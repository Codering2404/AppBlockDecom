package ru.noties.markwon;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
class MarkwonImpl extends Markwon {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView.BufferType f147079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Parser f147080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MarkwonVisitor f147081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f147082d;

    MarkwonImpl(TextView.BufferType bufferType, Parser parser, MarkwonVisitor markwonVisitor, List list) {
        this.f147079a = bufferType;
        this.f147080b = parser;
        this.f147081c = markwonVisitor;
        this.f147082d = list;
    }

    @Override // ru.noties.markwon.Markwon
    public void b(TextView textView, String str) {
        e(textView, f(str));
    }

    public Node c(String str) {
        Iterator it = this.f147082d.iterator();
        while (it.hasNext()) {
            str = ((MarkwonPlugin) it.next()).processMarkdown(str);
        }
        return this.f147080b.c(str);
    }

    public Spanned d(Node node) {
        Iterator it = this.f147082d.iterator();
        while (it.hasNext()) {
            ((MarkwonPlugin) it.next()).beforeRender(node);
        }
        node.a(this.f147081c);
        Iterator it2 = this.f147082d.iterator();
        while (it2.hasNext()) {
            ((MarkwonPlugin) it2.next()).afterRender(node, this.f147081c);
        }
        SpannableStringBuilder spannableStringBuilderK = this.f147081c.builder().k();
        this.f147081c.clear();
        return spannableStringBuilderK;
    }

    public void e(TextView textView, Spanned spanned) {
        Iterator it = this.f147082d.iterator();
        while (it.hasNext()) {
            ((MarkwonPlugin) it.next()).beforeSetText(textView, spanned);
        }
        textView.setText(spanned, this.f147079a);
        Iterator it2 = this.f147082d.iterator();
        while (it2.hasNext()) {
            ((MarkwonPlugin) it2.next()).afterSetText(textView);
        }
    }

    public Spanned f(String str) {
        return d(c(str));
    }
}
