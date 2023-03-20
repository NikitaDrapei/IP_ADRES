import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        //Почему выбран тип long в описании к проектам
        long intIp;
        String ip = "128.32.39.0";//192.168.000.112

        intIp = ipToInt(ip);

        if (intIp == 0) {
            System.out.println("Введен неверный ip адрес");
        } else {
            System.out.println(intIp);
        }

        ip = intToIp(intIp);
        System.out.println(ip);

    }

    public static long ipToInt(String ip) {//Принимает ip адрес в виде строки
        long num = 0;//
        int oktNum = 0;//Количество октов
        String[] ipArray = ip.split("\\.");
        for (String okt : ipArray) {//Проверка на неправильный ip адрес, не может быть - и > 255
            if (Integer.parseInt(okt) < 0 || Integer.parseInt(okt) > 255) {
                return 0;
            }
            oktNum++;
        }
        if (oktNum != 4) {//Проверка на количество октов, строго 4 для ip4
            return 0;
        }
        for (int i = 0; i < ipArray.length; i++) {
            num += ((Integer.parseInt(ipArray[i]) % 256 * Math.pow(256, 3 - i)));
        }
        return num;
    }

    public static String intToIp(long intIp) {
        StringBuilder result = new StringBuilder();
//FF=255
        result.append((intIp >> 24) & 0xFF).append(".");
        result.append((intIp >> 16) & 0xFF).append(".");
        result.append((intIp >> 8) & 0xFF).append(".");
        result.append(intIp & 0xFF);

        return result.toString();
    }


}
