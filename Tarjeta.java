public class Tarjeta {
    private String codigo;
    private Integer codVerificacion;
    private Usuario propietario;

    public Tarjeta(String codigo,Integer codVerificacion, Usuario propietario) {
        this.codigo = codigo;
        this.codVerificacion = codVerificacion;
        this.propietario = propietario;
    }
    public Boolean veriFicacionCodigoSeguridad(){
        Integer c1,c2,c3;
        c1=Integer.parseInt(""+this.codigo.charAt(4));
        c2=Integer.parseInt(""+this.codigo.charAt(8));
        c3=Integer.parseInt(""+this.codigo.charAt(12));
        Integer multiplicacion=c1*c2*c3;
        if(multiplicacion.equals(this.codVerificacion)){
            return true;
        }else{
        return false;
        }
    }
    
    public Tarjeta(){

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCodVerificacion() {
        return codVerificacion;
    }

    public void setCodVerificacion(Integer codVerificacion) {
        this.codVerificacion = codVerificacion;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }
}
