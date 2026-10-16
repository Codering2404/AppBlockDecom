package com.revenuecat.purchases.subscriberattributes.caching;

import android.content.SharedPreferences;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.strings.AttributionStrings;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttribute;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesFactoriesKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class SubscriberAttributesCache {
    private final DeviceCache deviceCache;
    private final Lazy subscriberAttributesCacheKey$delegate;

    public SubscriberAttributesCache(DeviceCache deviceCache) {
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        this.deviceCache = deviceCache;
        this.subscriberAttributesCacheKey$delegate = LazyKt.b(new Function0<String>() { // from class: com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache$subscriberAttributesCacheKey$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.getDeviceCache$purchases_defaultsBc8Release().newKey$purchases_defaultsBc8Release("subscriberAttributes");
            }
        });
    }

    private final synchronized void deleteSyncedSubscriberAttributesForOtherUsers(final String str, SharedPreferences.Editor editor) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        Pair pairA;
        try {
            final LogIntent logIntent = LogIntent.DEBUG;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache$deleteSyncedSubscriberAttributesForOtherUsers$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str4 = String.format(AttributionStrings.DELETING_ATTRIBUTES_OTHER_USERS, Arrays.copyOf(new Object[]{str}, 1));
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    sb.append(str4);
                    return sb.toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str2 = "[Purchases] - " + logLevel.name();
                        str3 = (String) function0.invoke();
                        currentLogHandler.d(str2, str3);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str2 = "[Purchases] - " + logLevel4.name();
                        str3 = (String) function0.invoke();
                        currentLogHandler.d(str2, str3);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str2 = "[Purchases] - " + logLevel6.name();
                        str3 = (String) function0.invoke();
                        currentLogHandler.d(str2, str3);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str2 = "[Purchases] - " + logLevel7.name();
                        str3 = (String) function0.invoke();
                        currentLogHandler.d(str2, str3);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel10 = LogLevel.WARN;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler7.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
            }
            Map<String, Map<String, SubscriberAttribute>> allStoredSubscriberAttributes = getAllStoredSubscriberAttributes();
            ArrayList arrayList = new ArrayList(allStoredSubscriberAttributes.size());
            for (Map.Entry<String, Map<String, SubscriberAttribute>> entry : allStoredSubscriberAttributes.entrySet()) {
                String key = entry.getKey();
                Map<String, SubscriberAttribute> value = entry.getValue();
                if (Intrinsics.areEqual(str, key)) {
                    pairA = TuplesKt.a(key, value);
                } else {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<String, SubscriberAttribute> entry2 : value.entrySet()) {
                        if (!entry2.getValue().isSynced()) {
                            linkedHashMap.put(entry2.getKey(), entry2.getValue());
                        }
                    }
                    pairA = TuplesKt.a(key, linkedHashMap);
                }
                arrayList.add(pairA);
            }
            Map map = MapsKt.toMap(arrayList);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry3 : map.entrySet()) {
                if (!((Map) entry3.getValue()).isEmpty()) {
                    linkedHashMap2.put(entry3.getKey(), entry3.getValue());
                }
            }
            editor.putString(getSubscriberAttributesCacheKey$purchases_defaultsBc8Release(), CachingHelpersKt.toJSONObject(linkedHashMap2).toString());
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final Map<String, SubscriberAttribute> filterUnsynced(Map<String, SubscriberAttribute> map, final String str) {
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, SubscriberAttribute> entry : map.entrySet()) {
            if (!entry.getValue().isSynced()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache$filterUnsynced$lambda$10$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                StringBuilder sb2 = new StringBuilder();
                String str2 = String.format(AttributionStrings.UNSYNCED_ATTRIBUTES_COUNT, Arrays.copyOf(new Object[]{Integer.valueOf(linkedHashMap.size()), str}, 2));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                sb2.append(str2);
                sb2.append(!linkedHashMap.isEmpty() ? CollectionsKt.joinToString$default(linkedHashMap.values(), "\n", null, null, 0, null, null, 62, null) : "");
                sb.append(sb2.toString());
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), (String) function0.invoke());
                }
                return linkedHashMap;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                return linkedHashMap;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                    return linkedHashMap;
                }
                return linkedHashMap;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                    return linkedHashMap;
                }
                return linkedHashMap;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    currentLogHandler4.d("[Purchases] - " + logLevel4.name(), (String) function0.invoke());
                    return linkedHashMap;
                }
                return linkedHashMap;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                return linkedHashMap;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                    return linkedHashMap;
                }
                return linkedHashMap;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    currentLogHandler6.d("[Purchases] - " + logLevel6.name(), (String) function0.invoke());
                    return linkedHashMap;
                }
                return linkedHashMap;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    currentLogHandler7.d("[Purchases] - " + logLevel7.name(), (String) function0.invoke());
                    return linkedHashMap;
                }
                return linkedHashMap;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler8.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                    return linkedHashMap;
                }
                return linkedHashMap;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler9.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                    return linkedHashMap;
                }
                return linkedHashMap;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                return linkedHashMap;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler10.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                    return linkedHashMap;
                }
                return linkedHashMap;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                return linkedHashMap;
            default:
                return linkedHashMap;
        }
    }

    private final void putAttributes(DeviceCache deviceCache, Map<String, ? extends Map<String, SubscriberAttribute>> map) {
        DeviceCache deviceCache2 = this.deviceCache;
        String subscriberAttributesCacheKey$purchases_defaultsBc8Release = getSubscriberAttributesCacheKey$purchases_defaultsBc8Release();
        String string = CachingHelpersKt.toJSONObject(map).toString();
        Intrinsics.checkNotNullExpressionValue(string, "updatedSubscriberAttribu…toJSONObject().toString()");
        deviceCache2.putString$purchases_defaultsBc8Release(subscriberAttributesCacheKey$purchases_defaultsBc8Release, string);
    }

    public final synchronized void cleanUpSubscriberAttributeCache(String currentAppUserID, SharedPreferences.Editor cacheEditor) {
        Intrinsics.checkNotNullParameter(currentAppUserID, "currentAppUserID");
        Intrinsics.checkNotNullParameter(cacheEditor, "cacheEditor");
        SubscriberAttributesMigrationExtensionsKt.migrateSubscriberAttributesIfNeeded(this, cacheEditor);
        deleteSyncedSubscriberAttributesForOtherUsers(currentAppUserID, cacheEditor);
    }

    public final synchronized void clearAllSubscriberAttributesFromUser(final String appUserID) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        try {
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            final LogIntent logIntent = LogIntent.DEBUG;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache$clearAllSubscriberAttributesFromUser$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(AttributionStrings.DELETING_ATTRIBUTES, Arrays.copyOf(new Object[]{appUserID}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb.append(str3);
                    return sb.toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel10 = LogLevel.WARN;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler7.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
            }
            Map mutableMap = MapsKt.toMutableMap(getAllStoredSubscriberAttributes());
            mutableMap.remove(appUserID);
            putAttributes(this.deviceCache, MapsKt.toMap(mutableMap));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void clearSubscriberAttributesIfSyncedForSubscriber(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        if (getUnsyncedSubscriberAttributes(appUserID).isEmpty()) {
            clearAllSubscriberAttributesFromUser(appUserID);
        }
    }

    public final synchronized Map<String, Map<String, SubscriberAttribute>> getAllStoredSubscriberAttributes() {
        Map<String, Map<String, SubscriberAttribute>> mapEmptyMap;
        try {
            JSONObject jSONObjectOrNull$purchases_defaultsBc8Release = this.deviceCache.getJSONObjectOrNull$purchases_defaultsBc8Release(getSubscriberAttributesCacheKey$purchases_defaultsBc8Release());
            if (jSONObjectOrNull$purchases_defaultsBc8Release == null || (mapEmptyMap = SubscriberAttributesFactoriesKt.buildSubscriberAttributesMapPerUser(jSONObjectOrNull$purchases_defaultsBc8Release)) == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
        } finally {
        }
        return mapEmptyMap;
    }

    public final DeviceCache getDeviceCache$purchases_defaultsBc8Release() {
        return this.deviceCache;
    }

    public final String getSubscriberAttributesCacheKey$purchases_defaultsBc8Release() {
        return (String) this.subscriberAttributesCacheKey$delegate.getValue();
    }

    public final synchronized Map<String, Map<String, SubscriberAttribute>> getUnsyncedSubscriberAttributes() {
        LinkedHashMap linkedHashMap;
        try {
            Map<String, Map<String, SubscriberAttribute>> allStoredSubscriberAttributes = getAllStoredSubscriberAttributes();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(allStoredSubscriberAttributes.size()));
            for (Object obj : allStoredSubscriberAttributes.entrySet()) {
                Object key = ((Map.Entry) obj).getKey();
                Map.Entry entry = (Map.Entry) obj;
                linkedHashMap2.put(key, filterUnsynced((Map) entry.getValue(), (String) entry.getKey()));
            }
            linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                if (!((Map) entry2.getValue()).isEmpty()) {
                    linkedHashMap.put(entry2.getKey(), entry2.getValue());
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return linkedHashMap;
    }

    public final synchronized void setAttributes(String appUserID, Map<String, SubscriberAttribute> attributesToBeSet) {
        try {
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(attributesToBeSet, "attributesToBeSet");
            Map<String, Map<String, SubscriberAttribute>> allStoredSubscriberAttributes = getAllStoredSubscriberAttributes();
            Map<String, SubscriberAttribute> mapEmptyMap = allStoredSubscriberAttributes.get(appUserID);
            if (mapEmptyMap == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
            putAttributes(this.deviceCache, MapsKt.plus(allStoredSubscriberAttributes, MapsKt.mapOf(TuplesKt.a(appUserID, MapsKt.plus(mapEmptyMap, attributesToBeSet)))));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized Map<String, SubscriberAttribute> getAllStoredSubscriberAttributes(String appUserID) {
        Map<String, SubscriberAttribute> mapEmptyMap;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        mapEmptyMap = getAllStoredSubscriberAttributes().get(appUserID);
        if (mapEmptyMap == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        return mapEmptyMap;
    }

    public final synchronized Map<String, SubscriberAttribute> getUnsyncedSubscriberAttributes(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        return filterUnsynced(getAllStoredSubscriberAttributes(appUserID), appUserID);
    }
}
