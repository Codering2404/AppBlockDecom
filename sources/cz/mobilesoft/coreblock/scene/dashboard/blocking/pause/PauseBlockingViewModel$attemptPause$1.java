package cz.mobilesoft.coreblock.scene.dashboard.blocking.pause;

import cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewState;
import cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel$attemptPause$1", f = "PauseBlockingViewModel.kt", l = {164, 162}, m = "invokeSuspend", v = 1)
final class PauseBlockingViewModel$attemptPause$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f100135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f100136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f100137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f100138d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f100139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ PauseBlockingViewModel f100140g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ PauseBlockingViewState.PauseBlockingType f100141h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PauseBlockingViewModel$attemptPause$1(PauseBlockingViewModel pauseBlockingViewModel, PauseBlockingViewState.PauseBlockingType pauseBlockingType, Continuation continuation) {
        super(1, continuation);
        this.f100140g = pauseBlockingViewModel;
        this.f100141h = pauseBlockingType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PauseBlockingViewState q(StreakEvaluator.PauseRisk pauseRisk, PauseBlockingViewState.PauseBlockingType pauseBlockingType, PauseBlockingViewState pauseBlockingViewState) {
        return PauseBlockingViewState.b(pauseBlockingViewState, null, null, null, null, new PauseBlockingViewState.StreakPauseWarning(pauseRisk, pauseBlockingType), 15, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new PauseBlockingViewModel$attemptPause$1(this.f100140g, this.f100141h, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x008d, code lost:
    
        if (r0 == r10) goto L23;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r16) throws java.lang.Throwable {
        /*
            r15 = this;
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r0 = r15.f100139f
            r11 = 0
            r7 = 2
            r1 = 1
            if (r0 == 0) goto L39
            if (r0 == r1) goto L25
            if (r0 != r7) goto L1d
            java.lang.Object r0 = r15.f100135a
            cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel r0 = (cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel) r0
            kotlin.ResultKt.b(r16)     // Catch: java.lang.Throwable -> L1a
            r0 = r16
            goto L90
        L1a:
            r0 = move-exception
            goto L97
        L1d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L25:
            long r0 = r15.f100138d
            int r2 = r15.f100137c
            java.lang.Object r3 = r15.f100136b
            cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator r3 = (cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator) r3
            java.lang.Object r5 = r15.f100135a
            cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel r5 = (cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel) r5
            kotlin.ResultKt.b(r16)     // Catch: java.lang.Throwable -> L1a
            r14 = r2
            r1 = r0
            r0 = r16
            goto L6d
        L39:
            kotlin.ResultKt.b(r16)
            cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel r8 = r15.f100140g
            cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewState$PauseBlockingType r0 = r15.f100141h
            kotlin.Result$Companion r2 = kotlin.Result.f139772b     // Catch: java.lang.Throwable -> L1a
            cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator r9 = cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel.c1(r8)     // Catch: java.lang.Throwable -> L1a
            long r12 = cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel.f1(r8, r0)     // Catch: java.lang.Throwable -> L1a
            cz.mobilesoft.coreblock.scene.streaks.StreakStore r0 = cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel.e1(r8)     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)     // Catch: java.lang.Throwable -> L1a
            r15.f100135a = r2     // Catch: java.lang.Throwable -> L1a
            r15.f100136b = r9     // Catch: java.lang.Throwable -> L1a
            r14 = 0
            r15.f100137c = r14     // Catch: java.lang.Throwable -> L1a
            r15.f100138d = r12     // Catch: java.lang.Throwable -> L1a
            r15.f100139f = r1     // Catch: java.lang.Throwable -> L1a
            r1 = 0
            r3 = 0
            r5 = 3
            r6 = 0
            r4 = r15
            java.lang.Object r0 = cz.mobilesoft.coreblock.scene.streaks.StreakStore.f(r0, r1, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L1a
            if (r0 != r10) goto L6a
            goto L8f
        L6a:
            r5 = r8
            r3 = r9
            r1 = r12
        L6d:
            cz.mobilesoft.coreblock.scene.streaks.StreakState r0 = (cz.mobilesoft.coreblock.scene.streaks.StreakState) r0     // Catch: java.lang.Throwable -> L1a
            cz.mobilesoft.coreblock.scene.streaks.StreakStats r0 = r0.d()     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)     // Catch: java.lang.Throwable -> L1a
            r15.f100135a = r5     // Catch: java.lang.Throwable -> L1a
            r15.f100136b = r11     // Catch: java.lang.Throwable -> L1a
            r15.f100137c = r14     // Catch: java.lang.Throwable -> L1a
            r15.f100139f = r7     // Catch: java.lang.Throwable -> L1a
            r4 = 0
            r6 = 0
            r8 = 12
            r9 = 0
            r7 = r3
            r3 = r0
            r0 = r7
            r7 = r15
            java.lang.Object r0 = cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator.g(r0, r1, r3, r4, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L1a
            if (r0 != r10) goto L90
        L8f:
            return r10
        L90:
            cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$PauseRisk r0 = (cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator.PauseRisk) r0     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r0 = kotlin.Result.b(r0)     // Catch: java.lang.Throwable -> L1a
            goto La1
        L97:
            kotlin.Result$Companion r1 = kotlin.Result.f139772b
            java.lang.Object r0 = kotlin.ResultKt.a(r0)
            java.lang.Object r0 = kotlin.Result.b(r0)
        La1:
            boolean r1 = kotlin.Result.g(r0)
            if (r1 == 0) goto La8
            goto La9
        La8:
            r11 = r0
        La9:
            cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$PauseRisk r11 = (cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator.PauseRisk) r11
            if (r11 != 0) goto Lb7
            cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel r0 = r15.f100140g
            cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewState$PauseBlockingType r1 = r15.f100141h
            cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel.g1(r0, r1)
            kotlin.Unit r0 = kotlin.Unit.f139807a
            return r0
        Lb7:
            cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel r0 = r15.f100140g
            cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewState$PauseBlockingType r1 = r15.f100141h
            cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.q0 r2 = new cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.q0
            r2.<init>()
            cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel.i1(r0, r2)
            kotlin.Unit r0 = kotlin.Unit.f139807a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel$attemptPause$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((PauseBlockingViewModel$attemptPause$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
