package sample;

public class Main{
    public static void main(String[] args) {
        String a = "ArsenUIods";
        String b = "Arseb";
        plag(a,b);
    }
    public static void plag(String s,String t){
        double count = 0;
        while (s.length()>t.length()){
                t+=" ";
        }
        while (t.length()>s.length()){
            s+=" ";
        }
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i)==t.charAt(i)){
                count++;
            }
        }
        System.out.println((count/s.length())*100+"%");
    }
}