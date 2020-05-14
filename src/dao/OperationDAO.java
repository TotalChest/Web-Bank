package dao;

import model.*;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public class OperationDAO extends GenericDAO<Operation, Long> {

    @SuppressWarnings("unchecked")
    public List<Contact> getByOperation(Long id) {
        TypedQuery<Contact> query = getCurrentSession().createQuery(
                "SELECT e FROM Operation e " +
                        "WHERE e.account.accountId = :id")
                .setParameter("id", id);
        return query.getResultList();
    }
}