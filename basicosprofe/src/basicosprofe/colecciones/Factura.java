package basicosprofe.colecciones;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record Factura(
        Integer idFactura,
        Integer idCliente,
        String numFactura,
        LocalDate fechaEmision,
        String estado,
        String observaciones,
        Integer subtotal,
        Integer importeIva,
        Integer total,
        LocalDateTime fechaCreacion,
        LocalDateTime fechaActualizacion
) {

}
