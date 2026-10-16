package cz.mobilesoft.coreblock.scene.schedule.detail;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.BorderKt;
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
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import coil.compose.SingletonAsyncImageKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.ConflictingScheduleKt;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent;
import cz.mobilesoft.coreblock.util.PackageManagerHelperKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.material3.CardsKt;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ConflictingSchedulesRowKt {
    public static final void g(final Set applications, final PackageManager packageManager, Composer composer, final int i3) throws Exception {
        int i4;
        Intrinsics.checkNotNullParameter(applications, "applications");
        Intrinsics.checkNotNullParameter(packageManager, "packageManager");
        Composer composerK = composer.k(1399756496);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(applications) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(packageManager) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1399756496, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ConflictingAppsRow (ConflictingSchedulesRow.kt:112)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
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
            IconKt.a(PainterResources_androidKt.c(R.drawable.w5, composerK, 0), null, SizeKt.v(companion, Dp.g(22)), ComposeColorsKt.j(composerK, 0).p(), composerK, 432, 0);
            o(applications, packageManager, composerK, i4 & 126);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.b3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ConflictingSchedulesRowKt.h(applications, packageManager, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Set set, PackageManager packageManager, int i3, Composer composer, int i4) throws Exception {
        g(set, packageManager, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void i(Modifier modifier, final List conflictingSchedules, final Function1 onEvent, final PackageManager packageManager, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        Composer composer2;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(conflictingSchedules, "conflictingSchedules");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(packageManager, "packageManager");
        Composer composerK = composer.k(-1991651736);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(conflictingSchedules) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(onEvent) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.I(packageManager) ? 2048 : 1024;
        }
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            Modifier modifier4 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-1991651736, i5, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ConflictingSchedulesRow (ConflictingSchedulesRow.kt:66)");
            }
            Modifier modifierH = SizeKt.h(PaddingKt.i(modifier4, PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0)), 0.0f, 1, null);
            long jE = ComposeColorsKt.j(composerK, 0).e();
            boolean z2 = (i5 & 896) == 256;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.y2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ConflictingSchedulesRowKt.l(onEvent);
                    }
                };
                composerK.w(objG);
            }
            Modifier modifier5 = modifier4;
            composer2 = composerK;
            CardsKt.n(modifierH, 0.0f, 0L, 0.0f, jE, false, null, (Function0) objG, ComposableLambdaKt.e(-1241156344, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.z2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ConflictingSchedulesRowKt.m(conflictingSchedules, packageManager, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 100663296, 110);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier3 = modifier5;
        } else {
            composer2 = composerK;
            composer2.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.a3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ConflictingSchedulesRowKt.n(modifier3, conflictingSchedules, onEvent, packageManager, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void j(Modifier modifier, final List conflictingSchedules, final Function1 onEvent, Composer composer, final int i3, final int i4) {
        int i5;
        final Modifier modifier2;
        Intrinsics.checkNotNullParameter(conflictingSchedules, "conflictingSchedules");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(-27839829);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(conflictingSchedules) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(onEvent) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            Modifier modifier3 = i6 != 0 ? Modifier.b8 : modifier;
            if (ComposerKt.M()) {
                ComposerKt.U(-27839829, i5, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ConflictingSchedulesRow (ConflictingSchedulesRow.kt:48)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = context.getApplicationContext().getPackageManager();
                composerK.w(objG);
            }
            PackageManager packageManager = (PackageManager) objG;
            Intrinsics.checkNotNull(packageManager);
            Modifier modifier4 = modifier3;
            i(modifier4, conflictingSchedules, onEvent, packageManager, composerK, i5 & 1022, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier2 = modifier4;
        } else {
            composerK.Q();
            modifier2 = modifier;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.x2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ConflictingSchedulesRowKt.k(modifier2, conflictingSchedules, onEvent, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Modifier modifier, List list, Function1 function1, int i3, int i4, Composer composer, int i5) {
        j(modifier, list, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Function1 function1) {
        function1.invoke(ScheduleViewEvent.OnConflictingSchedulesClicked.f114560a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(List list, PackageManager packageManager, ColumnScope BorderedCard, Composer composer, int i3) throws Exception {
        Intrinsics.checkNotNullParameter(BorderedCard, "$this$BorderedCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1241156344, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ConflictingSchedulesRow.<anonymous> (ConflictingSchedulesRow.kt:76)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierI = PaddingKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(16));
            Alignment.Companion companion2 = Alignment.f25072a;
            Alignment.Vertical verticalI = companion2.i();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), verticalI, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            Modifier modifierC = RowScope.c(RowScopeInstance.f7101a, companion, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), companion2.k(), composer, 0);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierC);
            Function0 function0A2 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A2);
            } else {
                composer.v();
            }
            Composer composerA2 = Updater.a(composer);
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            g(ConflictingScheduleKt.a(list), packageManager, composer, 0);
            SpacerKt.a(SizeKt.i(companion, Dp.g(8)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.N1, composer, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).j(), composer, 0, 0, 65534);
            composer.y();
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95580y1, composer, 6), null, null, ComposeColorsKt.j(composer, 0).q(), composer, 48, 4);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Modifier modifier, List list, Function1 function1, PackageManager packageManager, int i3, int i4, Composer composer, int i5) {
        i(modifier, list, function1, packageManager, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v6 */
    private static final void o(final Set set, final PackageManager packageManager, Composer composer, final int i3) throws Exception {
        Composer composerK = composer.k(1201695128);
        int i4 = (i3 & 6) == 0 ? (composerK.I(set) ? 4 : 2) | i3 : i3;
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(packageManager) ? 32 : 16;
        }
        int i5 = 1;
        ?? r8 = 0;
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1201695128, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.IconsRow (ConflictingSchedulesRow.kt:135)");
            }
            Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.o(Dp.g(-10)), Alignment.f25072a.l(), composerK, 6);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
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
            Updater.e(composerA, measurePolicyB, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            composerK.a0(-1419094809);
            int i6 = 0;
            for (Object obj : set) {
                int i7 = i6 + 1;
                if (i6 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str = (String) obj;
                boolean Z = composerK.Z(str);
                Object objG = composerK.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = PackageManagerHelperKt.a(packageManager, str);
                    composerK.w(objG);
                }
                Drawable drawable = (Drawable) ((Pair) objG).b();
                Modifier.Companion companion2 = Modifier.b8;
                float f3 = 3;
                Modifier modifierF2 = BorderKt.f(ZIndexModifierKt.a(SizeKt.v(companion2, Dp.g(22)), i6), Dp.g(f3), ComposeColorsKt.j(composerK, r8).e(), RoundedCornerShapeKt.a(50));
                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), r8);
                int iA2 = ComposablesKt.a(composerK, r8);
                CompositionLocalMap compositionLocalMapU2 = composerK.u();
                Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierF2);
                ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
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
                Updater.e(composerA2, modifierF3, companion3.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                SingletonAsyncImageKt.a(drawable, null, SizeKt.f(PaddingKt.i(companion2, Dp.g(f3)), 0.0f, i5, null), null, null, null, null, 0.0f, null, 0, composerK, 432, 1016);
                composerK.y();
                i6 = i7;
                r8 = 0;
                i5 = i5;
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.w2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return ConflictingSchedulesRowKt.p(set, packageManager, i3, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Set set, PackageManager packageManager, int i3, Composer composer, int i4) throws Exception {
        o(set, packageManager, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
