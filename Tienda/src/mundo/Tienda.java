/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Programa de Ingenier�a de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Desarrollo de Software - Gu�a 2 - Actividad 2 Ejercicio: tienda
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package mundo;

/**
 * Tienda que maneja 4 productos.
 */
public class Tienda {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Producto 1 de la tienda.
     */
    private Producto producto1;

    /**
     * Producto 2 de la tienda.
     */
    private Producto producto2;

    /**
     * Producto 3 de la tienda.
     */
    private Producto producto3;

    /**
     * Producto 4 de la tienda.
     */
    private Producto producto4;

    /**
     * Dinero total recibido por las ventas.
     */
    private double dineroEnCaja;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Crea la tienda con sus 4 productos. <br>
     * <b> post: </b> El dinero en caja fue inicializado en 0.<br>
     * Los 4 productos fueron inicializados con los siguientes valores: <br>
     * Producto 1 - Tipo: PAPELERIA, Nombre: L�piz, Valor unitario: 550.0,
     * Cantidad en bodega: 18, Cantidad m�nima: 5, Imagen: lapiz.png. <br>
     * Producto 2 - Tipo: DROGUERIA, Nombre: Aspirina, Valor unitario: 109.5,
     * Cantidad en bodega: 25, Cantidad m�nima: 8, Imagen: aspirina.png. <br>
     * Producto 3 - Tipo: PAPELERIA, Nombre: Borrador, Valor unitario: 207.3,
     * Cantidad en bodega: 30, Cantidad m�nima: 10, Imagen: borrador.png. <br>
     * Producto 4 - Tipo: SUPERMERCADO, Nombre: Pan, Valor unitario: 150.0,
     * Cantidad en bodega: 15, Cantidad m�nima: 20, Imagen: pan.png. <br>
     */
    public Tienda() {
        producto1 = new Producto("papeleria", "Lapiz", 550.0, 18, 5, "lapiz.png");
        producto2 = new Producto("drogueria", "Aspirina", 109.5, 25, 8, "aspirina.png");
        producto3 = new Producto("papeleria", "Borrador", 207.3, 30, 10, "borrador.png");
        producto4 = new Producto("supermercado", "Pan", 150.0, 15, 20, "pan.png");
        dineroEnCaja = 0;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------
    /**
     * Retorna el producto 1.
     *
     * @return Producto 1 de la tienda.
     */
    public Producto darPrimerProducto() {
        return producto1;
    }

    /**
     * Retorna el producto 2.
     *
     * @return Producto 2 de la tienda.
     */
    public Producto darSegundoProducto() {
        return producto2;
    }

    /**
     * Retorna el producto 3.
     *
     * @return Producto 3 de la tienda.
     */
    public Producto darTercerProducto() {
        return producto3;
    }

    /**
     * Retorna el producto 4.
     *
     * @return Producto 4 de la tienda.
     */
    public Producto darCuartoProducto() {
        return producto4;
    }

    /**
     * Retorna el dinero en caja.
     *
     * @return Dinero en caja.
     */
    public double darDineroEnCaja() {
        return dineroEnCaja;
    }

    /**
     * Retorna el producto con el nombre dado por par�metro.
     *
     * @param pNombre Nombre del producto buscado. pNombre != null && pNombre !=
     * "".
     * @return Producto con el nombre dado por par�metro, null si no lo
     * encuentra.
     */
    public Producto darProducto(String pNombre) {
        if (pNombre.equals(this.producto1.darNombre())) {
            Producto buscado = producto1;
            return buscado;
        } else if (pNombre.equals(this.producto2.darNombre())) {
            Producto buscado = producto2;
            return buscado;
        } else if (pNombre.equals(this.producto3.darNombre())) {
            Producto buscado = producto3;
            return buscado;
        } else {
            return null;
        }
        // TODO: Buscar el producto con el nombre dado
    }

    /**
     * Retorna el promedio de las ventas.
     *
     * @return Dinero promedio obtenido por unidad de producto vendida.
     */
    public double darPromedioVentas() {
        double respuesta = 0.0;
        respuesta = (this.producto1.darCantidadUnidadesVendidas() + this.producto2.darCantidadUnidadesVendidas() + this.producto3.darCantidadUnidadesVendidas() + this.producto4.darCantidadUnidadesVendidas()) / 4;
        return respuesta;
    }

    /**
     * Retorna el producto con m�s unidades vendidas.
     *
     * @return Producto con m�s unidades vendidas. Null si ning�n producto tiene
     * unidades vendidas.
     */
    public Producto darProductoMasVendido() {
        Producto masVendido = null;

        // Verificar si todas las cantidades de unidades vendidas son cero
        if (this.producto1.darCantidadUnidadesVendidas() == 0
                && this.producto2.darCantidadUnidadesVendidas() == 0
                && this.producto3.darCantidadUnidadesVendidas() == 0
                && this.producto4.darCantidadUnidadesVendidas() == 0) {
            return null; // Devuelve null si todas las cantidades son cero
        }

        int maxCantidad = Math.max(this.producto1.darCantidadUnidadesVendidas(),
                Math.max(this.producto2.darCantidadUnidadesVendidas(),
                        Math.max(this.producto3.darCantidadUnidadesVendidas(),
                                this.producto4.darCantidadUnidadesVendidas())));

        // Determinar qué producto tiene la cantidad máxima de unidades vendidas
        if (maxCantidad == this.producto1.darCantidadUnidadesVendidas()) {
            masVendido = this.producto1;
        } else if (maxCantidad == this.producto2.darCantidadUnidadesVendidas()) {
            masVendido = this.producto2;
        } else if (maxCantidad == this.producto3.darCantidadUnidadesVendidas()) {
            masVendido = this.producto3;
        } else {
            masVendido = this.producto4;
        }

        return masVendido;
    }

    /**
     * Retorna el producto con menos unidades vendidas.
     *
     * @return Producto con menos unidades vendidas. Null si ning�n producto
     * tiene unidades vendidas.
     */
    public Producto darProductoMenosVendido() {
        Producto menosVendido = null;

        // Verificar si todas las cantidades de unidades vendidas son cero
        if (this.producto1.darCantidadUnidadesVendidas() == 0
                && this.producto2.darCantidadUnidadesVendidas() == 0
                && this.producto3.darCantidadUnidadesVendidas() == 0
                && this.producto4.darCantidadUnidadesVendidas() == 0) {
            return null; // Devuelve null si todas las cantidades son cero
        }

        // Inicializar el valor mínimo con un valor grande para la comparación inicial
        int minCantidad = Integer.MAX_VALUE;

        // Obtener la cantidad mínima de unidades vendidas
        minCantidad = Math.min(minCantidad, this.producto1.darCantidadUnidadesVendidas());
        minCantidad = Math.min(minCantidad, this.producto2.darCantidadUnidadesVendidas());
        minCantidad = Math.min(minCantidad, this.producto3.darCantidadUnidadesVendidas());
        minCantidad = Math.min(minCantidad, this.producto4.darCantidadUnidadesVendidas());

        // Determinar qué producto tiene la cantidad mínima de unidades vendidas
        if (minCantidad == this.producto1.darCantidadUnidadesVendidas()) {
            menosVendido = this.producto1;
        } else if (minCantidad == this.producto2.darCantidadUnidadesVendidas()) {
            menosVendido = this.producto2;
        } else if (minCantidad == this.producto3.darCantidadUnidadesVendidas()) {
            menosVendido = this.producto3;
        } else {
            menosVendido = this.producto4;
        }

        return menosVendido;
    }

    /**
     * Vende una cantidad de unidades de producto de la tienda, dado su nombre
     * por par�metro. <br>
     * <b>post: </b> Disminuy� la cantidad de unidades del producto dado y se
     * actualiz� el dinero de la caja a partir de la cantidad real vendida
     * multiplicada por el precio final (con IVA) del producto vendido..
     *
     * @param pNombreProducto Nombre del producto a vender.
     * @param pCantidad Cantidad de unidades del producto a vender. pCantidad >
     * 0.
     * @return Cantidad que fue efectivamente vendida.
     */
    public int venderProducto(String pNombreProducto, int pCantidad) {
        if (pNombreProducto.equals(this.producto1.darNombre())) {
            this.dineroEnCaja += this.producto1.vender(pCantidad) * this.producto1.calcularPrecioFinal();
            return pCantidad;
        } else if (pNombreProducto.equals(this.producto2.darNombre())) {
            this.dineroEnCaja += this.producto2.vender(pCantidad) * this.producto2.calcularPrecioFinal();
            return pCantidad;
        } else if (pNombreProducto.equals(this.producto3.darNombre())) {
            this.dineroEnCaja += this.producto3.vender(pCantidad) * this.producto3.calcularPrecioFinal();
            return pCantidad;
        } else {
            this.dineroEnCaja += this.producto4.vender(pCantidad) * this.producto4.calcularPrecioFinal();
            return pCantidad;
        }
        // TODO: Vender la cantidad pCantidad del producto con el nombre dado
    }

    /**
     * Abastece un producto dado su nombre, con la cantidad de unidades dadas.
     * <br>
     * <b>post: </b> Aument� la cantidad de unidades en bodega del producto
     * dado.
     *
     * @param pNombreProducto Nombre del producto a abastecer.
     * @param pCantidad La cantidad de unidades a abastecer. cantidad >= 0.
     * @return Retorna true si se pudo efectuar el abastecimiento, false en caso
     * contrario.
     */
    public boolean abastecerProducto(String pNombreProducto, int pCantidad) {
        boolean abastece = false;
        if (pNombreProducto.equals(this.producto1.darNombre())) {
            if (this.producto1.puedeAbastecer()) {
                this.producto1.abastecer(pCantidad);
                abastece = true;
            }
        } else if (pNombreProducto.equals(this.producto2.darNombre())) {
            if (this.producto2.puedeAbastecer()) {
                this.producto2.abastecer(pCantidad);
                abastece = true;
            }
        } else if (pNombreProducto.equals(this.producto3.darNombre())) {
            if (this.producto3.puedeAbastecer()) {
                this.producto3.abastecer(pCantidad);
                abastece = true;
            }
        } else {
            if (this.producto4.puedeAbastecer()) {
                this.producto4.abastecer(pCantidad);
                abastece = true;
            }
        }
        // TODO: Abastece el producto con el nombre dado en la cantidad especificada
        return abastece;
    }

    /**
     * Cambia el producto que tiene el nombre actual con los nuevos valores
     * dados por par�metro. <br>
     * <b>post: </b> El nombre, tipo, valor unitario, cantidad en bodega y
     * cantidad m�nima fueron cambiados con los valores dados por par�metro.
     *
     * @param pNombreActual Nombre actual del producto.
     * @param pNombreNuevo Nuevo nombre del producto.
     * @param pTipo Tipo del producto.
     * @param pValorUnitario Valor unitario del producto
     * @param pCantidadBodega Cantidad en bodega del producto.
     * @param pCantidadMinima Cantidad m�nima en bodega para hacer un pedido del
     * producto.
     * @param pRutaImagen Ruta de la imagen del producto.
     * @return Retorna true si cambi� la informaci�n del producto, Retorna false
     * si ya exist�a un producto con el nuevo nombre.
     */
    public boolean cambiarProducto(String pNombreActual, String pNombreNuevo, String pTipo, double pValorUnitario, int pCantidadBodega, int pCantidadMinima, String pRutaImagen) {
        boolean cambio = false;
        if (pNombreActual.equals(this.producto1.darNombre())) {
            if (!pNombreNuevo.equals(this.producto1.darNombre())
                    && !pNombreNuevo.equals(this.producto2.darNombre())
                    && !pNombreNuevo.equals(this.producto2.darNombre())
                    && !pNombreNuevo.equals(this.producto3.darNombre())
                    && !pNombreNuevo.equals(this.producto4.darNombre())) {
                this.producto1.cambiarNombre(pNombreNuevo);
                this.producto1.cambiarTipo(pTipo);
                this.producto1.cambiarValorUnitario(pValorUnitario);
                this.producto1.cambiarCantidadBodega(pCantidadBodega);
                this.producto1.cambiarCantidadMinima(pCantidadMinima);
                this.producto1.cambiardarRutaImagen(pRutaImagen);
                cambio = true;
            }
        } else if (pNombreActual.equals(this.producto2.darNombre())) {
            if (!pNombreNuevo.equals(this.producto1.darNombre())
                    && !pNombreNuevo.equals(this.producto2.darNombre())
                    && !pNombreNuevo.equals(this.producto2.darNombre())
                    && !pNombreNuevo.equals(this.producto3.darNombre())
                    && !pNombreNuevo.equals(this.producto4.darNombre())) {
                this.producto2.cambiarNombre(pNombreNuevo);
                this.producto2.cambiarTipo(pTipo);
                this.producto2.cambiarValorUnitario(pValorUnitario);
                this.producto2.cambiarCantidadBodega(pCantidadBodega);
                this.producto2.cambiarCantidadMinima(pCantidadMinima);
                this.producto2.cambiardarRutaImagen(pRutaImagen);
                cambio = true;
            }
        } else if (pNombreActual.equals(this.producto3.darNombre())) {
            if (!pNombreNuevo.equals(this.producto1.darNombre())
                    && !pNombreNuevo.equals(this.producto2.darNombre())
                    && !pNombreNuevo.equals(this.producto2.darNombre())
                    && !pNombreNuevo.equals(this.producto3.darNombre())
                    && !pNombreNuevo.equals(this.producto4.darNombre())) {
                this.producto3.cambiarNombre(pNombreNuevo);
                this.producto3.cambiarTipo(pTipo);
                this.producto3.cambiarValorUnitario(pValorUnitario);
                this.producto3.cambiarCantidadBodega(pCantidadBodega);
                this.producto3.cambiarCantidadMinima(pCantidadMinima);
                this.producto3.cambiardarRutaImagen(pRutaImagen);
                cambio = true;
            }
        } else {
            if (!pNombreNuevo.equals(this.producto1.darNombre())
                    && !pNombreNuevo.equals(this.producto2.darNombre())
                    && !pNombreNuevo.equals(this.producto2.darNombre())
                    && !pNombreNuevo.equals(this.producto3.darNombre())
                    && !pNombreNuevo.equals(this.producto4.darNombre())) {
                this.producto4.cambiarNombre(pNombreNuevo);
                this.producto4.cambiarTipo(pTipo);
                this.producto4.cambiarValorUnitario(pValorUnitario);
                this.producto4.cambiarCantidadBodega(pCantidadBodega);
                this.producto4.cambiarCantidadMinima(pCantidadMinima);
                this.producto4.cambiardarRutaImagen(pRutaImagen);
                cambio = true;
            }
        }
        // TODO: Cambiar la informaci�n del producto, si y solo si, no existe el producto
        // TODO: con el nombre nuevo.
        return cambio;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------
    /**
     * Obtiene la cantidad de productos que tienen un precio inferior al
     * promedio de los precios.
     *
     * @return Cantidad de productos con precio inferior al promedio.
     */
    public int metodo1() {
        // Calcular el precio promedio de todos los productos
        double precioPromedio = 0;

        // Calcular la suma de los precios de los productos
        precioPromedio += producto1.calcularPrecioFinal();
        precioPromedio += producto2.calcularPrecioFinal();
        precioPromedio += producto3.calcularPrecioFinal();
        precioPromedio += producto4.calcularPrecioFinal();

        // Calcular el promedio
        precioPromedio /= 4; // Siempre son 4 productos en este caso

        // Contar la cantidad de productos con precio inferior al promedio
        int cantidadProductosInferiores = 0;
        if (producto1.calcularPrecioFinal() < precioPromedio) {
            cantidadProductosInferiores++;
        }
        if (producto2.calcularPrecioFinal() < precioPromedio) {
            cantidadProductosInferiores++;
        }
        if (producto3.calcularPrecioFinal() < precioPromedio) {
            cantidadProductosInferiores++;
        }
        if (producto4.calcularPrecioFinal() < precioPromedio) {
            cantidadProductosInferiores++;
        }

        return cantidadProductosInferiores;
    }

    /**
     * Obtiene el nombre del producto m�s barato de la tienda
     *
     * @return Retorna el nombre del producto mas barato de la tienda
     */
    public String metodo2() {
        // TODO: Completar el m�todo!
        String masBarato = "";
        // Comparar las cantidades de unidades vendidas para encontrar el máximo
        // Inicializar el valor mínimo con un valor grande para la comparación inicial
        int minValor = Integer.MAX_VALUE;

        // Obtener la cantidad mínima de unidades vendidas
        minValor = Math.min(minValor, this.producto1.darCantidadUnidadesVendidas());
        minValor = Math.min(minValor, this.producto2.darCantidadUnidadesVendidas());
        minValor = Math.min(minValor, this.producto3.darCantidadUnidadesVendidas());
        minValor = Math.min(minValor, this.producto4.darCantidadUnidadesVendidas());

        // Determinar qué producto tiene el valor minimo
        if (minValor == this.producto1.darCantidadUnidadesVendidas()) {
            masBarato = this.producto1.darNombre();
        } else if (minValor == this.producto2.darCantidadUnidadesVendidas()) {
            masBarato = this.producto2.darNombre();
        } else if (minValor == this.producto3.darCantidadUnidadesVendidas()) {
            masBarato = this.producto3.darNombre();
        } else {
            masBarato = this.producto4.darNombre();
        }
        return masBarato;
    }
}
