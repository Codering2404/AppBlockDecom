package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfvw implements zzfvu {
    private final zzfvu zza;

    public zzfvw(zzfvu zzfvuVar) {
        this.zza = zzfvuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvu
    public final JSONObject zza(View view) {
        JSONObject jSONObjectZzb = zzfwe.zzb(0, 0, 0, 0);
        int iZzb = zzfwh.zzb();
        int i3 = iZzb - 1;
        if (iZzb == 0) {
            throw null;
        }
        try {
            jSONObjectZzb.put("noOutputDevice", i3 == 0);
            return jSONObjectZzb;
        } catch (JSONException e3) {
            zzfwf.zza("Error with setting output device status", e3);
            return jSONObjectZzb;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfvu
    public final void zzb(View view, JSONObject jSONObject, zzfvt zzfvtVar, boolean z2, boolean z3) {
        ArrayList arrayList = new ArrayList();
        zzfvi zzfviVarZza = zzfvi.zza();
        if (zzfviVarZza != null) {
            Collection collectionZzf = zzfviVarZza.zzf();
            int size = collectionZzf.size();
            IdentityHashMap identityHashMap = new IdentityHashMap(size + size + 3);
            Iterator it = collectionZzf.iterator();
            while (it.hasNext()) {
                View viewZzi = ((zzfuo) it.next()).zzi();
                if (viewZzi != null && viewZzi.isAttachedToWindow() && viewZzi.isShown()) {
                    View view2 = viewZzi;
                    while (true) {
                        if (view2 == null) {
                            View rootView = viewZzi.getRootView();
                            if (rootView != null && !identityHashMap.containsKey(rootView)) {
                                identityHashMap.put(rootView, rootView);
                                float z4 = rootView.getZ();
                                int size2 = arrayList.size();
                                while (size2 > 0) {
                                    int i3 = size2 - 1;
                                    if (((View) arrayList.get(i3)).getZ() <= z4) {
                                        break;
                                    } else {
                                        size2 = i3;
                                    }
                                }
                                arrayList.add(size2, rootView);
                            }
                        } else {
                            if (view2.getAlpha() == 0.0f) {
                                break;
                            }
                            Object parent = view2.getParent();
                            view2 = parent instanceof View ? (View) parent : null;
                        }
                    }
                }
            }
        }
        int size3 = arrayList.size();
        for (int i4 = 0; i4 < size3; i4++) {
            zzfvtVar.zza((View) arrayList.get(i4), this.zza, jSONObject, z3);
        }
    }
}
