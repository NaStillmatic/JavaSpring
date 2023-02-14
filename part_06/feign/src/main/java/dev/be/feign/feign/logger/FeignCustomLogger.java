package dev.be.feign.feign.logger;

import feign.Logger;
import feign.Request;
import feign.Response;
import feign.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static feign.Util.*;


@Slf4j
@RequiredArgsConstructor
public class FeignCustomLogger extends Logger {
    private static final int DEFAULT_SLOW_API_TIME = 3_000;
    private static final String SLOW_API_NOTICE = "Slow API";

    @Override
    protected void log(String configKey, String format, Object... args) {
        // log 를 어떤 형식으로 넘길지 정해준다.
        System.out.println(String.format(methodTag(configKey) + format, args));
    }

    @Override
    protected void logRequest(String configKey, Level logLevel, Request request) {
        System.out.println("[logRequest] : " + request);
    }

    @Override
    protected Response logAndRebufferResponse(String configKey, Level logLevel, Response response, long elapsedTime) throws IOException {
        /**
         * [참고]
         * - `logAndRebufferResponse` 메소드내에선 Request, Response에 대한 정보를 log로 남길 수 있다.
         * - 매소드내 코드는 "feign.Logger#logAndRebufferResponse(java.lang.String, feign.Logger.Level, feign.Response, long)"에서 가져왔다.
         *
         * [사용 예]
         * 예상 요청 처리 시간보다 오래 걸렸다면 "Slow API"라는 log를 출력시킬 수 있다.
         * ex) [DemoFeignClient#callGet] <--- HTTP/1.1 200 (115ms)
         *     [DemoFeignClient#callGet] connection: keep-alive
         *     [DemoFeignClient#callGet] content-type: application/json
         *     [DemoFeignClient#callGet] date: Sun, 24 Jul 2022 01:26:05 GMT
         *     [DemoFeignClient#callGet] keep-alive: timeout=60
         *     [DemoFeignClient#callGet] transfer-encoding: chunked
         *     [DemoFeignClient#callGet] {"name":"customName","age":1,"header":"CustomHeader"}
         *     [DemoFeignClient#callGet] [Slow API] elapsedTime : 3001
         *     [DemoFeignClient#callGet] <--- END HTTP (53-byte body)
         */

        String protocolVersion = resolveProtocolVersion(response.protocolVersion());
        String reason = response.reason() != null
                && logLevel.compareTo(Level.NONE) > 0 ? " " + response.reason() : "";
        int status = response.status();
        log(configKey, "<--- %s %s%s (%sms)", protocolVersion, status, reason, elapsedTime);
        if (logLevel.ordinal() >= Level.HEADERS.ordinal()) {

            for (String field : response.headers().keySet()) {
                if (shouldLogResponseHeader(field)) {
                    for (String value : valuesOrEmpty(response.headers(), field)) {
                        log(configKey, "%s: %s", field, value);
                    }
                }
            }

            int bodyLength = 0;
            if (response.body() != null && !(status == 204 || status == 205)) {
                // HTTP 204 No Content "...response MUST NOT include a message-body"
                // HTTP 205 Reset Content "...response MUST NOT include an entity"
                if (logLevel.ordinal() >= Level.FULL.ordinal()) {
                    log(configKey, ""); // CRLF
                }
                byte[] bodyData = Util.toByteArray(response.body().asInputStream());
                bodyLength = bodyData.length;
                if (logLevel.ordinal() >= Level.HEADERS.ordinal() && bodyLength > 0) {
                    log(configKey, "%s", decodeOrDefault(bodyData, UTF_8, "Binary data"));
                }
                if (elapsedTime > DEFAULT_SLOW_API_TIME) {
                    log(configKey, "[%s] elapsedTime : %s", SLOW_API_NOTICE, elapsedTime);
                }
                log(configKey, "<--- END HTTP (%s-byte body)", bodyLength);
                return response.toBuilder().body(bodyData).build();
            } else {
                log(configKey, "<--- END HTTP (%s-byte body)", bodyLength);
            }
        }
        return response;
    }
}
