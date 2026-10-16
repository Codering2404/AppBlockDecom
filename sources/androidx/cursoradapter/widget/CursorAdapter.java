package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.cursoradapter.widget.CursorFilter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilter.CursorFilterClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f35429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f35430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Cursor f35431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Context f35432d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f35433f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected ChangeObserver f35434g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected DataSetObserver f35435h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected CursorFilter f35436i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected FilterQueryProvider f35437j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ChangeObserver extends ContentObserver {
        ChangeObserver() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z2) {
            CursorAdapter.this.h();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class MyDataSetObserver extends DataSetObserver {
        MyDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.f35429a = true;
            cursorAdapter.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.f35429a = false;
            cursorAdapter.notifyDataSetInvalidated();
        }
    }

    public CursorAdapter(Context context, Cursor cursor, boolean z2) {
        e(context, cursor, z2 ? 1 : 2);
    }

    public void a(Cursor cursor) {
        Cursor cursorI = i(cursor);
        if (cursorI != null) {
            cursorI.close();
        }
    }

    public Cursor b(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.f35437j;
        return filterQueryProvider != null ? filterQueryProvider.runQuery(charSequence) : this.f35431c;
    }

    @Override // androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public Cursor c() {
        return this.f35431c;
    }

    public CharSequence convertToString(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public abstract void d(View view, Context context, Cursor cursor);

    void e(Context context, Cursor cursor, int i3) {
        if ((i3 & 1) == 1) {
            i3 |= 2;
            this.f35430b = true;
        } else {
            this.f35430b = false;
        }
        boolean z2 = cursor != null;
        this.f35431c = cursor;
        this.f35429a = z2;
        this.f35432d = context;
        this.f35433f = z2 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i3 & 2) == 2) {
            this.f35434g = new ChangeObserver();
            this.f35435h = new MyDataSetObserver();
        } else {
            this.f35434g = null;
            this.f35435h = null;
        }
        if (z2) {
            ChangeObserver changeObserver = this.f35434g;
            if (changeObserver != null) {
                cursor.registerContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.f35435h;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public View f(Context context, Cursor cursor, ViewGroup viewGroup) {
        return g(context, cursor, viewGroup);
    }

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f35429a || (cursor = this.f35431c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i3, View view, ViewGroup viewGroup) {
        if (!this.f35429a) {
            return null;
        }
        this.f35431c.moveToPosition(i3);
        if (view == null) {
            view = f(this.f35432d, this.f35431c, viewGroup);
        }
        d(view, this.f35432d, this.f35431c);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f35436i == null) {
            this.f35436i = new CursorFilter(this);
        }
        return this.f35436i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        Cursor cursor;
        if (!this.f35429a || (cursor = this.f35431c) == null) {
            return null;
        }
        cursor.moveToPosition(i3);
        return this.f35431c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        Cursor cursor;
        if (this.f35429a && (cursor = this.f35431c) != null && cursor.moveToPosition(i3)) {
            return this.f35431c.getLong(this.f35433f);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        if (!this.f35429a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f35431c.moveToPosition(i3)) {
            if (view == null) {
                view = g(this.f35432d, this.f35431c, viewGroup);
            }
            d(view, this.f35432d, this.f35431c);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i3);
    }

    protected void h() {
        Cursor cursor;
        if (!this.f35430b || (cursor = this.f35431c) == null || cursor.isClosed()) {
            return;
        }
        this.f35429a = this.f35431c.requery();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public Cursor i(Cursor cursor) {
        Cursor cursor2 = this.f35431c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            ChangeObserver changeObserver = this.f35434g;
            if (changeObserver != null) {
                cursor2.unregisterContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.f35435h;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f35431c = cursor;
        if (cursor == null) {
            this.f35433f = -1;
            this.f35429a = false;
            notifyDataSetInvalidated();
            return cursor2;
        }
        ChangeObserver changeObserver2 = this.f35434g;
        if (changeObserver2 != null) {
            cursor.registerContentObserver(changeObserver2);
        }
        DataSetObserver dataSetObserver2 = this.f35435h;
        if (dataSetObserver2 != null) {
            cursor.registerDataSetObserver(dataSetObserver2);
        }
        this.f35433f = cursor.getColumnIndexOrThrow("_id");
        this.f35429a = true;
        notifyDataSetChanged();
        return cursor2;
    }
}
