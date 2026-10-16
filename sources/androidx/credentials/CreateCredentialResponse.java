package androidx.credentials;

import android.os.Bundle;
import androidx.credentials.internal.FrameworkClassParsingException;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class CreateCredentialResponse {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f34736c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f34737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bundle f34738b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CreateCredentialResponse a(String type, Bundle data) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                if (Intrinsics.areEqual(type, "android.credentials.TYPE_PASSWORD_CREDENTIAL")) {
                    return CreatePasswordResponse.f34742d.a(data);
                }
                if (Intrinsics.areEqual(type, "androidx.credentials.TYPE_PUBLIC_KEY_CREDENTIAL")) {
                    return CreatePublicKeyCredentialResponse.f34745e.a(data);
                }
                throw new FrameworkClassParsingException();
            } catch (FrameworkClassParsingException unused) {
                return new CreateCustomCredentialResponse(type, data);
            }
        }

        private Companion() {
        }
    }

    public CreateCredentialResponse(String str, Bundle data) {
        Intrinsics.checkNotNullParameter(str, pMpIcGE.NZdie);
        Intrinsics.checkNotNullParameter(data, "data");
        this.f34737a = str;
        this.f34738b = data;
    }
}
