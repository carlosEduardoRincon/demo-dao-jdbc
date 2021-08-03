
package model.dao;

import model.dao.impl.SellerDaoJDBC;

/**
 *
 * @author Carlos Eduardo
 */
public class DaoFactory {
    
    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC();
    }
}
