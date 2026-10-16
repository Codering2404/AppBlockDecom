package androidx.credentials.playservices.controllers;

import androidx.credentials.CredentialManagerCallback;
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
final class CredentialProviderController$maybeReportErrorFromResultReceiver$1 extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Executor f35107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CredentialManagerCallback f35108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Object f35109c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CredentialProviderController$maybeReportErrorFromResultReceiver$1(Executor executor, CredentialManagerCallback credentialManagerCallback, Object obj) {
        super(0);
        this.f35107a = executor;
        this.f35108b = credentialManagerCallback;
        this.f35109c = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(CredentialManagerCallback credentialManagerCallback, Object obj) {
        credentialManagerCallback.a(obj);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        m328invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m328invoke() {
        Executor executor = this.f35107a;
        final CredentialManagerCallback credentialManagerCallback = this.f35108b;
        final Object obj = this.f35109c;
        executor.execute(new Runnable() { // from class: androidx.credentials.playservices.controllers.a
            @Override // java.lang.Runnable
            public final void run() {
                CredentialProviderController$maybeReportErrorFromResultReceiver$1.d(credentialManagerCallback, obj);
            }
        });
    }
}
