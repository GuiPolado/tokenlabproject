/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenlabproject.eventos.service;

import tokenlabproject.eventos.dao.ConviteDAO;
import tokenlabproject.eventos.dao.DaoFactory;
import tokenlabproject.eventos.model.Convite;

/**
 *
 * @author guilherme
 */
public class ConviteServiceImpl implements ConviteService{

    private ConviteDAO conviteDao;

    public ConviteServiceImpl() {
        this.conviteDao = DaoFactory.getConviteDAO();
    }

    @Override
    public boolean save(Convite convite) {
        boolean b = false;

        if (convite != null) {
            b = this.conviteDao.save(convite);
        }

        return b;
    }
}
