package cz.mobilesoft.coreblock.scene.more.signin;

import com.facebook.internal.FacebookRequestErrorClassification;
import cz.mobilesoft.coreblock.rest.ApiResponse;
import cz.mobilesoft.coreblock.rest.response.LoginResponse;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$signInSocial$1", f = "SignInViewModel.kt", l = {482, 491, FacebookRequestErrorClassification.ESC_APP_INACTIVE, 498}, m = "invokeSuspend", v = 1)
final class SignInViewModel$signInSocial$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f110508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f110509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f110510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ SignInViewModel f110511d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f110512f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ String f110513g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SignInViewModel$signInSocial$1(SignInViewModel signInViewModel, String str, String str2, Continuation continuation) {
        super(1, continuation);
        this.f110511d = signInViewModel;
        this.f110512f = str;
        this.f110513g = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignInViewState A(LoginResponse loginResponse, SignInViewState signInViewState) {
        return SignInViewState.b(signInViewState, null, null, loginResponse.getEmail(), null, null, null, null, false, false, null, null, null, false, false, false, false, false, false, false, false, false, null, 4194299, null);
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
    public final Continuation create(Continuation continuation) {
        return new SignInViewModel$signInSocial$1(this.f110511d, this.f110512f, this.f110513g, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$signInSocial$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((SignInViewModel$signInSocial$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
