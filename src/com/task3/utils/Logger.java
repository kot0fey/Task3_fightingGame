package com.task3.utils;

import MyArrayList.MyArrayList;
import com.task3.characters.Entity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {


    private static String log = "";
    private static final File file = createFile();


    public static File createFile() {
        File dir = new File("logs");
        Date date = new Date();
        String actualDate = date.toString().replace(':', '_');
        int hashCode = date.hashCode();

        dir.mkdir();
        return new File(dir, actualDate + "_" + hashCode);
    }

    public static void setLog(Entity playerEntity, Entity machineEntity) {
        MyArrayList<Entity> list = new MyArrayList<Entity>();
        list.add(playerEntity);
        list.add(machineEntity);
        //A:Weapon:W:(int)HP; B:Weapon:L:(int)HP;
        for (Entity entity : list) {
            log += entity.getName() + ':' + entity.getPickedWeaponName() + ':' + entity.getWinFlag() + ':' + entity.getHealthPoints() + "; ";
        }
        log += '\n';
    }

    public static void writeToFile() throws IOException {
        FileWriter writer = new FileWriter(file);
        if (!log.equals("")) {
            writer.write(log);
        } else {
            writer.close();
            file.delete();
        }
        writer.close();
    }

}
