/**
 * Representa un contacto dentro de la aplicacion.
 * <p>
 * Cada contacto posee un identificador unico e inmutable, junto con
 * los campos actualizables: nombre, apellido, telefono y direccion.
 * Todos los campos son obligatorios y se validan tanto en el constructor
 * como en los metodos de modificacion.
 * </p>
 *
 */
public class Contact {
    private final String id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;

    /**
     * Crea un nuevo contacto con los datos proporcionados.
     *
     * @param id        identificador unico del contacto; no puede ser nulo
     *                  ni tener mas de 10 caracteres
     * @param nombre    nombre del contacto; no puede ser nulo ni tener
     *                  mas de 10 caracteres
     * @param apellido  apellido del contacto; no puede ser nulo ni tener
     *                  mas de 10 caracteres
     * @param telefono  numero de telefono; no puede ser nulo y debe tener
     *                  exactamente 10 digitos numericos
     * @param direccion direccion del contacto; no puede ser nula ni tener
     *                  mas de 30 caracteres
     * @throws IllegalArgumentException si algun parametro no cumple las
     *                                  restricciones indicadas
     */
    public Contact(String id, String nombre, String apellido, String telefono, String direccion) {
        if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("ID no puede ser nulo y debe ser de maximo 10 caracteres");
        }
        this.id = id;
        setNombre(nombre);
        setApellido(apellido);
        setTelefono(telefono);
        setDireccion(direccion);
    }

    /**
     * Obtiene el identificador unico del contacto.
     *
     * @return el identificador del contacto; nunca es nulo ni modificable
     */
    public String getId() {
        return id;
    }

    /**
     * Obtiene el nombre del contacto.
     *
     * @return el nombre del contacto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Actualiza el nombre del contacto.
     *
     * @param nombre nuevo nombre; no puede ser nulo ni tener mas de
     *               10 caracteres
     * @throws IllegalArgumentException si el nombre es nulo o excede los
     *                                  10 caracteres
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.length() > 10) {
            throw new IllegalArgumentException("Nombre no puede ser nulo y debe ser de maximo 10 caracteres");
        }
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del contacto.
     *
     * @return el apellido del contacto
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Actualiza el apellido del contacto.
     *
     * @param apellido nuevo apellido; no puede ser nulo ni tener mas de
     *                 10 caracteres
     * @throws IllegalArgumentException si el apellido es nulo o excede los
     *                                  10 caracteres
     */
    public void setApellido(String apellido) {
        if (apellido == null || apellido.length() > 10) {
            throw new IllegalArgumentException("Apellido no puede ser nulo y debe ser de maximo 10 caracteres");
        }
        this.apellido = apellido;
    }

    /**
     * Obtiene el numero de telefono del contacto.
     *
     * @return el numero de telefono de 10 digitos
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Actualiza el numero de telefono del contacto.
     *
     * @param telefono nuevo numero de telefono; no puede ser nulo y debe
     *                 contener exactamente 10 digitos numericos
     * @throws IllegalArgumentException si el telefono es nulo o no tiene
     *                                  exactamente 10 digitos
     */
    public void setTelefono(String telefono) {
        if (telefono == null || !telefono.matches("\\d{10}")) {
            throw new IllegalArgumentException("Telefono no puede ser nulo y debe tener exactamente 10 digitos");
        }
        this.telefono = telefono;
    }

    /**
     * Obtiene la direccion del contacto.
     *
     * @return la direccion del contacto
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Actualiza la direccion del contacto.
     *
     * @param direccion nueva direccion; no puede ser nula ni tener mas de
     *                  30 caracteres
     * @throws IllegalArgumentException si la direccion es nula o excede los
     *                                  30 caracteres
     */
    public void setDireccion(String direccion) {
        if (direccion == null || direccion.length() > 30) {
            throw new IllegalArgumentException("Direccion no puede ser nula y debe ser de maximo 30 caracteres");
        }
        this.direccion = direccion;
    }
}
