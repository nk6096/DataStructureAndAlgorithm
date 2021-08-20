package com.example.demo.prc.array;

public class MyInterfaceImpl implements MyInter {

    @Override
    public String myFunctionalMet() {
        return null;
    }

    public static void main(String[] args) {
        MyInterfaceImpl myInterface = new MyInterfaceImpl();
        System.out.println(myInterface.myFunctionalMet());
    }


}
