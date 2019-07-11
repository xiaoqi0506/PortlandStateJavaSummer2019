package edu.pdx.cs410J.hw6;

/**
 * The main class for the CS410J appointment book Project
 */
public class Project1 {

  public static void main(String[] args) {
    Appointment appointment = new Appointment();  // Refer to one of Dave's classes so that we can be sure it is on the classpath
    if(args.length<4) {
      System.err.println("Missing command line arguments");
    }


   // for (String arg : args) {
    //    // System.out.println(args);
    /**
     * take in input args to multiple variables
     */
      String owner=args[0];
     // System.out.println("NAME: "+owner);
      String description=args[1];
     // System.out.println("description: "+description);
      String begintime=args[2];
     // System.out.println("begintime: "+begintime);
      String endtime=args[3];
      //System.out.println("endtime: "+endtime);

      if(owner.length()>50){
        System.out.println("NAME is too long, may be you need to shorten your name");
        return;
      }
      if(owner == null){
        System.out.print("Name is null");

        return ;
      }
      Appointment details = new Appointment(description, begintime, endtime);
      System.out.print(owner+", the topic is : ");

      System.out.print(details.toString());


      AppointmentBook appt= new AppointmentBook(owner, details);

      appt.printALLInfo();

   // }
    System.exit(1);
  }

}