package cz.mobilesoft.coreblock.repository;

import cz.mobilesoft.coreblock.rest.ApiInterface;
import cz.mobilesoft.coreblock.rest.request.AccountabilityPartnerDeactivationRequest;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository$accountabilityPartnerDeactivationRequest$1$result$1", f = "AccountabilityPartnerRepository.kt", l = {55}, m = "invokeSuspend", v = 1)
final class AccountabilityPartnerRepository$accountabilityPartnerDeactivationRequest$1$result$1 extends SuspendLambda implements Function2<ApiInterface, Continuation<? super Response<Unit>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f97326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f97327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f97328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f97329d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AccountabilityPartnerRepository$accountabilityPartnerDeactivationRequest$1$result$1(String str, String str2, Continuation continuation) {
        super(2, continuation);
        this.f97328c = str;
        this.f97329d = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AccountabilityPartnerRepository$accountabilityPartnerDeactivationRequest$1$result$1 accountabilityPartnerRepository$accountabilityPartnerDeactivationRequest$1$result$1 = new AccountabilityPartnerRepository$accountabilityPartnerDeactivationRequest$1$result$1(this.f97328c, this.f97329d, continuation);
        accountabilityPartnerRepository$accountabilityPartnerDeactivationRequest$1$result$1.f97327b = obj;
        return accountabilityPartnerRepository$accountabilityPartnerDeactivationRequest$1$result$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ApiInterface apiInterface, Continuation continuation) {
        return ((AccountabilityPartnerRepository$accountabilityPartnerDeactivationRequest$1$result$1) create(apiInterface, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ApiInterface apiInterface = (ApiInterface) this.f97327b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f97326a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        AccountabilityPartnerDeactivationRequest accountabilityPartnerDeactivationRequest = new AccountabilityPartnerDeactivationRequest(this.f97328c);
        String str = this.f97329d;
        this.f97327b = SpillingKt.a(apiInterface);
        this.f97326a = 1;
        Object objO = apiInterface.o(accountabilityPartnerDeactivationRequest, str, this);
        return objO == objF ? objF : objO;
    }
}
