package Services;

import DataAccessObjects.UserDao;
import Interfaces.Service;
import Models.Entities.Batch;
import Models.Entities.User;

import java.util.List;
import java.util.Set;

public class UserService implements Service<User> {
    private UserDao userDao = new UserDao();
    @Override
    public User findEntity(int id) {
        User user = userDao.findById(id);
        Set<Batch> batches =  user.getBatches();
        for (Batch batch:
             batches) {
            batch.setProduces(null);
            batch.setfWorker(null);
            batch.setfUser(null);
        }
        user.setBatches(batches);
        return user;
    }

    @Override
    public void saveEntity(User entity) {
        userDao.save(entity);
    }

    @Override
    public void deleteEntity(User entity) {
        userDao.delete(entity);
    }

    @Override
    public void updateEntity(User entity) {
    userDao.update(entity);
    }

    @Override
    public List<User> findAllEntities() {
        return userDao.findAll();
    }
}
