package projet.wcs.starter.services;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;


@Service
public class RoomService {
    public static String generateRandomNumber()
    {
        int len = 8;
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }

    public static void main(String[] args)
    {

        System.out.println(generateRandomNumber());
    }




}
