package com.revenuecat.purchases.ui.revenuecatui.components.properties;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderKt;
import androidx.compose.ui.graphics.TileMode;
import java.util.List;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
final class RelativeLinearGradient extends GradientBrush {
    private final List<Color> colors;
    private final float degrees;
    private final float radians;
    private final List<Float> stops;
    private final int tileMode;

    public /* synthetic */ RelativeLinearGradient(List list, List list2, float f3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, f3, i3);
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public Shader mo220createShaderuvyYCjk(long j3) {
        double d3 = 2;
        float fSqrt = (float) Math.sqrt(((float) Math.pow(Size.i(j3), d3)) + ((float) Math.pow(Size.g(j3), d3)));
        float fAcos = (float) Math.acos(Size.i(j3) / fSqrt);
        float f3 = this.degrees;
        float fAbs = Math.abs(((float) Math.cos((((f3 <= 90.0f || f3 >= 180.0f) && (f3 <= 270.0f || f3 >= 360.0f)) ? this.radians : 3.1415927f - this.radians) - fAcos)) * fSqrt) / 2;
        float fCos = ((float) Math.cos(this.radians)) * fAbs;
        float fSin = fAbs * ((float) Math.sin(this.radians));
        return ShaderKt.a(Offset.q(SizeKt.b(j3), OffsetKt.a(-fCos, fSin)), Offset.q(SizeKt.b(j3), OffsetKt.a(fCos, -fSin)), getColors$revenuecatui_defaultsBc8Release(), this.stops, this.tileMode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RelativeLinearGradient)) {
            return false;
        }
        RelativeLinearGradient relativeLinearGradient = (RelativeLinearGradient) obj;
        return Intrinsics.areEqual(this.colors, relativeLinearGradient.colors) && Intrinsics.areEqual(this.stops, relativeLinearGradient.stops) && TileMode.g(this.tileMode, relativeLinearGradient.tileMode);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.properties.GradientBrush
    public List<Color> getColors$revenuecatui_defaultsBc8Release() {
        return this.colors;
    }

    public int hashCode() {
        int iHashCode = this.colors.hashCode() * 31;
        List<Float> list = this.stops;
        return ((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + TileMode.h(this.tileMode);
    }

    public String toString() {
        return "RelativeLinearGradient(colors=" + this.colors + ", stops=" + this.stops + ", tileMode=" + ((Object) TileMode.i(this.tileMode)) + ')';
    }

    public /* synthetic */ RelativeLinearGradient(List list, List list2, float f3, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i4 & 2) != 0 ? null : list2, f3, (i4 & 8) != 0 ? TileMode.f25948b.a() : i3, null);
    }

    private RelativeLinearGradient(List<Color> colors, List<Float> list, float f3, int i3) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.colors = colors;
        this.stops = list;
        this.tileMode = i3;
        float f4 = 360;
        float f5 = (((90 - f3) % f4) + f4) % f4;
        this.degrees = f5;
        this.radians = (float) Math.toRadians(f5);
    }
}
