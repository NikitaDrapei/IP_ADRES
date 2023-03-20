import inet.ipaddr.IPAddressString;
import inet.ipaddr.ipv4.IPv4Address;

public class Runner2_withLibrary {
    public static void main(String[] args) {

        String ip = "0.0.0.255";
        int intIp = 25672341;

        try {//ip to int
            IPv4Address intToIp = new IPAddressString(ip).getAddress().toIPv4();
            int intIpi = intToIp.intValue();
            System.out.println(intIpi);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        try {//int to ip
            IPv4Address intToIp = new IPv4Address(intIp);
            System.out.println(intToIp);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }


    }
}
