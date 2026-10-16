package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgy implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final URL f73749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f73750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzgw f73751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f73752d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f73753f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ zzgz f73754g;

    public zzgy(zzgz zzgzVar, String str, URL url, byte[] bArr, Map map, zzgw zzgwVar) {
        Objects.requireNonNull(zzgzVar);
        this.f73754g = zzgzVar;
        Preconditions.g(str);
        Preconditions.m(url);
        Preconditions.m(zzgwVar);
        this.f73749a = url;
        this.f73750b = bArr;
        this.f73751c = zzgwVar;
        this.f73752d = str;
        this.f73753f = map;
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x00fe: MOVE (r9 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]) (LINE:255), block:B:51:0x00fc */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0101: MOVE (r10 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]) (LINE:258), block:B:52:0x0100 */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0164 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgy.run():void");
    }
}
