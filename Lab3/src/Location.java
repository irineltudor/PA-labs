import java.util.HashMap;
import java.util.Map;
public abstract class Location implements Comparable<Location>
{
    private Map<Location, Integer> cost = new HashMap<>();
    private String name;

    //… constructors, getters, setters
    Location(){}
    Location(String name)
    {
        this.name=name;
    }

    public Map<Location, Integer> getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Map<Location, Integer> cost) {
        this.cost = cost;
    }

    public void setCost(Location node, int value) {
        cost.put(node, value);
    }





    @Override
    public int compareTo(Location other) {
        if(other.name!=null&&this.name!=null)
        return this.name.compareTo(other.name);

        return 0;
    }
}
