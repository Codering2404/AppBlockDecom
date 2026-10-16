package com.revenuecat.purchases.models;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
final class StoreReplacementModeMapping {
    private final String galaxyBackendName;
    private final GoogleReplacementMode googleReplacementMode;
    private final String legacyPlayBackendName;
    private final int playBillingClientMode;

    public StoreReplacementModeMapping(int i3, String legacyPlayBackendName, String str, GoogleReplacementMode googleReplacementMode) {
        Intrinsics.checkNotNullParameter(legacyPlayBackendName, "legacyPlayBackendName");
        Intrinsics.checkNotNullParameter(googleReplacementMode, "googleReplacementMode");
        this.playBillingClientMode = i3;
        this.legacyPlayBackendName = legacyPlayBackendName;
        this.galaxyBackendName = str;
        this.googleReplacementMode = googleReplacementMode;
    }

    public static /* synthetic */ StoreReplacementModeMapping copy$default(StoreReplacementModeMapping storeReplacementModeMapping, int i3, String str, String str2, GoogleReplacementMode googleReplacementMode, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = storeReplacementModeMapping.playBillingClientMode;
        }
        if ((i4 & 2) != 0) {
            str = storeReplacementModeMapping.legacyPlayBackendName;
        }
        if ((i4 & 4) != 0) {
            str2 = storeReplacementModeMapping.galaxyBackendName;
        }
        if ((i4 & 8) != 0) {
            googleReplacementMode = storeReplacementModeMapping.googleReplacementMode;
        }
        return storeReplacementModeMapping.copy(i3, str, str2, googleReplacementMode);
    }

    public final int component1() {
        return this.playBillingClientMode;
    }

    public final String component2() {
        return this.legacyPlayBackendName;
    }

    public final String component3() {
        return this.galaxyBackendName;
    }

    public final GoogleReplacementMode component4() {
        return this.googleReplacementMode;
    }

    public final StoreReplacementModeMapping copy(int i3, String legacyPlayBackendName, String str, GoogleReplacementMode googleReplacementMode) {
        Intrinsics.checkNotNullParameter(legacyPlayBackendName, "legacyPlayBackendName");
        Intrinsics.checkNotNullParameter(googleReplacementMode, "googleReplacementMode");
        return new StoreReplacementModeMapping(i3, legacyPlayBackendName, str, googleReplacementMode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StoreReplacementModeMapping)) {
            return false;
        }
        StoreReplacementModeMapping storeReplacementModeMapping = (StoreReplacementModeMapping) obj;
        return this.playBillingClientMode == storeReplacementModeMapping.playBillingClientMode && Intrinsics.areEqual(this.legacyPlayBackendName, storeReplacementModeMapping.legacyPlayBackendName) && Intrinsics.areEqual(this.galaxyBackendName, storeReplacementModeMapping.galaxyBackendName) && this.googleReplacementMode == storeReplacementModeMapping.googleReplacementMode;
    }

    public final String getGalaxyBackendName() {
        return this.galaxyBackendName;
    }

    public final GoogleReplacementMode getGoogleReplacementMode() {
        return this.googleReplacementMode;
    }

    public final String getLegacyPlayBackendName() {
        return this.legacyPlayBackendName;
    }

    public final int getPlayBillingClientMode() {
        return this.playBillingClientMode;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.playBillingClientMode) * 31) + this.legacyPlayBackendName.hashCode()) * 31;
        String str = this.galaxyBackendName;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.googleReplacementMode.hashCode();
    }

    public String toString() {
        return "StoreReplacementModeMapping(playBillingClientMode=" + this.playBillingClientMode + ", legacyPlayBackendName=" + this.legacyPlayBackendName + ", galaxyBackendName=" + this.galaxyBackendName + ", googleReplacementMode=" + this.googleReplacementMode + ')';
    }
}
