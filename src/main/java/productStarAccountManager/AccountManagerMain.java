package productStarAccountManager;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AccountManagerMain {

    public static void main(String[] args) {

        var applicationContext = new AnnotationConfigApplicationContext(AccountManagerConfig.class);

        var phoneToCardResolver = applicationContext.getBean(PhoneToAccountResolver.class);

        var accountService = applicationContext.getBean(AccountService.class);

        Account account1 = new Account(1, 1000L);
        Account account2 = new Account(2, 1000L);

        var phoneNumber = "12345";
        phoneToCardResolver.addMapping(phoneNumber, account2);

        accountService.transferByPhoneNumber(account1, phoneNumber, 650L);
        System.out.println(account1);
        System.out.println(account2);

        accountService.transferByPhoneNumber(account1, "555", 50L);
        System.out.println(account1);
        System.out.println(account2);

        accountService.transfer(account1, account2, 300L);
        System.out.println(account1);
        System.out.println(account2);


        accountService.transfer(account1, account2, 300L);
        System.out.println(account1);
        System.out.println(account2);
    }
}
