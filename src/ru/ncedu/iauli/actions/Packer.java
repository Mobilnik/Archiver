package ru.ncedu.iauli.actions;

import ru.ncedu.iauli.Archive;
import ru.ncedu.iauli.Processor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * The class provides users with the core of API for packing zip archives.
 *
 * @author Ilya Ulitin
 */
public class Packer {

    /**
     * The method allows user to add a comment and to start the procedure of packing.
     *
     * @throws IOException
     */
    public static void startPacking() throws IOException {
        System.out.println("\nYou are now in the archive creating menu");

        Archive archive = new Archive();
        boolean possible = Processor.handleInputPack(archive);
        if (possible) {
            System.out.println("If you want to add a comment to your file in the archive, please enter it in the line below. " +
                    "If you don't want to add a comment, just press 'Enter' button on your keyboard:");

            Scanner scanner = new Scanner(System.in);
            archive.setComment(scanner.nextLine());

            System.out.println("\nArchive name: " + archive.getArchiveName());
            System.out.println("File name: " + archive.getFileName());
            System.out.println("Comment: " + archive.getComment());

            CreateZipArchiveWithFile(archive);
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
    static void CreateZipArchiveWithFile(Archive archive) throws IOException {
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(archive.getArchiveName()));
        File file = new File(archive.getFileName());
        FileInputStream fis = new FileInputStream(file);
        ZipEntry ze = new ZipEntry(file.getName());
        zos.putNextEntry(ze);

        zos.setComment(archive.getComment());

        writeFromFisToZos(fis, zos);

        fis.close();
        zos.closeEntry();
        zos.close();
        System.out.println("The archive \"" + archive.getArchiveName() + "\" has been created successfully!");
    }


    /**
     * The method allows to redirect a data stream using a buffer.
     *
     * @param inputStream     - input stream based on a  (@Code File)
     * @param outputStream - output stream, based on a zip archive
     * @throws IOException
     */
    static void writeFromFisToZos(FileInputStream inputStream, ZipOutputStream outputStream) throws IOException {
        byte[] buf = new byte[8000];
        int length;
        while (true) {
            length = inputStream.read(buf);
            if (length < 0) break;
            outputStream.write(buf, 0, length);
        }
    }

}
