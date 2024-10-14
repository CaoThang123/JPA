package vn.iotstar.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iotstar.entity.Category;
import vn.iotstar.services.ICategoryService;
import vn.iotstar.services.impl.CategoryService;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = { "/views","/admin/categories", "/admin/category/add", "/admin/category/insert", 
                            "/admin/category/delete", "/admin/category/edit", "/admin/category/update" })
public class CategoryController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public ICategoryService cateService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("==> doGet() called with URL: " + req.getRequestURI());  // In ra URL

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = req.getRequestURI();

        if (url.contains("/admin/category")) {
            System.out.println("Navigating to category-add.jsp");
            req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);

        } else if (url.contains("/views")) {
            System.out.println("Retrieving all categories");
            List<Category> list = cateService.findAll();
            req.setAttribute("listcate", list);
            req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);

        } else if (url.contains("/admin/category/delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            System.out.println("Deleting category with ID: " + id);
            try {
                cateService.delete(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            resp.sendRedirect(req.getContextPath() + "/admin/categories");

        } else if (url.contains("/admin/category/edit")) {
            int id = Integer.parseInt(req.getParameter("id"));
            System.out.println("Editing category with ID: " + id);
            Category category = cateService.findById(id);
            req.setAttribute("cate", category);
            req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("==> doPost() called with URL: " + req.getRequestURI());  // In ra URL

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = req.getRequestURI();

        if (url.contains("/admin/category/update")) {
            System.out.println("Updating category");
            int categoryid = Integer.parseInt(req.getParameter("categoryid"));
            String categoryname = req.getParameter("categoryname");
            int status = Integer.parseInt(req.getParameter("status"));

            Category category = new Category();
            category.setCategoryId(categoryid);
            category.setCategoryname(categoryname);
            category.setStatus(status);

            try {
                Part part = req.getPart("images1");
                if (part != null) {
                    System.out.println("Image file uploaded: " + part.getSubmittedFileName());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            cateService.update(category);
            resp.sendRedirect(req.getContextPath() + "/admin/categories");

        } else if (url.contains("/admin/category/insert")) {
            System.out.println("Inserting new category");
            String categoryname = req.getParameter("categoryname");
            int status = Integer.parseInt(req.getParameter("status"));

            Category category = new Category();
            category.setCategoryname(categoryname);
            category.setStatus(status);

            cateService.insert(category);
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        }
    }
}
