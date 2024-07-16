class ConfigurationManager {
  private static uniqueInstance: ConfigurationManager | null = null;
  private databaseURL: string | null = null;
  private apiKey: string | null = null;

  // Private constructor to prevent instantiation
  private constructor() {}

  // Static method to get the single instance of the class
  public static getInstance(): ConfigurationManager {
    if (!ConfigurationManager.uniqueInstance) {
      ConfigurationManager.uniqueInstance = new ConfigurationManager();
    }
    return ConfigurationManager.uniqueInstance;
  }

  // Setters and getters for configuration settings
  public setDatabaseURL(databaseURL: string | null): void {
    this.databaseURL = databaseURL;
  }

  public getDatabaseURL(): string | null {
    return this.databaseURL;
  }

  public setApiKey(apiKey: string | null): void {
    this.apiKey = apiKey;
  }

  public getApiKey(): string | null {
    return this.apiKey;
  }
}

export default ConfigurationManager;
