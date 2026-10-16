package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzt {
    private final zzf zza;
    private final zzz zzb;
    private final int zzc;

    private zzt(zzz zzzVar) {
        this(zzzVar, false, zzj.zza, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public static zzt zza(char c3) {
        final zzh zzhVar = new zzh(c3);
        zzu.zza(zzhVar);
        return new zzt(new zzz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzw
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzz
            public final Iterator zza(zzt zztVar, CharSequence charSequence) {
                return new zzy(zztVar, charSequence, zzhVar);
            }
        });
    }

    private zzt(zzz zzzVar, boolean z2, zzf zzfVar, int i3) {
        this.zzb = zzzVar;
        this.zza = zzfVar;
        this.zzc = Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static zzt zza(String str) {
        final zzl zzlVarZza = zzp.zza(str);
        if (!zzlVarZza.zza("").zzc()) {
            return new zzt(new zzz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzv
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzz
                public final Iterator zza(zzt zztVar, CharSequence charSequence) {
                    return new zzx(zztVar, charSequence, zzlVarZza.zza(charSequence));
                }
            });
        }
        throw new IllegalArgumentException(zzp.zza("The pattern may not match the empty string: %s", zzlVarZza));
    }

    public final List<String> zza(CharSequence charSequence) {
        zzu.zza(charSequence);
        Iterator<String> itZza = this.zzb.zza(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (itZza.hasNext()) {
            arrayList.add(itZza.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
