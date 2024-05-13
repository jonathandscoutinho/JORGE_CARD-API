package com.example.jorgecardproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.jorgecardproject.model.User;
import com.example.jorgecardproject.repository.IUser;

@Service
public class UserService {

	//instanciação do CRUD Repository
	private IUser repository;
	
	//Construtor do objeto repository acima
	public  UserService(IUser repository) {
		this.repository = repository;
	}
	
	//GET
	public List<User> listarUsuario(){
		List<User> Lista = (List<User>) repository.findAll();
		return Lista;
	}
	
	//POST
	public User criarUsuario(User user) {
		User usuarioNovo = repository.save(user);
		return usuarioNovo;
	}
	
	//PUT
	public User editarUsuario(User user) {
		User usuarioNovo = repository.save(user);
		return usuarioNovo;
	}
	
	//DELETE
	public Boolean excluirUsuario(Integer id) {
		repository.deleteById(id);
		return true;
	}
		
}
