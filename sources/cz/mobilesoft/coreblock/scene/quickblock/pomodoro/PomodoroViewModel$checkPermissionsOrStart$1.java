package cz.mobilesoft.coreblock.scene.quickblock.pomodoro;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel$checkPermissionsOrStart$1", f = "PomodoroViewModel.kt", l = {149, 157}, m = "invokeSuspend", v = 1)
final class PomodoroViewModel$checkPermissionsOrStart$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f114093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f114094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PomodoroViewModel f114095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f114096d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f114097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ int f114098g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PomodoroViewModel$checkPermissionsOrStart$1(PomodoroViewModel pomodoroViewModel, long j3, long j4, int i3, Continuation continuation) {
        super(1, continuation);
        this.f114095c = pomodoroViewModel;
        this.f114096d = j3;
        this.f114097f = j4;
        this.f114098g = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new PomodoroViewModel$checkPermissionsOrStart$1(this.f114095c, this.f114096d, this.f114097f, this.f114098g, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0062, code lost:
    
        if (r1.P0(r3, r10) == r0) goto L18;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r10.f114094b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r0 = r10.f114093a
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.b(r11)
            goto L65
        L16:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1e:
            kotlin.ResultKt.b(r11)
            goto L30
        L22:
            kotlin.ResultKt.b(r11)
            cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel r11 = r10.f114095c
            r10.f114094b = r3
            java.lang.Object r11 = cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel.U0(r11, r10)
            if (r11 != r0) goto L30
            goto L64
        L30:
            java.util.List r11 = (java.util.List) r11
            boolean r1 = r11.isEmpty()
            if (r1 == 0) goto L44
            cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel r3 = r10.f114095c
            long r4 = r10.f114096d
            long r6 = r10.f114097f
            int r8 = r10.f114098g
            cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel.b1(r3, r4, r6, r8)
            goto L65
        L44:
            cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel r1 = r10.f114095c
            cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewCommand$ShowPermissionsBeforeStart r3 = new cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewCommand$ShowPermissionsBeforeStart
            cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel$PomodoroDto r4 = new cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel$PomodoroDto
            long r5 = r10.f114096d
            long r7 = r10.f114097f
            int r9 = r10.f114098g
            r4.<init>(r5, r7, r9)
            r3.<init>(r4, r11)
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.a(r11)
            r10.f114093a = r11
            r10.f114094b = r2
            java.lang.Object r11 = cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel.a1(r1, r3, r10)
            if (r11 != r0) goto L65
        L64:
            return r0
        L65:
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel$checkPermissionsOrStart$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((PomodoroViewModel$checkPermissionsOrStart$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
