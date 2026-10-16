package androidx.credentials.playservices;

import android.util.Log;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.exceptions.ClearCredentialUnknownException;
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
final class CredentialProviderPlayServicesImpl$onClearCredential$5$1$1 extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Exception f34931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Executor f34932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CredentialManagerCallback f34933c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CredentialProviderPlayServicesImpl$onClearCredential$5$1$1(Exception exc, Executor executor, CredentialManagerCallback credentialManagerCallback) {
        super(0);
        this.f34931a = exc;
        this.f34932b = executor;
        this.f34933c = credentialManagerCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(CredentialManagerCallback credentialManagerCallback, Exception exc) {
        credentialManagerCallback.a(new ClearCredentialUnknownException(exc.getMessage()));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        m304invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m304invoke() {
        Log.w("PlayServicesImpl", "During clear credential sign out failed with " + this.f34931a);
        Executor executor = this.f34932b;
        final CredentialManagerCallback credentialManagerCallback = this.f34933c;
        final Exception exc = this.f34931a;
        executor.execute(new Runnable() { // from class: androidx.credentials.playservices.i
            @Override // java.lang.Runnable
            public final void run() {
                CredentialProviderPlayServicesImpl$onClearCredential$5$1$1.d(credentialManagerCallback, exc);
            }
        });
    }
}
