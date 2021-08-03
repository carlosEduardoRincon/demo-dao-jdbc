
package model.dao;

import java.util.List;
import model.entities.Seller;

/**
 *
 * @author Carlos Eduardo
 */
public interface SellerDao {
    
    void insert(Seller obj);
    void update(Seller obj);
    void deleteById(Seller obj);
    Seller findById(Integer id);
    List<Seller> findAll();
}
