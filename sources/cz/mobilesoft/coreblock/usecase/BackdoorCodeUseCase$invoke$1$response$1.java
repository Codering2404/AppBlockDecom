package cz.mobilesoft.coreblock.usecase;

import cz.mobilesoft.coreblock.rest.ApiInterface;
import cz.mobilesoft.coreblock.rest.request.ValidateUnlockCodeRequest;
import cz.mobilesoft.coreblock.usecase.BackdoorCodeUseCase;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.usecase.BackdoorCodeUseCase$invoke$1$response$1", f = "BackdoorCodeUseCase.kt", l = {18}, m = "invokeSuspend", v = 1)
final class BackdoorCodeUseCase$invoke$1$response$1 extends SuspendLambda implements Function2<ApiInterface, Continuation<? super Response<Unit>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f126949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f126950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BackdoorCodeUseCase.Params f126951c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackdoorCodeUseCase$invoke$1$response$1(BackdoorCodeUseCase.Params params, Continuation continuation) {
        super(2, continuation);
        this.f126951c = params;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        BackdoorCodeUseCase$invoke$1$response$1 backdoorCodeUseCase$invoke$1$response$1 = new BackdoorCodeUseCase$invoke$1$response$1(this.f126951c, continuation);
        backdoorCodeUseCase$invoke$1$response$1.f126950b = obj;
        return backdoorCodeUseCase$invoke$1$response$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ApiInterface apiInterface, Continuation continuation) {
        return ((BackdoorCodeUseCase$invoke$1$response$1) create(apiInterface, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ApiInterface apiInterface = (ApiInterface) this.f126950b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f126949a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        ValidateUnlockCodeRequest validateUnlockCodeRequest = new ValidateUnlockCodeRequest(this.f126951c.a());
        this.f126950b = SpillingKt.a(apiInterface);
        this.f126949a = 1;
        Object objG = apiInterface.g(validateUnlockCodeRequest, this);
        return objG == objF ? objF : objG;
    }
}
