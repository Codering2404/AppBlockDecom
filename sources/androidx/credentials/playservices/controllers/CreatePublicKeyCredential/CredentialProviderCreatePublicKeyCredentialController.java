package androidx.credentials.playservices.controllers.CreatePublicKeyCredential;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.util.Log;
import androidx.credentials.CreateCredentialResponse;
import androidx.credentials.CreatePublicKeyCredentialRequest;
import androidx.credentials.CreatePublicKeyCredentialResponse;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.CreateCredentialUnknownException;
import androidx.credentials.exceptions.domerrors.EncodingError;
import androidx.credentials.exceptions.domerrors.UnknownError;
import androidx.credentials.exceptions.publickeycredential.CreatePublicKeyCredentialDomException;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import androidx.credentials.playservices.HiddenActivity;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import androidx.credentials.playservices.controllers.CredentialProviderController;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredential;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialCreationOptions;
import com.sun.jna.Callback;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

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
public final class CredentialProviderCreatePublicKeyCredentialController extends CredentialProviderController<CreatePublicKeyCredentialRequest, PublicKeyCredentialCreationOptions, PublicKeyCredential, CreateCredentialResponse, CreateCredentialException> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Companion f35008l = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f35009g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private CredentialManagerCallback f35010h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Executor f35011i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CancellationSignal f35012j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final CredentialProviderCreatePublicKeyCredentialController$resultReceiver$1 f35013k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CredentialProviderCreatePublicKeyCredentialController a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new CredentialProviderCreatePublicKeyCredentialController(context);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.credentials.playservices.controllers.CreatePublicKeyCredential.CredentialProviderCreatePublicKeyCredentialController$resultReceiver$1] */
    public CredentialProviderCreatePublicKeyCredentialController(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f35009g = context;
        final Handler handler = new Handler(Looper.getMainLooper());
        this.f35013k = new ResultReceiver(handler) { // from class: androidx.credentials.playservices.controllers.CreatePublicKeyCredential.CredentialProviderCreatePublicKeyCredentialController$resultReceiver$1
            @Override // android.os.ResultReceiver
            public void onReceiveResult(int i3, Bundle resultData) {
                Executor executor;
                CredentialManagerCallback credentialManagerCallback;
                Intrinsics.checkNotNullParameter(resultData, "resultData");
                CredentialProviderCreatePublicKeyCredentialController credentialProviderCreatePublicKeyCredentialController = this.f35029a;
                CredentialProviderCreatePublicKeyCredentialController$resultReceiver$1$onReceiveResult$1 credentialProviderCreatePublicKeyCredentialController$resultReceiver$1$onReceiveResult$1 = new CredentialProviderCreatePublicKeyCredentialController$resultReceiver$1$onReceiveResult$1(CredentialProviderBaseController.f35097b);
                Executor executor2 = this.f35029a.f35011i;
                if (executor2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("executor");
                    executor = null;
                } else {
                    executor = executor2;
                }
                CredentialManagerCallback credentialManagerCallback2 = this.f35029a.f35010h;
                if (credentialManagerCallback2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(Callback.METHOD_NAME);
                    credentialManagerCallback = null;
                } else {
                    credentialManagerCallback = credentialManagerCallback2;
                }
                if (credentialProviderCreatePublicKeyCredentialController.f(resultData, credentialProviderCreatePublicKeyCredentialController$resultReceiver$1$onReceiveResult$1, executor, credentialManagerCallback, this.f35029a.f35012j)) {
                    return;
                }
                this.f35029a.s(resultData.getInt("ACTIVITY_REQUEST_CODE"), i3, (Intent) resultData.getParcelable("RESULT_DATA"));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CreatePublicKeyCredentialDomException j(JSONException jSONException) {
        String message = jSONException.getMessage();
        return (message == null || message.length() <= 0) ? new CreatePublicKeyCredentialDomException(new EncodingError(), "Unknown error") : new CreatePublicKeyCredentialDomException(new EncodingError(), message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(CredentialProviderCreatePublicKeyCredentialController credentialProviderCreatePublicKeyCredentialController) {
        CredentialManagerCallback credentialManagerCallback = credentialProviderCreatePublicKeyCredentialController.f35010h;
        if (credentialManagerCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Callback.METHOD_NAME);
            credentialManagerCallback = null;
        }
        credentialManagerCallback.a(new CreatePublicKeyCredentialDomException(new UnknownError(), "Upon handling create public key credential response, fido module giving null bytes indicating internal error"));
    }

    public PublicKeyCredentialCreationOptions q(CreatePublicKeyCredentialRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return PublicKeyCredentialControllerUtility.f35030a.d(request, this.f35009g);
    }

    public CreateCredentialResponse r(PublicKeyCredential response) throws CreateCredentialUnknownException {
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            String strH1 = response.h1();
            Intrinsics.checkNotNullExpressionValue(strH1, "toJson(...)");
            return new CreatePublicKeyCredentialResponse(strH1);
        } catch (Throwable th) {
            throw new CreateCredentialUnknownException("The PublicKeyCredential response json had an unexpected exception when parsing: " + th.getMessage());
        }
    }

    public final void s(int i3, int i4, Intent intent) {
        CredentialProviderBaseController.Companion companion = CredentialProviderBaseController.f35097b;
        if (i3 != companion.b()) {
            Log.w("CreatePublicKey", "Returned request code " + companion.b() + " does not match what was given " + i3);
            return;
        }
        if (CredentialProviderController.g(i4, new Function2<CancellationSignal, Function0<? extends Unit>, Unit>() { // from class: androidx.credentials.playservices.controllers.CreatePublicKeyCredential.CredentialProviderCreatePublicKeyCredentialController$handleResponse$1
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
        }, new CredentialProviderCreatePublicKeyCredentialController$handleResponse$2(this), this.f35012j)) {
            return;
        }
        Executor executor = null;
        byte[] byteArrayExtra = intent != null ? intent.getByteArrayExtra("FIDO2_CREDENTIAL_EXTRA") : null;
        if (byteArrayExtra == null) {
            if (CredentialProviderPlayServicesImpl.Companion.a(this.f35012j)) {
                return;
            }
            Executor executor2 = this.f35011i;
            if (executor2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("executor");
            } else {
                executor = executor2;
            }
            executor.execute(new Runnable() { // from class: androidx.credentials.playservices.controllers.CreatePublicKeyCredential.a
                @Override // java.lang.Runnable
                public final void run() {
                    CredentialProviderCreatePublicKeyCredentialController.t(this.f35057a);
                }
            });
            return;
        }
        PublicKeyCredential publicKeyCredentialM = PublicKeyCredential.M(byteArrayExtra);
        Intrinsics.checkNotNullExpressionValue(publicKeyCredentialM, "deserializeFromBytes(...)");
        CreateCredentialException createCredentialExceptionM = PublicKeyCredentialControllerUtility.f35030a.M(publicKeyCredentialM);
        if (createCredentialExceptionM != null) {
            CredentialProviderController.e(this.f35012j, new CredentialProviderCreatePublicKeyCredentialController$handleResponse$4(this, createCredentialExceptionM));
            return;
        }
        try {
            CredentialProviderController.e(this.f35012j, new CredentialProviderCreatePublicKeyCredentialController$handleResponse$5(this, r(publicKeyCredentialM)));
        } catch (JSONException e3) {
            CredentialProviderController.e(this.f35012j, new CredentialProviderCreatePublicKeyCredentialController$handleResponse$6(this, e3));
        } catch (Throwable th) {
            CredentialProviderController.e(this.f35012j, new CredentialProviderCreatePublicKeyCredentialController$handleResponse$7(this, th));
        }
    }

    public void u(CreatePublicKeyCredentialRequest request, CredentialManagerCallback callback, Executor executor, CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.f35012j = cancellationSignal;
        this.f35010h = callback;
        this.f35011i = executor;
        try {
            PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptionsQ = q(request);
            if (CredentialProviderPlayServicesImpl.Companion.a(cancellationSignal)) {
                return;
            }
            Intent intent = new Intent(this.f35009g, (Class<?>) HiddenActivity.class);
            intent.putExtra("REQUEST_TYPE", publicKeyCredentialCreationOptionsQ);
            c(this.f35013k, intent, "CREATE_PUBLIC_KEY_CREDENTIAL");
            try {
                this.f35009g.startActivity(intent);
            } catch (Exception unused) {
                CredentialProviderController.e(cancellationSignal, new CredentialProviderCreatePublicKeyCredentialController$invokePlayServices$3(this));
            }
        } catch (JSONException e3) {
            CredentialProviderController.e(cancellationSignal, new CredentialProviderCreatePublicKeyCredentialController$invokePlayServices$1(this, e3));
        } catch (Throwable th) {
            CredentialProviderController.e(cancellationSignal, new CredentialProviderCreatePublicKeyCredentialController$invokePlayServices$2(this, th));
        }
    }
}
