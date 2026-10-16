package com.google.android.libraries.identity.googleid;

import android.os.Bundle;
import androidx.credentials.GetCustomCredentialOption;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class GetSignInWithGoogleOption extends GetCustomCredentialOption {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Companion f74616l = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f74617i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f74618j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f74619k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f74620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f74621b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f74622c;

        public Builder(String serverClientId) {
            Intrinsics.checkNotNullParameter(serverClientId, "serverClientId");
            this.f74620a = serverClientId;
        }

        public final GetSignInWithGoogleOption a() {
            return new GetSignInWithGoogleOption(this.f74620a, this.f74621b, this.f74622c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final Bundle a(String serverClientId, String str, String str2, boolean z2) {
            Intrinsics.checkNotNullParameter(serverClientId, "serverClientId");
            Bundle bundle = new Bundle();
            bundle.putString("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_SERVER_CLIENT_ID", serverClientId);
            bundle.putString("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_NONCE", str2);
            bundle.putString("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_HOSTED_DOMAIN_FILTER", str);
            bundle.putBoolean("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_AUTO_SELECT_ENABLED", true);
            bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_GOOGLE_ID_TOKEN_SUBTYPE", "com.google.android.libraries.identity.googleid.TYPE_GOOGLE_ID_TOKEN_SIWG_CREDENTIAL");
            return bundle;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetSignInWithGoogleOption(String serverClientId, String str, String str2) {
        super("com.google.android.libraries.identity.googleid.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL", Companion.a(serverClientId, str, str2, true), Companion.a(serverClientId, str, str2, true), true, true, null, 32, null);
        Intrinsics.checkNotNullParameter(serverClientId, "serverClientId");
        this.f74617i = serverClientId;
        this.f74618j = str;
        this.f74619k = str2;
        if (serverClientId.length() <= 0) {
            throw new IllegalArgumentException("serverClientId should not be empty");
        }
    }

    public final String g() {
        return this.f74618j;
    }

    public final String h() {
        return this.f74619k;
    }

    public final String i() {
        return this.f74617i;
    }
}
