package cz.mobilesoft.coreblock.scene.streaks.banner;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.streaks.StreakWeekDayStatus;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class StreakBannerWeekRowKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f120600a = Dp.g(36);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f120601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f120602c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f120613a;

        static {
            int[] iArr = new int[StreakWeekDayStatus.values().length];
            try {
                iArr[StreakWeekDayStatus.Obtained.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StreakWeekDayStatus.Rest.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StreakWeekDayStatus.Inactive.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StreakWeekDayStatus.Lost.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[StreakWeekDayStatus.Future.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f120613a = iArr;
        }
    }

    static {
        Duration.Companion companion = Duration.f140631b;
        DurationUnit durationUnit = DurationUnit.f140640d;
        f120601b = DurationKt.s(600, durationUnit);
        f120602c = DurationKt.s(350, durationUnit);
    }

    private static final void f(final long j3, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(98013131);
        if ((i3 & 6) == 0) {
            i4 = (composerK.f(j3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(98013131, i4, -1, "cz.mobilesoft.coreblock.scene.streaks.banner.DayCircle (StreakBannerWeekRow.kt:204)");
            }
            BoxKt.a(BackgroundKt.c(SizeKt.v(Modifier.b8, f120600a), j3, RoundedCornerShapeKt.g()), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.banner.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreakBannerWeekRowKt.g(j3, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(long j3, int i3, Composer composer, int i4) {
        f(j3, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void h(final Modifier modifier, Composer composer, final int i3, final int i4) {
        int i5;
        Composer composerK = composer.k(2588774);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if (composerK.r((i5 & 3) != 2, i5 & 1)) {
            if (i6 != 0) {
                modifier = Modifier.b8;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(2588774, i5, -1, "cz.mobilesoft.coreblock.scene.streaks.banner.FutureDay (StreakBannerWeekRow.kt:194)");
            }
            IconKt.d(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.Q5, composerK, 6), null, SizeKt.v(modifier, f120600a), ComposeColorsKt.j(composerK, 0).q(), composerK, 48, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.banner.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreakBannerWeekRowKt.i(modifier, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Modifier modifier, int i3, int i4, Composer composer, int i5) {
        h(modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void j(final boolean z2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-14831172);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-14831172, i4, -1, "cz.mobilesoft.coreblock.scene.streaks.banner.ObtainedDay (StreakBannerWeekRow.kt:161)");
            }
            State stateD = AnimateAsStateKt.d(z2 ? 1.0f : 0.0f, AnimationSpecKt.l(0.82f, 400.0f, null, 4, null), 0.0f, "streakBannerDayReveal", null, composerK, 3120, 20);
            Modifier.Companion companion = Modifier.b8;
            h(AlphaKt.a(ScaleKt.a(companion, MathHelpersKt.b(1.0f, 0.4f, k(stateD))), 1.0f - k(stateD)), composerK, 0, 0);
            float f3 = f120600a;
            Modifier modifierA = AlphaKt.a(ScaleKt.a(SizeKt.v(companion, f3), MathHelpersKt.b(0.4f, 1.0f, k(stateD))), k(stateD));
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierA);
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
            f(Color.r(ComposeColorsKt.j(composerK, 0).V(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), composerK, 0);
            IconKt.d(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.L5, composerK, 6), null, SizeKt.v(companion, Dp.g(f3 * 0.625f)), Color.f25715b.k(), composerK, 3504, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.banner.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreakBannerWeekRowKt.l(z2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float k(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(boolean z2, int i3, Composer composer, int i4) {
        j(z2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void m(final StreakWeekDayStatus streakWeekDayStatus, final boolean z2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1215288486);
        if ((i3 & 6) == 0) {
            i4 = (composerK.e(streakWeekDayStatus.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1215288486, i4, -1, "cz.mobilesoft.coreblock.scene.streaks.banner.StreakBannerDay (StreakBannerWeekRow.kt:120)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = f120600a;
            Modifier modifierV = SizeKt.v(companion, f3);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierV);
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
            int i5 = WhenMappings.f120613a[streakWeekDayStatus.ordinal()];
            if (i5 == 1) {
                composerK.a0(994582928);
                j(z2, composerK, (i4 >> 3) & 14);
                composerK.U();
            } else if (i5 == 2) {
                composerK.a0(767524975);
                f(Color.r(ComposeColorsKt.j(composerK, 0).V(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null), composerK, 0);
                IconKt.d(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.S5, composerK, 6), null, SizeKt.v(companion, f3), ComposeColorsKt.j(composerK, 0).q(), composerK, 432, 0);
                composerK.U();
            } else if (i5 == 3 || i5 == 4) {
                composerK.a0(768250375);
                IconKt.d(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.R5, composerK, 6), null, SizeKt.v(companion, f3), ComposeColorsKt.j(composerK, 0).u(), composerK, 432, 0);
                composerK.U();
            } else {
                if (i5 != 5) {
                    composerK.a0(994582319);
                    composerK.U();
                    throw new NoWhenBranchMatchedException();
                }
                composerK.a0(994623415);
                h(null, composerK, 0, 1);
                composerK.U();
            }
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.banner.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreakBannerWeekRowKt.n(streakWeekDayStatus, z2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(StreakWeekDayStatus streakWeekDayStatus, boolean z2, int i3, Composer composer, int i4) {
        m(streakWeekDayStatus, z2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a0  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void o(final java.util.List r37, androidx.compose.ui.Modifier r38, boolean r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instruction units count: 1009
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.banner.StreakBannerWeekRowKt.o(java.util.List, androidx.compose.ui.Modifier, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p(MutableIntState mutableIntState) {
        return mutableIntState.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(MutableIntState mutableIntState, int i3) {
        mutableIntState.a(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(List list, Modifier modifier, boolean z2, int i3, int i4, Composer composer, int i5) {
        o(list, modifier, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
