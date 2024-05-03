import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        scanner.nextLine();
        String string =
                "package bullscows;\n" +
                        "\n" +
                        "import java.util.Scanner;\n" +
                        "import java.util.Random;\n" +
                        "\n" +
                        "public class Main {\n" +
                        "\n" +
                        "\n" +
                        "    public static void main(String[] args) {\n" +
                        "        Scanner scanner = new Scanner(System.in);\n" +
                        "\n" +
                        "        // todo geen copypasta\n" +
                        "\n" +
                        "        System.out.println(\"Please, enter the secret code's length:\");\n" +
                        "\n" +
                        "        int hoelang = scanner.nextInt();\n" +
                        "\n" +
                        "        System.out.println(\"Input the number of possible symbols in the code:\");\n" +
                        "\n" +
                        "        int possibleSymbols = scanner.nextInt();\n" +
                        "        String allSymbols = \"0123456789abcdefghijklmnopqrstuvwxyz\";\n" +
                        "\n" +
                        "        String kruisjes = \"*\".repeat(hoelang);\n" +
                        "\n" +
                        "\n" +
                        "        if (possibleSymbols <= 10) {\n" +
                        "            System.out.printf(\"The secret is prepared: %s (0-%d).\\n\", kruisjes, possibleSymbols - 1);\n" +
                        "        } else {\n" +
                        "            System.out.printf(\"The secret is prepared: %s (0-9, a-%s).\\n\", kruisjes, allSymbols.charAt(possibleSymbols - 1));\n" +
                        "        }\n" +
                        "\n" +
                        "        System.out.println(\"Okay, let's start a game!\");\n" +
                        "        while (hoelang > 36) {\n" +
                        "            System.out.println(\"Error: can't generate a secret with a length of \" + hoelang +\n" +
                        "                    \" because there aren't enough unique symbols.\");\n" +
                        "            hoelang = scanner.nextInt();\n" +
                        "        }\n" +
                        "\n" +
                        "        String secret = uniekeCodeMaken(hoelang, possibleSymbols);\n" +
                        "\n" +
                        "        //    String secretCode = secret;\n" +
                        "        boolean gewonnen = false;\n" +
                        "        int turn = 1;\n" +
                        "        while (!gewonnen) {\n" +
                        "            System.out.println(\"Turn \" + turn++);\n" +
                        "            String code = scanner.next();\n" +
                        "            grading(secret, code, hoelang);\n" +
                        "            if (secret.equals(code)) gewonnen = true;\n" +
                        "        }\n" +
                        "    }\n" +
                        "\n" +
                        "    public static String uniekeCodeMaken(int hoelang, int possibleSymbols) {\n" +
                        "        String allSymbols = \"0123456789abcdefghijklmnopqrstuvwxyz\";\n" +
                        "        String usedChars = allSymbols.substring(0, possibleSymbols);\n" +
                        "\n" +
                        "        StringBuilder uniek = new StringBuilder();\n" +
                        "        Random randO = new Random(hoelang);\n" +
                        "\n" +
                        "        while (uniek.length() < hoelang) {\n" +
                        "            char c = usedChars.charAt(randO.nextInt(possibleSymbols));\n" +
                        "            if (uniek.toString().indexOf(c) == - 1) {\n" +
                        "                uniek.append(c);\n" +
                        "            }\n" +
                        "        }\n" +
                        "\n" +
                        "\n" +
                        "        return uniek.toString();\n" +
                        "    }\n" +
                        "\n" +
                        "\n" +
                        "    public static void grading(String secretCode, String codeInput, int hoelang) {\n" +
                        "        int cowCount = 0;\n" +
                        "        int bullCount = 0;\n" +
                        "\n" +
                        "        char[] secretChars = convertToCharacters(secretCode, hoelang);\n" +
                        "        char[] codeChars = convertToCharacters(codeInput, hoelang);\n" +
                        "\n" +
                        "        // vergelijk code met geheime code\n" +
                        "        for (int i = 0; i < hoelang; i++) {\n" +
                        "            if (secretChars[i] == codeChars[i]) {\n" +
                        "                bullCount++; // als ze gelijk zijn en op dezelfde positie, bulls++\n" +
                        "            } else {\n" +
                        "                for (int j = 0; j < hoelang; j++) {\n" +
                        "                    if (codeChars[i] == secretChars[j]) {\n" +
                        "                        cowCount++; // als het getal in de code zit maar op een andere positie, cows++\n" +
                        "                        break;\n" +
                        "                    }\n" +
                        "                }\n" +
                        "            }\n" +
                        "        }\n" +
                        "\n" +
                        "        if (bullCount == hoelang) {\n" +
                        "            System.out.printf(\"Grade: %s bull(s). \\nCongratulations! You guessed the secret code.\\n\", hoelang);\n" +
                        "        } else if (bullCount == 0 && cowCount == 0) {\n" +
                        "            System.out.println(\"Grade: None.\");\n" +
                        "        } else if (bullCount == 0) {\n" +
                        "            System.out.printf(\"Grade: %s cow(s).\\n\", cowCount);\n" +
                        "        } else {\n" +
                        "            System.out.printf(\"Grade: %s bulls(s) and %s cow(s).\\n\", bullCount, cowCount);\n" +
                        "        }\n" +
                        "    }\n" +
                        "\n" +
                        "    public static char[] convertToCharacters(String code, int hoelang) {\n" +
                        "        char[] characters = new char[hoelang];\n" +
                        "        for (int i = 0; i < hoelang; i++) {\n" +
                        "            characters[i] = (code.charAt(i));\n" +
                        "        }\n" +
                        "        return characters;\n" +
                        "    }\n" +
                        "}\n";

        slowPrint(string);
    }

    public static void slowPrint(String message) {
        String[] characters = message.split("");

        for (String character : characters) {
            System.out.print(character);
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}