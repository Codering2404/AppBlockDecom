package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class TintTypedArray {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TypedArray f2247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TypedValue f2248c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api21Impl {
        static int a(TypedArray typedArray) {
            return typedArray.getChangingConfigurations();
        }

        static int b(TypedArray typedArray, int i3) {
            return typedArray.getType(i3);
        }
    }

    private TintTypedArray(Context context, TypedArray typedArray) {
        this.f2246a = context;
        this.f2247b = typedArray;
    }

    public static TintTypedArray t(Context context, int i3, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(i3, iArr));
    }

    public static TintTypedArray u(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static TintTypedArray v(Context context, AttributeSet attributeSet, int[] iArr, int i3, int i4) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i3, i4));
    }

    public boolean a(int i3, boolean z2) {
        return this.f2247b.getBoolean(i3, z2);
    }

    public int b(int i3, int i4) {
        return this.f2247b.getColor(i3, i4);
    }

    public ColorStateList c(int i3) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!this.f2247b.hasValue(i3) || (resourceId = this.f2247b.getResourceId(i3, 0)) == 0 || (colorStateListA = AppCompatResources.a(this.f2246a, resourceId)) == null) ? this.f2247b.getColorStateList(i3) : colorStateListA;
    }

    public float d(int i3, float f3) {
        return this.f2247b.getDimension(i3, f3);
    }

    public int e(int i3, int i4) {
        return this.f2247b.getDimensionPixelOffset(i3, i4);
    }

    public int f(int i3, int i4) {
        return this.f2247b.getDimensionPixelSize(i3, i4);
    }

    public Drawable g(int i3) {
        int resourceId;
        return (!this.f2247b.hasValue(i3) || (resourceId = this.f2247b.getResourceId(i3, 0)) == 0) ? this.f2247b.getDrawable(i3) : AppCompatResources.b(this.f2246a, resourceId);
    }

    public Drawable h(int i3) {
        int resourceId;
        if (!this.f2247b.hasValue(i3) || (resourceId = this.f2247b.getResourceId(i3, 0)) == 0) {
            return null;
        }
        return AppCompatDrawableManager.b().d(this.f2246a, resourceId, true);
    }

    public float i(int i3, float f3) {
        return this.f2247b.getFloat(i3, f3);
    }

    public Typeface j(int i3, int i4, ResourcesCompat.FontCallback fontCallback) {
        int resourceId = this.f2247b.getResourceId(i3, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f2248c == null) {
            this.f2248c = new TypedValue();
        }
        return ResourcesCompat.j(this.f2246a, resourceId, this.f2248c, i4, fontCallback);
    }

    public int k(int i3, int i4) {
        return this.f2247b.getInt(i3, i4);
    }

    public int l(int i3, int i4) {
        return this.f2247b.getInteger(i3, i4);
    }

    public int m(int i3, int i4) {
        return this.f2247b.getLayoutDimension(i3, i4);
    }

    public int n(int i3, int i4) {
        return this.f2247b.getResourceId(i3, i4);
    }

    public String o(int i3) {
        return this.f2247b.getString(i3);
    }

    public CharSequence p(int i3) {
        return this.f2247b.getText(i3);
    }

    public CharSequence[] q(int i3) {
        return this.f2247b.getTextArray(i3);
    }

    public TypedArray r() {
        return this.f2247b;
    }

    public boolean s(int i3) {
        return this.f2247b.hasValue(i3);
    }

    public TypedValue w(int i3) {
        return this.f2247b.peekValue(i3);
    }

    public void x() {
        this.f2247b.recycle();
    }
}
