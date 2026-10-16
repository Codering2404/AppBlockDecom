package cz.mobilesoft.coreblock.view;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
public class CheckableFrameLayout extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f130031b = {R.attr.state_checked};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f130032a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: cz.mobilesoft.coreblock.view.CheckableFrameLayout.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f130033a;

        public String toString() {
            return "CheckableFrameLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " checked=" + this.f130033a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeValue(Boolean.valueOf(this.f130033a));
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f130033a = ((Boolean) parcel.readValue(getClass().getClassLoader())).booleanValue();
        }
    }

    public CheckableFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(ViewGroup viewGroup, boolean z2) {
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            KeyEvent.Callback childAt = viewGroup.getChildAt(i3);
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(z2);
            }
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, z2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable background = getBackground();
        if (background != null) {
            background.setState(getDrawableState());
            invalidate();
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f130032a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f130031b);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.f130033a);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f130033a = isChecked();
        return savedState;
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        if (this.f130032a != z2) {
            this.f130032a = z2;
            refreshDrawableState();
            a(this, z2);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f130032a);
    }
}
