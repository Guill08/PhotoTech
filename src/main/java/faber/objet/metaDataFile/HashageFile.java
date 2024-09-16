package faber.objet.metaDataFile;

import faber.main.Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashageFile {

    public static String calculateFileHash(File file, String algorithm)
            throws NoSuchAlgorithmException, IOException {
        Path path = Paths.get(file.getPath());
        MessageDigest digest = MessageDigest.getInstance(algorithm);

        try (InputStream fis = new FileInputStream(path.toFile())) {
            byte[] byteBuffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(byteBuffer)) != -1) {
                digest.update(byteBuffer, 0, bytesRead);
            }
        }

        byte[] hashBytes = digest.digest();

        StringBuilder hashString = new StringBuilder();
        for (byte b : hashBytes) {
            hashString.append(String.format("%02x", b));
        }

        return hashString.toString();
    }
}
