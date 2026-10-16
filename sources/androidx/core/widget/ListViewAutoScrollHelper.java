package androidx.core.widget;

import android.widget.ListView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ListViewAutoScrollHelper extends AutoScrollHelper {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final ListView f34661t;

    public ListViewAutoScrollHelper(ListView listView) {
        super(listView);
        this.f34661t = listView;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public boolean a(int i3) {
        return false;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public boolean b(int i3) {
        ListView listView = this.f34661t;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i4 = firstVisiblePosition + childCount;
        if (i3 > 0) {
            if (i4 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (i3 >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public void j(int i3, int i4) {
        this.f34661t.scrollListBy(i4);
    }
}
