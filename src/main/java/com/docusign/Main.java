package com.docusign;

import com.docusign.model.Input;
import com.docusign.model.Prompter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Prompter prompter = new Prompter(new Input());
        prompter.run();
    }
}
