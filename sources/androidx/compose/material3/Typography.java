package androidx.compose.material3;

import androidx.compose.material3.tokens.TypographyTokens;
import androidx.compose.ui.text.TextStyle;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class Typography {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextStyle f21566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextStyle f21567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextStyle f21568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextStyle f21569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextStyle f21570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextStyle f21571f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextStyle f21572g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final TextStyle f21573h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final TextStyle f21574i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final TextStyle f21575j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final TextStyle f21576k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final TextStyle f21577l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final TextStyle f21578m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final TextStyle f21579n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final TextStyle f21580o;

    public Typography(TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13, TextStyle textStyle14, TextStyle textStyle15) {
        this.f21566a = textStyle;
        this.f21567b = textStyle2;
        this.f21568c = textStyle3;
        this.f21569d = textStyle4;
        this.f21570e = textStyle5;
        this.f21571f = textStyle6;
        this.f21572g = textStyle7;
        this.f21573h = textStyle8;
        this.f21574i = textStyle9;
        this.f21575j = textStyle10;
        this.f21576k = textStyle11;
        this.f21577l = textStyle12;
        this.f21578m = textStyle13;
        this.f21579n = textStyle14;
        this.f21580o = textStyle15;
    }

    public final Typography a(TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13, TextStyle textStyle14, TextStyle textStyle15) {
        return new Typography(textStyle, textStyle2, textStyle3, textStyle4, textStyle5, textStyle6, textStyle7, textStyle8, textStyle9, textStyle10, textStyle11, textStyle12, textStyle13, textStyle14, textStyle15);
    }

    public final TextStyle b() {
        return this.f21575j;
    }

    public final TextStyle c() {
        return this.f21576k;
    }

    public final TextStyle d() {
        return this.f21577l;
    }

    public final TextStyle e() {
        return this.f21566a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Typography)) {
            return false;
        }
        Typography typography = (Typography) obj;
        return Intrinsics.areEqual(this.f21566a, typography.f21566a) && Intrinsics.areEqual(this.f21567b, typography.f21567b) && Intrinsics.areEqual(this.f21568c, typography.f21568c) && Intrinsics.areEqual(this.f21569d, typography.f21569d) && Intrinsics.areEqual(this.f21570e, typography.f21570e) && Intrinsics.areEqual(this.f21571f, typography.f21571f) && Intrinsics.areEqual(this.f21572g, typography.f21572g) && Intrinsics.areEqual(this.f21573h, typography.f21573h) && Intrinsics.areEqual(this.f21574i, typography.f21574i) && Intrinsics.areEqual(this.f21575j, typography.f21575j) && Intrinsics.areEqual(this.f21576k, typography.f21576k) && Intrinsics.areEqual(this.f21577l, typography.f21577l) && Intrinsics.areEqual(this.f21578m, typography.f21578m) && Intrinsics.areEqual(this.f21579n, typography.f21579n) && Intrinsics.areEqual(this.f21580o, typography.f21580o);
    }

    public final TextStyle f() {
        return this.f21567b;
    }

    public final TextStyle g() {
        return this.f21568c;
    }

    public final TextStyle h() {
        return this.f21569d;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((this.f21566a.hashCode() * 31) + this.f21567b.hashCode()) * 31) + this.f21568c.hashCode()) * 31) + this.f21569d.hashCode()) * 31) + this.f21570e.hashCode()) * 31) + this.f21571f.hashCode()) * 31) + this.f21572g.hashCode()) * 31) + this.f21573h.hashCode()) * 31) + this.f21574i.hashCode()) * 31) + this.f21575j.hashCode()) * 31) + this.f21576k.hashCode()) * 31) + this.f21577l.hashCode()) * 31) + this.f21578m.hashCode()) * 31) + this.f21579n.hashCode()) * 31) + this.f21580o.hashCode();
    }

    public final TextStyle i() {
        return this.f21570e;
    }

    public final TextStyle j() {
        return this.f21571f;
    }

    public final TextStyle k() {
        return this.f21578m;
    }

    public final TextStyle l() {
        return this.f21579n;
    }

    public final TextStyle m() {
        return this.f21580o;
    }

    public final TextStyle n() {
        return this.f21572g;
    }

    public final TextStyle o() {
        return this.f21573h;
    }

    public final TextStyle p() {
        return this.f21574i;
    }

    public String toString() {
        return "Typography(displayLarge=" + this.f21566a + ", displayMedium=" + this.f21567b + ",displaySmall=" + this.f21568c + ", headlineLarge=" + this.f21569d + ", headlineMedium=" + this.f21570e + ", headlineSmall=" + this.f21571f + ", titleLarge=" + this.f21572g + ", titleMedium=" + this.f21573h + ", titleSmall=" + this.f21574i + ", bodyLarge=" + this.f21575j + ", bodyMedium=" + this.f21576k + ", bodySmall=" + this.f21577l + ", labelLarge=" + this.f21578m + ", labelMedium=" + this.f21579n + ", labelSmall=" + this.f21580o + ')';
    }

    public /* synthetic */ Typography(TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13, TextStyle textStyle14, TextStyle textStyle15, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? TypographyTokens.f23694a.d() : textStyle, (i3 & 2) != 0 ? TypographyTokens.f23694a.e() : textStyle2, (i3 & 4) != 0 ? TypographyTokens.f23694a.f() : textStyle3, (i3 & 8) != 0 ? TypographyTokens.f23694a.g() : textStyle4, (i3 & 16) != 0 ? TypographyTokens.f23694a.h() : textStyle5, (i3 & 32) != 0 ? TypographyTokens.f23694a.i() : textStyle6, (i3 & 64) != 0 ? TypographyTokens.f23694a.m() : textStyle7, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? TypographyTokens.f23694a.n() : textStyle8, (i3 & Function.MAX_NARGS) != 0 ? TypographyTokens.f23694a.o() : textStyle9, (i3 & 512) != 0 ? TypographyTokens.f23694a.a() : textStyle10, (i3 & 1024) != 0 ? TypographyTokens.f23694a.b() : textStyle11, (i3 & 2048) != 0 ? TypographyTokens.f23694a.c() : textStyle12, (i3 & 4096) != 0 ? TypographyTokens.f23694a.j() : textStyle13, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? TypographyTokens.f23694a.k() : textStyle14, (i3 & 16384) != 0 ? TypographyTokens.f23694a.l() : textStyle15);
    }
}
