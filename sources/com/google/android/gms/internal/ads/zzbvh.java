package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbvh extends zzbef implements zzbvi {
    public zzbvh() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public static zzbvi zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        return iInterfaceQueryLocalInterface instanceof zzbvi ? (zzbvi) iInterfaceQueryLocalInterface : new zzbvg(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        switch (i3) {
            case 1:
                zze();
                break;
            case 2:
                zzf();
                break;
            case 3:
                int i5 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzg(i5);
                break;
            case 4:
                zzh();
                break;
            case 5:
                zzi();
                break;
            case 6:
                zzj();
                break;
            case 7:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                }
                zzbeg.zzh(parcel);
                break;
            case 8:
                zzk();
                break;
            case 9:
                String string = parcel.readString();
                String string2 = parcel.readString();
                zzbeg.zzh(parcel);
                zzl(string, string2);
                break;
            case 10:
                zzbmu.zzb(parcel.readStrongBinder());
                parcel.readString();
                zzbeg.zzh(parcel);
                break;
            case 11:
                zzn();
                break;
            case 12:
                parcel.readString();
                zzbeg.zzh(parcel);
                break;
            case 13:
                zzo();
                break;
            case 14:
                zzccb zzccbVar = (zzccb) zzbeg.zzb(parcel, zzccb.CREATOR);
                zzbeg.zzh(parcel);
                zzp(zzccbVar);
                break;
            case 15:
                zzq();
                break;
            case 16:
                zzccf zzccfVarZzb = zzcce.zzb(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzr(zzccfVarZzb);
                break;
            case 17:
                int i6 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzs(i6);
                break;
            case 18:
                zzt();
                break;
            case 19:
                zzbeg.zzh(parcel);
                break;
            case 20:
                zzu();
                break;
            case 21:
                String string3 = parcel.readString();
                zzbeg.zzh(parcel);
                zzv(string3);
                break;
            case 22:
                int i7 = parcel.readInt();
                String string4 = parcel.readString();
                zzbeg.zzh(parcel);
                zzw(i7, string4);
                break;
            case 23:
                com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzbeg.zzb(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
                zzbeg.zzh(parcel);
                zzx(zzeVar);
                break;
            case 24:
                com.google.android.gms.ads.internal.client.zze zzeVar2 = (com.google.android.gms.ads.internal.client.zze) zzbeg.zzb(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
                zzbeg.zzh(parcel);
                zzy(zzeVar2);
                break;
            case 25:
                zzz();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
