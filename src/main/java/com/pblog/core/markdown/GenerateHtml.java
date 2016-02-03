package com.pblog.core.markdown;


import org.pegdown.LinkRenderer;
import org.pegdown.PegDownProcessor;
import org.pegdown.ToHtmlSerializer;
import org.pegdown.ast.RootNode;
import org.pegdown.plugins.PegDownPlugins;
import org.pegdown.plugins.ToHtmlSerializerPlugin;

import java.util.Arrays;
import java.util.List;

public class GenerateHtml {

    public final static String markdownToHTML(String markdown){
        PegDownPlugins plugins = new PegDownPlugins.Builder().withPlugin(ComponentParser.class).build();

        PegDownProcessor processor = new PegDownProcessor(0, plugins);
        RootNode ast = processor.parseMarkdown(markdown.toCharArray());

        List<ToHtmlSerializerPlugin> serializePlugins = Arrays
                .asList((ToHtmlSerializerPlugin) (new ComponentSerializer()));

        return new ToHtmlSerializer(new LinkRenderer(), serializePlugins).toHtml(ast);
    }
}
