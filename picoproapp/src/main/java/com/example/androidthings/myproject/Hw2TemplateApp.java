package com.example.androidthings.myproject;

import com.google.android.things.pio.Gpio;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.*;



/**
 * Template for IDD Fall 2017 HW2 (text entry device)
 * Created by bjoern on 9/5/17.
 */

public class Hw2TemplateApp extends SimplePicoPro {
    private List<Integer> intList;

    public Hw2TemplateApp() {
        super();

        intList = new ArrayList<Integer>();
        for (int index = 0; index < 5; index++)
        {
            intList.add(0);
        }

    }


    @Override
    public void setup() {
        //set two GPIOs to input
        pinMode(GPIO_128,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_128,Gpio.EDGE_BOTH);

        pinMode(GPIO_39,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_39,Gpio.EDGE_BOTH);

        pinMode(GPIO_37,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_37,Gpio.EDGE_BOTH);

        pinMode(GPIO_35,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_35,Gpio.EDGE_BOTH);

        pinMode(GPIO_34,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_34,Gpio.EDGE_BOTH);
    }

    @Override
    public void loop() {
        //nothing to do here

    }

    @Override
    void digitalEdgeEvent(Gpio pin, boolean value) {

        println("digitalEdgeEvent"+pin+", "+value);

        // Putting 1 whenever
        if (pin==GPIO_128 && value==LOW) intList.set(0, 1); // Thumb
        if (pin==GPIO_39 && value==LOW) intList.set(1, 1);  // Index
        if (pin==GPIO_37 && value==LOW) intList.set(2, 1);  // Middle
        if (pin==GPIO_35 && value==LOW) intList.set(3, 1);  // Ring
        if (pin==GPIO_34 && value==LOW) intList.set(4, 1);  // Pinky



        // Depending on which combination of [x x x x x], select letter
        if(pin==GPIO_128 && value==HIGH || pin==GPIO_39 && value==HIGH || pin==GPIO_37 && value==HIGH || pin==GPIO_35 && value==HIGH || pin==GPIO_34 && value==HIGH)
            if (intList.get(0) == 1 && intList.get(1) == 1 && intList.get(2) == 1 && intList.get(3) == 1 && intList.get(4) == 1) {
                printCharacterToScreen('z');
                intList.set(0, 0);
                intList.set(1, 0);
                intList.set(2, 0);
                intList.set(3, 0);
                intList.set(4, 0);
            } else if (intList.get(0) == 1 & intList.get(1) == 1 & intList.get(2) == 1 & intList.get(3) == 1) {
                if (pin==GPIO_34 && value==LOW){
                    return;
                }
                printCharacterToScreen('v');
                intList.set(0, 0);
                intList.set(1, 0);
                intList.set(2, 0);
                intList.set(3, 0);
            } else if (intList.get(0) == 1 & intList.get(2) == 1 & intList.get(3) == 1 & intList.get(4) == 1) {
                if (pin==GPIO_39 && value==LOW){
                    return;
                }
                printCharacterToScreen('w');
                intList.set(0, 0);
                intList.set(2, 0);
                intList.set(3, 0);
                intList.set(4, 0);
            } else if (intList.get(1) == 1 & intList.get(2) == 1 & intList.get(3) == 1 & intList.get(4) == 1) {
                if (pin==GPIO_128 && value==LOW){
                    return;
                }
                printCharacterToScreen(' ');
                intList.set(1, 0);
                intList.set(2, 0);
                intList.set(3, 0);
                intList.set(4, 0);
            } else if (intList.get(0) == 1 & intList.get(1) == 1 & intList.get(3) == 1 & intList.get(4) == 1) {
                if (pin==GPIO_37 && value==LOW){
                    return;
                }
                printCharacterToScreen('x');
                intList.set(0, 0);
                intList.set(1, 0);
                intList.set(3, 0);
                intList.set(4, 0);
            } else if (intList.get(0) == 1 & intList.get(1) == 1 & intList.get(2) == 1 & intList.get(4) == 1) {
                if (pin==GPIO_39 && value==LOW || pin==GPIO_37 && value==LOW){
                    return;
                }
                printCharacterToScreen('y');
                intList.set(0, 0);
                intList.set(1, 0);
                intList.set(2, 0);
                intList.set(4, 0);
            } else if (intList.get(0) == 1 & intList.get(1) == 1 & intList.get(2) == 1) {
                if (pin==GPIO_35 && value==LOW || pin==GPIO_34 && value==LOW){
                    return;
                }
                printCharacterToScreen('p');
                intList.set(0, 0);
                intList.set(1, 0);
                intList.set(2, 0);
            } else if (intList.get(0) == 1 && intList.get(2) == 1 && intList.get(3) == 1) {
                if (pin==GPIO_39 && value==LOW || pin==GPIO_34 && value==LOW){
                    return;
                }
                printCharacterToScreen('q');
                intList.set(0, 0);
                intList.set(2, 0);
                intList.set(3, 0);
            } else if (intList.get(0) == 1 && intList.get(3) == 1 && intList.get(4) == 1) {
                if (pin==GPIO_39 && value==LOW || pin==GPIO_37 && value==LOW){
                    return;
                }
                printCharacterToScreen('r');
                intList.set(0, 0);
                intList.set(3, 0);
                intList.set(4, 0);
            } else if (intList.get(1) == 1 && intList.get(2) == 1 && intList.get(3) == 1) {
                if (pin==GPIO_128 && value==LOW || pin==GPIO_34 && value==LOW){
                    return;
                }
                printCharacterToScreen('s');
                intList.set(1, 0);
                intList.set(2, 0);
                intList.set(3, 0);
            } else if (intList.get(1) == 1 && intList.get(3) == 1 && intList.get(4) == 1) {
                if (pin==GPIO_128 && value==LOW || pin==GPIO_37 && value==LOW){
                    return;
                }
                printCharacterToScreen('t');
                intList.set(1, 0);
                intList.set(3, 0);
                intList.set(4, 0);
            } else if (intList.get(2) == 1 && intList.get(3) == 1 && intList.get(4) == 1) {
                if (pin==GPIO_128 && value==LOW || pin==GPIO_39 && value==LOW){
                    return;
                }
                printCharacterToScreen('u');
                intList.set(2, 0);
                intList.set(3, 0);
                intList.set(4, 0);
            } else if (intList.get(0) == 1 && intList.get(1) == 1) {
                if (pin==GPIO_37 && value==LOW || pin==GPIO_35 && value==LOW || pin==GPIO_34 && value==LOW){
                    return;
                }
                printCharacterToScreen('f');
                intList.set(0, 0);
                intList.set(1, 0);
            } else if (intList.get(0) == 1 && intList.get(2) == 1) {
                if (pin==GPIO_39 && value==LOW || pin==GPIO_35 && value==LOW || pin==GPIO_34 && value==LOW){
                    return;
                }
                printCharacterToScreen('g');
                intList.set(0, 0);
                intList.set(2, 0);
            } else if (intList.get(0) == 1 && intList.get(3) == 1) {
                if (pin==GPIO_39 && value==LOW || pin==GPIO_37 && value==LOW || pin==GPIO_34 && value==LOW){
                    return;
                }
                printCharacterToScreen('h');
                intList.set(0, 0);
                intList.set(3, 0);
            } else if (intList.get(0) == 1 && intList.get(4) == 1) {
                if (pin==GPIO_39 && value==LOW || pin==GPIO_37 && value==LOW || pin==GPIO_35 && value==LOW){
                    return;
                }
                printCharacterToScreen('i');
                intList.set(0, 0);
                intList.set(4, 0);
            } else if (intList.get(1) == 1 && intList.get(2) == 1) {
                if (pin==GPIO_128 && value==LOW || pin==GPIO_35 && value==LOW || pin==GPIO_34 && value==LOW){
                    return;
                }
                printCharacterToScreen('j');
                intList.set(1, 0);
                intList.set(2, 0);
            } else if (intList.get(1) == 1 && intList.get(3) == 1) {
                if (pin==GPIO_128 && value==LOW || pin==GPIO_37 && value==LOW || pin==GPIO_34 && value==LOW){
                    return;
                }
                printCharacterToScreen('k');
                intList.set(1, 0);
                intList.set(3, 0);
            } else if (intList.get(1) == 1 && intList.get(4) == 1) {
                if (pin==GPIO_128 && value==LOW || pin==GPIO_37 && value==LOW || pin==GPIO_35 && value==LOW){
                    return;
                }
                printCharacterToScreen('l');
                intList.set(1, 0);
                intList.set(4, 0);
            } else if (intList.get(2) == 1 && intList.get(3) == 1) {
                if (pin==GPIO_128 && value==LOW || pin==GPIO_39 && value==LOW || pin==GPIO_34 && value==LOW){
                    return;
                }
                printCharacterToScreen('m');
                intList.set(2, 0);
                intList.set(3, 0);
            } else if (intList.get(2) == 1 && intList.get(4) == 1) {
                if (pin==GPIO_128 && value==LOW || pin==GPIO_39 && value==LOW || pin==GPIO_35 && value==LOW){
                    return;
                }
                printCharacterToScreen('n');
                intList.set(2, 0);
                intList.set(4, 0);
            } else if (intList.get(3) == 1 && intList.get(4) == 1) {
                if (pin==GPIO_128 && value==LOW || pin==GPIO_39 && value==LOW || pin==GPIO_37 && value==LOW){
                    return;
                }
                printCharacterToScreen('o');
                intList.set(3, 0);
                intList.set(4, 0);
            } else if (intList.get(0) == 1) {
                if (pin==GPIO_39 && value==LOW || pin==GPIO_37 && value==LOW || pin==GPIO_35 && value==LOW || pin==GPIO_34 && value==LOW){
                    return;
                }
                printCharacterToScreen('a');
                intList.set(0, 0);
            } else if (intList.get(1) == 1) {
                if (pin==GPIO_128 && value==LOW || pin==GPIO_37 && value==LOW || pin==GPIO_35 && value==LOW || pin==GPIO_34 && value==LOW){
                    return;
                }
                printCharacterToScreen('b');
                intList.set(1, 0);
            } else if (intList.get(2) == 1) {
                if (pin==GPIO_128 && value==LOW || pin==GPIO_39 && value==LOW || pin==GPIO_35 && value==LOW || pin==GPIO_34 && value==LOW){
                    return;
                }
                printCharacterToScreen('c');
                intList.set(2, 0);
            } else if (intList.get(3) == 1) {
                if (pin==GPIO_128 && value==LOW || pin==GPIO_39 && value==LOW || pin==GPIO_37 && value==LOW || pin==GPIO_34 && value==LOW){
                    return;
                }
                printCharacterToScreen('d');
                intList.set(3, 0);
            } else if (intList.get(4) == 1) {
                if (pin==GPIO_128 && value==LOW || pin==GPIO_39 && value==LOW || pin==GPIO_37 && value==LOW || pin==GPIO_35 && value==LOW){
                    return;
                }
                printCharacterToScreen('e');
                intList.set(4, 0);
            }




    }

}