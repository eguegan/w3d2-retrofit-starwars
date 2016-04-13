package com.example.test.samplemasterdetail.utils;

/**
 * Created by evin on 3/10/16.
 */
public class ToonParser {
    private static final String TAG = "ToonParserTAG_";
    private static final String TITLE_PLACEHOLDER = "TitlePlaceholder";
    private static final String DESCRIPTION_PLACEHOLDER = "DescriptionPlaceholder";

    public static String[] parseText(String longText) {
        String[] auxArray = longText.split(" - ");

        if (auxArray.length < 2) {
            auxArray = new String[]{TITLE_PLACEHOLDER, DESCRIPTION_PLACEHOLDER};
        }

        return auxArray;
    }
}
