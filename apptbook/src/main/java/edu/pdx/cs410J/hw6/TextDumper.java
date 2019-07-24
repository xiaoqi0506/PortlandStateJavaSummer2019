package edu.pdx.cs410J.hw6;

import edu.pdx.cs410J.AbstractAppointmentBook;
import edu.pdx.cs410J.AppointmentBookDumper;
import org.w3c.dom.Text;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * A TextDumper dumps the contents of an appointment book3
 * (including appointments) to a text
 * file.
 * will create appt book object and store it to APPTBOOK.
 * if there is not such file, then create one and stroe.
 */
public class TextDumper implements AppointmentBookDumper <AppointmentBook> {

    /**
     * Dumps an appointment book to some destination.
     *
     * @param book The appointment book whose contents are to be dumped
     * @throws IOException Something went wrong while dumping the appointment book
     */
    public ArrayList<Appointment> list;
    public String owner;
   ;

    public TextDumper(){
        ArrayList<Appointment> list = null;
        String owner= null;
    }
    public TextDumper(AppointmentBook book){
    ArrayList<Appointment> list = book.getAppointments();
    String owner= book.getOwnerName();
    }

    @Override
    public void dump(AppointmentBook book) throws IOException {
      //  TextDumper obj= new TextDumper(book);

        try{
            File file = new File("APPTBOOK.txt");

            FileWriter  fileWriter=new FileWriter(file, true);
            String tmp_str = new String();

            for(int i=0; i<book.list.size(); i++){
                tmp_str = tmp_str.concat(book.owner.toString()+"@");
                tmp_str = tmp_str.concat(book.list.get(i).descrip.toString()+"@");
                tmp_str = tmp_str.concat(book.list.get(i).beginTime.toString()+"@");
                tmp_str = tmp_str.concat(book.list.get(i).endTime.toString());
                tmp_str = tmp_str.concat("\n");
            }
            //str = tmp_str.toString();
            fileWriter.write(tmp_str);

            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }



}
