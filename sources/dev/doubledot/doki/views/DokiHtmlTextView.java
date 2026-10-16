package dev.doubledot.doki.views;

import android.content.Context;
import android.content.res.Resources;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import ru.noties.markwon.AbstractMarkwonPlugin;
import ru.noties.markwon.Markwon;
import ru.noties.markwon.MarkwonConfiguration;
import ru.noties.markwon.RenderProps;
import ru.noties.markwon.core.MarkwonTheme;
import ru.noties.markwon.core.spans.CodeBlockSpan;
import ru.noties.markwon.html.HtmlPlugin;
import ru.noties.markwon.html.HtmlTag;
import ru.noties.markwon.html.MarkwonHtmlRenderer;
import ru.noties.markwon.html.tag.SimpleTagHandler;
import ru.noties.markwon.image.ImagesPlugin;
import ru.noties.markwon.image.okhttp.OkHttpImagesPlugin;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DokiHtmlTextView extends AppCompatTextView {
    private String htmlText;
    private int linkHighlightColor;
    private final Markwon markwon;

    public DokiHtmlTextView(Context context) {
        this(context, null, 0, 6, null);
    }

    public final String getHtmlText() {
        return this.htmlText;
    }

    public final int getLinkHighlightColor() {
        return this.linkHighlightColor;
    }

    public final void setHtmlText(String str) {
        if (str != null) {
            this.markwon.b(this, str);
        }
        this.htmlText = str;
    }

    public final void setLinkHighlightColor(int i3) {
        this.linkHighlightColor = i3;
        setHtmlText(this.htmlText);
    }

    public DokiHtmlTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ DokiHtmlTextView(Context context, AttributeSet attributeSet, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DokiHtmlTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Markwon markwonBuild = Markwon.a(context).a(ImagesPlugin.a(context)).a(OkHttpImagesPlugin.a()).a(HtmlPlugin.b()).a(new AbstractMarkwonPlugin() { // from class: dev.doubledot.doki.views.DokiHtmlTextView$markwon$1
            @Override // ru.noties.markwon.AbstractMarkwonPlugin, ru.noties.markwon.MarkwonPlugin
            public void configureHtmlRenderer(MarkwonHtmlRenderer.Builder builder) {
                Intrinsics.checkParameterIsNotNull(builder, "builder");
                builder.b("code", new SimpleTagHandler() { // from class: dev.doubledot.doki.views.DokiHtmlTextView$markwon$1$configureHtmlRenderer$1
                    @Override // ru.noties.markwon.html.tag.SimpleTagHandler
                    public Object getSpans(MarkwonConfiguration configuration, RenderProps renderProps, HtmlTag tag) {
                        Intrinsics.checkParameterIsNotNull(configuration, "configuration");
                        Intrinsics.checkParameterIsNotNull(renderProps, "renderProps");
                        Intrinsics.checkParameterIsNotNull(tag, "tag");
                        return new CodeBlockSpan(configuration.h());
                    }
                });
            }

            @Override // ru.noties.markwon.AbstractMarkwonPlugin, ru.noties.markwon.MarkwonPlugin
            public void configureTheme(MarkwonTheme.Builder builder) {
                Intrinsics.checkParameterIsNotNull(builder, "builder");
                MarkwonTheme.Builder builderE = builder.D(0).E(this.this$0.getLinkHighlightColor());
                Resources system = Resources.getSystem();
                Intrinsics.checkExpressionValueIsNotNull(system, "Resources.getSystem()");
                MarkwonTheme.Builder builderW = builderE.w(MathKt.d(system.getDisplayMetrics().density * 24.0f));
                Resources system2 = Resources.getSystem();
                Intrinsics.checkExpressionValueIsNotNull(system2, "Resources.getSystem()");
                builderW.x(MathKt.d(system2.getDisplayMetrics().density * 4.0f)).A(16777215).B(16777215);
            }
        }).build();
        Intrinsics.checkExpressionValueIsNotNull(markwonBuild, "Markwon.builder(context)…      })\n        .build()");
        this.markwon = markwonBuild;
        setMovementMethod(LinkMovementMethod.getInstance());
    }
}
