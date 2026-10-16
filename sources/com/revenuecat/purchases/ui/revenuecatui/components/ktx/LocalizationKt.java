package com.revenuecat.purchases.ui.revenuecatui.components.ktx;

import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocalizationData;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls;
import com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyListKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMap;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMapKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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
public final class LocalizationKt {
    private static final Map<String, String> scriptByRegion = MapsKt.mapOf(TuplesKt.a("CN", "Hans"), TuplesKt.a("SG", "Hans"), TuplesKt.a("MY", "Hans"), TuplesKt.a("TW", "Hant"), TuplesKt.a("HK", "Hant"), TuplesKt.a("MO", "Hant"));

    /* JADX INFO: renamed from: getBestMatch-64pKzr8, reason: not valid java name */
    public static final /* synthetic */ Object m726getBestMatch64pKzr8(Map getBestMatch, String localeId) {
        Intrinsics.checkNotNullParameter(getBestMatch, "$this$getBestMatch");
        Intrinsics.checkNotNullParameter(localeId, "localeId");
        String strM727getBestMatch64pKzr8 = m727getBestMatch64pKzr8(getBestMatch.keySet(), localeId);
        if (strM727getBestMatch64pKzr8 != null) {
            return getBestMatch.get(LocaleId.m612boximpl(strM727getBestMatch64pKzr8));
        }
        return null;
    }

    private static final List<Locale> getFallbackLanguages(Locale locale) {
        String language = locale.getLanguage();
        return Intrinsics.areEqual(language, "nb") ? CollectionsKt.listOf(new Locale("no", locale.getCountry(), locale.getVariant())) : Intrinsics.areEqual(language, "nn") ? CollectionsKt.listOf(new Locale("no", locale.getCountry(), locale.getVariant())) : CollectionsKt.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: image-7v81vok, reason: not valid java name */
    public static final /* synthetic */ Result m728image7v81vok(NonEmptyMap image, String key) {
        Intrinsics.checkNotNullParameter(image, "$this$image");
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = image.get(LocalizationKey.m648boximpl(key));
        String str = null;
        Object[] objArr = 0;
        ThemeImageUrls themeImageUrlsM627unboximpl = obj instanceof LocalizationData.Image ? ((LocalizationData.Image) obj).m627unboximpl() : null;
        return themeImageUrlsM627unboximpl != null ? new Result.Success(themeImageUrlsM627unboximpl) : new Result.Error(new PaywallValidationError.MissingImageLocalization(key, str, 2, objArr == true ? 1 : 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: string-7v81vok, reason: not valid java name */
    public static final /* synthetic */ Result m730string7v81vok(NonEmptyMap string, String key) {
        Intrinsics.checkNotNullParameter(string, "$this$string");
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = string.get(LocalizationKey.m648boximpl(key));
        String str = null;
        Object[] objArr = 0;
        String strM636unboximpl = obj instanceof LocalizationData.Text ? ((LocalizationData.Text) obj).m636unboximpl() : null;
        return strM636unboximpl != null ? new Result.Success(strM636unboximpl) : new Result.Error(new PaywallValidationError.MissingStringLocalization(key, str, 2, objArr == true ? 1 : 0));
    }

    /* JADX INFO: renamed from: stringForAllLocales-7v81vok, reason: not valid java name */
    public static final /* synthetic */ Result m731stringForAllLocales7v81vok(NonEmptyMap stringForAllLocales, String key) {
        Intrinsics.checkNotNullParameter(stringForAllLocales, "$this$stringForAllLocales");
        Intrinsics.checkNotNullParameter(key, "key");
        Map map = stringForAllLocales.all;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key2 = entry.getKey();
            String strM618unboximpl = ((LocaleId) entry.getKey()).m618unboximpl();
            Result resultM730string7v81vok = m730string7v81vok((NonEmptyMap) entry.getValue(), key);
            if (!(resultM730string7v81vok instanceof Result.Success)) {
                if (!(resultM730string7v81vok instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                resultM730string7v81vok = new Result.Error(NonEmptyListKt.nonEmptyListOf(new PaywallValidationError.MissingStringLocalization(key, strM618unboximpl, null), new PaywallValidationError.MissingStringLocalization[0]));
            }
            linkedHashMap.put(key2, resultM730string7v81vok);
        }
        NonEmptyMap nonEmptyMapNonEmptyMapOf = NonEmptyMapKt.nonEmptyMapOf(TuplesKt.a(stringForAllLocales.getEntry().getKey(), MapsKt.getValue(linkedHashMap, stringForAllLocales.getEntry().getKey())), linkedHashMap);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        Result success = (Result) nonEmptyMapNonEmptyMapOf.getEntry().getValue();
        if (success instanceof Result.Success) {
            success = new Result.Success((String) ((Result.Success) success).getValue());
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            success = new Result.Success(TuplesKt.a(nonEmptyMapNonEmptyMapOf.getEntry().getKey(), ((Result.Success) success).getValue()));
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(success instanceof Result.Success) && (success instanceof Result.Error)) {
            arrayList.addAll((NonEmptyList) ((Result.Error) success).getValue());
        }
        Iterator it = nonEmptyMapNonEmptyMapOf.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            Object key3 = entry2.getKey();
            Result result = (Result) entry2.getValue();
            if (result instanceof Result.Success) {
                if (arrayList.isEmpty() && !Intrinsics.areEqual(key3, nonEmptyMapNonEmptyMapOf.getEntry().getKey())) {
                    linkedHashMap2.put(key3, (String) ((Result.Success) result).getValue());
                }
            } else if (result instanceof Result.Error) {
                arrayList.addAll((Collection) ((Result.Error) result).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(arrayList);
        return nonEmptyListOrNull != null ? new Result.Error(nonEmptyListOrNull) : new Result.Success(NonEmptyMapKt.nonEmptyMapOf((Pair) ResultKt.getOrThrow(success), linkedHashMap2));
    }

    public static final /* synthetic */ androidx.compose.ui.text.intl.Locale toComposeLocale(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        String languageTag = locale.toLanguageTag();
        Intrinsics.checkNotNullExpressionValue(languageTag, "toLanguageTag()");
        return new androidx.compose.ui.text.intl.Locale(languageTag);
    }

    /* JADX INFO: renamed from: toComposeLocale-_KYeFs0, reason: not valid java name */
    public static final /* synthetic */ androidx.compose.ui.text.intl.Locale m732toComposeLocale_KYeFs0(String toComposeLocale) {
        Intrinsics.checkNotNullParameter(toComposeLocale, "$this$toComposeLocale");
        return new androidx.compose.ui.text.intl.Locale(StringsKt.N(toComposeLocale, '_', '-', false, 4, null));
    }

    public static final /* synthetic */ Locale toJavaLocale(androidx.compose.ui.text.intl.Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        Locale localeForLanguageTag = Locale.forLanguageTag(locale.c());
        Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(toLanguageTag())");
        return localeForLanguageTag;
    }

    /* JADX INFO: renamed from: toJavaLocale-_KYeFs0, reason: not valid java name */
    public static final /* synthetic */ Locale m733toJavaLocale_KYeFs0(String toJavaLocale) {
        Intrinsics.checkNotNullParameter(toJavaLocale, "$this$toJavaLocale");
        Locale localeForLanguageTag = Locale.forLanguageTag(StringsKt.N(toJavaLocale, '_', '-', false, 4, null));
        Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(value.replace('_', '-'))");
        return localeForLanguageTag;
    }

    public static final /* synthetic */ String toLocaleId(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        String languageTag = locale.toLanguageTag();
        Intrinsics.checkNotNullExpressionValue(languageTag, "toLanguageTag()");
        return LocaleId.m613constructorimpl(StringsKt.N(languageTag, '-', '_', false, 4, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: video-7v81vok, reason: not valid java name */
    public static final /* synthetic */ Result m734video7v81vok(NonEmptyMap video, String key) {
        Intrinsics.checkNotNullParameter(video, "$this$video");
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = video.get(LocalizationKey.m648boximpl(key));
        String str = null;
        Object[] objArr = 0;
        ThemeVideoUrls themeVideoUrlsM645unboximpl = obj instanceof LocalizationData.Video ? ((LocalizationData.Video) obj).m645unboximpl() : null;
        return themeVideoUrlsM645unboximpl != null ? new Result.Success(themeVideoUrlsM645unboximpl) : new Result.Error(new PaywallValidationError.MissingVideoLocalization(key, str, 2, objArr == true ? 1 : 0));
    }

    /* JADX INFO: renamed from: videoForAllLocales-7v81vok, reason: not valid java name */
    public static final /* synthetic */ Result m735videoForAllLocales7v81vok(NonEmptyMap videoForAllLocales, String key) {
        Intrinsics.checkNotNullParameter(videoForAllLocales, "$this$videoForAllLocales");
        Intrinsics.checkNotNullParameter(key, "key");
        Map map = videoForAllLocales.all;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key2 = entry.getKey();
            String strM618unboximpl = ((LocaleId) entry.getKey()).m618unboximpl();
            Result resultM734video7v81vok = m734video7v81vok((NonEmptyMap) entry.getValue(), key);
            if (!(resultM734video7v81vok instanceof Result.Success)) {
                if (!(resultM734video7v81vok instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                resultM734video7v81vok = new Result.Error(NonEmptyListKt.nonEmptyListOf(new PaywallValidationError.MissingVideoLocalization(key, strM618unboximpl, null), new PaywallValidationError.MissingVideoLocalization[0]));
            }
            linkedHashMap.put(key2, resultM734video7v81vok);
        }
        NonEmptyMap nonEmptyMapNonEmptyMapOf = NonEmptyMapKt.nonEmptyMapOf(TuplesKt.a(videoForAllLocales.getEntry().getKey(), MapsKt.getValue(linkedHashMap, videoForAllLocales.getEntry().getKey())), linkedHashMap);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        Result success = (Result) nonEmptyMapNonEmptyMapOf.getEntry().getValue();
        if (success instanceof Result.Success) {
            success = new Result.Success((ThemeVideoUrls) ((Result.Success) success).getValue());
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            success = new Result.Success(TuplesKt.a(nonEmptyMapNonEmptyMapOf.getEntry().getKey(), ((Result.Success) success).getValue()));
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(success instanceof Result.Success) && (success instanceof Result.Error)) {
            arrayList.addAll((NonEmptyList) ((Result.Error) success).getValue());
        }
        Iterator it = nonEmptyMapNonEmptyMapOf.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            Object key3 = entry2.getKey();
            Result result = (Result) entry2.getValue();
            if (result instanceof Result.Success) {
                if (arrayList.isEmpty() && !Intrinsics.areEqual(key3, nonEmptyMapNonEmptyMapOf.getEntry().getKey())) {
                    linkedHashMap2.put(key3, (ThemeVideoUrls) ((Result.Success) result).getValue());
                }
            } else if (result instanceof Result.Error) {
                arrayList.addAll((Collection) ((Result.Error) result).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(arrayList);
        return nonEmptyListOrNull != null ? new Result.Error(nonEmptyListOrNull) : new Result.Success(NonEmptyMapKt.nonEmptyMapOf((Pair) ResultKt.getOrThrow(success), linkedHashMap2));
    }

    /* JADX INFO: renamed from: withFallbackLanguages-_KYeFs0, reason: not valid java name */
    private static final List<Locale> m736withFallbackLanguages_KYeFs0(String str) {
        Locale localeM733toJavaLocale_KYeFs0 = m733toJavaLocale_KYeFs0(str);
        List<Locale> fallbackLanguages = getFallbackLanguages(localeM733toJavaLocale_KYeFs0);
        if (fallbackLanguages.isEmpty()) {
            return CollectionsKt.listOf(localeM733toJavaLocale_KYeFs0);
        }
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        listCreateListBuilder.add(localeM733toJavaLocale_KYeFs0);
        listCreateListBuilder.addAll(fallbackLanguages);
        return CollectionsKt.build(listCreateListBuilder);
    }

    /* JADX INFO: renamed from: getBestMatch-64pKzr8, reason: not valid java name */
    public static final /* synthetic */ String m727getBestMatch64pKzr8(Set getBestMatch, String localeId) {
        LocaleId localeIdM612boximpl;
        String strM613constructorimpl;
        String strM613constructorimpl2;
        Object next;
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(getBestMatch, "$this$getBestMatch");
        Intrinsics.checkNotNullParameter(localeId, "localeId");
        if (getBestMatch.contains(LocaleId.m612boximpl(localeId))) {
            return localeId;
        }
        Iterator<T> it = m736withFallbackLanguages_KYeFs0(localeId).iterator();
        while (true) {
            if (!it.hasNext()) {
                localeIdM612boximpl = null;
                break;
            }
            Locale locale = (Locale) it.next();
            String language = locale.getLanguage();
            String country = locale.getCountry();
            String it2 = locale.getScript();
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            if (StringsKt.p0(it2)) {
                it2 = null;
            }
            if (it2 == null) {
                it2 = scriptByRegion.get(country);
            }
            Intrinsics.checkNotNullExpressionValue(language, "language");
            String strM613constructorimpl3 = LocaleId.m613constructorimpl(language);
            if (it2 != null) {
                strM613constructorimpl = LocaleId.m613constructorimpl(language + '_' + it2);
            } else {
                strM613constructorimpl = null;
            }
            if (it2 != null) {
                strM613constructorimpl2 = LocaleId.m613constructorimpl(language + '_' + it2 + '_' + country);
            } else {
                strM613constructorimpl2 = null;
            }
            String localeId2 = toLocaleId(locale);
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            listCreateListBuilder.add(LocaleId.m612boximpl(localeId2));
            if (strM613constructorimpl2 != null) {
                listCreateListBuilder.add(LocaleId.m612boximpl(strM613constructorimpl2));
            }
            if (strM613constructorimpl != null) {
                listCreateListBuilder.add(LocaleId.m612boximpl(strM613constructorimpl));
            }
            listCreateListBuilder.add(LocaleId.m612boximpl(strM613constructorimpl3));
            Iterator it3 = CollectionsKt.build(listCreateListBuilder).iterator();
            while (true) {
                if (!it3.hasNext()) {
                    next = null;
                    break;
                }
                next = it3.next();
                if (getBestMatch.contains(LocaleId.m612boximpl(((LocaleId) next).m618unboximpl()))) {
                    break;
                }
            }
            LocaleId localeId3 = (LocaleId) next;
            String strM618unboximpl = localeId3 != null ? localeId3.m618unboximpl() : null;
            if (strM618unboximpl == null) {
                Set set = getBestMatch;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
                Iterator it4 = set.iterator();
                while (it4.hasNext()) {
                    arrayList.add(m733toJavaLocale_KYeFs0(((LocaleId) it4.next()).m618unboximpl()));
                }
                int size = arrayList.size();
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        obj = null;
                        break;
                    }
                    obj = arrayList.get(i4);
                    i4++;
                    Locale locale2 = (Locale) obj;
                    if (Intrinsics.areEqual(locale2.getLanguage(), language) && Intrinsics.areEqual(locale2.getScript(), it2)) {
                        break;
                    }
                }
                Locale locale3 = (Locale) obj;
                if (locale3 != null) {
                    strM618unboximpl = toLocaleId(locale3);
                } else {
                    int size2 = arrayList.size();
                    while (true) {
                        if (i3 >= size2) {
                            obj2 = null;
                            break;
                        }
                        obj2 = arrayList.get(i3);
                        i3++;
                        if (Intrinsics.areEqual(((Locale) obj2).getLanguage(), language)) {
                            break;
                        }
                    }
                    Locale locale4 = (Locale) obj2;
                    strM618unboximpl = locale4 != null ? toLocaleId(locale4) : null;
                }
            }
            localeIdM612boximpl = strM618unboximpl != null ? LocaleId.m612boximpl(strM618unboximpl) : null;
            if (localeIdM612boximpl != null) {
                break;
            }
        }
        if (localeIdM612boximpl != null) {
            return localeIdM612boximpl.m618unboximpl();
        }
        return null;
    }

    /* JADX INFO: renamed from: imageForAllLocales-7v81vok, reason: not valid java name */
    public static final /* synthetic */ Result m729imageForAllLocales7v81vok(NonEmptyMap imageForAllLocales, String str) {
        Intrinsics.checkNotNullParameter(imageForAllLocales, "$this$imageForAllLocales");
        Intrinsics.checkNotNullParameter(str, tDEtWsFLJfe.ZKYTQMmueqj);
        Map map = imageForAllLocales.all;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            String strM618unboximpl = ((LocaleId) entry.getKey()).m618unboximpl();
            Result resultM728image7v81vok = m728image7v81vok((NonEmptyMap) entry.getValue(), str);
            if (!(resultM728image7v81vok instanceof Result.Success)) {
                if (!(resultM728image7v81vok instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                resultM728image7v81vok = new Result.Error(NonEmptyListKt.nonEmptyListOf(new PaywallValidationError.MissingImageLocalization(str, strM618unboximpl, null), new PaywallValidationError.MissingImageLocalization[0]));
            }
            linkedHashMap.put(key, resultM728image7v81vok);
        }
        NonEmptyMap nonEmptyMapNonEmptyMapOf = NonEmptyMapKt.nonEmptyMapOf(TuplesKt.a(imageForAllLocales.getEntry().getKey(), MapsKt.getValue(linkedHashMap, imageForAllLocales.getEntry().getKey())), linkedHashMap);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        Result success = (Result) nonEmptyMapNonEmptyMapOf.getEntry().getValue();
        if (success instanceof Result.Success) {
            success = new Result.Success((ThemeImageUrls) ((Result.Success) success).getValue());
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            success = new Result.Success(TuplesKt.a(nonEmptyMapNonEmptyMapOf.getEntry().getKey(), ((Result.Success) success).getValue()));
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(success instanceof Result.Success) && (success instanceof Result.Error)) {
            arrayList.addAll((NonEmptyList) ((Result.Error) success).getValue());
        }
        Iterator it = nonEmptyMapNonEmptyMapOf.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            Object key2 = entry2.getKey();
            Result result = (Result) entry2.getValue();
            if (result instanceof Result.Success) {
                if (arrayList.isEmpty() && !Intrinsics.areEqual(key2, nonEmptyMapNonEmptyMapOf.getEntry().getKey())) {
                    linkedHashMap2.put(key2, (ThemeImageUrls) ((Result.Success) result).getValue());
                }
            } else if (result instanceof Result.Error) {
                arrayList.addAll((Collection) ((Result.Error) result).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(arrayList);
        return nonEmptyListOrNull != null ? new Result.Error(nonEmptyListOrNull) : new Result.Success(NonEmptyMapKt.nonEmptyMapOf((Pair) ResultKt.getOrThrow(success), linkedHashMap2));
    }

    public static final /* synthetic */ String toLocaleId(androidx.compose.ui.text.intl.Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        return LocaleId.m613constructorimpl(StringsKt.N(locale.c(), '-', '_', false, 4, null));
    }
}
