package androidx.preference;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.preference.PreferenceManager;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Preference implements Comparable<Preference> {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private int G;
    private int H;
    private OnPreferenceChangeInternalListener I;
    private List J;
    private PreferenceGroup K;
    private boolean L;
    private boolean M;
    private OnPreferenceCopyListener N;
    private SummaryProvider O;
    private final View.OnClickListener P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f50819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PreferenceManager f50820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PreferenceDataStore f50821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f50822d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private OnPreferenceChangeListener f50823f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private OnPreferenceClickListener f50824g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f50825h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f50826i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CharSequence f50827j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CharSequence f50828k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f50829l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Drawable f50830m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f50831n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Intent f50832o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f50833p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Bundle f50834q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f50835r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f50836s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f50837t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f50838u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Object f50839v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f50840w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f50841x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f50842y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f50843z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class BaseSavedState extends AbsSavedState {
        public static final Parcelable.Creator<BaseSavedState> CREATOR = new Parcelable.Creator<BaseSavedState>() { // from class: androidx.preference.Preference.BaseSavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public BaseSavedState createFromParcel(Parcel parcel) {
                return new BaseSavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public BaseSavedState[] newArray(int i3) {
                return new BaseSavedState[i3];
            }
        };

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }

        public BaseSavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface OnPreferenceChangeInternalListener {
        void c(Preference preference);

        void d(Preference preference);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnPreferenceChangeListener {
        boolean a(Preference preference, Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnPreferenceClickListener {
        boolean a(Preference preference);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class OnPreferenceCopyListener implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Preference f50845a;

        OnPreferenceCopyListener(Preference preference) {
            this.f50845a = preference;
        }

        @Override // android.view.View.OnCreateContextMenuListener
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            CharSequence charSequenceX = this.f50845a.x();
            if (!this.f50845a.C() || TextUtils.isEmpty(charSequenceX)) {
                return;
            }
            contextMenu.setHeaderTitle(charSequenceX);
            contextMenu.add(0, 0, 0, R.string.f50987a).setOnMenuItemClickListener(this);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            ClipboardManager clipboardManager = (ClipboardManager) this.f50845a.h().getSystemService("clipboard");
            CharSequence charSequenceX = this.f50845a.x();
            clipboardManager.setPrimaryClip(ClipData.newPlainText("Preference", charSequenceX));
            Toast.makeText(this.f50845a.h(), this.f50845a.h().getString(R.string.f50990d, charSequenceX), 0).show();
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface SummaryProvider<T extends Preference> {
        CharSequence a(Preference preference);
    }

    public Preference(Context context, AttributeSet attributeSet, int i3, int i4) {
        this.f50825h = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f50826i = 0;
        this.f50835r = true;
        this.f50836s = true;
        this.f50837t = true;
        this.f50840w = true;
        this.f50841x = true;
        this.f50842y = true;
        this.f50843z = true;
        this.A = true;
        this.C = true;
        this.F = true;
        int i5 = R.layout.f50984b;
        this.G = i5;
        this.P = new View.OnClickListener() { // from class: androidx.preference.Preference.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Preference.this.b0(view);
            }
        };
        this.f50819a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.J, i3, i4);
        this.f50829l = TypedArrayUtils.l(typedArrayObtainStyledAttributes, R.styleable.f51015h0, R.styleable.K, 0);
        this.f50831n = TypedArrayUtils.m(typedArrayObtainStyledAttributes, R.styleable.f51024k0, R.styleable.Q);
        this.f50827j = TypedArrayUtils.n(typedArrayObtainStyledAttributes, R.styleable.f51044s0, R.styleable.O);
        this.f50828k = TypedArrayUtils.n(typedArrayObtainStyledAttributes, R.styleable.f51042r0, R.styleable.R);
        this.f50825h = TypedArrayUtils.d(typedArrayObtainStyledAttributes, R.styleable.f51030m0, R.styleable.S, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        this.f50833p = TypedArrayUtils.m(typedArrayObtainStyledAttributes, R.styleable.f51012g0, R.styleable.X);
        this.G = TypedArrayUtils.l(typedArrayObtainStyledAttributes, R.styleable.f51027l0, R.styleable.N, i5);
        this.H = TypedArrayUtils.l(typedArrayObtainStyledAttributes, R.styleable.f51046t0, R.styleable.T, 0);
        this.f50835r = TypedArrayUtils.b(typedArrayObtainStyledAttributes, R.styleable.f51009f0, R.styleable.M, true);
        this.f50836s = TypedArrayUtils.b(typedArrayObtainStyledAttributes, R.styleable.f51036o0, R.styleable.P, true);
        this.f50837t = TypedArrayUtils.b(typedArrayObtainStyledAttributes, R.styleable.f51033n0, R.styleable.L, true);
        this.f50838u = TypedArrayUtils.m(typedArrayObtainStyledAttributes, R.styleable.f51003d0, R.styleable.U);
        int i6 = R.styleable.f50994a0;
        this.f50843z = TypedArrayUtils.b(typedArrayObtainStyledAttributes, i6, i6, this.f50836s);
        int i7 = R.styleable.f50997b0;
        this.A = TypedArrayUtils.b(typedArrayObtainStyledAttributes, i7, i7, this.f50836s);
        int i8 = R.styleable.f51000c0;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            this.f50839v = U(typedArrayObtainStyledAttributes, i8);
        } else {
            int i9 = R.styleable.V;
            if (typedArrayObtainStyledAttributes.hasValue(i9)) {
                this.f50839v = U(typedArrayObtainStyledAttributes, i9);
            }
        }
        this.F = TypedArrayUtils.b(typedArrayObtainStyledAttributes, R.styleable.f51038p0, R.styleable.W, true);
        int i10 = R.styleable.f51040q0;
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i10);
        this.B = zHasValue;
        if (zHasValue) {
            this.C = TypedArrayUtils.b(typedArrayObtainStyledAttributes, i10, R.styleable.Y, true);
        }
        this.D = TypedArrayUtils.b(typedArrayObtainStyledAttributes, R.styleable.f51018i0, R.styleable.Z, false);
        int i11 = R.styleable.f51021j0;
        this.f50842y = TypedArrayUtils.b(typedArrayObtainStyledAttributes, i11, i11, true);
        int i12 = R.styleable.f51006e0;
        this.E = TypedArrayUtils.b(typedArrayObtainStyledAttributes, i12, i12, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void A0(SharedPreferences.Editor editor) {
        if (this.f50820b.p()) {
            editor.apply();
        }
    }

    private void B0() {
        Preference preferenceG;
        String str = this.f50838u;
        if (str == null || (preferenceG = g(str)) == null) {
            return;
        }
        preferenceG.C0(this);
    }

    private void C0(Preference preference) {
        List list = this.J;
        if (list != null) {
            list.remove(preference);
        }
    }

    private void g0() {
        if (TextUtils.isEmpty(this.f50838u)) {
            return;
        }
        Preference preferenceG = g(this.f50838u);
        if (preferenceG != null) {
            preferenceG.h0(this);
            return;
        }
        throw new IllegalStateException("Dependency \"" + this.f50838u + "\" not found for preference \"" + this.f50831n + "\" (title: \"" + ((Object) this.f50827j) + "\"");
    }

    private void h0(Preference preference) {
        if (this.J == null) {
            this.J = new ArrayList();
        }
        this.J.add(preference);
        preference.S(this, x0());
    }

    private void l0(View view, boolean z2) {
        view.setEnabled(z2);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                l0(viewGroup.getChildAt(childCount), z2);
            }
        }
    }

    public final int A() {
        return this.H;
    }

    public boolean B() {
        return !TextUtils.isEmpty(this.f50831n);
    }

    public boolean C() {
        return this.E;
    }

    public boolean D() {
        return this.f50835r && this.f50840w && this.f50841x;
    }

    final boolean D0() {
        return this.L;
    }

    public boolean E() {
        return this.f50837t;
    }

    public boolean F() {
        return this.f50836s;
    }

    public final boolean G() {
        return this.f50842y;
    }

    protected void H() {
        OnPreferenceChangeInternalListener onPreferenceChangeInternalListener = this.I;
        if (onPreferenceChangeInternalListener != null) {
            onPreferenceChangeInternalListener.c(this);
        }
    }

    public void I(boolean z2) {
        List list = this.J;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((Preference) list.get(i3)).S(this, z2);
        }
    }

    protected void O() {
        OnPreferenceChangeInternalListener onPreferenceChangeInternalListener = this.I;
        if (onPreferenceChangeInternalListener != null) {
            onPreferenceChangeInternalListener.d(this);
        }
    }

    public void P() {
        g0();
    }

    public void Q(PreferenceViewHolder preferenceViewHolder) {
        Integer numValueOf;
        View view = preferenceViewHolder.itemView;
        view.setOnClickListener(this.P);
        view.setId(this.f50826i);
        TextView textView = (TextView) preferenceViewHolder.b(android.R.id.summary);
        if (textView != null) {
            CharSequence charSequenceX = x();
            if (TextUtils.isEmpty(charSequenceX)) {
                textView.setVisibility(8);
                numValueOf = null;
            } else {
                textView.setText(charSequenceX);
                textView.setVisibility(0);
                numValueOf = Integer.valueOf(textView.getCurrentTextColor());
            }
        } else {
            numValueOf = null;
        }
        TextView textView2 = (TextView) preferenceViewHolder.b(android.R.id.title);
        if (textView2 != null) {
            CharSequence charSequenceZ = z();
            if (TextUtils.isEmpty(charSequenceZ)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(charSequenceZ);
                textView2.setVisibility(0);
                if (this.B) {
                    textView2.setSingleLine(this.C);
                }
                if (!F() && D() && numValueOf != null) {
                    textView2.setTextColor(numValueOf.intValue());
                }
            }
        }
        ImageView imageView = (ImageView) preferenceViewHolder.b(android.R.id.icon);
        if (imageView != null) {
            int i3 = this.f50829l;
            if (i3 != 0 || this.f50830m != null) {
                if (this.f50830m == null) {
                    this.f50830m = AppCompatResources.b(this.f50819a, i3);
                }
                Drawable drawable = this.f50830m;
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                }
            }
            if (this.f50830m != null) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(this.D ? 4 : 8);
            }
        }
        View viewB = preferenceViewHolder.b(R.id.f50972a);
        if (viewB == null) {
            viewB = preferenceViewHolder.b(android.R.id.icon_frame);
        }
        if (viewB != null) {
            if (this.f50830m != null) {
                viewB.setVisibility(0);
            } else {
                viewB.setVisibility(this.D ? 4 : 8);
            }
        }
        if (this.F) {
            l0(view, D());
        } else {
            l0(view, true);
        }
        boolean zF = F();
        view.setFocusable(zF);
        view.setClickable(zF);
        preferenceViewHolder.f(this.f50843z);
        preferenceViewHolder.g(this.A);
        boolean zC = C();
        if (zC && this.N == null) {
            this.N = new OnPreferenceCopyListener(this);
        }
        view.setOnCreateContextMenuListener(zC ? this.N : null);
        view.setLongClickable(zC);
        if (!zC || zF) {
            return;
        }
        ViewCompat.q0(view, null);
    }

    public void S(Preference preference, boolean z2) {
        if (this.f50840w == z2) {
            this.f50840w = !z2;
            I(x0());
            H();
        }
    }

    public void T() {
        B0();
        this.L = true;
    }

    protected Object U(TypedArray typedArray, int i3) {
        return null;
    }

    public void W(Preference preference, boolean z2) {
        if (this.f50841x == z2) {
            this.f50841x = !z2;
            I(x0());
            H();
        }
    }

    protected void X() {
        B0();
    }

    protected void Y(Parcelable parcelable) {
        this.M = true;
        if (parcelable != AbsSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    protected Parcelable Z() {
        this.M = true;
        return AbsSavedState.EMPTY_STATE;
    }

    void a(PreferenceGroup preferenceGroup) {
        if (preferenceGroup != null && this.K != null) {
            throw new IllegalStateException("This preference already has a parent. You must remove the existing parent before assigning a new one.");
        }
        this.K = preferenceGroup;
    }

    public void a0() {
        PreferenceManager.OnPreferenceTreeClickListener onPreferenceTreeClickListenerG;
        if (D() && F()) {
            R();
            OnPreferenceClickListener onPreferenceClickListener = this.f50824g;
            if (onPreferenceClickListener == null || !onPreferenceClickListener.a(this)) {
                PreferenceManager preferenceManagerW = w();
                if ((preferenceManagerW == null || (onPreferenceTreeClickListenerG = preferenceManagerW.g()) == null || !onPreferenceTreeClickListenerG.m(this)) && this.f50832o != null) {
                    h().startActivity(this.f50832o);
                }
            }
        }
    }

    public boolean b(Object obj) {
        OnPreferenceChangeListener onPreferenceChangeListener = this.f50823f;
        return onPreferenceChangeListener == null || onPreferenceChangeListener.a(this, obj);
    }

    protected void b0(View view) {
        a0();
    }

    final void c() {
        this.L = false;
    }

    protected boolean c0(boolean z2) {
        if (!y0()) {
            return false;
        }
        if (z2 == r(!z2)) {
            return true;
        }
        PreferenceDataStore preferenceDataStoreV = v();
        if (preferenceDataStoreV != null) {
            preferenceDataStoreV.e(this.f50831n, z2);
        } else {
            SharedPreferences.Editor editorE = this.f50820b.e();
            editorE.putBoolean(this.f50831n, z2);
            A0(editorE);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(Preference preference) {
        int i3 = this.f50825h;
        int i4 = preference.f50825h;
        if (i3 != i4) {
            return i3 - i4;
        }
        CharSequence charSequence = this.f50827j;
        CharSequence charSequence2 = preference.f50827j;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.f50827j.toString());
    }

    protected boolean d0(int i3) {
        if (!y0()) {
            return false;
        }
        if (i3 == s(~i3)) {
            return true;
        }
        PreferenceDataStore preferenceDataStoreV = v();
        if (preferenceDataStoreV != null) {
            preferenceDataStoreV.f(this.f50831n, i3);
        } else {
            SharedPreferences.Editor editorE = this.f50820b.e();
            editorE.putInt(this.f50831n, i3);
            A0(editorE);
        }
        return true;
    }

    void e(Bundle bundle) {
        Parcelable parcelable;
        if (!B() || (parcelable = bundle.getParcelable(this.f50831n)) == null) {
            return;
        }
        this.M = false;
        Y(parcelable);
        if (!this.M) {
            throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
        }
    }

    protected boolean e0(String str) {
        if (!y0()) {
            return false;
        }
        if (TextUtils.equals(str, t(null))) {
            return true;
        }
        PreferenceDataStore preferenceDataStoreV = v();
        if (preferenceDataStoreV != null) {
            preferenceDataStoreV.g(this.f50831n, str);
        } else {
            SharedPreferences.Editor editorE = this.f50820b.e();
            editorE.putString(this.f50831n, str);
            A0(editorE);
        }
        return true;
    }

    void f(Bundle bundle) {
        if (B()) {
            this.M = false;
            Parcelable parcelableZ = Z();
            if (!this.M) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            }
            if (parcelableZ != null) {
                bundle.putParcelable(this.f50831n, parcelableZ);
            }
        }
    }

    public boolean f0(Set set) {
        if (!y0()) {
            return false;
        }
        if (set.equals(u(null))) {
            return true;
        }
        PreferenceDataStore preferenceDataStoreV = v();
        if (preferenceDataStoreV != null) {
            preferenceDataStoreV.h(this.f50831n, set);
        } else {
            SharedPreferences.Editor editorE = this.f50820b.e();
            editorE.putStringSet(this.f50831n, set);
            A0(editorE);
        }
        return true;
    }

    protected Preference g(String str) {
        PreferenceManager preferenceManager = this.f50820b;
        if (preferenceManager == null) {
            return null;
        }
        return preferenceManager.a(str);
    }

    public Context h() {
        return this.f50819a;
    }

    public Bundle i() {
        if (this.f50834q == null) {
            this.f50834q = new Bundle();
        }
        return this.f50834q;
    }

    public void i0(Bundle bundle) {
        e(bundle);
    }

    StringBuilder j() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequenceZ = z();
        if (!TextUtils.isEmpty(charSequenceZ)) {
            sb.append(charSequenceZ);
            sb.append(' ');
        }
        CharSequence charSequenceX = x();
        if (!TextUtils.isEmpty(charSequenceX)) {
            sb.append(charSequenceX);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    public String k() {
        return this.f50833p;
    }

    public void k0(Bundle bundle) {
        f(bundle);
    }

    public Drawable l() {
        int i3;
        if (this.f50830m == null && (i3 = this.f50829l) != 0) {
            this.f50830m = AppCompatResources.b(this.f50819a, i3);
        }
        return this.f50830m;
    }

    long m() {
        return this.f50822d;
    }

    public void m0(int i3) {
        n0(AppCompatResources.b(this.f50819a, i3));
        this.f50829l = i3;
    }

    public Intent n() {
        return this.f50832o;
    }

    public void n0(Drawable drawable) {
        if (this.f50830m != drawable) {
            this.f50830m = drawable;
            this.f50829l = 0;
            H();
        }
    }

    public String o() {
        return this.f50831n;
    }

    public void o0(int i3) {
        this.G = i3;
    }

    public final int p() {
        return this.G;
    }

    final void p0(OnPreferenceChangeInternalListener onPreferenceChangeInternalListener) {
        this.I = onPreferenceChangeInternalListener;
    }

    public PreferenceGroup q() {
        return this.K;
    }

    public void q0(OnPreferenceClickListener onPreferenceClickListener) {
        this.f50824g = onPreferenceClickListener;
    }

    protected boolean r(boolean z2) {
        if (!y0()) {
            return z2;
        }
        PreferenceDataStore preferenceDataStoreV = v();
        return preferenceDataStoreV != null ? preferenceDataStoreV.a(this.f50831n, z2) : this.f50820b.k().getBoolean(this.f50831n, z2);
    }

    public void r0(int i3) {
        if (i3 != this.f50825h) {
            this.f50825h = i3;
            O();
        }
    }

    protected int s(int i3) {
        if (!y0()) {
            return i3;
        }
        PreferenceDataStore preferenceDataStoreV = v();
        return preferenceDataStoreV != null ? preferenceDataStoreV.b(this.f50831n, i3) : this.f50820b.k().getInt(this.f50831n, i3);
    }

    public void s0(CharSequence charSequence) {
        if (y() != null) {
            throw new IllegalStateException("Preference already has a SummaryProvider set.");
        }
        if (TextUtils.equals(this.f50828k, charSequence)) {
            return;
        }
        this.f50828k = charSequence;
        H();
    }

    protected String t(String str) {
        if (!y0()) {
            return str;
        }
        PreferenceDataStore preferenceDataStoreV = v();
        return preferenceDataStoreV != null ? preferenceDataStoreV.c(this.f50831n, str) : this.f50820b.k().getString(this.f50831n, str);
    }

    public final void t0(SummaryProvider summaryProvider) {
        this.O = summaryProvider;
        H();
    }

    public String toString() {
        return j().toString();
    }

    public Set u(Set set) {
        if (!y0()) {
            return set;
        }
        PreferenceDataStore preferenceDataStoreV = v();
        return preferenceDataStoreV != null ? preferenceDataStoreV.d(this.f50831n, set) : this.f50820b.k().getStringSet(this.f50831n, set);
    }

    public void u0(int i3) {
        v0(this.f50819a.getString(i3));
    }

    public PreferenceDataStore v() {
        PreferenceDataStore preferenceDataStore = this.f50821c;
        if (preferenceDataStore != null) {
            return preferenceDataStore;
        }
        PreferenceManager preferenceManager = this.f50820b;
        if (preferenceManager != null) {
            return preferenceManager.i();
        }
        return null;
    }

    public void v0(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.f50827j)) {
            return;
        }
        this.f50827j = charSequence;
        H();
    }

    public PreferenceManager w() {
        return this.f50820b;
    }

    public CharSequence x() {
        return y() != null ? y().a(this) : this.f50828k;
    }

    public boolean x0() {
        return !D();
    }

    public final SummaryProvider y() {
        return this.O;
    }

    protected boolean y0() {
        return this.f50820b != null && E() && B();
    }

    public CharSequence z() {
        return this.f50827j;
    }

    protected void R() {
    }

    public void V(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    public Preference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.a(context, R.attr.f50964i, android.R.attr.preferenceStyle));
    }

    public Preference(Context context) {
        this(context, null);
    }
}
