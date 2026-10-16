package cz.mobilesoft.coreblock.scene.premium.components;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.NotificationsKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PremiumTrialTimelineKt {
    /* JADX WARN: Removed duplicated region for block: B:152:0x050c  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0519  */
    /* JADX WARN: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void k(androidx.compose.ui.Modifier r42, long r43, final int r45, final boolean r46, final boolean r47, boolean r48, androidx.compose.runtime.Composer r49, final int r50, final int r51) {
        /*
            Method dump skipped, instruction units count: 1316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.components.PremiumTrialTimelineKt.k(androidx.compose.ui.Modifier, long, int, boolean, boolean, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(final boolean z2, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2060317665, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.PremiumTrialTimeline.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PremiumTrialTimeline.kt:139)");
            }
            Arrangement arrangement = Arrangement.f6574a;
            FlowLayoutKt.d(null, arrangement.o(Dp.g(8)), arrangement.o(Dp.g(2)), null, 0, 0, ComposableLambdaKt.e(-1880645412, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.components.r3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PremiumTrialTimelineKt.m(z2, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1573296, 57);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(boolean z2, FlowRowScope FlowRow, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1880645412, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.PremiumTrialTimeline.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PremiumTrialTimeline.kt:143)");
            }
            x(NotificationsKt.a(Icons.f15145a.a()), StringResources_androidKt.b(R.string.ml, composer, 0), composer, 0);
            if (z2) {
                composer.a0(1541240308);
                x(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.t6, composer, 6), StringResources_androidKt.b(R.string.T, composer, 0), composer, 0);
            } else {
                composer.a0(1534808614);
            }
            composer.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Modifier modifier, long j3, int i3, boolean z2, boolean z3, boolean z4, int i4, int i5, Composer composer, int i6) {
        k(modifier, j3, i3, z2, z3, z4, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    private static final void o(final long j3, final float f3, final float f4, final float f5, Composer composer, final int i3) {
        int i4;
        ScopeUpdateScope scopeUpdateScopeN;
        Function2 function2;
        Composer composerK = composer.k(423469646);
        if ((i3 & 6) == 0) {
            i4 = (composerK.f(j3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.c(f3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.c(f4) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.c(f5) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(423469646, i4, -1, "cz.mobilesoft.coreblock.scene.premium.components.TimelineGraph (PremiumTrialTimeline.kt:201)");
            }
            if (f3 == 0.0f || f4 == 0.0f || f5 == 0.0f) {
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.s3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PremiumTrialTimelineKt.p(j3, f3, f4, f5, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    scopeUpdateScopeN.a(function2);
                }
                return;
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = Dp.d(Dp.g(40));
                composerK.w(objG);
            }
            float fL = ((Dp) objG).l();
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = Dp.d(Dp.g(fL / 2));
                composerK.w(objG2);
            }
            float fL2 = ((Dp) objG2).l();
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = Dp.d(Dp.g(8));
                composerK.w(objG3);
            }
            float fL3 = ((Dp) objG3).l();
            Density density = (Density) composerK.q(CompositionLocalsKt.f());
            boolean z2 = (i4 & 7168) == 2048;
            Object objG4 = composerK.G();
            if (z2 || objG4 == companion.a()) {
                objG4 = Dp.d(((Dp) RangesKt.h(Dp.d(Dp.g(density.G(f5) - fL3)), Dp.d(fL3))).l());
                composerK.w(objG4);
            }
            float fL4 = ((Dp) objG4).l();
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierD = SizeKt.d(SizeKt.A(companion2, fL), 0.0f, 1, null);
            Object objG5 = composerK.G();
            if (objG5 == companion.a()) {
                objG5 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.components.t3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PremiumTrialTimelineKt.q((GraphicsLayerScope) obj);
                    }
                };
                composerK.w(objG5);
            }
            Modifier modifierC = BackgroundKt.c(GraphicsLayerModifierKt.a(modifierD, (Function1) objG5), ComposeColorsKt.j(composerK, 0).b(), RoundedCornerShapeKt.d(fL2));
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierC);
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
            Modifier modifierM = PaddingKt.m(boxScopeInstance.f(companion2, companion3.m()), 0.0f, Dp.g(fL4 - fL3), 0.0f, 0.0f, 13, null);
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion3.o(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierM);
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
            Updater.e(composerA2, measurePolicyG2, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            BoxKt.a(BackgroundKt.c(SizeKt.o(companion2, Dp.g(fL + fL3)), j3, RoundedCornerShapeKt.g()), composerK, 0);
            composerK.y();
            float f6 = 0;
            BoxKt.a(BackgroundKt.b(SizeKt.d(SizeKt.A(PaddingKt.m(companion2, 0.0f, fL4, 0.0f, 0.0f, 13, null), fL), 0.0f, 1, null), Brush.Companion.c(CollectionsKt.listOf((Object[]) new Color[]{Color.n(ComposeColorsKt.j(composerK, 0).Y()), Color.n(j3)}), Offset.e((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), Offset.e((((long) Float.floatToRawIntBits(Float.POSITIVE_INFINITY)) & 4294967295L) | (((long) Float.floatToRawIntBits(0.0f)) << 32)), TileMode.f25948b.a()), RoundedCornerShapeKt.e(fL2, fL2, Dp.g(f6), Dp.g(f6)), 0.0f, 4, null), composerK, 0);
            ImageVector.Companion companion5 = ImageVector.f26323k;
            s(boxScopeInstance, VectorResources_androidKt.b(companion5, R.drawable.w3, composerK, 6), f3, composerK, ((i4 << 3) & 896) | 6);
            s(boxScopeInstance, VectorResources_androidKt.b(companion5, R.drawable.f95567u0, composerK, 6), f4, composerK, (i4 & 896) | 6);
            s(boxScopeInstance, VectorResources_androidKt.b(companion5, R.drawable.s4, composerK, 6), f5, composerK, ((i4 >> 3) & 896) | 6);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.u3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PremiumTrialTimelineKt.r(j3, f3, f4, f5, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeN.a(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(long j3, float f3, float f4, float f5, int i3, Composer composer, int i4) {
        o(j3, f3, f4, f5, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.B(true);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(long j3, float f3, float f4, float f5, int i3, Composer composer, int i4) {
        o(j3, f3, f4, f5, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void s(final BoxScope boxScope, final ImageVector imageVector, final float f3, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1307966273);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(boxScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(imageVector) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.c(f3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1307966273, i4, -1, "cz.mobilesoft.coreblock.scene.premium.components.TimelineIcon (PremiumTrialTimeline.kt:271)");
            }
            IconKt.b(imageVector, null, boxScope.f(PaddingKt.m(Modifier.b8, 0.0f, Dp.g(((Density) composerK.q(CompositionLocalsKt.f())).G(f3) + Dp.g(2)), 0.0f, 0.0f, 13, null), Alignment.f25072a.m()), Color.f25715b.l(), composerK, ((i4 >> 3) & 14) | 3120, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.y3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PremiumTrialTimelineKt.t(boxScope, imageVector, f3, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(BoxScope boxScope, ImageVector imageVector, float f3, int i3, Composer composer, int i4) {
        s(boxScope, imageVector, f3, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void u(final java.lang.String r33, final java.lang.String r34, final androidx.compose.runtime.MutableState r35, kotlin.jvm.functions.Function2 r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instruction units count: 420
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.components.PremiumTrialTimelineKt.u(java.lang.String, java.lang.String, androidx.compose.runtime.MutableState, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(MutableState mutableState, LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        mutableState.setValue(Float.valueOf(Float.intBitsToFloat((int) (LayoutCoordinatesKt.e(coordinates) & 4294967295L))));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(String str, String str2, MutableState mutableState, Function2 function2, int i3, int i4, Composer composer, int i5) {
        u(str, str2, mutableState, function2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void x(final ImageVector imageVector, String str, Composer composer, final int i3) {
        int i4;
        final String str2;
        Composer composerK = composer.k(1559823635);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(imageVector) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(str) ? 32 : 16;
        }
        int i5 = i4;
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1559823635, i5, -1, "cz.mobilesoft.coreblock.scene.premium.components.TrialNotificationInfoBadge (PremiumTrialTimeline.kt:176)");
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = Arrangement.f6574a.o(Dp.g(4));
            Alignment.Vertical verticalI = Alignment.f25072a.i();
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalO, verticalI, composerK, 54);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            IconKt.b(imageVector, null, SizeKt.v(companion, Dp.g(16)), ComposeColorsKt.j(composerK, 0).b(), composerK, (i5 & 14) | 432, 0);
            str2 = str;
            TextKt.c(str2, null, ComposeColorsKt.j(composerK, 0).b(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).j(), composerK, (i5 >> 3) & 14, 0, 65530);
            composerK = composerK;
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            str2 = str;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.x3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PremiumTrialTimelineKt.y(imageVector, str2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(ImageVector imageVector, String str, int i3, Composer composer, int i4) {
        x(imageVector, str, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
