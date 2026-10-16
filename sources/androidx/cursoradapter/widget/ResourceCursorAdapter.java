package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ResourceCursorAdapter extends CursorAdapter {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f35441k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f35442l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private LayoutInflater f35443m;

    public ResourceCursorAdapter(Context context, int i3, Cursor cursor, boolean z2) {
        super(context, cursor, z2);
        this.f35442l = i3;
        this.f35441k = i3;
        this.f35443m = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View f(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f35443m.inflate(this.f35442l, viewGroup, false);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f35443m.inflate(this.f35441k, viewGroup, false);
    }
}
