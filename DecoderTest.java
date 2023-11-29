package org.example;

import static org.junit.jupiter.api.Assertions.*;

class DecoderTest {

    @org.junit.jupiter.api.Test
    void decodeVowels() {
        assertEquals("testing", Decoder.decodeVowels("t2st3ng"));
    }

    @org.junit.jupiter.api.Test
    void decodeConsonants() {
                assertEquals("bcdefghijklmnopqrstuvwxyza", Decoder.decodeConsonants("abcdefghijklmnopqrstuvwxyz"));
    }

    @org.junit.jupiter.api.Test
    void decodeMessage() {
        assertEquals("testing decoding methods", Decoder.decodeMessage("t2st3ng d5c4d3ng m5th4ds"));
        assertEquals("hello world", Decoder.decodeMessage("h3ll4 w4rld"));
    }
}