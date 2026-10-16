package cz.mobilesoft.coreblock.service.worker;

import cz.mobilesoft.coreblock.rest.ApiInterface;
import cz.mobilesoft.coreblock.rest.response.CurrentCampaignResponse;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.worker.CampaignCheckWorker$Companion$checkForCampaigns$result$1", f = "CampaignCheckWorker.kt", l = {106}, m = "invokeSuspend", v = 1)
final class CampaignCheckWorker$Companion$checkForCampaigns$result$1 extends SuspendLambda implements Function2<ApiInterface, Continuation<? super Response<CurrentCampaignResponse>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f123902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f123903b;

    CampaignCheckWorker$Companion$checkForCampaigns$result$1(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        CampaignCheckWorker$Companion$checkForCampaigns$result$1 campaignCheckWorker$Companion$checkForCampaigns$result$1 = new CampaignCheckWorker$Companion$checkForCampaigns$result$1(continuation);
        campaignCheckWorker$Companion$checkForCampaigns$result$1.f123903b = obj;
        return campaignCheckWorker$Companion$checkForCampaigns$result$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ApiInterface apiInterface, Continuation continuation) {
        return ((CampaignCheckWorker$Companion$checkForCampaigns$result$1) create(apiInterface, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ApiInterface apiInterface = (ApiInterface) this.f123903b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f123902a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        this.f123903b = SpillingKt.a(apiInterface);
        this.f123902a = 1;
        Object objY = apiInterface.y(this);
        return objY == objF ? objF : objY;
    }
}
