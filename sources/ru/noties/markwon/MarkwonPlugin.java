package ru.noties.markwon;

import android.text.Spanned;
import android.widget.TextView;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import ru.noties.markwon.MarkwonConfiguration;
import ru.noties.markwon.MarkwonSpansFactory;
import ru.noties.markwon.MarkwonVisitor;
import ru.noties.markwon.core.MarkwonTheme;
import ru.noties.markwon.html.MarkwonHtmlRenderer;
import ru.noties.markwon.image.AsyncDrawableLoader;
import ru.noties.markwon.priority.Priority;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public interface MarkwonPlugin {
    void afterRender(Node node, MarkwonVisitor markwonVisitor);

    void afterSetText(TextView textView);

    void beforeRender(Node node);

    void beforeSetText(TextView textView, Spanned spanned);

    void configureConfiguration(MarkwonConfiguration.Builder builder);

    void configureHtmlRenderer(MarkwonHtmlRenderer.Builder builder);

    void configureImages(AsyncDrawableLoader.Builder builder);

    void configureParser(Parser.Builder builder);

    void configureSpansFactory(MarkwonSpansFactory.Builder builder);

    void configureTheme(MarkwonTheme.Builder builder);

    void configureVisitor(MarkwonVisitor.Builder builder);

    Priority priority();

    String processMarkdown(String str);
}
