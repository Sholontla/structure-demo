package secure.vault.demo.repositories;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndReplaceOptions;

import secure.vault.demo.entities.DataVault;
import secure.vault.demo.entities.TestingEntity;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.ReturnDocument.AFTER;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DataVaultRepository implements IDataVaultRepository {

    private final MongoClient client;
    private MongoCollection<DataVault> dataVaultCollection;

    public DataVaultRepository(MongoClient mongoClient) {
        this.client = mongoClient;
    }

    @PostConstruct
    void init() {
        dataVaultCollection = client.getDatabase("test").getCollection("data-vault", DataVault.class);
    }

    @Override
    public DataVault save(DataVault person) {
        person.setId(new ObjectId());
        dataVaultCollection.insertOne(person);
        return person;
    }

    @Override
    public DataVault findOne(String id) {
        return dataVaultCollection.find(eq("_id", new ObjectId(id))).first();
    }

    @Override
    public DataVault findDriver(String driver) {
        return dataVaultCollection.find(eq("driver", new ObjectId(driver))).first();
    }
    
    @Override
    public DataVault findByDriver(String driver) {
        return dataVaultCollection.find(eq("driver", driver)).first();
    }
    
    @Override
    public long delete(String id) {
        return dataVaultCollection.deleteOne(eq("_id", new ObjectId(id))).getDeletedCount();
    }

    @Override
    public DataVault update(DataVault person) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().returnDocument(AFTER);
        return dataVaultCollection.findOneAndReplace(eq("_id", person.getId()), person, options);
    }

    @Override
    public List<TestingEntity> getTesting(String userId) {
        List<TestingEntity> returnValue = new ArrayList<>();
        
        TestingEntity albumEntity = new TestingEntity();
        albumEntity.setUserId(userId);
        albumEntity.setAlbumId("album1Id");
        albumEntity.setDescription("album 1 description");
        albumEntity.setId(1L);
        albumEntity.setName("album 1 name");
        
        TestingEntity albumEntity2 = new TestingEntity();
        albumEntity2.setUserId(userId);
        albumEntity2.setAlbumId("album2Id");
        albumEntity2.setDescription("album 2 description");
        albumEntity2.setId(2L);
        albumEntity2.setName("album 2 name");
        
        returnValue.add(albumEntity);
        returnValue.add(albumEntity2);
        
        return returnValue;
    }

}
