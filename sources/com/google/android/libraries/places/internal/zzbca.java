package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzbca implements zzbff {
    static {
        zzbdb zzbdbVar = zzbdb.f76041b;
        int i3 = zzbcc.f75986a;
    }

    @Override // com.google.android.libraries.places.internal.zzbff
    public final /* bridge */ /* synthetic */ Object b(zzbco zzbcoVar, zzbdb zzbdbVar) throws zzbed {
        zzbfx zzbfxVar;
        zzbex zzbexVar = (zzbex) a(zzbcoVar, zzbdbVar);
        if (zzbexVar == null || zzbexVar.c()) {
            return zzbexVar;
        }
        if (zzbexVar instanceof zzbby) {
            zzbfxVar = new zzbfx((zzbby) zzbexVar);
        } else {
            if (zzbexVar instanceof zzbbz) {
                throw null;
            }
            zzbfxVar = new zzbfx(zzbexVar);
        }
        throw zzbfxVar.a();
    }
}
