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
@DebugMetadata(c = "cz.mobilesoft.appblock.service.lock.UsageLimitHostTracker$checkAndClearIfNotInForeground$1", f = "UsageLimitHostTracker.kt", l = {170, 171, 172}, m = "invokeSuspend", v = 1)
final class UsageLimitHostTracker$checkAndClearIfNotInForeground$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f95011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ UsageLimitHostTracker f95012b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UsageLimitHostTracker$checkAndClearIfNotInForeground$1(UsageLimitHostTracker usageLimitHostTracker, Continuation continuation) {
        super(1, continuation);
        this.f95012b = usageLimitHostTracker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new UsageLimitHostTracker$checkAndClearIfNotInForeground$1(this.f95012b, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
    
        if (r12.r2(r3, r11) != r0) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r11.f95011a
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L25
            if (r1 == r4) goto L21
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            kotlin.ResultKt.b(r12)
            goto L6b
        L15:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1d:
            kotlin.ResultKt.b(r12)
            goto L56
        L21:
            kotlin.ResultKt.b(r12)
            goto L41
        L25:
            kotlin.ResultKt.b(r12)
            cz.mobilesoft.appblock.service.lock.UsageLimitHostTracker r12 = r11.f95012b
            cz.mobilesoft.coreblock.storage.datastore.EventDataStore r12 = cz.mobilesoft.appblock.service.lock.UsageLimitHostTracker.a(r12)
            cz.mobilesoft.coreblock.dto.events.PackageAdditionalBlockingDTO r5 = new cz.mobilesoft.coreblock.dto.events.PackageAdditionalBlockingDTO
            r9 = 7
            r10 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r5.<init>(r6, r7, r8, r9, r10)
            r11.f95011a = r4
            java.lang.Object r12 = r12.s2(r5, r11)
            if (r12 != r0) goto L41
            goto L6a
        L41:
            cz.mobilesoft.appblock.service.lock.UsageLimitHostTracker r12 = r11.f95012b
            cz.mobilesoft.coreblock.storage.datastore.EventDataStore r12 = cz.mobilesoft.appblock.service.lock.UsageLimitHostTracker.a(r12)
            cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt r1 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.f128663a
            long r4 = r1.f()
            r11.f95011a = r3
            java.lang.Object r12 = r12.S1(r4, r11)
            if (r12 != r0) goto L56
            goto L6a
        L56:
            cz.mobilesoft.appblock.service.lock.UsageLimitHostTracker r12 = r11.f95012b
            cz.mobilesoft.coreblock.storage.datastore.EventDataStore r12 = cz.mobilesoft.appblock.service.lock.UsageLimitHostTracker.a(r12)
            cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt r1 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.f128663a
            long r3 = r1.f()
            r11.f95011a = r2
            java.lang.Object r12 = r12.r2(r3, r11)
            if (r12 != r0) goto L6b
        L6a:
            return r0
        L6b:
            kotlin.Unit r12 = kotlin.Unit.f139807a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.lock.UsageLimitHostTracker$checkAndClearIfNotInForeground$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((UsageLimitHostTracker$checkAndClearIfNotInForeground$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
