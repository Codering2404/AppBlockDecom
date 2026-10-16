package com.revenuecat.purchases;

import com.google.common.cache.LSNn.vfptEEmYY;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocalizedVariableLocalizationKeyMapSerializer;
import com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FontStyle;
import com.revenuecat.purchases.paywalls.components.properties.FontStyleDeserializer;
import java.lang.annotation.Annotation;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@Serializable
public final class UiConfig {
    private final AppConfig app;
    private final Map<String, CustomVariableDefinition> customVariables;
    private final Map<LocaleId, Map<VariableLocalizationKey, String>> localizations;
    private final VariableConfig variableConfig;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, new LinkedHashMapSerializer(StringSerializer.f142891a, CustomVariableDefinitionSerializer.INSTANCE)};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class AppConfig {
        private final Map<ColorAlias, ColorScheme> colors;
        private final Map<FontAlias, FontsConfig> fonts;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new LinkedHashMapSerializer(ColorAlias$$serializer.INSTANCE, ColorScheme$$serializer.INSTANCE), new LinkedHashMapSerializer(FontAlias$$serializer.INSTANCE, UiConfig$AppConfig$FontsConfig$$serializer.INSTANCE)};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<AppConfig> serializer() {
                return UiConfig$AppConfig$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class FontsConfig {

            /* JADX INFO: renamed from: android, reason: collision with root package name */
            private final FontInfo f92236android;
            public static final Companion Companion = new Companion(null);
            private static final KSerializer<Object>[] $childSerializers = {new SealedClassSerializer("com.revenuecat.purchases.UiConfig.AppConfig.FontsConfig.FontInfo", Reflection.b(FontInfo.class), new KClass[]{Reflection.b(FontInfo.GoogleFonts.class), Reflection.b(FontInfo.Name.class)}, new KSerializer[]{UiConfig$AppConfig$FontsConfig$FontInfo$GoogleFonts$$serializer.INSTANCE, UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer.INSTANCE}, new Annotation[0])};

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<FontsConfig> serializer() {
                    return UiConfig$AppConfig$FontsConfig$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @Serializable
            public interface FontInfo {
                public static final Companion Companion = Companion.$$INSTANCE;

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public static final class Companion {
                    static final /* synthetic */ Companion $$INSTANCE = new Companion();

                    private Companion() {
                    }

                    public final KSerializer<FontInfo> serializer() {
                        return new SealedClassSerializer("com.revenuecat.purchases.UiConfig.AppConfig.FontsConfig.FontInfo", Reflection.b(FontInfo.class), new KClass[]{Reflection.b(GoogleFonts.class), Reflection.b(Name.class)}, new KSerializer[]{UiConfig$AppConfig$FontsConfig$FontInfo$GoogleFonts$$serializer.INSTANCE, UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer.INSTANCE}, new Annotation[0]);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @Serializable
                @SerialName
                public static final class GoogleFonts implements FontInfo {
                    public static final Companion Companion = new Companion(null);
                    private final String value;

                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        public final KSerializer<GoogleFonts> serializer() {
                            return UiConfig$AppConfig$FontsConfig$FontInfo$GoogleFonts$$serializer.INSTANCE;
                        }

                        private Companion() {
                        }
                    }

                    @Deprecated
                    public /* synthetic */ GoogleFonts(int i3, String str, SerializationConstructorMarker serializationConstructorMarker) {
                        if (1 != (i3 & 1)) {
                            PluginExceptionsKt.b(i3, 1, UiConfig$AppConfig$FontsConfig$FontInfo$GoogleFonts$$serializer.INSTANCE.getDescriptor());
                        }
                        this.value = str;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return (obj instanceof GoogleFonts) && Intrinsics.areEqual(this.value, ((GoogleFonts) obj).value);
                    }

                    public final /* synthetic */ String getValue() {
                        return this.value;
                    }

                    public int hashCode() {
                        return this.value.hashCode();
                    }

                    public String toString() {
                        return "GoogleFonts(value=" + this.value + ')';
                    }

                    public GoogleFonts(String value) {
                        Intrinsics.checkNotNullParameter(value, "value");
                        this.value = value;
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @Serializable
                @SerialName
                public static final class Name implements FontInfo {
                    public static final Companion Companion = new Companion(null);
                    private final String family;
                    private final String hash;
                    private final FontStyle style;
                    private final String url;
                    private final String value;
                    private final Integer weight;

                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        public final KSerializer<Name> serializer() {
                            return UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer.INSTANCE;
                        }

                        private Companion() {
                        }
                    }

                    @Deprecated
                    public /* synthetic */ Name(int i3, String str, String str2, String str3, String str4, Integer num, FontStyle fontStyle, SerializationConstructorMarker serializationConstructorMarker) {
                        if (1 != (i3 & 1)) {
                            PluginExceptionsKt.b(i3, 1, UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer.INSTANCE.getDescriptor());
                        }
                        this.value = str;
                        if ((i3 & 2) == 0) {
                            this.url = null;
                        } else {
                            this.url = str2;
                        }
                        if ((i3 & 4) == 0) {
                            this.hash = null;
                        } else {
                            this.hash = str3;
                        }
                        if ((i3 & 8) == 0) {
                            this.family = null;
                        } else {
                            this.family = str4;
                        }
                        if ((i3 & 16) == 0) {
                            this.weight = null;
                        } else {
                            this.weight = num;
                        }
                        if ((i3 & 32) == 0) {
                            this.style = null;
                        } else {
                            this.style = fontStyle;
                        }
                    }

                    @JvmStatic
                    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Name name, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                        compositeEncoder.y(serialDescriptor, 0, name.value);
                        if (compositeEncoder.z(serialDescriptor, 1) || name.url != null) {
                            compositeEncoder.i(serialDescriptor, 1, StringSerializer.f142891a, name.url);
                        }
                        if (compositeEncoder.z(serialDescriptor, 2) || name.hash != null) {
                            compositeEncoder.i(serialDescriptor, 2, StringSerializer.f142891a, name.hash);
                        }
                        if (compositeEncoder.z(serialDescriptor, 3) || name.family != null) {
                            compositeEncoder.i(serialDescriptor, 3, StringSerializer.f142891a, name.family);
                        }
                        if (compositeEncoder.z(serialDescriptor, 4) || name.weight != null) {
                            compositeEncoder.i(serialDescriptor, 4, IntSerializer.f142823a, name.weight);
                        }
                        if (!compositeEncoder.z(serialDescriptor, 5) && name.style == null) {
                            return;
                        }
                        compositeEncoder.i(serialDescriptor, 5, FontStyleDeserializer.INSTANCE, name.style);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof Name)) {
                            return false;
                        }
                        Name name = (Name) obj;
                        return Intrinsics.areEqual(this.value, name.value) && Intrinsics.areEqual(this.url, name.url) && Intrinsics.areEqual(this.hash, name.hash) && Intrinsics.areEqual(this.family, name.family) && Intrinsics.areEqual(this.weight, name.weight) && this.style == name.style;
                    }

                    public final /* synthetic */ String getFamily() {
                        return this.family;
                    }

                    public final /* synthetic */ String getHash() {
                        return this.hash;
                    }

                    public final /* synthetic */ FontStyle getStyle() {
                        return this.style;
                    }

                    public final /* synthetic */ String getUrl() {
                        return this.url;
                    }

                    public final /* synthetic */ String getValue() {
                        return this.value;
                    }

                    public final /* synthetic */ Integer getWeight() {
                        return this.weight;
                    }

                    public int hashCode() {
                        int iHashCode = this.value.hashCode() * 31;
                        String str = this.url;
                        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                        String str2 = this.hash;
                        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                        String str3 = this.family;
                        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
                        Integer num = this.weight;
                        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
                        FontStyle fontStyle = this.style;
                        return iHashCode5 + (fontStyle != null ? fontStyle.hashCode() : 0);
                    }

                    public String toString() {
                        return "Name(value=" + this.value + ", url=" + this.url + ", hash=" + this.hash + ", family=" + this.family + ", weight=" + this.weight + ", style=" + this.style + ')';
                    }

                    public Name(String value, String str, String str2, String str3, Integer num, FontStyle fontStyle) {
                        Intrinsics.checkNotNullParameter(value, "value");
                        this.value = value;
                        this.url = str;
                        this.hash = str2;
                        this.family = str3;
                        this.weight = num;
                        this.style = fontStyle;
                    }

                    public /* synthetic */ Name(String str, String str2, String str3, String str4, Integer num, FontStyle fontStyle, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                        this(str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? null : num, (i3 & 32) != 0 ? null : fontStyle);
                    }
                }
            }

            @Deprecated
            public /* synthetic */ FontsConfig(int i3, FontInfo fontInfo, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i3 & 1)) {
                    PluginExceptionsKt.b(i3, 1, UiConfig$AppConfig$FontsConfig$$serializer.INSTANCE.getDescriptor());
                }
                this.f92236android = fontInfo;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof FontsConfig) && Intrinsics.areEqual(this.f92236android, ((FontsConfig) obj).f92236android);
            }

            public final /* synthetic */ FontInfo getAndroid() {
                return this.f92236android;
            }

            public int hashCode() {
                return this.f92236android.hashCode();
            }

            public String toString() {
                return "FontsConfig(android=" + this.f92236android + ')';
            }

            public FontsConfig(FontInfo android2) {
                Intrinsics.checkNotNullParameter(android2, "android");
                this.f92236android = android2;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AppConfig() {
            this((Map) null, (Map) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(AppConfig appConfig, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            if (compositeEncoder.z(serialDescriptor, 0) || !Intrinsics.areEqual(appConfig.colors, MapsKt.emptyMap())) {
                compositeEncoder.C(serialDescriptor, 0, kSerializerArr[0], appConfig.colors);
            }
            if (!compositeEncoder.z(serialDescriptor, 1) && Intrinsics.areEqual(appConfig.fonts, MapsKt.emptyMap())) {
                return;
            }
            compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], appConfig.fonts);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AppConfig)) {
                return false;
            }
            AppConfig appConfig = (AppConfig) obj;
            return Intrinsics.areEqual(this.colors, appConfig.colors) && Intrinsics.areEqual(this.fonts, appConfig.fonts);
        }

        public final /* synthetic */ Map getColors() {
            return this.colors;
        }

        public final /* synthetic */ Map getFonts() {
            return this.fonts;
        }

        public int hashCode() {
            return (this.colors.hashCode() * 31) + this.fonts.hashCode();
        }

        public String toString() {
            return "AppConfig(colors=" + this.colors + ", fonts=" + this.fonts + ')';
        }

        @Deprecated
        public /* synthetic */ AppConfig(int i3, Map map, Map map2, SerializationConstructorMarker serializationConstructorMarker) {
            this.colors = (i3 & 1) == 0 ? MapsKt.emptyMap() : map;
            if ((i3 & 2) == 0) {
                this.fonts = MapsKt.emptyMap();
            } else {
                this.fonts = map2;
            }
        }

        public AppConfig(Map<ColorAlias, ColorScheme> colors, Map<FontAlias, FontsConfig> fonts) {
            Intrinsics.checkNotNullParameter(colors, "colors");
            Intrinsics.checkNotNullParameter(fonts, "fonts");
            this.colors = colors;
            this.fonts = fonts;
        }

        public /* synthetic */ AppConfig(Map map, Map map2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? MapsKt.emptyMap() : map, (i3 & 2) != 0 ? MapsKt.emptyMap() : map2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<UiConfig> serializer() {
            return UiConfig$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable(with = CustomVariableDefinitionSerializer.class)
    public static final class CustomVariableDefinition {
        public static final Companion Companion = new Companion(null);
        private final Object defaultValue;
        private final String type;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<CustomVariableDefinition> serializer() {
                return CustomVariableDefinitionSerializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public CustomVariableDefinition(String type, Object defaultValue) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
            this.type = type;
            this.defaultValue = defaultValue;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomVariableDefinition)) {
                return false;
            }
            CustomVariableDefinition customVariableDefinition = (CustomVariableDefinition) obj;
            return Intrinsics.areEqual(this.type, customVariableDefinition.type) && Intrinsics.areEqual(this.defaultValue, customVariableDefinition.defaultValue);
        }

        public final /* synthetic */ Object getDefaultValue() {
            return this.defaultValue;
        }

        public final /* synthetic */ String getType() {
            return this.type;
        }

        public int hashCode() {
            return (this.type.hashCode() * 31) + this.defaultValue.hashCode();
        }

        public String toString() {
            return "CustomVariableDefinition(type=" + this.type + ", defaultValue=" + this.defaultValue + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class VariableConfig {
        private static final KSerializer<Object>[] $childSerializers;
        public static final Companion Companion = new Companion(null);
        private final Map<String, String> functionCompatibilityMap;
        private final Map<String, String> variableCompatibilityMap;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<VariableConfig> serializer() {
                return UiConfig$VariableConfig$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        static {
            StringSerializer stringSerializer = StringSerializer.f142891a;
            $childSerializers = new KSerializer[]{new LinkedHashMapSerializer(stringSerializer, stringSerializer), new LinkedHashMapSerializer(stringSerializer, stringSerializer)};
        }

        /* JADX WARN: Multi-variable type inference failed */
        public VariableConfig() {
            this((Map) null, (Map) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        @SerialName
        public static /* synthetic */ void getFunctionCompatibilityMap$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getVariableCompatibilityMap$annotations() {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(VariableConfig variableConfig, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            if (compositeEncoder.z(serialDescriptor, 0) || !Intrinsics.areEqual(variableConfig.variableCompatibilityMap, MapsKt.emptyMap())) {
                compositeEncoder.C(serialDescriptor, 0, kSerializerArr[0], variableConfig.variableCompatibilityMap);
            }
            if (!compositeEncoder.z(serialDescriptor, 1) && Intrinsics.areEqual(variableConfig.functionCompatibilityMap, MapsKt.emptyMap())) {
                return;
            }
            compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], variableConfig.functionCompatibilityMap);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VariableConfig)) {
                return false;
            }
            VariableConfig variableConfig = (VariableConfig) obj;
            return Intrinsics.areEqual(this.variableCompatibilityMap, variableConfig.variableCompatibilityMap) && Intrinsics.areEqual(this.functionCompatibilityMap, variableConfig.functionCompatibilityMap);
        }

        public final /* synthetic */ Map getFunctionCompatibilityMap() {
            return this.functionCompatibilityMap;
        }

        public final /* synthetic */ Map getVariableCompatibilityMap() {
            return this.variableCompatibilityMap;
        }

        public int hashCode() {
            return (this.variableCompatibilityMap.hashCode() * 31) + this.functionCompatibilityMap.hashCode();
        }

        @Deprecated
        public /* synthetic */ VariableConfig(int i3, @SerialName Map map, @SerialName Map map2, SerializationConstructorMarker serializationConstructorMarker) {
            this.variableCompatibilityMap = (i3 & 1) == 0 ? MapsKt.emptyMap() : map;
            if ((i3 & 2) == 0) {
                this.functionCompatibilityMap = MapsKt.emptyMap();
            } else {
                this.functionCompatibilityMap = map2;
            }
        }

        public String toString() {
            return "VariableConfig(variableCompatibilityMap=" + this.variableCompatibilityMap + vfptEEmYY.AMB + this.functionCompatibilityMap + ')';
        }

        public VariableConfig(Map<String, String> variableCompatibilityMap, Map<String, String> functionCompatibilityMap) {
            Intrinsics.checkNotNullParameter(variableCompatibilityMap, "variableCompatibilityMap");
            Intrinsics.checkNotNullParameter(functionCompatibilityMap, "functionCompatibilityMap");
            this.variableCompatibilityMap = variableCompatibilityMap;
            this.functionCompatibilityMap = functionCompatibilityMap;
        }

        public /* synthetic */ VariableConfig(Map map, Map map2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? MapsKt.emptyMap() : map, (i3 & 2) != 0 ? MapsKt.emptyMap() : map2);
        }
    }

    public UiConfig() {
        this((AppConfig) null, (Map) null, (VariableConfig) null, (Map) null, 15, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(UiConfig uiConfig, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        int i3 = 3;
        Map map = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        if (compositeEncoder.z(serialDescriptor, 0) || !Intrinsics.areEqual(uiConfig.app, new AppConfig(map, (Map) (objArr5 == true ? 1 : 0), i3, (DefaultConstructorMarker) (objArr4 == true ? 1 : 0)))) {
            compositeEncoder.C(serialDescriptor, 0, UiConfig$AppConfig$$serializer.INSTANCE, uiConfig.app);
        }
        if (compositeEncoder.z(serialDescriptor, 1) || !Intrinsics.areEqual(uiConfig.localizations, MapsKt.emptyMap())) {
            compositeEncoder.C(serialDescriptor, 1, LocalizedVariableLocalizationKeyMapSerializer.INSTANCE, uiConfig.localizations);
        }
        if (compositeEncoder.z(serialDescriptor, 2) || !Intrinsics.areEqual(uiConfig.variableConfig, new VariableConfig((Map) (objArr3 == true ? 1 : 0), (Map) (objArr2 == true ? 1 : 0), i3, (DefaultConstructorMarker) (objArr == true ? 1 : 0)))) {
            compositeEncoder.C(serialDescriptor, 2, UiConfig$VariableConfig$$serializer.INSTANCE, uiConfig.variableConfig);
        }
        if (!compositeEncoder.z(serialDescriptor, 3) && Intrinsics.areEqual(uiConfig.customVariables, MapsKt.emptyMap())) {
            return;
        }
        compositeEncoder.C(serialDescriptor, 3, kSerializerArr[3], uiConfig.customVariables);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UiConfig)) {
            return false;
        }
        UiConfig uiConfig = (UiConfig) obj;
        return Intrinsics.areEqual(this.app, uiConfig.app) && Intrinsics.areEqual(this.localizations, uiConfig.localizations) && Intrinsics.areEqual(this.variableConfig, uiConfig.variableConfig) && Intrinsics.areEqual(this.customVariables, uiConfig.customVariables);
    }

    public final /* synthetic */ AppConfig getApp() {
        return this.app;
    }

    public final /* synthetic */ Map getCustomVariables() {
        return this.customVariables;
    }

    public final /* synthetic */ Map getLocalizations() {
        return this.localizations;
    }

    public final /* synthetic */ VariableConfig getVariableConfig() {
        return this.variableConfig;
    }

    public int hashCode() {
        return (((((this.app.hashCode() * 31) + this.localizations.hashCode()) * 31) + this.variableConfig.hashCode()) * 31) + this.customVariables.hashCode();
    }

    public String toString() {
        return "UiConfig(app=" + this.app + ", localizations=" + this.localizations + ", variableConfig=" + this.variableConfig + ", customVariables=" + this.customVariables + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public /* synthetic */ UiConfig(int i3, AppConfig appConfig, @Serializable(with = LocalizedVariableLocalizationKeyMapSerializer.class) Map map, @SerialName VariableConfig variableConfig, @SerialName Map map2, SerializationConstructorMarker serializationConstructorMarker) {
        int i4 = 3;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        this.app = (i3 & 1) == 0 ? new AppConfig((Map) null, (Map) (0 == true ? 1 : 0), i4, (DefaultConstructorMarker) (0 == true ? 1 : 0)) : appConfig;
        if ((i3 & 2) == 0) {
            this.localizations = MapsKt.emptyMap();
        } else {
            this.localizations = map;
        }
        if ((i3 & 4) == 0) {
            this.variableConfig = new VariableConfig((Map) (objArr3 == true ? 1 : 0), (Map) (objArr2 == true ? 1 : 0), i4, (DefaultConstructorMarker) (objArr == true ? 1 : 0));
        } else {
            this.variableConfig = variableConfig;
        }
        if ((i3 & 8) == 0) {
            this.customVariables = MapsKt.emptyMap();
        } else {
            this.customVariables = map2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UiConfig(AppConfig app, Map<LocaleId, ? extends Map<VariableLocalizationKey, String>> localizations, VariableConfig variableConfig, Map<String, CustomVariableDefinition> customVariables) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(localizations, "localizations");
        Intrinsics.checkNotNullParameter(variableConfig, "variableConfig");
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        this.app = app;
        this.localizations = localizations;
        this.variableConfig = variableConfig;
        this.customVariables = customVariables;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ UiConfig(AppConfig appConfig, Map map, VariableConfig variableConfig, Map map2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        int i4 = 3;
        this((i3 & 1) != 0 ? new AppConfig((Map) null, (Map) (0 == true ? 1 : 0), i4, (DefaultConstructorMarker) (0 == true ? 1 : 0)) : appConfig, (i3 & 2) != 0 ? MapsKt.emptyMap() : map, (i3 & 4) != 0 ? new VariableConfig((Map) (0 == true ? 1 : 0), (Map) (0 == true ? 1 : 0), i4, (DefaultConstructorMarker) (0 == true ? 1 : 0)) : variableConfig, (i3 & 8) != 0 ? MapsKt.emptyMap() : map2);
    }

    @SerialName
    public static /* synthetic */ void getCustomVariables$annotations() {
    }

    @Serializable(with = LocalizedVariableLocalizationKeyMapSerializer.class)
    public static /* synthetic */ void getLocalizations$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getVariableConfig$annotations() {
    }
}
