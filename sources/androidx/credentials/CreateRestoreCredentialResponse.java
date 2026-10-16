package androidx.credentials;

import android.os.Bundle;
import androidx.credentials.exceptions.CreateCredentialUnknownException;
import androidx.credentials.internal.RequestValidationHelper;
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
public final class CreateRestoreCredentialResponse extends CreateCredentialResponse {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f34748e = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f34749d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CreateRestoreCredentialResponse a(Bundle data) throws CreateCredentialUnknownException {
            Intrinsics.checkNotNullParameter(data, "data");
            String string = data.getString("androidx.credentials.BUNDLE_KEY_CREATE_RESTORE_CREDENTIAL_RESPONSE");
            if (string != null) {
                return new CreateRestoreCredentialResponse(string, data, null);
            }
            throw new CreateCredentialUnknownException("The response bundle did not contain the response data. This should not happen.");
        }

        private Companion() {
        }
    }

    public /* synthetic */ CreateRestoreCredentialResponse(String str, Bundle bundle, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bundle);
    }

    private CreateRestoreCredentialResponse(String str, Bundle bundle) {
        super("androidx.credentials.TYPE_RESTORE_CREDENTIAL", bundle);
        this.f34749d = str;
        if (!RequestValidationHelper.f34913a.a(str)) {
            throw new IllegalArgumentException("registrationResponseJson must not be empty, and must be a valid JSON");
        }
    }
}
