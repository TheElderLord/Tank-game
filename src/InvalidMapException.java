public class InvalidMapException extends Exception{

    public InvalidMapException(String message){
        System.out.println(message);
    }

    @Override
    public String getMessage(){
        return " ";
    }

}