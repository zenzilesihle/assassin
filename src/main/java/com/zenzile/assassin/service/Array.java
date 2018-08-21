package com.zenzile.assassin.service;

public class Array {
    public static void main(String[] args) {
//        String [] names;  //
//
//        names = new String[6]; //
//
//        names[0] = "Apiwe";
//        names[3] = "Sihle";
//        names[1] = "Zenzie";
//        names[4] = "Xozwa";
//        names[2] = "Siso";
//        names[5] = "XYTRD";
//
//        for(int i = 0; i < names.length; i++) {
//            System.out.println(names[i]);
//        }




































































        String [] names = new String[4];
        String name = "Sonke is not in the array";

        names[0] = "Apiwe";
        names[1] = "Sisonke";
        names[2] = "Sonke";
        names[3] = "Siso";

        for(int i = 0; i< names.length; i++ ){
            if(names[i].equals("Sonke")){
                System.out.println(i);
                name = "Sonke is in the array ";
            }
        }
        System.out.println(name);




    }



}
