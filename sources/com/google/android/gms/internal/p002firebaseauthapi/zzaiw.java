package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaiw {
    private List<String> zza;

    public zzaiw() {
        this(null);
    }

    public static zzaiw zza() {
        return new zzaiw(null);
    }

    public final List<String> zzb() {
        return this.zza;
    }

    private zzaiw(List<String> list) {
        this.zza = new ArrayList();
    }

    public zzaiw(int i3, List<String> list) {
        if (list != null && !list.isEmpty()) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.set(i4, Strings.a(list.get(i4)));
            }
            this.zza = Collections.unmodifiableList(list);
            return;
        }
        this.zza = Collections.EMPTY_LIST;
    }
}
