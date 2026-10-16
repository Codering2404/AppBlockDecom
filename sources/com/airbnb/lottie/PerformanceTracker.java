package com.airbnb.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import com.airbnb.lottie.utils.MeanCalculator;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PerformanceTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f56391a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f56392b = new ArraySet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f56393c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Comparator f56394d = new Comparator<Pair<String, Float>>() { // from class: com.airbnb.lottie.PerformanceTracker.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Pair pair, Pair pair2) {
            float fFloatValue = ((Float) pair.f34341b).floatValue();
            float fFloatValue2 = ((Float) pair2.f34341b).floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface FrameListener {
        void a(float f3);
    }

    public void a(String str, float f3) {
        if (this.f56391a) {
            MeanCalculator meanCalculator = (MeanCalculator) this.f56393c.get(str);
            if (meanCalculator == null) {
                meanCalculator = new MeanCalculator();
                this.f56393c.put(str, meanCalculator);
            }
            meanCalculator.a(f3);
            if (str.equals("__container")) {
                Iterator it = this.f56392b.iterator();
                while (it.hasNext()) {
                    ((FrameListener) it.next()).a(f3);
                }
            }
        }
    }

    void b(boolean z2) {
        this.f56391a = z2;
    }
}
