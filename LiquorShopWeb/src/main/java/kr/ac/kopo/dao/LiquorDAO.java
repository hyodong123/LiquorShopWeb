package kr.ac.kopo.dao;

import java.util.List;
import kr.ac.kopo.vo.LiquorVO;

public interface LiquorDAO {
    List<LiquorVO> selectAllLiquors();
    LiquorVO selectLiquorById(int liquorId);
    void insertLiquor(LiquorVO liquor);
    void updateLiquor(LiquorVO liquor);
    void deleteLiquor(int liquorId);
}
