package cz.mobilesoft.coreblock.scene.intro.stats;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.scene.intro.OnboardingViewState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

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
public final class ComposableSingletons$StatsExplanation2ScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$StatsExplanation2ScreenKt f104906a = new ComposableSingletons$StatsExplanation2ScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f104907b = ComposableLambdaKt.c(-1255645445, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.stats.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StatsExplanation2ScreenKt.g((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f104908c = ComposableLambdaKt.c(-1900333672, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.stats.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StatsExplanation2ScreenKt.i((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f104909d = ComposableLambdaKt.c(-35054719, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.stats.e
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StatsExplanation2ScreenKt.j((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1255645445, i3, -1, "cz.mobilesoft.coreblock.scene.intro.stats.ComposableSingletons$StatsExplanation2ScreenKt.lambda$-1255645445.<anonymous> (StatsExplanation2Screen.kt:50)");
            }
            OnboardingViewState onboardingViewState = new OnboardingViewState(null, null, null, 4750L, 50L, false, false, false, 231, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.stats.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$StatsExplanation2ScreenKt.h();
                    }
                };
                composer.w(objG);
            }
            StatsExplanation2ScreenKt.z(onboardingViewState, (Function0) objG, composer, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1900333672, i3, -1, "cz.mobilesoft.coreblock.scene.intro.stats.ComposableSingletons$StatsExplanation2ScreenKt.lambda$-1900333672.<anonymous> (StatsExplanation2Screen.kt:164)");
            }
            BoxKt.a(BackgroundKt.b(SizeKt.k(Modifier.b8, Dp.g(40), 0.0f, 2, null), Brush.Companion.b(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.n(ColorKt.d(4294939904L)), Color.n(ColorKt.d(4294916935L)), Color.n(ColorKt.d(4284832255L))}), 0.0f, 0.0f, 0, 14, null), null, 0.0f, 6, null), composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-35054719, i3, -1, "cz.mobilesoft.coreblock.scene.intro.stats.ComposableSingletons$StatsExplanation2ScreenKt.lambda$-35054719.<anonymous> (StatsExplanation2Screen.kt:236)");
            }
            BoxKt.a(SizeKt.k(Modifier.b8, Dp.g(40), 0.0f, 2, null), composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function2 e() {
        return f104908c;
    }

    public final Function2 f() {
        return f104909d;
    }
}
