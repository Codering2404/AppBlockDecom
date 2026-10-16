package cz.mobilesoft.coreblock.scene.intro.stats;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.res.StringResources_androidKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.onboarding.statistics.StatsQuestionScreenKt;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class StatsQuestion2ScreenKt {
    public static final void c(Function1 onContinueClicked, Composer composer, final int i3) {
        int i4;
        final Function1 function1;
        Intrinsics.checkNotNullParameter(onContinueClicked, "onContinueClicked");
        Composer composerK = composer.k(-340654329);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onContinueClicked) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-340654329, i4, -1, "cz.mobilesoft.coreblock.scene.intro.stats.StatsQuestion2Screen (StatsQuestion2Screen.kt:20)");
            }
            function1 = onContinueClicked;
            StatsQuestionScreenKt.n(StringResources_androidKt.b(R.string.bm, composerK, 0), RangesKt.b(0.0f, 300.0f), new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.stats.c0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StatsQuestion2ScreenKt.d(((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, function1, null, composerK, (i4 << 9) & 7168, 16);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function1 = onContinueClicked;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.stats.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatsQuestion2ScreenKt.e(function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String d(float f3, Composer composer, int i3) {
        composer.a0(1302017962);
        if (ComposerKt.M()) {
            ComposerKt.U(1302017962, i3, -1, "cz.mobilesoft.coreblock.scene.intro.stats.StatsQuestion2Screen.<anonymous> (StatsQuestion2Screen.kt:25)");
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str = String.format(Locale.getDefault(), "%d×", Arrays.copyOf(new Object[]{Integer.valueOf(MathKt.d(f3))}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Function1 function1, int i3, Composer composer, int i4) {
        c(function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
