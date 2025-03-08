package onmyownn.service;

import onmyownn.model.entity.AccountEntity;

public interface AccountService {
    AccountEntity getCurrentUser();
    AccountEntity getUser(Long userId);
    AccountEntity save(AccountEntity account);
    void deleteById(Long id);
    AccountEntity findById(Long id);
    AccountEntity findByUsername(String username);
}
