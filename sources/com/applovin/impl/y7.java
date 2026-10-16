package com.applovin.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface y7 {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f65161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f65162b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f65163c;

        public a(byte[] bArr, String str, int i3) {
            this.f65161a = bArr;
            this.f65162b = str;
            this.f65163c = i3;
        }

        public byte[] a() {
            return this.f65161a;
        }

        public String b() {
            return this.f65162b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
        void a(y7 y7Var, byte[] bArr, int i3, int i4, byte[] bArr2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface c {
        y7 a(UUID uuid);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f65164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f65165b;

        public d(byte[] bArr, String str) {
            this.f65164a = bArr;
            this.f65165b = str;
        }

        public byte[] a() {
            return this.f65164a;
        }

        public String b() {
            return this.f65165b;
        }
    }

    a a(byte[] bArr, List list, int i3, HashMap map);

    void a();

    void a(b bVar);

    void a(byte[] bArr);

    void a(byte[] bArr, byte[] bArr2);

    boolean a(byte[] bArr, String str);

    d b();

    Map b(byte[] bArr);

    byte[] b(byte[] bArr, byte[] bArr2);

    int c();

    void c(byte[] bArr);

    y4 d(byte[] bArr);

    byte[] d();
}
