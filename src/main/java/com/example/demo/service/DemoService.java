package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

public class DemoService {

    public void demo() {
        // โจทย์
        //หาองศาของนาฬิกา ระหว่างเข็มสั้นไปเข็มยาว
        //โดย input hour (0-23), minute(0-59)

        int hour = 16;
        int min = 10;

        // ถ้าเกิน 12 ให้ลบ 12 คือ จำนวน 1 รอบ
        if(hour > 12) hour = hour - 12;
        if(hour < 12) hour = hour;



        // cal
        // 360 degrees in 60 minute
        // 60 min is 1 hour
        int minDegree = min * 6; // 1 min = 6 degree
        int hourDegree = (int) ((hour * 60 + min) * 0.5);


        int angle = Math.abs(hourDegree - minDegree); // องศา ที่ชั่วโมงและนาทีห่างกัน
        angle = Math.min(360-angle, angle);

        System.out.println(angle);

        //ให้เขียนโปรแกรมหา substring ที่ยาวที่สุดใน input ที่ไม่มี character ซ้ำกันเลย ถ้าคำตอบมีมากกว่า 1 อันให้เลือกออกมาเฉพาะอันแรกสุด
//
//        "ที่ไม่มี character ซ้ำกันเลย"
//
//        input = "xxxxaxabcdexxabcxx"
//        output = "xabcde"

        String input = "xxxxaxabcdexxabcxx";
        Map<Integer,String> mapStr = new HashMap<>();
        String emtry = "";
        for (int i = 0; i < input.length() ; i++ ) {

            if (emtry.contains(String.valueOf(input.charAt(i)))) {
                mapStr.put(emtry.length(), emtry);
                emtry = input.charAt(i) + "";
            } else {
                emtry = emtry + input.charAt(i);
            }
        }

        System.out.println(mapStr.get(
                mapStr.keySet().stream().sorted().toList().getLast())
        );
    }
}
