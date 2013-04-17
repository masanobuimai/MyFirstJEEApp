package com.example.control;

import javax.enterprise.inject.Model;
import javax.inject.Named;

@Model @Named(value = "greeting")
public class GreetingController {
    public String getMessage() {
        return "‚±‚ñ‚É‚¿‚Í¢ŠE";
    }
}
