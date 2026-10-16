package cz.mobilesoft.coreblock.scene.more.signin;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import cz.mobilesoft.coreblock.rest.ApiInterface;
import cz.mobilesoft.coreblock.rest.request.UpdateUserDetailsRequest;
import cz.mobilesoft.coreblock.rest.response.UserDetailsResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$onEvent$6", f = "SignInViewModel.kt", l = {153, 154, ModuleDescriptor.MODULE_VERSION, 156}, m = "invokeSuspend", v = 1)
final class SignInViewModel$onEvent$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f110448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f110449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SignInViewModel f110450c;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$onEvent$6$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$onEvent$6$1", f = "SignInViewModel.kt", l = {154}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ApiInterface, Continuation<? super Response<UserDetailsResponse>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f110451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f110452b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f110453c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation continuation) {
            super(2, continuation);
            this.f110453c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f110453c, continuation);
            anonymousClass1.f110452b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(ApiInterface apiInterface, Continuation continuation) {
            return ((AnonymousClass1) create(apiInterface, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ApiInterface apiInterface = (ApiInterface) this.f110452b;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f110451a;
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return obj;
            }
            ResultKt.b(obj);
            UpdateUserDetailsRequest updateUserDetailsRequest = new UpdateUserDetailsRequest(this.f110453c);
            this.f110452b = SpillingKt.a(apiInterface);
            this.f110451a = 1;
            Object objT = apiInterface.t(updateUserDetailsRequest, this);
            return objT == objF ? objF : objT;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SignInViewModel$onEvent$6(SignInViewModel signInViewModel, Continuation continuation) {
        super(2, continuation);
        this.f110450c = signInViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SignInViewModel$onEvent$6(this.f110450c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x009f, code lost:
    
        if (r9.P0(r3, r8) != r0) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008f A[PHI: r1
      0x008f: PHI (r1v4 java.lang.String) = (r1v3 java.lang.String), (r1v11 java.lang.String) binds: [B:21:0x008c, B:11:0x0025] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.f110449b
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L3d
            if (r1 == r5) goto L35
            if (r1 == r4) goto L2d
            if (r1 == r3) goto L25
            if (r1 != r2) goto L1d
            java.lang.Object r0 = r8.f110448a
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.b(r9)
            goto La2
        L1d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L25:
            java.lang.Object r1 = r8.f110448a
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.b(r9)
            goto L8f
        L2d:
            java.lang.Object r1 = r8.f110448a
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.b(r9)
            goto L7e
        L35:
            java.lang.Object r1 = r8.f110448a
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.b(r9)
            goto L63
        L3d:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel r9 = r8.f110450c
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewState r9 = cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel.h1(r9)
            java.lang.String r9 = r9.l()
            java.lang.CharSequence r9 = kotlin.text.StringsKt.t1(r9)
            java.lang.String r1 = r9.toString()
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel r9 = r8.f110450c
            cz.mobilesoft.coreblock.storage.datastore.SessionDataStore r9 = cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel.j1(r9)
            r8.f110448a = r1
            r8.f110449b = r5
            java.lang.Object r9 = r9.f0(r1, r8)
            if (r9 != r0) goto L63
            goto La1
        L63:
            cz.mobilesoft.coreblock.rest.RestClient r9 = cz.mobilesoft.coreblock.rest.RestClient.f98457a
            cz.mobilesoft.coreblock.rest.ApiInterface r5 = r9.t()
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$onEvent$6$1 r6 = new cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$onEvent$6$1
            r7 = 0
            r6.<init>(r1, r7)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r8.f110448a = r7
            r8.f110449b = r4
            java.lang.Object r9 = r9.H(r5, r6, r8)
            if (r9 != r0) goto L7e
            goto La1
        L7e:
            cz.mobilesoft.coreblock.util.SessionManager r9 = cz.mobilesoft.coreblock.util.SessionManager.f127910a
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r8.f110448a = r4
            r8.f110449b = r3
            java.lang.Object r9 = r9.D(r8)
            if (r9 != r0) goto L8f
            goto La1
        L8f:
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel r9 = r8.f110450c
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewCommand$ShowWelcomeScreen r3 = cz.mobilesoft.coreblock.scene.more.signin.SignInViewCommand.ShowWelcomeScreen.f110416a
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r8.f110448a = r1
            r8.f110449b = r2
            java.lang.Object r9 = cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel.l1(r9, r3, r8)
            if (r9 != r0) goto La2
        La1:
            return r0
        La2:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$onEvent$6.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SignInViewModel$onEvent$6) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
