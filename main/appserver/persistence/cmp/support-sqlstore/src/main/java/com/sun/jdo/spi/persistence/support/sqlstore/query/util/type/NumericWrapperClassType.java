/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 1997-2017 Oracle and/or its affiliates. All rights reserved.
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

/*
 * NumericWrapperClassType.java
 *
 * Created on April 14, 2000
 */

package com.sun.jdo.spi.persistence.support.sqlstore.query.util.type;

/** 
 *
 * @author  Michael Bouschen
 * @version 0.1
 */
public class NumericWrapperClassType
    extends WrapperClassType
    implements NumberType
{
    /**
     *
     */
    public NumericWrapperClassType(String name, Class clazz, int enumType, 
                                   PrimitiveType primitiveType, TypeTable typetab)
    {
        super(name, clazz, enumType, primitiveType, typetab);
    }
    
    /**
     * A numeric wrapper class type defines an ordering.
     */
    public boolean isOrderable()
    {
        return true;
    }

    /**
     * Converts the specified value into a value of this numeric type.
     * E.g. an Integer is converted into a Double, if this represents 
     * the numeric type double.
     * @param value value to be converted
     * @return converted value
     */
    public Number getValue(Number value)
    {
        return ((NumericType)primitiveType).getValue(value);
    }

    /**
     * Returns -value. 
     * @param value value to be negated
     * @return -value
     */
    public Number negate(Number value)
    {
        return ((NumericType)primitiveType).negate(value);
    }
}
