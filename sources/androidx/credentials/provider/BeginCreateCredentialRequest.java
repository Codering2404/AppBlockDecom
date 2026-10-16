package androidx.credentials.provider;

import android.os.Bundle;
import androidx.credentials.internal.FrameworkClassParsingException;
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
public abstract class BeginCreateCredentialRequest {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f35242d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f35243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bundle f35244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CallingAppInfo f35245c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Api21Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api21Impl f35246a = new Api21Impl();

        private Api21Impl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Api34Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api34Impl f35247a = new Api34Impl();

        private Api34Impl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BeginCreateCredentialRequest a(String type, Bundle candidateQueryData, CallingAppInfo callingAppInfo) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(candidateQueryData, "candidateQueryData");
            try {
                return Intrinsics.areEqual(type, "android.credentials.TYPE_PASSWORD_CREDENTIAL") ? BeginCreatePasswordCredentialRequest.f35253e.a(candidateQueryData, callingAppInfo) : Intrinsics.areEqual(type, "androidx.credentials.TYPE_PUBLIC_KEY_CREDENTIAL") ? BeginCreatePublicKeyCredentialRequest.f35254g.a(candidateQueryData, callingAppInfo) : new BeginCreateCustomCredentialRequest(type, candidateQueryData, callingAppInfo);
            } catch (FrameworkClassParsingException unused) {
                return new BeginCreateCustomCredentialRequest(type, candidateQueryData, callingAppInfo);
            }
        }

        private Companion() {
        }
    }

    public BeginCreateCredentialRequest(String type, Bundle candidateQueryData, CallingAppInfo callingAppInfo) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(candidateQueryData, "candidateQueryData");
        this.f35243a = type;
        this.f35244b = candidateQueryData;
        this.f35245c = callingAppInfo;
    }
}
