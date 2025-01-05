package kr.ac.kopo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.ac.kopo.mybatis.MyConfig;
import kr.ac.kopo.vo.LiquorVO;

public class LiquorDAOImpl implements LiquorDAO {

    private SqlSessionFactory sqlSessionFactory;

    public LiquorDAOImpl() {
        sqlSessionFactory = MyConfig.getSqlSessionFactory();
    }

    @Override
    public List<LiquorVO> selectAllLiquors() {
        List<LiquorVO> liquorList = null;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            liquorList = session.selectList("LiquorMapper.selectAllLiquors");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liquorList;
    }

    @Override
    public LiquorVO selectLiquorById(int liquorId) {
        LiquorVO liquor = null;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            liquor = session.selectOne("LiquorMapper.selectLiquorById", liquorId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liquor;
    }

    @Override
    public void insertLiquor(LiquorVO liquor) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.insert("LiquorMapper.insertLiquor", liquor);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateLiquor(LiquorVO liquor) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.update("LiquorMapper.updateLiquor", liquor);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLiquor(int liquorId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.delete("LiquorMapper.deleteLiquor", liquorId);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
