package com.revenuecat.purchases.ui.revenuecatui.components.properties;

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
public final class ColorStyles {
    public static final int $stable = 0;
    private final ColorStyle dark;
    private final ColorStyle light;

    public ColorStyles(ColorStyle light, ColorStyle colorStyle) {
        Intrinsics.checkNotNullParameter(light, "light");
        this.light = light;
        this.dark = colorStyle;
    }

    public static /* synthetic */ ColorStyles copy$default(ColorStyles colorStyles, ColorStyle colorStyle, ColorStyle colorStyle2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            colorStyle = colorStyles.light;
        }
        if ((i3 & 2) != 0) {
            colorStyle2 = colorStyles.dark;
        }
        return colorStyles.copy(colorStyle, colorStyle2);
    }

    public final ColorStyle component1() {
        return this.light;
    }

    public final ColorStyle component2() {
        return this.dark;
    }

    public final ColorStyles copy(ColorStyle light, ColorStyle colorStyle) {
        Intrinsics.checkNotNullParameter(light, "light");
        return new ColorStyles(light, colorStyle);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ColorStyles)) {
            return false;
        }
        ColorStyles colorStyles = (ColorStyles) obj;
        return Intrinsics.areEqual(this.light, colorStyles.light) && Intrinsics.areEqual(this.dark, colorStyles.dark);
    }

    public final /* synthetic */ ColorStyle getDark() {
        return this.dark;
    }

    public final /* synthetic */ ColorStyle getLight() {
        return this.light;
    }

    public int hashCode() {
        int iHashCode = this.light.hashCode() * 31;
        ColorStyle colorStyle = this.dark;
        return iHashCode + (colorStyle == null ? 0 : colorStyle.hashCode());
    }

    public String toString() {
        return "ColorStyles(light=" + this.light + ", dark=" + this.dark + ')';
    }

    public /* synthetic */ ColorStyles(ColorStyle colorStyle, ColorStyle colorStyle2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorStyle, (i3 & 2) != 0 ? null : colorStyle2);
    }
}
