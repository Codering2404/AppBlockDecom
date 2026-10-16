package cz.mobilesoft.coreblock.view.compose.material3;

import android.graphics.PathMeasure;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

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
public final class RatingGraphPathKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [boolean, int] */
    private static final void j(final BoxScope boxScope, final Function2 function2, Function2 function22, final long j3, final float f3, float f4, final InfiniteRepeatableSpec infiniteRepeatableSpec, final float f5, Composer composer, final int i3) {
        int i4;
        BoxScope boxScope2;
        Function2 function23;
        final long j4;
        final Function2 function24;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeN;
        Function2 function25;
        ?? r9;
        final float f6;
        final float f7;
        final State stateA;
        Composer composer3;
        Function2 function26;
        Function2 function27;
        final Function2 function28 = function22;
        final float f8 = f4;
        Composer composerK = composer.k(-1417813719);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(boxScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function28) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.f(j3) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.c(f3) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.c(f8) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= (2097152 & i3) == 0 ? composerK.Z(infiniteRepeatableSpec) : composerK.I(infiniteRepeatableSpec) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i4 |= composerK.c(f5) ? 8388608 : 4194304;
        }
        if (composerK.r((4793491 & i4) != 4793490, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1417813719, i4, -1, "cz.mobilesoft.coreblock.view.compose.material3.MarkerContentAboveDot (RatingGraphPath.kt:175)");
            }
            if (function2 == null && function28 == null) {
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    function25 = new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.material3.w1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return RatingGraphPathKt.k(boxScope, function2, function28, j3, f3, f8, infiniteRepeatableSpec, f5, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    scopeUpdateScopeN.a(function25);
                }
                return;
            }
            boxScope2 = boxScope;
            j4 = j3;
            Density density = (Density) composerK.q(CompositionLocalsKt.f());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(IntSize.b(IntSize.f29998b.a()), null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            float fM1 = density.M1(f3);
            float fM12 = density.M1(f5);
            if (infiniteRepeatableSpec == null || fM12 <= 0.0f) {
                r9 = 0;
                f6 = fM1;
                Composer composer4 = composerK;
                f7 = fM12;
                composer4.a0(-1379043867);
                Object objG2 = composer4.G();
                if (objG2 == companion.a()) {
                    objG2 = PrimitiveSnapshotStateKt.a(0.0f);
                    composer4.w(objG2);
                }
                stateA = (MutableFloatState) objG2;
                composer4.U();
                composer3 = composer4;
            } else {
                composerK.a0(-1379372405);
                f6 = fM1;
                r9 = 0;
                f7 = fM12;
                stateA = InfiniteTransitionKt.a(InfiniteTransitionKt.c("rating_marker_bounce", composerK, 6, 0), 0.0f, 1.0f, infiniteRepeatableSpec, "rating_marker_bounce_progress", composerK, ((i4 >> 9) & 7168) | InfiniteTransition.f3967f | 25008 | (InfiniteRepeatableSpec.f3963d << 9), 0);
                Composer composer5 = composerK;
                composer5.U();
                composer3 = composer5;
            }
            Modifier.Companion companion2 = Modifier.b8;
            Alignment.Companion companion3 = Alignment.f25072a;
            Modifier modifierF = boxScope2.f(companion2, companion3.o());
            Object objG3 = composer3.G();
            if (objG3 == companion.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.material3.x1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RatingGraphPathKt.q(mutableState, (IntSize) obj);
                    }
                };
                composer3.w(objG3);
            }
            Modifier modifierA = OnRemeasuredModifierKt.a(modifierF, (Function1) objG3);
            int i5 = ((i4 & 7168) != 2048 ? r9 : 1) | (composer3.c(f6) ? 1 : 0);
            Object objG4 = composer3.G();
            if (i5 != 0 || objG4 == companion.a()) {
                objG4 = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.material3.y1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RatingGraphPathKt.r(j4, f6, mutableState, (Density) obj);
                    }
                };
                composer3.w(objG4);
            }
            Modifier modifierB = OffsetKt.b(modifierA, (Function1) objG4);
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), r9);
            int iA = ComposablesKt.a(composer3, r9);
            CompositionLocalMap compositionLocalMapU = composer3.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer3, modifierB);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
            if (composer3.m() == null) {
                ComposablesKt.c();
            }
            composer3.L();
            if (composer3.i()) {
                composer3.P(function0A);
            } else {
                composer3.v();
            }
            Composer composerA = Updater.a(composer3);
            Updater.e(composerA, measurePolicyG, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion4.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion3.g(), composer3, 48);
            int iA2 = ComposablesKt.a(composer3, 0);
            CompositionLocalMap compositionLocalMapU2 = composer3.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer3, companion2);
            Function0 function0A2 = companion4.a();
            if (composer3.m() == null) {
                ComposablesKt.c();
            }
            composer3.L();
            if (composer3.i()) {
                composer3.P(function0A2);
            } else {
                composer3.v();
            }
            Composer composerA2 = Updater.a(composer3);
            Updater.e(composerA2, measurePolicyA, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF3, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            if (function2 != null) {
                composer3.a0(1405306024);
                boolean Z = composer3.Z(stateA) | composer3.c(f7);
                Object objG5 = composer3.G();
                if (Z || objG5 == companion.a()) {
                    objG5 = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.material3.z1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RatingGraphPathKt.l(f7, stateA, (Density) obj);
                        }
                    };
                    composer3.w(objG5);
                }
                Modifier modifierB2 = OffsetKt.b(companion2, (Function1) objG5);
                MeasurePolicy measurePolicyG2 = BoxKt.g(companion3.o(), false);
                int iA3 = ComposablesKt.a(composer3, 0);
                CompositionLocalMap compositionLocalMapU3 = composer3.u();
                Modifier modifierF4 = ComposedModifierKt.f(composer3, modifierB2);
                Function0 function0A3 = companion4.a();
                if (composer3.m() == null) {
                    ComposablesKt.c();
                }
                composer3.L();
                if (composer3.i()) {
                    composer3.P(function0A3);
                } else {
                    composer3.v();
                }
                Composer composerA3 = Updater.a(composer3);
                Updater.e(composerA3, measurePolicyG2, companion4.e());
                Updater.e(composerA3, compositionLocalMapU3, companion4.g());
                Function2 function2B3 = companion4.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF4, companion4.f());
                Function2 function29 = function2;
                function29.invoke(composer3, Integer.valueOf((i4 >> 3) & 14));
                composer3.y();
                function26 = function29;
            } else {
                function26 = function2;
                composer3.a0(1395959741);
            }
            composer3.U();
            if (function26 == null || function22 == null) {
                f8 = f4;
                composer3.a0(1395959741);
            } else {
                composer3.a0(1405761197);
                f8 = f4;
                SpacerKt.a(SizeKt.i(companion2, f8), composer3, 0);
            }
            composer3.U();
            if (function22 == null) {
                composer3.a0(1405865108);
                composer3.U();
                function27 = function22;
            } else {
                composer3.a0(1846465805);
                Function2 function210 = function22;
                function210.invoke(composer3, Integer.valueOf((i4 >> 6) & 14));
                composer3.U();
                Unit unit = Unit.f139807a;
                function27 = function210;
            }
            composer3.y();
            composer3.y();
            composer2 = composer3;
            function24 = function27;
            function23 = function26;
            if (ComposerKt.M()) {
                ComposerKt.T();
                composer2 = composer3;
                function24 = function27;
                function23 = function26;
            }
        } else {
            boxScope2 = boxScope;
            function23 = function2;
            j4 = j3;
            Composer composer6 = composerK;
            composer6.Q();
            composer2 = composer6;
            function24 = function28;
        }
        scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            final BoxScope boxScope3 = boxScope2;
            final Function2 function211 = function23;
            final long j5 = j4;
            function25 = new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.material3.a2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RatingGraphPathKt.m(boxScope3, function211, function24, j5, f3, f8, infiniteRepeatableSpec, f5, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeN.a(function25);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(BoxScope boxScope, Function2 function2, Function2 function22, long j3, float f3, float f4, InfiniteRepeatableSpec infiniteRepeatableSpec, float f5, int i3, Composer composer, int i4) {
        j(boxScope, function2, function22, j3, f3, f4, infiniteRepeatableSpec, f5, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset l(float f3, State state, Density offset) {
        Intrinsics.checkNotNullParameter(offset, "$this$offset");
        return IntOffset.c(IntOffset.f((((long) 0) << 32) | (((long) MathKt.d((-p(state)) * f3)) & 4294967295L)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(BoxScope boxScope, Function2 function2, Function2 function22, long j3, float f3, float f4, InfiniteRepeatableSpec infiniteRepeatableSpec, float f5, int i3, Composer composer, int i4) {
        j(boxScope, function2, function22, j3, f3, f4, infiniteRepeatableSpec, f5, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final long n(MutableState mutableState) {
        return ((IntSize) mutableState.getValue()).j();
    }

    private static final void o(MutableState mutableState, long j3) {
        mutableState.setValue(IntSize.b(j3));
    }

    private static final float p(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(MutableState mutableState, IntSize intSize) {
        o(mutableState, intSize.j());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset r(long j3, float f3, MutableState mutableState, Density offset) {
        Intrinsics.checkNotNullParameter(offset, "$this$offset");
        return IntOffset.c(IntOffset.f((((long) MathKt.d(Float.intBitsToFloat((int) (j3 >> 32)) - (((int) (n(mutableState) >> 32)) / 2.0f))) << 32) | (((long) MathKt.d((Float.intBitsToFloat((int) (j3 & 4294967295L)) - ((int) (n(mutableState) & 4294967295L))) - f3)) & 4294967295L)));
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x06b4  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x06d3  */
    /* JADX WARN: Removed duplicated region for block: B:296:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0103 A[PHI: r33
      0x0103: PHI (r33v28 int) = (r33v4 int), (r33v10 int), (r33v11 int) binds: [B:81:0x0101, B:91:0x011e, B:90:0x011b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0127 A[PHI: r33
      0x0127: PHI (r33v27 int) = (r33v13 int), (r33v19 int), (r33v20 int) binds: [B:93:0x0125, B:103:0x0142, B:102:0x013f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void s(androidx.compose.ui.Modifier r39, final float r40, final float r41, float r42, float r43, float r44, float r45, float r46, androidx.compose.animation.core.InfiniteRepeatableSpec r47, androidx.compose.animation.core.InfiniteRepeatableSpec r48, float r49, float r50, kotlin.jvm.functions.Function2 r51, kotlin.jvm.functions.Function2 r52, kotlin.jvm.functions.Function2 r53, kotlin.jvm.functions.Function2 r54, androidx.compose.runtime.Composer r55, final int r56, final int r57, final int r58) {
        /*
            Method dump skipped, instruction units count: 1774
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.material3.RatingGraphPathKt.s(androidx.compose.ui.Modifier, float, float, float, float, float, float, float, androidx.compose.animation.core.InfiniteRepeatableSpec, androidx.compose.animation.core.InfiniteRepeatableSpec, float, float, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    private static final float t(MutableFloatState mutableFloatState) {
        return mutableFloatState.c();
    }

    private static final void u(MutableFloatState mutableFloatState, float f3) {
        mutableFloatState.s(f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(MutableFloatState mutableFloatState, IntSize intSize) {
        u(mutableFloatState, (int) (intSize.j() >> 32));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset w(long j3, float f3, Density offset) {
        Intrinsics.checkNotNullParameter(offset, "$this$offset");
        return IntOffset.c(IntOffset.f((((long) MathKt.d(Float.intBitsToFloat((int) (j3 >> 32)) - f3)) << 32) | (((long) MathKt.d(Float.intBitsToFloat((int) (j3 & 4294967295L)) - f3)) & 4294967295L)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset x(long j3, float f3, Density offset) {
        Intrinsics.checkNotNullParameter(offset, "$this$offset");
        return IntOffset.c(IntOffset.f((((long) MathKt.d(Float.intBitsToFloat((int) (j3 >> 32)) - f3)) << 32) | (((long) MathKt.d(Float.intBitsToFloat((int) (j3 & 4294967295L)) - f3)) & 4294967295L)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(Modifier modifier, float f3, float f4, float f5, float f6, float f7, float f8, float f9, InfiniteRepeatableSpec infiniteRepeatableSpec, InfiniteRepeatableSpec infiniteRepeatableSpec2, float f10, float f11, Function2 function2, Function2 function22, Function2 function23, Function2 function24, int i3, int i4, int i5, Composer composer, int i6) {
        s(modifier, f3, f4, f5, f6, f7, f8, f9, infiniteRepeatableSpec, infiniteRepeatableSpec2, f10, f11, function2, function22, function23, function24, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), i5);
        return Unit.f139807a;
    }

    private static final long z(PathMeasure pathMeasure, float f3, float f4) {
        float[] fArr = new float[2];
        if (!pathMeasure.getPosTan(f3, fArr, null)) {
            return Offset.f25596b.c();
        }
        float f5 = fArr[0] * f4;
        return Offset.e((((long) Float.floatToRawIntBits(fArr[1] * f4)) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32));
    }
}
