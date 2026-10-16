package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.json.annotation.JsonValue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public enum Origin {
    INJECTED("injected"),
    USER_AGENT("user-agent"),
    INSPECTOR("inspector"),
    REGULAR("regular");

    private final String mValue;

    Origin(String str) {
        this.mValue = str;
    }

    @JsonValue
    public String getProtocolValue() {
        return this.mValue;
    }
}
