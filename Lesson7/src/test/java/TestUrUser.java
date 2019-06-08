import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ru.eltex.users.UrUser;

public class TestUrUser {
    private UrUser urUser;

    @Before
    public void setup() {
        urUser = new UrUser();
    }

    @Test
    public void testSetFIO() {
        urUser.setFIO("Gloria F. Marshall");
        String FIO = "Gloria F. Marshall";
        Assert.assertEquals(urUser.getFIO(), FIO);
    }

    @Test
    public void testSetPhone() {
        urUser.setPhone("215-251-2748");
        String phone = "215-251-2748";
        Assert.assertEquals(urUser.getPhone(), phone);
    }

    @Test
    public void testSetRegistrationDate() {
        urUser.setRegistrationDate("2018-08-22");
        String registrationDate = "2018-08-22";
        Assert.assertEquals(urUser.getRegistrationDate(), registrationDate);
    }
}
