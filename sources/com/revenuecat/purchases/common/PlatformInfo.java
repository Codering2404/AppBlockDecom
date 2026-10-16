package com.revenuecat.purchases.common;

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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class PlatformInfo {
    private final String flavor;
    private final String version;

    public PlatformInfo(String flavor, String str) {
        Intrinsics.checkNotNullParameter(flavor, "flavor");
        this.flavor = flavor;
        this.version = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlatformInfo)) {
            return false;
        }
        PlatformInfo platformInfo = (PlatformInfo) obj;
        return Intrinsics.areEqual(this.flavor, platformInfo.flavor) && Intrinsics.areEqual(this.version, platformInfo.version);
    }

    public final String getFlavor() {
        return this.flavor;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iHashCode = this.flavor.hashCode() * 31;
        String str = this.version;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "PlatformInfo(flavor=" + this.flavor + ", version=" + this.version + ')';
    }
}
