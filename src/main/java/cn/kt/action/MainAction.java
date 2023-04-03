package cn.kt.action;

import cn.kt.ui.MainUI;
import com.intellij.database.psi.DbTable;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiElement;

/**
 * mybatis generator工具生成类
 * Created by kangtian on 2018/7/17.
 */
public class MainAction extends AnAction {

    /**
     * 点击后打开插件主页面
     *
     * @param event -
     */
    @Override
    public void actionPerformed(AnActionEvent event) {
        PsiElement[] psiElements = event.getData(LangDataKeys.PSI_ELEMENT_ARRAY);
        if (psiElements == null || psiElements.length == 0) {
            Messages.showMessageDialog("Please select one table!", "Notice", Messages.getInformationIcon());
            return;
        } else if (psiElements.length > 1) {
            Messages.showMessageDialog("Not support multi table!", "Notice", Messages.getInformationIcon());
            return;
        }
        for (PsiElement psiElement : psiElements) {
            if (!(psiElement instanceof DbTable)) {
                Messages.showMessageDialog("Please select one or more tables", "Notice", Messages.getInformationIcon());
                return;
            }
        }
        new MainUI(event);
    }

}
