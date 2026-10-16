package com.revenuecat.purchases.ui.revenuecatui.templates;

import android.net.Uri;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
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
import com.revenuecat.purchases.ui.revenuecatui.composables.InsetSpacersKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityStateViewKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIconKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIconName;
import com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.RemoteImageKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallStateKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.ui.revenuecatui.extensions.AnimationsKt;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PackageExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.WindowHelperKt;
import com.sun.jna.Function;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class Template5Kt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void AnimatedPackages(final com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Legacy r23, final com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel r24, boolean r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt.AnimatedPackages(com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Legacy, com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CheckmarkBox(final boolean z2, final TemplateConfiguration.Colors colors, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1250908873);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(colors) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1250908873, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.CheckmarkBox (Template5.kt:438)");
            }
            Modifier modifierD = BackgroundKt.d(ClipKt.a(SizeKt.v(Modifier.b8, Template5UIConstants.INSTANCE.m1219getCheckmarkSizeD9Ej5fM()), RoundedCornerShapeKt.g()), z2 ? colors.m1088getBackground0d7_KjU() : getUnselectedOutline(colors), null, 2, null);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierD);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            composerK.a0(1030134494);
            if (z2) {
                PaywallIconKt.m914PaywallIconFNF3uiM(PaywallIconName.CHECK_CIRCLE, null, getSelectedOutline(colors), composerK, 6, 2);
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt.CheckmarkBox.2
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
                    Template5Kt.CheckmarkBox(z2, colors, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DiscountBanner(final RowScope rowScope, PaywallState.Loaded.Legacy legacy, TemplateConfiguration.PackageInfo packageInfo, Composer composer, final int i3) {
        int i4;
        final PaywallState.Loaded.Legacy legacy2 = legacy;
        final TemplateConfiguration.PackageInfo packageInfo2 = packageInfo;
        Composer composerK = composer.k(1630065399);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(rowScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(legacy2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(packageInfo2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) != 146 || !composerK.l()) {
            if (ComposerKt.M()) {
                ComposerKt.U(1630065399, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.DiscountBanner (Template5.kt:458)");
            }
            String offerBadge = packageInfo2.getLocalization().getOfferBadge();
            if (offerBadge != null) {
                String upperCase = offerBadge.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                if (upperCase != null) {
                    if (StringsKt.p0(upperCase)) {
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
                        if (scopeUpdateScopeN != null) {
                            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt.DiscountBanner.1
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
                                    Template5Kt.DiscountBanner(rowScope, legacy2, packageInfo2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                                }
                            });
                            return;
                        }
                        return;
                    }
                    int i5 = i4 >> 3;
                    TemplateConfiguration.Colors currentColors = PaywallStateKt.getCurrentColors(legacy2, composerK, i5 & 14);
                    int i6 = i5 & 126;
                    long jM1156packageButtonColorAnimation9z6LAg8 = AnimationsKt.m1156packageButtonColorAnimation9z6LAg8(legacy2, packageInfo2, getSelectedOutline(currentColors), getUnselectedOutline(currentColors), composerK, i6);
                    legacy2 = legacy;
                    packageInfo2 = packageInfo;
                    long jM1156packageButtonColorAnimation9z6LAg82 = AnimationsKt.m1156packageButtonColorAnimation9z6LAg8(legacy2, packageInfo2, getSelectedDiscountText(currentColors), getUnselectedDiscountText(currentColors), composerK, i6);
                    Modifier.Companion companion = Modifier.b8;
                    Alignment.Companion companion2 = Alignment.f25072a;
                    Modifier modifierD = rowScope.d(companion, companion2.l());
                    UIConstant uIConstant = UIConstant.INSTANCE;
                    float fM690getDefaultHorizontalPaddingD9Ej5fM = uIConstant.m690getDefaultHorizontalPaddingD9Ej5fM();
                    Template5UIConstants template5UIConstants = Template5UIConstants.INSTANCE;
                    Modifier modifierC = OffsetKt.c(modifierD, Dp.g(fM690getDefaultHorizontalPaddingD9Ej5fM - template5UIConstants.m1220getDiscountPaddingD9Ej5fM()), Dp.g(Dp.g(-uIConstant.m693getDefaultVerticalSpacingD9Ej5fM()) + template5UIConstants.m1220getDiscountPaddingD9Ej5fM()));
                    MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
                    int iA = ComposablesKt.a(composerK, 0);
                    CompositionLocalMap compositionLocalMapU = composerK.u();
                    Modifier modifierF = ComposedModifierKt.f(composerK, modifierC);
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
                    Updater.e(composerA, measurePolicyG, companion3.e());
                    Updater.e(composerA, compositionLocalMapU, companion3.g());
                    Function2 function2B = companion3.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion3.f());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                    Modifier modifierK = PaddingKt.k(PaddingKt.k(BackgroundKt.c(companion, jM1156packageButtonColorAnimation9z6LAg8, ButtonDefaults.f16077a.t(composerK, ButtonDefaults.f16091o)), 0.0f, Dp.g(4), 1, null), Dp.g(8), 0.0f, 2, null);
                    MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
                    int iA2 = ComposablesKt.a(composerK, 0);
                    CompositionLocalMap compositionLocalMapU2 = composerK.u();
                    Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierK);
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
                    Updater.e(composerA2, measurePolicyG2, companion3.e());
                    Updater.e(composerA2, compositionLocalMapU2, companion3.g());
                    Function2 function2B2 = companion3.b();
                    if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                        composerA2.w(Integer.valueOf(iA2));
                        composerA2.p(Integer.valueOf(iA2), function2B2);
                    }
                    Updater.e(composerA2, modifierF2, companion3.f());
                    TextKt.c(upperCase, null, jM1156packageButtonColorAnimation9z6LAg82, 0L, null, FontWeight.f29233b.g(), null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f18110a.c(composerK, MaterialTheme.f18111b).m(), composerK, 196608, 0, 65498);
                    composerK.y();
                    composerK.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            ScopeUpdateScope scopeUpdateScopeN2 = composerK.n();
            if (scopeUpdateScopeN2 != null) {
                scopeUpdateScopeN2.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt$DiscountBanner$text$1
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
                        Template5Kt.DiscountBanner(rowScope, legacy2, packageInfo2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                    }
                });
                return;
            }
            return;
        }
        composerK.Q();
        ScopeUpdateScope scopeUpdateScopeN3 = composerK.n();
        if (scopeUpdateScopeN3 != null) {
            scopeUpdateScopeN3.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt.DiscountBanner.3
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
                    Template5Kt.DiscountBanner(rowScope, legacy2, packageInfo2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Feature(final PaywallData.LocalizedConfiguration.Feature feature, final TemplateConfiguration.Colors colors, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-840476137);
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
                ComposerKt.U(-840476137, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Feature (Template5.kt:274)");
            }
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Vertical verticalI = companion.i();
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierE = SemanticsModifierKt.e(SizeKt.h(companion2, 0.0f, 1, null), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt.Feature.1
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
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), verticalI, composerK, 48);
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
            Modifier modifierV = SizeKt.v(companion2, Template5UIConstants.INSTANCE.m1221getFeatureIconSizeD9Ej5fM());
            MeasurePolicy measurePolicyG = BoxKt.g(companion.o(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierV);
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
            String iconID = feature.getIconID();
            PaywallIconName paywallIconNameFromValue = iconID != null ? PaywallIconName.Companion.fromValue(iconID) : null;
            composerK.a0(-929062679);
            if (paywallIconNameFromValue != null) {
                PaywallIconKt.m914PaywallIconFNF3uiM(paywallIconNameFromValue, null, getFeatureIcon(colors), composerK, 0, 2);
                Unit unit = Unit.f139807a;
            }
            composerK.U();
            composerK.y();
            Modifier modifierM = PaddingKt.m(companion2, UIConstant.INSTANCE.m690getDefaultHorizontalPaddingD9Ej5fM(), 0.0f, 0.0f, 0.0f, 14, null);
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
            FontWeight fontWeightG = companion4.g();
            TextAlign.Companion companion5 = TextAlign.f29616b;
            MarkdownKt.m901MarkdownDkhmgE0(feature.getTitle(), null, colors.m1093getText10d7_KjU(), textStyleB, 0L, fontWeightG, null, null, TextAlign.h(companion5.f()), false, true, false, composerK, 196608, 54, 722);
            String content = feature.getContent();
            composerK.a0(-929039817);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt.Feature.3
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
                    Template5Kt.Feature(feature, colors, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Features(final PaywallState.Loaded.Legacy legacy, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-330300649);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(legacy) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-330300649, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Features (Template5.kt:259)");
            }
            TemplateConfiguration.Colors currentColors = legacy.getTemplateConfiguration().getCurrentColors(composerK, 0);
            Iterator<T> it = PaywallStateKt.getSelectedLocalization(legacy).getFeatures().iterator();
            while (it.hasNext()) {
                Feature((PaywallData.LocalizedConfiguration.Feature) it.next(), currentColors, composerK, 0);
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt.Features.2
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
                    Template5Kt.Features(legacy, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HeaderImage(final Uri uri, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(108940117);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(uri) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(108940117, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.HeaderImage (Template5.kt:228)");
            }
            if (uri != null) {
                String string = uri.toString();
                Intrinsics.checkNotNullExpressionValue(string, "uri.toString()");
                RemoteImageKt.RemoteImage(string, AspectRatioKt.b(Modifier.b8, 2.0f, false, 2, null), null, ContentScale.f27054a.a(), null, null, 0.0f, null, composerK, 3120, 244);
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt.HeaderImage.2
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
                    Template5Kt.HeaderImage(uri, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SelectPackageButton(final ColumnScope columnScope, final PaywallState.Loaded.Legacy legacy, final TemplateConfiguration.PackageInfo packageInfo, final PaywallViewModel paywallViewModel, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(423303156);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(columnScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(legacy) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(packageInfo) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(paywallViewModel) ? 2048 : 1024;
        }
        int i5 = i4;
        if ((i5 & 1171) == 1170 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(423303156, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.SelectPackageButton (Template5.kt:370)");
            }
            int i6 = i5 >> 3;
            final TemplateConfiguration.Colors currentColors = PaywallStateKt.getCurrentColors(legacy, composerK, i6 & 14);
            final boolean zAreEqual = Intrinsics.areEqual(packageInfo, legacy.getSelectedPackage().getValue());
            float fPackageButtonActionInProgressOpacityAnimation = AnimationsKt.packageButtonActionInProgressOpacityAnimation(paywallViewModel, composerK, (i5 >> 9) & 14);
            final long jM1093getText10d7_KjU = currentColors.m1093getText10d7_KjU();
            long jM1156packageButtonColorAnimation9z6LAg8 = AnimationsKt.m1156packageButtonColorAnimation9z6LAg8(legacy, packageInfo, getSelectedOutline(currentColors), getUnselectedOutline(currentColors), composerK, i6 & 126);
            Modifier modifierC = columnScope.c(AlphaKt.a(SizeKt.h(Modifier.b8, 0.0f, 1, null), fPackageButtonActionInProgressOpacityAnimation), Alignment.f25072a.k());
            composerK.a0(1055889971);
            boolean zB = composerK.b(zAreEqual);
            Object objG = composerK.G();
            if (zB || objG == Composer.f23746a.a()) {
                objG = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt$SelectPackageButton$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        SemanticsPropertiesKt.s0(semantics, zAreEqual);
                    }
                };
                composerK.w(objG);
            }
            composerK.U();
            Modifier modifierF = SemanticsModifierKt.f(modifierC, false, (Function1) objG, 1, null);
            ButtonColors buttonColorsB = ButtonDefaults.f16077a.b(Color.f25715b.j(), jM1093getText10d7_KjU, 0L, 0L, composerK, (ButtonDefaults.f16091o << 12) | 6, 12);
            UIConstant uIConstant = UIConstant.INSTANCE;
            RoundedCornerShape roundedCornerShapeD = RoundedCornerShapeKt.d(uIConstant.m692getDefaultPackageCornerRadiusD9Ej5fM());
            PaddingValues paddingValuesB = PaddingKt.b(uIConstant.m690getDefaultHorizontalPaddingD9Ej5fM(), uIConstant.m693getDefaultVerticalSpacingD9Ej5fM());
            BorderStroke borderStrokeA = BorderStrokeKt.a(uIConstant.m691getDefaultPackageBorderWidthD9Ej5fM(), jM1156packageButtonColorAnimation9z6LAg8);
            composerK.a0(1055892398);
            boolean z2 = ((i5 & 7168) == 2048) | ((i5 & 112) == 32) | ((i5 & 896) == 256);
            Object objG2 = composerK.G();
            if (z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt$SelectPackageButton$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1214invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m1214invoke() {
                        TemplatePackageRowInteractionKt.trackTemplatePackageRowSelectionIfChanged$default(paywallViewModel, legacy, packageInfo, null, 4, null);
                        paywallViewModel.selectPackage(packageInfo);
                    }
                };
                composerK.w(objG2);
            }
            composerK.U();
            ButtonKt.a((Function0) objG2, modifierF, false, roundedCornerShapeD, buttonColorsB, null, borderStrokeA, paddingValuesB, null, ComposableLambdaKt.e(644978660, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt.SelectPackageButton.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(RowScope Button, Composer composer2, int i7) {
                    Intrinsics.checkNotNullParameter(Button, "$this$Button");
                    if ((i7 & 17) == 16 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(644978660, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.SelectPackageButton.<anonymous> (Template5.kt:405)");
                    }
                    Modifier.Companion companion = Modifier.b8;
                    Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
                    Arrangement arrangement = Arrangement.f6574a;
                    Arrangement.HorizontalOrVertical horizontalOrVerticalO = arrangement.o(Dp.g(4));
                    Alignment.Companion companion2 = Alignment.f25072a;
                    Alignment.Horizontal horizontalK = companion2.k();
                    TemplateConfiguration.PackageInfo packageInfo2 = packageInfo;
                    long j3 = jM1093getText10d7_KjU;
                    boolean z3 = zAreEqual;
                    TemplateConfiguration.Colors colors = currentColors;
                    PaywallState.Loaded.Legacy legacy2 = legacy;
                    MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalO, horizontalK, composer2, 54);
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierH);
                    ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
                    Function0 function0A = companion3.a();
                    if (composer2.m() == null) {
                        ComposablesKt.c();
                    }
                    composer2.L();
                    if (composer2.i()) {
                        composer2.P(function0A);
                    } else {
                        composer2.v();
                    }
                    Composer composerA = Updater.a(composer2);
                    Updater.e(composerA, measurePolicyA, companion3.e());
                    Updater.e(composerA, compositionLocalMapU, companion3.g());
                    Function2 function2B = companion3.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF2, companion3.f());
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                    MeasurePolicy measurePolicyB = RowKt.b(arrangement.o(Dp.g(6)), companion2.i(), composer2, 54);
                    int iA2 = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU2 = composer2.u();
                    Modifier modifierF3 = ComposedModifierKt.f(composer2, companion);
                    Function0 function0A2 = companion3.a();
                    if (composer2.m() == null) {
                        ComposablesKt.c();
                    }
                    composer2.L();
                    if (composer2.i()) {
                        composer2.P(function0A2);
                    } else {
                        composer2.v();
                    }
                    Composer composerA2 = Updater.a(composer2);
                    Updater.e(composerA2, measurePolicyB, companion3.e());
                    Updater.e(composerA2, compositionLocalMapU2, companion3.g());
                    Function2 function2B2 = companion3.b();
                    if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                        composerA2.w(Integer.valueOf(iA2));
                        composerA2.p(Integer.valueOf(iA2), function2B2);
                    }
                    Updater.e(composerA2, modifierF3, companion3.f());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                    Template5Kt.CheckmarkBox(z3, colors, composer2, 0);
                    String offerName = packageInfo2.getLocalization().getOfferName();
                    if (offerName == null) {
                        offerName = packageInfo2.getRcPackage().getProduct().getTitle();
                    }
                    MaterialTheme materialTheme = MaterialTheme.f18110a;
                    int i8 = MaterialTheme.f18111b;
                    TextStyle textStyleB = materialTheme.c(composer2, i8).b();
                    TextKt.c(offerName, rowScopeInstance.a(companion, 1.0f, true), j3, 0L, null, FontWeight.f29233b.h(), null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleB, composer2, 196608, 0, 65496);
                    Template5Kt.DiscountBanner(rowScopeInstance, legacy2, packageInfo2, composer2, 6);
                    composer2.y();
                    IntroEligibilityStateViewKt.m892IntroEligibilityStateViewQETHhvg(packageInfo2.getLocalization().getOfferDetails(), packageInfo2.getLocalization().getOfferDetailsWithIntroOffer(), packageInfo2.getLocalization().getOfferDetailsWithMultipleIntroOffers(), PackageExtensionsKt.getOfferEligibility(packageInfo2), j3, materialTheme.c(composer2, i8).c(), null, null, false, null, composer2, 100663296, 704);
                    composer2.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, 805306368, 292);
            composerK = composerK;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt.SelectPackageButton.4
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
                    Template5Kt.SelectPackageButton(columnScope, legacy, packageInfo, paywallViewModel, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void Template5(PaywallState.Loaded.Legacy state, PaywallViewModel viewModel, Composer composer, final int i3) {
        int i4;
        PaywallState.Loaded.Legacy legacy;
        final PaywallViewModel paywallViewModel;
        final PaywallState.Loaded.Legacy legacy2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer composerK = composer.k(1727742443);
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
            legacy2 = state;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1727742443, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template5 (Template5.kt:92)");
            }
            composerK.a0(-1567803066);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.valueOf(state.getTemplateConfiguration().getMode() != PaywallMode.FOOTER_CONDENSED), null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            composerK.U();
            Modifier.Companion companion2 = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion2);
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            if (WindowHelperKt.shouldUseLandscapeLayout(state, composerK, i4 & 14)) {
                composerK.a0(1533583235);
                int i5 = i4 << 3;
                Template5LandscapeContent(columnScopeInstance, state, viewModel, composerK, (i5 & 896) | 6 | (i5 & 112));
                composerK.U();
                legacy = state;
                paywallViewModel = viewModel;
            } else {
                composerK.a0(1533656364);
                int i6 = i4 << 3;
                Template5PortraitContent(columnScopeInstance, state, viewModel, Template5$lambda$1(mutableState), composerK, (i6 & 896) | 6 | (i6 & 112));
                legacy = state;
                paywallViewModel = viewModel;
                composerK = composerK;
                composerK.U();
            }
            int i7 = i4 & 112;
            PurchaseButtonKt.m923PurchaseButtonhGBTI10(legacy, paywallViewModel, null, 0.0f, null, composerK, i4 & 126, 28);
            legacy2 = legacy;
            TemplateConfiguration templateConfiguration = legacy2.getTemplateConfiguration();
            composerK.a0(188029008);
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt$Template5$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1215invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m1215invoke() {
                        Template5Kt.Template5$lambda$2(mutableState, !Template5Kt.Template5$lambda$1(r0));
                    }
                };
                composerK.w(objG2);
            }
            composerK.U();
            FooterKt.Footer(templateConfiguration, paywallViewModel, null, null, (Function0) objG2, composerK, i7 | 24576, 12);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt.Template5.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i8) {
                    Template5Kt.Template5(legacy2, paywallViewModel, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Template5$lambda$1(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template5$lambda$2(MutableState<Boolean> mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template5LandscapeContent(ColumnScope columnScope, final PaywallState.Loaded.Legacy legacy, final PaywallViewModel paywallViewModel, Composer composer, final int i3) {
        int i4;
        final ColumnScope columnScope2;
        Composer composerK = composer.k(1534776921);
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
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1534776921, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template5LandscapeContent (Template5.kt:175)");
            }
            ScrollState scrollStateC = ScrollKt.c(0, composerK, 0, 1);
            ScrollState scrollStateC2 = ScrollKt.c(0, composerK, 0, 1);
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
            Modifier modifierJ = PaddingKt.j(RowScope.c(rowScopeInstance, ScrollKt.g(companion2, scrollStateC, false, null, false, 14, null), 1.0f, false, 2, null), uIConstant.m690getDefaultHorizontalPaddingD9Ej5fM(), uIConstant.m693getDefaultVerticalSpacingD9Ej5fM());
            Alignment.Horizontal horizontalG = companion.g();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.q(uIConstant.m693getDefaultVerticalSpacingD9Ej5fM(), companion.i()), horizontalG, composerK, 48);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierJ);
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
            Title(columnScopeInstance, legacy, composerK, (i5 & 112) | 6);
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 0.5f, false, 2, null), composerK, 0);
            int i6 = i5 >> 3;
            Features(legacy, composerK, i6 & 14);
            composerK.y();
            Modifier modifierJ2 = PaddingKt.j(RowScope.c(rowScopeInstance, ScrollKt.g(companion2, scrollStateC2, false, null, false, 14, null), 1.0f, false, 2, null), uIConstant.m690getDefaultHorizontalPaddingD9Ej5fM(), uIConstant.m693getDefaultVerticalSpacingD9Ej5fM());
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.q(uIConstant.m693getDefaultVerticalSpacingD9Ej5fM(), companion.i()), companion.g(), composerK, 48);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierJ2);
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
            columnScope2 = columnScope;
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 0.5f, false, 2, null), composerK, 0);
            AnimatedPackages(legacy, paywallViewModel, false, composerK, i6 & 126, 4);
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 0.5f, false, 2, null), composerK, 0);
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt.Template5LandscapeContent.2
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
                    Template5Kt.Template5LandscapeContent(columnScope2, legacy, paywallViewModel, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template5PaywallFooterCondensedPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(1995671160);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1995671160, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template5PaywallFooterCondensedPreview (Template5.kt:547)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt.Template5PaywallFooterCondensedPreview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1216invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1216invoke();
                    return Unit.f139807a;
                }
            }).build(), new MockViewModel(PaywallMode.FOOTER_CONDENSED, TestData.INSTANCE.getTemplate5Offering(), null, false, false, 28, null), composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt.Template5PaywallFooterCondensedPreview.2
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
                    Template5Kt.Template5PaywallFooterCondensedPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template5PaywallFooterPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(2073587697);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(2073587697, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template5PaywallFooterPreview (Template5.kt:537)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt.Template5PaywallFooterPreview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1217invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1217invoke();
                    return Unit.f139807a;
                }
            }).build(), new MockViewModel(PaywallMode.FOOTER, TestData.INSTANCE.getTemplate5Offering(), null, false, false, 28, null), composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt.Template5PaywallFooterPreview.2
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
                    Template5Kt.Template5PaywallFooterPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template5PaywallPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(1911239734);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1911239734, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template5PaywallPreview (Template5.kt:527)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt.Template5PaywallPreview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1218invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1218invoke();
                    return Unit.f139807a;
                }
            }).build(), new MockViewModel(null, TestData.INSTANCE.getTemplate5Offering(), null, false, false, 29, null), composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt.Template5PaywallPreview.2
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
                    Template5Kt.Template5PaywallPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template5PortraitContent(final ColumnScope columnScope, final PaywallState.Loaded.Legacy legacy, final PaywallViewModel paywallViewModel, final boolean z2, Composer composer, final int i3) {
        int i4;
        boolean z3;
        int i5;
        int i6;
        Composer composerK = composer.k(2076791099);
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
        if ((i3 & 3072) == 0) {
            z3 = z2;
            i4 |= composerK.b(z3) ? 2048 : 1024;
        } else {
            z3 = z2;
        }
        int i7 = i4;
        if ((i7 & 1171) == 1170 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(2076791099, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template5PortraitContent (Template5.kt:120)");
            }
            Uri headerUri = legacy.getTemplateConfiguration().getImages().getHeaderUri();
            composerK.a0(812095237);
            if (PaywallStateKt.isInFullScreenMode(legacy)) {
                HeaderImage(headerUri, composerK, 0);
            }
            composerK.U();
            final ScrollState scrollStateC = ScrollKt.c(0, composerK, 0, 1);
            Modifier.Companion companion = Modifier.b8;
            boolean zIsInFullScreenMode = PaywallStateKt.isInFullScreenMode(legacy);
            composerK.a0(812101850);
            int i8 = i7 & 14;
            boolean Z = (i8 == 4) | composerK.Z(scrollStateC);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt$Template5PortraitContent$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Modifier invoke(Modifier conditional) {
                        Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                        return ColumnScope.b(columnScope, ScrollKt.g(Modifier.b8, scrollStateC, false, null, false, 14, null), 1.0f, false, 2, null);
                    }
                };
                composerK.w(objG);
            }
            composerK.U();
            Modifier modifierConditional = ModifierExtensionsKt.conditional(companion, zIsInFullScreenMode, (Function1) objG);
            UIConstant uIConstant = UIConstant.INSTANCE;
            Modifier modifierJ = PaddingKt.j(modifierConditional, uIConstant.m690getDefaultHorizontalPaddingD9Ej5fM(), uIConstant.m693getDefaultVerticalSpacingD9Ej5fM());
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.q(uIConstant.m693getDefaultVerticalSpacingD9Ej5fM(), companion2.i()), companion2.g(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierJ);
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            composerK.a0(-1562177448);
            if (PaywallStateKt.isInFullScreenMode(legacy)) {
                composerK.a0(-1562176230);
                if (headerUri == null) {
                    composerK.a0(-1562175040);
                    if (legacy.getShouldDisplayDismissButton()) {
                        i6 = 0;
                    } else {
                        i6 = 0;
                        InsetSpacersKt.StatusBarSpacer(composerK, 0);
                    }
                    composerK.U();
                    SpacerKt.a(SizeKt.i(companion, uIConstant.m694getIconButtonSizeD9Ej5fM()), composerK, i6);
                }
                composerK.U();
                Title(columnScopeInstance, legacy, composerK, (i7 & 112) | 6);
                i5 = i8;
                SpacerKt.a(ColumnScope.b(columnScopeInstance, companion, 1.0f, false, 2, null), composerK, 0);
                Features(legacy, composerK, (i7 >> 3) & 14);
                SpacerKt.a(ColumnScope.b(columnScopeInstance, companion, 1.0f, false, 2, null), composerK, 0);
            } else {
                i5 = i8;
            }
            composerK.U();
            AnimatedPackages(legacy, paywallViewModel, z3, composerK, (i7 >> 3) & 1022, 0);
            composerK.a0(-1562162191);
            if (PaywallStateKt.isInFullScreenMode(legacy)) {
                SpacerKt.a(ColumnScope.b(columnScopeInstance, companion, 1.0f, false, 2, null), composerK, 0);
            }
            composerK.U();
            composerK.y();
            AnimatedVisibilityKt.g(columnScope, z2, null, EnterExitTransitionKt.o(uIConstant.defaultAnimation(), 0.0f, 2, null), EnterExitTransitionKt.q(uIConstant.defaultAnimation(), 0.0f, 2, null), "Template5.packageSpacing", ComposableSingletons$Template5Kt.INSTANCE.m1172getLambda1$revenuecatui_defaultsBc8Release(), composerK, i5 | 1769472 | ((i7 >> 6) & 112), 2);
            composerK = composerK;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt.Template5PortraitContent.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i9) {
                    Template5Kt.Template5PortraitContent(columnScope, legacy, paywallViewModel, z2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Title(final ColumnScope columnScope, final PaywallState.Loaded.Legacy legacy, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(1309191016);
        if ((i3 & 48) == 0) {
            i4 = (composerK.Z(legacy) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 17) == 16 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1309191016, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Title (Template5.kt:242)");
            }
            composer2 = composerK;
            MarkdownKt.m901MarkdownDkhmgE0(PaywallStateKt.getSelectedLocalization(legacy).getTitle(), SizeKt.h(Modifier.b8, 0.0f, 1, null), legacy.getTemplateConfiguration().getCurrentColors(composerK, 0).m1093getText10d7_KjU(), MaterialTheme.f18110a.c(composerK, MaterialTheme.f18111b).i(), 0L, FontWeight.f29233b.b(), null, null, TextAlign.h(TextAlign.f29616b.f()), false, true, false, composer2, 196656, 54, 720);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt.Title.1
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
                    Template5Kt.Title(columnScope, legacy, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    private static final long getFeatureIcon(TemplateConfiguration.Colors colors) {
        return colors.m1085getAccent10d7_KjU();
    }

    private static final long getSelectedDiscountText(TemplateConfiguration.Colors colors) {
        return colors.m1094getText20d7_KjU();
    }

    private static final long getSelectedOutline(TemplateConfiguration.Colors colors) {
        return colors.m1086getAccent20d7_KjU();
    }

    private static final long getUnselectedDiscountText(TemplateConfiguration.Colors colors) {
        return colors.m1095getText30d7_KjU();
    }

    private static final long getUnselectedOutline(TemplateConfiguration.Colors colors) {
        return colors.m1087getAccent30d7_KjU();
    }
}
