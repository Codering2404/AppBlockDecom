package com.revenuecat.purchases.paywalls;

import com.facebook.internal.Utility;
import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.utils.LocaleExtensionsKt;
import com.revenuecat.purchases.utils.serializers.GoogleListSerializer;
import com.revenuecat.purchases.utils.serializers.OptionalURLSerializer;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
import com.sun.jna.Function;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
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
public final class PaywallData {
    private static final KSerializer<Object>[] $childSerializers;
    public static final Companion Companion = new Companion(null);
    private final URL assetBaseURL;
    private final Configuration config;
    private final String defaultLocale;
    private final String id;
    private final Map<String, LocalizedConfiguration> localization;
    private final Map<String, Map<String, LocalizedConfiguration>> localizationByTier;
    private final int revision;
    private final String templateName;
    private final List<String> zeroDecimalPlaceCountries;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PaywallData> serializer() {
            return PaywallData$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        PaywallData$LocalizedConfiguration$$serializer paywallData$LocalizedConfiguration$$serializer = PaywallData$LocalizedConfiguration$$serializer.INSTANCE;
        $childSerializers = new KSerializer[]{null, null, null, null, null, new LinkedHashMapSerializer(stringSerializer, paywallData$LocalizedConfiguration$$serializer), new LinkedHashMapSerializer(stringSerializer, new LinkedHashMapSerializer(stringSerializer, paywallData$LocalizedConfiguration$$serializer)), null, null};
    }

    @Deprecated
    public /* synthetic */ PaywallData(int i3, String str, @SerialName String str2, Configuration configuration, @SerialName @Serializable(with = URLSerializer.class) URL url, int i4, @SerialName Map map, @SerialName Map map2, @SerialName @Serializable(with = GoogleListSerializer.class) List list, @SerialName String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (46 != (i3 & 46)) {
            PluginExceptionsKt.b(i3, 46, PaywallData$$serializer.INSTANCE.getDescriptor());
        }
        if ((i3 & 1) == 0) {
            this.id = null;
        } else {
            this.id = str;
        }
        this.templateName = str2;
        this.config = configuration;
        this.assetBaseURL = url;
        if ((i3 & 16) == 0) {
            this.revision = 0;
        } else {
            this.revision = i4;
        }
        this.localization = map;
        if ((i3 & 64) == 0) {
            this.localizationByTier = MapsKt.emptyMap();
        } else {
            this.localizationByTier = map2;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
            this.zeroDecimalPlaceCountries = CollectionsKt.emptyList();
        } else {
            this.zeroDecimalPlaceCountries = list;
        }
        if ((i3 & Function.MAX_NARGS) == 0) {
            this.defaultLocale = null;
        } else {
            this.defaultLocale = str3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PaywallData copy$default(PaywallData paywallData, String str, Configuration configuration, URL url, int i3, Map map, Map map2, List list, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = paywallData.templateName;
        }
        if ((i4 & 2) != 0) {
            configuration = paywallData.config;
        }
        if ((i4 & 4) != 0) {
            url = paywallData.assetBaseURL;
        }
        if ((i4 & 8) != 0) {
            i3 = paywallData.revision;
        }
        if ((i4 & 16) != 0) {
            map = paywallData.localization;
        }
        if ((i4 & 32) != 0) {
            map2 = paywallData.localizationByTier;
        }
        if ((i4 & 64) != 0) {
            list = paywallData.zeroDecimalPlaceCountries;
        }
        if ((i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            str2 = paywallData.defaultLocale;
        }
        List list2 = list;
        String str3 = str2;
        Map map3 = map;
        Map map4 = map2;
        return paywallData.copy(str, configuration, url, i3, map3, map4, list2, str3);
    }

    private final Pair<Locale, Map<String, LocalizedConfiguration>> tieredConfigForLocales(List<Locale> list) {
        Object next;
        Iterator<Locale> it = list.iterator();
        while (it.hasNext()) {
            Locale localeConvertToCorrectlyFormattedLocale = LocaleExtensionsKt.convertToCorrectlyFormattedLocale(it.next());
            Map<String, LocalizedConfiguration> mapTieredConfigForLocale = tieredConfigForLocale(localeConvertToCorrectlyFormattedLocale);
            if (mapTieredConfigForLocale != null) {
                return TuplesKt.a(localeConvertToCorrectlyFormattedLocale, mapTieredConfigForLocale);
            }
        }
        String str = this.defaultLocale;
        if (str != null) {
            Iterator<T> it2 = this.localizationByTier.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                if (Intrinsics.areEqual(LocaleExtensionsKt.toLocale((String) ((Map.Entry) next).getKey()), LocaleExtensionsKt.toLocale(str))) {
                    break;
                }
            }
            Map.Entry entry = (Map.Entry) next;
            if (entry != null) {
                return TuplesKt.a(LocaleExtensionsKt.toLocale((String) entry.getKey()), entry.getValue());
            }
        }
        Map.Entry entry2 = (Map.Entry) CollectionsKt.first(this.localizationByTier.entrySet());
        return TuplesKt.a(LocaleExtensionsKt.toLocale((String) entry2.getKey()), entry2.getValue());
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PaywallData paywallData, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (compositeEncoder.z(serialDescriptor, 0) || paywallData.id != null) {
            compositeEncoder.i(serialDescriptor, 0, StringSerializer.f142891a, paywallData.id);
        }
        compositeEncoder.y(serialDescriptor, 1, paywallData.templateName);
        compositeEncoder.C(serialDescriptor, 2, PaywallData$Configuration$$serializer.INSTANCE, paywallData.config);
        compositeEncoder.C(serialDescriptor, 3, URLSerializer.INSTANCE, paywallData.assetBaseURL);
        if (compositeEncoder.z(serialDescriptor, 4) || paywallData.revision != 0) {
            compositeEncoder.w(serialDescriptor, 4, paywallData.revision);
        }
        compositeEncoder.C(serialDescriptor, 5, kSerializerArr[5], paywallData.localization);
        if (compositeEncoder.z(serialDescriptor, 6) || !Intrinsics.areEqual(paywallData.localizationByTier, MapsKt.emptyMap())) {
            compositeEncoder.C(serialDescriptor, 6, kSerializerArr[6], paywallData.localizationByTier);
        }
        if (compositeEncoder.z(serialDescriptor, 7) || !Intrinsics.areEqual(paywallData.zeroDecimalPlaceCountries, CollectionsKt.emptyList())) {
            compositeEncoder.C(serialDescriptor, 7, GoogleListSerializer.INSTANCE, paywallData.zeroDecimalPlaceCountries);
        }
        if (!compositeEncoder.z(serialDescriptor, 8) && paywallData.defaultLocale == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 8, StringSerializer.f142891a, paywallData.defaultLocale);
    }

    public final LocalizedConfiguration configForLocale(Locale requiredLocale) {
        Object next;
        Intrinsics.checkNotNullParameter(requiredLocale, "requiredLocale");
        LocalizedConfiguration localizedConfiguration = this.localization.get(requiredLocale.toString());
        if (localizedConfiguration != null) {
            return localizedConfiguration;
        }
        Iterator<T> it = this.localization.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (LocaleExtensionsKt.sharedLanguageCodeWith(requiredLocale, LocaleExtensionsKt.toLocale((String) ((Map.Entry) next).getKey()))) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (LocalizedConfiguration) entry.getValue();
        }
        return null;
    }

    public final PaywallData copy(String templateName, Configuration config, URL assetBaseURL, int i3, Map<String, LocalizedConfiguration> localization, Map<String, ? extends Map<String, LocalizedConfiguration>> localizationByTier, List<String> zeroDecimalPlaceCountries, String str) {
        Intrinsics.checkNotNullParameter(templateName, "templateName");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(assetBaseURL, "assetBaseURL");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(localizationByTier, "localizationByTier");
        Intrinsics.checkNotNullParameter(zeroDecimalPlaceCountries, "zeroDecimalPlaceCountries");
        return new PaywallData((String) null, templateName, config, assetBaseURL, i3, localization, localizationByTier, zeroDecimalPlaceCountries, str, 1, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallData)) {
            return false;
        }
        PaywallData paywallData = (PaywallData) obj;
        return Intrinsics.areEqual(this.id, paywallData.id) && Intrinsics.areEqual(this.templateName, paywallData.templateName) && Intrinsics.areEqual(this.config, paywallData.config) && Intrinsics.areEqual(this.assetBaseURL, paywallData.assetBaseURL) && this.revision == paywallData.revision && Intrinsics.areEqual(this.localization, paywallData.localization) && Intrinsics.areEqual(this.localizationByTier, paywallData.localizationByTier) && Intrinsics.areEqual(this.zeroDecimalPlaceCountries, paywallData.zeroDecimalPlaceCountries) && Intrinsics.areEqual(this.defaultLocale, paywallData.defaultLocale);
    }

    public final URL getAssetBaseURL() {
        return this.assetBaseURL;
    }

    public final Configuration getConfig() {
        return this.config;
    }

    public final String getDefaultLocale() {
        return this.defaultLocale;
    }

    public final String getId() {
        return this.id;
    }

    public final Map<String, LocalizedConfiguration> getLocalization$purchases_defaultsBc8Release() {
        return this.localization;
    }

    public final Map<String, Map<String, LocalizedConfiguration>> getLocalizationByTier$purchases_defaultsBc8Release() {
        return this.localizationByTier;
    }

    public final Pair<Locale, LocalizedConfiguration> getLocalizedConfiguration() {
        return localizedConfiguration(LocaleExtensionsKt.getDefaultLocales());
    }

    public final int getRevision() {
        return this.revision;
    }

    public final String getTemplateName() {
        return this.templateName;
    }

    public final Pair<Locale, Map<String, LocalizedConfiguration>> getTieredLocalizedConfiguration() {
        return tieredConfigForLocales(LocaleExtensionsKt.getDefaultLocales());
    }

    public final List<String> getZeroDecimalPlaceCountries() {
        return this.zeroDecimalPlaceCountries;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (((((((((((((((str == null ? 0 : str.hashCode()) * 31) + this.templateName.hashCode()) * 31) + this.config.hashCode()) * 31) + this.assetBaseURL.hashCode()) * 31) + this.revision) * 31) + this.localization.hashCode()) * 31) + this.localizationByTier.hashCode()) * 31) + this.zeroDecimalPlaceCountries.hashCode()) * 31;
        String str2 = this.defaultLocale;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final Pair<Locale, LocalizedConfiguration> localizedConfiguration(List<Locale> locales) {
        Object next;
        Intrinsics.checkNotNullParameter(locales, "locales");
        Iterator<Locale> it = locales.iterator();
        while (it.hasNext()) {
            Locale localeConvertToCorrectlyFormattedLocale = LocaleExtensionsKt.convertToCorrectlyFormattedLocale(it.next());
            LocalizedConfiguration localizedConfigurationConfigForLocale = configForLocale(localeConvertToCorrectlyFormattedLocale);
            if (localizedConfigurationConfigForLocale != null) {
                return TuplesKt.a(localeConvertToCorrectlyFormattedLocale, localizedConfigurationConfigForLocale);
            }
        }
        String str = this.defaultLocale;
        if (str != null) {
            Iterator<T> it2 = this.localization.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                if (Intrinsics.areEqual(LocaleExtensionsKt.toLocale((String) ((Map.Entry) next).getKey()), LocaleExtensionsKt.toLocale(str))) {
                    break;
                }
            }
            Map.Entry entry = (Map.Entry) next;
            if (entry != null) {
                return TuplesKt.a(LocaleExtensionsKt.toLocale((String) entry.getKey()), entry.getValue());
            }
        }
        Map.Entry entry2 = (Map.Entry) CollectionsKt.first(this.localization.entrySet());
        return TuplesKt.a(LocaleExtensionsKt.toLocale((String) entry2.getKey()), entry2.getValue());
    }

    public final Map<String, LocalizedConfiguration> tieredConfigForLocale(Locale requiredLocale) {
        Object next;
        Intrinsics.checkNotNullParameter(requiredLocale, "requiredLocale");
        Map<String, LocalizedConfiguration> map = this.localizationByTier.get(requiredLocale.toString());
        if (map != null) {
            return map;
        }
        Iterator<T> it = this.localizationByTier.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (LocaleExtensionsKt.sharedLanguageCodeWith(requiredLocale, LocaleExtensionsKt.toLocale((String) ((Map.Entry) next).getKey()))) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (Map) entry.getValue();
        }
        return null;
    }

    public String toString() {
        return "PaywallData(id=" + this.id + ", templateName=" + this.templateName + ", config=" + this.config + ", assetBaseURL=" + this.assetBaseURL + ", revision=" + this.revision + ", localization=" + this.localization + ", localizationByTier=" + this.localizationByTier + ", zeroDecimalPlaceCountries=" + this.zeroDecimalPlaceCountries + ", defaultLocale=" + this.defaultLocale + ')';
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Configuration {
        private static final KSerializer<Object>[] $childSerializers;
        public static final Companion Companion = new Companion(null);
        private final boolean blurredBackgroundImage;
        private final ColorInformation colors;
        private final Map<String, ColorInformation> colorsByTier;
        private final String defaultPackage;
        private final String defaultTier;
        private final boolean displayRestorePurchases;
        private final Map<String, Images> imagesByTier;
        private final Images imagesWebp;
        private final Images legacyImages;
        private final List<String> packageIds;
        private final URL privacyURL;
        private final URL termsOfServiceURL;
        private final List<Tier> tiers;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class ColorInformation {
            public static final Companion Companion = new Companion(null);
            private final Colors dark;
            private final Colors light;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<ColorInformation> serializer() {
                    return PaywallData$Configuration$ColorInformation$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            @Deprecated
            public /* synthetic */ ColorInformation(int i3, Colors colors, Colors colors2, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i3 & 1)) {
                    PluginExceptionsKt.b(i3, 1, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE.getDescriptor());
                }
                this.light = colors;
                if ((i3 & 2) == 0) {
                    this.dark = null;
                } else {
                    this.dark = colors2;
                }
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(ColorInformation colorInformation, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                PaywallData$Configuration$Colors$$serializer paywallData$Configuration$Colors$$serializer = PaywallData$Configuration$Colors$$serializer.INSTANCE;
                compositeEncoder.C(serialDescriptor, 0, paywallData$Configuration$Colors$$serializer, colorInformation.light);
                if (!compositeEncoder.z(serialDescriptor, 1) && colorInformation.dark == null) {
                    return;
                }
                compositeEncoder.i(serialDescriptor, 1, paywallData$Configuration$Colors$$serializer, colorInformation.dark);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ColorInformation)) {
                    return false;
                }
                ColorInformation colorInformation = (ColorInformation) obj;
                return Intrinsics.areEqual(this.light, colorInformation.light) && Intrinsics.areEqual(this.dark, colorInformation.dark);
            }

            public final Colors getDark() {
                return this.dark;
            }

            public final Colors getLight() {
                return this.light;
            }

            public int hashCode() {
                int iHashCode = this.light.hashCode() * 31;
                Colors colors = this.dark;
                return iHashCode + (colors == null ? 0 : colors.hashCode());
            }

            public String toString() {
                return "ColorInformation(light=" + this.light + ", dark=" + this.dark + ')';
            }

            public ColorInformation(Colors light, Colors colors) {
                Intrinsics.checkNotNullParameter(light, "light");
                this.light = light;
                this.dark = colors;
            }

            public /* synthetic */ ColorInformation(Colors colors, Colors colors2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(colors, (i3 & 2) != 0 ? null : colors2);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Colors {
            public static final Companion Companion = new Companion(null);
            private final PaywallColor accent1;
            private final PaywallColor accent2;
            private final PaywallColor accent3;
            private final PaywallColor background;
            private final PaywallColor callToActionBackground;
            private final PaywallColor callToActionForeground;
            private final PaywallColor callToActionSecondaryBackground;
            private final PaywallColor closeButton;
            private final PaywallColor text1;
            private final PaywallColor text2;
            private final PaywallColor text3;
            private final PaywallColor tierControlBackground;
            private final PaywallColor tierControlForeground;
            private final PaywallColor tierControlSelectedBackground;
            private final PaywallColor tierControlSelectedForeground;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<Colors> serializer() {
                    return PaywallData$Configuration$Colors$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            @Deprecated
            public /* synthetic */ Colors(int i3, @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor, @SerialName @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor2, @SerialName @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor3, @SerialName @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor4, @SerialName @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor5, @SerialName @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor6, @SerialName @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor7, @SerialName @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor8, @SerialName @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor9, @SerialName @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor10, @SerialName @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor11, @SerialName @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor12, @SerialName @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor13, @SerialName @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor14, @SerialName @Serializable(with = PaywallColor.Serializer.class) PaywallColor paywallColor15, SerializationConstructorMarker serializationConstructorMarker) {
                if (51 != (i3 & 51)) {
                    PluginExceptionsKt.b(i3, 51, PaywallData$Configuration$Colors$$serializer.INSTANCE.getDescriptor());
                }
                this.background = paywallColor;
                this.text1 = paywallColor2;
                if ((i3 & 4) == 0) {
                    this.text2 = null;
                } else {
                    this.text2 = paywallColor3;
                }
                if ((i3 & 8) == 0) {
                    this.text3 = null;
                } else {
                    this.text3 = paywallColor4;
                }
                this.callToActionBackground = paywallColor5;
                this.callToActionForeground = paywallColor6;
                if ((i3 & 64) == 0) {
                    this.callToActionSecondaryBackground = null;
                } else {
                    this.callToActionSecondaryBackground = paywallColor7;
                }
                if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
                    this.accent1 = null;
                } else {
                    this.accent1 = paywallColor8;
                }
                if ((i3 & Function.MAX_NARGS) == 0) {
                    this.accent2 = null;
                } else {
                    this.accent2 = paywallColor9;
                }
                if ((i3 & 512) == 0) {
                    this.accent3 = null;
                } else {
                    this.accent3 = paywallColor10;
                }
                if ((i3 & 1024) == 0) {
                    this.closeButton = null;
                } else {
                    this.closeButton = paywallColor11;
                }
                if ((i3 & 2048) == 0) {
                    this.tierControlBackground = null;
                } else {
                    this.tierControlBackground = paywallColor12;
                }
                if ((i3 & 4096) == 0) {
                    this.tierControlForeground = null;
                } else {
                    this.tierControlForeground = paywallColor13;
                }
                if ((i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
                    this.tierControlSelectedBackground = null;
                } else {
                    this.tierControlSelectedBackground = paywallColor14;
                }
                if ((i3 & 16384) == 0) {
                    this.tierControlSelectedForeground = null;
                } else {
                    this.tierControlSelectedForeground = paywallColor15;
                }
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Colors colors, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                PaywallColor.Serializer serializer = PaywallColor.Serializer.INSTANCE;
                compositeEncoder.C(serialDescriptor, 0, serializer, colors.background);
                compositeEncoder.C(serialDescriptor, 1, serializer, colors.text1);
                if (compositeEncoder.z(serialDescriptor, 2) || colors.text2 != null) {
                    compositeEncoder.i(serialDescriptor, 2, serializer, colors.text2);
                }
                if (compositeEncoder.z(serialDescriptor, 3) || colors.text3 != null) {
                    compositeEncoder.i(serialDescriptor, 3, serializer, colors.text3);
                }
                compositeEncoder.C(serialDescriptor, 4, serializer, colors.callToActionBackground);
                compositeEncoder.C(serialDescriptor, 5, serializer, colors.callToActionForeground);
                if (compositeEncoder.z(serialDescriptor, 6) || colors.callToActionSecondaryBackground != null) {
                    compositeEncoder.i(serialDescriptor, 6, serializer, colors.callToActionSecondaryBackground);
                }
                if (compositeEncoder.z(serialDescriptor, 7) || colors.accent1 != null) {
                    compositeEncoder.i(serialDescriptor, 7, serializer, colors.accent1);
                }
                if (compositeEncoder.z(serialDescriptor, 8) || colors.accent2 != null) {
                    compositeEncoder.i(serialDescriptor, 8, serializer, colors.accent2);
                }
                if (compositeEncoder.z(serialDescriptor, 9) || colors.accent3 != null) {
                    compositeEncoder.i(serialDescriptor, 9, serializer, colors.accent3);
                }
                if (compositeEncoder.z(serialDescriptor, 10) || colors.closeButton != null) {
                    compositeEncoder.i(serialDescriptor, 10, serializer, colors.closeButton);
                }
                if (compositeEncoder.z(serialDescriptor, 11) || colors.tierControlBackground != null) {
                    compositeEncoder.i(serialDescriptor, 11, serializer, colors.tierControlBackground);
                }
                if (compositeEncoder.z(serialDescriptor, 12) || colors.tierControlForeground != null) {
                    compositeEncoder.i(serialDescriptor, 12, serializer, colors.tierControlForeground);
                }
                if (compositeEncoder.z(serialDescriptor, 13) || colors.tierControlSelectedBackground != null) {
                    compositeEncoder.i(serialDescriptor, 13, serializer, colors.tierControlSelectedBackground);
                }
                if (!compositeEncoder.z(serialDescriptor, 14) && colors.tierControlSelectedForeground == null) {
                    return;
                }
                compositeEncoder.i(serialDescriptor, 14, serializer, colors.tierControlSelectedForeground);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Colors)) {
                    return false;
                }
                Colors colors = (Colors) obj;
                return Intrinsics.areEqual(this.background, colors.background) && Intrinsics.areEqual(this.text1, colors.text1) && Intrinsics.areEqual(this.text2, colors.text2) && Intrinsics.areEqual(this.text3, colors.text3) && Intrinsics.areEqual(this.callToActionBackground, colors.callToActionBackground) && Intrinsics.areEqual(this.callToActionForeground, colors.callToActionForeground) && Intrinsics.areEqual(this.callToActionSecondaryBackground, colors.callToActionSecondaryBackground) && Intrinsics.areEqual(this.accent1, colors.accent1) && Intrinsics.areEqual(this.accent2, colors.accent2) && Intrinsics.areEqual(this.accent3, colors.accent3) && Intrinsics.areEqual(this.closeButton, colors.closeButton) && Intrinsics.areEqual(this.tierControlBackground, colors.tierControlBackground) && Intrinsics.areEqual(this.tierControlForeground, colors.tierControlForeground) && Intrinsics.areEqual(this.tierControlSelectedBackground, colors.tierControlSelectedBackground) && Intrinsics.areEqual(this.tierControlSelectedForeground, colors.tierControlSelectedForeground);
            }

            public final PaywallColor getAccent1() {
                return this.accent1;
            }

            public final PaywallColor getAccent2() {
                return this.accent2;
            }

            public final PaywallColor getAccent3() {
                return this.accent3;
            }

            public final PaywallColor getBackground() {
                return this.background;
            }

            public final PaywallColor getCallToActionBackground() {
                return this.callToActionBackground;
            }

            public final PaywallColor getCallToActionForeground() {
                return this.callToActionForeground;
            }

            public final PaywallColor getCallToActionSecondaryBackground() {
                return this.callToActionSecondaryBackground;
            }

            public final PaywallColor getCloseButton() {
                return this.closeButton;
            }

            public final PaywallColor getText1() {
                return this.text1;
            }

            public final PaywallColor getText2() {
                return this.text2;
            }

            public final PaywallColor getText3() {
                return this.text3;
            }

            public final PaywallColor getTierControlBackground() {
                return this.tierControlBackground;
            }

            public final PaywallColor getTierControlForeground() {
                return this.tierControlForeground;
            }

            public final PaywallColor getTierControlSelectedBackground() {
                return this.tierControlSelectedBackground;
            }

            public final PaywallColor getTierControlSelectedForeground() {
                return this.tierControlSelectedForeground;
            }

            public int hashCode() {
                int iHashCode = ((this.background.hashCode() * 31) + this.text1.hashCode()) * 31;
                PaywallColor paywallColor = this.text2;
                int iHashCode2 = (iHashCode + (paywallColor == null ? 0 : paywallColor.hashCode())) * 31;
                PaywallColor paywallColor2 = this.text3;
                int iHashCode3 = (((((iHashCode2 + (paywallColor2 == null ? 0 : paywallColor2.hashCode())) * 31) + this.callToActionBackground.hashCode()) * 31) + this.callToActionForeground.hashCode()) * 31;
                PaywallColor paywallColor3 = this.callToActionSecondaryBackground;
                int iHashCode4 = (iHashCode3 + (paywallColor3 == null ? 0 : paywallColor3.hashCode())) * 31;
                PaywallColor paywallColor4 = this.accent1;
                int iHashCode5 = (iHashCode4 + (paywallColor4 == null ? 0 : paywallColor4.hashCode())) * 31;
                PaywallColor paywallColor5 = this.accent2;
                int iHashCode6 = (iHashCode5 + (paywallColor5 == null ? 0 : paywallColor5.hashCode())) * 31;
                PaywallColor paywallColor6 = this.accent3;
                int iHashCode7 = (iHashCode6 + (paywallColor6 == null ? 0 : paywallColor6.hashCode())) * 31;
                PaywallColor paywallColor7 = this.closeButton;
                int iHashCode8 = (iHashCode7 + (paywallColor7 == null ? 0 : paywallColor7.hashCode())) * 31;
                PaywallColor paywallColor8 = this.tierControlBackground;
                int iHashCode9 = (iHashCode8 + (paywallColor8 == null ? 0 : paywallColor8.hashCode())) * 31;
                PaywallColor paywallColor9 = this.tierControlForeground;
                int iHashCode10 = (iHashCode9 + (paywallColor9 == null ? 0 : paywallColor9.hashCode())) * 31;
                PaywallColor paywallColor10 = this.tierControlSelectedBackground;
                int iHashCode11 = (iHashCode10 + (paywallColor10 == null ? 0 : paywallColor10.hashCode())) * 31;
                PaywallColor paywallColor11 = this.tierControlSelectedForeground;
                return iHashCode11 + (paywallColor11 != null ? paywallColor11.hashCode() : 0);
            }

            public String toString() {
                return "Colors(background=" + this.background + ", text1=" + this.text1 + ", text2=" + this.text2 + ", text3=" + this.text3 + ", callToActionBackground=" + this.callToActionBackground + ", callToActionForeground=" + this.callToActionForeground + ", callToActionSecondaryBackground=" + this.callToActionSecondaryBackground + ", accent1=" + this.accent1 + ", accent2=" + this.accent2 + ", accent3=" + this.accent3 + ", closeButton=" + this.closeButton + ", tierControlBackground=" + this.tierControlBackground + ", tierControlForeground=" + this.tierControlForeground + ", tierControlSelectedBackground=" + this.tierControlSelectedBackground + ", tierControlSelectedForeground=" + this.tierControlSelectedForeground + ')';
            }

            public Colors(PaywallColor background, PaywallColor text1, PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor callToActionBackground, PaywallColor callToActionForeground, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5, PaywallColor paywallColor6, PaywallColor paywallColor7, PaywallColor paywallColor8, PaywallColor paywallColor9, PaywallColor paywallColor10, PaywallColor paywallColor11) {
                Intrinsics.checkNotNullParameter(background, "background");
                Intrinsics.checkNotNullParameter(text1, "text1");
                Intrinsics.checkNotNullParameter(callToActionBackground, "callToActionBackground");
                Intrinsics.checkNotNullParameter(callToActionForeground, "callToActionForeground");
                this.background = background;
                this.text1 = text1;
                this.text2 = paywallColor;
                this.text3 = paywallColor2;
                this.callToActionBackground = callToActionBackground;
                this.callToActionForeground = callToActionForeground;
                this.callToActionSecondaryBackground = paywallColor3;
                this.accent1 = paywallColor4;
                this.accent2 = paywallColor5;
                this.accent3 = paywallColor6;
                this.closeButton = paywallColor7;
                this.tierControlBackground = paywallColor8;
                this.tierControlForeground = paywallColor9;
                this.tierControlSelectedBackground = paywallColor10;
                this.tierControlSelectedForeground = paywallColor11;
            }

            @SerialName
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getAccent1$annotations() {
            }

            @SerialName
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getAccent2$annotations() {
            }

            @SerialName
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getAccent3$annotations() {
            }

            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getBackground$annotations() {
            }

            @SerialName
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getCallToActionBackground$annotations() {
            }

            @SerialName
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getCallToActionForeground$annotations() {
            }

            @SerialName
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getCallToActionSecondaryBackground$annotations() {
            }

            @SerialName
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getCloseButton$annotations() {
            }

            @SerialName
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getText1$annotations() {
            }

            @SerialName
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getText2$annotations() {
            }

            @SerialName
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getText3$annotations() {
            }

            @SerialName
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getTierControlBackground$annotations() {
            }

            @SerialName
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getTierControlForeground$annotations() {
            }

            @SerialName
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getTierControlSelectedBackground$annotations() {
            }

            @SerialName
            @Serializable(with = PaywallColor.Serializer.class)
            public static /* synthetic */ void getTierControlSelectedForeground$annotations() {
            }

            public /* synthetic */ Colors(PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5, PaywallColor paywallColor6, PaywallColor paywallColor7, PaywallColor paywallColor8, PaywallColor paywallColor9, PaywallColor paywallColor10, PaywallColor paywallColor11, PaywallColor paywallColor12, PaywallColor paywallColor13, PaywallColor paywallColor14, PaywallColor paywallColor15, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(paywallColor, paywallColor2, (i3 & 4) != 0 ? null : paywallColor3, (i3 & 8) != 0 ? null : paywallColor4, paywallColor5, paywallColor6, (i3 & 64) != 0 ? null : paywallColor7, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : paywallColor8, (i3 & Function.MAX_NARGS) != 0 ? null : paywallColor9, (i3 & 512) != 0 ? null : paywallColor10, (i3 & 1024) != 0 ? null : paywallColor11, (i3 & 2048) != 0 ? null : paywallColor12, (i3 & 4096) != 0 ? null : paywallColor13, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : paywallColor14, (i3 & 16384) != 0 ? null : paywallColor15);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Configuration> serializer() {
                return PaywallData$Configuration$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Images {
            public static final Companion Companion = new Companion(null);
            private final String background;
            private final String header;
            private final String icon;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<Images> serializer() {
                    return PaywallData$Configuration$Images$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public Images() {
                this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Images images, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                if (compositeEncoder.z(serialDescriptor, 0) || images.header != null) {
                    compositeEncoder.i(serialDescriptor, 0, EmptyStringToNullSerializer.INSTANCE, images.header);
                }
                if (compositeEncoder.z(serialDescriptor, 1) || images.background != null) {
                    compositeEncoder.i(serialDescriptor, 1, EmptyStringToNullSerializer.INSTANCE, images.background);
                }
                if (!compositeEncoder.z(serialDescriptor, 2) && images.icon == null) {
                    return;
                }
                compositeEncoder.i(serialDescriptor, 2, EmptyStringToNullSerializer.INSTANCE, images.icon);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Images)) {
                    return false;
                }
                Images images = (Images) obj;
                return Intrinsics.areEqual(this.header, images.header) && Intrinsics.areEqual(this.background, images.background) && Intrinsics.areEqual(this.icon, images.icon);
            }

            public final List<String> getAll$purchases_defaultsBc8Release() {
                return CollectionsKt.listOfNotNull((Object[]) new String[]{this.header, this.background, this.icon});
            }

            public final String getBackground() {
                return this.background;
            }

            public final String getHeader() {
                return this.header;
            }

            public final String getIcon() {
                return this.icon;
            }

            public int hashCode() {
                String str = this.header;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.background;
                int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.icon;
                return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
            }

            public String toString() {
                return "Images(header=" + this.header + ", background=" + this.background + ", icon=" + this.icon + ')';
            }

            @Deprecated
            public /* synthetic */ Images(int i3, @Serializable(with = EmptyStringToNullSerializer.class) String str, @Serializable(with = EmptyStringToNullSerializer.class) String str2, @Serializable(with = EmptyStringToNullSerializer.class) String str3, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i3 & 1) == 0) {
                    this.header = null;
                } else {
                    this.header = str;
                }
                if ((i3 & 2) == 0) {
                    this.background = null;
                } else {
                    this.background = str2;
                }
                if ((i3 & 4) == 0) {
                    this.icon = null;
                } else {
                    this.icon = str3;
                }
            }

            public Images(String str, String str2, String str3) {
                this.header = str;
                this.background = str2;
                this.icon = str3;
            }

            public /* synthetic */ Images(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3);
            }

            @Serializable(with = EmptyStringToNullSerializer.class)
            public static /* synthetic */ void getBackground$annotations() {
            }

            @Serializable(with = EmptyStringToNullSerializer.class)
            public static /* synthetic */ void getHeader$annotations() {
            }

            @Serializable(with = EmptyStringToNullSerializer.class)
            public static /* synthetic */ void getIcon$annotations() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Tier {
            private final String defaultPackageId;
            private final String id;
            private final List<String> packageIds;
            public static final Companion Companion = new Companion(null);
            private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(StringSerializer.f142891a), null};

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<Tier> serializer() {
                    return PaywallData$Configuration$Tier$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            @Deprecated
            public /* synthetic */ Tier(int i3, String str, @SerialName List list, @SerialName String str2, SerializationConstructorMarker serializationConstructorMarker) {
                if (7 != (i3 & 7)) {
                    PluginExceptionsKt.b(i3, 7, PaywallData$Configuration$Tier$$serializer.INSTANCE.getDescriptor());
                }
                this.id = str;
                this.packageIds = list;
                this.defaultPackageId = str2;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Tier tier, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                KSerializer<Object>[] kSerializerArr = $childSerializers;
                compositeEncoder.y(serialDescriptor, 0, tier.id);
                compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], tier.packageIds);
                compositeEncoder.y(serialDescriptor, 2, tier.defaultPackageId);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Tier)) {
                    return false;
                }
                Tier tier = (Tier) obj;
                return Intrinsics.areEqual(this.id, tier.id) && Intrinsics.areEqual(this.packageIds, tier.packageIds) && Intrinsics.areEqual(this.defaultPackageId, tier.defaultPackageId);
            }

            public final String getDefaultPackageId() {
                return this.defaultPackageId;
            }

            public final String getId() {
                return this.id;
            }

            public final List<String> getPackageIds() {
                return this.packageIds;
            }

            public int hashCode() {
                return (((this.id.hashCode() * 31) + this.packageIds.hashCode()) * 31) + this.defaultPackageId.hashCode();
            }

            public String toString() {
                return "Tier(id=" + this.id + ", packageIds=" + this.packageIds + ", defaultPackageId=" + this.defaultPackageId + ')';
            }

            public Tier(String id, List<String> packageIds, String defaultPackageId) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(packageIds, "packageIds");
                Intrinsics.checkNotNullParameter(defaultPackageId, "defaultPackageId");
                this.id = id;
                this.packageIds = packageIds;
                this.defaultPackageId = defaultPackageId;
            }

            @SerialName
            public static /* synthetic */ void getDefaultPackageId$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getPackageIds$annotations() {
            }
        }

        static {
            StringSerializer stringSerializer = StringSerializer.f142891a;
            $childSerializers = new KSerializer[]{new ArrayListSerializer(stringSerializer), null, null, null, new LinkedHashMapSerializer(stringSerializer, PaywallData$Configuration$Images$$serializer.INSTANCE), null, null, null, null, null, new LinkedHashMapSerializer(stringSerializer, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE), new ArrayListSerializer(PaywallData$Configuration$Tier$$serializer.INSTANCE), null};
        }

        @Deprecated
        public /* synthetic */ Configuration(int i3, @SerialName List list, @SerialName String str, @SerialName Images images, @SerialName Images images2, @SerialName Map map, @SerialName boolean z2, @SerialName boolean z3, @SerialName @Serializable(with = OptionalURLSerializer.class) URL url, @SerialName @Serializable(with = OptionalURLSerializer.class) URL url2, ColorInformation colorInformation, @SerialName Map map2, List list2, @SerialName String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (512 != (i3 & 512)) {
                PluginExceptionsKt.b(i3, 512, PaywallData$Configuration$$serializer.INSTANCE.getDescriptor());
            }
            this.packageIds = (i3 & 1) == 0 ? CollectionsKt.emptyList() : list;
            if ((i3 & 2) == 0) {
                this.defaultPackage = null;
            } else {
                this.defaultPackage = str;
            }
            if ((i3 & 4) == 0) {
                this.imagesWebp = null;
            } else {
                this.imagesWebp = images;
            }
            if ((i3 & 8) == 0) {
                this.legacyImages = null;
            } else {
                this.legacyImages = images2;
            }
            if ((i3 & 16) == 0) {
                this.imagesByTier = null;
            } else {
                this.imagesByTier = map;
            }
            if ((i3 & 32) == 0) {
                this.blurredBackgroundImage = false;
            } else {
                this.blurredBackgroundImage = z2;
            }
            if ((i3 & 64) == 0) {
                this.displayRestorePurchases = true;
            } else {
                this.displayRestorePurchases = z3;
            }
            if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
                this.termsOfServiceURL = null;
            } else {
                this.termsOfServiceURL = url;
            }
            if ((i3 & Function.MAX_NARGS) == 0) {
                this.privacyURL = null;
            } else {
                this.privacyURL = url2;
            }
            this.colors = colorInformation;
            if ((i3 & 1024) == 0) {
                this.colorsByTier = null;
            } else {
                this.colorsByTier = map2;
            }
            if ((i3 & 2048) == 0) {
                this.tiers = null;
            } else {
                this.tiers = list2;
            }
            if ((i3 & 4096) == 0) {
                this.defaultTier = null;
            } else {
                this.defaultTier = str2;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Configuration copy$default(Configuration configuration, List list, String str, Images images, Images images2, Map map, boolean z2, boolean z3, URL url, URL url2, ColorInformation colorInformation, Map map2, List list2, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = configuration.packageIds;
            }
            return configuration.copy(list, (i3 & 2) != 0 ? configuration.defaultPackage : str, (i3 & 4) != 0 ? configuration.imagesWebp : images, (i3 & 8) != 0 ? configuration.legacyImages : images2, (i3 & 16) != 0 ? configuration.imagesByTier : map, (i3 & 32) != 0 ? configuration.blurredBackgroundImage : z2, (i3 & 64) != 0 ? configuration.displayRestorePurchases : z3, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? configuration.termsOfServiceURL : url, (i3 & Function.MAX_NARGS) != 0 ? configuration.privacyURL : url2, (i3 & 512) != 0 ? configuration.colors : colorInformation, (i3 & 1024) != 0 ? configuration.colorsByTier : map2, (i3 & 2048) != 0 ? configuration.tiers : list2, (i3 & 4096) != 0 ? configuration.defaultTier : str2);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Configuration configuration, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            if (compositeEncoder.z(serialDescriptor, 0) || !Intrinsics.areEqual(configuration.packageIds, CollectionsKt.emptyList())) {
                compositeEncoder.C(serialDescriptor, 0, kSerializerArr[0], configuration.packageIds);
            }
            if (compositeEncoder.z(serialDescriptor, 1) || configuration.defaultPackage != null) {
                compositeEncoder.i(serialDescriptor, 1, StringSerializer.f142891a, configuration.defaultPackage);
            }
            if (compositeEncoder.z(serialDescriptor, 2) || configuration.imagesWebp != null) {
                compositeEncoder.i(serialDescriptor, 2, PaywallData$Configuration$Images$$serializer.INSTANCE, configuration.imagesWebp);
            }
            if (compositeEncoder.z(serialDescriptor, 3) || configuration.legacyImages != null) {
                compositeEncoder.i(serialDescriptor, 3, PaywallData$Configuration$Images$$serializer.INSTANCE, configuration.legacyImages);
            }
            if (compositeEncoder.z(serialDescriptor, 4) || configuration.imagesByTier != null) {
                compositeEncoder.i(serialDescriptor, 4, kSerializerArr[4], configuration.imagesByTier);
            }
            if (compositeEncoder.z(serialDescriptor, 5) || configuration.blurredBackgroundImage) {
                compositeEncoder.x(serialDescriptor, 5, configuration.blurredBackgroundImage);
            }
            if (compositeEncoder.z(serialDescriptor, 6) || !configuration.displayRestorePurchases) {
                compositeEncoder.x(serialDescriptor, 6, configuration.displayRestorePurchases);
            }
            if (compositeEncoder.z(serialDescriptor, 7) || configuration.termsOfServiceURL != null) {
                compositeEncoder.i(serialDescriptor, 7, OptionalURLSerializer.INSTANCE, configuration.termsOfServiceURL);
            }
            if (compositeEncoder.z(serialDescriptor, 8) || configuration.privacyURL != null) {
                compositeEncoder.i(serialDescriptor, 8, OptionalURLSerializer.INSTANCE, configuration.privacyURL);
            }
            compositeEncoder.C(serialDescriptor, 9, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE, configuration.colors);
            if (compositeEncoder.z(serialDescriptor, 10) || configuration.colorsByTier != null) {
                compositeEncoder.i(serialDescriptor, 10, kSerializerArr[10], configuration.colorsByTier);
            }
            if (compositeEncoder.z(serialDescriptor, 11) || configuration.tiers != null) {
                compositeEncoder.i(serialDescriptor, 11, kSerializerArr[11], configuration.tiers);
            }
            if (!compositeEncoder.z(serialDescriptor, 12) && configuration.defaultTier == null) {
                return;
            }
            compositeEncoder.i(serialDescriptor, 12, StringSerializer.f142891a, configuration.defaultTier);
        }

        public final Configuration copy(List<String> packageIds, String str, Images images, Images images2, Map<String, Images> map, boolean z2, boolean z3, URL url, URL url2, ColorInformation colors, Map<String, ColorInformation> map2, List<Tier> list, String str2) {
            Intrinsics.checkNotNullParameter(packageIds, "packageIds");
            Intrinsics.checkNotNullParameter(colors, "colors");
            return new Configuration(packageIds, str, images, images2, map, z2, z3, url, url2, colors, map2, list, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Configuration)) {
                return false;
            }
            Configuration configuration = (Configuration) obj;
            return Intrinsics.areEqual(this.packageIds, configuration.packageIds) && Intrinsics.areEqual(this.defaultPackage, configuration.defaultPackage) && Intrinsics.areEqual(this.imagesWebp, configuration.imagesWebp) && Intrinsics.areEqual(this.legacyImages, configuration.legacyImages) && Intrinsics.areEqual(this.imagesByTier, configuration.imagesByTier) && this.blurredBackgroundImage == configuration.blurredBackgroundImage && this.displayRestorePurchases == configuration.displayRestorePurchases && Intrinsics.areEqual(this.termsOfServiceURL, configuration.termsOfServiceURL) && Intrinsics.areEqual(this.privacyURL, configuration.privacyURL) && Intrinsics.areEqual(this.colors, configuration.colors) && Intrinsics.areEqual(this.colorsByTier, configuration.colorsByTier) && Intrinsics.areEqual(this.tiers, configuration.tiers) && Intrinsics.areEqual(this.defaultTier, configuration.defaultTier);
        }

        public final boolean getBlurredBackgroundImage() {
            return this.blurredBackgroundImage;
        }

        public final ColorInformation getColors() {
            return this.colors;
        }

        public final Map<String, ColorInformation> getColorsByTier() {
            return this.colorsByTier;
        }

        public final String getDefaultPackage() {
            return this.defaultPackage;
        }

        public final String getDefaultTier() {
            return this.defaultTier;
        }

        public final boolean getDisplayRestorePurchases() {
            return this.displayRestorePurchases;
        }

        public final Images getImages() {
            String header;
            String background;
            String icon;
            Images images = this.imagesWebp;
            String icon2 = null;
            if (images == null || (header = images.getHeader()) == null) {
                Images images2 = this.legacyImages;
                header = images2 != null ? images2.getHeader() : null;
            }
            Images images3 = this.imagesWebp;
            if (images3 == null || (background = images3.getBackground()) == null) {
                Images images4 = this.legacyImages;
                background = images4 != null ? images4.getBackground() : null;
            }
            Images images5 = this.imagesWebp;
            if (images5 == null || (icon = images5.getIcon()) == null) {
                Images images6 = this.legacyImages;
                if (images6 != null) {
                    icon2 = images6.getIcon();
                }
            } else {
                icon2 = icon;
            }
            return new Images(header, background, icon2);
        }

        public final Map<String, Images> getImagesByTier() {
            return this.imagesByTier;
        }

        public final Images getImagesWebp$purchases_defaultsBc8Release() {
            return this.imagesWebp;
        }

        public final Images getLegacyImages$purchases_defaultsBc8Release() {
            return this.legacyImages;
        }

        public final List<String> getPackageIds() {
            return this.packageIds;
        }

        public final URL getPrivacyURL() {
            return this.privacyURL;
        }

        public final URL getTermsOfServiceURL() {
            return this.termsOfServiceURL;
        }

        public final List<Tier> getTiers() {
            return this.tiers;
        }

        public int hashCode() {
            int iHashCode = this.packageIds.hashCode() * 31;
            String str = this.defaultPackage;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Images images = this.imagesWebp;
            int iHashCode3 = (iHashCode2 + (images == null ? 0 : images.hashCode())) * 31;
            Images images2 = this.legacyImages;
            int iHashCode4 = (iHashCode3 + (images2 == null ? 0 : images2.hashCode())) * 31;
            Map<String, Images> map = this.imagesByTier;
            int iHashCode5 = (((((iHashCode4 + (map == null ? 0 : map.hashCode())) * 31) + Boolean.hashCode(this.blurredBackgroundImage)) * 31) + Boolean.hashCode(this.displayRestorePurchases)) * 31;
            URL url = this.termsOfServiceURL;
            int iHashCode6 = (iHashCode5 + (url == null ? 0 : url.hashCode())) * 31;
            URL url2 = this.privacyURL;
            int iHashCode7 = (((iHashCode6 + (url2 == null ? 0 : url2.hashCode())) * 31) + this.colors.hashCode()) * 31;
            Map<String, ColorInformation> map2 = this.colorsByTier;
            int iHashCode8 = (iHashCode7 + (map2 == null ? 0 : map2.hashCode())) * 31;
            List<Tier> list = this.tiers;
            int iHashCode9 = (iHashCode8 + (list == null ? 0 : list.hashCode())) * 31;
            String str2 = this.defaultTier;
            return iHashCode9 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Configuration(packageIds=" + this.packageIds + ", defaultPackage=" + this.defaultPackage + ", imagesWebp=" + this.imagesWebp + ", legacyImages=" + this.legacyImages + ", imagesByTier=" + this.imagesByTier + ", blurredBackgroundImage=" + this.blurredBackgroundImage + ", displayRestorePurchases=" + this.displayRestorePurchases + ", termsOfServiceURL=" + this.termsOfServiceURL + ", privacyURL=" + this.privacyURL + ", colors=" + this.colors + ", colorsByTier=" + this.colorsByTier + ", tiers=" + this.tiers + ", defaultTier=" + this.defaultTier + ')';
        }

        public Configuration(List<String> packageIds, String str, Images images, Images images2, Map<String, Images> map, boolean z2, boolean z3, URL url, URL url2, ColorInformation colors, Map<String, ColorInformation> map2, List<Tier> list, String str2) {
            Intrinsics.checkNotNullParameter(packageIds, "packageIds");
            Intrinsics.checkNotNullParameter(colors, "colors");
            this.packageIds = packageIds;
            this.defaultPackage = str;
            this.imagesWebp = images;
            this.legacyImages = images2;
            this.imagesByTier = map;
            this.blurredBackgroundImage = z2;
            this.displayRestorePurchases = z3;
            this.termsOfServiceURL = url;
            this.privacyURL = url2;
            this.colors = colors;
            this.colorsByTier = map2;
            this.tiers = list;
            this.defaultTier = str2;
        }

        @SerialName
        public static /* synthetic */ void getBlurredBackgroundImage$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getColorsByTier$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getDefaultPackage$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getDefaultTier$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getDisplayRestorePurchases$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getImagesByTier$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getImagesWebp$purchases_defaultsBc8Release$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getLegacyImages$purchases_defaultsBc8Release$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getPackageIds$annotations() {
        }

        @SerialName
        @Serializable(with = OptionalURLSerializer.class)
        public static /* synthetic */ void getPrivacyURL$annotations() {
        }

        @SerialName
        @Serializable(with = OptionalURLSerializer.class)
        public static /* synthetic */ void getTermsOfServiceURL$annotations() {
        }

        /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
            java.lang.NullPointerException
            */
        public /* synthetic */ Configuration(java.util.List r17, java.lang.String r18, com.revenuecat.purchases.paywalls.PaywallData.Configuration.Images r19, com.revenuecat.purchases.paywalls.PaywallData.Configuration.Images r20, java.util.Map r21, boolean r22, boolean r23, java.net.URL r24, java.net.URL r25, com.revenuecat.purchases.paywalls.PaywallData.Configuration.ColorInformation r26, java.util.Map r27, java.util.List r28, java.lang.String r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
            /*
                r16 = this;
                r0 = r30
                r1 = r0 & 1
                if (r1 == 0) goto Lc
                java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
                r3 = r1
                goto Le
            Lc:
                r3 = r17
            Le:
                r1 = r0 & 2
                r2 = 0
                if (r1 == 0) goto L15
                r4 = r2
                goto L17
            L15:
                r4 = r18
            L17:
                r1 = r0 & 4
                if (r1 == 0) goto L1d
                r5 = r2
                goto L1f
            L1d:
                r5 = r19
            L1f:
                r1 = r0 & 8
                if (r1 == 0) goto L25
                r6 = r2
                goto L27
            L25:
                r6 = r20
            L27:
                r1 = r0 & 16
                if (r1 == 0) goto L2d
                r7 = r2
                goto L2f
            L2d:
                r7 = r21
            L2f:
                r1 = r0 & 32
                if (r1 == 0) goto L36
                r1 = 0
                r8 = r1
                goto L38
            L36:
                r8 = r22
            L38:
                r1 = r0 & 64
                if (r1 == 0) goto L3f
                r1 = 1
                r9 = r1
                goto L41
            L3f:
                r9 = r23
            L41:
                r1 = r0 & 128(0x80, float:1.8E-43)
                if (r1 == 0) goto L47
                r10 = r2
                goto L49
            L47:
                r10 = r24
            L49:
                r1 = r0 & 256(0x100, float:3.59E-43)
                if (r1 == 0) goto L4f
                r11 = r2
                goto L51
            L4f:
                r11 = r25
            L51:
                r1 = r0 & 1024(0x400, float:1.435E-42)
                if (r1 == 0) goto L57
                r13 = r2
                goto L59
            L57:
                r13 = r27
            L59:
                r1 = r0 & 2048(0x800, float:2.87E-42)
                if (r1 == 0) goto L5f
                r14 = r2
                goto L61
            L5f:
                r14 = r28
            L61:
                r0 = r0 & 4096(0x1000, float:5.74E-42)
                if (r0 == 0) goto L6b
                r15 = r2
                r12 = r26
                r2 = r16
                goto L71
            L6b:
                r15 = r29
                r2 = r16
                r12 = r26
            L71:
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.PaywallData.Configuration.<init>(java.util.List, java.lang.String, com.revenuecat.purchases.paywalls.PaywallData$Configuration$Images, com.revenuecat.purchases.paywalls.PaywallData$Configuration$Images, java.util.Map, boolean, boolean, java.net.URL, java.net.URL, com.revenuecat.purchases.paywalls.PaywallData$Configuration$ColorInformation, java.util.Map, java.util.List, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public /* synthetic */ Configuration(List list, String str, Images images, Map map, ColorInformation colorInformation, Map map2, List list2, boolean z2, boolean z3, URL url, URL url2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i3 & 2) != 0 ? null : str, images, (i3 & 8) != 0 ? null : map, colorInformation, (i3 & 32) != 0 ? null : map2, (i3 & 64) != 0 ? null : list2, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? false : z2, (i3 & Function.MAX_NARGS) != 0 ? true : z3, (i3 & 512) != 0 ? null : url, (i3 & 1024) != 0 ? null : url2);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Configuration(List<String> packageIds, String str, Images images, Map<String, Images> map, ColorInformation colors, Map<String, ColorInformation> map2, List<Tier> list, boolean z2, boolean z3, URL url, URL url2) {
            this(packageIds, str, images, (Images) null, map, z2, z3, url, url2, colors, map2, list, (String) null, 4104, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(packageIds, "packageIds");
            Intrinsics.checkNotNullParameter(images, "images");
            Intrinsics.checkNotNullParameter(colors, "colors");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class LocalizedConfiguration {
        private final String callToAction;
        private final String callToActionWithIntroOffer;
        private final String callToActionWithMultipleIntroOffers;
        private final List<Feature> features;
        private final String offerDetails;
        private final String offerDetailsWithIntroOffer;
        private final String offerDetailsWithMultipleIntroOffers;
        private final String offerName;
        private final Map<String, OfferOverride> offerOverrides;
        private final String subtitle;
        private final String tierName;
        private final String title;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, null, new ArrayListSerializer(PaywallData$LocalizedConfiguration$Feature$$serializer.INSTANCE), null, new LinkedHashMapSerializer(StringSerializer.f142891a, PaywallData$LocalizedConfiguration$OfferOverride$$serializer.INSTANCE)};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<LocalizedConfiguration> serializer() {
                return PaywallData$LocalizedConfiguration$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Feature {
            public static final Companion Companion = new Companion(null);
            private final String content;
            private final String iconID;
            private final String title;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<Feature> serializer() {
                    return PaywallData$LocalizedConfiguration$Feature$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            @Deprecated
            public /* synthetic */ Feature(int i3, String str, String str2, @SerialName String str3, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i3 & 1)) {
                    PluginExceptionsKt.b(i3, 1, PaywallData$LocalizedConfiguration$Feature$$serializer.INSTANCE.getDescriptor());
                }
                this.title = str;
                if ((i3 & 2) == 0) {
                    this.content = null;
                } else {
                    this.content = str2;
                }
                if ((i3 & 4) == 0) {
                    this.iconID = null;
                } else {
                    this.iconID = str3;
                }
            }

            public static /* synthetic */ Feature copy$default(Feature feature, String str, String str2, String str3, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = feature.title;
                }
                if ((i3 & 2) != 0) {
                    str2 = feature.content;
                }
                if ((i3 & 4) != 0) {
                    str3 = feature.iconID;
                }
                return feature.copy(str, str2, str3);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Feature feature, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                compositeEncoder.y(serialDescriptor, 0, feature.title);
                if (compositeEncoder.z(serialDescriptor, 1) || feature.content != null) {
                    compositeEncoder.i(serialDescriptor, 1, StringSerializer.f142891a, feature.content);
                }
                if (!compositeEncoder.z(serialDescriptor, 2) && feature.iconID == null) {
                    return;
                }
                compositeEncoder.i(serialDescriptor, 2, StringSerializer.f142891a, feature.iconID);
            }

            public final /* synthetic */ Feature copy(String title, String str, String str2) {
                Intrinsics.checkNotNullParameter(title, "title");
                return new Feature(title, str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Feature)) {
                    return false;
                }
                Feature feature = (Feature) obj;
                return Intrinsics.areEqual(this.title, feature.title) && Intrinsics.areEqual(this.content, feature.content) && Intrinsics.areEqual(this.iconID, feature.iconID);
            }

            public final String getContent() {
                return this.content;
            }

            public final String getIconID() {
                return this.iconID;
            }

            public final String getTitle() {
                return this.title;
            }

            public int hashCode() {
                int iHashCode = this.title.hashCode() * 31;
                String str = this.content;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.iconID;
                return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "Feature(title=" + this.title + ", content=" + this.content + ", iconID=" + this.iconID + ')';
            }

            public Feature(String title, String str, String str2) {
                Intrinsics.checkNotNullParameter(title, "title");
                this.title = title;
                this.content = str;
                this.iconID = str2;
            }

            public /* synthetic */ Feature(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3);
            }

            @SerialName
            public static /* synthetic */ void getIconID$annotations() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class OfferOverride {
            public static final Companion Companion = new Companion(null);
            private final String offerBadge;
            private final String offerDetails;
            private final String offerDetailsWithIntroOffer;
            private final String offerDetailsWithMultipleIntroOffers;
            private final String offerName;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<OfferOverride> serializer() {
                    return PaywallData$LocalizedConfiguration$OfferOverride$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            @Deprecated
            public /* synthetic */ OfferOverride(int i3, @SerialName String str, @SerialName String str2, @SerialName @Serializable(with = EmptyStringToNullSerializer.class) String str3, @SerialName @Serializable(with = EmptyStringToNullSerializer.class) String str4, @SerialName @Serializable(with = EmptyStringToNullSerializer.class) String str5, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i3 & 3)) {
                    PluginExceptionsKt.b(i3, 3, PaywallData$LocalizedConfiguration$OfferOverride$$serializer.INSTANCE.getDescriptor());
                }
                this.offerName = str;
                this.offerDetails = str2;
                if ((i3 & 4) == 0) {
                    this.offerDetailsWithIntroOffer = null;
                } else {
                    this.offerDetailsWithIntroOffer = str3;
                }
                if ((i3 & 8) == 0) {
                    this.offerDetailsWithMultipleIntroOffers = null;
                } else {
                    this.offerDetailsWithMultipleIntroOffers = str4;
                }
                if ((i3 & 16) == 0) {
                    this.offerBadge = null;
                } else {
                    this.offerBadge = str5;
                }
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(OfferOverride offerOverride, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                compositeEncoder.y(serialDescriptor, 0, offerOverride.offerName);
                compositeEncoder.y(serialDescriptor, 1, offerOverride.offerDetails);
                if (compositeEncoder.z(serialDescriptor, 2) || offerOverride.offerDetailsWithIntroOffer != null) {
                    compositeEncoder.i(serialDescriptor, 2, EmptyStringToNullSerializer.INSTANCE, offerOverride.offerDetailsWithIntroOffer);
                }
                if (compositeEncoder.z(serialDescriptor, 3) || offerOverride.offerDetailsWithMultipleIntroOffers != null) {
                    compositeEncoder.i(serialDescriptor, 3, EmptyStringToNullSerializer.INSTANCE, offerOverride.offerDetailsWithMultipleIntroOffers);
                }
                if (!compositeEncoder.z(serialDescriptor, 4) && offerOverride.offerBadge == null) {
                    return;
                }
                compositeEncoder.i(serialDescriptor, 4, EmptyStringToNullSerializer.INSTANCE, offerOverride.offerBadge);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof OfferOverride)) {
                    return false;
                }
                OfferOverride offerOverride = (OfferOverride) obj;
                return Intrinsics.areEqual(this.offerName, offerOverride.offerName) && Intrinsics.areEqual(this.offerDetails, offerOverride.offerDetails) && Intrinsics.areEqual(this.offerDetailsWithIntroOffer, offerOverride.offerDetailsWithIntroOffer) && Intrinsics.areEqual(this.offerDetailsWithMultipleIntroOffers, offerOverride.offerDetailsWithMultipleIntroOffers) && Intrinsics.areEqual(this.offerBadge, offerOverride.offerBadge);
            }

            public final String getOfferBadge() {
                return this.offerBadge;
            }

            public final String getOfferDetails() {
                return this.offerDetails;
            }

            public final String getOfferDetailsWithIntroOffer() {
                return this.offerDetailsWithIntroOffer;
            }

            public final String getOfferDetailsWithMultipleIntroOffers() {
                return this.offerDetailsWithMultipleIntroOffers;
            }

            public final String getOfferName() {
                return this.offerName;
            }

            public int hashCode() {
                int iHashCode = ((this.offerName.hashCode() * 31) + this.offerDetails.hashCode()) * 31;
                String str = this.offerDetailsWithIntroOffer;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.offerDetailsWithMultipleIntroOffers;
                int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.offerBadge;
                return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
            }

            public String toString() {
                return "OfferOverride(offerName=" + this.offerName + ", offerDetails=" + this.offerDetails + ", offerDetailsWithIntroOffer=" + this.offerDetailsWithIntroOffer + ", offerDetailsWithMultipleIntroOffers=" + this.offerDetailsWithMultipleIntroOffers + ", offerBadge=" + this.offerBadge + ')';
            }

            public OfferOverride(String offerName, String offerDetails, String str, String str2, String str3) {
                Intrinsics.checkNotNullParameter(offerName, "offerName");
                Intrinsics.checkNotNullParameter(offerDetails, "offerDetails");
                this.offerName = offerName;
                this.offerDetails = offerDetails;
                this.offerDetailsWithIntroOffer = str;
                this.offerDetailsWithMultipleIntroOffers = str2;
                this.offerBadge = str3;
            }

            public /* synthetic */ OfferOverride(String str, String str2, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? null : str5);
            }

            @SerialName
            @Serializable(with = EmptyStringToNullSerializer.class)
            public static /* synthetic */ void getOfferBadge$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getOfferDetails$annotations() {
            }

            @SerialName
            @Serializable(with = EmptyStringToNullSerializer.class)
            public static /* synthetic */ void getOfferDetailsWithIntroOffer$annotations() {
            }

            @SerialName
            @Serializable(with = EmptyStringToNullSerializer.class)
            public static /* synthetic */ void getOfferDetailsWithMultipleIntroOffers$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getOfferName$annotations() {
            }
        }

        @Deprecated
        public /* synthetic */ LocalizedConfiguration(int i3, String str, @Serializable(with = EmptyStringToNullSerializer.class) String str2, @SerialName String str3, @SerialName @Serializable(with = EmptyStringToNullSerializer.class) String str4, @SerialName @Serializable(with = EmptyStringToNullSerializer.class) String str5, @SerialName @Serializable(with = EmptyStringToNullSerializer.class) String str6, @SerialName @Serializable(with = EmptyStringToNullSerializer.class) String str7, @SerialName @Serializable(with = EmptyStringToNullSerializer.class) String str8, @SerialName @Serializable(with = EmptyStringToNullSerializer.class) String str9, List list, @SerialName @Serializable(with = EmptyStringToNullSerializer.class) String str10, @SerialName Map map, SerializationConstructorMarker serializationConstructorMarker) {
            if (5 != (i3 & 5)) {
                PluginExceptionsKt.b(i3, 5, PaywallData$LocalizedConfiguration$$serializer.INSTANCE.getDescriptor());
            }
            this.title = str;
            if ((i3 & 2) == 0) {
                this.subtitle = null;
            } else {
                this.subtitle = str2;
            }
            this.callToAction = str3;
            if ((i3 & 8) == 0) {
                this.callToActionWithIntroOffer = null;
            } else {
                this.callToActionWithIntroOffer = str4;
            }
            if ((i3 & 16) == 0) {
                this.callToActionWithMultipleIntroOffers = null;
            } else {
                this.callToActionWithMultipleIntroOffers = str5;
            }
            if ((i3 & 32) == 0) {
                this.offerDetails = null;
            } else {
                this.offerDetails = str6;
            }
            if ((i3 & 64) == 0) {
                this.offerDetailsWithIntroOffer = null;
            } else {
                this.offerDetailsWithIntroOffer = str7;
            }
            if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
                this.offerDetailsWithMultipleIntroOffers = null;
            } else {
                this.offerDetailsWithMultipleIntroOffers = str8;
            }
            if ((i3 & Function.MAX_NARGS) == 0) {
                this.offerName = null;
            } else {
                this.offerName = str9;
            }
            if ((i3 & 512) == 0) {
                this.features = CollectionsKt.emptyList();
            } else {
                this.features = list;
            }
            if ((i3 & 1024) == 0) {
                this.tierName = null;
            } else {
                this.tierName = str10;
            }
            if ((i3 & 2048) == 0) {
                this.offerOverrides = MapsKt.emptyMap();
            } else {
                this.offerOverrides = map;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(LocalizedConfiguration localizedConfiguration, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            compositeEncoder.y(serialDescriptor, 0, localizedConfiguration.title);
            if (compositeEncoder.z(serialDescriptor, 1) || localizedConfiguration.subtitle != null) {
                compositeEncoder.i(serialDescriptor, 1, EmptyStringToNullSerializer.INSTANCE, localizedConfiguration.subtitle);
            }
            compositeEncoder.y(serialDescriptor, 2, localizedConfiguration.callToAction);
            if (compositeEncoder.z(serialDescriptor, 3) || localizedConfiguration.callToActionWithIntroOffer != null) {
                compositeEncoder.i(serialDescriptor, 3, EmptyStringToNullSerializer.INSTANCE, localizedConfiguration.callToActionWithIntroOffer);
            }
            if (compositeEncoder.z(serialDescriptor, 4) || localizedConfiguration.callToActionWithMultipleIntroOffers != null) {
                compositeEncoder.i(serialDescriptor, 4, EmptyStringToNullSerializer.INSTANCE, localizedConfiguration.callToActionWithMultipleIntroOffers);
            }
            if (compositeEncoder.z(serialDescriptor, 5) || localizedConfiguration.offerDetails != null) {
                compositeEncoder.i(serialDescriptor, 5, EmptyStringToNullSerializer.INSTANCE, localizedConfiguration.offerDetails);
            }
            if (compositeEncoder.z(serialDescriptor, 6) || localizedConfiguration.offerDetailsWithIntroOffer != null) {
                compositeEncoder.i(serialDescriptor, 6, EmptyStringToNullSerializer.INSTANCE, localizedConfiguration.offerDetailsWithIntroOffer);
            }
            if (compositeEncoder.z(serialDescriptor, 7) || localizedConfiguration.offerDetailsWithMultipleIntroOffers != null) {
                compositeEncoder.i(serialDescriptor, 7, EmptyStringToNullSerializer.INSTANCE, localizedConfiguration.offerDetailsWithMultipleIntroOffers);
            }
            if (compositeEncoder.z(serialDescriptor, 8) || localizedConfiguration.offerName != null) {
                compositeEncoder.i(serialDescriptor, 8, EmptyStringToNullSerializer.INSTANCE, localizedConfiguration.offerName);
            }
            if (compositeEncoder.z(serialDescriptor, 9) || !Intrinsics.areEqual(localizedConfiguration.features, CollectionsKt.emptyList())) {
                compositeEncoder.C(serialDescriptor, 9, kSerializerArr[9], localizedConfiguration.features);
            }
            if (compositeEncoder.z(serialDescriptor, 10) || localizedConfiguration.tierName != null) {
                compositeEncoder.i(serialDescriptor, 10, EmptyStringToNullSerializer.INSTANCE, localizedConfiguration.tierName);
            }
            if (!compositeEncoder.z(serialDescriptor, 11) && Intrinsics.areEqual(localizedConfiguration.offerOverrides, MapsKt.emptyMap())) {
                return;
            }
            compositeEncoder.C(serialDescriptor, 11, kSerializerArr[11], localizedConfiguration.offerOverrides);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocalizedConfiguration)) {
                return false;
            }
            LocalizedConfiguration localizedConfiguration = (LocalizedConfiguration) obj;
            return Intrinsics.areEqual(this.title, localizedConfiguration.title) && Intrinsics.areEqual(this.subtitle, localizedConfiguration.subtitle) && Intrinsics.areEqual(this.callToAction, localizedConfiguration.callToAction) && Intrinsics.areEqual(this.callToActionWithIntroOffer, localizedConfiguration.callToActionWithIntroOffer) && Intrinsics.areEqual(this.callToActionWithMultipleIntroOffers, localizedConfiguration.callToActionWithMultipleIntroOffers) && Intrinsics.areEqual(this.offerDetails, localizedConfiguration.offerDetails) && Intrinsics.areEqual(this.offerDetailsWithIntroOffer, localizedConfiguration.offerDetailsWithIntroOffer) && Intrinsics.areEqual(this.offerDetailsWithMultipleIntroOffers, localizedConfiguration.offerDetailsWithMultipleIntroOffers) && Intrinsics.areEqual(this.offerName, localizedConfiguration.offerName) && Intrinsics.areEqual(this.features, localizedConfiguration.features) && Intrinsics.areEqual(this.tierName, localizedConfiguration.tierName) && Intrinsics.areEqual(this.offerOverrides, localizedConfiguration.offerOverrides);
        }

        public final String getCallToAction() {
            return this.callToAction;
        }

        public final String getCallToActionWithIntroOffer() {
            return this.callToActionWithIntroOffer;
        }

        public final String getCallToActionWithMultipleIntroOffers() {
            return this.callToActionWithMultipleIntroOffers;
        }

        public final List<Feature> getFeatures() {
            return this.features;
        }

        public final String getOfferDetails() {
            return this.offerDetails;
        }

        public final String getOfferDetailsWithIntroOffer() {
            return this.offerDetailsWithIntroOffer;
        }

        public final String getOfferDetailsWithMultipleIntroOffers() {
            return this.offerDetailsWithMultipleIntroOffers;
        }

        public final String getOfferName() {
            return this.offerName;
        }

        public final Map<String, OfferOverride> getOfferOverrides() {
            return this.offerOverrides;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final String getTierName() {
            return this.tierName;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            int iHashCode = this.title.hashCode() * 31;
            String str = this.subtitle;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.callToAction.hashCode()) * 31;
            String str2 = this.callToActionWithIntroOffer;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.callToActionWithMultipleIntroOffers;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.offerDetails;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.offerDetailsWithIntroOffer;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.offerDetailsWithMultipleIntroOffers;
            int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.offerName;
            int iHashCode8 = (((iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31) + this.features.hashCode()) * 31;
            String str8 = this.tierName;
            return ((iHashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31) + this.offerOverrides.hashCode();
        }

        public String toString() {
            return "LocalizedConfiguration(title=" + this.title + ", subtitle=" + this.subtitle + ", callToAction=" + this.callToAction + ", callToActionWithIntroOffer=" + this.callToActionWithIntroOffer + ", callToActionWithMultipleIntroOffers=" + this.callToActionWithMultipleIntroOffers + ", offerDetails=" + this.offerDetails + ", offerDetailsWithIntroOffer=" + this.offerDetailsWithIntroOffer + ", offerDetailsWithMultipleIntroOffers=" + this.offerDetailsWithMultipleIntroOffers + ", offerName=" + this.offerName + ", features=" + this.features + ", tierName=" + this.tierName + ", offerOverrides=" + this.offerOverrides + ')';
        }

        public LocalizedConfiguration(String title, String str, String callToAction, String str2, String str3, String str4, String str5, String str6, String str7, List<Feature> features, String str8, Map<String, OfferOverride> offerOverrides) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(callToAction, "callToAction");
            Intrinsics.checkNotNullParameter(features, "features");
            Intrinsics.checkNotNullParameter(offerOverrides, "offerOverrides");
            this.title = title;
            this.subtitle = str;
            this.callToAction = callToAction;
            this.callToActionWithIntroOffer = str2;
            this.callToActionWithMultipleIntroOffers = str3;
            this.offerDetails = str4;
            this.offerDetailsWithIntroOffer = str5;
            this.offerDetailsWithMultipleIntroOffers = str6;
            this.offerName = str7;
            this.features = features;
            this.tierName = str8;
            this.offerOverrides = offerOverrides;
        }

        @SerialName
        public static /* synthetic */ void getCallToAction$annotations() {
        }

        @SerialName
        @Serializable(with = EmptyStringToNullSerializer.class)
        public static /* synthetic */ void getCallToActionWithIntroOffer$annotations() {
        }

        @SerialName
        @Serializable(with = EmptyStringToNullSerializer.class)
        public static /* synthetic */ void getCallToActionWithMultipleIntroOffers$annotations() {
        }

        @SerialName
        @Serializable(with = EmptyStringToNullSerializer.class)
        public static /* synthetic */ void getOfferDetails$annotations() {
        }

        @SerialName
        @Serializable(with = EmptyStringToNullSerializer.class)
        public static /* synthetic */ void getOfferDetailsWithIntroOffer$annotations() {
        }

        @SerialName
        @Serializable(with = EmptyStringToNullSerializer.class)
        public static /* synthetic */ void getOfferDetailsWithMultipleIntroOffers$annotations() {
        }

        @SerialName
        @Serializable(with = EmptyStringToNullSerializer.class)
        public static /* synthetic */ void getOfferName$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getOfferOverrides$annotations() {
        }

        @Serializable(with = EmptyStringToNullSerializer.class)
        public static /* synthetic */ void getSubtitle$annotations() {
        }

        @SerialName
        @Serializable(with = EmptyStringToNullSerializer.class)
        public static /* synthetic */ void getTierName$annotations() {
        }

        public /* synthetic */ LocalizedConfiguration(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List list, String str10, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? null : str2, str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? null : str5, (i3 & 32) != 0 ? null : str6, (i3 & 64) != 0 ? null : str7, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : str8, (i3 & Function.MAX_NARGS) != 0 ? null : str9, (i3 & 512) != 0 ? CollectionsKt.emptyList() : list, (i3 & 1024) != 0 ? null : str10, (i3 & 2048) != 0 ? MapsKt.emptyMap() : map);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallData(String str, String templateName, Configuration config, URL assetBaseURL, int i3, Map<String, LocalizedConfiguration> localization, Map<String, ? extends Map<String, LocalizedConfiguration>> localizationByTier, List<String> zeroDecimalPlaceCountries, String str2) {
        Intrinsics.checkNotNullParameter(templateName, "templateName");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(assetBaseURL, "assetBaseURL");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(localizationByTier, "localizationByTier");
        Intrinsics.checkNotNullParameter(zeroDecimalPlaceCountries, "zeroDecimalPlaceCountries");
        this.id = str;
        this.templateName = templateName;
        this.config = config;
        this.assetBaseURL = assetBaseURL;
        this.revision = i3;
        this.localization = localization;
        this.localizationByTier = localizationByTier;
        this.zeroDecimalPlaceCountries = zeroDecimalPlaceCountries;
        this.defaultLocale = str2;
    }

    @SerialName
    @Serializable(with = URLSerializer.class)
    public static /* synthetic */ void getAssetBaseURL$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getDefaultLocale$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getLocalization$purchases_defaultsBc8Release$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getLocalizationByTier$purchases_defaultsBc8Release$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getTemplateName$annotations() {
    }

    @SerialName
    @Serializable(with = GoogleListSerializer.class)
    public static /* synthetic */ void getZeroDecimalPlaceCountries$annotations() {
    }

    public /* synthetic */ PaywallData(String str, String str2, Configuration configuration, URL url, int i3, Map map, Map map2, List list, String str3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : str, str2, configuration, url, (i4 & 16) != 0 ? 0 : i3, map, (i4 & 64) != 0 ? MapsKt.emptyMap() : map2, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? CollectionsKt.emptyList() : list, (i4 & Function.MAX_NARGS) != 0 ? null : str3);
    }
}
