import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

class ContourAnalyze {
	static int i = 0, count = 0;
	static double points[] = new double[10000];	
	
	public void ContourAnalyze() {
		
	}
	static void analyzeIt () {
		File contourTarget = new File("/Users/takuya/Dropbox/program/workspace/DicomDecomposer/src/MonacoPlan/Contour2.txt");
		File contourTargetTemp = new File("/Users/takuya/Dropbox/program/workspace/DicomDecomposer/src/MonacoPlan/ContourTemp.txt");
		
		backslashToSpace(contourTarget);
		valueDecompose(contourTargetTemp);

	}
	
	static void analyzeIt (String inputString) {
		File contourTarget = new File("/Users/takuya/Dropbox/program/workspace/DicomDecomposer/src/MonacoPlan/Contour2.txt");
		File contourTargetTemp = new File("/Users/takuya/Dropbox/program/workspace/DicomDecomposer/src/MonacoPlan/ContourTemp.txt");
		
		backslashToSpace(contourTarget);
		valueDecompose(contourTargetTemp);

	}
	
	static void backslashToSpace (File contourTarget) {
		try{
			FileReader input = new FileReader(contourTarget);
			FileWriter output = new FileWriter(contourTarget.getParent() + "/ContourTemp.txt");
			int data = 0;
			while((data = input.read()) != -1) {
				if(data != 92) {
					output.write(data);	
				} else {
					output.write(' ');
				}
			}
			input.close();
			output.close();
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	
	static void valueDecompose(File contourTargetTemp) {
		try {
			FileReader input2 = new FileReader(contourTargetTemp);
			//FileWriter output2 = new FileWriter(coutourTarget2.getParent() + "/ContourOutput.txt");
			StreamTokenizer st = new StreamTokenizer(input2);
					
			while(st.nextToken() != StreamTokenizer.TT_EOF)
			{
				//System.out.print(st.nval + " ");
				points[i] = st.nval;
				i++;
			}
			//int filesize = input.available();
			count = i;
		 	int j = 0;
			double position[][] =new double[count/3][3];
			//System.out.println(" here " + count/3 + " here ");
			for( j = 0; j < count; j++) {
				if ((j + 3) %3 == 0) position[j/3][0] = points[j];
				if ((j + 3) %3 == 1) position[j/3][1] = points[j];
				if ((j + 3) %3 == 2) position[j/3][2] = points[j];
			}
			for(i = 0; i < count /3; i ++) {
				for(j = 0; j < 3; j++) {
					System.out.print(position[i][j] + " ");
				}
				System.out.println("");
			}
		}catch(IOException e) {
			System.out.println(e);
		}
	}

}