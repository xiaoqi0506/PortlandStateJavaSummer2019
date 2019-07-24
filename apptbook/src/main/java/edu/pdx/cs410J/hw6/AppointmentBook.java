package edu.pdx.cs410J.hw6;

import edu.pdx.cs410J.AbstractAppointment;
import edu.pdx.cs410J.AbstractAppointmentBook;

import java.io.*;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.lang.Comparable;

/**
 * the class of implementation to abstractAppointmentbook
 *
 */
public class AppointmentBook extends AbstractAppointmentBook< Appointment> {
    public ArrayList<Appointment> list;
    public String owner;

    public AppointmentBook(){
        owner="";
        list=new ArrayList<>();
    }

    /**
     * constrctors of appointment book
     *
     * @param owner String will contain the person to meet with
     * @param obj the detial of the appointment
     */
    public  AppointmentBook(String owner, Appointment obj){

        this.owner=owner;
        this.list=new ArrayList<>();
        this.list.add(obj);

    }
    public AppointmentBook(String ower, ArrayList<Appointment> obj){
        this.owner=ower;
        this.list=obj;
    }
    public  AppointmentBook(ArrayList<Appointment>obj){
        this.list = obj;
    }

    public void printALLInfo() {
        System.out.print(' ');
       System.out.print(this.toString()+"\n");

       for(int i=0; i< this.list.size(); i++){
           System.out.print("Description: "+ list.get(i).descrip+ "  ");
           System.out.print("BeginTime: "+ list.get(i).beginTime+ "  ");
           System.out.println("EndTime: "+ list.get(i).endTime);

       }
    }

    public ArrayList<Appointment> Sorting() throws ParseException {

        BufferedReader reader;
        ArrayList<Appointment> sorted = new ArrayList<Appointment>();
        String OWNER = null;
        try{
            reader=new BufferedReader((new FileReader("APPTBOOK.txt")));
            String line= reader.readLine();

            BufferedReader Reader = new BufferedReader(new FileReader("APPTBOOK.txt"));
            int ApptNumber = 0;
            while (Reader.readLine() != null) {
                ApptNumber++;
            }
            Reader.close();
            System.out.println("ApptNUMB: "+ ApptNumber);
            //////get the number of how many appts in the file

            while(line!=null) {
                System.out.println("IN WHILE LOOP");


                    String details = line.toString();
                    String delim = "[@]";
                    String[] tokens = details.split(delim);
                    int size = tokens.length;
                    // System.out.println("Token length: "+ size);
                     if (size < 4) {
                         System.err.print(" details lacked, the file might be broken");
                         System.exit(-1);
                    } else if (size > 4) {
                         System.err.print(" details overloaded, the file might be broken");
                         System.exit(-1);
                    }
                    else {
                         String Owner = tokens[0];
                         String bt = tokens[2];
                         String et = tokens[3];

                         Appointment appt = new Appointment(tokens[1], bt, et);//tokens[1] is desc
                         System.out.println(" created a new appt");
                         sorted.add(appt);
                         System.out.println(" A NEW APPT IS INSERT");
                    }
                line = reader.readLine();
            }
            Collections.sort(sorted);
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i=0; i<sorted.size(); i++) {
            System.out.println(" Sorted list: " + sorted.get(i));
        }

        try{
            File file = new File("PrettyAPPTBOOK.txt");
            FileWriter  Filewriter=new FileWriter(file, true);

            for(int j=0 ; j<sorted.size();j++) {
                Filewriter.write(String.valueOf(sorted.get(j))+"\n");
            }
            Filewriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }


     return sorted;
    }




@Override
    public String getOwnerName(){
        return owner;
    };

    @Override
    public ArrayList<Appointment> getAppointments(){
        return list;
    };

    @Override
    public void addAppointment(Appointment appt)
    {
        list.add(appt);
    };



}
