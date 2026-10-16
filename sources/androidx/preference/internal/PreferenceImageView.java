package androidx.preference.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.preference.R;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class PreferenceImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f51070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f51071b;

    public PreferenceImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.ImageView
    public int getMaxHeight() {
        return this.f51071b;
    }

    @Override // android.widget.ImageView
    public int getMaxWidth() {
        return this.f51070a;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i3);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int size = View.MeasureSpec.getSize(i3);
            int maxWidth = getMaxWidth();
            if (maxWidth != Integer.MAX_VALUE && (maxWidth < size || mode == 0)) {
                i3 = View.MeasureSpec.makeMeasureSpec(maxWidth, Integer.MIN_VALUE);
            }
        }
        int mode2 = View.MeasureSpec.getMode(i4);
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            int size2 = View.MeasureSpec.getSize(i4);
            int maxHeight = getMaxHeight();
            if (maxHeight != Integer.MAX_VALUE && (maxHeight < size2 || mode2 == 0)) {
                i4 = View.MeasureSpec.makeMeasureSpec(maxHeight, Integer.MIN_VALUE);
            }
        }
        super.onMeasure(i3, i4);
    }

    @Override // android.widget.ImageView
    public void setMaxHeight(int i3) {
        this.f51071b = i3;
        super.setMaxHeight(i3);
    }

    @Override // android.widget.ImageView
    public void setMaxWidth(int i3) {
        this.f51070a = i3;
        super.setMaxWidth(i3);
    }

    public PreferenceImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f51070a = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f51071b = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.H0, i3, 0);
        setMaxWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.J0, Api.BaseClientBuilder.API_PRIORITY_OTHER));
        setMaxHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.I0, Api.BaseClientBuilder.API_PRIORITY_OTHER));
        typedArrayObtainStyledAttributes.recycle();
    }
}
