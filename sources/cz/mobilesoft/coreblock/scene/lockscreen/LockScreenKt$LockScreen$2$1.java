package cz.mobilesoft.coreblock.scene.lockscreen;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.LockScreenKt$LockScreen$2$1", f = "LockScreen.kt", l = {140, 145}, m = "invokeSuspend", v = 1)
final class LockScreenKt$LockScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f105395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f105396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f105397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f105398d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f105399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutableFloatState f105400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ MutableState f105401h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenKt$LockScreen$2$1(boolean z2, long j3, MutableFloatState mutableFloatState, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.f105398d = z2;
        this.f105399f = j3;
        this.f105400g = mutableFloatState;
        this.f105401h = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockScreenKt$LockScreen$2$1(this.f105398d, this.f105399f, this.f105400g, this.f105401h, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006e, code lost:
    
        if (r15 == r0) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0078  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006e -> B:21:0x0071). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r14.f105397c
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L21
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            long r4 = r14.f105395a
            kotlin.ResultKt.b(r15)
            r6 = r4
            goto L71
        L15:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L1d:
            kotlin.ResultKt.b(r15)
            goto L41
        L21:
            kotlin.ResultKt.b(r15)
            androidx.compose.runtime.MutableState r15 = r14.f105401h
            cz.mobilesoft.coreblock.enums.DynamicLockScreen$Companion r1 = cz.mobilesoft.coreblock.enums.DynamicLockScreen.Companion
            cz.mobilesoft.coreblock.enums.DynamicLockScreen r1 = r1.b()
            cz.mobilesoft.coreblock.scene.lockscreen.LockScreenKt.t0(r15, r1)
            boolean r15 = r14.f105398d
            if (r15 == 0) goto L8a
        L33:
            cz.mobilesoft.coreblock.scene.lockscreen.n1 r15 = new cz.mobilesoft.coreblock.scene.lockscreen.n1
            r15.<init>()
            r14.f105397c = r3
            java.lang.Object r15 = androidx.compose.runtime.MonotonicFrameClockKt.c(r15, r14)
            if (r15 != r0) goto L41
            goto L70
        L41:
            java.lang.Number r15 = (java.lang.Number) r15
            long r4 = r15.longValue()
            r6 = r4
        L48:
            long r8 = r4 - r6
            long r10 = r14.f105399f
            r15 = 1000000(0xf4240, float:1.401298E-39)
            long r12 = (long) r15
            long r12 = r12 * r10
            int r1 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r1 >= 0) goto L78
            androidx.compose.runtime.MutableFloatState r1 = r14.f105400g
            float r8 = (float) r8
            float r15 = (float) r15
            float r8 = r8 / r15
            float r15 = (float) r10
            float r8 = r8 / r15
            r1.s(r8)
            cz.mobilesoft.coreblock.scene.lockscreen.o1 r15 = new cz.mobilesoft.coreblock.scene.lockscreen.o1
            r15.<init>()
            r14.f105395a = r6
            r14.f105396b = r4
            r14.f105397c = r2
            java.lang.Object r15 = androidx.compose.runtime.MonotonicFrameClockKt.c(r15, r14)
            if (r15 != r0) goto L71
        L70:
            return r0
        L71:
            java.lang.Number r15 = (java.lang.Number) r15
            long r4 = r15.longValue()
            goto L48
        L78:
            androidx.compose.runtime.MutableFloatState r15 = r14.f105400g
            r1 = 0
            r15.s(r1)
            androidx.compose.runtime.MutableState r15 = r14.f105401h
            cz.mobilesoft.coreblock.enums.DynamicLockScreen$Companion r1 = cz.mobilesoft.coreblock.enums.DynamicLockScreen.Companion
            cz.mobilesoft.coreblock.enums.DynamicLockScreen r1 = r1.b()
            cz.mobilesoft.coreblock.scene.lockscreen.LockScreenKt.t0(r15, r1)
            goto L33
        L8a:
            kotlin.Unit r15 = kotlin.Unit.f139807a
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.LockScreenKt$LockScreen$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockScreenKt$LockScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long y(long j3) {
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long z(long j3) {
        return j3;
    }
}
