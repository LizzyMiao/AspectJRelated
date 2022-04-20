package de.scrum_master.app;

import de.scrum_master.common.CollectException;

public class ExceptionClass {

    @CollectException
    public void divideByZeroWithCatch(){
        try{
            int a = 5/0;
        }
        catch (ArithmeticException e){
            System.out.println("Can not divide by zero");
        }
    }


    public void divideByZeroWithNoCatch(){
        int b = 5/0;
    }
}
