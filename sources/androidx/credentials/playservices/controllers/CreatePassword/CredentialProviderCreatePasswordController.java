package androidx.credentials.playservices.controllers.CreatePassword;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.util.Log;
import androidx.credentials.CreateCredentialResponse;
import androidx.credentials.CreatePasswordRequest;
import androidx.credentials.CreatePasswordResponse;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import androidx.credentials.playservices.HiddenActivity;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import androidx.credentials.playservices.controllers.CredentialProviderController;
import com.google.android.gms.auth.api.identity.SavePasswordRequest;
import com.google.android.gms.auth.api.identity.SignInPassword;
import com.sun.jna.Callback;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class CredentialProviderCreatePasswordController extends CredentialProviderController<CreatePasswordRequest, SavePasswordRequest, Unit, CreateCredentialResponse, CreateCredentialException> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Companion f34991l = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f34992g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private CredentialManagerCallback f34993h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Executor f34994i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CancellationSignal f34995j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final CredentialProviderCreatePasswordController$resultReceiver$1 f34996k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CredentialProviderCreatePasswordController a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new CredentialProviderCreatePasswordController(context);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.credentials.playservices.controllers.CreatePassword.CredentialProviderCreatePasswordController$resultReceiver$1] */
    public CredentialProviderCreatePasswordController(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f34992g = context;
        final Handler handler = new Handler(Looper.getMainLooper());
        this.f34996k = new ResultReceiver(handler) { // from class: androidx.credentials.playservices.controllers.CreatePassword.CredentialProviderCreatePasswordController$resultReceiver$1
            @Override // android.os.ResultReceiver
            public void onReceiveResult(int i3, Bundle resultData) {
                Executor executor;
                CredentialManagerCallback credentialManagerCallback;
                Intrinsics.checkNotNullParameter(resultData, "resultData");
                CredentialProviderCreatePasswordController credentialProviderCreatePasswordController = this.f35002a;
                CredentialProviderCreatePasswordController$resultReceiver$1$onReceiveResult$1 credentialProviderCreatePasswordController$resultReceiver$1$onReceiveResult$1 = new CredentialProviderCreatePasswordController$resultReceiver$1$onReceiveResult$1(CredentialProviderBaseController.f35097b);
                Executor executor2 = this.f35002a.f34994i;
                if (executor2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("executor");
                    executor = null;
                } else {
                    executor = executor2;
                }
                CredentialManagerCallback credentialManagerCallback2 = this.f35002a.f34993h;
                if (credentialManagerCallback2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(Callback.METHOD_NAME);
                    credentialManagerCallback = null;
                } else {
                    credentialManagerCallback = credentialManagerCallback2;
                }
                if (credentialProviderCreatePasswordController.f(resultData, credentialProviderCreatePasswordController$resultReceiver$1$onReceiveResult$1, executor, credentialManagerCallback, this.f35002a.f34995j)) {
                    return;
                }
                this.f35002a.p(resultData.getInt("ACTIVITY_REQUEST_CODE"), i3);
            }
        };
    }

    public SavePasswordRequest n(CreatePasswordRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        SavePasswordRequest savePasswordRequestA = SavePasswordRequest.M().b(new SignInPassword(request.c(), request.d())).a();
        Intrinsics.checkNotNullExpressionValue(savePasswordRequestA, "build(...)");
        return savePasswordRequestA;
    }

    public CreateCredentialResponse o(Unit response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return new CreatePasswordResponse();
    }

    public final void p(int i3, int i4) {
        CredentialProviderBaseController.Companion companion = CredentialProviderBaseController.f35097b;
        if (i3 == companion.b()) {
            if (CredentialProviderController.g(i4, new Function2<CancellationSignal, Function0<? extends Unit>, Unit>() { // from class: androidx.credentials.playservices.controllers.CreatePassword.CredentialProviderCreatePasswordController$handleResponse$1
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
            }, new CredentialProviderCreatePasswordController$handleResponse$2(this), this.f34995j)) {
                return;
            }
            CredentialProviderController.e(this.f34995j, new CredentialProviderCreatePasswordController$handleResponse$3(this, o(Unit.f139807a)));
            return;
        }
        Log.w("CreatePassword", "Returned request code " + companion.b() + " which does not match what was given " + i3);
    }

    public void q(CreatePasswordRequest request, CredentialManagerCallback callback, Executor executor, CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.f34995j = cancellationSignal;
        this.f34993h = callback;
        this.f34994i = executor;
        if (CredentialProviderPlayServicesImpl.Companion.a(cancellationSignal)) {
            return;
        }
        SavePasswordRequest savePasswordRequestN = n(request);
        Intent intent = new Intent(this.f34992g, (Class<?>) HiddenActivity.class);
        intent.putExtra("REQUEST_TYPE", savePasswordRequestN);
        c(this.f34996k, intent, "CREATE_PASSWORD");
        try {
            this.f34992g.startActivity(intent);
        } catch (Exception unused) {
            CredentialProviderController.e(cancellationSignal, new CredentialProviderCreatePasswordController$invokePlayServices$1(this));
        }
    }
}
