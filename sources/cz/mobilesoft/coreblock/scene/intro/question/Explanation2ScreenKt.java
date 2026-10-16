package cz.mobilesoft.coreblock.scene.intro.question;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import cz.mobilesoft.coreblock.R;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class Explanation2ScreenKt {
    public static final void c(final float f3, final long j3, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1068519150);
        if ((i3 & 6) == 0) {
            i4 = (composerK.c(f3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.f(j3) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1068519150, i4, -1, "cz.mobilesoft.coreblock.scene.intro.question.AnimatedCircle (Explanation2Screen.kt:106)");
            }
            SurfaceKt.a(SizeKt.o(Modifier.b8, f3), RoundedCornerShapeKt.g(), j3, 0L, null, 0.0f, ComposableSingletons$Explanation2ScreenKt.f104670a.h(), composerK, ((i4 << 3) & 896) | 1572864, 56);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.question.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Explanation2ScreenKt.d(f3, j3, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(float f3, long j3, int i3, Composer composer, int i4) {
        c(f3, j3, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void e(Function0 onContinueClicked, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(onContinueClicked, "onContinueClicked");
        Composer composerK = composer.k(-227033451);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onContinueClicked) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-227033451, i4, -1, "cz.mobilesoft.coreblock.scene.intro.question.Explanation2Screen (Explanation2Screen.kt:42)");
            }
            function0 = onContinueClicked;
            ExplanationScreenKt.e(StringResources_androidKt.c(R.string.jm, new Object[]{StringResources_androidKt.b(R.string.f95790f1, composerK, 0)}, composerK, 0), StringResources_androidKt.b(R.string.im, composerK, 0), null, function0, null, ComposableSingletons$Explanation2ScreenKt.f104670a.i(), composerK, ((i4 << 9) & 7168) | 196608, 20);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onContinueClicked;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.question.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Explanation2ScreenKt.f(function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Function0 function0, int i3, Composer composer, int i4) {
        e(function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
