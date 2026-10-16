package com.facebook.internal.security;

import android.util.Base64;
import android.util.Log;
import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.security.OidcSecurityUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class OidcSecurityUtil {
    public static final OidcSecurityUtil INSTANCE = new OidcSecurityUtil();
    private static final String OPENID_KEYS_PATH = "/.well-known/oauth/openid/keys/";
    public static final String SIGNATURE_ALGORITHM_SHA256 = "SHA256withRSA";
    public static final long TIMEOUT_IN_MILLISECONDS = 5000;

    private OidcSecurityUtil() {
    }

    @JvmStatic
    public static final PublicKey getPublicKeyFromString(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        byte[] bArrDecode = Base64.decode(StringsKt.O(StringsKt.O(StringsKt.O(key, "\n", "", false, 4, null), "-----BEGIN PUBLIC KEY-----", "", false, 4, null), "-----END PUBLIC KEY-----", "", false, 4, null), 0);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(pubKeyString, Base64.DEFAULT)");
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArrDecode));
        Intrinsics.checkNotNullExpressionValue(publicKeyGeneratePublic, "kf.generatePublic(x509publicKey)");
        return publicKeyGeneratePublic;
    }

    @JvmStatic
    public static final String getRawKeyFromEndPoint(final String kid) {
        Intrinsics.checkNotNullParameter(kid, "kid");
        final URL url = new URL("https", "www." + FacebookSdk.getFacebookDomain(), OPENID_KEYS_PATH);
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition conditionNewCondition = reentrantLock.newCondition();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        FacebookSdk.getExecutor().execute(new Runnable() { // from class: s.a
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                OidcSecurityUtil.getRawKeyFromEndPoint$lambda$1(url, objectRef, kid, reentrantLock, conditionNewCondition);
            }
        });
        reentrantLock.lock();
        try {
            conditionNewCondition.await(5000L, TimeUnit.MILLISECONDS);
            reentrantLock.unlock();
            return (String) objectRef.f140144a;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @JvmStatic
    public static final boolean verify(PublicKey publicKey, String data, String signature) {
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(signature, "signature");
        try {
            Signature signature2 = Signature.getInstance(SIGNATURE_ALGORITHM_SHA256);
            signature2.initVerify(publicKey);
            byte[] bytes = data.getBytes(Charsets.f140510b);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            signature2.update(bytes);
            byte[] bArrDecode = Base64.decode(signature, 8);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(signature, Base64.URL_SAFE)");
            return signature2.verify(bArrDecode);
        } catch (Exception unused) {
            return false;
        }
    }

    public final String getOPENID_KEYS_PATH() {
        return OPENID_KEYS_PATH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRawKeyFromEndPoint$lambda$1(URL url, Ref.ObjectRef result, String kid, ReentrantLock lock, Condition condition) throws IOException {
        Intrinsics.checkNotNullParameter(url, rnFwbPAQmQTnL.RtqLWgWQGwg);
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(kid, "$kid");
        Intrinsics.checkNotNullParameter(lock, "$lock");
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        try {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                Intrinsics.checkNotNullExpressionValue(inputStream, "connection.inputStream");
                String strH = TextStreamsKt.h(new BufferedReader(new InputStreamReader(inputStream, Charsets.f140510b), Utility.DEFAULT_STREAM_BUFFER_SIZE));
                httpURLConnection.getInputStream().close();
                result.f140144a = new JSONObject(strH).optString(kid);
                httpURLConnection.disconnect();
                lock.lock();
                try {
                    condition.signal();
                    Unit unit = Unit.f139807a;
                } finally {
                }
            } catch (Throwable th) {
                httpURLConnection.disconnect();
                lock.lock();
                try {
                    condition.signal();
                    Unit unit2 = Unit.f139807a;
                    throw th;
                } finally {
                }
            }
        } catch (Exception e3) {
            String name = INSTANCE.getClass().getName();
            String message = e3.getMessage();
            if (message == null) {
                message = "Error getting public key";
            }
            Log.d(name, message);
            httpURLConnection.disconnect();
            lock.lock();
            try {
                condition.signal();
                Unit unit3 = Unit.f139807a;
            } finally {
            }
        }
    }
}
