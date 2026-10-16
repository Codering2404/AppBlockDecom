package androidx.credentials.playservices.controllers.CreatePublicKeyCredential;

import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.exceptions.domerrors.EncodingError;
import androidx.credentials.exceptions.publickeycredential.CreatePublicKeyCredentialDomException;
import com.sun.jna.Callback;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;

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
final class CredentialProviderCreatePublicKeyCredentialController$handleResponse$6 extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CredentialProviderCreatePublicKeyCredentialController f35020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ JSONException f35021b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CredentialProviderCreatePublicKeyCredentialController$handleResponse$6(CredentialProviderCreatePublicKeyCredentialController credentialProviderCreatePublicKeyCredentialController, JSONException jSONException) {
        super(0);
        this.f35020a = credentialProviderCreatePublicKeyCredentialController;
        this.f35021b = jSONException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(CredentialProviderCreatePublicKeyCredentialController credentialProviderCreatePublicKeyCredentialController, JSONException jSONException) {
        CredentialManagerCallback credentialManagerCallback = credentialProviderCreatePublicKeyCredentialController.f35010h;
        if (credentialManagerCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Callback.METHOD_NAME);
            credentialManagerCallback = null;
        }
        credentialManagerCallback.a(new CreatePublicKeyCredentialDomException(new EncodingError(), jSONException.getMessage()));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        m318invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m318invoke() {
        Executor executor = this.f35020a.f35011i;
        if (executor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("executor");
            executor = null;
        }
        final CredentialProviderCreatePublicKeyCredentialController credentialProviderCreatePublicKeyCredentialController = this.f35020a;
        final JSONException jSONException = this.f35021b;
        executor.execute(new Runnable() { // from class: androidx.credentials.playservices.controllers.CreatePublicKeyCredential.e
            @Override // java.lang.Runnable
            public final void run() {
                CredentialProviderCreatePublicKeyCredentialController$handleResponse$6.d(credentialProviderCreatePublicKeyCredentialController, jSONException);
            }
        });
    }
}
