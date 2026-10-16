package cz.mobilesoft.coreblock.scene.streaks.detail;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBottomSheetsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StreakHelpSheetKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List f120738a = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.a(Integer.valueOf(R.string.bB), Integer.valueOf(R.string.WA)), TuplesKt.a(Integer.valueOf(R.string.cB), Integer.valueOf(R.string.XA)), TuplesKt.a(Integer.valueOf(R.string.dB), Integer.valueOf(R.string.YA)), TuplesKt.a(Integer.valueOf(R.string.eB), Integer.valueOf(R.string.ZA)), TuplesKt.a(Integer.valueOf(R.string.fB), Integer.valueOf(R.string.aB))});

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Composer composer, final int i3) {
        Composer composerK = composer.k(-1083228209);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1083228209, i3, -1, "cz.mobilesoft.coreblock.scene.streaks.detail.StreakHelpContent (StreakHelpSheet.kt:41)");
            }
            float f3 = 16;
            Modifier modifierM = PaddingKt.m(PaddingKt.k(ScrollKt.g(Modifier.b8, ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null), Dp.g(f3), 0.0f, 2, null), 0.0f, Dp.g(24), 0.0f, Dp.g(f3), 5, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.o(Dp.g(36)), Alignment.f25072a.k(), composerK, 6);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            composerK.a0(-1879928343);
            for (Pair pair : f120738a) {
                f(((Number) pair.a()).intValue(), ((Number) pair.b()).intValue(), composerK, 0);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.a1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreakHelpSheetKt.e(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(int i3, Composer composer, int i4) {
        d(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void f(final int i3, final int i4, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer composerK = composer.k(-2034427211);
        if ((i5 & 6) == 0) {
            i6 = i5 | (composerK.e(i3) ? 4 : 2);
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= composerK.e(i4) ? 32 : 16;
        }
        int i7 = i6;
        if (composerK.r((i7 & 19) != 18, i7 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2034427211, i7, -1, "cz.mobilesoft.coreblock.scene.streaks.detail.StreakHelpSection (StreakHelpSheet.kt:59)");
            }
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = arrangement.o(Dp.g(14));
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Vertical verticalL = companion.l();
            Modifier.Companion companion2 = Modifier.b8;
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalO, verticalL, composerK, 54);
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
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            IconKt.d(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.L5, composerK, 6), null, SizeKt.v(companion2, Dp.g(24)), Color.f25715b.k(), composerK, 3504, 0);
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.o(Dp.g(10)), companion.k(), composerK, 6);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, companion2);
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
            String strB = StringResources_androidKt.b(i3, composerK, i7 & 14);
            MaterialTheme materialTheme = MaterialTheme.f13091a;
            int i8 = MaterialTheme.f13092b;
            composer2 = composerK;
            TextKt.c(strB, null, ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, materialTheme.c(composerK, i8).g(), composer2, 0, 0, 65530);
            TextKt.c(StringResources_androidKt.b(i4, composer2, (i7 >> 3) & 14), null, ComposeColorsKt.j(composer2, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, materialTheme.c(composer2, i8).b(), composer2, 0, 0, 65530);
            composer2.y();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.b1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreakHelpSheetKt.g(i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(int i3, int i4, int i5, Composer composer, int i6) {
        f(i3, i4, composer, RecomposeScopeImplKt.a(i5 | 1));
        return Unit.f139807a;
    }

    public static final void h(Function0 onDismiss, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerK = composer.k(981546037);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onDismiss) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(981546037, i4, -1, "cz.mobilesoft.coreblock.scene.streaks.detail.StreakHelpSheet (StreakHelpSheet.kt:31)");
            }
            function0 = onDismiss;
            ComposeBottomSheetsKt.f(null, null, true, ComposableSingletons$StreakHelpSheetKt.f120662a.c(), null, function0, composerK, ((i4 << 15) & 458752) | 3456, 19);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onDismiss;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.c1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreakHelpSheetKt.i(function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Function0 function0, int i3, Composer composer, int i4) {
        h(function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
