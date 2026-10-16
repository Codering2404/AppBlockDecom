package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class SimpleCursorAdapter extends ResourceCursorAdapter {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected int[] f35444n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected int[] f35445o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f35446p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private CursorToStringConverter f35447q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ViewBinder f35448r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    String[] f35449s;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface CursorToStringConverter {
        CharSequence convertToString(Cursor cursor);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ViewBinder {
        boolean setViewValue(View view, Cursor cursor, int i3);
    }

    private void j(Cursor cursor, String[] strArr) {
        if (cursor == null) {
            this.f35444n = null;
            return;
        }
        int length = strArr.length;
        int[] iArr = this.f35444n;
        if (iArr == null || iArr.length != length) {
            this.f35444n = new int[length];
        }
        for (int i3 = 0; i3 < length; i3++) {
            this.f35444n[i3] = cursor.getColumnIndexOrThrow(strArr[i3]);
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor cursor) {
        CursorToStringConverter cursorToStringConverter = this.f35447q;
        if (cursorToStringConverter != null) {
            return cursorToStringConverter.convertToString(cursor);
        }
        int i3 = this.f35446p;
        return i3 > -1 ? cursor.getString(i3) : super.convertToString(cursor);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void d(View view, Context context, Cursor cursor) {
        ViewBinder viewBinder = this.f35448r;
        int[] iArr = this.f35445o;
        int length = iArr.length;
        int[] iArr2 = this.f35444n;
        for (int i3 = 0; i3 < length; i3++) {
            View viewFindViewById = view.findViewById(iArr[i3]);
            if (viewFindViewById != null) {
                if (viewBinder != null ? viewBinder.setViewValue(viewFindViewById, cursor, iArr2[i3]) : false) {
                    continue;
                } else {
                    String string = cursor.getString(iArr2[i3]);
                    if (string == null) {
                        string = "";
                    }
                    if (viewFindViewById instanceof TextView) {
                        l((TextView) viewFindViewById, string);
                    } else {
                        if (!(viewFindViewById instanceof ImageView)) {
                            throw new IllegalStateException(viewFindViewById.getClass().getName() + " is not a  view that can be bounds by this SimpleCursorAdapter");
                        }
                        k((ImageView) viewFindViewById, string);
                    }
                }
            }
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public Cursor i(Cursor cursor) {
        j(cursor, this.f35449s);
        return super.i(cursor);
    }

    public void k(ImageView imageView, String str) {
        try {
            imageView.setImageResource(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    public void l(TextView textView, String str) {
        textView.setText(str);
    }
}
