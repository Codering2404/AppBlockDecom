package com.revenuecat.purchases.ui.revenuecatui.templates;

import android.net.Uri;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt;
import com.revenuecat.purchases.ui.revenuecatui.PaywallMode;
import com.revenuecat.purchases.ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.ui.revenuecatui.UIConstant;
import com.revenuecat.purchases.ui.revenuecatui.composables.IconImageKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityStateViewKt;
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
import com.revenuecat.purchases.ui.revenuecatui.extensions.AnimationsKt;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PackageExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.TestTag;
import com.sun.jna.Function;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
public final class Template2Kt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void AnimatedPackages(final PaywallState.Loaded.Legacy legacy, final boolean z2, final boolean z3, final PaywallViewModel paywallViewModel, final Modifier modifier, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1799464452);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(legacy) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(paywallViewModel) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.Z(modifier) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((i4 & 9363) == 9362 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1799464452, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.AnimatedPackages (Template2.kt:301)");
            }
            Alignment alignmentO = PaywallStateKt.isInFullScreenMode(legacy) ? Alignment.f25072a.o() : Alignment.f25072a.b();
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyG = BoxKt.g(alignmentO, false);
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
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            AnimatedVisibilityKt.j(!z2, null, EnterExitTransitionKt.o(AnimationSpecKt.n(0, 200, null, 5, null), 0.0f, 2, null), EnterExitTransitionKt.q(AnimationSpecKt.n(0, 200, null, 5, null), 0.0f, 2, null), "OfferDetailsVisibility", ComposableLambdaKt.e(4658274, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt$AnimatedPackages$1$1
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int i5) {
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    if (ComposerKt.M()) {
                        ComposerKt.U(4658274, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.AnimatedPackages.<anonymous>.<anonymous> (Template2.kt:314)");
                    }
                    OfferDetailsKt.OfferDetails(legacy, null, composer2, 0, 2);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, 224640, 2);
            Alignment.Companion companion3 = Alignment.f25072a;
            AnimatedVisibilityKt.j(z2, null, EnterExitTransitionKt.m(null, companion3.a(), false, null, 13, null), EnterExitTransitionKt.A(null, companion3.a(), false, null, 13, null), "SelectPackagesVisibility", ComposableLambdaKt.e(1995133977, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt$AnimatedPackages$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int i5) {
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    if (ComposerKt.M()) {
                        ComposerKt.U(1995133977, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.AnimatedPackages.<anonymous>.<anonymous> (Template2.kt:323)");
                    }
                    Arrangement arrangement = Arrangement.f6574a;
                    float fG = z3 ? Dp.g(UIConstant.INSTANCE.m693getDefaultVerticalSpacingD9Ej5fM() / 2.0f) : UIConstant.INSTANCE.m693getDefaultVerticalSpacingD9Ej5fM();
                    Alignment.Companion companion4 = Alignment.f25072a;
                    Arrangement.Vertical verticalQ = arrangement.q(fG, companion4.i());
                    PaywallState.Loaded.Legacy legacy2 = legacy;
                    PaywallViewModel paywallViewModel2 = paywallViewModel;
                    Modifier modifier2 = modifier;
                    Modifier.Companion companion5 = Modifier.b8;
                    MeasurePolicy measurePolicyA = ColumnKt.a(verticalQ, companion4.k(), composer2, 0);
                    int iA2 = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU2 = composer2.u();
                    Modifier modifierF2 = ComposedModifierKt.f(composer2, companion5);
                    ComposeUiNode.Companion companion6 = ComposeUiNode.f8;
                    Function0 function0A2 = companion6.a();
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
                    Updater.e(composerA2, measurePolicyA, companion6.e());
                    Updater.e(composerA2, compositionLocalMapU2, companion6.g());
                    Function2 function2B2 = companion6.b();
                    if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                        composerA2.w(Integer.valueOf(iA2));
                        composerA2.p(Integer.valueOf(iA2), function2B2);
                    }
                    Updater.e(composerA2, modifierF2, companion6.f());
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                    composer2.a0(1488168427);
                    Iterator<T> it = legacy2.getTemplateConfiguration().getPackages().getAll().iterator();
                    while (it.hasNext()) {
                        Template2Kt.SelectPackageButton(columnScopeInstance, legacy2, (TemplateConfiguration.PackageInfo) it.next(), paywallViewModel2, modifier2, composer2, 6);
                    }
                    composer2.U();
                    composer2.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, ((i4 >> 3) & 14) | 224640, 2);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.AnimatedPackages.2
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
                    Template2Kt.AnimatedPackages(legacy, z2, z3, paywallViewModel, modifier, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CheckmarkBox(final boolean z2, final TemplateConfiguration.Colors colors, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1250819500);
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
                ComposerKt.U(1250819500, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.CheckmarkBox (Template2.kt:422)");
            }
            Modifier modifierD = BackgroundKt.d(ClipKt.a(SizeKt.v(Modifier.b8, Template2UIConstants.INSTANCE.m1187getCheckmarkSizeD9Ej5fM()), RoundedCornerShapeKt.g()), Color.r(colors.m1086getAccent20d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
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
            composerK.a0(1030128935);
            if (z2) {
                PaywallIconKt.m914PaywallIconFNF3uiM(PaywallIconName.CHECK_CIRCLE, null, colors.m1085getAccent10d7_KjU(), composerK, 6, 2);
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.CheckmarkBox.2
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
                    Template2Kt.CheckmarkBox(z2, colors, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void IconImage(final PaywallState.Loaded.Legacy legacy, Modifier modifier, Composer composer, final int i3) {
        int i4;
        final Modifier modifier2;
        Composer composerK = composer.k(-951232294);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(legacy) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(modifier) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
            modifier2 = modifier;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-951232294, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.IconImage (Template2.kt:249)");
            }
            Uri iconUri = legacy.getTemplateConfiguration().getImages().getIconUri();
            Template2UIConstants template2UIConstants = Template2UIConstants.INSTANCE;
            modifier2 = modifier;
            IconImageKt.m891IconImagedjqsMU(iconUri, template2UIConstants.m1189getMaxIconWidthD9Ej5fM(), template2UIConstants.m1188getIconCornerRadiusD9Ej5fM(), modifier2, composerK, ((i4 << 6) & 7168) | 432, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.IconImage.1
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
                    Template2Kt.IconImage(legacy, modifier2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SelectPackageButton(final ColumnScope columnScope, final PaywallState.Loaded.Legacy legacy, final TemplateConfiguration.PackageInfo packageInfo, final PaywallViewModel paywallViewModel, final Modifier modifier, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1238280660);
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
            i4 |= composerK.Z(modifier) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        int i5 = i4;
        if ((i5 & 9363) == 9362 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1238280660, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.SelectPackageButton (Template2.kt:348)");
            }
            TemplateConfiguration.Colors currentColors = legacy.getTemplateConfiguration().getCurrentColors(composerK, 0);
            final boolean zAreEqual = Intrinsics.areEqual(packageInfo, legacy.getSelectedPackage().getValue());
            float fPackageButtonActionInProgressOpacityAnimation = AnimationsKt.packageButtonActionInProgressOpacityAnimation(paywallViewModel, composerK, (i5 >> 9) & 14);
            int i6 = (i5 >> 3) & 126;
            long jM1156packageButtonColorAnimation9z6LAg8 = AnimationsKt.m1156packageButtonColorAnimation9z6LAg8(legacy, packageInfo, currentColors.m1086getAccent20d7_KjU(), currentColors.m1088getBackground0d7_KjU(), composerK, i6);
            final long jM1156packageButtonColorAnimation9z6LAg82 = AnimationsKt.m1156packageButtonColorAnimation9z6LAg8(legacy, packageInfo, currentColors.m1085getAccent10d7_KjU(), currentColors.m1093getText10d7_KjU(), composerK, i6);
            BorderStroke borderStrokeA = zAreEqual ? null : BorderStrokeKt.a(UIConstant.INSTANCE.m691getDefaultPackageBorderWidthD9Ej5fM(), Color.r(currentColors.m1093getText10d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null));
            Modifier modifierC = columnScope.c(AlphaKt.a(SizeKt.h(modifier, 0.0f, 1, null), fPackageButtonActionInProgressOpacityAnimation), Alignment.f25072a.k());
            composerK.a0(1055888883);
            boolean zB = composerK.b(zAreEqual);
            Object objG = composerK.G();
            if (zB || objG == Composer.f23746a.a()) {
                objG = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt$SelectPackageButton$1$1
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
            Modifier modifierA = TestTagKt.a(SemanticsModifierKt.f(modifierC, false, (Function1) objG, 1, null), TestTag.INSTANCE.selectButtonTestTag(packageInfo.getRcPackage().getIdentifier()));
            ButtonColors buttonColorsB = ButtonDefaults.f16077a.b(jM1156packageButtonColorAnimation9z6LAg8, jM1156packageButtonColorAnimation9z6LAg82, 0L, 0L, composerK, ButtonDefaults.f16091o << 12, 12);
            UIConstant uIConstant = UIConstant.INSTANCE;
            RoundedCornerShape roundedCornerShapeD = RoundedCornerShapeKt.d(uIConstant.m692getDefaultPackageCornerRadiusD9Ej5fM());
            PaddingValues paddingValuesB = PaddingKt.b(uIConstant.m690getDefaultHorizontalPaddingD9Ej5fM(), uIConstant.m693getDefaultVerticalSpacingD9Ej5fM());
            composerK.a0(1055893998);
            boolean z2 = ((i5 & 7168) == 2048) | ((i5 & 112) == 32) | ((i5 & 896) == 256);
            Object objG2 = composerK.G();
            if (z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt$SelectPackageButton$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1182invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m1182invoke() {
                        TemplatePackageRowInteractionKt.trackTemplatePackageRowSelectionIfChanged$default(paywallViewModel, legacy, packageInfo, null, 4, null);
                        paywallViewModel.selectPackage(packageInfo);
                    }
                };
                composerK.w(objG2);
            }
            composerK.U();
            ComposableLambda composableLambdaE = ComposableLambdaKt.e(760289252, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.SelectPackageButton.3
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
                        ComposerKt.U(760289252, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.SelectPackageButton.<anonymous> (Template2.kt:393)");
                    }
                    Modifier.Companion companion = Modifier.b8;
                    Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
                    Arrangement arrangement = Arrangement.f6574a;
                    Arrangement.HorizontalOrVertical horizontalOrVerticalO = arrangement.o(Dp.g(4));
                    Alignment.Companion companion2 = Alignment.f25072a;
                    Alignment.Horizontal horizontalK = companion2.k();
                    TemplateConfiguration.PackageInfo packageInfo2 = packageInfo;
                    long j3 = jM1156packageButtonColorAnimation9z6LAg82;
                    boolean z3 = zAreEqual;
                    PaywallState.Loaded.Legacy legacy2 = legacy;
                    MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalO, horizontalK, composer2, 54);
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF = ComposedModifierKt.f(composer2, modifierH);
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
                    MeasurePolicy measurePolicyB = RowKt.b(arrangement.o(Dp.g(6)), companion2.i(), composer2, 54);
                    int iA2 = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU2 = composer2.u();
                    Modifier modifierF2 = ComposedModifierKt.f(composer2, companion);
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
                    Updater.e(composerA2, modifierF2, companion3.f());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                    Template2Kt.CheckmarkBox(z3, PaywallStateKt.getCurrentColors(legacy2, composer2, 0), composer2, 0);
                    String offerName = packageInfo2.getLocalization().getOfferName();
                    if (offerName == null) {
                        offerName = packageInfo2.getRcPackage().getProduct().getTitle();
                    }
                    MaterialTheme materialTheme = MaterialTheme.f18110a;
                    int i8 = MaterialTheme.f18111b;
                    TextKt.c(offerName, null, j3, 0L, null, FontWeight.f29233b.h(), null, 0L, null, null, 0L, 0, false, 0, 0, null, materialTheme.c(composer2, i8).b(), composer2, 196608, 0, 65498);
                    composer2.y();
                    IntroEligibilityStateViewKt.m892IntroEligibilityStateViewQETHhvg(packageInfo2.getLocalization().getOfferDetails(), packageInfo2.getLocalization().getOfferDetailsWithIntroOffer(), packageInfo2.getLocalization().getOfferDetailsWithMultipleIntroOffers(), PackageExtensionsKt.getOfferEligibility(packageInfo2), j3, materialTheme.c(composer2, i8).c(), null, null, false, null, composer2, 100663296, 704);
                    composer2.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54);
            composerK = composerK;
            ButtonKt.a((Function0) objG2, modifierA, false, roundedCornerShapeD, buttonColorsB, null, borderStrokeA, paddingValuesB, null, composableLambdaE, composerK, 805306368, 292);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.SelectPackageButton.4
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
                    Template2Kt.SelectPackageButton(columnScope, legacy, packageInfo, paywallViewModel, modifier, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0100  */
    /* JADX INFO: renamed from: Subtitle-8iNrtrE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1178Subtitle8iNrtrE(com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Legacy r24, final androidx.compose.ui.Modifier r25, int r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.m1178Subtitle8iNrtrE(com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Legacy, androidx.compose.ui.Modifier, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void Template2(final com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Legacy r20, final com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel r21, androidx.compose.ui.Modifier r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instruction units count: 683
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.Template2(com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Legacy, com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Template2$lambda$5$lambda$4$lambda$1(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template2$lambda$5$lambda$4$lambda$2(MutableState<Boolean> mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template2LandscapeContent(final ColumnScope columnScope, final PaywallState.Loaded.Legacy legacy, final PaywallViewModel paywallViewModel, final boolean z2, final Modifier modifier, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1667751062);
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
            i4 |= composerK.Z(modifier) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        int i5 = i4;
        if ((i5 & 9363) == 9362 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1667751062, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template2LandscapeContent (Template2.kt:188)");
            }
            ScrollState scrollStateC = ScrollKt.c(0, composerK, 0, 1);
            ScrollState scrollStateC2 = ScrollKt.c(0, composerK, 0, 1);
            Arrangement.Horizontal horizontalD = Arrangement.Absolute.f6583a.d();
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Vertical verticalI = companion.i();
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierB = ColumnScope.b(columnScope, companion2, 1.0f, false, 2, null);
            UIConstant uIConstant = UIConstant.INSTANCE;
            Modifier modifierJ = PaddingKt.j(modifierB, uIConstant.m690getDefaultHorizontalPaddingD9Ej5fM(), uIConstant.m693getDefaultVerticalSpacingD9Ej5fM());
            MeasurePolicy measurePolicyB = RowKt.b(horizontalD, verticalI, composerK, 54);
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
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            Modifier modifierC = RowScope.c(rowScopeInstance, ScrollKt.g(companion2, scrollStateC, false, null, false, 14, null), 0.5f, false, 2, null);
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
            int i8 = ((i5 >> 9) & 112) | i7;
            IconImage(legacy, modifier, composerK, i8);
            TextAlign.Companion companion4 = TextAlign.f29616b;
            m1179Title8iNrtrE(legacy, modifier, companion4.f(), composerK, i8, 0);
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 0.5f, false, 2, null), composerK, 0);
            m1178Subtitle8iNrtrE(legacy, modifier, companion4.f(), composerK, i8, 0);
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 0.5f, false, 2, null), composerK, 0);
            composerK.y();
            Modifier modifierC2 = RowScope.c(rowScopeInstance, ScrollKt.g(companion2, scrollStateC2, false, null, false, 14, null), 0.5f, false, 2, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.q(uIConstant.m693getDefaultVerticalSpacingD9Ej5fM(), companion.i()), companion.g(), composerK, 48);
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
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 0.5f, false, 2, null), composerK, 0);
            int i9 = i7 | 384;
            int i10 = i5 >> 6;
            AnimatedPackages(legacy, z2, true, paywallViewModel, modifier, composerK, i9 | (i10 & 112) | ((i5 << 3) & 7168) | (57344 & i5));
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 0.5f, false, 2, null), composerK, 0);
            PurchaseButtonKt.m923PurchaseButtonhGBTI10(legacy, paywallViewModel, modifier, Dp.g(0), null, composerK, i7 | 3072 | (i6 & 112) | (i10 & 896), 16);
            composerK = composerK;
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 0.5f, false, 2, null), composerK, 0);
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.Template2LandscapeContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i11) {
                    Template2Kt.Template2LandscapeContent(columnScope, legacy, paywallViewModel, z2, modifier, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template2PaywallFooterCondensedPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(-741508648);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-741508648, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template2PaywallFooterCondensedPreview (Template2.kt:468)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.Template2PaywallFooterCondensedPreview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1184invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1184invoke();
                    return Unit.f139807a;
                }
            }).build(), new MockViewModel(PaywallMode.FOOTER_CONDENSED, TestData.INSTANCE.getTemplate2Offering(), null, false, false, 28, null), composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.Template2PaywallFooterCondensedPreview.2
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
                    Template2Kt.Template2PaywallFooterCondensedPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template2PaywallFooterPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(1374736823);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1374736823, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template2PaywallFooterPreview (Template2.kt:458)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.Template2PaywallFooterPreview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1185invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1185invoke();
                    return Unit.f139807a;
                }
            }).build(), new MockViewModel(PaywallMode.FOOTER, TestData.INSTANCE.getTemplate2Offering(), null, false, false, 28, null), composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.Template2PaywallFooterPreview.2
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
                    Template2Kt.Template2PaywallFooterPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template2PaywallPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(44645436);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(44645436, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template2PaywallPreview (Template2.kt:448)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.Template2PaywallPreview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1186invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1186invoke();
                    return Unit.f139807a;
                }
            }).build(), new MockViewModel(null, TestData.INSTANCE.getTemplate2Offering(), null, false, false, 29, null), composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.Template2PaywallPreview.2
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
                    Template2Kt.Template2PaywallPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template2PortraitContent(final ColumnScope columnScope, final PaywallState.Loaded.Legacy legacy, final PaywallViewModel paywallViewModel, final boolean z2, final Modifier modifier, Composer composer, final int i3) {
        int i4;
        PaywallViewModel paywallViewModel2;
        boolean z3;
        Composer composerK = composer.k(75198122);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(columnScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(legacy) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            paywallViewModel2 = paywallViewModel;
            i4 |= composerK.Z(paywallViewModel2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            paywallViewModel2 = paywallViewModel;
        }
        if ((i3 & 3072) == 0) {
            z3 = z2;
            i4 |= composerK.b(z3) ? 2048 : 1024;
        } else {
            z3 = z2;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.Z(modifier) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        int i5 = i4;
        if ((i5 & 9363) == 9362 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(75198122, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template2PortraitContent (Template2.kt:138)");
            }
            Modifier.Companion companion = Modifier.b8;
            UIConstant uIConstant = UIConstant.INSTANCE;
            SpacerKt.a(SizeKt.i(companion, uIConstant.m693getDefaultVerticalSpacingD9Ej5fM()), composerK, 0);
            final ScrollState scrollStateC = ScrollKt.c(0, composerK, 0, 1);
            boolean zIsInFullScreenMode = PaywallStateKt.isInFullScreenMode(legacy);
            composerK.a0(-491622595);
            boolean Z = ((i5 & 14) == 4) | composerK.Z(scrollStateC);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt$Template2PortraitContent$1$1
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
            Modifier modifierJ = PaddingKt.j(ModifierExtensionsKt.conditional(companion, zIsInFullScreenMode, (Function1) objG), uIConstant.m690getDefaultHorizontalPaddingD9Ej5fM(), uIConstant.m693getDefaultVerticalSpacingD9Ej5fM());
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
            composerK.a0(-1596100152);
            if (PaywallStateKt.isInFullScreenMode(legacy)) {
                SpacerKt.a(ColumnScope.b(columnScopeInstance, companion, 1.0f, false, 2, null), composerK, 0);
                int i6 = ((i5 >> 9) & 112) | ((i5 >> 3) & 14);
                IconImage(legacy, modifier, composerK, i6);
                m1179Title8iNrtrE(legacy, modifier, 0, composerK, i6, 4);
                SpacerKt.a(ColumnScope.b(columnScopeInstance, companion, 1.0f, false, 2, null), composerK, 0);
                m1178Subtitle8iNrtrE(legacy, modifier, 0, composerK, i6, 4);
                SpacerKt.a(ColumnScope.b(columnScopeInstance, companion, 1.0f, false, 2, null), composerK, 0);
            }
            composerK.U();
            AnimatedPackages(legacy, z3, false, paywallViewModel2, modifier, composerK, ((i5 >> 3) & 14) | 384 | ((i5 >> 6) & 112) | ((i5 << 3) & 7168) | (57344 & i5));
            composerK = composerK;
            composerK.a0(-1596084908);
            if (PaywallStateKt.isInFullScreenMode(legacy)) {
                SpacerKt.a(ColumnScope.b(columnScopeInstance, companion, 1.0f, false, 2, null), composerK, 0);
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.Template2PortraitContent.3
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
                    Template2Kt.Template2PortraitContent(columnScope, legacy, paywallViewModel, z2, modifier, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fc  */
    /* JADX INFO: renamed from: Title-8iNrtrE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1179Title8iNrtrE(com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Legacy r24, final androidx.compose.ui.Modifier r25, int r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.m1179Title8iNrtrE(com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Legacy, androidx.compose.ui.Modifier, int, androidx.compose.runtime.Composer, int, int):void");
    }
}
