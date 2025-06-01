package com.example.ms.proveedor.repository;


import com.example.ms.proveedor.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    // Buscar por nombre de empresa
    List<Proveedor> findByNombreEmpresaContainingIgnoreCase(String nombreEmpresa);

    List<Proveedor> getProveedorById(Long id);

    // Buscar por país
    List<Proveedor> findByPaisIgnoreCase(String pais);

    // Buscar por ciudad
    List<Proveedor> findByCiudadIgnoreCase(String ciudad);

    // Buscar por correo electrónico
    Optional<Proveedor> findByCorreoElectronico(String correoElectronico);

    // Verificar si existe un proveedor con ese correo
    boolean existsByCorreoElectronico(String correoElectronico);

    // Buscar proveedores por país y ciudad
    @Query("SELECT p FROM Proveedor p WHERE p.pais = :pais AND p.ciudad = :ciudad")
    List<Proveedor> findByPaisAndCiudad(@Param("pais") String pais, @Param("ciudad") String ciudad);

    // Buscar proveedores activos (puedes agregar un campo estado más adelante)
    @Query("SELECT p FROM Proveedor p WHERE p.nombreEmpresa IS NOT NULL AND p.correoElectronico IS NOT NULL")
    List<Proveedor> findProveedoresActivos();
}