package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите код для форматирования:");
        String inputCode = sc.nextLine();

        String formattedCode = formatCode(inputCode);

        System.out.println("Отформатированный код:");
        System.out.println(formattedCode);
    }

    public static String formatCode(String code)
    {
        StringBuilder formattedCode = new StringBuilder();
        int indentationLevel = 0;

        for (int i = 0; i < code.length(); i++)
        {
            char c = code.charAt(i);

            if (c == '{' || c-1 == '[')
            {
                formattedCode.append("\n");
                for (int j = 0; j < indentationLevel; j++)
                {
                    formattedCode.append("\t");
                }
                formattedCode.append(c);
                formattedCode.append("\n");
                indentationLevel++;
                for (int j = 0; j < indentationLevel; j++)
                {
                    formattedCode.append("\t");
                }
            }

            else if (c == ';' && c != '}')
            {
                formattedCode.append(c);
                formattedCode.append("\n");
                for (int j = 0; j < indentationLevel; j++)
                {
                    formattedCode.append("\t");
                }
            }

            else if (c == '}' || c+1 == '}')
            {
                formattedCode.append("\n");
                indentationLevel--;
                for (int j = 0; j < indentationLevel; j++)
                {
                    formattedCode.append("\t");
                }
                formattedCode.append(c);
                formattedCode.append("\n");
                for (int j = 0; j < indentationLevel; j++)
                {
                    formattedCode.append("\t");
                }
            }

            else
            {
                formattedCode.append(c);
            }
        }

        return formattedCode.toString();
    }

}
