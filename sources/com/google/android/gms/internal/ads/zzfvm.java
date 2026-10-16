package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfvm {
    private static final Pattern zza = Pattern.compile(pMpIcGE.UBlxyYl);
    private final List zzb = new ArrayList();

    public final List zza() {
        return this.zzb;
    }

    public final void zzb(View view, zzfur zzfurVar, String str) {
        zzfvl zzfvlVar;
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
        if (!zza.matcher("Ad overlay").matches()) {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
        }
        List list = this.zzb;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzfvlVar = null;
                break;
            } else {
                zzfvlVar = (zzfvl) it.next();
                if (zzfvlVar.zza().get() == view) {
                    break;
                }
            }
        }
        if (zzfvlVar == null) {
            list.add(new zzfvl(view, zzfurVar, "Ad overlay"));
        }
    }

    public final void zzc() {
        this.zzb.clear();
    }
}
