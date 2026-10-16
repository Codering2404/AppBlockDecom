package cz.mobilesoft.coreblock.scene.schedule.blockingmode;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
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
public final class ComposableSingletons$BlockingModeSettingsScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$BlockingModeSettingsScreenKt f115085a = new ComposableSingletons$BlockingModeSettingsScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f115086b = ComposableLambdaKt.c(102638363, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.y
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BlockingModeSettingsScreenKt.j((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f115087c = ComposableLambdaKt.c(141998284, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.z
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BlockingModeSettingsScreenKt.m((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f115088d = ComposableLambdaKt.c(1717291703, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.a0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BlockingModeSettingsScreenKt.p((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(102638363, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.blockingmode.ComposableSingletons$BlockingModeSettingsScreenKt.lambda$102638363.<anonymous> (BlockingModeSettingsScreen.kt:79)");
            }
            PaddingValues paddingValuesC = PaddingKt.c(0.0f, 0.0f, 3, null);
            BlockingModeSettingsViewState blockingModeSettingsViewState = new BlockingModeSettingsViewState(null, false, false, null, null, false, null, 127, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.b0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$BlockingModeSettingsScreenKt.k();
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.c0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$BlockingModeSettingsScreenKt.l((BlockingModeSettingsViewEvent) obj);
                    }
                };
                composer.w(objG2);
            }
            BlockingModeSettingsScreenKt.P(paddingValuesC, blockingModeSettingsViewState, function0, (Function1) objG2, composer, 3462);
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
    public static final Unit l(BlockingModeSettingsViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(141998284, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.blockingmode.ComposableSingletons$BlockingModeSettingsScreenKt.lambda$141998284.<anonymous> (BlockingModeSettingsScreen.kt:92)");
            }
            PaddingValues paddingValuesC = PaddingKt.c(0.0f, 0.0f, 3, null);
            BlockingModeSettingsViewState blockingModeSettingsViewState = new BlockingModeSettingsViewState(null, false, false, null, null, false, null, 127, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.f0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$BlockingModeSettingsScreenKt.n();
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.g0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$BlockingModeSettingsScreenKt.o((BlockingModeSettingsViewEvent) obj);
                    }
                };
                composer.w(objG2);
            }
            BlockingModeSettingsScreenKt.P(paddingValuesC, blockingModeSettingsViewState, function0, (Function1) objG2, composer, 3462);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(BlockingModeSettingsViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1717291703, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.blockingmode.ComposableSingletons$BlockingModeSettingsScreenKt.lambda$1717291703.<anonymous> (BlockingModeSettingsScreen.kt:105)");
            }
            PaddingValues paddingValuesC = PaddingKt.c(0.0f, 0.0f, 3, null);
            BlockingModeSettingsViewState blockingModeSettingsViewState = new BlockingModeSettingsViewState(null, false, false, null, PremiumState.Subscription.Yearly.INSTANCE, false, null, 111, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.d0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$BlockingModeSettingsScreenKt.q();
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.e0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$BlockingModeSettingsScreenKt.r((BlockingModeSettingsViewEvent) obj);
                    }
                };
                composer.w(objG2);
            }
            BlockingModeSettingsScreenKt.P(paddingValuesC, blockingModeSettingsViewState, function0, (Function1) objG2, composer, 3462);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(BlockingModeSettingsViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }
}
