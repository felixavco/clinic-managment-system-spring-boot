package com.clinicmanagementsystem.api.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.clinicmanagementsystem.api.models.entities.User;

public interface IUserDao extends CrudRepository<User, Long> {

}
