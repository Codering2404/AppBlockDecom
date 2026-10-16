package com.revenuecat.purchases.common.offerings;

import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LocaleProvider;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.caching.InMemoryCachedObject;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class OfferingsCache {
    public static final Companion Companion = new Companion(null);
    public static final String ORIGINAL_SOURCE_KEY = "rc_original_source";
    private String cachedLanguageTags;
    private final DateProvider dateProvider;
    private final DeviceCache deviceCache;
    private final LocaleProvider localeProvider;
    private final InMemoryCachedObject<Offerings> offeringsCachedObject;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public OfferingsCache(DeviceCache deviceCache, DateProvider dateProvider, InMemoryCachedObject<Offerings> offeringsCachedObject, LocaleProvider localeProvider) {
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(offeringsCachedObject, "offeringsCachedObject");
        Intrinsics.checkNotNullParameter(localeProvider, "localeProvider");
        this.deviceCache = deviceCache;
        this.dateProvider = dateProvider;
        this.offeringsCachedObject = offeringsCachedObject;
        this.localeProvider = localeProvider;
    }

    public final synchronized void cacheOfferings(Offerings offerings, JSONObject offeringsResponse) {
        Intrinsics.checkNotNullParameter(offerings, "offerings");
        Intrinsics.checkNotNullParameter(offeringsResponse, "offeringsResponse");
        JSONObject jSONObjectCopy = JSONObjectExtensionsKt.copy(offeringsResponse, false);
        jSONObjectCopy.put(ORIGINAL_SOURCE_KEY, offerings.getOriginalSource$purchases_defaultsBc8Release());
        this.offeringsCachedObject.cacheInstance(offerings);
        this.deviceCache.cacheOfferingsResponse$purchases_defaultsBc8Release(jSONObjectCopy);
        this.offeringsCachedObject.updateCacheTimestamp(this.dateProvider.getNow());
        char[] charArray = this.localeProvider.getCurrentLocalesLanguageTags().toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        this.cachedLanguageTags = new String(charArray);
    }

    public final synchronized void clearCache() {
        this.offeringsCachedObject.clearCache();
        this.deviceCache.clearOfferingsResponseCache$purchases_defaultsBc8Release();
        this.cachedLanguageTags = null;
    }

    public final synchronized void clearInMemoryOfferingsCache() {
        this.offeringsCachedObject.clearCache();
        this.cachedLanguageTags = null;
    }

    public final synchronized void forceCacheStale() {
        this.offeringsCachedObject.clearCacheTimestamp();
        this.cachedLanguageTags = null;
    }

    public final synchronized Offerings getCachedOfferings() {
        return this.offeringsCachedObject.getCachedInstance();
    }

    public final synchronized JSONObject getCachedOfferingsResponse() {
        return this.deviceCache.getOfferingsResponseCache$purchases_defaultsBc8Release();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized boolean isOfferingsCacheStale(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.revenuecat.purchases.common.caching.InMemoryCachedObject<com.revenuecat.purchases.Offerings> r0 = r2.offeringsCachedObject     // Catch: java.lang.Throwable -> L20
            java.util.Date r0 = r0.getLastUpdatedAt$purchases_defaultsBc8Release()     // Catch: java.lang.Throwable -> L20
            com.revenuecat.purchases.common.DateProvider r1 = r2.dateProvider     // Catch: java.lang.Throwable -> L20
            boolean r3 = com.revenuecat.purchases.common.caching.DateExtensionsKt.isCacheStale(r0, r3, r1)     // Catch: java.lang.Throwable -> L20
            if (r3 != 0) goto L22
            java.lang.String r3 = r2.cachedLanguageTags     // Catch: java.lang.Throwable -> L20
            com.revenuecat.purchases.common.LocaleProvider r0 = r2.localeProvider     // Catch: java.lang.Throwable -> L20
            java.lang.String r0 = r0.getCurrentLocalesLanguageTags()     // Catch: java.lang.Throwable -> L20
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r0)     // Catch: java.lang.Throwable -> L20
            if (r3 != 0) goto L1e
            goto L22
        L1e:
            r3 = 0
            goto L23
        L20:
            r3 = move-exception
            goto L25
        L22:
            r3 = 1
        L23:
            monitor-exit(r2)
            return r3
        L25:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.offerings.OfferingsCache.isOfferingsCacheStale(boolean):boolean");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ OfferingsCache(DeviceCache deviceCache, DateProvider dateProvider, InMemoryCachedObject inMemoryCachedObject, LocaleProvider localeProvider, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        dateProvider = (i3 & 2) != 0 ? new DefaultDateProvider() : dateProvider;
        this(deviceCache, dateProvider, (i3 & 4) != 0 ? new InMemoryCachedObject(null, dateProvider, 1, null) : inMemoryCachedObject, localeProvider);
    }
}
