package onmyownn.service;

import onmyownn.model.entity.AccountEntity;
import java.util.List;

public interface AccountService {
    List<AccountEntity> findAll();
    AccountEntity save(AccountEntity account);
    void deleteById(Long id);
}
