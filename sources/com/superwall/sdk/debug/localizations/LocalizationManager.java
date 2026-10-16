package com.superwall.sdk.debug.localizations;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

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
public final class LocalizationManager {
    private final List<LocalizationGrouping> localizationGroupings;
    private final List<String> popularLocales = CollectionsKt.listOf((Object[]) new String[]{"de_DE", "es_US"});

    public LocalizationManager() {
        Locale[] availableLocales = Locale.getAvailableLocales();
        Intrinsics.checkNotNullExpressionValue(availableLocales, "getAvailableLocales(...)");
        ArrayList arrayList = new ArrayList(availableLocales.length);
        for (Locale locale : availableLocales) {
            arrayList.add(locale.toString());
        }
        LocalizationLogic localizationLogic = LocalizationLogic.INSTANCE;
        this.localizationGroupings = localizationLogic.getGroupings(localizationLogic.getSortedLocalizations(arrayList, this.popularLocales));
    }

    public final List<LocalizationGrouping> getLocalizationGroupings() {
        return this.localizationGroupings;
    }

    public final List<String> getPopularLocales() {
        return this.popularLocales;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.superwall.sdk.debug.localizations.LocalizationGrouping> localizationGroupings(java.lang.String r8) {
        /*
            r7 = this;
            if (r8 == 0) goto Lf
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r8 = r8.toLowerCase(r0)
            java.lang.String r0 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            if (r8 != 0) goto L11
        Lf:
            java.lang.String r8 = ""
        L11:
            int r0 = r8.length()
            if (r0 != 0) goto L1a
            java.util.List<com.superwall.sdk.debug.localizations.LocalizationGrouping> r8 = r7.localizationGroupings
            return r8
        L1a:
            java.util.List<com.superwall.sdk.debug.localizations.LocalizationGrouping> r0 = r7.localizationGroupings
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L27:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L77
            java.lang.Object r2 = r0.next()
            com.superwall.sdk.debug.localizations.LocalizationGrouping r2 = (com.superwall.sdk.debug.localizations.LocalizationGrouping) r2
            java.util.List r3 = r2.getLocalizations()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r3 = r3.iterator()
        L42:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L59
            java.lang.Object r5 = r3.next()
            r6 = r5
            com.superwall.sdk.debug.localizations.LocalizationOption r6 = (com.superwall.sdk.debug.localizations.LocalizationOption) r6
            boolean r6 = r6.included(r8)
            if (r6 == 0) goto L42
            r4.add(r5)
            goto L42
        L59:
            java.util.List r3 = kotlin.collections.CollectionsKt.toMutableList(r4)
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L70
            com.superwall.sdk.debug.localizations.LocalizationGrouping r4 = new com.superwall.sdk.debug.localizations.LocalizationGrouping
            java.lang.String r2 = r2.getTitle()
            r4.<init>(r3, r2)
            goto L71
        L70:
            r4 = 0
        L71:
            if (r4 == 0) goto L27
            r1.add(r4)
            goto L27
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.debug.localizations.LocalizationManager.localizationGroupings(java.lang.String):java.util.List");
    }
}
