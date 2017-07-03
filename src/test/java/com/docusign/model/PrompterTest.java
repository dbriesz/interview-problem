package com.docusign.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PrompterTest {
    private Input input;

    @Before
    public void setup() throws Exception {
        input = new Input();
    }

    @Test
    public void commandBeforeRemovingPjsFailTest() throws Exception {
        input.setTemperature("hot");
        input.addCommand(6);
        Prompter prompter = new Prompter(input);
        List<Integer> commands = input.getCommands();

        assertEquals("fail", prompter.getReady(commands));
    }
}
