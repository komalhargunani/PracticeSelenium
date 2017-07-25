package com.advancetopics.testcases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;

public class ReadCSVFile {
	
	
	@Test
	public void readCSVData() throws Exception{
		
		 CSVReader reader = new CSVReader(new FileReader("E:\\synerzip_workspace\\synerzip\\jexcel\\csvreader.csv"));
		 
		 
		  List<String[]> li = reader.readAll();
		  System.out.println("Total rows which we have is "+li.size());
		            
		 
		  Iterator<String[]>i1= li.iterator();
		    
		 
		 while(i1.hasNext()){
		     
		 String[] str=i1.next();
		   
		 System.out.print(" Values are ");
		 
		 for(int i=0;i<str.length;i++)
		{
		 
		   System.out.print(" "+str[i]);
		 
		}
		   System.out.println("   ");
		     
		    
		}
		
	}

}
