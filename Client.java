package structual.DAO;

import java.util.List;
import java.util.Optional;

public class Client {
	private static DAO<User> userDAO;

	
	public static User getUser(long id) {
		Optional<User> user = userDAO.get(id);
		return user.orElseGet( () -> new User("non-existing user", "no-email"));
	}
	
	public static List<User> getAllUsers(){
		return userDAO.getAll();
	}
	
	public static void updateUser(User user, String[]params) {
		userDAO.update(user, params);
	}
	
	public static void saveUser(User user) {
		userDAO.save(user);
	}
	
	public static void deleteUser(User user) {
		userDAO.delete(user);
	}
	
	public static void main(String[] args) {
		User user1 = getUser(1);
        System.out.println(user1);
        updateUser(user1, new String[]{"Jake", "jake@domain.com"});
        saveUser(new User("Monica", "monica@domain.com"));
        deleteUser(getUser(2));
        getAllUsers().forEach(user -> System.out.println(user.getName()));
	}
}
