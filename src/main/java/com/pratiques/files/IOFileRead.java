package com.pratiques.files;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

// source https://www.mkyong.com/java/java-read-a-text-file-line-by-line/ 


public class IOFileRead {

    public static void main(String[] args) throws IOException {

        RandomAccessFile file = new RandomAccessFile("src/com/mkyong/data.txt", "r");

        FileChannel channel = file.getChannel();

        System.out.println("File size is: " + channel.size());

        ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());

        channel.read(buffer);

        buffer.flip();//Restore buffer to position 0 to read it

        System.out.println("Reading content and printing ... ");

        for (int i = 0; i < channel.size(); i++) {
            System.out.print((char) buffer.get());
        }

        channel.close();
        file.close();

    }

}