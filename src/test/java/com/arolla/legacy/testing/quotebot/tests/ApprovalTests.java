package com.arolla.legacy.testing.quotebot.tests;

import com.arolla.legacy.testing.quotebot.Application;
import com.arolla.legacy.testing.quotebot.ApplicationAllMode;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ApprovalTests {

    @Test
    public void Explore() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream("a\n".getBytes());

        System.setOut(new PrintStream(outputStream));
        System.setIn(inputStream);

        ApplicationAllMode.main(new String[0]);

        var actual = outputStream.toString();

        Approvals.verify(actual);
    }
}
