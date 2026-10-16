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
public final class BorderStyles {
    public static final int $stable = 0;
    private final ColorStyles colors;
    private final float width;

    public /* synthetic */ BorderStyles(float f3, ColorStyles colorStyles, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, colorStyles);
    }

    /* JADX INFO: renamed from: copy-D5KLDUw$default, reason: not valid java name */
    public static /* synthetic */ BorderStyles m764copyD5KLDUw$default(BorderStyles borderStyles, float f3, ColorStyles colorStyles, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = borderStyles.width;
        }
        if ((i3 & 2) != 0) {
            colorStyles = borderStyles.colors;
        }
        return borderStyles.m766copyD5KLDUw(f3, colorStyles);
    }

    /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name */
    public final float m765component1D9Ej5fM() {
        return this.width;
    }

    public final ColorStyles component2() {
        return this.colors;
    }

    /* JADX INFO: renamed from: copy-D5KLDUw, reason: not valid java name */
    public final BorderStyles m766copyD5KLDUw(float f3, ColorStyles colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        return new BorderStyles(f3, colors, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderStyles)) {
            return false;
        }
        BorderStyles borderStyles = (BorderStyles) obj;
        return Dp.i(this.width, borderStyles.width) && Intrinsics.areEqual(this.colors, borderStyles.colors);
    }

    public final /* synthetic */ ColorStyles getColors() {
        return this.colors;
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m767getWidthD9Ej5fM() {
        return this.width;
    }

    public int hashCode() {
        return (Dp.j(this.width) * 31) + this.colors.hashCode();
    }

    public String toString() {
        return "BorderStyles(width=" + ((Object) Dp.k(this.width)) + ", colors=" + this.colors + ')';
    }

    private BorderStyles(float f3, ColorStyles colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.width = f3;
        this.colors = colors;
    }
}
