/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2007 Sun Microsystems, Inc. All rights reserved.
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



package com.sun.enterprise.config.serverbeans;


import org.jvnet.hk2.config.Attribute;
import org.jvnet.hk2.config.Element;
import org.jvnet.hk2.config.Configured;
import org.jvnet.hk2.config.ConfigBeanProxy;
import org.jvnet.hk2.component.Injectable;

import java.beans.PropertyVetoException;
import java.util.List;

import org.glassfish.api.admin.config.PropertiesDesc;
import org.glassfish.api.amx.AMXConfigInfo;
import org.glassfish.api.admin.config.Property;
import org.glassfish.api.admin.config.PropertyBag;

import org.glassfish.quality.ToDo;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

/**
 *
 */

/* @XmlType(name = "", propOrder = {
    "property"
}) */
@AMXConfigInfo( amxInterfaceName="com.sun.appserv.management.config.DiagnosticServiceConfig", singleton=true)
@Configured
public interface DiagnosticService extends ConfigBeanProxy, Injectable, PropertyBag {

    /**
     * Gets the value of the computeChecksum property.
     * Boolean attribute. Indicates whether checksum of binaries is computed.
     *
     * @return possible object is
     *         {@link String }
     */
    @Attribute (defaultValue="true")
    String getComputeChecksum();

    /**
     * Sets the value of the computeChecksum property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setComputeChecksum(String value) throws PropertyVetoException;

    /**
     * Gets the value of the verifyConfig property.
     *
     * A boolean attribute which indicates whether output of verify-config
     * asadmin command is included in the diagnostic report.
     *
     * @return possible object is
     *         {@link String }
     */
    @Attribute (defaultValue="true")
    String getVerifyConfig();

    /**
     * Sets the value of the verifyConfig property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setVerifyConfig(String value) throws PropertyVetoException;

    /**
     * Gets the value of the captureInstallLog property.
     *
     * Boolean attribute which indicated whether the log generated  during
     * installation of the application server is captured.
     *
     * @return possible object is
     *         {@link String }
     */
    @Attribute (defaultValue="true")
    String getCaptureInstallLog();

    /**
     * Sets the value of the captureInstallLog property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setCaptureInstallLog(String value) throws PropertyVetoException;

    /**
     * Gets the value of the captureSystemInfo property.
     * Boolean attribute which specifies whether OS level information is
     * collected as part of diagnostic report.        
     *
     * @return possible object is
     *         {@link String }
     */
    @Attribute (defaultValue="true")
    String getCaptureSystemInfo();

    /**
     * Sets the value of the captureSystemInfo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setCaptureSystemInfo(String value) throws PropertyVetoException;

    /**
     * Gets the value of the captureHadbInfo property.
     *
     * Boolean attribute to indicate if HADB related information is collected.
     *
     * @return possible object is
     *         {@link String }
     */
    @Attribute (defaultValue="true")
    String getCaptureHadbInfo();

    /**
     * Sets the value of the captureHadbInfo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setCaptureHadbInfo(String value) throws PropertyVetoException;

    /**
     * Gets the value of the captureAppDd property.
     *
     * Boolean attribute. If "true", application deployment descriptors in plain
     * text are captured as part of diagnostic report. If Deployment descriptors
     * contain any confidential information, it's recommended to set it to false
     * 
     * @return possible object is
     *         {@link String }
     */
    @Attribute (defaultValue="true")
    String getCaptureAppDd();

    /**
     * Sets the value of the captureAppDd property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setCaptureAppDd(String value) throws PropertyVetoException;

    /**
     * Gets the value of the minLogLevel property.
     *
     * The log levels can be changed using one of the seven levels.
     * Please refer JSR 047 to understand the Log Levels. The default level is
     * INFO, meaning that messages at that level or higher (WARNING, SEVERE) are
     * captured as part of the diagnostic report.If set to OFF, log contents
     * will not be captured as part of diagnostic report.
     *
     * @return possible object is
     *         {@link String }
     */
    @Attribute (defaultValue="INFO")
    String getMinLogLevel();

    /**
     * Sets the value of the minLogLevel property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setMinLogLevel(String value) throws PropertyVetoException;

    /**
     * Gets the value of the maxLogEntries property.
     *
     * Max no. of log entries being captured as part of diagnostic  report.
     * A non negative value.
     * 
     * @return possible object is
     *         {@link String }
     */
    @Attribute (defaultValue="500")
    @Min(value=0)
    String getMaxLogEntries();

    /**
     * Sets the value of the maxLogEntries property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setMaxLogEntries(String value) throws PropertyVetoException;
    
    /**
    	Properties as per {@link PropertyBag}
     */
    @ToDo(priority=ToDo.Priority.IMPORTANT, details="Provide PropertyDesc for legal props" )
    @PropertiesDesc(props={})
    @Element
    List<Property> getProperty();
}
