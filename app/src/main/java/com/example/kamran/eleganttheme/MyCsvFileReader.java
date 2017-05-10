package com.example.kamran.eleganttheme;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by administorzz on 2017/3/1.
 */

public class MyCsvFileReader {
    Context context;
    public MyCsvFileReader(Context applicationContext) {
        this.context = applicationContext;
}
    public ArrayList<String[]> readCsvFile(int fileresource) {
        ArrayList<String[]> games = new ArrayList<>();
        InputStream fin = null;
        InputStreamReader isr = null;
        BufferedReader reader = null;
        try {
            fin = context.getResources().openRawResource(fileresource);
            isr = new InputStreamReader(fin);
            reader = new BufferedReader(isr);
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] teamInfo = line.split(",");

                games.add(teamInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null)
                    isr.close();
                if (fin != null)
                    fin.close();
                if (reader != null)
                    reader.close();
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
        return games;
    }

//    private static Team createTeam(String[] teamData){
//        String name = teamData[0];
//        int imageId = Integer.parseInt(teamData[1]);
//        String date = teamData[2];
//        String site = teamData[3];
//        String nickname = teamData[4];
//        int ranking = Integer.parseInt(teamData[5]);
//        String score = teamData[6];
//
//        return new Team(name,imageId,date,site,nickname,ranking,score);
//
//
//    }

}


