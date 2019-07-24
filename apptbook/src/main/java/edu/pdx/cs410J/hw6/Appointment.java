package edu.pdx.cs410J.hw6;

import edu.pdx.cs410J.AbstractAppointment;

import java.awt.*;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.*;
import java.util.zip.DataFormatException;
import java.lang.Comparable;

/**
 * The class is the implementation of absMethod form AbstrationAppointment.
 * desctip, begintime and endtime are all peremeter in the class. they are all Strings.
 */
public class Appointment extends AbstractAppointment implements Comparable<Appointment> {
  // constructor of Appt

  public String descrip;
  public String beginTime;
  public String endTime;

  /**
   * constructors of Appointment( depault + with Args)
   */
  public Appointment(){
    descrip="NULL";
    beginTime="NULL";
    endTime="NULL";
  }
  public Appointment( String Descrip, String beginTime, String endTime) {

    this.descrip = Descrip;
    this.beginTime = beginTime;
    this.endTime = endTime;
/**
 * Checking the validity of decrip begintime and endtime. to check existing of variables and the length of description
 */
    if (descrip == null) {
      throw new NullPointerException("Description is empty.");
    }
    if (beginTime == null) {
      throw new NullPointerException("Begin Time is missing....");
    }
    if (endTime == null) {
      throw new NullPointerException("End Time is missing....");
    }

    if (descrip.length() > 500) {
      System.out.println("Description is too long");
    }
    /*if (TimeRegex(beginTime) == false) {
      System.out.println("Your begin time is in invalid format");
      return;
    }
    if (TimeRegex(endTime) == false) {
      System.out.println("Your end time is in invalid format");
      return;
    }
    */


    if (BeginEarlyThanEnd(beginTime, endTime) == false) {
      System.out.println("Begin Time is later than End time. Those are invalid time settings");
      System.exit(1);
      return;
    }



  }





    @Override
    public String getBeginTimeString () {
    String beginTime;// for return
     DateFormat dataFormatter ;
     Date time = null;
     dataFormatter = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT,Locale.US);
      try {
        time=BeginTimetoDate();
      } catch (ParseException e) {
        e.printStackTrace();
      }
      beginTime=dataFormatter.format(time);

    return beginTime;
    }

  @Override
    public String getEndTimeString () {

    String endTime;// for return
    DateFormat dataFormatter ;
    Date time=null;
    dataFormatter = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT,Locale.US);
    try {
      time=EndTimetoDate();
    } catch (ParseException e) {
      e.printStackTrace();
    }
    endTime=dataFormatter.format(time);

    return endTime;
    }

    @Override
    public String getDescription () {
    return descrip;
    }


  /**
   * will compare the time of begin and entime, if begin time is earlier then end time, then will return false
   *
   * @param beginTime is the time of begin time
   * @param endTime is the time of end tiem
   * both begin time and end time will be split to month day year hour and minus to compre
   */
/*
    public boolean BeginEarlyThanEnd (String beginTime, String endTime){
      String[] BTime = beginTime.split(" ", 2);
      String Bmdy = BTime[0];
     // System.out.print("Bmdy: "+Bmdy);


      String Bhm = BTime[1];


     // System.out.print("Bhm: "+Bhm);
      String[] ETime = endTime.split(" ", 2);
      String Emdy = ETime[0];


     // System.out.print("Emdy: "+Emdy);
      String Ehm = ETime[1];


     //System.out.print("Ehm: "+Ehm);

      String[] BeginSplitMDY = Bmdy.split("/", 3);

      String BeginM = BeginSplitMDY[0];


      int beginMonth = Integer.parseInt(BeginM);
      if(0>beginMonth || beginMonth>12){
        System.out.print("invalid begin Month");
        System.exit(1);
      }

      String BeginD = BeginSplitMDY[1];
      int beginDay = Integer.parseInt(BeginD);
      if(0>beginDay || beginDay>31){
        System.out.print("invalid begin Day");
        System.exit(1);
      }

      String BeginY = BeginSplitMDY[2];
      int beginYear = Integer.parseInt(BeginY);
      if(0>beginYear || beginYear>9999){
        System.out.print("invalid begin year");
        System.exit(1);
      }
      String[] BeginSplitHM = Bhm.split(":", 2);
      String BeginH = BeginSplitHM[0];
      int beginHour = Integer.parseInt(BeginH);
      if(0>beginHour || beginHour>23) {
        System.out.print("invalid begin hour");
        System.exit(1);
      }
      String BeginMin = BeginSplitHM[1];
      int beginMin = Integer.parseInt(BeginMin);
      if(0>beginMin || beginMin>59) {
          System.out.print("invalid begin min");
          System.exit(-1);
      }
      String[] EndSplitMDY = Emdy.split("/", 3);

      String EndM = EndSplitMDY[0];
      int endMonth = Integer.parseInt(EndM);
      if(0>endMonth || endMonth>12){
        System.out.print("invalid end Month");
        System.exit(-1);
      }
      String EndD = EndSplitMDY[1];
      int endDay = Integer.parseInt(EndD);
      if(0>endDay || endDay>31){
        System.out.print("invalid end Day");
        System.exit(-1);
      }

      String EndY = EndSplitMDY[2];
      int endYear = Integer.parseInt(EndY);
      if(0>endYear || endYear>9999){
        System.out.print("invalid end year");
        System.exit(-1);
      }
      String[] EndSplitHM = Ehm.split(":", 2);
      String EndH = EndSplitHM[0];
      int endHour = Integer.parseInt(EndH);
     // System.out.println("endHour= "+ endHour);
      if(0>endHour || endHour>23) {
        System.out.print("invalid end hour");
        System.exit(-1);
      }
      String EndMin = EndSplitHM[1];
      //System.out.println("EndMin= "+ EndMin);
        int endMin = Integer.parseInt(EndMin);
        //System.out.println("EndMin:: "+ EndMin);
      if(0>endMin || endMin>59) {
            System.out.print("invalid end min");
            System.exit(-1);
        }

        if(0>beginMin || beginMin>59) {
            System.out.print("invalid begin min");
            System.exit(-1);
        }
      if (beginYear > endYear) {
        System.out.println("begin time Year is later than end time Year");
        return false;
      }
      if (beginMonth > endMonth) {
        System.out.println("begin time Month is later than end time Month");
        return false;
      }

      if (beginDay > endDay) {
        System.out.println("begin time Day is later than end time Day");
        return false;
      }

      if (beginHour > endHour) {
        System.out.println("begin time Hour is later than end time Hour");
        return false;
      }
      if (beginMin > endMin) {
        System.out.println("begin time Min is later than end time Min");
        return  false;
      } else {
        return true;
      }
    }

*/

  public boolean BeginEarlyThanEnd (String beginTime, String endTime){// to test the insert timming is valid
    String[] BTime = beginTime.split(" ", 3);
    String Bmdy = BTime[0];
    String Bhm = BTime[1];
    String Bampm= BTime[2];

    String[] ETime = endTime.split(" ", 3);
    String Emdy = ETime[0];
    String Ehm = ETime[1];
    String Eampm = ETime[2];


    String[] BeginSplitMDY = Bmdy.split("/", 3);

    String BeginM = BeginSplitMDY[0];


    if(Bampm.toUpperCase().equals("PM") && Eampm.toUpperCase().equals("AM")){
      System.out.println("MY Lord have to sleep, Please double check your begin and end time");
      System.exit(-1);

    }

    int beginMonth = Integer.parseInt(BeginM);


    if(0>beginMonth || beginMonth>12){
      System.out.print("invalid begin Month");
      System.exit(1);
    }

    String BeginD = BeginSplitMDY[1];
    int beginDay = Integer.parseInt(BeginD);
    if(0>beginDay || beginDay>31){
      System.out.print("invalid begin Day");
      System.exit(1);
    }

    String BeginY = BeginSplitMDY[2];
    int beginYear = Integer.parseInt(BeginY);
    if(0>beginYear || beginYear>9999){
      System.out.print("invalid begin year");
      System.exit(1);
    }
    String[] BeginSplitHM = Bhm.split(":", 2);
    String BeginH = BeginSplitHM[0];
    int beginHour = Integer.parseInt(BeginH);

  //  System.out.println("begin Hour:"+beginHour);
    if(0>beginHour || beginHour>12) {
      System.out.print("invalid begin hour");
      System.exit(1);
    }
    String BeginMin = BeginSplitHM[1];
    int beginMin = Integer.parseInt(BeginMin);
    if(0>beginMin || beginMin>59) {
      System.out.print("invalid begin min");
      System.exit(-1);
    }
    String[] EndSplitMDY = Emdy.split("/", 3);

    String EndM = EndSplitMDY[0];
    int endMonth = Integer.parseInt(EndM);
    if(0>endMonth || endMonth>12){
      System.out.print("invalid end Month");
      System.exit(-1);
    }
    String EndD = EndSplitMDY[1];
    int endDay = Integer.parseInt(EndD);
    if(0>endDay || endDay>31){
      System.out.print("invalid end Day");
      System.exit(-1);
    }

    String EndY = EndSplitMDY[2];
    int endYear = Integer.parseInt(EndY);
    if(0>endYear || endYear>9999){
      System.out.print("invalid end year");
      System.exit(-1);
    }
    String[] EndSplitHM = Ehm.split(":", 2);
    String EndH = EndSplitHM[0];
    int endHour = Integer.parseInt(EndH);
    // System.out.println("endHour= "+ endHour);
    if(0>endHour || endHour>12) {
      System.out.print("invalid end hour");
      System.exit(-1);
    }
    String EndMin = EndSplitHM[1];
    //System.out.println("EndMin= "+ EndMin);
    int endMin = Integer.parseInt(EndMin);
    //System.out.println("EndMin:: "+ EndMin);
    if(0>endMin || endMin>59) {
      System.out.print("invalid end min");
      System.exit(-1);
    }


    if(0>beginMin || beginMin>59) {
      System.out.print("invalid begin min");
      System.exit(-1);
    }


    if(Bampm.toUpperCase().equals("PM")){
      beginHour=beginHour+12;
    }
    if(Eampm.toUpperCase().equals("PM")){
      endHour=endHour+12;
    }



    if (beginYear > endYear) {
      System.out.println("begin time Year is later than end time Year");
      return false;
    }
    if (beginMonth > endMonth) {
      System.out.println("begin time Month is later than end time Month");
      return false;
    }

    if (beginDay > endDay) {
      System.out.println("begin time Day is later than end time Day");
      return false;
    }


    if (beginHour > endHour) {

      System.out.println("begin time Hour is later than end time Hour");
      return false;
    }
    if (beginMin > endMin) {
      System.out.println("begin time Min is later than end time Min");
      return  false;
    } else {
      return true;
    }
  }



  public  Date BeginTimetoDate() throws ParseException {
    String[] Time = this.beginTime.split(" ", 3);
    String mdy = Time[0];
    String hm = Time[1];
    String ampm= Time[2];


    String[] TimeSplitHM = hm.split(":", 2);
    String TimeH = TimeSplitHM[0];
    int TimeHour = Integer.parseInt(TimeH);
    if(0>TimeHour || TimeHour>12) {
      System.out.print("invalid  hour");
      System.exit(1);
    }
    String TimeMIN = TimeSplitHM[1];
    int TimeMin = Integer.parseInt(TimeMIN);
    if(0>TimeMin || TimeMin>59) {
      System.out.print("invalid min");
      System.exit(-1);
    }
    String TimeHourToString="";
    if(ampm.toUpperCase().equals("PM")){
      TimeHour=TimeHour+12;
      TimeHourToString=Integer.toString(TimeHour);
    }

    String TIME=mdy+" "+ TimeHourToString+":"+TimeMIN;

    Date date=new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(TIME);

    return date;
  }

  public  Date EndTimetoDate() throws ParseException {
    String[] Time = this.endTime.split(" ", 3);
    String mdy = Time[0];
    String hm = Time[1];
    String ampm= Time[2];


    String[] TimeSplitHM = hm.split(":", 2);
    String TimeH = TimeSplitHM[0];
    int TimeHour = Integer.parseInt(TimeH);
    if(0>TimeHour || TimeHour>12) {
      System.out.print("invalid  hour");
      System.exit(1);
    }
    String TimeMIN = TimeSplitHM[1];
    int TimeMin = Integer.parseInt(TimeMIN);
    if(0>TimeMin || TimeMin>59) {
      System.out.print("invalid min");
      System.exit(-1);
    }
    String TimeHourToString="";
    if(ampm.toUpperCase().equals("PM")){
      TimeHour=TimeHour+12;
      TimeHourToString=Integer.toString(TimeHour);

    }

    String TIME=mdy+" "+ TimeHourToString+":"+TimeMIN;

    Date date=new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(TIME);

    return date;
  }

  @Override
  public int compareTo(Appointment obj)  {

    int beginflag = 0;

    try {
      beginflag = this.BeginTimetoDate().compareTo(obj.BeginTimetoDate());
    } catch (ParseException e) {
      e.printStackTrace();
    }

    if(beginflag==0){
      int endflag= 0;
      try {
        endflag = this.EndTimetoDate().compareTo(obj.EndTimetoDate());
      } catch (ParseException e) {
        e.printStackTrace();
      }
      if(endflag==0){
            int decrflag= this.getDescription().compareTo(obj.getDescription());
            if(decrflag==0){
              System.out.println("you duplicate the appointment ");
              System.exit(-1);
            }
            return decrflag;
        }
      return endflag;
    }
    return beginflag;

  }


}
