package com.org.virtualkeyforrepositories;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Application {
	
	public static void getFileList()
	{
		Scanner s1=new Scanner(System.in);
		try
		{
			System.out.println("Enter Directory path:");
			String s=s1.nextLine();
			File f1=new File(s);
			//checking whether user provided valid directory or not
			if(f1.isDirectory()==true)
			{
				String l[]=f1.list();
				ArrayList<String> list=new ArrayList<String>(Arrays.asList(l));
				//using selection sort to sort the filenames in ascending order
				if(list.size()>0)
				{
					for(int i=0;i<list.size()-1;i++)
					{
						String temp1=list.get(i);
						int index=i;
				        for(int j=i+1;j<list.size();j++)
				        {
				        	String temp2=list.get(j);
				        	if(temp2.compareTo(temp1)<0)
				            {
				        		temp1=temp2;
				        		index=j;
				            }
				        }
				        if(index!=i)
				        {
				        	String temp3=list.get(i);
				        	list.set(index, temp3);
				        	list.set(i, temp1);
				        }
					}
					for(String i:list)
						System.out.println(i);
				}
				else
					System.out.println("Directory empty");
			}
			else
				System.out.println("Please enter valid Directory name");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void bleveloperations() throws IOException
	{
		Scanner s2=new Scanner(System.in);
		try
		{
			int ch;
			//do-while loop used to loop switch cases over and over unless user inputs 4
			do
			{
				System.out.println("\nBusiness Level Operations\n");
				System.out.println("1.Add a file\n2.Delete a file\n3.Search for a file\n4.Go back to Main Menu\n");
				System.out.println("Enter your choice:");
				ch=s2.nextInt();
				switch(ch)
				{
					case 1:
						//adding a new file and writing user-input data into it
						Scanner s3=new Scanner(System.in);
						String fname;
						System.out.println("Enter path and file name that is to be created:");
						fname=s3.nextLine();
						File f2=new File(fname);
						if(f2.createNewFile())
						{
							System.out.println("File is created");
							System.out.println("Enter data to write into the file:");
							String d=s3.nextLine();
							FileWriter writer=new FileWriter(f2);
							writer.write(d);
							System.out.println("Data written to file, please check");
							writer.close();
						}
						else
							System.out.println("File already exists");
						break;
					case 2:
						//deleting user-input file from the directory provided by user
						Scanner s4=new Scanner(System.in);
						String fname1;
						System.out.println("Enter path and file name that is to be deleted(case-sensitive):");
						fname1=s4.nextLine();
						File f3=new File(fname1);
						if(f3.exists())
						{
							Files.delete(Paths.get(fname1));
							System.out.println("Deletion Successful");
						}
						else
							System.out.println("File not found");
						break;
					case 3:
						//searching for a filename from a directory provided by user using linear search
						Scanner s5=new Scanner(System.in);
						int flag=0;
						String fname2, fpath;
						System.out.println("Enter Directory name in which the file needs to be searched:");
						fpath=s5.nextLine();
						File f4=new File(fpath);
						if(f4.isDirectory()==true)
						{
							System.out.println("Enter filename that is to be searched for(case-sensitive):");
							fname2=s5.nextLine();
							String flist[]=f4.list();
							for(int i=0;i<flist.length;i++)
							{
								if(fname2.equals(flist[i]))
								{
									flag=1;
									break;
								}
								else
									flag=0;
							}
							if(flag==1)
								System.out.println("File found");
							else
								System.out.println("File not found");
						}
						else
							System.out.println("Please enter valid directory name");
						break;
					case 4:
						//returning to previous switch case
						System.out.println("Returning to previous menu\n");
						break;
					default:
						System.out.println("Please enter a valid choice");
						break;
				}
			} while(ch!=4);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc=new Scanner(System.in);
		try
		{
			int c;
			//do-while loop used to loop switch cases over and over unless user inputs 3
			do
			{
				System.out.println("\nProject name: LockedMe.com");
				System.out.println("Developer details: Anurag Pal, 216 Java SL(Evening Batch), Java FSD Phase-1 Assessment, \nContact no: 1111111111");
				System.out.println("\n-----Menu-----\n");
				System.out.println("1.Get File List\n2.Business-level Operations\n3.Close\n");
				System.out.println("Enter your choice:");
				c=sc.nextInt();
				switch(c)
				{
					case 1:
						//calling method getFileList()
						try {
							getFileList();
						}
						catch (Exception e)
						{
							e.printStackTrace();
						}
						break;
					case 2:
						//calling method bleveloperations()
						try {
							bleveloperations();
						}
						catch (Exception e)
						{
							e.printStackTrace();
						}
						break;
					case 3:
						//Closing switch case
						System.out.println("Application Closed");
						break;
					default:
						System.out.println("Please enter a valid choice");
						break;
				}
			} while(c!=3);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
