/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2010 Sun Microsystems, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://glassfish.dev.java.net/public/CDDL+GPL.html
 * or glassfish/bootstrap/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/bootstrap/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 *
 * Contributor(s):
 *
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package webclient;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.ws.*;
import javax.xml.ws.soap.*;

import service.*;

/**
 * @author Rama Pulavarthi
 */
public class Client extends HttpServlet {

    @javax.xml.ws.WebServiceRef
    SubtractNumbersService service;

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws javax.servlet.ServletException {
        doPost(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws javax.servlet.ServletException {
        try {
            com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump = true;
            SubtractNumbers port2 = service.getSubtractNumbersPort();

            ((BindingProvider) port2).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                    "http://localhost:8080/webserviceref-cobundle/SubtractNumbersService?WSDL");
            int ret = port2.subtractNumbers(9999, 4444);
            PrintWriter out = resp.getWriter();
            resp.setContentType("text/html");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>TestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>");
            out.println("So the RESULT OF SUBTRACT SERVICE IS :");
            out.println("</p>");
            out.println("[" + ret + "]");
            out.println("</body>");
            out.println("</html>");
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

