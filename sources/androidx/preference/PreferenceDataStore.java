package androidx.preference;

import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class PreferenceDataStore {
    public boolean a(String str, boolean z2) {
        return z2;
    }

    public int b(String str, int i3) {
        return i3;
    }

    public String c(String str, String str2) {
        return str2;
    }

    public Set d(String str, Set set) {
        return set;
    }

    public void e(String str, boolean z2) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void f(String str, int i3) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void g(String str, String str2) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void h(String str, Set set) {
        throw new UnsupportedOperationException(MrGIhy.gsEB);
    }
}
