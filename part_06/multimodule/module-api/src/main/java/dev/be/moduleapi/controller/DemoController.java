package dev.be.moduleapi.controller;

import dev.be.moduleapi.exception.CustomException;
import dev.be.moduleapi.service.DemoService;
import dev.be.modulecommon.enums.CodeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/save")
    public String save() {
        return demoService.save();
    }

    @GetMapping("/find")
    public String find() {
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
