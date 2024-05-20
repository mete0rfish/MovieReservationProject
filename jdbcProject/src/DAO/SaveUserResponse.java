package DAO;

import Domain.User;

public record SaveUserResponse(
		String username,
		String password,
		String name,
		String phoneNum,
		String email
		) {
	
	public User toUser() {
        return new User(username, password, name, phoneNum, email);
    }
}
