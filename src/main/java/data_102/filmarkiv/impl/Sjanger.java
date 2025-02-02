package data_102.filmarkiv.impl;

public enum Sjanger {
    ACTION, DRAMA, HISTORY, SCIFI, ROMCOM;

    public static Sjanger finnSjanger(String navn) {
        for (Sjanger s : Sjanger.values()) {
            if (s.toString().equalsIgnoreCase(navn)) {
                return s;
            }
        }
        return null;
    }
}
