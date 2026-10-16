package com.revenuecat.purchases.common.caching;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;

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
public final class DeviceCacheKt {
    public static final int CUSTOMER_INFO_SCHEMA_VERSION = 3;
    private static final long PRODUCT_ENTITLEMENT_MAPPING_CACHE_REFRESH_PERIOD;
    private static final String SHARED_PREFERENCES_PREFIX = "com.revenuecat.purchases.";
    private static final KSerializer<Map<String, TokenCacheEntry>> tokenMapSerializer;

    static {
        Duration.Companion companion = Duration.f140631b;
        PRODUCT_ENTITLEMENT_MAPPING_CACHE_REFRESH_PERIOD = DurationKt.s(25, DurationUnit.f140643h);
        tokenMapSerializer = BuiltinSerializersKt.k(BuiltinSerializersKt.I(StringCompanionObject.f140150a), TokenCacheEntry.Companion.serializer());
    }
}
