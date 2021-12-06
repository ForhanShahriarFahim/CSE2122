import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList 
{
	public static void main(String[] args) 
	{
		Constants constant = new Constants();

		//Check arguments
	    //if the arguments is not given or given string's length is greater than 1 then it will not terminate 

		if(args.length == 0 || args.length > 1)
		{
			System.out.println("Program terminated.\nPlease Enter a valid argument");
			return;
		}

		//if the argument is a then it will show all the student list

		else if(args[0].equals(constant.showAll)) 
		{
			System.out.println(constant.dLoading);			
			try 
			{
				String fullLine = loadData(constant.studentList);
				String studentNames[] = fullLine.split(constant.StudentEntryDelimite);			
				for(String student : studentNames) 
				{ 
					System.out.println(student);
				}
			} 
			catch (Exception exception)
			{

			} 
			System.out.println(constant.dLoaded);
		}

		//if the argument is r then it will show a random string from studentlist

		else if(args[0].equals(constant.showRandom)) 
		{
			System.out.println(constant.dLoading);			
			try 
			{
				String fullLine = loadData(constant.studentList);		
				String studentNames[] = fullLine.split(constant.StudentEntryDelimite);	
				Random random = new Random();
				int output = random.nextInt(studentNames.length);
				System.out.println(studentNames[output]);
				} 
			catch (Exception exception)
			{

			} 
			System.out.println(constant.dLoaded);			
		}

		//if the argument is '+' then it will add a string into the student list text file.

		else if(args[0].contains(constant.addEntry))
		{
			System.out.println(constant.dLoading);			
			try 
			{
				BufferedWriter bufferReader = new BufferedWriter(new FileWriter(constant.studentList, true));
				String addStudent  = args[0].substring(1);
				Date date  = new Date();
				String dateFormate = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(dateFormate);
				String formateDate = dateFormat.format(date );
				bufferReader.write(", "+addStudent +"\nList last updated on "+formateDate);
				bufferReader.close();
			} 
			catch (Exception exception)
			{

			}
							
			System.out.println(constant.dLoaded);	
		}

		//if argument is 'c' then it will count total string number from the studentlist txt

		else if(args[0].contains(constant.findEntry)) 
		{
			System.out.println(constant.dLoading);			
			try 
			{
				String fullLine = loadData(constant.studentList);
				String studentNames[] = fullLine.split(constant.StudentEntryDelimite);	
				boolean done = false;
				String addStudent = args[0].substring(1);
				for(int idx = 0; idx<studentNames.length && !done; idx++) 
				{
					if(studentNames[idx].equals(addStudent)) 
					{
						System.out.println("We found it!");
						done = true;
					}
				}
			} 
			catch (Exception exception)
			{

			} 
			System.out.println(constant.dLoaded);				
		}

		//if the argument is not equal to above's then it will show Invalid arguments

		else if(args[0].contains(constant.showCount)) 
		{
			System.out.println(constant.dLoading);			
			try 
			{
				String reader = loadData(constant.studentList);
				String input[] = reader.split(constant.StudentEntryDelimite);
				char charArray[] = reader.toCharArray();			
				boolean in_word = false;
				int count = 0;
				for(char gap:charArray) 
				{
					if(gap == ' ') 
					{
						if (!in_word) 
						{	
							count++;
							in_word = true;
						}
						else 
						{
							in_word = false;
						}			
					}
				}
				System.out.println(count +" word(s) found ");
			} 
			catch (Exception exception)
			{

			} 
			System.out.println(constant.dLoaded);				
		}
		else 
		{
			System.out.println("Wrong argument");
		}
	}

	//here we created a method called loadname where we done the file streaming part 
	//and later used it when we needed to read file

	public static String loadData(String filename)
	{
		try
		{
			BufferedReader fileStream = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			String line = fileStream.readLine();
			return line;
		}
		catch(Exception e)
		{

		}
		return "";
	}
}