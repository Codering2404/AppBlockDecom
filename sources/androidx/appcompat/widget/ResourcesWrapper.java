package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.core.content.res.ResourcesCompat;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class ResourcesWrapper extends Resources {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f2071a;

    public ResourcesWrapper(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f2071a = resources;
    }

    final Drawable a(int i3) {
        return super.getDrawable(i3);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i3) {
        return this.f2071a.getAnimation(i3);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i3) {
        return this.f2071a.getBoolean(i3);
    }

    @Override // android.content.res.Resources
    public int getColor(int i3) {
        return this.f2071a.getColor(i3);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i3) {
        return this.f2071a.getColorStateList(i3);
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.f2071a.getConfiguration();
    }

    @Override // android.content.res.Resources
    public float getDimension(int i3) {
        return this.f2071a.getDimension(i3);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i3) {
        return this.f2071a.getDimensionPixelOffset(i3);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i3) {
        return this.f2071a.getDimensionPixelSize(i3);
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.f2071a.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i3) {
        return this.f2071a.getDrawable(i3);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i3, int i4) {
        return ResourcesCompat.g(this.f2071a, i3, i4, null);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i3, int i4, int i5) {
        return this.f2071a.getFraction(i3, i4, i5);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        return this.f2071a.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i3) {
        return this.f2071a.getIntArray(i3);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i3) {
        return this.f2071a.getInteger(i3);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i3) {
        return this.f2071a.getLayout(i3);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i3) {
        return this.f2071a.getMovie(i3);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i3, int i4, Object... objArr) {
        return this.f2071a.getQuantityString(i3, i4, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i3, int i4) {
        return this.f2071a.getQuantityText(i3, i4);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i3) {
        return this.f2071a.getResourceEntryName(i3);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i3) {
        return this.f2071a.getResourceName(i3);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i3) {
        return this.f2071a.getResourcePackageName(i3);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i3) {
        return this.f2071a.getResourceTypeName(i3);
    }

    @Override // android.content.res.Resources
    public String getString(int i3) {
        return this.f2071a.getString(i3);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i3) {
        return this.f2071a.getStringArray(i3);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i3) {
        return this.f2071a.getText(i3);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i3) {
        return this.f2071a.getTextArray(i3);
    }

    @Override // android.content.res.Resources
    public void getValue(int i3, TypedValue typedValue, boolean z2) {
        this.f2071a.getValue(i3, typedValue, z2);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i3, int i4, TypedValue typedValue, boolean z2) {
        this.f2071a.getValueForDensity(i3, i4, typedValue, z2);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i3) {
        return this.f2071a.getXml(i3);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f2071a.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i3) {
        return this.f2071a.obtainTypedArray(i3);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i3) {
        return this.f2071a.openRawResource(i3);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i3) {
        return this.f2071a.openRawResourceFd(i3);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.f2071a.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.f2071a.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.f2071a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i3, Resources.Theme theme) {
        return ResourcesCompat.f(this.f2071a, i3, theme);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i3, int i4, Resources.Theme theme) {
        return ResourcesCompat.g(this.f2071a, i3, i4, theme);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i3, int i4) {
        return this.f2071a.getQuantityString(i3, i4);
    }

    @Override // android.content.res.Resources
    public String getString(int i3, Object... objArr) {
        return this.f2071a.getString(i3, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i3, CharSequence charSequence) {
        return this.f2071a.getText(i3, charSequence);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z2) {
        this.f2071a.getValue(str, typedValue, z2);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i3, TypedValue typedValue) {
        return this.f2071a.openRawResource(i3, typedValue);
    }
}
