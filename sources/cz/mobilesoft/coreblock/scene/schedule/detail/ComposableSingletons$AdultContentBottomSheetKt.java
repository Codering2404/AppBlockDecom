package cz.mobilesoft.coreblock.scene.schedule.detail;

import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent;
import cz.mobilesoft.coreblock.util.AdultContentDownloadWorker;
import cz.mobilesoft.coreblock.util.FailedWithError;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.Success;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
public final class ComposableSingletons$AdultContentBottomSheetKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$AdultContentBottomSheetKt f116504a = new ComposableSingletons$AdultContentBottomSheetKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f116505b = ComposableLambdaKt.c(1828600028, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.r0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AdultContentBottomSheetKt.k((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f116506c = ComposableLambdaKt.c(1216538168, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.s0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AdultContentBottomSheetKt.i((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f116507d = ComposableLambdaKt.c(1981027221, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.t0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AdultContentBottomSheetKt.m((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f116508e = ComposableLambdaKt.c(1993371632, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.u0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AdultContentBottomSheetKt.o((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1216538168, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ComposableSingletons$AdultContentBottomSheetKt.lambda$1216538168.<anonymous> (AdultContentBottomSheet.kt:75)");
            }
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composer);
                composer.w(objG);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objG;
            ScheduleViewState scheduleViewState = new ScheduleViewState(null, new AdultContentDownloadWorker.AdultContentSyncState(Loading.f127895a, 0.0f, 2, null), false, null, false, false, false, false, null, null, null, null, null, false, null, null, PremiumState.Subscription.Yearly.INSTANCE, 65533, null);
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.w0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$AdultContentBottomSheetKt.j((ScheduleViewEvent) obj);
                    }
                };
                composer.w(objG2);
            }
            AdultContentBottomSheetKt.d(coroutineScope, scheduleViewState, (Function1) objG2, ModalBottomSheetKt.j(ModalBottomSheetValue.Expanded, null, null, false, composer, 6, 14), composer, (ModalBottomSheetState.f13222e << 9) | 384);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(ScheduleViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1828600028, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ComposableSingletons$AdultContentBottomSheetKt.lambda$1828600028.<anonymous> (AdultContentBottomSheet.kt:59)");
            }
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composer);
                composer.w(objG);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objG;
            ScheduleViewState scheduleViewState = new ScheduleViewState(null, null, false, null, false, false, false, false, null, null, null, null, null, false, null, null, PremiumState.Subscription.Yearly.INSTANCE, 65535, null);
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.x0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$AdultContentBottomSheetKt.l((ScheduleViewEvent) obj);
                    }
                };
                composer.w(objG2);
            }
            AdultContentBottomSheetKt.d(coroutineScope, scheduleViewState, (Function1) objG2, ModalBottomSheetKt.j(ModalBottomSheetValue.Expanded, null, null, false, composer, 6, 14), composer, (ModalBottomSheetState.f13222e << 9) | 384);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(ScheduleViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1981027221, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ComposableSingletons$AdultContentBottomSheetKt.lambda$1981027221.<anonymous> (AdultContentBottomSheet.kt:92)");
            }
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composer);
                composer.w(objG);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objG;
            ScheduleViewState scheduleViewState = new ScheduleViewState(null, new AdultContentDownloadWorker.AdultContentSyncState(Success.f128020a, 0.0f, 2, null), false, null, false, false, false, false, null, null, null, null, null, false, null, null, PremiumState.Subscription.Yearly.INSTANCE, 65533, null);
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.v0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$AdultContentBottomSheetKt.n((ScheduleViewEvent) obj);
                    }
                };
                composer.w(objG2);
            }
            AdultContentBottomSheetKt.d(coroutineScope, scheduleViewState, (Function1) objG2, ModalBottomSheetKt.j(ModalBottomSheetValue.Expanded, null, null, false, composer, 6, 14), composer, (ModalBottomSheetState.f13222e << 9) | 384);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(ScheduleViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1993371632, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ComposableSingletons$AdultContentBottomSheetKt.lambda$1993371632.<anonymous> (AdultContentBottomSheet.kt:109)");
            }
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composer);
                composer.w(objG);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objG;
            ScheduleViewState scheduleViewState = new ScheduleViewState(null, new AdultContentDownloadWorker.AdultContentSyncState(new FailedWithError(null, null, null, null, 15, null), 0.0f, 2, null), false, null, false, false, false, false, null, null, null, null, null, false, null, null, PremiumState.Subscription.Yearly.INSTANCE, 65533, null);
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.y0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$AdultContentBottomSheetKt.p((ScheduleViewEvent) obj);
                    }
                };
                composer.w(objG2);
            }
            AdultContentBottomSheetKt.d(coroutineScope, scheduleViewState, (Function1) objG2, ModalBottomSheetKt.j(ModalBottomSheetValue.Expanded, null, null, false, composer, 6, 14), composer, (ModalBottomSheetState.f13222e << 9) | 384);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(ScheduleViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }
}
