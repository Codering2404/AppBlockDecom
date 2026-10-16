package androidx.credentials.playservices.controllers.GetRestoreCredential;

import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.exceptions.GetCredentialException;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
final class CredentialProviderGetDigitalCredentialController$invokePlayServices$2$1 extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Executor f35125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CredentialManagerCallback f35126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ GetCredentialException f35127c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CredentialProviderGetDigitalCredentialController$invokePlayServices$2$1(Executor executor, CredentialManagerCallback credentialManagerCallback, GetCredentialException getCredentialException) {
        super(0);
        this.f35125a = executor;
        this.f35126b = credentialManagerCallback;
        this.f35127c = getCredentialException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(CredentialManagerCallback credentialManagerCallback, GetCredentialException getCredentialException) {
        credentialManagerCallback.a(getCredentialException);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        m332invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m332invoke() {
        Executor executor = this.f35125a;
        final CredentialManagerCallback credentialManagerCallback = this.f35126b;
        final GetCredentialException getCredentialException = this.f35127c;
        executor.execute(new Runnable() { // from class: androidx.credentials.playservices.controllers.GetRestoreCredential.g
            @Override // java.lang.Runnable
            public final void run() {
                CredentialProviderGetDigitalCredentialController$invokePlayServices$2$1.d(credentialManagerCallback, getCredentialException);
            }
        });
    }
}
