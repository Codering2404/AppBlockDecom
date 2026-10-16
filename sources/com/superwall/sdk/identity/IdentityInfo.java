package com.superwall.sdk.identity;

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
public final class IdentityInfo {
    private final String aliasId;
    private final String appUserId;

    public IdentityInfo(String aliasId, String str) {
        Intrinsics.checkNotNullParameter(aliasId, "aliasId");
        this.aliasId = aliasId;
        this.appUserId = str;
    }

    public static /* synthetic */ IdentityInfo copy$default(IdentityInfo identityInfo, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = identityInfo.aliasId;
        }
        if ((i3 & 2) != 0) {
            str2 = identityInfo.appUserId;
        }
        return identityInfo.copy(str, str2);
    }

    public final String component1() {
        return this.aliasId;
    }

    public final String component2() {
        return this.appUserId;
    }

    public final IdentityInfo copy(String aliasId, String str) {
        Intrinsics.checkNotNullParameter(aliasId, "aliasId");
        return new IdentityInfo(aliasId, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IdentityInfo)) {
            return false;
        }
        IdentityInfo identityInfo = (IdentityInfo) obj;
        return Intrinsics.areEqual(this.aliasId, identityInfo.aliasId) && Intrinsics.areEqual(this.appUserId, identityInfo.appUserId);
    }

    public final String getAliasId() {
        return this.aliasId;
    }

    public final String getAppUserId() {
        return this.appUserId;
    }

    public int hashCode() {
        int iHashCode = this.aliasId.hashCode() * 31;
        String str = this.appUserId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "IdentityInfo(aliasId=" + this.aliasId + ", appUserId=" + this.appUserId + ")";
    }
}
