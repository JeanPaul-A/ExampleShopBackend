package com.jeanpaul.exampleshop.repositories;


import com.jeanpaul.exampleshop.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    /**
     * This function update the state of all orders incrementing the value in 1.
     * Code:
     create or replace function functionUpdateState(timer int) returns void
     as $$
     BEGIN
     update orders set state = state + 1 where created < now() - interval '$1 minutes' and state < 5;
     END; $$
     language plpgsql;
     * @param timer = Time needed to pass to change the status of the order
     */
    @Query(value = "select functionUpdateState(:timer)", nativeQuery = true)
    void updateState(int timer);



}
