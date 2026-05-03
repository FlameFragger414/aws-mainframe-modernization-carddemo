package com.aws.carddemo.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Modernized Navigation Controller emulating the CICS Main Menu (COMEN01C).
 * Bridges legacy screen-based navigation with a RESTful API.
 */
@RestController
@RequestMapping("/api/v1/navigation")
public class NavigationController {

    @GetMapping("/menu")
    public MenuResponse getMainMenu() {
        List<MenuOption> options = new ArrayList<>();
        options.add(new MenuOption(1, "Account View", "/api/v1/accounts/{id}", "U"));
        options.add(new MenuOption(2, "Account Update", "/api/v1/accounts/{id}/update", "U"));
        options.add(new MenuOption(3, "Credit Card List", "/api/v1/cards", "U"));
        options.add(new MenuOption(4, "Credit Card View", "/api/v1/cards/{num}", "U"));
        options.add(new MenuOption(5, "Credit Card Update", "/api/v1/cards/{num}/update", "U"));
        options.add(new MenuOption(6, "Transaction List", "/api/v1/transactions", "U"));
        options.add(new MenuOption(7, "Transaction View", "/api/v1/transactions/{id}", "U"));
        options.add(new MenuOption(8, "Transaction Add", "/api/v1/transactions/add", "U"));
        options.add(new MenuOption(9, "Transaction Reports", "/api/v1/reports", "U"));
        options.add(new MenuOption(10, "Bill Payment", "/api/v1/payments", "U"));
        options.add(new MenuOption(11, "Pending Authorization View", "/api/v1/authorizations", "U"));

        return MenuResponse.builder()
                .programName("COMEN01C")
                .title("CardDemo Main Menu")
                .options(options)
                .build();
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MenuResponse {
        private String programName;
        private String title;
        private List<MenuOption> options;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MenuOption {
        private int id;
        private String name;
        private String endpoint;
        private String userType;
    }
}
