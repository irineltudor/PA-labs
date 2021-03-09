import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Hotel[] hotels=new Hotel[1];
        hotels[0]=new Hotel("Hotel");

        Museum[] museums=new Museum[2];
        museums[0]=new Museum("Museum A");
        museums[1]=new Museum("Museum B");

        Church[] churches=new Church[2];
        churches[0]=new Church("Church A");
        churches[1]=new Church("Church B");
        churches[0].setOpeningTime(LocalTime.of(10,30));
        churches[1].setOpeningTime(LocalTime.of(9,30));

        Restaurant[] restaurants=new Restaurant[1];
        restaurants[0]=new Restaurant("Restaurant");

        hotels[0].setCost(museums[0],10);
        hotels[0].setCost(museums[1],50);
        museums[0].setCost(museums[1],20);
        museums[1].setCost(museums[0],20);
        museums[0].setCost(churches[0],20);
        museums[0].setCost(churches[1],10);
        museums[1].setCost(churches[0],20);
        churches[0].setCost(churches[1],30);
        churches[1].setCost(churches[0],30);
        churches[0].setCost(restaurants[0],10);
        churches[1].setCost(restaurants[0],20);



        City firstCity=new City("Unknown");
        firstCity.addLocation(hotels[0]);
        firstCity.addLocation(museums[0]);
        firstCity.addLocation(museums[1]);
        firstCity.addLocation(churches[0]);
        firstCity.addLocation(churches[1]);
        firstCity.addLocation(restaurants[0]);

        firstCity.print();
        firstCity.costTable();
        firstCity.visitableFree();


        firstCity.createMatrix();

        TravelPlan travel=new TravelPlan("prima excursie",firstCity);


        travel.shortestPath(hotels[0],churches[1]);
        travel.shortestPath(hotels[0],restaurants[0]);








    }
}
