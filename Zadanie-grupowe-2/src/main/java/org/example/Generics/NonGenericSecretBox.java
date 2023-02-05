package org.example.Generics;

public class NonGenericSecretBox {
    private Object secretValue;
    private String password;

    public NonGenericSecretBox(Object secretValue, String password) {
        this.secretValue = secretValue;
        this.password = password;
    }

    public Object tryOpen(String password) throws InvalidPasswordException {
        if (this.password.equals(password)) {
            return this.secretValue;
        }
        else {
            throw new InvalidPasswordException();
        }
    }

    public static void example() {
        NonGenericSecretBox box = new NonGenericSecretBox(100, "qwerty");
        try {
            Integer valueFromBox = (Integer) box.tryOpen("qwerty");
            System.out.println(valueFromBox);
        }
        catch (InvalidPasswordException e) {
            System.out.println("Provided password is invalid!");
        }
        catch (ClassCastException e) {
            System.out.println("Casted type is mismatched!");
        }
    }
}
