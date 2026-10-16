package com.google.android.gms.internal.auth;

import android.util.Log;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbz extends FastSafeParcelableJsonResponse {
    public final byte[] toByteArray() {
        try {
            return toString().getBytes(Utf8Charset.NAME);
        } catch (UnsupportedEncodingException e3) {
            Log.e("AUTH", "Error serializing object.", e3);
            return null;
        }
    }
}
