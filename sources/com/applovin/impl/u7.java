package com.applovin.impl;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class u7 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f64114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f64115c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f64113a = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f64116d = System.currentTimeMillis();

    public u7(String str, Map map) {
        this.f64114b = str;
        this.f64115c = map;
    }

    public long a() {
        return this.f64116d;
    }

    public String b() {
        return this.f64113a;
    }

    public String c() {
        return this.f64114b;
    }

    public Map d() {
        return this.f64115c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        u7 u7Var = (u7) obj;
        if (this.f64116d == u7Var.f64116d && Objects.equals(this.f64114b, u7Var.f64114b) && Objects.equals(this.f64115c, u7Var.f64115c)) {
            return Objects.equals(this.f64113a, u7Var.f64113a);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f64114b;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Map map = this.f64115c;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        long j3 = this.f64116d;
        int i3 = (iHashCode2 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        String str2 = this.f64113a;
        return i3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Event{name='" + this.f64114b + "', id='" + this.f64113a + "', creationTimestampMillis=" + this.f64116d + ", parameters=" + this.f64115c + '}';
    }
}
