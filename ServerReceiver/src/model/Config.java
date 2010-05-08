package model;

import java.io.FileReader;
import java.util.Properties;
import utils.Log;

/**
 * Just for the sake of not manually write the String of properties key
 * @author riza
 */
public class Config {
    public static final String QueueCapacity = "QueueCapacity";
    public static final String QueueFairness = "QueueFairness";
    public static final String ThreadNumber = "ThreadNumber";
    public static final char EOS = '|';
    public static final String Port = "Port";
    public static final String MinimumQueueThreshold = "MinimumQueueThreshold";
    public static final boolean MaintainConnection = false;
    public static final String MysqlDBUser = "MysqlDBUser";
    public static final String MysqlDBPass = "MysqlDBPass";
    public static final String MysqlDBHost = "MysqlDBHost";
    public static final String MysqlDBPort = "MysqlDBPort";
    public static final String MysqlDBName = "MysqlDBName";

    private Properties mProperties;

    public Config() {
        
    }

    public int getQueueCapacity() {
        try {
            return Integer.parseInt(mProperties.getProperty(QueueCapacity));
        } catch(Exception e) {
            Log.warning(Errors.GET_CAPACITY_FAILED, e.getMessage());
            return 1;
        }
    }

    public boolean getQueueFairness() {
        try {
            return Boolean.parseBoolean(mProperties.getProperty(QueueFairness));
        } catch(Exception e) {
            Log.warning(Errors.GET_FAIRNESS_FAILED, e.getMessage());
            return true;
        }
    }

    public int getThreadNumber() {
        try {
            return Integer.parseInt(mProperties.getProperty(ThreadNumber));
        } catch(Exception e) {
            Log.warning(Errors.GET_THREADNUMBER_FAILED, e.getMessage());
            return 1;
        }
    }

    public char getEOS() {
        return EOS;
    }

    public int getPort() {
        try {
            return Integer.parseInt(mProperties.getProperty(Port));
        } catch(Exception e) {
            Log.warning(Errors.GET_CAPACITY_FAILED, e.getMessage());
            return 23456;
        }
    }

    public Properties getProperties() {
        return mProperties;
    }

    public boolean loadConfiguration()  {
        mProperties = new Properties();
        mProperties.setProperty(Config.QueueCapacity,"100");
        mProperties.setProperty(Config.QueueFairness,"true");
        mProperties.setProperty(Config.ThreadNumber,"10");
        mProperties.setProperty(Config.Port,"23456");
        FileReader tFileReader = null;
        try{
            tFileReader = new FileReader("config/properties.config");
            mProperties.load(tFileReader );
            Log.write("configuration loaded");
            return true;
        } catch(Exception ex) {
            Log.info("cannot load file properties, default used");
            return false;
        } finally {
            try {
                tFileReader.close();
            } catch(Exception ex) { }
        }
    }

    public int getMinThreshold() {
        try {
            return Integer.parseInt(mProperties.getProperty(MinimumQueueThreshold));
        } catch(Exception e) {
            Log.warning(Errors.GET_THREADNUMBER_FAILED, e.getMessage());
            return 1;
        }
    }

    public String GetMysqlDBUser() {
        try {
            return mProperties.getProperty(MysqlDBUser);
        } catch(Exception e) {
            Log.warning(Errors.GET_MYSQL_USER_FAIL, e.getMessage());
            return "localhost";
        }
    }

    public String GetMysqlDBPass() {
        try {
            return mProperties.getProperty(MysqlDBPass);
        } catch(Exception e) {
            Log.warning(Errors.GET_MYSQL_PASS_FAIL, e.getMessage());
            return "localhost";
        }
    }

    public String GetMysqlDBHost() {
        try {
            return mProperties.getProperty(MysqlDBHost);
        } catch(Exception e) {
            Log.warning(Errors.GET_MYSQL_HOST_FAIL, e.getMessage());
            return "localhost";
        }
    }

    public String GetMysqlDBPort() {
        try {
            return mProperties.getProperty(MysqlDBPort);
        } catch(Exception e) {
            Log.warning(Errors.GET_MYSQL_PORT_FAIL, e.getMessage());
            return "3306";
        }
    }

    public String GetMysqlDBName() {
        try {
            return mProperties.getProperty(MysqlDBName);
        } catch(Exception e) {
            Log.warning(Errors.GET_MYSQL_NAME_FAIL, e.getMessage());
            return "dbname";
        }
    }
}
