package com.docusign.model;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private String temperature;
    private List<Integer> commands = new ArrayList<>();

    public Input() {
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void addCommand(Integer command) {
        commands.add(command);
    }

    public List<Integer> getCommands() {
        return commands;
    }
}
