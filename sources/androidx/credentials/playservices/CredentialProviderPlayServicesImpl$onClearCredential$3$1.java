package androidx.credentials.playservices;

import androidx.credentials.CredentialManagerCallback;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

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
final class CredentialProviderPlayServicesImpl$onClearCredential$3$1 extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Executor f34923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CredentialManagerCallback f34924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f34925c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CredentialProviderPlayServicesImpl$onClearCredential$3$1(Executor executor, CredentialManagerCallback credentialManagerCallback, Ref.ObjectRef objectRef) {
        super(0);
        this.f34923a = executor;
        this.f34924b = credentialManagerCallback;
        this.f34925c = objectRef;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(CredentialManagerCallback credentialManagerCallback, Ref.ObjectRef objectRef) {
        credentialManagerCallback.a(objectRef.f140144a);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        m302invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m302invoke() {
        Executor executor = this.f34923a;
        final CredentialManagerCallback credentialManagerCallback = this.f34924b;
        final Ref.ObjectRef objectRef = this.f34925c;
        executor.execute(new Runnable() { // from class: androidx.credentials.playservices.g
            @Override // java.lang.Runnable
            public final void run() {
                CredentialProviderPlayServicesImpl$onClearCredential$3$1.d(credentialManagerCallback, objectRef);
            }
        });
    }
}
