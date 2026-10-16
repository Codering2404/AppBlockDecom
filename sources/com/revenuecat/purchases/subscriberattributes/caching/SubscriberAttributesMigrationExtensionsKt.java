package com.revenuecat.purchases.subscriberattributes.caching;

import android.content.SharedPreferences;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttribute;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesFactoriesKt;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

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
public final class SubscriberAttributesMigrationExtensionsKt {
    public static final synchronized Map<String, Map<String, SubscriberAttribute>> getAllLegacyStoredSubscriberAttributes(SubscriberAttributesCache subscriberAttributesCache) {
        LinkedHashMap linkedHashMap;
        Map<String, SubscriberAttribute> mapEmptyMap;
        try {
            Intrinsics.checkNotNullParameter(subscriberAttributesCache, "<this>");
            String strLegacySubscriberAttributesCacheKey = legacySubscriberAttributesCacheKey(subscriberAttributesCache, "");
            Set<String> setFindKeysThatStartWith$purchases_defaultsBc8Release = subscriberAttributesCache.getDeviceCache$purchases_defaultsBc8Release().findKeysThatStartWith$purchases_defaultsBc8Release(strLegacySubscriberAttributesCacheKey);
            linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setFindKeysThatStartWith$purchases_defaultsBc8Release, 10)), 16));
            for (String str : setFindKeysThatStartWith$purchases_defaultsBc8Release) {
                String str2 = (String) StringsKt.V0(str, new String[]{strLegacySubscriberAttributesCacheKey}, false, 0, 6, null).get(1);
                JSONObject jSONObjectOrNull$purchases_defaultsBc8Release = subscriberAttributesCache.getDeviceCache$purchases_defaultsBc8Release().getJSONObjectOrNull$purchases_defaultsBc8Release(str);
                if (jSONObjectOrNull$purchases_defaultsBc8Release == null || (mapEmptyMap = SubscriberAttributesFactoriesKt.buildLegacySubscriberAttributes(jSONObjectOrNull$purchases_defaultsBc8Release)) == null) {
                    mapEmptyMap = MapsKt.emptyMap();
                }
                Pair pairA = TuplesKt.a(str2, mapEmptyMap);
                linkedHashMap.put(pairA.e(), pairA.f());
            }
        } catch (Throwable th) {
            throw th;
        }
        return linkedHashMap;
    }

    public static final String legacySubscriberAttributesCacheKey(SubscriberAttributesCache subscriberAttributesCache, String appUserID) {
        Intrinsics.checkNotNullParameter(subscriberAttributesCache, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        return subscriberAttributesCache.getSubscriberAttributesCacheKey$purchases_defaultsBc8Release() + '.' + appUserID;
    }

    public static final synchronized void migrateSubscriberAttributes(SubscriberAttributesCache subscriberAttributesCache, Map<String, ? extends Map<String, SubscriberAttribute>> legacySubscriberAttributesForAppUserID, SharedPreferences.Editor cacheEditor) {
        try {
            Intrinsics.checkNotNullParameter(subscriberAttributesCache, "<this>");
            Intrinsics.checkNotNullParameter(legacySubscriberAttributesForAppUserID, "legacySubscriberAttributesForAppUserID");
            Intrinsics.checkNotNullParameter(cacheEditor, "cacheEditor");
            Map<String, Map<String, SubscriberAttribute>> allStoredSubscriberAttributes = subscriberAttributesCache.getAllStoredSubscriberAttributes();
            Map mutableMap = MapsKt.toMutableMap(allStoredSubscriberAttributes);
            for (Map.Entry<String, ? extends Map<String, SubscriberAttribute>> entry : legacySubscriberAttributesForAppUserID.entrySet()) {
                String key = entry.getKey();
                Map<String, SubscriberAttribute> value = entry.getValue();
                Map<String, SubscriberAttribute> mapEmptyMap = allStoredSubscriberAttributes.get(key);
                if (mapEmptyMap == null) {
                    mapEmptyMap = MapsKt.emptyMap();
                }
                mutableMap.put(key, MapsKt.plus(value, mapEmptyMap));
                cacheEditor.remove(legacySubscriberAttributesCacheKey(subscriberAttributesCache, key));
            }
            cacheEditor.putString(subscriberAttributesCache.getSubscriberAttributesCacheKey$purchases_defaultsBc8Release(), CachingHelpersKt.toJSONObject(mutableMap).toString());
        } catch (Throwable th) {
            throw th;
        }
    }

    public static final synchronized void migrateSubscriberAttributesIfNeeded(SubscriberAttributesCache subscriberAttributesCache, SharedPreferences.Editor cacheEditor) {
        Intrinsics.checkNotNullParameter(subscriberAttributesCache, "<this>");
        Intrinsics.checkNotNullParameter(cacheEditor, "cacheEditor");
        Map<String, Map<String, SubscriberAttribute>> allLegacyStoredSubscriberAttributes = getAllLegacyStoredSubscriberAttributes(subscriberAttributesCache);
        if (allLegacyStoredSubscriberAttributes.isEmpty()) {
            allLegacyStoredSubscriberAttributes = null;
        }
        if (allLegacyStoredSubscriberAttributes != null) {
            migrateSubscriberAttributes(subscriberAttributesCache, allLegacyStoredSubscriberAttributes, cacheEditor);
        }
    }
}
