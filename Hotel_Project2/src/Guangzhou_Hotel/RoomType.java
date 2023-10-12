package Guangzhou_Hotel;

public class RoomType {
    private String type;
    private int rate;

    public RoomType(String type, int rate){
        this.type = type;
        this.rate = rate;
    }

    public String getType(){
        return type;
    }
    public int getRate(){
        return rate;
    }
}
