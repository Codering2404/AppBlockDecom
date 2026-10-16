package cz.mobilesoft.coreblock.scene.more.backup.progress;

import cz.mobilesoft.coreblock.rest.ApiInterface;
import cz.mobilesoft.coreblock.rest.request.RegisterDeviceRequest;
import cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity;
import cz.mobilesoft.coreblock.util.runnability.DeviceIdUtils;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.backup.progress.BackupProgressViewModel$startBackup$1$registerDeviceResponse$1", f = "BackupProgressViewModel.kt", l = {108, 106}, m = "invokeSuspend", v = 1)
final class BackupProgressViewModel$startBackup$1$registerDeviceResponse$1 extends SuspendLambda implements Function2<ApiInterface, Continuation<? super Response<Unit>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f106531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f106532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f106533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private /* synthetic */ Object f106534d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ TokenFCMEntity f106535f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackupProgressViewModel$startBackup$1$registerDeviceResponse$1(TokenFCMEntity tokenFCMEntity, Continuation continuation) {
        super(2, continuation);
        this.f106535f = tokenFCMEntity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        BackupProgressViewModel$startBackup$1$registerDeviceResponse$1 backupProgressViewModel$startBackup$1$registerDeviceResponse$1 = new BackupProgressViewModel$startBackup$1$registerDeviceResponse$1(this.f106535f, continuation);
        backupProgressViewModel$startBackup$1$registerDeviceResponse$1.f106534d = obj;
        return backupProgressViewModel$startBackup$1$registerDeviceResponse$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ApiInterface apiInterface, Continuation continuation) {
        return ((BackupProgressViewModel$startBackup$1$registerDeviceResponse$1) create(apiInterface, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        String str;
        ApiInterface apiInterface;
        ApiInterface apiInterface2 = (ApiInterface) this.f106534d;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f106533c;
        if (i3 == 0) {
            ResultKt.b(obj);
            TokenFCMEntity tokenFCMEntity = this.f106535f;
            String strA = tokenFCMEntity != null ? tokenFCMEntity.a() : null;
            DeviceIdUtils deviceIdUtils = DeviceIdUtils.f129470a;
            this.f106534d = SpillingKt.a(apiInterface2);
            this.f106531a = strA;
            this.f106532b = apiInterface2;
            this.f106533c = 1;
            objB = deviceIdUtils.b(this);
            if (objB != objF) {
                str = strA;
                apiInterface = apiInterface2;
            }
        }
        if (i3 != 1) {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        apiInterface = (ApiInterface) this.f106532b;
        String str2 = (String) this.f106531a;
        ResultKt.b(obj);
        str = str2;
        objB = obj;
        RegisterDeviceRequest registerDeviceRequest = new RegisterDeviceRequest(null, null, null, (String) objB, null, null, null, null, null, null, str, 1015, null);
        this.f106534d = SpillingKt.a(apiInterface2);
        this.f106531a = null;
        this.f106532b = null;
        this.f106533c = 2;
        Object objI = apiInterface.i(registerDeviceRequest, this);
        return objI == objF ? objF : objI;
    }
}
