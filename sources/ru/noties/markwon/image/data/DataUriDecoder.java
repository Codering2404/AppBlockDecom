package ru.noties.markwon.image.data;

import android.text.TextUtils;
import android.util.Base64;
import com.facebook.stetho.common.Utf8Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class DataUriDecoder {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Impl extends DataUriDecoder {
        Impl() {
        }

        @Override // ru.noties.markwon.image.data.DataUriDecoder
        public byte[] b(DataUri dataUri) {
            String strC = dataUri.c();
            if (!TextUtils.isEmpty(strC)) {
                try {
                    return dataUri.a() ? Base64.decode(strC.getBytes(Utf8Charset.NAME), 0) : strC.getBytes(Utf8Charset.NAME);
                } catch (Throwable unused) {
                }
            }
            return null;
        }
    }

    public static DataUriDecoder a() {
        return new Impl();
    }

    public abstract byte[] b(DataUri dataUri);
}
