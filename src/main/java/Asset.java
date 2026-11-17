import java.math.BigDecimal;

public class Asset {
    private String description;
    private String dateAcquired;
    private BigDecimal originalCost;

    public Asset(String description, String dateAcquired, BigDecimal originalCost) {
        this.description = description;
        this.dateAcquired = dateAcquired;
        this.originalCost = originalCost;
    }

    // returns original cost
   public BigDecimal getValue(){
       return this.originalCost;
   }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(String dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public BigDecimal getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(BigDecimal originalCost) {
        this.originalCost = originalCost;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Asset{");
        sb.append("description='").append(description).append('\'');
        sb.append(", dateAcquired='").append(dateAcquired).append('\'');
        sb.append(", originalCost=").append(originalCost);
        sb.append(", value=").append(this.getValue());
        sb.append('}');
        return sb.toString();
    }
}
