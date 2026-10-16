package com.squareup.okhttp;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f92994a;

    Protocol(String str) {
        this.f92994a = str;
    }

    public static Protocol a(String str) throws IOException {
        Protocol protocol = HTTP_1_0;
        if (str.equals(protocol.f92994a)) {
            return protocol;
        }
        Protocol protocol2 = HTTP_1_1;
        if (str.equals(protocol2.f92994a)) {
            return protocol2;
        }
        Protocol protocol3 = HTTP_2;
        if (str.equals(protocol3.f92994a)) {
            return protocol3;
        }
        Protocol protocol4 = SPDY_3;
        if (str.equals(protocol4.f92994a)) {
            return protocol4;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f92994a;
    }
}
