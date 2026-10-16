package androidx.recyclerview.widget;

import androidx.recyclerview.widget.TileList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
interface ThreadUtil<T> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface BackgroundCallback<T> {
        void a(int i3, int i4, int i5, int i6, int i7);

        void b(int i3, int i4);

        void c(int i3);

        void d(TileList.Tile tile);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface MainThreadCallback<T> {
        void a(int i3, int i4);

        void b(int i3, TileList.Tile tile);

        void c(int i3, int i4);
    }
}
