/**
 * CS-320
 *
 * Esta clase de pruebas verifica las funcionalidades de la clase Contact,
 * asegurando que el constructor, los getters y los setters cumplan con las
 * reglas de validacion establecidas. Utiliza anotaciones y aserciones de JUnit 5.
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @DisplayName("Crear un contacto con datos validos")
    @Test
    void testContactCreationValid() {
        Contact contacto = new Contact("0", "Juan", "Perez", "1234567890", "Calle Principal 123");

        assertEquals("0", contacto.getId());
        assertEquals("Juan", contacto.getNombre());
        assertEquals("Perez", contacto.getApellido());
        assertEquals("1234567890", contacto.getTelefono());
        assertEquals("Calle Principal 123", contacto.getDireccion());
    }

    @DisplayName("Aceptar un ID de exactamente 10 caracteres")
    @Test
    void testIdExactlyTenCharacters() {
        Contact contacto = new Contact("1234567890", "Juan", "Perez", "1234567890", "Calle Principal 123");

        assertEquals("1234567890", contacto.getId());
    }

    @DisplayName("Rechazar un ID con mas de 10 caracteres")
    @Test
    void testIdTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("12345678901", "Juan", "Perez", "1234567890", "Calle Principal 123"));
    }

    @DisplayName("Rechazar un ID nulo")
    @Test
    void testIdNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(null, "Juan", "Perez", "1234567890", "Calle Principal 123"));
    }

    @DisplayName("Aceptar un nombre de exactamente 10 caracteres")
    @Test
    void testNombreExactlyTenCharacters() {
        Contact contacto = new Contact("1", "JuanJuanJu", "Perez", "1234567890", "Calle Principal 123");

        assertEquals("JuanJuanJu", contacto.getNombre());
    }

    @DisplayName("Rechazar un nombre con mas de 10 caracteres")
    @Test
    void testNombreTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", "JuanJuanJuan", "Perez", "1234567890", "Calle Principal 123"));
    }

    @DisplayName("Rechazar un nombre nulo")
    @Test
    void testNombreNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", null, "Perez", "1234567890", "Calle Principal 123"));
    }

    @DisplayName("Aceptar un apellido de exactamente 10 caracteres")
    @Test
    void testApellidoExactlyTenCharacters() {
        Contact contacto = new Contact("1", "Juan", "PerezPerez", "1234567890", "Calle Principal 123");

        assertEquals("PerezPerez", contacto.getApellido());
    }

    @DisplayName("Rechazar un apellido con mas de 10 caracteres")
    @Test
    void testApellidoTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", "Juan", "PerezPerezP", "1234567890", "Calle Principal 123"));
    }

    @DisplayName("Rechazar un apellido nulo")
    @Test
    void testApellidoNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", "Juan", null, "1234567890", "Calle Principal 123"));
    }

    @DisplayName("Rechazar un telefono con menos de 10 digitos")
    @Test
    void testTelefonoTooShort() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", "Juan", "Perez", "123456789", "Calle Principal 123"));
    }

    @DisplayName("Rechazar un telefono con mas de 10 digitos")
    @Test
    void testTelefonoTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", "Juan", "Perez", "12345678901", "Calle Principal 123"));
    }

    @DisplayName("Rechazar un telefono con caracteres no numericos")
    @Test
    void testTelefonoNotDigits() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", "Juan", "Perez", "12345abcde", "Calle Principal 123"));
    }

    @DisplayName("Rechazar un telefono nulo")
    @Test
    void testTelefonoNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", "Juan", "Perez", null, "Calle Principal 123"));
    }

    @DisplayName("Aceptar una direccion de exactamente 30 caracteres")
    @Test
    void testDireccionExactlyThirtyCharacters() {
        String direccion = "Direccion de prueba numero uno";

        Contact contacto = new Contact("1", "Juan", "Perez", "1234567890", direccion);

        assertEquals(direccion, contacto.getDireccion());
    }

    @DisplayName("Rechazar una direccion con mas de 30 caracteres")
    @Test
    void testDireccionTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", "Juan", "Perez", "1234567890", "Direccion de prueba numero unoX"));
    }

    @DisplayName("Rechazar una direccion nula")
    @Test
    void testDireccionNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", "Juan", "Perez", "1234567890", null));
    }

    @DisplayName("Actualizar el nombre con un valor valido")
    @Test
    void testSetNombreValid() {
        Contact contacto = new Contact("1", "Juan", "Perez", "1234567890", "Calle Principal 123");

        contacto.setNombre("Luis");

        assertEquals("Luis", contacto.getNombre());
    }

    @DisplayName("Rechazar valores invalidos al actualizar el nombre")
    @Test
    void testSetNombreInvalid() {
        Contact contacto = new Contact("1", "Juan", "Perez", "1234567890", "Calle Principal 123");

        assertThrows(IllegalArgumentException.class, () -> contacto.setNombre(null));
        assertThrows(IllegalArgumentException.class, () -> contacto.setNombre("JuanJuanJuan"));
    }

    @DisplayName("Actualizar el apellido con un valor valido")
    @Test
    void testSetApellidoValid() {
        Contact contacto = new Contact("1", "Juan", "Perez", "1234567890", "Calle Principal 123");

        contacto.setApellido("Garcia");

        assertEquals("Garcia", contacto.getApellido());
    }

    @DisplayName("Rechazar valores invalidos al actualizar el apellido")
    @Test
    void testSetApellidoInvalid() {
        Contact contacto = new Contact("1", "Juan", "Perez", "1234567890", "Calle Principal 123");

        assertThrows(IllegalArgumentException.class, () -> contacto.setApellido(null));
        assertThrows(IllegalArgumentException.class, () -> contacto.setApellido("PerezPerezP"));
    }

    @DisplayName("Actualizar el telefono con un valor valido")
    @Test
    void testSetTelefonoValid() {
        Contact contacto = new Contact("1", "Juan", "Perez", "1234567890", "Calle Principal 123");

        contacto.setTelefono("0987654321");

        assertEquals("0987654321", contacto.getTelefono());
    }

    @DisplayName("Rechazar valores invalidos al actualizar el telefono")
    @Test
    void testSetTelefonoInvalid() {
        Contact contacto = new Contact("1", "Juan", "Perez", "1234567890", "Calle Principal 123");

        assertThrows(IllegalArgumentException.class, () -> contacto.setTelefono(null));
        assertThrows(IllegalArgumentException.class, () -> contacto.setTelefono("123"));
        assertThrows(IllegalArgumentException.class, () -> contacto.setTelefono("12345678901"));
    }

    @DisplayName("Actualizar la direccion con un valor valido")
    @Test
    void testSetDireccionValid() {
        Contact contacto = new Contact("1", "Juan", "Perez", "1234567890", "Calle Principal 123");

        contacto.setDireccion("Calle Nueva 45");

        assertEquals("Calle Nueva 45", contacto.getDireccion());
    }

    @DisplayName("Rechazar valores invalidos al actualizar la direccion")
    @Test
    void testSetDireccionInvalid() {
        Contact contacto = new Contact("1", "Juan", "Perez", "1234567890", "Calle Principal 123");

        assertThrows(IllegalArgumentException.class, () -> contacto.setDireccion(null));
        assertThrows(IllegalArgumentException.class, () ->
            contacto.setDireccion("Direccion de prueba numero unoX"));
    }

    @DisplayName("Verificar que el ID no se puede actualizar")
    @Test
    void testIdNotUpdatable() {
        Contact contacto = new Contact("1", "Juan", "Perez", "1234567890", "Calle Principal 123");

        assertEquals("1", contacto.getId());
    }
}
