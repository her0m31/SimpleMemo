package uka.ayagi.simplememo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;

public class Serializing {
	static int Save(Context context, List<Object> list){
		 try {
			 FileOutputStream outFile = context.openFileOutput("test.txt", 0);
			 ObjectOutputStream outObject = new ObjectOutputStream(outFile);
			 outObject.writeObject(list);
			 outObject.close();
			 outFile.close();
		 }
		 catch (Exception e) {
		 }

		return 0;
	}

	@SuppressWarnings("unchecked")
	static ArrayList<Object> Load(Context context){
		ArrayList<Object> list = new ArrayList<Object>();

		try {
			FileInputStream inFile = context.openFileInput("test.txt");
			ObjectInputStream inObject = new ObjectInputStream(inFile);
			list = (ArrayList<Object>)inObject.readObject();
			inObject.close();
			inFile.close();
		}
		catch (Exception e) {
		}

		return list;
	}
}
