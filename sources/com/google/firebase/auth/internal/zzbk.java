package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzahy;
import com.google.android.gms.internal.p002firebaseauthapi.zzaiz;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbk {
    public static MultiFactorInfo a(zzahy zzahyVar) {
        if (zzahyVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(zzahyVar.zze())) {
            return new PhoneMultiFactorInfo(zzahyVar.zzd(), zzahyVar.zzc(), zzahyVar.zza(), Preconditions.g(zzahyVar.zze()));
        }
        if (zzahyVar.zzb() != null) {
            return new TotpMultiFactorInfo(zzahyVar.zzd(), zzahyVar.zzc(), zzahyVar.zza(), (zzaiz) Preconditions.n(zzahyVar.zzb(), "totpInfo cannot be null."));
        }
        return null;
    }

    public static List b(List list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MultiFactorInfo multiFactorInfoA = a((zzahy) it.next());
            if (multiFactorInfoA != null) {
                arrayList.add(multiFactorInfoA);
            }
        }
        return arrayList;
    }
}
