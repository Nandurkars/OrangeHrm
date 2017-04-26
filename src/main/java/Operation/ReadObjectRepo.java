package Operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class ReadObjectRepo {
	
    Properties p = new Properties();
    public Properties getObjectRepository(String objectFilePath) throws IOException{
        InputStream stream = new FileInputStream(new File(objectFilePath));
        p.load(stream);
    	return p;
    } 
}
