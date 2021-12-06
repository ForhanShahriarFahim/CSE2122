import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList 
{
	public static void main(String[] args) 
	{

//		Check arguments
		if(args.length == 0 || args.length > 1)
		{
			System.out.println("Program terminated.\nPlease Enter a valid argument");
			return;
		}
		else if(args[0].equals("a")) 
		{
			System.out.println("Loading data ...");			
			try 
			{
				BufferedReader bufferReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String fullLine  = bufferReader.readLine();
				String studentNames[] = fullLine .split(",");			
				for(String student : studentNames) 
				{ 
					System.out.println(student);
				}
			} 
			catch (Exception exception)
			{

			} 
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) 
		{
			System.out.println("Loading data ...");			
			try 
			{
				BufferedReader bufferReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String fullLine  = bufferReader.readLine();			
				String studentNames[] = fullLine .split(", ");	
				Random random = new Random();
				int output = random.nextInt(studentNames.length);
				System.out.println(studentNames[output]);
				} 
			catch (Exception exception)
			{

			} 
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+"))
		{
			System.out.println("Loading data ...");			
			try 
			{
				BufferedWriter bufferReader = new BufferedWriter(new FileWriter("students.txt", true));
				String addStudent  = args[0].substring(1);
				Date date  = new Date();
				String dateFormate = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(dateFormate);
				String formateDate= dateFormat.format(date );
				bufferReader.write(", "+addStudent +"\nList last updated on "+formateDate);
				bufferReader.close();
			} 
			catch (Exception exception)
			{

			}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			
			try 
			{
				BufferedReader bufferReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String fullLine  = bufferReader.readLine();
				String studentNames[] = fullLine .split(", ");	
				boolean done = false;
				String addStudent = args[0].substring(1);
				for(int idx = 0; idx<studentNames.length && !done; idx++) 
				{
					if(studentNames[idx].equals(addStudent)) 
					{
						System.out.println("We found it!");
						done=true;
					}
				}
			} 
			catch (Exception exception)
			{

			} 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");			
			try 
			{
				BufferedReader bufferReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String reader = bufferReader.readLine();
				char charArray[] = reader.toCharArray();			
				boolean in_word = false;
				int count=0;
				for(char gap:charArray) 
				{
					if(gap ==' ') 
					{
						if (!in_word) 
						{	
							count++;
							in_word =true;
						}
						else 
						{
							in_word=false;
						}			
					}
				}
				System.out.println(count +" word(s) found ");
			} 
			catch (Exception exception)
			{

			} 
			System.out.println("Data Loaded.");				
		}
		else 
		{
			System.out.println("Wrong argument");
		}
	}
}