package androidx.credentials.provider;

import android.os.Bundle;
import androidx.credentials.internal.FrameworkClassParsingException;
import androidx.credentials.provider.utils.RequestValidationUtil;
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
public final class BeginGetPublicKeyCredentialOption extends BeginGetCredentialOption {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f35276g = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f35277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f35278f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BeginGetPublicKeyCredentialOption a(Bundle data, String id) throws FrameworkClassParsingException {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(id, "id");
            try {
                String string = data.getString("androidx.credentials.BUNDLE_KEY_REQUEST_JSON");
                byte[] byteArray = data.getByteArray("androidx.credentials.BUNDLE_KEY_CLIENT_DATA_HASH");
                Intrinsics.checkNotNull(string);
                return new BeginGetPublicKeyCredentialOption(data, id, string, byteArray);
            } catch (Exception unused) {
                throw new FrameworkClassParsingException();
            }
        }

        public final BeginGetPublicKeyCredentialOption b(Bundle data, String id) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(id, "id");
            return new BeginGetPublicKeyCredentialOption(data, id, "{\"dummy_key\":\"dummy_value\"}", null, 8, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ BeginGetPublicKeyCredentialOption(Bundle bundle, String str, String str2, byte[] bArr, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(bundle, str, str2, (i3 & 8) != 0 ? null : bArr);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeginGetPublicKeyCredentialOption(Bundle candidateQueryData, String id, String requestJson, byte[] bArr) {
        super(id, "androidx.credentials.TYPE_PUBLIC_KEY_CREDENTIAL", candidateQueryData);
        Intrinsics.checkNotNullParameter(candidateQueryData, "candidateQueryData");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(requestJson, "requestJson");
        this.f35277e = requestJson;
        this.f35278f = bArr;
        if (!RequestValidationUtil.f35408a.a(requestJson)) {
            throw new IllegalArgumentException("requestJson must not be empty, and must be a valid JSON");
        }
    }
}
