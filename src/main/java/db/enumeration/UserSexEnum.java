package db.enumeration;

public enum UserSexEnum {
    Man((byte) 0),Girl((byte) 1);
    private byte sexNumber;

    UserSexEnum(byte b) {
        sexNumber=b;
    }

    public static UserSexEnum getUserSexEnum(int typeNumber){
        switch (typeNumber){
            case 0:
                return Man;
            case 1:
                return Girl;

                default:
                    return null;
        }
    }

    public byte getSexNumber() {
        return sexNumber;
    }

    public void setSexNumber(byte sexNumber) {
        this.sexNumber = sexNumber;
    }


}
