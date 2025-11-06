package com.example.transaction;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {
    public void transfer(int fromId, int toId, double amount) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Account from = session.get(Account.class, fromId);
            Account to = session.get(Account.class, toId);

            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);

            session.update(from);
            session.update(to);
            tx.commit();

            System.out.println("Transfer successful.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
