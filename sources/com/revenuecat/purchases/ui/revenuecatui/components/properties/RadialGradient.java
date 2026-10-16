package com.revenuecat.purchases.ui.revenuecatui.components.properties;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderKt;
import androidx.compose.ui.graphics.TileMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
final class RadialGradient extends GradientBrush {
    private final long center;
    private final Pair<Float, Color>[] colorStopsArray;
    private final List<Color> colors;
    private final float radius;
    private final int tileMode;

    public /* synthetic */ RadialGradient(Pair[] pairArr, long j3, float f3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(pairArr, j3, f3, i3);
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public Shader mo220createShaderuvyYCjk(long j3) {
        float fMax = this.radius;
        if (fMax == Float.POSITIVE_INFINITY) {
            fMax = Math.max(Size.i(j3), Size.g(j3)) / 2.0f;
        }
        float f3 = fMax;
        long jB = Offset.j(this.center, Offset.f25596b.b()) ? SizeKt.b(j3) : this.center;
        Pair<Float, Color>[] pairArr = this.colorStopsArray;
        ArrayList arrayList = new ArrayList(pairArr.length);
        for (Pair<Float, Color> pair : pairArr) {
            arrayList.add(Color.n(((Color) pair.f()).B()));
        }
        Pair<Float, Color>[] pairArr2 = this.colorStopsArray;
        ArrayList arrayList2 = new ArrayList(pairArr2.length);
        for (Pair<Float, Color> pair2 : pairArr2) {
            arrayList2.add(Float.valueOf(((Number) pair2.e()).floatValue()));
        }
        return ShaderKt.c(jB, f3, arrayList, arrayList2, this.tileMode);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RadialGradient)) {
            return false;
        }
        RadialGradient radialGradient = (RadialGradient) obj;
        return Arrays.equals(radialGradient.colorStopsArray, this.colorStopsArray) && Offset.j(radialGradient.center, this.center) && radialGradient.radius == this.radius && TileMode.g(radialGradient.tileMode, this.tileMode);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.properties.GradientBrush
    public List<Color> getColors$revenuecatui_defaultsBc8Release() {
        return this.colors;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.colorStopsArray) * 31) + (Offset.o(this.center) * 31) + (Float.hashCode(this.radius) * 31) + TileMode.h(this.tileMode);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RadialGradient(colorStops=");
        String string = Arrays.toString(this.colorStopsArray);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        sb.append(string);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ RadialGradient(Pair[] pairArr, long j3, float f3, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(pairArr, (i4 & 2) != 0 ? Offset.f25596b.b() : j3, (i4 & 4) != 0 ? Float.POSITIVE_INFINITY : f3, (i4 & 8) != 0 ? TileMode.f25948b.a() : i3, null);
    }

    private RadialGradient(Pair<Float, Color>[] colorStops, long j3, float f3, int i3) {
        Intrinsics.checkNotNullParameter(colorStops, "colorStops");
        this.center = j3;
        this.radius = f3;
        this.tileMode = i3;
        this.colorStopsArray = colorStops;
        ArrayList arrayList = new ArrayList(colorStops.length);
        for (Pair<Float, Color> pair : colorStops) {
            arrayList.add(Color.n(((Color) pair.f()).B()));
        }
        this.colors = arrayList;
    }
}
