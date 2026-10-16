package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
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
final class StaticLayoutParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharSequence f28981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f28982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f28983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextPaint f28984d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f28985e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextDirectionHeuristic f28986f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Layout.Alignment f28987g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f28988h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final TextUtils.TruncateAt f28989i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f28990j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final float f28991k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final float f28992l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f28993m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f28994n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f28995o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f28996p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f28997q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f28998r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f28999s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int[] f29000t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int[] f29001u;

    public StaticLayoutParams(CharSequence charSequence, int i3, int i4, TextPaint textPaint, int i5, TextDirectionHeuristic textDirectionHeuristic, Layout.Alignment alignment, int i6, TextUtils.TruncateAt truncateAt, int i7, float f3, float f4, int i8, boolean z2, boolean z3, int i9, int i10, int i11, int i12, int[] iArr, int[] iArr2) {
        this.f28981a = charSequence;
        this.f28982b = i3;
        this.f28983c = i4;
        this.f28984d = textPaint;
        this.f28985e = i5;
        this.f28986f = textDirectionHeuristic;
        this.f28987g = alignment;
        this.f28988h = i6;
        this.f28989i = truncateAt;
        this.f28990j = i7;
        this.f28991k = f3;
        this.f28992l = f4;
        this.f28993m = i8;
        this.f28994n = z2;
        this.f28995o = z3;
        this.f28996p = i9;
        this.f28997q = i10;
        this.f28998r = i11;
        this.f28999s = i12;
        this.f29000t = iArr;
        this.f29001u = iArr2;
        if (!(i3 >= 0 && i3 <= i4)) {
            InlineClassHelperKt.a("invalid start value");
        }
        if (!(i4 >= 0 && i4 <= charSequence.length())) {
            InlineClassHelperKt.a("invalid end value");
        }
        if (!(i6 >= 0)) {
            InlineClassHelperKt.a("invalid maxLines value");
        }
        if (!(i5 >= 0)) {
            InlineClassHelperKt.a("invalid width value");
        }
        if (!(i7 >= 0)) {
            InlineClassHelperKt.a("invalid ellipsizedWidth value");
        }
        if (f3 >= 0.0f) {
            return;
        }
        InlineClassHelperKt.a("invalid lineSpacingMultiplier value");
    }

    public final Layout.Alignment a() {
        return this.f28987g;
    }

    public final int b() {
        return this.f28996p;
    }

    public final TextUtils.TruncateAt c() {
        return this.f28989i;
    }

    public final int d() {
        return this.f28990j;
    }

    public final int e() {
        return this.f28983c;
    }

    public final int f() {
        return this.f28999s;
    }

    public final boolean g() {
        return this.f28994n;
    }

    public final int h() {
        return this.f28993m;
    }

    public final int[] i() {
        return this.f29000t;
    }

    public final int j() {
        return this.f28997q;
    }

    public final int k() {
        return this.f28998r;
    }

    public final float l() {
        return this.f28992l;
    }

    public final float m() {
        return this.f28991k;
    }

    public final int n() {
        return this.f28988h;
    }

    public final TextPaint o() {
        return this.f28984d;
    }

    public final int[] p() {
        return this.f29001u;
    }

    public final int q() {
        return this.f28982b;
    }

    public final CharSequence r() {
        return this.f28981a;
    }

    public final TextDirectionHeuristic s() {
        return this.f28986f;
    }

    public final boolean t() {
        return this.f28995o;
    }

    public final int u() {
        return this.f28985e;
    }
}
