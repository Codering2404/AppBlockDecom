package androidx.credentials;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class GetCredentialResponse {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f34811b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Credential f34812a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GetCredentialResponse a(Bundle bundle) {
            Bundle bundle2;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            String string = bundle.getString("androidx.credentials.provider.extra.EXTRA_CREDENTIAL_TYPE");
            if (string == null || (bundle2 = bundle.getBundle("androidx.credentials.provider.extra.EXTRA_CREDENTIAL_DATA")) == null) {
                return null;
            }
            return new GetCredentialResponse(Credential.f34750c.b(string, bundle2));
        }

        private Companion() {
        }
    }

    public GetCredentialResponse(Credential credential) {
        Intrinsics.checkNotNullParameter(credential, "credential");
        this.f34812a = credential;
    }

    public final Credential a() {
        return this.f34812a;
    }
}
