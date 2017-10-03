import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


import java.util.stream.Collectors;


public class Dijkstra {

	public static void main(String[] args) {
	
		             String line[] = new String[100];
                     int CountLine=0;
                     String DistinctVertex[]= new String[50];
                     int graph[][]= new int [50][50];
                     int src = 0;
                     int dest = 0;
		
			    	 File inFile = null;
			    	 if (0 < args.length) {
			    	    inFile = new File(args[0]);
			    	 } else {
			    	    System.err.println("Invalid arguments count:" + args.length);
			    	    System.exit(0);
			    	 }
			        BufferedReader br = null;

			        try {

			            String sCurrentLine;
			           
			            String LastLine="END OF INPUT";

			            br = new BufferedReader(new FileReader(inFile));

			            for (int i=0;(sCurrentLine = br.readLine()) != null && sCurrentLine.equalsIgnoreCase(LastLine)==false; i++) {
			            
			               
			              
			               
			             
			                line[i]=sCurrentLine;
			                //System.out.println(line[i]);
			                CountLine++;
			               // System.out.println(CountLine);
			               
			            }

			        } 

			        catch (IOException e) {
			            e.printStackTrace();
			        } 

			        finally {
			            try {
			                if (br != null)br.close();
			            } catch (IOException ex) {
			                ex.printStackTrace();
			            }
			        }
			        
			        
			      // System.out.println(line[27]);
			     //  System.out.println(CountLine);
			       
			     try {
			    	DistinctVertex= VertexList(line,CountLine);
			     }
			     
			       catch( Exception e){
			    	   System.out.println(e);
			       }
			    	   
			    // System.out.println(DistinctVertex.length);
			       
			     //System.out.println(Arrays.toString(DistinctVertex));
			     
			      try {
					graph=MakeGraph(line,DistinctVertex);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			      
			 /*    System.out.println(graph[0][1]);
			       //System.out.println(DistinctVertex);
			     
			       for(int i=0;i<DistinctVertex.length;i++) {
			    	   
			    	   for(int j=0;j<DistinctVertex.length;j++)
			    	   {
			    		   System.out.print(graph[i][j]);
			    		   System.out.print(",");
			    	   }
			    	   
			    	   System.out.println("");;
			       }
				      */

			 //  System.out.println(args[1]+ " "+ args[2] );
			      switch (args[1].toString()){
			      case "Luebeck":  
			    	   src =0;
			    	   break;
			      case "Hamburg" :
			    	  src=1;
			    	  break;
			      case "Bremen": src=2;  break;
			      case "Hannover": src=3;  break;
			      case "Berlin": src=4;  break;
			      case "Dortmund" : src=5;  break;
			      case "Magdeburg": src=6;  break;
			      case "Kassel":  src=7;  break;
			      case "Dresden": src=8;  break;
			      case "Leipzig":  src=9;  break;
			      case "Duesseldorf": src=10;  break;
			      case "Frankfurt": src=11;  break;
			      case "Nuremberg": src=12;  break;
			      case "Saarbruecken": src=13;  break;
			      case "Karlsruhe": src=14;  break;
			      case "Stuttgart": src=15;  break;
			      case "Munich": src=16;  break;
			      case "Manchester": src=17;  break;
			      case "Birmingham": src=18;  break;
			      case "Bristol":  src=19;  break;
			      case "London":  src=20;  break;

			  
			      }
			      switch (args[2]){
			      case "Luebeck":  
			    	   dest =0;
			    	   break;
			      case "Hamburg" :
			    	  dest=1;
			    	  break;
			      case "Bremen": dest=2;break;
			      case "Hannover": dest=3;break;
			      case "Berlin": dest=4;break;
			      case "Dortmund" : dest=5;break;
			      case "Magdeburg": dest=6;break;
			      case "Kassel":  dest=7;break;
			      case "Dresden": dest=8;break;
			      case "Leipzig":  dest=9;break;
			      case "Duesseldorf": dest=10;break;
			      case "Frankfurt": dest=11;break;
			      case "Nuremberg": dest=12;break;
			      
			      case "Saarbruecken": dest=13;break;
			      case "Karlsruhe": dest=14;break;
			      case "Stuttgart": dest=15;break;
			      case "Munich": dest=16;break;
			      case "Manchester": dest=17;break;
			      case "Birmingham": dest=18;break;
			      case "Bristol":  dest=19;break;
			      case "London":  dest=20;break;

			      
			      }
			      
			    //  System.out.println(src + " "+ dest);
			                   // graph, vertex length, source ,destination
			      dijkstra(graph,DistinctVertex.length,src, dest);

			       
			        
			    }
		
	
	public static String[] VertexList(String[] line, int CountLine) {
		
		 ArrayList<String> obj = new ArrayList<String>();
		String VertexList[]= new String [100];
		 
	   //  System.out.println(arr[0]);
	     
	     for(int i=0;i<CountLine;i++) {
	    	 
	    	 String arr[] = line[i].split(" ");
	    	 String temp1=arr[0];
	    	 String temp2= arr[1];
	    	 
	    //	System.out.println(arr[2]);
	    	 obj.add(temp1);
	    	 obj.add(temp2);
	    	
	    	
	     
	    // System.out.println(obj);
	     
        }
	   /// System.out.println(obj);
	    
	    List<String> listDistinct = obj.stream().distinct().collect(Collectors.toList());
	    
	   
	   
	 //  System.out.println(listDistinct);
	   VertexList = listDistinct.toArray(new String[listDistinct.size()]);
	  // System.out.println(VertexList.length);
	     
	     
	     return VertexList;
	}
	                 
public static int[][] MakeGraph(String line[],String DistinctVertex[]){
	int length= DistinctVertex.length;
	int graph [][]= new int[length][length];
	
	
   // System.out.println(Arrays.toString(DistinctVertex));
   // System.out.println(DistinctVertex.length);
	
	for(int i=0; i <length;i++) {
		for(int j=0; j <length;j++) {
			graph[i][j]=0;
			//System.out.println(graph[i][j]);
		}
		
	}
		
		
	//System.out.println(graph[0][1]);
	
	for(int i=0; i <line.length;i++) {
		String arr[]= new String[3];
		if(line[i]!=null) {
		    arr=line[i].split(" ");
		}
		
		
		
		
		for(int j=0; j<length; j++) {
			//System.out.println(DistinctVertex[j]+" "+ j);
			for(int k=0; k<length; k++) {
				
				
				if (DistinctVertex[j].equals(arr[0]) && DistinctVertex[k].equals(arr[1])) {
					//System.out.println("in loop");
					try {
						graph[j][k]=Integer.parseInt(arr[2].toString());
						 //System.out.println(graph[j][k]);
						
						}
							
					 catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
		}
		
		
	
	}
	//System.out.println(graph[0][1]);

	return graph;
	
	
}
	
static int minDistance(int dist[], Boolean sptSet[],int V)
{
	// Initialize min value
	int min = Integer.MAX_VALUE, min_index=-1;

	for (int v = 0; v < V; v++)
		if (sptSet[v] == false && dist[v] <= min)
		{
			min = dist[v];
			min_index = v;
		}

	return min_index;
}


static void dijkstra(int graph[][], int V, int src,int dest)
{   
	int dist[] = new int[V];
	int parent[]= new int [V];	
	
	
	Boolean sptSet[] = new Boolean[V];

	
	for (int i = 0; i < V; i++)
	{
		dist[i] = Integer.MAX_VALUE; // distance = infinite
		sptSet[i] = false;
		parent[0] = -1;
	}

	
	dist[src] = 0;

	
	for (int count = 0; count < V-1; count++)
	{
		
		int u = minDistance(dist, sptSet, V);

		//marking the set of shortest path
		sptSet[u] = true;

		
		for (int v = 0; v < V; v++)

			//update if min
			if (!sptSet[v] && graph[u][v]!=0 &&
					dist[u] != Integer.MAX_VALUE &&
					dist[u]+graph[u][v] < dist[v]) {
				parent[v]  = u;
				dist[v] = dist[u] + graph[u][v];
			}
				 
	}


	print(dist,dest,parent,graph);
}

static void print(int dist[], int dest,int parent[], int graph[][])
{
	
	boolean notInfi=true;
	if (dist[dest]!=Integer.MAX_VALUE) {
		System.out.println("Distance : " + dist[dest]+ "km");
		notInfi=false;
	}
	else {
		System.out.println("Distance : " +"Infinity");
	}
	
	
 System.out.println("route:");
		printPath(parent,dest, graph,notInfi);
		
}


static void printPath(int parent[], int j, int graph[][],boolean notInfi )
{
	
	String temp = null, temp1 = null;
    
    if (parent[j]==-1)
        return;
 
 
    printPath(parent, parent[j],graph, notInfi);
    switch (j){
    case 0:  temp="Luebeck";
  	 
  	   break;
    case 1 :temp="Hamburg";
  	  break;
    case 2: temp="Bremen";  break;
    case 3: temp="Hannover";  break;
    case 4: temp="Berlin"; break;
    case 5 : temp="Dortmund";  break;
    case 6: temp="Magdeburg";  break;
    case 7:  temp="Kassel";  break;
    case 8: temp="Dresden";  break;
    case 9:  temp="Leipzig";  break;
    case 10: temp="Duesseldorf";  break;
    case 11: temp="Frankfurt";  break;
    case 12: temp="Nuremberg";  break;
    case 13:temp="Saarbruecken";  break;
    case 14: temp="Karlsruhe";  break;
    case 15: temp="Stuttgart";  break;
    case 16: temp="Munich";  break;
    case 17:temp="Manchester";  break;
    case 18: temp="Birmingham";  break;
    case 19:  temp="Bristol";  break;
    case 20:  temp="London";  break;
    
    }
    
    switch (parent[j]){
    case 0:  temp1="Luebeck";
  	 
  	   break;
    case 1 :temp1="Hamburg";
  	  break;
    case 2: temp1="Bremen";  break;
    case 3: temp1="Hannover";  break;
    case 4: temp1="Berlin"; break;
    case 5 : temp1="Dortmund";  break;
    case 6: temp1="Magdeburg";  break;
    case 7:  temp1="Kassel";  break;
    case 8: temp1="Dresden";  break;
    case 9:  temp1="Leipzig";  break;
    case 10: temp1="Duesseldorf";  break;
    case 11: temp1="Frankfurt";  break;
    case 12: temp1="Nuremberg";  break;
    case 13:temp1="Saarbruecken";  break;
    case 14: temp1="Karlsruhe";  break;
    case 15: temp1="Stuttgart";  break;
    case 16: temp1="Munich";  break;
    case 17:temp1="Manchester";  break;
    case 18: temp1="Birmingham";  break;
    case 19:  temp1="Bristol";  break;
    case 20:  temp1="London";  break;
    
    }
   if (notInfi==false) {
	   System.out.println(temp1 +"  to  "+ temp+ " ,"+ graph[parent[j]][j]+ " km");

   }
   else {
	   System.out.println("None");

   }
   
}




}

