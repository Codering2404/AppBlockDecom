package com.facebook.stetho.server.http;

import com.facebook.stetho.common.Utf8Charset;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LightHttpBody {
    public static LightHttpBody create(String str, String str2) {
        try {
            return create(str.getBytes(Utf8Charset.NAME), str2);
        } catch (UnsupportedEncodingException e3) {
            throw new RuntimeException(e3);
        }
    }

    public abstract int contentLength();

    public abstract String contentType();

    public abstract void writeTo(OutputStream outputStream) throws IOException;

    public static LightHttpBody create(final byte[] bArr, final String str) {
        return new LightHttpBody() { // from class: com.facebook.stetho.server.http.LightHttpBody.1
            @Override // com.facebook.stetho.server.http.LightHttpBody
            public int contentLength() {
                return bArr.length;
            }

            @Override // com.facebook.stetho.server.http.LightHttpBody
            public String contentType() {
                return str;
            }

            @Override // com.facebook.stetho.server.http.LightHttpBody
            public void writeTo(OutputStream outputStream) throws IOException {
                outputStream.write(bArr);
            }
        };
    }
}
