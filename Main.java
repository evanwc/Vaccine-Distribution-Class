/** 										   
* Class to distribute vaccines to counties equitably
* through a system of phases. Calculates batch by batch
* for the state of California. Only calculates the 3 FDA
* approved vaccines. Meant for a single
* government worker.
*
* @author: Cheng, Evan. Fang, Abby. Guo, Jessica. Webb, Celeste
*
* links to copies of this code in case this fails:
* repl.it/@CostcoWater/SoftDiscreteVerification#Main.java
* replit.com/@CostcoWater/Backup#Main.java
*
* <Pre-conditions> Ask each county for a rough estimate
* of population that meets each phase requirement and
* have that information on hand. Receive a batch of FDA
* approved COVID-19 vaccines. Assume population is 16+,
* as they are the only ones approved for a vaccine so
* far. Sleep a minimum of 8 hours before beginning.
*
*/
import java.util.Scanner;
class Main
{
 // instance variables
 // county name
 private String name;
 //population per phase per county
 private int ppCounty;
 //status of phase
 private boolean done;
 //type of vaccine
 private String type;
 //county phase
 private int phase;
 //vaccine amount
 private int vacAmount;
 //calculation variables
 public static int MtypeCalc = 0;
 public static int PtypeCalc = 0;
 public static int JtypeCalc = 0;
 //number of vaccines
 public static int CAvacM = 0;
 public static int CAvacP = 0;
 //number of ppl.
 public static int CAdoseM = 0;
 public static int CAdoseP = 0;
 public static int CAdoseJ = 0;
 //state phase
 public static int statePhase = 1;
 //checks
 public static boolean inCase = false;
 
 // constructor
 public Main(String initname)
 {
   name = initname;
   ppCounty = 0;
   done = false;
   type = "";
   phase = 1;
   vacAmount = 0;
 }
 
 // mutator method for ppCounty
 public void setppp(int newppp)
 {
   ppCounty = newppp;
 }
 
 // accessor method for done
 public boolean getDone()
 {
   return done;
 }
 
 // accessor method for phase
 public int getPhase()
 {
   return phase;
 }
 
 // accessor method for ppCounty
 public int getppCounty()
 {
   return ppCounty;
 }
  //mutator method for phase
 public void setPhase()
 {
   phase = statePhase;
 }
  // utilizes setppp(int newppp) mutator method
 // input population within county that qualifies for the current phase, and input is set to ppCounty
 public void setppCounty()
 {
   done = false;
   Scanner in = new Scanner(System.in);
   String temp = "";
   //below also ensures the answer is a number so that it can be parsed and assigned to ppCounty
   boolean isNumber = true;
   while (!temp.equals("y") || !isNumber)
   {
     isNumber = true;
     System.out.println("Around how many people in " + name + " county are part of phase " + statePhase + "?");
     String pp = in.nextLine();
     System.out.println("Is " + pp + " correct? (y/n)");
     temp = in.nextLine();
     if (pp.length() < 1)
     {
       System.out.println("Please input an actual number.");
       temp = "";
     }
     if (temp.equals("y"))
     {
       for(int i = 0; i<pp.length() && isNumber; i++)
       {
         if (!(pp.substring(i, i+1).equals("0") || pp.substring(i, i+1).equals("1") || pp.substring(i, i+1).equals("2") || pp.substring(i, i+1).equals("3") || pp.substring(i, i+1).equals("4") || pp.substring(i, i+1).equals("5") || pp.substring(i, i+1).equals("6") || pp.substring(i, i+1).equals("7") || pp.substring(i, i+1).equals("8") || pp.substring(i, i+1).equals("9")))
         {
           System.out.println("Please make sure your answer only contains the digits 0 through 9.");
           isNumber = false;
         }
         else
         {
           isNumber = true;
         }
       }
       if(isNumber)
       {
         setppp(Integer.parseInt(pp));
       }
     }
   }
 }
 
 // input how many of each vaccine is in the batch
 // changes CAvac and CAdose static variables
 // checks that input is a number each time
 public static void howMany()
 {
   Scanner in = new Scanner(System.in);
   String temp = "";
   boolean isNumber = true;
   while(!temp.equals("y") || !isNumber)
   {
     isNumber = true;
     System.out.println("How many Moderna vaccines have you received?");
     String tempM = in.nextLine();
     System.out.println("You said " + tempM + ". Is this correct?(y/n)");
     temp = in.nextLine();
     if (tempM.length() < 1)
     {
       System.out.println("Please input an actual number.");
       temp = "";
     }
     //checks if user input is not an integer with digits from 1-9, only sets number of ppl who can be vaccinated if it is
     if(temp.equals("y"))
     {
       for(int i = 0; i<tempM.length() && isNumber; i++)
       {
         if (!(tempM.substring(i, i+1).equals("0") || tempM.substring(i, i+1).equals("1") || tempM.substring(i, i+1).equals("2") || tempM.substring(i, i+1).equals("3") || tempM.substring(i, i+1).equals("4") || tempM.substring(i, i+1).equals("5") || tempM.substring(i, i+1).equals("6") || tempM.substring(i, i+1).equals("7") || tempM.substring(i, i+1).equals("8") || tempM.substring(i, i+1).equals("9")))
         {
           System.out.println("Please make sure your answer only contains the digits 0 through 9.");
           isNumber = false;
         }
         else
         {
           isNumber = true;
         }
       }
       if(isNumber)
       {
         CAvacM += Integer.parseInt(tempM);
         CAdoseM = CAvacM/2;
       }
     }
   }
 
   temp = "";
   isNumber = true;
   while(!temp.equals("y") || !isNumber)
   {
     isNumber = true;
     System.out.println("How many Pfizer vaccines have you received?");
     String tempP = in.nextLine();
     System.out.println("You said " + tempP + ". Is this correct?(y/n)");
     temp = in.nextLine();
     if (tempP.length() < 1)
     {
       System.out.println("Please input an actual number.");
       temp = "";
     }
     if(temp.equals("y"))
     {
       for (int i = 0; i < tempP.length() && isNumber; i++)
       {
         if (!(tempP.substring(i, i+1).equals("0") || tempP.substring(i, i+1).equals("1") || tempP.substring(i, i+1).equals("2") || tempP.substring(i, i+1).equals("3") || tempP.substring(i, i+1).equals("4") || tempP.substring(i, i+1).equals("5") || tempP.substring(i, i+1).equals("6") || tempP.substring(i, i+1).equals("7") || tempP.substring(i, i+1).equals("8") || tempP.substring(i, i+1).equals("9")))
         {
           System.out.println("Please make sure your answer only contains the digits 0 through 9.");
           isNumber = false;
         }
         else
         {
           isNumber = true;
         }
       }
       if(isNumber)
       {
         CAvacP += Integer.parseInt(tempP);
         CAdoseP = CAvacP/2;
       }
     }
   }
 
   temp = "";
   isNumber = true;
   while(!temp.equals("y") || !isNumber)
   {
     isNumber = true;
     System.out.println("How many Johnson & Johnson vaccines have you received?");
     String tempJ = in.nextLine();
     System.out.println("You said " + tempJ + ". Is this correct?(y/n)");
     temp = in.nextLine();
     if (tempJ.length() < 1)
     {
       System.out.println("Please input an actual number.");
       temp = "";
     }
     if(temp.equals("y"))
     {
       for(int i = 0; i<tempJ.length() && isNumber; i++)
       {
         if (!(tempJ.substring(i, i+1).equals("0") || tempJ.substring(i, i+1).equals("1") || tempJ.substring(i, i+1).equals("2") || tempJ.substring(i, i+1).equals("3") || tempJ.substring(i, i+1).equals("4") || tempJ.substring(i, i+1).equals("5") || tempJ.substring(i, i+1).equals("6") || tempJ.substring(i, i+1).equals("7") || tempJ.substring(i, i+1).equals("8") || tempJ.substring(i, i+1).equals("9")))
         {
           System.out.println("Please make sure your answer only contains the digits 0 through 9.");
           isNumber = false;
         }
         else
         {
           isNumber = true;
         }
       }
       if(isNumber)
       {
         CAdoseJ += Integer.parseInt(tempJ);
       }
     }
   }
 }
 
 // calculates how many vaccines a county needs
 // ppCounty is population of a county that quallifies for the phase, pop is population of california that qualifies for the phase, vac is how many people can be vaccinated from the current batch
 //initial calculation to get rough idea of how many vaccines should be sent to each county
 public void setAmount(int pop, int vac)
 {
   vacAmount = (int)((double)ppCounty/pop*vac);
 }
  // mutator method for vacAmount
 public void setvacAmount(int newAmount)
 {
   vacAmount = newAmount;
 }
 
 // assigns each county a type of vaccine so double doses are ensured both doses--starts distributing based on which type of vaccine there is more of, assigns a random one if they are equal
 // in one batch, a county can recieve only one type of vaccine, but is not constrained to the same vaccine for the next batch
 public void setType()
 {
   if (MtypeCalc >= vacAmount)
   {
     MtypeCalc -= vacAmount;
     type = "Moderna";
   }
   else if (PtypeCalc >= vacAmount)
   {
     PtypeCalc -= vacAmount;
     type = "Pfizer";
   }
   else if (JtypeCalc >= vacAmount)
   {
     JtypeCalc -= vacAmount;
     type = "Johnson & Johnson";
   }
   else if (MtypeCalc > PtypeCalc && MtypeCalc > JtypeCalc)
   {
     MtypeCalc = 0;
     type = "Moderna";
   }
   else if (PtypeCalc > MtypeCalc && PtypeCalc >  JtypeCalc)
   {
     PtypeCalc = 0;
     type = "Pfizer";
   }
   else if (JtypeCalc > PtypeCalc && JtypeCalc > MtypeCalc)
   {
     JtypeCalc = 0;
     type = "Johnson & Johnson";
   }
   else if (JtypeCalc == PtypeCalc)
   {
     JtypeCalc = 0;
     type = "Johnson & Johnson";
   }
   else if (PtypeCalc == MtypeCalc)
   {
     PtypeCalc = 0;
     type = "Pfizer";
   }
   else if (MtypeCalc == JtypeCalc)
   {
     MtypeCalc = 0;
     type = "Moderna";
   }
   else
   {
     type = "Moderna";
   }
 }
 
 // if a county is given a Moderna vaccine, then the ppCounty of the county is returned; similar idea for the next two methods. Used in main to calculate total population qualified for the phase of counties of that specific type
 public int findMpop()
 {
   if (type.equals("Moderna"))
   {
     return ppCounty;
   }
   else
   {
     return 0;
   }
 }
 
 public int findPpop()
 {
   if (type.equals("Pfizer"))
   {
     return ppCounty;
   }
   else
   {
     return 0;
   }
 }
 
 public int findJpop()
 {
   if (type.equals("Johnson & Johnson"))
   {
     return ppCounty;
   }
   else
   {
     return 0;
   }
 }
  // if a county is assigned Moderna vaccine, then returns the number of Moderna vaccines given to the county. Similar idea for the next two methods. Used in main to subtract amount of vaccines that have been distributed from CAvacM, CAvacP, and CAdoseJ. That means extra vaccines are remembered and can be distributed in the next distribution.
 public int findMAmount()
 {
   if (type.equals("Moderna"))
   {
     return vacAmount;
   }
   else
   {
     return 0;
   }
 }
 
 public int findPAmount()
 {
   if (type.equals("Pfizer"))
   {
     return vacAmount;
   }
   else
   {
     return 0;
   }
 }
 
 public int findJAmount()
 {
   if (type.equals("Johnson & Johnson"))
   {
     return vacAmount;
   }
   else
   {
     return 0;
   }
 }
 
 // similar to setAmount method. calculates vacAmount, but this time based on total population of counties of the same vaccine type rather than total population of California
 public void finalAmount(int Mpop, int Ppop, int Jpop, int CAvacM, int CAvacP, int CAdoseJ)
 {
   if (type.equals("Moderna"))
   {
     vacAmount = (int)((double)ppCounty/Mpop*CAvacM);
   }
   else if (type.equals("Pfizer"))
   {
     vacAmount = (int)((double)ppCounty/Ppop*CAvacP);
   }
   else if (type.equals("Johnson & Johnson"))
   {
     vacAmount = (int)((double)ppCounty/Jpop*CAdoseJ);
   }
 }
 
 // asks the user if each county has finished the current phase. calculatess the theoretical population of how many more people need to be vaccinated
 public void print()
 {
   Scanner in = new Scanner(System.in);
   if(!done)
   {
     if(type.equals("Moderna") || type.equals("Pfizer"))
     {
       vacAmount *= 2;
     }
     if ((type.equals("Moderna") || type.equals("Pfizer")) && (vacAmount > (2 * ppCounty)))
     {
       setvacAmount(2 * ppCounty);
     }
     if (type.equals("Johnson & Johnson") && (vacAmount > ppCounty))
     {
       setvacAmount(ppCounty);
     }
     System.out.println(name + " will be sent "+ vacAmount + " " + type + " vaccine(s).");
     if(type.equals("Moderna") || type.equals("Pfizer"))
     {
       ppCounty -= vacAmount/2;
     }
     else
     {
       ppCounty -= vacAmount;
     }
    
     // response is the first input
     String response = "";
     // temp is the input that checks the response
     String temp = "";
     while(!temp.equals("y"))
     {
       System.out.println("Records indicate around " + ppCounty + " people still need to be vaccinated for this phase. \nIs the county done with phase " + statePhase + "? (y/n)");
       response = in.nextLine();
       System.out.println("You said " + response + ". Is this correct? (y/n).");
       temp = in.nextLine();
     }
    
     if (response.equals("y"))
     { 
       //chance to end early if situation shows everyone is vaccinated and there are less people to vaccinate than expected due to overlap in phase qualifications.
       done = true;
       ppCounty = 0;
     }
    
     else
     {
       //chance to add to ppCounty if initial estimates were underestimated
       if (ppCounty == 0)
       {
         //checks if input is a number
         temp = "";
         boolean isNumber = true;
         while (!temp.equals("y") || !isNumber)
         {
           isNumber = true;
           System.out.println("How many more people need to be vaccinated for phase " + statePhase + " to be over?");
           response = in.nextLine();
           System.out.println("You said " + response + ". Is this correct? (y/n)");
           temp = in.nextLine();
           if (response.length() < 1)
           {
             System.out.println("Please input an actual number.");
             temp = "";
           }
           if (temp.equals("y"))
           {
             for(int i = 0; i<response.length() && isNumber; i++)
             {
               if (!(response.substring(i, i+1).equals("0") || response.substring(i, i+1).equals("1") || response.substring(i, i+1).equals("2") || response.substring(i, i+1).equals("3") || response.substring(i, i+1).equals("4") || response.substring(i, i+1).equals("5") || response.substring(i, i+1).equals("6") || response.substring(i, i+1).equals("7") || response.substring(i, i+1).equals("8") || response.substring(i, i+1).equals("9")))
               {
                 System.out.println("Please make sure your answer only contains digits 0 to 9.");
                 isNumber = false;
               }
               else
               {
                 isNumber = true;
               }
             }
             if(isNumber)
             {
               ppCounty = Integer.parseInt(response);
               inCase = true;
             }
           }
         }
       }
       else
       {
         inCase = false;
       }
       done = false;
     }
   }
 }
  // more specific distribution details for Orange County
 public void forOrange()
 {
   //first if condition ensures it doesn't run in the main method when recalculating for counties who seem done but aren't
   if(!(vacAmount == 0))
   {
     if (phase == 1 || phase == 3)
     {
       System.out.println("All " + vacAmount + " vaccines should be distributed amongst hospitals.");
     }
     else if (phase == 6)
     {
       System.out.println(vacAmount/2 + " vaccines should be sent to Santa Ana, Garden Grove, Midway City, Stanton, and Anaheim. The remaining " + vacAmount/2 + " vaccines should be distributed among the other 31 cities.");
     }
     else
     {
       System.out.println("Distribute the vaccines proportionally by population among the cities and centers.");
     }
   }
 }
 
 public static void main (String[] args)
 {
   Scanner in = new Scanner(System.in);
   Main county1 = new Main("Alameda");
   Main county2 = new Main("Alpine");
   Main county3 = new Main("Amador");
   Main county4 = new Main("Butte");
   Main county5 = new Main("Calaveras");
   Main county6 = new Main("Colusa");
   Main county7 = new Main("Contra Costa");
   Main county8 = new Main("Del Norte");
   Main county9 = new Main("El Dorado");
   Main county10 = new Main("Fresno");
   Main county11 = new Main("Glenn");
   Main county12 = new Main("Humboldt");
   Main county13 = new Main("Imperial");
   Main county14 = new Main("Inyo");
   Main county15 = new Main("Kern");
   Main county16 = new Main("Kings");
   Main county17 = new Main("Lake");
   Main county18 = new Main("Lassen");
   Main county19 = new Main("Los Angeles");
   Main county20 = new Main("Madera");
   Main county21 = new Main("Marin");
   Main county22 = new Main("Mariposa");
   Main county23 = new Main("Mendocino");
   Main county24 = new Main("Merced");
   Main county25 = new Main("Modoc");
   Main county26 = new Main("Mono");
   Main county27 = new Main("Monterey");
   Main county28 = new Main("Napa");
   Main county29 = new Main("Nevada");
   Main county30 = new Main("Orange");
   Main county31 = new Main("Placer");
   Main county32 = new Main("Plumas");
   Main county33 = new Main("Riverside");
   Main county34 = new Main("Riverside");
   Main county35 = new Main("Sacramento");
   Main county36 = new Main("San Benito");
   Main county37 = new Main("San Bernardino");
   Main county38 = new Main("San Diego");
   Main county39 = new Main("San Francisco");
   Main county40 = new Main("San Joaquin");
   Main county41 = new Main("San Luis Obispo");
   Main county42 = new Main("San Mateo");
   Main county43 = new Main("Santa Barbara");
   Main county44 = new Main("Santa Cruz");
   Main county45 = new Main("Shasta");
   Main county46 = new Main("Sierra");
   Main county47 = new Main("Siskiyou");
   Main county48 = new Main("Solano");
   Main county49 = new Main("Sonoma");
   Main county50 = new Main("Stanislaus");
   Main county51 = new Main("Sutter");
   Main county52 = new Main("Tehama");
   Main county53 = new Main("Trinity");
   Main county54 = new Main("Tulare");
   Main county55 = new Main("Tuolumne");
   Main county56 = new Main("Ventura");
   Main county57 = new Main("Yolo");
   Main county58 = new Main("Yuba");
  
   //Ensures the code continues until phase 7 is complete
   while (!(county1.getDone()
   && county2.getDone()
   && county3.getDone()
   && county4.getDone()
   && county5.getDone()
   && county2.getDone()
   && county3.getDone()
   && county4.getDone()
   && county6.getDone()
   && county7.getDone()
   && county8.getDone()
   && county9.getDone()
   && county10.getDone()
   && county11.getDone()
   && county12.getDone()
   && county13.getDone()
   && county14.getDone()
   && county15.getDone()
   && county16.getDone()
   && county17.getDone()
   && county18.getDone()
   && county19.getDone()
   && county20.getDone()
   && county21.getDone()
   && county22.getDone()
   && county23.getDone()
   && county24.getDone()
   && county25.getDone()
   && county26.getDone()
   && county27.getDone()
   && county28.getDone()
   && county29.getDone()
   && county30.getDone()
   && county31.getDone()
   && county32.getDone()
   && county33.getDone()
   && county34.getDone()
   && county35.getDone()
   && county36.getDone()
   && county37.getDone()
   && county38.getDone()
   && county39.getDone()
   && county40.getDone()
   && county41.getDone()
   && county42.getDone()
   && county43.getDone()
   && county44.getDone()
   && county45.getDone()
   && county46.getDone()
   && county47.getDone()
   && county48.getDone()
   && county49.getDone()
   && county50.getDone()
   && county51.getDone()
   && county52.getDone()
   && county53.getDone()
   && county54.getDone()
   && county55.getDone()
   && county56.getDone()
   && county57.getDone()
   && county58.getDone()
   ) ||
   !(county1.getPhase() == 7
   && county2.getPhase() == 7
   && county3.getPhase() == 7
   && county4.getPhase() == 7
   && county5.getPhase() == 7
   && county6.getPhase() == 7
   && county7.getPhase() == 7
   && county8.getPhase() == 7
   && county9.getPhase() == 7
   && county10.getPhase() == 7
   && county11.getPhase() == 7
   && county12.getPhase() == 7
   && county13.getPhase() == 7
   && county14.getPhase() == 7
   && county15.getPhase() == 7
   && county16.getPhase() == 7
   && county17.getPhase() == 7
   && county18.getPhase() == 7
   && county19.getPhase() == 7
   && county20.getPhase() == 7
   && county21.getPhase() == 7
   && county22.getPhase() == 7
   && county23.getPhase() == 7
   && county24.getPhase() == 7
   && county25.getPhase() == 7
   && county26.getPhase() == 7
   && county27.getPhase() == 7
   && county28.getPhase() == 7
   && county29.getPhase() == 7
   && county30.getPhase() == 7
   && county31.getPhase() == 7
   && county32.getPhase() == 7
   && county33.getPhase() == 7
   && county34.getPhase() == 7
   && county35.getPhase() == 7
   && county36.getPhase() == 7
   && county37.getPhase() == 7
   && county38.getPhase() == 7
   && county39.getPhase() == 7
   && county40.getPhase() == 7
   && county41.getPhase() == 7
   && county42.getPhase() == 7
   && county43.getPhase() == 7
   && county44.getPhase() == 7
   && county45.getPhase() == 7
   && county46.getPhase() == 7
   && county47.getPhase() == 7
   && county48.getPhase() == 7
   && county49.getPhase() == 7
   && county50.getPhase() == 7
   && county51.getPhase() == 7
   && county52.getPhase() == 7
   && county53.getPhase() == 7
   && county54.getPhase() == 7
   && county55.getPhase() == 7
   && county56.getPhase() == 7
   && county57.getPhase() == 7
   && county58.getPhase() == 7
   ))
   {
     //ensures the county's phase is set to the same as the state's
     county1.setPhase();
     county2.setPhase();
     county3.setPhase();
     county4.setPhase();
     county5.setPhase();
     county6.setPhase();
     county7.setPhase();
     county8.setPhase();
     county9.setPhase();
     county10.setPhase();
     county11.setPhase();
     county12.setPhase();
     county13.setPhase();
     county14.setPhase();
     county15.setPhase();
     county16.setPhase();
     county17.setPhase();
     county18.setPhase();
     county19.setPhase();
     county20.setPhase();
     county21.setPhase();
     county22.setPhase();
     county23.setPhase();
     county24.setPhase();
     county25.setPhase();
     county26.setPhase();
     county27.setPhase();
     county28.setPhase();
     county29.setPhase();
     county30.setPhase();
     county31.setPhase();
     county32.setPhase();
     county33.setPhase();
     county34.setPhase();
     county35.setPhase();
     county36.setPhase();
     county37.setPhase();
     county38.setPhase();
     county39.setPhase();
     county40.setPhase();
     county41.setPhase();
     county42.setPhase();
     county43.setPhase();
     county44.setPhase();
     county45.setPhase();
     county46.setPhase();
     county47.setPhase();
     county48.setPhase();
     county49.setPhase();
     county50.setPhase();
     county51.setPhase();
     county52.setPhase();
     county53.setPhase();
     county54.setPhase();
     county55.setPhase();
     county56.setPhase();
     county57.setPhase();
     county58.setPhase();
 
     //reminder of who constitutes each phase
     if (statePhase == 1)
     {
       System.out.println("Phase 1 consists solely of healthcare personel. Vaccines will only be sent and distributed to hospitals.");
     }
     if (statePhase == 2)
     {
       System.out.println("Phase 2 consists of long-term care residents and the elderly (age +65). Vaccines will be distributed throughout the county.");
     }
     if (statePhase == 3)
     {
       System.out.println("Phase 3 consists of people between the ages 16-65 that have pre-existing medical conditions. Vaccines will be distributed at hospitals.");
     }
     if (statePhase == 4)
     {
       System.out.println("Phase 4 consists of low-income families, those under the poverty line, the un- and underinsured, the incarcerated, and the homeless.");
     }
     if (statePhase == 5)
     {
       System.out.println("Phase 5 critical workers in industrial, commercial, manufacturing, transportation, and logistics. Vaccines will be distributed throughout the county.");
     }
     if (statePhase == 6)
     {
       System.out.println("Phase 6 consists of consists of all other critical workers such as those in professional and business services, leisure and hospitality, education and health, etc.");
     }
     if (statePhase == 7)
     {
       System.out.println("Phase 7 consists of the general public who have yet to be vaccinated.");
     }
 
     //asks for user input for approximate amount of people in current phase
     county1.setppCounty();
     county2.setppCounty();
     county3.setppCounty();
     county4.setppCounty();
     county5.setppCounty();
     county6.setppCounty();
     county7.setppCounty();
     county8.setppCounty();
     county9.setppCounty();
     county10.setppCounty();
     county11.setppCounty();
     county12.setppCounty();
     county13.setppCounty();
     county14.setppCounty();
     county15.setppCounty();
     county16.setppCounty();
     county17.setppCounty();
     county18.setppCounty();
     county19.setppCounty();
     county20.setppCounty();
     county21.setppCounty();
     county22.setppCounty();
     county23.setppCounty();
     county24.setppCounty();
     county25.setppCounty();
     county26.setppCounty();
     county27.setppCounty();
     county28.setppCounty();
     county29.setppCounty();
     county30.setppCounty();
     county31.setppCounty();
     county32.setppCounty();
     county33.setppCounty();
     county34.setppCounty();
     county35.setppCounty();
     county36.setppCounty();
     county37.setppCounty();
     county38.setppCounty();
     county39.setppCounty();
     county40.setppCounty();
     county41.setppCounty();
     county42.setppCounty();
     county43.setppCounty();
     county44.setppCounty();
     county45.setppCounty();
     county46.setppCounty();
     county47.setppCounty();
     county48.setppCounty();
     county49.setppCounty();
     county50.setppCounty();
     county51.setppCounty();
     county52.setppCounty();
     county53.setppCounty();
     county54.setppCounty();
     county55.setppCounty();
     county56.setppCounty();
     county57.setppCounty();
     county58.setppCounty();
 
     //ensures every county is done with the phase before any county or the state can move on to next phase.
     while(!(county1.getDone() && county2.getDone() && county3.getDone() && county4.getDone() &&county5.getDone() && county6.getDone() && county7.getDone() && county8.getDone() && county9.getDone() && county10.getDone() && county11.getDone() && county12.getDone() && county13.getDone() && county14.getDone() && county15.getDone() && county16.getDone() && county17.getDone() && county18.getDone() && county19.getDone() && county20.getDone() && county21.getDone() && county22.getDone() && county23.getDone() && county24.getDone() && county25.getDone() && county26.getDone() && county27.getDone() && county28.getDone() && county29.getDone() && county30.getDone() && county31.getDone() && county32.getDone() && county33.getDone() && county34.getDone() && county35.getDone() && county36.getDone() && county37.getDone() && county38.getDone() && county39.getDone() && county40.getDone() && county41.getDone() && county42.getDone() && county43.getDone() && county44.getDone() && county45.getDone() && county46.getDone() && county47.getDone() && county48.getDone() && county49.getDone() && county50.getDone() && county51.getDone() && county52.getDone() && county53.getDone() && county54.getDone() && county55.getDone() && county56.getDone() && county57.getDone() && county58.getDone()) || !(county1.getPhase() == statePhase && county2.getPhase() == statePhase && county3.getPhase() == statePhase && county4.getPhase() == statePhase && county5.getPhase() == statePhase && county6.getPhase() == statePhase && county7.getPhase() == statePhase && county8.getPhase() == statePhase && county9.getPhase() == statePhase && county10.getPhase() == statePhase && county11.getPhase() == statePhase && county12.getPhase() == statePhase && county13.getPhase() == statePhase && county14.getPhase() == statePhase && county15.getPhase() == statePhase && county16.getPhase() == statePhase && county17.getPhase() == statePhase && county18.getPhase() == statePhase && county19.getPhase() == statePhase && county20.getPhase() == statePhase && county21.getPhase() == statePhase && county22.getPhase() == statePhase && county23.getPhase() == statePhase && county24.getPhase() == statePhase && county25.getPhase() == statePhase && county26.getPhase() == statePhase && county27.getPhase() == statePhase && county28.getPhase() == statePhase && county29.getPhase() == statePhase && county30.getPhase() == statePhase && county31.getPhase() == statePhase && county32.getPhase() == statePhase && county33.getPhase() == statePhase && county34.getPhase() == statePhase && county35.getPhase() == statePhase && county36.getPhase() == statePhase && county37.getPhase() == statePhase && county38.getPhase() == statePhase && county39.getPhase() == statePhase && county40.getPhase() == statePhase && county41.getPhase() == statePhase && county42.getPhase() == statePhase && county43.getPhase() == statePhase && county44.getPhase() == statePhase && county45.getPhase() == statePhase && county46.getPhase() == statePhase && county47.getPhase() == statePhase && county48.getPhase() == statePhase && county49.getPhase() == statePhase && county50.getPhase() == statePhase && county51.getPhase() == statePhase && county52.getPhase() == statePhase && county53.getPhase() == statePhase && county54.getPhase() == statePhase && county55.getPhase() == statePhase && county56.getPhase() == statePhase && county57.getPhase() == statePhase && county58.getPhase() == statePhase))
     {
       // asking for how many of each vaccine is in the batch
       Main.howMany();
      
       MtypeCalc = CAdoseM;
       PtypeCalc = CAdoseP;
       JtypeCalc = CAdoseJ;
 
       // calculates the total amount of people California is able to vaccinate, used to pass as into method
       int CAtotalDose = CAdoseM + CAdoseP + CAdoseJ;
 
       // calculates the total population of california in the current phase
       int CAtotalppp = county1.getppCounty() + county2.getppCounty() + county3.getppCounty() + county4.getppCounty() + county5.getppCounty() + county6.getppCounty() + county7.getppCounty() + county8.getppCounty() + county9.getppCounty() + county10.getppCounty() + county11.getppCounty() + county12.getppCounty() + county13.getppCounty() + county14.getppCounty() + county15.getppCounty() + county16.getppCounty() + county17.getppCounty() + county18.getppCounty() + county19.getppCounty() + county20.getppCounty() + county21.getppCounty() + county22.getppCounty() + county23.getppCounty() + county24.getppCounty() + county25.getppCounty() + county26.getppCounty() + county27.getppCounty() + county28.getppCounty() + county29.getppCounty() + county30.getppCounty() + county31.getppCounty() + county32.getppCounty() + county33.getppCounty() + county34.getppCounty() + county35.getppCounty() + county36.getppCounty() + county37.getppCounty() + county38.getppCounty() + county39.getppCounty() + county40.getppCounty() + county41.getppCounty() + county42.getppCounty() + county43.getppCounty() + county44.getppCounty() + county45.getppCounty() + county46.getppCounty() + county47.getppCounty() + county48.getppCounty() + county49.getppCounty() + county50.getppCounty() + county51.getppCounty() + county52.getppCounty() + county53.getppCounty() + county54.getppCounty() + county55.getppCounty() + county56.getppCounty() + county57.getppCounty() + county58.getppCounty();
      
       // calculates roughly how many "doses" each county recieves based on population
       county1.setAmount(CAtotalppp, CAtotalDose);
       county2.setAmount(CAtotalppp, CAtotalDose);
       county3.setAmount(CAtotalppp, CAtotalDose);
       county4.setAmount(CAtotalppp, CAtotalDose);
       county5.setAmount(CAtotalppp, CAtotalDose);
       county6.setAmount(CAtotalppp, CAtotalDose);
       county7.setAmount(CAtotalppp, CAtotalDose);
       county8.setAmount(CAtotalppp, CAtotalDose);
       county9.setAmount(CAtotalppp, CAtotalDose);
       county10.setAmount(CAtotalppp, CAtotalDose);
       county11.setAmount(CAtotalppp, CAtotalDose);
       county12.setAmount(CAtotalppp, CAtotalDose);
       county13.setAmount(CAtotalppp, CAtotalDose);
       county14.setAmount(CAtotalppp, CAtotalDose);
       county15.setAmount(CAtotalppp, CAtotalDose);
       county16.setAmount(CAtotalppp, CAtotalDose);
       county17.setAmount(CAtotalppp, CAtotalDose);
       county18.setAmount(CAtotalppp, CAtotalDose);
       county19.setAmount(CAtotalppp, CAtotalDose);
       county20.setAmount(CAtotalppp, CAtotalDose);
       county21.setAmount(CAtotalppp, CAtotalDose);
       county22.setAmount(CAtotalppp, CAtotalDose);
       county23.setAmount(CAtotalppp, CAtotalDose);
       county24.setAmount(CAtotalppp, CAtotalDose);
       county25.setAmount(CAtotalppp, CAtotalDose);
       county26.setAmount(CAtotalppp, CAtotalDose);
       county27.setAmount(CAtotalppp, CAtotalDose);
       county28.setAmount(CAtotalppp, CAtotalDose);
       county29.setAmount(CAtotalppp, CAtotalDose);
       county30.setAmount(CAtotalppp, CAtotalDose);
       county31.setAmount(CAtotalppp, CAtotalDose);
       county32.setAmount(CAtotalppp, CAtotalDose);
       county33.setAmount(CAtotalppp, CAtotalDose);
       county34.setAmount(CAtotalppp, CAtotalDose);
       county35.setAmount(CAtotalppp, CAtotalDose);
       county36.setAmount(CAtotalppp, CAtotalDose);
       county37.setAmount(CAtotalppp, CAtotalDose);
       county38.setAmount(CAtotalppp, CAtotalDose);
       county39.setAmount(CAtotalppp, CAtotalDose);
       county40.setAmount(CAtotalppp, CAtotalDose);
       county41.setAmount(CAtotalppp, CAtotalDose);
       county42.setAmount(CAtotalppp, CAtotalDose);
       county43.setAmount(CAtotalppp, CAtotalDose);
       county44.setAmount(CAtotalppp, CAtotalDose);
       county45.setAmount(CAtotalppp, CAtotalDose);
       county46.setAmount(CAtotalppp, CAtotalDose);
       county47.setAmount(CAtotalppp, CAtotalDose);
       county48.setAmount(CAtotalppp, CAtotalDose);
       county49.setAmount(CAtotalppp, CAtotalDose);
       county50.setAmount(CAtotalppp, CAtotalDose);
       county51.setAmount(CAtotalppp, CAtotalDose);
       county52.setAmount(CAtotalppp, CAtotalDose);
       county53.setAmount(CAtotalppp, CAtotalDose);
       county54.setAmount(CAtotalppp, CAtotalDose);
       county55.setAmount(CAtotalppp, CAtotalDose);
       county56.setAmount(CAtotalppp, CAtotalDose);
       county57.setAmount(CAtotalppp, CAtotalDose);
       county58.setAmount(CAtotalppp, CAtotalDose);
 
       // assigns each county a type of vaccine
       county1.setType();
       county2.setType();
       county3.setType();
       county4.setType();
       county5.setType();
       county6.setType();
       county7.setType();
       county8.setType();
       county9.setType();
       county10.setType();
       county11.setType();
       county12.setType();
       county13.setType();
       county14.setType();
       county15.setType();
       county16.setType();
       county17.setType();
       county18.setType();
       county19.setType();
       county20.setType();
       county21.setType();
       county22.setType();
       county23.setType();
       county24.setType();
       county25.setType();
       county26.setType();
       county27.setType();
       county28.setType();
       county29.setType();
       county30.setType();
       county31.setType();
       county32.setType();
       county33.setType();
       county34.setType();
       county35.setType();
       county36.setType();
       county37.setType();
       county38.setType();
       county39.setType();
       county40.setType();
       county41.setType();
       county42.setType();
       county43.setType();
       county44.setType();
       county45.setType();
       county46.setType();
       county47.setType();
       county48.setType();
       county49.setType();
       county50.setType();
       county51.setType();
       county52.setType();
       county53.setType();
       county54.setType();
       county55.setType();
       county56.setType();
       county57.setType();
       county58.setType();
 
       // adds all the same vaccine county populations together. Used to recalculate how much each county should get.
       int Mpop = county1.findMpop() + county2.findMpop() + county3.findMpop() +
       county4.findMpop() + county5.findMpop() + county6.findMpop() +
       county7.findMpop() + county8.findMpop() + county9.findMpop() +
       county10.findMpop() + county11.findMpop() + county12.findMpop() +
       county13.findMpop() + county14.findMpop() + county15.findMpop() +
       county16.findMpop() + county17.findMpop() + county18.findMpop() +
       county19.findMpop() + county20.findMpop() + county21.findMpop() +
       county22.findMpop() + county23.findMpop() + county24.findMpop() +
       county25.findMpop() + county26.findMpop() + county27.findMpop() +
       county28.findMpop() + county29.findMpop() + county30.findMpop() +
       county31.findMpop() + county32.findMpop() + county33.findMpop() +
       county34.findMpop() + county35.findMpop() + county36.findMpop() +
       county37.findMpop() + county38.findMpop() + county39.findMpop() +
       county40.findMpop() + county41.findMpop() + county42.findMpop() +
       county43.findMpop() + county44.findMpop() + county45.findMpop() +
       county46.findMpop() + county47.findMpop() + county48.findMpop() +
       county49.findMpop() + county50.findMpop() + county51.findMpop() +
       county52.findMpop() + county53.findMpop() + county54.findMpop() +
       county55.findMpop() + county56.findMpop() + county57.findMpop() +
       county58.findMpop();
        
       int Ppop = county1.findPpop() + county2.findPpop() + county3.findPpop() +
       county4.findPpop() + county5.findPpop() + county6.findPpop() +
       county7.findPpop() + county8.findPpop() + county9.findPpop() +
       county10.findPpop() + county11.findPpop() + county12.findPpop() +
       county13.findPpop() + county14.findPpop() + county15.findPpop() +
       county16.findPpop() + county17.findPpop() + county18.findPpop() +
       county19.findPpop() + county20.findPpop() + county21.findPpop() +
       county22.findPpop() + county23.findPpop() + county24.findPpop() +
       county25.findPpop() + county26.findPpop() + county27.findPpop() +
       county28.findPpop() + county29.findPpop() + county30.findPpop() +
       county31.findPpop() + county32.findPpop() + county33.findPpop() +
       county34.findPpop() + county35.findPpop() + county36.findPpop() +
       county37.findPpop() + county38.findPpop() + county39.findPpop() +
       county40.findPpop() + county41.findPpop() + county42.findPpop() +
       county43.findPpop() + county44.findPpop() + county45.findPpop() +
       county46.findPpop() + county47.findPpop() + county48.findPpop() +
       county49.findPpop() + county50.findPpop() + county51.findPpop() +
       county52.findPpop() + county53.findPpop() + county54.findPpop() +
       county55.findPpop() + county56.findPpop() + county57.findPpop() +
       county58.findPpop();
        
       int Jpop = county1.findJpop() + county2.findJpop() + county3.findJpop() +
       county4.findJpop() + county5.findJpop() + county6.findJpop() +
       county7.findJpop() + county8.findJpop() + county9.findJpop() +
       county10.findJpop() + county11.findJpop() + county12.findJpop() +
       county13.findJpop() + county14.findJpop() + county15.findJpop() +
       county16.findJpop() + county17.findJpop() + county18.findJpop() +
       county19.findJpop() + county20.findJpop() + county21.findJpop() +
       county22.findJpop() + county23.findJpop() + county24.findJpop() +
       county25.findJpop() + county26.findJpop() + county27.findJpop() +
       county28.findJpop() + county29.findJpop() + county30.findJpop() +
       county31.findJpop() + county32.findJpop() + county33.findJpop() +
       county34.findJpop() + county35.findJpop() + county36.findJpop() +
       county37.findJpop() + county38.findJpop() + county39.findJpop() +
       county40.findJpop() + county41.findJpop() + county42.findJpop() +
       county43.findJpop() + county44.findJpop() + county45.findJpop() +
       county46.findJpop() + county47.findJpop() + county48.findJpop() +
       county49.findJpop() + county50.findJpop() + county51.findJpop() +
       county52.findJpop() + county53.findJpop() + county54.findJpop() +
       county55.findJpop() + county56.findJpop() + county57.findJpop() +
       county58.findJpop();
 
       // calculates the number of vaccines sent to the county by vac type 
       county1.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county2.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county3.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county4.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county5.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county6.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county7.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county8.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county9.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county10.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county11.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county12.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county13.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county14.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county15.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county16.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county17.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county18.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county19.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county20.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county21.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county22.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county23.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county24.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county25.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county26.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county27.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county28.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county29.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county30.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county31.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county32.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county33.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county34.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county35.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county36.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county37.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county38.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county39.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county40.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county41.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county42.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county43.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county44.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county45.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county46.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county47.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county48.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county49.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county50.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county51.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county52.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county53.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county54.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county55.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county56.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county57.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
       county58.finalAmount(Mpop, Ppop, Jpop, CAdoseM, CAdoseP, CAdoseJ);
 
       // declares how many vaccines Califonia has before distribution
       System.out.println("California currently has " + CAvacM + " Moderna vaccines.");
       System.out.println("California currently has " + CAvacP + " Pfizer vaccines.");
       System.out.println("California currently has " + CAdoseJ + " Johnson & Johnson vaccines.");
      
       // asks each county if they are done with the current phase. Will also announce the theoretical population that still needs to be vaccinated.
       county1.print();
       county2.print();
       county3.print();
       county4.print();
       county5.print();
       county6.print();
       county7.print();
       county8.print();
       county9.print();
       county10.print();
       county11.print();
       county12.print();
       county13.print();
       county14.print();
       county15.print();
       county16.print();
       county17.print();
       county18.print();
       county19.print();
       county20.print();
       county21.print();
       county22.print();
       county23.print();
       county24.print();
       county25.print();
       county26.print();
       county27.print();
       county28.print();
       county29.print();
       county30.print();
       // Orange County Specific Method for distribution
       county30.forOrange();
       county31.print();
       county32.print();
       county33.print();
       county34.print();
       county35.print();
       county36.print();
       county37.print();
       county38.print();
       county39.print();
       county40.print();
       county41.print();
       county42.print();
       county43.print();
       county44.print();
       county45.print();
       county46.print();
       county47.print();
       county48.print();
       county49.print();
       county50.print();
       county51.print();
       county52.print();
       county53.print();
       county54.print();
       county55.print();
       county56.print();
       county57.print();
       county58.print();
      
       // subtract all same vaccines that were distributed from the California total
       CAvacM -= county1.findMAmount() + county2.findMAmount() + county3.findMAmount() + county4.findMAmount() + county5.findMAmount() + county6.findMAmount() + county7.findMAmount() + county8.findMAmount() + county9.findMAmount() + county10.findMAmount() + county11.findMAmount() + county12.findMAmount() + county13.findMAmount() + county14.findMAmount() + county15.findMAmount() + county16.findMAmount() + county17.findMAmount() + county18.findMAmount() + county19.findMAmount() + county20.findMAmount() + county21.findMAmount() + county22.findMAmount() + county23.findMAmount() + county24.findMAmount() + county25.findMAmount() + county26.findMAmount() + county27.findMAmount() + county28.findMAmount() + county29.findMAmount() + county30.findMAmount() + county31.findMAmount() + county32.findMAmount() + county33.findMAmount() + county34.findMAmount() + county35.findMAmount() + county36.findMAmount() + county37.findMAmount() + county38.findMAmount() + county39.findMAmount() + county40.findMAmount() + county41.findMAmount() + county42.findMAmount() + county43.findMAmount() + county44.findMAmount() + county45.findMAmount() + county46.findMAmount() + county47.findMAmount() + county48.findMAmount() + county49.findMAmount() + county50.findMAmount() + county51.findMAmount() + county52.findMAmount() + county53.findMAmount() + county54.findMAmount() + county55.findMAmount() + county56.findMAmount() + county57.findMAmount() + county58.findMAmount();
 
       CAvacP -= county1.findPAmount() + county2.findPAmount() + county3.findPAmount() + county4.findPAmount() + county5.findPAmount() + county6.findPAmount() + county7.findPAmount() + county8.findPAmount() + county9.findPAmount() + county10.findPAmount() + county11.findPAmount() + county12.findPAmount() + county13.findPAmount() + county14.findPAmount() + county15.findPAmount() + county16.findPAmount() + county17.findPAmount() + county18.findPAmount() + county19.findPAmount() + county20.findPAmount() + county21.findPAmount() + county22.findPAmount() + county23.findPAmount() + county24.findPAmount() + county25.findPAmount() + county26.findPAmount() + county27.findPAmount() + county28.findPAmount() + county29.findPAmount() + county30.findPAmount() + county31.findPAmount() + county32.findPAmount() + county33.findPAmount() + county34.findPAmount() + county35.findPAmount() + county36.findPAmount() + county37.findPAmount() + county38.findPAmount() + county39.findPAmount() + county40.findPAmount() + county41.findPAmount() + county42.findPAmount() + county43.findPAmount() + county44.findPAmount() + county45.findPAmount() + county46.findPAmount() + county47.findPAmount() + county48.findPAmount() + county49.findPAmount() + county50.findPAmount() + county51.findPAmount() + county52.findPAmount() + county53.findPAmount() + county54.findPAmount() + county55.findPAmount() + county56.findPAmount() + county57.findPAmount() + county58.findPAmount();
      
       CAdoseJ -= county1.findJAmount() + county2.findJAmount() + county3.findJAmount() + county4.findJAmount() + county5.findJAmount() + county6.findJAmount() + county7.findJAmount() + county8.findJAmount() + county9.findJAmount() + county10.findJAmount() + county11.findJAmount() + county12.findJAmount() + county13.findJAmount() + county14.findJAmount() + county15.findJAmount() + county16.findJAmount() + county17.findJAmount() + county18.findJAmount() + county19.findJAmount() + county20.findJAmount() + county21.findJAmount() + county22.findJAmount() + county23.findJAmount() + county24.findJAmount() + county25.findJAmount() + county26.findJAmount() + county27.findJAmount() + county28.findJAmount() + county29.findJAmount() + county30.findJAmount() + county31.findJAmount() + county32.findJAmount() + county33.findJAmount() + county34.findJAmount() + county35.findJAmount() + county36.findJAmount() + county37.findJAmount() + county38.findJAmount() + county39.findJAmount() + county40.findJAmount() + county41.findJAmount() + county42.findJAmount() + county43.findJAmount() + county44.findJAmount() + county45.findJAmount() + county46.findJAmount() + county47.findJAmount() + county48.findJAmount() + county49.findJAmount() + county50.findJAmount() + county51.findJAmount() + county52.findJAmount() + county53.findJAmount() + county54.findJAmount() + county55.findJAmount() + county56.findJAmount() + county57.findJAmount() + county58.findJAmount();
        
       // prints how many of each type of vaccine california has left after distribution
       System.out.println("California currently has " + CAvacM + " Moderna vaccines. This is enough for " + CAvacM/2 + " people.");
       System.out.println("California currently has " + CAvacP + " Pfizer vaccines. This is enough for " + CAvacP/2 + " people.");
       System.out.println("California currently has " + CAdoseJ + " Johnson & Johnson vaccines. This is enough for " + CAdoseJ + " people.");
 
       // if says not finished with phase when theoretical population number is 0, and this is holding the state back from proceeding to the next phase when there are vaccines available, immediately distributes remaining vaccines
       if(inCase && (CAvacM > 1 || CAvacP > 1 || CAdoseJ > 0))
       {
         System.out.println("Please answer the following questions immediately. Answer \"0\" for the next three questions.");
       }
       else
       {
         System.out.println("If there are more than 58 people's worth of vaccine left and counties that have yet to finish with phase " + statePhase + ", please answer the following questions immediately with \"0\" in order to distribute the rest of the vaccines. Otherwise, please answer the following questions once you get the next batch of vaccines:");
       }
     }
       // when all counties are finished with the current phase, the statePhase will increase by one, and all counties' phase will be reassigned
       statePhase++;
   }
   // when phase 7 is finished, then the vaccine distribution has also finished
   System.out.println("Just kidding. No more questions! Congratulations--California is vaccinated!");
 }
}
