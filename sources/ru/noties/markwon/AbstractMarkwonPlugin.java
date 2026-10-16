package ru.noties.markwon;

import android.text.Spanned;
import android.widget.TextView;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import ru.noties.markwon.MarkwonConfiguration;
import ru.noties.markwon.MarkwonSpansFactory;
import ru.noties.markwon.MarkwonVisitor;
import ru.noties.markwon.core.CorePlugin;
import ru.noties.markwon.core.MarkwonTheme;
import ru.noties.markwon.html.MarkwonHtmlRenderer;
import ru.noties.markwon.image.AsyncDrawableLoader;
import ru.noties.markwon.priority.Priority;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractMarkwonPlugin implements MarkwonPlugin {
    @Override // ru.noties.markwon.MarkwonPlugin
    public Priority priority() {
        return Priority.b(CorePlugin.class);
    }

    @Override // ru.noties.markwon.MarkwonPlugin
    public void afterSetText(TextView textView) {
    }

    @Override // ru.noties.markwon.MarkwonPlugin
    public void beforeRender(Node node) {
    }

    @Override // ru.noties.markwon.MarkwonPlugin
    public void configureConfiguration(MarkwonConfiguration.Builder builder) {
    }

    @Override // ru.noties.markwon.MarkwonPlugin
    public void configureHtmlRenderer(MarkwonHtmlRenderer.Builder builder) {
    }

    @Override // ru.noties.markwon.MarkwonPlugin
    public void configureImages(AsyncDrawableLoader.Builder builder) {
    }

    @Override // ru.noties.markwon.MarkwonPlugin
    public void configureParser(Parser.Builder builder) {
    }

    @Override // ru.noties.markwon.MarkwonPlugin
    public void configureSpansFactory(MarkwonSpansFactory.Builder builder) {
    }

    @Override // ru.noties.markwon.MarkwonPlugin
    public void configureTheme(MarkwonTheme.Builder builder) {
    }

    @Override // ru.noties.markwon.MarkwonPlugin
    public void configureVisitor(MarkwonVisitor.Builder builder) {
    }

    @Override // ru.noties.markwon.MarkwonPlugin
    public String processMarkdown(String str) {
        return str;
    }

    @Override // ru.noties.markwon.MarkwonPlugin
    public void afterRender(Node node, MarkwonVisitor markwonVisitor) {
    }

    @Override // ru.noties.markwon.MarkwonPlugin
    public void beforeSetText(TextView textView, Spanned spanned) {
    }
}
