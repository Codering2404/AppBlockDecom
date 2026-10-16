package androidx.compose.ui.text;

import android.graphics.RectF;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.selection.WordBoundary_androidKt;
import androidx.compose.ui.text.android.selection.WordIterator;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import com.sun.jna.Function;
import java.util.List;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class AndroidParagraph implements Paragraph {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AndroidParagraphIntrinsics f28623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f28624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f28625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f28626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextLayout f28627e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CharSequence f28628f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f28629g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f28630a;

        static {
            int[] iArr = new int[ResolvedTextDirection.values().length];
            try {
                iArr[ResolvedTextDirection.f29612a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ResolvedTextDirection.f29613b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f28630a = iArr;
        }
    }

    public /* synthetic */ AndroidParagraph(AndroidParagraphIntrinsics androidParagraphIntrinsics, int i3, int i4, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(androidParagraphIntrinsics, i3, i4, j3);
    }

    private final TextLayout F(int i3, int i4, TextUtils.TruncateAt truncateAt, int i5, int i6, int i7, int i8, int i9, CharSequence charSequence) {
        return new TextLayout(charSequence, getWidth(), J(), i3, truncateAt, this.f28623a.j(), 1.0f, 0.0f, AndroidParagraphHelper_androidKt.b(this.f28623a.i()), true, i5, i7, i8, i9, i6, i4, null, null, this.f28623a.h(), 196736, null);
    }

    static /* synthetic */ TextLayout G(AndroidParagraph androidParagraph, int i3, int i4, TextUtils.TruncateAt truncateAt, int i5, int i6, int i7, int i8, int i9, CharSequence charSequence, int i10, Object obj) {
        return androidParagraph.F(i3, i4, truncateAt, i5, i6, i7, i8, i9, (i10 & Function.MAX_NARGS) != 0 ? androidParagraph.f28628f : charSequence);
    }

    private final ShaderBrushSpan[] I(TextLayout textLayout) {
        if (!(textLayout.G() instanceof Spanned)) {
            return null;
        }
        CharSequence charSequenceG = textLayout.G();
        Intrinsics.checkNotNull(charSequenceG, "null cannot be cast to non-null type android.text.Spanned");
        if (!K((Spanned) charSequenceG, ShaderBrushSpan.class)) {
            return null;
        }
        CharSequence charSequenceG2 = textLayout.G();
        Intrinsics.checkNotNull(charSequenceG2, "null cannot be cast to non-null type android.text.Spanned");
        return (ShaderBrushSpan[]) ((Spanned) charSequenceG2).getSpans(0, textLayout.G().length(), ShaderBrushSpan.class);
    }

    private final boolean K(Spanned spanned, Class cls) {
        return spanned.nextSpanTransition(-1, spanned.length(), cls) != spanned.length();
    }

    private final void L(Canvas canvas) {
        android.graphics.Canvas canvasD = AndroidCanvas_androidKt.d(canvas);
        if (r()) {
            canvasD.save();
            canvasD.clipRect(0.0f, 0.0f, getWidth(), getHeight());
        }
        this.f28627e.M(canvasD);
        if (r()) {
            canvasD.restore();
        }
    }

    @Override // androidx.compose.ui.text.Paragraph
    public long A(Rect rect, int i3, final TextInclusionStrategy textInclusionStrategy) {
        int[] iArrC = this.f28627e.C(RectHelper_androidKt.c(rect), AndroidParagraph_androidKt.r(i3), new Function2<RectF, RectF, Boolean>() { // from class: androidx.compose.ui.text.AndroidParagraph$getRangeForRect$range$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(RectF rectF, RectF rectF2) {
                return Boolean.valueOf(textInclusionStrategy.a(RectHelper_androidKt.f(rectF), RectHelper_androidKt.f(rectF2)));
            }
        });
        return iArrC == null ? TextRange.f28921b.a() : TextRangeKt.b(iArrC[0], iArrC[1]);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public ResolvedTextDirection B(int i3) {
        return this.f28627e.L(i3) ? ResolvedTextDirection.f29613b : ResolvedTextDirection.f29612a;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float C(int i3) {
        return this.f28627e.l(i3);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public List D() {
        return this.f28629g;
    }

    public float H(int i3) {
        return this.f28627e.k(i3);
    }

    public final AndroidTextPaint J() {
        return this.f28623a.k();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float a(int i3) {
        return this.f28627e.u(i3);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float b(int i3) {
        return this.f28627e.s(i3);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float c() {
        return this.f28623a.c();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float d(int i3) {
        return this.f28627e.t(i3);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float e() {
        return this.f28623a.e();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public Rect f(int i3) {
        boolean z2 = false;
        if (i3 >= 0 && i3 < this.f28628f.length()) {
            z2 = true;
        }
        if (!z2) {
            InlineClassHelperKt.a("offset(" + i3 + ") is out of bounds [0," + this.f28628f.length() + ')');
        }
        RectF rectFC = this.f28627e.c(i3);
        return new Rect(rectFC.left, rectFC.top, rectFC.right, rectFC.bottom);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public ResolvedTextDirection g(int i3) {
        return this.f28627e.z(this.f28627e.q(i3)) == 1 ? ResolvedTextDirection.f29612a : ResolvedTextDirection.f29613b;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getHeight() {
        return this.f28627e.f();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getWidth() {
        return Constraints.l(this.f28626d);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float h(int i3) {
        return this.f28627e.w(i3);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public Rect i(int i3) {
        if (!(i3 >= 0 && i3 <= this.f28628f.length())) {
            InlineClassHelperKt.a("offset(" + i3 + ") is out of bounds [0," + this.f28628f.length() + ']');
        }
        float fB = TextLayout.B(this.f28627e, i3, false, 2, null);
        int iQ = this.f28627e.q(i3);
        return new Rect(fB, this.f28627e.w(iQ), fB, this.f28627e.l(iQ));
    }

    @Override // androidx.compose.ui.text.Paragraph
    public void j(Canvas canvas, long j3, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i3) {
        int iB = J().b();
        AndroidTextPaint androidTextPaintJ = J();
        androidTextPaintJ.f(j3);
        androidTextPaintJ.h(shadow);
        androidTextPaintJ.i(textDecoration);
        androidTextPaintJ.g(drawStyle);
        androidTextPaintJ.d(i3);
        L(canvas);
        J().d(iB);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public long k(int i3) {
        WordIterator wordIteratorI = this.f28627e.I();
        return TextRangeKt.b(WordBoundary_androidKt.b(wordIteratorI, i3), WordBoundary_androidKt.a(wordIteratorI, i3));
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float l() {
        return H(0);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int m(long j3) {
        return this.f28627e.y(this.f28627e.r((int) Float.intBitsToFloat((int) (4294967295L & j3))), Float.intBitsToFloat((int) (j3 >> 32)));
    }

    @Override // androidx.compose.ui.text.Paragraph
    public boolean n(int i3) {
        return this.f28627e.K(i3);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int o(int i3) {
        return this.f28627e.v(i3);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int p(int i3, boolean z2) {
        return z2 ? this.f28627e.x(i3) : this.f28627e.p(i3);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int q() {
        return this.f28627e.m();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public boolean r() {
        return this.f28627e.d();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int s(float f3) {
        return this.f28627e.r((int) f3);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public Path t(int i3, int i4) {
        if (!(i3 >= 0 && i3 <= i4 && i4 <= this.f28628f.length())) {
            InlineClassHelperKt.a("start(" + i3 + ") or end(" + i4 + ") is out of range [0.." + this.f28628f.length() + "], or start > end!");
        }
        android.graphics.Path path = new android.graphics.Path();
        this.f28627e.F(i3, i4, path);
        return AndroidPath_androidKt.c(path);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float u(int i3, boolean z2) {
        return z2 ? TextLayout.B(this.f28627e, i3, false, 2, null) : TextLayout.E(this.f28627e, i3, false, 2, null);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public void w(Canvas canvas, Brush brush, float f3, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i3) {
        int iB = J().b();
        AndroidTextPaint androidTextPaintJ = J();
        float width = getWidth();
        androidTextPaintJ.e(brush, Size.d((((long) Float.floatToRawIntBits(getHeight())) & 4294967295L) | (Float.floatToRawIntBits(width) << 32)), f3);
        androidTextPaintJ.h(shadow);
        androidTextPaintJ.i(textDecoration);
        androidTextPaintJ.g(drawStyle);
        androidTextPaintJ.d(i3);
        L(canvas);
        J().d(iB);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public void x(long j3, float[] fArr, int i3) {
        this.f28627e.a(TextRange.l(j3), TextRange.k(j3), fArr, i3);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float y() {
        return H(q() - 1);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int z(int i3) {
        return this.f28627e.q(i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01fe  */
    /* JADX WARN: Type inference failed for: r0v10, types: [androidx.compose.ui.text.AndroidParagraph] */
    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.compose.ui.text.AndroidParagraph] */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.compose.ui.text.AndroidParagraph] */
    /* JADX WARN: Type inference failed for: r0v5, types: [androidx.compose.ui.text.AndroidParagraph] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v41 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r22v0, types: [androidx.compose.ui.text.AndroidParagraph] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private AndroidParagraph(androidx.compose.ui.text.platform.AndroidParagraphIntrinsics r23, int r24, int r25, long r26) {
        /*
            Method dump skipped, instruction units count: 796
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.AndroidParagraph.<init>(androidx.compose.ui.text.platform.AndroidParagraphIntrinsics, int, int, long):void");
    }
}
