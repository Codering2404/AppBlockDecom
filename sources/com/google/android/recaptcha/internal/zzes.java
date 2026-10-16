package com.google.android.recaptcha.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzes implements zzeo {
    private static Timer zza;
    private final Context zzb;
    private final zzet zzc;
    private final CoroutineScope zzd;
    private final zzei zze;

    public zzes(Context context, zzet zzetVar, CoroutineScope coroutineScope) {
        this.zzb = context;
        this.zzc = zzetVar;
        this.zzd = coroutineScope;
        zzei zzeiVar = null;
        try {
            zzei zzeiVar2 = zzei.zzd;
            zzeiVar2 = zzeiVar2 == null ? new zzei(context, null) : zzeiVar2;
            zzei.zzd = zzeiVar2;
            zzeiVar = zzeiVar2;
        } catch (Exception unused) {
        }
        this.zze = zzeiVar;
        zzh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzg() {
        zzei zzeiVar;
        zztx zztxVarZzk;
        int iZzN;
        int i3;
        zzei zzeiVar2 = this.zze;
        if (zzeiVar2 != null) {
            for (List<zzej> list : CollectionsKt.windowed(zzeiVar2.zzd(), 20, 20, true)) {
                zzrd zzrdVarZzi = zzrf.zzi();
                ArrayList arrayList = new ArrayList();
                for (zzej zzejVar : list) {
                    try {
                        zztxVarZzk = zztx.zzk(zzkh.zzg().zzj(zzejVar.zzc()));
                        iZzN = zztxVarZzk.zzN();
                        i3 = iZzN - 1;
                    } catch (Exception unused) {
                        zzei zzeiVar3 = this.zze;
                        if (zzeiVar3 != null) {
                            zzeiVar3.zzf(zzejVar);
                        }
                    }
                    if (iZzN == 0) {
                        throw null;
                    }
                    if (i3 == 0) {
                        zzrdVarZzi.zzq(zztxVarZzk.zzf());
                    } else if (i3 == 1) {
                        zzrdVarZzi.zzr(zztxVarZzk.zzg());
                    } else {
                        if (i3 != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        Unit unit = Unit.f139807a;
                    }
                    arrayList.add(zzejVar);
                }
                if (zzrdVarZzi.zze() + zzrdVarZzi.zzf() != 0) {
                    if (this.zzc.zza(((zzrf) zzrdVarZzi.zzk()).zzd()) && (zzeiVar = this.zze) != null) {
                        zzeiVar.zza(arrayList);
                    }
                }
            }
        }
    }

    private final void zzh() {
        if (zza == null) {
            Timer timer = new Timer();
            zza = timer;
            timer.schedule(new zzep(this), 120000L, 120000L);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzeo
    public final void zza(zztx zztxVar) {
        BuildersKt__Builders_commonKt.d(this.zzd, null, null, new zzer(this, zztxVar, null), 3, null);
        zzh();
    }
}
