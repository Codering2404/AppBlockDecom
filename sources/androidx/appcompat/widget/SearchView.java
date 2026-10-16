package androidx.appcompat.widget;

import android.R;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.view.ViewCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.customview.view.AbsSavedState;
import com.applovin.sdk.AppLovinEventParameters;
import com.facebook.internal.NativeProtocol;
import com.sun.jna.Function;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    static final PreQAutoCompleteTextViewReflector f2104r0;
    private Rect A;
    private Rect B;
    private int[] C;
    private int[] D;
    private final ImageView E;
    private final Drawable F;
    private final int G;
    private final int H;
    private final Intent I;
    private final Intent J;
    private final CharSequence K;
    private OnQueryTextListener L;
    private OnCloseListener M;
    View.OnFocusChangeListener N;
    private OnSuggestionListener O;
    private View.OnClickListener P;
    private boolean Q;
    private boolean R;
    CursorAdapter S;
    private boolean T;
    private CharSequence U;
    private boolean V;
    private boolean W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private int f2105a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private boolean f2106b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private CharSequence f2107c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private CharSequence f2108d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private boolean f2109e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private int f2110f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    SearchableInfo f2111g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private Bundle f2112h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private final Runnable f2113i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private Runnable f2114j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final WeakHashMap f2115k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private final View.OnClickListener f2116l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    View.OnKeyListener f2117m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private final TextView.OnEditorActionListener f2118n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private final AdapterView.OnItemClickListener f2119o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private final AdapterView.OnItemSelectedListener f2120p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final SearchAutoComplete f2121q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private TextWatcher f2122q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final View f2123r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final View f2124s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final View f2125t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final ImageView f2126u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final ImageView f2127v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final ImageView f2128w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    final ImageView f2129x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final View f2130y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private UpdatableTouchDelegate f2131z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api29Impl {
        static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        static void b(SearchAutoComplete searchAutoComplete, int i3) {
            searchAutoComplete.setInputMethodMode(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f2142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2143b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f2144c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f2145d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f2146e;

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void readProperties(SearchView searchView, PropertyReader propertyReader) {
            if (!this.f2142a) {
                throw c.a();
            }
            propertyReader.readInt(this.f2143b, searchView.getImeOptions());
            propertyReader.readInt(this.f2144c, searchView.getMaxWidth());
            propertyReader.readBoolean(this.f2145d, searchView.L());
            propertyReader.readObject(this.f2146e, searchView.getQueryHint());
        }

        public void mapProperties(PropertyMapper propertyMapper) {
            this.f2143b = propertyMapper.mapInt("imeOptions", R.attr.imeOptions);
            this.f2144c = propertyMapper.mapInt("maxWidth", R.attr.maxWidth);
            this.f2145d = propertyMapper.mapBoolean("iconifiedByDefault", androidx.appcompat.R.attr.f632a0);
            this.f2146e = propertyMapper.mapObject("queryHint", androidx.appcompat.R.attr.f656m0);
            this.f2142a = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnCloseListener {
        boolean onClose();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnQueryTextListener {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnSuggestionListener {
        boolean onSuggestionClick(int i3);

        boolean onSuggestionSelect(int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PreQAutoCompleteTextViewReflector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Method f2147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Method f2148b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Method f2149c;

        PreQAutoCompleteTextViewReflector() {
            this.f2147a = null;
            this.f2148b = null;
            this.f2149c = null;
            d();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);
                this.f2147a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);
                this.f2148b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f2149c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        private static void d() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f2148b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, null);
                } catch (Exception unused) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f2147a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, null);
                } catch (Exception unused) {
                }
            }
        }

        void c(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f2149c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.appcompat.widget.SearchView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f2150c;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f2150c + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeValue(Boolean.valueOf(this.f2150c));
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2150c = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f2151f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private SearchView f2152g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f2153h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final Runnable f2154i;

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, androidx.appcompat.R.attr.f663q);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i3 = configuration.screenWidthDp;
            int i4 = configuration.screenHeightDp;
            if (i3 >= 960 && i4 >= 720 && configuration.orientation == 2) {
                return Function.MAX_NARGS;
            }
            if (i3 < 600) {
                return (i3 < 640 || i4 < 480) ? 160 : 192;
            }
            return 192;
        }

        void b() {
            if (Build.VERSION.SDK_INT < 29) {
                SearchView.f2104r0.c(this);
                return;
            }
            Api29Impl.b(this, 1);
            if (enoughToFilter()) {
                showDropDown();
            }
        }

        boolean c() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        void d() {
            if (this.f2153h) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f2153h = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f2151f <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f2153h) {
                removeCallbacks(this.f2154i);
                post(this.f2154i);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z2, int i3, Rect rect) {
            super.onFocusChanged(z2, i3, rect);
            this.f2152g.a0();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i3, KeyEvent keyEvent) {
            if (i3 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f2152g.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i3, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z2) {
            super.onWindowFocusChanged(z2);
            if (z2 && this.f2152g.hasFocus() && getVisibility() == 0) {
                this.f2153h = true;
                if (SearchView.N(getContext())) {
                    b();
                }
            }
        }

        void setImeVisibility(boolean z2) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z2) {
                this.f2153h = false;
                removeCallbacks(this.f2154i);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f2153h = true;
                    return;
                }
                this.f2153h = false;
                removeCallbacks(this.f2154i);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        void setSearchView(SearchView searchView) {
            this.f2152g = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i3) {
            super.setThreshold(i3);
            this.f2151f = i3;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i3) {
            super(context, attributeSet, i3);
            this.f2154i = new Runnable() { // from class: androidx.appcompat.widget.SearchView.SearchAutoComplete.1
                @Override // java.lang.Runnable
                public void run() {
                    SearchAutoComplete.this.d();
                }
            };
            this.f2151f = getThreshold();
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class UpdatableTouchDelegate extends TouchDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f2156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Rect f2157b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Rect f2158c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Rect f2159d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f2160e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f2161f;

        public UpdatableTouchDelegate(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f2160e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f2157b = new Rect();
            this.f2159d = new Rect();
            this.f2158c = new Rect();
            a(rect, rect2);
            this.f2156a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f2157b.set(rect);
            this.f2159d.set(rect);
            Rect rect3 = this.f2159d;
            int i3 = this.f2160e;
            rect3.inset(-i3, -i3);
            this.f2158c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z2;
            boolean z3;
            int x2 = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z4 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z3 = this.f2161f;
                    if (z3 && !this.f2159d.contains(x2, y2)) {
                        z4 = z3;
                        z2 = false;
                    }
                } else {
                    if (action == 3) {
                        z3 = this.f2161f;
                        this.f2161f = false;
                    }
                    z2 = true;
                    z4 = false;
                }
                z4 = z3;
                z2 = true;
            } else if (this.f2157b.contains(x2, y2)) {
                this.f2161f = true;
                z2 = true;
            } else {
                z2 = true;
                z4 = false;
            }
            if (!z4) {
                return false;
            }
            if (!z2 || this.f2158c.contains(x2, y2)) {
                Rect rect = this.f2158c;
                motionEvent.setLocation(x2 - rect.left, y2 - rect.top);
            } else {
                motionEvent.setLocation(this.f2156a.getWidth() / 2, this.f2156a.getHeight() / 2);
            }
            return this.f2156a.dispatchTouchEvent(motionEvent);
        }
    }

    static {
        f2104r0 = Build.VERSION.SDK_INT < 29 ? new PreQAutoCompleteTextViewReflector() : null;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private Intent C(String str, Uri uri, String str2, String str3, int i3, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f2108d0);
        if (str3 != null) {
            intent.putExtra(AppLovinEventParameters.SEARCH_QUERY, str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f2112h0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i3 != 0) {
            intent.putExtra("action_key", i3);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f2111g0.getSearchActivity());
        return intent;
    }

    private Intent D(Cursor cursor, int i3, String str) {
        int position;
        String strN;
        try {
            String strN2 = SuggestionsAdapter.n(cursor, "suggest_intent_action");
            if (strN2 == null) {
                strN2 = this.f2111g0.getSuggestIntentAction();
            }
            if (strN2 == null) {
                strN2 = "android.intent.action.SEARCH";
            }
            String str2 = strN2;
            String strN3 = SuggestionsAdapter.n(cursor, "suggest_intent_data");
            if (strN3 == null) {
                strN3 = this.f2111g0.getSuggestIntentData();
            }
            if (strN3 != null && (strN = SuggestionsAdapter.n(cursor, "suggest_intent_data_id")) != null) {
                strN3 = strN3 + "/" + Uri.encode(strN);
            }
            return C(str2, strN3 == null ? null : Uri.parse(strN3), SuggestionsAdapter.n(cursor, "suggest_intent_extra_data"), SuggestionsAdapter.n(cursor, "suggest_intent_query"), i3, str);
        } catch (RuntimeException e3) {
            try {
                position = cursor.getPosition();
            } catch (RuntimeException unused) {
                position = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e3);
            return null;
        }
    }

    private Intent E(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f2112h0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent F(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private void G() {
        this.f2121q.dismissDropDown();
    }

    private void I(View view, Rect rect) {
        view.getLocationInWindow(this.C);
        getLocationInWindow(this.D);
        int[] iArr = this.C;
        int i3 = iArr[1];
        int[] iArr2 = this.D;
        int i4 = i3 - iArr2[1];
        int i5 = iArr[0] - iArr2[0];
        rect.set(i5, i4, view.getWidth() + i5, view.getHeight() + i4);
    }

    private CharSequence J(CharSequence charSequence) {
        if (!this.Q || this.F == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f2121q.getTextSize()) * 1.25d);
        this.F.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.F), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private boolean K() {
        SearchableInfo searchableInfo = this.f2111g0;
        if (searchableInfo != null && searchableInfo.getVoiceSearchEnabled()) {
            Intent intent = this.f2111g0.getVoiceSearchLaunchWebSearch() ? this.I : this.f2111g0.getVoiceSearchLaunchRecognizer() ? this.J : null;
            if (intent != null && getContext().getPackageManager().resolveActivity(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != null) {
                return true;
            }
        }
        return false;
    }

    static boolean N(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private boolean O() {
        return (this.T || this.f2106b0) && !M();
    }

    private void P(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e3) {
            Log.e("SearchView", "Failed launch activity: " + intent, e3);
        }
    }

    private boolean R(int i3, int i4, String str) {
        Cursor cursorC = this.S.c();
        if (cursorC == null || !cursorC.moveToPosition(i3)) {
            return false;
        }
        P(D(cursorC, i4, str));
        return true;
    }

    private void c0() {
        post(this.f2113i0);
    }

    private void d0(int i3) {
        Editable text = this.f2121q.getText();
        Cursor cursorC = this.S.c();
        if (cursorC == null) {
            return;
        }
        if (!cursorC.moveToPosition(i3)) {
            setQuery(text);
            return;
        }
        CharSequence charSequenceConvertToString = this.S.convertToString(cursorC);
        if (charSequenceConvertToString != null) {
            setQuery(charSequenceConvertToString);
        } else {
            setQuery(text);
        }
    }

    private void f0() {
        boolean zIsEmpty = TextUtils.isEmpty(this.f2121q.getText());
        this.f2128w.setVisibility(!zIsEmpty || (this.Q && !this.f2109e0) ? 0 : 8);
        Drawable drawable = this.f2128w.getDrawable();
        if (drawable != null) {
            drawable.setState(!zIsEmpty ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(androidx.appcompat.R.dimen.f698g);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(androidx.appcompat.R.dimen.f699h);
    }

    private void h0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f2121q;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(J(queryHint));
    }

    private void i0() {
        this.f2121q.setThreshold(this.f2111g0.getSuggestThreshold());
        this.f2121q.setImeOptions(this.f2111g0.getImeOptions());
        int inputType = this.f2111g0.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f2111g0.getSuggestAuthority() != null) {
                inputType |= 589824;
            }
        }
        this.f2121q.setInputType(inputType);
        CursorAdapter cursorAdapter = this.S;
        if (cursorAdapter != null) {
            cursorAdapter.a(null);
        }
        if (this.f2111g0.getSuggestAuthority() != null) {
            SuggestionsAdapter suggestionsAdapter = new SuggestionsAdapter(getContext(), this, this.f2111g0, this.f2115k0);
            this.S = suggestionsAdapter;
            this.f2121q.setAdapter(suggestionsAdapter);
            ((SuggestionsAdapter) this.S).w(this.V ? 2 : 1);
        }
    }

    private void j0() {
        this.f2125t.setVisibility((O() && (this.f2127v.getVisibility() == 0 || this.f2129x.getVisibility() == 0)) ? 0 : 8);
    }

    private void k0(boolean z2) {
        this.f2127v.setVisibility((this.T && O() && hasFocus() && (z2 || !this.f2106b0)) ? 0 : 8);
    }

    private void l0(boolean z2) {
        this.R = z2;
        int i3 = 8;
        int i4 = z2 ? 0 : 8;
        boolean zIsEmpty = TextUtils.isEmpty(this.f2121q.getText());
        this.f2126u.setVisibility(i4);
        k0(!zIsEmpty);
        this.f2123r.setVisibility(z2 ? 8 : 0);
        if (this.E.getDrawable() != null && !this.Q) {
            i3 = 0;
        }
        this.E.setVisibility(i3);
        f0();
        m0(zIsEmpty);
        j0();
    }

    private void m0(boolean z2) {
        int i3 = 8;
        if (this.f2106b0 && !M() && z2) {
            this.f2127v.setVisibility(8);
            i3 = 0;
        }
        this.f2129x.setVisibility(i3);
    }

    private void setQuery(CharSequence charSequence) {
        this.f2121q.setText(charSequence);
        this.f2121q.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    void B() {
        if (this.f2130y.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f2124s.getPaddingLeft();
            Rect rect = new Rect();
            boolean zB = ViewUtils.b(this);
            int dimensionPixelSize = this.Q ? resources.getDimensionPixelSize(androidx.appcompat.R.dimen.f696e) + resources.getDimensionPixelSize(androidx.appcompat.R.dimen.f697f) : 0;
            this.f2121q.getDropDownBackground().getPadding(rect);
            this.f2121q.setDropDownHorizontalOffset(zB ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.f2121q.setDropDownWidth((((this.f2130y.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    void H() {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.a(this.f2121q);
            return;
        }
        PreQAutoCompleteTextViewReflector preQAutoCompleteTextViewReflector = f2104r0;
        preQAutoCompleteTextViewReflector.b(this.f2121q);
        preQAutoCompleteTextViewReflector.a(this.f2121q);
    }

    public boolean L() {
        return this.Q;
    }

    public boolean M() {
        return this.R;
    }

    void Q(int i3, String str, String str2) {
        getContext().startActivity(C("android.intent.action.SEARCH", null, null, str2, i3, str));
    }

    void S() {
        if (!TextUtils.isEmpty(this.f2121q.getText())) {
            this.f2121q.setText("");
            this.f2121q.requestFocus();
            this.f2121q.setImeVisibility(true);
        } else if (this.Q) {
            OnCloseListener onCloseListener = this.M;
            if (onCloseListener == null || !onCloseListener.onClose()) {
                clearFocus();
                l0(true);
            }
        }
    }

    boolean T(int i3, int i4, String str) {
        OnSuggestionListener onSuggestionListener = this.O;
        if (onSuggestionListener != null && onSuggestionListener.onSuggestionClick(i3)) {
            return false;
        }
        R(i3, 0, null);
        this.f2121q.setImeVisibility(false);
        G();
        return true;
    }

    boolean U(int i3) {
        OnSuggestionListener onSuggestionListener = this.O;
        if (onSuggestionListener != null && onSuggestionListener.onSuggestionSelect(i3)) {
            return false;
        }
        d0(i3);
        return true;
    }

    protected void V(CharSequence charSequence) {
        setQuery(charSequence);
    }

    void W() {
        l0(false);
        this.f2121q.requestFocus();
        this.f2121q.setImeVisibility(true);
        View.OnClickListener onClickListener = this.P;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    void X() {
        Editable text = this.f2121q.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        OnQueryTextListener onQueryTextListener = this.L;
        if (onQueryTextListener == null || !onQueryTextListener.onQueryTextSubmit(text.toString())) {
            if (this.f2111g0 != null) {
                Q(0, null, text.toString());
            }
            this.f2121q.setImeVisibility(false);
            G();
        }
    }

    boolean Y(View view, int i3, KeyEvent keyEvent) {
        if (this.f2111g0 != null && this.S != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i3 == 66 || i3 == 84 || i3 == 61) {
                return T(this.f2121q.getListSelection(), 0, null);
            }
            if (i3 == 21 || i3 == 22) {
                this.f2121q.setSelection(i3 == 21 ? 0 : this.f2121q.length());
                this.f2121q.setListSelection(0);
                this.f2121q.clearListSelection();
                this.f2121q.b();
                return true;
            }
            if (i3 == 19) {
                this.f2121q.getListSelection();
                return false;
            }
        }
        return false;
    }

    void Z(CharSequence charSequence) {
        Editable text = this.f2121q.getText();
        this.f2108d0 = text;
        boolean zIsEmpty = TextUtils.isEmpty(text);
        k0(!zIsEmpty);
        m0(zIsEmpty);
        f0();
        j0();
        if (this.L != null && !TextUtils.equals(charSequence, this.f2107c0)) {
            this.L.onQueryTextChange(charSequence.toString());
        }
        this.f2107c0 = charSequence.toString();
    }

    void a0() {
        l0(M());
        c0();
        if (this.f2121q.hasFocus()) {
            H();
        }
    }

    void b0() {
        SearchableInfo searchableInfo = this.f2111g0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(F(this.I, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(E(this.J, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.W = true;
        super.clearFocus();
        this.f2121q.clearFocus();
        this.f2121q.setImeVisibility(false);
        this.W = false;
    }

    public void e0(CharSequence charSequence, boolean z2) {
        this.f2121q.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f2121q;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f2108d0 = charSequence;
        }
        if (!z2 || TextUtils.isEmpty(charSequence)) {
            return;
        }
        X();
    }

    void g0() {
        int[] iArr = this.f2121q.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f2124s.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f2125t.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public int getImeOptions() {
        return this.f2121q.getImeOptions();
    }

    public int getInputType() {
        return this.f2121q.getInputType();
    }

    public int getMaxWidth() {
        return this.f2105a0;
    }

    public CharSequence getQuery() {
        return this.f2121q.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.U;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f2111g0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.K : getContext().getText(this.f2111g0.getHintId());
    }

    int getSuggestionCommitIconResId() {
        return this.H;
    }

    int getSuggestionRowLayout() {
        return this.G;
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.S;
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewCollapsed() {
        e0("", false);
        clearFocus();
        l0(true);
        this.f2121q.setImeOptions(this.f2110f0);
        this.f2109e0 = false;
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewExpanded() {
        if (this.f2109e0) {
            return;
        }
        this.f2109e0 = true;
        int imeOptions = this.f2121q.getImeOptions();
        this.f2110f0 = imeOptions;
        this.f2121q.setImeOptions(imeOptions | 33554432);
        this.f2121q.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f2113i0);
        post(this.f2114j0);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        if (z2) {
            I(this.f2121q, this.A);
            Rect rect = this.B;
            Rect rect2 = this.A;
            rect.set(rect2.left, 0, rect2.right, i6 - i4);
            UpdatableTouchDelegate updatableTouchDelegate = this.f2131z;
            if (updatableTouchDelegate != null) {
                updatableTouchDelegate.a(this.B, this.A);
                return;
            }
            UpdatableTouchDelegate updatableTouchDelegate2 = new UpdatableTouchDelegate(this.B, this.A, this.f2121q);
            this.f2131z = updatableTouchDelegate2;
            setTouchDelegate(updatableTouchDelegate2);
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i3, int i4) {
        int i5;
        if (M()) {
            super.onMeasure(i3, i4);
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            int i6 = this.f2105a0;
            size = i6 > 0 ? Math.min(i6, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f2105a0;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i5 = this.f2105a0) > 0) {
            size = Math.min(i5, size);
        }
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.c());
        l0(savedState.f2150c);
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2150c = M();
        return savedState;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        c0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i3, Rect rect) {
        if (this.W || !isFocusable()) {
            return false;
        }
        if (M()) {
            return super.requestFocus(i3, rect);
        }
        boolean zRequestFocus = this.f2121q.requestFocus(i3, rect);
        if (zRequestFocus) {
            l0(false);
        }
        return zRequestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f2112h0 = bundle;
    }

    public void setIconified(boolean z2) {
        if (z2) {
            S();
        } else {
            W();
        }
    }

    public void setIconifiedByDefault(boolean z2) {
        if (this.Q == z2) {
            return;
        }
        this.Q = z2;
        l0(z2);
        h0();
    }

    public void setImeOptions(int i3) {
        this.f2121q.setImeOptions(i3);
    }

    public void setInputType(int i3) {
        this.f2121q.setInputType(i3);
    }

    public void setMaxWidth(int i3) {
        this.f2105a0 = i3;
        requestLayout();
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.M = onCloseListener;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.N = onFocusChangeListener;
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        this.L = onQueryTextListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.P = onClickListener;
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
        this.O = onSuggestionListener;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.U = charSequence;
        h0();
    }

    public void setQueryRefinementEnabled(boolean z2) {
        this.V = z2;
        CursorAdapter cursorAdapter = this.S;
        if (cursorAdapter instanceof SuggestionsAdapter) {
            ((SuggestionsAdapter) cursorAdapter).w(z2 ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f2111g0 = searchableInfo;
        if (searchableInfo != null) {
            i0();
            h0();
        }
        boolean zK = K();
        this.f2106b0 = zK;
        if (zK) {
            this.f2121q.setPrivateImeOptions("nm");
        }
        l0(M());
    }

    public void setSubmitButtonEnabled(boolean z2) {
        this.T = z2;
        l0(M());
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.S = cursorAdapter;
        this.f2121q.setAdapter(cursorAdapter);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.f662p0);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.A = new Rect();
        this.B = new Rect();
        this.C = new int[2];
        this.D = new int[2];
        this.f2113i0 = new Runnable() { // from class: androidx.appcompat.widget.SearchView.1
            @Override // java.lang.Runnable
            public void run() {
                SearchView.this.g0();
            }
        };
        this.f2114j0 = new Runnable() { // from class: androidx.appcompat.widget.SearchView.2
            @Override // java.lang.Runnable
            public void run() {
                CursorAdapter cursorAdapter = SearchView.this.S;
                if (cursorAdapter instanceof SuggestionsAdapter) {
                    cursorAdapter.a(null);
                }
            }
        };
        this.f2115k0 = new WeakHashMap();
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: androidx.appcompat.widget.SearchView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchView searchView = SearchView.this;
                if (view == searchView.f2126u) {
                    searchView.W();
                    return;
                }
                if (view == searchView.f2128w) {
                    searchView.S();
                    return;
                }
                if (view == searchView.f2127v) {
                    searchView.X();
                } else if (view == searchView.f2129x) {
                    searchView.b0();
                } else if (view == searchView.f2121q) {
                    searchView.H();
                }
            }
        };
        this.f2116l0 = onClickListener;
        this.f2117m0 = new View.OnKeyListener() { // from class: androidx.appcompat.widget.SearchView.6
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i4, KeyEvent keyEvent) {
                SearchView searchView = SearchView.this;
                if (searchView.f2111g0 == null) {
                    return false;
                }
                if (searchView.f2121q.isPopupShowing() && SearchView.this.f2121q.getListSelection() != -1) {
                    return SearchView.this.Y(view, i4, keyEvent);
                }
                if (SearchView.this.f2121q.c() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i4 != 66) {
                    return false;
                }
                view.cancelLongPress();
                SearchView searchView2 = SearchView.this;
                searchView2.Q(0, null, searchView2.f2121q.getText().toString());
                return true;
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: androidx.appcompat.widget.SearchView.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i4, KeyEvent keyEvent) {
                SearchView.this.X();
                return true;
            }
        };
        this.f2118n0 = onEditorActionListener;
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.widget.SearchView.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i4, long j3) {
                SearchView.this.T(i4, 0, null);
            }
        };
        this.f2119o0 = onItemClickListener;
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.SearchView.9
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView adapterView, View view, int i4, long j3) {
                SearchView.this.U(i4);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView adapterView) {
            }
        };
        this.f2120p0 = onItemSelectedListener;
        this.f2122q0 = new TextWatcher() { // from class: androidx.appcompat.widget.SearchView.10
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                SearchView.this.Z(charSequence);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            }
        };
        int[] iArr = androidx.appcompat.R.styleable.f868p2;
        TintTypedArray tintTypedArrayV = TintTypedArray.v(context, attributeSet, iArr, i3, 0);
        ViewCompat.k0(this, context, iArr, attributeSet, tintTypedArrayV.r(), i3, 0);
        LayoutInflater.from(context).inflate(tintTypedArrayV.n(androidx.appcompat.R.styleable.z2, androidx.appcompat.R.layout.f778t), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(androidx.appcompat.R.id.J);
        this.f2121q = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f2123r = findViewById(androidx.appcompat.R.id.F);
        View viewFindViewById = findViewById(androidx.appcompat.R.id.I);
        this.f2124s = viewFindViewById;
        View viewFindViewById2 = findViewById(androidx.appcompat.R.id.P);
        this.f2125t = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(androidx.appcompat.R.id.D);
        this.f2126u = imageView;
        ImageView imageView2 = (ImageView) findViewById(androidx.appcompat.R.id.G);
        this.f2127v = imageView2;
        ImageView imageView3 = (ImageView) findViewById(androidx.appcompat.R.id.E);
        this.f2128w = imageView3;
        ImageView imageView4 = (ImageView) findViewById(androidx.appcompat.R.id.K);
        this.f2129x = imageView4;
        ImageView imageView5 = (ImageView) findViewById(androidx.appcompat.R.id.H);
        this.E = imageView5;
        ViewCompat.q0(viewFindViewById, tintTypedArrayV.g(androidx.appcompat.R.styleable.A2));
        ViewCompat.q0(viewFindViewById2, tintTypedArrayV.g(androidx.appcompat.R.styleable.E2));
        int i4 = androidx.appcompat.R.styleable.D2;
        imageView.setImageDrawable(tintTypedArrayV.g(i4));
        imageView2.setImageDrawable(tintTypedArrayV.g(androidx.appcompat.R.styleable.x2));
        imageView3.setImageDrawable(tintTypedArrayV.g(androidx.appcompat.R.styleable.u2));
        imageView4.setImageDrawable(tintTypedArrayV.g(androidx.appcompat.R.styleable.G2));
        imageView5.setImageDrawable(tintTypedArrayV.g(i4));
        this.F = tintTypedArrayV.g(androidx.appcompat.R.styleable.C2);
        TooltipCompat.a(imageView, getResources().getString(androidx.appcompat.R.string.f796p));
        this.G = tintTypedArrayV.n(androidx.appcompat.R.styleable.F2, androidx.appcompat.R.layout.f777s);
        this.H = tintTypedArrayV.n(androidx.appcompat.R.styleable.v2, 0);
        imageView.setOnClickListener(onClickListener);
        imageView3.setOnClickListener(onClickListener);
        imageView2.setOnClickListener(onClickListener);
        imageView4.setOnClickListener(onClickListener);
        searchAutoComplete.setOnClickListener(onClickListener);
        searchAutoComplete.addTextChangedListener(this.f2122q0);
        searchAutoComplete.setOnEditorActionListener(onEditorActionListener);
        searchAutoComplete.setOnItemClickListener(onItemClickListener);
        searchAutoComplete.setOnItemSelectedListener(onItemSelectedListener);
        searchAutoComplete.setOnKeyListener(this.f2117m0);
        searchAutoComplete.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: androidx.appcompat.widget.SearchView.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z2) {
                SearchView searchView = SearchView.this;
                View.OnFocusChangeListener onFocusChangeListener = searchView.N;
                if (onFocusChangeListener != null) {
                    onFocusChangeListener.onFocusChange(searchView, z2);
                }
            }
        });
        setIconifiedByDefault(tintTypedArrayV.a(androidx.appcompat.R.styleable.y2, true));
        int iF = tintTypedArrayV.f(androidx.appcompat.R.styleable.r2, -1);
        if (iF != -1) {
            setMaxWidth(iF);
        }
        this.K = tintTypedArrayV.p(androidx.appcompat.R.styleable.w2);
        this.U = tintTypedArrayV.p(androidx.appcompat.R.styleable.B2);
        int iK = tintTypedArrayV.k(androidx.appcompat.R.styleable.t2, -1);
        if (iK != -1) {
            setImeOptions(iK);
        }
        int iK2 = tintTypedArrayV.k(androidx.appcompat.R.styleable.s2, -1);
        if (iK2 != -1) {
            setInputType(iK2);
        }
        setFocusable(tintTypedArrayV.a(androidx.appcompat.R.styleable.f872q2, true));
        tintTypedArrayV.x();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.I = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.J = intent2;
        intent2.addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f2130y = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.appcompat.widget.SearchView.4
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
                    SearchView.this.B();
                }
            });
        }
        l0(this.Q);
        h0();
    }
}
