package com.revenuecat.purchases.ui.revenuecatui.data;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.revenuecat.purchases.ui.revenuecatui.PaywallModeKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.ProcessedLocalizedConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final class PaywallStateKt {
    public static final TemplateConfiguration.Colors getCurrentColors(PaywallState.Loaded.Legacy legacy, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(legacy, "<this>");
        if (ComposerKt.M()) {
            ComposerKt.U(779612430, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.data.<get-currentColors> (PaywallState.kt:424)");
        }
        TemplateConfiguration.Colors currentColors = legacy.getTemplateConfiguration().getCurrentColors(composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return currentColors;
    }

    public static final ProcessedLocalizedConfiguration getSelectedLocalization(PaywallState.Loaded.Legacy legacy) {
        Intrinsics.checkNotNullParameter(legacy, "<this>");
        return ((TemplateConfiguration.PackageInfo) legacy.getSelectedPackage().getValue()).getLocalization();
    }

    public static final boolean isInFullScreenMode(PaywallState.Loaded.Legacy legacy) {
        Intrinsics.checkNotNullParameter(legacy, "<this>");
        return PaywallModeKt.isFullScreen(legacy.getTemplateConfiguration().getMode());
    }

    public static final PaywallState.Loaded.Legacy loadedLegacy(PaywallState paywallState) {
        Intrinsics.checkNotNullParameter(paywallState, "<this>");
        if (paywallState instanceof PaywallState.Error) {
            return null;
        }
        if (!(paywallState instanceof PaywallState.Loaded)) {
            if (paywallState instanceof PaywallState.Loading) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }
        PaywallState.Loaded loaded = (PaywallState.Loaded) paywallState;
        if (loaded instanceof PaywallState.Loaded.Legacy) {
            return (PaywallState.Loaded.Legacy) paywallState;
        }
        if (loaded instanceof PaywallState.Loaded.Components) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
