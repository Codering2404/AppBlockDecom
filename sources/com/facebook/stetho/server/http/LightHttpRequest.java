package com.facebook.stetho.server.http;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LightHttpRequest extends LightHttpMessage {
    public String method;
    public String protocol;
    public Uri uri;

    @Override // com.facebook.stetho.server.http.LightHttpMessage
    public void reset() {
        super.reset();
        this.method = null;
        this.uri = null;
        this.protocol = null;
    }
}
