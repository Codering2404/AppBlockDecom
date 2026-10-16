package cz.mobilesoft.coreblock.scene.more.backup.progress;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import cz.mobilesoft.coreblock.rest.ApiResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel$downloadAndRestoreBackup$1", f = "BackupProgressViewModel.kt", l = {143, 145, 153, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 192, 195, RCHTTPStatusCodes.CREATED, 204, 205}, m = "invokeSuspend", v = 1)
final class BackupProgressViewModel$downloadAndRestoreBackup$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f106496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f106497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    float f106498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f106499d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ BackupProgressViewModel f106500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ long f106501g;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel$downloadAndRestoreBackup$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass2<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BackupProgressViewModel f106502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ApiResponse f106503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f106504c;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel$downloadAndRestoreBackup$1$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel$downloadAndRestoreBackup$1$2$1", f = "BackupProgressViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f106505a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ BackupProgressViewModel f106506b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ float f106507c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(BackupProgressViewModel backupProgressViewModel, float f3, Continuation continuation) {
                super(2, continuation);
                this.f106506b = backupProgressViewModel;
                this.f106507c = f3;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass1(this.f106506b, this.f106507c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.f106505a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.f106506b.a1(this.f106507c);
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        AnonymousClass2(BackupProgressViewModel backupProgressViewModel, ApiResponse apiResponse, float f3) {
            this.f106502a = backupProgressViewModel;
            this.f106503b = apiResponse;
            this.f106504c = f3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x0132, code lost:
        
            if (r12.emit(r3, r0) == r1) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x019d, code lost:
        
            if (r12.emit(r3, r0) != r1) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x01ff, code lost:
        
            if (r12.emit(r2, r0) == r1) goto L67;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x006f A[PHI: r11 r12
          0x006f: PHI (r11v14 cz.mobilesoft.coreblock.util.AdultContentDownloadWorker$AdultContentSyncState) = 
          (r11v11 cz.mobilesoft.coreblock.util.AdultContentDownloadWorker$AdultContentSyncState)
          (r11v21 cz.mobilesoft.coreblock.util.AdultContentDownloadWorker$AdultContentSyncState)
         binds: [B:30:0x00f1, B:17:0x0068] A[DONT_GENERATE, DONT_INLINE]
          0x006f: PHI (r12v19 java.lang.Object) = (r12v18 java.lang.Object), (r12v1 java.lang.Object) binds: [B:30:0x00f1, B:17:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00c5 A[PHI: r11
          0x00c5: PHI (r11v11 cz.mobilesoft.coreblock.util.AdultContentDownloadWorker$AdultContentSyncState) = 
          (r11v8 cz.mobilesoft.coreblock.util.AdultContentDownloadWorker$AdultContentSyncState)
          (r11v13 cz.mobilesoft.coreblock.util.AdultContentDownloadWorker$AdultContentSyncState)
         binds: [B:27:0x00c1, B:19:0x0072] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00fa  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0139  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0182 A[PHI: r2 r11
          0x0182: PHI (r2v20 cz.mobilesoft.coreblock.util.AdultContentDownloadWorker$AdultContentSyncState) = 
          (r2v17 cz.mobilesoft.coreblock.util.AdultContentDownloadWorker$AdultContentSyncState)
          (r2v23 cz.mobilesoft.coreblock.util.AdultContentDownloadWorker$AdultContentSyncState)
         binds: [B:48:0x017e, B:14:0x0041] A[DONT_GENERATE, DONT_INLINE]
          0x0182: PHI (r11v30 cz.mobilesoft.coreblock.repository.BackupsRepository$BackupRestoreSuccessDTO) = 
          (r11v27 cz.mobilesoft.coreblock.repository.BackupsRepository$BackupRestoreSuccessDTO)
          (r11v35 cz.mobilesoft.coreblock.repository.BackupsRepository$BackupRestoreSuccessDTO)
         binds: [B:48:0x017e, B:14:0x0041] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(cz.mobilesoft.coreblock.util.AdultContentDownloadWorker.AdultContentSyncState r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 540
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel$downloadAndRestoreBackup$1.AnonymousClass2.emit(cz.mobilesoft.coreblock.util.AdultContentDownloadWorker$AdultContentSyncState, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackupProgressViewModel$downloadAndRestoreBackup$1(BackupProgressViewModel backupProgressViewModel, long j3, Continuation continuation) {
        super(1, continuation);
        this.f106500f = backupProgressViewModel;
        this.f106501g = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BackupProgressViewModel$downloadAndRestoreBackup$1(this.f106500f, this.f106501g, continuation);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x009f, code lost:
    
        if (r11.emit(r2, r10) == r0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0132, code lost:
    
        if (r2.collect(r3, r10) == r0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01ac, code lost:
    
        if (r11.emit(r3, r10) == r0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0216, code lost:
    
        if (r11.emit(r3, r10) != r0) goto L74;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0045 A[PHI: r1 r11
      0x0045: PHI (r1v10 cz.mobilesoft.coreblock.rest.ApiResponse) = (r1v7 cz.mobilesoft.coreblock.rest.ApiResponse), (r1v16 cz.mobilesoft.coreblock.rest.ApiResponse) binds: [B:51:0x016b, B:10:0x003e] A[DONT_GENERATE, DONT_INLINE]
      0x0045: PHI (r11v33 java.lang.Object) = (r11v32 java.lang.Object), (r11v0 java.lang.Object) binds: [B:51:0x016b, B:10:0x003e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01fa A[PHI: r1 r2
      0x01fa: PHI (r1v20 cz.mobilesoft.coreblock.repository.BackupsRepository$BackupRestoreSuccessDTO) = 
      (r1v17 cz.mobilesoft.coreblock.repository.BackupsRepository$BackupRestoreSuccessDTO)
      (r1v24 cz.mobilesoft.coreblock.repository.BackupsRepository$BackupRestoreSuccessDTO)
     binds: [B:69:0x01f7, B:7:0x0017] A[DONT_GENERATE, DONT_INLINE]
      0x01fa: PHI (r2v14 cz.mobilesoft.coreblock.rest.ApiResponse) = (r2v11 cz.mobilesoft.coreblock.rest.ApiResponse), (r2v17 cz.mobilesoft.coreblock.rest.ApiResponse) binds: [B:69:0x01f7, B:7:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 564
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel$downloadAndRestoreBackup$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((BackupProgressViewModel$downloadAndRestoreBackup$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
