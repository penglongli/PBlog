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

        String markdown = "##MaHua是什么?\n" +
                "一个在线编辑markdown文档的编辑器\n" +
                "\n" +
                "向Mac下优秀的markdown编辑器mou致敬\n" +
                "\n" +
                "##MaHua有哪些功能？\n" +
                "\n" +
                "* 方便的`导入导出`功能\n" +
                "    *  直接把一个markdown的文本文件拖放到当前这个页面就可以了\n" +
                "    *  导出为一个html格式的文件，样式一点也不会丢失\n" +
                "* 编辑和预览`同步滚动`，所见即所得（右上角设置）\n" +
                "* `VIM快捷键`支持，方便vim党们快速的操作 （右上角设置）\n" +
                "* 强大的`自定义CSS`功能，方便定制自己的展示\n" +
                "* 有数量也有质量的`主题`,编辑器和预览区域\n" +
                "* 完美兼容`Github`的markdown语法\n" +
                "* 预览区域`代码高亮`\n" +
                "* 所有选项自动记忆\n" +
                "\n" +
                "##有问题反馈\n" +
                "在使用中有任何问题，欢迎反馈给我，可以用以下联系方式跟我交流\n" +
                "\n" +
                "* 邮件(dev.hubo#gmail.com, 把#换成@)\n" +
                "* QQ: 287759234\n" +
                "* weibo: [@草依山](http://weibo.com/ihubo)\n" +
                "* twitter: [@ihubo](http://twitter.com/ihubo)\n" +
                "\n" +
                "##捐助开发者\n" +
                "在兴趣的驱动下,写一个`免费`的东西，有欣喜，也还有汗水，希望你喜欢我的作品，同时也能支持一下。\n" +
                "当然，有钱捧个钱场（右上角的爱心标志，支持支付宝和PayPal捐助），没钱捧个人场，谢谢各位。\n" +
                "\n" +
                "##感激\n" +
                "感谢以下的项目,排名不分先后\n" +
                "\n" +
                "* [mou](http://mouapp.com/) \n" +
                "* [ace](http://ace.ajax.org/)\n" +
                "* [jquery](http://jquery.com)\n" +
                "\n" +
                "##关于作者\n" +
                "\n" +
                "```\n" +
                "  var ihubo = {\n" +
                "    nickName  : \"草依山\",\n" +
                "    site : \"http://jser.me\"\n" +
                "  }\n" +
                "```";
        PegDownProcessor processor = new PegDownProcessor(0, plugins);
        RootNode ast = processor.parseMarkdown(markdown.toCharArray());

        List<ToHtmlSerializerPlugin> serializePlugins = Arrays
                .asList((ToHtmlSerializerPlugin) (new ComponentSerializer()));

        String finalHtml = new ToHtmlSerializer(new LinkRenderer(), serializePlugins).toHtml(ast);

        System.out.println(finalHtml);
    }
}
