package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzibg {
    @Deprecated
    public zzibg() {
    }

    public final String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            zzicf zzicfVar = new zzicf(zzica.zza(sb));
            zzicfVar.zza(zzibl.LENIENT);
            zzicb.zza.zza(zzicfVar, this);
            return sb.toString();
        } catch (IOException e3) {
            throw new AssertionError(e3);
        }
    }

    public String zzd() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final zzibi zze() {
        if (this instanceof zzibi) {
            return (zzibi) this;
        }
        throw new IllegalStateException("Not a JSON Object: ".concat(toString()));
    }

    public final zzibf zzf() {
        if (this instanceof zzibf) {
            return (zzibf) this;
        }
        throw new IllegalStateException("Not a JSON Array: ".concat(toString()));
    }

    public final zzibk zzg() {
        if (this instanceof zzibk) {
            return (zzibk) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: ".concat(toString()));
    }
}
