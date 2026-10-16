package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ComplexColorCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Shader f33890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorStateList f33891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f33892c;

    private ComplexColorCompat(Shader shader, ColorStateList colorStateList, int i3) {
        this.f33890a = shader;
        this.f33891b = colorStateList;
        this.f33892c = i3;
    }

    private static ComplexColorCompat a(Resources resources, int i3, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        XmlResourceParser xml = resources.getXml(i3);
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        name.getClass();
        if (name.equals("gradient")) {
            return d(GradientColorInflaterCompat.b(resources, xml, attributeSetAsAttributeSet, theme));
        }
        if (name.equals("selector")) {
            return c(ColorStateListInflaterCompat.b(resources, xml, attributeSetAsAttributeSet, theme));
        }
        throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
    }

    static ComplexColorCompat b(int i3) {
        return new ComplexColorCompat(null, null, i3);
    }

    static ComplexColorCompat c(ColorStateList colorStateList) {
        return new ComplexColorCompat(null, colorStateList, colorStateList.getDefaultColor());
    }

    static ComplexColorCompat d(Shader shader) {
        return new ComplexColorCompat(shader, null, 0);
    }

    public static ComplexColorCompat g(Resources resources, int i3, Resources.Theme theme) {
        try {
            return a(resources, i3, theme);
        } catch (Exception e3) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e3);
            return null;
        }
    }

    public int e() {
        return this.f33892c;
    }

    public Shader f() {
        return this.f33890a;
    }

    public boolean h() {
        return this.f33890a != null;
    }

    public boolean i() {
        ColorStateList colorStateList;
        return this.f33890a == null && (colorStateList = this.f33891b) != null && colorStateList.isStateful();
    }

    public boolean j(int[] iArr) {
        if (!i()) {
            return false;
        }
        ColorStateList colorStateList = this.f33891b;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (colorForState == this.f33892c) {
            return false;
        }
        this.f33892c = colorForState;
        return true;
    }

    public void k(int i3) {
        this.f33892c = i3;
    }

    public boolean l() {
        return h() || this.f33892c != 0;
    }
}
