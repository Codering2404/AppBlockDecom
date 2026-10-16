package cz.mobilesoft.coreblock.scene.strictmode3.followschedules;

import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewState;
import cz.mobilesoft.coreblock.view.compose.ThemedSnackbarHostKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.coroutines.CoroutineScope;

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
public final class ComposableSingletons$ScheduleSelectScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$ScheduleSelectScreenKt f122015a = new ComposableSingletons$ScheduleSelectScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function3 f122016b = ComposableLambdaKt.c(1159107611, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.a
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ScheduleSelectScreenKt.k((SnackbarHostState) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f122017c = ComposableLambdaKt.c(-1310003212, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ScheduleSelectScreenKt.q((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f122018d = ComposableLambdaKt.c(340607651, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ScheduleSelectScreenKt.l((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f122019e = ComposableLambdaKt.c(-1291058473, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ScheduleSelectScreenKt.o((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(SnackbarHostState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1159107611, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ComposableSingletons$ScheduleSelectScreenKt.lambda$1159107611.<anonymous> (ScheduleSelectScreen.kt:167)");
            }
            ThemedSnackbarHostKt.b(it, null, composer, i3 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(340607651, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ComposableSingletons$ScheduleSelectScreenKt.lambda$340607651.<anonymous> (ScheduleSelectScreen.kt:465)");
            }
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composer, 0, 3);
            ScheduleSelectViewState scheduleSelectViewState = new ScheduleSelectViewState(false, ExtensionsKt.b(new ScheduleSelectViewState.ScheduleDto(1L, 0, 0, "Test schedule with a very long name", true, ScheduleEmoji.Home, true, false, false, false, false, 1926, null), new ScheduleSelectViewState.ScheduleDto(2L, 0, 0, "Test2", false, ScheduleEmoji.Web, false, false, false, false, false, 1926, null)), null, null, null, false, false, 0, 221, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$ScheduleSelectScreenKt.m((ScheduleSelectViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$ScheduleSelectScreenKt.n();
                    }
                };
                composer.w(objG2);
            }
            ScheduleSelectScreenKt.E(scaffoldStateG, scheduleSelectViewState, false, function1, (Function0) objG2, composer, 28032);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(ScheduleSelectViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1291058473, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ComposableSingletons$ScheduleSelectScreenKt.lambda$-1291058473.<anonymous> (ScheduleSelectScreen.kt:496)");
            }
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composer);
                composer.w(objG);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objG;
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composer, 0, 3);
            ScheduleSelectViewState scheduleSelectViewState = new ScheduleSelectViewState(false, null, null, null, null, false, false, 0, 255, null);
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$ScheduleSelectScreenKt.p((ScheduleSelectViewEvent) obj);
                    }
                };
                composer.w(objG2);
            }
            ScheduleSelectScreenKt.u(coroutineScope, scaffoldStateG, scheduleSelectViewState, (Function1) objG2, composer, 3072);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(ScheduleSelectViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1310003212, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ComposableSingletons$ScheduleSelectScreenKt.lambda$-1310003212.<anonymous> (ScheduleSelectScreen.kt:435)");
            }
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composer, 0, 3);
            ScheduleSelectViewState scheduleSelectViewState = new ScheduleSelectViewState(false, ExtensionsKt.b(new ScheduleSelectViewState.ScheduleDto(1L, 0, 0, "Test schedule with a very long name", true, ScheduleEmoji.Home, true, false, false, false, false, 1926, null), new ScheduleSelectViewState.ScheduleDto(2L, 0, 0, "Test2", false, ScheduleEmoji.Web, false, false, false, false, false, 1926, null)), null, null, null, false, false, 0, 253, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$ScheduleSelectScreenKt.r((ScheduleSelectViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$ScheduleSelectScreenKt.s();
                    }
                };
                composer.w(objG2);
            }
            ScheduleSelectScreenKt.E(scaffoldStateG, scheduleSelectViewState, true, function1, (Function0) objG2, composer, 28032);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(ScheduleSelectViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s() {
        return Unit.f139807a;
    }

    public final Function3 j() {
        return f122016b;
    }
}
