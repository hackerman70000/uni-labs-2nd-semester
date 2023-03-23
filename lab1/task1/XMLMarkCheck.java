package task1;

import java.io.*;
import java.util.*;
import java.util.Properties;

public class XMLMarkCheck {

    public static void main(String[] args) throws IOException {

        Stack<String> markStack = new Stack<>();
        Properties properties = new Properties();

        try {
            // Example file downloaded from https://www.w3schools.com/xml/xml_examples.asp
            properties.load(new FileReader("/home/bartelemy/Documents/APRO2/lab1/task1/test1.txt"));  //your path to file (depends on your run config)

            Scanner scanner = new Scanner(new File("/home/bartelemy/Documents/APRO2/lab1/task1/test1fail.xml")); //your path to file (depends on your run config)
            scanner.nextLine();

            String line;

            int lineCount = 2;
            boolean ifMark = false;
            boolean ifCorrect = true;

            while (scanner.hasNext()) {

                line = scanner.nextLine();
                String mark = "";


                for (int i = 0; i < line.length(); i++) {

                    if (line.charAt(i) == '<') {
                        if (line.charAt(i + 1) == '!' || line.charAt(i + 1) == '?')
                            break;
                        ifMark = true;
                    }

                    if (line.charAt(i) == '>') {
                        ifMark = false;

                        if (!mark.contains("/") && !mark.isEmpty()) {
                            if (!properties.contains(mark)) break;
                            markStack.push(mark);
                            mark = "";
                        }

                        if (mark.contains("/")) {
                            mark = mark.replace("/", "");
                            if (!properties.contains(mark))
                                break;
                            if (mark.equals(markStack.peek())) {
                                markStack.pop();
                                mark = "";
                            } else {
                                System.out.println("Error in line " + lineCount);
                                ifCorrect = false;
                            }
                        }

                    }


                    if (ifMark && line.charAt(i + 1) != '>') {
                        mark += line.charAt(i + 1);
                    }
                }

                lineCount++;
            }

            if (ifCorrect) System.out.println("There are no errors in file.");
            else {
                System.out.println("There are some errors in file.");
            }

        } catch (IOException e) {
            System.out.println("File not found.");
        }

    }
}

