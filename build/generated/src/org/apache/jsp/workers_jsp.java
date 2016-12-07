package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class workers_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <script src=\"bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"bootstrap-3.3.7-dist/js/bootstrap.js\" type=\"text/javascript\"></script>\n");
      out.write("        <link href=\"bootstrap-3.3.7-dist/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>Workers</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Данные работника</h1>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <form class=\"form-horizontal\">   \n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label col-sm-2\" for=\"firstname\">Имя:</label>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"firstname\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label col-sm-2\" for=\"lastname\">Фамилия:</label>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"lastname\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label col-sm-2\" for=\"isikukood\">Isikukood:</label>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"isikukood\">\n");
      out.write("                    </div>   \n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label col-sm-2\" for=\"adress\">Адрес:</label>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"adress\">\n");
      out.write("                    </div>   \n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label col-sm-2\" for=\"telefon\">Телефон:</label>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"telefon\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">        \n");
      out.write("                    <div class=\"col-sm-offset-2 col-sm-10\">\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-info btn-xs\" id=\"add\">Добавить</button>\n");
      out.write("                        <button type=\"button\" class=\"btn btn-info btn-xs\" data-toggle=\"modal\" data-target=\"#myModal\" id=\"change\">Удалить</button>\n");
      out.write("                        <div class=\"modal fade\" id=\"myModal\" role=\"dialog\">\n");
      out.write("                            <div class=\"modal-dialog\">\n");
      out.write("\n");
      out.write("                                <!-- Modal content-->\n");
      out.write("                                <div class=\"modal-content\">\n");
      out.write("                                    <div class=\"modal-header\">\n");
      out.write("                                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                                        <h4 class=\"modal-title\">Удалить данные работника</h4>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"modal-body\">\n");
      out.write("                                        <form class=\"form-horizontal\">   \n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label class=\"control-label col-sm-2\" for=\"firstname\">Имя:</label>\n");
      out.write("                                                <div class=\"col-sm-10\">\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" readonly id=\"firstname\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label class=\"control-label col-sm-2\" for=\"lastname\">Фамилия:</label>\n");
      out.write("                                                <div class=\"col-sm-10\">\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" id=\"lastname\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label class=\"control-label col-sm-2\" for=\"isikukood\">Isikukood:</label>\n");
      out.write("                                                <div class=\"col-sm-10\">\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" id=\"isikukood\">\n");
      out.write("                                                </div>   \n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label class=\"control-label col-sm-2\" for=\"adress\">Адрес:</label>\n");
      out.write("                                                <div class=\"col-sm-10\">\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" id=\"adress\">\n");
      out.write("                                                </div>   \n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label class=\"control-label col-sm-2\" for=\"telefon\">Телефон:</label>\n");
      out.write("                                                <div class=\"col-sm-10\">\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" id=\"telefon\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"modal-footer\">\n");
      out.write("                                        <button type=\"button\" class=\"btn btn-info btn-xs\" data-toggle=\"modal\" data-target=\"#myModal\" id=\"remove\">Удалить</button>\n");
      out.write("                                        <button type=\"button\" class=\"btn btn-info btn-xs\" data-toggle=\"modal\" data-target=\"#myModal\" id=\"remove\">Закрыть</button>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <button type=\"button\" class=\"btn btn-info btn-xs\" data-toggle=\"modal\" data-target=\"#myModal\" id=\"remove\"></button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
