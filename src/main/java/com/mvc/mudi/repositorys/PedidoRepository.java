package com.mvc.mudi.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvc.mudi.models.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
  List<Pedido> findByStatus(StatusPedido aguardando);
}
