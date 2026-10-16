package androidx.credentials;

import androidx.credentials.exceptions.GetCredentialException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

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
public final class CredentialManager$getCredential$4$callback$1 implements CredentialManagerCallback<GetCredentialResponse, GetCredentialException> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CancellableContinuation f34762a;

    @Override // androidx.credentials.CredentialManagerCallback
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(GetCredentialException e3) {
        Intrinsics.checkNotNullParameter(e3, "e");
        if (this.f34762a.isActive()) {
            CancellableContinuation cancellableContinuation = this.f34762a;
            Result.Companion companion = Result.f139772b;
            cancellableContinuation.resumeWith(Result.b(ResultKt.a(e3)));
        }
    }

    @Override // androidx.credentials.CredentialManagerCallback
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onResult(GetCredentialResponse result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (this.f34762a.isActive()) {
            this.f34762a.resumeWith(Result.b(result));
        }
    }
}
