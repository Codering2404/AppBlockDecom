package cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
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
public final class ComposableSingletons$OnboardingBlockingTestScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$OnboardingBlockingTestScreenKt f111072a = new ComposableSingletons$OnboardingBlockingTestScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function3 f111073b = ComposableLambdaKt.c(187468390, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.a
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$OnboardingBlockingTestScreenKt.j((AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function3 f111074c = ComposableLambdaKt.c(-2037939121, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.b
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$OnboardingBlockingTestScreenKt.l((AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function4 f111075d = ComposableLambdaKt.c(1021106033, false, new Function4() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.c
        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return ComposableSingletons$OnboardingBlockingTestScreenKt.i((AnimatedContentScope) obj, (String) obj2, (Composer) obj3, ((Integer) obj4).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function3 f111076e = ComposableLambdaKt.c(467525880, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.d
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$OnboardingBlockingTestScreenKt.k((AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(AnimatedContentScope AnimatedContent, String text, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
        Intrinsics.checkNotNullParameter(text, "text");
        if (ComposerKt.M()) {
            ComposerKt.U(1021106033, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.ComposableSingletons$OnboardingBlockingTestScreenKt.lambda$1021106033.<anonymous> (OnboardingBlockingTestScreen.kt:310)");
        }
        TextStyle textStyleF = ComposeTypographyKt.g(composer, 0).f();
        TextKt.c(text, SizeKt.h(Modifier.b8, 0.0f, 1, null), ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, textStyleF, composer, ((i3 >> 3) & 14) | 48, 0, 65016);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(187468390, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.ComposableSingletons$OnboardingBlockingTestScreenKt.lambda$187468390.<anonymous> (OnboardingBlockingTestScreen.kt:245)");
        }
        TextKt.c(StringResources_androidKt.b(R.string.zl, composer, 0), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65530);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(467525880, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.ComposableSingletons$OnboardingBlockingTestScreenKt.lambda$467525880.<anonymous> (OnboardingBlockingTestScreen.kt:574)");
        }
        ImageKt.a(PainterResources_androidKt.c(R.drawable.bb, composer, 0), null, SizeKt.x(Modifier.b8, Dp.g(40), Dp.g(164)), null, null, 0.0f, null, composer, 432, 120);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(-2037939121, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.ComposableSingletons$OnboardingBlockingTestScreenKt.lambda$-2037939121.<anonymous> (OnboardingBlockingTestScreen.kt:258)");
        }
        TextKt.c(StringResources_androidKt.b(R.string.am, composer, 0), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65530);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    public final Function3 e() {
        return f111074c;
    }

    public final Function4 f() {
        return f111075d;
    }

    public final Function3 g() {
        return f111073b;
    }

    public final Function3 h() {
        return f111076e;
    }
}
