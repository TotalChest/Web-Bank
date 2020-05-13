package dao;

import model.*;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ContactDAO extends GenericDAO<Contact, Long> {
    @SuppressWarnings("unchecked")
    public List<Contact> getByCustomerId(Long id) {
        TypedQuery<Contact> query = getCurrentSession().createQuery(
                "SELECT e FROM Contact e " +
                        "WHERE e.customer.customerId = :id")
                .setParameter("id", id);
        return query.getResultList();
    }
}