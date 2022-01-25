package com.mabay;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/account")
    public String onAccountFallback() {
        return "Hi";
    }

    @GetMapping("/ticket")
    public String onTicketFallback() {
        return "May";
    }

}
