/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2002-2017 Oracle and/or its affiliates. All rights reserved.
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

package servletonly.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestClient {

    /* to test .reload look for a changed value from one run to the next */
    private String changeableValue = null;
    private String expectedChangeableValue = null;

    public static void main (String[] args) {
        TestClient client = new TestClient();
        client.doTest(args);
    }
    
    public void doTest(String[] args) {

        String url = args[0];
        if (args.length > 2) {
            expectedChangeableValue = args[2];
        }
        boolean testPositive = (Boolean.valueOf(args[1])).booleanValue();
        try {
            log("Test: devtests/deployment/war/servletonly");
            int code = invokeServlet(url);
            report(code, testPositive, expectedChangeableValue, changeableValue);
        } catch (IOException ex) {
            if (testPositive) {
                ex.printStackTrace();
                fail();
            } else {
                log("Caught EXPECTED IOException: " + ex);
                pass();
            }
	} catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    private int invokeServlet(String url) throws Exception {
        log("Invoking URL = " + url);
        URL u = new URL(url);
        HttpURLConnection c1 = (HttpURLConnection)u.openConnection();
        int code = c1.getResponseCode();
        InputStream is = c1.getInputStream();
        BufferedReader input = new BufferedReader (new InputStreamReader(is));
        String line = null;
        while ((line = input.readLine()) != null) {
            log(line);
            if (line.startsWith("changeableValue=")) {
                changeableValue = line.substring("changeableValue=".length());
            }
        }
        return code;
    }

    private void report(int code, boolean testPositive, String expectedChangeableValue, String changeableValue) {
        if (testPositive) { //expect return code 200
            if(code != 200) {
                log("Incorrect return code: " + code);
                fail();
            } else {
                log("Correct return code: " + code);
                if (expectedChangeableValue != null && expectedChangeableValue.length() > 0 &&
                        ! expectedChangeableValue.equals("${extra.args}")) {
                    if (expectedChangeableValue.equals(changeableValue)) {
                        log("Correct changeable value: " + changeableValue);
                        pass();
                    } else {
                        log("Incorrect changeable value: expected " + expectedChangeableValue + " but found " + changeableValue);
                        fail();
                    }
                } else {
                    // No expected changeable value to check.
                    pass();
                }
            }
        } else {
            if(code != 200) { //expect return code !200
                log("Correct return code: " + code);
                pass();
            } else {
                log("Incorrect return code: " + code);
                fail();
            }
        }
    }

    private void log(String message) {
        System.err.println("[war.client.Client]:: " + message);
    }

    private void pass() {
        log("PASSED: devtests/deployment/war/servletonly");
        System.exit(0);
    }

    private void fail() {
        log("FAILED: devtests/deployment/war/servletonly");
        System.exit(-1);
    }
}
