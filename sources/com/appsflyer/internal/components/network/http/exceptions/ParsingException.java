package com.appsflyer.internal.components.network.http.exceptions;

import com.appsflyer.internal.AFc1dSDK;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ParsingException extends IOException {
    private final AFc1dSDK<String> values;

    public ParsingException(String str, Throwable th, AFc1dSDK<String> aFc1dSDK) {
        super(str, th);
        this.values = aFc1dSDK;
    }

    public AFc1dSDK<String> getRawResponse() {
        return this.values;
    }
}
