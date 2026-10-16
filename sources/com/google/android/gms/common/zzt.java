package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzt> CREATOR = new zzu();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f72356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzj f72357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f72358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f72359d;

    zzt(String str, zzj zzjVar, boolean z2, boolean z3) {
        this.f72356a = str;
        this.f72357b = zzjVar;
        this.f72358c = z2;
        this.f72359d = z3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = this.f72356a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, str, false);
        zzj zzjVar = this.f72357b;
        if (zzjVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            zzjVar = null;
        }
        SafeParcelWriter.t(parcel, 2, zzjVar, false);
        SafeParcelWriter.g(parcel, 3, this.f72358c);
        SafeParcelWriter.g(parcel, 4, this.f72359d);
        SafeParcelWriter.b(parcel, iA);
    }

    zzt(String str, IBinder iBinder, boolean z2, boolean z3) {
        this.f72356a = str;
        zzk zzkVar = null;
        if (iBinder != null) {
            try {
                IObjectWrapper iObjectWrapperZzd = com.google.android.gms.common.internal.zzw.x3(iBinder).zzd();
                byte[] bArr = iObjectWrapperZzd == null ? null : (byte[]) ObjectWrapper.h5(iObjectWrapperZzd);
                if (bArr != null) {
                    zzkVar = new zzk(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e3) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e3);
            }
        }
        this.f72357b = zzkVar;
        this.f72358c = z2;
        this.f72359d = z3;
    }
}
