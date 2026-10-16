package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzga extends com.google.android.gms.internal.measurement.zzbm implements zzgb {
    public zzga() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        zzgh zzgfVar = null;
        zzge zzgcVar = null;
        switch (i3) {
            case 1:
                zzbg zzbgVar = (zzbg) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzbg.CREATOR);
                zzr zzrVar = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                W0(zzbgVar, zzrVar);
                parcel2.writeNoException();
                return true;
            case 2:
                zzpl zzplVar = (zzpl) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzpl.CREATOR);
                zzr zzrVar2 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                n1(zzplVar, zzrVar2);
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            case 22:
            case 23:
            case 28:
            default:
                return false;
            case 4:
                zzr zzrVar3 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                q4(zzrVar3);
                parcel2.writeNoException();
                return true;
            case 5:
                zzbg zzbgVar2 = (zzbg) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzbg.CREATOR);
                String string = parcel.readString();
                String string2 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                B2(zzbgVar2, string, string2);
                parcel2.writeNoException();
                return true;
            case 6:
                zzr zzrVar4 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                X0(zzrVar4);
                parcel2.writeNoException();
                return true;
            case 7:
                zzr zzrVar5 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                boolean zZza = com.google.android.gms.internal.measurement.zzbn.zza(parcel);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                List listH2 = h2(zzrVar5, zZza);
                parcel2.writeNoException();
                parcel2.writeTypedList(listH2);
                return true;
            case 9:
                zzbg zzbgVar3 = (zzbg) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzbg.CREATOR);
                String string3 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                byte[] bArrD1 = d1(zzbgVar3, string3);
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrD1);
                return true;
            case 10:
                long j3 = parcel.readLong();
                String string4 = parcel.readString();
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                M2(j3, string4, string5, string6);
                parcel2.writeNoException();
                return true;
            case 11:
                zzr zzrVar6 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                String strW1 = W1(zzrVar6);
                parcel2.writeNoException();
                parcel2.writeString(strW1);
                return true;
            case 12:
                zzah zzahVar = (zzah) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzah.CREATOR);
                zzr zzrVar7 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                K(zzahVar, zzrVar7);
                parcel2.writeNoException();
                return true;
            case 13:
                zzah zzahVar2 = (zzah) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzah.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                e1(zzahVar2);
                parcel2.writeNoException();
                return true;
            case 14:
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                boolean zZza2 = com.google.android.gms.internal.measurement.zzbn.zza(parcel);
                zzr zzrVar8 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                List listK4 = K4(string7, string8, zZza2, zzrVar8);
                parcel2.writeNoException();
                parcel2.writeTypedList(listK4);
                return true;
            case 15:
                String string9 = parcel.readString();
                String string10 = parcel.readString();
                String string11 = parcel.readString();
                boolean zZza3 = com.google.android.gms.internal.measurement.zzbn.zza(parcel);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                List listI = I(string9, string10, string11, zZza3);
                parcel2.writeNoException();
                parcel2.writeTypedList(listI);
                return true;
            case 16:
                String string12 = parcel.readString();
                String string13 = parcel.readString();
                zzr zzrVar9 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                List listS4 = S4(string12, string13, zzrVar9);
                parcel2.writeNoException();
                parcel2.writeTypedList(listS4);
                return true;
            case 17:
                String string14 = parcel.readString();
                String string15 = parcel.readString();
                String string16 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                List listT0 = t0(string14, string15, string16);
                parcel2.writeNoException();
                parcel2.writeTypedList(listT0);
                return true;
            case 18:
                zzr zzrVar10 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                O2(zzrVar10);
                parcel2.writeNoException();
                return true;
            case 19:
                Bundle bundle = (Bundle) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, Bundle.CREATOR);
                zzr zzrVar11 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                e4(bundle, zzrVar11);
                parcel2.writeNoException();
                return true;
            case 20:
                zzr zzrVar12 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                e5(zzrVar12);
                parcel2.writeNoException();
                return true;
            case 21:
                zzr zzrVar13 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                zzao zzaoVarB4 = b4(zzrVar13);
                parcel2.writeNoException();
                if (zzaoVarB4 == null) {
                    parcel2.writeInt(0);
                } else {
                    parcel2.writeInt(1);
                    zzaoVarB4.writeToParcel(parcel2, 1);
                }
                return true;
            case 24:
                zzr zzrVar14 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                Bundle bundle2 = (Bundle) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, Bundle.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                List listS0 = S0(zzrVar14, bundle2);
                parcel2.writeNoException();
                parcel2.writeTypedList(listS0);
                return true;
            case 25:
                zzr zzrVar15 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                F0(zzrVar15);
                parcel2.writeNoException();
                return true;
            case 26:
                zzr zzrVar16 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                Z0(zzrVar16);
                parcel2.writeNoException();
                return true;
            case 27:
                zzr zzrVar17 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                E4(zzrVar17);
                parcel2.writeNoException();
                return true;
            case 29:
                zzr zzrVar18 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                zzoo zzooVar = (zzoo) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzoo.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
                    zzgfVar = iInterfaceQueryLocalInterface instanceof zzgh ? (zzgh) iInterfaceQueryLocalInterface : new zzgf(strongBinder);
                }
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                F(zzrVar18, zzooVar, zzgfVar);
                parcel2.writeNoException();
                return true;
            case 30:
                zzr zzrVar19 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                zzaf zzafVar = (zzaf) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzaf.CREATOR);
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                L3(zzrVar19, zzafVar);
                parcel2.writeNoException();
                return true;
            case 31:
                zzr zzrVar20 = (zzr) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzr.CREATOR);
                Bundle bundle3 = (Bundle) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, Bundle.CREATOR);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
                    zzgcVar = iInterfaceQueryLocalInterface2 instanceof zzge ? (zzge) iInterfaceQueryLocalInterface2 : new zzgc(strongBinder2);
                }
                com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
                w3(zzrVar20, bundle3, zzgcVar);
                parcel2.writeNoException();
                return true;
        }
    }
}
