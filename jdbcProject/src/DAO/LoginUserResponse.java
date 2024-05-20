package DAO;

public record LoginUserResponse(
		String username,
		String password,
		int isAdmin
		) {
	
}
