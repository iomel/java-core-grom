package lesson8.accounts.Ads;

public class HouseAd extends Ad{
    String ownerName;
    String address;
    double square;
    int flors;

    public HouseAd(long id, int price, String ownerName, String address, double square, int flors) {
        super(id, price);
        this.ownerName = ownerName;
        this.address = address;
        this.square = square;
        this.flors = flors;
    }

    boolean checkOwner()
    {
        Owners ow = new Owners();
        for (String o : ow.owners)
            if (ownerName == o)
                return true;
        return false;
    }
}
