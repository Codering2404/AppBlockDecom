package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.gtm.zzxp;
import com.google.android.gms.internal.gtm.zzxv;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzxv<MessageType extends zzxv<MessageType, BuilderType>, BuilderType extends zzxp<MessageType, BuilderType>> extends zztl<MessageType, BuilderType> {
    private static final Map zza = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzaal zzc = zzaal.zzc();

    public static zzxt zzaa(zzzg zzzgVar, zzzg zzzgVar2, zzxy zzxyVar, int i3, zzaba zzabaVar, boolean z2, Class cls) {
        return new zzxt(zzzgVar, Collections.EMPTY_LIST, zzzgVar2, new zzxs(null, i3, zzabaVar, true, false), cls);
    }

    public static zzxt zzab(zzzg zzzgVar, Object obj, zzzg zzzgVar2, zzxy zzxyVar, int i3, zzaba zzabaVar, Class cls) {
        return new zzxt(zzzgVar, obj, zzzgVar2, new zzxs(zzxyVar, i3, zzabaVar, false, false), cls);
    }

    static zzxv zzac(Class cls) {
        Map map = zza;
        zzxv zzxvVar = (zzxv) map.get(cls);
        if (zzxvVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzxvVar = (zzxv) map.get(cls);
            } catch (ClassNotFoundException e3) {
                throw new IllegalStateException("Class initialization cannot fail.", e3);
            }
        }
        if (zzxvVar != null) {
            return zzxvVar;
        }
        zzxv zzxvVar2 = (zzxv) ((zzxv) zzaau.zze(cls)).zzb(6, null, null);
        if (zzxvVar2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, zzxvVar2);
        return zzxvVar2;
    }

    protected static zzxv zzae(zzxv zzxvVar, InputStream inputStream, zzxf zzxfVar) throws zzyg {
        zzuh zzuhVar = new zzuh(inputStream, 4096, null);
        zzxv zzxvVarZzad = zzxvVar.zzad();
        try {
            zzzt zzztVarZzb = zzzp.zza().zzb(zzxvVarZzad.getClass());
            zzztVarZzb.zzh(zzxvVarZzad, zzuk.zzq(zzuhVar), zzxfVar);
            zzztVarZzb.zzf(zzxvVarZzad);
            zze(zzxvVarZzad);
            return zzxvVarZzad;
        } catch (zzaaj e3) {
            zzyg zzygVarZza = e3.zza();
            zzygVarZza.zzh(zzxvVarZzad);
            throw zzygVarZza;
        } catch (zzyg e4) {
            e = e4;
            if (e.zzl()) {
                e = new zzyg(e);
            }
            e.zzh(zzxvVarZzad);
            throw e;
        } catch (IOException e5) {
            if (e5.getCause() instanceof zzyg) {
                throw ((zzyg) e5.getCause());
            }
            zzyg zzygVar = new zzyg(e5);
            zzygVar.zzh(zzxvVarZzad);
            throw zzygVar;
        } catch (RuntimeException e6) {
            if (e6.getCause() instanceof zzyg) {
                throw ((zzyg) e6.getCause());
            }
            throw e6;
        }
    }

    protected static zzxv zzaf(zzxv zzxvVar, byte[] bArr, zzxf zzxfVar) throws zzyg {
        zzxv zzxvVarZzf = zzf(zzxvVar, bArr, 0, bArr.length, zzxfVar);
        zze(zzxvVarZzf);
        return zzxvVarZzf;
    }

    protected static zzya zzag() {
        return zzxw.zzf();
    }

    protected static zzyd zzah() {
        return zzzq.zze();
    }

    protected static zzyd zzai(zzyd zzydVar) {
        int size = zzydVar.size();
        return zzydVar.zzd(size == 0 ? 10 : size + size);
    }

    static Object zzaj(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e3);
        } catch (InvocationTargetException e4) {
            Throwable cause = e4.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static Object zzak(zzzg zzzgVar, String str, Object[] objArr) {
        return new zzzr(zzzgVar, str, objArr);
    }

    protected static void zzan(Class cls, zzxv zzxvVar) {
        zzxvVar.zzam();
        zza.put(cls, zzxvVar);
    }

    protected static final boolean zzap(zzxv zzxvVar, boolean z2) {
        byte bByteValue = ((Byte) zzxvVar.zzb(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzk = zzzp.zza().zzb(zzxvVar.getClass()).zzk(zzxvVar);
        if (z2) {
            zzxvVar.zzb(2, true != zZzk ? null : zzxvVar, null);
        }
        return zZzk;
    }

    private final int zzc(zzzt zzztVar) {
        return zzzp.zza().zzb(getClass()).zza(this);
    }

    private static zzxv zze(zzxv zzxvVar) throws zzyg {
        if (zzxvVar == null || zzxvVar.zzay()) {
            return zzxvVar;
        }
        zzyg zzygVarZza = new zzaaj(zzxvVar).zza();
        zzygVarZza.zzh(zzxvVar);
        throw zzygVarZza;
    }

    private static zzxv zzf(zzxv zzxvVar, byte[] bArr, int i3, int i4, zzxf zzxfVar) throws zzyg {
        zzxv zzxvVarZzad = zzxvVar.zzad();
        try {
            zzzt zzztVarZzb = zzzp.zza().zzb(zzxvVarZzad.getClass());
            zzztVarZzb.zzi(zzxvVarZzad, bArr, 0, i4, new zztp(zzxfVar));
            zzztVarZzb.zzf(zzxvVarZzad);
            return zzxvVarZzad;
        } catch (zzaaj e3) {
            zzyg zzygVarZza = e3.zza();
            zzygVarZza.zzh(zzxvVarZzad);
            throw zzygVarZza;
        } catch (zzyg e4) {
            zzyg zzygVar = e4;
            if (zzygVar.zzl()) {
                zzygVar = new zzyg(zzygVar);
            }
            zzygVar.zzh(zzxvVarZzad);
            throw zzygVar;
        } catch (IOException e5) {
            if (e5.getCause() instanceof zzyg) {
                throw ((zzyg) e5.getCause());
            }
            zzyg zzygVar2 = new zzyg(e5);
            zzygVar2.zzh(zzxvVarZzad);
            throw zzygVar2;
        } catch (IndexOutOfBoundsException unused) {
            zzyg zzygVarZzj = zzyg.zzj();
            zzygVarZzj.zzh(zzxvVarZzad);
            throw zzygVarZzj;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzzp.zza().zzb(getClass()).zzj(this, (zzxv) obj);
    }

    public final int hashCode() {
        if (zzaq()) {
            return zzW();
        }
        int i3 = this.zzb;
        if (i3 != 0) {
            return i3;
        }
        int iZzW = zzW();
        this.zzb = iZzW;
        return iZzW;
    }

    public final String toString() {
        return zzzi.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.gtm.zztl
    final int zzQ(zzzt zzztVar) {
        if (zzaq()) {
            int iZza = zzztVar.zza(this);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
        }
        int i3 = this.zzd & Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (i3 != Integer.MAX_VALUE) {
            return i3;
        }
        int iZza2 = zzztVar.zza(this);
        if (iZza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza2;
            return iZza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZza2);
    }

    final int zzW() {
        return zzzp.zza().zzb(getClass()).zzb(this);
    }

    @Override // com.google.android.gms.internal.gtm.zzzg
    public final int zzX() {
        if (zzaq()) {
            int iZzc = zzc(null);
            if (iZzc >= 0) {
                return iZzc;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZzc);
        }
        int i3 = this.zzd & Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (i3 != Integer.MAX_VALUE) {
            return i3;
        }
        int iZzc2 = zzc(null);
        if (iZzc2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iZzc2;
            return iZzc2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZzc2);
    }

    protected final zzxp zzY() {
        return (zzxp) zzb(5, null, null);
    }

    public final zzxp zzZ() {
        zzxp zzxpVar = (zzxp) zzb(5, null, null);
        zzxpVar.zzA(this);
        return zzxpVar;
    }

    final zzxv zzad() {
        return (zzxv) zzb(4, null, null);
    }

    protected final void zzal() {
        zzzp.zza().zzb(getClass()).zzf(this);
        zzam();
    }

    final void zzam() {
        this.zzd &= Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    final void zzao(int i3) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    final boolean zzaq() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    @Override // com.google.android.gms.internal.gtm.zzzg
    public final /* synthetic */ zzzf zzau() {
        return (zzxp) zzb(5, null, null);
    }

    @Override // com.google.android.gms.internal.gtm.zzzg
    public final /* synthetic */ zzzf zzav() {
        zzxp zzxpVar = (zzxp) zzb(5, null, null);
        zzxpVar.zzA(this);
        return zzxpVar;
    }

    @Override // com.google.android.gms.internal.gtm.zzzg
    public final void zzaw(zzuq zzuqVar) throws IOException {
        zzzp.zza().zzb(getClass()).zzm(this, zzur.zza(zzuqVar));
    }

    @Override // com.google.android.gms.internal.gtm.zzzh
    public final /* synthetic */ zzzg zzax() {
        return (zzxv) zzb(6, null, null);
    }

    @Override // com.google.android.gms.internal.gtm.zzzh
    public final boolean zzay() {
        return zzap(this, true);
    }

    protected abstract Object zzb(int i3, Object obj, Object obj2);
}
