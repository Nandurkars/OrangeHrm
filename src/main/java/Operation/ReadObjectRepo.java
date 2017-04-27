package Operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ReadObjectRepo {
	
	Properties p = new Properties();
    public Properties getObjectRepository() throws IOException{
        p.load(new FileInputStream(new File(System.getProperty("user.dir") + "//ObjectRepo//object.properties")));
    	return p;
    } 
}
