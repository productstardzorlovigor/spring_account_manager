package productStarAccountManager;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class InMemoryPhoneToAccountResolver implements PhoneToAccountResolver{

    private final Map<String, Account> phoneToAccountMapping;

    public InMemoryPhoneToAccountResolver(Map<String, Account> phoneToAccountMapping) {
        this.phoneToAccountMapping = phoneToAccountMapping;
    }

    @Override
    public Optional<Account> findAccountByPhoneNumber(String phoneNumber) {
        return Optional.ofNullable(phoneToAccountMapping.get(phoneNumber));
    }

    @Override
    public void addMapping(String phoneNumber, Account account) {
        phoneToAccountMapping.put(phoneNumber, account);
    }

    @Override
    public void removeMapping(String phoneNumber) {
        phoneToAccountMapping.remove(phoneNumber);
    }
}
