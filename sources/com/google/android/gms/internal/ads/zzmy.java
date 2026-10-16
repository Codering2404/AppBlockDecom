package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmy extends zziw {
    public static final /* synthetic */ int zzb = 0;
    private final int zzc;
    private final int zzd;
    private final int[] zze;
    private final int[] zzf;
    private final zzbf[] zzg;
    private final Object[] zzh;
    private final HashMap zzi;

    /* JADX WARN: Illegal instructions before constructor call */
    public zzmy(Collection collection, zzzf zzzfVar) {
        zzbf[] zzbfVarArr = new zzbf[collection.size()];
        Iterator it = collection.iterator();
        int i3 = 0;
        int i4 = 0;
        while (it.hasNext()) {
            zzbfVarArr[i4] = ((zzmg) it.next()).zzb();
            i4++;
        }
        Object[] objArr = new Object[collection.size()];
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            objArr[i3] = ((zzmg) it2.next()).zza();
            i3++;
        }
        this(zzbfVarArr, objArr, zzzfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zziw
    protected final int zzp(int i3) {
        return zzfl.zzn(this.zze, i3 + 1, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zziw
    protected final int zzq(int i3) {
        return zzfl.zzn(this.zzf, i3 + 1, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zziw
    protected final int zzr(Object obj) {
        Integer num = (Integer) this.zzi.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.google.android.gms.internal.ads.zziw
    protected final zzbf zzs(int i3) {
        return this.zzg[i3];
    }

    @Override // com.google.android.gms.internal.ads.zziw
    protected final int zzt(int i3) {
        return this.zze[i3];
    }

    @Override // com.google.android.gms.internal.ads.zziw
    protected final int zzu(int i3) {
        return this.zzf[i3];
    }

    @Override // com.google.android.gms.internal.ads.zziw
    protected final Object zzv(int i3) {
        return this.zzh[i3];
    }

    final List zzw() {
        return Arrays.asList(this.zzg);
    }

    public final zzmy zzx(zzzf zzzfVar) {
        zzbf[] zzbfVarArr = this.zzg;
        zzbf[] zzbfVarArr2 = new zzbf[zzbfVarArr.length];
        for (int i3 = 0; i3 < zzbfVarArr.length; i3++) {
            zzbfVarArr2[i3] = new zzmx(this, zzbfVarArr[i3]);
        }
        return new zzmy(zzbfVarArr2, this.zzh, zzzfVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzmy(zzbf[] zzbfVarArr, Object[] objArr, zzzf zzzfVar) {
        super(false, zzzfVar);
        int i3 = 0;
        this.zzg = zzbfVarArr;
        int length = zzbfVarArr.length;
        this.zze = new int[length];
        this.zzf = new int[length];
        this.zzh = objArr;
        this.zzi = new HashMap();
        int iZza = 0;
        int iZzc = 0;
        int i4 = 0;
        while (i3 < zzbfVarArr.length) {
            zzbf zzbfVar = zzbfVarArr[i3];
            this.zzg[i4] = zzbfVar;
            this.zzf[i4] = iZza;
            this.zze[i4] = iZzc;
            iZza += zzbfVar.zza();
            iZzc += this.zzg[i4].zzc();
            this.zzi.put(objArr[i4], Integer.valueOf(i4));
            i3++;
            i4++;
        }
        this.zzc = iZza;
        this.zzd = iZzc;
    }
}
