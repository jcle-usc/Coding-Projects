/*
import java.io.*; //file stuff
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Tester
{  
    public static void main (String[] args) throws IOException
    {
        try
        {
            String inputFileName = args[0]; //args[0] takes the first {"file"}; sampleGraphics.java
            String inputScale = args[1]; //args[1] takes the second {"scale"}; 150
            int scaleNum = Integer.parseInt(inputScale);
            //Double scaleNum = Double.parseDouble(inputScale); //turns it into a percentage
            //if the input is anything other than the name of the txt file, goes to the "catch"
            File myfile = new File(inputFileName);
            Scanner filereader = new Scanner(myfile);

            String baseName = inputFileName.substring(0, inputFileName.lastIndexOf(".")); //SampleGraphics
            String java = inputFileName.substring(inputFileName.lastIndexOf("."), inputFileName.length()); //.java

            String fileName = baseName + "Scaled" + java; 

            FileWriter fw = new FileWriter(fileName);
            PrintWriter output = new PrintWriter (fw);

            String[] whitelist = {"win.setSize","g.fillRect","windowPos",
                    "stepPos","presentPos","presentHeight","nextPresent",
                    "trunk","size","g.fillOval","xRandom","yRandom","xrandom",
                    "yrandom","nextPanel","treeHeight","treeLength","xPos",
                    "yPos","middle","right","top","left","bottom","addPoint",
                    "leftPos","rightPos","height","adjust","h1","h2","h3","x1",
                    "x2","x3","x4","x5","t1","t2","t3","t4","t5"};

            String[] blacklistNumbers = {"h1","h2","h3","x1","x2","x3","x4","x5","t1",
                    "t2","t3","t4","t5"}; //i shouldn't have made variables with numbers looking back..≥

            String[] blacklist = {"topWindows","bottomWindows","sizeRandom"}; //variables that contain whitelist words but don't need to be scaled
            //ex. whitelist "top" is counted in topWindows, when topWindows needs to be blacklisted
                    
            while (filereader.hasNext())
            {
                String input = filereader.nextLine(); //takes the next entire line
                if (input.contains("//")) // cuts the remarks since some of them contain whitelist words (oops)
                {
                    input = input.substring(0, (input.indexOf("//")));                    
                }
                input = input.replace(baseName, baseName + "Scaled"); //replaces the class name with the new "Scaled" name, will repeat through the whole while loop but the fileName only appears once
                /* if (input.equals(inputFileName))
                {
                result += "Scaled";
                i -= 6;
                }             
                String result = ""; //new String to rebuild sentence(s)

                boolean lineContainsWhitelist = false;
                for (String list : whitelist)
                {
                    if (input.contains(list))
                    {
                        lineContainsWhitelist = true;
                    }
                }

                boolean lineContainsBlackListNumbers = false;
                for (String list : blacklistNumbers)
                {
                    if (input.contains(list))
                    {
                        lineContainsBlackListNumbers = true;
                    }
                }
                
                boolean lineContainsBlackList = false;
                for (String list : blacklist)
                {
                    if (input.contains(list))
                    {
                        lineContainsBlackList = true;
                    }
                }

                if (lineContainsWhitelist && !lineContainsBlackList)
                {
                    String numbers[] = input.split("[\\D]+"); //array of only numbers, removing the String

                    int index = 1; //start w/ 1 since the first element of numbers[] is an empty string
                    for (int i = 0; i < input.length(); i++) //goes through each character of the line
                    {                
                        char c = input.charAt(i); //converts the String into characters

                        if (Character.isDigit(c)) //if the character is a number
                        {
                            int num = Integer.parseInt(numbers[index]); //turns the String numbers array into an int
                            //System.out.println("num before: " + num);

                            if (lineContainsBlackListNumbers && num <= 5) //ignore the digits that are less than 5 (the actual numbers that need to be scaled are greater than 6, less are just variables)
                            {
                                result += input.charAt(i);
                                index++;
                                continue;
                            }

                            num *= scaleNum; //multiply the number by the scaler
                            num /= 100; //divide by 100
                            num = (int)Math.round(num); //rounds to an int since JFrame doesn't take doubles
                            //the numbers in my code are very specific so sometimes it makes the graphic look off (the trunk connects to the tree if its scale 50, but disconnects at scale 75 or the presents at the bottom don't show entirely)
                            //the scaling math itself is still correct though
                            //System.out.println("num after: " + num);

                            result += num; //adds the scaled num to the new sentence
                            //System.out.println("resultDigit: " + result);
                            //System.out.println("i: " + i);

                            //numbers[index] = Integer.toString(num); //revert the new number back into an integer

                            //System.out.println("number length: " + numbers[index].length());
                            i += numbers[index].length() - 1; //to keep the i index in the correct spot

                            index++; //go to the next number that was split in the numbers[] array
                            //System.out.println("index: " + index);
                        }
                        else //if the character is not a number
                        {
                            result += input.charAt(i); //simply add the character to the new sentence
                            //System.out.println("resultNotDigit: " + result);
                            //System.out.println("i: " + i);
                        }
                    }
                    //debug
                    /*
                    for (int i = 0; i < numbers.length; i++) 
                    {
                    System.out.println(i + ": " + numbers[i]);
                    }
                     
                }
                else //if the line does not contain the whitelist
                {
                    result += input; //simply add the character to the new sentence
                }

                output.println(result);
            }

            filereader.close();
            output.close();
            fw.close();
        }

        catch (IOException e)
        {
            System.out.println("File not found error!");
        }
    }
}
*/