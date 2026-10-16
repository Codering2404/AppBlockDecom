package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.ImageButton;
import androidx.appcompat.R;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableImageSourceView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatImageButton extends ImageButton implements TintableBackgroundView, TintableImageSourceView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppCompatBackgroundHelper f1801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AppCompatImageHelper f1802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1803c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1805b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1806c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f1807d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1808e;

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void readProperties(AppCompatImageButton appCompatImageButton, PropertyReader propertyReader) {
            if (!this.f1804a) {
                throw c.a();
            }
            propertyReader.readObject(this.f1805b, appCompatImageButton.getBackgroundTintList());
            propertyReader.readObject(this.f1806c, appCompatImageButton.getBackgroundTintMode());
            propertyReader.readObject(this.f1807d, appCompatImageButton.getImageTintList());
            propertyReader.readObject(this.f1808e, appCompatImageButton.getImageTintMode());
        }

        public void mapProperties(PropertyMapper propertyMapper) {
            this.f1805b = propertyMapper.mapObject("backgroundTint", R.attr.f673v);
            this.f1806c = propertyMapper.mapObject("backgroundTintMode", R.attr.f675w);
            this.f1807d = propertyMapper.mapObject("tint", R.attr.D0);
            this.f1808e = propertyMapper.mapObject("tintMode", R.attr.E0);
            this.f1804a = true;
        }
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f634b0);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1801a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.b();
        }
        AppCompatImageHelper appCompatImageHelper = this.f1802b;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1801a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1801a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        AppCompatImageHelper appCompatImageHelper = this.f1802b;
        if (appCompatImageHelper != null) {
            return appCompatImageHelper.d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        AppCompatImageHelper appCompatImageHelper = this.f1802b;
        if (appCompatImageHelper != null) {
            return appCompatImageHelper.e();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f1802b.f() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1801a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1801a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.g(i3);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        AppCompatImageHelper appCompatImageHelper = this.f1802b;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        AppCompatImageHelper appCompatImageHelper = this.f1802b;
        if (appCompatImageHelper != null && drawable != null && !this.f1803c) {
            appCompatImageHelper.h(drawable);
        }
        super.setImageDrawable(drawable);
        AppCompatImageHelper appCompatImageHelper2 = this.f1802b;
        if (appCompatImageHelper2 != null) {
            appCompatImageHelper2.c();
            if (this.f1803c) {
                return;
            }
            this.f1802b.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i3) {
        super.setImageLevel(i3);
        this.f1803c = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        this.f1802b.i(i3);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        AppCompatImageHelper appCompatImageHelper = this.f1802b;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.c();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1801a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1801a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        AppCompatImageHelper appCompatImageHelper = this.f1802b;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.j(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        AppCompatImageHelper appCompatImageHelper = this.f1802b;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.k(mode);
        }
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i3) {
        super(TintContextWrapper.b(context), attributeSet, i3);
        this.f1803c = false;
        ThemeUtils.a(this, getContext());
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.f1801a = appCompatBackgroundHelper;
        appCompatBackgroundHelper.e(attributeSet, i3);
        AppCompatImageHelper appCompatImageHelper = new AppCompatImageHelper(this);
        this.f1802b = appCompatImageHelper;
        appCompatImageHelper.g(attributeSet, i3);
    }
}
