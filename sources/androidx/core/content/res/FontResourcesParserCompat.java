package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.core.R;
import androidx.core.provider.FontRequest;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class FontResourcesParserCompat {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api21Impl {
        static int a(TypedArray typedArray, int i3) {
            return typedArray.getType(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface FamilyResourceEntry {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FetchStrategy {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class FontFamilyFilesResourceEntry implements FamilyResourceEntry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final FontFileResourceEntry[] f33893a;

        public FontFamilyFilesResourceEntry(FontFileResourceEntry[] fontFileResourceEntryArr) {
            this.f33893a = fontFileResourceEntryArr;
        }

        public FontFileResourceEntry[] a() {
            return this.f33893a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class FontFileResourceEntry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f33894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f33895b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f33896c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f33897d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f33898e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f33899f;

        public FontFileResourceEntry(String str, int i3, boolean z2, String str2, int i4, int i5) {
            this.f33894a = str;
            this.f33895b = i3;
            this.f33896c = z2;
            this.f33897d = str2;
            this.f33898e = i4;
            this.f33899f = i5;
        }

        public String a() {
            return this.f33894a;
        }

        public int b() {
            return this.f33899f;
        }

        public int c() {
            return this.f33898e;
        }

        public String d() {
            return this.f33897d;
        }

        public int e() {
            return this.f33895b;
        }

        public boolean f() {
            return this.f33896c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ProviderResourceEntry implements FamilyResourceEntry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final FontRequest f33900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final FontRequest f33901b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f33902c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f33903d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f33904e;

        public ProviderResourceEntry(FontRequest fontRequest, FontRequest fontRequest2, int i3, int i4, String str) {
            this.f33900a = fontRequest;
            this.f33901b = fontRequest2;
            this.f33903d = i3;
            this.f33902c = i4;
            this.f33904e = str;
        }

        public FontRequest a() {
            return this.f33901b;
        }

        public int b() {
            return this.f33903d;
        }

        public FontRequest c() {
            return this.f33900a;
        }

        public String d() {
            return this.f33904e;
        }

        public int e() {
            return this.f33902c;
        }
    }

    private static int a(TypedArray typedArray, int i3) {
        return Api21Impl.a(typedArray, i3);
    }

    public static FamilyResourceEntry b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List c(Resources resources, int i3) {
        if (i3 == 0) {
            return Collections.EMPTY_LIST;
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i3);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            if (a(typedArrayObtainTypedArray, 0) == 1) {
                for (int i4 = 0; i4 < typedArrayObtainTypedArray.length(); i4++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i4, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i3)));
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    private static FamilyResourceEntry d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static FamilyResourceEntry e(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.f33537h);
        String string = typedArrayObtainAttributes.getString(R.styleable.f33538i);
        String string2 = typedArrayObtainAttributes.getString(R.styleable.f33543n);
        String string3 = typedArrayObtainAttributes.getString(R.styleable.f33544o);
        String string4 = typedArrayObtainAttributes.getString(R.styleable.f33540k);
        int resourceId = typedArrayObtainAttributes.getResourceId(R.styleable.f33539j, 0);
        int integer = typedArrayObtainAttributes.getInteger(R.styleable.f33541l, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(R.styleable.f33542m, 500);
        String string5 = typedArrayObtainAttributes.getString(R.styleable.f33545p);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            List listC = c(resources, resourceId);
            return new ProviderResourceEntry(new FontRequest(string, string2, string3, listC), string4 != null ? new FontRequest(string, string2, string4, listC) : null, integer, integer2, string5);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new FontFamilyFilesResourceEntry((FontFileResourceEntry[]) arrayList.toArray(new FontFileResourceEntry[0]));
    }

    private static FontFileResourceEntry f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.f33546q);
        int i3 = R.styleable.f33555z;
        if (!typedArrayObtainAttributes.hasValue(i3)) {
            i3 = R.styleable.f33548s;
        }
        int i4 = typedArrayObtainAttributes.getInt(i3, RCHTTPStatusCodes.BAD_REQUEST);
        int i5 = R.styleable.f33553x;
        if (!typedArrayObtainAttributes.hasValue(i5)) {
            i5 = R.styleable.f33549t;
        }
        boolean z2 = 1 == typedArrayObtainAttributes.getInt(i5, 0);
        int i6 = R.styleable.A;
        if (!typedArrayObtainAttributes.hasValue(i6)) {
            i6 = R.styleable.f33550u;
        }
        int i7 = R.styleable.f33554y;
        if (!typedArrayObtainAttributes.hasValue(i7)) {
            i7 = R.styleable.f33551v;
        }
        String string = typedArrayObtainAttributes.getString(i7);
        int i8 = typedArrayObtainAttributes.getInt(i6, 0);
        int i9 = R.styleable.f33552w;
        if (!typedArrayObtainAttributes.hasValue(i9)) {
            i9 = R.styleable.f33547r;
        }
        int resourceId = typedArrayObtainAttributes.getResourceId(i9, 0);
        String string2 = typedArrayObtainAttributes.getString(i9);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new FontFileResourceEntry(string2, i4, z2, string, i8, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i3 = 1;
        while (i3 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i3++;
            } else if (next == 3) {
                i3--;
            }
        }
    }

    private static List h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
