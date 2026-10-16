package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;

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
public final class LineHeightStyleSpan implements android.text.style.LineHeightSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f29050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f29051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f29052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f29053d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f29054f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f29055g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f29056h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f29057i = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f29058j = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f29059k = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f29060l = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f29061m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f29062n;

    public LineHeightStyleSpan(float f3, int i3, int i4, boolean z2, boolean z3, float f4, boolean z4) {
        this.f29050a = f3;
        this.f29051b = i3;
        this.f29052c = i4;
        this.f29053d = z2;
        this.f29054f = z3;
        this.f29055g = f4;
        this.f29056h = z4;
        if ((0.0f <= f4 && f4 <= 1.0f) || f4 == -1.0f) {
            return;
        }
        InlineClassHelperKt.c("topRatio should be in [0..1] range or -1");
    }

    private final void a(Paint.FontMetricsInt fontMetricsInt) {
        int iCeil = (int) Math.ceil(this.f29050a);
        int iA = iCeil - LineHeightStyleSpan_androidKt.a(fontMetricsInt);
        if (this.f29056h && iA <= 0) {
            int i3 = fontMetricsInt.ascent;
            this.f29058j = i3;
            int i4 = fontMetricsInt.descent;
            this.f29059k = i4;
            this.f29057i = i3;
            this.f29060l = i4;
            this.f29061m = 0;
            this.f29062n = 0;
            return;
        }
        float fAbs = this.f29055g;
        if (fAbs == -1.0f) {
            fAbs = Math.abs(fontMetricsInt.ascent) / LineHeightStyleSpan_androidKt.a(fontMetricsInt);
        }
        int iCeil2 = (int) (iA <= 0 ? Math.ceil(iA * fAbs) : Math.ceil(iA * (1.0f - fAbs)));
        int i5 = fontMetricsInt.descent;
        int i6 = iCeil2 + i5;
        this.f29059k = i6;
        int i7 = i6 - iCeil;
        this.f29058j = i7;
        if (this.f29053d) {
            i7 = fontMetricsInt.ascent;
        }
        this.f29057i = i7;
        if (this.f29054f) {
            i6 = i5;
        }
        this.f29060l = i6;
        this.f29061m = fontMetricsInt.ascent - i7;
        this.f29062n = i6 - i5;
    }

    public final LineHeightStyleSpan b(int i3, int i4, boolean z2) {
        return new LineHeightStyleSpan(this.f29050a, i3, i4, z2, this.f29054f, this.f29055g, this.f29056h);
    }

    public final int c() {
        return this.f29061m;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i3, int i4, int i5, int i6, Paint.FontMetricsInt fontMetricsInt) {
        if (LineHeightStyleSpan_androidKt.a(fontMetricsInt) <= 0) {
            return;
        }
        boolean z2 = i3 == this.f29051b;
        boolean z3 = i4 == this.f29052c;
        if (z2 && z3 && this.f29053d && this.f29054f) {
            return;
        }
        if (this.f29057i == Integer.MIN_VALUE) {
            a(fontMetricsInt);
        }
        fontMetricsInt.ascent = z2 ? this.f29057i : this.f29058j;
        fontMetricsInt.descent = z3 ? this.f29060l : this.f29059k;
    }

    public final int d() {
        return this.f29062n;
    }

    public final boolean e() {
        return this.f29054f;
    }
}
