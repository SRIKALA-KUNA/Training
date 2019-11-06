package com.epam.engx.cleancode.naming.task5;


import com.epam.engx.cleancode.naming.task5.thirdpartyjar.Predicate;

public class FileExtPred implements Predicate<String> {

    private String[] extension;

    FileExtPred(String[] extension) {
        this.extension = extension;
    }

    @Override
    public boolean test(String fileName) {
        for (String extension : extension) {
            if (fileName.toLowerCase().endsWith(extension)) {
                return true;
            }
        }
        return false;
    }
}
