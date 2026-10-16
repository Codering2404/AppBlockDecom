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
final class ScaffoldConfigData {
    private final CustomerCenterState.NavigationButtonType navigationButtonType;
    private final boolean shouldUseLargeTopBar;
    private final String title;

    public ScaffoldConfigData(String str, CustomerCenterState.NavigationButtonType navigationButtonType, boolean z2) {
        Intrinsics.checkNotNullParameter(navigationButtonType, "navigationButtonType");
        this.title = str;
        this.navigationButtonType = navigationButtonType;
        this.shouldUseLargeTopBar = z2;
    }

    public static /* synthetic */ ScaffoldConfigData copy$default(ScaffoldConfigData scaffoldConfigData, String str, CustomerCenterState.NavigationButtonType navigationButtonType, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = scaffoldConfigData.title;
        }
        if ((i3 & 2) != 0) {
            navigationButtonType = scaffoldConfigData.navigationButtonType;
        }
        if ((i3 & 4) != 0) {
            z2 = scaffoldConfigData.shouldUseLargeTopBar;
        }
        return scaffoldConfigData.copy(str, navigationButtonType, z2);
    }

    public final String component1() {
        return this.title;
    }

    public final CustomerCenterState.NavigationButtonType component2() {
        return this.navigationButtonType;
    }

    public final boolean component3() {
        return this.shouldUseLargeTopBar;
    }

    public final ScaffoldConfigData copy(String str, CustomerCenterState.NavigationButtonType navigationButtonType, boolean z2) {
        Intrinsics.checkNotNullParameter(navigationButtonType, "navigationButtonType");
        return new ScaffoldConfigData(str, navigationButtonType, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScaffoldConfigData)) {
            return false;
        }
        ScaffoldConfigData scaffoldConfigData = (ScaffoldConfigData) obj;
        return Intrinsics.areEqual(this.title, scaffoldConfigData.title) && this.navigationButtonType == scaffoldConfigData.navigationButtonType && this.shouldUseLargeTopBar == scaffoldConfigData.shouldUseLargeTopBar;
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
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.navigationButtonType.hashCode()) * 31) + Boolean.hashCode(this.shouldUseLargeTopBar);
    }

    public String toString() {
        return "ScaffoldConfigData(title=" + this.title + ", navigationButtonType=" + this.navigationButtonType + ", shouldUseLargeTopBar=" + this.shouldUseLargeTopBar + ')';
    }
}
