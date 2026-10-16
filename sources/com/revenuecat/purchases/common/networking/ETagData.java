package com.revenuecat.purchases.common.networking;

import java.util.Date;
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
public final class ETagData {
    private final String eTag;
    private final Date lastRefreshTime;

    public ETagData(String eTag, Date date) {
        Intrinsics.checkNotNullParameter(eTag, "eTag");
        this.eTag = eTag;
        this.lastRefreshTime = date;
    }

    public static /* synthetic */ ETagData copy$default(ETagData eTagData, String str, Date date, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = eTagData.eTag;
        }
        if ((i3 & 2) != 0) {
            date = eTagData.lastRefreshTime;
        }
        return eTagData.copy(str, date);
    }

    public final String component1() {
        return this.eTag;
    }

    public final Date component2() {
        return this.lastRefreshTime;
    }

    public final ETagData copy(String eTag, Date date) {
        Intrinsics.checkNotNullParameter(eTag, "eTag");
        return new ETagData(eTag, date);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ETagData)) {
            return false;
        }
        ETagData eTagData = (ETagData) obj;
        return Intrinsics.areEqual(this.eTag, eTagData.eTag) && Intrinsics.areEqual(this.lastRefreshTime, eTagData.lastRefreshTime);
    }

    public final String getETag() {
        return this.eTag;
    }

    public final Date getLastRefreshTime() {
        return this.lastRefreshTime;
    }

    public int hashCode() {
        int iHashCode = this.eTag.hashCode() * 31;
        Date date = this.lastRefreshTime;
        return iHashCode + (date == null ? 0 : date.hashCode());
    }

    public String toString() {
        return "ETagData(eTag=" + this.eTag + ", lastRefreshTime=" + this.lastRefreshTime + ')';
    }
}
