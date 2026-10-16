package cz.mobilesoft.coreblock.scene.password;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel$handleFailedAttempts$1", f = "BasePassCodeViewModel.kt", l = {138, 148}, m = "invokeSuspend", v = 1)
final class BasePassCodeViewModel$handleFailedAttempts$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f111639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f111640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f111641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ BasePassCodeViewModel f111642d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BasePassCodeViewModel$handleFailedAttempts$1(BasePassCodeViewModel basePassCodeViewModel, Continuation continuation) {
        super(2, continuation);
        this.f111642d = basePassCodeViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BasePassCodeViewModel$handleFailedAttempts$1(this.f111642d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0071, code lost:
    
        if (r1.s1(r3, r7) == r0) goto L24;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.f111641c
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r8)
            goto L74
        L12:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1a:
            kotlin.ResultKt.b(r8)
            goto L35
        L1e:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel r8 = r7.f111642d
            cz.mobilesoft.coreblock.scene.password.PassCodeViewState r1 = cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel.U0(r8)
            int r1 = r1.d()
            int r1 = r1 + r3
            r7.f111641c = r3
            java.lang.Object r8 = r8.t1(r1, r7)
            if (r8 != r0) goto L35
            goto L73
        L35:
            cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel r8 = r7.f111642d
            cz.mobilesoft.coreblock.scene.password.PassCodeViewState r8 = cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel.U0(r8)
            int r8 = r8.d()
            r1 = 3
            if (r8 <= r1) goto L74
            cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel r1 = r7.f111642d
            cz.mobilesoft.coreblock.scene.password.PassCodeViewState r1 = cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel.U0(r1)
            int r1 = r1.d()
            r3 = 4
            if (r1 == r3) goto L5a
            r3 = 5
            if (r1 == r3) goto L56
            r1 = 300000(0x493e0, float:4.2039E-40)
            goto L5d
        L56:
            r1 = 180000(0x2bf20, float:2.52234E-40)
            goto L5d
        L5a:
            r1 = 60000(0xea60, float:8.4078E-41)
        L5d:
            long r3 = (long) r1
            cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt r1 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.f128663a
            long r5 = r1.f()
            long r3 = r3 + r5
            cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel r1 = r7.f111642d
            r7.f111639a = r8
            r7.f111640b = r3
            r7.f111641c = r2
            java.lang.Object r8 = r1.s1(r3, r7)
            if (r8 != r0) goto L74
        L73:
            return r0
        L74:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel$handleFailedAttempts$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BasePassCodeViewModel$handleFailedAttempts$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
