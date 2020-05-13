package dao;

import model.*;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public class TypeOfAccountDAO extends GenericDAO<TypeOfAccount, Long> {

}