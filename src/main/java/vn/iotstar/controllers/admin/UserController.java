package vn.iotstar.controllers.admin;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iotstar.entity.User;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserService;


@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = { "/users","/admin/users", "/admin/user/add", "/admin/user/insert", 
                            "/admin/user/delete", "/admin/user/edit", "/admin/user/update" })
public class UserController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("==> doGet() called with URL: " + req.getRequestURI());

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = req.getRequestURI();

        if (url.contains("/admin/user/add")) {
            System.out.println("Navigating to user-add.jsp");
            req.getRequestDispatcher("/views/admin/user-add.jsp").forward(req, resp);

        } else if (url.contains("/users")) {
            System.out.println("Retrieving all users");
            List<User> list = userService.findAll();
            req.setAttribute("listUsers", list);
            req.getRequestDispatcher("/views/admin/user-list.jsp").forward(req, resp);

        } else if (url.contains("/admin/user/delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            System.out.println("Deleting user with ID: " + id);
            try {
                userService.delete(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            resp.sendRedirect(req.getContextPath() + "/admin/users");

        } else if (url.contains("/admin/user/edit")) {
            int id = Integer.parseInt(req.getParameter("id"));
            System.out.println("Editing user with ID: " + id);
            User user = userService.findById(id);
            req.setAttribute("user", user);
            req.getRequestDispatcher("/views/admin/user-edit.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("==> doPost() called with URL: " + req.getRequestURI());

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = req.getRequestURI();

        if (url.contains("/admin/user/update")) {
            System.out.println("Updating user");
            int userid = Integer.parseInt(req.getParameter("userid"));
            String username = req.getParameter("username");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            int status = Integer.parseInt(req.getParameter("status"));

            User user = new User();
            user.setId(userid);
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
          

            userService.update(user);
            resp.sendRedirect(req.getContextPath() + "/admin/users");

        } else if (url.contains("/admin/user/insert")) {
            System.out.println("Inserting new user");
            String username = req.getParameter("username");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
           
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
         

            userService.insert(user);
            resp.sendRedirect(req.getContextPath() + "/admin/users");
        }
    }
}
