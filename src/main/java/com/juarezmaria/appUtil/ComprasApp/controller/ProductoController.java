package com.juarezmaria.appUtil.ComprasApp.controller;

import com.juarezmaria.appUtil.ComprasApp.entity.Producto;
import com.juarezmaria.appUtil.ComprasApp.exception.ProductoNotFoundException;
import com.juarezmaria.appUtil.ComprasApp.dao.daoImpl.ProductosServiceImpl;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private static final Log LOGGER = LogFactory.getLog(ProductoController.class);

    @Autowired
    private ProductosServiceImpl productosServiceImpl;

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public void agregarProducto(@Valid @RequestBody Producto producto) {
        LOGGER.info("METHOD: 'agregarProducto' -- VALUES: '" + producto.toString() + "'");
        productosServiceImpl.agregarProducto(producto);
    }

    @RequestMapping(value = "/editar", method = RequestMethod.PUT)
    public ResponseEntity<Producto> editEmpleado(@Valid @RequestBody Producto productoEditado) throws ProductoNotFoundException {
        LOGGER.info("METHOD: 'editEmpleado' -- VALUES_INIT: '" + productoEditado.toString() + "'");
        if (productosServiceImpl.editarProducto(productoEditado.getId(), productoEditado)) {
            LOGGER.info("METHOD: 'editEmpleado' -- VALUES_FINALLY: '" + productoEditado.toString() + "'");
            return ResponseEntity.ok(productoEditado);
        }
        throw new ProductoNotFoundException("No se encontro el producto a editar");
    }

    @RequestMapping(value = "/eliminar", method = RequestMethod.DELETE)
    public ResponseEntity<Producto> deleteEmpleado(@Valid @RequestBody Producto productoEliminar) throws ProductoNotFoundException {
        LOGGER.info("METHOD: 'deleteEmpleado' -- VALUES: '" + productoEliminar.toString() + "'");
        if (productosServiceImpl.eliminarEmpleado(productoEliminar.getId(), productoEliminar)) {
            return ResponseEntity.ok(productoEliminar);
        }
        throw new ProductoNotFoundException("No se encontro el producto a eliminar");
    }

    @RequestMapping("/list")
    public List<Producto> listEmpleados() {
        return productosServiceImpl.list();
    }


    @ExceptionHandler(ProductoNotFoundException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, String> onException(ProductoNotFoundException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, Map<String, String>> validationError(MethodArgumentNotValidException ex) {
        Map<String, String> map = new HashMap<String, String>();
        Map<String, Map<String, String>> errors = new HashMap<String, Map<String, String>>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        errors.put("errores", map);
        return errors;
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, Map<String, String>> validationError(BindException ex) {
        Map<String, String> map = new HashMap<String, String>
                ();
        Map<String, Map<String, String>> errors = new HashMap<String, Map<String, String>>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        errors.put("errores", map);
        return errors;
    }
}
