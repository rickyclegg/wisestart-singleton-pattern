import ConfigurationManager from './ConfigurationManager';

describe('ConfigurationManager', () => {
  beforeEach(() => {
    const instance = ConfigurationManager.getInstance();
    instance.setDatabaseURL(null);
    instance.setApiKey(null);
  });

  test('should return the same instance', () => {
    const instance1 = ConfigurationManager.getInstance();
    const instance2 = ConfigurationManager.getInstance();

    expect(instance1).toBe(instance2);
  });

  test('should set and get configuration settings', () => {
    const instance = ConfigurationManager.getInstance();
    instance.setDatabaseURL('jdbc:mysql://localhost:3306/mydb');
    instance.setApiKey('12345');

    expect(instance.getDatabaseURL()).toBe('jdbc:mysql://localhost:3306/mydb');
    expect(instance.getApiKey()).toBe('12345');
  });

  test('should be thread-safe', async () => {
    const instances: ConfigurationManager[] = [];
    const promises = Array.from({ length: 10 }, () =>
        new Promise<void>((resolve) => {
          setTimeout(() => {
            instances.push(ConfigurationManager.getInstance());
            resolve();
          }, Math.random() * 100);
        })
    );

    await Promise.all(promises);

    const [firstInstance, ...otherInstances] = instances;
    otherInstances.forEach(instance => {
      expect(instance).toBe(firstInstance);
    });
  });
});
