package Services;

import DataAccessObjects.ProduceDao;
import Interfaces.Service;
import Models.Entities.Batch;
import Models.Entities.Produce;
import Models.Entities.Standart;
import Models.Entities.Worker;

import java.util.List;

public class ProduceService implements Service<Produce> {
    private ProduceDao produceDao = new ProduceDao();

    @Override
    public Produce findEntity(int id) {
        Produce produce = produceDao.findById(id);
        Batch batch = produce.getfBatch();
        Worker worker = produce.getfWorker();
        Standart standart = produce.getfStandart();
        if (standart != null)
            standart.setProduces(null);
        if (batch != null) {
            batch.setfUser(null);
            batch.setfWorker(null);
            batch.setProduces(null);
        }
        if (worker != null) {
            worker.setProduces(null);
            worker.setBatches(null);
        }
        produce.setfBatch(batch);
        produce.setfWorker(worker);
        produce.setfStandart(standart);
        return produce;
    }

    @Override
    public void saveEntity(Produce entity) {
        produceDao.save(entity);
    }

    @Override
    public void deleteEntity(Produce entity) {
        produceDao.delete(entity);
    }

    @Override
    public void updateEntity(Produce entity) {
        produceDao.update(entity);
    }

    @Override
    public List<Produce> findAllEntities() {
        return produceDao.findAll();
    }
}
