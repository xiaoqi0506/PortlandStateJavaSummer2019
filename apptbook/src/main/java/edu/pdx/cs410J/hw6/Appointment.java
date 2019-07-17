package edu.pdx.cs410J.hw6;

import edu.pdx.cs410J.AbstractAppointment;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.*;

/**
 * The class is the implementation of absMethod form AbstrationAppointment.
 * desctip, begintime and endtime are all peremeter in the class. they are all Strings.
 */
public class Appointment extends AbstractAppointment {
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

    if (BeginLateThanEnd(beginTime, endTime) == false) {
      System.out.println("Begin Time is later than End time. Those are invalid time settings");
      System.exit(1);
      return;
    }


  }
    @Override
    public String getBeginTimeString () {
      return beginTime;
    }

    @Override
    public String getEndTimeString () {
      return endTime;

    }

    @Override
    public String getDescription () {
    return descrip;

    }

   /* public boolean TimeRegex( String time){
      Pattern p = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");
      Matcher m = p.matcher(time);

      boolean result= m.matches();
      return result;

    }
*/
  /**
   * will compare the time of begin and entime, if begin time is earlier then end time, then will return false
   *
   * @param beginTime is the time of begin time
   * @param endTime is the time of end tiem
   * both begin time and end time will be split to month day year hour and minus to compre
   */

    public boolean BeginLateThanEnd (String beginTime, String endTime){
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
          System.exit(1);
      }
      String[] EndSplitMDY = Emdy.split("/", 3);

      String EndM = EndSplitMDY[0];
      int endMonth = Integer.parseInt(EndM);
      if(0>endMonth || endMonth>12){
        System.out.print("invalid end Month");
        System.exit(1);
      }
      String EndD = EndSplitMDY[1];
      int endDay = Integer.parseInt(EndD);
      if(0>endDay || endDay>31){
        System.out.print("invalid end Day");
        System.exit(1);
      }

      String EndY = EndSplitMDY[2];
      int endYear = Integer.parseInt(EndY);
      if(0>endYear || endYear>9999){
        System.out.print("invalid end year");
        System.exit(1);
      }
      String[] EndSplitHM = Ehm.split(":", 2);
      String EndH = EndSplitHM[0];
      int endHour = Integer.parseInt(EndH);
     // System.out.println("endHour= "+ endHour);
      if(0>endHour || endHour>23) {
        System.out.print("invalid end hour");
        System.exit(1);
      }
      String EndMin = EndSplitHM[1];
      //System.out.println("EndMin= "+ EndMin);
        int endMin = Integer.parseInt(EndMin);
        //System.out.println("EndMin:: "+ EndMin);
      if(0>endMin || endMin>59) {
            System.out.print("invalid end min");
            System.exit(1);
        }

        if(0>beginMin || beginMin>59) {
            System.out.print("invalid begin min");
            System.exit(1);
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


}
