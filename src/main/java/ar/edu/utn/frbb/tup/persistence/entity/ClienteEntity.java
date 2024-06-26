package ar.edu.utn.frbb.tup.persistence.entity;

import ar.edu.utn.frbb.tup.model.Cliente;
import ar.edu.utn.frbb.tup.model.Cuenta;
import ar.edu.utn.frbb.tup.model.TipoPersona;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteEntity extends BaseEntity {

    private final String tipoPersona;
    private final String nombre;
    private final String apellido;
    private final LocalDate fechaAlta;
    private final LocalDate fechaNacimiento;
    private List<Long> cuentas;

    public ClienteEntity(Cliente cliente) {
        super(cliente.getDni());
        this.tipoPersona = cliente.getTipoPersona().getDescripcion();
        this.nombre = cliente.getNombre();
        this.apellido = cliente.getApellido();
        this.fechaAlta = cliente.getFechaAlta();
        this.fechaNacimiento = cliente.getFechaNacimiento();
        if (cliente.getCuentas() != null && !cliente.getCuentas().isEmpty()) {
            this.cuentas = new ArrayList<>();
            for (Cuenta c: cliente.getCuentas()) {
                cuentas.add(Long.parseLong(c.getNumeroCuenta()));
            }
        }
    }

    public void addCuenta(Cuenta cuenta) {
        if (cuentas == null){
            cuentas = new ArrayList<>();
        }
        cuentas.add(Long.parseLong(cuenta.getNumeroCuenta()));
    }

    public Cliente toCliente() {
        Cliente cliente = new Cliente();
        cliente.setDni(this.getId());
        cliente.setNombre(this.nombre);
        cliente.setApellido(this.apellido);
        cliente.setTipoPersona(TipoPersona.fromString(this.tipoPersona));
        cliente.setFechaAlta(this.fechaAlta);
        cliente.setFechaNacimiento(this.fechaNacimiento);
        return cliente;
    }
}
