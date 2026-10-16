package androidx.credentials.playservices.controllers.CreatePassword;

import androidx.credentials.CreateCredentialResponse;
import androidx.credentials.CredentialManagerCallback;
import com.sun.jna.Callback;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class CredentialProviderCreatePasswordController$handleResponse$3 extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CredentialProviderCreatePasswordController f34999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CreateCredentialResponse f35000b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CredentialProviderCreatePasswordController$handleResponse$3(CredentialProviderCreatePasswordController credentialProviderCreatePasswordController, CreateCredentialResponse createCredentialResponse) {
        super(0);
        this.f34999a = credentialProviderCreatePasswordController;
        this.f35000b = createCredentialResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(CredentialProviderCreatePasswordController credentialProviderCreatePasswordController, CreateCredentialResponse createCredentialResponse) {
        CredentialManagerCallback credentialManagerCallback = credentialProviderCreatePasswordController.f34993h;
        if (credentialManagerCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Callback.METHOD_NAME);
            credentialManagerCallback = null;
        }
        credentialManagerCallback.onResult(createCredentialResponse);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        m314invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m314invoke() {
        Executor executor = this.f34999a.f34994i;
        if (executor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("executor");
            executor = null;
        }
        final CredentialProviderCreatePasswordController credentialProviderCreatePasswordController = this.f34999a;
        final CreateCredentialResponse createCredentialResponse = this.f35000b;
        executor.execute(new Runnable() { // from class: androidx.credentials.playservices.controllers.CreatePassword.b
            @Override // java.lang.Runnable
            public final void run() {
                CredentialProviderCreatePasswordController$handleResponse$3.d(credentialProviderCreatePasswordController, createCredentialResponse);
            }
        });
    }
}
