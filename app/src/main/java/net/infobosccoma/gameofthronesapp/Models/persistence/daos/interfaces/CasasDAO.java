package net.infobosccoma.gameofthronesapp.Models.persistence.daos.interfaces;

import net.infobosccoma.gameofthronesapp.Models.Business.Entities.Casa;

import java.util.List;
import java.util.ListResourceBundle;

/**
 * Created by Kevin on 29/02/2016.
 */
public interface CasasDAO {
    Casa getById(int id);
    List<Casa> getAll();
    boolean save(Casa casa);
    boolean update(Casa casa);
    boolean delete(Casa casa);
}
