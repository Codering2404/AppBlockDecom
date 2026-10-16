package androidx.credentials;

import android.os.Bundle;
import androidx.credentials.internal.FrameworkClassParsingException;
import androidx.credentials.internal.RequestValidationHelper;
import java.util.Set;
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
public final class GetDigitalCredentialOption extends CredentialOption {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Companion f34813j = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f34814i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GetDigitalCredentialOption a(Bundle requestData, Bundle candidateQueryData, boolean z2, Set allowedProviders) throws FrameworkClassParsingException {
            Intrinsics.checkNotNullParameter(requestData, "requestData");
            Intrinsics.checkNotNullParameter(candidateQueryData, "candidateQueryData");
            Intrinsics.checkNotNullParameter(allowedProviders, "allowedProviders");
            try {
                String string = requestData.getString("androidx.credentials.BUNDLE_KEY_REQUEST_JSON");
                Intrinsics.checkNotNull(string);
                return new GetDigitalCredentialOption(string, requestData, candidateQueryData, z2, requestData.getBoolean("androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED", false), allowedProviders, requestData.getInt("androidx.credentials.BUNDLE_KEY_TYPE_PRIORITY_VALUE", 100));
            } catch (Exception unused) {
                throw new FrameworkClassParsingException();
            }
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetDigitalCredentialOption(String requestJson, Bundle requestData, Bundle candidateQueryData, boolean z2, boolean z3, Set allowedProviders, int i3) {
        super("androidx.credentials.TYPE_DIGITAL_CREDENTIAL", requestData, candidateQueryData, z2, z3, allowedProviders, i3);
        Intrinsics.checkNotNullParameter(requestJson, "requestJson");
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        Intrinsics.checkNotNullParameter(candidateQueryData, "candidateQueryData");
        Intrinsics.checkNotNullParameter(allowedProviders, "allowedProviders");
        this.f34814i = requestJson;
        if (!RequestValidationHelper.f34913a.a(requestJson)) {
            throw new IllegalArgumentException("credentialJson must not be empty, and must be a valid JSON");
        }
    }

    public final String g() {
        return this.f34814i;
    }
}
