package cz.mobilesoft.coreblock.scene.strictmode3.confirmation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.enums.StrictModeOption;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import cz.mobilesoft.coreblock.scene.strictmode3.confirmation.ComposableSingletons$StrictModeConfirmationScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.collections.immutable.ExtensionsKt;

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
public final class ComposableSingletons$StrictModeConfirmationScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$StrictModeConfirmationScreenKt f121976a = new ComposableSingletons$StrictModeConfirmationScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f121977b = ComposableLambdaKt.c(1291042152, false, new Function2() { // from class: y1.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StrictModeConfirmationScreenKt.g((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f121978c = ComposableLambdaKt.c(-1873138519, false, new Function2() { // from class: y1.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StrictModeConfirmationScreenKt.j((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1291042152, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.confirmation.ComposableSingletons$StrictModeConfirmationScreenKt.lambda$1291042152.<anonymous> (StrictModeConfirmationScreen.kt:68)");
            }
            StrictModeConfirmationViewState strictModeConfirmationViewState = new StrictModeConfirmationViewState(StrictModeAccessMethod.Charger, new AccessMethodConfiguration.Timer(19800000L), ExtensionsKt.b(StrictModeOption.BlockRecentApps, StrictModeOption.BlockSettings, StrictModeOption.BlockUninstalling), null, null, 24, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function0() { // from class: y1.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$StrictModeConfirmationScreenKt.h();
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: y1.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$StrictModeConfirmationScreenKt.i();
                    }
                };
                composer.w(objG2);
            }
            StrictModeConfirmationScreenKt.t(strictModeConfirmationViewState, function0, (Function0) objG2, composer, 432);
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
    public static final Unit i() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1873138519, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.confirmation.ComposableSingletons$StrictModeConfirmationScreenKt.lambda$-1873138519.<anonymous> (StrictModeConfirmationScreen.kt:91)");
            }
            StrictModeConfirmationViewState strictModeConfirmationViewState = new StrictModeConfirmationViewState(StrictModeAccessMethod.SchedulesAndPin, null, ExtensionsKt.b(StrictModeOption.BlockEditing), null, null, 26, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function0() { // from class: y1.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$StrictModeConfirmationScreenKt.k();
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: y1.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$StrictModeConfirmationScreenKt.l();
                    }
                };
                composer.w(objG2);
            }
            StrictModeConfirmationScreenKt.t(strictModeConfirmationViewState, function0, (Function0) objG2, composer, 432);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l() {
        return Unit.f139807a;
    }
}
