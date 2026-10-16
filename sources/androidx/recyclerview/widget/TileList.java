package androidx.recyclerview.widget;

import android.util.SparseArray;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class TileList<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseArray f52057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Tile f52058b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Tile<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object[] f52059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f52060b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f52061c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Tile f52062d;

        Tile(Class cls, int i3) {
            this.f52059a = (Object[]) Array.newInstance((Class<?>) cls, i3);
        }
    }

    public Tile a(Tile tile) {
        int iIndexOfKey = this.f52057a.indexOfKey(tile.f52060b);
        if (iIndexOfKey < 0) {
            this.f52057a.put(tile.f52060b, tile);
            return null;
        }
        Tile tile2 = (Tile) this.f52057a.valueAt(iIndexOfKey);
        this.f52057a.setValueAt(iIndexOfKey, tile);
        if (this.f52058b == tile2) {
            this.f52058b = tile;
        }
        return tile2;
    }

    public void b() {
        this.f52057a.clear();
    }

    public Tile c(int i3) {
        if (i3 < 0 || i3 >= this.f52057a.size()) {
            return null;
        }
        return (Tile) this.f52057a.valueAt(i3);
    }

    public Tile d(int i3) {
        Tile tile = (Tile) this.f52057a.get(i3);
        if (this.f52058b == tile) {
            this.f52058b = null;
        }
        this.f52057a.delete(i3);
        return tile;
    }

    public int e() {
        return this.f52057a.size();
    }
}
