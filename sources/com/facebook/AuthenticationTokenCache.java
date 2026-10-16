package com.facebook;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AuthenticationTokenCache {
    public static final String CACHED_AUTHENTICATION_TOKEN_KEY = "com.facebook.AuthenticationManager.CachedAuthenticationToken";
    public static final Companion Companion = new Companion(null);
    public final SharedPreferences sharedPreferences;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public AuthenticationTokenCache(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.sharedPreferences = sharedPreferences;
    }

    private final AuthenticationToken getCachedAuthenticationToken() {
        String string = this.sharedPreferences.getString(CACHED_AUTHENTICATION_TOKEN_KEY, null);
        if (string == null) {
            return null;
        }
        try {
            return new AuthenticationToken(new JSONObject(string));
        } catch (JSONException unused) {
            return null;
        }
    }

    private final boolean hasCachedAuthenticationToken() {
        return this.sharedPreferences.contains(CACHED_AUTHENTICATION_TOKEN_KEY);
    }

    public final void clear() {
        this.sharedPreferences.edit().remove(CACHED_AUTHENTICATION_TOKEN_KEY).apply();
    }

    public final AuthenticationToken load() {
        if (hasCachedAuthenticationToken()) {
            return getCachedAuthenticationToken();
        }
        return null;
    }

    public final void save(AuthenticationToken authenticationToken) {
        Intrinsics.checkNotNullParameter(authenticationToken, "authenticationToken");
        try {
            this.sharedPreferences.edit().putString(CACHED_AUTHENTICATION_TOKEN_KEY, authenticationToken.toJSONObject$facebook_core_release().toString()).apply();
        } catch (JSONException unused) {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AuthenticationTokenCache() {
        SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(AuthenticationTokenManager.SHARED_PREFERENCES_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getApplicationContext()\n…ME, Context.MODE_PRIVATE)");
        this(sharedPreferences);
    }
}
