package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p002firebaseauthapi.zzahv;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.MultiFactor;
import com.google.firebase.auth.UserInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaf extends FirebaseUser {
    public static final Parcelable.Creator<zzaf> CREATOR = new zzae();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zzahv f87845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zzab f87846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f87847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f87848d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f87849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f87850g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f87851h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Boolean f87852i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public zzah f87853j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f87854k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.google.firebase.auth.zze f87855l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public zzbj f87856m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f87857n;

    public zzaf(FirebaseApp firebaseApp, List list) {
        Preconditions.m(firebaseApp);
        this.f87847c = firebaseApp.o();
        this.f87848d = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.f87851h = "2";
        K2(list);
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final FirebaseApp J2() {
        return FirebaseApp.n(this.f87847c);
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String K() {
        return this.f87846b.K();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final synchronized FirebaseUser K2(List list) {
        try {
            Preconditions.m(list);
            this.f87849f = new ArrayList(list.size());
            this.f87850g = new ArrayList(list.size());
            for (int i3 = 0; i3 < list.size(); i3++) {
                UserInfo userInfo = (UserInfo) list.get(i3);
                if (userInfo.K().equals("firebase")) {
                    this.f87846b = (zzab) userInfo;
                } else {
                    this.f87850g.add(userInfo.K());
                }
                this.f87849f.add((zzab) userInfo);
            }
            if (this.f87846b == null) {
                this.f87846b = (zzab) this.f87849f.get(0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final void L2(zzahv zzahvVar) {
        this.f87845a = (zzahv) Preconditions.m(zzahvVar);
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final FirebaseUserMetadata M() {
        return this.f87853j;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final /* synthetic */ FirebaseUser M2() {
        this.f87852i = Boolean.FALSE;
        return this;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final /* synthetic */ MultiFactor N() {
        return new zzaj(this);
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final void N2(List list) {
        if (list == null) {
            list = new ArrayList();
        }
        this.f87857n = list;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final List O() {
        return this.f87849f;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final zzahv O2() {
        return this.f87845a;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final void P2(List list) {
        this.f87856m = zzbj.M(list);
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final List Q2() {
        return this.f87857n;
    }

    public final zzaf R2(String str) {
        this.f87851h = str;
        return this;
    }

    public final void S2(zzah zzahVar) {
        this.f87853j = zzahVar;
    }

    public final void T2(com.google.firebase.auth.zze zzeVar) {
        this.f87855l = zzeVar;
    }

    public final void U2(boolean z2) {
        this.f87854k = z2;
    }

    public final com.google.firebase.auth.zze V2() {
        return this.f87855l;
    }

    public final List W2() {
        zzbj zzbjVar = this.f87856m;
        return zzbjVar != null ? zzbjVar.zza() : new ArrayList();
    }

    public final List X2() {
        return this.f87849f;
    }

    public final boolean Y2() {
        return this.f87854k;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String g0() {
        Map map;
        zzahv zzahvVar = this.f87845a;
        if (zzahvVar == null || zzahvVar.zzc() == null || (map = (Map) zzbi.a(this.f87845a.zzc()).a().get("firebase")) == null) {
            return null;
        }
        return (String) map.get("tenant");
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String j0() {
        return this.f87846b.g0();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final boolean w0() {
        GetTokenResult getTokenResultA;
        Boolean bool = this.f87852i;
        if (bool == null || bool.booleanValue()) {
            zzahv zzahvVar = this.f87845a;
            String strB = "";
            if (zzahvVar != null && (getTokenResultA = zzbi.a(zzahvVar.zzc())) != null) {
                strB = getTokenResultA.b();
            }
            boolean z2 = true;
            if (O().size() > 1 || (strB != null && strB.equals("custom"))) {
                z2 = false;
            }
            this.f87852i = Boolean.valueOf(z2);
        }
        return this.f87852i.booleanValue();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 1, O2(), i3, false);
        SafeParcelWriter.E(parcel, 2, this.f87846b, i3, false);
        SafeParcelWriter.G(parcel, 3, this.f87847c, false);
        SafeParcelWriter.G(parcel, 4, this.f87848d, false);
        SafeParcelWriter.K(parcel, 5, this.f87849f, false);
        SafeParcelWriter.I(parcel, 6, zzg(), false);
        SafeParcelWriter.G(parcel, 7, this.f87851h, false);
        SafeParcelWriter.i(parcel, 8, Boolean.valueOf(w0()), false);
        SafeParcelWriter.E(parcel, 9, M(), i3, false);
        SafeParcelWriter.g(parcel, 10, this.f87854k);
        SafeParcelWriter.E(parcel, 11, this.f87855l, i3, false);
        SafeParcelWriter.E(parcel, 12, this.f87856m, i3, false);
        SafeParcelWriter.K(parcel, 13, Q2(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String zzd() {
        return O2().zzc();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String zze() {
        return this.f87845a.zzf();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final List zzg() {
        return this.f87850g;
    }

    public zzaf(zzahv zzahvVar, zzab zzabVar, String str, String str2, List list, List list2, String str3, Boolean bool, zzah zzahVar, boolean z2, com.google.firebase.auth.zze zzeVar, zzbj zzbjVar, List list3) {
        this.f87845a = zzahvVar;
        this.f87846b = zzabVar;
        this.f87847c = str;
        this.f87848d = str2;
        this.f87849f = list;
        this.f87850g = list2;
        this.f87851h = str3;
        this.f87852i = bool;
        this.f87853j = zzahVar;
        this.f87854k = z2;
        this.f87855l = zzeVar;
        this.f87856m = zzbjVar;
        this.f87857n = list3;
    }
}
