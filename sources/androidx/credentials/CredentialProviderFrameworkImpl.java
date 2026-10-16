package androidx.credentials;

import android.content.Context;
import android.credentials.ClearCredentialStateException;
import android.credentials.GetCredentialRequest;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.OutcomeReceiver;
import android.util.Log;
import androidx.credentials.Credential;
import androidx.credentials.PrepareGetCredentialResponse;
import androidx.credentials.exceptions.ClearCredentialUnknownException;
import androidx.credentials.exceptions.ClearCredentialUnsupportedException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.GetCredentialUnsupportedException;
import androidx.credentials.internal.ConversionUtilsKt;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

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
public final class CredentialProviderFrameworkImpl implements CredentialProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Companion f34780b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final android.credentials.CredentialManager f34781a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.credentials.CredentialProviderFrameworkImpl$onGetCredential$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class C03481 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CredentialManagerCallback f34788a;

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m295invoke();
            return Unit.f139807a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m295invoke() {
            this.f34788a.a(new GetCredentialUnsupportedException("Your device doesn't support credential manager"));
        }
    }

    public CredentialProviderFrameworkImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f34781a = v.a(context.getSystemService("credential"));
    }

    private final android.credentials.GetCredentialRequest a(GetCredentialRequest getCredentialRequest) {
        h.a();
        GetCredentialRequest.Builder builderA = f.a(GetCredentialRequest.f34800f.a(getCredentialRequest));
        for (CredentialOption credentialOption : getCredentialRequest.a()) {
            i.a();
            builderA.addCredentialOption(g.a(credentialOption.d(), credentialOption.c(), credentialOption.b()).setIsSystemProviderRequired(credentialOption.f()).setAllowedProviders(credentialOption.a()).build());
        }
        h(getCredentialRequest, builderA);
        android.credentials.GetCredentialRequest getCredentialRequestBuild = builderA.build();
        Intrinsics.checkNotNullExpressionValue(getCredentialRequestBuild, "builder.build()");
        return getCredentialRequestBuild;
    }

    private final android.credentials.ClearCredentialStateRequest f() {
        e.a();
        return y.a(new Bundle());
    }

    private final boolean g(Function0 function0) {
        if (this.f34781a != null) {
            return false;
        }
        function0.invoke();
        return true;
    }

    private final void h(GetCredentialRequest getCredentialRequest, GetCredentialRequest.Builder builder) {
        if (getCredentialRequest.b() != null) {
            builder.setOrigin(getCredentialRequest.b());
        }
    }

    public final GetCredentialResponse b(android.credentials.GetCredentialResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        android.credentials.Credential credential = response.getCredential();
        Intrinsics.checkNotNullExpressionValue(credential, "response.credential");
        Credential.Companion companion = Credential.f34750c;
        String type = credential.getType();
        Intrinsics.checkNotNullExpressionValue(type, "credential.type");
        Bundle data = credential.getData();
        Intrinsics.checkNotNullExpressionValue(data, "credential.data");
        return new GetCredentialResponse(companion.b(type, data));
    }

    public final PrepareGetCredentialResponse c(android.credentials.PrepareGetCredentialResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return new PrepareGetCredentialResponse.Builder().h(response).i(new PrepareGetCredentialResponse.PendingGetCredentialHandle(response.getPendingGetCredentialHandle())).d();
    }

    public final CreateCredentialException d(android.credentials.CreateCredentialException error) {
        Intrinsics.checkNotNullParameter(error, "error");
        String type = error.getType();
        Intrinsics.checkNotNullExpressionValue(type, "error.type");
        return ConversionUtilsKt.a(type, error.getMessage());
    }

    public final GetCredentialException e(android.credentials.GetCredentialException error) {
        Intrinsics.checkNotNullParameter(error, "error");
        String type = error.getType();
        Intrinsics.checkNotNullExpressionValue(type, "error.type");
        return ConversionUtilsKt.b(type, error.getMessage());
    }

    @Override // androidx.credentials.CredentialProvider
    public boolean isAvailableOnDevice() {
        return Build.VERSION.SDK_INT >= 34 && this.f34781a != null;
    }

    @Override // androidx.credentials.CredentialProvider
    public void onClearCredential(ClearCredentialStateRequest request, CancellationSignal cancellationSignal, Executor executor, final CredentialManagerCallback callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Log.i("CredManProvService", "In CredentialProviderFrameworkImpl onClearCredential");
        if (g(new Function0<Unit>() { // from class: androidx.credentials.CredentialProviderFrameworkImpl.onClearCredential.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m293invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m293invoke() {
                callback.a(new ClearCredentialUnsupportedException("Your device doesn't support credential manager"));
            }
        })) {
            return;
        }
        OutcomeReceiver outcomeReceiver = new OutcomeReceiver() { // from class: androidx.credentials.CredentialProviderFrameworkImpl$onClearCredential$outcome$1
            public void a(ClearCredentialStateException error) {
                Intrinsics.checkNotNullParameter(error, "error");
                Log.i("CredManProvService", "ClearCredentialStateException error returned from framework");
                callback.a(new ClearCredentialUnknownException(null, 1, null));
            }

            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onResult(Void r3) {
                Log.i("CredManProvService", "Clear result returned from framework: ");
                callback.onResult(r3);
            }

            public /* bridge */ /* synthetic */ void onError(Throwable th) {
                a(z.a(th));
            }
        };
        android.credentials.CredentialManager credentialManager = this.f34781a;
        Intrinsics.checkNotNull(credentialManager);
        credentialManager.clearCredentialState(f(), cancellationSignal, executor, androidx.core.os.a.a(outcomeReceiver));
    }

    @Override // androidx.credentials.CredentialProvider
    public void onGetCredential(Context context, GetCredentialRequest request, CancellationSignal cancellationSignal, Executor executor, final CredentialManagerCallback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (g(new Function0<Unit>() { // from class: androidx.credentials.CredentialProviderFrameworkImpl.onGetCredential.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m296invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m296invoke() {
                callback.a(new GetCredentialUnsupportedException("Your device doesn't support credential manager"));
            }
        })) {
            return;
        }
        OutcomeReceiver outcomeReceiver = new OutcomeReceiver() { // from class: androidx.credentials.CredentialProviderFrameworkImpl$onGetCredential$outcome$2
            public void a(android.credentials.GetCredentialException error) {
                Intrinsics.checkNotNullParameter(error, "error");
                Log.i("CredManProvService", "GetCredentialResponse error returned from framework");
                callback.a(this.e(error));
            }

            public void b(android.credentials.GetCredentialResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
                Log.i("CredManProvService", "GetCredentialResponse returned from framework");
                callback.onResult(this.b(response));
            }

            public /* bridge */ /* synthetic */ void onError(Throwable th) {
                a(e0.a(th));
            }

            public /* bridge */ /* synthetic */ void onResult(Object obj) {
                b(d0.a(obj));
            }
        };
        android.credentials.CredentialManager credentialManager = this.f34781a;
        Intrinsics.checkNotNull(credentialManager);
        credentialManager.getCredential(context, a(request), cancellationSignal, executor, (OutcomeReceiver<android.credentials.GetCredentialResponse, android.credentials.GetCredentialException>) androidx.core.os.a.a(outcomeReceiver));
    }
}
