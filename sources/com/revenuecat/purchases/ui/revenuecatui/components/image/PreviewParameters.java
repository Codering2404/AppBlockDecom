package com.revenuecat.purchases.ui.revenuecatui.components.image;

import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.Size;
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
final class PreviewParameters {
    private final FitMode fitMode;
    private final int imageHeight;
    private final int imageWidth;
    private final Size viewSize;

    public /* synthetic */ PreviewParameters(int i3, int i4, Size size, FitMode fitMode, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i4, size, fitMode);
    }

    public final FitMode getFitMode() {
        return this.fitMode;
    }

    /* JADX INFO: renamed from: getImageHeight-pVg5ArA, reason: not valid java name */
    public final int m722getImageHeightpVg5ArA() {
        return this.imageHeight;
    }

    /* JADX INFO: renamed from: getImageWidth-pVg5ArA, reason: not valid java name */
    public final int m723getImageWidthpVg5ArA() {
        return this.imageWidth;
    }

    public final Size getViewSize() {
        return this.viewSize;
    }

    private PreviewParameters(int i3, int i4, Size viewSize, FitMode fitMode) {
        Intrinsics.checkNotNullParameter(viewSize, "viewSize");
        Intrinsics.checkNotNullParameter(fitMode, "fitMode");
        this.imageWidth = i3;
        this.imageHeight = i4;
        this.viewSize = viewSize;
        this.fitMode = fitMode;
    }
}
