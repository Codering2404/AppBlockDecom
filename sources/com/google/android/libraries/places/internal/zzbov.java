package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbov {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzblt f76567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f76568b = (String) Preconditions.u("pick_first", "defaultPolicy");

    zzbov(zzblt zzbltVar, String str) {
        this.f76567a = (zzblt) Preconditions.u(zzbltVar, "registry");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final com.google.android.libraries.places.internal.zzbms a(java.util.Map r12) {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbov.a(java.util.Map):com.google.android.libraries.places.internal.zzbms");
    }

    final /* synthetic */ zzblr b(String str, String str2) throws zzbou {
        zzblr zzblrVarB = this.f76567a.b(str);
        if (zzblrVarB != null) {
            return zzblrVarB;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68);
        sb.append("Trying to load '");
        sb.append(str);
        sb.append("' because using default policy, but it's unavailable");
        throw new zzbou(sb.toString(), null);
    }

    final /* synthetic */ zzblt c() {
        return this.f76567a;
    }

    final /* synthetic */ String d() {
        return this.f76568b;
    }
}
