package androidx.credentials.playservices.controllers.GetRestoreCredential;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.util.Log;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.CredentialOption;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetDigitalCredentialOption;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.GetCredentialInterruptedException;
import androidx.credentials.exceptions.GetCredentialUnknownException;
import androidx.credentials.internal.ConversionUtilsKt;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import androidx.credentials.playservices.IdentityCredentialApiHiddenActivity;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import androidx.credentials.playservices.controllers.CredentialProviderController;
import androidx.credentials.provider.PendingIntentHandler;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.identitycredentials.GetCredentialResponse;
import com.google.android.gms.identitycredentials.IdentityCredentialManager;
import com.google.android.gms.identitycredentials.PendingGetCredentialHandle;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.sun.jna.Callback;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class CredentialProviderGetDigitalCredentialController extends CredentialProviderController<GetCredentialRequest, com.google.android.gms.identitycredentials.GetCredentialRequest, GetCredentialResponse, androidx.credentials.GetCredentialResponse, GetCredentialException> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Companion f35110l = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f35111g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CredentialManagerCallback f35112h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Executor f35113i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CancellationSignal f35114j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final CredentialProviderGetDigitalCredentialController$resultReceiver$1 f35115k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.credentials.playservices.controllers.GetRestoreCredential.CredentialProviderGetDigitalCredentialController$resultReceiver$1] */
    public CredentialProviderGetDigitalCredentialController(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f35111g = context;
        final Handler handler = new Handler(Looper.getMainLooper());
        this.f35115k = new ResultReceiver(handler) { // from class: androidx.credentials.playservices.controllers.GetRestoreCredential.CredentialProviderGetDigitalCredentialController$resultReceiver$1
            @Override // android.os.ResultReceiver
            public void onReceiveResult(int i3, Bundle resultData) {
                Intrinsics.checkNotNullParameter(resultData, "resultData");
                if (this.f35128a.f(resultData, new CredentialProviderGetDigitalCredentialController$resultReceiver$1$onReceiveResult$1(CredentialProviderBaseController.f35097b), this.f35128a.s(), this.f35128a.r(), this.f35128a.f35114j)) {
                    return;
                }
                this.f35128a.t(resultData.getInt("ACTIVITY_REQUEST_CODE"), i3, (Intent) resultData.getParcelable("RESULT_DATA"));
            }
        };
    }

    private final GetCredentialException q(Throwable th) {
        if (th instanceof com.google.android.gms.identitycredentials.GetCredentialException) {
            return ConversionUtilsKt.b(((com.google.android.gms.identitycredentials.GetCredentialException) th).a(), th.getMessage());
        }
        if (!(th instanceof ApiException)) {
            return new GetCredentialUnknownException("Get digital credential failed, failure: " + th);
        }
        int statusCode = ((ApiException) th).getStatusCode();
        if (statusCode == 16) {
            return new GetCredentialCancellationException(th.getMessage());
        }
        if (CredentialProviderBaseController.f35097b.d().contains(Integer.valueOf(statusCode))) {
            return new GetCredentialInterruptedException(th.getMessage());
        }
        return new GetCredentialUnknownException("Get digital credential failed, failure: " + th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(CredentialProviderGetDigitalCredentialController credentialProviderGetDigitalCredentialController, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback credentialManagerCallback, Exception e3) {
        Intrinsics.checkNotNullParameter(e3, "e");
        CredentialProviderController.e(cancellationSignal, new CredentialProviderGetDigitalCredentialController$invokePlayServices$2$1(executor, credentialManagerCallback, credentialProviderGetDigitalCredentialController.q(e3)));
    }

    public com.google.android.gms.identitycredentials.GetCredentialRequest p(GetCredentialRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        ArrayList arrayList = new ArrayList();
        for (CredentialOption credentialOption : request.a()) {
            if (credentialOption instanceof GetDigitalCredentialOption) {
                arrayList.add(new com.google.android.gms.identitycredentials.CredentialOption(credentialOption.d(), credentialOption.c(), credentialOption.b(), ((GetDigitalCredentialOption) credentialOption).g(), "", ""));
            }
        }
        return new com.google.android.gms.identitycredentials.GetCredentialRequest(arrayList, GetCredentialRequest.f34800f.a(request), request.b(), new ResultReceiver(null));
    }

    public final CredentialManagerCallback r() {
        CredentialManagerCallback credentialManagerCallback = this.f35112h;
        if (credentialManagerCallback != null) {
            return credentialManagerCallback;
        }
        Intrinsics.throwUninitializedPropertyAccessException(Callback.METHOD_NAME);
        return null;
    }

    public final Executor s() {
        Executor executor = this.f35113i;
        if (executor != null) {
            return executor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("executor");
        return null;
    }

    public final void t(int i3, int i4, Intent intent) {
        CredentialProviderBaseController.Companion companion = CredentialProviderBaseController.f35097b;
        if (i3 != companion.b()) {
            Log.w("DigitalCredentialClient", "Returned request code " + companion.b() + " which  does not match what was given " + i3);
            return;
        }
        if (CredentialProviderController.h(i4, new Function2<CancellationSignal, Function0<? extends Unit>, Unit>() { // from class: androidx.credentials.playservices.controllers.GetRestoreCredential.CredentialProviderGetDigitalCredentialController$handleResponse$1
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
        }, new CredentialProviderGetDigitalCredentialController$handleResponse$2(this), this.f35114j)) {
            return;
        }
        if (intent == null) {
            CredentialProviderController.e(this.f35114j, new CredentialProviderGetDigitalCredentialController$handleResponse$3(this));
            return;
        }
        PendingIntentHandler.Companion companion2 = PendingIntentHandler.f35353a;
        androidx.credentials.GetCredentialResponse getCredentialResponseB = companion2.b(intent);
        if (getCredentialResponseB != null) {
            CredentialProviderController.e(this.f35114j, new CredentialProviderGetDigitalCredentialController$handleResponse$4(this, getCredentialResponseB));
        } else {
            CredentialProviderController.e(this.f35114j, new CredentialProviderGetDigitalCredentialController$handleResponse$5(this, companion2.a(intent)));
        }
    }

    public void u(GetCredentialRequest request, final CredentialManagerCallback callback, final Executor executor, final CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.f35114j = cancellationSignal;
        x(callback);
        y(executor);
        if (CredentialProviderPlayServicesImpl.Companion.a(cancellationSignal)) {
            return;
        }
        Task taskD = IdentityCredentialManager.f72829a.a(this.f35111g).d(p(request));
        final Function1<PendingGetCredentialHandle, Unit> function1 = new Function1<PendingGetCredentialHandle, Unit>() { // from class: androidx.credentials.playservices.controllers.GetRestoreCredential.CredentialProviderGetDigitalCredentialController$invokePlayServices$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(PendingGetCredentialHandle pendingGetCredentialHandle) {
                if (CredentialProviderPlayServicesImpl.Companion.a(cancellationSignal)) {
                    return;
                }
                Intent intent = new Intent(this.f35111g, (Class<?>) IdentityCredentialApiHiddenActivity.class);
                intent.setFlags(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
                CredentialProviderGetDigitalCredentialController credentialProviderGetDigitalCredentialController = this;
                intent.putExtra("RESULT_RECEIVER", credentialProviderGetDigitalCredentialController.d(credentialProviderGetDigitalCredentialController.f35115k));
                intent.putExtra("EXTRA_GET_CREDENTIAL_INTENT", pendingGetCredentialHandle.M());
                this.f35111g.startActivity(intent);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((PendingGetCredentialHandle) obj);
                return Unit.f139807a;
            }
        };
        taskD.addOnSuccessListener(new OnSuccessListener() { // from class: androidx.credentials.playservices.controllers.GetRestoreCredential.a
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                CredentialProviderGetDigitalCredentialController.v(function1, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: androidx.credentials.playservices.controllers.GetRestoreCredential.b
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                CredentialProviderGetDigitalCredentialController.w(this.f35144a, cancellationSignal, executor, callback, exc);
            }
        });
    }

    public final void x(CredentialManagerCallback credentialManagerCallback) {
        Intrinsics.checkNotNullParameter(credentialManagerCallback, "<set-?>");
        this.f35112h = credentialManagerCallback;
    }

    public final void y(Executor executor) {
        Intrinsics.checkNotNullParameter(executor, "<set-?>");
        this.f35113i = executor;
    }
}
