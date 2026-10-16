package com.google.android.libraries.places.internal;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbdl extends zzbca {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbdq f76082a;

    public zzbdl(zzbdq zzbdqVar) {
        this.f76082a = zzbdqVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbff
    public final /* synthetic */ Object a(zzbco zzbcoVar, zzbdb zzbdbVar) throws zzbed {
        int i3 = zzbdq.zzd;
        zzbdq zzbdqVarX = this.f76082a.x();
        try {
            zzbfl zzbflVarB = zzbfh.a().b(zzbdqVarX.getClass());
            zzbflVarB.b(zzbdqVarX, zzbcp.r(zzbcoVar), zzbdbVar);
            zzbflVarB.zzh(zzbdqVarX);
            return zzbdqVarX;
        } catch (zzbed e3) {
            if (e3.b()) {
                throw new zzbed(e3);
            }
            throw e3;
        } catch (zzbfx e4) {
            throw e4.a();
        } catch (IOException e5) {
            if (e5.getCause() instanceof zzbed) {
                throw ((zzbed) e5.getCause());
            }
            throw new zzbed(e5);
        } catch (RuntimeException e6) {
            if (e6.getCause() instanceof zzbed) {
                throw ((zzbed) e6.getCause());
            }
            throw e6;
        }
    }
}
