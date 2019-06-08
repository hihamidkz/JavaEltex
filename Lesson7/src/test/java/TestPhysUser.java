import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ru.eltex.users.PhysUser;

public class TestPhysUser {
    private PhysUser physUser;

    @Before
    public void setup() {
        physUser = new PhysUser();
    }

    @Test
    public void testSetFIO() {
        physUser.setFIO("Stephen King");
        String FIO = "Stephen King";
        Assert.assertEquals(physUser.getFIO(), FIO);
    }

    @Test
    public void testSetPhone() {
        physUser.setPhone("513-352-4792");
        String phone = "513-352-4792";
        Assert.assertEquals(physUser.getPhone(), phone);
    }

    @Test
    public void testSetAddress() {
        physUser.setAddress("4639 Burning Memory Lane");
        String address = "4639 Burning Memory Lane";
        Assert.assertEquals(physUser.getAddress(), address);
    }
}
