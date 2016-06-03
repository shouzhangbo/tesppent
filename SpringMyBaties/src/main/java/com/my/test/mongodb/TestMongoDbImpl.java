package com.my.test.mongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.my.test.mapper.baseUser;

@Service
public class TestMongoDbImpl implements TestMongoDb{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void save(Object obj) {
		try{
			mongoTemplate.insert(obj);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public List<baseUser> find(String userName) {
		return mongoTemplate.find(Query.query(Criteria.where("userName").is(userName)), baseUser.class);
	}
	//分页
	public List<baseUser> getListByPage(Long vendorId,String batchNo,int pageNum,int pageSize){
        return this.mongoTemplate.find(Query.query(Criteria.where("vendorId").is(vendorId).and("batchNo").is(batchNo))
                .with(new Sort(Sort.Direction.ASC, "index"))
                .skip(pageSize * pageNum).limit(pageSize), baseUser.class);
    }

}
