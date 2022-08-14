package kau.isabu.web_project.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();
    public static SingletonService getSingletonService(){
        return instance;
    }
    private SingletonService(){

    }
}
