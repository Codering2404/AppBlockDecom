package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class SplashContentKt {
    public static final void c(String text, final boolean z2, Composer composer, final int i3, final int i4) {
        int i5;
        final String str;
        Composer composer2;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerK = composer.k(-529194149);
        if ((i3 & 6) == 0) {
            i5 = (composerK.Z(text) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i6 = i4 & 2;
        if (i6 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.b(z2) ? 32 : 16;
        }
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (i6 != 0) {
                z2 = true;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-529194149, i5, -1, "cz.mobilesoft.coreblock.view.compose.SplashAnimated (SplashContent.kt:41)");
            }
            TweenSpec tweenSpecN = AnimationSpecKt.n(500, 0, EasingKt.d(), 2, null);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = PrimitiveSnapshotStateKt.a(0.0f);
                composerK.w(objG);
            }
            MutableFloatState mutableFloatState = (MutableFloatState) objG;
            State stateD = AnimateAsStateKt.d(d(mutableFloatState), tweenSpecN, 0.0f, "FeaturesOverviewScreenAlpha", null, composerK, 3072, 20);
            Unit unit = Unit.f139807a;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = new SplashContentKt$SplashAnimated$1$1(mutableFloatState, null);
                composerK.w(objG2);
            }
            EffectsKt.g(unit, (Function2) objG2, composerK, 6);
            str = text;
            boolean z3 = z2;
            h(f(stateD), str, z3, composerK, (i5 << 3) & 1008, 0);
            composer2 = composerK;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            z2 = z3;
        } else {
            str = text;
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.eb
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SplashContentKt.g(str, z2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float d(MutableFloatState mutableFloatState) {
        return mutableFloatState.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(MutableFloatState mutableFloatState, float f3) {
        mutableFloatState.s(f3);
    }

    private static final float f(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(String str, boolean z2, int i3, int i4, Composer composer, int i5) {
        c(str, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void h(final float r31, final java.lang.String r32, boolean r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instruction units count: 405
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.SplashContentKt.h(float, java.lang.String, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(float f3, String str, boolean z2, int i3, int i4, Composer composer, int i5) {
        h(f3, str, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
