package faber.objet.metaDataFile;



import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.UserDefinedFileAttributeView;

public class MetaDataFile {

    private File file;

    public MetaDataFile(File file) {
        this.file = file;
    }

    public void ajouterPopriete(String propriete , String value) throws IOException {
        Path path = file.toPath();
        UserDefinedFileAttributeView view =
                Files.getFileAttributeView(path, UserDefinedFileAttributeView.class);
        ByteBuffer writeBuffer = ByteBuffer.allocate(value.length());
        writeBuffer.clear();
        writeBuffer.put(value.getBytes());
        writeBuffer.flip();
        view.write(propriete, writeBuffer);
    }
    public   String lirePropriete(String propriete) throws IOException {
        Path path = file.toPath();
        UserDefinedFileAttributeView view =
                Files.getFileAttributeView(path, UserDefinedFileAttributeView.class);
        ByteBuffer readBuffer = ByteBuffer.allocate(view.size(propriete));
        view.read(propriete, readBuffer);
        readBuffer.flip();
        String value = new String(readBuffer.array(), StandardCharsets.UTF_8);
        return value;
    }

}
