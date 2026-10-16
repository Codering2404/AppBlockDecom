package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbzp extends zzbzn {
    private zzbzp() {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzbzn
    public final boolean a(zzbzq zzbzqVar, int i3, int i4) {
        synchronized (zzbzqVar) {
            try {
                if (zzbzqVar.a() != 0) {
                    return false;
                }
                zzbzqVar.b(-1);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbzn
    public final void b(zzbzq zzbzqVar, int i3) {
        synchronized (zzbzqVar) {
            zzbzqVar.b(0);
        }
    }

    /* synthetic */ zzbzp(byte[] bArr) {
        super(null);
    }
}
