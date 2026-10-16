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
public final class BorderStyle {
    public static final int $stable = 0;
    private final ColorStyle color;
    private final float width;

    public /* synthetic */ BorderStyle(float f3, ColorStyle colorStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, colorStyle);
    }

    /* JADX INFO: renamed from: copy-D5KLDUw$default, reason: not valid java name */
    public static /* synthetic */ BorderStyle m760copyD5KLDUw$default(BorderStyle borderStyle, float f3, ColorStyle colorStyle, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = borderStyle.width;
        }
        if ((i3 & 2) != 0) {
            colorStyle = borderStyle.color;
        }
        return borderStyle.m762copyD5KLDUw(f3, colorStyle);
    }

    /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name */
    public final float m761component1D9Ej5fM() {
        return this.width;
    }

    public final ColorStyle component2() {
        return this.color;
    }

    /* JADX INFO: renamed from: copy-D5KLDUw, reason: not valid java name */
    public final BorderStyle m762copyD5KLDUw(float f3, ColorStyle color) {
        Intrinsics.checkNotNullParameter(color, "color");
        return new BorderStyle(f3, color, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderStyle)) {
            return false;
        }
        BorderStyle borderStyle = (BorderStyle) obj;
        return Dp.i(this.width, borderStyle.width) && Intrinsics.areEqual(this.color, borderStyle.color);
    }

    public final /* synthetic */ ColorStyle getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m763getWidthD9Ej5fM() {
        return this.width;
    }

    public int hashCode() {
        return (Dp.j(this.width) * 31) + this.color.hashCode();
    }

    public String toString() {
        return "BorderStyle(width=" + ((Object) Dp.k(this.width)) + ", color=" + this.color + ')';
    }

    private BorderStyle(float f3, ColorStyle color) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.width = f3;
        this.color = color;
    }
}
