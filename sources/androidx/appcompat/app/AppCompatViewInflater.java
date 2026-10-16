package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.ViewCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatViewInflater {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class[] f1090b = {Context.class, AttributeSet.class};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f1091c = {R.attr.onClick};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f1092d = {R.attr.accessibilityHeading};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f1093e = {R.attr.accessibilityPaneTitle};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f1094f = {R.attr.screenReaderFocusable};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f1095g = {"android.widget.", "android.view.", "android.webkit."};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final SimpleArrayMap f1096h = new SimpleArrayMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object[] f1097a = new Object[2];

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DeclaredOnClickListener implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f1098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f1099b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Method f1100c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Context f1101d;

        public DeclaredOnClickListener(View view, String str) {
            this.f1098a = view;
            this.f1099b = str;
        }

        private void a(Context context) {
            String str;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f1099b, View.class)) != null) {
                        this.f1100c = method;
                        this.f1101d = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.f1098a.getId();
            if (id == -1) {
                str = "";
            } else {
                str = " with id '" + this.f1098a.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f1099b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f1098a.getClass() + str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f1100c == null) {
                a(this.f1098a.getContext());
            }
            try {
                this.f1100c.invoke(this.f1101d, view);
            } catch (IllegalAccessException e3) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e3);
            } catch (InvocationTargetException e4) {
                throw new IllegalStateException("Could not execute method for android:onClick", e4);
            }
        }
    }

    private void a(Context context, View view, AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT > 28) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1092d);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            ViewCompat.n0(view, typedArrayObtainStyledAttributes.getBoolean(0, false));
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f1093e);
        if (typedArrayObtainStyledAttributes2.hasValue(0)) {
            ViewCompat.p0(view, typedArrayObtainStyledAttributes2.getString(0));
        }
        typedArrayObtainStyledAttributes2.recycle();
        TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f1094f);
        if (typedArrayObtainStyledAttributes3.hasValue(0)) {
            ViewCompat.F0(view, typedArrayObtainStyledAttributes3.getBoolean(0, false));
        }
        typedArrayObtainStyledAttributes3.recycle();
    }

    private void b(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && view.hasOnClickListeners()) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1091c);
            String string = typedArrayObtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new DeclaredOnClickListener(view, string));
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private View s(Context context, String str, String str2) {
        String str3;
        SimpleArrayMap simpleArrayMap = f1096h;
        Constructor constructor = (Constructor) simpleArrayMap.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f1090b);
            simpleArrayMap.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f1097a);
    }

    private View t(Context context, String str, AttributeSet attributeSet) {
        if (str.equals(ViewHierarchyConstants.VIEW_KEY)) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            Object[] objArr = this.f1097a;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return s(context, str, null);
            }
            int i3 = 0;
            while (true) {
                String[] strArr = f1095g;
                if (i3 >= strArr.length) {
                    return null;
                }
                View viewS = s(context, str, strArr[i3]);
                if (viewS != null) {
                    return viewS;
                }
                i3++;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr2 = this.f1097a;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }

    private static Context u(Context context, AttributeSet attributeSet, boolean z2, boolean z3) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.R3, 0, 0);
        int resourceId = z2 ? typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.S3, 0) : 0;
        if (z3 && resourceId == 0 && (resourceId = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.T3, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes.recycle();
        return (resourceId == 0 || ((context instanceof ContextThemeWrapper) && ((ContextThemeWrapper) context).c() == resourceId)) ? context : new ContextThemeWrapper(context, resourceId);
    }

    private void v(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    protected AppCompatAutoCompleteTextView c(Context context, AttributeSet attributeSet) {
        return new AppCompatAutoCompleteTextView(context, attributeSet);
    }

    protected AppCompatButton d(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    protected AppCompatCheckBox e(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    protected AppCompatCheckedTextView f(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckedTextView(context, attributeSet);
    }

    protected AppCompatEditText g(Context context, AttributeSet attributeSet) {
        return new AppCompatEditText(context, attributeSet);
    }

    protected AppCompatImageButton h(Context context, AttributeSet attributeSet) {
        return new AppCompatImageButton(context, attributeSet);
    }

    protected AppCompatImageView i(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    protected AppCompatMultiAutoCompleteTextView j(Context context, AttributeSet attributeSet) {
        return new AppCompatMultiAutoCompleteTextView(context, attributeSet);
    }

    protected AppCompatRadioButton k(Context context, AttributeSet attributeSet) {
        return new AppCompatRadioButton(context, attributeSet);
    }

    protected AppCompatRatingBar l(Context context, AttributeSet attributeSet) {
        return new AppCompatRatingBar(context, attributeSet);
    }

    protected AppCompatSeekBar m(Context context, AttributeSet attributeSet) {
        return new AppCompatSeekBar(context, attributeSet);
    }

    protected AppCompatSpinner n(Context context, AttributeSet attributeSet) {
        return new AppCompatSpinner(context, attributeSet);
    }

    protected AppCompatTextView o(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    protected AppCompatToggleButton p(Context context, AttributeSet attributeSet) {
        return new AppCompatToggleButton(context, attributeSet);
    }

    protected View q(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final View r(View view, String str, Context context, AttributeSet attributeSet, boolean z2, boolean z3, boolean z4, boolean z5) {
        View viewL;
        Context context2 = (!z2 || view == null) ? context : view.getContext();
        if (z3 || z4) {
            context2 = u(context2, attributeSet, z3, z4);
        }
        if (z5) {
            context2 = TintContextWrapper.b(context2);
        }
        str.getClass();
        byte b3 = -1;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    b3 = 0;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    b3 = 1;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    b3 = 2;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    b3 = 3;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    b3 = 4;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    b3 = 5;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    b3 = 6;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    b3 = 7;
                }
                break;
            case 799298502:
                if (str.equals("ToggleButton")) {
                    b3 = 8;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    b3 = 9;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    b3 = 10;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    b3 = Ascii.VT;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    b3 = Ascii.FF;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    b3 = Ascii.CR;
                }
                break;
        }
        switch (b3) {
            case 0:
                viewL = l(context2, attributeSet);
                v(viewL, str);
                break;
            case 1:
                viewL = f(context2, attributeSet);
                v(viewL, str);
                break;
            case 2:
                viewL = j(context2, attributeSet);
                v(viewL, str);
                break;
            case 3:
                viewL = o(context2, attributeSet);
                v(viewL, str);
                break;
            case 4:
                viewL = h(context2, attributeSet);
                v(viewL, str);
                break;
            case 5:
                viewL = m(context2, attributeSet);
                v(viewL, str);
                break;
            case 6:
                viewL = n(context2, attributeSet);
                v(viewL, str);
                break;
            case 7:
                viewL = k(context2, attributeSet);
                v(viewL, str);
                break;
            case 8:
                viewL = p(context2, attributeSet);
                v(viewL, str);
                break;
            case 9:
                viewL = i(context2, attributeSet);
                v(viewL, str);
                break;
            case 10:
                viewL = c(context2, attributeSet);
                v(viewL, str);
                break;
            case 11:
                viewL = e(context2, attributeSet);
                v(viewL, str);
                break;
            case 12:
                viewL = g(context2, attributeSet);
                v(viewL, str);
                break;
            case 13:
                viewL = d(context2, attributeSet);
                v(viewL, str);
                break;
            default:
                viewL = q(context2, str, attributeSet);
                break;
        }
        if (viewL == null && context != context2) {
            viewL = t(context2, str, attributeSet);
        }
        if (viewL != null) {
            b(viewL, attributeSet);
            a(context2, viewL, attributeSet);
        }
        return viewL;
    }
}
