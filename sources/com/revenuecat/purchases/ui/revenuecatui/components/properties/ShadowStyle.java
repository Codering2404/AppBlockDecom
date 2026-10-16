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
public final class ShadowStyle {
    public static final int $stable = 0;
    private final ColorStyle color;
    private final float radius;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final float f92320x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final float f92321y;

    public /* synthetic */ ShadowStyle(ColorStyle colorStyle, float f3, float f4, float f5, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorStyle, f3, f4, f5);
    }

    /* JADX INFO: renamed from: copy-qQh39rQ$default, reason: not valid java name */
    public static /* synthetic */ ShadowStyle m789copyqQh39rQ$default(ShadowStyle shadowStyle, ColorStyle colorStyle, float f3, float f4, float f5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            colorStyle = shadowStyle.color;
        }
        if ((i3 & 2) != 0) {
            f3 = shadowStyle.radius;
        }
        if ((i3 & 4) != 0) {
            f4 = shadowStyle.f92320x;
        }
        if ((i3 & 8) != 0) {
            f5 = shadowStyle.f92321y;
        }
        return shadowStyle.m793copyqQh39rQ(colorStyle, f3, f4, f5);
    }

    public final ColorStyle component1() {
        return this.color;
    }

    /* JADX INFO: renamed from: component2-D9Ej5fM, reason: not valid java name */
    public final float m790component2D9Ej5fM() {
        return this.radius;
    }

    /* JADX INFO: renamed from: component3-D9Ej5fM, reason: not valid java name */
    public final float m791component3D9Ej5fM() {
        return this.f92320x;
    }

    /* JADX INFO: renamed from: component4-D9Ej5fM, reason: not valid java name */
    public final float m792component4D9Ej5fM() {
        return this.f92321y;
    }

    /* JADX INFO: renamed from: copy-qQh39rQ, reason: not valid java name */
    public final ShadowStyle m793copyqQh39rQ(ColorStyle color, float f3, float f4, float f5) {
        Intrinsics.checkNotNullParameter(color, "color");
        return new ShadowStyle(color, f3, f4, f5, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShadowStyle)) {
            return false;
        }
        ShadowStyle shadowStyle = (ShadowStyle) obj;
        return Intrinsics.areEqual(this.color, shadowStyle.color) && Dp.i(this.radius, shadowStyle.radius) && Dp.i(this.f92320x, shadowStyle.f92320x) && Dp.i(this.f92321y, shadowStyle.f92321y);
    }

    public final /* synthetic */ ColorStyle getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: getRadius-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m794getRadiusD9Ej5fM() {
        return this.radius;
    }

    /* JADX INFO: renamed from: getX-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m795getXD9Ej5fM() {
        return this.f92320x;
    }

    /* JADX INFO: renamed from: getY-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m796getYD9Ej5fM() {
        return this.f92321y;
    }

    public int hashCode() {
        return (((((this.color.hashCode() * 31) + Dp.j(this.radius)) * 31) + Dp.j(this.f92320x)) * 31) + Dp.j(this.f92321y);
    }

    public String toString() {
        return "ShadowStyle(color=" + this.color + ", radius=" + ((Object) Dp.k(this.radius)) + ", x=" + ((Object) Dp.k(this.f92320x)) + ", y=" + ((Object) Dp.k(this.f92321y)) + ')';
    }

    private ShadowStyle(ColorStyle color, float f3, float f4, float f5) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.color = color;
        this.radius = f3;
        this.f92320x = f4;
        this.f92321y = f5;
    }
}
