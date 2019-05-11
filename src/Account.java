import java.util.ArrayList;
import java.util.List;

class Account {
    private static List<Account> accounts = new ArrayList<>();
    private String username;

    private Account(String username) {
        this.username = username;
    }

    Account createNewAccount(String username) {
        if (hasThis(username))
            return null;
        Account newAccount = new Account(username);
        accounts.add(newAccount);
        return newAccount;
    }

    private boolean hasThis(String username) {
        return getAccountByName(username) != null;
    }

    private Account getAccountByName(String username) {
        for (Account account : accounts)
            if (account.username.equals(username))
                return account;
        return null;
    }


}
