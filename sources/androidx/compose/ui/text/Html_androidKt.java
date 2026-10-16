package androidx.compose.ui.text;

import android.graphics.Typeface;
import android.text.Editable;
import android.text.Html;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.font.AndroidTypeface_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.core.text.HtmlCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.xml.sax.XMLReader;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class Html_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Html_androidKt$TagHandler$1 f28698a = new Html.TagHandler() { // from class: androidx.compose.ui.text.Html_androidKt$TagHandler$1
        @Override // android.text.Html.TagHandler
        public void handleTag(boolean z2, String str, Editable editable, XMLReader xMLReader) {
            if (xMLReader == null || editable == null || !z2 || !Intrinsics.areEqual(str, "ContentHandlerReplacementTag")) {
                return;
            }
            xMLReader.setContentHandler(new AnnotationContentHandler(xMLReader.getContentHandler(), editable));
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f28699a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f28699a = iArr;
        }
    }

    private static final void a(AnnotatedString.Builder builder, Object obj, int i3, int i4, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener) {
        String url;
        if (obj instanceof AbsoluteSizeSpan) {
            return;
        }
        if (obj instanceof AlignmentSpan) {
            builder.e(g((AlignmentSpan) obj), i3, i4);
            return;
        }
        if (obj instanceof AnnotationSpan) {
            AnnotationSpan annotationSpan = (AnnotationSpan) obj;
            builder.d(annotationSpan.a(), annotationSpan.b(), i3, i4);
            return;
        }
        if (obj instanceof BackgroundColorSpan) {
            builder.f(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, ColorKt.b(((BackgroundColorSpan) obj).getBackgroundColor()), (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 63487, (DefaultConstructorMarker) null), i3, i4);
            return;
        }
        if (obj instanceof BulletSpanWithLevel) {
            long jB = BulletKt.b();
            BulletSpanWithLevel bulletSpanWithLevel = (BulletSpanWithLevel) obj;
            int iB = bulletSpanWithLevel.b();
            TextUnitKt.b(jB);
            builder.a(bulletSpanWithLevel.a(), TextUnitKt.l(TextUnit.f(jB), TextUnit.h(jB) * iB), i3, i4);
            return;
        }
        if (obj instanceof ForegroundColorSpan) {
            builder.f(new SpanStyle(ColorKt.b(((ForegroundColorSpan) obj).getForegroundColor()), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null), i3, i4);
            return;
        }
        if (obj instanceof RelativeSizeSpan) {
            builder.f(new SpanStyle(0L, TextUnitKt.e(((RelativeSizeSpan) obj).getSizeChange()), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65533, (DefaultConstructorMarker) null), i3, i4);
            return;
        }
        if (obj instanceof StrikethroughSpan) {
            builder.f(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.f29625b.b(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61439, (DefaultConstructorMarker) null), i3, i4);
            return;
        }
        if (obj instanceof StyleSpan) {
            SpanStyle spanStyleH = h((StyleSpan) obj);
            if (spanStyleH != null) {
                builder.f(spanStyleH, i3, i4);
                return;
            }
            return;
        }
        if (obj instanceof SubscriptSpan) {
            builder.f(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, BaselineShift.d(BaselineShift.f29554b.b()), (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65279, (DefaultConstructorMarker) null), i3, i4);
            return;
        }
        if (obj instanceof SuperscriptSpan) {
            builder.f(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, BaselineShift.d(BaselineShift.f29554b.c()), (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65279, (DefaultConstructorMarker) null), i3, i4);
            return;
        }
        if (obj instanceof TypefaceSpan) {
            builder.f(i((TypefaceSpan) obj), i3, i4);
            return;
        }
        if (obj instanceof UnderlineSpan) {
            builder.f(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.f29625b.d(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61439, (DefaultConstructorMarker) null), i3, i4);
        } else {
            if (!(obj instanceof URLSpan) || (url = ((URLSpan) obj).getURL()) == null) {
                return;
            }
            builder.c(new LinkAnnotation.Url(url, textLinkStyles, linkInteractionListener), i3, i4);
        }
    }

    private static final void b(AnnotatedString.Builder builder, Spanned spanned, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener) {
        for (Object obj : spanned.getSpans(0, builder.n(), Object.class)) {
            long jB = TextRangeKt.b(spanned.getSpanStart(obj), spanned.getSpanEnd(obj));
            a(builder, obj, TextRange.n(jB), TextRange.i(jB), textLinkStyles, linkInteractionListener);
        }
    }

    public static final AnnotatedString c(AnnotatedString.Companion companion, String str, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener) {
        return f(HtmlCompat.b("<ContentHandlerReplacementTag />" + str, 63, null, f28698a), textLinkStyles, linkInteractionListener);
    }

    public static /* synthetic */ AnnotatedString d(AnnotatedString.Companion companion, String str, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            textLinkStyles = null;
        }
        if ((i3 & 4) != 0) {
            linkInteractionListener = null;
        }
        return c(companion, str, textLinkStyles, linkInteractionListener);
    }

    private static final FontFamily e(String str) {
        if (str != null && str.length() != 0) {
            Typeface typefaceCreate = Typeface.create(str, 0);
            Typeface typeface = Typeface.DEFAULT;
            if (Intrinsics.areEqual(typefaceCreate, typeface) || Intrinsics.areEqual(typefaceCreate, Typeface.create(typeface, 0))) {
                typefaceCreate = null;
            }
            if (typefaceCreate != null) {
                return AndroidTypeface_androidKt.a(typefaceCreate);
            }
        }
        return null;
    }

    public static final AnnotatedString f(Spanned spanned, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener) {
        AnnotatedString.Builder builderAppend = new AnnotatedString.Builder(spanned.length()).append(spanned);
        b(builderAppend, spanned, textLinkStyles, linkInteractionListener);
        return builderAppend.t();
    }

    private static final ParagraphStyle g(AlignmentSpan alignmentSpan) {
        Layout.Alignment alignment = alignmentSpan.getAlignment();
        int i3 = alignment == null ? -1 : WhenMappings.f28699a[alignment.ordinal()];
        return new ParagraphStyle(i3 != 1 ? i3 != 2 ? i3 != 3 ? TextAlign.f29616b.g() : TextAlign.f29616b.b() : TextAlign.f29616b.a() : TextAlign.f29616b.f(), 0, 0L, null, null, null, 0, 0, null, 510, null);
    }

    private static final SpanStyle h(StyleSpan styleSpan) {
        int style = styleSpan.getStyle();
        if (style == 1) {
            return new SpanStyle(0L, 0L, FontWeight.f29233b.b(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65531, (DefaultConstructorMarker) null);
        }
        if (style == 2) {
            return new SpanStyle(0L, 0L, (FontWeight) null, FontStyle.c(FontStyle.f29211b.a()), (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65527, (DefaultConstructorMarker) null);
        }
        if (style != 3) {
            return null;
        }
        return new SpanStyle(0L, 0L, FontWeight.f29233b.b(), FontStyle.c(FontStyle.f29211b.a()), (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65523, (DefaultConstructorMarker) null);
    }

    private static final SpanStyle i(TypefaceSpan typefaceSpan) {
        String family = typefaceSpan.getFamily();
        FontFamily.Companion companion = FontFamily.f29155b;
        return new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, Intrinsics.areEqual(family, companion.a().g()) ? companion.a() : Intrinsics.areEqual(family, companion.c().g()) ? companion.c() : Intrinsics.areEqual(family, companion.d().g()) ? companion.d() : Intrinsics.areEqual(family, companion.e().g()) ? companion.e() : e(typefaceSpan.getFamily()), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65503, (DefaultConstructorMarker) null);
    }
}
