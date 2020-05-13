package dao;

import model.*;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AccountDAO extends GenericDAO<Account, Long> {

}