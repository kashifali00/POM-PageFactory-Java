package com.testPackage.logger;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Kashif on 9/14/2018.
 */
public class MyLogger {

    static{

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        System.setProperty("current.date.time", dateFormat.format(new Date()));
        String path = System.getProperty("user.dir");
        System.out.println("PATH ::->"+path);
        String filePath = path+"/logs/";
        System.setProperty("filePath",filePath);
    }

    public static Logger log = Logger.getLogger(MyLogger.class);
}
