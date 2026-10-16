package com.google.android.libraries.identity.googleid;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.credentials.CustomCredential;
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
public final class GoogleIdTokenCredential extends CustomCredential {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Companion f74623k = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f74624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f74625e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f74626f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f74627g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f74628h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Uri f74629i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f74630j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f74631a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f74632b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f74633c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f74634d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f74635e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Uri f74636f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f74637g;

        public final GoogleIdTokenCredential a() {
            return new GoogleIdTokenCredential(this.f74631a, this.f74632b, this.f74633c, this.f74634d, this.f74635e, this.f74636f, this.f74637g);
        }

        public final Builder b(String str) {
            this.f74633c = str;
            return this;
        }

        public final Builder c(String str) {
            this.f74634d = str;
            return this;
        }

        public final Builder d(String str) {
            this.f74635e = str;
            return this;
        }

        public final Builder e(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.f74631a = id;
            return this;
        }

        public final Builder f(String idToken) {
            Intrinsics.checkNotNullParameter(idToken, "idToken");
            this.f74632b = idToken;
            return this;
        }

        public final Builder g(String str) {
            this.f74637g = str;
            return this;
        }

        public final Builder h(Uri uri) {
            this.f74636f = uri;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final GoogleIdTokenCredential a(Bundle data) throws GoogleIdTokenParsingException {
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                String string = data.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_ID");
                String string2 = data.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_ID_TOKEN");
                String string3 = data.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_DISPLAY_NAME");
                String string4 = data.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_FAMILY_NAME");
                String string5 = data.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_GIVEN_NAME");
                Uri uri = Build.VERSION.SDK_INT >= 33 ? (Uri) data.getParcelable("com.google.android.libraries.identity.googleid.BUNDLE_KEY_PROFILE_PICTURE_URI", Uri.class) : (Uri) data.getParcelable("com.google.android.libraries.identity.googleid.BUNDLE_KEY_PROFILE_PICTURE_URI");
                String string6 = data.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_PHONE_NUMBER");
                Intrinsics.checkNotNull(string);
                Intrinsics.checkNotNull(string2);
                return new GoogleIdTokenCredential(string, string2, string3, string4, string5, uri, string6);
            } catch (Exception e3) {
                throw new GoogleIdTokenParsingException(e3);
            }
        }
    }

    public GoogleIdTokenCredential(String id, String idToken, String str, String str2, String str3, Uri uri, String str4) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(idToken, "idToken");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(idToken, "idToken");
        Bundle bundle = new Bundle();
        bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_ID", id);
        bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_ID_TOKEN", idToken);
        bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_DISPLAY_NAME", str);
        bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_FAMILY_NAME", str2);
        bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_GIVEN_NAME", str3);
        bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_PHONE_NUMBER", str4);
        bundle.putParcelable("com.google.android.libraries.identity.googleid.BUNDLE_KEY_PROFILE_PICTURE_URI", uri);
        super("com.google.android.libraries.identity.googleid.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL", bundle);
        this.f74624d = id;
        this.f74625e = idToken;
        this.f74626f = str;
        this.f74627g = str2;
        this.f74628h = str3;
        this.f74629i = uri;
        this.f74630j = str4;
        if (id.length() <= 0) {
            throw new IllegalArgumentException("id should not be empty");
        }
        if (idToken.length() <= 0) {
            throw new IllegalArgumentException("idToken should not be empty");
        }
    }

    public final String c() {
        return this.f74625e;
    }
}
