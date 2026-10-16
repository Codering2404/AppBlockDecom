package cz.mobilesoft.coreblock.scene.more.signin;

import cz.mobilesoft.coreblock.rest.ApiResponse;
import cz.mobilesoft.coreblock.util.Loading;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$signUp$1", f = "SignInViewModel.kt", l = {423, 429, 430}, m = "invokeSuspend", v = 1)
final class SignInViewModel$signUp$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f110521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f110522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f110523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ SignInViewModel f110524d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ SignInViewState f110525f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SignInViewModel$signUp$1(SignInViewModel signInViewModel, SignInViewState signInViewState, Continuation continuation) {
        super(1, continuation);
        this.f110524d = signInViewModel;
        this.f110525f = signInViewState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignInViewState y(SignInViewState signInViewState) {
        return SignInViewState.b(signInViewState, null, null, null, null, null, Loading.f127895a, null, false, false, null, null, null, false, false, false, false, false, false, false, false, false, null, 4194271, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignInViewState z(ApiResponse apiResponse, SignInViewState signInViewState) {
        return SignInViewState.b(signInViewState, null, null, null, null, null, apiResponse.b(), null, false, false, null, null, null, false, false, false, false, false, false, false, false, false, null, 4194271, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new SignInViewModel$signUp$1(this.f110524d, this.f110525f, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b6  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r13.f110523c
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L3a
            if (r1 == r5) goto L36
            if (r1 == r4) goto L28
            if (r1 != r3) goto L20
            java.lang.Object r0 = r13.f110522b
            cz.mobilesoft.coreblock.rest.response.LoginResponse r0 = (cz.mobilesoft.coreblock.rest.response.LoginResponse) r0
            java.lang.Object r0 = r13.f110521a
            cz.mobilesoft.coreblock.rest.ApiResponse r0 = (cz.mobilesoft.coreblock.rest.ApiResponse) r0
            kotlin.ResultKt.b(r14)
            r10 = r13
            goto L9c
        L20:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L28:
            java.lang.Object r1 = r13.f110522b
            cz.mobilesoft.coreblock.rest.response.LoginResponse r1 = (cz.mobilesoft.coreblock.rest.response.LoginResponse) r1
            java.lang.Object r4 = r13.f110521a
            cz.mobilesoft.coreblock.rest.ApiResponse r4 = (cz.mobilesoft.coreblock.rest.ApiResponse) r4
            kotlin.ResultKt.b(r14)
            r10 = r13
            r14 = r4
            goto L88
        L36:
            kotlin.ResultKt.b(r14)
            goto L5e
        L3a:
            kotlin.ResultKt.b(r14)
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel r14 = r13.f110524d
            cz.mobilesoft.coreblock.scene.more.signin.p3 r1 = new cz.mobilesoft.coreblock.scene.more.signin.p3
            r1.<init>()
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel.s1(r14, r1)
            cz.mobilesoft.coreblock.rest.RestClient r14 = cz.mobilesoft.coreblock.rest.RestClient.f98457a
            cz.mobilesoft.coreblock.rest.ApiInterface r1 = r14.t()
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$signUp$1$response$1 r6 = new cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$signUp$1$response$1
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewState r7 = r13.f110525f
            r6.<init>(r7, r2)
            r13.f110523c = r5
            java.lang.Object r14 = r14.H(r1, r6, r13)
            if (r14 != r0) goto L5e
            r10 = r13
            goto L9a
        L5e:
            cz.mobilesoft.coreblock.rest.ApiResponse r14 = (cz.mobilesoft.coreblock.rest.ApiResponse) r14
            boolean r1 = r14 instanceof cz.mobilesoft.coreblock.rest.ApiResponse.Data
            if (r1 == 0) goto L9e
            r1 = r14
            cz.mobilesoft.coreblock.rest.ApiResponse$Data r1 = (cz.mobilesoft.coreblock.rest.ApiResponse.Data) r1
            java.lang.Object r1 = r1.c()
            r7 = r1
            cz.mobilesoft.coreblock.rest.response.LoginResponse r7 = (cz.mobilesoft.coreblock.rest.response.LoginResponse) r7
            cz.mobilesoft.coreblock.util.SessionManager r6 = cz.mobilesoft.coreblock.util.SessionManager.f127910a
            r13.f110521a = r14
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r13.f110522b = r1
            r13.f110523c = r4
            java.lang.String r8 = "local"
            r9 = 0
            r11 = 4
            r12 = 0
            r10 = r13
            java.lang.Object r1 = cz.mobilesoft.coreblock.util.SessionManager.u(r6, r7, r8, r9, r10, r11, r12)
            if (r1 != r0) goto L87
            goto L9a
        L87:
            r1 = r7
        L88:
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel r4 = r10.f110524d
            r10.f110521a = r14
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r10.f110522b = r1
            r10.f110523c = r3
            java.lang.Object r1 = cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel.r1(r4, r5, r13)
            if (r1 != r0) goto L9b
        L9a:
            return r0
        L9b:
            r0 = r14
        L9c:
            r14 = r0
            goto L9f
        L9e:
            r10 = r13
        L9f:
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel r0 = r10.f110524d
            cz.mobilesoft.coreblock.scene.more.signin.q3 r1 = new cz.mobilesoft.coreblock.scene.more.signin.q3
            r1.<init>()
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel.s1(r0, r1)
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel r14 = r10.f110524d
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel.n1(r14)
            cz.mobilesoft.coreblock.util.SessionManager r14 = cz.mobilesoft.coreblock.util.SessionManager.f127910a
            boolean r14 = r14.r()
            if (r14 == 0) goto Lbd
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel r14 = r10.f110524d
            cz.mobilesoft.coreblock.scene.more.signin.SignInMethod r0 = cz.mobilesoft.coreblock.scene.more.signin.SignInMethod.Email
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel.k1(r14, r2, r0)
        Lbd:
            kotlin.Unit r14 = kotlin.Unit.f139807a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$signUp$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((SignInViewModel$signUp$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
