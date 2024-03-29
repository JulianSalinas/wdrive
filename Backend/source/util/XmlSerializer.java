package util;

import com.thoughtworks.xstream.XStream;
import model.WAccount;
import model.WFileSystem;
import model.FileSystemDir;
import model.FileSystemFile;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class XmlSerializer extends XStream {

    public XmlSerializer(){
        super();
        XStream.setupDefaultSecurity(this);
        this.autodetectAnnotations(true);
        this.allowTypes(new Class[]{
                WAccount.class,
                WFileSystem.class,
                FileSystemDir.class,
                FileSystemFile.class
        });
    }

    public Object load(Path path) throws IOException {
        String xml = FileUtils.readFileToString(path.toFile());
        return this.fromXML(xml);
    }

    public Object load(String filename) throws IOException {
        String xml = FileUtils.readFileToString(new File(filename));
        return this.fromXML(xml);
    }

    public String save(Path path, Object content) throws IOException{
        return save(path.toString(), content);
    }

    public String save(String filename, Object content) throws IOException{
        String xml = this.toXML(content);
        if(!filename.endsWith(".xml")) filename += ".xml";
        FileUtils.writeStringToFile(new File(filename), xml, false);
        return xml;
    }

}
