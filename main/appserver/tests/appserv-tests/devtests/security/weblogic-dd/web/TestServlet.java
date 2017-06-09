/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2017 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://oss.oracle.com/licenses/CDDL+GPL-1.1
 * or LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
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

package com.sun.security.devtests.weblogicdd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

public class TestServlet extends HttpServlet {

    private static final String[] roles = {"weblogic-xml", "weblogic-app-xml"};

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<br>Basic Authentication tests from Servlet: Test1,Test2 ");
        out.println("<br>Authorization test from Servlet: Test3 -> HttpServletRequest.isUserInRole() authorization from Servlet.");

        test1(request, response, out);
        test2(request, response, out);
        test3(request, response, out);
    }

    //Tests begin
    public void test1(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
        //Check the auth type - request.getAuthType()
        out.println("<br><br>Test1. Postive check for the correct authentication type");
        String authtype = request.getAuthType();
        if ("BASIC".equalsIgnoreCase(authtype)) {
            out.println("<br>request.getAuthType() test Passed.");
        } else {
            out.println("<br>request.getAuthType() test Failed!");
        }
        out.println("<br>Info:request.getAuthType() is= " + authtype);
    }
    //Test2

    public void test2(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
        Principal ruser = request.getUserPrincipal();
        out.println("<br><br>Test2. Positive check for the correct principal name");
        if (ruser != null) {
            out.println("<br>request.getUserPrincipal() test Passed.");
        } else {
            out.println("<br>request.getUserPrincipal() test Failed!");
        }
        out.println("<br>Info:request.getUserPrincipal() is= " + ruser);

    }
    //Test3 - positive test for checking the user's proper role

    public void test3(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
        out.println("<br><br>Test3. Positive check whether the user is in proper role");
        boolean isInProperRole = false;
        for (int i = 0; i < 2; i++) {
            if (request.isUserInRole(roles[i])) {
                isInProperRole = true;
                out.println("<br>Hello " + roles[i] + "!!!");
            }
        }
        if (isInProperRole) {
            out.println("<br>HttpServletRequest.isUserInRole() test Passed.");
        } else {
            out.println("<br>HttpServletRequest.isUserInRole() test Failed!");
        }
    }
}
