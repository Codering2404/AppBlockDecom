package cz.mobilesoft.coreblock.service.job;

import com.evernote.android.job.Job;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.job.AutoLockJob$onRunJob$1", f = "AutoLockJob.kt", l = {34, 42, 44}, m = "invokeSuspend", v = 1)
final class AutoLockJob$onRunJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job.Result>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f123161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f123162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f123163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AutoLockJob f123164d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f123165f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutoLockJob$onRunJob$1(AutoLockJob autoLockJob, long j3, Continuation continuation) {
        super(2, continuation);
        this.f123164d = autoLockJob;
        this.f123165f = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AutoLockJob$onRunJob$1(this.f123164d, this.f123165f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x008c, code lost:
    
        if (r8.W1(r4, r7) != r0) goto L26;
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
            int r1 = r7.f123163c
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L30
            if (r1 == r4) goto L2c
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            java.lang.Object r0 = r7.f123161a
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r0 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r0
            kotlin.ResultKt.b(r8)
            goto L8f
        L1a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L22:
            boolean r1 = r7.f123162b
            java.lang.Object r3 = r7.f123161a
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r3 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r3
            kotlin.ResultKt.b(r8)
            goto L72
        L2c:
            kotlin.ResultKt.b(r8)
            goto L44
        L30:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.service.job.AutoLockJob r8 = r7.f123164d
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r8 = cz.mobilesoft.coreblock.service.job.AutoLockJob.y(r8)
            long r5 = r7.f123165f
            r7.f123163c = r4
            java.lang.Object r8 = r8.e(r5, r7)
            if (r8 != r0) goto L44
            goto L8e
        L44:
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r8 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r8
            cz.mobilesoft.coreblock.service.job.AutoLockJob r1 = r7.f123164d
            cz.mobilesoft.coreblock.repository.StrictModeRepository r1 = cz.mobilesoft.coreblock.service.job.AutoLockJob.z(r1)
            boolean r1 = r1.n()
            if (r8 == 0) goto L92
            if (r1 != 0) goto L55
            goto L92
        L55:
            r4 = 0
            r8.i0(r4)
            cz.mobilesoft.coreblock.service.job.AutoLockJob r4 = r7.f123164d
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r4 = cz.mobilesoft.coreblock.service.job.AutoLockJob.y(r4)
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r7.f123161a = r5
            r7.f123162b = r1
            r7.f123163c = r3
            java.lang.Object r3 = r4.p(r8, r7)
            if (r3 != r0) goto L71
            goto L8e
        L71:
            r3 = r8
        L72:
            cz.mobilesoft.coreblock.service.job.AutoLockJob r8 = r7.f123164d
            cz.mobilesoft.coreblock.storage.datastore.EventDataStore r8 = cz.mobilesoft.coreblock.service.job.AutoLockJob.x(r8)
            cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt r4 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.f128663a
            long r4 = r4.f()
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.a(r3)
            r7.f123161a = r3
            r7.f123162b = r1
            r7.f123163c = r2
            java.lang.Object r8 = r8.W1(r4, r7)
            if (r8 != r0) goto L8f
        L8e:
            return r0
        L8f:
            com.evernote.android.job.Job$Result r8 = com.evernote.android.job.Job.Result.SUCCESS
            return r8
        L92:
            com.evernote.android.job.Job$Result r8 = com.evernote.android.job.Job.Result.SUCCESS
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.job.AutoLockJob$onRunJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AutoLockJob$onRunJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
