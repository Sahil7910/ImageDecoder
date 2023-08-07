	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Base64;
	import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




	public class ReadExcel {
	
		public static void main(String args[]) throws IOException {
				 try  
				 {  
				 ArrayList<String>arrlist=new ArrayList<>();			 
				 File file = new File("C:\\Users\\Acer\\Documents\\AID\\docpic.xlsx");    
				 FileInputStream fis = new FileInputStream(file);    
				
				 XSSFWorkbook wb = new XSSFWorkbook(fis);   
				 XSSFSheet sheet = wb.getSheetAt(0);       
				 Iterator<Row> itr = sheet.iterator();     
				 int i = 0;
				 while (itr.hasNext())                 
				 {  
				 Row row = itr.next();  
				 Iterator<Cell> cellIterator = row.cellIterator();    
				
//				 int col = 0;
				 String filename = row.getCell(0).getStringCellValue();
				 String imagestr = row.getCell(1).getStringCellValue();
//				 System.out.print((i++) + " " + strval);
//				 while (cellIterator.hasNext())   
//				 {  
//				 Cell cell = cellIterator.next();
//				 
//				
//				 System.out.print(i + " " + cell.getStringCellValue());
				 decoder(imagestr, "C:\\Users\\Acer\\Documents\\AID\\Pic\\" + filename + ".jpg");
	//
//				 }  
				 	System.out.println(" generated ");  
				 }  
				 
				 
				 
				 }  
				 catch(Exception e)  
				 {  
				 e.printStackTrace();  
				 }  
				 }
		
		
		
		
		
		public static void decoder(String base64Image, String pathFile) {
			try (FileOutputStream imageOutFile = new FileOutputStream(pathFile)) {
			
				byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
				imageOutFile.write(imageByteArray);
				
				
			} catch (FileNotFoundException e) {
				System.out.println("Image not found" + e);
			} catch (IOException ioe) {
				System.out.println("Exception while reading the Image " + ioe);
			}
		}
		
		
 
		
		
		}
