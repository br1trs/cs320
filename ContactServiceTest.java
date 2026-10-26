/**
 * CS-320
 *
 * Esta clase de pruebas verifica las funcionalidades de la clase ContactService,
 * asegurando que los contactos puedan agregarse, eliminarse y actualizarse
 * correctamente. Utiliza anotaciones y aserciones de JUnit 5.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
    private ContactService servicio;

    @BeforeEach
    void setUp() {
        servicio = new ContactService();
    }

    private Contact crearContactoEjemplo() {
        return new Contact("0", "Juan", "Perez", "1234567890", "Calle Principal 123");
    }

    @DisplayName("Agregar un contacto al servicio")
    @Test
    void testAddContact() {
        Contact contacto = crearContactoEjemplo();

        servicio.addContact(contacto);

        assertEquals(contacto, servicio.findContact("0"));
    }

    @DisplayName("Rechazar agregar un contacto nulo")
    @Test
    void testAddNullContactThrows() {
        assertThrows(IllegalArgumentException.class, () -> servicio.addContact(null));
    }

    @DisplayName("Rechazar agregar un contacto con ID duplicado")
    @Test
    void testAddDuplicateIdThrows() {
        Contact contacto1 = crearContactoEjemplo();
        Contact contacto2 = new Contact("0", "Maria", "Lopez", "0987654321", "Calle Secundaria 456");

        servicio.addContact(contacto1);

        assertThrows(IllegalArgumentException.class, () -> servicio.addContact(contacto2));
    }

    @DisplayName("Eliminar un contacto existente por su ID")
    @Test
    void testDeleteContact() {
        Contact contacto = crearContactoEjemplo();

        servicio.addContact(contacto);
        servicio.deleteContact("0");

        assertThrows(IllegalArgumentException.class, () -> servicio.findContact("0"));
    }

    @DisplayName("Rechazar eliminar un contacto con ID inexistente")
    @Test
    void testDeleteNonExistentThrows() {
        assertThrows(IllegalArgumentException.class, () -> servicio.deleteContact("999"));
    }

    @DisplayName("Buscar un contacto existente por su ID")
    @Test
    void testFindContact() {
        Contact contacto = crearContactoEjemplo();

        servicio.addContact(contacto);

        assertEquals(contacto, servicio.findContact("0"));
    }

    @DisplayName("Rechazar buscar un contacto con ID inexistente")
    @Test
    void testFindNonExistentThrows() {
        assertThrows(IllegalArgumentException.class, () -> servicio.findContact("999"));
    }

    @DisplayName("Actualizar todos los campos de un contacto")
    @Test
    void testUpdateContactAllFields() {
        Contact contacto = crearContactoEjemplo();

        servicio.addContact(contacto);
        servicio.updateContact("0", "Maria", "Lopez", "0987654321", "Calle Secundaria 456");

        assertEquals("Maria", contacto.getNombre());
        assertEquals("Lopez", contacto.getApellido());
        assertEquals("0987654321", contacto.getTelefono());
        assertEquals("Calle Secundaria 456", contacto.getDireccion());
    }

    @DisplayName("Actualizar solo el nombre sin afectar los demas campos")
    @Test
    void testUpdateNombreOnly() {
        Contact contacto = crearContactoEjemplo();

        servicio.addContact(contacto);
        servicio.updateContact("0", "Luis", null, null, null);

        assertEquals("Luis", contacto.getNombre());
        assertEquals("Perez", contacto.getApellido());
        assertEquals("1234567890", contacto.getTelefono());
        assertEquals("Calle Principal 123", contacto.getDireccion());
    }

    @DisplayName("Actualizar solo el apellido sin afectar los demas campos")
    @Test
    void testUpdateApellidoOnly() {
        Contact contacto = crearContactoEjemplo();

        servicio.addContact(contacto);
        servicio.updateContact("0", null, "Garcia", null, null);

        assertEquals("Juan", contacto.getNombre());
        assertEquals("Garcia", contacto.getApellido());
        assertEquals("1234567890", contacto.getTelefono());
        assertEquals("Calle Principal 123", contacto.getDireccion());
    }

    @DisplayName("Actualizar solo el telefono sin afectar los demas campos")
    @Test
    void testUpdateTelefonoOnly() {
        Contact contacto = crearContactoEjemplo();

        servicio.addContact(contacto);
        servicio.updateContact("0", null, null, "0987654321", null);

        assertEquals("Juan", contacto.getNombre());
        assertEquals("Perez", contacto.getApellido());
        assertEquals("0987654321", contacto.getTelefono());
        assertEquals("Calle Principal 123", contacto.getDireccion());
    }

    @DisplayName("Actualizar solo la direccion sin afectar los demas campos")
    @Test
    void testUpdateDireccionOnly() {
        Contact contacto = crearContactoEjemplo();

        servicio.addContact(contacto);
        servicio.updateContact("0", null, null, null, "Calle Nueva 45");

        assertEquals("Juan", contacto.getNombre());
        assertEquals("Perez", contacto.getApellido());
        assertEquals("1234567890", contacto.getTelefono());
        assertEquals("Calle Nueva 45", contacto.getDireccion());
    }

    @DisplayName("Actualizar parcialmente nombre y telefono")
    @Test
    void testUpdateNombreAndTelefonoPartially() {
        Contact contacto = crearContactoEjemplo();

        servicio.addContact(contacto);
        servicio.updateContact("0", "Carlos", null, "5555555555", null);

        assertEquals("Carlos", contacto.getNombre());
        assertEquals("Perez", contacto.getApellido());
        assertEquals("5555555555", contacto.getTelefono());
        assertEquals("Calle Principal 123", contacto.getDireccion());
    }

    @DisplayName("Rechazar actualizar un contacto con ID inexistente")
    @Test
    void testUpdateNonExistentThrows() {
        assertThrows(IllegalArgumentException.class, () ->
            servicio.updateContact("999", "Maria", "Lopez", "0987654321", "Calle Secundaria 456"));
    }

    @DisplayName("Rechazar actualizar el nombre con un valor invalido")
    @Test
    void testUpdateInvalidNombreThrows() {
        Contact contacto = crearContactoEjemplo();

        servicio.addContact(contacto);

        assertThrows(IllegalArgumentException.class, () ->
            servicio.updateContact("0", "JuanJuanJuan", null, null, null));
    }

    @DisplayName("Rechazar actualizar el apellido con un valor invalido")
    @Test
    void testUpdateInvalidApellidoThrows() {
        Contact contacto = crearContactoEjemplo();

        servicio.addContact(contacto);

        assertThrows(IllegalArgumentException.class, () ->
            servicio.updateContact("0", null, "PerezPerezP", null, null));
    }

    @DisplayName("Rechazar actualizar el telefono con un valor invalido")
    @Test
    void testUpdateInvalidTelefonoThrows() {
        Contact contacto = crearContactoEjemplo();

        servicio.addContact(contacto);

        assertThrows(IllegalArgumentException.class, () ->
            servicio.updateContact("0", null, null, "123", null));
    }

    @DisplayName("Rechazar actualizar la direccion con un valor invalido")
    @Test
    void testUpdateInvalidDireccionThrows() {
        Contact contacto = crearContactoEjemplo();

        servicio.addContact(contacto);

        assertThrows(IllegalArgumentException.class, () ->
            servicio.updateContact("0", null, null, null, "Direccion de prueba numero unoX"));
    }

    @DisplayName("Verificar que el ID no cambia despues de actualizar")
    @Test
    void testIdNotChangedOnUpdate() {
        Contact contacto = crearContactoEjemplo();

        servicio.addContact(contacto);
        servicio.updateContact("0", "Maria", "Lopez", "0987654321", "Calle Secundaria 456");

        assertEquals("0", contacto.getId());
    }
}
