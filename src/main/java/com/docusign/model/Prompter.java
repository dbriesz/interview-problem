package com.docusign.model;

import java.io.*;
import java.util.*;

public class Prompter {
    private Map<Integer, String> hot;
    private Map<Integer, String> cold;
    private BufferedReader reader;
    private Input input;

    public Prompter(Input input) {
        this.input = input;
        reader = new BufferedReader(new InputStreamReader(System.in));
        hot = new HashMap<>();
        hot.put(1, "sandals");
        hot.put(2, "sun visor");
        hot.put(3, "socks");
        hot.put(4, "t-shirt");
        hot.put(5, "jacket");
        hot.put(6, "shorts");
        hot.put(7, "leaving house");
        hot.put(8, "Removing PJs");

        cold = new HashMap<>();
        cold.put(1, "boots");
        cold.put(2, "hat");
        cold.put(3, "socks");
        cold.put(4, "shirt");
        cold.put(5, "jacket");
        cold.put(6, "pants");
        cold.put(7, "leaving house");
        cold.put(8, "Removing PJs");
    }

    private String promptForTemperature() {
        System.out.print("Is it hot or cold outside?  ");
        String temp = "";
        try {
            temp = reader.readLine();
            temp = temp.trim().toUpperCase();
        } catch (IOException e) {
            System.out.printf("%nInvalid input. Please enter either hot or cold. %n%n");
        }
        return temp;
    }

    private void promptForCommands() throws IOException {
        System.out.println("Your clothing options are:");
        if (input.getTemperature().equals("HOT")) {
            for (Map.Entry<Integer, String> option : hot.entrySet()) {
                System.out.printf("%n%d) %s %n",
                        option.getKey(),
                        option.getValue());
            }
            System.out.printf("%n%nWhat do you want to do? ");
            int choice = -1;
            do {
                try {
                    System.out.printf("%nSelect a command (Type 0 to exit and print output):  ");
                    String optionAsString = reader.readLine();
                    choice = Integer.parseInt(optionAsString.trim());
                    hotTempRules(choice);
                } catch (NumberFormatException nfe) {
                    System.out.printf("%nInvalid input. Please try again.%n%n");
                }
            } while (choice > 0 || input.getCommands().size() > 8);
        } else {
            for (Map.Entry<Integer, String> option : cold.entrySet()) {
                System.out.printf("%n%d) %s %n",
                        option.getKey(),
                        option.getValue());
            }
            System.out.printf("%n%nWhat do you want to do? ");
            int choice = -1;
            do {
                try {
                    System.out.printf("%nSelect a command (Type 0 to exit and print output):  ");
                    String optionAsString = reader.readLine();
                    choice = Integer.parseInt(optionAsString.trim());
                    coldTempRules(choice);
                } catch (NumberFormatException nfe) {
                    System.out.printf("%nInvalid input. Please try again.%n%n");
                }
            } while (choice > 0 || input.getCommands().size() > 8);
        }
        if (input.getCommands().get(0) != 8) {
            System.out.println("fail");
            System.exit(0);
        }
    }

    private void coldTempRules(int choice) {
        if (input.getCommands().contains(choice)
                || (choice == 5 && !input.getCommands().contains(3))
                || (choice == 1 && !input.getCommands().contains(6))
                || (choice == 2 && !input.getCommands().contains(4))
                || (choice == 5 && !input.getCommands().contains(4))
                || (choice == 7 && input.getCommands().size() != 7)
                || (choice == 0 && input.getCommands().size() < 8)) {
            System.out.println("fail");
            System.exit(0);
        }
        if (choice != 0) {
            input.addCommand(choice);
        }
    }

    private void hotTempRules(int choice) {
        if (input.getCommands().contains(choice)
                || choice == 3
                || choice == 5
                || (choice == 1 && !input.getCommands().contains(6))
                || (choice == 2 && !input.getCommands().contains(4))
                || (choice == 7 && input.getCommands().size() != 5)
                || (choice == 0 && input.getCommands().size() < 6)) {
            System.out.println("fail");
            System.exit(0);
        }
        if (choice != 0) {
            input.addCommand(choice);
        }
    }

    public void run() throws IOException {
        String temperature = promptForTemperature();
        if (!temperature.equals("HOT") && !temperature.equals("COLD")) {
            temperature = promptForTemperature();
        }
        input.setTemperature(temperature);
        try {
            promptForCommands();
        } catch (IndexOutOfBoundsException ex) {
            promptForCommands();
        }
        List<Integer> commands = input.getCommands();
        getReady(commands);
    }

    private void getReady(List<Integer> commands) {
        if (input.getTemperature().equals("HOT")) {
            int count = 1;
            for (int i : commands) {
                String value = hot.get(i);
                if (count == commands.size()) {
                    System.out.printf("%s", value);
                } else {
                    System.out.printf("%s, ", value);
                    count++;
                }
            }
        } else {
            int counter = 1;
            for (int j : commands) {
                String value = cold.get(j);
                if (counter == commands.size()) {
                    System.out.printf("%s", value);
                } else {
                    System.out.printf("%s, ", value);
                    counter++;
                }
            }
        }
    }
}
