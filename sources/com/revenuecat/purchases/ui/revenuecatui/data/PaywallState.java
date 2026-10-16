package com.revenuecat.purchases.ui.revenuecatui.data;

import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.text.intl.LocaleList;
import com.facebook.internal.Utility;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.LocalizationKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.composables.SimpleSheetState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableDataProvider;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PackageExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.LocaleHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptySet;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallWarning;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

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
public interface PaywallState {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Error implements PaywallState {
        public static final int $stable = 0;
        private final String errorMessage;

        public Error(String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            this.errorMessage = errorMessage;
            Logger.INSTANCE.e("Paywall transitioned to error state: " + errorMessage);
        }

        public static /* synthetic */ Error copy$default(Error error, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = error.errorMessage;
            }
            return error.copy(str);
        }

        public final String component1() {
            return this.errorMessage;
        }

        public final Error copy(String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            return new Error(errorMessage);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual(this.errorMessage, ((Error) obj).errorMessage);
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public int hashCode() {
            return this.errorMessage.hashCode();
        }

        public String toString() {
            return "Error(errorMessage=" + this.errorMessage + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Loading implements PaywallState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        private Loading() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Loaded extends PaywallState {
        Offering getOffering();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Components implements Loaded {
            public static final int $stable = 0;
            private final MutableState actionInProgress$delegate;
            private final Lazy availableStorefrontCountryLocalesByLanguage$delegate;
            private final BackgroundStyles background;
            private final State currencyLocale$delegate;
            private final Map<String, CustomVariableValue> customVariables;
            private final Function0<Date> dateProvider;
            private final Map<String, CustomVariableValue> defaultCustomVariables;
            private final ComponentStyle header;
            private int headerHeightPx;
            private final String initialSelectedPackageOutsideTabs;
            private final String initialSelectedPackageUniqueId;
            private final State locale$delegate;
            private final MutableState localeId$delegate;
            private final NonEmptySet<LocaleId> locales;
            private final boolean mainStackHasHeroImage;
            private final Map<String, CustomVariableValue> mergedCustomVariables;
            private final State mostExpensivePricePerMonthMicros$delegate;
            private final Offering offering;
            private final AvailablePackages packages;
            private final Set<String> packagesOutsideTabsUniqueIds;
            private final PurchasesType purchases;
            private final State selectedOfferEligibility$delegate;
            private final SnapshotStateMap<Integer, String> selectedPackageByTab;
            private final State selectedPackageInfo$delegate;
            private final MutableState selectedPackageUniqueId$delegate;
            private final MutableIntState selectedTabIndex$delegate;
            private final SimpleSheetState sheet;
            private final boolean showPricesWithDecimals;
            private final ComponentStyle stack;
            private final ComponentStyle stickyFooter;
            private final String storefrontCountryCode;
            private final Map<String, Set<Integer>> tabsByUniqueId;
            private final UiConfig.VariableConfig variableConfig;
            private final VariableDataProvider variableDataProvider;

            /* JADX WARN: Multi-variable type inference failed */
            public Components(ComponentStyle stack, ComponentStyle componentStyle, ComponentStyle componentStyle2, BackgroundStyles background, boolean z2, boolean z3, UiConfig.VariableConfig variableConfig, VariableDataProvider variableDataProvider, Offering offering, NonEmptySet<LocaleId> locales, String str, Function0<? extends Date> dateProvider, AvailablePackages availablePackages, Map<String, ? extends CustomVariableValue> customVariables, Map<String, ? extends CustomVariableValue> defaultCustomVariables, LocaleList initialLocaleList, Integer num, SimpleSheetState initialSheetState, PurchasesType purchases) {
                Object next;
                AvailablePackages.Info info;
                Object next2;
                Intrinsics.checkNotNullParameter(stack, "stack");
                Intrinsics.checkNotNullParameter(background, "background");
                Intrinsics.checkNotNullParameter(variableConfig, "variableConfig");
                Intrinsics.checkNotNullParameter(variableDataProvider, "variableDataProvider");
                Intrinsics.checkNotNullParameter(offering, "offering");
                Intrinsics.checkNotNullParameter(locales, "locales");
                Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
                Intrinsics.checkNotNullParameter(availablePackages, pMpIcGE.RfNOZtb);
                Intrinsics.checkNotNullParameter(customVariables, "customVariables");
                Intrinsics.checkNotNullParameter(defaultCustomVariables, "defaultCustomVariables");
                Intrinsics.checkNotNullParameter(initialLocaleList, "initialLocaleList");
                Intrinsics.checkNotNullParameter(initialSheetState, "initialSheetState");
                Intrinsics.checkNotNullParameter(purchases, "purchases");
                this.stack = stack;
                this.header = componentStyle;
                this.stickyFooter = componentStyle2;
                this.background = background;
                this.mainStackHasHeroImage = z2;
                this.showPricesWithDecimals = z3;
                this.variableConfig = variableConfig;
                this.variableDataProvider = variableDataProvider;
                this.offering = offering;
                this.locales = locales;
                this.storefrontCountryCode = str;
                this.dateProvider = dateProvider;
                this.packages = availablePackages;
                this.customVariables = customVariables;
                this.defaultCustomVariables = defaultCustomVariables;
                this.purchases = purchases;
                this.mergedCustomVariables = MapsKt.plus(defaultCustomVariables, customVariables);
                Iterator<T> it = availablePackages.getPackagesOutsideTabs().iterator();
                while (true) {
                    if (it.hasNext()) {
                        next = it.next();
                        if (((AvailablePackages.Info) next).isSelectedByDefault()) {
                            break;
                        }
                    } else {
                        next = null;
                        break;
                    }
                }
                AvailablePackages.Info info2 = (AvailablePackages.Info) next;
                this.initialSelectedPackageOutsideTabs = info2 != null ? info2.getUniqueId() : null;
                List<AvailablePackages.Info> packagesOutsideTabs = this.packages.getPackagesOutsideTabs();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Iterator<T> it2 = packagesOutsideTabs.iterator();
                while (it2.hasNext()) {
                    linkedHashSet.add(((AvailablePackages.Info) it2.next()).getUniqueId());
                }
                this.packagesOutsideTabsUniqueIds = linkedHashSet;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<Integer, List<AvailablePackages.Info>> entry : this.packages.getPackagesByTab().entrySet()) {
                    int iIntValue = entry.getKey().intValue();
                    Iterator<T> it3 = entry.getValue().iterator();
                    while (it3.hasNext()) {
                        String uniqueId = ((AvailablePackages.Info) it3.next()).getUniqueId();
                        linkedHashMap.put(uniqueId, SetsKt.plus((Set<? extends Integer>) linkedHashMap.getOrDefault(uniqueId, SetsKt.emptySet()), Integer.valueOf(iIntValue)));
                    }
                }
                this.tabsByUniqueId = linkedHashMap;
                this.localeId$delegate = SnapshotStateKt__SnapshotStateKt.e(LocaleId.m612boximpl(m1063toLocaleId8pYHj4M(initialLocaleList)), null, 2, null);
                this.availableStorefrontCountryLocalesByLanguage$delegate = LazyKt.b(new Function0<Map<String, ? extends Locale>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$availableStorefrontCountryLocalesByLanguage$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Map<String, Locale> invoke() {
                        String str2 = this.this$0.storefrontCountryCode;
                        if (str2 == null || StringsKt.p0(str2)) {
                            return MapsKt.emptyMap();
                        }
                        PaywallState.Loaded.Components components = this.this$0;
                        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
                        Locale[] availableLocales = Locale.getAvailableLocales();
                        Intrinsics.checkNotNullExpressionValue(availableLocales, "getAvailableLocales()");
                        for (Locale availableLocale : availableLocales) {
                            if (StringsKt.F(availableLocale.getCountry(), components.storefrontCountryCode, true)) {
                                String language = availableLocale.getLanguage();
                                Intrinsics.checkNotNullExpressionValue(language, "availableLocale.language");
                                String lowerCase = language.toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                Intrinsics.checkNotNullExpressionValue(availableLocale, "availableLocale");
                                mapCreateMapBuilder.put(lowerCase, availableLocale);
                            }
                        }
                        return MapsKt.build(mapCreateMapBuilder);
                    }
                });
                this.locale$delegate = SnapshotStateKt.e(new Function0<androidx.compose.ui.text.intl.Locale>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$locale$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final androidx.compose.ui.text.intl.Locale invoke() {
                        return LocalizationKt.m732toComposeLocale_KYeFs0(this.this$0.m1061getLocaleIduqtKvyA());
                    }
                });
                this.currencyLocale$delegate = SnapshotStateKt.e(new Function0<androidx.compose.ui.text.intl.Locale>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$currencyLocale$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final androidx.compose.ui.text.intl.Locale invoke() {
                        String str2 = this.this$0.storefrontCountryCode;
                        if (str2 == null || StringsKt.p0(str2)) {
                            return this.this$0.getLocale();
                        }
                        String strA = this.this$0.getLocale().a();
                        Locale locale = Locale.ROOT;
                        String lowerCase = strA.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        Locale javaLocale = (Locale) this.this$0.getAvailableStorefrontCountryLocalesByLanguage().get(lowerCase);
                        if (javaLocale == null && (javaLocale = (Locale) CollectionsKt.firstOrNull(this.this$0.getAvailableStorefrontCountryLocalesByLanguage().values())) == null) {
                            Locale.Builder locale2 = new Locale.Builder().setLocale(LocalizationKt.toJavaLocale(this.this$0.getLocale()));
                            String upperCase = this.this$0.storefrontCountryCode.toUpperCase(locale);
                            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                            javaLocale = locale2.setRegion(upperCase).build();
                        }
                        Intrinsics.checkNotNullExpressionValue(javaLocale, "javaLocale");
                        return LocalizationKt.toComposeLocale(javaLocale);
                    }
                });
                SnapshotStateMap<Integer, String> snapshotStateMapH = SnapshotStateKt.h();
                Map<Integer, List<AvailablePackages.Info>> packagesByTab = this.packages.getPackagesByTab();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(packagesByTab.size()));
                Iterator<T> it4 = packagesByTab.entrySet().iterator();
                while (it4.hasNext()) {
                    Map.Entry entry2 = (Map.Entry) it4.next();
                    Object key = entry2.getKey();
                    Iterator it5 = ((List) entry2.getValue()).iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            next2 = it5.next();
                            if (((AvailablePackages.Info) next2).isSelectedByDefault()) {
                                break;
                            }
                        } else {
                            next2 = null;
                            break;
                        }
                    }
                    AvailablePackages.Info info3 = (AvailablePackages.Info) next2;
                    linkedHashMap2.put(key, info3 != null ? info3.getUniqueId() : null);
                }
                snapshotStateMapH.putAll(linkedHashMap2);
                this.selectedPackageByTab = snapshotStateMapH;
                this.selectedTabIndex$delegate = SnapshotIntStateKt.a(num != null ? num.intValue() : 0);
                String uniqueId2 = this.initialSelectedPackageOutsideTabs;
                if (uniqueId2 == null && (uniqueId2 = (String) snapshotStateMapH.get(Integer.valueOf(getSelectedTabIndex()))) == null) {
                    List<AvailablePackages.Info> list = this.packages.getPackagesByTab().get(Integer.valueOf(getSelectedTabIndex()));
                    uniqueId2 = (list == null || (info = (AvailablePackages.Info) CollectionsKt.firstOrNull((List) list)) == null) ? null : info.getUniqueId();
                }
                this.initialSelectedPackageUniqueId = uniqueId2;
                this.selectedPackageUniqueId$delegate = SnapshotStateKt__SnapshotStateKt.e(uniqueId2, null, 2, null);
                this.selectedPackageInfo$delegate = SnapshotStateKt.e(new Function0<SelectedPackageInfo>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$selectedPackageInfo$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final PaywallState.Loaded.Components.SelectedPackageInfo invoke() {
                        PaywallState.Loaded.Components.AvailablePackages.Info infoFindPackageInfoByUniqueId;
                        String selectedPackageUniqueId = this.this$0.getSelectedPackageUniqueId();
                        if (selectedPackageUniqueId == null || (infoFindPackageInfoByUniqueId = this.this$0.findPackageInfoByUniqueId(selectedPackageUniqueId)) == null) {
                            return null;
                        }
                        return new PaywallState.Loaded.Components.SelectedPackageInfo(infoFindPackageInfoByUniqueId.getPkg(), infoFindPackageInfoByUniqueId.getResolvedOffer(), selectedPackageUniqueId, PackageExtensionsKt.calculateOfferEligibility(infoFindPackageInfoByUniqueId.getResolvedOffer(), infoFindPackageInfoByUniqueId.getPkg()));
                    }
                });
                this.selectedOfferEligibility$delegate = SnapshotStateKt.e(new Function0<OfferEligibility>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$selectedOfferEligibility$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final OfferEligibility invoke() {
                        OfferEligibility offerEligibility;
                        PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = this.this$0.getSelectedPackageInfo();
                        return (selectedPackageInfo == null || (offerEligibility = selectedPackageInfo.getOfferEligibility()) == null) ? OfferEligibility.Ineligible.INSTANCE : offerEligibility;
                    }
                });
                this.mostExpensivePricePerMonthMicros$delegate = SnapshotStateKt.e(new Function0<Long>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$mostExpensivePricePerMonthMicros$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Long invoke() {
                        PaywallState.Loaded.Components components = this.this$0;
                        List<PaywallState.Loaded.Components.AvailablePackages.Info> packagesOutsideTabs2 = components.packages.getPackagesOutsideTabs();
                        List<PaywallState.Loaded.Components.AvailablePackages.Info> listEmptyList = this.this$0.packages.getPackagesByTab().get(Integer.valueOf(this.this$0.getSelectedTabIndex()));
                        if (listEmptyList == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        return components.mostExpensivePricePerMonthMicros(CollectionsKt.plus((Collection) packagesOutsideTabs2, (Iterable) listEmptyList));
                    }
                });
                this.actionInProgress$delegate = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                this.sheet = initialSheetState;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final AvailablePackages.Info findPackageInfoByUniqueId(String str) {
                Object obj;
                Object next;
                Iterator<T> it = this.packages.getPackagesOutsideTabs().iterator();
                while (true) {
                    obj = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(((AvailablePackages.Info) next).getUniqueId(), str)) {
                        break;
                    }
                }
                AvailablePackages.Info info = (AvailablePackages.Info) next;
                if (info != null) {
                    return info;
                }
                Iterator it2 = CollectionsKt.flatten(this.packages.getPackagesByTab().values()).iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next2 = it2.next();
                    if (Intrinsics.areEqual(((AvailablePackages.Info) next2).getUniqueId(), str)) {
                        obj = next2;
                        break;
                    }
                }
                return (AvailablePackages.Info) obj;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final Map<String, Locale> getAvailableStorefrontCountryLocalesByLanguage() {
                return (Map) this.availableStorefrontCountryLocalesByLanguage$delegate.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX INFO: renamed from: getLocaleId-uqtKvyA, reason: not valid java name */
            public final String m1061getLocaleIduqtKvyA() {
                return ((LocaleId) this.localeId$delegate.getValue()).m618unboximpl();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final String getSelectedPackageUniqueId() {
                return (String) this.selectedPackageUniqueId$delegate.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final Long mostExpensivePricePerMonthMicros(List<AvailablePackages.Info> list) {
                Object next;
                Iterator it = SequencesKt.N(SequencesKt.M(CollectionsKt.asSequence(list), new Function1<AvailablePackages.Info, StoreProduct>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$mostExpensivePricePerMonthMicros$4
                    @Override // kotlin.jvm.functions.Function1
                    public final StoreProduct invoke(PaywallState.Loaded.Components.AvailablePackages.Info info) {
                        Intrinsics.checkNotNullParameter(info, "info");
                        return info.getPkg().getProduct();
                    }
                }), new Function1<StoreProduct, Price>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$mostExpensivePricePerMonthMicros$5
                    @Override // kotlin.jvm.functions.Function1
                    public final Price invoke(StoreProduct product) {
                        Intrinsics.checkNotNullParameter(product, "product");
                        return StoreProduct.pricePerMonth$default(product, null, 1, null);
                    }
                }).iterator();
                if (it.hasNext()) {
                    next = it.next();
                    if (it.hasNext()) {
                        long amountMicros = ((Price) next).getAmountMicros();
                        do {
                            Object next2 = it.next();
                            long amountMicros2 = ((Price) next2).getAmountMicros();
                            if (amountMicros < amountMicros2) {
                                next = next2;
                                amountMicros = amountMicros2;
                            }
                        } while (it.hasNext());
                    }
                } else {
                    next = null;
                }
                Price price = (Price) next;
                if (price != null) {
                    return Long.valueOf(price.getAmountMicros());
                }
                return null;
            }

            private final void setActionInProgress(boolean z2) {
                this.actionInProgress$delegate.setValue(Boolean.valueOf(z2));
            }

            /* JADX INFO: renamed from: setLocaleId-_KYeFs0, reason: not valid java name */
            private final void m1062setLocaleId_KYeFs0(String str) {
                this.localeId$delegate.setValue(LocaleId.m612boximpl(str));
            }

            private final void setSelectedPackageUniqueId(String str) {
                this.selectedPackageUniqueId$delegate.setValue(str);
            }

            private final void setSelectedTabIndex(int i3) {
                this.selectedTabIndex$delegate.a(i3);
            }

            /* JADX INFO: renamed from: toLocaleId-8pYHj4M, reason: not valid java name */
            private final String m1063toLocaleId8pYHj4M(LocaleList localeList) {
                String localeId;
                String preferredUILocaleOverride = this.purchases.getPreferredUILocaleOverride();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(localeList, 10));
                Iterator<androidx.compose.ui.text.intl.Locale> it = localeList.iterator();
                while (it.hasNext()) {
                    arrayList.add(LocaleId.m612boximpl(LocalizationKt.toLocaleId(it.next())));
                }
                List listPlus = CollectionsKt.plus((Collection<? extends Object>) arrayList, this.locales.getHead());
                LocaleId localeId2 = null;
                if (preferredUILocaleOverride != null) {
                    try {
                        localeId = LocalizationKt.toLocaleId(LocalizationKt.toComposeLocale(LocaleHelpersKt.createLocaleFromString(preferredUILocaleOverride)));
                    } catch (Exception unused) {
                        localeId = null;
                    }
                    if (localeId != null) {
                        listPlus = CollectionsKt.plus((Collection) CollectionsKt.listOf(LocaleId.m612boximpl(localeId)), (Iterable) listPlus);
                    }
                }
                Iterator it2 = listPlus.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    String strM727getBestMatch64pKzr8 = LocalizationKt.m727getBestMatch64pKzr8(this.locales, ((LocaleId) it2.next()).m618unboximpl());
                    LocaleId localeIdM612boximpl = strM727getBestMatch64pKzr8 != null ? LocaleId.m612boximpl(strM727getBestMatch64pKzr8) : null;
                    if (localeIdM612boximpl != null) {
                        localeId2 = localeIdM612boximpl;
                        break;
                    }
                }
                if (localeId2 != null) {
                    return localeId2.m618unboximpl();
                }
                throw new NoSuchElementException("No element of the collection was transformed to a non-null value.");
            }

            public static /* synthetic */ void update$default(Components components, android.os.LocaleList localeList, Integer num, Boolean bool, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    localeList = null;
                }
                if ((i3 & 2) != 0) {
                    num = null;
                }
                if ((i3 & 4) != 0) {
                    bool = null;
                }
                components.update(localeList, num, bool);
            }

            public final Package defaultPackageForPackageRowAnalytics() {
                AvailablePackages.Info infoFindPackageInfoByUniqueId;
                String strPeekDefaultPackageUniqueIdAfterSheetDismiss = peekDefaultPackageUniqueIdAfterSheetDismiss();
                if (strPeekDefaultPackageUniqueIdAfterSheetDismiss == null || (infoFindPackageInfoByUniqueId = findPackageInfoByUniqueId(strPeekDefaultPackageUniqueIdAfterSheetDismiss)) == null) {
                    return null;
                }
                return infoFindPackageInfoByUniqueId.getPkg();
            }

            public final boolean getActionInProgress() {
                return ((Boolean) this.actionInProgress$delegate.getValue()).booleanValue();
            }

            public final BackgroundStyles getBackground() {
                return this.background;
            }

            public final androidx.compose.ui.text.intl.Locale getCurrencyLocale() {
                return (androidx.compose.ui.text.intl.Locale) this.currencyLocale$delegate.getValue();
            }

            public final Date getCurrentDate() {
                return (Date) this.dateProvider.invoke();
            }

            public final Map<String, CustomVariableValue> getCustomVariables() {
                return this.customVariables;
            }

            public final Map<String, CustomVariableValue> getDefaultCustomVariables() {
                return this.defaultCustomVariables;
            }

            public final ComponentStyle getHeader() {
                return this.header;
            }

            public final /* synthetic */ int getHeaderHeightPx() {
                return this.headerHeightPx;
            }

            public final androidx.compose.ui.text.intl.Locale getLocale() {
                return (androidx.compose.ui.text.intl.Locale) this.locale$delegate.getValue();
            }

            public final boolean getMainStackHasHeroImage() {
                return this.mainStackHasHeroImage;
            }

            public final Map<String, CustomVariableValue> getMergedCustomVariables() {
                return this.mergedCustomVariables;
            }

            public final Long getMostExpensivePricePerMonthMicros() {
                return (Long) this.mostExpensivePricePerMonthMicros$delegate.getValue();
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded
            public Offering getOffering() {
                return this.offering;
            }

            public final OfferEligibility getSelectedOfferEligibility() {
                return (OfferEligibility) this.selectedOfferEligibility$delegate.getValue();
            }

            public final SelectedPackageInfo getSelectedPackageInfo() {
                return (SelectedPackageInfo) this.selectedPackageInfo$delegate.getValue();
            }

            public final int getSelectedTabIndex() {
                return this.selectedTabIndex$delegate.g();
            }

            public final SimpleSheetState getSheet() {
                return this.sheet;
            }

            public final boolean getShowPricesWithDecimals() {
                return this.showPricesWithDecimals;
            }

            public final ComponentStyle getStack() {
                return this.stack;
            }

            public final ComponentStyle getStickyFooter() {
                return this.stickyFooter;
            }

            public final UiConfig.VariableConfig getVariableConfig() {
                return this.variableConfig;
            }

            public final VariableDataProvider getVariableDataProvider() {
                return this.variableDataProvider;
            }

            public final String peekDefaultPackageUniqueIdAfterSheetDismiss() {
                Object next;
                String uniqueId;
                List<AvailablePackages.Info> list = this.packages.getPackagesByTab().get(Integer.valueOf(getSelectedTabIndex()));
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        if (((AvailablePackages.Info) next).isSelectedByDefault()) {
                            break;
                        }
                    }
                    AvailablePackages.Info info = (AvailablePackages.Info) next;
                    if (info != null && (uniqueId = info.getUniqueId()) != null) {
                        return uniqueId;
                    }
                }
                String str = this.initialSelectedPackageOutsideTabs;
                return str == null ? (String) this.selectedPackageByTab.get(Integer.valueOf(getSelectedTabIndex())) : str;
            }

            public final SelectedPackageInfo peekSelectedPackageInfoAfterSheetDismiss() {
                String strPeekDefaultPackageUniqueIdAfterSheetDismiss = peekDefaultPackageUniqueIdAfterSheetDismiss();
                AvailablePackages.Info infoFindPackageInfoByUniqueId = strPeekDefaultPackageUniqueIdAfterSheetDismiss != null ? findPackageInfoByUniqueId(strPeekDefaultPackageUniqueIdAfterSheetDismiss) : null;
                if (strPeekDefaultPackageUniqueIdAfterSheetDismiss == null || infoFindPackageInfoByUniqueId == null) {
                    return null;
                }
                return new SelectedPackageInfo(infoFindPackageInfoByUniqueId.getPkg(), infoFindPackageInfoByUniqueId.getResolvedOffer(), strPeekDefaultPackageUniqueIdAfterSheetDismiss, PackageExtensionsKt.calculateOfferEligibility(infoFindPackageInfoByUniqueId.getResolvedOffer(), infoFindPackageInfoByUniqueId.getPkg()));
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void resetToDefaultPackage() {
                /*
                    r3 = this;
                    com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$AvailablePackages r0 = r3.packages
                    java.util.Map r0 = r0.getPackagesByTab()
                    int r1 = r3.getSelectedTabIndex()
                    java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                    java.lang.Object r0 = r0.get(r1)
                    java.util.List r0 = (java.util.List) r0
                    if (r0 == 0) goto L3b
                    java.lang.Iterable r0 = (java.lang.Iterable) r0
                    java.util.Iterator r0 = r0.iterator()
                L1c:
                    boolean r1 = r0.hasNext()
                    if (r1 == 0) goto L30
                    java.lang.Object r1 = r0.next()
                    r2 = r1
                    com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$AvailablePackages$Info r2 = (com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Components.AvailablePackages.Info) r2
                    boolean r2 = r2.isSelectedByDefault()
                    if (r2 == 0) goto L1c
                    goto L31
                L30:
                    r1 = 0
                L31:
                    com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$AvailablePackages$Info r1 = (com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Components.AvailablePackages.Info) r1
                    if (r1 == 0) goto L3b
                    java.lang.String r0 = r1.getUniqueId()
                    if (r0 != 0) goto L4f
                L3b:
                    java.lang.String r0 = r3.initialSelectedPackageOutsideTabs
                    if (r0 != 0) goto L4f
                    androidx.compose.runtime.snapshots.SnapshotStateMap<java.lang.Integer, java.lang.String> r0 = r3.selectedPackageByTab
                    int r1 = r3.getSelectedTabIndex()
                    java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                    java.lang.Object r0 = r0.get(r1)
                    java.lang.String r0 = (java.lang.String) r0
                L4f:
                    r3.setSelectedPackageUniqueId(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Components.resetToDefaultPackage():void");
            }

            public final /* synthetic */ void setHeaderHeightPx$revenuecatui_defaultsBc8Release(int i3) {
                this.headerHeightPx = i3;
            }

            public final void update(android.os.LocaleList localeList, Integer num, Boolean bool) {
                AvailablePackages.Info info;
                if (localeList != null) {
                    String languageTags = localeList.toLanguageTags();
                    Intrinsics.checkNotNullExpressionValue(languageTags, "localeList.toLanguageTags()");
                    m1062setLocaleId_KYeFs0(m1063toLocaleId8pYHj4M(new LocaleList(languageTags)));
                }
                if (num != null) {
                    setSelectedTabIndex(num.intValue());
                    if (getSelectedPackageUniqueId() != null && CollectionsKt.contains(this.packagesOutsideTabsUniqueIds, getSelectedPackageUniqueId())) {
                        return;
                    }
                    String uniqueId = (String) this.selectedPackageByTab.get(num);
                    if (uniqueId == null && (uniqueId = this.initialSelectedPackageOutsideTabs) == null) {
                        List<AvailablePackages.Info> list = this.packages.getPackagesByTab().get(num);
                        if (list == null || (info = (AvailablePackages.Info) CollectionsKt.firstOrNull((List) list)) == null || (uniqueId = info.getUniqueId()) == null) {
                            uniqueId = null;
                        } else {
                            Logger.INSTANCE.w("Could not find default package for tab " + num + ". Using first package instead. This could be caused by not having any package marked as selected by default.");
                        }
                    }
                    setSelectedPackageUniqueId(uniqueId);
                }
                if (bool != null) {
                    setActionInProgress(bool.booleanValue());
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class SelectedPackageInfo {
                public static final int $stable = 8;
                private final OfferEligibility offerEligibility;
                private final Package rcPackage;
                private final ResolvedOffer resolvedOffer;
                private final String uniqueId;

                public SelectedPackageInfo(Package rcPackage, ResolvedOffer resolvedOffer, String uniqueId, OfferEligibility offerEligibility) {
                    Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
                    Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
                    Intrinsics.checkNotNullParameter(offerEligibility, muQRKXGtpOhe.cNrKSyPptAfhmnH);
                    this.rcPackage = rcPackage;
                    this.resolvedOffer = resolvedOffer;
                    this.uniqueId = uniqueId;
                    this.offerEligibility = offerEligibility;
                }

                public static /* synthetic */ SelectedPackageInfo copy$default(SelectedPackageInfo selectedPackageInfo, Package r12, ResolvedOffer resolvedOffer, String str, OfferEligibility offerEligibility, int i3, Object obj) {
                    if ((i3 & 1) != 0) {
                        r12 = selectedPackageInfo.rcPackage;
                    }
                    if ((i3 & 2) != 0) {
                        resolvedOffer = selectedPackageInfo.resolvedOffer;
                    }
                    if ((i3 & 4) != 0) {
                        str = selectedPackageInfo.uniqueId;
                    }
                    if ((i3 & 8) != 0) {
                        offerEligibility = selectedPackageInfo.offerEligibility;
                    }
                    return selectedPackageInfo.copy(r12, resolvedOffer, str, offerEligibility);
                }

                public final Package component1() {
                    return this.rcPackage;
                }

                public final ResolvedOffer component2() {
                    return this.resolvedOffer;
                }

                public final String component3() {
                    return this.uniqueId;
                }

                public final OfferEligibility component4() {
                    return this.offerEligibility;
                }

                public final SelectedPackageInfo copy(Package rcPackage, ResolvedOffer resolvedOffer, String uniqueId, OfferEligibility offerEligibility) {
                    Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
                    Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
                    Intrinsics.checkNotNullParameter(offerEligibility, "offerEligibility");
                    return new SelectedPackageInfo(rcPackage, resolvedOffer, uniqueId, offerEligibility);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof SelectedPackageInfo)) {
                        return false;
                    }
                    SelectedPackageInfo selectedPackageInfo = (SelectedPackageInfo) obj;
                    return Intrinsics.areEqual(this.rcPackage, selectedPackageInfo.rcPackage) && Intrinsics.areEqual(this.resolvedOffer, selectedPackageInfo.resolvedOffer) && Intrinsics.areEqual(this.uniqueId, selectedPackageInfo.uniqueId) && Intrinsics.areEqual(this.offerEligibility, selectedPackageInfo.offerEligibility);
                }

                public final OfferEligibility getOfferEligibility() {
                    return this.offerEligibility;
                }

                public final Package getRcPackage() {
                    return this.rcPackage;
                }

                public final ResolvedOffer getResolvedOffer() {
                    return this.resolvedOffer;
                }

                public final String getUniqueId() {
                    return this.uniqueId;
                }

                public int hashCode() {
                    int iHashCode = this.rcPackage.hashCode() * 31;
                    ResolvedOffer resolvedOffer = this.resolvedOffer;
                    return ((((iHashCode + (resolvedOffer == null ? 0 : resolvedOffer.hashCode())) * 31) + this.uniqueId.hashCode()) * 31) + this.offerEligibility.hashCode();
                }

                public String toString() {
                    return "SelectedPackageInfo(rcPackage=" + this.rcPackage + ", resolvedOffer=" + this.resolvedOffer + ", uniqueId=" + this.uniqueId + ", offerEligibility=" + this.offerEligibility + ')';
                }

                public /* synthetic */ SelectedPackageInfo(Package r12, ResolvedOffer resolvedOffer, String str, OfferEligibility offerEligibility, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                    this(r12, (i3 & 2) != 0 ? null : resolvedOffer, str, offerEligibility);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AvailablePackages {
                public static final int $stable = 8;
                private final Map<Integer, List<Info>> packagesByTab;
                private final List<Info> packagesOutsideTabs;

                /* JADX WARN: Multi-variable type inference failed */
                public AvailablePackages(List<Info> packagesOutsideTabs, Map<Integer, ? extends List<Info>> packagesByTab) {
                    Intrinsics.checkNotNullParameter(packagesOutsideTabs, "packagesOutsideTabs");
                    Intrinsics.checkNotNullParameter(packagesByTab, "packagesByTab");
                    this.packagesOutsideTabs = packagesOutsideTabs;
                    this.packagesByTab = packagesByTab;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ AvailablePackages copy$default(AvailablePackages availablePackages, List list, Map map, int i3, Object obj) {
                    if ((i3 & 1) != 0) {
                        list = availablePackages.packagesOutsideTabs;
                    }
                    if ((i3 & 2) != 0) {
                        map = availablePackages.packagesByTab;
                    }
                    return availablePackages.copy(list, map);
                }

                public final List<Info> component1() {
                    return this.packagesOutsideTabs;
                }

                public final Map<Integer, List<Info>> component2() {
                    return this.packagesByTab;
                }

                public final AvailablePackages copy(List<Info> packagesOutsideTabs, Map<Integer, ? extends List<Info>> packagesByTab) {
                    Intrinsics.checkNotNullParameter(packagesOutsideTabs, "packagesOutsideTabs");
                    Intrinsics.checkNotNullParameter(packagesByTab, "packagesByTab");
                    return new AvailablePackages(packagesOutsideTabs, packagesByTab);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof AvailablePackages)) {
                        return false;
                    }
                    AvailablePackages availablePackages = (AvailablePackages) obj;
                    return Intrinsics.areEqual(this.packagesOutsideTabs, availablePackages.packagesOutsideTabs) && Intrinsics.areEqual(this.packagesByTab, availablePackages.packagesByTab);
                }

                public final boolean getHasAnyPackages() {
                    return (this.packagesOutsideTabs.isEmpty() && this.packagesByTab.isEmpty()) ? false : true;
                }

                public final Map<Integer, List<Info>> getPackagesByTab() {
                    return this.packagesByTab;
                }

                public final List<Info> getPackagesOutsideTabs() {
                    return this.packagesOutsideTabs;
                }

                public int hashCode() {
                    return (this.packagesOutsideTabs.hashCode() * 31) + this.packagesByTab.hashCode();
                }

                public final AvailablePackages merge(AvailablePackages availablePackages) {
                    List<Info> list = this.packagesOutsideTabs;
                    List<Info> listEmptyList = availablePackages != null ? availablePackages.packagesOutsideTabs : null;
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    List listPlus = CollectionsKt.plus((Collection) list, (Iterable) listEmptyList);
                    Map<Integer, List<Info>> mapEmptyMap = this.packagesByTab;
                    if (mapEmptyMap.isEmpty()) {
                        Map<Integer, List<Info>> map = availablePackages != null ? availablePackages.packagesByTab : null;
                        mapEmptyMap = map == null ? MapsKt.emptyMap() : map;
                    }
                    return new AvailablePackages(listPlus, mapEmptyMap);
                }

                public String toString() {
                    return "AvailablePackages(packagesOutsideTabs=" + this.packagesOutsideTabs + ", packagesByTab=" + this.packagesByTab + ')';
                }

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public static final class Info {
                    public static final int $stable = 8;
                    private final boolean isSelectedByDefault;
                    private final Package pkg;
                    private final ResolvedOffer resolvedOffer;
                    private final String uniqueId;

                    public Info(Package pkg, boolean z2, ResolvedOffer resolvedOffer) {
                        String identifier;
                        SubscriptionOption option;
                        Intrinsics.checkNotNullParameter(pkg, "pkg");
                        this.pkg = pkg;
                        this.isSelectedByDefault = z2;
                        this.resolvedOffer = resolvedOffer;
                        String id = null;
                        ResolvedOffer.ConfiguredOffer configuredOffer = resolvedOffer instanceof ResolvedOffer.ConfiguredOffer ? (ResolvedOffer.ConfiguredOffer) resolvedOffer : null;
                        if (configuredOffer != null && (option = configuredOffer.getOption()) != null) {
                            id = option.getId();
                        }
                        if (id != null) {
                            identifier = pkg.getIdentifier() + ':' + id;
                        } else {
                            identifier = pkg.getIdentifier();
                        }
                        this.uniqueId = identifier;
                    }

                    public static /* synthetic */ Info copy$default(Info info, Package r12, boolean z2, ResolvedOffer resolvedOffer, int i3, Object obj) {
                        if ((i3 & 1) != 0) {
                            r12 = info.pkg;
                        }
                        if ((i3 & 2) != 0) {
                            z2 = info.isSelectedByDefault;
                        }
                        if ((i3 & 4) != 0) {
                            resolvedOffer = info.resolvedOffer;
                        }
                        return info.copy(r12, z2, resolvedOffer);
                    }

                    public final Package component1() {
                        return this.pkg;
                    }

                    public final boolean component2() {
                        return this.isSelectedByDefault;
                    }

                    public final ResolvedOffer component3() {
                        return this.resolvedOffer;
                    }

                    public final Info copy(Package pkg, boolean z2, ResolvedOffer resolvedOffer) {
                        Intrinsics.checkNotNullParameter(pkg, "pkg");
                        return new Info(pkg, z2, resolvedOffer);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof Info)) {
                            return false;
                        }
                        Info info = (Info) obj;
                        return Intrinsics.areEqual(this.pkg, info.pkg) && this.isSelectedByDefault == info.isSelectedByDefault && Intrinsics.areEqual(this.resolvedOffer, info.resolvedOffer);
                    }

                    public final Package getPkg() {
                        return this.pkg;
                    }

                    public final ResolvedOffer getResolvedOffer() {
                        return this.resolvedOffer;
                    }

                    public final String getUniqueId() {
                        return this.uniqueId;
                    }

                    public int hashCode() {
                        int iHashCode = ((this.pkg.hashCode() * 31) + Boolean.hashCode(this.isSelectedByDefault)) * 31;
                        ResolvedOffer resolvedOffer = this.resolvedOffer;
                        return iHashCode + (resolvedOffer == null ? 0 : resolvedOffer.hashCode());
                    }

                    public final boolean isSelectedByDefault() {
                        return this.isSelectedByDefault;
                    }

                    public String toString() {
                        return "Info(pkg=" + this.pkg + ", isSelectedByDefault=" + this.isSelectedByDefault + ", resolvedOffer=" + this.resolvedOffer + ')';
                    }

                    public /* synthetic */ Info(Package r12, boolean z2, ResolvedOffer resolvedOffer, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                        this(r12, z2, (i3 & 4) != 0 ? null : resolvedOffer);
                    }
                }
            }

            public final void update(String selectedPackageUniqueId) {
                Intrinsics.checkNotNullParameter(selectedPackageUniqueId, "selectedPackageUniqueId");
                setSelectedPackageUniqueId(selectedPackageUniqueId);
                int selectedTabIndex = getSelectedTabIndex();
                Set<Integer> set = this.tabsByUniqueId.get(selectedPackageUniqueId);
                if (set == null || !set.contains(Integer.valueOf(selectedTabIndex))) {
                    return;
                }
                this.selectedPackageByTab.put(Integer.valueOf(selectedTabIndex), selectedPackageUniqueId);
            }

            public /* synthetic */ Components(ComponentStyle componentStyle, ComponentStyle componentStyle2, ComponentStyle componentStyle3, BackgroundStyles backgroundStyles, boolean z2, boolean z3, UiConfig.VariableConfig variableConfig, VariableDataProvider variableDataProvider, Offering offering, NonEmptySet nonEmptySet, String str, Function0 function0, AvailablePackages availablePackages, Map map, Map map2, LocaleList localeList, Integer num, SimpleSheetState simpleSheetState, PurchasesType purchasesType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(componentStyle, componentStyle2, componentStyle3, backgroundStyles, (i3 & 16) != 0 ? false : z2, z3, variableConfig, variableDataProvider, offering, nonEmptySet, str, function0, availablePackages, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? MapsKt.emptyMap() : map, (i3 & 16384) != 0 ? MapsKt.emptyMap() : map2, (32768 & i3) != 0 ? LocaleList.f29471c.a() : localeList, (65536 & i3) != 0 ? null : num, (i3 & 131072) != 0 ? new SimpleSheetState() : simpleSheetState, purchasesType);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Legacy implements Loaded {
            public static final int $stable = 0;
            private final Offering offering;
            private final MutableState<TemplateConfiguration.PackageInfo> selectedPackage;
            private final boolean shouldDisplayDismissButton;
            private final TemplateConfiguration templateConfiguration;
            private final PaywallWarning validationWarning;

            public Legacy(Offering offering, TemplateConfiguration templateConfiguration, MutableState<TemplateConfiguration.PackageInfo> selectedPackage, boolean z2, PaywallWarning paywallWarning) {
                Intrinsics.checkNotNullParameter(offering, "offering");
                Intrinsics.checkNotNullParameter(templateConfiguration, "templateConfiguration");
                Intrinsics.checkNotNullParameter(selectedPackage, "selectedPackage");
                this.offering = offering;
                this.templateConfiguration = templateConfiguration;
                this.selectedPackage = selectedPackage;
                this.shouldDisplayDismissButton = z2;
                this.validationWarning = paywallWarning;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Legacy copy$default(Legacy legacy, Offering offering, TemplateConfiguration templateConfiguration, MutableState mutableState, boolean z2, PaywallWarning paywallWarning, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    offering = legacy.offering;
                }
                if ((i3 & 2) != 0) {
                    templateConfiguration = legacy.templateConfiguration;
                }
                if ((i3 & 4) != 0) {
                    mutableState = legacy.selectedPackage;
                }
                if ((i3 & 8) != 0) {
                    z2 = legacy.shouldDisplayDismissButton;
                }
                if ((i3 & 16) != 0) {
                    paywallWarning = legacy.validationWarning;
                }
                PaywallWarning paywallWarning2 = paywallWarning;
                MutableState mutableState2 = mutableState;
                return legacy.copy(offering, templateConfiguration, mutableState2, z2, paywallWarning2);
            }

            public final Offering component1() {
                return this.offering;
            }

            public final TemplateConfiguration component2() {
                return this.templateConfiguration;
            }

            public final MutableState<TemplateConfiguration.PackageInfo> component3() {
                return this.selectedPackage;
            }

            public final boolean component4() {
                return this.shouldDisplayDismissButton;
            }

            public final PaywallWarning component5() {
                return this.validationWarning;
            }

            public final Legacy copy(Offering offering, TemplateConfiguration templateConfiguration, MutableState<TemplateConfiguration.PackageInfo> selectedPackage, boolean z2, PaywallWarning paywallWarning) {
                Intrinsics.checkNotNullParameter(offering, "offering");
                Intrinsics.checkNotNullParameter(templateConfiguration, "templateConfiguration");
                Intrinsics.checkNotNullParameter(selectedPackage, "selectedPackage");
                return new Legacy(offering, templateConfiguration, selectedPackage, z2, paywallWarning);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Legacy)) {
                    return false;
                }
                Legacy legacy = (Legacy) obj;
                return Intrinsics.areEqual(this.offering, legacy.offering) && Intrinsics.areEqual(this.templateConfiguration, legacy.templateConfiguration) && Intrinsics.areEqual(this.selectedPackage, legacy.selectedPackage) && this.shouldDisplayDismissButton == legacy.shouldDisplayDismissButton && Intrinsics.areEqual(this.validationWarning, legacy.validationWarning);
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded
            public Offering getOffering() {
                return this.offering;
            }

            public final MutableState<TemplateConfiguration.PackageInfo> getSelectedPackage() {
                return this.selectedPackage;
            }

            public final boolean getShouldDisplayDismissButton() {
                return this.shouldDisplayDismissButton;
            }

            public final TemplateConfiguration getTemplateConfiguration() {
                return this.templateConfiguration;
            }

            public final PaywallWarning getValidationWarning() {
                return this.validationWarning;
            }

            public int hashCode() {
                int iHashCode = ((((((this.offering.hashCode() * 31) + this.templateConfiguration.hashCode()) * 31) + this.selectedPackage.hashCode()) * 31) + Boolean.hashCode(this.shouldDisplayDismissButton)) * 31;
                PaywallWarning paywallWarning = this.validationWarning;
                return iHashCode + (paywallWarning == null ? 0 : paywallWarning.hashCode());
            }

            public final void selectPackage(TemplateConfiguration.PackageInfo packageInfo) {
                Intrinsics.checkNotNullParameter(packageInfo, "packageInfo");
                this.selectedPackage.setValue(packageInfo);
            }

            public String toString() {
                return "Legacy(offering=" + this.offering + ", templateConfiguration=" + this.templateConfiguration + ", selectedPackage=" + this.selectedPackage + ", shouldDisplayDismissButton=" + this.shouldDisplayDismissButton + ", validationWarning=" + this.validationWarning + ')';
            }

            public /* synthetic */ Legacy(Offering offering, TemplateConfiguration templateConfiguration, MutableState mutableState, boolean z2, PaywallWarning paywallWarning, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(offering, templateConfiguration, (MutableState<TemplateConfiguration.PackageInfo>) mutableState, z2, (i3 & 16) != 0 ? null : paywallWarning);
            }

            public /* synthetic */ Legacy(Offering offering, TemplateConfiguration templateConfiguration, TemplateConfiguration.PackageInfo packageInfo, boolean z2, PaywallWarning paywallWarning, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(offering, templateConfiguration, packageInfo, z2, (i3 & 16) != 0 ? null : paywallWarning);
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public Legacy(Offering offering, TemplateConfiguration templateConfiguration, TemplateConfiguration.PackageInfo selectedPackage, boolean z2, PaywallWarning paywallWarning) {
                this(offering, templateConfiguration, (MutableState<TemplateConfiguration.PackageInfo>) SnapshotStateKt__SnapshotStateKt.e(selectedPackage, null, 2, null), z2, paywallWarning);
                Intrinsics.checkNotNullParameter(offering, "offering");
                Intrinsics.checkNotNullParameter(templateConfiguration, "templateConfiguration");
                Intrinsics.checkNotNullParameter(selectedPackage, "selectedPackage");
            }
        }
    }
}
