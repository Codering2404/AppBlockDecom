package cz.mobilesoft.coreblock.scene.dashboard.blocking.pause;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.navigation.NavHostController;
import cz.mobilesoft.coreblock.enums.PremiumState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class ComposableSingletons$PauseBlockingScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$PauseBlockingScreenKt f100091a = new ComposableSingletons$PauseBlockingScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f100092b = ComposableLambdaKt.c(-1591835962, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PauseBlockingScreenKt.i((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f100093c = ComposableLambdaKt.c(802864933, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PauseBlockingScreenKt.g((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f100094d = ComposableLambdaKt.c(-673809129, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PauseBlockingScreenKt.k((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(802864933, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.ComposableSingletons$PauseBlockingScreenKt.lambda$802864933.<anonymous> (PauseBlockingScreen.kt:81)");
            }
            PauseBlockingViewState pauseBlockingViewState = new PauseBlockingViewState(PremiumState.Lifetime.INSTANCE, null, null, null, null, 30, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$PauseBlockingScreenKt.h((PauseBlockingViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            PauseBlockingScreenKt.A(pauseBlockingViewState, (Function1) objG, new NavHostController((Context) composer.q(AndroidCompositionLocals_androidKt.g())), composer, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(PauseBlockingViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1591835962, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.ComposableSingletons$PauseBlockingScreenKt.lambda$-1591835962.<anonymous> (PauseBlockingScreen.kt:67)");
            }
            PauseBlockingViewState pauseBlockingViewState = new PauseBlockingViewState(PremiumState.None.INSTANCE, null, null, null, null, 30, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$PauseBlockingScreenKt.j((PauseBlockingViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            PauseBlockingScreenKt.A(pauseBlockingViewState, (Function1) objG, new NavHostController((Context) composer.q(AndroidCompositionLocals_androidKt.g())), composer, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(PauseBlockingViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-673809129, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.ComposableSingletons$PauseBlockingScreenKt.lambda$-673809129.<anonymous> (PauseBlockingScreen.kt:128)");
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function2 f() {
        return f100094d;
    }
}
