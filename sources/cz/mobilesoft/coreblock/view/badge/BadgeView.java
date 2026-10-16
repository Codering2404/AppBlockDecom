package cz.mobilesoft.coreblock.view.badge;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import cz.mobilesoft.coreblock.util.view.ViewHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
public class BadgeView extends LinearLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final double f130086h = Math.sqrt(2.0d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f130087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f130088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f130089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f130090d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImageView f130091f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextView f130092g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class CustomOutline extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f130093a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f130094b;

        CustomOutline(int i3, int i4) {
            this.f130093a = i3;
            this.f130094b = i4;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int i3 = this.f130093a;
            int i4 = this.f130094b;
            if (i3 == i4) {
                outline.setOval(0, 0, BadgeView.this.f130088b * 2, BadgeView.this.f130088b * 2);
            } else {
                outline.setRoundRect(0, 0, i3, i4, BadgeView.this.f130088b);
            }
        }
    }

    public BadgeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setClipToOutline(true);
        TextView textView = new TextView(context);
        this.f130092g = textView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 16;
        textView.setLayoutParams(layoutParams);
        textView.setGravity(16);
        addView(textView, 0);
        ImageView imageView = new ImageView(context);
        this.f130091f = imageView;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        imageView.setLayoutParams(layoutParams2);
        addView(imageView, 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.layout_height});
        try {
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
            typedArrayObtainStyledAttributes.recycle();
            TypedArray typedArrayObtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(attributeSet, cz.mobilesoft.coreblock.R.styleable.D, 0, 0);
            try {
                int dimensionPixelSize2 = typedArrayObtainStyledAttributes2.getDimensionPixelSize(cz.mobilesoft.coreblock.R.styleable.I, -1);
                this.f130088b = dimensionPixelSize2;
                if (dimensionPixelSize2 == -1) {
                    if (dimensionPixelSize != -1) {
                        this.f130088b = dimensionPixelSize / 2;
                    } else {
                        this.f130088b = 0;
                    }
                }
                int i3 = this.f130088b;
                int dimensionPixelSize3 = (i3 - ((int) ((((double) i3) * 0.9d) / f130086h))) + typedArrayObtainStyledAttributes2.getDimensionPixelSize(cz.mobilesoft.coreblock.R.styleable.H, 0);
                this.f130087a = dimensionPixelSize3;
                setPadding(dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) imageView.getLayoutParams();
                int i4 = (this.f130088b - dimensionPixelSize3) * 2;
                layoutParams3.height = i4;
                layoutParams3.width = i4;
                int resourceId = typedArrayObtainStyledAttributes2.getResourceId(cz.mobilesoft.coreblock.R.styleable.F, -1);
                if (resourceId != -1) {
                    imageView.setImageResource(resourceId);
                }
                int resourceId2 = typedArrayObtainStyledAttributes2.getResourceId(cz.mobilesoft.coreblock.R.styleable.E, -1);
                this.f130090d = resourceId2;
                if (resourceId2 != -1) {
                    setBackgroundResource(resourceId2);
                }
                int dimensionPixelSize4 = typedArrayObtainStyledAttributes2.getDimensionPixelSize(cz.mobilesoft.coreblock.R.styleable.G, -1);
                this.f130089c = dimensionPixelSize4;
                if (dimensionPixelSize4 != -1) {
                    if (ViewHelper.e(getContext())) {
                        setElevation(0.0f);
                    } else {
                        setElevation(dimensionPixelSize4);
                    }
                }
                typedArrayObtainStyledAttributes2.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes2.recycle();
                throw th;
            }
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    private void b() {
        int i3 = (this.f130092g.getText() == null || this.f130092g.getText().length() == 0) ? 0 : this.f130087a;
        this.f130092g.setPaddingRelative(i3, 0, i3, 0);
    }

    public ImageView getImageView() {
        return this.f130091f;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        setOutlineProvider(new CustomOutline(i3, i4));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f130091f.getLayoutParams();
        int i7 = (this.f130088b - this.f130087a) * 2;
        layoutParams.height = i7;
        layoutParams.width = i7;
    }

    public void setEnabledAppearance(boolean z2) {
        if (!z2) {
            setBackgroundColor(ContextCompat.getColor(getContext(), cz.mobilesoft.coreblock.R.color.f95461p));
            setAlpha(0.5f);
            setElevation(0.0f);
            return;
        }
        setAlpha(1.0f);
        if (this.f130089c != -1) {
            if (ViewHelper.e(getContext())) {
                setElevation(0.0f);
            } else {
                setElevation(this.f130089c);
            }
        }
        int i3 = this.f130090d;
        if (i3 != -1) {
            setBackgroundResource(i3);
        } else {
            setBackground(null);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        this.f130091f.setImageDrawable(drawable);
    }

    public void setImageResource(int i3) {
        this.f130091f.setImageResource(i3);
    }

    public void setImageTintList(ColorStateList colorStateList) {
        this.f130091f.setImageTintList(colorStateList);
    }

    public void setText(CharSequence charSequence) {
        this.f130092g.setText(charSequence);
        b();
    }

    public void setText(int i3) {
        this.f130092g.setText(i3);
        b();
    }
}
