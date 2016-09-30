import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SearchUSA {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//createFile();
		
		FileReader fileReader = new FileReader("roads2.txt");
		BufferedReader in = new BufferedReader(fileReader);
		ArrayList<Vertex> vList = new ArrayList<Vertex>();
		Graph g;
		String input;
		String[] v;
		
		
		while((input=in.readLine())!=null){
			v = input.split(",");
			Vertex v1 = new Vertex(v[0]);
			Vertex v2 = new Vertex(v[1]);
			vList.add(v1);
			vList.add(v2);
		}
		
	}
	
	/*static void createFile() throws Exception{
		FileReader fileReader = new FileReader("roads.txt");
		BufferedReader in = new BufferedReader(fileReader);
		PrintWriter printWriter = new PrintWriter("roads2.txt"); 
		String input;
		String[] output;
		String x;
				
		while((input=in.readLine()) != null){
			
			String test=input.replaceAll("\\s+","");
			output = test.split("\\.");
			for(int i=0;i<output.length;i++)
			{
				x=output[i].replace("road(", "");
				x=x.replace(")", "");
				printWriter.write(x+"\n");
				printWriter.flush();
			}
		}
		
		in.close();
		printWriter.close();
	}*/

}
