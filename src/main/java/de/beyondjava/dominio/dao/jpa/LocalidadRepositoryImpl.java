package de.beyondjava.dominio.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;



import org.springframework.stereotype.Repository;

import de.beyondjava.dominio.dao.LocalidadDao;
import de.beyondjava.dominio.modelo.Localidad;
import de.beyondjava.dominio.reporte.CriterioBusquedaLocalidad;
import de.beyondjava.dominio.reporte.SelConsultaLocalidadesReporte;


@Repository
public class LocalidadRepositoryImpl implements LocalidadDao {

	private EntityManager entityManager;

	@PersistenceContext()
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public int obtenerLocalidadesCriterioBusquedaTotal(
			CriterioBusquedaLocalidad criterioBusquedaLocalidad) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<Long> q = cb
				.createQuery(Long.class);
		Root<Localidad> c = q.from(Localidad.class);
		List<Predicate> predicateList = crearPredicadosLocalidad(
				criterioBusquedaLocalidad, cb, c);

		Predicate[] predicates = new Predicate[predicateList.size()];
		predicateList.toArray(predicates);
		q.where(predicates);

		q.select(cb.countDistinct(c));
		Long total= entityManager
				.createQuery(q).getSingleResult();
		return total.intValue();
	}

	private List<Predicate> crearPredicadosLocalidad(
			CriterioBusquedaLocalidad criterioBusquedaLocalidad, CriteriaBuilder cb,
			Root<Localidad> c) {
		List<Predicate> predicateList = new ArrayList<Predicate>();
		Predicate nombrePredicate;

		if ((criterioBusquedaLocalidad.getLocalidad() != null)
				&& (!(criterioBusquedaLocalidad.getLocalidad().isEmpty()))) {
			criterioBusquedaLocalidad.setLocalidad(criterioBusquedaLocalidad.getLocalidad()
					.replace("*", "%"));
			nombrePredicate = cb.like(cb.upper(c.<String> get("nombre")),
					criterioBusquedaLocalidad.getLocalidad().toUpperCase());
			predicateList.add(nombrePredicate);
		}
		return predicateList;
	}


	@Override
	public List<SelConsultaLocalidadesReporte> obtenerLocalidadesCriterioBusquedaPaginada(
			CriterioBusquedaLocalidad criterioBusquedaLocalidad, int pagina,
			int tamanioPagina) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<SelConsultaLocalidadesReporte> q = cb
				.createQuery(SelConsultaLocalidadesReporte.class);
		Root<Localidad> c = q.from(Localidad.class);
		q.select(cb.construct(SelConsultaLocalidadesReporte.class,
				c.get("id"), c.get("nombre")));
		List<Predicate> predicateList = crearPredicadosLocalidad(
				criterioBusquedaLocalidad, cb, c);

		Predicate[] predicates = new Predicate[predicateList.size()];
		predicateList.toArray(predicates);
		q.where(predicates);

		TypedQuery<SelConsultaLocalidadesReporte> q2 = entityManager
				.createQuery(q);
		q2.setFirstResult(pagina);
		q2.setMaxResults(tamanioPagina);
		List<SelConsultaLocalidadesReporte> results = q2.getResultList();
		return results;
	}


}
