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
public final class ClearCredentialStateRequest {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f34729c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f34730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bundle f34731b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ClearCredentialStateRequest(String requestType) {
        Intrinsics.checkNotNullParameter(requestType, "requestType");
        this.f34730a = requestType;
        Bundle bundle = new Bundle();
        this.f34731b = bundle;
        if (Intrinsics.areEqual(requestType, "androidx.credentials.TYPE_CLEAR_CREDENTIAL_STATE") || Intrinsics.areEqual(requestType, "androidx.credentials.TYPE_CLEAR_RESTORE_CREDENTIAL")) {
            if (Intrinsics.areEqual(requestType, "androidx.credentials.TYPE_CLEAR_RESTORE_CREDENTIAL")) {
                bundle.putBoolean("androidx.credentials.BUNDLE_KEY_CLEAR_RESTORE_CREDENTIAL_REQUEST", true);
            }
        } else {
            throw new IllegalArgumentException("The request type " + requestType + " is not supported.");
        }
    }

    public final Bundle a() {
        return this.f34731b;
    }

    public final String b() {
        return this.f34730a;
    }

    public /* synthetic */ ClearCredentialStateRequest(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "androidx.credentials.TYPE_CLEAR_CREDENTIAL_STATE" : str);
    }
}
