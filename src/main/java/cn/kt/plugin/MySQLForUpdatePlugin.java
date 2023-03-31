/**
 * @(#)MySQLForUpdatePlugin.java, 2023/3/31.
 * <p/>
 * Copyright 2023 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package cn.kt.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.PrimitiveTypeWrapper;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

/**
 * @author wangliang07@corp.netease.com
 */
public class MySQLForUpdatePlugin extends PluginAdapter {
    public MySQLForUpdatePlugin() {
    }

    public boolean validate(List<String> warnings) {
        return true;
    }

    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        PrimitiveTypeWrapper booleanWrapper = FullyQualifiedJavaType.getBooleanPrimitiveInstance().getPrimitiveTypeWrapper();
        Field forUpdate = new Field();
        forUpdate.setName("forUpdate");
        forUpdate.setVisibility(JavaVisibility.PRIVATE);
        forUpdate.setType(booleanWrapper);
        topLevelClass.addField(forUpdate);
        Method setForUpdate = new Method();
        setForUpdate.setVisibility(JavaVisibility.PUBLIC);
        setForUpdate.setName("setForUpdate");
        setForUpdate.addParameter(new Parameter(booleanWrapper, "forUpdate"));
        setForUpdate.addBodyLine("this.forUpdate = forUpdate;");
        topLevelClass.addMethod(setForUpdate);
        Method getForUpdate = new Method();
        getForUpdate.setVisibility(JavaVisibility.PUBLIC);
        getForUpdate.setReturnType(booleanWrapper);
        getForUpdate.setName("getForUpdate");
        getForUpdate.addBodyLine("return forUpdate;");
        topLevelClass.addMethod(getForUpdate);
        return true;
    }

    private void appendForUpdate(XmlElement element, IntrospectedTable introspectedTable) {
        XmlElement forUpdateElement = new XmlElement("if");
        forUpdateElement.addAttribute(new Attribute("test", "forUpdate != null and forUpdate == true"));
        forUpdateElement.addElement(new TextElement("for update"));
        element.addElement(forUpdateElement);
    }

    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        this.appendForUpdate(element, introspectedTable);
        return true;
    }

    public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        this.appendForUpdate(element, introspectedTable);
        return true;
    }
}