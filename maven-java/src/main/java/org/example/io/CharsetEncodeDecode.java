package org.example.io;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

class CharsetEncodeDecode {

    public static void main(String[] args) {
        String[] charsetNames = {"US-ASCII", "ISO-8859-1", "UTF-8", "UTF-16",
            "UTF-16BE", "UTF-16LE", "GBK", "BIG5"};

        String message = "Hi,您好!";
        System.out.printf("%10s: ", "UCS-2");

        for (int i = 0; i < message.length(); i++) {
            System.out.printf("%04X ", (int) message.charAt(i));
        }
        System.out.println();

        for (String charsetName : charsetNames) {
            Charset charset = Charset.forName(charsetName);
            System.out.printf("%10s: ", charset.name());

            ByteBuffer buffer = charset.encode(message);
            while (buffer.hasRemaining()) {
                System.out.printf("%02X ", buffer.get());
            }
            System.out.println();
        }
        System.out.println();
    }

}
