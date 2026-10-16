package com.revenuecat.purchases.ui.revenuecatui.customercenter;

import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterState;
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
final class CustomerCenterScaffoldConfig {
    private final CustomerCenterState.NavigationButtonType navigationButtonType;
    private final boolean shouldUseLargeTopBar;
    private final String title;

    public CustomerCenterScaffoldConfig(String str, boolean z2, CustomerCenterState.NavigationButtonType navigationButtonType) {
        Intrinsics.checkNotNullParameter(navigationButtonType, "navigationButtonType");
        this.title = str;
        this.shouldUseLargeTopBar = z2;
        this.navigationButtonType = navigationButtonType;
    }

    public static /* synthetic */ CustomerCenterScaffoldConfig copy$default(CustomerCenterScaffoldConfig customerCenterScaffoldConfig, String str, boolean z2, CustomerCenterState.NavigationButtonType navigationButtonType, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = customerCenterScaffoldConfig.title;
        }
        if ((i3 & 2) != 0) {
            z2 = customerCenterScaffoldConfig.shouldUseLargeTopBar;
        }
        if ((i3 & 4) != 0) {
            navigationButtonType = customerCenterScaffoldConfig.navigationButtonType;
        }
        return customerCenterScaffoldConfig.copy(str, z2, navigationButtonType);
    }

    public final String component1() {
        return this.title;
    }

    public final boolean component2() {
        return this.shouldUseLargeTopBar;
    }

    public final CustomerCenterState.NavigationButtonType component3() {
        return this.navigationButtonType;
    }

    public final CustomerCenterScaffoldConfig copy(String str, boolean z2, CustomerCenterState.NavigationButtonType navigationButtonType) {
        Intrinsics.checkNotNullParameter(navigationButtonType, "navigationButtonType");
        return new CustomerCenterScaffoldConfig(str, z2, navigationButtonType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomerCenterScaffoldConfig)) {
            return false;
        }
        CustomerCenterScaffoldConfig customerCenterScaffoldConfig = (CustomerCenterScaffoldConfig) obj;
        return Intrinsics.areEqual(this.title, customerCenterScaffoldConfig.title) && this.shouldUseLargeTopBar == customerCenterScaffoldConfig.shouldUseLargeTopBar && this.navigationButtonType == customerCenterScaffoldConfig.navigationButtonType;
    }

    public final CustomerCenterState.NavigationButtonType getNavigationButtonType() {
        return this.navigationButtonType;
    }

    public final boolean getShouldUseLargeTopBar() {
        return this.shouldUseLargeTopBar;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        return ((((str == null ? 0 : str.hashCode()) * 31) + Boolean.hashCode(this.shouldUseLargeTopBar)) * 31) + this.navigationButtonType.hashCode();
    }

    public String toString() {
        return "CustomerCenterScaffoldConfig(title=" + this.title + ", shouldUseLargeTopBar=" + this.shouldUseLargeTopBar + ", navigationButtonType=" + this.navigationButtonType + ')';
    }
}
