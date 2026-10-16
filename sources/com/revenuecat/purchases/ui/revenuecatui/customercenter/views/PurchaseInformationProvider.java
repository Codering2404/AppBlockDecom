package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigTestData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation;
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
final class PurchaseInformationProvider implements PreviewParameterProvider<PurchaseInformation> {
    private final Sequence<PurchaseInformation> values;

    public PurchaseInformationProvider() {
        CustomerCenterConfigTestData customerCenterConfigTestData = CustomerCenterConfigTestData.INSTANCE;
        this.values = SequencesKt.m(customerCenterConfigTestData.getPurchaseInformationMonthlyRenewing(), customerCenterConfigTestData.getPurchaseInformationYearlyExpiring(), customerCenterConfigTestData.getPurchaseInformationYearlyExpired(), customerCenterConfigTestData.getPurchaseInformationFreeTrial(), customerCenterConfigTestData.getPurchaseInformationPromotional(), customerCenterConfigTestData.getPurchaseInformationLifetime(), PurchaseInformation.copy$default(customerCenterConfigTestData.getPurchaseInformationMonthlyRenewing(), "Monthly long subscription name that overflows", null, null, null, null, false, null, false, false, false, false, 2046, null));
    }

    @Override // androidx.compose.ui.tooling.preview.PreviewParameterProvider
    public /* bridge */ /* synthetic */ int getCount() {
        return super.getCount();
    }

    @Override // androidx.compose.ui.tooling.preview.PreviewParameterProvider
    public Sequence<PurchaseInformation> getValues() {
        return this.values;
    }
}
