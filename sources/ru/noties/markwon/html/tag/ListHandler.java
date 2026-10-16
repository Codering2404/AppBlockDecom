package ru.noties.markwon.html.tag;

import org.commonmark.node.ListItem;
import ru.noties.markwon.MarkwonConfiguration;
import ru.noties.markwon.MarkwonVisitor;
import ru.noties.markwon.RenderProps;
import ru.noties.markwon.SpanFactory;
import ru.noties.markwon.SpannableBuilder;
import ru.noties.markwon.core.CoreProps;
import ru.noties.markwon.html.HtmlTag;
import ru.noties.markwon.html.MarkwonHtmlRenderer;
import ru.noties.markwon.html.TagHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class ListHandler extends TagHandler {
    private static int a(HtmlTag.Block block) {
        int i3 = 0;
        while (true) {
            block = block.d();
            if (block == null) {
                return i3;
            }
            if ("ul".equals(block.name()) || "ol".equals(block.name())) {
                i3++;
            }
        }
    }

    @Override // ru.noties.markwon.html.TagHandler
    public void handle(MarkwonVisitor markwonVisitor, MarkwonHtmlRenderer markwonHtmlRenderer, HtmlTag htmlTag) {
        if (htmlTag.b()) {
            HtmlTag.Block blockA = htmlTag.a();
            boolean zEquals = "ol".equals(blockA.name());
            boolean zEquals2 = "ul".equals(blockA.name());
            if (zEquals || zEquals2) {
                MarkwonConfiguration markwonConfigurationX = markwonVisitor.x();
                RenderProps renderPropsQ = markwonVisitor.q();
                SpanFactory spanFactoryA = markwonConfigurationX.f().a(ListItem.class);
                int iA = a(blockA);
                int i3 = 1;
                for (HtmlTag.Block block : blockA.e()) {
                    TagHandler.visitChildren(markwonVisitor, markwonHtmlRenderer, block);
                    if (spanFactoryA != null && "li".equals(block.name())) {
                        if (zEquals) {
                            CoreProps.f147098a.e(renderPropsQ, CoreProps.ListItemType.ORDERED);
                            CoreProps.f147100c.e(renderPropsQ, Integer.valueOf(i3));
                            i3++;
                        } else {
                            CoreProps.f147098a.e(renderPropsQ, CoreProps.ListItemType.BULLET);
                            CoreProps.f147099b.e(renderPropsQ, Integer.valueOf(iA));
                        }
                        SpannableBuilder.j(markwonVisitor.builder(), spanFactoryA.a(markwonConfigurationX, renderPropsQ), block.start(), block.end());
                    }
                }
            }
        }
    }
}
