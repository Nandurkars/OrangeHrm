package Operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class ReadObjectRepo {
	
    Properties p = new Properties();
    public Properties getObjectRepository() throws IOException{
        InputStream stream = new FileInputStream(new File("C:\\Users\\cdeshpande\\git\\OrangeHrm\\src\\main\\java\\ObjectRepo\\object.properties"));
        p.load(stream);
    	return p;
    } 
}
