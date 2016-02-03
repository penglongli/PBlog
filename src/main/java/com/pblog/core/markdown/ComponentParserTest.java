package com.pblog.core.markdown;

import org.parboiled.BaseParser;
import org.pegdown.LinkRenderer;
import org.pegdown.PegDownProcessor;
import org.pegdown.ToHtmlSerializer;
import org.pegdown.ast.RootNode;
import org.pegdown.plugins.PegDownPlugins;
import org.pegdown.plugins.ToHtmlSerializerPlugin;

import java.util.Arrays;
import java.util.List;

public class ComponentParserTest extends BaseParser{

    public static void main(String[] args){
        PegDownPlugins plugins = new PegDownPlugins.Builder().withPlugin(ComponentParser.class).build();

        String markdown = "# 欢迎使用 Cmd Markdown 编辑阅读器\n" +
                "\n" +
                "------\n" +
                "\n" +
                "我们理解您需要更便捷更高效的工具记录思想，整理笔记、知识，并将其中承载的价值传播给他人，**Cmd Markdown** 是我们给出的答案 —— 我们为记录思想和分享知识提供更专业的工具。 您可以使用 Cmd Markdown：\n" +
                "\n" +
                "> * 整理知识，学习笔记\n" +
                "> * 发布日记，杂文，所见所想\n" +
                "> * 撰写发布技术文稿（代码支持）\n" +
                "> * 撰写发布学术论文（LaTeX 公式支持）";
        PegDownProcessor processor = new PegDownProcessor(0, plugins);
        RootNode ast = processor.parseMarkdown(markdown.toCharArray());

        List<ToHtmlSerializerPlugin> serializePlugins = Arrays
                .asList((ToHtmlSerializerPlugin) (new ComponentSerializer()));

        String finalHtml = new ToHtmlSerializer(new LinkRenderer(), serializePlugins).toHtml(ast);

        System.out.println(finalHtml);
    }
}
