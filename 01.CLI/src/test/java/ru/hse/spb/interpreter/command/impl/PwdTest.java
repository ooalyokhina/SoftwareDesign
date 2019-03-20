package ru.hse.spb.interpreter.command.impl;

import org.junit.Test;
import ru.hse.spb.interpreter.model.BashCommandResult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static org.junit.Assert.*;

public class PwdTest {

    @Test
    public void testIsFits() {
        final Pwd pwd = new Pwd();
        assertTrue(pwd.isFits("pwd"));
        assertTrue(pwd.isFits("pwd 123 123 123"));
        assertTrue(pwd.isFits("pwd        1231 23123 "));
        assertTrue(pwd.isFits("    pwd        1231 23123 "));
        assertFalse(pwd.isFits("pwd1 asdas asdca ds"));
        assertFalse(pwd.isFits("1pwd asdas asdca ds"));
    }

    @Test
    public void testApply() {
        final Pwd pwd = new Pwd();
        final String path = pwd.apply("pwd ").getResult();
        assertTrue(path.contains("01.CLI"));
    }
}