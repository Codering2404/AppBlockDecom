package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbmn {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static zzbmn f76420e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f76421a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f76422b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzbmm[] f76423c = new zzbmm[5];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f76424d;

    zzbmn() {
    }

    public static synchronized zzbmn a() {
        try {
            if (f76420e == null) {
                f76420e = new zzbmn();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f76420e;
    }

    private final void e() {
        zzbmm[] zzbmmVarArr = this.f76423c;
        this.f76423c = (zzbmm[]) Arrays.copyOf(zzbmmVarArr, zzbmmVarArr.length + 5);
    }

    public final List b() {
        List listUnmodifiableList;
        synchronized (this.f76421a) {
            listUnmodifiableList = Collections.unmodifiableList(Arrays.asList((zzbmm[]) Arrays.copyOfRange(this.f76423c, 0, this.f76424d)));
        }
        return listUnmodifiableList;
    }

    public final zzblu c(String str, String str2, String str3, List list, List list2, boolean z2) {
        zzblu zzbluVar;
        Preconditions.e(!Strings.b(str), "missing metric name");
        Preconditions.u(str2, "description");
        Preconditions.u(str3, "unit");
        Preconditions.u(list, "requiredLabelKeys");
        Preconditions.u(list2, "optionalLabelKeys");
        synchronized (this.f76421a) {
            try {
                Set set = this.f76422b;
                if (set.contains(str)) {
                    StringBuilder sb = new StringBuilder(str.length() + 32);
                    sb.append("Metric with name ");
                    sb.append(str);
                    sb.append(" already exists");
                    throw new IllegalStateException(sb.toString());
                }
                int i3 = this.f76424d;
                if (i3 + 1 == this.f76423c.length) {
                    e();
                }
                zzbluVar = new zzblu(i3, str, str2, str3, list, list2, false);
                this.f76423c[i3] = zzbluVar;
                set.add(str);
                this.f76424d++;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbluVar;
    }

    public final zzblv d(String str, String str2, String str3, List list, List list2, boolean z2) {
        zzblv zzblvVar;
        Preconditions.e(!Strings.b("grpc.subchannel.open_connections"), "missing metric name");
        Preconditions.u("EXPERIMENTAL. Number of open connections.", "description");
        Preconditions.u("{connection}", "unit");
        Preconditions.u(list, "requiredLabelKeys");
        Preconditions.u(list2, "optionalLabelKeys");
        synchronized (this.f76421a) {
            try {
                Set set = this.f76422b;
                if (set.contains("grpc.subchannel.open_connections")) {
                    StringBuilder sb = new StringBuilder(64);
                    sb.append("Metric with name ");
                    sb.append("grpc.subchannel.open_connections");
                    sb.append(" already exists");
                    throw new IllegalStateException(sb.toString());
                }
                int i3 = this.f76424d;
                if (i3 + 1 == this.f76423c.length) {
                    e();
                }
                zzblvVar = new zzblv(i3, "grpc.subchannel.open_connections", "EXPERIMENTAL. Number of open connections.", "{connection}", list, list2, false);
                this.f76423c[i3] = zzblvVar;
                set.add("grpc.subchannel.open_connections");
                this.f76424d++;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzblvVar;
    }
}
