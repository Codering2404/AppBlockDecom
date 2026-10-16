package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class TagManager {
    private static TagManager zza;
    private final zzfo zzb;
    private final Context zzc;
    private final DataLayer zzd;
    private final zzex zze;
    private final ConcurrentMap zzf;
    private final zzao zzg;

    TagManager(Context context, zzfo zzfoVar, DataLayer dataLayer, zzex zzexVar) {
        Context applicationContext = context.getApplicationContext();
        this.zzc = applicationContext;
        this.zze = zzexVar;
        this.zzb = zzfoVar;
        this.zzf = new ConcurrentHashMap();
        this.zzd = dataLayer;
        dataLayer.zzg(new zzfl(this));
        dataLayer.zzg(new zzg(applicationContext));
        this.zzg = new zzao();
        Preconditions.m(applicationContext);
        applicationContext.registerComponentCallbacks(new zzfn(this));
        Preconditions.m(applicationContext);
        zzd.zzb(applicationContext);
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            try {
                if (zza == null) {
                    if (context == null) {
                        Log.e("GoogleTagManager", "TagManager.getInstance requires non-null context.");
                        throw null;
                    }
                    zza = new TagManager(context, new zzfm(), new DataLayer(new zzbd(context)), zzfe.zzg());
                }
                tagManager = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tagManager;
    }

    static /* bridge */ /* synthetic */ void zzb(TagManager tagManager, String str) {
        Preconditions.m(tagManager.zzf);
        Iterator it = tagManager.zzf.values().iterator();
        while (it.hasNext()) {
            ((zzz) it.next()).zzd(str);
        }
    }

    public void dispatch() {
        this.zze.zza();
    }

    public DataLayer getDataLayer() {
        return this.zzd;
    }

    public final int zza(zzz zzzVar) {
        this.zzf.put(zzzVar.zza(), zzzVar);
        return this.zzf.size();
    }

    public final boolean zzc(zzz zzzVar) {
        return this.zzf.remove(zzzVar.zza()) != null;
    }

    final synchronized boolean zzd(Uri uri) {
        try {
            zzdz zzdzVarZza = zzdz.zza();
            if (!zzdzVarZza.zzd(uri)) {
                return false;
            }
            String strZzc = zzdzVarZza.zzc();
            int iZze = zzdzVarZza.zze();
            int i3 = iZze - 1;
            if (iZze == 0) {
                throw null;
            }
            if (i3 == 0) {
                zzz zzzVar = (zzz) this.zzf.get(strZzc);
                if (zzzVar != null) {
                    zzzVar.zze(null);
                    zzzVar.refresh();
                }
            } else if (i3 == 1 || i3 == 2) {
                for (String str : this.zzf.keySet()) {
                    zzz zzzVar2 = (zzz) this.zzf.get(str);
                    if (str.equals(strZzc)) {
                        zzzVar2.zze(zzdzVarZza.zzb());
                        zzzVar2.refresh();
                    } else if (zzzVar2.zzb() != null) {
                        zzzVar2.zze(null);
                        zzzVar2.refresh();
                    }
                }
            }
            return true;
        } finally {
        }
    }
}
