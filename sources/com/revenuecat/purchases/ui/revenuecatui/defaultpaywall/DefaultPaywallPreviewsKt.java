package com.revenuecat.purchases.ui.revenuecatui.defaultpaywall;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.ProcessedLocalizedConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DualColorImageGenerator;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallWarning;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class DefaultPaywallPreviewsKt {
    private static final List<TemplateConfiguration.PackageInfo> previewPackages;

    static {
        TestData.Packages packages = TestData.Packages.INSTANCE;
        List<Package> listListOf = CollectionsKt.listOf((Object[]) new Package[]{packages.getAnnual(), packages.getMonthly()});
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf, 10));
        for (Package r2 : listListOf) {
            arrayList.add(new TemplateConfiguration.PackageInfo(r2, new ProcessedLocalizedConfiguration(r2.getProduct().getName(), null, "Continue", null, null, null, null, null, r2.getProduct().getName(), null, null, null, 1024, null), null));
        }
        previewPackages = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DefaultPaywallBlueGreenPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(657651692);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(657651692, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallBlueGreenPreview (DefaultPaywallPreviews.kt:61)");
            }
            DefaultPaywallPreview(DualColorImageGenerator.INSTANCE.getBlueGreen(), null, composerK, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreviewsKt.DefaultPaywallBlueGreenPreview.1
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
                    DefaultPaywallPreviewsKt.DefaultPaywallBlueGreenPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DefaultPaywallPreview(final DualColorImageGenerator.PreviewAppIcon previewAppIcon, final PaywallWarning paywallWarning, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1946056999);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(previewAppIcon) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(paywallWarning) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1946056999, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreview (DefaultPaywallPreviews.kt:114)");
            }
            MaterialThemeKt.b(DarkThemeKt.a(composerK, 0) ? ColorSchemeKt.e(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 15, null) : ColorSchemeKt.k(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 15, null), null, null, ComposableLambdaKt.e(2020893435, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreviewsKt.DefaultPaywallPreview.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    if ((i5 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(2020893435, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreview.<anonymous> (DefaultPaywallPreviews.kt:117)");
                    }
                    DefaultPaywallViewKt.DefaultPaywallView(DefaultPaywallPreviewsKt.previewPackages, (TemplateConfiguration.PackageInfo) CollectionsKt.first(DefaultPaywallPreviewsKt.previewPackages), paywallWarning, new Function1<TemplateConfiguration.PackageInfo, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreviewsKt.DefaultPaywallPreview.1.1
                        public final void invoke(TemplateConfiguration.PackageInfo it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((TemplateConfiguration.PackageInfo) obj);
                            return Unit.f139807a;
                        }
                    }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreviewsKt.DefaultPaywallPreview.1.2
                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m1104invoke() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1104invoke();
                            return Unit.f139807a;
                        }
                    }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreviewsKt.DefaultPaywallPreview.1.3
                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m1105invoke() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1105invoke();
                            return Unit.f139807a;
                        }
                    }, BackgroundKt.d(Modifier.b8, MaterialTheme.f18110a.a(composer2, MaterialTheme.f18111b).c(), null, 2, null), new DefaultPaywallPreviewOverrides("RevenueCat", previewAppIcon.getBitmap(), previewAppIcon.getProminentColors(), Boolean.TRUE), composer2, 224256, 0);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, 3072, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreviewsKt.DefaultPaywallPreview.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    DefaultPaywallPreviewsKt.DefaultPaywallPreview(previewAppIcon, paywallWarning, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DefaultPaywallPurpleOrangePreview(Composer composer, final int i3) {
        Composer composerK = composer.k(361581643);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(361581643, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPurpleOrangePreview (DefaultPaywallPreviews.kt:75)");
            }
            DefaultPaywallPreview(DualColorImageGenerator.INSTANCE.getPurpleOrange(), null, composerK, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreviewsKt.DefaultPaywallPurpleOrangePreview.1
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
                    DefaultPaywallPreviewsKt.DefaultPaywallPurpleOrangePreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DefaultPaywallRedGreenPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(-848283725);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-848283725, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallRedGreenPreview (DefaultPaywallPreviews.kt:47)");
            }
            DefaultPaywallPreview(DualColorImageGenerator.INSTANCE.getRedGreen(), null, composerK, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreviewsKt.DefaultPaywallRedGreenPreview.1
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
                    DefaultPaywallPreviewsKt.DefaultPaywallRedGreenPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DefaultPaywallWarningLocalizationPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(-197693384);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-197693384, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallWarningLocalizationPreview (DefaultPaywallPreviews.kt:89)");
            }
            DefaultPaywallPreview(DualColorImageGenerator.INSTANCE.getRedGreen(), PaywallWarning.MissingLocalization.INSTANCE, composerK, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreviewsKt.DefaultPaywallWarningLocalizationPreview.1
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
                    DefaultPaywallPreviewsKt.DefaultPaywallWarningLocalizationPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DefaultPaywallWarningNoPaywallPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(-684325386);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-684325386, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallWarningNoPaywallPreview (DefaultPaywallPreviews.kt:103)");
            }
            DefaultPaywallPreview(DualColorImageGenerator.INSTANCE.getPurpleOrange(), new PaywallWarning.NoPaywall("WAT"), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreviewsKt.DefaultPaywallWarningNoPaywallPreview.1
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
                    DefaultPaywallPreviewsKt.DefaultPaywallWarningNoPaywallPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
