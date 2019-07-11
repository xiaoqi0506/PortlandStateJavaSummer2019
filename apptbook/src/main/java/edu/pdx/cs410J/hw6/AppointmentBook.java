package edu.pdx.cs410J.hw6;

import edu.pdx.cs410J.AbstractAppointment;
import edu.pdx.cs410J.AbstractAppointmentBook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

    public void printALLInfo() {
        System.out.print(' ');
       System.out.print(this.toString());
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
