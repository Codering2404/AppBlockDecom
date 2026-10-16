package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.libraries.places.internal.zzbdk;
import com.google.android.libraries.places.internal.zzbdq;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzbdq<MessageType extends zzbdq<MessageType, BuilderType>, BuilderType extends zzbdk<MessageType, BuilderType>> extends zzbby<MessageType, BuilderType> {
    public static final /* synthetic */ int zzd = 0;
    private static final Map zze = new ConcurrentHashMap();
    private int zzb = -1;
    protected zzbfz zzc = zzbfz.a();

    static zzbdq C(Class cls) {
        Map map = zze;
        zzbdq zzbdqVar = (zzbdq) map.get(cls);
        if (zzbdqVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzbdqVar = (zzbdq) map.get(cls);
            } catch (ClassNotFoundException e3) {
                throw new IllegalStateException("Class initialization cannot fail.", e3);
            }
        }
        if (zzbdqVar != null) {
            return zzbdqVar;
        }
        zzbdq zzbdqVar2 = (zzbdq) ((zzbdq) zzbgf.h(cls)).l(6, null, null);
        if (zzbdqVar2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, zzbdqVar2);
        return zzbdqVar2;
    }

    protected static void D(Class cls, zzbdq zzbdqVar) {
        zzbdqVar.w();
        zze.put(cls, zzbdqVar);
    }

    private final int E(zzbfl zzbflVar) {
        return zzbfh.a().b(getClass()).zze(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean F(zzbdq zzbdqVar, boolean z2) {
        byte bByteValue = ((Byte) zzbdqVar.l(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzi = zzbfh.a().b(zzbdqVar.getClass()).zzi(zzbdqVar);
        if (z2) {
            zzbdqVar.l(2, true != zZzi ? null : zzbdqVar, null);
        }
        return zZzi;
    }

    protected static Object m(zzbex zzbexVar, String str, Object[] objArr) {
        return new zzbfj(zzbexVar, str, objArr);
    }

    public static zzbdp n(zzbex zzbexVar, Object obj, zzbex zzbexVar2, zzbdv zzbdvVar, int i3, zzbgj zzbgjVar, Class cls) {
        return new zzbdp(zzbexVar, obj, zzbexVar2, new zzbdo(null, 525004180, zzbgjVar, false, false), cls);
    }

    static Object o(Method method, Object obj, Object... objArr) {
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

    protected static zzbdy p() {
        return zzbdr.b();
    }

    protected static zzbdy q(zzbdy zzbdyVar) {
        int size = zzbdyVar.size();
        return zzbdyVar.zzg(size + size);
    }

    protected static zzbdz r() {
        return zzbem.b();
    }

    protected static zzbea s() {
        return zzbfi.b();
    }

    protected static zzbea t(zzbea zzbeaVar) {
        int size = zzbeaVar.size();
        return zzbeaVar.zzg(size + size);
    }

    protected final zzbdk A() {
        return (zzbdk) l(5, null, null);
    }

    final void B(int i3) {
        this.zzb = (this.zzb & Integer.MIN_VALUE) | Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    @Override // com.google.android.libraries.places.internal.zzbey
    public final boolean c() {
        return F(this, true);
    }

    @Override // com.google.android.libraries.places.internal.zzbby
    final int d(zzbfl zzbflVar) {
        if (v()) {
            int iZze = zzbflVar.zze(this);
            if (iZze >= 0) {
                return iZze;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(iZze).length() + 42);
            sb.append("serialized size must be non-negative, was ");
            sb.append(iZze);
            throw new IllegalStateException(sb.toString());
        }
        int i3 = this.zzb & Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (i3 != Integer.MAX_VALUE) {
            return i3;
        }
        int iZze2 = zzbflVar.zze(this);
        if (iZze2 >= 0) {
            this.zzb = (this.zzb & Integer.MIN_VALUE) | iZze2;
            return iZze2;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(iZze2).length() + 42);
        sb2.append("serialized size must be non-negative, was ");
        sb2.append(iZze2);
        throw new IllegalStateException(sb2.toString());
    }

    @Override // com.google.android.libraries.places.internal.zzbey
    public final /* synthetic */ zzbex e() {
        return (zzbdq) l(6, null, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzbfh.a().b(getClass()).zzb(this, (zzbdq) obj);
    }

    @Override // com.google.android.libraries.places.internal.zzbex
    public final /* synthetic */ zzbew g() {
        return (zzbdk) l(5, null, null);
    }

    @Override // com.google.android.libraries.places.internal.zzbex
    public final /* synthetic */ zzbew h() {
        zzbdk zzbdkVar = (zzbdk) l(5, null, null);
        zzbdkVar.u(this);
        return zzbdkVar;
    }

    public final int hashCode() {
        if (v()) {
            return y();
        }
        int i3 = this.zza;
        if (i3 != 0) {
            return i3;
        }
        int iY = y();
        this.zza = iY;
        return iY;
    }

    @Override // com.google.android.libraries.places.internal.zzbex
    public final int j() {
        if (v()) {
            int iE = E(null);
            if (iE >= 0) {
                return iE;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(iE).length() + 42);
            sb.append("serialized size must be non-negative, was ");
            sb.append(iE);
            throw new IllegalStateException(sb.toString());
        }
        int i3 = this.zzb & Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (i3 != Integer.MAX_VALUE) {
            return i3;
        }
        int iE2 = E(null);
        if (iE2 >= 0) {
            this.zzb = (this.zzb & Integer.MIN_VALUE) | iE2;
            return iE2;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(iE2).length() + 42);
        sb2.append("serialized size must be non-negative, was ");
        sb2.append(iE2);
        throw new IllegalStateException(sb2.toString());
    }

    @Override // com.google.android.libraries.places.internal.zzbex
    public final void k(zzbcu zzbcuVar) {
        zzbfh.a().b(getClass()).a(this, zzbcv.d(zzbcuVar));
    }

    protected abstract Object l(int i3, Object obj, Object obj2);

    public final String toString() {
        return zzbez.a(this, super.toString());
    }

    final boolean v() {
        return (this.zzb & Integer.MIN_VALUE) != 0;
    }

    final void w() {
        this.zzb &= Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    final zzbdq x() {
        return (zzbdq) l(4, null, null);
    }

    final int y() {
        return zzbfh.a().b(getClass()).zzc(this);
    }

    protected final void z() {
        zzbfh.a().b(getClass()).zzh(this);
        w();
    }

    @Override // com.google.android.libraries.places.internal.zzbex
    public final zzbff zzbr() {
        return (zzbff) l(7, null, null);
    }
}
