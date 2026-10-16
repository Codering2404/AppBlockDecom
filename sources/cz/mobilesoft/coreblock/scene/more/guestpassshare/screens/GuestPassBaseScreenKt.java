package cz.mobilesoft.coreblock.scene.more.guestpassshare.screens;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.scene.more.guestpassshare.screens.GuestPassBaseScreenKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class GuestPassBaseScreenKt {
    public static final void b(final String title, String subtitle, Function2 content, Composer composer, final int i3) {
        int i4;
        final String str;
        final Function2 function2;
        Composer composer2;
        Modifier modifier;
        Modifier modifierK;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerK = composer.k(1862860176);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(title) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(subtitle) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(content) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1862860176, i4, -1, "cz.mobilesoft.coreblock.scene.more.guestpassshare.screens.GuestPassBaseScreen (GuestPassBaseScreen.kt:26)");
            }
            long jA = ((WindowInfo) composerK.q(CompositionLocalsKt.u())).a();
            int i5 = (int) (jA & 4294967295L);
            float F = ((Density) composerK.q(CompositionLocalsKt.f())).F(i5);
            boolean z2 = ((int) (jA >> 32)) > i5;
            Modifier modifier2 = Modifier.b8;
            Modifier modifierF = SizeKt.f(modifier2, 0.0f, 1, null);
            if (z2) {
                modifier = modifier2;
                composerK.a0(-792717128);
                composerK.U();
            } else {
                composerK.a0(-792718475);
                Modifier modifierG = ScrollKt.g(modifier2, ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null);
                modifier = modifier2;
                composerK.U();
                modifier2 = modifierG;
            }
            Modifier modifierK2 = PaddingKt.k(modifierF.then(modifier2), Dp.g(24), 0.0f, 2, null);
            Alignment.Companion companion = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion.g(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierK2);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextStyle textStyleF = ComposeTypographyKt.g(composerK, 0).f();
            long jP = ComposeColorsKt.j(composerK, 0).p();
            TextAlign.Companion companion3 = TextAlign.f29616b;
            int i6 = i4;
            TextKt.c(title, null, jP, 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, textStyleF, composerK, i4 & 14, 0, 65018);
            str = subtitle;
            TextKt.c(str, PaddingKt.m(modifier, 0.0f, Dp.g(16), 0.0f, 0.0f, 13, null), ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composerK, ((i6 >> 3) & 14) | 48, 0, 65016);
            composer2 = composerK;
            Modifier modifier3 = modifier;
            Modifier modifierH = SizeKt.h(modifier3, 0.0f, 1, null);
            if (z2) {
                modifierK = ColumnScope.b(columnScopeInstance, modifier3, 1.0f, false, 2, null);
                modifier3 = modifier3;
            } else {
                modifierK = SizeKt.k(modifier3, Dp.g(F * 0.55f), 0.0f, 2, null);
            }
            Modifier modifierThen = modifierH.then(modifierK);
            MeasurePolicy measurePolicyG = BoxKt.g(companion.e(), false);
            int iA2 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU2 = composer2.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer2, modifierThen);
            Function0 function0A2 = companion2.a();
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
            Updater.e(composerA2, measurePolicyG, companion2.e());
            Updater.e(composerA2, compositionLocalMapU2, companion2.g());
            Function2 function2B2 = companion2.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF3, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            if (z2) {
                composer2.a0(-2107900493);
                Modifier modifierE = SizeKt.e(modifier3, 0.5f);
                MeasurePolicy measurePolicyG2 = BoxKt.g(companion.e(), false);
                int iA3 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU3 = composer2.u();
                Modifier modifierF4 = ComposedModifierKt.f(composer2, modifierE);
                Function0 function0A3 = companion2.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A3);
                } else {
                    composer2.v();
                }
                Composer composerA3 = Updater.a(composer2);
                Updater.e(composerA3, measurePolicyG2, companion2.e());
                Updater.e(composerA3, compositionLocalMapU3, companion2.g());
                Function2 function2B3 = companion2.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF4, companion2.f());
                function2 = content;
                function2.invoke(composer2, Integer.valueOf((i6 >> 6) & 14));
                composer2.y();
                composer2.U();
            } else {
                function2 = content;
                composer2.a0(-2107897955);
                function2.invoke(composer2, Integer.valueOf((i6 >> 6) & 14));
                composer2.U();
            }
            composer2.y();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            str = subtitle;
            function2 = content;
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: b1.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GuestPassBaseScreenKt.c(title, str, function2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(String str, String str2, Function2 function2, int i3, Composer composer, int i4) {
        b(str, str2, function2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
