package com.revenuecat.purchases.ui.revenuecatui.extensions;

import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.ColorKt;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt;
import com.revenuecat.purchases.ui.revenuecatui.PaywallMode;
import com.revenuecat.purchases.ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.PaywallTemplate;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockResourceProvider;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class PaywallDataExtensionsKt {
    public static final void DefaultPaywallFooterCondensedPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(-1110154474);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1110154474, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.extensions.DefaultPaywallFooterCondensedPreview (PaywallDataExtensions.kt:168)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.extensions.PaywallDataExtensionsKt.DefaultPaywallFooterCondensedPreview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1159invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1159invoke();
                    return Unit.f139807a;
                }
            }).build(), new MockViewModel(PaywallMode.FOOTER_CONDENSED, getDefaultPreviewOffering(composerK, 0), null, false, false, 28, null), composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.extensions.PaywallDataExtensionsKt.DefaultPaywallFooterCondensedPreview.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    PaywallDataExtensionsKt.DefaultPaywallFooterCondensedPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void DefaultPaywallFooterPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(1073266441);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1073266441, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.extensions.DefaultPaywallFooterPreview (PaywallDataExtensions.kt:159)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.extensions.PaywallDataExtensionsKt.DefaultPaywallFooterPreview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1160invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1160invoke();
                    return Unit.f139807a;
                }
            }).build(), new MockViewModel(PaywallMode.FOOTER, getDefaultPreviewOffering(composerK, 0), null, false, false, 28, null), composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.extensions.PaywallDataExtensionsKt.DefaultPaywallFooterPreview.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    PaywallDataExtensionsKt.DefaultPaywallFooterPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void DefaultPaywallPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(1231396708);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1231396708, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.extensions.DefaultPaywallPreview (PaywallDataExtensions.kt:150)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.extensions.PaywallDataExtensionsKt.DefaultPaywallPreview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1161invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1161invoke();
                    return Unit.f139807a;
                }
            }).build(), new MockViewModel(null, getDefaultPreviewOffering(composerK, 0), null, false, false, 29, null), composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.extensions.PaywallDataExtensionsKt.DefaultPaywallPreview.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    PaywallDataExtensionsKt.DefaultPaywallPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: asPaywallColor-8_81llA, reason: not valid java name */
    private static final PaywallColor m1158asPaywallColor8_81llA(long j3) {
        return new PaywallColor(ColorKt.k(j3));
    }

    public static final PaywallData createDefault(PaywallData.Companion companion, List<Package> packages, ColorScheme currentColorScheme, ResourceProvider resourceProvider) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(packages, "packages");
        Intrinsics.checkNotNullParameter(currentColorScheme, "currentColorScheme");
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        PaywallData.Companion companion2 = PaywallData.Companion;
        List<Package> list = packages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Package) it.next()).getIdentifier());
        }
        return createDefaultForIdentifiers(companion2, arrayList, currentColorScheme, resourceProvider);
    }

    public static final PaywallData createDefaultForIdentifiers(PaywallData.Companion companion, List<String> packageIdentifiers, ColorScheme currentColors, ResourceProvider resourceProvider) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(packageIdentifiers, "packageIdentifiers");
        Intrinsics.checkNotNullParameter(currentColors, "currentColors");
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        PaywallData.Companion companion2 = PaywallData.Companion;
        return new PaywallData((String) null, getDefaultTemplate(companion2).getId(), new PaywallData.Configuration((List) packageIdentifiers, (String) null, new PaywallData.Configuration.Images((String) null, getDefaultBackgroundPlaceholder(companion2), getDefaultAppIconPlaceholder(companion2), 1, (DefaultConstructorMarker) null), (Map) null, defaultColors(companion2, currentColors), (Map) null, (List) null, true, true, (URL) null, (URL) null, 1642, (DefaultConstructorMarker) null), getDefaultTemplateBaseURL(companion2), getRevisionID(companion2), MapsKt.mapOf(TuplesKt.a(resourceProvider.getLocale().toString(), defaultLocalization(companion2, resourceProvider))), (Map) null, getZeroDecimalPlaceCountries(companion2), (String) null, 321, (DefaultConstructorMarker) null);
    }

    private static final PaywallData.Configuration.ColorInformation defaultColors(PaywallData.Companion companion, ColorScheme colorScheme) {
        PaywallData.Configuration.Colors themeColors = getThemeColors(colorScheme);
        return new PaywallData.Configuration.ColorInformation(themeColors, themeColors);
    }

    private static final PaywallData.LocalizedConfiguration defaultLocalization(PaywallData.Companion companion, ResourceProvider resourceProvider) {
        return new PaywallData.LocalizedConfiguration("{{ app_name }}", (String) null, resourceProvider.getString(R.string.continue_cta, new Object[0]), (String) null, (String) null, "{{ total_price_and_per_month }}", resourceProvider.getString(R.string.default_offer_details_with_intro_offer, new Object[0]), (String) null, "{{ sub_period }}", (List) null, (String) null, (Map) null, 3738, (DefaultConstructorMarker) null);
    }

    public static final String getDefaultAppIconPlaceholder(PaywallData.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return "revenuecatui_default_paywall_app_icon";
    }

    public static final String getDefaultBackgroundPlaceholder(PaywallData.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return "revenuecatui_default_paywall_background";
    }

    private static final Offering getDefaultPreviewOffering(Composer composer, int i3) {
        composer.a0(-363130030);
        if (ComposerKt.M()) {
            ComposerKt.U(-363130030, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.extensions.getDefaultPreviewOffering (PaywallDataExtensions.kt:127)");
        }
        TestData.Packages packages = TestData.Packages.INSTANCE;
        List listListOf = CollectionsKt.listOf((Object[]) new Package[]{packages.getWeekly(), packages.getMonthly(), packages.getAnnual()});
        Offering offering = new Offering("Template2", "", MapsKt.emptyMap(), listListOf, createDefault(PaywallData.Companion, listListOf, MaterialTheme.f18110a.a(composer, MaterialTheme.f18111b), new MockResourceProvider(null, null, null, null, null, 31, null)), null, null, 96, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return offering;
    }

    public static final PaywallTemplate getDefaultTemplate(PaywallData.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return PaywallTemplate.TEMPLATE_2;
    }

    private static final URL getDefaultTemplateBaseURL(PaywallData.Companion companion) {
        return new URL("https://");
    }

    private static final int getRevisionID(PaywallData.Companion companion) {
        return -1;
    }

    private static final PaywallData.Configuration.Colors getThemeColors(ColorScheme colorScheme) {
        return new PaywallData.Configuration.Colors(m1158asPaywallColor8_81llA(colorScheme.c()), m1158asPaywallColor8_81llA(colorScheme.V()), (PaywallColor) null, (PaywallColor) null, m1158asPaywallColor8_81llA(colorScheme.m0()), m1158asPaywallColor8_81llA(colorScheme.c()), (PaywallColor) null, m1158asPaywallColor8_81llA(colorScheme.j0()), m1158asPaywallColor8_81llA(colorScheme.U()), (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, 32332, (DefaultConstructorMarker) null);
    }

    private static final List<String> getZeroDecimalPlaceCountries(PaywallData.Companion companion) {
        return CollectionsKt.emptyList();
    }
}
