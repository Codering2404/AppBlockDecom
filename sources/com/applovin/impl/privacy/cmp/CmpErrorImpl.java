package com.applovin.impl.privacy.cmp;

import com.applovin.sdk.AppLovinCmpError;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class CmpErrorImpl implements AppLovinCmpError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppLovinCmpError.Code f62480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f62481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f62482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f62483d;

    public CmpErrorImpl(AppLovinCmpError.Code code, String str) {
        this(code, str, -1, "");
    }

    @Override // com.applovin.sdk.AppLovinCmpError
    public int getCmpCode() {
        return this.f62482c;
    }

    @Override // com.applovin.sdk.AppLovinCmpError
    public String getCmpMessage() {
        return this.f62483d;
    }

    @Override // com.applovin.sdk.AppLovinCmpError
    public AppLovinCmpError.Code getCode() {
        return this.f62480a;
    }

    @Override // com.applovin.sdk.AppLovinCmpError
    public String getMessage() {
        return this.f62481b;
    }

    public String toString() {
        return "CmpErrorImpl(code=" + getCode() + ", message=" + getMessage() + ", cmpCode=" + getCmpCode() + ", cmpMessage=" + getCmpMessage() + ")";
    }

    public CmpErrorImpl(AppLovinCmpError.Code code, String str, int i3, String str2) {
        this.f62480a = code;
        this.f62481b = str;
        this.f62482c = i3;
        this.f62483d = str2;
    }
}
