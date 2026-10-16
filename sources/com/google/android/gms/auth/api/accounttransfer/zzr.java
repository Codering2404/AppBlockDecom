package com.google.android.gms.auth.api.accounttransfer;

import android.os.Bundle;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzr implements Api.ApiOptions.Optional {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final zzr f71019b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bundle f71020a;

    static {
        Bundle bundle = new Bundle();
        if (!bundle.containsKey("accountTypes")) {
            bundle.putStringArrayList("accountTypes", new ArrayList<>(0));
        }
        f71019b = new zzr(bundle, null);
    }

    /* synthetic */ zzr(Bundle bundle, zzq zzqVar) {
        this.f71020a = bundle;
    }

    public final Bundle a() {
        return new Bundle(this.f71020a);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzr)) {
            return false;
        }
        Bundle bundleA = a();
        Bundle bundleA2 = ((zzr) obj).a();
        if (bundleA.size() != bundleA2.size()) {
            return false;
        }
        for (String str : bundleA.keySet()) {
            if (!bundleA2.containsKey(str) || !Objects.b(bundleA.get(str), bundleA2.get(str))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        Bundle bundleA = a();
        int size = bundleA.size();
        ArrayList arrayList = new ArrayList(size + size);
        ArrayList arrayList2 = new ArrayList(bundleA.keySet());
        Collections.sort(arrayList2);
        int size2 = arrayList2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            String str = (String) arrayList2.get(i3);
            arrayList.add(str);
            arrayList.add(bundleA.get(str));
        }
        return Objects.c(arrayList);
    }
}
