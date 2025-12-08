package DesingPatterns.Creational;

class Connection{
    private static Connection connection;

    private Connection() {}

    public static Connection getInstance(){
        synchronized (Connection.class){
            if (connection == null) {
                System.out.println("Create connection object");
                connection = new Connection();
            }
        }
        return connection;
    }
}

public class Singleton {
    public static void main(String[] args) {
        Connection connection = Connection.getInstance();
        Connection connection1 = Connection.getInstance();
    }
}

/**
 * SOLID: 
 */