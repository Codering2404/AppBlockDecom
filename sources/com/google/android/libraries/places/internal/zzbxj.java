package com.google.android.libraries.places.internal;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbxj extends zzblr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final boolean f77153a = zzbsz.j("GRPC_EXPERIMENTAL_ENABLE_NEW_PICK_FIRST", false);

    @Override // com.google.android.libraries.places.internal.zzble
    public final zzblp a(zzblg zzblgVar) {
        return f77153a ? new zzbxc(zzblgVar) : new zzbxi(zzblgVar);
    }

    @Override // com.google.android.libraries.places.internal.zzblr
    public final boolean b() {
        return true;
    }

    @Override // com.google.android.libraries.places.internal.zzblr
    public final int c() {
        return 5;
    }

    @Override // com.google.android.libraries.places.internal.zzblr
    public final String d() {
        return "pick_first";
    }

    @Override // com.google.android.libraries.places.internal.zzblr
    public final zzbms e(Map map) {
        try {
            Boolean boolI = zzbud.i(map, "shuffleAddressList");
            return zzbms.a(f77153a ? new zzbwx(boolI, null) : new zzbxe(boolI, null));
        } catch (RuntimeException e3) {
            return zzbms.b(zzbnp.f76496m.d(e3).e("Failed parsing configuration for pick_first"));
        }
    }
}
