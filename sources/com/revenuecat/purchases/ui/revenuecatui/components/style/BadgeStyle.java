package com.revenuecat.purchases.ui.revenuecatui.components.style;

import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.TwoDimensionalAlignment;
import kotlin.Metadata;
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
public final class BadgeStyle {
    public static final int $stable = 0;
    private final TwoDimensionalAlignment alignment;
    private final StackComponentStyle stackStyle;
    private final Badge.Style style;

    public BadgeStyle(StackComponentStyle stackStyle, Badge.Style style, TwoDimensionalAlignment alignment) {
        Intrinsics.checkNotNullParameter(stackStyle, "stackStyle");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        this.stackStyle = stackStyle;
        this.style = style;
        this.alignment = alignment;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BadgeStyle)) {
            return false;
        }
        BadgeStyle badgeStyle = (BadgeStyle) obj;
        return Intrinsics.areEqual(this.stackStyle, badgeStyle.stackStyle) && this.style == badgeStyle.style && this.alignment == badgeStyle.alignment;
    }

    public final /* synthetic */ TwoDimensionalAlignment getAlignment() {
        return this.alignment;
    }

    public final /* synthetic */ StackComponentStyle getStackStyle() {
        return this.stackStyle;
    }

    public final /* synthetic */ Badge.Style getStyle() {
        return this.style;
    }

    public int hashCode() {
        return (((this.stackStyle.hashCode() * 31) + this.style.hashCode()) * 31) + this.alignment.hashCode();
    }

    public String toString() {
        return "BadgeStyle(stackStyle=" + this.stackStyle + ", style=" + this.style + ", alignment=" + this.alignment + ')';
    }
}
