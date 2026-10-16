package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzqx implements zzrv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final UUID f78488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f78489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f78490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Thread f78491d;

    zzqx(String str, UUID uuid, String str2, zzrt zzrtVar) {
        this.f78490c = (String) Preconditions.t(str);
        this.f78488a = uuid;
        this.f78489b = str2;
        zzse zzseVar = zzrtVar.f78538c;
        this.f78491d = Thread.currentThread();
    }

    public static String a(UUID uuid) {
        return "tk-trace-id: ".concat(String.valueOf(Long.toString(uuid.getLeastSignificantBits() >>> 1, 36)));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        zzqs zzqsVar = zzrh.f78506b;
        Preconditions.t(this);
        zzrt zzrtVarD = zzrh.d();
        zzrv zzrvVar = zzrtVarD.f78537b;
        if (zzrvVar == null) {
            String strZze = zze();
            StringBuilder sb = new StringBuilder(String.valueOf(strZze).length() + 101);
            sb.append("Tried to end [");
            sb.append(strZze);
            sb.append("], but no trace was active. This is caused by mismatched or missing calls to beginSpan.");
            throw new zzre(sb.toString());
        }
        if (this == zzrvVar) {
            zzrh.c(zzrtVarD, null);
            this.f78491d = null;
            return;
        }
        String strZze2 = zze();
        String strZze3 = zzrvVar.zze();
        StringBuilder sb2 = new StringBuilder(String.valueOf(strZze2).length() + 79 + String.valueOf(strZze3).length() + 1);
        sb2.append("Tried to end span ");
        sb2.append(strZze2);
        sb2.append(", but that span is not the current span. The current span is ");
        sb2.append(strZze3);
        sb2.append(".");
        throw new zzrf(sb2.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e5 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzqx.toString():java.lang.String");
    }

    @Override // com.google.android.libraries.places.internal.zzrv
    public final Thread zza() {
        return this.f78491d;
    }

    @Override // com.google.android.libraries.places.internal.zzrv
    public final zzrv zzb() {
        return null;
    }

    @Override // com.google.android.libraries.places.internal.zzrv
    public final UUID zzc() {
        return this.f78488a;
    }

    @Override // com.google.android.libraries.places.internal.zzrv
    public final String zzd() {
        return this.f78489b;
    }

    @Override // com.google.android.libraries.places.internal.zzrv
    public final String zze() {
        return this.f78490c;
    }
}
