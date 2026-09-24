package com.dev.desafioRelogio.repository;

import com.dev.desafioRelogio.entity.Relogio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface RelogioRepository extends JpaRepository<Relogio, UUID>, JpaSpecificationExecutor<Relogio> {
}
