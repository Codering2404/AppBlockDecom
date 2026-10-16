package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorSession;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzam extends MultiFactorSession {
    public static final Parcelable.Creator<zzam> CREATOR = new zzap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f87869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f87870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f87871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f87872d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public zzaf f87873f;

    public zzam() {
    }

    public static zzam M(String str, zzaf zzafVar) {
        Preconditions.g(str);
        zzam zzamVar = new zzam();
        zzamVar.f87869a = str;
        zzamVar.f87873f = zzafVar;
        return zzamVar;
    }

    public static zzam N(List list, String str) {
        Preconditions.m(list);
        Preconditions.g(str);
        zzam zzamVar = new zzam();
        zzamVar.f87871c = new ArrayList();
        zzamVar.f87872d = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MultiFactorInfo multiFactorInfo = (MultiFactorInfo) it.next();
            if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                zzamVar.f87871c.add((PhoneMultiFactorInfo) multiFactorInfo);
            } else {
                if (!(multiFactorInfo instanceof TotpMultiFactorInfo)) {
                    throw new IllegalArgumentException("MultiFactorInfo must be either PhoneMultiFactorInfo or TotpMultiFactorInfo. The factorId of this MultiFactorInfo: " + multiFactorInfo.O());
                }
                zzamVar.f87872d.add((TotpMultiFactorInfo) multiFactorInfo);
            }
        }
        zzamVar.f87870b = str;
        return zzamVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, this.f87869a, false);
        SafeParcelWriter.G(parcel, 2, this.f87870b, false);
        SafeParcelWriter.K(parcel, 3, this.f87871c, false);
        SafeParcelWriter.K(parcel, 4, this.f87872d, false);
        SafeParcelWriter.E(parcel, 5, this.f87873f, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public final String zzb() {
        return this.f87869a;
    }

    public final String zzc() {
        return this.f87870b;
    }

    public final boolean zzd() {
        return this.f87869a != null;
    }

    public zzam(String str, String str2, List list, List list2, zzaf zzafVar) {
        this.f87869a = str;
        this.f87870b = str2;
        this.f87871c = list;
        this.f87872d = list2;
        this.f87873f = zzafVar;
    }
}
