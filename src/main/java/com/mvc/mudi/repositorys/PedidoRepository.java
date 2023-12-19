package com.mvc.mudi.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvc.mudi.models.Pedido;
import com.mvc.mudi.models.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	List<Pedido> findByStatus(StatusPedido aguardando);

}
