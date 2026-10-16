package com.revenuecat.purchases.ui.revenuecatui.components.image;

import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

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
final class PreviewParametersProvider implements PreviewParameterProvider<PreviewParameters> {
    private final Sequence<PreviewParameters> values;

    public PreviewParametersProvider() {
        Size size = new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fixed(200, null));
        FitMode fitMode = FitMode.FILL;
        PreviewParameters previewParameters = new PreviewParameters(100, 100, size, fitMode, null);
        Size size2 = new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fixed(200, null));
        FitMode fitMode2 = FitMode.FIT;
        PreviewParameters previewParameters2 = new PreviewParameters(100, 100, size2, fitMode2, null);
        PreviewParameters previewParameters3 = new PreviewParameters(100, 100, new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fixed(50, null)), fitMode, null);
        PreviewParameters previewParameters4 = new PreviewParameters(100, 100, new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fixed(50, null)), fitMode2, null);
        PreviewParameters previewParameters5 = new PreviewParameters(100, 100, new Size(new SizeConstraint.Fixed(50, null), new SizeConstraint.Fixed(200, null)), fitMode, null);
        PreviewParameters previewParameters6 = new PreviewParameters(100, 100, new Size(new SizeConstraint.Fixed(50, null), new SizeConstraint.Fixed(200, null)), fitMode2, null);
        SizeConstraint.Fixed fixed = new SizeConstraint.Fixed(72, null);
        SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
        PreviewParameters previewParameters7 = new PreviewParameters(100, 100, new Size(fixed, fit), fitMode, null);
        PreviewParameters previewParameters8 = new PreviewParameters(100, 100, new Size(fit, new SizeConstraint.Fixed(72, null)), fitMode, null);
        SizeConstraint.Fill fill = SizeConstraint.Fill.INSTANCE;
        this.values = SequencesKt.m(previewParameters, previewParameters2, previewParameters3, previewParameters4, previewParameters5, previewParameters6, previewParameters7, previewParameters8, new PreviewParameters(1909, 1306, new Size(fill, fit), fitMode2, null), new PreviewParameters(1306, 1909, new Size(fit, fill), fitMode2, null));
    }

    @Override // androidx.compose.ui.tooling.preview.PreviewParameterProvider
    public /* bridge */ /* synthetic */ int getCount() {
        return super.getCount();
    }

    @Override // androidx.compose.ui.tooling.preview.PreviewParameterProvider
    public Sequence<PreviewParameters> getValues() {
        return this.values;
    }
}
