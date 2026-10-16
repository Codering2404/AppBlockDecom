package cz.mobilesoft.coreblock.scene.more.signin;

import cz.mobilesoft.coreblock.rest.ApiInterface;
import cz.mobilesoft.coreblock.rest.ApiResponse;
import cz.mobilesoft.coreblock.rest.RestClient;
import cz.mobilesoft.coreblock.scene.more.signin.SignInViewState;
import cz.mobilesoft.coreblock.util.Loading;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$submitEmail$1", f = "SignInViewModel.kt", l = {205}, m = "invokeSuspend", v = 1)
final class SignInViewModel$submitEmail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f110561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SignInViewModel f110562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SignInViewState f110563c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SignInViewModel$submitEmail$1(SignInViewModel signInViewModel, SignInViewState signInViewState, Continuation continuation) {
        super(2, continuation);
        this.f110562b = signInViewModel;
        this.f110563c = signInViewState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignInViewState A(SignInViewState signInViewState) {
        return SignInViewState.b(signInViewState, null, null, null, null, null, null, null, false, false, null, null, SignInViewState.ForgotPasswordScreenType.VERIFICATION, false, false, false, false, false, false, false, false, false, null, 4192255, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignInViewState G(ApiResponse apiResponse, SignInViewState signInViewState) {
        return SignInViewState.b(signInViewState, null, null, null, null, null, apiResponse.b(), null, false, false, null, null, null, false, false, false, false, false, false, false, false, false, null, 4194271, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignInViewState z(SignInViewState signInViewState) {
        return SignInViewState.b(signInViewState, null, null, null, null, null, Loading.f127895a, null, false, false, null, null, null, false, false, false, false, false, false, false, false, false, null, 4194271, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SignInViewModel$submitEmail$1(this.f110562b, this.f110563c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f110561a;
        if (i3 == 0) {
            ResultKt.b(obj);
            this.f110562b.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.s3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return SignInViewModel$submitEmail$1.z((SignInViewState) obj2);
                }
            });
            RestClient restClient = RestClient.f98457a;
            ApiInterface apiInterfaceI = restClient.I();
            SignInViewModel$submitEmail$1$response$1 signInViewModel$submitEmail$1$response$1 = new SignInViewModel$submitEmail$1$response$1(this.f110563c, null);
            this.f110561a = 1;
            obj = restClient.H(apiInterfaceI, signInViewModel$submitEmail$1$response$1, this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        final ApiResponse apiResponse = (ApiResponse) obj;
        if (apiResponse instanceof ApiResponse.Success) {
            this.f110562b.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.t3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return SignInViewModel$submitEmail$1.A((SignInViewState) obj2);
                }
            });
        }
        this.f110562b.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.u3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return SignInViewModel$submitEmail$1.G(apiResponse, (SignInViewState) obj2);
            }
        });
        this.f110562b.U1();
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SignInViewModel$submitEmail$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
