package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.UIConstant;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class TierSwitcherKt {
    /* JADX INFO: renamed from: SelectedTierView-1wkBAMs, reason: not valid java name */
    public static final void m940SelectedTierView1wkBAMs(final TemplateConfiguration.TierInfo selectedTier, final long j3, final long j4, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(selectedTier, "selectedTier");
        Composer composerK = composer.k(-474734628);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(selectedTier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.f(j3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.f(j4) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-474734628, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.SelectedTierView (TierSwitcher.kt:52)");
            }
            Modifier modifierC = BackgroundKt.c(Modifier.b8, j3, RoundedCornerShapeKt.a(50));
            TierSwitcherUIConstants tierSwitcherUIConstants = TierSwitcherUIConstants.INSTANCE;
            Modifier modifierJ = PaddingKt.j(modifierC, tierSwitcherUIConstants.m947getTierHorizontalPaddingD9Ej5fM(), tierSwitcherUIConstants.m950getTierVerticalPaddingD9Ej5fM());
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierJ);
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
            composer2 = composerK;
            TextKt.c(selectedTier.getName(), null, j4, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f18110a.c(composerK, MaterialTheme.f18111b).c(), composer2, i4 & 896, 0, 65530);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.TierSwitcherKt$SelectedTierView$2
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
                    TierSwitcherKt.m940SelectedTierView1wkBAMs(selectedTier, j3, j4, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: TierSwitcher-UFBoNtE, reason: not valid java name */
    public static final void m941TierSwitcherUFBoNtE(final List<TemplateConfiguration.TierInfo> tiers, final TemplateConfiguration.TierInfo selectedTier, final Function1<? super TemplateConfiguration.TierInfo, Unit> onTierSelected, final long j3, final long j4, final long j5, final long j6, Composer composer, final int i3) {
        Intrinsics.checkNotNullParameter(tiers, "tiers");
        Intrinsics.checkNotNullParameter(selectedTier, "selectedTier");
        Intrinsics.checkNotNullParameter(onTierSelected, "onTierSelected");
        Composer composerK = composer.k(1054819874);
        int i4 = (i3 & 6) == 0 ? (composerK.I(tiers) ? 4 : 2) | i3 : i3;
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(selectedTier) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onTierSelected) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.f(j3) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.f(j4) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.f(j5) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.f(j6) ? 1048576 : 524288;
        }
        if ((i4 & 599187) == 599186 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1054819874, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.TierSwitcher (TierSwitcher.kt:82)");
            }
            int iIndexOf = tiers.indexOf(selectedTier);
            composerK.a0(-1638624750);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            int i5 = i4;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(0, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            composerK.U();
            composerK.a0(-1638622858);
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Dp.d(Dp.g(40)), null, 2, null);
                composerK.w(objG2);
            }
            final MutableState mutableState2 = (MutableState) objG2;
            composerK.U();
            final Density density = (Density) composerK.q(CompositionLocalsKt.f());
            UIConstant uIConstant = UIConstant.INSTANCE;
            State stateA = SingleValueAnimationKt.a(j3, uIConstant.getDefaultColorAnimation(), "backgroundColor", null, composerK, ((i5 >> 9) & 14) | 384, 8);
            State stateA2 = SingleValueAnimationKt.a(j4, uIConstant.getDefaultColorAnimation(), "backgroundSelectedColor", null, composerK, ((i5 >> 12) & 14) | 384, 8);
            State stateA3 = SingleValueAnimationKt.a(j5, uIConstant.getDefaultColorAnimation(), "foregroundColor", null, composerK, ((i5 >> 15) & 14) | 384, 8);
            State stateA4 = SingleValueAnimationKt.a(j6, uIConstant.getDefaultColorAnimation(), "foregroundSelectedColor", null, composerK, ((i5 >> 18) & 14) | 384, 8);
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierD = BackgroundKt.d(ClipKt.a(companion2, RoundedCornerShapeKt.a(50)), TierSwitcher_UFBoNtE$lambda$7(stateA), null, 2, null);
            float f3 = 0.0f;
            Modifier modifierH = SizeKt.h(modifierD, 0.0f, 1, null);
            composerK.a0(-1638586667);
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = new Function1<IntSize, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.TierSwitcherKt$TierSwitcher$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        m942invokeozmzZPI(((IntSize) obj).j());
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                    public final void m942invokeozmzZPI(long j7) {
                        TierSwitcherKt.TierSwitcher_UFBoNtE$lambda$3(mutableState, IntSize.g(j7));
                    }
                };
                composerK.w(objG3);
            }
            composerK.U();
            Modifier modifierA = OnRemeasuredModifierKt.a(modifierH, (Function1) objG3);
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierA);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
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
            Updater.e(composerA, measurePolicyG, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            float fG = Dp.g(density.F(TierSwitcher_UFBoNtE$lambda$2(mutableState) / tiers.size()) * iIndexOf);
            int i6 = 1;
            State stateC = AnimateAsStateKt.c(fG, null, "tier_switcher", null, composerK, 384, 10);
            composerK = composerK;
            Modifier modifierI = SizeKt.i(SizeKt.g(OffsetKt.d(companion2, TierSwitcher_UFBoNtE$lambda$20$lambda$13(stateC), 0.0f, 2, null), 1.0f / tiers.size()), TierSwitcher_UFBoNtE$lambda$5(mutableState2));
            TierSwitcherUIConstants tierSwitcherUIConstants = TierSwitcherUIConstants.INSTANCE;
            BoxKt.a(BackgroundKt.d(ClipKt.a(PaddingKt.i(modifierI, tierSwitcherUIConstants.m946getSelectedTierPaddingD9Ej5fM()), RoundedCornerShapeKt.a(50)), TierSwitcher_UFBoNtE$lambda$8(stateA2), null, 2, null), composerK, 0);
            Alignment.Vertical verticalI = companion3.i();
            Arrangement.HorizontalOrVertical horizontalOrVerticalF = Arrangement.f6574a.f();
            composerK.a0(1157748976);
            boolean Z = composerK.Z(density);
            Object objG4 = composerK.G();
            if (Z || objG4 == companion.a()) {
                objG4 = new Function1<IntSize, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.TierSwitcherKt$TierSwitcher$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        m943invokeozmzZPI(((IntSize) obj).j());
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                    public final void m943invokeozmzZPI(long j7) {
                        TierSwitcherKt.TierSwitcher_UFBoNtE$lambda$6(mutableState2, density.F(IntSize.f(j7)));
                    }
                };
                composerK.w(objG4);
            }
            composerK.U();
            Modifier modifierK = SizeKt.k(IntrinsicKt.a(OnRemeasuredModifierKt.a(companion2, (Function1) objG4), IntrinsicSize.f6987b), tierSwitcherUIConstants.m945getMinimumHeightD9Ej5fM(), 0.0f, 2, null);
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalF, verticalI, composerK, 54);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierK);
            Function0 function0A2 = companion4.a();
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
            Updater.e(composerA2, measurePolicyB, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            composerK.a0(686110850);
            for (final TemplateConfiguration.TierInfo tierInfo : tiers) {
                Alignment alignmentE = Alignment.f25072a.e();
                Modifier.Companion companion5 = Modifier.b8;
                RowScopeInstance rowScopeInstance2 = rowScopeInstance;
                Modifier modifierD2 = SizeKt.d(RowScope.c(rowScopeInstance, companion5, 1.0f, false, 2, null), f3, i6, null);
                composerK.a0(-606775784);
                Object objG5 = composerK.G();
                Composer.Companion companion6 = Composer.f23746a;
                if (objG5 == companion6.a()) {
                    objG5 = InteractionSourceKt.a();
                    composerK.w(objG5);
                }
                MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objG5;
                composerK.U();
                composerK.a0(-606773603);
                int i7 = ((i5 & 896) == 256 ? i6 : 0) | (composerK.Z(tierInfo) ? 1 : 0);
                Object objG6 = composerK.G();
                if (i7 != 0 || objG6 == companion6.a()) {
                    objG6 = new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.TierSwitcherKt$TierSwitcher$2$2$1$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m944invoke();
                            return Unit.f139807a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m944invoke() {
                            onTierSelected.invoke(tierInfo);
                        }
                    };
                    composerK.w(objG6);
                }
                composerK.U();
                Modifier modifierD3 = ClickableKt.d(modifierD2, mutableInteractionSource, null, false, null, null, (Function0) objG6, 28, null);
                MeasurePolicy measurePolicyG2 = BoxKt.g(alignmentE, false);
                int iA3 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU3 = composerK.u();
                Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierD3);
                ComposeUiNode.Companion companion7 = ComposeUiNode.f8;
                Function0 function0A3 = companion7.a();
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
                Updater.e(composerA3, measurePolicyG2, companion7.e());
                Updater.e(composerA3, compositionLocalMapU3, companion7.g());
                Function2 function2B3 = companion7.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF3, companion7.f());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.f6642a;
                String name = tierInfo.getName();
                TextStyle textStyleC = MaterialTheme.f18110a.c(composerK, MaterialTheme.f18111b).c();
                int iA4 = TextAlign.f29616b.a();
                TierSwitcherUIConstants tierSwitcherUIConstants2 = TierSwitcherUIConstants.INSTANCE;
                TextKt.c(name, PaddingKt.j(companion5, tierSwitcherUIConstants2.m948getTierTextPaddingHorizontalD9Ej5fM(), tierSwitcherUIConstants2.m949getTierTextPaddingVerticalD9Ej5fM()), Intrinsics.areEqual(selectedTier, tierInfo) ? TierSwitcher_UFBoNtE$lambda$10(stateA4) : TierSwitcher_UFBoNtE$lambda$9(stateA3), 0L, null, null, null, 0L, null, TextAlign.h(iA4), 0L, 0, false, 0, 0, null, textStyleC, composerK, 48, 0, 65016);
                composerK.y();
                f3 = f3;
                rowScopeInstance = rowScopeInstance2;
                i6 = 1;
            }
            composerK.U();
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.TierSwitcherKt$TierSwitcher$3
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

                public final void invoke(Composer composer2, int i8) {
                    TierSwitcherKt.m941TierSwitcherUFBoNtE(tiers, selectedTier, onTierSelected, j3, j4, j5, j6, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    private static final long TierSwitcher_UFBoNtE$lambda$10(State<Color> state) {
        return ((Color) state.getValue()).B();
    }

    private static final int TierSwitcher_UFBoNtE$lambda$2(MutableState<Integer> mutableState) {
        return ((Number) mutableState.getValue()).intValue();
    }

    private static final float TierSwitcher_UFBoNtE$lambda$20$lambda$13(State<Dp> state) {
        return ((Dp) state.getValue()).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TierSwitcher_UFBoNtE$lambda$3(MutableState<Integer> mutableState, int i3) {
        mutableState.setValue(Integer.valueOf(i3));
    }

    private static final float TierSwitcher_UFBoNtE$lambda$5(MutableState<Dp> mutableState) {
        return ((Dp) mutableState.getValue()).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TierSwitcher_UFBoNtE$lambda$6(MutableState<Dp> mutableState, float f3) {
        mutableState.setValue(Dp.d(f3));
    }

    private static final long TierSwitcher_UFBoNtE$lambda$7(State<Color> state) {
        return ((Color) state.getValue()).B();
    }

    private static final long TierSwitcher_UFBoNtE$lambda$8(State<Color> state) {
        return ((Color) state.getValue()).B();
    }

    private static final long TierSwitcher_UFBoNtE$lambda$9(State<Color> state) {
        return ((Color) state.getValue()).B();
    }
}
