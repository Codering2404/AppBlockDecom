package cz.mobilesoft.appblock.service.lock;

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
@DebugMetadata(c = "cz.mobilesoft.appblock.service.lock.LockScreenExecutor$execute$1$1", f = "LockScreenExecutor.kt", l = {132, 133}, m = "invokeSuspend", v = 1)
final class LockScreenExecutor$execute$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LockScreenExecutor f94788b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenExecutor$execute$1$1(LockScreenExecutor lockScreenExecutor, Continuation continuation) {
        super(1, continuation);
        this.f94788b = lockScreenExecutor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new LockScreenExecutor$execute$1$1(this.f94788b, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
    
        if (r11.t2(r3, r10) == r0) goto L15;
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
            int r1 = r10.f94787a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r11)
            goto L4f
        L12:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1a:
            kotlin.ResultKt.b(r11)
            goto L3a
        L1e:
            kotlin.ResultKt.b(r11)
            cz.mobilesoft.appblock.service.lock.LockScreenExecutor r11 = r10.f94788b
            cz.mobilesoft.coreblock.storage.datastore.EventDataStore r11 = cz.mobilesoft.appblock.service.lock.LockScreenExecutor.c(r11)
            cz.mobilesoft.coreblock.dto.events.PackageAdditionalBlockingDTO r4 = new cz.mobilesoft.coreblock.dto.events.PackageAdditionalBlockingDTO
            r8 = 7
            r9 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r4.<init>(r5, r6, r7, r8, r9)
            r10.f94787a = r3
            java.lang.Object r11 = r11.s2(r4, r10)
            if (r11 != r0) goto L3a
            goto L4e
        L3a:
            cz.mobilesoft.appblock.service.lock.LockScreenExecutor r11 = r10.f94788b
            cz.mobilesoft.coreblock.storage.datastore.EventDataStore r11 = cz.mobilesoft.appblock.service.lock.LockScreenExecutor.c(r11)
            cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt r1 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.f128663a
            long r3 = r1.f()
            r10.f94787a = r2
            java.lang.Object r11 = r11.t2(r3, r10)
            if (r11 != r0) goto L4f
        L4e:
            return r0
        L4f:
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.lock.LockScreenExecutor$execute$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((LockScreenExecutor$execute$1$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
