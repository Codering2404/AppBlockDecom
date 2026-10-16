package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzc;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface IFragmentWrapper extends IInterface {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Stub extends com.google.android.gms.internal.common.zzb implements IFragmentWrapper {
        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        @Override // com.google.android.gms.internal.common.zzb
        protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
            switch (i3) {
                case 2:
                    IObjectWrapper iObjectWrapperZzb = zzb();
                    parcel2.writeNoException();
                    zzc.zze(parcel2, iObjectWrapperZzb);
                    return true;
                case 3:
                    Bundle bundleZzc = zzc();
                    parcel2.writeNoException();
                    zzc.zzd(parcel2, bundleZzc);
                    return true;
                case 4:
                    int iZzd = zzd();
                    parcel2.writeNoException();
                    parcel2.writeInt(iZzd);
                    return true;
                case 5:
                    IFragmentWrapper iFragmentWrapperZze = zze();
                    parcel2.writeNoException();
                    zzc.zze(parcel2, iFragmentWrapperZze);
                    return true;
                case 6:
                    IObjectWrapper iObjectWrapperZzf = zzf();
                    parcel2.writeNoException();
                    zzc.zze(parcel2, iObjectWrapperZzf);
                    return true;
                case 7:
                    boolean zZzg = zzg();
                    parcel2.writeNoException();
                    int i5 = zzc.zza;
                    parcel2.writeInt(zZzg ? 1 : 0);
                    return true;
                case 8:
                    String strZzh = zzh();
                    parcel2.writeNoException();
                    parcel2.writeString(strZzh);
                    return true;
                case 9:
                    IFragmentWrapper iFragmentWrapperZzi = zzi();
                    parcel2.writeNoException();
                    zzc.zze(parcel2, iFragmentWrapperZzi);
                    return true;
                case 10:
                    int iZzj = zzj();
                    parcel2.writeNoException();
                    parcel2.writeInt(iZzj);
                    return true;
                case 11:
                    boolean zZzk = zzk();
                    parcel2.writeNoException();
                    int i6 = zzc.zza;
                    parcel2.writeInt(zZzk ? 1 : 0);
                    return true;
                case 12:
                    IObjectWrapper iObjectWrapperZzl = zzl();
                    parcel2.writeNoException();
                    zzc.zze(parcel2, iObjectWrapperZzl);
                    return true;
                case 13:
                    boolean zZzm = zzm();
                    parcel2.writeNoException();
                    int i7 = zzc.zza;
                    parcel2.writeInt(zZzm ? 1 : 0);
                    return true;
                case 14:
                    boolean zZzn = zzn();
                    parcel2.writeNoException();
                    int i8 = zzc.zza;
                    parcel2.writeInt(zZzn ? 1 : 0);
                    return true;
                case 15:
                    boolean zZzo = zzo();
                    parcel2.writeNoException();
                    int i9 = zzc.zza;
                    parcel2.writeInt(zZzo ? 1 : 0);
                    return true;
                case 16:
                    boolean zZzp = zzp();
                    parcel2.writeNoException();
                    int i10 = zzc.zza;
                    parcel2.writeInt(zZzp ? 1 : 0);
                    return true;
                case 17:
                    boolean zZzq = zzq();
                    parcel2.writeNoException();
                    int i11 = zzc.zza;
                    parcel2.writeInt(zZzq ? 1 : 0);
                    return true;
                case 18:
                    boolean zZzr = zzr();
                    parcel2.writeNoException();
                    int i12 = zzc.zza;
                    parcel2.writeInt(zZzr ? 1 : 0);
                    return true;
                case 19:
                    boolean zZzs = zzs();
                    parcel2.writeNoException();
                    int i13 = zzc.zza;
                    parcel2.writeInt(zZzs ? 1 : 0);
                    return true;
                case 20:
                    IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                    zzc.zzf(parcel);
                    zzt(iObjectWrapperX3);
                    parcel2.writeNoException();
                    return true;
                case 21:
                    boolean zZza = zzc.zza(parcel);
                    zzc.zzf(parcel);
                    zzu(zZza);
                    parcel2.writeNoException();
                    return true;
                case 22:
                    boolean zZza2 = zzc.zza(parcel);
                    zzc.zzf(parcel);
                    e0(zZza2);
                    parcel2.writeNoException();
                    return true;
                case 23:
                    boolean zZza3 = zzc.zza(parcel);
                    zzc.zzf(parcel);
                    zzw(zZza3);
                    parcel2.writeNoException();
                    return true;
                case 24:
                    boolean zZza4 = zzc.zza(parcel);
                    zzc.zzf(parcel);
                    zzx(zZza4);
                    parcel2.writeNoException();
                    return true;
                case 25:
                    Intent intent = (Intent) zzc.zzb(parcel, Intent.CREATOR);
                    zzc.zzf(parcel);
                    s4(intent);
                    parcel2.writeNoException();
                    return true;
                case 26:
                    Intent intent2 = (Intent) zzc.zzb(parcel, Intent.CREATOR);
                    int i14 = parcel.readInt();
                    zzc.zzf(parcel);
                    I0(intent2, i14);
                    parcel2.writeNoException();
                    return true;
                case 27:
                    IObjectWrapper iObjectWrapperX32 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                    zzc.zzf(parcel);
                    X1(iObjectWrapperX32);
                    parcel2.writeNoException();
                    return true;
                default:
                    return false;
            }
        }
    }

    void I0(Intent intent, int i3);

    void X1(IObjectWrapper iObjectWrapper);

    void e0(boolean z2);

    void s4(Intent intent);

    IObjectWrapper zzb();

    Bundle zzc();

    int zzd();

    IFragmentWrapper zze();

    IObjectWrapper zzf();

    boolean zzg();

    String zzh();

    IFragmentWrapper zzi();

    int zzj();

    boolean zzk();

    IObjectWrapper zzl();

    boolean zzm();

    boolean zzn();

    boolean zzo();

    boolean zzp();

    boolean zzq();

    boolean zzr();

    boolean zzs();

    void zzt(IObjectWrapper iObjectWrapper);

    void zzu(boolean z2);

    void zzw(boolean z2);

    void zzx(boolean z2);
}
