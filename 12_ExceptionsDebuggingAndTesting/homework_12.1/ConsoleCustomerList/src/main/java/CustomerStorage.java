import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;
        final String REGEX_EMAIL = "[a-z\\.]+@[a-z]+.[a-z]+";
        final String REGEX_PHONE = "\\+79[0-9]{9}";

        String[] components = data.split("\\s+");
        if (components.length != 4 || !components[INDEX_EMAIL].matches(REGEX_EMAIL) || !components[INDEX_PHONE].matches(REGEX_PHONE)) {
            throw new IllegalArgumentException("Wrong format. \n add Василий Петров vasily.petrov@gmail.com +79215637722");
        }

        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        if (!storage.containsKey(name)) {
            throw new IllegalArgumentException("Wrong name");
        } else {
            storage.remove(name);
        }

    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}