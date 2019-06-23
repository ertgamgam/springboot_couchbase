package com.ertgamgam.sampleapi.repository;

import com.ertgamgam.sampleapi.entity.Lesson;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "student")
public interface LessonRepository extends CouchbasePagingAndSortingRepository<Lesson,String> {


}
