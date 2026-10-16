package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfx {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object f73612g = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f73613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbn f73614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f73615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f73616d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile Object f73617e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile Object f73618f = null;

    /* synthetic */ zzfx(String str, Object obj, Object obj2, zzbn zzbnVar, byte[] bArr) {
        this.f73613a = str;
        this.f73615c = obj;
        this.f73614b = zzbnVar;
    }

    public final String a() {
        return this.f73613a;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f73616d
            monitor-enter(r0)
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L68
            if (r4 == 0) goto L7
            return r4
        L7:
            com.google.android.gms.measurement.internal.zzae r4 = com.google.android.gms.measurement.internal.zzfr.f73606a
            if (r4 != 0) goto Le
            java.lang.Object r4 = r3.f73615c
            return r4
        Le:
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzfx.f73612g
            monitor-enter(r4)
            boolean r0 = com.google.android.gms.measurement.internal.zzae.a()     // Catch: java.lang.Throwable -> L1e
            if (r0 == 0) goto L24
            java.lang.Object r0 = r3.f73618f     // Catch: java.lang.Throwable -> L1e
            if (r0 != 0) goto L20
            java.lang.Object r0 = r3.f73615c     // Catch: java.lang.Throwable -> L1e
            goto L22
        L1e:
            r0 = move-exception
            goto L66
        L20:
            java.lang.Object r0 = r3.f73618f     // Catch: java.lang.Throwable -> L1e
        L22:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L1e
            return r0
        L24:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L1e
            java.util.List r4 = com.google.android.gms.measurement.internal.zzfy.b()     // Catch: java.lang.SecurityException -> L5a
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.SecurityException -> L5a
        L2d:
            boolean r0 = r4.hasNext()     // Catch: java.lang.SecurityException -> L5a
            if (r0 == 0) goto L5a
            java.lang.Object r0 = r4.next()     // Catch: java.lang.SecurityException -> L5a
            com.google.android.gms.measurement.internal.zzfx r0 = (com.google.android.gms.measurement.internal.zzfx) r0     // Catch: java.lang.SecurityException -> L5a
            boolean r1 = com.google.android.gms.measurement.internal.zzae.a()     // Catch: java.lang.SecurityException -> L5a
            if (r1 != 0) goto L52
            r1 = 0
            com.google.android.gms.measurement.internal.zzbn r2 = r0.f73614b     // Catch: java.lang.IllegalStateException -> L48 java.lang.SecurityException -> L5a
            if (r2 == 0) goto L48
            java.lang.Object r1 = r2.zza()     // Catch: java.lang.IllegalStateException -> L48 java.lang.SecurityException -> L5a
        L48:
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzfx.f73612g     // Catch: java.lang.SecurityException -> L5a
            monitor-enter(r2)     // Catch: java.lang.SecurityException -> L5a
            r0.f73618f = r1     // Catch: java.lang.Throwable -> L4f
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L4f
            goto L2d
        L4f:
            r4 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L4f
            throw r4     // Catch: java.lang.SecurityException -> L5a
        L52:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.SecurityException -> L5a
            java.lang.String r0 = "Refreshing flag cache must be done on a worker thread."
            r4.<init>(r0)     // Catch: java.lang.SecurityException -> L5a
            throw r4     // Catch: java.lang.SecurityException -> L5a
        L5a:
            com.google.android.gms.measurement.internal.zzbn r4 = r3.f73614b
            if (r4 != 0) goto L61
        L5e:
            java.lang.Object r4 = r3.f73615c
            goto L65
        L61:
            java.lang.Object r4 = r4.zza()     // Catch: java.lang.Throwable -> L5e
        L65:
            return r4
        L66:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L1e
            throw r0
        L68:
            r4 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L68
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfx.b(java.lang.Object):java.lang.Object");
    }
}
