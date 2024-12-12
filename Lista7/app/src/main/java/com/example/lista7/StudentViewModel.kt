package com.example.lista7

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lista7.data.dummyStudents
import com.example.lista7.model.Student

class StudentViewModel : ViewModel() {
    private val _students = MutableLiveData(dummyStudents)
    val students: LiveData<List<Student>> = _students

    private val _selectedStudent = MutableLiveData<Student?>()
    val selectedStudent: LiveData<Student?> = _selectedStudent

    fun selectStudent(student: Student) {
        _selectedStudent.value = student
    }
}
