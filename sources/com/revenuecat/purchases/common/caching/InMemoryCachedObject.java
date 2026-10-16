package com.revenuecat.purchases.common.caching;

import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class InMemoryCachedObject<T> {
    private T cachedInstance;
    private final DateProvider dateProvider;
    private Date lastUpdatedAt;

    /* JADX WARN: Multi-variable type inference failed */
    public InMemoryCachedObject() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final void cacheInstance(T t2) {
        this.cachedInstance = t2;
        this.lastUpdatedAt = this.dateProvider.getNow();
    }

    public final void clearCache() {
        clearCacheTimestamp();
        this.cachedInstance = null;
    }

    public final void clearCacheTimestamp() {
        this.lastUpdatedAt = null;
    }

    public final T getCachedInstance() {
        return this.cachedInstance;
    }

    public final Date getLastUpdatedAt$purchases_defaultsBc8Release() {
        return this.lastUpdatedAt;
    }

    public final void setCachedInstance(T t2) {
        this.cachedInstance = t2;
    }

    public final void setLastUpdatedAt$purchases_defaultsBc8Release(Date date) {
        this.lastUpdatedAt = date;
    }

    public final void updateCacheTimestamp(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        this.lastUpdatedAt = date;
    }

    public InMemoryCachedObject(Date date, DateProvider dateProvider) {
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.lastUpdatedAt = date;
        this.dateProvider = dateProvider;
    }

    public /* synthetic */ InMemoryCachedObject(Date date, DateProvider dateProvider, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : date, (i3 & 2) != 0 ? new DefaultDateProvider() : dateProvider);
    }
}
