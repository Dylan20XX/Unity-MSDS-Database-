import java.util.Comparator;

//This class is used to 
public class MaterialNameComparator implements Comparator<Material> {

	@Override
	public int compare(Material mat1, Material mat2) {
		return mat1.getName().compareTo(mat2.getName());
	}
	// sorts the order which entities are rendered
	//private Comparator<Entity> renderSorter=new Comparator<Entity>(){
	//@Override 
	//public int compare(Material mat1, Material mat2) {
		//return mat1.getName().compareTo(mat2.getName());
	//}

	//};

	
}
