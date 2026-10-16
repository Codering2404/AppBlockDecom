package cz.mobilesoft.coreblock.scene.app_feel;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NavBackStackEntry;
import cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelEmptyScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ComposableSingletons$AppFeelActivityKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$AppFeelActivityKt f98622a = new ComposableSingletons$AppFeelActivityKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f98623b = ComposableLambdaKt.c(1155414834, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.app_feel.c0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AppFeelActivityKt.f((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function4 f98624c = ComposableLambdaKt.c(485594257, false, new Function4() { // from class: cz.mobilesoft.coreblock.scene.app_feel.d0
        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return ComposableSingletons$AppFeelActivityKt.g((AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1155414834, i3, -1, "cz.mobilesoft.coreblock.scene.app_feel.ComposableSingletons$AppFeelActivityKt.lambda$1155414834.<anonymous> (AppFeelActivity.kt:76)");
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(485594257, i3, -1, "cz.mobilesoft.coreblock.scene.app_feel.ComposableSingletons$AppFeelActivityKt.lambda$485594257.<anonymous> (AppFeelActivity.kt:127)");
        }
        Object objG = composer.G();
        if (objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.e0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ComposableSingletons$AppFeelActivityKt.h();
                }
            };
            composer.w(objG);
        }
        BackHandlerKt.a(false, (Function0) objG, composer, 48, 1);
        AppFeelEmptyScreenKt.b(composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h() {
        return Unit.f139807a;
    }

    public final Function2 d() {
        return f98623b;
    }

    public final Function4 e() {
        return f98624c;
    }
}
