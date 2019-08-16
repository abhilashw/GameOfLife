import java.util.* ;
public class GameOfLife{
	int width;
	int height;

	GameOfLife(int width,int height){
		this.width=width;
		this.height=height;
	}

	// public List<List<Integer>> deadState(int width,int height){

	// 	List<List<Integer>> dead =new ArrayList<List<Integer>>(height);
	// 	int i=0;
	// 	while(i<height){
	// 		List<Integer> inside =new ArrayList<Integer>(width);
	// 		int j=0;
	// 		while(j< width){
	// 			inside.add(0);
	// 			j++;
	// 		}
	// 		dead.add(inside);
	// 		i++;
	// 	}
	// 	return dead ;
	// }
	public List<List<Integer>> randomState(int width,int height){
		Random rand=new Random();

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

	public List<List<Character>> renderBoard(List<List<Integer>> random, int width,int height){

		List<List<Character>> board =new ArrayList<List<Character>>();
		int i=0;
		while(i<height){
			List<Integer> inside = random.get(i);
			List<Character> ins= new ArrayList<>();
			int j=0;
			while(j< width){
				
				if(inside.get(j)==1){
					ins.add('#');
				}
				else{
					ins.add(' ');
				}
				j++;
			}
			board.add(ins);	
			i++;
		}
		return board ;
	}

	public static void main(String[] args){

		GameOfLife system1=new GameOfLife(20,20);
		List<List<Integer>> res=system1.randomState(20,20);
		List<List<Character>> b =system1.renderBoard(res,20,20);

		// System.out.println(res);
		
		
		for(int i=0;i<b.size() ;i++){
			for(int j=0;j<b.get(i).size() ;j++){
				System.out.printf("%c ",b.get(i).get(j));
			}
			System.out.println();
		}
	}
}