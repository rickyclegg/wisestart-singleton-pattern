public class ConfigurationManager {
    // Volatile keyword ensures that multiple threads handle the uniqueInstance variable correctly when it is being initialized to the Singleton instance
    private static volatile ConfigurationManager uniqueInstance;

    // Configuration settings
    private String databaseURL;
    private String apiKey;

    // Private constructor prevents instantiation from other classes
    private ConfigurationManager() { }

    // Double-checked locking to reduce the use of synchronization in getInstance()
    public static ConfigurationManager getInstance() {
        if (uniqueInstance == null) {
            synchronized (ConfigurationManager.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new ConfigurationManager();
                }
            }
        }
        return uniqueInstance;
    }

    // Set and get configuration entries
    public void setDatabaseURL(String databaseURL) {
        this.databaseURL = databaseURL;
    }

    public String getDatabaseURL() {
        return databaseURL;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }
}
