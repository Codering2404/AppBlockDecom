package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.utils.serializers.GoogleListSerializer;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
import com.sun.jna.Function;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Serializable
public final class PaywallComponentsData {
    private final URL assetBaseURL;
    private final ComponentsConfig componentsConfig;
    private final Map<LocaleId, Map<LocalizationKey, LocalizationData>> componentsLocalizations;
    private final String defaultLocaleIdentifier;
    private final ExitOffers exitOffers;
    private final String id;
    private final ProductChangeConfig productChangeConfig;
    private final int revision;
    private final String templateName;
    private final List<String> zeroDecimalPlaceCountries;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, new LinkedHashMapSerializer(LocaleId$$serializer.INSTANCE, new LinkedHashMapSerializer(LocalizationKey$$serializer.INSTANCE, LocalizationDataSerializer.INSTANCE)), null, null, null, null, null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PaywallComponentsData> serializer() {
            return PaywallComponentsData$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ PaywallComponentsData(int i3, String str, @SerialName String str2, @SerialName @Serializable(with = URLSerializer.class) URL url, @SerialName ComponentsConfig componentsConfig, @SerialName Map map, @SerialName String str3, int i4, @SerialName @Serializable(with = GoogleListSerializer.class) List list, @SerialName ExitOffers exitOffers, @SerialName @Serializable(with = ProductChangeConfigSerializer.class) ProductChangeConfig productChangeConfig, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, str2, url, componentsConfig, (Map<LocaleId, ? extends Map<LocalizationKey, ? extends LocalizationData>>) map, str3, i4, (List<String>) list, exitOffers, productChangeConfig, serializationConstructorMarker);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PaywallComponentsData paywallComponentsData, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (compositeEncoder.z(serialDescriptor, 0) || paywallComponentsData.id != null) {
            compositeEncoder.i(serialDescriptor, 0, StringSerializer.f142891a, paywallComponentsData.id);
        }
        compositeEncoder.y(serialDescriptor, 1, paywallComponentsData.templateName);
        compositeEncoder.C(serialDescriptor, 2, URLSerializer.INSTANCE, paywallComponentsData.assetBaseURL);
        compositeEncoder.C(serialDescriptor, 3, ComponentsConfig$$serializer.INSTANCE, paywallComponentsData.componentsConfig);
        compositeEncoder.C(serialDescriptor, 4, kSerializerArr[4], paywallComponentsData.componentsLocalizations);
        compositeEncoder.C(serialDescriptor, 5, LocaleId$$serializer.INSTANCE, LocaleId.m612boximpl(paywallComponentsData.defaultLocaleIdentifier));
        if (compositeEncoder.z(serialDescriptor, 6) || paywallComponentsData.revision != 0) {
            compositeEncoder.w(serialDescriptor, 6, paywallComponentsData.revision);
        }
        if (compositeEncoder.z(serialDescriptor, 7) || !Intrinsics.areEqual(paywallComponentsData.zeroDecimalPlaceCountries, CollectionsKt.emptyList())) {
            compositeEncoder.C(serialDescriptor, 7, GoogleListSerializer.INSTANCE, paywallComponentsData.zeroDecimalPlaceCountries);
        }
        if (compositeEncoder.z(serialDescriptor, 8) || paywallComponentsData.exitOffers != null) {
            compositeEncoder.i(serialDescriptor, 8, ExitOffers$$serializer.INSTANCE, paywallComponentsData.exitOffers);
        }
        if (!compositeEncoder.z(serialDescriptor, 9) && paywallComponentsData.productChangeConfig == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 9, ProductChangeConfigSerializer.INSTANCE, paywallComponentsData.productChangeConfig);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallComponentsData)) {
            return false;
        }
        PaywallComponentsData paywallComponentsData = (PaywallComponentsData) obj;
        return Intrinsics.areEqual(this.id, paywallComponentsData.id) && Intrinsics.areEqual(this.templateName, paywallComponentsData.templateName) && Intrinsics.areEqual(this.assetBaseURL, paywallComponentsData.assetBaseURL) && Intrinsics.areEqual(this.componentsConfig, paywallComponentsData.componentsConfig) && Intrinsics.areEqual(this.componentsLocalizations, paywallComponentsData.componentsLocalizations) && LocaleId.m615equalsimpl0(this.defaultLocaleIdentifier, paywallComponentsData.defaultLocaleIdentifier) && this.revision == paywallComponentsData.revision && Intrinsics.areEqual(this.zeroDecimalPlaceCountries, paywallComponentsData.zeroDecimalPlaceCountries) && Intrinsics.areEqual(this.exitOffers, paywallComponentsData.exitOffers) && Intrinsics.areEqual(this.productChangeConfig, paywallComponentsData.productChangeConfig);
    }

    public final /* synthetic */ URL getAssetBaseURL() {
        return this.assetBaseURL;
    }

    public final /* synthetic */ ComponentsConfig getComponentsConfig() {
        return this.componentsConfig;
    }

    public final /* synthetic */ Map getComponentsLocalizations() {
        return this.componentsLocalizations;
    }

    /* JADX INFO: renamed from: getDefaultLocaleIdentifier-uqtKvyA, reason: not valid java name */
    public final /* synthetic */ String m658getDefaultLocaleIdentifieruqtKvyA() {
        return this.defaultLocaleIdentifier;
    }

    public final /* synthetic */ ExitOffers getExitOffers() {
        return this.exitOffers;
    }

    public final /* synthetic */ String getId() {
        return this.id;
    }

    public final /* synthetic */ ProductChangeConfig getProductChangeConfig() {
        return this.productChangeConfig;
    }

    public final /* synthetic */ int getRevision() {
        return this.revision;
    }

    public final /* synthetic */ String getTemplateName() {
        return this.templateName;
    }

    public final /* synthetic */ List getZeroDecimalPlaceCountries() {
        return this.zeroDecimalPlaceCountries;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (((((((((((((((str == null ? 0 : str.hashCode()) * 31) + this.templateName.hashCode()) * 31) + this.assetBaseURL.hashCode()) * 31) + this.componentsConfig.hashCode()) * 31) + this.componentsLocalizations.hashCode()) * 31) + LocaleId.m616hashCodeimpl(this.defaultLocaleIdentifier)) * 31) + this.revision) * 31) + this.zeroDecimalPlaceCountries.hashCode()) * 31;
        ExitOffers exitOffers = this.exitOffers;
        int iHashCode2 = (iHashCode + (exitOffers == null ? 0 : exitOffers.hashCode())) * 31;
        ProductChangeConfig productChangeConfig = this.productChangeConfig;
        return iHashCode2 + (productChangeConfig != null ? productChangeConfig.hashCode() : 0);
    }

    public String toString() {
        return "PaywallComponentsData(id=" + this.id + ", templateName=" + this.templateName + ", assetBaseURL=" + this.assetBaseURL + ", componentsConfig=" + this.componentsConfig + ", componentsLocalizations=" + this.componentsLocalizations + ", defaultLocaleIdentifier=" + ((Object) LocaleId.m617toStringimpl(this.defaultLocaleIdentifier)) + ", revision=" + this.revision + ", zeroDecimalPlaceCountries=" + this.zeroDecimalPlaceCountries + ", exitOffers=" + this.exitOffers + ", productChangeConfig=" + this.productChangeConfig + ')';
    }

    public /* synthetic */ PaywallComponentsData(String str, String str2, URL url, ComponentsConfig componentsConfig, Map map, String str3, int i3, List list, ExitOffers exitOffers, ProductChangeConfig productChangeConfig, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, url, componentsConfig, map, str3, i3, list, exitOffers, productChangeConfig);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private PaywallComponentsData(int i3, String str, String str2, URL url, ComponentsConfig componentsConfig, Map<LocaleId, ? extends Map<LocalizationKey, ? extends LocalizationData>> map, String str3, int i4, List<String> list, ExitOffers exitOffers, ProductChangeConfig productChangeConfig, SerializationConstructorMarker serializationConstructorMarker) {
        if (62 != (i3 & 62)) {
            PluginExceptionsKt.b(i3, 62, PaywallComponentsData$$serializer.INSTANCE.getDescriptor());
        }
        if ((i3 & 1) == 0) {
            this.id = null;
        } else {
            this.id = str;
        }
        this.templateName = str2;
        this.assetBaseURL = url;
        this.componentsConfig = componentsConfig;
        this.componentsLocalizations = map;
        this.defaultLocaleIdentifier = str3;
        if ((i3 & 64) == 0) {
            this.revision = 0;
        } else {
            this.revision = i4;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
            this.zeroDecimalPlaceCountries = CollectionsKt.emptyList();
        } else {
            this.zeroDecimalPlaceCountries = list;
        }
        if ((i3 & Function.MAX_NARGS) == 0) {
            this.exitOffers = null;
        } else {
            this.exitOffers = exitOffers;
        }
        if ((i3 & 512) == 0) {
            this.productChangeConfig = null;
        } else {
            this.productChangeConfig = productChangeConfig;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private PaywallComponentsData(String str, String templateName, URL assetBaseURL, ComponentsConfig componentsConfig, Map<LocaleId, ? extends Map<LocalizationKey, ? extends LocalizationData>> componentsLocalizations, String defaultLocaleIdentifier, int i3, List<String> zeroDecimalPlaceCountries, ExitOffers exitOffers, ProductChangeConfig productChangeConfig) {
        Intrinsics.checkNotNullParameter(templateName, "templateName");
        Intrinsics.checkNotNullParameter(assetBaseURL, "assetBaseURL");
        Intrinsics.checkNotNullParameter(componentsConfig, "componentsConfig");
        Intrinsics.checkNotNullParameter(componentsLocalizations, "componentsLocalizations");
        Intrinsics.checkNotNullParameter(defaultLocaleIdentifier, "defaultLocaleIdentifier");
        Intrinsics.checkNotNullParameter(zeroDecimalPlaceCountries, "zeroDecimalPlaceCountries");
        this.id = str;
        this.templateName = templateName;
        this.assetBaseURL = assetBaseURL;
        this.componentsConfig = componentsConfig;
        this.componentsLocalizations = componentsLocalizations;
        this.defaultLocaleIdentifier = defaultLocaleIdentifier;
        this.revision = i3;
        this.zeroDecimalPlaceCountries = zeroDecimalPlaceCountries;
        this.exitOffers = exitOffers;
        this.productChangeConfig = productChangeConfig;
    }

    @SerialName
    @Serializable(with = URLSerializer.class)
    public static /* synthetic */ void getAssetBaseURL$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getComponentsConfig$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getComponentsLocalizations$annotations() {
    }

    @SerialName
    /* JADX INFO: renamed from: getDefaultLocaleIdentifier-uqtKvyA$annotations, reason: not valid java name */
    public static /* synthetic */ void m657getDefaultLocaleIdentifieruqtKvyA$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getExitOffers$annotations() {
    }

    @SerialName
    @Serializable(with = ProductChangeConfigSerializer.class)
    public static /* synthetic */ void getProductChangeConfig$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getTemplateName$annotations() {
    }

    @SerialName
    @Serializable(with = GoogleListSerializer.class)
    public static /* synthetic */ void getZeroDecimalPlaceCountries$annotations() {
    }

    public /* synthetic */ PaywallComponentsData(String str, String str2, URL url, ComponentsConfig componentsConfig, Map map, String str3, int i3, List list, ExitOffers exitOffers, ProductChangeConfig productChangeConfig, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : str, str2, url, componentsConfig, map, str3, (i4 & 64) != 0 ? 0 : i3, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? CollectionsKt.emptyList() : list, (i4 & Function.MAX_NARGS) != 0 ? null : exitOffers, (i4 & 512) != 0 ? null : productChangeConfig, null);
    }
}
