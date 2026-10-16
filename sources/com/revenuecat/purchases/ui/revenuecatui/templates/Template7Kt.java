package com.revenuecat.purchases.ui.revenuecatui.templates;

import android.net.Uri;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
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
import androidx.compose.runtime.internal.ComposableLambda;
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
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
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
import com.revenuecat.purchases.ui.revenuecatui.composables.TierSwitcherKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallStateKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.ProcessedLocalizedConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.ui.revenuecatui.extensions.AnimationsKt;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PackageExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionFactoriesKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallLegacyComponentInteraction;
import com.revenuecat.purchases.ui.revenuecatui.helpers.WindowHelperKt;
import com.sun.jna.Function;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
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
public final class Template7Kt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void AnimatedPackages(final com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Legacy r25, final com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel r26, boolean r27, final java.util.List<com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.PackageInfo> r28, final com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.Colors r29, final com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.TierInfo r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instruction units count: 509
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.AnimatedPackages(com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Legacy, com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel, boolean, java.util.List, com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration$Colors, com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration$TierInfo, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CheckmarkBox(final boolean z2, final TemplateConfiguration.Colors colors, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1250968455);
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
                ComposerKt.U(1250968455, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.CheckmarkBox (Template7.kt:596)");
            }
            Modifier modifierD = BackgroundKt.d(ClipKt.a(SizeKt.v(Modifier.b8, Template7UIConstants.INSTANCE.m1227getCheckmarkSizeD9Ej5fM()), RoundedCornerShapeKt.g()), z2 ? colors.m1088getBackground0d7_KjU() : getUnselectedOutline(colors), null, 2, null);
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
            composerK.a0(1030338206);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.CheckmarkBox.2
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
                    Template7Kt.CheckmarkBox(z2, colors, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DiscountBanner(final RowScope rowScope, final PaywallState.Loaded.Legacy legacy, final TemplateConfiguration.PackageInfo packageInfo, final TemplateConfiguration.Colors colors, Composer composer, final int i3) {
        int i4;
        PaywallState.Loaded.Legacy legacy2;
        TemplateConfiguration.PackageInfo packageInfo2;
        TemplateConfiguration.Colors colors2;
        Composer composerK = composer.k(148348005);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(rowScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            legacy2 = legacy;
            i4 |= composerK.Z(legacy2) ? 32 : 16;
        } else {
            legacy2 = legacy;
        }
        if ((i3 & 384) == 0) {
            packageInfo2 = packageInfo;
            i4 |= composerK.Z(packageInfo2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            packageInfo2 = packageInfo;
        }
        if ((i3 & 3072) == 0) {
            colors2 = colors;
            i4 |= composerK.Z(colors2) ? 2048 : 1024;
        } else {
            colors2 = colors;
        }
        if ((i4 & 1171) != 1170 || !composerK.l()) {
            if (ComposerKt.M()) {
                ComposerKt.U(148348005, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.DiscountBanner (Template7.kt:617)");
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
                            final PaywallState.Loaded.Legacy legacy3 = legacy2;
                            final TemplateConfiguration.PackageInfo packageInfo3 = packageInfo2;
                            final TemplateConfiguration.Colors colors3 = colors2;
                            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.DiscountBanner.1
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
                                    Template7Kt.DiscountBanner(rowScope, legacy3, packageInfo3, colors3, composer2, RecomposeScopeImplKt.a(i3 | 1));
                                }
                            });
                            return;
                        }
                        return;
                    }
                    int i5 = (i4 >> 3) & 126;
                    long jM1156packageButtonColorAnimation9z6LAg8 = AnimationsKt.m1156packageButtonColorAnimation9z6LAg8(legacy, packageInfo, getSelectedOutline(colors), getUnselectedOutline(colors), composerK, i5);
                    long jM1156packageButtonColorAnimation9z6LAg82 = AnimationsKt.m1156packageButtonColorAnimation9z6LAg8(legacy, packageInfo, getSelectedDiscountText(colors), getUnselectedDiscountText(colors), composerK, i5);
                    Modifier.Companion companion = Modifier.b8;
                    Alignment.Companion companion2 = Alignment.f25072a;
                    Modifier modifierD = rowScope.d(companion, companion2.l());
                    UIConstant uIConstant = UIConstant.INSTANCE;
                    float fM690getDefaultHorizontalPaddingD9Ej5fM = uIConstant.m690getDefaultHorizontalPaddingD9Ej5fM();
                    Template7UIConstants template7UIConstants = Template7UIConstants.INSTANCE;
                    Modifier modifierC = OffsetKt.c(modifierD, Dp.g(fM690getDefaultHorizontalPaddingD9Ej5fM - template7UIConstants.m1228getDiscountPaddingD9Ej5fM()), Dp.g(Dp.g(-uIConstant.m693getDefaultVerticalSpacingD9Ej5fM()) + template7UIConstants.m1228getDiscountPaddingD9Ej5fM()));
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
                    composerK = composerK;
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
                scopeUpdateScopeN2.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt$DiscountBanner$text$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.f139807a;
                    }

                    public final void invoke(Composer composer2, int i6) {
                        Template7Kt.DiscountBanner(rowScope, legacy, packageInfo, colors, composer2, RecomposeScopeImplKt.a(i3 | 1));
                    }
                });
                return;
            }
            return;
        }
        composerK.Q();
        ScopeUpdateScope scopeUpdateScopeN3 = composerK.n();
        if (scopeUpdateScopeN3 != null) {
            scopeUpdateScopeN3.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.DiscountBanner.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i6) {
                    Template7Kt.DiscountBanner(rowScope, legacy, packageInfo, colors, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Feature(final PaywallData.LocalizedConfiguration.Feature feature, final TemplateConfiguration.Colors colors, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-840416555);
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
                ComposerKt.U(-840416555, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Feature (Template7.kt:416)");
            }
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Vertical verticalI = companion.i();
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierE = SemanticsModifierKt.e(SizeKt.h(companion2, 0.0f, 1, null), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Feature.1
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
            Modifier modifierV = SizeKt.v(companion2, Template7UIConstants.INSTANCE.m1229getFeatureIconSizeD9Ej5fM());
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
            composerK.a0(-928875799);
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
            composerK.a0(-928852937);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Feature.3
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
                    Template7Kt.Feature(feature, colors, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Features(final PaywallState.Loaded.Legacy legacy, final TemplateConfiguration.TierInfo tierInfo, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(571837189);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(legacy) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(tierInfo) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(571837189, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Features (Template7.kt:386)");
            }
            final TemplateConfiguration.Colors currentColorsForTier = legacy.getTemplateConfiguration().getCurrentColorsForTier(tierInfo, composerK, (i4 >> 3) & 14);
            AnimatedContentKt.b(selectedLocalizationForTier(tierInfo), null, null, null, "features portrait", null, ComposableLambdaKt.e(-1011395967, true, new Function4<AnimatedContentScope, ProcessedLocalizedConfiguration, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Features.1
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    invoke((AnimatedContentScope) obj, (ProcessedLocalizedConfiguration) obj2, (Composer) obj3, ((Number) obj4).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(AnimatedContentScope AnimatedContent, ProcessedLocalizedConfiguration it, Composer composer2, int i5) {
                    Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1011395967, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Features.<anonymous> (Template7.kt:395)");
                    }
                    Alignment.Companion companion = Alignment.f25072a;
                    Alignment.Horizontal horizontalG = companion.g();
                    Arrangement.Vertical verticalQ = Arrangement.f6574a.q(UIConstant.INSTANCE.m693getDefaultVerticalSpacingD9Ej5fM(), companion.i());
                    TemplateConfiguration.Colors colors = currentColorsForTier;
                    Modifier.Companion companion2 = Modifier.b8;
                    MeasurePolicy measurePolicyA = ColumnKt.a(verticalQ, horizontalG, composer2, 48);
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF = ComposedModifierKt.f(composer2, companion2);
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
                    Updater.e(composerA, modifierF, companion3.f());
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                    composer2.a0(965659384);
                    Iterator<T> it2 = it.getFeatures().iterator();
                    while (it2.hasNext()) {
                        Template7Kt.Feature((PaywallData.LocalizedConfiguration.Feature) it2.next(), colors, composer2, 0);
                    }
                    composer2.U();
                    composer2.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, 1597440, 46);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Features.2
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
                    Template7Kt.Features(legacy, tierInfo, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HeaderImage(final Uri uri, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(108999699);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(uri) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(108999699, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.HeaderImage (Template7.kt:346)");
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.HeaderImage.2
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
                    Template7Kt.HeaderImage(uri, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SelectPackageButton(final ColumnScope columnScope, final PaywallState.Loaded.Legacy legacy, final TemplateConfiguration.PackageInfo packageInfo, PaywallViewModel paywallViewModel, final TemplateConfiguration.Colors colors, final TemplateConfiguration.TierInfo tierInfo, Composer composer, final int i3) {
        int i4;
        final PaywallViewModel paywallViewModel2;
        Composer composerK = composer.k(-833673358);
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
        if ((i3 & 24576) == 0) {
            i4 |= composerK.Z(colors) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.Z(tierInfo) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((74899 & i4) == 74898 && composerK.l()) {
            composerK.Q();
            paywallViewModel2 = paywallViewModel;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-833673358, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.SelectPackageButton (Template7.kt:521)");
            }
            final boolean zAreEqual = Intrinsics.areEqual(packageInfo, legacy.getSelectedPackage().getValue());
            float fPackageButtonActionInProgressOpacityAnimation = AnimationsKt.packageButtonActionInProgressOpacityAnimation(paywallViewModel, composerK, (i4 >> 9) & 14);
            final long jM1093getText10d7_KjU = colors.m1093getText10d7_KjU();
            int i5 = i4;
            long jM1156packageButtonColorAnimation9z6LAg8 = AnimationsKt.m1156packageButtonColorAnimation9z6LAg8(legacy, packageInfo, getSelectedOutline(colors), getUnselectedOutline(colors), composerK, (i5 >> 3) & 126);
            Modifier modifierC = columnScope.c(AlphaKt.a(SizeKt.h(Modifier.b8, 0.0f, 1, null), fPackageButtonActionInProgressOpacityAnimation), Alignment.f25072a.k());
            composerK.a0(1056086291);
            boolean zB = composerK.b(zAreEqual);
            Object objG = composerK.G();
            if (zB || objG == Composer.f23746a.a()) {
                objG = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt$SelectPackageButton$1$1
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
            composerK.a0(1056088853);
            boolean z2 = ((i5 & 7168) == 2048) | ((i5 & 112) == 32) | ((i5 & 896) == 256) | ((458752 & i5) == 131072);
            Object objG2 = composerK.G();
            if (z2 || objG2 == Composer.f23746a.a()) {
                paywallViewModel2 = paywallViewModel;
                objG2 = new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt$SelectPackageButton$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1222invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m1222invoke() {
                        TemplatePackageRowInteractionKt.trackTemplatePackageRowSelectionIfChanged(paywallViewModel2, legacy, packageInfo, tierInfo.getDefaultPackage());
                        paywallViewModel2.selectPackage(packageInfo);
                    }
                };
                composerK.w(objG2);
            } else {
                paywallViewModel2 = paywallViewModel;
            }
            composerK.U();
            ComposableLambda composableLambdaE = ComposableLambdaKt.e(-1813526686, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.SelectPackageButton.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(RowScope Button, Composer composer2, int i6) {
                    Intrinsics.checkNotNullParameter(Button, "$this$Button");
                    if ((i6 & 17) == 16 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1813526686, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.SelectPackageButton.<anonymous> (Template7.kt:559)");
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
                    TemplateConfiguration.Colors colors2 = colors;
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
                    Template7Kt.CheckmarkBox(z3, colors2, composer2, 0);
                    String offerName = packageInfo2.getLocalization().getOfferName();
                    if (offerName == null) {
                        offerName = packageInfo2.getRcPackage().getProduct().getTitle();
                    }
                    MaterialTheme materialTheme = MaterialTheme.f18110a;
                    int i7 = MaterialTheme.f18111b;
                    TextStyle textStyleB = materialTheme.c(composer2, i7).b();
                    TextKt.c(offerName, rowScopeInstance.a(companion, 1.0f, true), j3, 0L, null, FontWeight.f29233b.h(), null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleB, composer2, 196608, 0, 65496);
                    Template7Kt.DiscountBanner(rowScopeInstance, legacy2, packageInfo2, colors2, composer2, 6);
                    composer2.y();
                    IntroEligibilityStateViewKt.m892IntroEligibilityStateViewQETHhvg(packageInfo2.getLocalization().getOfferDetails(), packageInfo2.getLocalization().getOfferDetailsWithIntroOffer(), packageInfo2.getLocalization().getOfferDetailsWithMultipleIntroOffers(), PackageExtensionsKt.getOfferEligibility(packageInfo2), j3, materialTheme.c(composer2, i7).c(), null, null, false, null, composer2, 100663296, 704);
                    composer2.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54);
            composerK = composerK;
            ButtonKt.a((Function0) objG2, modifierF, false, roundedCornerShapeD, buttonColorsB, null, borderStrokeA, paddingValuesB, null, composableLambdaE, composerK, 805306368, 292);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final PaywallViewModel paywallViewModel3 = paywallViewModel2;
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.SelectPackageButton.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i6) {
                    Template7Kt.SelectPackageButton(columnScope, legacy, packageInfo, paywallViewModel3, colors, tierInfo, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void Template7(final PaywallState.Loaded.Legacy state, PaywallViewModel paywallViewModel, Composer composer, final int i3) {
        int i4;
        final PaywallState.Loaded.Legacy legacy;
        final PaywallViewModel viewModel = paywallViewModel;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer composerK = composer.k(-305592021);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(state) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(viewModel) ? 32 : 16;
        }
        int i5 = i4;
        if ((i5 & 19) == 18 && composerK.l()) {
            composerK.Q();
            legacy = state;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-305592021, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template7 (Template7.kt:106)");
            }
            TemplateConfiguration.PackageConfiguration packages = state.getTemplateConfiguration().getPackages();
            if (!(packages instanceof TemplateConfiguration.PackageConfiguration.MultiTier)) {
                throw new IllegalArgumentException("The configuration is not MultiTier");
            }
            TemplateConfiguration.PackageConfiguration.MultiTier multiTier = (TemplateConfiguration.PackageConfiguration.MultiTier) packages;
            TemplateConfiguration.TierInfo defaultTier = multiTier.getDefaultTier();
            List<TemplateConfiguration.TierInfo> allTiers = multiTier.getAllTiers();
            composerK.a0(-1567765976);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.valueOf(state.getTemplateConfiguration().getMode() != PaywallMode.FOOTER_CONDENSED), null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            composerK.U();
            composerK.a0(-1567761839);
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(defaultTier, null, 2, null);
                composerK.w(objG2);
            }
            final MutableState mutableState2 = (MutableState) objG2;
            composerK.U();
            TemplateConfiguration.Colors currentColorsForTier = state.getTemplateConfiguration().getCurrentColorsForTier(Template7$lambda$6(mutableState2), composerK, 0);
            composerK.a0(-1567754477);
            int i6 = i5 & 112;
            int i7 = i5 & 14;
            boolean z2 = (i6 == 32) | (i7 == 4);
            Object objG3 = composerK.G();
            if (z2 || objG3 == companion.a()) {
                objG3 = new Function1<TemplateConfiguration.TierInfo, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt$Template7$onTierSelected$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((TemplateConfiguration.TierInfo) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(TemplateConfiguration.TierInfo tier) {
                        Intrinsics.checkNotNullParameter(tier, "tier");
                        viewModel.trackComponentInteraction(PaywallComponentInteractionFactoriesKt.paywallTierSelection(Template7Kt.tierSelectorComponentInteractionValue(tier), PaywallLegacyComponentInteraction.TIER_SELECTOR_NAME, ((TemplateConfiguration.PackageInfo) state.getSelectedPackage().getValue()).getRcPackage(), tier.getDefaultPackage().getRcPackage()));
                        mutableState2.setValue(tier);
                        state.selectPackage(tier.getDefaultPackage());
                    }
                };
                composerK.w(objG3);
            }
            Function1 function1 = (Function1) objG3;
            composerK.U();
            Modifier modifierD = BackgroundKt.d(Modifier.b8, currentColorsForTier.m1088getBackground0d7_KjU(), null, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
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
            if (WindowHelperKt.shouldUseLandscapeLayout(state, composerK, i7)) {
                composerK.a0(514405850);
                int i8 = i5 << 3;
                Template7LandscapeContent(columnScopeInstance, state, paywallViewModel, allTiers, Template7$lambda$6(mutableState2), function1, composerK, 6 | (i8 & 112) | (i8 & 896));
                composerK = composerK;
                composerK.U();
            } else {
                composerK.a0(514613395);
                int i9 = i5 << 3;
                Template7PortraitContent(columnScopeInstance, state, paywallViewModel, Template7$lambda$3(mutableState), allTiers, Template7$lambda$6(mutableState2), function1, composerK, 6 | (i9 & 112) | (i9 & 896));
                composerK = composerK;
                composerK.U();
            }
            PurchaseButtonKt.m923PurchaseButtonhGBTI10(state, paywallViewModel, null, 0.0f, currentColorsForTier, composerK, i5 & 126, 12);
            legacy = state;
            TemplateConfiguration templateConfiguration = legacy.getTemplateConfiguration();
            composerK.a0(-1091762798);
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt$Template7$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1223invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m1223invoke() {
                        Template7Kt.Template7$lambda$4(mutableState, !Template7Kt.Template7$lambda$3(r0));
                    }
                };
                composerK.w(objG4);
            }
            composerK.U();
            FooterKt.Footer(templateConfiguration, paywallViewModel, null, currentColorsForTier, (Function0) objG4, composerK, i6 | 24576, 4);
            viewModel = paywallViewModel;
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Template7.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i10) {
                    Template7Kt.Template7(legacy, viewModel, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Template7$lambda$3(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template7$lambda$4(MutableState<Boolean> mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    private static final TemplateConfiguration.TierInfo Template7$lambda$6(MutableState<TemplateConfiguration.TierInfo> mutableState) {
        return (TemplateConfiguration.TierInfo) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template7LandscapeContent(final ColumnScope columnScope, final PaywallState.Loaded.Legacy legacy, final PaywallViewModel paywallViewModel, final List<TemplateConfiguration.TierInfo> list, final TemplateConfiguration.TierInfo tierInfo, final Function1<? super TemplateConfiguration.TierInfo, Unit> function1, Composer composer, final int i3) {
        int i4;
        int i5;
        Composer composerK = composer.k(2027062712);
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
            i4 |= composerK.I(list) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.Z(tierInfo) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(function1) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((74899 & i4) == 74898 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(2027062712, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template7LandscapeContent (Template7.kt:269)");
            }
            ScrollState scrollStateC = ScrollKt.c(0, composerK, 0, 1);
            ScrollState scrollStateC2 = ScrollKt.c(0, composerK, 0, 1);
            TemplateConfiguration.Colors currentColorsForTier = legacy.getTemplateConfiguration().getCurrentColorsForTier(tierInfo, composerK, (i4 >> 12) & 14);
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
            int i6 = i4;
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
            Title(columnScopeInstance, legacy, tierInfo, composerK, (i6 & 112) | 6 | ((i6 >> 6) & 896));
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 0.5f, false, 2, null), composerK, 0);
            int i7 = i6 >> 3;
            int i8 = i6 >> 9;
            Features(legacy, tierInfo, composerK, (i7 & 14) | (i8 & 112));
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
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 0.5f, false, 2, null), composerK, 0);
            composerK.a0(392941851);
            if (list.size() > 1) {
                composerK.a0(392946785);
                boolean z2 = (i6 & 458752) == 131072;
                Object objG = composerK.G();
                if (z2 || objG == Composer.f23746a.a()) {
                    objG = new Function1<TemplateConfiguration.TierInfo, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt$Template7LandscapeContent$1$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((TemplateConfiguration.TierInfo) obj);
                            return Unit.f139807a;
                        }

                        public final void invoke(TemplateConfiguration.TierInfo it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            function1.invoke(it);
                        }
                    };
                    composerK.w(objG);
                }
                composerK.U();
                i5 = 0;
                TierSwitcherKt.m941TierSwitcherUFBoNtE(list, tierInfo, (Function1) objG, getTierSwitcherBackground(currentColorsForTier), getTierSwitcherBackgroundSelected(currentColorsForTier), getTierSwitcherForeground(currentColorsForTier), getTierSwitcherForegroundSelected(currentColorsForTier), composerK, i8 & 126);
                SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 0.5f, false, 2, null), composerK, 0);
            } else {
                i5 = 0;
            }
            composerK.U();
            AnimatedPackages(legacy, paywallViewModel, false, tierInfo.getPackages(), currentColorsForTier, tierInfo, composerK, (i7 & 126) | ((i6 << 3) & 458752), 4);
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 0.5f, false, 2, null), composerK, i5);
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Template7LandscapeContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i9) {
                    Template7Kt.Template7LandscapeContent(columnScope, legacy, paywallViewModel, list, tierInfo, function1, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template7PaywallFooterCondensedPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(957146168);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(957146168, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template7PaywallFooterCondensedPreview (Template7.kt:719)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Template7PaywallFooterCondensedPreview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1224invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1224invoke();
                    return Unit.f139807a;
                }
            }).build(), new MockViewModel(PaywallMode.FOOTER_CONDENSED, TestData.INSTANCE.getTemplate7Offering(), null, false, false, 28, null), composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Template7PaywallFooterCondensedPreview.2
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
                    Template7Kt.Template7PaywallFooterCondensedPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template7PaywallFooterPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(-323823251);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-323823251, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template7PaywallFooterPreview (Template7.kt:708)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Template7PaywallFooterPreview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1225invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1225invoke();
                    return Unit.f139807a;
                }
            }).build(), new MockViewModel(PaywallMode.FOOTER, TestData.INSTANCE.getTemplate7Offering(), null, false, false, 28, null), composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Template7PaywallFooterPreview.2
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
                    Template7Kt.Template7PaywallFooterPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template7PaywallPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(292324402);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(292324402, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template7PaywallPreview (Template7.kt:697)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Template7PaywallPreview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1226invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1226invoke();
                    return Unit.f139807a;
                }
            }).build(), new MockViewModel(null, TestData.INSTANCE.getTemplate7Offering(), null, false, false, 29, null), composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Template7PaywallPreview.2
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
                    Template7Kt.Template7PaywallPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template7PortraitContent(final ColumnScope columnScope, final PaywallState.Loaded.Legacy legacy, final PaywallViewModel paywallViewModel, final boolean z2, final List<TemplateConfiguration.TierInfo> list, final TemplateConfiguration.TierInfo tierInfo, final Function1<? super TemplateConfiguration.TierInfo, Unit> function1, Composer composer, final int i3) {
        int i4;
        List<TemplateConfiguration.TierInfo> list2;
        int i5;
        ColumnScopeInstance columnScopeInstance;
        int i6;
        int i7;
        Modifier.Companion companion;
        int i8;
        Object obj;
        TemplateConfiguration.TierInfo tierInfo2 = tierInfo;
        Composer composerK = composer.k(1979964246);
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
            i4 |= composerK.b(z2) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            list2 = list;
            i4 |= composerK.I(list2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            list2 = list;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.Z(tierInfo2) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.I(function1) ? 1048576 : 524288;
        }
        if ((599187 & i4) == 599186 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1979964246, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template7PortraitContent (Template7.kt:181)");
            }
            TemplateConfiguration.Images images = legacy.getTemplateConfiguration().getImagesByTier().get(tierInfo2.getId());
            Uri headerUri = images != null ? images.getHeaderUri() : null;
            composerK.a0(-1181970856);
            if (PaywallStateKt.isInFullScreenMode(legacy) && headerUri != null) {
                HeaderImage(headerUri, composerK, 0);
            }
            composerK.U();
            int i9 = (i4 >> 15) & 14;
            TemplateConfiguration.Colors currentColorsForTier = legacy.getTemplateConfiguration().getCurrentColorsForTier(tierInfo2, composerK, i9);
            final ScrollState scrollStateC = ScrollKt.c(0, composerK, 0, 1);
            Modifier.Companion companion2 = Modifier.b8;
            boolean zIsInFullScreenMode = PaywallStateKt.isInFullScreenMode(legacy);
            composerK.a0(-1181960488);
            int i10 = i4 & 14;
            boolean Z = (i10 == 4) | composerK.Z(scrollStateC);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt$Template7PortraitContent$1$1
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
            Modifier modifierConditional = ModifierExtensionsKt.conditional(companion2, zIsInFullScreenMode, (Function1) objG);
            UIConstant uIConstant = UIConstant.INSTANCE;
            Modifier modifierJ = PaddingKt.j(modifierConditional, uIConstant.m690getDefaultHorizontalPaddingD9Ej5fM(), uIConstant.m693getDefaultVerticalSpacingD9Ej5fM());
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.q(uIConstant.m693getDefaultVerticalSpacingD9Ej5fM(), companion3.i()), companion3.g(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierJ);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Uri uri = headerUri;
            Function0 function0A = companion4.a();
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
            int i11 = i4;
            Updater.e(composerA, measurePolicyA, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.f6666a;
            composerK.a0(-1539462923);
            if (PaywallStateKt.isInFullScreenMode(legacy)) {
                composerK.a0(-1539461608);
                if (uri == null) {
                    composerK.a0(-1539460418);
                    i5 = 0;
                    if (!legacy.getShouldDisplayDismissButton()) {
                        InsetSpacersKt.StatusBarSpacer(composerK, 0);
                    }
                    composerK.U();
                    SpacerKt.a(SizeKt.i(companion2, uIConstant.m694getIconButtonSizeD9Ej5fM()), composerK, 0);
                } else {
                    i5 = 0;
                }
                composerK.U();
                Title(columnScopeInstance2, legacy, tierInfo2, composerK, 6 | (i11 & 112) | ((i11 >> 9) & 896));
            } else {
                i5 = 0;
            }
            composerK.U();
            composerK.a0(-1539451997);
            if (list2.size() <= 1) {
                columnScopeInstance = columnScopeInstance2;
                i6 = i5;
                i7 = i10;
                companion = companion2;
                i8 = i11;
                obj = null;
            } else if (z2) {
                composerK.a0(-478320840);
                composerK.a0(-1539445980);
                int i12 = (i11 & 3670016) != 1048576 ? i5 : 1;
                Object objG2 = composerK.G();
                if (i12 != 0 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function1<TemplateConfiguration.TierInfo, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt$Template7PortraitContent$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            invoke((TemplateConfiguration.TierInfo) obj2);
                            return Unit.f139807a;
                        }

                        public final void invoke(TemplateConfiguration.TierInfo it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            function1.invoke(it);
                        }
                    };
                    composerK.w(objG2);
                }
                composerK.U();
                companion = companion2;
                i7 = i10;
                i8 = i11;
                columnScopeInstance = columnScopeInstance2;
                i6 = i5;
                obj = null;
                TierSwitcherKt.m941TierSwitcherUFBoNtE(list, tierInfo2, (Function1) objG2, getTierSwitcherBackground(currentColorsForTier), getTierSwitcherBackgroundSelected(currentColorsForTier), getTierSwitcherForeground(currentColorsForTier), getTierSwitcherForegroundSelected(currentColorsForTier), composerK, (i11 >> 12) & 126);
                composerK = composerK;
                composerK.U();
                tierInfo2 = tierInfo;
            } else {
                columnScopeInstance = columnScopeInstance2;
                i6 = i5;
                i7 = i10;
                companion = companion2;
                i8 = i11;
                obj = null;
                composerK.a0(-477740582);
                TierSwitcherKt.m940SelectedTierView1wkBAMs(tierInfo, getTierSwitcherBackgroundSelected(currentColorsForTier), getTierSwitcherForegroundSelected(currentColorsForTier), composerK, i9);
                tierInfo2 = tierInfo;
                composerK = composerK;
                composerK.U();
            }
            composerK.U();
            composerK.a0(-1539421679);
            if (PaywallStateKt.isInFullScreenMode(legacy)) {
                Features(legacy, tierInfo2, composerK, ((i8 >> 3) & 14) | ((i8 >> 12) & 112));
            }
            composerK.U();
            Object obj2 = obj;
            AnimatedPackages(legacy, paywallViewModel, z2, tierInfo2.getPackages(), currentColorsForTier, tierInfo2, composerK, (i8 & 458752) | ((i8 >> 3) & 1022), 0);
            composerK.a0(-1539409617);
            if (PaywallStateKt.isInFullScreenMode(legacy)) {
                SpacerKt.a(ColumnScope.b(columnScopeInstance, companion, 1.0f, false, 2, null), composerK, i6);
            }
            composerK.U();
            composerK.y();
            AnimatedVisibilityKt.g(columnScope, z2, null, EnterExitTransitionKt.o(uIConstant.defaultAnimation(), 0.0f, 2, obj2), EnterExitTransitionKt.q(uIConstant.defaultAnimation(), 0.0f, 2, obj2), "Template7.packageSpacing", ComposableSingletons$Template7Kt.INSTANCE.m1173getLambda1$revenuecatui_defaultsBc8Release(), composerK, i7 | 1769472 | ((i8 >> 6) & 112), 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Template7PortraitContent.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4) {
                    invoke((Composer) obj3, ((Number) obj4).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i13) {
                    Template7Kt.Template7PortraitContent(columnScope, legacy, paywallViewModel, z2, list, tierInfo, function1, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Title(final ColumnScope columnScope, final PaywallState.Loaded.Legacy legacy, final TemplateConfiguration.TierInfo tierInfo, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-1395216940);
        if ((i3 & 48) == 0) {
            i4 = (composerK.Z(legacy) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(tierInfo) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 145) == 144 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1395216940, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Title (Template7.kt:361)");
            }
            TemplateConfiguration.Colors currentColorsForTier = legacy.getTemplateConfiguration().getCurrentColorsForTier(tierInfo, composerK, (i4 >> 6) & 14);
            ProcessedLocalizedConfiguration processedLocalizedConfigurationSelectedLocalizationForTier = selectedLocalizationForTier(tierInfo);
            composer2 = composerK;
            MarkdownKt.m901MarkdownDkhmgE0(processedLocalizedConfigurationSelectedLocalizationForTier.getTitle(), SizeKt.h(Modifier.b8, 0.0f, 1, null), currentColorsForTier.m1093getText10d7_KjU(), MaterialTheme.f18110a.c(composerK, MaterialTheme.f18111b).i(), 0L, FontWeight.f29233b.b(), null, null, TextAlign.h(TextAlign.f29616b.a()), false, true, false, composer2, 196656, 54, 720);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Title.1
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
                    Template7Kt.Title(columnScope, legacy, tierInfo, composer3, RecomposeScopeImplKt.a(i3 | 1));
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

    private static final long getTierSwitcherBackground(TemplateConfiguration.Colors colors) {
        Color colorM1096getTierControlBackgroundQN2ZGVo = colors.m1096getTierControlBackgroundQN2ZGVo();
        return colorM1096getTierControlBackgroundQN2ZGVo != null ? colorM1096getTierControlBackgroundQN2ZGVo.B() : colors.m1085getAccent10d7_KjU();
    }

    private static final long getTierSwitcherBackgroundSelected(TemplateConfiguration.Colors colors) {
        Color colorM1098getTierControlSelectedBackgroundQN2ZGVo = colors.m1098getTierControlSelectedBackgroundQN2ZGVo();
        return colorM1098getTierControlSelectedBackgroundQN2ZGVo != null ? colorM1098getTierControlSelectedBackgroundQN2ZGVo.B() : getUnselectedDiscountText(colors);
    }

    private static final long getTierSwitcherForeground(TemplateConfiguration.Colors colors) {
        Color colorM1097getTierControlForegroundQN2ZGVo = colors.m1097getTierControlForegroundQN2ZGVo();
        return colorM1097getTierControlForegroundQN2ZGVo != null ? colorM1097getTierControlForegroundQN2ZGVo.B() : colors.m1093getText10d7_KjU();
    }

    private static final long getTierSwitcherForegroundSelected(TemplateConfiguration.Colors colors) {
        Color colorM1099getTierControlSelectedForegroundQN2ZGVo = colors.m1099getTierControlSelectedForegroundQN2ZGVo();
        return colorM1099getTierControlSelectedForegroundQN2ZGVo != null ? colorM1099getTierControlSelectedForegroundQN2ZGVo.B() : colors.m1093getText10d7_KjU();
    }

    private static final long getUnselectedDiscountText(TemplateConfiguration.Colors colors) {
        return colors.m1095getText30d7_KjU();
    }

    private static final long getUnselectedOutline(TemplateConfiguration.Colors colors) {
        return colors.m1087getAccent30d7_KjU();
    }

    private static final ProcessedLocalizedConfiguration selectedLocalizationForTier(TemplateConfiguration.TierInfo tierInfo) {
        return tierInfo.getDefaultPackage().getLocalization();
    }

    public static final /* synthetic */ String tierSelectorComponentInteractionValue(TemplateConfiguration.TierInfo tier) {
        Intrinsics.checkNotNullParameter(tier, "tier");
        String name = tier.getName();
        if (StringsKt.p0(name)) {
            name = null;
        }
        return name == null ? tier.getId() : name;
    }
}
