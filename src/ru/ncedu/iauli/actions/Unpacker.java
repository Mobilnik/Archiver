package ru.ncedu.iauli.actions;

import ru.ncedu.iauli.Archive;
import ru.ncedu.iauli.Processor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * The class provides users with the core of API for unpacking zip archives.
 *
 * @author Ilya Ulitin
 */
public class Unpacker {

    /**
     * The method allows user to start the procedure of unpacking.
     *
     * @throws IOException
     */
    public static void startUnpacking() throws IOException {
        System.out.println("\nYou are now in the archive unpacking menu");

        Archive archive = new Archive();
        boolean possible = Processor.handleInputPack(archive);
        if (possible) {
            System.out.println("\nArchive name: " + archive.getArchiveName());
            System.out.println("File name: " + archive.getFileName());

            CreateFileFromZipArchive(archive);
        } else {
            System.out.println("Something went wrong. Please, try again.");
        }
    }

    /**
     * The method manipulates with Zip and File streams, redirecting data from the one to the another.
     *
     * @param archive - data with the archive full name and path to unpacked file.
     * @throws IOException
     */
    static void CreateFileFromZipArchive(Archive archive) throws IOException {
        ZipInputStream zis = new ZipInputStream(new FileInputStream(archive.getArchiveName()));
        File file = new File(archive.getFileName());

        FileOutputStream fos = new FileOutputStream(file);
        ZipEntry ze = new ZipEntry(file.getName());
        zis.getNextEntry();


        writeFromZisToFos(zis, fos);

        fos.close();
        zis.closeEntry();
        zis.close();
        System.out.println("The file \"" + archive.getArchiveName() + "\" has been dearchivated successfully!");
    }

    /**
     * The method allows to redirect a data stream using a buffer.
     *
     * @param inputStream - input stream based on a zip archive.
     * @param outputStream - output stream, based on a (@Code File).
     * @throws IOException
     */
    static void writeFromZisToFos(ZipInputStream inputStream, FileOutputStream outputStream) throws IOException {
        byte[] buf = new byte[8000];
        int length;
        while (true) {
            length = inputStream.read(buf);
            if (length < 0) break;
            outputStream.write(buf, 0, length);
        }
    }
}
