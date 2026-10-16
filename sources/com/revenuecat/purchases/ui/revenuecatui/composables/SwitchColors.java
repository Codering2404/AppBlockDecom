package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.ui.graphics.Color;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
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
public final class SwitchColors {
    public static final int $stable = 0;
    private final ColorStyle checkedBorderColor;
    private final long checkedIconColor;
    private final ColorStyle checkedThumbColor;
    private final ColorStyle checkedTrackColor;
    private final ColorStyle disabledCheckedBorderColor;
    private final long disabledCheckedIconColor;
    private final ColorStyle disabledCheckedThumbColor;
    private final ColorStyle disabledCheckedTrackColor;
    private final ColorStyle disabledUncheckedBorderColor;
    private final long disabledUncheckedIconColor;
    private final ColorStyle disabledUncheckedThumbColor;
    private final ColorStyle disabledUncheckedTrackColor;
    private final ColorStyle uncheckedBorderColor;
    private final long uncheckedIconColor;
    private final ColorStyle uncheckedThumbColor;
    private final ColorStyle uncheckedTrackColor;

    public /* synthetic */ SwitchColors(ColorStyle colorStyle, ColorStyle colorStyle2, ColorStyle colorStyle3, long j3, ColorStyle colorStyle4, ColorStyle colorStyle5, ColorStyle colorStyle6, long j4, ColorStyle colorStyle7, ColorStyle colorStyle8, ColorStyle colorStyle9, long j5, ColorStyle colorStyle10, ColorStyle colorStyle11, ColorStyle colorStyle12, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorStyle, colorStyle2, colorStyle3, j3, colorStyle4, colorStyle5, colorStyle6, j4, colorStyle7, colorStyle8, colorStyle9, j5, colorStyle10, colorStyle11, colorStyle12, j6);
    }

    public final ColorStyle borderColor$revenuecatui_defaultsBc8Release(boolean z2, boolean z3) {
        return z2 ? z3 ? this.checkedBorderColor : this.uncheckedBorderColor : z3 ? this.disabledCheckedBorderColor : this.disabledUncheckedBorderColor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwitchColors)) {
            return false;
        }
        SwitchColors switchColors = (SwitchColors) obj;
        return Intrinsics.areEqual(this.checkedThumbColor, switchColors.checkedThumbColor) && Intrinsics.areEqual(this.checkedTrackColor, switchColors.checkedTrackColor) && Intrinsics.areEqual(this.checkedBorderColor, switchColors.checkedBorderColor) && Color.t(this.checkedIconColor, switchColors.checkedIconColor) && Intrinsics.areEqual(this.uncheckedThumbColor, switchColors.uncheckedThumbColor) && Intrinsics.areEqual(this.uncheckedTrackColor, switchColors.uncheckedTrackColor) && Intrinsics.areEqual(this.uncheckedBorderColor, switchColors.uncheckedBorderColor) && Color.t(this.uncheckedIconColor, switchColors.uncheckedIconColor) && Intrinsics.areEqual(this.disabledCheckedThumbColor, switchColors.disabledCheckedThumbColor) && Intrinsics.areEqual(this.disabledCheckedTrackColor, switchColors.disabledCheckedTrackColor) && Intrinsics.areEqual(this.disabledCheckedBorderColor, switchColors.disabledCheckedBorderColor) && Color.t(this.disabledCheckedIconColor, switchColors.disabledCheckedIconColor) && Intrinsics.areEqual(this.disabledUncheckedThumbColor, switchColors.disabledUncheckedThumbColor) && Intrinsics.areEqual(this.disabledUncheckedTrackColor, switchColors.disabledUncheckedTrackColor) && Intrinsics.areEqual(this.disabledUncheckedBorderColor, switchColors.disabledUncheckedBorderColor) && Color.t(this.disabledUncheckedIconColor, switchColors.disabledUncheckedIconColor);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((this.checkedThumbColor.hashCode() * 31) + this.checkedTrackColor.hashCode()) * 31) + this.checkedBorderColor.hashCode()) * 31) + Color.z(this.checkedIconColor)) * 31) + this.uncheckedThumbColor.hashCode()) * 31) + this.uncheckedTrackColor.hashCode()) * 31) + this.uncheckedBorderColor.hashCode()) * 31) + Color.z(this.uncheckedIconColor)) * 31) + this.disabledCheckedThumbColor.hashCode()) * 31) + this.disabledCheckedTrackColor.hashCode()) * 31) + this.disabledCheckedBorderColor.hashCode()) * 31) + Color.z(this.disabledCheckedIconColor)) * 31) + this.disabledUncheckedThumbColor.hashCode()) * 31) + this.disabledUncheckedTrackColor.hashCode()) * 31) + this.disabledUncheckedBorderColor.hashCode()) * 31) + Color.z(this.disabledUncheckedIconColor);
    }

    /* JADX INFO: renamed from: iconColor-WaAFU9c$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final long m931iconColorWaAFU9c$revenuecatui_defaultsBc8Release(boolean z2, boolean z3) {
        return z2 ? z3 ? this.checkedIconColor : this.uncheckedIconColor : z3 ? this.disabledCheckedIconColor : this.disabledUncheckedIconColor;
    }

    public final ColorStyle thumbColor$revenuecatui_defaultsBc8Release(boolean z2, boolean z3) {
        return z2 ? z3 ? this.checkedThumbColor : this.uncheckedThumbColor : z3 ? this.disabledCheckedThumbColor : this.disabledUncheckedThumbColor;
    }

    public String toString() {
        return "SwitchColors(checkedThumbColor=" + this.checkedThumbColor + ", checkedTrackColor=" + this.checkedTrackColor + ", checkedBorderColor=" + this.checkedBorderColor + ", checkedIconColor=" + ((Object) Color.A(this.checkedIconColor)) + ", uncheckedThumbColor=" + this.uncheckedThumbColor + ", uncheckedTrackColor=" + this.uncheckedTrackColor + ", uncheckedBorderColor=" + this.uncheckedBorderColor + ", uncheckedIconColor=" + ((Object) Color.A(this.uncheckedIconColor)) + ", disabledCheckedThumbColor=" + this.disabledCheckedThumbColor + ", disabledCheckedTrackColor=" + this.disabledCheckedTrackColor + ", disabledCheckedBorderColor=" + this.disabledCheckedBorderColor + ", disabledCheckedIconColor=" + ((Object) Color.A(this.disabledCheckedIconColor)) + ", disabledUncheckedThumbColor=" + this.disabledUncheckedThumbColor + ", disabledUncheckedTrackColor=" + this.disabledUncheckedTrackColor + ", disabledUncheckedBorderColor=" + this.disabledUncheckedBorderColor + ", disabledUncheckedIconColor=" + ((Object) Color.A(this.disabledUncheckedIconColor)) + ')';
    }

    public final ColorStyle trackColor$revenuecatui_defaultsBc8Release(boolean z2, boolean z3) {
        return z2 ? z3 ? this.checkedTrackColor : this.uncheckedTrackColor : z3 ? this.disabledCheckedTrackColor : this.disabledUncheckedTrackColor;
    }

    private SwitchColors(ColorStyle checkedThumbColor, ColorStyle checkedTrackColor, ColorStyle checkedBorderColor, long j3, ColorStyle uncheckedThumbColor, ColorStyle uncheckedTrackColor, ColorStyle uncheckedBorderColor, long j4, ColorStyle disabledCheckedThumbColor, ColorStyle disabledCheckedTrackColor, ColorStyle disabledCheckedBorderColor, long j5, ColorStyle disabledUncheckedThumbColor, ColorStyle disabledUncheckedTrackColor, ColorStyle disabledUncheckedBorderColor, long j6) {
        Intrinsics.checkNotNullParameter(checkedThumbColor, "checkedThumbColor");
        Intrinsics.checkNotNullParameter(checkedTrackColor, "checkedTrackColor");
        Intrinsics.checkNotNullParameter(checkedBorderColor, "checkedBorderColor");
        Intrinsics.checkNotNullParameter(uncheckedThumbColor, "uncheckedThumbColor");
        Intrinsics.checkNotNullParameter(uncheckedTrackColor, "uncheckedTrackColor");
        Intrinsics.checkNotNullParameter(uncheckedBorderColor, "uncheckedBorderColor");
        Intrinsics.checkNotNullParameter(disabledCheckedThumbColor, "disabledCheckedThumbColor");
        Intrinsics.checkNotNullParameter(disabledCheckedTrackColor, "disabledCheckedTrackColor");
        Intrinsics.checkNotNullParameter(disabledCheckedBorderColor, "disabledCheckedBorderColor");
        Intrinsics.checkNotNullParameter(disabledUncheckedThumbColor, "disabledUncheckedThumbColor");
        Intrinsics.checkNotNullParameter(disabledUncheckedTrackColor, "disabledUncheckedTrackColor");
        Intrinsics.checkNotNullParameter(disabledUncheckedBorderColor, "disabledUncheckedBorderColor");
        this.checkedThumbColor = checkedThumbColor;
        this.checkedTrackColor = checkedTrackColor;
        this.checkedBorderColor = checkedBorderColor;
        this.checkedIconColor = j3;
        this.uncheckedThumbColor = uncheckedThumbColor;
        this.uncheckedTrackColor = uncheckedTrackColor;
        this.uncheckedBorderColor = uncheckedBorderColor;
        this.uncheckedIconColor = j4;
        this.disabledCheckedThumbColor = disabledCheckedThumbColor;
        this.disabledCheckedTrackColor = disabledCheckedTrackColor;
        this.disabledCheckedBorderColor = disabledCheckedBorderColor;
        this.disabledCheckedIconColor = j5;
        this.disabledUncheckedThumbColor = disabledUncheckedThumbColor;
        this.disabledUncheckedTrackColor = disabledUncheckedTrackColor;
        this.disabledUncheckedBorderColor = disabledUncheckedBorderColor;
        this.disabledUncheckedIconColor = j6;
    }
}
