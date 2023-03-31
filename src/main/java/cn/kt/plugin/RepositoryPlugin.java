/**
 * @(#)RepositoryPlugin.java, 2023/3/31.
 * <p/>
 * Copyright 2023 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package cn.kt.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

/**
 * @author wangliang07@corp.netease.com
 */
public class RepositoryPlugin extends PluginAdapter {
    private FullyQualifiedJavaType annotationRepository = new FullyQualifiedJavaType("org.springframework.stereotype.Repository");
    private String annotation = "@Repository";

    public RepositoryPlugin() {
    }

    public boolean validate(List<String> list) {
        return true;
    }

    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        interfaze.addImportedType(this.annotationRepository);
        interfaze.addAnnotation(this.annotation);
        return true;
    }
}