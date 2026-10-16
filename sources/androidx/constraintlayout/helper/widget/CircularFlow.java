package androidx.constraintlayout.helper.widget;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class CircularFlow extends VirtualLayout {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static int f32514w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static float f32515x;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    ConstraintLayout f32516m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f32517n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float[] f32518o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int[] f32519p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f32520q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f32521r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f32522s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f32523t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Float f32524u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Integer f32525v;

    private void A() {
        this.f32516m = (ConstraintLayout) getParent();
        for (int i3 = 0; i3 < this.f33097b; i3++) {
            View viewById = this.f32516m.getViewById(this.f33096a[i3]);
            if (viewById != null) {
                int i4 = f32514w;
                float f3 = f32515x;
                int[] iArr = this.f32519p;
                if (iArr == null || i3 >= iArr.length) {
                    Integer num = this.f32525v;
                    if (num == null || num.intValue() == -1) {
                        Log.e("CircularFlow", "Added radius to view with id: " + ((String) this.f33104j.get(Integer.valueOf(viewById.getId()))));
                    } else {
                        this.f32520q++;
                        if (this.f32519p == null) {
                            this.f32519p = new int[1];
                        }
                        int[] radius = getRadius();
                        this.f32519p = radius;
                        radius[this.f32520q - 1] = i4;
                    }
                } else {
                    i4 = iArr[i3];
                }
                float[] fArr = this.f32518o;
                if (fArr == null || i3 >= fArr.length) {
                    Float f4 = this.f32524u;
                    if (f4 == null || f4.floatValue() == -1.0f) {
                        Log.e("CircularFlow", "Added angle to view with id: " + ((String) this.f33104j.get(Integer.valueOf(viewById.getId()))));
                    } else {
                        this.f32521r++;
                        if (this.f32518o == null) {
                            this.f32518o = new float[1];
                        }
                        float[] angles = getAngles();
                        this.f32518o = angles;
                        angles[this.f32521r - 1] = f3;
                    }
                } else {
                    f3 = fArr[i3];
                }
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) viewById.getLayoutParams();
                layoutParams.f33140r = f3;
                layoutParams.f33136p = this.f32517n;
                layoutParams.f33138q = i4;
                viewById.setLayoutParams(layoutParams);
            }
        }
        h();
    }

    private void setAngles(String str) {
        if (str == null) {
            return;
        }
        int i3 = 0;
        this.f32521r = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i3);
            if (iIndexOf == -1) {
                y(str.substring(i3).trim());
                return;
            } else {
                y(str.substring(i3, iIndexOf).trim());
                i3 = iIndexOf + 1;
            }
        }
    }

    private void setRadius(String str) {
        if (str == null) {
            return;
        }
        int i3 = 0;
        this.f32520q = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i3);
            if (iIndexOf == -1) {
                z(str.substring(i3).trim());
                return;
            } else {
                z(str.substring(i3, iIndexOf).trim());
                i3 = iIndexOf + 1;
            }
        }
    }

    private void y(String str) {
        float[] fArr;
        if (str == null || str.length() == 0 || this.f33098c == null || (fArr = this.f32518o) == null) {
            return;
        }
        if (this.f32521r + 1 > fArr.length) {
            this.f32518o = Arrays.copyOf(fArr, fArr.length + 1);
        }
        this.f32518o[this.f32521r] = Integer.parseInt(str);
        this.f32521r++;
    }

    private void z(String str) {
        int[] iArr;
        if (str == null || str.length() == 0 || this.f33098c == null || (iArr = this.f32519p) == null) {
            return;
        }
        if (this.f32520q + 1 > iArr.length) {
            this.f32519p = Arrays.copyOf(iArr, iArr.length + 1);
        }
        this.f32519p[this.f32520q] = (int) (Integer.parseInt(str) * this.f33098c.getResources().getDisplayMetrics().density);
        this.f32520q++;
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.f32518o, this.f32521r);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.f32519p, this.f32520q);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    protected void o(AttributeSet attributeSet) {
        super.o(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.f33354n1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.J1) {
                    this.f32517n = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                } else if (index == R.styleable.F1) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f32522s = string;
                    setAngles(string);
                } else if (index == R.styleable.I1) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.f32523t = string2;
                    setRadius(string2);
                } else if (index == R.styleable.G1) {
                    Float fValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, f32515x));
                    this.f32524u = fValueOf;
                    setDefaultAngle(fValueOf.floatValue());
                } else if (index == R.styleable.H1) {
                    Integer numValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, f32514w));
                    this.f32525v = numValueOf;
                    setDefaultRadius(numValueOf.intValue());
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f32522s;
        if (str != null) {
            this.f32518o = new float[1];
            setAngles(str);
        }
        String str2 = this.f32523t;
        if (str2 != null) {
            this.f32519p = new int[1];
            setRadius(str2);
        }
        Float f3 = this.f32524u;
        if (f3 != null) {
            setDefaultAngle(f3.floatValue());
        }
        Integer num = this.f32525v;
        if (num != null) {
            setDefaultRadius(num.intValue());
        }
        A();
    }

    public void setDefaultAngle(float f3) {
        f32515x = f3;
    }

    public void setDefaultRadius(int i3) {
        f32514w = i3;
    }
}
