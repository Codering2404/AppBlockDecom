package ru.noties.markwon.image;

import android.content.Context;
import android.text.Spanned;
import android.widget.TextView;
import java.util.Arrays;
import org.commonmark.node.Image;
import org.commonmark.node.Link;
import ru.noties.markwon.AbstractMarkwonPlugin;
import ru.noties.markwon.MarkwonConfiguration;
import ru.noties.markwon.MarkwonSpansFactory;
import ru.noties.markwon.MarkwonVisitor;
import ru.noties.markwon.RenderProps;
import ru.noties.markwon.SpanFactory;
import ru.noties.markwon.image.AsyncDrawableLoader;
import ru.noties.markwon.image.data.DataUriSchemeHandler;
import ru.noties.markwon.image.file.FileSchemeHandler;
import ru.noties.markwon.image.network.NetworkSchemeHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class ImagesPlugin extends AbstractMarkwonPlugin {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f147378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f147379b;

    protected ImagesPlugin(Context context, boolean z2) {
        this.f147378a = context;
        this.f147379b = z2;
    }

    public static ImagesPlugin a(Context context) {
        return new ImagesPlugin(context, false);
    }

    @Override // ru.noties.markwon.AbstractMarkwonPlugin, ru.noties.markwon.MarkwonPlugin
    public void afterSetText(TextView textView) {
        AsyncDrawableScheduler.b(textView);
    }

    @Override // ru.noties.markwon.AbstractMarkwonPlugin, ru.noties.markwon.MarkwonPlugin
    public void beforeSetText(TextView textView, Spanned spanned) {
        AsyncDrawableScheduler.c(textView);
    }

    @Override // ru.noties.markwon.AbstractMarkwonPlugin, ru.noties.markwon.MarkwonPlugin
    public void configureImages(AsyncDrawableLoader.Builder builder) {
        builder.a("data", DataUriSchemeHandler.b()).a("file", this.f147379b ? FileSchemeHandler.c(this.f147378a.getAssets()) : FileSchemeHandler.b()).b(Arrays.asList("http", "https"), NetworkSchemeHandler.c()).d(ImageMediaDecoder.b(this.f147378a.getResources()));
    }

    @Override // ru.noties.markwon.AbstractMarkwonPlugin, ru.noties.markwon.MarkwonPlugin
    public void configureSpansFactory(MarkwonSpansFactory.Builder builder) {
        builder.a(Image.class, new ImageSpanFactory());
    }

    @Override // ru.noties.markwon.AbstractMarkwonPlugin, ru.noties.markwon.MarkwonPlugin
    public void configureVisitor(MarkwonVisitor.Builder builder) {
        builder.b(Image.class, new MarkwonVisitor.NodeVisitor<Image>() { // from class: ru.noties.markwon.image.ImagesPlugin.1
            @Override // ru.noties.markwon.MarkwonVisitor.NodeVisitor
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(MarkwonVisitor markwonVisitor, Image image) {
                SpanFactory spanFactoryA = markwonVisitor.x().f().a(Image.class);
                if (spanFactoryA == null) {
                    markwonVisitor.f(image);
                    return;
                }
                int length = markwonVisitor.length();
                markwonVisitor.f(image);
                if (length == markwonVisitor.length()) {
                    markwonVisitor.builder().append((char) 65532);
                }
                MarkwonConfiguration markwonConfigurationX = markwonVisitor.x();
                boolean z2 = image.g() instanceof Link;
                String strA = markwonConfigurationX.i().a(image.o());
                RenderProps renderPropsQ = markwonVisitor.q();
                ImageProps.f147371a.e(renderPropsQ, strA);
                ImageProps.f147372b.e(renderPropsQ, Boolean.valueOf(z2));
                ImageProps.f147373c.e(renderPropsQ, null);
                markwonVisitor.d(length, spanFactoryA.a(markwonConfigurationX, renderPropsQ));
            }
        });
    }
}
