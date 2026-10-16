package com.facebook.stetho.server.http;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class HandlerRegistry {
    private final ArrayList<PathMatcher> mPathMatchers = new ArrayList<>();
    private final ArrayList<HttpHandler> mHttpHandlers = new ArrayList<>();

    public synchronized HttpHandler lookup(String str) {
        int size = this.mPathMatchers.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.mPathMatchers.get(i3).match(str)) {
                return this.mHttpHandlers.get(i3);
            }
        }
        return null;
    }

    public synchronized void register(PathMatcher pathMatcher, HttpHandler httpHandler) {
        this.mPathMatchers.add(pathMatcher);
        this.mHttpHandlers.add(httpHandler);
    }

    public synchronized boolean unregister(PathMatcher pathMatcher, HttpHandler httpHandler) {
        int iIndexOf = this.mPathMatchers.indexOf(pathMatcher);
        if (iIndexOf < 0 || httpHandler != this.mHttpHandlers.get(iIndexOf)) {
            return false;
        }
        this.mPathMatchers.remove(iIndexOf);
        this.mHttpHandlers.remove(iIndexOf);
        return true;
    }
}
