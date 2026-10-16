package com.airbnb.lottie;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LottieComposition {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map f56300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map f56301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map f56302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List f56303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SparseArrayCompat f56304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private LongSparseArray f56305h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List f56306i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Rect f56307j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f56308k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f56309l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f56310m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f56311n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PerformanceTracker f56298a = new PerformanceTracker();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashSet f56299b = new HashSet();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f56312o = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public static class Factory {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class ListenerAdapter implements LottieListener<LottieComposition>, Cancellable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final OnCompositionLoadedListener f56313a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private boolean f56314b;

            @Override // com.airbnb.lottie.LottieListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(LottieComposition lottieComposition) {
                if (this.f56314b) {
                    return;
                }
                this.f56313a.a(lottieComposition);
            }
        }
    }

    public void a(String str) {
        Logger.c(str);
        this.f56299b.add(str);
    }

    public Rect b() {
        return this.f56307j;
    }

    public SparseArrayCompat c() {
        return this.f56304g;
    }

    public float d() {
        return (long) ((e() / this.f56310m) * 1000.0f);
    }

    public float e() {
        return this.f56309l - this.f56308k;
    }

    public float f() {
        return this.f56309l;
    }

    public Map g() {
        return this.f56302e;
    }

    public float h(float f3) {
        return MiscUtils.i(this.f56308k, this.f56309l, f3);
    }

    public float i() {
        return this.f56310m;
    }

    public Map j() {
        return this.f56301d;
    }

    public List k() {
        return this.f56306i;
    }

    public Marker l(String str) {
        int size = this.f56303f.size();
        for (int i3 = 0; i3 < size; i3++) {
            Marker marker = (Marker) this.f56303f.get(i3);
            if (marker.a(str)) {
                return marker;
            }
        }
        return null;
    }

    public int m() {
        return this.f56312o;
    }

    public PerformanceTracker n() {
        return this.f56298a;
    }

    public List o(String str) {
        return (List) this.f56300c.get(str);
    }

    public float p() {
        return this.f56308k;
    }

    public boolean q() {
        return this.f56311n;
    }

    public void r(int i3) {
        this.f56312o += i3;
    }

    public void s(Rect rect, float f3, float f4, float f5, List list, LongSparseArray longSparseArray, Map map, Map map2, SparseArrayCompat sparseArrayCompat, Map map3, List list2) {
        this.f56307j = rect;
        this.f56308k = f3;
        this.f56309l = f4;
        this.f56310m = f5;
        this.f56306i = list;
        this.f56305h = longSparseArray;
        this.f56300c = map;
        this.f56301d = map2;
        this.f56304g = sparseArrayCompat;
        this.f56302e = map3;
        this.f56303f = list2;
    }

    public Layer t(long j3) {
        return (Layer) this.f56305h.g(j3);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator it = this.f56306i.iterator();
        while (it.hasNext()) {
            sb.append(((Layer) it.next()).y("\t"));
        }
        return sb.toString();
    }

    public void u(boolean z2) {
        this.f56311n = z2;
    }

    public void v(boolean z2) {
        this.f56298a.b(z2);
    }
}
