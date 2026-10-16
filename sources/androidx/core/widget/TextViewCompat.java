package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TextViewCompat {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api23Impl {
        static void a(TextView textView, int i3) {
            textView.setBreakStrategy(i3);
        }

        static void b(TextView textView, ColorStateList colorStateList) {
            textView.setCompoundDrawableTintList(colorStateList);
        }

        static void c(TextView textView, PorterDuff.Mode mode) {
            textView.setCompoundDrawableTintMode(mode);
        }

        static void d(TextView textView, int i3) {
            textView.setHyphenationFrequency(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api24Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api26Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api34Impl {
        public static void a(TextView textView, int i3, float f3) {
            textView.setLineHeight(i3, f3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface AutoSizeTextType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class OreoCallback implements ActionMode.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ActionMode.Callback f34712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TextView f34713b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Class f34714c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Method f34715d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f34716e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f34717f;

        private Intent a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        private Intent b(ResolveInfo resolveInfo, TextView textView) {
            Intent intentPutExtra = a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !e(textView));
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            return intentPutExtra.setClassName(activityInfo.packageName, activityInfo.name);
        }

        private List c(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (context instanceof Activity) {
                for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(a(), 0)) {
                    if (f(resolveInfo, context)) {
                        arrayList.add(resolveInfo);
                    }
                }
            }
            return arrayList;
        }

        private boolean e(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        private boolean f(ResolveInfo resolveInfo, Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (!activityInfo.exported) {
                return false;
            }
            String str = activityInfo.permission;
            return str == null || context.checkSelfPermission(str) == 0;
        }

        private void g(Menu menu) {
            Context context = this.f34713b.getContext();
            PackageManager packageManager = context.getPackageManager();
            boolean z2 = this.f34717f;
            Class cls = Integer.TYPE;
            if (!z2) {
                this.f34717f = true;
                try {
                    Class<?> cls2 = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f34714c = cls2;
                    this.f34715d = cls2.getDeclaredMethod("removeItemAt", cls);
                    this.f34716e = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f34714c = null;
                    this.f34715d = null;
                    this.f34716e = false;
                }
            }
            try {
                Method declaredMethod = (this.f34716e && this.f34714c.isInstance(menu)) ? this.f34715d : menu.getClass().getDeclaredMethod("removeItemAt", cls);
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        declaredMethod.invoke(menu, Integer.valueOf(size));
                    }
                }
                List listC = c(context, packageManager);
                for (int i3 = 0; i3 < listC.size(); i3++) {
                    ResolveInfo resolveInfo = (ResolveInfo) listC.get(i3);
                    menu.add(0, 0, i3 + 100, resolveInfo.loadLabel(packageManager)).setIntent(b(resolveInfo, this.f34713b)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        ActionMode.Callback d() {
            return this.f34712a;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f34712a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f34712a.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.f34712a.onDestroyActionMode(actionMode);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            g(menu);
            return this.f34712a.onPrepareActionMode(actionMode, menu);
        }
    }

    public static Drawable[] a(TextView textView) {
        return textView.getCompoundDrawablesRelative();
    }

    public static int b(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int c(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    public static int d(TextView textView) {
        return textView.getMaxLines();
    }

    private static int e(TextDirectionHeuristic textDirectionHeuristic) {
        TextDirectionHeuristic textDirectionHeuristic2;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        if (textDirectionHeuristic == textDirectionHeuristic3 || textDirectionHeuristic == (textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == textDirectionHeuristic2) {
            return 6;
        }
        return textDirectionHeuristic == textDirectionHeuristic3 ? 7 : 1;
    }

    public static PrecomputedTextCompat.Params f(TextView textView) {
        return new PrecomputedTextCompat.Params(Api28Impl.b(textView));
    }

    public static void g(TextView textView, ColorStateList colorStateList) {
        Preconditions.h(textView);
        Api23Impl.b(textView, colorStateList);
    }

    public static void h(TextView textView, PorterDuff.Mode mode) {
        Preconditions.h(textView);
        Api23Impl.c(textView, mode);
    }

    public static void i(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    public static void j(TextView textView, int i3) {
        Preconditions.e(i3);
        Api28Impl.c(textView, i3);
    }

    public static void k(TextView textView, int i3) {
        Preconditions.e(i3);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i4 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i3 > Math.abs(i4)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i3 - i4);
        }
    }

    public static void l(TextView textView, int i3) {
        Preconditions.e(i3);
        if (i3 != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i3 - r0, 1.0f);
        }
    }

    public static void m(TextView textView, int i3, float f3) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.a(textView, i3, f3);
        } else {
            l(textView, Math.round(TypedValue.applyDimension(i3, f3, textView.getResources().getDisplayMetrics())));
        }
    }

    public static void n(TextView textView, PrecomputedTextCompat precomputedTextCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            textView.setText(Api28Impl.a(precomputedTextCompat.c()));
        } else {
            if (!f(textView).a(precomputedTextCompat.b())) {
                throw new IllegalArgumentException("Given text can not be applied to TextView.");
            }
            textView.setText(precomputedTextCompat);
        }
    }

    public static void o(TextView textView, int i3) {
        textView.setTextAppearance(i3);
    }

    public static void p(TextView textView, PrecomputedTextCompat.Params params) {
        textView.setTextDirection(e(params.d()));
        textView.getPaint().set(params.e());
        Api23Impl.a(textView, params.b());
        Api23Impl.d(textView, params.c());
    }

    public static ActionMode.Callback q(ActionMode.Callback callback) {
        return callback instanceof OreoCallback ? ((OreoCallback) callback).d() : callback;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api28Impl {
        static PrecomputedText.Params b(TextView textView) {
            return textView.getTextMetricsParams();
        }

        static void c(TextView textView, int i3) {
            textView.setFirstBaselineToTopHeight(i3);
        }

        static CharSequence a(PrecomputedText precomputedText) {
            return precomputedText;
        }
    }

    public static ActionMode.Callback r(TextView textView, ActionMode.Callback callback) {
        return callback;
    }
}
