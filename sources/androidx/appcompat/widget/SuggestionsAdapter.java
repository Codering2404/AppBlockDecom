package androidx.appcompat.widget;

import android.R;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.appevents.AppEventsConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class SuggestionsAdapter extends ResourceCursorAdapter implements View.OnClickListener {
    private int A;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final SearchView f2169n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final SearchableInfo f2170o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Context f2171p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final WeakHashMap f2172q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f2173r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f2174s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f2175t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ColorStateList f2176u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f2177v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f2178w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f2179x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f2180y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f2181z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ChildViewCache {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f2182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f2183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f2184c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f2185d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ImageView f2186e;

        public ChildViewCache(View view) {
            this.f2182a = (TextView) view.findViewById(R.id.text1);
            this.f2183b = (TextView) view.findViewById(R.id.text2);
            this.f2184c = (ImageView) view.findViewById(R.id.icon1);
            this.f2185d = (ImageView) view.findViewById(R.id.icon2);
            this.f2186e = (ImageView) view.findViewById(androidx.appcompat.R.id.f751s);
        }
    }

    public SuggestionsAdapter(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f2174s = false;
        this.f2175t = 1;
        this.f2177v = -1;
        this.f2178w = -1;
        this.f2179x = -1;
        this.f2180y = -1;
        this.f2181z = -1;
        this.A = -1;
        this.f2169n = searchView;
        this.f2170o = searchableInfo;
        this.f2173r = searchView.getSuggestionCommitIconResId();
        this.f2171p = context;
        this.f2172q = weakHashMap;
    }

    private void A(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    private Drawable j(String str) {
        Drawable.ConstantState constantState = (Drawable.ConstantState) this.f2172q.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence k(CharSequence charSequence) {
        if (this.f2176u == null) {
            TypedValue typedValue = new TypedValue();
            this.f2171p.getTheme().resolveAttribute(androidx.appcompat.R.attr.f682z0, typedValue, true);
            this.f2176u = this.f2171p.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f2176u, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable l(ComponentName componentName) {
        PackageManager packageManager = this.f2171p.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e3) {
            Log.w("SuggestionsAdapter", e3.toString());
            return null;
        }
    }

    private Drawable m(ComponentName componentName) {
        String strFlattenToShortString = componentName.flattenToShortString();
        if (!this.f2172q.containsKey(strFlattenToShortString)) {
            Drawable drawableL = l(componentName);
            this.f2172q.put(strFlattenToShortString, drawableL != null ? drawableL.getConstantState() : null);
            return drawableL;
        }
        Drawable.ConstantState constantState = (Drawable.ConstantState) this.f2172q.get(strFlattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.f2171p.getResources());
    }

    public static String n(Cursor cursor, String str) {
        return v(cursor, cursor.getColumnIndex(str));
    }

    private Drawable o() {
        Drawable drawableM = m(this.f2170o.getSearchActivity());
        return drawableM != null ? drawableM : this.f2171p.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable p(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return q(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream inputStreamOpenInputStream = this.f2171p.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                Drawable drawableCreateFromStream = Drawable.createFromStream(inputStreamOpenInputStream, null);
                try {
                    return drawableCreateFromStream;
                } catch (IOException e3) {
                    return drawableCreateFromStream;
                }
            } finally {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e32) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e32);
                }
            }
        } catch (FileNotFoundException e4) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e4.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e4.getMessage());
        return null;
    }

    private Drawable r(String str) {
        if (str == null || str.isEmpty() || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str)) {
            return null;
        }
        try {
            int i3 = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f2171p.getPackageName() + "/" + i3;
            Drawable drawableJ = j(str2);
            if (drawableJ != null) {
                return drawableJ;
            }
            Drawable drawable = ContextCompat.getDrawable(this.f2171p, i3);
            z(str2, drawable);
            return drawable;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable drawableJ2 = j(str);
            if (drawableJ2 != null) {
                return drawableJ2;
            }
            Drawable drawableP = p(Uri.parse(str));
            z(str, drawableP);
            return drawableP;
        }
    }

    private Drawable s(Cursor cursor) {
        int i3 = this.f2180y;
        if (i3 == -1) {
            return null;
        }
        Drawable drawableR = r(cursor.getString(i3));
        return drawableR != null ? drawableR : o();
    }

    private Drawable t(Cursor cursor) {
        int i3 = this.f2181z;
        if (i3 == -1) {
            return null;
        }
        return r(cursor.getString(i3));
    }

    private static String v(Cursor cursor, int i3) {
        if (i3 == -1) {
            return null;
        }
        try {
            return cursor.getString(i3);
        } catch (Exception e3) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e3);
            return null;
        }
    }

    private void x(ImageView imageView, Drawable drawable, int i3) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i3);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void y(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void z(String str, Drawable drawable) {
        if (drawable != null) {
            this.f2172q.put(str, drawable.getConstantState());
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public void a(Cursor cursor) {
        if (this.f2174s) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.f2177v = cursor.getColumnIndex("suggest_text_1");
                this.f2178w = cursor.getColumnIndex("suggest_text_2");
                this.f2179x = cursor.getColumnIndex("suggest_text_2_url");
                this.f2180y = cursor.getColumnIndex("suggest_icon_1");
                this.f2181z = cursor.getColumnIndex("suggest_icon_2");
                this.A = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e3) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e3);
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public Cursor b(CharSequence charSequence) {
        String string = charSequence == null ? "" : charSequence.toString();
        if (this.f2169n.getVisibility() == 0 && this.f2169n.getWindowVisibility() == 0) {
            try {
                Cursor cursorU = u(this.f2170o, string, 50);
                if (cursorU != null) {
                    cursorU.getCount();
                    return cursorU;
                }
            } catch (RuntimeException e3) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e3);
            }
        }
        return null;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor cursor) {
        String strN;
        String strN2;
        if (cursor == null) {
            return null;
        }
        String strN3 = n(cursor, "suggest_intent_query");
        if (strN3 != null) {
            return strN3;
        }
        if (this.f2170o.shouldRewriteQueryFromData() && (strN2 = n(cursor, "suggest_intent_data")) != null) {
            return strN2;
        }
        if (!this.f2170o.shouldRewriteQueryFromText() || (strN = n(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return strN;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void d(View view, Context context, Cursor cursor) {
        ChildViewCache childViewCache = (ChildViewCache) view.getTag();
        int i3 = this.A;
        int i4 = i3 != -1 ? cursor.getInt(i3) : 0;
        if (childViewCache.f2182a != null) {
            y(childViewCache.f2182a, v(cursor, this.f2177v));
        }
        if (childViewCache.f2183b != null) {
            String strV = v(cursor, this.f2179x);
            CharSequence charSequenceK = strV != null ? k(strV) : v(cursor, this.f2178w);
            if (TextUtils.isEmpty(charSequenceK)) {
                TextView textView = childViewCache.f2182a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    childViewCache.f2182a.setMaxLines(2);
                }
            } else {
                TextView textView2 = childViewCache.f2182a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    childViewCache.f2182a.setMaxLines(1);
                }
            }
            y(childViewCache.f2183b, charSequenceK);
        }
        ImageView imageView = childViewCache.f2184c;
        if (imageView != null) {
            x(imageView, s(cursor), 4);
        }
        ImageView imageView2 = childViewCache.f2185d;
        if (imageView2 != null) {
            x(imageView2, t(cursor), 8);
        }
        int i5 = this.f2175t;
        if (i5 != 2 && (i5 != 1 || (i4 & 1) == 0)) {
            childViewCache.f2186e.setVisibility(8);
            return;
        }
        childViewCache.f2186e.setVisibility(0);
        childViewCache.f2186e.setTag(childViewCache.f2182a.getText());
        childViewCache.f2186e.setOnClickListener(this);
    }

    @Override // androidx.cursoradapter.widget.ResourceCursorAdapter, androidx.cursoradapter.widget.CursorAdapter
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewG = super.g(context, cursor, viewGroup);
        viewG.setTag(new ChildViewCache(viewG));
        ((ImageView) viewG.findViewById(androidx.appcompat.R.id.f751s)).setImageResource(this.f2173r);
        return viewG;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i3, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i3, view, viewGroup);
        } catch (RuntimeException e3) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e3);
            View viewF = f(this.f2171p, c(), viewGroup);
            if (viewF != null) {
                ((ChildViewCache) viewF.getTag()).f2182a.setText(e3.toString());
            }
            return viewF;
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i3, view, viewGroup);
        } catch (RuntimeException e3) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e3);
            View viewG = g(this.f2171p, c(), viewGroup);
            if (viewG != null) {
                ((ChildViewCache) viewG.getTag()).f2182a.setText(e3.toString());
            }
            return viewG;
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        A(c());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        A(c());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f2169n.V((CharSequence) tag);
        }
    }

    Drawable q(Uri uri) throws FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f2171p.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (identifier != 0) {
                return resourcesForApplication.getDrawable(identifier);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    Cursor u(SearchableInfo searchableInfo, String str, int i3) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme(AppLovinEventTypes.USER_VIEWED_CONTENT).authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i3 > 0) {
            builderFragment.appendQueryParameter("limit", String.valueOf(i3));
        }
        return this.f2171p.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }

    public void w(int i3) {
        this.f2175t = i3;
    }
}
