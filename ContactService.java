import java.util.ArrayList;
import java.util.List;

/**
 * Servicio encargado de gestionar los contactos de la aplicacion.
 * <p>
 * Almacena los contactos en una estructura de datos en memoria y permite
 * agregar, eliminar y actualizar contactos mediante su identificador unico.
 * No requiere base de datos ni interfaz de usuario.
 * </p>
 *
 */
public class ContactService {
    private List<Contact> contacts;

    /**
     * Crea un nuevo servicio de contactos con una lista vacia en memoria.
     */
    public ContactService() {
        this.contacts = new ArrayList<>();
    }

    /**
     * Agrega un nuevo contacto al servicio.
     * <p>
     * El identificador del contacto debe ser unico; si ya existe un contacto
     * con el mismo ID, la operacion es rechazada.
     * </p>
     *
     * @param contact el contacto a agregar; no puede ser nulo
     * @throws IllegalArgumentException si ya existe un contacto con el mismo ID
     */
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("El contacto no puede ser nulo");
        }
        for (Contact c : contacts) {
            if (c.getId().equals(contact.getId())) {
                throw new IllegalArgumentException("El ID ya existe");
            }
        }
        contacts.add(contact);
    }

    /**
     * Elimina un contacto del servicio segun su identificador.
     *
     * @param id identificador del contacto a eliminar
     * @throws IllegalArgumentException si no existe un contacto con ese ID
     */
    public void deleteContact(String id) {
        Contact contact = findContact(id);
        contacts.remove(contact);
    }

    /**
     * Actualiza los campos de un contacto existente segun su identificador.
     * <p>
     * Los campos actualizables son: nombre, apellido, telefono y direccion.
     * Cualquier parametro con valor {@code null} se ignora, permitiendo
     * actualizar campos de forma individual. El identificador del contacto
     * nunca se modifica.
     * </p>
     *
     * @param id        identificador del contacto a actualizar
     * @param nombre    nuevo nombre, o {@code null} para conservar el actual
     * @param apellido  nuevo apellido, o {@code null} para conservar el actual
     * @param telefono  nuevo telefono, o {@code null} para conservar el actual
     * @param direccion nueva direccion, o {@code null} para conservar la actual
     * @throws IllegalArgumentException si no existe un contacto con ese ID o
     *                                  si algun valor nuevo no cumple las
     *                                  validaciones de la clase {@link Contact}
     */
    public void updateContact(String id, String nombre, String apellido, String telefono, String direccion) {
        Contact contact = findContact(id);
        if (nombre != null) {
            contact.setNombre(nombre);
        }
        if (apellido != null) {
            contact.setApellido(apellido);
        }
        if (telefono != null) {
            contact.setTelefono(telefono);
        }
        if (direccion != null) {
            contact.setDireccion(direccion);
        }
    }

    /**
     * Busca un contacto por su identificador unico.
     *
     * @param id identificador del contacto a buscar
     * @return el contacto asociado al identificador
     * @throws IllegalArgumentException si no existe un contacto con ese ID
     */
    public Contact findContact(String id) {
        for (Contact contact : contacts) {
            if (contact.getId().equals(id)) {
                return contact;
            }
        }
        throw new IllegalArgumentException("No existe un contacto con ese ID");
    }
}
