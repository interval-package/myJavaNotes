package test.test06;

//functional class

public class StringGoodUser {

    private StringGoodUser(){}

//        String obj = new String("ASasDQcEasxFFdwasDA");
//        System.out.println("old obj: "+obj+"\nget Exchanged:　"+getCaseExchanged(obj));

//        String source = new String("sadasdasdwfeasasdwadsafasf");
//        String item = new String("asd");
//        System.out.println("Source String: "+source+"\titem is: "+item);
//        System.out.println("deleted String:　"+myDeleter(source,item));
//        System.out.println("Source String unchanged: "+source);

//        String[] testItem = {
//                new String("sacdcas"),
//                new String("saccawdwac"),
//                new String("sssssssssssssssss"),
//        };
//            for (String str: testItem) {
//            System.out.println(str+" : "+isPlalindrome(str));
//        }

//        String numStiring = new String("1235489132158912137864112167143");
//        System.out.println("unformated:　"+numStiring+"\nformated:　"+stringIntToFormated(numStiring));

    static public void main(String[] args){
        String str="abcjavadefjavadddjavc";
        String newStr="av";
        int count = searchByIndexOf(str, newStr);
        System.out.println(newStr+" 匹配到 "+count+" 次");
    }


    public static String getCaseExchanged(String source){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < source.length(); i++) {
            //索引指定位置的字符
            char c = source.charAt(i);
            //判断是否为小写字母
            if(Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c));
            }else if(Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            }
        }
        return result.toString();
    }

    public static boolean isPlalindrome(String str){
        int mid1 =str.length()%2==0 ? str.length()/2 : (str.length()/2+1);
        int mid2 =str.length()%2==0 ? mid1+1 : mid1;
        for(int i=0; i<mid1; i++){
            if(str.charAt(mid1-1-i)!=str.charAt(mid2-1+i)){
                return false;
            }
        }
        return true;
    }

    public static String myDeleter(String source, String item){
        source=source.replace(item, "");
        return source;
    }

//    使用IndexOf
    public static int searchByIndexOf(String str,String newStr){
        int count=0;
        int i=0;
        while(str.indexOf(newStr,i)>=0){
            count++;
            i=str.indexOf(newStr,i)+1;
        }
        return count;
    }

    public static String stringIntToFormated(String myNum){
        StringBuilder output= new StringBuilder(myNum);
        int subs = myNum.length()%3;
        int mainBody = myNum.length()/3;
//        System.out.println(subs+" "+mainBody);
        int i =0;
        if (subs==0){
            i++;
//            退一位，给序号留空间，使进入的第一位为3
            subs--;
        }
        for (;i < mainBody;i++){
//            因为如果有了subs!=0，那么就后面整体退一位了
            output.insert(subs + i * 4, ",");
        }
        return output.toString();
    }

}
