package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbxa extends zzbef implements zzbxb {
    public zzbxa() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzbxb zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        return iInterfaceQueryLocalInterface instanceof zzbxb ? (zzbxb) iInterfaceQueryLocalInterface : new zzbwz(iBinder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.google.android.gms.internal.ads.zzbxa, com.google.android.gms.internal.ads.zzbxb] */
    /* JADX WARN: Type inference failed for: r5v11, types: [com.google.android.gms.internal.ads.zzbwy] */
    /* JADX WARN: Type inference failed for: r5v15, types: [com.google.android.gms.internal.ads.zzbwv] */
    /* JADX WARN: Type inference failed for: r5v19, types: [com.google.android.gms.internal.ads.zzbwy] */
    /* JADX WARN: Type inference failed for: r5v21, types: [com.google.android.gms.internal.ads.zzbwp] */
    /* JADX WARN: Type inference failed for: r5v24, types: [com.google.android.gms.internal.ads.zzbwv] */
    /* JADX WARN: Type inference failed for: r5v28, types: [com.google.android.gms.internal.ads.zzbwm] */
    /* JADX WARN: Type inference failed for: r5v5, types: [com.google.android.gms.internal.ads.zzbwp] */
    /* JADX WARN: Type inference failed for: r5v9, types: [com.google.android.gms.internal.ads.zzbws] */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.google.android.gms.internal.ads.zzbxe] */
    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        IInterface zzbwkVar = null;
        if (i3 == 1) {
            IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
            String string = parcel.readString();
            Parcelable.Creator creator = Bundle.CREATOR;
            Bundle bundle = (Bundle) zzbeg.zzb(parcel, creator);
            Bundle bundle2 = (Bundle) zzbeg.zzb(parcel, creator);
            com.google.android.gms.ads.internal.client.zzr zzrVar = (com.google.android.gms.ads.internal.client.zzr) zzbeg.zzb(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
                zzbwkVar = iInterfaceQueryLocalInterface instanceof zzbxe ? (zzbxe) iInterfaceQueryLocalInterface : new zzbxc(strongBinder);
            }
            zzbeg.zzh(parcel);
            zze(iObjectWrapperX3, string, bundle, bundle2, zzrVar, zzbwkVar);
            parcel2.writeNoException();
        } else if (i3 == 2) {
            zzbxq zzbxqVarZzf = zzf();
            parcel2.writeNoException();
            zzbeg.zzd(parcel2, zzbxqVarZzf);
        } else if (i3 == 3) {
            zzbxq zzbxqVarZzg = zzg();
            parcel2.writeNoException();
            zzbeg.zzd(parcel2, zzbxqVarZzg);
        } else if (i3 == 5) {
            com.google.android.gms.ads.internal.client.zzea zzeaVarZzh = zzh();
            parcel2.writeNoException();
            zzbeg.zze(parcel2, zzeaVarZzh);
        } else if (i3 == 10) {
            IObjectWrapper.Stub.x3(parcel.readStrongBinder());
            zzbeg.zzh(parcel);
            parcel2.writeNoException();
        } else if (i3 != 11) {
            switch (i3) {
                case 13:
                    String string2 = parcel.readString();
                    String string3 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar = (com.google.android.gms.ads.internal.client.zzm) zzbeg.zzb(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperX32 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                    IBinder strongBinder2 = parcel.readStrongBinder();
                    if (strongBinder2 != null) {
                        IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                        zzbwkVar = iInterfaceQueryLocalInterface2 instanceof zzbwp ? (zzbwp) iInterfaceQueryLocalInterface2 : new zzbwn(strongBinder2);
                    }
                    ?? r5 = zzbwkVar;
                    zzbvi zzbviVarZzb = zzbvh.zzb(parcel.readStrongBinder());
                    com.google.android.gms.ads.internal.client.zzr zzrVar2 = (com.google.android.gms.ads.internal.client.zzr) zzbeg.zzb(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                    zzbeg.zzh(parcel);
                    zzi(string2, string3, zzmVar, iObjectWrapperX32, r5, zzbviVarZzb, zzrVar2);
                    parcel2.writeNoException();
                    break;
                case 14:
                    String string4 = parcel.readString();
                    String string5 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar2 = (com.google.android.gms.ads.internal.client.zzm) zzbeg.zzb(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperX33 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                    IBinder strongBinder3 = parcel.readStrongBinder();
                    if (strongBinder3 != null) {
                        IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
                        zzbwkVar = iInterfaceQueryLocalInterface3 instanceof zzbws ? (zzbws) iInterfaceQueryLocalInterface3 : new zzbwq(strongBinder3);
                    }
                    zzbvi zzbviVarZzb2 = zzbvh.zzb(parcel.readStrongBinder());
                    zzbeg.zzh(parcel);
                    zzj(string4, string5, zzmVar2, iObjectWrapperX33, zzbwkVar, zzbviVarZzb2);
                    parcel2.writeNoException();
                    break;
                case 15:
                    IObjectWrapper iObjectWrapperX34 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                    zzbeg.zzh(parcel);
                    boolean zZzk = zzk(iObjectWrapperX34);
                    parcel2.writeNoException();
                    parcel2.writeInt(zZzk ? 1 : 0);
                    break;
                case 16:
                    String string6 = parcel.readString();
                    String string7 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar3 = (com.google.android.gms.ads.internal.client.zzm) zzbeg.zzb(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperX35 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                    IBinder strongBinder4 = parcel.readStrongBinder();
                    if (strongBinder4 != null) {
                        IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        zzbwkVar = iInterfaceQueryLocalInterface4 instanceof zzbwy ? (zzbwy) iInterfaceQueryLocalInterface4 : new zzbww(strongBinder4);
                    }
                    zzbvi zzbviVarZzb3 = zzbvh.zzb(parcel.readStrongBinder());
                    zzbeg.zzh(parcel);
                    zzl(string6, string7, zzmVar3, iObjectWrapperX35, zzbwkVar, zzbviVarZzb3);
                    parcel2.writeNoException();
                    break;
                case 17:
                    IObjectWrapper iObjectWrapperX36 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                    zzbeg.zzh(parcel);
                    boolean zZzm = zzm(iObjectWrapperX36);
                    parcel2.writeNoException();
                    parcel2.writeInt(zZzm ? 1 : 0);
                    break;
                case 18:
                    String string8 = parcel.readString();
                    String string9 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar4 = (com.google.android.gms.ads.internal.client.zzm) zzbeg.zzb(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperX37 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                    IBinder strongBinder5 = parcel.readStrongBinder();
                    if (strongBinder5 != null) {
                        IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                        zzbwkVar = iInterfaceQueryLocalInterface5 instanceof zzbwv ? (zzbwv) iInterfaceQueryLocalInterface5 : new zzbwt(strongBinder5);
                    }
                    zzbvi zzbviVarZzb4 = zzbvh.zzb(parcel.readStrongBinder());
                    zzbeg.zzh(parcel);
                    zzn(string8, string9, zzmVar4, iObjectWrapperX37, zzbwkVar, zzbviVarZzb4);
                    parcel2.writeNoException();
                    break;
                case 19:
                    String string10 = parcel.readString();
                    zzbeg.zzh(parcel);
                    zzo(string10);
                    parcel2.writeNoException();
                    break;
                case 20:
                    String string11 = parcel.readString();
                    String string12 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar5 = (com.google.android.gms.ads.internal.client.zzm) zzbeg.zzb(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperX38 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                    IBinder strongBinder6 = parcel.readStrongBinder();
                    if (strongBinder6 != null) {
                        IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        zzbwkVar = iInterfaceQueryLocalInterface6 instanceof zzbwy ? (zzbwy) iInterfaceQueryLocalInterface6 : new zzbww(strongBinder6);
                    }
                    zzbvi zzbviVarZzb5 = zzbvh.zzb(parcel.readStrongBinder());
                    zzbeg.zzh(parcel);
                    zzp(string11, string12, zzmVar5, iObjectWrapperX38, zzbwkVar, zzbviVarZzb5);
                    parcel2.writeNoException();
                    break;
                case 21:
                    String string13 = parcel.readString();
                    String string14 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar6 = (com.google.android.gms.ads.internal.client.zzm) zzbeg.zzb(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperX39 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                    IBinder strongBinder7 = parcel.readStrongBinder();
                    if (strongBinder7 != null) {
                        IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                        zzbwkVar = iInterfaceQueryLocalInterface7 instanceof zzbwp ? (zzbwp) iInterfaceQueryLocalInterface7 : new zzbwn(strongBinder7);
                    }
                    ?? r52 = zzbwkVar;
                    zzbvi zzbviVarZzb6 = zzbvh.zzb(parcel.readStrongBinder());
                    com.google.android.gms.ads.internal.client.zzr zzrVar3 = (com.google.android.gms.ads.internal.client.zzr) zzbeg.zzb(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                    zzbeg.zzh(parcel);
                    zzq(string13, string14, zzmVar6, iObjectWrapperX39, r52, zzbviVarZzb6, zzrVar3);
                    parcel2.writeNoException();
                    break;
                case 22:
                    String string15 = parcel.readString();
                    String string16 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar7 = (com.google.android.gms.ads.internal.client.zzm) zzbeg.zzb(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperX310 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                    IBinder strongBinder8 = parcel.readStrongBinder();
                    if (strongBinder8 != null) {
                        IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                        zzbwkVar = iInterfaceQueryLocalInterface8 instanceof zzbwv ? (zzbwv) iInterfaceQueryLocalInterface8 : new zzbwt(strongBinder8);
                    }
                    zzbvi zzbviVarZzb7 = zzbvh.zzb(parcel.readStrongBinder());
                    zzblt zzbltVar = (zzblt) zzbeg.zzb(parcel, zzblt.CREATOR);
                    zzbeg.zzh(parcel);
                    zzr(string15, string16, zzmVar7, iObjectWrapperX310, zzbwkVar, zzbviVarZzb7, zzbltVar);
                    parcel2.writeNoException();
                    break;
                case 23:
                    String string17 = parcel.readString();
                    String string18 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar8 = (com.google.android.gms.ads.internal.client.zzm) zzbeg.zzb(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperX311 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                    IBinder strongBinder9 = parcel.readStrongBinder();
                    if (strongBinder9 != null) {
                        IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IAppOpenCallback");
                        zzbwkVar = iInterfaceQueryLocalInterface9 instanceof zzbwm ? (zzbwm) iInterfaceQueryLocalInterface9 : new zzbwk(strongBinder9);
                    }
                    zzbvi zzbviVarZzb8 = zzbvh.zzb(parcel.readStrongBinder());
                    zzbeg.zzh(parcel);
                    zzs(string17, string18, zzmVar8, iObjectWrapperX311, zzbwkVar, zzbviVarZzb8);
                    parcel2.writeNoException();
                    break;
                case 24:
                    IObjectWrapper iObjectWrapperX312 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                    zzbeg.zzh(parcel);
                    boolean zZzt = zzt(iObjectWrapperX312);
                    parcel2.writeNoException();
                    parcel2.writeInt(zZzt ? 1 : 0);
                    break;
                default:
                    return false;
            }
        } else {
            parcel.createStringArray();
            zzbeg.zzh(parcel);
            parcel2.writeNoException();
        }
        return true;
    }
}
