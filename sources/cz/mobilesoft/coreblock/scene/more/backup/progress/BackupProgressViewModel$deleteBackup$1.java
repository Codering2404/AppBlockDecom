package cz.mobilesoft.coreblock.scene.more.backup.progress;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel$deleteBackup$1", f = "BackupProgressViewModel.kt", l = {217, 219, 223, 226}, m = "invokeSuspend", v = 1)
final class BackupProgressViewModel$deleteBackup$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f106491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f106492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BackupProgressViewModel f106493c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackupProgressViewModel$deleteBackup$1(BackupProgressViewModel backupProgressViewModel, Continuation continuation) {
        super(1, continuation);
        this.f106493c = backupProgressViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BackupProgressViewModel$deleteBackup$1(this.f106493c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x009f, code lost:
    
        if (r8.emit(r3, r7) == r0) goto L29;
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
            int r1 = r7.f106492b
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L35
            if (r1 == r5) goto L31
            if (r1 == r4) goto L2d
            if (r1 == r3) goto L25
            if (r1 != r2) goto L1d
            java.lang.Object r0 = r7.f106491a
            cz.mobilesoft.coreblock.rest.ApiResponse r0 = (cz.mobilesoft.coreblock.rest.ApiResponse) r0
            kotlin.ResultKt.b(r8)
            goto La2
        L1d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L25:
            java.lang.Object r1 = r7.f106491a
            cz.mobilesoft.coreblock.rest.ApiResponse r1 = (cz.mobilesoft.coreblock.rest.ApiResponse) r1
            kotlin.ResultKt.b(r8)
            goto L89
        L2d:
            kotlin.ResultKt.b(r8)
            goto L5e
        L31:
            kotlin.ResultKt.b(r8)
            goto L49
        L35:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel r8 = r7.f106493c
            kotlinx.coroutines.flow.MutableStateFlow r8 = cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel.L0(r8)
            cz.mobilesoft.coreblock.util.Loading r1 = cz.mobilesoft.coreblock.util.Loading.f127895a
            r7.f106492b = r5
            java.lang.Object r8 = r8.emit(r1, r7)
            if (r8 != r0) goto L49
            goto La1
        L49:
            cz.mobilesoft.coreblock.rest.RestClient r8 = cz.mobilesoft.coreblock.rest.RestClient.f98457a
            cz.mobilesoft.coreblock.rest.ApiInterface r1 = r8.t()
            cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel$deleteBackup$1$deleteBackupResponse$1 r5 = new cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel$deleteBackup$1$deleteBackupResponse$1
            r6 = 0
            r5.<init>(r6)
            r7.f106492b = r4
            java.lang.Object r8 = r8.H(r1, r5, r7)
            if (r8 != r0) goto L5e
            goto La1
        L5e:
            r1 = r8
            cz.mobilesoft.coreblock.rest.ApiResponse r1 = (cz.mobilesoft.coreblock.rest.ApiResponse) r1
            cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel r8 = r7.f106493c
            r4 = 1065353216(0x3f800000, float:1.0)
            cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel.R0(r8, r4)
            boolean r8 = r1 instanceof cz.mobilesoft.coreblock.rest.ApiResponse.Success
            if (r8 == 0) goto L89
            cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel r8 = r7.f106493c
            android.os.CountDownTimer r8 = cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel.J0(r8)
            if (r8 != 0) goto L89
            cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel r8 = r7.f106493c
            kotlinx.coroutines.flow.MutableStateFlow r8 = r8.W0()
            java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.c(r4)
            r7.f106491a = r1
            r7.f106492b = r3
            java.lang.Object r8 = r8.emit(r4, r7)
            if (r8 != r0) goto L89
            goto La1
        L89:
            cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel r8 = r7.f106493c
            kotlinx.coroutines.flow.MutableStateFlow r8 = cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel.L0(r8)
            cz.mobilesoft.coreblock.util.ViewModelState r3 = r1.b()
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r7.f106491a = r1
            r7.f106492b = r2
            java.lang.Object r8 = r8.emit(r3, r7)
            if (r8 != r0) goto La2
        La1:
            return r0
        La2:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel$deleteBackup$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((BackupProgressViewModel$deleteBackup$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
