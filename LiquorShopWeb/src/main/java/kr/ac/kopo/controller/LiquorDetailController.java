package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.dao.LiquorDAO;
import kr.ac.kopo.dao.LiquorDAOImpl;
import kr.ac.kopo.vo.LiquorVO;

public class LiquorDetailController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String liquorIdStr = request.getParameter("id");
        if (liquorIdStr != null) {
            int liquorId = Integer.parseInt(liquorIdStr);
            LiquorDAO liquorDAO = new LiquorDAOImpl();
            LiquorVO liquor = liquorDAO.selectLiquorById(liquorId);
            request.setAttribute("liquor", liquor);
        }
        return "/jsp/liquor/detail.jsp";
    }
}
