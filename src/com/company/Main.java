package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[][] Person1 ={{"9:00", "10:30"}, {"12:00","13:00"}, {"16:00","18:00"}};
        String [] Person1DB ={"9:00","20:00"};
        String[][] Person2 ={{"10:00","11:30"}, {"12:30","14:30"}, {"14:30","15:00"}, {"16:00","17:00"}};
        String [] Person2DB ={"10:00","18:30"};
        List<Integer> Meetings1 = new ArrayList<>();
        List<Integer> Meetings2 = new ArrayList<>();
        List<Integer> DB1 = new ArrayList<>();
        List<Integer> DB2 = new ArrayList<>();
        List<List<Integer>> FT1 = new ArrayList<>();
        List<List<Integer>> FT2 = new ArrayList<>();

        //convert all to minutes

        for (String[]a:Person1){

            for (String s :a){
                String[] hourMin = s.split(":");
                int hour = Integer.parseInt(hourMin[0]);
                int mins = Integer.parseInt(hourMin[1]);
                int hoursInMins = (hour * 60)+ mins;
                Meetings1.add(hoursInMins);
            }

        }
        System.out.println(Meetings1);
        for (String[]a:Person2){

            for (String s :a){
                String[] hourMin = s.split(":");
                int hour = Integer.parseInt(hourMin[0]);
                int mins = Integer.parseInt(hourMin[1]);
                int hoursInMins = (hour * 60) + mins;
                Meetings2.add(hoursInMins);
            }

        }
        System.out.println(Meetings2);
        for (String s :Person1DB){
                String[] hourMin = s.split(":");
                int hour = Integer.parseInt(hourMin[0]);
                int mins = Integer.parseInt(hourMin[1]);
                int hoursInMins = (hour * 60) + mins;
                DB1.add(hoursInMins);
            }
        System.out.println(DB1);
        for (String s :Person2DB){
            String[] hourMin = s.split(":");
            int hour = Integer.parseInt(hourMin[0]);
            int mins = Integer.parseInt(hourMin[1]);
            int hoursInMins = (hour * 60) + mins;
            DB2.add(hoursInMins);
        }
        System.out.println(DB2);

        // List processing
        int j=0;
        for(int i =1; i<= Meetings1.size()-2;){
            if(Meetings1.get(i+1)-Meetings1.get(i)>30){
                FT1.add(new ArrayList<>());
                FT1.get(j).add(Meetings1.get(i));
                FT1.get(j).add(Meetings1.get(i+1));
               j++;
            }
            i+=2;
        }
        if((DB1.get(DB1.size()-1)-Meetings1.get(Meetings1.size()-1))>30) {
            FT1.add(new ArrayList<>());
            FT1.get(j).add(Meetings1.get(Meetings1.size() - 1));
            FT1.get(j).add(DB1.get(DB1.size() - 1));
        }
        System.out.println(FT1);

        j=0;
        for(int i =1; i<= Meetings2.size()-2;){
            if(Meetings2.get(i+1)-Meetings2.get(i)>30){
                FT2.add(new ArrayList<>());
                FT2.get(j).add(Meetings2.get(i));
                FT2.get(j).add(Meetings2.get(i+1));
                j++;
            }
            i+=2;
        }
        if((DB2.get(DB2.size()-1)-Meetings2.get(Meetings2.size()-1))>30){
            FT2.add(new ArrayList<>());
            FT2.get(j).add(Meetings2.get(Meetings2.size()-1));
            FT2.get(j).add(DB2.get(DB2.size()-1));
        }
        System.out.println(FT2);

        while(FT1.get(0).get(1)<FT2.get(0).get(0)){
            FT1.remove(0);
        }
        System.out.println(FT1);
        while(FT2.get(0).get(1)<FT1.get(0).get(0)){
            FT2.remove(0);
        }
        System.out.println(FT2);

        Iterator itFT1 = FT1.iterator();
        Iterator itFT2 = FT2.iterator();
        ArrayList <Integer> step;
        ArrayList <Integer> step2;
        ArrayList <ArrayList<Integer>> calender = new ArrayList<>();
        j=0;
        while (itFT1.hasNext()&& itFT2.hasNext()){

           step = (ArrayList<Integer>) itFT1.next();
           step2 =(ArrayList<Integer>) itFT2.next();
           if(step.get(0)>=step2.get(0)){
               calender.add(new ArrayList<>());
               calender.get(j).add(step.get(0));
           }
           else {
               calender.add(new ArrayList<>());
               calender.get(j).add(step2.get(0));
           }

            if(step.get(1)<=step2.get(1)){
                calender.get(j).add(step.get(1));
            }
            else {
                calender.get(j).add(step2.get(1));
            }
            j++;
           System.out.println(calender);
        }
        ArrayList<ArrayList<String>> Result = new ArrayList<>();
        j=0;
        for (ArrayList<Integer> a : calender){
            Result.add(new ArrayList<>());
            for(int time : a){
                int hours = time / 60; //since both are ints, you get an int
                int minutes = time % 60;
                String cast =  String.format("%02d", minutes);
                Result.get(j).add(""+hours+":"+cast);
            }
            j++;
        }
        System.out.println(Result);
    }
}
