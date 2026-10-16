package androidx.compose.ui.graphics.vector.compat;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.compose.ui.graphics.vector.PathParser;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

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
public final class AndroidVectorParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final XmlPullParser f26581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f26582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PathParser f26583c;

    public AndroidVectorParser(XmlPullParser xmlPullParser, int i3) {
        this.f26581a = xmlPullParser;
        this.f26582b = i3;
        this.f26583c = new PathParser();
    }

    private final void l(int i3) {
        this.f26582b = i3 | this.f26582b;
    }

    public final float a(TypedArray typedArray, int i3, float f3) {
        float dimension = typedArray.getDimension(i3, f3);
        l(typedArray.getChangingConfigurations());
        return dimension;
    }

    public final float b(TypedArray typedArray, int i3, float f3) {
        float f4 = typedArray.getFloat(i3, f3);
        l(typedArray.getChangingConfigurations());
        return f4;
    }

    public final int c(TypedArray typedArray, int i3, int i4) {
        int i5 = typedArray.getInt(i3, i4);
        l(typedArray.getChangingConfigurations());
        return i5;
    }

    public final boolean d(TypedArray typedArray, String str, int i3, boolean z2) {
        boolean zE = TypedArrayUtils.e(typedArray, this.f26581a, str, i3, z2);
        l(typedArray.getChangingConfigurations());
        return zE;
    }

    public final ColorStateList e(TypedArray typedArray, Resources.Theme theme, String str, int i3) {
        ColorStateList colorStateListG = TypedArrayUtils.g(typedArray, this.f26581a, theme, str, i3);
        l(typedArray.getChangingConfigurations());
        return colorStateListG;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndroidVectorParser)) {
            return false;
        }
        AndroidVectorParser androidVectorParser = (AndroidVectorParser) obj;
        return Intrinsics.areEqual(this.f26581a, androidVectorParser.f26581a) && this.f26582b == androidVectorParser.f26582b;
    }

    public final ComplexColorCompat f(TypedArray typedArray, Resources.Theme theme, String str, int i3, int i4) {
        ComplexColorCompat complexColorCompatI = TypedArrayUtils.i(typedArray, this.f26581a, theme, str, i3, i4);
        l(typedArray.getChangingConfigurations());
        return complexColorCompatI;
    }

    public final float g(TypedArray typedArray, String str, int i3, float f3) {
        float fJ = TypedArrayUtils.j(typedArray, this.f26581a, str, i3, f3);
        l(typedArray.getChangingConfigurations());
        return fJ;
    }

    public final int h(TypedArray typedArray, String str, int i3, int i4) {
        int iK = TypedArrayUtils.k(typedArray, this.f26581a, str, i3, i4);
        l(typedArray.getChangingConfigurations());
        return iK;
    }

    public int hashCode() {
        return (this.f26581a.hashCode() * 31) + Integer.hashCode(this.f26582b);
    }

    public final String i(TypedArray typedArray, int i3) {
        String string = typedArray.getString(i3);
        l(typedArray.getChangingConfigurations());
        return string;
    }

    public final XmlPullParser j() {
        return this.f26581a;
    }

    public final TypedArray k(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        TypedArray typedArrayQ = TypedArrayUtils.q(resources, theme, attributeSet, iArr);
        l(typedArrayQ.getChangingConfigurations());
        return typedArrayQ;
    }

    public String toString() {
        return "AndroidVectorParser(xmlParser=" + this.f26581a + ", config=" + this.f26582b + ')';
    }

    public /* synthetic */ AndroidVectorParser(XmlPullParser xmlPullParser, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(xmlPullParser, (i4 & 2) != 0 ? 0 : i3);
    }
}
