package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class TransitionValues {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f53546b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f53545a = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ArrayList f53547c = new ArrayList();

    public TransitionValues(View view) {
        this.f53546b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        return this.f53546b == transitionValues.f53546b && this.f53545a.equals(transitionValues.f53545a);
    }

    public int hashCode() {
        return (this.f53546b.hashCode() * 31) + this.f53545a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f53546b + "\n") + "    values:";
        for (String str2 : this.f53545a.keySet()) {
            str = str + "    " + str2 + ": " + this.f53545a.get(str2) + "\n";
        }
        return str;
    }
}
