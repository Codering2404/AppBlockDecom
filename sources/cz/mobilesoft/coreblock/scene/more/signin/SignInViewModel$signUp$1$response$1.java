package cz.mobilesoft.coreblock.scene.more.signin;

import cz.mobilesoft.coreblock.rest.ApiInterface;
import cz.mobilesoft.coreblock.rest.request.RegisterRequest;
import cz.mobilesoft.coreblock.rest.response.LoginResponse;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$signUp$1$response$1", f = "SignInViewModel.kt", l = {424}, m = "invokeSuspend", v = 1)
final class SignInViewModel$signUp$1$response$1 extends SuspendLambda implements Function2<ApiInterface, Continuation<? super Response<LoginResponse>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f110526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f110527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SignInViewState f110528c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SignInViewModel$signUp$1$response$1(SignInViewState signInViewState, Continuation continuation) {
        super(2, continuation);
        this.f110528c = signInViewState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SignInViewModel$signUp$1$response$1 signInViewModel$signUp$1$response$1 = new SignInViewModel$signUp$1$response$1(this.f110528c, continuation);
        signInViewModel$signUp$1$response$1.f110527b = obj;
        return signInViewModel$signUp$1$response$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ApiInterface apiInterface, Continuation continuation) {
        return ((SignInViewModel$signUp$1$response$1) create(apiInterface, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ApiInterface apiInterface = (ApiInterface) this.f110527b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f110526a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        RegisterRequest registerRequest = new RegisterRequest(this.f110528c.d(), StringHelperExtKt.y(this.f110528c.m()));
        this.f110527b = SpillingKt.a(apiInterface);
        this.f110526a = 1;
        Object objC = apiInterface.c(registerRequest, this);
        return objC == objF ? objF : objC;
    }
}
