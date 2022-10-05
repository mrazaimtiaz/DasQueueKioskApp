package com.gicproject.kcbsignatureapp.domain.use_case

import com.gicproject.dasdoctorcvapp.domain.use_case.GetEmployeeData
import com.gicproject.dasdoctorcvapp.domain.use_case.GetEmployeeSignature
import com.gicproject.dasdoctorcvapp.domain.use_case.GetResult

data class MyUseCases(
    val getResult: GetResult,
    val getEmployeeData: GetEmployeeData,
    val getEmployeeSignature: GetEmployeeSignature,
    val addEmployeeData: AddEmployeeData,
)
