package com.applovin.impl;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface qo {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f62660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f62661b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f62662c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f62663d;

        public a(int i3, byte[] bArr, int i4, int i5) {
            this.f62660a = i3;
            this.f62661b = bArr;
            this.f62662c = i4;
            this.f62663d = i5;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                a aVar = (a) obj;
                if (this.f62660a == aVar.f62660a && this.f62662c == aVar.f62662c && this.f62663d == aVar.f62663d && Arrays.equals(this.f62661b, aVar.f62661b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f62660a * 31) + Arrays.hashCode(this.f62661b)) * 31) + this.f62662c) * 31) + this.f62663d;
        }
    }

    default int a(f5 f5Var, int i3, boolean z2) {
        return a(f5Var, i3, z2, 0);
    }

    int a(f5 f5Var, int i3, boolean z2, int i4);

    void a(long j3, int i3, int i4, int i5, a aVar);

    void a(ah ahVar, int i3, int i4);

    void a(e9 e9Var);

    default void a(ah ahVar, int i3) {
        a(ahVar, i3, 0);
    }
}
