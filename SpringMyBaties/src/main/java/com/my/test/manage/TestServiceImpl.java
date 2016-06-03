package com.my.test.manage;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.my.test.dao.BaseUserDao;
import com.my.test.dao.UserInfoDao;
import com.my.test.mapper.baseUser;
import com.my.test.mapper.userInfo;

@Service
@Transactional(rollbackFor=Exception.class)
public class TestServiceImpl implements TestService {

	@Autowired
    BaseUserDao baseDao;
	@Autowired
	UserInfoDao userInfoDao;
//	@Autowired
	private PlatformTransactionManager transactionManager;
	@Override
	public Boolean testt(){
		TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                try {
                	baseUser base = new baseUser();
        			base.setUserName("hzb");
        			base.setUserPwd("hzb");
        			base.setUserStatus(1);
        			base.setCreatedate(new Date());
        			base.setModifydate(new Date());
        			baseDao.save(base);
        			
        			
        			userInfo user = new userInfo();
        			userInfoDao.save(user);
                    return true;
                }catch (Exception e){
                    transactionStatus.setRollbackOnly();
                    return false;
                }
            }
        });
        return true;
	}
//	@Transactional(rollbackFor={Exception.class}) 
	@Override
	public void test(baseUser base,userInfo user){
		try{
			base.setCreatedate(new Date());
			base.setModifydate(new Date());
			baseDao.save(base);
			
			
			user.setCreatedate(new Date());
			user.setModifydate(new Date());
			userInfoDao.save(user);
			
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("Error");
		}
	}
	
	public TransactionTemplate getDataSourceTransactionManager() {
        return new TransactionTemplate(this.transactionManager);
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
}
