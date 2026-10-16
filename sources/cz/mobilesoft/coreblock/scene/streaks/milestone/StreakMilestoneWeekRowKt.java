package cz.mobilesoft.coreblock.scene.streaks.milestone;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.streaks.StreakWeekDayStatus;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StreakMilestoneWeekRowKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f120963a = Dp.g(38);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f120964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f120965c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f120978a;

        static {
            int[] iArr = new int[StreakWeekDayStatus.values().length];
            try {
                iArr[StreakWeekDayStatus.Rest.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StreakWeekDayStatus.Obtained.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StreakWeekDayStatus.Lost.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StreakWeekDayStatus.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[StreakWeekDayStatus.Future.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f120978a = iArr;
        }
    }

    static {
        Duration.Companion companion = Duration.f140631b;
        DurationUnit durationUnit = DurationUnit.f140640d;
        f120964b = DurationKt.s(1450, durationUnit);
        f120965c = DurationKt.s(150, durationUnit);
    }

    private static final void g(final StreakWeekDayStatus streakWeekDayStatus, final Modifier modifier, Composer composer, final int i3, final int i4) {
        int i5;
        ScopeUpdateScope scopeUpdateScopeN;
        Function2 function2;
        Pair pairA;
        Composer composerK = composer.k(-979560785);
        if ((i3 & 6) == 0) {
            i5 = (composerK.e(streakWeekDayStatus.ordinal()) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i6 = i4 & 2;
        if (i6 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.Z(modifier) ? 32 : 16;
        }
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (i6 != 0) {
                modifier = Modifier.b8;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-979560785, i5, -1, "cz.mobilesoft.coreblock.scene.streaks.milestone.MilestoneDay (StreakMilestoneWeekRow.kt:148)");
            }
            if (streakWeekDayStatus == StreakWeekDayStatus.Rest) {
                composerK.a0(-2087199753);
                float f3 = f120963a;
                Modifier modifierV = SizeKt.v(modifier, f3);
                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
                int iA = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU = composerK.u();
                Modifier modifierF = ComposedModifierKt.f(composerK, modifierV);
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
                Modifier.Companion companion2 = Modifier.b8;
                BoxKt.a(BackgroundKt.c(SizeKt.v(companion2, f3), ComposeColorsKt.j(composerK, 0).n(), RoundedCornerShapeKt.g()), composerK, 0);
                IconKt.d(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.S5, composerK, 6), null, SizeKt.v(companion2, f3), ComposeColorsKt.j(composerK, 0).q(), composerK, 432, 0);
                composerK.y();
                composerK.U();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.milestone.s
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return StreakMilestoneWeekRowKt.h(streakWeekDayStatus, modifier, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            } else {
                composerK.a0(-2093383757);
                composerK.U();
                int i7 = WhenMappings.f120978a[streakWeekDayStatus.ordinal()];
                if (i7 != 1) {
                    if (i7 == 2) {
                        composerK.a0(-760039070);
                        composerK.U();
                        pairA = TuplesKt.a(Integer.valueOf(R.drawable.L5), Color.n(Color.f25715b.k()));
                    } else if (i7 == 3) {
                        composerK.a0(-760035829);
                        pairA = TuplesKt.a(Integer.valueOf(R.drawable.P5), Color.n(ComposeColorsKt.j(composerK, 0).q()));
                        composerK.U();
                    } else if (i7 == 4) {
                        composerK.a0(-760032181);
                        pairA = TuplesKt.a(Integer.valueOf(R.drawable.R5), Color.n(ComposeColorsKt.j(composerK, 0).u()));
                        composerK.U();
                    } else {
                        if (i7 != 5) {
                            composerK.a0(-760044494);
                            composerK.U();
                            throw new NoWhenBranchMatchedException();
                        }
                        composerK.a0(-760028597);
                        pairA = TuplesKt.a(Integer.valueOf(R.drawable.Q5), Color.n(ComposeColorsKt.j(composerK, 0).q()));
                        composerK.U();
                    }
                    IconKt.d(VectorResources_androidKt.b(ImageVector.f26323k, ((Number) pairA.a()).intValue(), composerK, 6), null, SizeKt.v(modifier, f120963a), ((Color) pairA.b()).B(), composerK, 48, 0);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                } else {
                    composerK.a0(-2086435603);
                    composerK.U();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                    scopeUpdateScopeN = composerK.n();
                    if (scopeUpdateScopeN == null) {
                        return;
                    } else {
                        function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.milestone.t
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return StreakMilestoneWeekRowKt.i(streakWeekDayStatus, modifier, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                    }
                }
            }
            scopeUpdateScopeN.a(function2);
        }
        composerK.Q();
        scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.milestone.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreakMilestoneWeekRowKt.j(streakWeekDayStatus, modifier, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeN.a(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(StreakWeekDayStatus streakWeekDayStatus, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        g(streakWeekDayStatus, modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(StreakWeekDayStatus streakWeekDayStatus, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        g(streakWeekDayStatus, modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(StreakWeekDayStatus streakWeekDayStatus, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        g(streakWeekDayStatus, modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0562  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x056d  */
    /* JADX WARN: Removed duplicated region for block: B:196:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007d  */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void k(final java.util.List r38, final java.lang.Integer r39, androidx.compose.ui.Modifier r40, boolean r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instruction units count: 1400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneWeekRowKt.k(java.util.List, java.lang.Integer, androidx.compose.ui.Modifier, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int l(MutableIntState mutableIntState) {
        return mutableIntState.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(MutableIntState mutableIntState, int i3) {
        mutableIntState.a(i3);
    }

    private static final float n(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(List list, Integer num, Modifier modifier, boolean z2, int i3, int i4, Composer composer, int i5) {
        k(list, num, modifier, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void p(final List list, final Modifier modifier, Composer composer, final int i3, final int i4) {
        int i5;
        Composer composerK = composer.k(575671449);
        if ((i3 & 6) == 0) {
            i5 = (composerK.I(list) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i6 = i4 & 2;
        if (i6 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.Z(modifier) ? 32 : 16;
        }
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (i6 != 0) {
                modifier = Modifier.b8;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(575671449, i5, -1, "cz.mobilesoft.coreblock.scene.streaks.milestone.StreakRibbon (StreakMilestoneWeekRow.kt:202)");
            }
            final long jR = Color.r(ComposeColorsKt.j(composerK, 0).V(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null);
            boolean zI = composerK.I(list) | composerK.f(jR);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.streaks.milestone.v
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StreakMilestoneWeekRowKt.q(list, jR, (DrawScope) obj);
                    }
                };
                composerK.w(objG);
            }
            CanvasKt.b(modifier, (Function1) objG, composerK, (i5 >> 3) & 14);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.milestone.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreakMilestoneWeekRowKt.r(list, modifier, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(List list, long j3, DrawScope drawScope) {
        int i3;
        DrawScope Canvas = drawScope;
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        float fIntBitsToFloat = Float.intBitsToFloat((int) (Canvas.b() >> 32)) / list.size();
        int i4 = 0;
        Integer numValueOf = null;
        for (Object obj : list) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (((Boolean) obj).booleanValue()) {
                int iIntValue = numValueOf != null ? numValueOf.intValue() : i4;
                if (i4 == CollectionsKt.getLastIndex(list) || !((Boolean) list.get(i5)).booleanValue()) {
                    float f3 = ((i4 - iIntValue) + 1) * fIntBitsToFloat;
                    long jE = Offset.e((((long) Float.floatToRawIntBits(iIntValue * fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L));
                    long jD = Size.d((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (Canvas.b() & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(f3)) << 32));
                    float fMin = Math.min(f3, Float.intBitsToFloat((int) (Canvas.b() & 4294967295L))) / 2.0f;
                    i3 = i5;
                    DrawScope.f2(Canvas, j3, jE, jD, CornerRadius.b((4294967295L & ((long) Float.floatToRawIntBits(fMin))) | (((long) Float.floatToRawIntBits(fMin)) << 32)), null, 0.0f, null, 0, 240, null);
                    numValueOf = null;
                } else {
                    numValueOf = Integer.valueOf(iIntValue);
                    i3 = i5;
                }
            } else {
                i3 = i5;
            }
            Canvas = drawScope;
            i4 = i3;
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(List list, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        p(list, modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
