package pl.sda.view;

import pl.sda.service.ExchangeRateService;

import java.util.Scanner;

public class Menu {

    private final static Scanner scanner = new Scanner(System.in);

    private final ExchangeRateService exchangeRateService;

    public Menu(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    public void displayMenu() {
        while (true) {
            System.out.println("Wybierz opcje");
            System.out.println("1. Przelicz walutę");
            System.out.println("0. Zakoncz");
            int option = scanner.nextInt();

            if (option == 0) {
                return;
            }
            if (option == 1) {
                System.out.println("Podaj kwote i walute");
                Double amount = scanner.nextDouble();
                scanner.nextLine();
                String currency = scanner.nextLine();

                Double calculatedAmount = exchangeRateService.exchangeMoney(amount, currency);
                System.out.println("Przeliczona kwota to " + calculatedAmount);
            }
        }
    }
}
