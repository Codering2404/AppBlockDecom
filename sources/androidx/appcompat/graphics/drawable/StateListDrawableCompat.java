package androidx.appcompat.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.graphics.drawable.DrawableContainerCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class StateListDrawableCompat extends DrawableContainerCompat {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private StateListState f1242n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f1243o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class StateListState extends DrawableContainerCompat.DrawableContainerState {
        int[][] J;

        StateListState(StateListState stateListState, StateListDrawableCompat stateListDrawableCompat, Resources resources) {
            super(stateListState, stateListDrawableCompat, resources);
            if (stateListState != null) {
                this.J = stateListState.J;
            } else {
                this.J = new int[f()][];
            }
        }

        int A(int[] iArr, Drawable drawable) {
            int iA = a(drawable);
            this.J[iA] = iArr;
            return iA;
        }

        int B(int[] iArr) {
            int[][] iArr2 = this.J;
            int iH = h();
            for (int i3 = 0; i3 < iH; i3++) {
                if (StateSet.stateSetMatches(iArr2[i3], iArr)) {
                    return i3;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new StateListDrawableCompat(this, null);
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat.DrawableContainerState
        public void o(int i3, int i4) {
            super.o(i3, i4);
            int[][] iArr = new int[i4][];
            System.arraycopy(this.J, 0, iArr, 0, i3);
            this.J = iArr;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat.DrawableContainerState
        void s() {
            int[][] iArr = this.J;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[] iArr3 = this.J[length];
                iArr2[length] = iArr3 != null ? (int[]) iArr3.clone() : null;
            }
            this.J = iArr2;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new StateListDrawableCompat(this, resources);
        }
    }

    StateListDrawableCompat(StateListState stateListState, Resources resources) {
        h(new StateListState(stateListState, this, resources));
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    void h(DrawableContainerCompat.DrawableContainerState drawableContainerState) {
        super.h(drawableContainerState);
        if (drawableContainerState instanceof StateListState) {
            this.f1242n = (StateListState) drawableContainerState;
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public StateListState b() {
        return new StateListState(this.f1242n, this, null);
    }

    int[] k(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i3 = 0;
        for (int i4 = 0; i4 < attributeCount; i4++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i4);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i5 = i3 + 1;
                if (!attributeSet.getAttributeBooleanValue(i4, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i3] = attributeNameResource;
                i3 = i5;
            }
        }
        return StateSet.trimStateSet(iArr, i3);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f1243o && super.mutate() == this) {
            this.f1242n.s();
            this.f1243o = true;
        }
        return this;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        int iB = this.f1242n.B(iArr);
        if (iB < 0) {
            iB = this.f1242n.B(StateSet.WILD_CARD);
        }
        return g(iB) || zOnStateChange;
    }

    StateListDrawableCompat(StateListState stateListState) {
        if (stateListState != null) {
            h(stateListState);
        }
    }
}
