package com.revenuecat.purchases.ui.revenuecatui.templates;

import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionFactoriesKt;
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
public final class TemplatePackageRowInteractionKt {
    public static final void trackTemplatePackageRowSelectionIfChanged(PaywallViewModel paywallViewModel, PaywallState.Loaded.Legacy state, TemplateConfiguration.PackageInfo packageInfo, TemplateConfiguration.PackageInfo defaultPackageInfo) {
        Intrinsics.checkNotNullParameter(paywallViewModel, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(packageInfo, "packageInfo");
        Intrinsics.checkNotNullParameter(defaultPackageInfo, "defaultPackageInfo");
        TemplateConfiguration.PackageInfo packageInfo2 = (TemplateConfiguration.PackageInfo) state.getSelectedPackage().getValue();
        Package rcPackage = packageInfo2 != null ? packageInfo2.getRcPackage() : null;
        Package rcPackage2 = packageInfo.getRcPackage();
        if (Intrinsics.areEqual(rcPackage != null ? rcPackage.getIdentifier() : null, rcPackage2.getIdentifier())) {
            return;
        }
        paywallViewModel.trackComponentInteraction(PaywallComponentInteractionFactoriesKt.paywallPackageRowSelection(null, rcPackage2, rcPackage, defaultPackageInfo.getRcPackage()));
    }

    public static /* synthetic */ void trackTemplatePackageRowSelectionIfChanged$default(PaywallViewModel paywallViewModel, PaywallState.Loaded.Legacy legacy, TemplateConfiguration.PackageInfo packageInfo, TemplateConfiguration.PackageInfo packageInfo2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            packageInfo2 = legacy.getTemplateConfiguration().getPackages().getDefault();
        }
        trackTemplatePackageRowSelectionIfChanged(paywallViewModel, legacy, packageInfo, packageInfo2);
    }
}
