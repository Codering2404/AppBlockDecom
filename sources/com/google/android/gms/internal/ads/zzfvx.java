package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfvx implements zzfvu {
    private final int[] zza = new int[2];

    @Override // com.google.android.gms.internal.ads.zzfvu
    public final JSONObject zza(View view) {
        if (view == null) {
            return zzfwe.zzb(0, 0, 0, 0);
        }
        int[] iArr = this.zza;
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(iArr);
        return zzfwe.zzb(iArr[0], iArr[1], width, height);
    }

    @Override // com.google.android.gms.internal.ads.zzfvu
    public final void zzb(View view, JSONObject jSONObject, zzfvt zzfvtVar, boolean z2, boolean z3) {
        int i3;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!z2) {
                for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                    zzfvtVar.zza(viewGroup.getChildAt(i4), this, jSONObject, z3);
                }
                return;
            }
            HashMap map = new HashMap();
            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                View childAt = viewGroup.getChildAt(i5);
                ArrayList arrayList = (ArrayList) map.get(Float.valueOf(childAt.getZ()));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(Float.valueOf(childAt.getZ()), arrayList);
                }
                arrayList.add(childAt);
            }
            ArrayList arrayList2 = new ArrayList(map.keySet());
            Collections.sort(arrayList2);
            int size = arrayList2.size();
            int i6 = 0;
            while (i6 < size) {
                ArrayList arrayList3 = (ArrayList) map.get((Float) arrayList2.get(i6));
                int size2 = arrayList3.size();
                int i7 = 0;
                while (true) {
                    i3 = i6 + 1;
                    if (i7 < size2) {
                        zzfvtVar.zza((View) arrayList3.get(i7), this, jSONObject, z3);
                        i7++;
                    }
                }
                i6 = i3;
            }
        }
    }
}
