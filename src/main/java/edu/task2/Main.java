package edu.task2;

public class Main {
    public static void main(String[] args) {
        Document document = new SmartDocument("gs://oop-2022-ucu-bucket/example.jpeg");
        document = new TimedDocument(document);
        document = new CashedDocument(document);
        System.out.println(document.parse());


    }
}
