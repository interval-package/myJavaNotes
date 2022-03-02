package test.test05;

/*
* 自定义非法年龄类IllegalAgeException
* 当年龄超出范围合理范围的时候用于表示抛出
* */
public class IllegalAgeException extends Exception{
    public final String errMessage="illegal age, exceeding the limits, please check your input!";

    private final static int upBoundary = 150, lowBoundary = 0;

    public void dispErr(){
        System.err.println(errMessage);
    }

    static boolean isSafe(int age){
        return age > lowBoundary && age < upBoundary;
    }
}
