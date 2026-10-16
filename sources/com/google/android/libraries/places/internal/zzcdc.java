package com.google.android.libraries.places.internal;

import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcdc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final zzcfj f77643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zzccz[] f77644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map f77645c;

    static {
        zzcfj zzcfjVar = zzcfj.f77742d;
        f77643a = zzcfi.a(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        zzccz zzcczVar = new zzccz(zzccz.f77626h, zzcfi.a(""));
        zzcfj zzcfjVar2 = zzccz.f77623e;
        zzccz zzcczVar2 = new zzccz(zzcfjVar2, zzcfi.a("GET"));
        zzccz zzcczVar3 = new zzccz(zzcfjVar2, zzcfi.a("POST"));
        zzcfj zzcfjVar3 = zzccz.f77624f;
        zzccz zzcczVar4 = new zzccz(zzcfjVar3, zzcfi.a("/"));
        zzccz zzcczVar5 = new zzccz(zzcfjVar3, zzcfi.a("/index.html"));
        zzcfj zzcfjVar4 = zzccz.f77625g;
        zzccz zzcczVar6 = new zzccz(zzcfjVar4, zzcfi.a("http"));
        zzccz zzcczVar7 = new zzccz(zzcfjVar4, zzcfi.a("https"));
        zzcfj zzcfjVar5 = zzccz.f77622d;
        f77644b = new zzccz[]{zzcczVar, zzcczVar2, zzcczVar3, zzcczVar4, zzcczVar5, zzcczVar6, zzcczVar7, new zzccz(zzcfjVar5, zzcfi.a("200")), new zzccz(zzcfjVar5, zzcfi.a("204")), new zzccz(zzcfjVar5, zzcfi.a("206")), new zzccz(zzcfjVar5, zzcfi.a("304")), new zzccz(zzcfjVar5, zzcfi.a("400")), new zzccz(zzcfjVar5, zzcfi.a("404")), new zzccz(zzcfjVar5, zzcfi.a("500")), new zzccz("accept-charset", ""), new zzccz("accept-encoding", "gzip, deflate"), new zzccz("accept-language", ""), new zzccz("accept-ranges", ""), new zzccz("accept", ""), new zzccz("access-control-allow-origin", ""), new zzccz("age", ""), new zzccz("allow", ""), new zzccz("authorization", ""), new zzccz("cache-control", ""), new zzccz("content-disposition", ""), new zzccz("content-encoding", ""), new zzccz("content-language", ""), new zzccz("content-length", ""), new zzccz("content-location", ""), new zzccz("content-range", ""), new zzccz("content-type", ""), new zzccz("cookie", ""), new zzccz("date", ""), new zzccz("etag", ""), new zzccz("expect", ""), new zzccz("expires", ""), new zzccz("from", ""), new zzccz(DiagnosticsTracker.HOST_KEY, ""), new zzccz("if-match", ""), new zzccz("if-modified-since", ""), new zzccz("if-none-match", ""), new zzccz("if-range", ""), new zzccz("if-unmodified-since", ""), new zzccz("last-modified", ""), new zzccz("link", ""), new zzccz("location", ""), new zzccz("max-forwards", ""), new zzccz("proxy-authenticate", ""), new zzccz("proxy-authorization", ""), new zzccz("range", ""), new zzccz("referer", ""), new zzccz("refresh", ""), new zzccz("retry-after", ""), new zzccz("server", ""), new zzccz("set-cookie", ""), new zzccz("strict-transport-security", ""), new zzccz("transfer-encoding", ""), new zzccz("user-agent", ""), new zzccz("vary", ""), new zzccz("via", ""), new zzccz("www-authenticate", "")};
        LinkedHashMap linkedHashMap = new LinkedHashMap(61);
        int i3 = 0;
        while (true) {
            zzccz[] zzcczVarArr = f77644b;
            int length = zzcczVarArr.length;
            if (i3 >= 61) {
                f77645c = Collections.unmodifiableMap(linkedHashMap);
                return;
            } else {
                if (!linkedHashMap.containsKey(zzcczVarArr[i3].f77627a)) {
                    linkedHashMap.put(zzcczVarArr[i3].f77627a, Integer.valueOf(i3));
                }
                i3++;
            }
        }
    }

    static /* synthetic */ zzcfj a(zzcfj zzcfjVar) throws IOException {
        int iJ = zzcfjVar.j();
        for (int i3 = 0; i3 < iJ; i3++) {
            byte bI = zzcfjVar.i(i3);
            if (bI >= 65 && bI <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: ".concat(zzcfjVar.e()));
            }
        }
        return zzcfjVar;
    }
}
