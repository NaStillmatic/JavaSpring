package dev.be.async.service;


import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AsyncService {

    private final EmailService emailService;

    public void asyncCall_1() {
        System.out.println("[asyncCall_1]" + Thread.currentThread().getName());
        emailService.sendMail();
        emailService.sendMailWithCustomThreadPool();
    }

    public void asyncCall_2() {
        System.out.println("[asyncCall_2]" + Thread.currentThread().getName());
        EmailService emailService = new EmailService();
        emailService.sendMail();
        emailService.sendMailWithCustomThreadPool();
    }

    public void asyncCall_3() {
        System.out.println("[asyncCall_3]" + Thread.currentThread().getName());
        sendMail();
    }

    @Async // 어노테이션을 붙이지 않을때와 동일한 동작
    public void sendMail() {
        System.out.println("[sendMail] :: " + Thread.currentThread().getName());
    }

}
