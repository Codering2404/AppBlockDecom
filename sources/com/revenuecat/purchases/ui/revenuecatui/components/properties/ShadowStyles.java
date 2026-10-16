package com.revenuecat.purchases.ui.revenuecatui.components.properties;

import androidx.compose.ui.unit.Dp;
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
public final class ShadowStyles {
    public static final int $stable = 0;
    private final ColorStyles colors;
    private final float radius;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final float f92322x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final float f92323y;

    public /* synthetic */ ShadowStyles(ColorStyles colorStyles, float f3, float f4, float f5, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorStyles, f3, f4, f5);
    }

    /* JADX INFO: renamed from: copy-qQh39rQ$default, reason: not valid java name */
    public static /* synthetic */ ShadowStyles m797copyqQh39rQ$default(ShadowStyles shadowStyles, ColorStyles colorStyles, float f3, float f4, float f5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            colorStyles = shadowStyles.colors;
        }
        if ((i3 & 2) != 0) {
            f3 = shadowStyles.radius;
        }
        if ((i3 & 4) != 0) {
            f4 = shadowStyles.f92322x;
        }
        if ((i3 & 8) != 0) {
            f5 = shadowStyles.f92323y;
        }
        return shadowStyles.m801copyqQh39rQ(colorStyles, f3, f4, f5);
    }

    public final ColorStyles component1() {
        return this.colors;
    }

    /* JADX INFO: renamed from: component2-D9Ej5fM, reason: not valid java name */
    public final float m798component2D9Ej5fM() {
        return this.radius;
    }

    /* JADX INFO: renamed from: component3-D9Ej5fM, reason: not valid java name */
    public final float m799component3D9Ej5fM() {
        return this.f92322x;
    }

    /* JADX INFO: renamed from: component4-D9Ej5fM, reason: not valid java name */
    public final float m800component4D9Ej5fM() {
        return this.f92323y;
    }

    /* JADX INFO: renamed from: copy-qQh39rQ, reason: not valid java name */
    public final ShadowStyles m801copyqQh39rQ(ColorStyles colors, float f3, float f4, float f5) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        return new ShadowStyles(colors, f3, f4, f5, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShadowStyles)) {
            return false;
        }
        ShadowStyles shadowStyles = (ShadowStyles) obj;
        return Intrinsics.areEqual(this.colors, shadowStyles.colors) && Dp.i(this.radius, shadowStyles.radius) && Dp.i(this.f92322x, shadowStyles.f92322x) && Dp.i(this.f92323y, shadowStyles.f92323y);
    }

    public final /* synthetic */ ColorStyles getColors() {
        return this.colors;
    }

    /* JADX INFO: renamed from: getRadius-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m802getRadiusD9Ej5fM() {
        return this.radius;
    }

    /* JADX INFO: renamed from: getX-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m803getXD9Ej5fM() {
        return this.f92322x;
    }

    /* JADX INFO: renamed from: getY-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m804getYD9Ej5fM() {
        return this.f92323y;
    }

    public int hashCode() {
        return (((((this.colors.hashCode() * 31) + Dp.j(this.radius)) * 31) + Dp.j(this.f92322x)) * 31) + Dp.j(this.f92323y);
    }

    public String toString() {
        return "ShadowStyles(colors=" + this.colors + ", radius=" + ((Object) Dp.k(this.radius)) + ", x=" + ((Object) Dp.k(this.f92322x)) + ", y=" + ((Object) Dp.k(this.f92323y)) + ')';
    }

    private ShadowStyles(ColorStyles colors, float f3, float f4, float f5) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.colors = colors;
        this.radius = f3;
        this.f92322x = f4;
        this.f92323y = f5;
    }
}
