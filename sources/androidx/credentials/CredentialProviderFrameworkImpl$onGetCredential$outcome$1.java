package androidx.credentials;

import android.credentials.GetCredentialException;
import android.os.OutcomeReceiver;
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
public final class CredentialProviderFrameworkImpl$onGetCredential$outcome$1 implements OutcomeReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CredentialManagerCallback f34790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CredentialProviderFrameworkImpl f34791b;

    public void a(GetCredentialException error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f34790a.a(this.f34791b.e(error));
    }

    public void b(android.credentials.GetCredentialResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        this.f34790a.onResult(this.f34791b.b(response));
    }

    public /* bridge */ /* synthetic */ void onError(Throwable th) {
        a(e0.a(th));
    }

    public /* bridge */ /* synthetic */ void onResult(Object obj) {
        b(d0.a(obj));
    }
}
