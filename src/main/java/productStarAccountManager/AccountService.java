package productStarAccountManager;

public interface AccountService {

    void transfer(Account from, Account to, long amount);
    void transferByPhoneNumber(Account from, String phoneNumber, long amount);
}
