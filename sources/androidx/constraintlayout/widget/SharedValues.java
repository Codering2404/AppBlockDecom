package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class SharedValues {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SparseIntArray f33398a = new SparseIntArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap f33399b = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface SharedValuesListener {
    }

    public void a(int i3, SharedValuesListener sharedValuesListener) {
        HashSet hashSet = (HashSet) this.f33399b.get(Integer.valueOf(i3));
        if (hashSet == null) {
            hashSet = new HashSet();
            this.f33399b.put(Integer.valueOf(i3), hashSet);
        }
        hashSet.add(new WeakReference(sharedValuesListener));
    }

    public void b(int i3, SharedValuesListener sharedValuesListener) {
        HashSet<WeakReference> hashSet = (HashSet) this.f33399b.get(Integer.valueOf(i3));
        if (hashSet == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (WeakReference weakReference : hashSet) {
            SharedValuesListener sharedValuesListener2 = (SharedValuesListener) weakReference.get();
            if (sharedValuesListener2 == null || sharedValuesListener2 == sharedValuesListener) {
                arrayList.add(weakReference);
            }
        }
        hashSet.removeAll(arrayList);
    }
}
