package ru.ncedu.iauli;

import ru.ncedu.iauli.exceptions.IncorrectArchiveNameException;
import ru.ncedu.iauli.exceptions.IncorrectFileNameException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class (@code Parser) provides user with possibility to check the correctness
 * of the entered file and archive full names.
 *
 * @author Ilya Ulitin
 */
public class Parser {

    /**
     * The method allows to check if the entered archive's full name matches the designed pattern.
     *
     * @param archiveName - String with the archive's full name.
     */
    public static void parseArchiveName(String archiveName) throws IncorrectArchiveNameException {
        String ARCHIVE_NAME_PATTERN = "^([a-zA-Z]{1}:\\\\)?([a-zA-Z0-9_^%@#!-\\.]+\\\\)*[a-zA-Z0-9_^%@#!-\\.]+\\.zip";
        Pattern archiveNamePattern = Pattern.compile(ARCHIVE_NAME_PATTERN);
        Matcher archiveNameMatcher = archiveNamePattern.matcher(archiveName);
        if (archiveNameMatcher.matches()) {
            return;
        }
        throw new IncorrectArchiveNameException("wrong archive name.");
    }

    /**
     * The method allows to check if the entered file's full name matches the designed pattern.
     *
     * @param fileName - String with the file's full name.
     */
    public static void parseFileName(String fileName) throws IncorrectFileNameException {
        String FILE_NAME_PATTERN = "^([a-zA-Z]{1}:\\\\)?([a-zA-Z0-9_^%@#!-\\.]+\\\\)*[a-zA-Z0-9_^%@#!-\\.]+(\\.[a-zA-Z]+)?";
        Pattern fileNamePattern = Pattern.compile(FILE_NAME_PATTERN);
        Matcher fileNameMatcher = fileNamePattern.matcher(fileName);
        if (fileNameMatcher.matches()) {
            return;
        }
        throw new IncorrectFileNameException("wrong file name.");
    }


}
