package cz.mobilesoft.coreblock.scene.more.backup.progress;

import cz.mobilesoft.coreblock.rest.ApiInterface;
import cz.mobilesoft.coreblock.scene.more.backup.dto.BackupResponseDTO;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import retrofit2.Response;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel$downloadAndRestoreBackup$1$responseBackupDownload$1", f = "BackupProgressViewModel.kt", l = {143}, m = "invokeSuspend", v = 1)
final class BackupProgressViewModel$downloadAndRestoreBackup$1$responseBackupDownload$1 extends SuspendLambda implements Function2<ApiInterface, Continuation<? super Response<BackupResponseDTO>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f106513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f106514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f106515c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackupProgressViewModel$downloadAndRestoreBackup$1$responseBackupDownload$1(long j3, Continuation continuation) {
        super(2, continuation);
        this.f106515c = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        BackupProgressViewModel$downloadAndRestoreBackup$1$responseBackupDownload$1 backupProgressViewModel$downloadAndRestoreBackup$1$responseBackupDownload$1 = new BackupProgressViewModel$downloadAndRestoreBackup$1$responseBackupDownload$1(this.f106515c, continuation);
        backupProgressViewModel$downloadAndRestoreBackup$1$responseBackupDownload$1.f106514b = obj;
        return backupProgressViewModel$downloadAndRestoreBackup$1$responseBackupDownload$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ApiInterface apiInterface, Continuation continuation) {
        return ((BackupProgressViewModel$downloadAndRestoreBackup$1$responseBackupDownload$1) create(apiInterface, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ApiInterface apiInterface = (ApiInterface) this.f106514b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f106513a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        long j3 = this.f106515c;
        this.f106514b = SpillingKt.a(apiInterface);
        this.f106513a = 1;
        Object objM = apiInterface.m(j3, this);
        return objM == objF ? objF : objM;
    }
}
