package util;

import exceptions.NoFileFoundInThisProject;
import exceptions.NotDataFoundForTheKey;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/* The class read, write to .properties file.  **
** User has to supply the properties file location **
** Handling the file locations - with project class path or on non-class path  */
public class PropertiesFileRW extends Properties {

    private static Properties properties = null;
    private static String fileNamex;
    private List<String> filePath = new ArrayList<>();

    public PropertiesFileRW(){
        properties = new Properties();
    }

    /* Method to set file name to be loaded and values to be read */
    public PropertiesFileRW setFileName(String fileName){
        fileNamex = fileName;
        return new PropertiesFileRW();
    }

    /* Method to get the file name set by user to be read or write */
    public String getfileName(){
        return fileNamex;
    }

    /* Method to read specific key value from the properties file */
    public String getKey(String key){
        PropertiesFileRW propertiesFileRW = new PropertiesFileRW();

        new PropertiesFileRW().loadPropertiesLocatedInProject(propertiesFileRW.getfileName());

        String data = properties.getProperty(key);

        if(data == null) {
            try {
                throw new NotDataFoundForTheKey("No such key "+key+" found in the propertie file, keys in file "+properties.toString());
            } catch (NotDataFoundForTheKey e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    /* Loading file located with project class path */
    private void loadPropertiesLocatedInProject(String fileName) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(new PropertiesFileRW().findFile(new File("."), fileName)));

            if(inputStream == null)
                throw new NoFileFoundInThisProject(String.format("No file with name %s.properties found under this project", fileName));
            properties.load(inputStream);
        } catch (IOException e) {
            try {
                throw new NoFileFoundInThisProject(String.format("No file with name %s.properties found under this project", fileName));
            } catch (NoFileFoundInThisProject ex) {
                ex.printStackTrace();
            }
        }finally{
            try {
                if(inputStream != null)
                    inputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /* Method to scan the folder structure and find the .properties file in project */
    public String findFile(File dir, String fileName) {
        File[] files = dir.listFiles();
        String resultPath = null;
        if(files != null){
            for (File file : files) {
                filePath.add(file.getAbsolutePath());
                if (file.listFiles() != null)
                    findFile(file, fileName);
            }

        }
        for(String path : filePath){
            if(path.contains(fileName))
                resultPath = path;
        }
        return resultPath;
    }
}
