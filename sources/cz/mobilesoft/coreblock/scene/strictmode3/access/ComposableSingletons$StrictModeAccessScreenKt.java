package cz.mobilesoft.coreblock.scene.strictmode3.access;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import cz.mobilesoft.coreblock.enums.PremiumState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposableSingletons$StrictModeAccessScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$StrictModeAccessScreenKt f121507a = new ComposableSingletons$StrictModeAccessScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f121508b = ComposableLambdaKt.c(-454089467, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StrictModeAccessScreenKt.j((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f121509c = ComposableLambdaKt.c(-1653581340, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StrictModeAccessScreenKt.g((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1653581340, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.access.ComposableSingletons$StrictModeAccessScreenKt.lambda$-1653581340.<anonymous> (StrictModeAccessScreen.kt:85)");
            }
            StrictModeAccessViewState strictModeAccessViewState = new StrictModeAccessViewState(null, null, PremiumState.Subscription.Monthly.INSTANCE, true, false, false, null, 115, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$StrictModeAccessScreenKt.h((StrictModeAccessViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$StrictModeAccessScreenKt.i();
                    }
                };
                composer.w(objG2);
            }
            StrictModeAccessScreenKt.X(strictModeAccessViewState, function1, (Function0) objG2, composer, 432);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(StrictModeAccessViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-454089467, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.access.ComposableSingletons$StrictModeAccessScreenKt.lambda$-454089467.<anonymous> (StrictModeAccessScreen.kt:73)");
            }
            StrictModeAccessViewState strictModeAccessViewState = new StrictModeAccessViewState(null, null, null, false, false, false, null, 127, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$StrictModeAccessScreenKt.k((StrictModeAccessViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$StrictModeAccessScreenKt.l();
                    }
                };
                composer.w(objG2);
            }
            StrictModeAccessScreenKt.X(strictModeAccessViewState, function1, (Function0) objG2, composer, 432);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(StrictModeAccessViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l() {
        return Unit.f139807a;
    }
}
