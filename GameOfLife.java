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

	public static void main(String[] args){

		GameOfLife system1=new GameOfLife(5,5);
		List<List<Integer>> res=system1.randomState(5,5);

		System.out.println(res);
		
		
		// for(int i=0;i<system1.height ;i++){
		// 	for(int j=0;j<system1.width ;j++){
		// 		System.out.printf("%d ",res.get(i).get(j));
		// 	}
		// 	System.out.println();
		// }
	}
}