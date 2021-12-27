import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class SLF4JDemo {

    private String name;
    private String ssn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }


    public static void main(String[] args) {

        SLF4JDemo slf4JDemo = new SLF4JDemo();

        slf4JDemo.setName("pcap");
        slf4JDemo.setSsn("7857803094");

        //Creating the Logger object
        Logger logger = LoggerFactory.getLogger(SLF4JDemo.class);

        //Logs only the class
        logger.info("The class that contains PII is " + slf4JDemo);

        // logs the name attribute of slf4JDemo
        logger.debug("The name is " + slf4JDemo.getName());

        // logs the ssn attribute of slf4JDemo
        logger.debug("The ssn is " + slf4JDemo.getSsn());
    }
}