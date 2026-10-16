package androidx.credentials.playservices.controllers.BeginSignIn;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.util.Log;
import androidx.credentials.Credential;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.PasswordCredential;
import androidx.credentials.PublicKeyCredential;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.GetCredentialInterruptedException;
import androidx.credentials.exceptions.GetCredentialUnknownException;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import androidx.credentials.playservices.HiddenActivity;
import androidx.credentials.playservices.controllers.CreatePublicKeyCredential.PublicKeyCredentialControllerUtility;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import androidx.credentials.playservices.controllers.CredentialProviderController;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.common.api.ApiException;
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential;
import com.sun.jna.Callback;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class CredentialProviderBeginSignInController extends CredentialProviderController<GetCredentialRequest, BeginSignInRequest, SignInCredential, GetCredentialResponse, GetCredentialException> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Companion f34962l = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f34963g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CredentialManagerCallback f34964h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Executor f34965i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CancellationSignal f34966j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final CredentialProviderBeginSignInController$resultReceiver$1 f34967k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.credentials.playservices.controllers.BeginSignIn.CredentialProviderBeginSignInController$resultReceiver$1] */
    public CredentialProviderBeginSignInController(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f34963g = context;
        final Handler handler = new Handler(Looper.getMainLooper());
        this.f34967k = new ResultReceiver(handler) { // from class: androidx.credentials.playservices.controllers.BeginSignIn.CredentialProviderBeginSignInController$resultReceiver$1
            @Override // android.os.ResultReceiver
            public void onReceiveResult(int i3, Bundle resultData) {
                Intrinsics.checkNotNullParameter(resultData, "resultData");
                if (this.f34979a.f(resultData, new CredentialProviderBeginSignInController$resultReceiver$1$onReceiveResult$1(CredentialProviderBaseController.f35097b), this.f34979a.p(), this.f34979a.o(), this.f34979a.f34966j)) {
                    return;
                }
                this.f34979a.q(resultData.getInt("ACTIVITY_REQUEST_CODE"), i3, (Intent) resultData.getParcelable("RESULT_DATA"));
            }
        };
    }

    private final GoogleIdTokenCredential n(SignInCredential signInCredential) {
        GoogleIdTokenCredential.Builder builder = new GoogleIdTokenCredential.Builder();
        String strJ0 = signInCredential.j0();
        Intrinsics.checkNotNullExpressionValue(strJ0, "getId(...)");
        GoogleIdTokenCredential.Builder builderE = builder.e(strJ0);
        String strG0 = signInCredential.g0();
        Intrinsics.checkNotNull(strG0);
        GoogleIdTokenCredential.Builder builderF = builderE.f(strG0);
        if (signInCredential.M() != null) {
            builderF.b(signInCredential.M());
        }
        if (signInCredential.O() != null) {
            builderF.d(signInCredential.O());
        }
        if (signInCredential.N() != null) {
            builderF.c(signInCredential.N());
        }
        if (signInCredential.z0() != null) {
            builderF.g(signInCredential.z0());
        }
        if (signInCredential.h1() != null) {
            builderF.h(signInCredential.h1());
        }
        return builderF.a();
    }

    public BeginSignInRequest l(GetCredentialRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return BeginSignInControllerUtility.f34961a.a(request, this.f34963g);
    }

    public GetCredentialResponse m(SignInCredential response) throws GetCredentialUnknownException {
        Credential publicKeyCredential;
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.w0() != null) {
            String strJ0 = response.j0();
            Intrinsics.checkNotNullExpressionValue(strJ0, "getId(...)");
            String strW0 = response.w0();
            Intrinsics.checkNotNull(strW0);
            publicKeyCredential = new PasswordCredential(strJ0, strW0);
        } else if (response.g0() != null) {
            publicKeyCredential = n(response);
        } else if (response.J2() != null) {
            publicKeyCredential = new PublicKeyCredential(PublicKeyCredentialControllerUtility.f35030a.N(response));
        } else {
            Log.w("BeginSignIn", "Credential returned but no google Id or password or passkey found");
            publicKeyCredential = null;
        }
        if (publicKeyCredential != null) {
            return new GetCredentialResponse(publicKeyCredential);
        }
        throw new GetCredentialUnknownException("When attempting to convert get response, null credential found");
    }

    public final CredentialManagerCallback o() {
        CredentialManagerCallback credentialManagerCallback = this.f34964h;
        if (credentialManagerCallback != null) {
            return credentialManagerCallback;
        }
        Intrinsics.throwUninitializedPropertyAccessException(Callback.METHOD_NAME);
        return null;
    }

    public final Executor p() {
        Executor executor = this.f34965i;
        if (executor != null) {
            return executor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("executor");
        return null;
    }

    public final void q(int i3, int i4, Intent intent) {
        CredentialProviderBaseController.Companion companion = CredentialProviderBaseController.f35097b;
        if (i3 != companion.b()) {
            Log.w("BeginSignIn", "Returned request code " + companion.b() + " which  does not match what was given " + i3);
            return;
        }
        if (CredentialProviderController.h(i4, new Function2<CancellationSignal, Function0<? extends Unit>, Unit>() { // from class: androidx.credentials.playservices.controllers.BeginSignIn.CredentialProviderBeginSignInController$handleResponse$1
            public final void c(CancellationSignal cancellationSignal, Function0 f3) {
                Intrinsics.checkNotNullParameter(f3, "f");
                CredentialProviderController.Companion companion2 = CredentialProviderController.f35101f;
                CredentialProviderController.e(cancellationSignal, f3);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((CancellationSignal) obj, (Function0) obj2);
                return Unit.f139807a;
            }
        }, new CredentialProviderBeginSignInController$handleResponse$2(this), this.f34966j)) {
            return;
        }
        try {
            SignInCredential signInCredentialFromIntent = Identity.c(this.f34963g).getSignInCredentialFromIntent(intent);
            Intrinsics.checkNotNullExpressionValue(signInCredentialFromIntent, "getSignInCredentialFromIntent(...)");
            CredentialProviderController.e(this.f34966j, new CredentialProviderBeginSignInController$handleResponse$3(this, m(signInCredentialFromIntent)));
        } catch (GetCredentialException e3) {
            CredentialProviderController.e(this.f34966j, new CredentialProviderBeginSignInController$handleResponse$5(this, e3));
        } catch (ApiException e4) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.f140144a = new GetCredentialUnknownException(e4.getMessage());
            if (e4.getStatusCode() == 16) {
                objectRef.f140144a = new GetCredentialCancellationException(e4.getMessage());
            } else if (CredentialProviderBaseController.f35097b.d().contains(Integer.valueOf(e4.getStatusCode()))) {
                objectRef.f140144a = new GetCredentialInterruptedException(e4.getMessage());
            }
            CredentialProviderController.e(this.f34966j, new CredentialProviderBeginSignInController$handleResponse$4(this, objectRef));
        } catch (Throwable th) {
            CredentialProviderController.e(this.f34966j, new CredentialProviderBeginSignInController$handleResponse$6(this, new GetCredentialUnknownException(th.getMessage())));
        }
    }

    public void r(GetCredentialRequest request, CredentialManagerCallback callback, Executor executor, CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.f34966j = cancellationSignal;
        s(callback);
        t(executor);
        if (CredentialProviderPlayServicesImpl.Companion.a(cancellationSignal)) {
            return;
        }
        BeginSignInRequest beginSignInRequestL = l(request);
        Intent intent = new Intent(this.f34963g, (Class<?>) HiddenActivity.class);
        intent.putExtra("REQUEST_TYPE", beginSignInRequestL);
        c(this.f34967k, intent, "BEGIN_SIGN_IN");
        try {
            this.f34963g.startActivity(intent);
        } catch (Exception unused) {
            CredentialProviderController.e(cancellationSignal, new CredentialProviderBeginSignInController$invokePlayServices$1(this));
        }
    }

    public final void s(CredentialManagerCallback credentialManagerCallback) {
        Intrinsics.checkNotNullParameter(credentialManagerCallback, "<set-?>");
        this.f34964h = credentialManagerCallback;
    }

    public final void t(Executor executor) {
        Intrinsics.checkNotNullParameter(executor, "<set-?>");
        this.f34965i = executor;
    }
}
