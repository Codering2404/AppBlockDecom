package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p002firebaseauthapi.zzaas;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorResolver;
import com.google.firebase.auth.MultiFactorSession;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzal extends MultiFactorResolver {
    public static final Parcelable.Creator<zzal> CREATOR = new zzan();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f87863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzam f87864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f87865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.firebase.auth.zze f87866d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final zzaf f87867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f87868g;

    public zzal(List list, zzam zzamVar, String str, com.google.firebase.auth.zze zzeVar, zzaf zzafVar, List list2) {
        this.f87863a = (List) Preconditions.m(list);
        this.f87864b = (zzam) Preconditions.m(zzamVar);
        this.f87865c = Preconditions.g(str);
        this.f87866d = zzeVar;
        this.f87867f = zzafVar;
        this.f87868g = (List) Preconditions.m(list2);
    }

    public static zzal N(zzaas zzaasVar, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        List<MultiFactorInfo> listZzc = zzaasVar.zzc();
        ArrayList arrayList = new ArrayList();
        for (MultiFactorInfo multiFactorInfo : listZzc) {
            if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                arrayList.add((PhoneMultiFactorInfo) multiFactorInfo);
            }
        }
        List<MultiFactorInfo> listZzc2 = zzaasVar.zzc();
        ArrayList arrayList2 = new ArrayList();
        for (MultiFactorInfo multiFactorInfo2 : listZzc2) {
            if (multiFactorInfo2 instanceof TotpMultiFactorInfo) {
                arrayList2.add((TotpMultiFactorInfo) multiFactorInfo2);
            }
        }
        return new zzal(arrayList, zzam.N(zzaasVar.zzc(), zzaasVar.zzb()), firebaseAuth.b().o(), zzaasVar.zza(), (zzaf) firebaseUser, arrayList2);
    }

    @Override // com.google.firebase.auth.MultiFactorResolver
    public final MultiFactorSession M() {
        return this.f87864b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.K(parcel, 1, this.f87863a, false);
        SafeParcelWriter.E(parcel, 2, M(), i3, false);
        SafeParcelWriter.G(parcel, 3, this.f87865c, false);
        SafeParcelWriter.E(parcel, 4, this.f87866d, i3, false);
        SafeParcelWriter.E(parcel, 5, this.f87867f, i3, false);
        SafeParcelWriter.K(parcel, 6, this.f87868g, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
