package com.android.volley;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface Cache {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f57642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f57643b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f57644c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f57645d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f57646e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f57647f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Map f57648g = Collections.EMPTY_MAP;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List f57649h;

        public boolean a() {
            return b(System.currentTimeMillis());
        }

        boolean b(long j3) {
            return this.f57646e < j3;
        }

        boolean c(long j3) {
            return this.f57647f < j3;
        }
    }

    Entry a(String str);

    void b(String str, boolean z2);

    void c(String str, Entry entry);

    void clear();

    void initialize();
}
