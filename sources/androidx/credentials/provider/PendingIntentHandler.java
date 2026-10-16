package androidx.credentials.provider;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.credentials.Credential;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.internal.ConversionUtilsKt;
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
public final class PendingIntentHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f35353a = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Api23Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f35354a = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final GetCredentialException a(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                GetCredentialException.Companion companion = GetCredentialException.f34862c;
                Bundle bundleExtra = intent.getBundleExtra("android.service.credentials.extra.GET_CREDENTIAL_EXCEPTION");
                if (bundleExtra == null) {
                    return null;
                }
                return companion.a(bundleExtra);
            }

            public final GetCredentialResponse b(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                GetCredentialResponse.Companion companion = GetCredentialResponse.f34811b;
                Bundle bundleExtra = intent.getBundleExtra("android.service.credentials.extra.GET_CREDENTIAL_RESPONSE");
                if (bundleExtra == null) {
                    return null;
                }
                return companion.a(bundleExtra);
            }

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Api34Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f35355a = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final GetCredentialException a(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                android.credentials.GetCredentialException getCredentialException = (android.credentials.GetCredentialException) intent.getSerializableExtra("android.service.credentials.extra.GET_CREDENTIAL_EXCEPTION", android.credentials.GetCredentialException.class);
                if (getCredentialException == null) {
                    return null;
                }
                String type = getCredentialException.getType();
                Intrinsics.checkNotNullExpressionValue(type, "ex.type");
                return ConversionUtilsKt.b(type, getCredentialException.getMessage());
            }

            public final GetCredentialResponse b(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                android.credentials.GetCredentialResponse getCredentialResponse = (android.credentials.GetCredentialResponse) intent.getParcelableExtra("android.service.credentials.extra.GET_CREDENTIAL_RESPONSE", android.credentials.GetCredentialResponse.class);
                if (getCredentialResponse == null) {
                    return null;
                }
                Credential.Companion companion = Credential.f34750c;
                android.credentials.Credential credential = getCredentialResponse.getCredential();
                Intrinsics.checkNotNullExpressionValue(credential, "response.credential");
                return new GetCredentialResponse(companion.a(credential));
            }

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GetCredentialException a(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            return Build.VERSION.SDK_INT >= 34 ? Api34Impl.f35355a.a(intent) : Api23Impl.f35354a.a(intent);
        }

        public final GetCredentialResponse b(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            return Build.VERSION.SDK_INT >= 34 ? Api34Impl.f35355a.b(intent) : Api23Impl.f35354a.b(intent);
        }

        private Companion() {
        }
    }
}
