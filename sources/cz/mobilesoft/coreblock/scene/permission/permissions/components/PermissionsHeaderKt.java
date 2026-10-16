package cz.mobilesoft.coreblock.scene.permission.permissions.components;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.MaterialTheme;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.permission.permissions.components.PermissionsHeaderKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.material3.CardsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class PermissionsHeaderKt {
    public static final void d(boolean z2, final String title, final String str, final AnnotatedString description, Composer composer, final int i3, final int i4) {
        boolean z3;
        int i5;
        final boolean z4;
        Modifier.Companion companion;
        Object obj;
        int i6;
        float f3;
        int i7;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Composer composerK = composer.k(-958417993);
        int i8 = i4 & 1;
        if (i8 != 0) {
            i5 = i3 | 6;
            z3 = z2;
        } else if ((i3 & 6) == 0) {
            z3 = z2;
            i5 = (composerK.b(z3) ? 4 : 2) | i3;
        } else {
            z3 = z2;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(title) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.Z(str) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.Z(description) ? 2048 : 1024;
        }
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            boolean z5 = i8 != 0 ? false : z3;
            if (ComposerKt.M()) {
                ComposerKt.U(-958417993, i5, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.components.PermissionsHeader (PermissionsHeader.kt:47)");
            }
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion2, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.g(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
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
            float f4 = 8;
            int i9 = i5;
            ImageKt.a(PainterResources_androidKt.c(z5 ? R.drawable.f4 : R.drawable.g4, composerK, 0), null, PaddingKt.k(companion2, 0.0f, Dp.g(f4), 1, null), null, null, 0.0f, null, composerK, 432, 120);
            Modifier modifierK = PaddingKt.k(companion2, 0.0f, Dp.g(f4), 1, null);
            TextAlign.Companion companion4 = TextAlign.f29616b;
            int iA2 = companion4.a();
            MaterialTheme materialTheme = MaterialTheme.f13091a;
            int i10 = MaterialTheme.f13092b;
            TextKt.c(title, modifierK, ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(iA2), 0L, 0, false, 0, 0, null, materialTheme.c(composerK, i10).f(), composerK, ((i9 >> 3) & 14) | 48, 0, 65016);
            if (str == null) {
                composerK.a0(1787100432);
                composerK.U();
                companion = companion2;
                i7 = 0;
                obj = null;
                i6 = 1;
                f3 = 0.0f;
            } else {
                composerK.a0(1787100433);
                companion = companion2;
                obj = null;
                i6 = 1;
                f3 = 0.0f;
                i7 = 0;
                CardsKt.k(SizeKt.I(SizeKt.E(PaddingKt.k(companion, 0.0f, Dp.g(4), 1, null), null, false, 3, null), null, false, 3, null), ComposeColorsKt.j(composerK, 0).c(), 0.0f, RoundedCornerShapeKt.g(), null, ComposableLambdaKt.e(-440338398, true, new Function3() { // from class: h1.s
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return PermissionsHeaderKt.g(str, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerK, 54), composerK, 196614, 20);
                composerK.U();
            }
            TextKt.d(description, PaddingKt.k(companion, f3, Dp.g(f4), i6, obj), ComposeColorsKt.j(composerK, i7).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, null, materialTheme.c(composerK, i10).b(), composerK, ((i9 >> 9) & 14) | 48, 0, 130552);
            composerK = composerK;
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            z4 = z5;
        } else {
            composerK.Q();
            z4 = z3;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: h1.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return PermissionsHeaderKt.h(z4, title, str, description, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    public static final void e(boolean z2, final String title, final String str, final String description, Composer composer, final int i3, final int i4) {
        int i5;
        final boolean z3;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Composer composerK = composer.k(89879805);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(title) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.Z(str) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.Z(description) ? 2048 : 1024;
        }
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            boolean z4 = i6 != 0 ? false : z2;
            if (ComposerKt.M()) {
                ComposerKt.U(89879805, i5, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.components.PermissionsHeader (PermissionsHeader.kt:32)");
            }
            d(z4, title, str, new AnnotatedString(description, null, 2, null), composerK, i5 & 1022, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            z3 = z4;
        } else {
            composerK.Q();
            z3 = z2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: h1.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PermissionsHeaderKt.f(z3, title, str, description, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(boolean z2, String str, String str2, String str3, int i3, int i4, Composer composer, int i5) {
        e(z2, str, str2, str3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(String str, ColumnScope BaseCard, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-440338398, i3, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.components.PermissionsHeader.<anonymous>.<anonymous>.<anonymous> (PermissionsHeader.kt:77)");
            }
            Modifier modifierK = PaddingKt.k(PaddingKt.k(Modifier.b8, Dp.g(12), 0.0f, 2, null), 0.0f, Dp.g(8), 1, null);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            TextKt.c(str, null, ComposeColorsKt.j(composer, 0).b(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composer, MaterialTheme.f13092b).h(), composer, 0, 0, 65018);
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
    public static final Unit h(boolean z2, String str, String str2, AnnotatedString annotatedString, int i3, int i4, Composer composer, int i5) {
        d(z2, str, str2, annotatedString, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
