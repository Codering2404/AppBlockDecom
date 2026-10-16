package cz.mobilesoft.coreblock.usecase;

import cz.mobilesoft.coreblock.rest.ApiInterface;
import cz.mobilesoft.coreblock.rest.request.UpdateUserDetailsRequest;
import cz.mobilesoft.coreblock.rest.response.UserDetailsResponse;
import cz.mobilesoft.coreblock.usecase.UpdateUserDetailUseCase;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.usecase.UpdateUserDetailUseCase$invoke$1$response$1", f = "UpdateUserDetailUseCase.kt", l = {21}, m = "invokeSuspend", v = 1)
final class UpdateUserDetailUseCase$invoke$1$response$1 extends SuspendLambda implements Function2<ApiInterface, Continuation<? super Response<UserDetailsResponse>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f127487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f127488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ UpdateUserDetailUseCase.Params f127489c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UpdateUserDetailUseCase$invoke$1$response$1(UpdateUserDetailUseCase.Params params, Continuation continuation) {
        super(2, continuation);
        this.f127489c = params;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        UpdateUserDetailUseCase$invoke$1$response$1 updateUserDetailUseCase$invoke$1$response$1 = new UpdateUserDetailUseCase$invoke$1$response$1(this.f127489c, continuation);
        updateUserDetailUseCase$invoke$1$response$1.f127488b = obj;
        return updateUserDetailUseCase$invoke$1$response$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ApiInterface apiInterface, Continuation continuation) {
        return ((UpdateUserDetailUseCase$invoke$1$response$1) create(apiInterface, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ApiInterface apiInterface = (ApiInterface) this.f127488b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f127487a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        UpdateUserDetailsRequest updateUserDetailsRequest = new UpdateUserDetailsRequest(this.f127489c.a());
        this.f127488b = SpillingKt.a(apiInterface);
        this.f127487a = 1;
        Object objT = apiInterface.t(updateUserDetailsRequest, this);
        return objT == objF ? objF : objT;
    }
}
