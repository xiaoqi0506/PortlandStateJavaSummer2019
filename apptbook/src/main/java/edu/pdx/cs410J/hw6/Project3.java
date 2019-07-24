package edu.pdx.cs410J.hw6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Project3 {


    public static void main(String[] args) throws IOException, ParseException {

        /*
        The following is the part to check if there is any options
         */
       /* for (String arg : args) {
            System.out.println(arg + " ");
        }
        */
        String[] my_arg;
        my_arg = args;
        List<String> my_list = new ArrayList<String>(Arrays.asList(my_arg));

        for (int i = 0; i < args.length; i++) {
            System.out.println("Options Testing....");
            if (args[i].equals("-README")) {
                System.out.println("Programmer: HE WANG\n");
                System.out.println("Project 3 README\n");
                System.out.println("Description: This project will have to method classes additional to project 1 and 2. \n" +
                        "TextDumper will write context to an external file, and TextParser will read from the file" +
                        "The external file is named APPTBOOK.txt, which will contain all details about the users\n" +
                        "the file name has to signed with .txt" +
                        "appointments. those details are passed from command line with 4 strings,those will be detailed\n" +
                        "in the following paragraph.\n" +
                        "WARNNING THIS PROJECT IS RESTRICTED ON HOW YOU USE READ ME." +
                        "README HAS THE TOP PRIORITY, IF YOUR OPTION HAS A README, NO MATTER WHERE IT IS, YOU WILL SEE THIS INSTROCTION" +
                        "Project 3 will take 4 Strings as argument list just like the last one. All of those argument will be quoted in quoatation markes. \n" +
                        "There should be a space between each argument\n" +
                        "The order of those arguments should be insert in particular order. The list has to follow this order: name\n" +
                        "of the owner of the Appointment book, the description of the appointment, the time of appointment begin time with am/pm,\n" +
                        "and the time of the appointment end time with am/pm.\n"+
                        "if you want to pretty print, you will have a option called -pretty with filename APPTBOOK.txt as a separate premiter, the program,\n "+
                        "will create a txt file for saving the pretty formate of all inserted appointmets. The pretty file is called PrettyAPPTBOOK.txt"
                );
                System.exit(1);
            }
            if (args[i].equals("-textFile")) {
                System.out.println("FIND A testFILE command");
                if (!args[i + 1].equals("APPTBOOK.txt")) {
                    System.out.println("There is no that file found. Project exit");
                    System.exit(1);
                } else if (args[i + 1].equals("-README")) {
                    System.out.println("Programmer: HE WANG\n");
                    System.out.println("Project 2 README\n");
                    System.out.println("Description: This project will have to method classes additional to project 1. \n" +
                            "TextDumper will write context to an external file, and TextParser will read from the file" +
                            "The external file is named APPTBOOK.txt, which will contain all details about the users\n" +
                            "the file name has to signed with .txt" +
                            "appointments. those details are passed from command line with 4 strings,those will be detailed\n" +
                            "in the following paragraph.\n" +
                            "WARNNING THIS PROJECT IS RESTRICTED ON HOW YOU USE READ ME." +
                            "README HAS THE TOP PRIORITY, IF YOUR OPTION HAS A README, NO MATTER WHERE IT IS, YOU WILL SEE THIS INSTROCTION" +
                            "Project 2 will take 4 Strings as argument list. All of those argument will be quoted in quoatation markes. \n" +
                            "There should be a space between each argument\n" +
                            "The order of those arguments should be insert in particular order. The list has to follow this order: name\n" +
                            "of the owner of the Appointment book, the description of the appointment, the time of appointment begin time,\n" +
                            "and the time of the appointment end time.");
                    System.exit(1);
                } else if (args[i + 1].equals("APPTBOOK.txt")) {// if there the file found
                    System.out.println("printing out the File");
                    TextParser temp_parser = new TextParser();
                    temp_parser.book = temp_parser.parse();
                    temp_parser.book.printALLInfo();

                    my_list.remove("-textFile");
                    my_list.remove("APPTBOOK.txt");

                }
            }

            if (args[i].equals("-print")) {
                for (int j = 0; j < my_list.size(); j++) {
                    if (my_list.get(j).equals("-README")) {
                        System.out.println("Programmer: HE WANG\n");
                        System.out.println("Project 3 README\n");
                        System.out.println("Description: This project will have to method classes additional to project 1 and 2. \n" +
                                "TextDumper will write context to an external file, and TextParser will read from the file" +
                                "The external file is named APPTBOOK.txt, which will contain all details about the users\n" +
                                "the file name has to signed with .txt" +
                                "appointments. those details are passed from command line with 4 strings,those will be detailed\n" +
                                "in the following paragraph.\n" +
                                "WARNNING THIS PROJECT IS RESTRICTED ON HOW YOU USE READ ME." +
                                "README HAS THE TOP PRIORITY, IF YOUR OPTION HAS A README, NO MATTER WHERE IT IS, YOU WILL SEE THIS INSTROCTION" +
                                "Project 3 will take 4 Strings as argument list just like the last one. All of those argument will be quoted in quoatation markes. \n" +
                                "There should be a space between each argument\n" +
                                "The order of those arguments should be insert in particular order. The list has to follow this order: name\n" +
                                "of the owner of the Appointment book, the description of the appointment, the time of appointment begin time with am/pm,\n" +
                                "and the time of the appointment end time with am/pm.\n"+
                                "if you want to pretty print, you will have a option called -pretty with filename APPTBOOK.txt as a separate premiter, the program,\n "+
                                "will create a txt file for saving the pretty formate of all inserted appointmets. The pretty file is called PrettyAPPTBOOK.txt"
                                );

                        System.exit(1);
                    }
                    my_list.remove("-pretty");
                    my_list.remove("-print");
                    my_list.remove("-testFile");
                    my_list.remove("APPTBOOK.txt");
                    my_list.remove("APPTBOOK.txt");
                }
                System.out.println("After clean up testfile and print");
                if (my_list.size() < 4) {
                    System.out.println("there are less of 4 args left, in order to text if there is any README");
                } else if (my_list.size() > 4) {
                    System.out.println("after this crop, there is still more than 4 args");
                } else {
                    System.out.println("Description: " + my_list.get(1));

                }
            }

            if (args[i].equals("-pretty")) {
                System.out.println("FIND A -pretty command");
                if (!args[i + 1].equals("APPTBOOK.txt")) {
                    System.out.println("There is no that file found. Project exit");
                    System.exit(1);
                } else if (args[i + 1].equals("-README")) {
                    System.out.println("Programmer: HE WANG\n");
                    System.out.println("Project 3 README\n");
                    System.out.println("Description: This project will have to method classes additional to project 1. \n" +
                            "TextDumper will write context to an external file, and TextParser will read from the file" +
                            "The external file is named APPTBOOK.txt, which will contain all details about the users\n" +
                            "the file name has to signed with .txt" +
                            "appointments. those details are passed from command line with 4 strings,those will be detailed\n" +
                            "in the following paragraph.\n" +
                            "WARNNING THIS PROJECT IS RESTRICTED ON HOW YOU USE READ ME." +
                            "README HAS THE TOP PRIORITY, IF YOUR OPTION HAS A README, NO MATTER WHERE IT IS, YOU WILL SEE THIS INSTROCTION" +
                            "Project 3 will take 4 Strings as argument list just like the last one. All of those argument will be quoted in quoatation markes. \n" +
                            "There should be a space between each argument\n" +
                            "The order of those arguments should be insert in particular order. The list has to follow this order: name\n" +
                            "of the owner of the Appointment book, the description of the appointment, the time of appointment begin time with am/pm,\n" +
                            "and the time of the appointment end time with am/pm.\n"+
                            "if you want to pretty print, you will have a option called -pretty with filename APPTBOOK.txt as a separate premiter, the program,\n "+
                            "will create a txt file for saving the pretty formate of all inserted appointmets. The pretty file is called PrettyAPPTBOOK.txt"
                    );
                    System.exit(1);
                } else if (args[i + 1].equals("APPTBOOK.txt")) {// if there the file found
                    my_list.remove("-pretty");
                    my_list.remove("-print");
                    my_list.remove("-testFile");
                    my_list.remove("APPTBOOK.txt");
                    my_list.remove("APPTBOOK.txt");

                    for (String arg : my_arg) {
                        System.out.println(arg + " ");
                    }

                    if (my_list != null) {
                        int SIZE = my_list.size();
                        if (SIZE < 4) {
                            System.out.print("Lack of args");
                            System.exit(-1);
                        }
                        if (SIZE > 4) {
                            System.out.print(" args > 4");
                            System.exit(-1);
                        }
                        String owner = my_list.get(0);

                        String desc = my_list.get(1);
                        String begintime = my_list.get(2);
                        String endtime = my_list.get(3);


                        if (owner.length() > 50) {
                            System.out.println("NAME is too long, may be you need to shorten your name");
                            System.exit(-1);
                        }
                        if (desc == null) {
                            System.out.print("Name is null");
                            System.exit(-1);
                        }
                        if (begintime == null) {
                            System.out.print("Begin Time is null");
                            System.exit(-1);
                        }

                        if (endtime == null) {
                            System.out.print("End Time is null");
                            System.exit(-1);
                        }


                        Appointment appt = new Appointment(desc, begintime, endtime);
                        ArrayList<Appointment> obj = new ArrayList<Appointment>();// create a new list of APPT
                        obj.add(appt);//just contains only one obj
                        AppointmentBook book = new AppointmentBook(owner, obj);//create a new book of owner with one obj

                        try {
                            TextDumper dumper = new TextDumper();// initial new textDumper
                            dumper.dump(book);//write to the file, and update new APPTBOOK to file
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                        TextParser PrettyParse = new TextParser();// download
                        if (PrettyParse.namecheck(my_list.get(0)) == false) {
                            System.out.println("Name DO NOT MATCH");
                            System.exit(-1);
                        }

                        AppointmentBook PrettyBook = new AppointmentBook();
                        PrettyBook.list=PrettyBook.Sorting();// will sort and will save it to file

                        System.out.println("Pretty book list size:"+ PrettyBook.list.size());

                        System.out.println("Pretty Print the File");
                        System.exit(1);
                    }
                }
            }

        }
            // need renew my args for main  it could be shorter then original
            my_list.remove("-print");
            my_list.remove("-testFile");
            my_list.remove("APPTBOOK.txt");

            my_arg = my_list.toArray(new String[0]);
            System.out.println("the new insert apt details are:  \n");
            for (int i = 0; i < my_arg.length; i++) {
                System.out.println(my_arg[i]);
            }


            if (my_arg != null) {
                int size = my_arg.length;
                if (size < 4) {
                    System.out.print("Lack of args");
                    System.exit(-1);
                }
                if (size > 4) {
                    System.out.print(" args > 4");
                    System.exit(-1);
                }
                String owner = my_arg[0];

                String desc = my_arg[1];
                String begintime = my_arg[2];
                String endtime = my_arg[3];

                if (owner.length() > 50) {
                    System.out.println("NAME is too long, may be you need to shorten your name");
                    System.exit(-1);
                }
                if (desc == null) {
                    System.out.print("Name is null");
                    System.exit(-1);
                }
                if (begintime == null) {
                    System.out.print("Begin Time is null");
                    System.exit(-1);
                }

                if (endtime == null) {
                    System.out.print("End Time is null");
                    System.exit(-1);
                }


                Appointment appt = new Appointment(desc, begintime, endtime);
                ArrayList<Appointment> obj = new ArrayList<Appointment>();// create a new list of APPT
                obj.add(appt);//just contains only one obj
                AppointmentBook book = new AppointmentBook(owner, obj);//create a new book of owner with one obj

                TextParser parse = new TextParser();// download
                if (parse.namecheck(my_arg[0]) == false) {
                    System.out.println("Name DO NOT MATCH");
                    System.exit(-1);
                }

                try {
                    TextDumper dumper = new TextDumper();// initial new textDumper
                    dumper.dump(book);//write to the file, and update new APPTBOOK to file
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // TextParser parse= new TextParser();// download

                parse.book = parse.parse();
                System.out.println("Pirnt out the info an apptbook from file with the new inserted aptbook");
                parse.book.printALLInfo();

            } else {

                System.out.print("NO args at all");
                System.exit(-1);
            }
            System.exit(1);
        }
    }
