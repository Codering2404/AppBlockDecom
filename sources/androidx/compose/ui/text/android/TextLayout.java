package androidx.compose.ui.text.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Trace;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.compose.ui.text.android.selection.WordIterator;
import androidx.compose.ui.text.android.style.BaselineShiftSpan;
import androidx.compose.ui.text.android.style.IndentationFixSpan_androidKt;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class TextLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextPaint f29006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextUtils.TruncateAt f29007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f29008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f29009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LayoutIntrinsics f29010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f29011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private WordIterator f29012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Layout f29013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f29014i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f29015j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f29016k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final float f29017l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final float f29018m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f29019n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Paint.FontMetricsInt f29020o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f29021p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final LineHeightStyleSpan[] f29022q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Rect f29023r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private LayoutHelper f29024s;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [int] */
    /* JADX WARN: Type inference failed for: r14v5 */
    public TextLayout(CharSequence charSequence, float f3, TextPaint textPaint, int i3, TextUtils.TruncateAt truncateAt, int i4, float f4, float f5, boolean z2, boolean z3, int i5, int i6, int i7, int i8, int i9, int i10, int[] iArr, int[] iArr2, LayoutIntrinsics layoutIntrinsics) {
        boolean z4;
        int i11;
        boolean z5;
        TextDirectionHeuristic textDirectionHeuristic;
        TextPaint textPaint2;
        Layout layoutA;
        this.f29006a = textPaint;
        this.f29007b = truncateAt;
        this.f29008c = z2;
        this.f29009d = z3;
        this.f29010e = layoutIntrinsics;
        this.f29023r = new Rect();
        int length = charSequence.length();
        TextDirectionHeuristic textDirectionHeuristicK = TextLayout_androidKt.k(i4);
        Layout.Alignment alignmentA = TextAlignmentAdapter.f29002a.a(i3);
        boolean z6 = (charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(-1, length, BaselineShiftSpan.class) < length;
        Trace.beginSection("TextLayout:initLayout");
        try {
            BoringLayout.Metrics metricsE = layoutIntrinsics.e();
            double d3 = f3;
            int iCeil = (int) Math.ceil(d3);
            if (metricsE == null || layoutIntrinsics.i() > f3 || z6) {
                z4 = true;
                this.f29019n = false;
                i11 = i5;
                z5 = false;
                textDirectionHeuristic = textDirectionHeuristicK;
                textPaint2 = textPaint;
                layoutA = StaticLayoutFactory.f28971a.a(charSequence, textPaint2, iCeil, 0, charSequence.length(), textDirectionHeuristic, alignmentA, i11, truncateAt, (int) Math.ceil(d3), f4, f5, i10, z2, z3, i6, i7, i8, i9, iArr, iArr2);
            } else {
                z4 = true;
                this.f29019n = true;
                layoutA = BoringLayoutFactory.f28933a.a(charSequence, textPaint, iCeil, metricsE, alignmentA, z2, z3, truncateAt, iCeil);
                textPaint2 = textPaint;
                i11 = i5;
                textDirectionHeuristic = textDirectionHeuristicK;
                z5 = false;
            }
            this.f29013h = layoutA;
            Trace.endSection();
            int iMin = Math.min(layoutA.getLineCount(), i11);
            this.f29014i = iMin;
            int i12 = iMin - 1;
            this.f29011f = (iMin >= i11 && (layoutA.getEllipsisCount(i12) > 0 || layoutA.getLineEnd(i12) != charSequence.length())) ? z4 : z5;
            long jL = TextLayout_androidKt.l(this);
            LineHeightStyleSpan[] lineHeightStyleSpanArrJ = TextLayout_androidKt.j(this);
            this.f29022q = lineHeightStyleSpanArrJ;
            long jI = lineHeightStyleSpanArrJ != null ? TextLayout_androidKt.i(lineHeightStyleSpanArrJ) : TextLayout_androidKt.f29026b;
            this.f29015j = Math.max(VerticalPaddings.d(jL), VerticalPaddings.d(jI));
            this.f29016k = Math.max(VerticalPaddings.c(jL), VerticalPaddings.c(jI));
            Paint.FontMetricsInt fontMetricsIntH = TextLayout_androidKt.h(this, textPaint2, textDirectionHeuristic, lineHeightStyleSpanArrJ);
            this.f29021p = fontMetricsIntH != null ? fontMetricsIntH.bottom - ((int) s(i12)) : z5;
            this.f29020o = fontMetricsIntH;
            this.f29017l = IndentationFixSpan_androidKt.b(layoutA, i12, null, 2, null);
            this.f29018m = IndentationFixSpan_androidKt.d(layoutA, i12, null, 2, null);
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public static /* synthetic */ float B(TextLayout textLayout, int i3, boolean z2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z2 = false;
        }
        return textLayout.A(i3, z2);
    }

    public static /* synthetic */ float E(TextLayout textLayout, int i3, boolean z2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z2 = false;
        }
        return textLayout.D(i3, z2);
    }

    private final float g(int i3) {
        if (i3 == this.f29014i - 1) {
            return this.f29017l + this.f29018m;
        }
        return 0.0f;
    }

    private final LayoutHelper j() {
        LayoutHelper layoutHelper = this.f29024s;
        if (layoutHelper != null) {
            Intrinsics.checkNotNull(layoutHelper);
            return layoutHelper;
        }
        LayoutHelper layoutHelper2 = new LayoutHelper(this.f29013h);
        this.f29024s = layoutHelper2;
        return layoutHelper2;
    }

    public final float A(int i3, boolean z2) {
        return j().c(i3, true, z2) + g(q(i3));
    }

    public final int[] C(RectF rectF, int i3, Function2 function2) {
        return Build.VERSION.SDK_INT >= 34 ? AndroidLayoutApi34.f28932a.c(this, rectF, i3, function2) : TextLayoutGetRangeForRectExtensions_androidKt.d(this, this.f29013h, j(), rectF, i3, function2);
    }

    public final float D(int i3, boolean z2) {
        return j().c(i3, false, z2) + g(q(i3));
    }

    public final void F(int i3, int i4, Path path) {
        this.f29013h.getSelectionPath(i3, i4, path);
        if (this.f29015j == 0 || path.isEmpty()) {
            return;
        }
        path.offset(0.0f, this.f29015j);
    }

    public final CharSequence G() {
        return this.f29013h.getText();
    }

    public final TextPaint H() {
        return this.f29006a;
    }

    public final WordIterator I() {
        WordIterator wordIterator = this.f29012g;
        if (wordIterator != null) {
            return wordIterator;
        }
        WordIterator wordIterator2 = new WordIterator(this.f29013h.getText(), 0, this.f29013h.getText().length(), this.f29006a.getTextLocale());
        this.f29012g = wordIterator2;
        return wordIterator2;
    }

    public final boolean J() {
        if (this.f29019n) {
            BoringLayoutFactory boringLayoutFactory = BoringLayoutFactory.f28933a;
            Layout layout = this.f29013h;
            Intrinsics.checkNotNull(layout, "null cannot be cast to non-null type android.text.BoringLayout");
            return boringLayoutFactory.b((BoringLayout) layout);
        }
        StaticLayoutFactory staticLayoutFactory = StaticLayoutFactory.f28971a;
        Layout layout2 = this.f29013h;
        Intrinsics.checkNotNull(layout2, "null cannot be cast to non-null type android.text.StaticLayout");
        return staticLayoutFactory.c((StaticLayout) layout2, this.f29009d);
    }

    public final boolean K(int i3) {
        return TextLayout_androidKt.m(this.f29013h, i3);
    }

    public final boolean L(int i3) {
        return this.f29013h.isRtlCharAt(i3);
    }

    public final void M(Canvas canvas) {
        if (canvas.getClipBounds(this.f29023r)) {
            int i3 = this.f29015j;
            if (i3 != 0) {
                canvas.translate(0.0f, i3);
            }
            TextAndroidCanvas textAndroidCanvas = TextLayout_androidKt.f29025a;
            textAndroidCanvas.a(canvas);
            this.f29013h.draw(textAndroidCanvas);
            int i4 = this.f29015j;
            if (i4 != 0) {
                canvas.translate(0.0f, (-1) * i4);
            }
        }
    }

    public final void a(int i3, int i4, float[] fArr, int i5) {
        float fD;
        float fE;
        int length = G().length();
        if (!(i3 >= 0)) {
            InlineClassHelperKt.a("startOffset must be > 0");
        }
        if (!(i3 < length)) {
            InlineClassHelperKt.a("startOffset must be less than text length");
        }
        if (!(i4 > i3)) {
            InlineClassHelperKt.a("endOffset must be greater than startOffset");
        }
        if (!(i4 <= length)) {
            InlineClassHelperKt.a("endOffset must be smaller or equal to text length");
        }
        if (!(fArr.length - i5 >= (i4 - i3) * 4)) {
            InlineClassHelperKt.a("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 4");
        }
        int iQ = q(i3);
        int iQ2 = q(i4 - 1);
        HorizontalPositionCache horizontalPositionCache = new HorizontalPositionCache(this);
        if (iQ > iQ2) {
            return;
        }
        int i6 = iQ;
        int i7 = i5;
        while (true) {
            int iV = v(i6);
            int iP = p(i6);
            int iMin = Math.min(i4, iP);
            float fW = w(i6);
            float fL = l(i6);
            boolean z2 = z(i6) == 1;
            for (int iMax = Math.max(i3, iV); iMax < iMin; iMax++) {
                boolean zL = L(iMax);
                if (z2 && !zL) {
                    fD = horizontalPositionCache.b(iMax);
                    fE = horizontalPositionCache.c(iMax + 1);
                } else if (z2 && zL) {
                    fE = horizontalPositionCache.d(iMax);
                    fD = horizontalPositionCache.e(iMax + 1);
                } else if (z2 || !zL) {
                    fD = horizontalPositionCache.d(iMax);
                    fE = horizontalPositionCache.e(iMax + 1);
                } else {
                    fE = horizontalPositionCache.b(iMax);
                    fD = horizontalPositionCache.c(iMax + 1);
                }
                fArr[i7] = fD;
                fArr[i7 + 1] = fW;
                fArr[i7 + 2] = fE;
                fArr[i7 + 3] = fL;
                i7 += 4;
            }
            if (i6 == iQ2) {
                return;
            } else {
                i6++;
            }
        }
    }

    public final void b(int i3, float[] fArr) {
        float fD;
        float fE;
        int iV = v(i3);
        int iP = p(i3);
        int i4 = 0;
        if (!(fArr.length >= (iP - iV) * 2)) {
            InlineClassHelperKt.a("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 2");
        }
        HorizontalPositionCache horizontalPositionCache = new HorizontalPositionCache(this);
        boolean z2 = z(i3) == 1;
        while (iV < iP) {
            boolean zL = L(iV);
            if (z2 && !zL) {
                fD = horizontalPositionCache.b(iV);
                fE = horizontalPositionCache.c(iV + 1);
            } else if (z2 && zL) {
                fE = horizontalPositionCache.d(iV);
                fD = horizontalPositionCache.e(iV + 1);
            } else if (zL) {
                fE = horizontalPositionCache.b(iV);
                fD = horizontalPositionCache.c(iV + 1);
            } else {
                fD = horizontalPositionCache.d(iV);
                fE = horizontalPositionCache.e(iV + 1);
            }
            fArr[i4] = fD;
            fArr[i4 + 1] = fE;
            i4 += 2;
            iV++;
        }
    }

    public final RectF c(int i3) {
        float fD;
        float fD2;
        float fA;
        float fA2;
        int iQ = q(i3);
        float fW = w(iQ);
        float fL = l(iQ);
        boolean z2 = z(iQ) == 1;
        boolean zIsRtlCharAt = this.f29013h.isRtlCharAt(i3);
        if (!z2 || zIsRtlCharAt) {
            if (z2 && zIsRtlCharAt) {
                fA = D(i3, false);
                fA2 = D(i3 + 1, true);
            } else if (zIsRtlCharAt) {
                fA = A(i3, false);
                fA2 = A(i3 + 1, true);
            } else {
                fD = D(i3, false);
                fD2 = D(i3 + 1, true);
            }
            float f3 = fA;
            fD = fA2;
            fD2 = f3;
        } else {
            fD = A(i3, false);
            fD2 = A(i3 + 1, true);
        }
        return new RectF(fD, fW, fD2, fL);
    }

    public final boolean d() {
        return this.f29011f;
    }

    public final boolean e() {
        return this.f29009d;
    }

    public final int f() {
        return (this.f29011f ? this.f29013h.getLineBottom(this.f29014i - 1) : this.f29013h.getHeight()) + this.f29015j + this.f29016k + this.f29021p;
    }

    public final boolean h() {
        return this.f29008c;
    }

    public final Layout i() {
        return this.f29013h;
    }

    public final float k(int i3) {
        return this.f29015j + ((i3 != this.f29014i + (-1) || this.f29020o == null) ? this.f29013h.getLineBaseline(i3) : w(i3) - this.f29020o.ascent);
    }

    public final float l(int i3) {
        if (i3 != this.f29014i - 1 || this.f29020o == null) {
            return this.f29015j + this.f29013h.getLineBottom(i3) + (i3 == this.f29014i + (-1) ? this.f29016k : 0);
        }
        return this.f29013h.getLineBottom(i3 - 1) + this.f29020o.bottom;
    }

    public final int m() {
        return this.f29014i;
    }

    public final int n(int i3) {
        return this.f29013h.getEllipsisCount(i3);
    }

    public final int o(int i3) {
        return this.f29013h.getEllipsisStart(i3);
    }

    public final int p(int i3) {
        return (TextLayout_androidKt.m(this.f29013h, i3) && this.f29007b == TextUtils.TruncateAt.END) ? this.f29013h.getText().length() : this.f29013h.getLineEnd(i3);
    }

    public final int q(int i3) {
        return this.f29013h.getLineForOffset(i3);
    }

    public final int r(int i3) {
        return this.f29013h.getLineForVertical(i3 - this.f29015j);
    }

    public final float s(int i3) {
        return l(i3) - w(i3);
    }

    public final float t(int i3) {
        return this.f29013h.getLineLeft(i3) + (i3 == this.f29014i + (-1) ? this.f29017l : 0.0f);
    }

    public final float u(int i3) {
        return this.f29013h.getLineRight(i3) + (i3 == this.f29014i + (-1) ? this.f29018m : 0.0f);
    }

    public final int v(int i3) {
        return this.f29013h.getLineStart(i3);
    }

    public final float w(int i3) {
        return this.f29013h.getLineTop(i3) + (i3 == 0 ? 0 : this.f29015j);
    }

    public final int x(int i3) {
        return (TextLayout_androidKt.m(this.f29013h, i3) && this.f29007b == TextUtils.TruncateAt.END) ? this.f29013h.getLineStart(i3) + this.f29013h.getEllipsisStart(i3) : j().e(i3);
    }

    public final int y(int i3, float f3) {
        return this.f29013h.getOffsetForHorizontal(i3, f3 + ((-1) * g(i3)));
    }

    public final int z(int i3) {
        return this.f29013h.getParagraphDirection(i3);
    }

    public /* synthetic */ TextLayout(CharSequence charSequence, float f3, TextPaint textPaint, int i3, TextUtils.TruncateAt truncateAt, int i4, float f4, float f5, boolean z2, boolean z3, int i5, int i6, int i7, int i8, int i9, int i10, int[] iArr, int[] iArr2, LayoutIntrinsics layoutIntrinsics, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        CharSequence charSequence2;
        TextPaint textPaint2;
        LayoutIntrinsics layoutIntrinsics2;
        int i12 = (i11 & 8) != 0 ? 0 : i3;
        TextUtils.TruncateAt truncateAt2 = (i11 & 16) != 0 ? null : truncateAt;
        int i13 = (i11 & 32) != 0 ? 2 : i4;
        float f6 = (i11 & 64) != 0 ? 1.0f : f4;
        float f7 = (i11 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 0.0f : f5;
        boolean z4 = (i11 & Function.MAX_NARGS) != 0 ? false : z2;
        boolean z5 = (i11 & 512) != 0 ? true : z3;
        int i14 = (i11 & 1024) != 0 ? Integer.MAX_VALUE : i5;
        int i15 = (i11 & 2048) != 0 ? 0 : i6;
        int i16 = (i11 & 4096) != 0 ? 0 : i7;
        int i17 = (i11 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? 0 : i8;
        int i18 = (i11 & 16384) != 0 ? 0 : i9;
        int i19 = (32768 & i11) != 0 ? 0 : i10;
        int[] iArr3 = (65536 & i11) != 0 ? null : iArr;
        int[] iArr4 = (131072 & i11) != 0 ? null : iArr2;
        if ((i11 & 262144) != 0) {
            charSequence2 = charSequence;
            textPaint2 = textPaint;
            layoutIntrinsics2 = new LayoutIntrinsics(charSequence2, textPaint2, i13);
        } else {
            charSequence2 = charSequence;
            textPaint2 = textPaint;
            layoutIntrinsics2 = layoutIntrinsics;
        }
        this(charSequence2, f3, textPaint2, i12, truncateAt2, i13, f6, f7, z4, z5, i14, i15, i16, i17, i18, i19, iArr3, iArr4, layoutIntrinsics2);
    }
}
