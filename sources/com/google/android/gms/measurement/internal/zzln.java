package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzln implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final URL f74162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f74163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzll f74164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f74165d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f74166f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ zzlo f74167g;

    public zzln(zzlo zzloVar, String str, URL url, byte[] bArr, Map map, zzll zzllVar) {
        Objects.requireNonNull(zzloVar);
        this.f74167g = zzloVar;
        Preconditions.g(str);
        Preconditions.m(url);
        Preconditions.m(zzllVar);
        this.f74162a = url;
        this.f74163b = bArr;
        this.f74164c = zzllVar;
        this.f74165d = str;
        this.f74166f = map;
    }

    private final void b(final int i3, final Exception exc, final byte[] bArr, final Map map) {
        this.f74167g.f73997a.b().t(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlm
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f74157a.a(i3, exc, bArr, map);
            }
        });
    }

    final /* synthetic */ void a(int i3, Exception exc, byte[] bArr, Map map) {
        this.f74164c.a(this.f74165d, i3, exc, bArr, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0135 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x015d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.google.android.gms.measurement.internal.zzln] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r6v3 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzln.run():void");
    }
}
