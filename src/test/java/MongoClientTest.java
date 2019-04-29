/*import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;*/

public class MongoClientTest {



    /*@Before
public void setup() {
    System.out.println("Nothing to setup here");
}

        @Ignore
        @Test
        public void connectMongoDB() {


            String mongoUrl = "mongodb://miqapi-staging:XFDNTjgVxyypttzkLL0NtfOsdgs3eydV6T1YFiaOZDFfbTh6SuKSbJzq8rFBQ8uGOPusU8gOzGBb3NIunVJ0eA==@miqapi-staging.documents.azure.com:10255/azure-staging?ssl=true&replicaSet=globaldb";

            MongoClientURI mongoClientURI = new MongoClientURI(mongoUrl);

            MongoClient mongoClient = new MongoClient(mongoClientURI);


            MongoDatabase mongoDatabase = mongoClient.getDatabase("azure-staging");

            System.out.println(mongoDatabase.getName());

            MongoCollection<Document> documentMongoCollection = mongoDatabase.getCollection("email_verification");


            System.out.println(documentMongoCollection.getNamespace());

            Document document = new Document("_id", new ObjectId("5a66dfeb59438e000d69e7e7"));

            System.out.println(document);

            FindIterable<Document> documentMongoCursor = documentMongoCollection.find(document);

            Document targetDocument = documentMongoCursor.first();

            System.out.println(targetDocument.get("secret"));
        }*/
}
