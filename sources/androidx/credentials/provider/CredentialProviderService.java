package androidx.credentials.provider;

import android.os.CancellationSignal;
import android.os.OutcomeReceiver;
import android.service.credentials.ClearCredentialStateRequest;
import androidx.credentials.exceptions.ClearCredentialException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.provider.utils.BeginCreateCredentialUtil;
import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import androidx.credentials.provider.utils.ClearCredentialUtil;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class CredentialProviderService extends android.service.credentials.CredentialProviderService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f35317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BeginCreateCredentialRequest f35318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BeginGetCredentialRequest f35319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ProviderClearCredentialStateRequest f35320d;

    public abstract void a(BeginCreateCredentialRequest beginCreateCredentialRequest, CancellationSignal cancellationSignal, OutcomeReceiver outcomeReceiver);

    public abstract void b(BeginGetCredentialRequest beginGetCredentialRequest, CancellationSignal cancellationSignal, OutcomeReceiver outcomeReceiver);

    public abstract void c(ProviderClearCredentialStateRequest providerClearCredentialStateRequest, CancellationSignal cancellationSignal, OutcomeReceiver outcomeReceiver);

    public final void onBeginCreateCredential(android.service.credentials.BeginCreateCredentialRequest request, CancellationSignal cancellationSignal, final OutcomeReceiver callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(cancellationSignal, "cancellationSignal");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OutcomeReceiver outcomeReceiver = new OutcomeReceiver() { // from class: androidx.credentials.provider.CredentialProviderService$onBeginCreateCredential$outcome$1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(CreateCredentialException error) {
                Intrinsics.checkNotNullParameter(error, "error");
                OutcomeReceiver outcomeReceiver2 = callback;
                d.a();
                outcomeReceiver2.onError(c.a(error.a(), error.getMessage()));
            }

            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onResult(BeginCreateCredentialResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
                callback.onResult(BeginCreateCredentialUtil.f35385a.a(response));
            }
        };
        BeginCreateCredentialRequest beginCreateCredentialRequestB = BeginCreateCredentialUtil.f35385a.b(request);
        if (this.f35317a) {
            this.f35318b = beginCreateCredentialRequestB;
        }
        a(beginCreateCredentialRequestB, cancellationSignal, androidx.core.os.a.a(outcomeReceiver));
    }

    public final void onBeginGetCredential(android.service.credentials.BeginGetCredentialRequest request, CancellationSignal cancellationSignal, final OutcomeReceiver callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(cancellationSignal, "cancellationSignal");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BeginGetCredentialRequest beginGetCredentialRequestD = BeginGetCredentialUtil.f35389a.d(request);
        OutcomeReceiver outcomeReceiver = new OutcomeReceiver() { // from class: androidx.credentials.provider.CredentialProviderService$onBeginGetCredential$outcome$1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(GetCredentialException error) {
                Intrinsics.checkNotNullParameter(error, "error");
                OutcomeReceiver outcomeReceiver2 = callback;
                f.a();
                outcomeReceiver2.onError(e.a(error.a(), error.getMessage()));
            }

            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onResult(BeginGetCredentialResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
                callback.onResult(BeginGetCredentialUtil.f35389a.b(response));
            }
        };
        if (this.f35317a) {
            this.f35319c = beginGetCredentialRequestD;
        }
        b(beginGetCredentialRequestD, cancellationSignal, androidx.core.os.a.a(outcomeReceiver));
    }

    public final void onClearCredentialState(ClearCredentialStateRequest clearCredentialStateRequest, CancellationSignal cancellationSignal, final OutcomeReceiver callback) {
        Intrinsics.checkNotNullParameter(clearCredentialStateRequest, KrzujOtzIk.ubpDfIhCmBtTnK);
        Intrinsics.checkNotNullParameter(cancellationSignal, "cancellationSignal");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OutcomeReceiver outcomeReceiver = new OutcomeReceiver() { // from class: androidx.credentials.provider.CredentialProviderService$onClearCredentialState$outcome$1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(ClearCredentialException error) {
                Intrinsics.checkNotNullParameter(error, "error");
                OutcomeReceiver outcomeReceiver2 = callback;
                h.a();
                outcomeReceiver2.onError(g.a(error.a(), error.getMessage()));
            }

            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onResult(Void r2) {
                callback.onResult(r2);
            }
        };
        ProviderClearCredentialStateRequest providerClearCredentialStateRequestA = ClearCredentialUtil.f35400a.a(clearCredentialStateRequest);
        if (this.f35317a) {
            this.f35320d = providerClearCredentialStateRequestA;
        }
        c(providerClearCredentialStateRequestA, cancellationSignal, androidx.core.os.a.a(outcomeReceiver));
    }
}
