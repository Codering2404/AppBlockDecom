package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TypedValue f1941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TypedValue f1942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TypedValue f1943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TypedValue f1944d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TypedValue f1945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TypedValue f1946g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Rect f1947h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private OnAttachListener f1948i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnAttachListener {
        void a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public void a(int i3, int i4, int i5, int i6) {
        this.f1947h.set(i3, i4, i5, i6);
        if (isLaidOut()) {
            requestLayout();
        }
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f1945f == null) {
            this.f1945f = new TypedValue();
        }
        return this.f1945f;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f1946g == null) {
            this.f1946g = new TypedValue();
        }
        return this.f1946g;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f1943c == null) {
            this.f1943c = new TypedValue();
        }
        return this.f1943c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f1944d == null) {
            this.f1944d = new TypedValue();
        }
        return this.f1944d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f1941a == null) {
            this.f1941a = new TypedValue();
        }
        return this.f1941a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f1942b == null) {
            this.f1942b = new TypedValue();
        }
        return this.f1942b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        OnAttachListener onAttachListener = this.f1948i;
        if (onAttachListener != null) {
            onAttachListener.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OnAttachListener onAttachListener = this.f1948i;
        if (onAttachListener != null) {
            onAttachListener.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00db  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(OnAttachListener onAttachListener) {
        this.f1948i = onAttachListener;
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f1947h = new Rect();
    }
}
