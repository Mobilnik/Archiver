package ru.ncedu.iauli;

import ru.ncedu.iauli.actions.Commentator;
import ru.ncedu.iauli.actions.Packer;
import ru.ncedu.iauli.actions.Unpacker;
import ru.ncedu.iauli.exceptions.IncorrectArchiveNameException;
import ru.ncedu.iauli.exceptions.IncorrectFileNameException;

import java.io.IOException;
import java.util.Scanner;

/**
 * The class provides dialogues with user using the console. Methods allow user to enter the variant using any case.
 *
 * @author Ilya Ulitin
 */
public class Processor {

    /**
     * The method begins a dilogue, allows user to select type of work in further and determines
     * the following methods calls.
     *
     * @throws IOException
     */
    static void startInput() throws IOException {
        String answer;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the action you want to perform:");
        System.out.println("Enter \"pack\" to pack a file or a directory into an archive.");
        System.out.println("Enter \"unpack\" to unpack files and directories from an archive.");
        System.out.println("Enter \"read\" to get comments from the existing archive.");

        answer = scanner.next();
        if (answer.toLowerCase().equals("pack")) {
            Packer.startPacking();
        } else if (answer.toLowerCase().equals("unpack")) {
            Unpacker.startUnpacking();
        } else if (answer.toLowerCase().equals("read")) {
            Commentator.getComment();
        } else {
            System.out.println("Incorrect input, please, try again.");
            startInput();
        }

    }

    /**
     * The method checks if it is possible to execute the program in further (packing branch).
     *
     * @param archive - data with the file to be archived.
     * @return possibility of proceed with the execution using the entered names.
     */
    public static boolean handleInputPack(Archive archive) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the archive's FULL name: (*.zip)");
        archive.setArchiveName(scanner.next());
        try {
            Parser.parseArchiveName(archive.getArchiveName());
        } catch (IncorrectArchiveNameException e) {
            System.out.println(e.toString());
            return false;
        }

        Scanner reader = new Scanner(System.in);
        System.out.println("Please, enter the file's FULL name: ");
        archive.setFileName(reader.next());
        try {
            Parser.parseFileName(archive.getFileName());
        } catch (IncorrectFileNameException e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }

    /**
     * The method checks if it is possible to execute the program in further (unpacking branch).
     *
     * @param archive - data with the archive and path to unpacked file.
     * @return possibility of proceed with the execution using the entered names.
     */
    public static boolean handleInputUnpack(Archive archive) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the archive's FULL name: (*.zip)");
        archive.setArchiveName(scanner.next());
        try {
            Parser.parseArchiveName(archive.getArchiveName());
        } catch (IncorrectArchiveNameException e) {
            System.out.println(e.toString());
            return false;
        }

        Scanner reader = new Scanner(System.in);
        System.out.println("Please, enter the file's FULL name after unpacking: ");
        archive.setFileName(reader.next());
        try {
            Parser.parseFileName(archive.getFileName());
        } catch (IncorrectFileNameException e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }

    /**
     * The method checks if it is possible to execute the program in further (comment reading branch).
     *
     * @param archive - data with the archive and file with the needed comment.
     * @return possibility of proceed with the execution using the entered names.
     */
    public static boolean handleInputComment(Archive archive) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the archive's FULL name: (*.zip)");
        archive.setArchiveName(scanner.next());
        try {
            Parser.parseArchiveName(archive.getArchiveName());
        } catch (IncorrectArchiveNameException e) {
            System.out.println(e.toString());
            return false;
        }
        Scanner reader = new Scanner(System.in);
        System.out.println("Please, enter the name of the commented file");
        archive.setFileName(reader.next());
        try {
            Parser.parseFileName(archive.getFileName());
        } catch (IncorrectFileNameException e) {
            System.out.println(e.toString());
            return false;
        }
        return true;

    }

}
