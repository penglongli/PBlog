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

        String markdown = "```" +
                "var ceshi = 1;\n" +
                "var ceshi2 = 2;\n" +
                "```";
        PegDownProcessor processor = new PegDownProcessor(0, plugins);
        RootNode ast = processor.parseMarkdown(markdown.toCharArray());

        List<ToHtmlSerializerPlugin> serializePlugins = Arrays
                .asList((ToHtmlSerializerPlugin) (new ComponentSerializer()));

        String finalHtml = new ToHtmlSerializer(new LinkRenderer(), serializePlugins).toHtml(ast);

        System.out.println(finalHtml);
    }
}
