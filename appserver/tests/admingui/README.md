[//]: # " DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER. "
[//]: # "  "
[//]: # " Copyright (c) 2018 Oracle and/or its affiliates. All rights reserved. "
[//]: # "  "
[//]: # " The contents of this file are subject to the terms of either the GNU "
[//]: # " General Public License Version 2 only (''GPL'') or the Common Development "
[//]: # " and Distribution License(''CDDL'') (collectively, the ''License'').  You "
[//]: # " may not use this file except in compliance with the License.  You can "
[//]: # " obtain a copy of the License at "
[//]: # " https://oss.oracle.com/licenses/CDDL+GPL-1.1 "
[//]: # " or LICENSE.txt.  See the License for the specific "
[//]: # " language governing permissions and limitations under the License. "
[//]: # "  "
[//]: # " When distributing the software, include this License Header Notice in each "
[//]: # " file and include the License file at LICENSE.txt. "
[//]: # "  "
[//]: # " GPL Classpath Exception: "
[//]: # " Oracle designates this particular file as subject to the ''Classpath'' "
[//]: # " exception as provided by Oracle in the GPL Version 2 section of the License "
[//]: # " file that accompanied this code. "
[//]: # "  "
[//]: # " Modifications: "
[//]: # " If applicable, add the following below the License Header, with the fields "
[//]: # " enclosed by brackets [] replaced by your own identifying information: "
[//]: # " ''Portions Copyright [year] [name of copyright owner]'' "
[//]: # "  "
[//]: # " Contributor(s): "
[//]: # " If you wish your version of this file to be governed by only the CDDL or "
[//]: # " only the GPL Version 2, indicate your decision by adding ''[Contributor] "
[//]: # " elects to include this software in this distribution under the [CDDL or GPL "
[//]: # " Version 2] license.''  If you don't indicate a single choice of license, a "
[//]: # " recipient has the option to distribute your version of this file under "
[//]: # " either the CDDL, the GPL Version 2 or to extend the choice of license to "
[//]: # " its licensees as provided above.  However, if you add GPL Version 2 code "
[//]: # " and therefore, elected the GPL Version 2 license, then the option applies "
[//]: # " only if the new code is made subject to such option by the copyright "
[//]: # " holder. "

#How to run the dev test cases
================================
#Annotation: 
All of the test cases can't be ran on the windows platform because 
the firefox can't support the JSF based on the windows platform very well.
If you want to ran the tests, please check out all of the codes to the linux, ubuntu or
mac platform.

#Preparation and Steps:
1). Download the firefox and install it, On my platform, I have downloaded and installed 
the firefox version 19.0

2). Download the selenium IDE plugin and installed, On my platform, I have installed the 
selenium IDE 2.4.0

3). Checkout the the tests from the github(https://github.com/LvSongping/GLASSFISH_ADMIN_CONSOLE_DEVTESTS/tree/master/auto-test) 
to your hard disk.

4). Before ran the tests, you need to restart the glassfish domain and try to access admin console's page(http://localhost:4848/common/index.jsf) 
to make sure the GUI is available

5). Open a terminal window and access to the root directory of auto-tests, Then execute the command 
as "mvn test" to run all of the tests

6). If some of the test cases are failed, you can also rerun the error or failed test cases 
using the command as "mvn test -Dtest=[ClassName]#[MethodName]" to confirm related test 
cases.(if the failure test cases passed at the second time, we can regard the failure test 
case as a passed case)

#Note:
The expected test results listed as follows:
test cases number:110
passed number:110
failed number:0
error number:0

