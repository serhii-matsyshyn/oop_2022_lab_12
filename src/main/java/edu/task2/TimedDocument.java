package edu.task2;

public class TimedDocument implements Document {
    private Document document;

    public TimedDocument(Document document) {
        this.document = document;
    }

    @Override
    public String parse() {
        long startTime = System.currentTimeMillis();
        String result = document.parse();
        long endTime = System.currentTimeMillis();
        System.out.println("Time took to parse document: " + (endTime - startTime) + "ms");
        return result;
    }

    @Override
    public String getGcsPath() {
        return document.getGcsPath();
    }
}
