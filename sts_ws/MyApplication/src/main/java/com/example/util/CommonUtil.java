package com.example.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.dto.Cart;

@Component
public class CommonUtil {

	String filename = "userData.txt";
	public void writeData(Map<String, List<Cart>> cartMap) {
		try {
			FileOutputStream fos=new FileOutputStream(filename);  
			ObjectOutputStream out=new ObjectOutputStream(fos);  
			out.writeObject(cartMap);  
			fos.close();
			out.close();  
			System.out.println("success");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

	}
	public Map<String, List<Cart>>  readData() {
		Map<String, List<Cart>> cartMap  = null;
			try {
				FileInputStream file = new FileInputStream (filename); 
				ObjectInputStream inp = new ObjectInputStream(file);
				cartMap = (Map<String, List<Cart>>) inp.readObject();
				file.close();
				inp.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return cartMap;
		
	}

}


