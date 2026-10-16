package com.superwall.sdk.debug.localizations;

import com.facebook.internal.AnalyticsEvents;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class LocalizationOption {
    private final String country;
    private final String description;
    private final String language;
    private final String locale;
    private final List<String> popularLocales;

    public LocalizationOption(String language, String str, String locale, List<String> popularLocales) {
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(popularLocales, "popularLocales");
        this.language = language;
        this.country = str;
        this.locale = locale;
        this.popularLocales = popularLocales;
        if (str != null) {
            language = language + " (" + str + ")";
        }
        this.description = language;
    }

    private final List<String> component4() {
        return this.popularLocales;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LocalizationOption copy$default(LocalizationOption localizationOption, String str, String str2, String str3, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = localizationOption.language;
        }
        if ((i3 & 2) != 0) {
            str2 = localizationOption.country;
        }
        if ((i3 & 4) != 0) {
            str3 = localizationOption.locale;
        }
        if ((i3 & 8) != 0) {
            list = localizationOption.popularLocales;
        }
        return localizationOption.copy(str, str2, str3, list);
    }

    public final String component1() {
        return this.language;
    }

    public final String component2() {
        return this.country;
    }

    public final String component3() {
        return this.locale;
    }

    public final LocalizationOption copy(String language, String str, String locale, List<String> popularLocales) {
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(popularLocales, "popularLocales");
        return new LocalizationOption(language, str, locale, popularLocales);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalizationOption)) {
            return false;
        }
        LocalizationOption localizationOption = (LocalizationOption) obj;
        return Intrinsics.areEqual(this.language, localizationOption.language) && Intrinsics.areEqual(this.country, localizationOption.country) && Intrinsics.areEqual(this.locale, localizationOption.locale) && Intrinsics.areEqual(this.popularLocales, localizationOption.popularLocales);
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getSectionTitle() {
        return isPopular() ? "Localized" : this.language.length() > 0 ? String.valueOf(Character.toUpperCase(StringsKt.y1(this.language))) : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    public final String getSortDescription() {
        return (isPopular() ? "a" : "b") + " " + this.description;
    }

    public int hashCode() {
        int iHashCode = this.language.hashCode() * 31;
        String str = this.country;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.locale.hashCode()) * 31) + this.popularLocales.hashCode();
    }

    public final boolean included(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        Locale locale = Locale.ROOT;
        String lowerCase = query.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String lowerCase2 = this.description.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        if (StringsKt.a0(lowerCase2, lowerCase, false, 2, null)) {
            return true;
        }
        String lowerCase3 = this.locale.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
        return StringsKt.a0(lowerCase3, lowerCase, false, 2, null);
    }

    public final boolean isPopular() {
        return Intrinsics.areEqual(this.locale, "en") || this.popularLocales.contains(this.locale);
    }

    public String toString() {
        return "LocalizationOption(language=" + this.language + ", country=" + this.country + ", locale=" + this.locale + ", popularLocales=" + this.popularLocales + ")";
    }
}
