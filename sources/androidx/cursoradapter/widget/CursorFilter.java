package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.widget.Filter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class CursorFilter extends Filter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    CursorFilterClient f35440a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface CursorFilterClient {
        void a(Cursor cursor);

        Cursor b(CharSequence charSequence);

        Cursor c();

        CharSequence convertToString(Cursor cursor);
    }

    CursorFilter(CursorFilterClient cursorFilterClient) {
        this.f35440a = cursorFilterClient;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.f35440a.convertToString((Cursor) obj);
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor cursorB = this.f35440a.b(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (cursorB != null) {
            filterResults.count = cursorB.getCount();
            filterResults.values = cursorB;
            return filterResults;
        }
        filterResults.count = 0;
        filterResults.values = null;
        return filterResults;
    }

    @Override // android.widget.Filter
    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor cursorC = this.f35440a.c();
        Object obj = filterResults.values;
        if (obj == null || obj == cursorC) {
            return;
        }
        this.f35440a.a((Cursor) obj);
    }
}
