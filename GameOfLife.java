package com.googlecode.lanterna;

import java.util.* ;

import java.io.IOException;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;


public class GameOfLife{
	int width;
	int height;
	Terminal terminal ;
	Screen screen ;


	GameOfLife(int width,int height) throws IOException{
		this.width=width;
		this.height=height;
		this.terminal= new DefaultTerminalFactory().createTerminal();
		this.screen = new TerminalScreen(terminal);
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


	public List<List<Character>> randomState(int width,int height){
		Random rand =new Random() ;

		List<List<Character>> random =new ArrayList<List<Character>>(height);
		int i=0;
		while(i<height){
			List<Character> inside =new ArrayList<>(width);
			int j=0;
			while(j< width){
				double n=rand.nextDouble() ;
				if(n<=0.5){
					inside.add('.');
				}else{
					inside.add('O');
				}	
				j++;
			}
			random.add(inside);
			i++;
		}
		return random ;
	}



	public void renderBoard(List<List<Character>> random) throws IOException{

        screen.startScreen();
        screen.clear();

        for(int i=0; i<random.size() ;i++){
            for(int j=0; j<random.get(i).size() ;j++){
                screen.setCharacter(i, j, new TextCharacter(random.get(i).get(j)));
            }
        }
        screen.refresh();
        
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
					if(initialState.get(i).get(j+1) =='O'){ins.set(j, count++ );}
					if(initialState.get(i+1).get(j) =='O'){ins.set(j, count++ ) ;}
					if(initialState.get(i+1).get(j+1) =='O'){ins.set(j, count++ ) ;}
				}
				else if(i==0 && j==width-1){
					if(initialState.get(i).get(j-1) =='O'){ins.set(j, count++ );}
					if(initialState.get(i+1).get(j-1) =='O'){ins.set(j, count++ ) ;}
					if(initialState.get(i+1).get(j) =='O'){ins.set(j, count++ ) ;}
				}
				else if(i==height -1 && j==0){
					if(initialState.get(i).get(j+1) =='O'){ins.set(j, count++ );}
					if(initialState.get(i-1).get(j) =='O'){ins.set(j, count++ );}
					if(initialState.get(i-1).get(j+1) =='O'){ins.set(j, count++ ) ;}
				}
				else if(i==height -1 && j==width -1){
					if(initialState.get(i).get(j-1)=='O'){ins.set(j, count++ );}
					if(initialState.get(i-1).get(j-1)=='O'){ins.set(j, count++ ) ;}
					if(initialState.get(i-1).get(j)=='O'){ins.set(j, count++ );}
				}
				else if(i==0){
					if(initialState.get(i).get(j-1) =='O'){ins.set(j, count++ );}
					if(initialState.get(i).get(j+1) =='O'){ins.set(j, count++ );}
					if(initialState.get(i+1).get(j-1) =='O'){ins.set(j, count++ ) ;}
					if(initialState.get(i+1).get(j) =='O'){ins.set(j, count++ ) ;}
					if(initialState.get(i+1).get(j+1) =='O'){ins.set(j, count++ );}
				}
				else if(i==height -1){
					if(initialState.get(i).get(j-1) =='O'){ins.set(j, count++ );}
					if(initialState.get(i).get(j+1) =='O'){ins.set(j, count++ );}
					if(initialState.get(i-1).get(j-1) =='O'){ins.set(j, count++ ) ;}
					if(initialState.get(i-1).get(j) =='O'){ins.set(j, count++ ) ;}
					if(initialState.get(i-1).get(j+1) =='O'){ins.set(j, count++ );}
				}
				else if(j==0){
					if(initialState.get(i-1).get(j) =='O'){ins.set(j, count++ );}
					if(initialState.get(i-1).get(j+1) =='O'){ins.set(j, count++ );}
					if(initialState.get(i).get(j+1) =='O'){ins.set(j, count++ ) ;}
					if(initialState.get(i+1).get(j) =='O'){ins.set(j, count++ ) ;}
					if(initialState.get(i+1).get(j+1) =='O'){ins.set(j, count++ );}
				}
				else if(j==width-1){
					if(initialState.get(i-1).get(j) =='O'){ins.set(j, count++ );}
					if(initialState.get(i-1).get(j-1) =='O'){ins.set(j, count++ );}
					if(initialState.get(i).get(j-1) =='O'){ins.set(j, count++ ) ;}
					if(initialState.get(i+1).get(j) =='O'){ins.set(j, count++ ) ;}
					if(initialState.get(i+1).get(j-1) =='O'){ins.set(j, count++ );}
				}
				else if(i>0 && j>0 && i< height && j< width){
					if(initialState.get(i-1).get(j-1) =='O'){ins.set(j, count++ );}
					if(initialState.get(i-1).get(j) =='O'){ins.set(j, count++ );}
					if(initialState.get(i-1).get(j+1) =='O'){ins.set(j, count++ ) ;}
					if(initialState.get(i).get(j-1) =='O'){ins.set(j, count++ ) ;}
					if(initialState.get(i).get(j+1) =='O'){ins.set(j, count++ );}
					if(initialState.get(i+1).get(j-1) =='O'){ins.set(j, count++ );}
					if(initialState.get(i+1).get(j) =='O'){ins.set(j, count++ );}
					if(initialState.get(i+1).get(j+1) =='O'){ins.set(j, count++ );}

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
					ins.add('.');
				}
				else if(inside.get(j)==3){
					ins.add('O');
				}
				else if(initialState.get(i).get(j)=='O' && (inside.get(j)==2 || inside.get(j)==3)){
					ins.add('O');
				}
				else if(initialState.get(i).get(j)=='.' && inside.get(j)==2){
					ins.add('.');
				}
				j++;
			}
			nextState.add(ins);	
			i++;
		}
		return nextState ;
	}

	public void forever(List<List<Character>> initialState)throws IOException{
		renderBoard(initialState);

		while(true){
			List<List<Integer>> neighbour = noOfNeighbour(initialState);
			List<List<Character>> nextState = nextBoardState(neighbour,initialState);

			renderBoard(nextState);
			initialState=nextState;
			try {
				Thread.sleep(750);
			}
			catch (Exception e) {
   				e.printStackTrace();
			}

		}
	}


	public static void main(String[] args)throws IOException {


		GameOfLife system1=new GameOfLife(50,100);
		List<List<Character>> initialState =system1.randomState(50,100);

	
		system1.forever(initialState);
		
	}
}