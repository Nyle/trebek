package trebek.result;

import java.util.List;
import java.util.ArrayList;

import java.util.Random;
import java.util.Date;
import java.sql.Timestamp;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;



public class ResultManager {
        DynamoDBMapper mapper;

        public ResultManager(AmazonDynamoDBClient client) {
                mapper = new DynamoDBMapper(client);       
        }

        public Result loadCurrentResult(String CustomerID) {
                DynamoDBScanExpression scanExpression =
                        new DynamoDBScanExpression();
                scanExpression.addFilterCondition(
                        "CustomerID", 
                        new Condition()
                        .withComparisonOperator(
                                ComparisonOperator.EQ)
                        .withAttributeValueList(
                                new AttributeValue().withS(CustomerID)));
                scanExpression.addFilterCondition(
                        "IsDone", 
                        new Condition()
                        .withComparisonOperator(ComparisonOperator.EQ)
                        .withAttributeValueList(
                                new AttributeValue().withN("0")));
                List<Result> scanResult = mapper.scan(Result.class,
                                                          scanExpression);
                Result res;
                if (scanResult.isEmpty()) {
                        res = new Result();
                        res.setCustomerID(CustomerID);
                        res.setIsDone(Boolean.FALSE);
                        res.setQuestion(0);
                        res.setResults(new ArrayList<Boolean>());
                        Date date = new Date();
                        Random rand = new Random(new Long(date.getTime()));
                        res.setSeed(rand.nextLong());
                } else {
                        System.out.println("loaded");
                        res = mapper.load(Result.class, scanResult.get(0).getId());
                }
                return res;
        }

        public void save(Result item) {
                mapper.save(item);
        }
}
