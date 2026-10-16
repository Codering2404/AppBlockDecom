package com.google.android.gms.internal.auth;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhs extends zzev implements zzfy {
    private static final zzhs zzb;
    private zzez zzd = zzev.zzf();

    static {
        zzhs zzhsVar = new zzhs();
        zzb = zzhsVar;
        zzev.zzk(zzhs.class, zzhsVar);
    }

    private zzhs() {
    }

    public static zzhs zzp(byte[] bArr) throws zzfb {
        return (zzhs) zzev.zzd(zzb, bArr);
    }

    @Override // com.google.android.gms.internal.auth.zzev
    protected final Object zzn(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzev.zzh(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzd"});
        }
        if (i4 == 3) {
            return new zzhs();
        }
        zzhq zzhqVar = null;
        if (i4 == 4) {
            return new zzhr(zzhqVar);
        }
        if (i4 != 5) {
            return null;
        }
        return zzb;
    }

    public final List zzq() {
        return this.zzd;
    }
}
