import java.math.BigDecimal;

public class Cash extends Asset {

    private String location;

    public Cash(String description, String dateAcquired,
                BigDecimal originalCost, String location) {

        super(description, dateAcquired, originalCost);
        this.location = location;
    }

    @Override
    public BigDecimal getValue() {
        return getOriginalCost();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}