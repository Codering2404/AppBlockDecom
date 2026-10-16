package com.android.volley.toolbox;

import com.android.volley.Cache;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class NoCache implements Cache {
    @Override // com.android.volley.Cache
    public Cache.Entry a(String str) {
        return null;
    }

    @Override // com.android.volley.Cache
    public void clear() {
    }

    @Override // com.android.volley.Cache
    public void initialize() {
    }

    @Override // com.android.volley.Cache
    public void b(String str, boolean z2) {
    }

    @Override // com.android.volley.Cache
    public void c(String str, Cache.Entry entry) {
    }
}
