package com.superwall.sdk.debug.localizations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
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
public final class LocalizationLogic {
    public static final LocalizationLogic INSTANCE = new LocalizationLogic();

    private LocalizationLogic() {
    }

    public final List<LocalizationGrouping> getGroupings(List<LocalizationOption> localizationOptions) {
        Intrinsics.checkNotNullParameter(localizationOptions, "localizationOptions");
        ArrayList arrayList = new ArrayList();
        for (LocalizationOption localizationOption : localizationOptions) {
            String sectionTitle = localizationOption.getSectionTitle();
            LocalizationGrouping localizationGrouping = (LocalizationGrouping) CollectionsKt.lastOrNull((List) arrayList);
            if (!Intrinsics.areEqual(localizationGrouping != null ? localizationGrouping.getTitle() : null, sectionTitle)) {
                arrayList.add(new LocalizationGrouping(new ArrayList(), sectionTitle));
            }
            ((LocalizationGrouping) CollectionsKt.last((List) arrayList)).getLocalizations().add(localizationOption);
        }
        return arrayList;
    }

    public final List<LocalizationOption> getSortedLocalizations(List<String> localeIds, List<String> popularLocales) {
        Intrinsics.checkNotNullParameter(localeIds, "localeIds");
        Intrinsics.checkNotNullParameter(popularLocales, "popularLocales");
        ArrayList arrayList = new ArrayList();
        for (String str : localeIds) {
            Locale locale = new Locale(str);
            List listV0 = StringsKt.V0(str, new String[]{"_"}, false, 0, 6, null);
            String displayLanguage = locale.getDisplayLanguage();
            Intrinsics.checkNotNullExpressionValue(displayLanguage, "getDisplayLanguage(...)");
            String displayLanguage2 = displayLanguage.length() > 0 ? locale.getDisplayLanguage() : listV0.size() > 1 ? new Locale("", (String) CollectionsKt.first(listV0)).getDisplayLanguage() : "";
            String displayCountry = locale.getDisplayCountry();
            Intrinsics.checkNotNullExpressionValue(displayCountry, "getDisplayCountry(...)");
            arrayList.add(new LocalizationOption(displayLanguage2, displayCountry.length() > 0 ? locale.getDisplayCountry() : listV0.size() > 1 ? new Locale("", (String) CollectionsKt.last(listV0)).getDisplayCountry() : null, str, popularLocales));
        }
        if (arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new Comparator() { // from class: com.superwall.sdk.debug.localizations.LocalizationLogic$getSortedLocalizations$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t2, T t3) {
                    return ComparisonsKt.d(((LocalizationOption) t2).getSortDescription(), ((LocalizationOption) t3).getSortDescription());
                }
            });
        }
        return arrayList;
    }
}
