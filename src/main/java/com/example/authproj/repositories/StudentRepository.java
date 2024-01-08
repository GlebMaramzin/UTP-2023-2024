package com.example.authproj.repositories;

import com.example.authproj.models.Student;

public interface StudentRepository {

    Student findByFIO(String FIO);
}
