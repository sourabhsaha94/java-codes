import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class SearchUSA {

	public static void main(String[] args) throws Exception{
		
		ArrayList<Vertex> Vlist = new ArrayList<Vertex>();	//create new list of vertex
		ArrayList<Vertex> Temp = new ArrayList<Vertex>();
		
		FileReader f = new FileReader("roads2.txt");	//new reader for getting city names
		BufferedReader bufferedReader1 = new BufferedReader(f);
		
		
		String line;
		String[] splitString;
		boolean flag=true;	//to mark duplicate values
		
		while((line = bufferedReader1.readLine())!= null){	//to fill temp array with all city names including duplicates
			splitString = line.split(",");
			Temp.add(new Vertex(splitString[0]));
			Temp.add(new Vertex(splitString[1]));
		}
		
		bufferedReader1.close();
		
		Vlist.add(Temp.get(0));
		
		for(Vertex v : Temp){	//to remove duplicate entries from temp into vlist
			flag=true;
			for(Vertex v1:Vlist){
				if(v.label.equalsIgnoreCase(v1.label)){
					flag=true;
					break;
				}else
				{
					flag=false;
				}
			}
			if(!flag){
				Vlist.add(v);
			}
		}
		
		
		Graph g = new Graph(Vlist);
		
		FileReader f1 = new FileReader("roads2.txt");	//new reader required for getting edges
		
		BufferedReader bufferedReader2 = new BufferedReader(f1);
		
		while((line = bufferedReader2.readLine())!= null){	//to fill temp array with all city names including duplicates
			splitString = line.split(",");
			g.addEdge(splitString[0], splitString[1], new Integer(splitString[2]));
		}
		
		bufferedReader2.close();
		
		for(Vertex v:Vlist){
			System.out.println(v.label+" "+v.Elist.size());
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
