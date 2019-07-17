package edu.pdx.cs410J.hw6;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

public class Project2 {

    /**
     * creates a new Appointment as specified on the command line
     * adds the Appointment to the AppointmentBook
     * writes the AppointmentBook back to the text file
     */

    public static void main(String[] args) throws IOException {

            if (args != null) {
                int size = args.length;
                if (size != 4) {
                    System.out.print("Lack of args");
                    System.exit(1);
                }
                String owner = args[0];
                String desc = args[1];
                String begintime = args[2];
                String endtime = args[3];

                if (owner.length() > 50) {
                    System.out.println("NAME is too long, may be you need to shorten your name");
                    return;
                }
                if (desc == null) {
                    System.out.print("Name is null");
                }
                if (begintime == null) {
                    System.out.print("Begin Time is null");
                }

                if (endtime == null) {
                    System.out.print("End Time is null");
                }


                Appointment appt = new Appointment(desc, begintime, endtime);
                ArrayList<Appointment> obj = new ArrayList<Appointment>();// create a new list of APPT
                obj.add(appt);//just contains only one obj
                AppointmentBook book= new AppointmentBook(owner, obj);//create a new book of owner with one obj
                try {
                    TextDumper dumper= new TextDumper();// initial new textDumper
                    dumper.dump(book);//write to the file, and update new APPTBOOK to file
                } catch (IOException e)
                {
                    e.printStackTrace();
                }

                TextParser parse= new TextParser();// download

                parse.book=parse.parse();
                System.out.println("Pirnt out the info an apptbook from parse");
                parse.book.printALLInfo();

            }
                //AppointmentBook book = new AppointmentBook(owner, list);
            else {

                System.out.print("NO args at all");
                System.exit(1);
            }
        System.exit(1);
        }
    }

