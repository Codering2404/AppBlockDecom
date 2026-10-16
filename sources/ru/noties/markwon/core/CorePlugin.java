package ru.noties.markwon.core;

import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Heading;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Link;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;
import ru.noties.markwon.AbstractMarkwonPlugin;
import ru.noties.markwon.MarkwonSpansFactory;
import ru.noties.markwon.MarkwonVisitor;
import ru.noties.markwon.core.CoreProps;
import ru.noties.markwon.core.factory.BlockQuoteSpanFactory;
import ru.noties.markwon.core.factory.CodeBlockSpanFactory;
import ru.noties.markwon.core.factory.CodeSpanFactory;
import ru.noties.markwon.core.factory.EmphasisSpanFactory;
import ru.noties.markwon.core.factory.HeadingSpanFactory;
import ru.noties.markwon.core.factory.LinkSpanFactory;
import ru.noties.markwon.core.factory.ListItemSpanFactory;
import ru.noties.markwon.core.factory.StrongEmphasisSpanFactory;
import ru.noties.markwon.core.factory.ThematicBreakSpanFactory;
import ru.noties.markwon.core.spans.OrderedListItemSpan;
import ru.noties.markwon.priority.Priority;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class CorePlugin extends AbstractMarkwonPlugin {
    protected CorePlugin() {
    }

    private static void c(MarkwonVisitor.Builder builder) {
        builder.b(BlockQuote.class, new MarkwonVisitor.NodeVisitor<BlockQuote>() { // from class: ru.noties.markwon.core.CorePlugin.4
            @Override // ru.noties.markwon.MarkwonVisitor.NodeVisitor
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(MarkwonVisitor markwonVisitor, BlockQuote blockQuote) {
                markwonVisitor.B();
                int length = markwonVisitor.length();
                markwonVisitor.f(blockQuote);
                markwonVisitor.r(blockQuote, length);
                if (markwonVisitor.i(blockQuote)) {
                    markwonVisitor.B();
                    markwonVisitor.z();
                }
            }
        });
    }

    private static void d(MarkwonVisitor.Builder builder) {
        builder.b(BulletList.class, new SimpleBlockNodeVisitor());
    }

    private static void e(MarkwonVisitor.Builder builder) {
        builder.b(Code.class, new MarkwonVisitor.NodeVisitor<Code>() { // from class: ru.noties.markwon.core.CorePlugin.5
            @Override // ru.noties.markwon.MarkwonVisitor.NodeVisitor
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(MarkwonVisitor markwonVisitor, Code code) {
                int length = markwonVisitor.length();
                markwonVisitor.builder().append((char) 160).d(code.o()).append((char) 160);
                markwonVisitor.r(code, length);
            }
        });
    }

    public static CorePlugin f() {
        return new CorePlugin();
    }

    private static void g(MarkwonVisitor.Builder builder) {
        builder.b(Emphasis.class, new MarkwonVisitor.NodeVisitor<Emphasis>() { // from class: ru.noties.markwon.core.CorePlugin.3
            @Override // ru.noties.markwon.MarkwonVisitor.NodeVisitor
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(MarkwonVisitor markwonVisitor, Emphasis emphasis) {
                int length = markwonVisitor.length();
                markwonVisitor.f(emphasis);
                markwonVisitor.r(emphasis, length);
            }
        });
    }

    private static void h(MarkwonVisitor.Builder builder) {
        builder.b(FencedCodeBlock.class, new MarkwonVisitor.NodeVisitor<FencedCodeBlock>() { // from class: ru.noties.markwon.core.CorePlugin.6
            @Override // ru.noties.markwon.MarkwonVisitor.NodeVisitor
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(MarkwonVisitor markwonVisitor, FencedCodeBlock fencedCodeBlock) {
                CorePlugin.v(markwonVisitor, fencedCodeBlock.s(), fencedCodeBlock.t(), fencedCodeBlock);
            }
        });
    }

    private static void i(MarkwonVisitor.Builder builder) {
        builder.b(HardLineBreak.class, new MarkwonVisitor.NodeVisitor<HardLineBreak>() { // from class: ru.noties.markwon.core.CorePlugin.12
            @Override // ru.noties.markwon.MarkwonVisitor.NodeVisitor
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(MarkwonVisitor markwonVisitor, HardLineBreak hardLineBreak) {
                markwonVisitor.B();
            }
        });
    }

    private static void j(MarkwonVisitor.Builder builder) {
        builder.b(Heading.class, new MarkwonVisitor.NodeVisitor<Heading>() { // from class: ru.noties.markwon.core.CorePlugin.10
            @Override // ru.noties.markwon.MarkwonVisitor.NodeVisitor
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(MarkwonVisitor markwonVisitor, Heading heading) {
                markwonVisitor.B();
                int length = markwonVisitor.length();
                markwonVisitor.f(heading);
                CoreProps.f147101d.e(markwonVisitor.q(), Integer.valueOf(heading.p()));
                markwonVisitor.r(heading, length);
                if (markwonVisitor.i(heading)) {
                    markwonVisitor.B();
                    markwonVisitor.z();
                }
            }
        });
    }

    private static void k(MarkwonVisitor.Builder builder) {
        builder.b(IndentedCodeBlock.class, new MarkwonVisitor.NodeVisitor<IndentedCodeBlock>() { // from class: ru.noties.markwon.core.CorePlugin.7
            @Override // ru.noties.markwon.MarkwonVisitor.NodeVisitor
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(MarkwonVisitor markwonVisitor, IndentedCodeBlock indentedCodeBlock) {
                CorePlugin.v(markwonVisitor, null, indentedCodeBlock.p(), indentedCodeBlock);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(Paragraph paragraph) {
        Block blockG = paragraph.g();
        if (blockG == null) {
            return false;
        }
        Node nodeG = blockG.g();
        if (nodeG instanceof ListBlock) {
            return ((ListBlock) nodeG).p();
        }
        return false;
    }

    private static void m(MarkwonVisitor.Builder builder) {
        builder.b(Link.class, new MarkwonVisitor.NodeVisitor<Link>() { // from class: ru.noties.markwon.core.CorePlugin.14
            @Override // ru.noties.markwon.MarkwonVisitor.NodeVisitor
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(MarkwonVisitor markwonVisitor, Link link) {
                int length = markwonVisitor.length();
                markwonVisitor.f(link);
                CoreProps.f147102e.e(markwonVisitor.q(), markwonVisitor.x().i().a(link.o()));
                markwonVisitor.r(link, length);
            }
        });
    }

    private static void n(MarkwonVisitor.Builder builder) {
        builder.b(ListItem.class, new MarkwonVisitor.NodeVisitor<ListItem>() { // from class: ru.noties.markwon.core.CorePlugin.8
            @Override // ru.noties.markwon.MarkwonVisitor.NodeVisitor
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(MarkwonVisitor markwonVisitor, ListItem listItem) {
                int length = markwonVisitor.length();
                markwonVisitor.f(listItem);
                Block blockG = listItem.g();
                if (blockG instanceof OrderedList) {
                    OrderedList orderedList = (OrderedList) blockG;
                    int iS = orderedList.s();
                    CoreProps.f147098a.e(markwonVisitor.q(), CoreProps.ListItemType.ORDERED);
                    CoreProps.f147100c.e(markwonVisitor.q(), Integer.valueOf(iS));
                    orderedList.u(orderedList.s() + 1);
                } else {
                    CoreProps.f147098a.e(markwonVisitor.q(), CoreProps.ListItemType.BULLET);
                    CoreProps.f147099b.e(markwonVisitor.q(), Integer.valueOf(CorePlugin.o(listItem)));
                }
                markwonVisitor.r(listItem, length);
                if (markwonVisitor.i(listItem)) {
                    markwonVisitor.B();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int o(Node node) {
        int i3 = 0;
        for (Node nodeG = node.g(); nodeG != null; nodeG = nodeG.g()) {
            if (nodeG instanceof ListItem) {
                i3++;
            }
        }
        return i3;
    }

    private static void p(MarkwonVisitor.Builder builder) {
        builder.b(OrderedList.class, new SimpleBlockNodeVisitor());
    }

    private static void q(MarkwonVisitor.Builder builder) {
        builder.b(Paragraph.class, new MarkwonVisitor.NodeVisitor<Paragraph>() { // from class: ru.noties.markwon.core.CorePlugin.13
            @Override // ru.noties.markwon.MarkwonVisitor.NodeVisitor
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(MarkwonVisitor markwonVisitor, Paragraph paragraph) {
                boolean zL = CorePlugin.l(paragraph);
                if (!zL) {
                    markwonVisitor.B();
                }
                int length = markwonVisitor.length();
                markwonVisitor.f(paragraph);
                CoreProps.f147103f.e(markwonVisitor.q(), Boolean.valueOf(zL));
                markwonVisitor.r(paragraph, length);
                if (zL || !markwonVisitor.i(paragraph)) {
                    return;
                }
                markwonVisitor.B();
                markwonVisitor.z();
            }
        });
    }

    private static void r(MarkwonVisitor.Builder builder) {
        builder.b(SoftLineBreak.class, new MarkwonVisitor.NodeVisitor<SoftLineBreak>() { // from class: ru.noties.markwon.core.CorePlugin.11
            @Override // ru.noties.markwon.MarkwonVisitor.NodeVisitor
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(MarkwonVisitor markwonVisitor, SoftLineBreak softLineBreak) {
                markwonVisitor.builder().append(' ');
            }
        });
    }

    private static void s(MarkwonVisitor.Builder builder) {
        builder.b(StrongEmphasis.class, new MarkwonVisitor.NodeVisitor<StrongEmphasis>() { // from class: ru.noties.markwon.core.CorePlugin.2
            @Override // ru.noties.markwon.MarkwonVisitor.NodeVisitor
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(MarkwonVisitor markwonVisitor, StrongEmphasis strongEmphasis) {
                int length = markwonVisitor.length();
                markwonVisitor.f(strongEmphasis);
                markwonVisitor.r(strongEmphasis, length);
            }
        });
    }

    private static void t(MarkwonVisitor.Builder builder) {
        builder.b(Text.class, new MarkwonVisitor.NodeVisitor<Text>() { // from class: ru.noties.markwon.core.CorePlugin.1
            @Override // ru.noties.markwon.MarkwonVisitor.NodeVisitor
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(MarkwonVisitor markwonVisitor, Text text) {
                markwonVisitor.builder().d(text.o());
            }
        });
    }

    private static void u(MarkwonVisitor.Builder builder) {
        builder.b(ThematicBreak.class, new MarkwonVisitor.NodeVisitor<ThematicBreak>() { // from class: ru.noties.markwon.core.CorePlugin.9
            @Override // ru.noties.markwon.MarkwonVisitor.NodeVisitor
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(MarkwonVisitor markwonVisitor, ThematicBreak thematicBreak) {
                markwonVisitor.B();
                int length = markwonVisitor.length();
                markwonVisitor.builder().append((char) 160);
                markwonVisitor.r(thematicBreak, length);
                if (markwonVisitor.i(thematicBreak)) {
                    markwonVisitor.B();
                    markwonVisitor.z();
                }
            }
        });
    }

    static void v(MarkwonVisitor markwonVisitor, String str, String str2, Node node) {
        markwonVisitor.B();
        int length = markwonVisitor.length();
        markwonVisitor.builder().append((char) 160).append('\n').append(markwonVisitor.x().g().a(str, str2));
        markwonVisitor.B();
        markwonVisitor.builder().append((char) 160);
        markwonVisitor.r(node, length);
        if (markwonVisitor.i(node)) {
            markwonVisitor.B();
            markwonVisitor.z();
        }
    }

    @Override // ru.noties.markwon.AbstractMarkwonPlugin, ru.noties.markwon.MarkwonPlugin
    public void afterSetText(TextView textView) {
        if (textView.getMovementMethod() == null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    @Override // ru.noties.markwon.AbstractMarkwonPlugin, ru.noties.markwon.MarkwonPlugin
    public void beforeSetText(TextView textView, Spanned spanned) {
        OrderedListItemSpan.a(textView, spanned);
    }

    @Override // ru.noties.markwon.AbstractMarkwonPlugin, ru.noties.markwon.MarkwonPlugin
    public void configureSpansFactory(MarkwonSpansFactory.Builder builder) {
        CodeBlockSpanFactory codeBlockSpanFactory = new CodeBlockSpanFactory();
        builder.a(StrongEmphasis.class, new StrongEmphasisSpanFactory()).a(Emphasis.class, new EmphasisSpanFactory()).a(BlockQuote.class, new BlockQuoteSpanFactory()).a(Code.class, new CodeSpanFactory()).a(FencedCodeBlock.class, codeBlockSpanFactory).a(IndentedCodeBlock.class, codeBlockSpanFactory).a(ListItem.class, new ListItemSpanFactory()).a(Heading.class, new HeadingSpanFactory()).a(Link.class, new LinkSpanFactory()).a(ThematicBreak.class, new ThematicBreakSpanFactory());
    }

    @Override // ru.noties.markwon.AbstractMarkwonPlugin, ru.noties.markwon.MarkwonPlugin
    public void configureVisitor(MarkwonVisitor.Builder builder) {
        t(builder);
        s(builder);
        g(builder);
        c(builder);
        e(builder);
        h(builder);
        k(builder);
        d(builder);
        p(builder);
        n(builder);
        u(builder);
        j(builder);
        r(builder);
        i(builder);
        q(builder);
        m(builder);
    }

    @Override // ru.noties.markwon.AbstractMarkwonPlugin, ru.noties.markwon.MarkwonPlugin
    public Priority priority() {
        return Priority.d();
    }
}
