package io.muzoo.ssc.zork;

import org.junit.jupiter.api.Test;

class CommandParserTest {

    @Test
    void testParser() {
        CommandParser commandParser = new CommandParser();
        commandParser.parse("exit");
    }
}