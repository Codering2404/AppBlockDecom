package androidx.compose.ui.text.android;

import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class TextLayout_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TextAndroidCanvas f29025a = new TextAndroidCanvas();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f29026b = a(0, 0);

    public static final long a(int i3, int i4) {
        return VerticalPaddings.a((((long) i4) & 4294967295L) | (((long) i3) << 32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Paint.FontMetricsInt h(TextLayout textLayout, TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, LineHeightStyleSpan[] lineHeightStyleSpanArr) {
        int iM = textLayout.m() - 1;
        if (textLayout.i().getLineStart(iM) != textLayout.i().getLineEnd(iM) || lineHeightStyleSpanArr == null || lineHeightStyleSpanArr.length == 0) {
            return null;
        }
        SpannableString spannableString = new SpannableString("\u200b");
        LineHeightStyleSpan lineHeightStyleSpan = (LineHeightStyleSpan) ArraysKt.first(lineHeightStyleSpanArr);
        spannableString.setSpan(lineHeightStyleSpan.b(0, spannableString.length(), (iM == 0 || !lineHeightStyleSpan.e()) ? lineHeightStyleSpan.e() : false), 0, spannableString.length(), 33);
        StaticLayout staticLayoutB = StaticLayoutFactory.b(StaticLayoutFactory.f28971a, spannableString, textPaint, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0, spannableString.length(), textDirectionHeuristic, null, 0, null, 0, 0.0f, 0.0f, 0, textLayout.h(), textLayout.e(), 0, 0, 0, 0, null, null, 2072512, null);
        Paint.FontMetricsInt fontMetricsInt = new Paint.FontMetricsInt();
        fontMetricsInt.ascent = staticLayoutB.getLineAscent(0);
        fontMetricsInt.descent = staticLayoutB.getLineDescent(0);
        fontMetricsInt.top = staticLayoutB.getLineTop(0);
        fontMetricsInt.bottom = staticLayoutB.getLineBottom(0);
        return fontMetricsInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long i(LineHeightStyleSpan[] lineHeightStyleSpanArr) {
        int iMax = 0;
        int iMax2 = 0;
        for (LineHeightStyleSpan lineHeightStyleSpan : lineHeightStyleSpanArr) {
            if (lineHeightStyleSpan.c() < 0) {
                iMax = Math.max(iMax, Math.abs(lineHeightStyleSpan.c()));
            }
            if (lineHeightStyleSpan.d() < 0) {
                iMax2 = Math.max(iMax, Math.abs(lineHeightStyleSpan.d()));
            }
        }
        return (iMax == 0 && iMax2 == 0) ? f29026b : a(iMax, iMax2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LineHeightStyleSpan[] j(TextLayout textLayout) {
        if (!(textLayout.G() instanceof Spanned)) {
            return null;
        }
        CharSequence charSequenceG = textLayout.G();
        Intrinsics.checkNotNull(charSequenceG, "null cannot be cast to non-null type android.text.Spanned");
        if (!SpannedExtensions_androidKt.a((Spanned) charSequenceG, LineHeightStyleSpan.class) && textLayout.G().length() > 0) {
            return null;
        }
        CharSequence charSequenceG2 = textLayout.G();
        Intrinsics.checkNotNull(charSequenceG2, "null cannot be cast to non-null type android.text.Spanned");
        return (LineHeightStyleSpan[]) ((Spanned) charSequenceG2).getSpans(0, textLayout.G().length(), LineHeightStyleSpan.class);
    }

    public static final TextDirectionHeuristic k(int i3) {
        return i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? TextDirectionHeuristics.FIRSTSTRONG_LTR : TextDirectionHeuristics.LOCALE : TextDirectionHeuristics.ANYRTL_LTR : TextDirectionHeuristics.FIRSTSTRONG_RTL : TextDirectionHeuristics.FIRSTSTRONG_LTR : TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long l(TextLayout textLayout) {
        if (textLayout.h() || textLayout.J()) {
            return f29026b;
        }
        TextPaint paint = textLayout.i().getPaint();
        CharSequence text = textLayout.i().getText();
        Rect rectC = PaintExtensions_androidKt.c(paint, text, textLayout.i().getLineStart(0), textLayout.i().getLineEnd(0));
        int lineAscent = textLayout.i().getLineAscent(0);
        int i3 = rectC.top;
        int topPadding = i3 < lineAscent ? lineAscent - i3 : textLayout.i().getTopPadding();
        if (textLayout.m() != 1) {
            int iM = textLayout.m() - 1;
            rectC = PaintExtensions_androidKt.c(paint, text, textLayout.i().getLineStart(iM), textLayout.i().getLineEnd(iM));
        }
        int lineDescent = textLayout.i().getLineDescent(textLayout.m() - 1);
        int i4 = rectC.bottom;
        int bottomPadding = i4 > lineDescent ? i4 - lineDescent : textLayout.i().getBottomPadding();
        return (topPadding == 0 && bottomPadding == 0) ? f29026b : a(topPadding, bottomPadding);
    }

    public static final boolean m(Layout layout, int i3) {
        return layout.getEllipsisCount(i3) > 0;
    }
}
