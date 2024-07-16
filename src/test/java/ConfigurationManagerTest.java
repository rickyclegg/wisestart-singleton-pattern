import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConfigurationManagerTest {

    @BeforeEach
    public void setup() {
        // Ensure we start fresh for each test (for testing purposes, we assume
        // there's a way to "reset" the Singleton, which is atypical for true Singleton usage)
        ConfigurationManager uniqueInstance = ConfigurationManager.getInstance();
        uniqueInstance.setDatabaseURL(null);
        uniqueInstance.setApiKey(null);
    }

    @Test
    public void testUniqueInstance() {
        ConfigurationManager instance1 = ConfigurationManager.getInstance();
        ConfigurationManager instance2 = ConfigurationManager.getInstance();

        // Both references should point to the same instance
        assertSame(instance1, instance2);
    }

    @Test
    public void testConfigurationSetting() {
        ConfigurationManager instance = ConfigurationManager.getInstance();
        instance.setDatabaseURL("jdbc:mysql://localhost:3306/mydb");
        instance.setApiKey("12345");

        assertEquals("jdbc:mysql://localhost:3306/mydb", instance.getDatabaseURL());
        assertEquals("12345", instance.getApiKey());
    }

    @Test
    public void testThreadSafety() throws InterruptedException {
        final ConfigurationManager[] instances = new ConfigurationManager[10];
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            final int index = i;
            threads[i] = new Thread(() -> instances[index] = ConfigurationManager.getInstance());
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        ConfigurationManager firstInstance = instances[0];
        for (int i = 1; i < 10; i++) {
            assertSame(firstInstance, instances[i]);
        }
    }
}
