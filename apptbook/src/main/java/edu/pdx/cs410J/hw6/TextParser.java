package edu.pdx.cs410J.hw6;

import com.sun.source.tree.WhileLoopTree;
import edu.pdx.cs410J.AbstractAppointmentBook;
import edu.pdx.cs410J.AppointmentBookParser;
import edu.pdx.cs410J.ParserException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * A TextParser reads the contents of a text file and from it creates an appointment book with
 * its associated appointments.
 */
public class TextParser implements AppointmentBookParser <AppointmentBook> {

    /**
     * Parses the contents of a file or other input source and returns
     * an appointment book.
     */

    public AppointmentBook book;


    public TextParser(){
        book = null;


    }

    public TextParser(AppointmentBook book){

        this.book= book;
    }
    public AppointmentBook parse() {
        BufferedReader reader;
        ArrayList<Appointment> LIST = new ArrayList<Appointment>();
        String OWNER = null;
        AppointmentBook book = new AppointmentBook();
        try{
            reader=new BufferedReader((new FileReader("APPTBOOK.txt")));
            String line= reader.readLine();
            while(line!=null){
                //System.out.println("line= " + line);
                String details = line.toString();
                String delim = "[ ]";
                String[] tokens = details.split(delim);
                int size = tokens.length;
                if (size < 6) {
                    System.err.print(" details lacked");
                    System.exit(1);
                } else {
                    String owner = tokens[0];
                    book.owner = owner;
                    System.out.println("the TOKENS SIZE IS: " + tokens.length);
                    System.out.println("Token0 " + tokens[0]);
                    System.out.println("Token1 " + tokens[1]);
                    System.out.println("Token2 " + tokens[2]);
                    System.out.println("Token3 " + tokens[3]);
                    System.out.println("Token4 " + tokens[4]);
                    System.out.println("Token5 " + tokens[5]);

                    String bt = tokens[2] + " " + tokens[3];
                    String et = tokens[4] + " " + tokens[5];


                    System.out.println("et format check:" + et + "ISTHERE ANY PROBLEM?");
                    Appointment appt = new Appointment(tokens[1], bt, et);
                    System.out.println(" created a new appt");
                    LIST.add(appt);//

                }
                line = reader.readLine();
            }
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        book.list=LIST;
        return book;


        /*
        ArrayList<Appointment> LIST = new ArrayList<Appointment>();
        String OWNER = null;
        AppointmentBook book = new AppointmentBook();
        BufferedReader br = null;
        try {
            br = new BufferedReader( new FileReader("APPTBOOK.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder sb= new StringBuilder();
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while ((line=bufferedReader.readLine()!=null){
            sb.append(line).append("\n");
            String details = sb.toString();
            String delim="[ ]";
            String[] tokens= details.split(delim);
            int size=tokens.length;
            if(size< 6){
                System.err.print(" details lacked");
                System.exit(1);
            }
            else {
                String owner = tokens[0];
                book.owner=owner;
                System.out.println("the TOKENS SIZE IS: "+ tokens.length);
                System.out.println("Token0 "+tokens[0]);
                System.out.println("Token1 "+tokens[1]);
                System.out.println("Token2 "+tokens[2]);
                System.out.println("Token3 "+tokens[3]);
                System.out.println("Token4 "+tokens[4]);
                System.out.println("Token5 "+tokens[5]);

                String bt= tokens[2]+" " +tokens[3];

               // System.out.println("bt = "+ bt);
                String et= tokens[4]+" "+tokens[5];
                et = et.substring(0, et.length() - 1);
              //  System.out.println("et = "+ et);

                System.out.println("et format check:"+et+"ISTHERE ANY PROBLEM?");
                Appointment appt = new Appointment(tokens[1], bt, et);
                System.out.println(" created a new appt");
                LIST.add(appt);//
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        book.list=LIST;
        return book;
        */

    }





}

