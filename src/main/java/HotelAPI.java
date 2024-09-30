import Controller.HotelController;
import Controller.RoomController;
import config.HibernateConfig;
import daos.HotelDAO;
import daos.RoomDAO;
import io.javalin.Javalin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;


public class HotelAPI {

    public static HotelController hotelController;

    public static RoomController roomController;

    public static HotelDAO hotelDAO;

    public static RoomDAO roomDAO;

    public static void main(String[] args) {


        EntityManagerFactory emf =HibernateConfig.getEntityManagerFactory("hotel");

        EntityManager entityManager = emf.createEntityManager();

        hotelDAO = new HotelDAO(entityManager);
        roomDAO = new RoomDAO(entityManager);

        hotelController = new HotelController(hotelDAO);
        roomController= new RoomController(roomDAO,hotelDAO);




        Javalin app = Javalin.create().start(7777);


        app.get("/hotels",hotelController::getAllHotels);
        app.get("/hotel/{id}",hotelController::getHotelById);
        app.post("/hotel",hotelController::createHotel);

        app.get("/rooms",roomController::getAllRooms);
        app.get("/room/{id}",roomController::getRoomById);
        app.post("/hotel/{hotelId}/room", roomController::createRoom);

        app.get("hotel/{id}/rooms", hotelController::getRoomsByHotelId);


    }

}
