package lesson25.home;

public class TestClass {
    private String name;
    private String description;

    public TestClass(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
