package hu.bme.mit.train.tachogaph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Date;
import java.util.Map;

public class TachographModule {

    Table<Date,Integer, Integer> data = HashBasedTable.create();

    public void recordData(int joystick, int speed){
        recordData(new Date(),joystick,speed);
    }

    public void recordData(Date d, int joystick, int speed){
        data.put(d,joystick,speed);
    }

    public Map<Integer, Integer> getData(Date d){
        return data.row(d);
    }

}
