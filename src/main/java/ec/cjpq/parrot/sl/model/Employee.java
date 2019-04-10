package ec.cjpq.parrot.sl.model;

import lombok.Data;

@Data
public class Employee {
    private String login;
    private String name;
    private String p12Archivo;
    private String p12Clave;
    private String codEstabl;
    private String codPtoEmi;
    private String secFactura;
    private String secNcredito;
    private String secNdebito;
    private String secGremision;
    private String secCretencion;
    private String tipAmbiente;
}
