package com.revenuecat.purchases.ui.revenuecatui.templates;

import android.net.Uri;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt;
import com.revenuecat.purchases.ui.revenuecatui.PaywallMode;
import com.revenuecat.purchases.ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.ui.revenuecatui.UIConstant;
import com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.IconImageKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.InsetSpacersKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferDetailsKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIconKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIconName;
import com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallStateKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.WindowHelperKt;
import com.sun.jna.Function;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class Template3Kt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void Feature(final PaywallData.LocalizedConfiguration.Feature feature, final TemplateConfiguration.Colors colors, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-840535719);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(feature) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(colors) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-840535719, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Feature (Template3.kt:198)");
            }
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Vertical verticalL = companion.l();
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion2, 0.0f, 1, null);
            UIConstant uIConstant = UIConstant.INSTANCE;
            Modifier modifierK = PaddingKt.k(modifierH, uIConstant.m690getDefaultHorizontalPaddingD9Ej5fM(), 0.0f, 2, null);
            Template3UIConstants template3UIConstants = Template3UIConstants.INSTANCE;
            Modifier modifierE = SemanticsModifierKt.e(PaddingKt.m(modifierK, 0.0f, Dp.g(template3UIConstants.m1199getIconPaddingD9Ej5fM() * 2), 0.0f, 0.0f, 13, null), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template3Kt.Feature.1
                public final void invoke(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.f139807a;
                }
            });
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), verticalL, composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierE);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            String iconID = feature.getIconID();
            PaywallIconName paywallIconNameFromValue = iconID != null ? PaywallIconName.Companion.fromValue(iconID) : null;
            composerK.a0(-115319316);
            if (paywallIconNameFromValue != null) {
                Modifier modifierD = BackgroundKt.d(ClipKt.a(SizeKt.v(companion2, template3UIConstants.m1195getFeatureIconSizeD9Ej5fM()), RoundedCornerShapeKt.g()), colors.m1086getAccent20d7_KjU(), null, 2, null);
                MeasurePolicy measurePolicyG = BoxKt.g(companion.o(), false);
                int iA2 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU2 = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierD);
                Function0 function0A2 = companion3.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A2);
                } else {
                    composerK.v();
                }
                Composer composerA2 = Updater.a(composerK);
                Updater.e(composerA2, measurePolicyG, companion3.e());
                Updater.e(composerA2, compositionLocalMapU2, companion3.g());
                Function2 function2B2 = companion3.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion3.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                PaywallIconKt.m914PaywallIconFNF3uiM(paywallIconNameFromValue, PaddingKt.i(companion2, template3UIConstants.m1199getIconPaddingD9Ej5fM()), colors.m1085getAccent10d7_KjU(), composerK, 48, 0);
                composerK.y();
                Unit unit = Unit.f139807a;
            }
            composerK.U();
            Modifier modifierM = PaddingKt.m(companion2, uIConstant.m690getDefaultHorizontalPaddingD9Ej5fM(), 0.0f, 0.0f, 0.0f, 14, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), companion.k(), composerK, 0);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierM);
            Function0 function0A3 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A3);
            } else {
                composerK.v();
            }
            Composer composerA3 = Updater.a(composerK);
            Updater.e(composerA3, measurePolicyA, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            MaterialTheme materialTheme = MaterialTheme.f18110a;
            int i5 = MaterialTheme.f18111b;
            TextStyle textStyleB = materialTheme.c(composerK, i5).b();
            FontWeight.Companion companion4 = FontWeight.f29233b;
            FontWeight fontWeightB = companion4.b();
            TextAlign.Companion companion5 = TextAlign.f29616b;
            MarkdownKt.m901MarkdownDkhmgE0(feature.getTitle(), null, colors.m1093getText10d7_KjU(), textStyleB, 0L, fontWeightB, null, null, TextAlign.h(companion5.f()), false, true, false, composerK, 196608, 54, 722);
            String content = feature.getContent();
            composerK.a0(-929124297);
            if (content == null) {
                composer2 = composerK;
            } else {
                composer2 = composerK;
                MarkdownKt.m901MarkdownDkhmgE0(content, null, colors.m1094getText20d7_KjU(), materialTheme.c(composerK, i5).c(), 0L, companion4.g(), null, null, TextAlign.h(companion5.f()), false, true, false, composer2, 196608, 54, 722);
                Unit unit2 = Unit.f139807a;
            }
            composer2.U();
            composer2.y();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template3Kt.Feature.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i6) {
                    Template3Kt.Feature(feature, colors, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Features-TDGSqEk, reason: not valid java name */
    public static final void m1190FeaturesTDGSqEk(final ColumnScope columnScope, final PaywallState.Loaded.Legacy legacy, final float f3, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-2122368427);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(columnScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(legacy) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.c(f3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-2122368427, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Features (Template3.kt:172)");
            }
            List<PaywallData.LocalizedConfiguration.Feature> features = PaywallStateKt.getSelectedLocalization(legacy).getFeatures();
            TemplateConfiguration.Colors currentColors = legacy.getTemplateConfiguration().getCurrentColors(composerK, 0);
            if (features.isEmpty()) {
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                ScopeUpdateScope scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template3Kt$Features$1
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
                            Template3Kt.m1190FeaturesTDGSqEk(columnScope, legacy, f3, composer2, RecomposeScopeImplKt.a(i3 | 1));
                        }
                    });
                    return;
                }
                return;
            }
            Modifier modifierD = SizeKt.d(ColumnScope.b(columnScope, ScrollKt.g(Modifier.b8, ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null), 1.0f, false, 2, null), 0.0f, 1, null);
            Arrangement arrangement = Arrangement.f6574a;
            Alignment.Companion companion = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.q(f3, companion.i()), companion.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierD);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            composerK.a0(-1766546977);
            Iterator<T> it = features.iterator();
            while (it.hasNext()) {
                Feature((PaywallData.LocalizedConfiguration.Feature) it.next(), currentColors, composerK, 0);
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN2 = composerK.n();
        if (scopeUpdateScopeN2 != null) {
            scopeUpdateScopeN2.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template3Kt$Features$3
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
                    Template3Kt.m1190FeaturesTDGSqEk(columnScope, legacy, f3, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Icon(final PaywallState.Loaded.Legacy legacy, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-743688035);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(legacy) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-743688035, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Icon (Template3.kt:144)");
            }
            Uri iconUri = legacy.getTemplateConfiguration().getImages().getIconUri();
            Template3UIConstants template3UIConstants = Template3UIConstants.INSTANCE;
            IconImageKt.m891IconImagedjqsMU(iconUri, template3UIConstants.m1200getIconSizeD9Ej5fM(), template3UIConstants.m1198getIconCornerRadiusD9Ej5fM(), PaddingKt.m(Modifier.b8, 0.0f, UIConstant.INSTANCE.m693getDefaultVerticalSpacingD9Ej5fM(), 0.0f, 0.0f, 13, null), composerK, 432, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template3Kt.Icon.1
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
                    Template3Kt.Icon(legacy, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LandscapeContent(ColumnScope columnScope, PaywallState.Loaded.Legacy legacy, PaywallViewModel paywallViewModel, Composer composer, final int i3) {
        int i4;
        final ColumnScope columnScope2;
        final PaywallState.Loaded.Legacy legacy2;
        final PaywallViewModel paywallViewModel2;
        Composer composer2;
        Composer composerK = composer.k(-1763419076);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(columnScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(legacy) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(paywallViewModel) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i5 = i4;
        if ((i5 & 147) == 146 && composerK.l()) {
            composerK.Q();
            columnScope2 = columnScope;
            legacy2 = legacy;
            paywallViewModel2 = paywallViewModel;
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1763419076, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.LandscapeContent (Template3.kt:106)");
            }
            Arrangement.Horizontal horizontalD = Arrangement.Absolute.f6583a.d();
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Vertical verticalI = companion.i();
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierB = ColumnScope.b(columnScope, companion2, 1.0f, false, 2, null);
            UIConstant uIConstant = UIConstant.INSTANCE;
            Modifier modifierK = PaddingKt.k(PaddingKt.m(modifierB, 0.0f, uIConstant.m693getDefaultVerticalSpacingD9Ej5fM(), 0.0f, 0.0f, 13, null), uIConstant.m690getDefaultHorizontalPaddingD9Ej5fM(), 0.0f, 2, null);
            MeasurePolicy measurePolicyB = RowKt.b(horizontalD, verticalI, composerK, 54);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierK);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            columnScope2 = columnScope;
            Modifier modifierC = RowScope.c(rowScopeInstance, companion2, 0.5f, false, 2, null);
            Alignment.Horizontal horizontalG = companion.g();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.q(uIConstant.m693getDefaultVerticalSpacingD9Ej5fM(), companion.i()), horizontalG, composerK, 48);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierC);
            Function0 function0A2 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A2);
            } else {
                composerK.v();
            }
            Composer composerA2 = Updater.a(composerK);
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 0.5f, false, 2, null), composerK, 0);
            int i6 = i5 >> 3;
            int i7 = i6 & 14;
            Icon(legacy, composerK, i7);
            Title(legacy, composerK, i7);
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 0.5f, false, 2, null), composerK, 0);
            composerK.y();
            Modifier modifierC2 = RowScope.c(rowScopeInstance, companion2, 0.5f, false, 2, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion.k(), composerK, 0);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierC2);
            Function0 function0A3 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A3);
            } else {
                composerK.v();
            }
            Composer composerA3 = Updater.a(composerK);
            Updater.e(composerA3, measurePolicyA2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            m1190FeaturesTDGSqEk(columnScopeInstance, legacy, Template3UIConstants.INSTANCE.m1196getFeatureSpacingLandscapeD9Ej5fM(), composerK, 390 | (i5 & 112));
            OfferDetailsKt.m912OfferDetailsRPmYEkk(legacy, legacy.getTemplateConfiguration().getCurrentColors(composerK, 0).m1094getText20d7_KjU(), composerK, i7);
            legacy2 = legacy;
            paywallViewModel2 = paywallViewModel;
            composer2 = composerK;
            PurchaseButtonKt.m923PurchaseButtonhGBTI10(legacy2, paywallViewModel2, null, Dp.g(0), null, composer2, i7 | 3072 | (i6 & 112), 20);
            composer2.y();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template3Kt.LandscapeContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i8) {
                    Template3Kt.LandscapeContent(columnScope2, legacy2, paywallViewModel2, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PortraitContent(final ColumnScope columnScope, final PaywallState.Loaded.Legacy legacy, final PaywallViewModel paywallViewModel, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(949126752);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(columnScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(legacy) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(paywallViewModel) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i5 = i4;
        if ((i5 & 147) == 146 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(949126752, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.PortraitContent (Template3.kt:77)");
            }
            composerK.a0(-217227990);
            if (PaywallStateKt.isInFullScreenMode(legacy)) {
                Modifier modifierH = SizeKt.h(ColumnScope.b(columnScope, Modifier.b8, 1.0f, false, 2, null), 0.0f, 1, null);
                UIConstant uIConstant = UIConstant.INSTANCE;
                Modifier modifierJ = PaddingKt.j(modifierH, uIConstant.m690getDefaultHorizontalPaddingD9Ej5fM(), uIConstant.m693getDefaultVerticalSpacingD9Ej5fM());
                Alignment.Companion companion = Alignment.f25072a;
                MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.q(uIConstant.m693getDefaultVerticalSpacingD9Ej5fM(), companion.l()), companion.g(), composerK, 48);
                int iA = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU = composerK.u();
                Modifier modifierF = ComposedModifierKt.f(composerK, modifierJ);
                ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
                Function0 function0A = companion2.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A);
                } else {
                    composerK.v();
                }
                Composer composerA = Updater.a(composerK);
                Updater.e(composerA, measurePolicyA, companion2.e());
                Updater.e(composerA, compositionLocalMapU, companion2.g());
                Function2 function2B = companion2.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion2.f());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                InsetSpacersKt.StatusBarSpacer(composerK, 0);
                int i6 = (i5 >> 3) & 14;
                Icon(legacy, composerK, i6);
                Title(legacy, composerK, i6);
                m1190FeaturesTDGSqEk(columnScopeInstance, legacy, Template3UIConstants.INSTANCE.m1197getFeatureSpacingPortraitD9Ej5fM(), composerK, (i5 & 112) | 390);
                composerK.y();
            }
            composerK.U();
            SpacerKt.a(SizeKt.i(Modifier.b8, UIConstant.INSTANCE.m693getDefaultVerticalSpacingD9Ej5fM()), composerK, 0);
            int i7 = i5 >> 3;
            OfferDetailsKt.m912OfferDetailsRPmYEkk(legacy, legacy.getTemplateConfiguration().getCurrentColors(composerK, 0).m1094getText20d7_KjU(), composerK, i7 & 14);
            composer2 = composerK;
            PurchaseButtonKt.m923PurchaseButtonhGBTI10(legacy, paywallViewModel, null, 0.0f, null, composer2, i7 & 126, 28);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template3Kt.PortraitContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i8) {
                    Template3Kt.PortraitContent(columnScope, legacy, paywallViewModel, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void Template3(final PaywallState.Loaded.Legacy state, PaywallViewModel viewModel, Composer composer, final int i3) {
        int i4;
        final PaywallViewModel paywallViewModel;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer composerK = composer.k(-533890389);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(state) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(viewModel) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
            paywallViewModel = viewModel;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-533890389, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template3 (Template3.kt:64)");
            }
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            if (WindowHelperKt.shouldUseLandscapeLayout(state, composerK, i4 & 14)) {
                composerK.a0(-1741914098);
                int i5 = i4 << 3;
                LandscapeContent(columnScopeInstance, state, viewModel, composerK, (i5 & 896) | 6 | (i5 & 112));
                composerK.U();
            } else {
                composerK.a0(-1741850641);
                int i6 = i4 << 3;
                PortraitContent(columnScopeInstance, state, viewModel, composerK, (i6 & 896) | 6 | (i6 & 112));
                composerK.U();
            }
            paywallViewModel = viewModel;
            FooterKt.Footer(state.getTemplateConfiguration(), paywallViewModel, null, null, null, composerK, i4 & 112, 28);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template3Kt.Template3.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i7) {
                    Template3Kt.Template3(state, paywallViewModel, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template3CondensedFooterPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(1430130282);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1430130282, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template3CondensedFooterPreview (Template3.kt:280)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template3Kt.Template3CondensedFooterPreview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1192invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1192invoke();
                    return Unit.f139807a;
                }
            }).build(), new MockViewModel(PaywallMode.FOOTER_CONDENSED, TestData.INSTANCE.getTemplate3Offering(), null, false, false, 28, null), composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template3Kt.Template3CondensedFooterPreview.2
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
                    Template3Kt.Template3CondensedFooterPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template3FooterPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(-377072487);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-377072487, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template3FooterPreview (Template3.kt:271)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template3Kt.Template3FooterPreview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1193invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1193invoke();
                    return Unit.f139807a;
                }
            }).build(), new MockViewModel(PaywallMode.FOOTER, TestData.INSTANCE.getTemplate3Offering(), null, false, false, 28, null), composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template3Kt.Template3FooterPreview.2
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
                    Template3Kt.Template3FooterPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template3Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(2025889118);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(2025889118, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template3Preview (Template3.kt:262)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template3Kt.Template3Preview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1194invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1194invoke();
                    return Unit.f139807a;
                }
            }).build(), new MockViewModel(null, TestData.INSTANCE.getTemplate3Offering(), null, false, false, 29, null), composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template3Kt.Template3Preview.2
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
                    Template3Kt.Template3Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Title(final PaywallState.Loaded.Legacy legacy, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(887524410);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(legacy) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(887524410, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Title (Template3.kt:156)");
            }
            composer2 = composerK;
            MarkdownKt.m901MarkdownDkhmgE0(PaywallStateKt.getSelectedLocalization(legacy).getTitle(), null, legacy.getTemplateConfiguration().getCurrentColors(composerK, 0).m1093getText10d7_KjU(), MaterialTheme.f18110a.c(composerK, MaterialTheme.f18111b).i(), 0L, FontWeight.f29233b.h(), null, null, TextAlign.h(TextAlign.f29616b.a()), false, true, false, composer2, 196608, 54, 722);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template3Kt.Title.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i5) {
                    Template3Kt.Title(legacy, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
