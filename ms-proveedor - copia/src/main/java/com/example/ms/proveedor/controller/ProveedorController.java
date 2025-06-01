package com.example.ms.proveedor.controller;

import com.example.ms.proveedor.dto.ProveedorDTO;
import com.example.ms.proveedor.service.ProveedorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProveedorController {


    @Autowired
    private ProveedorService proveedorService;

    // GET /api/proveedores - Obtener todos los proveedores
    @GetMapping
    public ResponseEntity<List<ProveedorDTO>> getAllProveedores() {
        List<ProveedorDTO> proveedores = proveedorService.getAllProveedores();
        return ResponseEntity.ok(proveedores);
    }

    // GET /api/proveedores/{id} - Obtener proveedor por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProveedorDTO> getProveedorById(@PathVariable Long id) {
        ProveedorDTO proveedor = proveedorService.getProveedorById(id);
        return ResponseEntity.ok(proveedor);
    }

    // POST /api/proveedores - Crear nuevo proveedor
    @PostMapping
    public ResponseEntity<ProveedorDTO> createProveedor(@Valid @RequestBody ProveedorDTO proveedorDTO) {
        ProveedorDTO nuevoProveedor = proveedorService.createProveedor(proveedorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProveedor);
    }

    // PUT /api/proveedores/{id} - Actualizar proveedor
    @PutMapping("/{id}")
    public ResponseEntity<ProveedorDTO> updateProveedor(@PathVariable Long id,
                                                        @Valid @RequestBody ProveedorDTO proveedorDTO) {
        ProveedorDTO proveedorActualizado = proveedorService.updateProveedor(id, proveedorDTO);
        return ResponseEntity.ok(proveedorActualizado);
    }

    // DELETE /api/proveedores/{id} - Eliminar proveedor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProveedor(@PathVariable Long id) {
        proveedorService.deleteProveedor(id);
        return ResponseEntity.noContent().build();
    }

    // GET /api/proveedores/search?nombre={nombre} - Buscar por nombre de empresa
    @GetMapping("/search")
    public ResponseEntity<List<ProveedorDTO>> searchProveedores(@RequestParam String nombre) {
        List<ProveedorDTO> proveedores = proveedorService.searchByNombreEmpresa(nombre);
        return ResponseEntity.ok(proveedores);
    }

    // GET /api/proveedores/pais/{pais} - Obtener proveedores por país
    @GetMapping("/pais/{pais}")
    public ResponseEntity<List<ProveedorDTO>> getProveedoresByPais(@PathVariable String pais) {
        List<ProveedorDTO> proveedores = proveedorService.getProveedoresByPais(pais);
        return ResponseEntity.ok(proveedores);
    }

    // GET /api/proveedores/ciudad/{ciudad} - Obtener proveedores por ciudad
    @GetMapping("/ciudad/{ciudad}")
    public ResponseEntity<List<ProveedorDTO>> getProveedoresByCiudad(@PathVariable String ciudad) {
        List<ProveedorDTO> proveedores = proveedorService.getProveedoresByCiudad(ciudad);
        return ResponseEntity.ok(proveedores);
    }

    // GET /api/proveedores/health - Health check endpoint
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Proveedor Service is running!");
    }
}