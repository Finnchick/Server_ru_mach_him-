package Services;

import DataAccessObjects.BatchDao;
import Interfaces.Service;
import Models.Entities.Batch;
import Models.Entities.Produce;
import Models.Entities.User;
import Models.Entities.Worker;

import java.util.List;
import java.util.Set;

public class BatchService implements Service<Batch> {
    private BatchDao batchDao = new BatchDao();

    @Override
    public Batch findEntity(int id) {
        Batch batch = batchDao.findById(id);
        Set<Produce> produces = batch.getProduces();
        Worker worker = batch.getfWorker();
        User user = batch.getfUser();
        worker.setProduces(null);
        worker.setBatches(null);
        for (Produce produce:
             produces) {
            produce.setfBatch(null);
            produce.setfWorker(null);
            produce.setfStandart(null);
        }
        user.setBatches(null);
        batch.setProduces(produces);
        batch.setfWorker(worker);
        batch.setfUser(user);
        return batch;
    }

    @Override
    public void saveEntity(Batch entity) {
        batchDao.save(entity);
    }

    @Override
    public void deleteEntity(Batch entity) {
        batchDao.delete(entity);
    }

    @Override
    public void updateEntity(Batch entity) {
        batchDao.update(entity);
    }

    @Override
    public List<Batch> findAllEntities() {
        return batchDao.findAll();
    }
}
