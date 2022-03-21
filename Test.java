public class Test {
    public static void main(String[] args) {
       String a = "China	Baby_Food	H	13/07/2014	888084399	21/08/2014	2764	255.28	159.42	705593.92	440636.88	264957.04";
       String b[] = a.split("\t");
       
       for (int i = 0; i < b.length; i++){
           System.out.println(b[i]);
       }
    }
}
