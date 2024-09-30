package daos;

import entities.Hotel;
import entities.Room;
import jakarta.persistence.EntityManager;

public class RoomDAO extends DAO<Room> {

    EntityManager entityManager;

    public RoomDAO(EntityManager entityManager) {
        super(Room.class);
        this.entityManager = entityManager;
    }
}
