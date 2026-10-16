package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface MenuProvider {
    boolean c(MenuItem menuItem);

    void d(Menu menu, MenuInflater menuInflater);

    default void a(Menu menu) {
    }

    default void b(Menu menu) {
    }
}
