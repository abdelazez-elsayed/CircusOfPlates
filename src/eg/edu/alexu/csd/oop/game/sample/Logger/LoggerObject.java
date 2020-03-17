package eg.edu.alexu.csd.oop.game.sample.Logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerObject {
   private static Logger logger;
   private LoggerObject(){
           logger = LogManager.getLogger("Sample Game Logger");
           PropertyConfigurator.configure("log4j.properties");
   }
  public static Logger getLogger(){
       if (logger==null) new LoggerObject();
       return logger;
   }
}
