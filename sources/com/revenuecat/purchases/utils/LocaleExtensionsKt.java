package com.revenuecat.purchases.utils;

import androidx.core.os.LocaleListCompat;
import coil.target.Yb.oUcQRqOVfOC;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
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
public final class LocaleExtensionsKt {
    public static final Locale convertToCorrectlyFormattedLocale(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        String string = locale.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString()");
        return toLocale(string);
    }

    public static final List<Locale> getDefaultLocales() {
        LocaleListCompat localeListCompatE = LocaleListCompat.e();
        Intrinsics.checkNotNullExpressionValue(localeListCompatE, "getDefault()");
        return toList(localeListCompatE);
    }

    public static final boolean sharedLanguageCodeWith(Locale locale, Locale locale2) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        Intrinsics.checkNotNullParameter(locale2, "locale");
        try {
            return Intrinsics.areEqual(locale.getISO3Language(), locale2.getISO3Language()) && Intrinsics.areEqual(inferScript(locale), inferScript(locale2));
        } catch (MissingResourceException e3) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Locale " + locale + " or " + locale2 + " can't obtain ISO3 language code (" + e3 + "). Falling back to language.", null);
            return Intrinsics.areEqual(locale.getLanguage(), locale2.getLanguage());
        }
    }

    private static final List<Locale> toList(LocaleListCompat localeListCompat) {
        int iH = localeListCompat.h();
        Locale[] localeArr = new Locale[iH];
        for (int i3 = 0; i3 < iH; i3++) {
            localeArr[i3] = localeListCompat.d(i3);
        }
        return ArraysKt.filterNotNull(localeArr);
    }

    public static final Locale toLocale(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Locale localeForLanguageTag = Locale.forLanguageTag(StringsKt.O(str, "_", "-", false, 4, null));
        Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, pMpIcGE.zlMRKzHXR);
        return localeForLanguageTag;
    }

    private static final String inferScript(Locale locale) {
        String country;
        String script = locale.getScript();
        if (script != null && script.length() != 0) {
            String script2 = locale.getScript();
            Intrinsics.checkNotNullExpressionValue(script2, oUcQRqOVfOC.tlpsXiLFU);
            return script2;
        }
        if (Intrinsics.areEqual(locale.getLanguage(), "zh") && (country = locale.getCountry()) != null) {
            int iHashCode = country.hashCode();
            if (iHashCode != 2155) {
                if (iHashCode != 2307) {
                    if (iHashCode != 2466) {
                        if (iHashCode != 2644) {
                            if (iHashCode == 2691 && country.equals("TW")) {
                                return "Hant";
                            }
                        } else if (country.equals("SG")) {
                            return "Hans";
                        }
                    } else if (country.equals(cJfnYMIyomoWf.WpJ)) {
                        return "Hant";
                    }
                } else if (country.equals("HK")) {
                    return "Hant";
                }
            } else if (country.equals("CN")) {
                return "Hans";
            }
        }
        return "";
    }
}
