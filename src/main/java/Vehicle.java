import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Year;

public class Vehicle extends Asset{
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, BigDecimal originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    @Override
    public BigDecimal getValue() {
        int age = Math.max(0, Year.now().getValue() - year);
        BigDecimal value = valueBeforeMileage(age);

        boolean isExempt =
                (this.makeModel.toLowerCase().contains("honda"))
                        ||
                        (this.makeModel.toLowerCase().contains("toyota"));

        if(!isExempt){
            if(odometer > 100_000){
                value = value.multiply(new BigDecimal("0.75"));
            }
        }

        return value.setScale(2, RoundingMode.HALF_UP);

    }







    private BigDecimal valueBeforeMileage(int age) {
        if (age > 10) {
            return new BigDecimal("1000.00");
        }

        int annualPercent;
        if (age <= 3) {
            annualPercent = 3;
        } else if (age <= 6) {
            annualPercent = 6;
        } else {
            annualPercent = 8;
        }

        // Apply the rate for the current age bracket to each year of age.
        BigDecimal depreciationRate = BigDecimal.valueOf((long) age * annualPercent, 2);
        return getOriginalCost().multiply(BigDecimal.ONE.subtract(depreciationRate));
    }




    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
}
