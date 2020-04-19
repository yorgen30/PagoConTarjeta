public class Venta {
    private Float valorVenta;
    private Integer descuento;
    private Integer valorIva;

    public Venta(Float valorVenta, Integer descuento, Integer valorIva) {
        this.valorVenta = valorVenta;
        this.descuento = descuento;
        this.valorIva = valorIva;
    }
    
    public Venta()
           {}
    public Float getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(Float valorVenta) {
        this.valorVenta = valorVenta;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public Integer getValorIva() {
        return valorIva;
    }

    public void setValorIva(Integer valorIva) {
        this.valorIva = valorIva;
    }
    
}