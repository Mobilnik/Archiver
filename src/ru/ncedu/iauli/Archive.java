package ru.ncedu.iauli;

import java.io.File;
import java.util.zip.ZipEntry;

/**
 * The class (@code Archive) provides user with several setters and getters of archive's and file's names,
 * comments to files.
 *
 * @author Ilya Ulitin
 */
public class Archive {
    private String archiveName = "";
    private String fileName = "";
    private String comment = "";


    /**
     * @return archive's full name.
     */
    public String getArchiveName() {
        return archiveName;
    }

    /**
     * @param archiveName - full archive's name to be set.
     */
    public void setArchiveName(String archiveName) {
        this.archiveName = archiveName;
    }

    /**
     * @return file's full name.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName - full file's name to be set.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return file's comment.
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment - comment to be set.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
