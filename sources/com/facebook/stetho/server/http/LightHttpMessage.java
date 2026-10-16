package com.facebook.stetho.server.http;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LightHttpMessage {
    public final ArrayList<String> headerNames = new ArrayList<>();
    public final ArrayList<String> headerValues = new ArrayList<>();

    public void addHeader(String str, String str2) {
        this.headerNames.add(str);
        this.headerValues.add(str2);
    }

    public String getFirstHeaderValue(String str) {
        int size = this.headerNames.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (str.equals(this.headerNames.get(i3))) {
                return this.headerValues.get(i3);
            }
        }
        return null;
    }

    public void reset() {
        this.headerNames.clear();
        this.headerValues.clear();
    }
}
