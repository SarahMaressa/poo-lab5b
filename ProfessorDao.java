package lab5b;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProfessorDao implements DAO<Professor> {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
	EntityManager em = emf.createEntityManager();

	@Override
	public Optional<Professor> get(long id) {
		return Optional.ofNullable(em.find(Professor.class, id));
	}

	@Override
	public List<Professor> getAll() {
		Query query = em.createQuery("SELECT p FROM Professor p"); // HQL

		return query.getResultList();
	}

	@Override
	public void save(Professor t) {

		var existe = get(t.getId());

		if (existe.isPresent()) {
			var p = existe.get();

			p.setMatricula(t.getMatricula());
			p.setFormacao(t.getFormacao());
			p.setDataNasc(t.getDataNasc());

			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
		} else {
			System.out.println("ERROR: Not found -> " + t.getClass().getSimpleName() + "." + t.getId());
		}
	}

	@Override
	public void update(Professor t) {
		Professor p = em.find(Professor.class, t);
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();

	}

	@Override
	public void delete(Professor t) {

		Professor p = em.find(Professor.class, t);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();

	}

	@Override
	public void close() {
		em.close();
	}

}
