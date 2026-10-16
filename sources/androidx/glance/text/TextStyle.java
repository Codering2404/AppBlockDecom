package androidx.glance.text;

import androidx.compose.ui.unit.TextUnit;
import androidx.glance.unit.ColorProvider;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class TextStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ColorProvider f39778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextUnit f39779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FontWeight f39780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FontStyle f39781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextAlign f39782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextDecoration f39783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final FontFamily f39784g;

    public /* synthetic */ TextStyle(ColorProvider colorProvider, TextUnit textUnit, FontWeight fontWeight, FontStyle fontStyle, TextAlign textAlign, TextDecoration textDecoration, FontFamily fontFamily, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorProvider, textUnit, fontWeight, fontStyle, textAlign, textDecoration, fontFamily);
    }

    public static /* synthetic */ TextStyle b(TextStyle textStyle, ColorProvider colorProvider, TextUnit textUnit, FontWeight fontWeight, FontStyle fontStyle, TextAlign textAlign, TextDecoration textDecoration, FontFamily fontFamily, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            colorProvider = textStyle.f39778a;
        }
        if ((i3 & 2) != 0) {
            textUnit = textStyle.f39779b;
        }
        if ((i3 & 4) != 0) {
            fontWeight = textStyle.f39780c;
        }
        if ((i3 & 8) != 0) {
            fontStyle = textStyle.f39781d;
        }
        if ((i3 & 16) != 0) {
            textAlign = textStyle.f39782e;
        }
        if ((i3 & 32) != 0) {
            textDecoration = textStyle.f39783f;
        }
        if ((i3 & 64) != 0) {
            fontFamily = textStyle.f39784g;
        }
        TextDecoration textDecoration2 = textDecoration;
        FontFamily fontFamily2 = fontFamily;
        TextAlign textAlign2 = textAlign;
        FontWeight fontWeight2 = fontWeight;
        return textStyle.a(colorProvider, textUnit, fontWeight2, fontStyle, textAlign2, textDecoration2, fontFamily2);
    }

    public final TextStyle a(ColorProvider colorProvider, TextUnit textUnit, FontWeight fontWeight, FontStyle fontStyle, TextAlign textAlign, TextDecoration textDecoration, FontFamily fontFamily) {
        return new TextStyle(colorProvider, textUnit, fontWeight, fontStyle, textAlign, textDecoration, fontFamily, null);
    }

    public final ColorProvider c() {
        return this.f39778a;
    }

    public final FontFamily d() {
        return this.f39784g;
    }

    public final TextUnit e() {
        return this.f39779b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextStyle)) {
            return false;
        }
        TextStyle textStyle = (TextStyle) obj;
        return Intrinsics.areEqual(this.f39778a, textStyle.f39778a) && Intrinsics.areEqual(this.f39779b, textStyle.f39779b) && Intrinsics.areEqual(this.f39780c, textStyle.f39780c) && Intrinsics.areEqual(this.f39781d, textStyle.f39781d) && Intrinsics.areEqual(this.f39783f, textStyle.f39783f) && Intrinsics.areEqual(this.f39782e, textStyle.f39782e) && Intrinsics.areEqual(this.f39784g, textStyle.f39784g);
    }

    public final FontStyle f() {
        return this.f39781d;
    }

    public final FontWeight g() {
        return this.f39780c;
    }

    public final TextAlign h() {
        return this.f39782e;
    }

    public int hashCode() {
        int iHashCode = this.f39778a.hashCode() * 31;
        TextUnit textUnit = this.f39779b;
        int iHashCode2 = (iHashCode + (textUnit != null ? textUnit.hashCode() : 0)) * 31;
        FontWeight fontWeight = this.f39780c;
        int iHashCode3 = (iHashCode2 + (fontWeight != null ? fontWeight.hashCode() : 0)) * 31;
        FontStyle fontStyle = this.f39781d;
        int iHashCode4 = (iHashCode3 + (fontStyle != null ? fontStyle.hashCode() : 0)) * 31;
        TextDecoration textDecoration = this.f39783f;
        int iHashCode5 = (iHashCode4 + (textDecoration != null ? textDecoration.hashCode() : 0)) * 31;
        TextAlign textAlign = this.f39782e;
        int iHashCode6 = (iHashCode5 + (textAlign != null ? textAlign.hashCode() : 0)) * 31;
        FontFamily fontFamily = this.f39784g;
        return iHashCode6 + (fontFamily != null ? fontFamily.hashCode() : 0);
    }

    public final TextDecoration i() {
        return this.f39783f;
    }

    public String toString() {
        return "TextStyle(color=" + this.f39778a + ", fontSize=" + this.f39779b + ", fontWeight=" + this.f39780c + ", fontStyle=" + this.f39781d + ", textDecoration=" + this.f39783f + ", textAlign=" + this.f39782e + ", fontFamily=" + this.f39784g + ')';
    }

    private TextStyle(ColorProvider colorProvider, TextUnit textUnit, FontWeight fontWeight, FontStyle fontStyle, TextAlign textAlign, TextDecoration textDecoration, FontFamily fontFamily) {
        this.f39778a = colorProvider;
        this.f39779b = textUnit;
        this.f39780c = fontWeight;
        this.f39781d = fontStyle;
        this.f39782e = textAlign;
        this.f39783f = textDecoration;
        this.f39784g = fontFamily;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TextStyle(ColorProvider colorProvider, TextUnit textUnit, FontWeight fontWeight, FontStyle fontStyle, TextAlign textAlign, TextDecoration textDecoration, FontFamily fontFamily, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        ColorProvider colorProviderA = (i3 & 1) != 0 ? TextDefaults.f39763a.a() : colorProvider;
        TextUnit textUnit2 = (i3 & 2) != 0 ? null : textUnit;
        FontWeight fontWeight2 = (i3 & 4) != 0 ? null : fontWeight;
        FontStyle fontStyle2 = (i3 & 8) != 0 ? null : fontStyle;
        TextAlign textAlign2 = (i3 & 16) != 0 ? null : textAlign;
        TextDecoration textDecoration2 = (i3 & 32) != 0 ? null : textDecoration;
        this(colorProviderA, textUnit2, fontWeight2, fontStyle2, textAlign2, textDecoration2, (i3 & 64) == 0 ? fontFamily : null, null);
    }
}
