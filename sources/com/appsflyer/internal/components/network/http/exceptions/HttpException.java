package com.appsflyer.internal.components.network.http.exceptions;

import com.appsflyer.internal.AFc1kSDK;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class HttpException extends IOException {
    private final AFc1kSDK values;

    public HttpException(Throwable th, AFc1kSDK aFc1kSDK) {
        super(th.getMessage(), th);
        this.values = aFc1kSDK;
    }

    public AFc1kSDK getMetrics() {
        return this.values;
    }
}
