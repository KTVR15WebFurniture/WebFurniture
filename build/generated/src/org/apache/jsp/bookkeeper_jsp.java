package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class bookkeeper_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <script src=\"bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"bootstrap-3.3.7-dist/js/bootstrap.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <link href=\"bootstrap-3.3.7-dist/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        <link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\r\n");
      out.write("        <title>bookkepper</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h1>Зарплата</h1>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"calender\">\r\n");
      out.write("            <table id=\"calendar3\">\r\n");
      out.write("                <thead>\r\n");
      out.write("                    <tr><td colspan=\"4\"><select>\r\n");
      out.write("                                <option value=\"0\">Январь</option>\r\n");
      out.write("                                <option value=\"1\">Февраль</option>\r\n");
      out.write("                                <option value=\"2\">Март</option>\r\n");
      out.write("                                <option value=\"3\">Апрель</option>\r\n");
      out.write("                                <option value=\"4\">Май</option>\r\n");
      out.write("                                <option value=\"5\">Июнь</option>\r\n");
      out.write("                                <option value=\"6\">Июль</option>\r\n");
      out.write("                                <option value=\"7\">Август</option>\r\n");
      out.write("                                <option value=\"8\">Сентябрь</option>\r\n");
      out.write("                                <option value=\"9\">Октябрь</option>\r\n");
      out.write("                                <option value=\"10\">Ноябрь</option>\r\n");
      out.write("                                <option value=\"11\">Декабрь</option>\r\n");
      out.write("                            </select><td colspan=\"3\"><input type=\"number\" value=\"\" min=\"0\" max=\"9999\" size=\"4\">\r\n");
      out.write("                    <tr><td>Пн<td>Вт<td>Ср<td>Чт<td>Пт<td>Сб<td>Вс\r\n");
      out.write("                <tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("\r\n");
      out.write("            <script>\r\n");
      out.write("                function Calendar3(id, year, month) {\r\n");
      out.write("                    var Dlast = new Date(year, month + 1, 0).getDate(),\r\n");
      out.write("                            D = new Date(year, month, Dlast),\r\n");
      out.write("                            DNlast = D.getDay(),\r\n");
      out.write("                            DNfirst = new Date(D.getFullYear(), D.getMonth(), 1).getDay(),\r\n");
      out.write("                            calendar = '<tr>',\r\n");
      out.write("                            m = document.querySelector('#' + id + ' option[value=\"' + D.getMonth() + '\"]'),\r\n");
      out.write("                            g = document.querySelector('#' + id + ' input');\r\n");
      out.write("                    if (DNfirst != 0) {\r\n");
      out.write("                        for (var i = 1; i < DNfirst; i++)\r\n");
      out.write("                            calendar += '<td>';\r\n");
      out.write("                    } else {\r\n");
      out.write("                        for (var i = 0; i < 6; i++)\r\n");
      out.write("                            calendar += '<td>';\r\n");
      out.write("                    }\r\n");
      out.write("                    for (var i = 1; i <= Dlast; i++) {\r\n");
      out.write("                        if (i == new Date().getDate() && D.getFullYear() == new Date().getFullYear() && D.getMonth() == new Date().getMonth()) {\r\n");
      out.write("                            calendar += '<td class=\"today\">' + i;\r\n");
      out.write("                        } else {\r\n");
      out.write("                            if (// список официальных праздников\r\n");
      out.write("                                    (i == 1 && D.getMonth() == 0 && ((D.getFullYear() > 1897 && D.getFullYear() < 1930) || D.getFullYear() > 1947)) || // Новый год\r\n");
      out.write("                                    (i == 2 && D.getMonth() == 0 && D.getFullYear() > 1992) || // Новый год\r\n");
      out.write("                                    ((i == 3 || i == 4 || i == 5 || i == 6 || i == 8) && D.getMonth() == 0 && D.getFullYear() > 2004) || // Новый год\r\n");
      out.write("                                    (i == 7 && D.getMonth() == 0 && D.getFullYear() > 1990) || // Рождество Христово\r\n");
      out.write("                                    (i == 23 && D.getMonth() == 1 && D.getFullYear() > 2001) || // День защитника Отечества\r\n");
      out.write("                                    (i == 8 && D.getMonth() == 2 && D.getFullYear() > 1965) || // Международный женский день\r\n");
      out.write("                                    (i == 1 && D.getMonth() == 4 && D.getFullYear() > 1917) || // Праздник Весны и Труда\r\n");
      out.write("                                    (i == 9 && D.getMonth() == 4 && D.getFullYear() > 1964) || // День Победы\r\n");
      out.write("                                    (i == 12 && D.getMonth() == 5 && D.getFullYear() > 1990) || // День России (декларации о государственном суверенитете Российской Федерации ознаменовала окончательный Распад СССР)\r\n");
      out.write("                                    (i == 7 && D.getMonth() == 10 && (D.getFullYear() > 1926 && D.getFullYear() < 2005)) || // Октябрьская революция 1917 года\r\n");
      out.write("                                    (i == 8 && D.getMonth() == 10 && (D.getFullYear() > 1926 && D.getFullYear() < 1992)) || // Октябрьская революция 1917 года\r\n");
      out.write("                                    (i == 4 && D.getMonth() == 10 && D.getFullYear() > 2004) // День народного единства, который заменил Октябрьскую революцию 1917 года\r\n");
      out.write("                                    ) {\r\n");
      out.write("                                calendar += '<td class=\"holiday\">' + i;\r\n");
      out.write("                            } else {\r\n");
      out.write("                                calendar += '<td>' + i;\r\n");
      out.write("                            }\r\n");
      out.write("                        }\r\n");
      out.write("                        if (new Date(D.getFullYear(), D.getMonth(), i).getDay() == 0) {\r\n");
      out.write("                            calendar += '<tr>';\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("                    for (var i = DNlast; i < 7; i++)\r\n");
      out.write("                        calendar += '<td>&nbsp;';\r\n");
      out.write("                    document.querySelector('#' + id + ' tbody').innerHTML = calendar;\r\n");
      out.write("                    g.value = D.getFullYear();\r\n");
      out.write("                    m.selected = true;\r\n");
      out.write("                    if (document.querySelectorAll('#' + id + ' tbody tr').length < 6) {\r\n");
      out.write("                        document.querySelector('#' + id + ' tbody').innerHTML += '<tr><td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;';\r\n");
      out.write("                    }\r\n");
      out.write("                    document.querySelector('#' + id + ' option[value=\"' + new Date().getMonth() + '\"]').style.color = 'rgb(220, 0, 0)'; // в выпадающем списке выделен текущий месяц\r\n");
      out.write("                }\r\n");
      out.write("                Calendar3(\"calendar3\", new Date().getFullYear(), new Date().getMonth());\r\n");
      out.write("                document.querySelector('#calendar3').onchange = function Kalendar3() {\r\n");
      out.write("                    Calendar3(\"calendar3\", document.querySelector('#calendar3 input').value, parseFloat(document.querySelector('#calendar3 select').options[document.querySelector('#calendar3 select').selectedIndex].value));\r\n");
      out.write("                }\r\n");
      out.write("            </script>  \r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <select class=\"form-control\" id=\"sel1\">\r\n");
      out.write("                    <option>1</option>\r\n");
      out.write("                    <option>2</option>\r\n");
      out.write("                    <option>3</option>\r\n");
      out.write("                    <option>4</option>\r\n");
      out.write("                </select>\r\n");
      out.write("            </div>\r\n");
      out.write("            <p></p>\r\n");
      out.write("            <table class=\"table\">\r\n");
      out.write("                <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th>Имя</th>\r\n");
      out.write("                        <th>Фамилия</th>\r\n");
      out.write("                        <th>Зарплата</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </thead>\r\n");
      out.write("                <tbody>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>----------------------------</td>\r\n");
      out.write("                        <td>-------------------------------</td>\r\n");
      out.write("                        <td>------------------------------</td>\r\n");
      out.write("                    </tr>      \r\n");
      out.write("                    <tr class=\"success\">\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr class=\"danger\">\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr class=\"info\">\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr class=\"warning\">\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr class=\"active\">\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
