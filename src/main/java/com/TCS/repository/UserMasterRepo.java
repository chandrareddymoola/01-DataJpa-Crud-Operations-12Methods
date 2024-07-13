package com.TCS.repository;

import com.TCS.entities.UserMasterEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMasterRepo extends CrudRepository<UserMasterEntity,Integer> {
//select * from user_master where user_city="Pcpalli";
    public List<UserMasterEntity> findByCity(String city);
    //select * from user_master where user_gender="Female"
    public List<UserMasterEntity> findByGender(String gender);
    //select * from user_master where user_age>=25;
    public List<UserMasterEntity>findByAgeGreaterThanEqual(int age);
    //select user_email from user_master where user_city="Pcpalli";
    public List<UserMasterEntity>findByGenderAndCity(String gender, String city);
    //select email from UserMasterEntity where city=:City
    @Query("select email from UserMasterEntity where city=:city")
    public List<String>getPcpalliEmails(String city);

    @Query("from UserMasterEntity")
    public List<UserMasterEntity>getAllUsers();
    //@Query(value="select * from user_master",nativeQuery = true)//writing actual sql query for custom methods
    //public List<UserMasterEntity>getAllUsersSql();


    @Query("update UserMasterEntity set age= :age where id=:uid ")
    @Transactional
    @Modifying
    public void UpdateAgeById(int age, int uid);


    @Query("delete from UserMasterEntity where id= :uid")
    @Transactional
    @Modifying
    public void DeleteById(int uid);

}
