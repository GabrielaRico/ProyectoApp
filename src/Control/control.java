package Control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.*;

/**
 * Servlet implementation class control
 */



@WebServlet("/control")
public class control extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public control() {
        // TODO Auto-generated constructor stub
    	
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String pagina = request.getParameter("pagina");
        switch(pagina)
        {
            case "ProductoBusqueda":
                productosbusqueda(request,response);
                break;
            case "ProveedoresBusqueda":
                proveedorbusqueda(request,response);
                break;
            case "OrdenesBusqueda":
                ordenbusqueda(request,response);
                break;
        }
        
    }
	private void productosbusqueda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductosDAO pdao=new ProductosDAO();
        String descripcion = request.getParameter("descripcion");
        ArrayList <Productos> productos = pdao.Consulta(descripcion);
        request.setAttribute("productos",productos);
        response.sendRedirect("Productos.jsp");
	}
	private void proveedorbusqueda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProveedorDAO pdao=new ProveedorDAO();
        String descripcion = request.getParameter("descripcion");
        ArrayList <Proveedor> proveedores = pdao.Consulta(descripcion);
        request.setAttribute("proveedores",proveedores);
        response.sendRedirect("Proveedores.jsp");
	}
	private void ordenbusqueda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrdenDAO odao = new OrdenDAO();
		String id = request.getParameter("id");
		ArrayList<Orden> ordenes = odao.Consulta(id);
		request.setAttribute("ordenes",ordenes);
		response.sendRedirect("Ordenes.jsp");
	}
        
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        processRequest(request, response);
	}

}
