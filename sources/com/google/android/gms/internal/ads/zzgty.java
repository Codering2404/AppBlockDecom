package com.google.android.gms.internal.ads;

import com.applovin.impl.privacy.consentFlow.as.KLAQHFCRAUejH;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgty {
    private final zzgtx zza;

    private zzgty(zzgtx zzgtxVar) {
        int i3 = zzgsw.zzb;
        this.zza = zzgtxVar;
    }

    public static zzgty zza(final zzgsx zzgsxVar) {
        return new zzgty(new zzgtx() { // from class: com.google.android.gms.internal.ads.zzgtv
            @Override // com.google.android.gms.internal.ads.zzgtx
            public final /* synthetic */ Iterator zza(zzgty zzgtyVar, CharSequence charSequence) {
                return new zzgtp(zzgtyVar, charSequence, zzgsxVar);
            }
        });
    }

    public static zzgty zzc(int i3) {
        final int i4 = 4000;
        return new zzgty(new zzgtx(i4) { // from class: com.google.android.gms.internal.ads.zzgtu
            @Override // com.google.android.gms.internal.ads.zzgtx
            public final /* synthetic */ Iterator zza(zzgty zzgtyVar, CharSequence charSequence) {
                return new zzgtr(zzgtyVar, charSequence, 4000);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final Iterator zzf(CharSequence charSequence) {
        return this.zza.zza(this, charSequence);
    }

    public final Iterable zzd(CharSequence charSequence) {
        charSequence.getClass();
        return new zzgts(this, charSequence);
    }

    public final List zze(CharSequence charSequence) {
        charSequence.getClass();
        Iterator itZzf = zzf(charSequence);
        ArrayList arrayList = new ArrayList();
        while (itZzf.hasNext()) {
            arrayList.add((String) itZzf.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static zzgty zzb(Pattern pattern) {
        final zzgtc zzgtcVar = new zzgtc(pattern);
        zzgtj.zzf(!((zzgtb) zzgtcVar.zza("")).zza.matches(), KLAQHFCRAUejH.TRAr, zzgtcVar);
        return new zzgty(new zzgtx() { // from class: com.google.android.gms.internal.ads.zzgtt
            @Override // com.google.android.gms.internal.ads.zzgtx
            public final /* synthetic */ Iterator zza(zzgty zzgtyVar, CharSequence charSequence) {
                return new zzgtq(zzgtyVar, charSequence, zzgtcVar.zza(charSequence));
            }
        });
    }
}
