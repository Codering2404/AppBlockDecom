package com.revenuecat.purchases.common.caching;

import android.content.SharedPreferences;
import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.CustomerInfoOriginalSource;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.CustomerInfoFactory;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.SharedPreferencesManager;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.offlineentitlements.ProductEntitlementMapping;
import com.revenuecat.purchases.interfaces.StorefrontProvider;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.BillingStrings;
import com.revenuecat.purchases.strings.OfflineEntitlementsStrings;
import com.revenuecat.purchases.strings.ReceiptStrings;
import com.revenuecat.purchases.strings.VirtualCurrencyStrings;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrenciesFactory;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.Json;
import org.json.JSONException;
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
public class DeviceCache implements StorefrontProvider {
    private static final String CUSTOMER_INFO_ORIGINAL_SOURCE_KEY = "customer_info_original_source";
    private static final String CUSTOMER_INFO_REQUEST_DATE_KEY = "customer_info_request_date";
    private static final String CUSTOMER_INFO_SCHEMA_VERSION_KEY = "schema_version";
    private static final String CUSTOMER_INFO_VERIFICATION_RESULT_KEY = "verification_result";
    private static final Companion Companion = new Companion(null);
    private final String apiKey;
    private final Lazy apiKeyPrefix$delegate;
    private final Lazy appUserIDCacheKey$delegate;
    private final String attributionCacheKey;
    private final Lazy customerInfoCachesLastUpdatedCacheBaseKey$delegate;
    private final DateProvider dateProvider;
    private final Lazy legacyAppUserIDCacheKey$delegate;
    private final Lazy legacyTokensCacheKey$delegate;
    private final Lazy offeringsResponseCacheKey$delegate;
    private final SharedPreferences preferences;
    private final Lazy productEntitlementMappingCacheKey$delegate;
    private final Lazy productEntitlementMappingLastUpdatedCacheKey$delegate;
    private final Lazy storefrontCacheKey$delegate;
    private Map<String, TokenCacheEntry> tokenMapCache;
    private final Lazy tokensCacheKey$delegate;
    private final Lazy virtualCurrenciesCacheBaseKey$delegate;
    private final Lazy virtualCurrenciesLastUpdatedCacheBaseKey$delegate;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public DeviceCache(SharedPreferences preferences, String apiKey, DateProvider dateProvider) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.preferences = preferences;
        this.apiKey = apiKey;
        this.dateProvider = dateProvider;
        this.apiKeyPrefix$delegate = LazyKt.b(new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$apiKeyPrefix$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return SharedPreferencesManager.SHARED_PREFERENCES_PREFIX + this.this$0.apiKey;
            }
        });
        this.legacyAppUserIDCacheKey$delegate = LazyKt.b(new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$legacyAppUserIDCacheKey$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.getApiKeyPrefix();
            }
        });
        this.appUserIDCacheKey$delegate = LazyKt.b(new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$appUserIDCacheKey$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.getApiKeyPrefix() + ".new";
            }
        });
        this.attributionCacheKey = "com.revenuecat.purchases..attribution";
        this.legacyTokensCacheKey$delegate = LazyKt.b(new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$legacyTokensCacheKey$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.getApiKeyPrefix() + ".tokens";
            }
        });
        this.tokensCacheKey$delegate = LazyKt.b(new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$tokensCacheKey$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.getApiKeyPrefix() + ".tokensV2";
            }
        });
        this.storefrontCacheKey$delegate = LazyKt.b(new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$storefrontCacheKey$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "storefrontCacheKey";
            }
        });
        this.productEntitlementMappingCacheKey$delegate = LazyKt.b(new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$productEntitlementMappingCacheKey$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.getApiKeyPrefix() + ".productEntitlementMapping";
            }
        });
        this.productEntitlementMappingLastUpdatedCacheKey$delegate = LazyKt.b(new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$productEntitlementMappingLastUpdatedCacheKey$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.getApiKeyPrefix() + ".productEntitlementMappingLastUpdated";
            }
        });
        this.customerInfoCachesLastUpdatedCacheBaseKey$delegate = LazyKt.b(new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$customerInfoCachesLastUpdatedCacheBaseKey$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.getApiKeyPrefix() + ".purchaserInfoLastUpdated";
            }
        });
        this.virtualCurrenciesCacheBaseKey$delegate = LazyKt.b(new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$virtualCurrenciesCacheBaseKey$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.getApiKeyPrefix() + ".virtualCurrencies";
            }
        });
        this.virtualCurrenciesLastUpdatedCacheBaseKey$delegate = LazyKt.b(new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$virtualCurrenciesLastUpdatedCacheBaseKey$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.getApiKeyPrefix() + ".virtualCurrenciesLastUpdated";
            }
        });
        this.offeringsResponseCacheKey$delegate = LazyKt.b(new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$offeringsResponseCacheKey$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.getApiKeyPrefix() + ".offeringsResponse";
            }
        });
    }

    public static /* synthetic */ void addSuccessfullyPostedToken$default(DeviceCache deviceCache, String str, Boolean bool, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSuccessfullyPostedToken");
        }
        if ((i3 & 2) != 0) {
            bool = null;
        }
        deviceCache.addSuccessfullyPostedToken(str, bool);
    }

    private final SharedPreferences.Editor clearAppUserID(SharedPreferences.Editor editor) {
        editor.remove(getAppUserIDCacheKey$purchases_defaultsBc8Release());
        editor.remove(getLegacyAppUserIDCacheKey$purchases_defaultsBc8Release());
        return editor;
    }

    private final SharedPreferences.Editor clearCustomerInfo(SharedPreferences.Editor editor) {
        String cachedAppUserID$purchases_defaultsBc8Release = getCachedAppUserID$purchases_defaultsBc8Release();
        if (cachedAppUserID$purchases_defaultsBc8Release != null) {
            editor.remove(customerInfoCacheKey$purchases_defaultsBc8Release(cachedAppUserID$purchases_defaultsBc8Release));
        }
        String legacyCachedAppUserID$purchases_defaultsBc8Release = getLegacyCachedAppUserID$purchases_defaultsBc8Release();
        if (legacyCachedAppUserID$purchases_defaultsBc8Release != null) {
            editor.remove(customerInfoCacheKey$purchases_defaultsBc8Release(legacyCachedAppUserID$purchases_defaultsBc8Release));
        }
        return editor;
    }

    private final SharedPreferences.Editor clearCustomerInfoCacheTimestamp(SharedPreferences.Editor editor, String str) {
        editor.remove(customerInfoLastUpdatedCacheKey$purchases_defaultsBc8Release(str));
        return editor;
    }

    private final SharedPreferences.Editor clearVirtualCurrenciesCache(SharedPreferences.Editor editor, String str) {
        editor.remove(virtualCurrenciesCacheKey$purchases_defaultsBc8Release(str));
        String cachedAppUserID$purchases_defaultsBc8Release = getCachedAppUserID$purchases_defaultsBc8Release();
        if (cachedAppUserID$purchases_defaultsBc8Release != null) {
            editor.remove(virtualCurrenciesCacheKey$purchases_defaultsBc8Release(cachedAppUserID$purchases_defaultsBc8Release));
        }
        String legacyCachedAppUserID$purchases_defaultsBc8Release = getLegacyCachedAppUserID$purchases_defaultsBc8Release();
        if (legacyCachedAppUserID$purchases_defaultsBc8Release != null) {
            editor.remove(virtualCurrenciesCacheKey$purchases_defaultsBc8Release(legacyCachedAppUserID$purchases_defaultsBc8Release));
        }
        return editor;
    }

    private final SharedPreferences.Editor clearVirtualCurrenciesCacheTimestamp(SharedPreferences.Editor editor, String str) {
        editor.remove(virtualCurrenciesLastUpdatedCacheKey$purchases_defaultsBc8Release(str));
        String cachedAppUserID$purchases_defaultsBc8Release = getCachedAppUserID$purchases_defaultsBc8Release();
        if (cachedAppUserID$purchases_defaultsBc8Release != null) {
            editor.remove(virtualCurrenciesLastUpdatedCacheKey$purchases_defaultsBc8Release(cachedAppUserID$purchases_defaultsBc8Release));
        }
        String legacyCachedAppUserID$purchases_defaultsBc8Release = getLegacyCachedAppUserID$purchases_defaultsBc8Release();
        if (legacyCachedAppUserID$purchases_defaultsBc8Release != null) {
            editor.remove(virtualCurrenciesLastUpdatedCacheKey$purchases_defaultsBc8Release(legacyCachedAppUserID$purchases_defaultsBc8Release));
        }
        return editor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getApiKeyPrefix() {
        return (String) this.apiKeyPrefix$delegate.getValue();
    }

    public static /* synthetic */ void getAppUserIDCacheKey$purchases_defaultsBc8Release$annotations() {
    }

    private final synchronized Date getCustomerInfoCachesLastUpdated(String str) {
        return new Date(this.preferences.getLong(customerInfoLastUpdatedCacheKey$purchases_defaultsBc8Release(str), 0L));
    }

    private final String getCustomerInfoCachesLastUpdatedCacheBaseKey() {
        return (String) this.customerInfoCachesLastUpdatedCacheBaseKey$delegate.getValue();
    }

    public static /* synthetic */ void getLegacyAppUserIDCacheKey$purchases_defaultsBc8Release$annotations() {
    }

    private final String getOfferingsResponseCacheKey() {
        return (String) this.offeringsResponseCacheKey$delegate.getValue();
    }

    private final String getProductEntitlementMappingCacheKey() {
        return (String) this.productEntitlementMappingCacheKey$delegate.getValue();
    }

    private final Date getProductEntitlementMappingLastUpdated() {
        if (this.preferences.contains(getProductEntitlementMappingLastUpdatedCacheKey())) {
            return new Date(this.preferences.getLong(getProductEntitlementMappingLastUpdatedCacheKey(), -1L));
        }
        return null;
    }

    private final String getProductEntitlementMappingLastUpdatedCacheKey() {
        return (String) this.productEntitlementMappingLastUpdatedCacheKey$delegate.getValue();
    }

    public static /* synthetic */ void getStorefrontCacheKey$purchases_defaultsBc8Release$annotations() {
    }

    private final synchronized Map<String, TokenCacheEntry> getTokenMap() {
        Map<String, TokenCacheEntry> map = this.tokenMapCache;
        if (map != null) {
            return map;
        }
        Map<String, TokenCacheEntry> mapLoadTokenMapFromPreferences = loadTokenMapFromPreferences();
        this.tokenMapCache = mapLoadTokenMapFromPreferences;
        return mapLoadTokenMapFromPreferences;
    }

    private final String getVirtualCurrenciesCacheBaseKey() {
        return (String) this.virtualCurrenciesCacheBaseKey$delegate.getValue();
    }

    private final synchronized Date getVirtualCurrenciesCacheLastUpdated(String str) {
        return new Date(this.preferences.getLong(virtualCurrenciesLastUpdatedCacheKey$purchases_defaultsBc8Release(str), 0L));
    }

    private final String getVirtualCurrenciesLastUpdatedCacheBaseKey() {
        return (String) this.virtualCurrenciesLastUpdatedCacheBaseKey$delegate.getValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final Map<String, TokenCacheEntry> loadTokenMapFromPreferences() {
        LogHandler currentLogHandler;
        String str;
        String str2;
        String string = this.preferences.getString(getTokensCacheKey$purchases_defaultsBc8Release(), null);
        if (string != null) {
            try {
                return (Map) Json.f142959d.d(DeviceCacheKt.tokenMapSerializer, string);
            } catch (SerializationException unused) {
                return MapsKt.emptyMap();
            } catch (IllegalArgumentException unused2) {
                return MapsKt.emptyMap();
            }
        }
        try {
            Set<String> stringSet = this.preferences.getStringSet(getLegacyTokensCacheKey$purchases_defaultsBc8Release(), null);
            Set set = stringSet != null ? CollectionsKt.toSet(stringSet) : null;
            if (set == null) {
                return MapsKt.emptyMap();
            }
            Set set2 = set;
            final LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(set2, 10)), 16));
            for (Object obj : set2) {
                linkedHashMap.put(obj, new TokenCacheEntry((Boolean) null, 1, (DefaultConstructorMarker) null));
            }
            saveTokenMap(linkedHashMap);
            this.preferences.edit().remove(getLegacyTokensCacheKey$purchases_defaultsBc8Release()).apply();
            final LogIntent logIntent = LogIntent.DEBUG;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$loadTokenMapFromPreferences$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(ReceiptStrings.TOKENS_ALREADY_POSTED, Arrays.copyOf(new Object[]{linkedHashMap.keySet()}, 1));
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
            return linkedHashMap;
        } catch (ClassCastException unused3) {
            return MapsKt.emptyMap();
        }
    }

    private final synchronized void saveTokenMap(final Map<String, TokenCacheEntry> map) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        try {
            final LogIntent logIntent = LogIntent.DEBUG;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$saveTokenMap$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(ReceiptStrings.SAVING_TOKENS, Arrays.copyOf(new Object[]{map.keySet()}, 1));
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
            putString$purchases_defaultsBc8Release(getTokensCacheKey$purchases_defaultsBc8Release(), Json.f142959d.b(DeviceCacheKt.tokenMapSerializer, map));
            this.tokenMapCache = map;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final void setProductEntitlementMappingCacheTimestamp(Date date) {
        this.preferences.edit().putLong(getProductEntitlementMappingLastUpdatedCacheKey(), date.getTime()).apply();
    }

    private final synchronized void setVirtualCurrenciesCacheTimestamp(String str, Date date) {
        this.preferences.edit().putLong(virtualCurrenciesLastUpdatedCacheKey$purchases_defaultsBc8Release(str), date.getTime()).apply();
    }

    private final synchronized void setVirtualCurrenciesCacheTimestampToNow(String str) {
        setVirtualCurrenciesCacheTimestamp(str, this.dateProvider.getNow());
    }

    public final synchronized void addSuccessfullyPostedToken(final String token, Boolean bool) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        try {
            Intrinsics.checkNotNullParameter(token, "token");
            final String strSha1 = UtilsKt.sha1(token);
            final LogIntent logIntent = LogIntent.DEBUG;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$addSuccessfullyPostedToken$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(ReceiptStrings.SAVING_TOKENS_WITH_HASH, Arrays.copyOf(new Object[]{token, strSha1}, 2));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb.append(str3);
                    return sb.toString();
                }
            };
            int[] iArr = LogWrapperKt.WhenMappings.$EnumSwitchMapping$0;
            switch (iArr[logIntent.ordinal()]) {
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
            final Map<String, TokenCacheEntry> mutableMap = MapsKt.toMutableMap(getTokenMap());
            Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$addSuccessfullyPostedToken$$inlined$log$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(ReceiptStrings.TOKENS_IN_CACHE, Arrays.copyOf(new Object[]{mutableMap.keySet()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb.append(str3);
                    return sb.toString();
                }
            };
            switch (iArr[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel11 = LogLevel.DEBUG;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                        currentLogHandler8.d("[Purchases] - " + logLevel11.name(), (String) function02.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel12 = LogLevel.WARN;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                        currentLogHandler9.w("[Purchases] - " + logLevel12.name(), (String) function02.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel13 = LogLevel.INFO;
                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                        currentLogHandler10.i("[Purchases] - " + logLevel13.name(), (String) function02.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel14 = LogLevel.DEBUG;
                    LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                        currentLogHandler11.d("[Purchases] - " + logLevel14.name(), (String) function02.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel15 = LogLevel.INFO;
                    LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                        currentLogHandler12.i("[Purchases] - " + logLevel15.name(), (String) function02.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel16 = LogLevel.DEBUG;
                    LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                        currentLogHandler13.d("[Purchases] - " + logLevel16.name(), (String) function02.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel17 = LogLevel.DEBUG;
                    LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                        currentLogHandler14.d("[Purchases] - " + logLevel17.name(), (String) function02.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel18 = LogLevel.WARN;
                    LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                        currentLogHandler15.w("[Purchases] - " + logLevel18.name(), (String) function02.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel19 = LogLevel.WARN;
                    LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                        currentLogHandler16.w("[Purchases] - " + logLevel19.name(), (String) function02.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel20 = LogLevel.WARN;
                    LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                        currentLogHandler17.w("[Purchases] - " + logLevel20.name(), (String) function02.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                    break;
            }
            TokenCacheEntry tokenCacheEntry = mutableMap.get(strSha1);
            if (tokenCacheEntry == null) {
                mutableMap.put(strSha1, new TokenCacheEntry(bool));
                saveTokenMap(mutableMap);
            } else if (bool != null && !Intrinsics.areEqual(tokenCacheEntry.isAutoRenewing(), bool)) {
                mutableMap.put(strSha1, tokenCacheEntry.copy(bool));
                saveTokenMap(mutableMap);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void cacheAppUserID$purchases_defaultsBc8Release(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        Intrinsics.checkNotNullExpressionValue(editorEdit, "preferences.edit()");
        cacheAppUserID$purchases_defaultsBc8Release(appUserID, editorEdit).apply();
    }

    public final synchronized void cacheCustomerInfo$purchases_defaultsBc8Release(String appUserID, CustomerInfo info) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(info, "info");
        JSONObject rawData = info.getRawData();
        rawData.put(CUSTOMER_INFO_SCHEMA_VERSION_KEY, 3);
        rawData.put("verification_result", info.getEntitlements().getVerification().name());
        rawData.put(CUSTOMER_INFO_REQUEST_DATE_KEY, info.getRequestDate().getTime());
        rawData.put(CUSTOMER_INFO_ORIGINAL_SOURCE_KEY, info.getOriginalSource$purchases_defaultsBc8Release().name());
        this.preferences.edit().putString(customerInfoCacheKey$purchases_defaultsBc8Release(appUserID), rawData.toString()).apply();
        setCustomerInfoCacheTimestampToNow$purchases_defaultsBc8Release(appUserID);
    }

    public final synchronized void cacheOfferingsResponse$purchases_defaultsBc8Release(JSONObject offeringsResponse) {
        Intrinsics.checkNotNullParameter(offeringsResponse, "offeringsResponse");
        this.preferences.edit().putString(getOfferingsResponseCacheKey(), offeringsResponse.toString()).apply();
    }

    public final synchronized void cacheProductEntitlementMapping$purchases_defaultsBc8Release(ProductEntitlementMapping productEntitlementMapping) {
        Intrinsics.checkNotNullParameter(productEntitlementMapping, tDEtWsFLJfe.bPZNAmnfAAQwB);
        this.preferences.edit().putString(getProductEntitlementMappingCacheKey(), productEntitlementMapping.toJson$purchases_defaultsBc8Release().toString()).apply();
        setProductEntitlementMappingCacheTimestampToNow$purchases_defaultsBc8Release();
    }

    public final synchronized void cacheVirtualCurrencies$purchases_defaultsBc8Release(String appUserID, VirtualCurrencies virtualCurrencies) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(virtualCurrencies, "virtualCurrencies");
        this.preferences.edit().putString(virtualCurrenciesCacheKey$purchases_defaultsBc8Release(appUserID), Json.f142959d.b(VirtualCurrencies.Companion.serializer(), virtualCurrencies)).apply();
        setVirtualCurrenciesCacheTimestampToNow(appUserID);
    }

    public final synchronized void cleanPreviouslySentTokens$purchases_defaultsBc8Release(Set<String> hashedTokens) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        try {
            Intrinsics.checkNotNullParameter(hashedTokens, "hashedTokens");
            final LogIntent logIntent = LogIntent.DEBUG;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$cleanPreviouslySentTokens$$inlined$log$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent.getEmojiList(), muQRKXGtpOhe.VccTdsDPt, null, null, 0, null, null, 62, null) + ' ' + ReceiptStrings.CLEANING_PREV_SENT_HASHED_TOKEN;
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
            Map<String, TokenCacheEntry> tokenMap = getTokenMap();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, TokenCacheEntry> entry : tokenMap.entrySet()) {
                if (hashedTokens.contains(entry.getKey())) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            saveTokenMap(linkedHashMap);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void cleanupOldAttributionData$purchases_defaultsBc8Release() {
        try {
            SharedPreferences.Editor editorEdit = this.preferences.edit();
            for (String str : this.preferences.getAll().keySet()) {
                if (str != null && StringsKt.U(str, this.attributionCacheKey, false, 2, null)) {
                    editorEdit.remove(str);
                }
            }
            editorEdit.apply();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void clearCachesForAppUserID$purchases_defaultsBc8Release(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        Intrinsics.checkNotNullExpressionValue(editorEdit, "preferences.edit()");
        clearVirtualCurrenciesCache(clearVirtualCurrenciesCacheTimestamp(clearCustomerInfoCacheTimestamp(clearAppUserID(clearCustomerInfo(editorEdit)), appUserID), appUserID), appUserID).apply();
    }

    public final synchronized void clearCustomerInfoCache$purchases_defaultsBc8Release(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        SharedPreferences.Editor editor = this.preferences.edit();
        Intrinsics.checkNotNullExpressionValue(editor, "editor");
        clearCustomerInfoCache$purchases_defaultsBc8Release(appUserID, editor);
        editor.apply();
    }

    public final synchronized void clearCustomerInfoCacheTimestamp$purchases_defaultsBc8Release(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        Intrinsics.checkNotNullExpressionValue(editorEdit, "preferences.edit()");
        clearCustomerInfoCacheTimestamp(editorEdit, appUserID).apply();
    }

    public final synchronized void clearOfferingsResponseCache$purchases_defaultsBc8Release() {
        this.preferences.edit().remove(getOfferingsResponseCacheKey()).apply();
    }

    public final synchronized void clearVirtualCurrenciesCache$purchases_defaultsBc8Release(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        SharedPreferences.Editor editor = this.preferences.edit();
        Intrinsics.checkNotNullExpressionValue(editor, "editor");
        clearVirtualCurrenciesCache$purchases_defaultsBc8Release(appUserID, editor);
        editor.apply();
    }

    public final String customerInfoCacheKey$purchases_defaultsBc8Release(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        return getLegacyAppUserIDCacheKey$purchases_defaultsBc8Release() + '.' + appUserID;
    }

    public final String customerInfoLastUpdatedCacheKey$purchases_defaultsBc8Release(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        return getCustomerInfoCachesLastUpdatedCacheBaseKey() + '.' + appUserID;
    }

    public final Set<String> findKeysThatStartWith$purchases_defaultsBc8Release(String cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        try {
            Map<String, ?> all = this.preferences.getAll();
            if (all != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    String it = entry.getKey();
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (StringsKt.U(it, cacheKey, false, 2, null)) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                Set<String> setKeySet = linkedHashMap.keySet();
                if (setKeySet != null) {
                    return setKeySet;
                }
            }
            return SetsKt.emptySet();
        } catch (NullPointerException unused) {
            return SetsKt.emptySet();
        }
    }

    public final synchronized List<StoreTransaction> getActivePurchasesNotInCache$purchases_defaultsBc8Release(Map<String, StoreTransaction> hashedTokens) {
        Intrinsics.checkNotNullParameter(hashedTokens, "hashedTokens");
        return CollectionsKt.toList(MapsKt.minus((Map) hashedTokens, (Iterable) getPreviouslySentHashedTokens$purchases_defaultsBc8Release()).values());
    }

    public final String getAppUserIDCacheKey$purchases_defaultsBc8Release() {
        return (String) this.appUserIDCacheKey$delegate.getValue();
    }

    public final String getAttributionCacheKey$purchases_defaultsBc8Release() {
        return this.attributionCacheKey;
    }

    public final synchronized String getCachedAppUserID$purchases_defaultsBc8Release() {
        return this.preferences.getString(getAppUserIDCacheKey$purchases_defaultsBc8Release(), null);
    }

    public final CustomerInfo getCachedCustomerInfo$purchases_defaultsBc8Release(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        String string = this.preferences.getString(customerInfoCacheKey$purchases_defaultsBc8Release(appUserID), null);
        if (string != null) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                int iOptInt = jSONObject.optInt(CUSTOMER_INFO_SCHEMA_VERSION_KEY);
                String verificationResultString = jSONObject.has("verification_result") ? jSONObject.getString("verification_result") : "NOT_REQUESTED";
                Long lValueOf = Long.valueOf(jSONObject.optLong(CUSTOMER_INFO_REQUEST_DATE_KEY));
                if (lValueOf.longValue() <= 0) {
                    lValueOf = null;
                }
                Date date = lValueOf != null ? new Date(lValueOf.longValue()) : null;
                CustomerInfoOriginalSource customerInfoOriginalSourceFromString = CustomerInfoOriginalSource.Companion.fromString(JSONObjectExtensionsKt.optNullableString(jSONObject, CUSTOMER_INFO_ORIGINAL_SOURCE_KEY));
                jSONObject.remove("verification_result");
                jSONObject.remove(CUSTOMER_INFO_REQUEST_DATE_KEY);
                jSONObject.remove(CUSTOMER_INFO_ORIGINAL_SOURCE_KEY);
                Intrinsics.checkNotNullExpressionValue(verificationResultString, "verificationResultString");
                VerificationResult verificationResultValueOf = VerificationResult.valueOf(verificationResultString);
                if (iOptInt == 3) {
                    return CustomerInfoFactory.INSTANCE.buildCustomerInfo(jSONObject, date, verificationResultValueOf, customerInfoOriginalSourceFromString, true);
                }
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public final synchronized VirtualCurrencies getCachedVirtualCurrencies$purchases_defaultsBc8Release(String appUserID) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        String string = this.preferences.getString(virtualCurrenciesCacheKey$purchases_defaultsBc8Release(appUserID), null);
        if (string != null) {
            try {
                return VirtualCurrenciesFactory.INSTANCE.buildVirtualCurrencies(string);
            } catch (SerializationException e3) {
                final LogIntent logIntent = LogIntent.WARNING;
                Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        StringBuilder sb = new StringBuilder();
                        sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                        sb.append(' ');
                        String str3 = String.format(VirtualCurrencyStrings.ERROR_DECODING_CACHED_VIRTUAL_CURRENCIES, Arrays.copyOf(new Object[]{e3}, 1));
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        sb.append(str3);
                        return sb.toString();
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler2.d("[Purchases] - " + logLevel.name(), (String) function0.invoke());
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler3.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler4.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            currentLogHandler5.d("[Purchases] - " + logLevel4.name(), (String) function0.invoke());
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler6.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            currentLogHandler7.d("[Purchases] - " + logLevel6.name(), (String) function0.invoke());
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            currentLogHandler8.d("[Purchases] - " + logLevel7.name(), (String) function0.invoke());
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            currentLogHandler9.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler10.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        break;
                    case 13:
                        LogLevel logLevel10 = LogLevel.WARN;
                        LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                            currentLogHandler11.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        break;
                }
            } catch (IllegalArgumentException e4) {
                final LogIntent logIntent2 = LogIntent.WARNING;
                Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        StringBuilder sb = new StringBuilder();
                        sb.append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null));
                        sb.append(' ');
                        String str3 = String.format(VirtualCurrencyStrings.ERROR_DECODING_CACHED_VIRTUAL_CURRENCIES, Arrays.copyOf(new Object[]{e4}, 1));
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        sb.append(str3);
                        return sb.toString();
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                    case 1:
                        LogLevel logLevel11 = LogLevel.DEBUG;
                        LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                            currentLogHandler12.d("[Purchases] - " + logLevel11.name(), (String) function02.invoke());
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel12 = LogLevel.WARN;
                        LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                            currentLogHandler13.w("[Purchases] - " + logLevel12.name(), (String) function02.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel13 = LogLevel.INFO;
                        LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                            currentLogHandler14.i("[Purchases] - " + logLevel13.name(), (String) function02.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel14 = LogLevel.DEBUG;
                        LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                            currentLogHandler15.d("[Purchases] - " + logLevel14.name(), (String) function02.invoke());
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel15 = LogLevel.INFO;
                        LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                            currentLogHandler16.i("[Purchases] - " + logLevel15.name(), (String) function02.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel16 = LogLevel.DEBUG;
                        LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                            currentLogHandler17.d("[Purchases] - " + logLevel16.name(), (String) function02.invoke());
                        }
                        break;
                    case 9:
                        LogLevel logLevel17 = LogLevel.DEBUG;
                        LogHandler currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                            currentLogHandler18.d("[Purchases] - " + logLevel17.name(), (String) function02.invoke());
                        }
                        break;
                    case 10:
                        LogLevel logLevel18 = LogLevel.WARN;
                        LogHandler currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                            currentLogHandler19.w("[Purchases] - " + logLevel18.name(), (String) function02.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel19 = LogLevel.WARN;
                        LogHandler currentLogHandler20 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                            currentLogHandler20.w("[Purchases] - " + logLevel19.name(), (String) function02.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                        break;
                    case 13:
                        LogLevel logLevel20 = LogLevel.WARN;
                        LogHandler currentLogHandler21 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                            currentLogHandler21.w("[Purchases] - " + logLevel20.name(), (String) function02.invoke());
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                        break;
                }
            } catch (JSONException e5) {
                final LogIntent logIntent3 = LogIntent.WARNING;
                Function0<String> function03 = new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        StringBuilder sb = new StringBuilder();
                        sb.append(CollectionsKt.joinToString$default(logIntent3.getEmojiList(), "", null, null, 0, null, null, 62, null));
                        sb.append(' ');
                        String str3 = String.format(VirtualCurrencyStrings.ERROR_DECODING_CACHED_VIRTUAL_CURRENCIES, Arrays.copyOf(new Object[]{e5}, 1));
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        sb.append(str3);
                        return sb.toString();
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent3.ordinal()]) {
                    case 1:
                        LogLevel logLevel21 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                            str = "[Purchases] - " + logLevel21.name();
                            str2 = (String) function03.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel22 = LogLevel.WARN;
                        LogHandler currentLogHandler22 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel22) <= 0) {
                            currentLogHandler22.w("[Purchases] - " + logLevel22.name(), (String) function03.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel23 = LogLevel.INFO;
                        LogHandler currentLogHandler23 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel23) <= 0) {
                            currentLogHandler23.i("[Purchases] - " + logLevel23.name(), (String) function03.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel24 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel24) <= 0) {
                            str = "[Purchases] - " + logLevel24.name();
                            str2 = (String) function03.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel25 = LogLevel.INFO;
                        LogHandler currentLogHandler24 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel25) <= 0) {
                            currentLogHandler24.i("[Purchases] - " + logLevel25.name(), (String) function03.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel26 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel26) <= 0) {
                            str = "[Purchases] - " + logLevel26.name();
                            str2 = (String) function03.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 9:
                        LogLevel logLevel27 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel27) <= 0) {
                            str = "[Purchases] - " + logLevel27.name();
                            str2 = (String) function03.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 10:
                        LogLevel logLevel28 = LogLevel.WARN;
                        LogHandler currentLogHandler25 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel28) <= 0) {
                            currentLogHandler25.w("[Purchases] - " + logLevel28.name(), (String) function03.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel29 = LogLevel.WARN;
                        LogHandler currentLogHandler26 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel29) <= 0) {
                            currentLogHandler26.w("[Purchases] - " + logLevel29.name(), (String) function03.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                        break;
                    case 13:
                        LogLevel logLevel30 = LogLevel.WARN;
                        LogHandler currentLogHandler27 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel30) <= 0) {
                            currentLogHandler27.w("[Purchases] - " + logLevel30.name(), (String) function03.invoke());
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                        break;
                }
            }
        }
        return null;
    }

    public JSONObject getJSONObjectOrNull$purchases_defaultsBc8Release(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String string = this.preferences.getString(key, null);
        if (string == null) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final String getLegacyAppUserIDCacheKey$purchases_defaultsBc8Release() {
        return (String) this.legacyAppUserIDCacheKey$delegate.getValue();
    }

    public final synchronized String getLegacyCachedAppUserID$purchases_defaultsBc8Release() {
        return this.preferences.getString(getLegacyAppUserIDCacheKey$purchases_defaultsBc8Release(), null);
    }

    public final String getLegacyTokensCacheKey$purchases_defaultsBc8Release() {
        return (String) this.legacyTokensCacheKey$delegate.getValue();
    }

    public final synchronized JSONObject getOfferingsResponseCache$purchases_defaultsBc8Release() {
        return getJSONObjectOrNull$purchases_defaultsBc8Release(getOfferingsResponseCacheKey());
    }

    public final synchronized Set<String> getPreviouslySentHashedTokens$purchases_defaultsBc8Release() {
        final Set<String> setKeySet;
        LogHandler currentLogHandler;
        String str;
        String str2;
        try {
            setKeySet = getTokenMap().keySet();
            final LogIntent logIntent = LogIntent.DEBUG;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.caching.DeviceCache$getPreviouslySentHashedTokens$lambda$21$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(ReceiptStrings.TOKENS_ALREADY_POSTED, Arrays.copyOf(new Object[]{setKeySet}, 1));
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
        } finally {
        }
        return setKeySet;
    }

    public final synchronized ProductEntitlementMapping getProductEntitlementMapping$purchases_defaultsBc8Release() {
        ProductEntitlementMapping productEntitlementMappingFromJson$purchases_defaultsBc8Release = null;
        String string = this.preferences.getString(getProductEntitlementMappingCacheKey(), null);
        if (string == null) {
            return null;
        }
        try {
            productEntitlementMappingFromJson$purchases_defaultsBc8Release = ProductEntitlementMapping.Companion.fromJson$purchases_defaultsBc8Release(new JSONObject(string), true);
        } catch (JSONException e3) {
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            String str = String.format(OfflineEntitlementsStrings.ERROR_PARSING_PRODUCT_ENTITLEMENT_MAPPING, Arrays.copyOf(new Object[]{string}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            currentLogHandler.e("[Purchases] - ERROR", str, e3);
            this.preferences.edit().remove(getProductEntitlementMappingCacheKey()).apply();
        }
        return productEntitlementMappingFromJson$purchases_defaultsBc8Release;
    }

    public final synchronized List<StoreTransaction> getPurchasesWithAutoRenewingChange$purchases_defaultsBc8Release(Map<String, StoreTransaction> hashedTokens) {
        LinkedHashMap linkedHashMap;
        try {
            Intrinsics.checkNotNullParameter(hashedTokens, "hashedTokens");
            Map<String, TokenCacheEntry> tokenMap = getTokenMap();
            linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, StoreTransaction> entry : hashedTokens.entrySet()) {
                String key = entry.getKey();
                StoreTransaction value = entry.getValue();
                TokenCacheEntry tokenCacheEntry = tokenMap.get(key);
                if (tokenCacheEntry != null && tokenCacheEntry.isAutoRenewing() != null && value.isAutoRenewing() != null && !Intrinsics.areEqual(value.isAutoRenewing(), tokenCacheEntry.isAutoRenewing())) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return CollectionsKt.toList(linkedHashMap.values());
    }

    @Override // com.revenuecat.purchases.interfaces.StorefrontProvider
    public synchronized String getStorefront() {
        String string;
        string = this.preferences.getString(getStorefrontCacheKey$purchases_defaultsBc8Release(), null);
        if (string == null) {
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.d("[Purchases] - " + logLevel.name(), BillingStrings.BILLING_STOREFRONT_NULL_FROM_CACHE);
            }
        }
        return string;
    }

    public final String getStorefrontCacheKey$purchases_defaultsBc8Release() {
        return (String) this.storefrontCacheKey$delegate.getValue();
    }

    public final String getTokensCacheKey$purchases_defaultsBc8Release() {
        return (String) this.tokensCacheKey$delegate.getValue();
    }

    public final synchronized boolean isCustomerInfoCacheStale$purchases_defaultsBc8Release(String str, boolean z2) {
        Intrinsics.checkNotNullParameter(str, sKeKFMqmvNzY.znlOhDdpQELweq);
        return DateExtensionsKt.isCacheStale(getCustomerInfoCachesLastUpdated(str), z2, this.dateProvider);
    }

    public final synchronized boolean isProductEntitlementMappingCacheStale$purchases_defaultsBc8Release() {
        return DateExtensionsKt.m526isCacheStale8Mi8wO0(getProductEntitlementMappingLastUpdated(), DeviceCacheKt.PRODUCT_ENTITLEMENT_MAPPING_CACHE_REFRESH_PERIOD, this.dateProvider);
    }

    public final synchronized boolean isVirtualCurrenciesCacheStale$purchases_defaultsBc8Release(String appUserID, boolean z2) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        return DateExtensionsKt.isCacheStale(getVirtualCurrenciesCacheLastUpdated(appUserID), z2, this.dateProvider);
    }

    public final String newKey$purchases_defaultsBc8Release(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getApiKeyPrefix() + '.' + key;
    }

    public void putString$purchases_defaultsBc8Release(String cacheKey, String value) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        Intrinsics.checkNotNullParameter(value, "value");
        this.preferences.edit().putString(cacheKey, value).apply();
    }

    public final void remove$purchases_defaultsBc8Release(String cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        this.preferences.edit().remove(cacheKey).apply();
    }

    public final synchronized void saveAutoRenewingStatus$purchases_defaultsBc8Release(Map<String, StoreTransaction> hashedTokens) {
        try {
            Intrinsics.checkNotNullParameter(hashedTokens, "hashedTokens");
            Map<String, TokenCacheEntry> mutableMap = MapsKt.toMutableMap(getTokenMap());
            boolean z2 = false;
            for (Map.Entry<String, StoreTransaction> entry : hashedTokens.entrySet()) {
                String key = entry.getKey();
                StoreTransaction value = entry.getValue();
                TokenCacheEntry tokenCacheEntry = mutableMap.get(key);
                if (tokenCacheEntry != null && value.isAutoRenewing() != null && !Intrinsics.areEqual(tokenCacheEntry.isAutoRenewing(), value.isAutoRenewing())) {
                    mutableMap.put(key, tokenCacheEntry.copy(value.isAutoRenewing()));
                    z2 = true;
                }
            }
            if (z2) {
                saveTokenMap(mutableMap);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void setCustomerInfoCacheTimestamp$purchases_defaultsBc8Release(String appUserID, Date date) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(date, "date");
        this.preferences.edit().putLong(customerInfoLastUpdatedCacheKey$purchases_defaultsBc8Release(appUserID), date.getTime()).apply();
    }

    public final synchronized void setCustomerInfoCacheTimestampToNow$purchases_defaultsBc8Release(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        setCustomerInfoCacheTimestamp$purchases_defaultsBc8Release(appUserID, this.dateProvider.getNow());
    }

    public final synchronized void setProductEntitlementMappingCacheTimestampToNow$purchases_defaultsBc8Release() {
        setProductEntitlementMappingCacheTimestamp(this.dateProvider.getNow());
    }

    public final synchronized void setStorefront$purchases_defaultsBc8Release(String countryCode) {
        try {
            Intrinsics.checkNotNullParameter(countryCode, "countryCode");
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                String str = "[Purchases] - " + logLevel.name();
                String str2 = String.format(BillingStrings.BILLING_STOREFRONT_CACHING, Arrays.copyOf(new Object[]{countryCode}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                currentLogHandler.v(str, str2);
            }
            this.preferences.edit().putString(getStorefrontCacheKey$purchases_defaultsBc8Release(), countryCode).apply();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final SharedPreferences.Editor startEditing$purchases_defaultsBc8Release() {
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        Intrinsics.checkNotNullExpressionValue(editorEdit, "preferences.edit()");
        return editorEdit;
    }

    public final String virtualCurrenciesCacheKey$purchases_defaultsBc8Release(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        return getVirtualCurrenciesCacheBaseKey() + '.' + appUserID;
    }

    public final String virtualCurrenciesLastUpdatedCacheKey$purchases_defaultsBc8Release(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        return getVirtualCurrenciesLastUpdatedCacheBaseKey() + '.' + appUserID;
    }

    public final synchronized SharedPreferences.Editor cacheAppUserID$purchases_defaultsBc8Release(String appUserID, SharedPreferences.Editor cacheEditor) {
        SharedPreferences.Editor editorPutString;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(cacheEditor, "cacheEditor");
        editorPutString = cacheEditor.putString(getAppUserIDCacheKey$purchases_defaultsBc8Release(), appUserID);
        Intrinsics.checkNotNullExpressionValue(editorPutString, "cacheEditor.putString(ap…serIDCacheKey, appUserID)");
        return editorPutString;
    }

    public final synchronized void clearCustomerInfoCache$purchases_defaultsBc8Release(String appUserID, SharedPreferences.Editor editor) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(editor, "editor");
        clearCustomerInfoCacheTimestamp(editor, appUserID);
        editor.remove(customerInfoCacheKey$purchases_defaultsBc8Release(appUserID));
    }

    public final synchronized void clearVirtualCurrenciesCache$purchases_defaultsBc8Release(String appUserID, SharedPreferences.Editor editor) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(editor, "editor");
        clearVirtualCurrenciesCacheTimestamp(editor, appUserID);
        clearVirtualCurrenciesCache(editor, appUserID);
    }

    public /* synthetic */ DeviceCache(SharedPreferences sharedPreferences, String str, DateProvider dateProvider, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(sharedPreferences, str, (i3 & 4) != 0 ? new DefaultDateProvider() : dateProvider);
    }
}
