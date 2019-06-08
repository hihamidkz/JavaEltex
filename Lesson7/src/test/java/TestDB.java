import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import ru.eltex.database.DB;
import ru.eltex.users.PhysUser;
import ru.eltex.users.User;

public class TestDB {
	private static PhysUser testUser;

	@BeforeClass
	public static void setup() {
		testUser = new PhysUser();
		testUser.setFIO("Stephen King");
		testUser.setPhone("513-352-4792");
		testUser.setAddress("4639 Burning Memory Lane");
		DB.insertUser(testUser);
	}

	@Test
	public void testGetUserById() {
		User actualUser = DB.getUserById(testUser.getId());
		Assert.assertEquals(testUser.getFIO(), ((PhysUser)actualUser).getFIO());
		Assert.assertEquals(testUser.getPhone(), ((PhysUser)actualUser).getPhone());
		Assert.assertEquals(testUser.getAddress(), ((PhysUser)actualUser).getAddress());
	}

	@Test
	public void testGetPhoneById() {
		String expectedPhone = testUser.getPhone();
		String actualPhone = DB.getPhoneById(testUser.getId());
		Assert.assertEquals(expectedPhone, actualPhone);
	}

	@Test
	public void testGetPhoneByName() {
		String expectedPhone = testUser.getPhone();
		String actualPhone = DB.getPhoneByName(testUser.getFIO());
		Assert.assertEquals(expectedPhone, actualPhone);
	}

	@AfterClass
	public static void after() {
		DB.deleteUserById(testUser.getId());
	}
}
