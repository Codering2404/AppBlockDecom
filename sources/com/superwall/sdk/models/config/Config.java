package com.superwall.sdk.models.config;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.superwall.sdk.models.SerializableEntity;
import com.superwall.sdk.models.config.LocalizationConfig;
import com.superwall.sdk.models.paywall.Paywall;
import com.superwall.sdk.models.paywall.Paywall$$serializer;
import com.superwall.sdk.models.postback.PostbackRequest;
import com.superwall.sdk.models.postback.PostbackRequest$$serializer;
import com.superwall.sdk.models.product.CrossplatformProduct;
import com.superwall.sdk.models.product.CrossplatformProductSerializer;
import com.superwall.sdk.models.product.ProductItem;
import com.superwall.sdk.models.product.ProductItemSerializer;
import com.superwall.sdk.models.triggers.Trigger;
import com.superwall.sdk.models.triggers.Trigger$$serializer;
import com.superwall.sdk.models.triggers.TriggerRule;
import com.superwall.sdk.store.testmode.models.TestStoreUser;
import com.superwall.sdk.store.testmode.models.TestStoreUser$$serializer;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Serializable
public final class Config implements SerializableEntity {
    private long appSessionTimeout;
    private final String buildId;
    private final String bundleIdConfig;
    private transient Set<String> locales;
    private LocalizationConfig localizationConfig;
    private int logLevel;
    private List<Paywall> paywalls;
    private PostbackRequest postback;
    private PreloadingDisabled preloadingDisabled;
    private final String prioritizedCampaignId;
    private final List<ProductItem> products;
    private final List<CrossplatformProduct> productsV3;
    private List<RawFeatureFlag> rawFeatureFlags;
    private String requestId;
    private final List<TestStoreUser> testModeUserIds;
    private Set<Trigger> triggers;
    private WebToAppConfig webToAppConfig;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new LinkedHashSetSerializer(Trigger$$serializer.INSTANCE), new ArrayListSerializer(Paywall$$serializer.INSTANCE), null, null, null, new ArrayListSerializer(RawFeatureFlag$$serializer.INSTANCE), new ArrayListSerializer(ProductItemSerializer.INSTANCE), new ArrayListSerializer(CrossplatformProductSerializer.INSTANCE), null, null, null, new LinkedHashSetSerializer(StringSerializer.f142891a), null, null, null, new ArrayListSerializer(TestStoreUser$$serializer.INSTANCE), null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Config> serializer() {
            return Config$$serializer.INSTANCE;
        }

        public final Config stub() {
            return new Config(SetsKt.setOf(Trigger.Companion.stub()), CollectionsKt.listOf(Paywall.Companion.stub()), 0, PostbackRequest.Companion.stub(), 3600000L, CollectionsKt.emptyList(), CollectionsKt.emptyList(), (List) null, PreloadingDisabled.Companion.stub(), new LocalizationConfig(CollectionsKt.emptyList()), (String) null, (Set) null, (WebToAppConfig) null, "stub-build-id", (String) null, (List) null, (String) null, 121856, (DefaultConstructorMarker) null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ Config(int i3, Set set, List list, int i4, PostbackRequest postbackRequest, long j3, List list2, List list3, List list4, PreloadingDisabled preloadingDisabled, LocalizationConfig localizationConfig, String str, Set set2, WebToAppConfig webToAppConfig, String str2, String str3, List list5, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if (9087 != (i3 & 9087)) {
            PluginExceptionsKt.b(i3, 9087, Config$$serializer.INSTANCE.getDescriptor());
        }
        this.triggers = set;
        this.paywalls = list;
        this.logLevel = i4;
        this.postback = postbackRequest;
        this.appSessionTimeout = j3;
        this.rawFeatureFlags = list2;
        this.products = list3;
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
            this.productsV3 = null;
        } else {
            this.productsV3 = list4;
        }
        this.preloadingDisabled = preloadingDisabled;
        this.localizationConfig = localizationConfig;
        if ((i3 & 1024) == 0) {
            this.requestId = null;
        } else {
            this.requestId = str;
        }
        this.locales = (i3 & 2048) == 0 ? SetsKt.emptySet() : set2;
        if ((i3 & 4096) == 0) {
            this.webToAppConfig = null;
        } else {
            this.webToAppConfig = webToAppConfig;
        }
        this.buildId = str2;
        if ((i3 & 16384) == 0) {
            this.bundleIdConfig = null;
        } else {
            this.bundleIdConfig = str3;
        }
        if ((32768 & i3) == 0) {
            this.testModeUserIds = null;
        } else {
            this.testModeUserIds = list5;
        }
        if ((i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) == 0) {
            this.prioritizedCampaignId = null;
        } else {
            this.prioritizedCampaignId = str4;
        }
        List<LocalizationConfig.LocaleConfig> locales = this.localizationConfig.getLocales();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(locales, 10));
        Iterator<T> it = locales.iterator();
        while (it.hasNext()) {
            arrayList.add(((LocalizationConfig.LocaleConfig) it.next()).getLocale());
        }
        this.locales = CollectionsKt.toSet(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Config copy$default(Config config, Set set, List list, int i3, PostbackRequest postbackRequest, long j3, List list2, List list3, List list4, PreloadingDisabled preloadingDisabled, LocalizationConfig localizationConfig, String str, Set set2, WebToAppConfig webToAppConfig, String str2, String str3, List list5, String str4, int i4, Object obj) {
        String str5;
        List list6;
        Set set3 = (i4 & 1) != 0 ? config.triggers : set;
        List list7 = (i4 & 2) != 0 ? config.paywalls : list;
        int i5 = (i4 & 4) != 0 ? config.logLevel : i3;
        PostbackRequest postbackRequest2 = (i4 & 8) != 0 ? config.postback : postbackRequest;
        long j4 = (i4 & 16) != 0 ? config.appSessionTimeout : j3;
        List list8 = (i4 & 32) != 0 ? config.rawFeatureFlags : list2;
        List list9 = (i4 & 64) != 0 ? config.products : list3;
        List list10 = (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? config.productsV3 : list4;
        PreloadingDisabled preloadingDisabled2 = (i4 & Function.MAX_NARGS) != 0 ? config.preloadingDisabled : preloadingDisabled;
        LocalizationConfig localizationConfig2 = (i4 & 512) != 0 ? config.localizationConfig : localizationConfig;
        String str6 = (i4 & 1024) != 0 ? config.requestId : str;
        Set set4 = (i4 & 2048) != 0 ? config.locales : set2;
        WebToAppConfig webToAppConfig2 = (i4 & 4096) != 0 ? config.webToAppConfig : webToAppConfig;
        Set set5 = set3;
        String str7 = (i4 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? config.buildId : str2;
        String str8 = (i4 & 16384) != 0 ? config.bundleIdConfig : str3;
        List list11 = (i4 & 32768) != 0 ? config.testModeUserIds : list5;
        if ((i4 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0) {
            list6 = list11;
            str5 = config.prioritizedCampaignId;
        } else {
            str5 = str4;
            list6 = list11;
        }
        return config.copy(set5, list7, i5, postbackRequest2, j4, list8, list9, list10, preloadingDisabled2, localizationConfig2, str6, set4, webToAppConfig2, str7, str8, list6, str5);
    }

    @SerialName
    public static /* synthetic */ void getAppSessionTimeout$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getBuildId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getBundleIdConfig$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getLocalizationConfig$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPaywalls$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPostback$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPreloadingDisabled$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPrioritizedCampaignId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getProducts$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getProductsV3$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getRawFeatureFlags$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getTestModeUserIds$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getTriggers$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getWebToAppConfig$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(Config config, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.C(serialDescriptor, 0, kSerializerArr[0], config.triggers);
        compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], config.paywalls);
        compositeEncoder.w(serialDescriptor, 2, config.logLevel);
        compositeEncoder.C(serialDescriptor, 3, PostbackRequest$$serializer.INSTANCE, config.postback);
        compositeEncoder.F(serialDescriptor, 4, config.appSessionTimeout);
        compositeEncoder.C(serialDescriptor, 5, kSerializerArr[5], config.rawFeatureFlags);
        compositeEncoder.C(serialDescriptor, 6, kSerializerArr[6], config.products);
        if (compositeEncoder.z(serialDescriptor, 7) || config.productsV3 != null) {
            compositeEncoder.i(serialDescriptor, 7, kSerializerArr[7], config.productsV3);
        }
        compositeEncoder.C(serialDescriptor, 8, PreloadingDisabled$$serializer.INSTANCE, config.preloadingDisabled);
        compositeEncoder.C(serialDescriptor, 9, LocalizationConfig$$serializer.INSTANCE, config.localizationConfig);
        if (compositeEncoder.z(serialDescriptor, 10) || config.requestId != null) {
            compositeEncoder.i(serialDescriptor, 10, StringSerializer.f142891a, config.requestId);
        }
        if (compositeEncoder.z(serialDescriptor, 11) || !Intrinsics.areEqual(config.locales, SetsKt.emptySet())) {
            compositeEncoder.C(serialDescriptor, 11, kSerializerArr[11], config.locales);
        }
        if (compositeEncoder.z(serialDescriptor, 12) || config.webToAppConfig != null) {
            compositeEncoder.i(serialDescriptor, 12, WebToAppConfig$$serializer.INSTANCE, config.webToAppConfig);
        }
        compositeEncoder.y(serialDescriptor, 13, config.buildId);
        if (compositeEncoder.z(serialDescriptor, 14) || config.bundleIdConfig != null) {
            compositeEncoder.i(serialDescriptor, 14, StringSerializer.f142891a, config.bundleIdConfig);
        }
        if (compositeEncoder.z(serialDescriptor, 15) || config.testModeUserIds != null) {
            compositeEncoder.i(serialDescriptor, 15, kSerializerArr[15], config.testModeUserIds);
        }
        if (!compositeEncoder.z(serialDescriptor, 16) && config.prioritizedCampaignId == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 16, StringSerializer.f142891a, config.prioritizedCampaignId);
    }

    public final Set<Trigger> component1() {
        return this.triggers;
    }

    public final LocalizationConfig component10() {
        return this.localizationConfig;
    }

    public final String component11() {
        return this.requestId;
    }

    public final Set<String> component12() {
        return this.locales;
    }

    public final WebToAppConfig component13() {
        return this.webToAppConfig;
    }

    public final String component14() {
        return this.buildId;
    }

    public final String component15() {
        return this.bundleIdConfig;
    }

    public final List<TestStoreUser> component16() {
        return this.testModeUserIds;
    }

    public final String component17() {
        return this.prioritizedCampaignId;
    }

    public final List<Paywall> component2() {
        return this.paywalls;
    }

    public final int component3() {
        return this.logLevel;
    }

    public final PostbackRequest component4() {
        return this.postback;
    }

    public final long component5() {
        return this.appSessionTimeout;
    }

    public final List<RawFeatureFlag> component6() {
        return this.rawFeatureFlags;
    }

    public final List<ProductItem> component7() {
        return this.products;
    }

    public final List<CrossplatformProduct> component8() {
        return this.productsV3;
    }

    public final PreloadingDisabled component9() {
        return this.preloadingDisabled;
    }

    public final Config copy(Set<Trigger> triggers, List<Paywall> paywalls, int i3, PostbackRequest postback, long j3, List<RawFeatureFlag> rawFeatureFlags, List<ProductItem> products, List<CrossplatformProduct> list, PreloadingDisabled preloadingDisabled, LocalizationConfig localizationConfig, String str, Set<String> locales, WebToAppConfig webToAppConfig, String buildId, String str2, List<TestStoreUser> list2, String str3) {
        Intrinsics.checkNotNullParameter(triggers, "triggers");
        Intrinsics.checkNotNullParameter(paywalls, "paywalls");
        Intrinsics.checkNotNullParameter(postback, "postback");
        Intrinsics.checkNotNullParameter(rawFeatureFlags, "rawFeatureFlags");
        Intrinsics.checkNotNullParameter(products, "products");
        Intrinsics.checkNotNullParameter(preloadingDisabled, "preloadingDisabled");
        Intrinsics.checkNotNullParameter(localizationConfig, "localizationConfig");
        Intrinsics.checkNotNullParameter(locales, "locales");
        Intrinsics.checkNotNullParameter(buildId, "buildId");
        return new Config(triggers, paywalls, i3, postback, j3, rawFeatureFlags, products, list, preloadingDisabled, localizationConfig, str, locales, webToAppConfig, buildId, str2, list2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Config)) {
            return false;
        }
        Config config = (Config) obj;
        return Intrinsics.areEqual(this.triggers, config.triggers) && Intrinsics.areEqual(this.paywalls, config.paywalls) && this.logLevel == config.logLevel && Intrinsics.areEqual(this.postback, config.postback) && this.appSessionTimeout == config.appSessionTimeout && Intrinsics.areEqual(this.rawFeatureFlags, config.rawFeatureFlags) && Intrinsics.areEqual(this.products, config.products) && Intrinsics.areEqual(this.productsV3, config.productsV3) && Intrinsics.areEqual(this.preloadingDisabled, config.preloadingDisabled) && Intrinsics.areEqual(this.localizationConfig, config.localizationConfig) && Intrinsics.areEqual(this.requestId, config.requestId) && Intrinsics.areEqual(this.locales, config.locales) && Intrinsics.areEqual(this.webToAppConfig, config.webToAppConfig) && Intrinsics.areEqual(this.buildId, config.buildId) && Intrinsics.areEqual(this.bundleIdConfig, config.bundleIdConfig) && Intrinsics.areEqual(this.testModeUserIds, config.testModeUserIds) && Intrinsics.areEqual(this.prioritizedCampaignId, config.prioritizedCampaignId);
    }

    public final List<ComputedPropertyRequest> getAllComputedProperties() {
        Set<Trigger> set = this.triggers;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            List<TriggerRule> rules = ((Trigger) it.next()).getRules();
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it2 = rules.iterator();
            while (it2.hasNext()) {
                CollectionsKt.addAll(arrayList2, ((TriggerRule) it2.next()).getComputedPropertyRequests());
            }
            CollectionsKt.addAll(arrayList, arrayList2);
        }
        return arrayList;
    }

    public final long getAppSessionTimeout() {
        return this.appSessionTimeout;
    }

    public final String getBuildId() {
        return this.buildId;
    }

    public final String getBundleIdConfig() {
        return this.bundleIdConfig;
    }

    public final FeatureFlags getFeatureFlags() {
        Object obj;
        Object next;
        Object next2;
        Object next3;
        Object next4;
        Object next5;
        Object next6;
        Object next7;
        Iterator<T> it = this.rawFeatureFlags.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((RawFeatureFlag) next).getKey(), "enable_multiple_paywall_urls")) {
                break;
            }
        }
        RawFeatureFlag rawFeatureFlag = (RawFeatureFlag) next;
        boolean enabled = rawFeatureFlag != null ? rawFeatureFlag.getEnabled() : false;
        Iterator<T> it2 = this.rawFeatureFlags.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
            if (Intrinsics.areEqual(((RawFeatureFlag) next2).getKey(), "enable_config_refresh_v2")) {
                break;
            }
        }
        RawFeatureFlag rawFeatureFlag2 = (RawFeatureFlag) next2;
        boolean enabled2 = rawFeatureFlag2 != null ? rawFeatureFlag2.getEnabled() : false;
        Iterator<T> it3 = this.rawFeatureFlags.iterator();
        while (true) {
            if (!it3.hasNext()) {
                next3 = null;
                break;
            }
            next3 = it3.next();
            if (Intrinsics.areEqual(((RawFeatureFlag) next3).getKey(), "enable_session_events")) {
                break;
            }
        }
        RawFeatureFlag rawFeatureFlag3 = (RawFeatureFlag) next3;
        boolean enabled3 = rawFeatureFlag3 != null ? rawFeatureFlag3.getEnabled() : false;
        Iterator<T> it4 = this.rawFeatureFlags.iterator();
        while (true) {
            if (!it4.hasNext()) {
                next4 = null;
                break;
            }
            next4 = it4.next();
            if (Intrinsics.areEqual(((RawFeatureFlag) next4).getKey(), "enable_postback")) {
                break;
            }
        }
        RawFeatureFlag rawFeatureFlag4 = (RawFeatureFlag) next4;
        boolean enabled4 = rawFeatureFlag4 != null ? rawFeatureFlag4.getEnabled() : false;
        Iterator<T> it5 = this.rawFeatureFlags.iterator();
        while (true) {
            if (!it5.hasNext()) {
                next5 = null;
                break;
            }
            next5 = it5.next();
            if (Intrinsics.areEqual(((RawFeatureFlag) next5).getKey(), "enable_userid_seed")) {
                break;
            }
        }
        RawFeatureFlag rawFeatureFlag5 = (RawFeatureFlag) next5;
        boolean enabled5 = rawFeatureFlag5 != null ? rawFeatureFlag5.getEnabled() : false;
        Iterator<T> it6 = this.rawFeatureFlags.iterator();
        while (true) {
            if (!it6.hasNext()) {
                next6 = null;
                break;
            }
            next6 = it6.next();
            if (Intrinsics.areEqual(((RawFeatureFlag) next6).getKey(), "disable_verbose_events")) {
                break;
            }
        }
        RawFeatureFlag rawFeatureFlag6 = (RawFeatureFlag) next6;
        boolean enabled6 = rawFeatureFlag6 != null ? rawFeatureFlag6.getEnabled() : false;
        Iterator<T> it7 = this.rawFeatureFlags.iterator();
        while (true) {
            if (!it7.hasNext()) {
                next7 = null;
                break;
            }
            next7 = it7.next();
            if (Intrinsics.areEqual(((RawFeatureFlag) next7).getKey(), "enable_cel_logging")) {
                break;
            }
        }
        RawFeatureFlag rawFeatureFlag7 = (RawFeatureFlag) next7;
        boolean enabled7 = rawFeatureFlag7 != null ? rawFeatureFlag7.getEnabled() : false;
        Iterator<T> it8 = this.rawFeatureFlags.iterator();
        while (true) {
            if (!it8.hasNext()) {
                break;
            }
            Object next8 = it8.next();
            if (Intrinsics.areEqual(((RawFeatureFlag) next8).getKey(), "web_2_app")) {
                obj = next8;
                break;
            }
        }
        RawFeatureFlag rawFeatureFlag8 = (RawFeatureFlag) obj;
        return new FeatureFlags(enabled2, enabled3, enabled4, enabled5, enabled6, enabled, enabled7, rawFeatureFlag8 != null ? rawFeatureFlag8.getEnabled() : false);
    }

    public final Set<String> getLocales() {
        return this.locales;
    }

    public final LocalizationConfig getLocalizationConfig() {
        return this.localizationConfig;
    }

    public final int getLogLevel() {
        return this.logLevel;
    }

    public final List<Paywall> getPaywalls() {
        return this.paywalls;
    }

    public final PostbackRequest getPostback() {
        return this.postback;
    }

    public final PreloadingDisabled getPreloadingDisabled() {
        return this.preloadingDisabled;
    }

    public final String getPrioritizedCampaignId() {
        return this.prioritizedCampaignId;
    }

    public final List<ProductItem> getProducts() {
        return this.products;
    }

    public final List<CrossplatformProduct> getProductsV3() {
        return this.productsV3;
    }

    public final List<RawFeatureFlag> getRawFeatureFlags() {
        return this.rawFeatureFlags;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final List<TestStoreUser> getTestModeUserIds() {
        return this.testModeUserIds;
    }

    public final Set<Trigger> getTriggers() {
        return this.triggers;
    }

    public final WebToAppConfig getWebToAppConfig() {
        return this.webToAppConfig;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.triggers.hashCode() * 31) + this.paywalls.hashCode()) * 31) + Integer.hashCode(this.logLevel)) * 31) + this.postback.hashCode()) * 31) + Long.hashCode(this.appSessionTimeout)) * 31) + this.rawFeatureFlags.hashCode()) * 31) + this.products.hashCode()) * 31;
        List<CrossplatformProduct> list = this.productsV3;
        int iHashCode2 = (((((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + this.preloadingDisabled.hashCode()) * 31) + this.localizationConfig.hashCode()) * 31;
        String str = this.requestId;
        int iHashCode3 = (((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.locales.hashCode()) * 31;
        WebToAppConfig webToAppConfig = this.webToAppConfig;
        int iHashCode4 = (((iHashCode3 + (webToAppConfig == null ? 0 : webToAppConfig.hashCode())) * 31) + this.buildId.hashCode()) * 31;
        String str2 = this.bundleIdConfig;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<TestStoreUser> list2 = this.testModeUserIds;
        int iHashCode6 = (iHashCode5 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str3 = this.prioritizedCampaignId;
        return iHashCode6 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setAppSessionTimeout(long j3) {
        this.appSessionTimeout = j3;
    }

    public final void setLocales(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.locales = set;
    }

    public final void setLocalizationConfig(LocalizationConfig localizationConfig) {
        Intrinsics.checkNotNullParameter(localizationConfig, "<set-?>");
        this.localizationConfig = localizationConfig;
    }

    public final void setLogLevel(int i3) {
        this.logLevel = i3;
    }

    public final void setPaywalls(List<Paywall> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.paywalls = list;
    }

    public final void setPostback(PostbackRequest postbackRequest) {
        Intrinsics.checkNotNullParameter(postbackRequest, "<set-?>");
        this.postback = postbackRequest;
    }

    public final void setPreloadingDisabled(PreloadingDisabled preloadingDisabled) {
        Intrinsics.checkNotNullParameter(preloadingDisabled, "<set-?>");
        this.preloadingDisabled = preloadingDisabled;
    }

    public final void setRawFeatureFlags(List<RawFeatureFlag> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.rawFeatureFlags = list;
    }

    public final void setRequestId(String str) {
        this.requestId = str;
    }

    public final void setTriggers(Set<Trigger> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.triggers = set;
    }

    public final void setWebToAppConfig(WebToAppConfig webToAppConfig) {
        this.webToAppConfig = webToAppConfig;
    }

    public String toString() {
        return "Config(triggers=" + this.triggers + ", paywalls=" + this.paywalls + ", logLevel=" + this.logLevel + ", postback=" + this.postback + ", appSessionTimeout=" + this.appSessionTimeout + ", rawFeatureFlags=" + this.rawFeatureFlags + ", products=" + this.products + ", productsV3=" + this.productsV3 + ", preloadingDisabled=" + this.preloadingDisabled + ", localizationConfig=" + this.localizationConfig + ", requestId=" + this.requestId + ", locales=" + this.locales + ", webToAppConfig=" + this.webToAppConfig + ", buildId=" + this.buildId + ", bundleIdConfig=" + this.bundleIdConfig + ", testModeUserIds=" + this.testModeUserIds + ", prioritizedCampaignId=" + this.prioritizedCampaignId + ")";
    }

    public Config(Set<Trigger> triggers, List<Paywall> paywalls, int i3, PostbackRequest postback, long j3, List<RawFeatureFlag> rawFeatureFlags, List<ProductItem> products, List<CrossplatformProduct> list, PreloadingDisabled preloadingDisabled, LocalizationConfig localizationConfig, String str, Set<String> locales, WebToAppConfig webToAppConfig, String buildId, String str2, List<TestStoreUser> list2, String str3) {
        Intrinsics.checkNotNullParameter(triggers, "triggers");
        Intrinsics.checkNotNullParameter(paywalls, "paywalls");
        Intrinsics.checkNotNullParameter(postback, "postback");
        Intrinsics.checkNotNullParameter(rawFeatureFlags, "rawFeatureFlags");
        Intrinsics.checkNotNullParameter(products, "products");
        Intrinsics.checkNotNullParameter(preloadingDisabled, MrGIhy.VpNWGWklvk);
        Intrinsics.checkNotNullParameter(localizationConfig, "localizationConfig");
        Intrinsics.checkNotNullParameter(locales, "locales");
        Intrinsics.checkNotNullParameter(buildId, "buildId");
        this.triggers = triggers;
        this.paywalls = paywalls;
        this.logLevel = i3;
        this.postback = postback;
        this.appSessionTimeout = j3;
        this.rawFeatureFlags = rawFeatureFlags;
        this.products = products;
        this.productsV3 = list;
        this.preloadingDisabled = preloadingDisabled;
        this.localizationConfig = localizationConfig;
        this.requestId = str;
        this.locales = locales;
        this.webToAppConfig = webToAppConfig;
        this.buildId = buildId;
        this.bundleIdConfig = str2;
        this.testModeUserIds = list2;
        this.prioritizedCampaignId = str3;
        List<LocalizationConfig.LocaleConfig> locales2 = localizationConfig.getLocales();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(locales2, 10));
        Iterator<T> it = locales2.iterator();
        while (it.hasNext()) {
            arrayList.add(((LocalizationConfig.LocaleConfig) it.next()).getLocale());
        }
        this.locales = CollectionsKt.toSet(arrayList);
    }

    public /* synthetic */ Config(Set set, List list, int i3, PostbackRequest postbackRequest, long j3, List list2, List list3, List list4, PreloadingDisabled preloadingDisabled, LocalizationConfig localizationConfig, String str, Set set2, WebToAppConfig webToAppConfig, String str2, String str3, List list5, String str4, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, list, i3, postbackRequest, j3, list2, list3, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : list4, preloadingDisabled, localizationConfig, (i4 & 1024) != 0 ? null : str, (i4 & 2048) != 0 ? SetsKt.emptySet() : set2, (i4 & 4096) != 0 ? null : webToAppConfig, str2, (i4 & 16384) != 0 ? null : str3, (32768 & i4) != 0 ? null : list5, (i4 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? null : str4);
    }
}
