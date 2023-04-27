public class StringUses {
     public void operations(){
            String s = "abc";
            String temp = "abc";
            temp = "cd";
            s = s + temp;
            StringBuffer buff = new StringBuffer(s);
//            for(int i =0 ; i < s.length() ; i++){
//                //replace a char
//                buff.setCharAt(i,'z');
//            }
            //delete a char
            buff.deleteCharAt(2);
            System.out.println(buff);

            // substring of a string, provide index excluding last index
            System.out.println(buff.substring(0,3));

            if(buff.charAt(0) == buff.charAt(1)){
                System.out.println("character match");
            }else{
                System.out.println("character doesn't match");
            }

            if(buff.charAt(0) > buff.charAt(1)){
                 System.out.println("first is greater");
            }else{
                System.out.println("first is smaller");
            }

            if(buff.equals(s)){
                System.out.println("Use equals for string matching");
            }

            // use compareTo for string comparison
            System.out.println(buff.toString().compareTo(s));

            String number = "941";
            System.out.println(convert(number));

           // convert to string
            int no = 942;

            System.out.println(Integer.toString(no));

     }

    private int convert(String number) {
         int num = 0;
         for(int i = 0; i < number.length(); i++){
             num = num*10 + (number.charAt(i) - '0');
         }
         return num;
    }
}
