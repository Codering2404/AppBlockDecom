package cz.mobilesoft.coreblock.scene.more.signin;

import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$signIn$1", f = "SignInViewModel.kt", l = {394, 398, RCHTTPStatusCodes.BAD_REQUEST}, m = "invokeSuspend", v = 1)
final class SignInViewModel$signIn$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f110492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f110493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f110494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f110495d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ SignInViewModel f110496f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ SignInViewState f110497g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SignInViewModel$signIn$1(SignInViewModel signInViewModel, SignInViewState signInViewState, Continuation continuation) {
        super(1, continuation);
        this.f110496f = signInViewModel;
        this.f110497g = signInViewState;
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
        return new SignInViewModel$signIn$1(this.f110496f, this.f110497g, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bf  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$signIn$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((SignInViewModel$signIn$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
