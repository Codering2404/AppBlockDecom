package com.superwall.sdk.models.config;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

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
public final class LocalizationConfig {
    private List<LocaleConfig> locales;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(LocalizationConfig$LocaleConfig$$serializer.INSTANCE)};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<LocalizationConfig> serializer() {
            return LocalizationConfig$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class LocaleConfig {
        public static final Companion Companion = new Companion(null);
        private String locale;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<LocaleConfig> serializer() {
                return LocalizationConfig$LocaleConfig$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ LocaleConfig(int i3, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, LocalizationConfig$LocaleConfig$$serializer.INSTANCE.getDescriptor());
            }
            this.locale = str;
        }

        public static /* synthetic */ LocaleConfig copy$default(LocaleConfig localeConfig, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = localeConfig.locale;
            }
            return localeConfig.copy(str);
        }

        public final String component1() {
            return this.locale;
        }

        public final LocaleConfig copy(String locale) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            return new LocaleConfig(locale);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LocaleConfig) && Intrinsics.areEqual(this.locale, ((LocaleConfig) obj).locale);
        }

        public final String getLocale() {
            return this.locale;
        }

        public int hashCode() {
            return this.locale.hashCode();
        }

        public final void setLocale(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.locale = str;
        }

        public String toString() {
            return "LocaleConfig(locale=" + this.locale + ")";
        }

        public LocaleConfig(String locale) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            this.locale = locale;
        }

        @SerialName
        public static /* synthetic */ void getLocale$annotations() {
        }
    }

    public /* synthetic */ LocalizationConfig(int i3, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, LocalizationConfig$$serializer.INSTANCE.getDescriptor());
        }
        this.locales = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LocalizationConfig copy$default(LocalizationConfig localizationConfig, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = localizationConfig.locales;
        }
        return localizationConfig.copy(list);
    }

    public final List<LocaleConfig> component1() {
        return this.locales;
    }

    public final LocalizationConfig copy(List<LocaleConfig> locales) {
        Intrinsics.checkNotNullParameter(locales, "locales");
        return new LocalizationConfig(locales);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocalizationConfig) && Intrinsics.areEqual(this.locales, ((LocalizationConfig) obj).locales);
    }

    public final List<LocaleConfig> getLocales() {
        return this.locales;
    }

    public int hashCode() {
        return this.locales.hashCode();
    }

    public final void setLocales(List<LocaleConfig> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.locales = list;
    }

    public String toString() {
        return "LocalizationConfig(locales=" + this.locales + ")";
    }

    public LocalizationConfig(List<LocaleConfig> locales) {
        Intrinsics.checkNotNullParameter(locales, "locales");
        this.locales = locales;
    }
}
