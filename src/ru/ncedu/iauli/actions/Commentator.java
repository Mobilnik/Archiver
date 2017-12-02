package ru.ncedu.iauli.actions;

import ru.ncedu.iauli.Archive;
import ru.ncedu.iauli.Processor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * The class (@code Commentator) provides user with possibility to get comments from files
 * archived in zip-archives.
 *
 * @author Ilya Ulitin
 */
public class Commentator {

    /**
     * The method provides core API of the class, printing the comment to the screen.
     *
     * @throws IOException
     */
    public static void getComment() throws IOException {
        Archive archive = new Archive();
        boolean possible = Processor.handleInputComment(archive);
        if (possible) {
            ZipInputStream zis = new ZipInputStream(new FileInputStream(archive.getArchiveName()));
            ZipEntry ze = zis.getNextEntry();
            System.out.println("The comment for " + ze.getName() + " is: \"" + ze.getComment() + "\"");
        }
    }
}