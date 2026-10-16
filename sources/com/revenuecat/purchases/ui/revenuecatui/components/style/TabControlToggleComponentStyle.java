package com.revenuecat.purchases.ui.revenuecatui.components.style;

import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
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
public final class TabControlToggleComponentStyle implements ComponentStyle {
    public static final int $stable = 0;
    private final String componentName;
    private final Size size;
    private final ColorStyles thumbColorOff;
    private final ColorStyles thumbColorOn;
    private final ColorStyles trackColorOff;
    private final ColorStyles trackColorOn;
    private final boolean visible;

    public TabControlToggleComponentStyle(ColorStyles thumbColorOn, ColorStyles thumbColorOff, ColorStyles trackColorOn, ColorStyles trackColorOff, String str) {
        Intrinsics.checkNotNullParameter(thumbColorOn, "thumbColorOn");
        Intrinsics.checkNotNullParameter(thumbColorOff, "thumbColorOff");
        Intrinsics.checkNotNullParameter(trackColorOn, "trackColorOn");
        Intrinsics.checkNotNullParameter(trackColorOff, "trackColorOff");
        this.thumbColorOn = thumbColorOn;
        this.thumbColorOff = thumbColorOff;
        this.trackColorOn = trackColorOn;
        this.trackColorOff = trackColorOff;
        this.componentName = str;
        this.visible = true;
        SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
        this.size = new Size(fit, fit);
    }

    public final /* synthetic */ String getComponentName() {
        return this.componentName;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public Size getSize() {
        return this.size;
    }

    public final /* synthetic */ ColorStyles getThumbColorOff() {
        return this.thumbColorOff;
    }

    public final /* synthetic */ ColorStyles getThumbColorOn() {
        return this.thumbColorOn;
    }

    public final /* synthetic */ ColorStyles getTrackColorOff() {
        return this.trackColorOff;
    }

    public final /* synthetic */ ColorStyles getTrackColorOn() {
        return this.trackColorOn;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public boolean getVisible() {
        return this.visible;
    }

    public /* synthetic */ TabControlToggleComponentStyle(ColorStyles colorStyles, ColorStyles colorStyles2, ColorStyles colorStyles3, ColorStyles colorStyles4, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorStyles, colorStyles2, colorStyles3, colorStyles4, (i3 & 16) != 0 ? null : str);
    }
}
