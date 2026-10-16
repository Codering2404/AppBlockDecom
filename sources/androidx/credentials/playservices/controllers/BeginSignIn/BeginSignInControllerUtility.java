package androidx.credentials.playservices.controllers.BeginSignIn;

import android.content.Context;
import androidx.credentials.CredentialOption;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetPasswordOption;
import androidx.credentials.GetPublicKeyCredentialOption;
import androidx.credentials.playservices.controllers.CreatePublicKeyCredential.PublicKeyCredentialControllerUtility;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.libraries.identity.googleid.GetGoogleIdOption;
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
public final class BeginSignInControllerUtility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f34961a = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final BeginSignInRequest.GoogleIdTokenRequestOptions b(GetGoogleIdOption getGoogleIdOption) {
            BeginSignInRequest.GoogleIdTokenRequestOptions.Builder builderG = BeginSignInRequest.GoogleIdTokenRequestOptions.M().c(getGoogleIdOption.h()).d(getGoogleIdOption.k()).e(getGoogleIdOption.l()).f(getGoogleIdOption.m()).g(true);
            Intrinsics.checkNotNullExpressionValue(builderG, "setSupported(...)");
            if (getGoogleIdOption.j() != null) {
                String strJ = getGoogleIdOption.j();
                Intrinsics.checkNotNull(strJ);
                builderG.a(strJ, getGoogleIdOption.i());
            }
            BeginSignInRequest.GoogleIdTokenRequestOptions googleIdTokenRequestOptionsB = builderG.b();
            Intrinsics.checkNotNullExpressionValue(googleIdTokenRequestOptionsB, "build(...)");
            return googleIdTokenRequestOptionsB;
        }

        private final long c(Context context) {
            Intrinsics.checkNotNullExpressionValue(context.getPackageManager(), "getPackageManager(...)");
            return r3.getPackageInfo("com.google.android.gms", 0).versionCode;
        }

        private final boolean d(long j3) {
            return j3 < 231815000;
        }

        public final BeginSignInRequest a(GetCredentialRequest request, Context context) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(context, "context");
            BeginSignInRequest.Builder builder = new BeginSignInRequest.Builder();
            long jC = c(context);
            boolean z2 = false;
            boolean z3 = false;
            for (CredentialOption credentialOption : request.a()) {
                if (credentialOption instanceof GetPasswordOption) {
                    builder.f(new BeginSignInRequest.PasswordRequestOptions.Builder().b(true).a());
                    z2 = z2 || credentialOption.e();
                } else if ((credentialOption instanceof GetPublicKeyCredentialOption) && !z3) {
                    if (d(jC)) {
                        builder.e(PublicKeyCredentialControllerUtility.f35030a.g((GetPublicKeyCredentialOption) credentialOption));
                    } else {
                        builder.d(PublicKeyCredentialControllerUtility.f35030a.f((GetPublicKeyCredentialOption) credentialOption));
                    }
                    z3 = true;
                } else if (credentialOption instanceof GetGoogleIdOption) {
                    GetGoogleIdOption getGoogleIdOption = (GetGoogleIdOption) credentialOption;
                    builder.c(b(getGoogleIdOption));
                    if (z2 || getGoogleIdOption.g()) {
                    }
                }
            }
            if (jC > 241217000) {
                builder.g(request.e());
            }
            BeginSignInRequest beginSignInRequestA = builder.b(z2).a();
            Intrinsics.checkNotNullExpressionValue(beginSignInRequestA, "build(...)");
            return beginSignInRequestA;
        }

        private Companion() {
        }
    }
}
