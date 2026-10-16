package androidx.credentials;

import android.credentials.CreateCredentialException;
import android.os.Bundle;
import android.os.OutcomeReceiver;
import android.util.Log;
import androidx.credentials.CreateCredentialResponse;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class CredentialProviderFrameworkImpl$onCreateCredential$outcome$1 implements OutcomeReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CredentialManagerCallback f34785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CreateCredentialRequest f34786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CredentialProviderFrameworkImpl f34787c;

    public void a(CreateCredentialException error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Log.i("CredManProvService", "CreateCredentialResponse error returned from framework");
        this.f34785a.a(this.f34787c.d(error));
    }

    public void b(android.credentials.CreateCredentialResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        Log.i("CredManProvService", "Create Result returned from framework: ");
        CredentialManagerCallback credentialManagerCallback = this.f34785a;
        CreateCredentialResponse.Companion companion = CreateCredentialResponse.f34736c;
        String strB = this.f34786b.b();
        Bundle data = response.getData();
        Intrinsics.checkNotNullExpressionValue(data, "response.data");
        credentialManagerCallback.onResult(companion.a(strB, data));
    }

    public /* bridge */ /* synthetic */ void onError(Throwable th) {
        a(a0.a(th));
    }

    public /* bridge */ /* synthetic */ void onResult(Object obj) {
        b(b0.a(obj));
    }
}
