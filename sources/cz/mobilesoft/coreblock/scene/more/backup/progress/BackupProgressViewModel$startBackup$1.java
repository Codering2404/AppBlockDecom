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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel$startBackup$1", f = "BackupProgressViewModel.kt", l = {101, 103, 105, 116, 119, 124, 125, 130, 132, 135}, m = "invokeSuspend", v = 1)
final class BackupProgressViewModel$startBackup$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f106524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f106525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f106526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f106527d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f106528f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ BackupProgressViewModel f106529g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ boolean f106530h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackupProgressViewModel$startBackup$1(BackupProgressViewModel backupProgressViewModel, boolean z2, Continuation continuation) {
        super(1, continuation);
        this.f106529g = backupProgressViewModel;
        this.f106530h = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BackupProgressViewModel$startBackup$1(this.f106529g, this.f106530h, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0104, code lost:
    
        if (r3.p(r1, r8) == r0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01ea, code lost:
    
        if (r9.emit(r5, r8) != r0) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x020d, code lost:
    
        if (r2.emit(r3, r8) == r0) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c3 A[PHI: r9
      0x00c3: PHI (r9v7 java.lang.Object) = (r9v6 java.lang.Object), (r9v0 java.lang.Object) binds: [B:20:0x00bf, B:14:0x0095] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0125 A[PHI: r1 r3 r9
      0x0125: PHI (r1v14 cz.mobilesoft.coreblock.rest.ApiResponse) = (r1v11 cz.mobilesoft.coreblock.rest.ApiResponse), (r1v16 cz.mobilesoft.coreblock.rest.ApiResponse) binds: [B:34:0x0121, B:10:0x0066] A[DONT_GENERATE, DONT_INLINE]
      0x0125: PHI (r3v9 cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity) = 
      (r3v6 cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity)
      (r3v12 cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity)
     binds: [B:34:0x0121, B:10:0x0066] A[DONT_GENERATE, DONT_INLINE]
      0x0125: PHI (r9v20 java.lang.Object) = (r9v16 java.lang.Object), (r9v0 java.lang.Object) binds: [B:34:0x0121, B:10:0x0066] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01c0 A[PHI: r1 r2 r3 r4
      0x01c0: PHI (r1v24 cz.mobilesoft.coreblock.rest.ApiResponse) = 
      (r1v18 cz.mobilesoft.coreblock.rest.ApiResponse)
      (r1v21 cz.mobilesoft.coreblock.rest.ApiResponse)
      (r1v28 cz.mobilesoft.coreblock.rest.ApiResponse)
     binds: [B:41:0x0160, B:48:0x01bd, B:7:0x0028] A[DONT_GENERATE, DONT_INLINE]
      0x01c0: PHI (r2v16 cz.mobilesoft.coreblock.scene.more.backup.dto.BackupRequest) = 
      (r2v9 cz.mobilesoft.coreblock.scene.more.backup.dto.BackupRequest)
      (r2v13 cz.mobilesoft.coreblock.scene.more.backup.dto.BackupRequest)
      (r2v19 cz.mobilesoft.coreblock.scene.more.backup.dto.BackupRequest)
     binds: [B:41:0x0160, B:48:0x01bd, B:7:0x0028] A[DONT_GENERATE, DONT_INLINE]
      0x01c0: PHI (r3v20 cz.mobilesoft.coreblock.rest.ApiResponse) = 
      (r3v13 cz.mobilesoft.coreblock.rest.ApiResponse)
      (r3v17 cz.mobilesoft.coreblock.rest.ApiResponse)
      (r3v23 cz.mobilesoft.coreblock.rest.ApiResponse)
     binds: [B:41:0x0160, B:48:0x01bd, B:7:0x0028] A[DONT_GENERATE, DONT_INLINE]
      0x01c0: PHI (r4v14 cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity) = 
      (r4v9 cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity)
      (r4v11 cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity)
      (r4v17 cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity)
     binds: [B:41:0x0160, B:48:0x01bd, B:7:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01f0  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 568
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel$startBackup$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((BackupProgressViewModel$startBackup$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
