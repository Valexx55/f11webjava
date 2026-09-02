package basicosprofe.colecciones;

import java.time.LocalDate;

public record Cliente(
        Integer idCliente,
        String nombre,
        String nifCif,
        String direccion,
        String codigoPostal,
        String poblacion,
        String provincia,
        String telefono,
        String email,
        LocalDate fechaAlta
) {

}
