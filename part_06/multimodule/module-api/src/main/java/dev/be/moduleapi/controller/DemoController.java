package dev.be.moduleapi.controller;

import dev.be.moduleapi.exception.CustomException;
import dev.be.moduleapi.service.DemoService;
import dev.be.modulecommon.domain.Member;
import dev.be.modulecommon.enums.CodeEnum;
import dev.be.modulecommon.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    private final MemberRepository memberRepository;

    @GetMapping("/save")
    public String save() {
        memberRepository.save(Member.builder()
                .name(Thread.currentThread().getName())
                .build());
        return demoService.save();
    }

    @GetMapping("/find")
    public String find() {
        int size = memberRepository.findAll().size();
        System.out.println("DB size: " + size);
        return demoService.find();
    }

    @GetMapping("/exception")
    public String exception() {
        if (true) {
            throw new CustomException(CodeEnum.UNKNOWN_ERROR);
        }
        return demoService.exception();
    }

}
