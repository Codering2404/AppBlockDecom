package com.applovin.impl;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.nativeAds.adPlacer.MaxAdPlacerSettings;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class yc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ug f65177a = new ug();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TreeSet f65178b = new TreeSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f65179c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f65180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f65181e;

    public yc(MaxAdPlacerSettings maxAdPlacerSettings) {
        a(maxAdPlacerSettings);
    }

    public void a() {
        this.f65179c.clear();
        this.f65178b.clear();
    }

    public int b(int i3) {
        if (i3 == 0) {
            return 0;
        }
        return i3 + a(i3 - 1, false);
    }

    public int c(int i3) {
        return i3 + a(i3, false);
    }

    public int d(int i3) {
        if (g(i3)) {
            return -1;
        }
        return i3 - a(i3, true);
    }

    public Collection e(int i3) {
        return new TreeSet((SortedSet) this.f65178b.tailSet(Integer.valueOf(i3), false));
    }

    public void f(int i3) {
        int iB = this.f65177a.b(Integer.valueOf(i3));
        for (int size = this.f65177a.size() - 1; size >= iB; size--) {
            Integer num = (Integer) this.f65177a.a(size);
            int iIntValue = num.intValue() + 1;
            a(num.intValue(), iIntValue);
            this.f65177a.a(size, Integer.valueOf(iIntValue));
        }
    }

    public boolean g(int i3) {
        return this.f65177a.contains(Integer.valueOf(i3));
    }

    public boolean h(int i3) {
        return this.f65178b.contains(Integer.valueOf(i3));
    }

    public void i(int i3) {
        int iB = this.f65177a.b(Integer.valueOf(i3));
        if (g(i3)) {
            this.f65179c.remove(Integer.valueOf(i3));
            this.f65178b.remove(Integer.valueOf(i3));
            this.f65177a.b(iB);
        }
        while (iB < this.f65177a.size()) {
            Integer num = (Integer) this.f65177a.a(iB);
            int iIntValue = num.intValue() - 1;
            a(num.intValue(), iIntValue);
            this.f65177a.a(iB, Integer.valueOf(iIntValue));
            iB++;
        }
    }

    public void b(int i3, int i4) {
        i(i3);
        f(i4);
    }

    public int c() {
        int i3 = this.f65180d;
        if (i3 != -1 && this.f65181e != -1) {
            while (i3 <= this.f65181e) {
                if (g(i3) && !h(i3)) {
                    return i3;
                }
                i3++;
            }
        }
        return -1;
    }

    public void a(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            this.f65179c.remove(num);
            this.f65178b.remove(num);
        }
    }

    public Collection b() {
        return new TreeSet((SortedSet) this.f65178b);
    }

    public void c(int i3, int i4) {
        this.f65180d = i3;
        this.f65181e = i4;
    }

    public MaxAd a(int i3) {
        return (MaxAd) this.f65179c.get(Integer.valueOf(i3));
    }

    private int a(int i3, boolean z2) {
        int iC = this.f65177a.c(Integer.valueOf(i3));
        if (!z2) {
            int i4 = i3 + iC;
            while (iC < this.f65177a.size() && i4 >= ((Integer) this.f65177a.a(iC)).intValue()) {
                i4++;
                iC++;
            }
        }
        return iC;
    }

    private void a(MaxAdPlacerSettings maxAdPlacerSettings) {
        if (!maxAdPlacerSettings.hasValidPositioning()) {
            com.applovin.impl.sdk.n.h("MaxAdPlacerData", "No positioning info was provided with ad placer settings. You must set at least (1) one or more fixed positions or (2) a repeating interval greater than or equal to 2 for the ad placer to determine where to position ads.");
            return;
        }
        this.f65177a.addAll(maxAdPlacerSettings.getFixedPositions());
        if (!maxAdPlacerSettings.isRepeatingEnabled()) {
            return;
        }
        int repeatingInterval = maxAdPlacerSettings.getRepeatingInterval();
        if (this.f65177a.isEmpty()) {
            this.f65177a.add(Integer.valueOf(repeatingInterval - 1));
        }
        int iIntValue = ((Integer) this.f65177a.a()).intValue();
        while (true) {
            iIntValue += repeatingInterval;
            if (this.f65177a.size() >= maxAdPlacerSettings.getMaxAdCount()) {
                return;
            } else {
                this.f65177a.add(Integer.valueOf(iIntValue));
            }
        }
    }

    public void a(MaxAd maxAd, int i3) {
        this.f65179c.put(Integer.valueOf(i3), maxAd);
        this.f65178b.add(Integer.valueOf(i3));
    }

    private void a(int i3, int i4) {
        if (this.f65179c.containsKey(Integer.valueOf(i3))) {
            this.f65179c.put(Integer.valueOf(i4), (MaxAd) this.f65179c.get(Integer.valueOf(i3)));
            this.f65178b.add(Integer.valueOf(i4));
            this.f65179c.remove(Integer.valueOf(i3));
            this.f65178b.remove(Integer.valueOf(i3));
        }
    }
}
