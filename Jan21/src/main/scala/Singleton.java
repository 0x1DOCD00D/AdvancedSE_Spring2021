public class Singleton {
    private static Singleton instanceVar = null;
    static Singleton creationPattern4Singleton() {
        if(instanceVar == null){
            instanceVar = new Singleton();
        }
        return instanceVar;
    }
    
    public static void main(String[] args) {
        Singleton client1 = Singleton.creationPattern4Singleton();//new Singleton();
        Singleton client2 = Singleton.creationPattern4Singleton();//new Singleton();
        System.out.println(client1);
        System.out.println(client2);
    }
}
