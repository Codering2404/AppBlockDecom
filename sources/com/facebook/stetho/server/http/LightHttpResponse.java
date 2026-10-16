package com.facebook.stetho.server.http;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LightHttpResponse extends LightHttpMessage {
    public LightHttpBody body;
    public int code;
    public String reasonPhrase;

    public void prepare() {
        LightHttpBody lightHttpBody = this.body;
        if (lightHttpBody != null) {
            addHeader("Content-Type", lightHttpBody.contentType());
            addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(this.body.contentLength()));
        }
    }

    @Override // com.facebook.stetho.server.http.LightHttpMessage
    public void reset() {
        super.reset();
        this.code = -1;
        this.reasonPhrase = null;
        this.body = null;
    }
}
