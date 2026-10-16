package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbee;
import com.google.android.gms.internal.ads.zzbeg;
import com.google.android.gms.internal.ads.zzbmh;
import com.google.android.gms.internal.ads.zzbmi;
import com.google.android.gms.internal.ads.zzbqq;
import com.google.android.gms.internal.ads.zzbqs;
import com.google.android.gms.internal.ads.zzbqt;
import com.google.android.gms.internal.ads.zzbvc;
import com.google.android.gms.internal.ads.zzbyt;
import com.google.android.gms.internal.ads.zzbyu;
import com.google.android.gms.internal.ads.zzbza;
import com.google.android.gms.internal.ads.zzbzb;
import com.google.android.gms.internal.ads.zzcch;
import com.google.android.gms.internal.ads.zzcci;
import com.google.android.gms.internal.ads.zzcel;
import com.google.android.gms.internal.ads.zzcem;
import io.reactivex.internal.operators.mixed.yrog.FptyjHFU;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcm extends zzbee implements zzco {
    zzcm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzdt E(IObjectWrapper iObjectWrapper, zzbvc zzbvcVar, int i3) throws RemoteException {
        zzdt zzdrVar;
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zze(parcelZza, zzbvcVar);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZzcZ = zzcZ(17, parcelZza);
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzdrVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOutOfContextTester");
            zzdrVar = iInterfaceQueryLocalInterface instanceof zzdt ? (zzdt) iInterfaceQueryLocalInterface : new zzdr(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzdrVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzcci J4(IObjectWrapper iObjectWrapper, String str, zzbvc zzbvcVar, int i3) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        zzbeg.zze(parcelZza, zzbvcVar);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZzcZ = zzcZ(12, parcelZza);
        zzcci zzcciVarZzt = zzcch.zzt(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return zzcciVarZzt;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbqt L1(IObjectWrapper iObjectWrapper, zzbvc zzbvcVar, int i3, zzbqq zzbqqVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zze(parcelZza, zzbvcVar);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        zzbeg.zze(parcelZza, zzbqqVar);
        Parcel parcelZzcZ = zzcZ(16, parcelZza);
        zzbqt zzbqtVarZzb = zzbqs.zzb(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return zzbqtVarZzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbu M3(IObjectWrapper iObjectWrapper, zzr zzrVar, String str, zzbvc zzbvcVar, int i3) throws RemoteException {
        zzbu zzbsVar;
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zzc(parcelZza, zzrVar);
        parcelZza.writeString(str);
        zzbeg.zze(parcelZza, zzbvcVar);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZzcZ = zzcZ(2, parcelZza);
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzbsVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbsVar = iInterfaceQueryLocalInterface instanceof zzbu ? (zzbu) iInterfaceQueryLocalInterface : new zzbs(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzbsVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzcem P0(IObjectWrapper iObjectWrapper, zzbvc zzbvcVar, int i3) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zze(parcelZza, zzbvcVar);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZzcZ = zzcZ(14, parcelZza);
        zzcem zzcemVarZzb = zzcel.zzb(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return zzcemVarZzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzch Q2(IObjectWrapper iObjectWrapper, zzbvc zzbvcVar, int i3) throws RemoteException {
        zzch zzcfVar;
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zze(parcelZza, zzbvcVar);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZzcZ = zzcZ(18, parcelZza);
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzcfVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloader");
            zzcfVar = iInterfaceQueryLocalInterface instanceof zzch ? (zzch) iInterfaceQueryLocalInterface : new zzcf(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzcfVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbu V0(IObjectWrapper iObjectWrapper, zzr zzrVar, String str, zzbvc zzbvcVar, int i3) throws RemoteException {
        zzbu zzbsVar;
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zzc(parcelZza, zzrVar);
        parcelZza.writeString(str);
        zzbeg.zze(parcelZza, zzbvcVar);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZzcZ = zzcZ(13, parcelZza);
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzbsVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbsVar = iInterfaceQueryLocalInterface instanceof zzbu ? (zzbu) iInterfaceQueryLocalInterface : new zzbs(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzbsVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbq c0(IObjectWrapper iObjectWrapper, String str, zzbvc zzbvcVar, int i3) throws RemoteException {
        zzbq zzboVar;
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        zzbeg.zze(parcelZza, zzbvcVar);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZzcZ = zzcZ(3, parcelZza);
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzboVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            zzboVar = iInterfaceQueryLocalInterface instanceof zzbq ? (zzbq) iInterfaceQueryLocalInterface : new zzbo(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzboVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbu i4(IObjectWrapper iObjectWrapper, zzr zzrVar, String str, zzbvc zzbvcVar, int i3) throws RemoteException {
        zzbu zzbsVar;
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zzc(parcelZza, zzrVar);
        parcelZza.writeString(str);
        zzbeg.zze(parcelZza, zzbvcVar);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZzcZ = zzcZ(1, parcelZza);
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzbsVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbsVar = iInterfaceQueryLocalInterface instanceof zzbu ? (zzbu) iInterfaceQueryLocalInterface : new zzbs(strongBinder);
        }
        parcelZzcZ.recycle();
        return zzbsVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbmi o2(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zze(parcelZza, iObjectWrapper2);
        Parcel parcelZzcZ = zzcZ(5, parcelZza);
        zzbmi zzbmiVarZzdG = zzbmh.zzdG(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return zzbmiVarZzdG;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbyu q0(IObjectWrapper iObjectWrapper, zzbvc zzbvcVar, int i3) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zze(parcelZza, zzbvcVar);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZzcZ = zzcZ(15, parcelZza);
        zzbyu zzbyuVarZzb = zzbyt.zzb(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return zzbyuVarZzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzbzb zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        Parcel parcelZzcZ = zzcZ(8, parcelZza);
        zzbzb zzbzbVarZzI = zzbza.zzI(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return zzbzbVarZzI;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final zzcy U1(IObjectWrapper iObjectWrapper, int i3) throws RemoteException {
        zzcy zzcwVar;
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZzcZ = zzcZ(9, parcelZza);
        IBinder strongBinder = parcelZzcZ.readStrongBinder();
        if (strongBinder == null) {
            zzcwVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(FptyjHFU.XcNLFx);
            if (iInterfaceQueryLocalInterface instanceof zzcy) {
                zzcwVar = (zzcy) iInterfaceQueryLocalInterface;
            } else {
                zzcwVar = new zzcw(strongBinder);
            }
        }
        parcelZzcZ.recycle();
        return zzcwVar;
    }
}
