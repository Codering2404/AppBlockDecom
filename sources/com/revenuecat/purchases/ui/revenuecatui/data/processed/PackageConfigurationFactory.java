package com.revenuecat.purchases.ui.revenuecatui.data.processed;

import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.ProcessedLocalizedConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessor;
import com.revenuecat.purchases.ui.revenuecatui.errors.PackageConfigurationError;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class PackageConfigurationFactory {
    public static final int $stable = 0;
    public static final PackageConfigurationFactory INSTANCE = new PackageConfigurationFactory();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PackageConfigurationType.values().length];
            try {
                iArr[PackageConfigurationType.SINGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PackageConfigurationType.MULTIPLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PackageConfigurationType.MULTITIER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private PackageConfigurationFactory() {
    }

    private final <K, V> Map<K, V> filterNotNullValues(Map<K, ? extends V> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            if (entry.getValue() != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x01d8  */
    /* JADX INFO: renamed from: makeMultiTierPackageConfiguration-yxL6bBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Object m1064makeMultiTierPackageConfigurationyxL6bBk(com.revenuecat.purchases.paywalls.PaywallData r16, java.util.List<java.lang.String> r17, java.util.List<com.revenuecat.purchases.Package> r18, com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableDataProvider r19, java.lang.String r20) {
        /*
            Method dump skipped, instruction units count: 495
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.data.processed.PackageConfigurationFactory.m1064makeMultiTierPackageConfigurationyxL6bBk(com.revenuecat.purchases.paywalls.PaywallData, java.util.List, java.util.List, com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableDataProvider, java.lang.String):java.lang.Object");
    }

    /* JADX INFO: renamed from: makeMultiplePackageConfiguration-yxL6bBk, reason: not valid java name */
    private final Object m1065makeMultiplePackageConfigurationyxL6bBk(List<Package> list, VariableDataProvider variableDataProvider, PaywallData paywallData, String str, String str2) {
        Object next;
        Pair<Locale, List<TemplateConfiguration.PackageInfo>> pairMakePackageInfo = makePackageInfo(list, variableDataProvider, paywallData, str2);
        Locale locale = (Locale) pairMakePackageInfo.a();
        List list2 = (List) pairMakePackageInfo.b();
        TemplateConfiguration.PackageInfo packageInfo = (TemplateConfiguration.PackageInfo) CollectionsKt.first(list2);
        Iterator it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((TemplateConfiguration.PackageInfo) next).getRcPackage().getIdentifier(), str)) {
                break;
            }
        }
        TemplateConfiguration.PackageInfo packageInfo2 = (TemplateConfiguration.PackageInfo) next;
        if (packageInfo2 == null) {
            packageInfo2 = packageInfo;
        }
        Result.Companion companion = Result.f139772b;
        return Result.b(TuplesKt.a(locale, new TemplateConfiguration.PackageConfiguration.Multiple(new TemplateConfiguration.PackageConfiguration.MultiPackage(packageInfo, packageInfo2, list2))));
    }

    private final Pair<Locale, List<TemplateConfiguration.PackageInfo>> makePackageInfo(List<Package> list, VariableDataProvider variableDataProvider, PaywallData paywallData, String str) {
        Price priceMostExpensivePricePerMonth = mostExpensivePricePerMonth(list);
        Pair<Locale, PaywallData.LocalizedConfiguration> localizedConfiguration = paywallData.getLocalizedConfiguration();
        Locale locale = (Locale) localizedConfiguration.a();
        PaywallData.LocalizedConfiguration localizedConfiguration2 = (PaywallData.LocalizedConfiguration) localizedConfiguration.b();
        List<Package> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Package r7 : list2) {
            Double dProductDiscount = INSTANCE.productDiscount(StoreProduct.pricePerMonth$default(r7.getProduct(), null, 1, null), priceMostExpensivePricePerMonth);
            boolean zContains = str != null ? paywallData.getZeroDecimalPlaceCountries().contains(str) : false;
            ProcessedLocalizedConfiguration.Companion companion = ProcessedLocalizedConfiguration.Companion;
            VariableProcessor.PackageContext packageContext = new VariableProcessor.PackageContext(dProductDiscount, zContains);
            VariableDataProvider variableDataProvider2 = variableDataProvider;
            arrayList.add(new TemplateConfiguration.PackageInfo(r7, companion.create(variableDataProvider2, packageContext, localizedConfiguration2, r7, locale), dProductDiscount));
            variableDataProvider = variableDataProvider2;
        }
        return TuplesKt.a(locale, arrayList);
    }

    /* JADX INFO: renamed from: makeSinglePackageConfiguration-BWLJW6A, reason: not valid java name */
    private final Object m1066makeSinglePackageConfigurationBWLJW6A(List<Package> list, VariableDataProvider variableDataProvider, PaywallData paywallData, String str) {
        Pair<Locale, List<TemplateConfiguration.PackageInfo>> pairMakePackageInfo = makePackageInfo(list, variableDataProvider, paywallData, str);
        Locale locale = (Locale) pairMakePackageInfo.a();
        TemplateConfiguration.PackageInfo packageInfo = (TemplateConfiguration.PackageInfo) CollectionsKt.first((List) pairMakePackageInfo.b());
        Result.Companion companion = Result.f139772b;
        return Result.b(TuplesKt.a(locale, new TemplateConfiguration.PackageConfiguration.Single(packageInfo)));
    }

    private final Price mostExpensivePricePerMonth(List<Package> list) {
        Object next;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            next = null;
            if (!it.hasNext()) {
                break;
            }
            Price pricePricePerMonth$default = StoreProduct.pricePerMonth$default(((Package) it.next()).getProduct(), null, 1, null);
            if (pricePricePerMonth$default != null) {
                arrayList.add(pricePricePerMonth$default);
            }
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            next = it2.next();
            if (it2.hasNext()) {
                long amountMicros = ((Price) next).getAmountMicros();
                do {
                    Object next2 = it2.next();
                    long amountMicros2 = ((Price) next2).getAmountMicros();
                    if (amountMicros < amountMicros2) {
                        next = next2;
                        amountMicros = amountMicros2;
                    }
                } while (it2.hasNext());
            }
        }
        return (Price) next;
    }

    private final Double productDiscount(Price price, Price price2) {
        if (price != null) {
            long amountMicros = price.getAmountMicros();
            if (price2 != null) {
                long amountMicros2 = price2.getAmountMicros();
                if (amountMicros >= amountMicros2) {
                    return null;
                }
                return Double.valueOf((amountMicros2 - amountMicros) / amountMicros2);
            }
        }
        return null;
    }

    private final List<TemplateConfiguration.PackageInfo> reprocessPackagesForTiers(List<Package> list, List<String> list2, PaywallData.LocalizedConfiguration localizedConfiguration, VariableDataProvider variableDataProvider, Locale locale, String str, List<String> list3) {
        Locale locale2;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list2.iterator();
        while (true) {
            locale2 = null;
            Object obj = null;
            if (!it.hasNext()) {
                break;
            }
            String str2 = (String) it.next();
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (Intrinsics.areEqual(((Package) next).getIdentifier(), str2)) {
                    obj = next;
                    break;
                }
            }
            Package r4 = (Package) obj;
            if (r4 != null) {
                arrayList.add(r4);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            arrayList2.add((Package) obj2);
        }
        Price priceMostExpensivePricePerMonth = mostExpensivePricePerMonth(arrayList2);
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size2 = arrayList.size();
        int i4 = 0;
        while (i4 < size2) {
            Object obj3 = arrayList.get(i4);
            i4++;
            Package r14 = (Package) obj3;
            Double dProductDiscount = INSTANCE.productDiscount(StoreProduct.pricePerMonth$default(r14.getProduct(), locale2, 1, locale2), priceMostExpensivePricePerMonth);
            arrayList3.add(new TemplateConfiguration.PackageInfo(r14, ProcessedLocalizedConfiguration.Companion.create(variableDataProvider, new VariableProcessor.PackageContext(dProductDiscount, str != null ? list3.contains(str) : false), localizedConfiguration, r14, locale), dProductDiscount));
            locale2 = null;
        }
        return arrayList3;
    }

    /* JADX INFO: renamed from: createPackageConfiguration-bMdYcbs, reason: not valid java name */
    public final Object m1067createPackageConfigurationbMdYcbs(VariableDataProvider variableDataProvider, List<Package> availablePackages, List<String> packageIdsInConfig, String str, PackageConfigurationType configurationType, PaywallData paywallData, String str2) {
        Intrinsics.checkNotNullParameter(variableDataProvider, "variableDataProvider");
        Intrinsics.checkNotNullParameter(availablePackages, "availablePackages");
        Intrinsics.checkNotNullParameter(packageIdsInConfig, "packageIdsInConfig");
        Intrinsics.checkNotNullParameter(configurationType, "configurationType");
        Intrinsics.checkNotNullParameter(paywallData, "paywallData");
        List<Package> list = availablePackages;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(((Package) obj).getIdentifier(), obj);
        }
        List<Package> arrayList = new ArrayList<>();
        for (String str3 : packageIdsInConfig) {
            Package r4 = (Package) linkedHashMap.get(str3);
            if (r4 == null) {
                Logger.INSTANCE.d("Package with id " + str3 + " not found. Ignoring.");
            }
            if (r4 != null) {
                arrayList.add(r4);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        if (arrayList == null) {
            arrayList = availablePackages;
        }
        if (arrayList.isEmpty()) {
            Result.Companion companion = Result.f139772b;
            return Result.b(ResultKt.a(new PackageConfigurationError("No packages found for ids " + packageIdsInConfig)));
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[configurationType.ordinal()];
        if (i3 == 1) {
            return m1066makeSinglePackageConfigurationBWLJW6A(arrayList, variableDataProvider, paywallData, str2);
        }
        if (i3 == 2) {
            return m1065makeMultiplePackageConfigurationyxL6bBk(arrayList, variableDataProvider, paywallData, str, str2);
        }
        if (i3 == 3) {
            return m1064makeMultiTierPackageConfigurationyxL6bBk(paywallData, packageIdsInConfig, availablePackages, variableDataProvider, str2);
        }
        throw new NoWhenBranchMatchedException();
    }
}
