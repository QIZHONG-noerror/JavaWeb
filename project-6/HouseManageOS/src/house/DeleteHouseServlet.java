package house;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteHouse")
public class DeleteHouseServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        try {
            HouseRepo.getInstance().deleteHouse(Long.valueOf(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect("./listHouse");
    }
}
