package androidx.compose.material;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
import java.util.NoSuchElementException;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class TabKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f14472a = Dp.g(48);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f14473b = Dp.g(72);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f14474c = Dp.g(16);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f14475d = Dp.g(14);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f14476e = Dp.g(6);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f14477f = TextUnitKt.i(20);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f14478g = Dp.g(8);

    /* JADX WARN: Removed duplicated region for block: B:100:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final boolean r28, final kotlin.jvm.functions.Function0 r29, final kotlin.jvm.functions.Function2 r30, final kotlin.jvm.functions.Function2 r31, androidx.compose.ui.Modifier r32, boolean r33, androidx.compose.foundation.interaction.MutableInteractionSource r34, long r35, long r37, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instruction units count: 530
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TabKt.a(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(final boolean r27, final kotlin.jvm.functions.Function0 r28, androidx.compose.ui.Modifier r29, boolean r30, kotlin.jvm.functions.Function2 r31, kotlin.jvm.functions.Function2 r32, androidx.compose.foundation.interaction.MutableInteractionSource r33, long r34, long r36, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instruction units count: 624
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TabKt.b(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.foundation.interaction.MutableInteractionSource, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(final boolean r32, final kotlin.jvm.functions.Function0 r33, androidx.compose.ui.Modifier r34, boolean r35, androidx.compose.foundation.interaction.MutableInteractionSource r36, long r37, long r39, final kotlin.jvm.functions.Function3 r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instruction units count: 524
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TabKt.c(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final Function2 function2, final Function2 function22, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1249848471);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function22) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1249848471, i4, -1, "androidx.compose.material.TabBaselineLayout (Tab.kt:302)");
            }
            int i5 = i4 & 14;
            boolean z2 = (i5 == 4) | ((i4 & 112) == 32);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new MeasurePolicy() { // from class: androidx.compose.material.TabKt$TabBaselineLayout$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo10measure3p2s80s(final MeasureScope measureScope, List list, long j3) {
                        Placeable placeableN0;
                        final Placeable placeableN02;
                        if (function2 != null) {
                            int size = list.size();
                            for (int i6 = 0; i6 < size; i6++) {
                                Measurable measurable = (Measurable) list.get(i6);
                                if (Intrinsics.areEqual(LayoutIdKt.a(measurable), "text")) {
                                    placeableN0 = measurable.n0(Constraints.d(j3, 0, 0, 0, 0, 11, null));
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                        placeableN0 = null;
                        if (function22 != null) {
                            int size2 = list.size();
                            for (int i7 = 0; i7 < size2; i7++) {
                                Measurable measurable2 = (Measurable) list.get(i7);
                                if (Intrinsics.areEqual(LayoutIdKt.a(measurable2), "icon")) {
                                    placeableN02 = measurable2.n0(j3);
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                        placeableN02 = null;
                        final int iMax = Math.max(placeableN0 != null ? placeableN0.X0() : 0, placeableN02 != null ? placeableN02.X0() : 0);
                        final int iZ0 = measureScope.z0((placeableN0 == null || placeableN02 == null) ? TabKt.f14472a : TabKt.f14473b);
                        final Integer numValueOf = placeableN0 != null ? Integer.valueOf(placeableN0.p0(AlignmentLineKt.a())) : null;
                        final Integer numValueOf2 = placeableN0 != null ? Integer.valueOf(placeableN0.p0(AlignmentLineKt.b())) : null;
                        final Placeable placeable = placeableN0;
                        return MeasureScope.B0(measureScope, iMax, iZ0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TabKt$TabBaselineLayout$2$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.f139807a;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                Placeable placeable2;
                                Placeable placeable3 = placeable;
                                if (placeable3 == null || (placeable2 = placeableN02) == null) {
                                    if (placeable3 != null) {
                                        TabKt.p(placementScope, placeable3, iZ0);
                                        return;
                                    }
                                    Placeable placeable4 = placeableN02;
                                    if (placeable4 != null) {
                                        TabKt.p(placementScope, placeable4, iZ0);
                                        return;
                                    }
                                    return;
                                }
                                MeasureScope measureScope2 = measureScope;
                                int i8 = iMax;
                                int i9 = iZ0;
                                Integer num = numValueOf;
                                Intrinsics.checkNotNull(num);
                                int iIntValue = num.intValue();
                                Integer num2 = numValueOf2;
                                Intrinsics.checkNotNull(num2);
                                TabKt.o(placementScope, measureScope2, placeable3, placeable2, i8, i9, iIntValue, num2.intValue());
                            }
                        }, 4, null);
                    }
                };
                composerK.w(objG);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objG;
            Modifier.Companion companion = Modifier.b8;
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
            Updater.e(composerA, measurePolicy, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            if (function2 != null) {
                composerK.a0(-238754006);
                Modifier modifierK = PaddingKt.k(LayoutIdKt.b(companion, "text"), f14474c, 0.0f, 2, null);
                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                int iA2 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU2 = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierK);
                Function0 function0A2 = companion2.a();
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
                Updater.e(composerA2, measurePolicyG, companion2.e());
                Updater.e(composerA2, compositionLocalMapU2, companion2.g());
                Function2 function2B2 = companion2.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion2.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                function2.invoke(composerK, Integer.valueOf(i5));
                composerK.y();
                composerK.U();
            } else {
                composerK.a0(-238605051);
                composerK.U();
            }
            if (function22 != null) {
                composerK.a0(-238572036);
                Modifier modifierB = LayoutIdKt.b(companion, "icon");
                MeasurePolicy measurePolicyG2 = BoxKt.g(Alignment.f25072a.o(), false);
                int iA3 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU3 = composerK.u();
                Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierB);
                Function0 function0A3 = companion2.a();
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
                Updater.e(composerA3, measurePolicyG2, companion2.e());
                Updater.e(composerA3, compositionLocalMapU3, companion2.g());
                Function2 function2B3 = companion2.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF3, companion2.f());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.f6642a;
                function22.invoke(composerK, Integer.valueOf((i4 >> 3) & 14));
                composerK.y();
                composerK.U();
            } else {
                composerK.a0(-238501883);
                composerK.U();
            }
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$TabBaselineLayout$3
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
                    TabKt.d(function2, function22, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final long j3, final long j4, boolean z2, final Function2 function2, Composer composer, final int i3) {
        int i4;
        final boolean z3;
        TwoWayConverter twoWayConverter;
        Composer composerK = composer.k(-405571117);
        if ((i3 & 6) == 0) {
            i4 = (composerK.f(j3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.f(j4) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            z3 = z2;
            i4 |= composerK.b(z3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            z3 = z2;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function2) ? 2048 : 1024;
        }
        if ((i4 & 1171) == 1170 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-405571117, i4, -1, "androidx.compose.material.TabTransition (Tab.kt:266)");
            }
            int i5 = i4 >> 6;
            Transition transitionJ = TransitionKt.j(Boolean.valueOf(z3), null, composerK, i5 & 14, 2);
            TabKt$TabTransition$color$2 tabKt$TabTransition$color$2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TabKt$TabTransition$color$2
                public final FiniteAnimationSpec c(Transition.Segment segment, Composer composer2, int i6) {
                    composer2.a0(-2120892502);
                    if (ComposerKt.M()) {
                        ComposerKt.U(-2120892502, i6, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:270)");
                    }
                    TweenSpec tweenSpecM = segment.d(Boolean.FALSE, Boolean.TRUE) ? AnimationSpecKt.m(150, 100, EasingKt.e()) : AnimationSpecKt.n(100, 0, EasingKt.e(), 2, null);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                    composer2.U();
                    return tweenSpecM;
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return c((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
                }
            };
            boolean zBooleanValue = ((Boolean) transitionJ.q()).booleanValue();
            composerK.a0(1445938070);
            if (ComposerKt.M()) {
                ComposerKt.U(1445938070, 0, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:284)");
            }
            long j5 = zBooleanValue ? j3 : j4;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composerK.U();
            ColorSpace colorSpaceW = Color.w(j5);
            boolean Z = composerK.Z(colorSpaceW);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = (TwoWayConverter) ColorVectorConverterKt.a(Color.f25715b).invoke(colorSpaceW);
                composerK.w(objG);
            }
            TwoWayConverter twoWayConverter2 = (TwoWayConverter) objG;
            boolean zBooleanValue2 = ((Boolean) transitionJ.i()).booleanValue();
            composerK.a0(1445938070);
            if (ComposerKt.M()) {
                ComposerKt.U(1445938070, 0, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:284)");
            }
            long j6 = zBooleanValue2 ? j3 : j4;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composerK.U();
            Color colorN = Color.n(j6);
            boolean zBooleanValue3 = ((Boolean) transitionJ.q()).booleanValue();
            composerK.a0(1445938070);
            if (ComposerKt.M()) {
                twoWayConverter = twoWayConverter2;
                ComposerKt.U(1445938070, 0, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:284)");
            } else {
                twoWayConverter = twoWayConverter2;
            }
            long j7 = zBooleanValue3 ? j3 : j4;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composerK.U();
            State stateF = TransitionKt.f(transitionJ, colorN, Color.n(j7), (FiniteAnimationSpec) tabKt$TabTransition$color$2.invoke(transitionJ.o(), composerK, 0), twoWayConverter, "ColorAnimation", composerK, 0);
            CompositionLocalKt.c(new ProvidedValue[]{ContentColorKt.a().d(Color.n(Color.r(f(stateF), 1.0f, 0.0f, 0.0f, 0.0f, 14, null))), ContentAlphaKt.a().d(Float.valueOf(Color.u(f(stateF))))}, function2, composerK, (i5 & 112) | ProvidedValue.f24012i);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$TabTransition$1
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
                    TabKt.e(j3, j4, z3, function2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    private static final long f(State state) {
        return ((Color) state.getValue()).B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Placeable.PlacementScope placementScope, Density density, Placeable placeable, Placeable placeable2, int i3, int i4, int i5, int i6) {
        int iZ0 = density.z0(i5 == i6 ? f14475d : f14476e) + density.z0(TabRowDefaults.f14549a.c());
        int iO0 = (placeable2.O0() + density.T1(f14477f)) - i5;
        int i7 = (i4 - i6) - iZ0;
        Placeable.PlacementScope.m(placementScope, placeable, (i3 - placeable.X0()) / 2, i7, 0.0f, 4, null);
        Placeable.PlacementScope.m(placementScope, placeable2, (i3 - placeable2.X0()) / 2, i7 - iO0, 0.0f, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Placeable.PlacementScope placementScope, Placeable placeable, int i3) {
        Placeable.PlacementScope.m(placementScope, placeable, 0, (i3 - placeable.O0()) / 2, 0.0f, 4, null);
    }
}
