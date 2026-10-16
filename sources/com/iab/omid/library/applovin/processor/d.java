package com.iab.omid.library.applovin.processor;

import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.applovin.processor.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f92167a = new int[2];

    private void b(ViewGroup viewGroup, JSONObject jSONObject, a.InterfaceC0169a interfaceC0169a, boolean z2) {
        HashMap map = new HashMap();
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            View childAt = viewGroup.getChildAt(i3);
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
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList2.get(i4);
            i4++;
            ArrayList arrayList3 = (ArrayList) map.get((Float) obj);
            int size2 = arrayList3.size();
            int i5 = 0;
            while (i5 < size2) {
                Object obj2 = arrayList3.get(i5);
                i5++;
                interfaceC0169a.a((View) obj2, this, jSONObject, z2);
            }
        }
    }

    @Override // com.iab.omid.library.applovin.processor.a
    public JSONObject a(View view) {
        if (view == null) {
            return com.iab.omid.library.applovin.utils.c.a(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f92167a);
        int[] iArr = this.f92167a;
        return com.iab.omid.library.applovin.utils.c.a(iArr[0], iArr[1], width, height);
    }

    @Override // com.iab.omid.library.applovin.processor.a
    public void a(View view, JSONObject jSONObject, a.InterfaceC0169a interfaceC0169a, boolean z2, boolean z3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (z2) {
                b(viewGroup, jSONObject, interfaceC0169a, z3);
            } else {
                a(viewGroup, jSONObject, interfaceC0169a, z3);
            }
        }
    }

    private void a(ViewGroup viewGroup, JSONObject jSONObject, a.InterfaceC0169a interfaceC0169a, boolean z2) {
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            interfaceC0169a.a(viewGroup.getChildAt(i3), this, jSONObject, z2);
        }
    }
}
