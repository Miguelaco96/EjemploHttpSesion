package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/SesionesServlet")

public class SesionesServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        response.setContentType("text/html;charset=UTF-8");     
       
        HttpSession sesion = request.getSession();
        
        String mensaje = null;
        
        Integer contador = (Integer) sesion.getAttribute("contadorVisitas");
        
        if(contador == null){           
            contador = 1;
            mensaje= "Gracias por unirte";      
            
        }else{

              contador++;
              mensaje= "Otra vez aqui";
        }      
        sesion.setAttribute("contadorVisitas", contador);
//        
        PrintWriter out = response.getWriter();
        
        out.println("el contador de sesion es; " + contador);
        
        out.println("El ID de la sesion es; " + sesion.getId());
        
    } 
    
    
}
