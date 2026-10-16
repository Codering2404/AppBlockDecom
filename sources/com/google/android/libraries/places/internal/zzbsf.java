package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbsf extends zzbmz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f76785a = zzbkx.a(zzbsf.class.getClassLoader());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f76786b = 0;

    @Override // com.google.android.libraries.places.internal.zzbmt
    public final zzbmy a(URI uri, zzbmr zzbmrVar) {
        if (!"dns".equals(uri.getScheme())) {
            return null;
        }
        String str = (String) Preconditions.u(uri.getPath(), "targetPath");
        Preconditions.o(str.startsWith("/"), "the path component (%s) of the target (%s) must start with '/'", str, uri);
        return new zzbse(uri.getAuthority(), str.substring(1), zzbmrVar, zzbsz.f76835p, Stopwatch.d(), f76785a);
    }

    @Override // com.google.android.libraries.places.internal.zzbmt
    public final String b() {
        return "dns";
    }

    @Override // com.google.android.libraries.places.internal.zzbmz
    protected final boolean c() {
        return true;
    }

    @Override // com.google.android.libraries.places.internal.zzbmz
    public final int d() {
        return 5;
    }

    @Override // com.google.android.libraries.places.internal.zzbmz
    public final Collection e() {
        return Collections.singleton(InetSocketAddress.class);
    }
}
