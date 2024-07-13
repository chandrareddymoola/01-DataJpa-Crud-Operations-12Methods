package com.TCS.service;

import com.TCS.entities.UserMasterEntity;
import com.TCS.repository.UserMasterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserMasterRepo userMasterRepo;


    public void testFindByMethods(){
        List<UserMasterEntity> entities=userMasterRepo.findByCity("Pcpalli");
        entities.forEach(entity->{
            System.out.println(entity);
        });
       // userMasterRepo.UpdateAgeById(30,103);
       // userMasterRepo.deleteById(308);
    }

    public void findBygender(){
        List<UserMasterEntity> entities1=userMasterRepo.findByGender("Female");
        entities1.forEach(genentity->{
            System.out.println(genentity);
        });
    }

    public void CustomQueryUpdate(){
        userMasterRepo.UpdateAgeById(20,103);

    }
    public void CustomQueryDelete(){
        userMasterRepo.DeleteById(208);
    }

    public void findByAgeGraterThanEqualTo(){
        List<UserMasterEntity> entitiesage =userMasterRepo.findByAgeGreaterThanEqual(25);
        entitiesage.forEach(age->{
            System.out.println(age);
        });
    }
    public void findbygenderandcity(){
        List<UserMasterEntity> genderandcity=userMasterRepo.findByGenderAndCity("Male","Pcpalli");
        genderandcity.forEach(GCITY->{
            System.out.println(GCITY);
        });
    }

    public void testCustomQueries(){
        List<String> emails=userMasterRepo.getPcpalliEmails("Pcpalli");
        emails.forEach(email->{
            System.out.println(email);
        });
    }
    public void getAllUsers(){
        List<UserMasterEntity> totalusers=userMasterRepo.getAllUsers();
        totalusers.forEach(AllUsers->{
            System.out.println(AllUsers);
        });
    }

    public void getUser(){
        Optional<UserMasterEntity> findById= userMasterRepo.findById(108);
        if(findById.isPresent()){
            System.out.println(findById.get());
        }
        else{
            System.out.println("Record is not availale");
        }
    }
    public void getUsers(){
        List<Integer> Ids=Arrays.asList(101,102,103,104,105);
     //  Iterable<UserMasterEntity> entities =userMasterRepo.findAllById(Ids);// prints specific elements
        Iterable<UserMasterEntity> entities =userMasterRepo.findAll();// prints all elements


        entities.forEach(e->{
            System.out.println(e);
        });
    }

    public void deleteUsers(){
        userMasterRepo.deleteById(1000);
       // userMasterRepo.deleteAll();
        userMasterRepo.deleteAllById(Arrays.asList(101,102));
    }
    public void test(){
       long count= userMasterRepo.count();
        System.out.println("total records in the count"+count);
        System.out.println("check the record ids exists or not"+userMasterRepo.existsById(101));
    }

    public void saveUser() {
        UserMasterEntity entity = new UserMasterEntity();
        entity.setId(508);
        entity.setName("abchdh");
        entity.setEmail("chandra234nn@gmail.com");
        entity.setCity("Pcpalli");
        entity.setAge(27);
        entity.setGender("Male");
        //insert the record by using save method
        userMasterRepo.save(entity);
        System.out.println(entity);
        System.out.println("saving the columns in database is completed");
// UPSERT-----> update+Insert
        UserMasterEntity entity1 = new UserMasterEntity();
        entity1.setId(108);
        entity1.setName("abchdh");
        entity1.setEmail("chandra234nn@gmail.com");
        entity1.setCity("Pcpalli");
        entity1.setAge(27);
        entity1.setGender("Male");
        //insert the record by using save method
//        userMasterRepo.save(entity1);
//        System.out.println(entity1);
//        System.out.println("saving the columns in database is completed");

        UserMasterEntity entity2 = new UserMasterEntity();
        entity2.setId(608);
        entity2.setName("abchdh");
        entity2.setEmail("chandra234nn@gmail.com");
        entity2.setCity("Pcpalli");
        entity2.setAge(27);
        entity2.setGender("Male");
        //insert the record by using save method
//        userMasterRepo.save(entity2);
//        System.out.println(entity2);
//        System.out.println("saving the columns in database is completed");
       List<UserMasterEntity> entitiesList= Arrays.asList(entity,entity1,entity2);
       userMasterRepo.saveAll(entitiesList);
        System.out.println("----------------Done ------------");

        }

    }



