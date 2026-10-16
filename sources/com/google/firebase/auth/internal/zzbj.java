package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbj> CREATOR = new zzbm();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f87917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f87918b;

    public zzbj(List list, List list2) {
        this.f87917a = list == null ? new ArrayList() : list;
        this.f87918b = list2 == null ? new ArrayList() : list2;
    }

    public static zzbj M(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MultiFactorInfo multiFactorInfo = (MultiFactorInfo) it.next();
            if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                arrayList.add((PhoneMultiFactorInfo) multiFactorInfo);
            } else if (multiFactorInfo instanceof TotpMultiFactorInfo) {
                arrayList2.add((TotpMultiFactorInfo) multiFactorInfo);
            }
        }
        return new zzbj(arrayList, arrayList2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.K(parcel, 1, this.f87917a, false);
        SafeParcelWriter.K(parcel, 2, this.f87918b, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public final List zza() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f87917a.iterator();
        while (it.hasNext()) {
            arrayList.add((PhoneMultiFactorInfo) it.next());
        }
        Iterator it2 = this.f87918b.iterator();
        while (it2.hasNext()) {
            arrayList.add((TotpMultiFactorInfo) it2.next());
        }
        return arrayList;
    }
}
