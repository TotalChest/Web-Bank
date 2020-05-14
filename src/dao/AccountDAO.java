package dao;

import model.*;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AccountDAO extends GenericDAO<Account, Long> {

    @SuppressWarnings("unchecked")
    public List<Contact> getByCustomer(Long id) {
        TypedQuery<Contact> query = getCurrentSession().createQuery(
                "SELECT e FROM Account e " +
                        "WHERE e.customer.customerId = :id")
                .setParameter("id", id);
        return query.getResultList();
    }
}