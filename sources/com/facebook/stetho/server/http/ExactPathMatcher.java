package com.facebook.stetho.server.http;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ExactPathMatcher implements PathMatcher {
    private final String mPath;

    public ExactPathMatcher(String str) {
        this.mPath = str;
    }

    @Override // com.facebook.stetho.server.http.PathMatcher
    public boolean match(String str) {
        return this.mPath.equals(str);
    }
}
