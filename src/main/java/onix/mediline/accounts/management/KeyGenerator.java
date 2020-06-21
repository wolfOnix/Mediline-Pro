package onix.mediline.accounts.management;

public class KeyGenerator {

    public static String generateKey (int lung) {
        int i;
        String domeniu = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder cheie = new StringBuilder(lung);
        for (i = 0; i < lung; i++)
        {
            int index = (int) (domeniu.length() * Math.random());
            cheie.append (domeniu.charAt(index));
        }
        return cheie.toString();
    }

}
