package org.example.models;

import java.util.ArrayList;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public void startGrocery() {
        Scanner myObj = new Scanner(System.in);

        while (true) {
            System.out.println("\nYapacağınız işlemi seçiniz: \n0: Çıkış\n1: Ekleme\n2: Çıkarma");
            int index;

            try {
                index = Integer.parseInt(myObj.nextLine());
            } catch (Exception e) {
                System.out.println("Geçersiz giriş.");
                continue;
            }

            switch (index) {
                case 0:
                    System.out.println("Uygulama durduruluyor.");
                    return;
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz (örnek: tomato, orange, peach):");
                    String add = myObj.nextLine();
                    addItems(add);
                    printSorted();
                    break;
                case 2:
                    System.out.println("Çıkarılmasını istediğiniz elemanları giriniz (örnek: tomato, orange, peach):");
                    String remove = myObj.nextLine();
                    removeItems(remove);
                    printSorted();
                    break;
                default:
                    System.out.println("Yanlış bir giriş yaptınız.");
            }
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String trimmedItem = item.trim();

            if (!checkItemIsInList(trimmedItem)) {
                groceryList.add(trimmedItem);
                System.out.println(trimmedItem + " listeye eklendi.");
                printSorted();
            } else {
                System.out.println(trimmedItem + " zaten listede mevcut.");
            }
        }
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String trimmedItem = item.trim();

            if (checkItemIsInList(trimmedItem)) {
                groceryList.remove(trimmedItem);
                System.out.println(trimmedItem + " listeden çıkarıldı.");
            } else {
                System.out.println(trimmedItem + " listede mevcut değil.");
            }
        }
    }

    public static boolean checkItemIsInList(String input) {
        return groceryList.contains(input.trim());
    }

    public static void printSorted() {
        groceryList.sort(String::compareToIgnoreCase);
        System.out.println("Güncel Liste (Sıralı): " + groceryList);
    }
}
