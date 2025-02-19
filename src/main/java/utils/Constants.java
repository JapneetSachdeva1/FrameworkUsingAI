package utils;

public class Constants
{
    // Timeouts
    public static final int IMPLICIT_WAIT = 10;
    public static final int PAGE_LOAD_TIMEOUT = 20;
    public static final int EXPLICIT_WAIT = 15;

    // URLs
    public static final String BASE_URL = ConfigReader.getProperty("base.url");

    // Browser
    public static final String BROWSER = ConfigReader.getProperty("browser");

}
