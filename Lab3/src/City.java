import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class City {
    private String name;
    private List<Location> nodes = new ArrayList<>();
    //Constructors
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

    public void print()
    {
        System.out.println("City name : " + this.name);
        System.out.print("Locations : ");

        for(int i=0;i<nodes.size();i++)
            System.out.print(nodes.get(i).getName()+ " , ");
        System.out.println();
    }
    /*
     Prints cost table
     */

    public void costTable()
    {  System.out.println("Cost table");

        for(int i=0;i<nodes.size();i++)
        {
            Map<Location, Integer> nodeCost = new HashMap<>();
            nodeCost=nodes.get(i).getCost();
            for (Location name: nodeCost.keySet()){
                String key = name.getName();
                Integer value = nodeCost.get(name);
                System.out.println(nodes.get(i).getName() + " " + key + " " + value);
            }

        }

    }



    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", nodes=" + nodes +
                '}';
    }
}
