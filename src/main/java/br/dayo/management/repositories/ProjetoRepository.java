package br.dayo.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.dayo.management.domain.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {
}
