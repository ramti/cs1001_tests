import il.ac.tau.cs.software1.ip.*;
import org.junit.Test;


public class TestIPAddress {
    private void checkIPOctets(IPAddress address, short[] expected) {
        for (int i = 0; i <= 3; i++) {
            assert address.getOctet(i) == expected[i];
        }
    }

    @Test
    public void testIPAddress() {
        int address1 = -1062731775; // 192.168.0.1
        short[] address2 = { 10, 1, 255, 1 }; // 10.1.255.1

        IPAddress ip1 = IPAddressFactory.createAddress(address1);
        IPAddress ip2 = IPAddressFactory.createAddress(address2);
        IPAddress ip3 = IPAddressFactory.createAddress("127.0.0.1");
        IPAddress ip4 = IPAddressFactory.createAddress("10.1.255.1");

        checkIPOctets(ip1, new short[]{192, 168, 0, 1});
        checkIPOctets(ip2, new short[]{10, 1, 255, 1});
        checkIPOctets(ip3, new short[]{127, 0, 0, 1});

        assert ip1.toString().equals("192.168.0.1");
        assert ip2.toString().equals("10.1.255.1");
        assert ip3.toString().equals("127.0.0.1");

        assert ip1.isPrivateNetwork();
        assert ip2.isPrivateNetwork();
        assert !ip3.isPrivateNetwork();

        assert !ip1.equals(ip2);
        assert ip2.equals(ip4);
    }
}
