package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbku {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicLong f76352d = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f76353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f76354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f76355c;

    zzbku(String str, String str2, long j3) {
        Preconditions.u(str, "typeName");
        Preconditions.e(!str.isEmpty(), "empty type");
        this.f76353a = str;
        this.f76354b = str2;
        this.f76355c = j3;
    }

    public static zzbku a(Class cls, String str) {
        String simpleName = ((Class) Preconditions.u(cls, "type")).getSimpleName();
        if (simpleName.isEmpty()) {
            simpleName = cls.getName().substring(cls.getPackage().getName().length() + 1);
        }
        return b(simpleName, str);
    }

    public static zzbku b(String str, String str2) {
        return new zzbku(str, str2, f76352d.incrementAndGet());
    }

    public final long c() {
        return this.f76355c;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.f76353a;
        int length = String.valueOf(str).length();
        long j3 = this.f76355c;
        StringBuilder sb2 = new StringBuilder(length + 1 + String.valueOf(j3).length() + 1);
        sb2.append(str);
        sb2.append("<");
        sb2.append(j3);
        sb2.append(">");
        sb.append(sb2.toString());
        String str2 = this.f76354b;
        if (str2 != null) {
            sb.append(": (");
            sb.append(str2);
            sb.append(')');
        }
        return sb.toString();
    }
}
