package androidx.compose.material;

import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.TextUnitKt;
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
    private final TextStyle f15128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextStyle f15129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextStyle f15130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextStyle f15131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextStyle f15132e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextStyle f15133f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextStyle f15134g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final TextStyle f15135h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final TextStyle f15136i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final TextStyle f15137j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final TextStyle f15138k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final TextStyle f15139l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final TextStyle f15140m;

    public Typography(TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13) {
        this.f15128a = textStyle;
        this.f15129b = textStyle2;
        this.f15130c = textStyle3;
        this.f15131d = textStyle4;
        this.f15132e = textStyle5;
        this.f15133f = textStyle6;
        this.f15134g = textStyle7;
        this.f15135h = textStyle8;
        this.f15136i = textStyle9;
        this.f15137j = textStyle10;
        this.f15138k = textStyle11;
        this.f15139l = textStyle12;
        this.f15140m = textStyle13;
    }

    public final TextStyle a() {
        return this.f15136i;
    }

    public final TextStyle b() {
        return this.f15137j;
    }

    public final TextStyle c() {
        return this.f15138k;
    }

    public final TextStyle d() {
        return this.f15139l;
    }

    public final TextStyle e() {
        return this.f15128a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Typography)) {
            return false;
        }
        Typography typography = (Typography) obj;
        return Intrinsics.areEqual(this.f15128a, typography.f15128a) && Intrinsics.areEqual(this.f15129b, typography.f15129b) && Intrinsics.areEqual(this.f15130c, typography.f15130c) && Intrinsics.areEqual(this.f15131d, typography.f15131d) && Intrinsics.areEqual(this.f15132e, typography.f15132e) && Intrinsics.areEqual(this.f15133f, typography.f15133f) && Intrinsics.areEqual(this.f15134g, typography.f15134g) && Intrinsics.areEqual(this.f15135h, typography.f15135h) && Intrinsics.areEqual(this.f15136i, typography.f15136i) && Intrinsics.areEqual(this.f15137j, typography.f15137j) && Intrinsics.areEqual(this.f15138k, typography.f15138k) && Intrinsics.areEqual(this.f15139l, typography.f15139l) && Intrinsics.areEqual(this.f15140m, typography.f15140m);
    }

    public final TextStyle f() {
        return this.f15129b;
    }

    public final TextStyle g() {
        return this.f15130c;
    }

    public final TextStyle h() {
        return this.f15131d;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.f15128a.hashCode() * 31) + this.f15129b.hashCode()) * 31) + this.f15130c.hashCode()) * 31) + this.f15131d.hashCode()) * 31) + this.f15132e.hashCode()) * 31) + this.f15133f.hashCode()) * 31) + this.f15134g.hashCode()) * 31) + this.f15135h.hashCode()) * 31) + this.f15136i.hashCode()) * 31) + this.f15137j.hashCode()) * 31) + this.f15138k.hashCode()) * 31) + this.f15139l.hashCode()) * 31) + this.f15140m.hashCode();
    }

    public final TextStyle i() {
        return this.f15132e;
    }

    public final TextStyle j() {
        return this.f15133f;
    }

    public final TextStyle k() {
        return this.f15140m;
    }

    public final TextStyle l() {
        return this.f15134g;
    }

    public final TextStyle m() {
        return this.f15135h;
    }

    public String toString() {
        return "Typography(h1=" + this.f15128a + ", h2=" + this.f15129b + ", h3=" + this.f15130c + ", h4=" + this.f15131d + ", h5=" + this.f15132e + ", h6=" + this.f15133f + ", subtitle1=" + this.f15134g + ", subtitle2=" + this.f15135h + ", body1=" + this.f15136i + ", body2=" + this.f15137j + ", button=" + this.f15138k + ", caption=" + this.f15139l + ", overline=" + this.f15140m + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Typography(FontFamily fontFamily, TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        TextStyle textStyleE;
        TextStyle textStyleE2;
        TextStyle textStyleE3;
        TextStyle textStyleE4;
        TextStyle textStyleE5;
        TextStyle textStyleE6;
        TextStyle textStyleE7;
        TextStyle textStyleE8;
        TextStyle textStyleE9;
        TextStyle textStyleE10;
        TextStyle textStyleE11;
        TextStyle textStyleE12;
        TextStyle textStyleE13;
        FontFamily fontFamilyB = (i3 & 1) != 0 ? FontFamily.f29155b.b() : fontFamily;
        if ((i3 & 2) != 0) {
            textStyleE = TextStyle.e(TypographyKt.b(), 0L, TextUnitKt.i(96), FontWeight.f29233b.e(), null, null, null, null, TextUnitKt.g(-1.5d), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(112), null, null, null, 0, 0, null, 16646009, null);
        } else {
            textStyleE = textStyle;
        }
        if ((i3 & 4) != 0) {
            textStyleE2 = TextStyle.e(TypographyKt.b(), 0L, TextUnitKt.i(60), FontWeight.f29233b.e(), null, null, null, null, TextUnitKt.g(-0.5d), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(72), null, null, null, 0, 0, null, 16646009, null);
        } else {
            textStyleE2 = textStyle2;
        }
        if ((i3 & 8) != 0) {
            textStyleE3 = TextStyle.e(TypographyKt.b(), 0L, TextUnitKt.i(48), FontWeight.f29233b.g(), null, null, null, null, TextUnitKt.i(0), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(56), null, null, null, 0, 0, null, 16646009, null);
        } else {
            textStyleE3 = textStyle3;
        }
        if ((i3 & 16) != 0) {
            textStyleE4 = TextStyle.e(TypographyKt.b(), 0L, TextUnitKt.i(34), FontWeight.f29233b.g(), null, null, null, null, TextUnitKt.g(0.25d), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(36), null, null, null, 0, 0, null, 16646009, null);
        } else {
            textStyleE4 = textStyle4;
        }
        if ((i3 & 32) != 0) {
            textStyleE5 = TextStyle.e(TypographyKt.b(), 0L, TextUnitKt.i(24), FontWeight.f29233b.g(), null, null, null, null, TextUnitKt.i(0), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(24), null, null, null, 0, 0, null, 16646009, null);
        } else {
            textStyleE5 = textStyle5;
        }
        if ((i3 & 64) != 0) {
            textStyleE6 = TextStyle.e(TypographyKt.b(), 0L, TextUnitKt.i(20), FontWeight.f29233b.f(), null, null, null, null, TextUnitKt.g(0.15d), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(24), null, null, null, 0, 0, null, 16646009, null);
        } else {
            textStyleE6 = textStyle6;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            textStyleE7 = TextStyle.e(TypographyKt.b(), 0L, TextUnitKt.i(16), FontWeight.f29233b.g(), null, null, null, null, TextUnitKt.g(0.15d), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(24), null, null, null, 0, 0, null, 16646009, null);
        } else {
            textStyleE7 = textStyle7;
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            textStyleE8 = TextStyle.e(TypographyKt.b(), 0L, TextUnitKt.i(14), FontWeight.f29233b.f(), null, null, null, null, TextUnitKt.g(0.1d), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(24), null, null, null, 0, 0, null, 16646009, null);
        } else {
            textStyleE8 = textStyle8;
        }
        if ((i3 & 512) != 0) {
            textStyleE9 = TextStyle.e(TypographyKt.b(), 0L, TextUnitKt.i(16), FontWeight.f29233b.g(), null, null, null, null, TextUnitKt.g(0.5d), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(24), null, null, null, 0, 0, null, 16646009, null);
        } else {
            textStyleE9 = textStyle9;
        }
        if ((i3 & 1024) != 0) {
            textStyleE10 = TextStyle.e(TypographyKt.b(), 0L, TextUnitKt.i(14), FontWeight.f29233b.g(), null, null, null, null, TextUnitKt.g(0.25d), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(20), null, null, null, 0, 0, null, 16646009, null);
        } else {
            textStyleE10 = textStyle10;
        }
        if ((i3 & 2048) != 0) {
            textStyleE11 = TextStyle.e(TypographyKt.b(), 0L, TextUnitKt.i(14), FontWeight.f29233b.f(), null, null, null, null, TextUnitKt.g(1.25d), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(16), null, null, null, 0, 0, null, 16646009, null);
        } else {
            textStyleE11 = textStyle11;
        }
        if ((i3 & 4096) != 0) {
            textStyleE12 = TextStyle.e(TypographyKt.b(), 0L, TextUnitKt.i(12), FontWeight.f29233b.g(), null, null, null, null, TextUnitKt.g(0.4d), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(16), null, null, null, 0, 0, null, 16646009, null);
        } else {
            textStyleE12 = textStyle12;
        }
        if ((i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0) {
            textStyleE13 = TextStyle.e(TypographyKt.b(), 0L, TextUnitKt.i(10), FontWeight.f29233b.g(), null, null, null, null, TextUnitKt.g(1.5d), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(16), null, null, null, 0, 0, null, 16646009, null);
        } else {
            textStyleE13 = textStyle13;
        }
        this(fontFamilyB, textStyleE, textStyleE2, textStyleE3, textStyleE4, textStyleE5, textStyleE6, textStyleE7, textStyleE8, textStyleE9, textStyleE10, textStyleE11, textStyleE12, textStyleE13);
    }

    public Typography(FontFamily fontFamily, TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13) {
        this(TypographyKt.d(textStyle, fontFamily), TypographyKt.d(textStyle2, fontFamily), TypographyKt.d(textStyle3, fontFamily), TypographyKt.d(textStyle4, fontFamily), TypographyKt.d(textStyle5, fontFamily), TypographyKt.d(textStyle6, fontFamily), TypographyKt.d(textStyle7, fontFamily), TypographyKt.d(textStyle8, fontFamily), TypographyKt.d(textStyle9, fontFamily), TypographyKt.d(textStyle10, fontFamily), TypographyKt.d(textStyle11, fontFamily), TypographyKt.d(textStyle12, fontFamily), TypographyKt.d(textStyle13, fontFamily));
    }
}
