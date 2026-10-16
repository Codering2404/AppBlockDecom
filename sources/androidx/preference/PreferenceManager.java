package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class PreferenceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f50933a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SharedPreferences f50935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PreferenceDataStore f50936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SharedPreferences.Editor f50937e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f50938f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f50939g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f50940h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private PreferenceScreen f50942j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PreferenceComparisonCallback f50943k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private OnPreferenceTreeClickListener f50944l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private OnDisplayPreferenceDialogListener f50945m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private OnNavigateToScreenListener f50946n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f50934b = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f50941i = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnDisplayPreferenceDialogListener {
        void l(Preference preference);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnNavigateToScreenListener {
        void g(PreferenceScreen preferenceScreen);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnPreferenceTreeClickListener {
        boolean m(Preference preference);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class PreferenceComparisonCallback {
        public abstract boolean a(Preference preference, Preference preference2);

        public abstract boolean b(Preference preference, Preference preference2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class SimplePreferenceComparisonCallback extends PreferenceComparisonCallback {
        @Override // androidx.preference.PreferenceManager.PreferenceComparisonCallback
        public boolean a(Preference preference, Preference preference2) {
            if (preference.getClass() != preference2.getClass()) {
                return false;
            }
            if ((preference == preference2 && preference.D0()) || !TextUtils.equals(preference.z(), preference2.z()) || !TextUtils.equals(preference.x(), preference2.x())) {
                return false;
            }
            Drawable drawableL = preference.l();
            Drawable drawableL2 = preference2.l();
            if ((drawableL != drawableL2 && (drawableL == null || !drawableL.equals(drawableL2))) || preference.D() != preference2.D() || preference.F() != preference2.F()) {
                return false;
            }
            if (!(preference instanceof TwoStatePreference) || ((TwoStatePreference) preference).E0() == ((TwoStatePreference) preference2).E0()) {
                return !(preference instanceof DropDownPreference) || preference == preference2;
            }
            return false;
        }

        @Override // androidx.preference.PreferenceManager.PreferenceComparisonCallback
        public boolean b(Preference preference, Preference preference2) {
            return preference.m() == preference2.m();
        }
    }

    public PreferenceManager(Context context) {
        this.f50933a = context;
        o(d(context));
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences(d(context), c());
    }

    private static int c() {
        return 0;
    }

    private static String d(Context context) {
        return context.getPackageName() + "_preferences";
    }

    public Preference a(CharSequence charSequence) {
        PreferenceScreen preferenceScreen = this.f50942j;
        if (preferenceScreen == null) {
            return null;
        }
        return preferenceScreen.E0(charSequence);
    }

    SharedPreferences.Editor e() {
        if (this.f50936d != null) {
            return null;
        }
        if (!this.f50938f) {
            return k().edit();
        }
        if (this.f50937e == null) {
            this.f50937e = k().edit();
        }
        return this.f50937e;
    }

    public OnNavigateToScreenListener f() {
        return this.f50946n;
    }

    public OnPreferenceTreeClickListener g() {
        return this.f50944l;
    }

    public PreferenceComparisonCallback h() {
        return this.f50943k;
    }

    public PreferenceDataStore i() {
        return this.f50936d;
    }

    public PreferenceScreen j() {
        return this.f50942j;
    }

    public SharedPreferences k() {
        if (i() != null) {
            return null;
        }
        if (this.f50935c == null) {
            this.f50935c = (this.f50941i != 1 ? this.f50933a : ContextCompat.createDeviceProtectedStorageContext(this.f50933a)).getSharedPreferences(this.f50939g, this.f50940h);
        }
        return this.f50935c;
    }

    public void l(OnDisplayPreferenceDialogListener onDisplayPreferenceDialogListener) {
        this.f50945m = onDisplayPreferenceDialogListener;
    }

    public void m(OnNavigateToScreenListener onNavigateToScreenListener) {
        this.f50946n = onNavigateToScreenListener;
    }

    public void n(OnPreferenceTreeClickListener onPreferenceTreeClickListener) {
        this.f50944l = onPreferenceTreeClickListener;
    }

    public void o(String str) {
        this.f50939g = str;
        this.f50935c = null;
    }

    boolean p() {
        return !this.f50938f;
    }

    public void q(Preference preference) {
        OnDisplayPreferenceDialogListener onDisplayPreferenceDialogListener = this.f50945m;
        if (onDisplayPreferenceDialogListener != null) {
            onDisplayPreferenceDialogListener.l(preference);
        }
    }
}
