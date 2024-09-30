package daos;

import entities.Hotel;
import entities.Room;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class HotelDAO extends DAO<Hotel>{

    EntityManager entityManager;


    public HotelDAO(EntityManager entityManager) {
        super(Hotel.class);
        this.entityManager = entityManager;
    }


    public List<Room> returnRooms(Hotel hotel) {
        TypedQuery<Room> query= em.createQuery("SELECT r FROM Room r WHERE r.hotel = :hotel", Room.class);
        query.setParameter("hotel", hotel);
        return query.getResultList();
    }


}






