package com.ertgamgam.sampleapi.repository;

import com.ertgamgam.sampleapi.entity.Student;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "student")
public interface StudentRepository extends CouchbasePagingAndSortingRepository<Student,String> {


     List<Student> findByName(String name);

     @Query("SELECT META().id AS _ID, META().cas AS _CAS,name,dictionary FROM sampleapi")
     List<Student> customGetAll(Pageable pageable);
}
