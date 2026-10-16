package com.revenuecat.purchases.ui.revenuecatui.components.state;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PackageAwareDelegate {
    public static final int $stable = 8;
    private final State isSelected$delegate;
    private final State offerEligibility$delegate;
    private final Function0<OfferEligibility> selectedOfferEligibilityProvider;
    private final Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider;
    private final Function0<Integer> selectedTabIndexProvider;
    private final PackageContext style;

    /* JADX WARN: Multi-variable type inference failed */
    public PackageAwareDelegate(PackageContext style, Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider, Function0<Integer> selectedTabIndexProvider, Function0<? extends OfferEligibility> selectedOfferEligibilityProvider) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(selectedPackageInfoProvider, "selectedPackageInfoProvider");
        Intrinsics.checkNotNullParameter(selectedTabIndexProvider, "selectedTabIndexProvider");
        Intrinsics.checkNotNullParameter(selectedOfferEligibilityProvider, "selectedOfferEligibilityProvider");
        this.style = style;
        this.selectedPackageInfoProvider = selectedPackageInfoProvider;
        this.selectedTabIndexProvider = selectedTabIndexProvider;
        this.selectedOfferEligibilityProvider = selectedOfferEligibilityProvider;
        this.isSelected$delegate = SnapshotStateKt.e(new Function0<Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.state.PackageAwareDelegate.isSelected.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(PackageAwareDelegate.this.style.computeIsSelected((PaywallState.Loaded.Components.SelectedPackageInfo) PackageAwareDelegate.this.selectedPackageInfoProvider.invoke(), ((Number) PackageAwareDelegate.this.selectedTabIndexProvider.invoke()).intValue()));
            }
        });
        this.offerEligibility$delegate = SnapshotStateKt.e(new Function0<OfferEligibility>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.state.PackageAwareDelegate$offerEligibility$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final OfferEligibility invoke() {
                return this.this$0.style.resolveOfferEligibility((OfferEligibility) this.this$0.selectedOfferEligibilityProvider.invoke());
            }
        });
    }

    public final OfferEligibility getOfferEligibility() {
        return (OfferEligibility) this.offerEligibility$delegate.getValue();
    }

    public final boolean isSelected() {
        return ((Boolean) this.isSelected$delegate.getValue()).booleanValue();
    }
}
