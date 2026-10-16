package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.R;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WeakReference f2350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LayoutInflater f2351d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private OnInflateListener f2352f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnInflateListener {
        void a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public View a() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
        if (this.f2348a == 0) {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        LayoutInflater layoutInflaterFrom = this.f2351d;
        if (layoutInflaterFrom == null) {
            layoutInflaterFrom = LayoutInflater.from(getContext());
        }
        View viewInflate = layoutInflaterFrom.inflate(this.f2348a, viewGroup, false);
        int i3 = this.f2349b;
        if (i3 != -1) {
            viewInflate.setId(i3);
        }
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(viewInflate, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(viewInflate, iIndexOfChild);
        }
        this.f2350c = new WeakReference(viewInflate);
        OnInflateListener onInflateListener = this.f2352f;
        if (onInflateListener != null) {
            onInflateListener.a(this, viewInflate);
        }
        return viewInflate;
    }

    public int getInflatedId() {
        return this.f2349b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f2351d;
    }

    public int getLayoutResource() {
        return this.f2348a;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i3) {
        this.f2349b = i3;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f2351d = layoutInflater;
    }

    public void setLayoutResource(int i3) {
        this.f2348a = i3;
    }

    public void setOnInflateListener(OnInflateListener onInflateListener) {
        this.f2352f = onInflateListener;
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        WeakReference weakReference = this.f2350c;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (view == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(i3);
            return;
        }
        super.setVisibility(i3);
        if (i3 == 0 || i3 == 4) {
            a();
        }
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f2348a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Y3, i3, 0);
        this.f2349b = typedArrayObtainStyledAttributes.getResourceId(R.styleable.b4, -1);
        this.f2348a = typedArrayObtainStyledAttributes.getResourceId(R.styleable.a4, 0);
        setId(typedArrayObtainStyledAttributes.getResourceId(R.styleable.Z3, -1));
        typedArrayObtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }
}
