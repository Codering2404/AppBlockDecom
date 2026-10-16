package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.applovin.impl.k5;
import com.applovin.impl.pa;
import com.applovin.impl.y7;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class qa implements pd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final pa.b f62599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f62600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f62601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f62602d;

    public qa(String str, boolean z2, pa.b bVar) {
        b1.a((z2 && TextUtils.isEmpty(str)) ? false : true);
        this.f62599a = bVar;
        this.f62600b = str;
        this.f62601c = z2;
        this.f62602d = new HashMap();
    }

    @Override // com.applovin.impl.pd
    public byte[] a(UUID uuid, y7.a aVar) throws qd {
        String strB = aVar.b();
        if (this.f62601c || TextUtils.isEmpty(strB)) {
            strB = this.f62600b;
        }
        if (TextUtils.isEmpty(strB)) {
            k5.b bVar = new k5.b();
            Uri uri = Uri.EMPTY;
            throw new qd(bVar.a(uri).a(), uri, fb.h(), 0L, new IllegalStateException("No license URL"));
        }
        HashMap map = new HashMap();
        UUID uuid2 = t2.f63864e;
        map.put("Content-Type", uuid2.equals(uuid) ? "text/xml" : t2.f63862c.equals(uuid) ? "application/json" : "application/octet-stream");
        if (uuid2.equals(uuid)) {
            map.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.f62602d) {
            map.putAll(this.f62602d);
        }
        return a(this.f62599a, strB, aVar.a(), map);
    }

    @Override // com.applovin.impl.pd
    public byte[] a(UUID uuid, y7.d dVar) {
        return a(this.f62599a, dVar.b() + "&signedRequest=" + xp.a(dVar.a()), null, Collections.EMPTY_MAP);
    }

    private static String a(pa.e eVar, int i3) {
        Map map;
        List list;
        int i4 = eVar.f62425d;
        if ((i4 != 307 && i4 != 308) || i3 >= 5 || (map = eVar.f62427g) == null || (list = (List) map.get("Location")) == null || list.isEmpty()) {
            return null;
        }
        return (String) list.get(0);
    }

    public void a(String str, String str2) {
        b1.a((Object) str);
        b1.a((Object) str2);
        synchronized (this.f62602d) {
            this.f62602d.put(str, str2);
        }
    }

    private static byte[] a(pa.b bVar, String str, byte[] bArr, Map map) throws qd {
        fl flVar = new fl(bVar.a());
        k5 k5VarA = new k5.b().b(str).a(map).b(2).a(bArr).a(1).a();
        int i3 = 0;
        k5 k5VarA2 = k5VarA;
        while (true) {
            try {
                j5 j5Var = new j5(flVar, k5VarA2);
                try {
                    try {
                        return xp.a((InputStream) j5Var);
                    } catch (pa.e e3) {
                        String strA = a(e3, i3);
                        if (strA != null) {
                            i3++;
                            k5VarA2 = k5VarA2.a().b(strA).a();
                            xp.a((Closeable) j5Var);
                        } else {
                            throw e3;
                        }
                    }
                } finally {
                    xp.a((Closeable) j5Var);
                }
            } catch (Exception e4) {
                throw new qd(k5VarA, (Uri) b1.a(flVar.h()), flVar.e(), flVar.g(), e4);
            }
        }
    }
}
