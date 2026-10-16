package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbef;
import com.google.android.gms.internal.ads.zzbeg;
import com.google.android.gms.internal.ads.zzbmi;
import com.google.android.gms.internal.ads.zzbmn;
import com.google.android.gms.internal.ads.zzbqp;
import com.google.android.gms.internal.ads.zzbqq;
import com.google.android.gms.internal.ads.zzbqt;
import com.google.android.gms.internal.ads.zzbvb;
import com.google.android.gms.internal.ads.zzbvc;
import com.google.android.gms.internal.ads.zzbyu;
import com.google.android.gms.internal.ads.zzbzb;
import com.google.android.gms.internal.ads.zzcbs;
import com.google.android.gms.internal.ads.zzcci;
import com.google.android.gms.internal.ads.zzcem;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzcn extends zzbef implements zzco {
    public zzcn() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    protected final boolean zzdd(int i3, Parcel parcel, Parcel parcel2, int i4) {
        switch (i3) {
            case 1:
                IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzr zzrVar = (zzr) zzbeg.zzb(parcel, zzr.CREATOR);
                String string = parcel.readString();
                zzbvc zzbvcVarZzf = zzbvb.zzf(parcel.readStrongBinder());
                int i5 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzbu zzbuVarI4 = i4(iObjectWrapperX3, zzrVar, string, zzbvcVarZzf, i5);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbuVarI4);
                return true;
            case 2:
                IObjectWrapper iObjectWrapperX32 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzr zzrVar2 = (zzr) zzbeg.zzb(parcel, zzr.CREATOR);
                String string2 = parcel.readString();
                zzbvc zzbvcVarZzf2 = zzbvb.zzf(parcel.readStrongBinder());
                int i6 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzbu zzbuVarM3 = M3(iObjectWrapperX32, zzrVar2, string2, zzbvcVarZzf2, i6);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbuVarM3);
                return true;
            case 3:
                IObjectWrapper iObjectWrapperX33 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                String string3 = parcel.readString();
                zzbvc zzbvcVarZzf3 = zzbvb.zzf(parcel.readStrongBinder());
                int i7 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzbq zzbqVarC0 = c0(iObjectWrapperX33, string3, zzbvcVarZzf3, i7);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbqVarC0);
                return true;
            case 4:
                IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, null);
                return true;
            case 5:
                IObjectWrapper iObjectWrapperX34 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperX35 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzbmi zzbmiVarO2 = o2(iObjectWrapperX34, iObjectWrapperX35);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbmiVarO2);
                return true;
            case 6:
                IObjectWrapper iObjectWrapperX36 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbvc zzbvcVarZzf4 = zzbvb.zzf(parcel.readStrongBinder());
                int i8 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzcbs zzcbsVarC3 = C3(iObjectWrapperX36, zzbvcVarZzf4, i8);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzcbsVarC3);
                return true;
            case 7:
                IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, null);
                return true;
            case 8:
                IObjectWrapper iObjectWrapperX37 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzbzb zzbzbVarZzg = zzg(iObjectWrapperX37);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbzbVarZzg);
                return true;
            case 9:
                IObjectWrapper iObjectWrapperX38 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                int i9 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzcy zzcyVarU1 = U1(iObjectWrapperX38, i9);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzcyVarU1);
                return true;
            case 10:
                IObjectWrapper iObjectWrapperX39 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzr zzrVar3 = (zzr) zzbeg.zzb(parcel, zzr.CREATOR);
                String string4 = parcel.readString();
                int i10 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzbu zzbuVarO1 = O1(iObjectWrapperX39, zzrVar3, string4, i10);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbuVarO1);
                return true;
            case 11:
                IObjectWrapper iObjectWrapperX310 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperX311 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperX312 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzbmn zzbmnVarH4 = h4(iObjectWrapperX310, iObjectWrapperX311, iObjectWrapperX312);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbmnVarH4);
                return true;
            case 12:
                IObjectWrapper iObjectWrapperX313 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                String string5 = parcel.readString();
                zzbvc zzbvcVarZzf5 = zzbvb.zzf(parcel.readStrongBinder());
                int i11 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzcci zzcciVarJ4 = J4(iObjectWrapperX313, string5, zzbvcVarZzf5, i11);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzcciVarJ4);
                return true;
            case 13:
                IObjectWrapper iObjectWrapperX314 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzr zzrVar4 = (zzr) zzbeg.zzb(parcel, zzr.CREATOR);
                String string6 = parcel.readString();
                zzbvc zzbvcVarZzf6 = zzbvb.zzf(parcel.readStrongBinder());
                int i12 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzbu zzbuVarV0 = V0(iObjectWrapperX314, zzrVar4, string6, zzbvcVarZzf6, i12);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbuVarV0);
                return true;
            case 14:
                IObjectWrapper iObjectWrapperX315 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbvc zzbvcVarZzf7 = zzbvb.zzf(parcel.readStrongBinder());
                int i13 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzcem zzcemVarP0 = P0(iObjectWrapperX315, zzbvcVarZzf7, i13);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzcemVarP0);
                return true;
            case 15:
                IObjectWrapper iObjectWrapperX316 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbvc zzbvcVarZzf8 = zzbvb.zzf(parcel.readStrongBinder());
                int i14 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzbyu zzbyuVarQ0 = q0(iObjectWrapperX316, zzbvcVarZzf8, i14);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbyuVarQ0);
                return true;
            case 16:
                IObjectWrapper iObjectWrapperX317 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbvc zzbvcVarZzf9 = zzbvb.zzf(parcel.readStrongBinder());
                int i15 = parcel.readInt();
                zzbqq zzbqqVarZzc = zzbqp.zzc(parcel.readStrongBinder());
                zzbeg.zzh(parcel);
                zzbqt zzbqtVarL1 = L1(iObjectWrapperX317, zzbvcVarZzf9, i15, zzbqqVarZzc);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzbqtVarL1);
                return true;
            case 17:
                IObjectWrapper iObjectWrapperX318 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbvc zzbvcVarZzf10 = zzbvb.zzf(parcel.readStrongBinder());
                int i16 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzdt zzdtVarE = E(iObjectWrapperX318, zzbvcVarZzf10, i16);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzdtVarE);
                return true;
            case 18:
                IObjectWrapper iObjectWrapperX319 = IObjectWrapper.Stub.x3(parcel.readStrongBinder());
                zzbvc zzbvcVarZzf11 = zzbvb.zzf(parcel.readStrongBinder());
                int i17 = parcel.readInt();
                zzbeg.zzh(parcel);
                zzch zzchVarQ2 = Q2(iObjectWrapperX319, zzbvcVarZzf11, i17);
                parcel2.writeNoException();
                zzbeg.zze(parcel2, zzchVarQ2);
                return true;
            default:
                return false;
        }
    }
}
