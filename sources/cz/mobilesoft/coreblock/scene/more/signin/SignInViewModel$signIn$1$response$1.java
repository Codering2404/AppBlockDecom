package cz.mobilesoft.coreblock.scene.more.signin;

import cz.mobilesoft.coreblock.rest.ApiInterface;
import cz.mobilesoft.coreblock.rest.request.LoginRequest;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$signIn$1$response$1", f = "SignInViewModel.kt", l = {394}, m = "invokeSuspend", v = 1)
final class SignInViewModel$signIn$1$response$1 extends SuspendLambda implements Function2<ApiInterface, Continuation<? super Response<LoginResponse>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f110498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f110499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SignInViewState f110500c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SignInViewModel$signIn$1$response$1(SignInViewState signInViewState, Continuation continuation) {
        super(2, continuation);
        this.f110500c = signInViewState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SignInViewModel$signIn$1$response$1 signInViewModel$signIn$1$response$1 = new SignInViewModel$signIn$1$response$1(this.f110500c, continuation);
        signInViewModel$signIn$1$response$1.f110499b = obj;
        return signInViewModel$signIn$1$response$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ApiInterface apiInterface, Continuation continuation) {
        return ((SignInViewModel$signIn$1$response$1) create(apiInterface, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ApiInterface apiInterface = (ApiInterface) this.f110499b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f110498a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        LoginRequest loginRequest = new LoginRequest(this.f110500c.d(), StringHelperExtKt.y(this.f110500c.m()));
        this.f110499b = SpillingKt.a(apiInterface);
        this.f110498a = 1;
        Object objF2 = apiInterface.f(loginRequest, this);
        return objF2 == objF ? objF : objF2;
    }
}
