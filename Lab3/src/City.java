import javax.sound.sampled.FloatControl;
import java.util.*;

public class City {
    private String name;
    protected List<Location> nodes = new ArrayList<>();

    //Constructors
    City(){}
    City(String name)
    {
        this.name=name;
    }
   //Setter
   public void setName(String name) {
       this.name = name;
   }

    public void addLocation(Location node) {
        nodes.add(node);
    }



    public void visitableFree()
    {
        List<Location> visitableFree= new ArrayList<>();
        for (Location node : this.nodes) {
            if (node instanceof Church) {
                visitableFree.add(node);
            }
        }

        visitableFree.sort(new Comparator<>() {

            public int compare(Location o1, Location o2) {

                return ((Church) o1).getOpeningTime().compareTo(((Church) o2).getOpeningTime());
            }
        });

        for (Location location : visitableFree)
            System.out.println(location.getName() + " " + ((Church) location).getOpeningTime());



    }


    public void print()
    {
        System.out.println("City name : " + this.name);
        System.out.print("Locations : ");

        for (Location node : nodes) System.out.print(node.getName() + " , ");
        System.out.println();
    }
    /*
     Prints cost table
     */

    public void costTable()
    {  System.out.println("Cost table");

        for (Location node : nodes) {
            Map<Location, Integer> nodeCost ;
            nodeCost = node.getCost();
            for (Location name : nodeCost.keySet()) {
                String key = name.getName();
                Integer value = nodeCost.get(name);
                System.out.println(node.getName() + " " + key + " " + value);
            }

        }

    }
    public int[][] createMatrix()
    {  int[][] matrix=new int[100][100];
        for(int i=0;i<nodes.size();i++)
        {
            Map<Location, Integer> nodeCost;
            nodeCost=nodes.get(i).getCost();
            for (Location name: nodeCost.keySet()){
                String key = name.getName();
                Integer value = nodeCost.get(name);
                matrix[i][nodes.indexOf(name)]=value;

            }

        }
        return matrix;

    }



    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", nodes=" + nodes +
                '}';
    }
}
