import java.util.* ;

public class GameOfLife{
	int width;
	int height;

	GameOfLife(int width,int height){
		this.width=width;
		this.height=height;
	}

	public List<List<Integer>> deadState(int width,int height){

		List<List<Integer>> dead =new ArrayList<List<Integer>>(height);
		int i=0;
		while(i<height){
			List<Integer> inside =new ArrayList<Integer>(width);
			int j=0;
			while(j< width){
				inside.add(0);
				j++;
			}
			dead.add(inside);
			i++;
		}
		return dead ;
	}


	public List<List<Integer>> randomState(int width,int height){
		Random rand =new Random() ;

		List<List<Integer>> random =new ArrayList<List<Integer>>(height);
		int i=0;
		while(i<height){
			List<Integer> inside =new ArrayList<Integer>(width);
			int j=0;
			while(j< width){
				double n=rand.nextDouble() ;
				if(n<=0.5){
					inside.add(0);
				}else{
					inside.add(1);
				}	
				j++;
			}
			random.add(inside);
			i++;
		}
		return random ;
	}



	public void renderBoard(List<List<Integer>> random){

		List<List<Character>> board =new ArrayList<List<Character>>();
		int i=0;
		while(i<height){
			List<Integer> inside = random.get(i);
			List<Character> ins= new ArrayList<>();
			int j=0;
			while(j< width){
				
				if(inside.get(j)==1){
					ins.add('+');
				}
				else{
					ins.add(' ');
				}
				j++;
			}
			board.add(ins);	
			i++;
		}
		for(int m=0;m<board.size() ;m++){
			for(int j=0;j<board.get(m).size() ;j++){
				System.out.printf("%c ",board.get(m).get(j));
			}
			System.out.println();
		}
		
	}


	public List<List<Integer>> noOfNeighbour(List<List<Character>> initialState){
		List<List<Integer>> neighbour = deadState(width,height) ;

		int i=0;
		while(i<height){
			
			List<Integer> ins= neighbour.get(i);
			int j=0;

			while(j< width){
				int count =1 ;
				if(i==0 && j==0){
					if(initialState.get(i).get(j+1) =='+'){ins.set(j, count++ );}
					if(initialState.get(i+1).get(j) =='+'){ins.set(j, count++ ) ;}
					if(initialState.get(i+1).get(j+1) =='+'){ins.set(j, count++ ) ;}
				}
				else if(i==0 && j==width-1){
					if(initialState.get(i).get(j-1) =='+'){ins.set(j, count++ );}
					if(initialState.get(i+1).get(j-1) =='+'){ins.set(j, count++ ) ;}
					if(initialState.get(i+1).get(j) =='+'){ins.set(j, count++ ) ;}
				}
				else if(i==height -1 && j==0){
					if(initialState.get(i).get(j+1) =='+'){ins.set(j, count++ );}
					if(initialState.get(i-1).get(j) =='+'){ins.set(j, count++ );}
					if(initialState.get(i-1).get(j+1) =='+'){ins.set(j, count++ ) ;}
				}
				else if(i==height -1 && j==width -1){
					if(initialState.get(i).get(j-1)=='+'){ins.set(j, count++ );}
					if(initialState.get(i-1).get(j-1)=='+'){ins.set(j, count++ ) ;}
					if(initialState.get(i-1).get(j)=='+'){ins.set(j, count++ );}
				}
				else if(i==0){
					if(initialState.get(i).get(j-1) =='+'){ins.set(j, count++ );}
					if(initialState.get(i).get(j+1) =='+'){ins.set(j, count++ );}
					if(initialState.get(i+1).get(j-1) =='+'){ins.set(j, count++ ) ;}
					if(initialState.get(i+1).get(j) =='+'){ins.set(j, count++ ) ;}
					if(initialState.get(i+1).get(j+1) =='+'){ins.set(j, count++ );}
				}
				else if(i==height -1){
					if(initialState.get(i).get(j-1) =='+'){ins.set(j, count++ );}
					if(initialState.get(i).get(j+1) =='+'){ins.set(j, count++ );}
					if(initialState.get(i-1).get(j-1) =='+'){ins.set(j, count++ ) ;}
					if(initialState.get(i-1).get(j) =='+'){ins.set(j, count++ ) ;}
					if(initialState.get(i-1).get(j+1) =='+'){ins.set(j, count++ );}
				}
				else if(j==0){
					if(initialState.get(i-1).get(j) =='+'){ins.set(j, count++ );}
					if(initialState.get(i-1).get(j+1) =='+'){ins.set(j, count++ );}
					if(initialState.get(i).get(j+1) =='+'){ins.set(j, count++ ) ;}
					if(initialState.get(i+1).get(j) =='+'){ins.set(j, count++ ) ;}
					if(initialState.get(i+1).get(j+1) =='+'){ins.set(j, count++ );}
				}
				else if(j==width-1){
					if(initialState.get(i-1).get(j) =='+'){ins.set(j, count++ );}
					if(initialState.get(i-1).get(j-1) =='+'){ins.set(j, count++ );}
					if(initialState.get(i).get(j-1) =='+'){ins.set(j, count++ ) ;}
					if(initialState.get(i+1).get(j) =='+'){ins.set(j, count++ ) ;}
					if(initialState.get(i+1).get(j-1) =='+'){ins.set(j, count++ );}
				}
				else if(i>0 && j>0 && i< height && j< width){
					if(initialState.get(i-1).get(j-1) =='+'){ins.set(j, count++ );}
					if(initialState.get(i-1).get(j) =='+'){ins.set(j, count++ );}
					if(initialState.get(i-1).get(j+1) =='+'){ins.set(j, count++ ) ;}
					if(initialState.get(i).get(j-1) =='+'){ins.set(j, count++ ) ;}
					if(initialState.get(i).get(j+1) =='+'){ins.set(j, count++ );}
					if(initialState.get(i+1).get(j-1) =='+'){ins.set(j, count++ );}
					if(initialState.get(i+1).get(j) =='+'){ins.set(j, count++ );}
					if(initialState.get(i+1).get(j+1) =='+'){ins.set(j, count++ );}

				}
				j++;
			}	
			i++;
		}
		return neighbour ;

	}

	public List<List<Character>> nextBoardState(List<List<Integer>> neighbour,List<List<Character>> initialState){

		List<List<Character>> nextState =new ArrayList<List<Character>>();
		int i=0;
		while(i<height){
			List<Integer> inside = neighbour.get(i);
			List<Character> ins= new ArrayList<>();
			int j=0;
			while(j< width){
				
				if(inside.get(j)==0 || inside.get(j)==1 || inside.get(j)>3){
					ins.add(' ');
				}
				else if(inside.get(j)==3){
					ins.add('+');
				}
				else if(initialState.get(i).get(j)=='+' && (inside.get(j)==2 || inside.get(j)==3)){
					ins.add('+');
				}
				j++;
			}
			nextState.add(ins);	
			i++;
		}
		return nextState ;
	}


	public static void main(String[] args){


		GameOfLife system1=new GameOfLife(3,3);
		List<List<Integer>> res=system1.randomState(3,3);
		system1.renderBoard(res);
		// List<List<Integer>> res1=system1.noOfNeighbour(b);
		// List<List<Character>> b1 =system1.nextBoardState(res1,b);
		
		
	}
}