package entity;

public class Boots extends entity.Product {
    private Integer size;
    private boolean isNaturalSkin;

    public Boots(Long id, String productName, Float price, Float weight, String color, Integer productCount, Integer size, boolean isNaturalSkin) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNaturalSkin = isNaturalSkin;
    }

    public Integer getSize() {
        return size;
    }

    public boolean getIsNaturalSkin() {
        return isNaturalSkin;
    }

    @Override
    public String toString() {
        return "Boots{" +
                "size=" + size +
                ", isNaturalSkin=" + isNaturalSkin +
                "} " + super.toString();
    }
}
