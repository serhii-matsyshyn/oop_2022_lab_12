package edu.task2;

public class Main {
    public static void main(String[] args) {
        Document document = new SmartDocument("gs://oop-2022-ucu-bucket/example.jpeg");
        document = new CashedDocument(document);
        document = new TimedDocument(document);
        System.out.println(document.parse());
    }
}
