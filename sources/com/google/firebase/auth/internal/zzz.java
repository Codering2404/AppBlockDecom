package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzz implements AuthResult {
    public static final Parcelable.Creator<zzz> CREATOR = new zzy();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zzaf f88012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zzx f88013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.google.firebase.auth.zze f88014c;

    public zzz(zzaf zzafVar) {
        zzaf zzafVar2 = (zzaf) Preconditions.m(zzafVar);
        this.f88012a = zzafVar2;
        List listX2 = zzafVar2.X2();
        this.f88013b = null;
        for (int i3 = 0; i3 < listX2.size(); i3++) {
            if (!TextUtils.isEmpty(((zzab) listX2.get(i3)).zza())) {
                this.f88013b = new zzx(((zzab) listX2.get(i3)).K(), ((zzab) listX2.get(i3)).zza(), zzafVar.Y2());
            }
        }
        if (this.f88013b == null) {
            this.f88013b = new zzx(zzafVar.Y2());
        }
        this.f88014c = zzafVar.V2();
    }

    @Override // com.google.firebase.auth.AuthResult
    public final FirebaseUser U0() {
        return this.f88012a;
    }

    @Override // com.google.firebase.auth.AuthResult
    public final AdditionalUserInfo b2() {
        return this.f88013b;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 1, U0(), i3, false);
        SafeParcelWriter.E(parcel, 2, b2(), i3, false);
        SafeParcelWriter.E(parcel, 3, this.f88014c, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public zzz(zzaf zzafVar, zzx zzxVar, com.google.firebase.auth.zze zzeVar) {
        this.f88012a = zzafVar;
        this.f88013b = zzxVar;
        this.f88014c = zzeVar;
    }
}
