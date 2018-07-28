package edu.budati.name_change;

import java.util.Scanner;
import java.io.File;

public class Main{
    public static void main(String[] args){
        String filePath = "C:\\Users\\chand\\Downloads\\The.Big.Bang.Theory.S02.COMPLETE.BluRay.x264-LeRalouf";
        final File folder = new File(filePath);
        nameChange(folder);
    }

    private static void nameChange(File folder){
        for(File f : folder.listFiles()){
            if(f.isDirectory()){
                nameChange(f);
            }
            else{
                String [] namep = f.getName().split("\\.");
                String name = namep[4].split("E")[1];
                String ext = namep[namep.length - 1];
                name = name + "." + ext;
                File newName = new File(f.getParent() + "\\" + name);
                f.renameTo(newName);
                String path = f.getName();
                System.out.println(path);
            }
        }
    }
}