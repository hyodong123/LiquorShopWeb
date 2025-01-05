package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.dao.LiquorDAO;
import kr.ac.kopo.dao.LiquorDAOImpl;
import kr.ac.kopo.vo.LiquorVO;

import java.util.List;

public class LiquorListController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LiquorDAO liquorDAO = new LiquorDAOImpl();
        List<LiquorVO> liquors = liquorDAO.selectAllLiquors();
        request.setAttribute("liquors", liquors);
        return "/jsp/liquor/list.jsp";
    }
}
