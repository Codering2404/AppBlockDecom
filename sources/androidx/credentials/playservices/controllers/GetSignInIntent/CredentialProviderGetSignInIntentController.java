package androidx.credentials.playservices.controllers.GetSignInIntent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.util.Log;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.GetCredentialInterruptedException;
import androidx.credentials.exceptions.GetCredentialUnknownException;
import androidx.credentials.exceptions.GetCredentialUnsupportedException;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import androidx.credentials.playservices.HiddenActivity;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import androidx.credentials.playservices.controllers.CredentialProviderController;
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.common.api.ApiException;
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption;
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
public final class CredentialProviderGetSignInIntentController extends CredentialProviderController<GetCredentialRequest, GetSignInIntentRequest, SignInCredential, GetCredentialResponse, GetCredentialException> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Companion f35167l = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f35168g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CredentialManagerCallback f35169h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Executor f35170i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CancellationSignal f35171j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final CredentialProviderGetSignInIntentController$resultReceiver$1 f35172k;

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
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.credentials.playservices.controllers.GetSignInIntent.CredentialProviderGetSignInIntentController$resultReceiver$1] */
    public CredentialProviderGetSignInIntentController(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f35168g = context;
        final Handler handler = new Handler(Looper.getMainLooper());
        this.f35172k = new ResultReceiver(handler) { // from class: androidx.credentials.playservices.controllers.GetSignInIntent.CredentialProviderGetSignInIntentController$resultReceiver$1
            @Override // android.os.ResultReceiver
            public void onReceiveResult(int i3, Bundle resultData) {
                Intrinsics.checkNotNullParameter(resultData, "resultData");
                if (this.f35186a.f(resultData, new CredentialProviderGetSignInIntentController$resultReceiver$1$onReceiveResult$1(CredentialProviderBaseController.f35097b), this.f35186a.p(), this.f35186a.o(), this.f35186a.f35171j)) {
                    return;
                }
                this.f35186a.q(resultData.getInt("ACTIVITY_REQUEST_CODE"), i3, (Intent) resultData.getParcelable("RESULT_DATA"));
            }
        };
    }

    public GetSignInIntentRequest l(GetCredentialRequest request) throws GetCredentialUnsupportedException {
        Intrinsics.checkNotNullParameter(request, "request");
        if (request.a().size() != 1) {
            throw new GetCredentialUnsupportedException("GetSignInWithGoogleOption cannot be combined with other options.");
        }
        Object obj = request.a().get(0);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption");
        GetSignInWithGoogleOption getSignInWithGoogleOption = (GetSignInWithGoogleOption) obj;
        GetSignInIntentRequest getSignInIntentRequestA = GetSignInIntentRequest.M().e(getSignInWithGoogleOption.i()).b(getSignInWithGoogleOption.g()).c(getSignInWithGoogleOption.h()).a();
        Intrinsics.checkNotNullExpressionValue(getSignInIntentRequestA, "build(...)");
        return getSignInIntentRequestA;
    }

    protected GetCredentialResponse m(SignInCredential response) throws GetCredentialUnknownException {
        GoogleIdTokenCredential googleIdTokenCredentialN;
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.g0() != null) {
            googleIdTokenCredentialN = n(response);
        } else {
            Log.w("GetSignInIntent", "Credential returned but no google Id found");
            googleIdTokenCredentialN = null;
        }
        if (googleIdTokenCredentialN != null) {
            return new GetCredentialResponse(googleIdTokenCredentialN);
        }
        throw new GetCredentialUnknownException("When attempting to convert get response, null credential found");
    }

    public final GoogleIdTokenCredential n(SignInCredential response) throws GetCredentialUnknownException {
        Intrinsics.checkNotNullParameter(response, "response");
        GoogleIdTokenCredential.Builder builder = new GoogleIdTokenCredential.Builder();
        String strJ0 = response.j0();
        Intrinsics.checkNotNullExpressionValue(strJ0, "getId(...)");
        GoogleIdTokenCredential.Builder builderE = builder.e(strJ0);
        try {
            String strG0 = response.g0();
            Intrinsics.checkNotNull(strG0);
            builderE.f(strG0);
            if (response.M() != null) {
                builderE.b(response.M());
            }
            if (response.O() != null) {
                builderE.d(response.O());
            }
            if (response.N() != null) {
                builderE.c(response.N());
            }
            if (response.z0() != null) {
                builderE.g(response.z0());
            }
            if (response.h1() != null) {
                builderE.h(response.h1());
            }
            return builderE.a();
        } catch (Exception unused) {
            throw new GetCredentialUnknownException("When attempting to convert get response, null Google ID Token found");
        }
    }

    public final CredentialManagerCallback o() {
        CredentialManagerCallback credentialManagerCallback = this.f35169h;
        if (credentialManagerCallback != null) {
            return credentialManagerCallback;
        }
        Intrinsics.throwUninitializedPropertyAccessException(Callback.METHOD_NAME);
        return null;
    }

    public final Executor p() {
        Executor executor = this.f35170i;
        if (executor != null) {
            return executor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("executor");
        return null;
    }

    public final void q(int i3, int i4, Intent intent) {
        CredentialProviderBaseController.Companion companion = CredentialProviderBaseController.f35097b;
        if (i3 != companion.b()) {
            Log.w("GetSignInIntent", "Returned request code " + companion.b() + " which  does not match what was given " + i3);
            return;
        }
        if (CredentialProviderController.h(i4, new Function2<CancellationSignal, Function0<? extends Unit>, Unit>() { // from class: androidx.credentials.playservices.controllers.GetSignInIntent.CredentialProviderGetSignInIntentController$handleResponse$1
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
        }, new CredentialProviderGetSignInIntentController$handleResponse$2(this), this.f35171j)) {
            return;
        }
        try {
            SignInCredential signInCredentialFromIntent = Identity.c(this.f35168g).getSignInCredentialFromIntent(intent);
            Intrinsics.checkNotNullExpressionValue(signInCredentialFromIntent, "getSignInCredentialFromIntent(...)");
            CredentialProviderController.e(this.f35171j, new CredentialProviderGetSignInIntentController$handleResponse$3(this, m(signInCredentialFromIntent)));
        } catch (GetCredentialException e3) {
            CredentialProviderController.e(this.f35171j, new CredentialProviderGetSignInIntentController$handleResponse$5(this, e3));
        } catch (ApiException e4) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.f140144a = new GetCredentialUnknownException(e4.getMessage());
            if (e4.getStatusCode() == 16) {
                objectRef.f140144a = new GetCredentialCancellationException(e4.getMessage());
            } else if (CredentialProviderBaseController.f35097b.d().contains(Integer.valueOf(e4.getStatusCode()))) {
                objectRef.f140144a = new GetCredentialInterruptedException(e4.getMessage());
            }
            CredentialProviderController.e(this.f35171j, new CredentialProviderGetSignInIntentController$handleResponse$4(this, objectRef));
        } catch (Throwable th) {
            CredentialProviderController.e(this.f35171j, new CredentialProviderGetSignInIntentController$handleResponse$6(this, new GetCredentialUnknownException(th.getMessage())));
        }
    }

    public void r(GetCredentialRequest request, CredentialManagerCallback callback, Executor executor, CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.f35171j = cancellationSignal;
        s(callback);
        t(executor);
        if (CredentialProviderPlayServicesImpl.Companion.a(cancellationSignal)) {
            return;
        }
        try {
            GetSignInIntentRequest getSignInIntentRequestL = l(request);
            Intent intent = new Intent(this.f35168g, (Class<?>) HiddenActivity.class);
            intent.putExtra("REQUEST_TYPE", getSignInIntentRequestL);
            c(this.f35172k, intent, "SIGN_IN_INTENT");
            this.f35168g.startActivity(intent);
        } catch (Exception e3) {
            if (e3 instanceof GetCredentialUnsupportedException) {
                CredentialProviderController.e(cancellationSignal, new CredentialProviderGetSignInIntentController$invokePlayServices$1(this, e3));
            } else {
                CredentialProviderController.e(cancellationSignal, new CredentialProviderGetSignInIntentController$invokePlayServices$2(this));
            }
        }
    }

    public final void s(CredentialManagerCallback credentialManagerCallback) {
        Intrinsics.checkNotNullParameter(credentialManagerCallback, "<set-?>");
        this.f35169h = credentialManagerCallback;
    }

    public final void t(Executor executor) {
        Intrinsics.checkNotNullParameter(executor, "<set-?>");
        this.f35170i = executor;
    }
}
