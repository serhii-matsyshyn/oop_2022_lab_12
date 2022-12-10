package edu.task2;

import edu.task2.database.DBConnection;

public class CashedDocument implements Document {
    private Document document;

    public CashedDocument(Document document) {
        this.document = document;
    }

    public boolean isCached() {
        return false;
    }

    @Override
    public String parse() {
        // check is there is a cashed version of the document in sql database
        // if there is, return it

        DBConnection dbConnection = DBConnection.getInstance();

        // check is there is a cashed version of the document in sql database (check by filename)
        String query = "SELECT text FROM document WHERE filename = '" + document.getGcsPath() + "'";
        String result = dbConnection.executeQueryWithAnswer(query);

        if (result != null) {
            return result;
        }

        // if there is not, parse the document and save it to the database
        String text = document.parse();
        // clean the text from special characters or incorrect symbols
        text = text.replaceAll("[^a-zA-Z0-9\\s]", "");

        query = "INSERT INTO document (filename, text) VALUES ('" + document.getGcsPath() + "', '" + text + "')";
        dbConnection.executeQuery(query);
        return text;
    }

    @Override
    public String getGcsPath() {
        return document.getGcsPath();
    }

}
