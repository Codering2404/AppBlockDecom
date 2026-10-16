package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.os.BundleKt;
import androidx.navigation.NavArgument;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavOptions;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import com.facebook.LegacyTokenHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParserException;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class NavInflater {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f48918c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ThreadLocal f48919d = new ThreadLocal();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f48920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final NavigatorProvider f48921b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NavType a(TypedValue value, NavType navType, NavType expectedNavType, String str, String foundType) throws XmlPullParserException {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(expectedNavType, "expectedNavType");
            Intrinsics.checkNotNullParameter(foundType, "foundType");
            if (navType == null || navType == expectedNavType) {
                return navType == null ? expectedNavType : navType;
            }
            throw new XmlPullParserException("Type is " + str + " but found " + foundType + ": " + value.data);
        }

        private Companion() {
        }
    }

    public NavInflater(Context context, NavigatorProvider navigatorProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(navigatorProvider, "navigatorProvider");
        this.f48920a = context;
        this.f48921b = navigatorProvider;
    }

    private final NavDestination a(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, int i3) throws XmlPullParserException, IOException {
        int depth;
        NavigatorProvider navigatorProvider = this.f48921b;
        String name = xmlResourceParser.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        NavDestination navDestinationC = navigatorProvider.e(name).c();
        navDestinationC.x(this.f48920a, attributeSet);
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2) {
                String name2 = xmlResourceParser.getName();
                if (Intrinsics.areEqual("argument", name2)) {
                    f(resources, navDestinationC, attributeSet, i3);
                } else if (Intrinsics.areEqual(SDKConstants.PARAM_DEEP_LINK, name2)) {
                    g(resources, navDestinationC, attributeSet);
                } else if (Intrinsics.areEqual("action", name2)) {
                    c(resources, navDestinationC, attributeSet, xmlResourceParser, i3);
                } else {
                    Resources resources2 = resources;
                    XmlResourceParser xmlResourceParser2 = xmlResourceParser;
                    AttributeSet attributeSet2 = attributeSet;
                    int i4 = i3;
                    if (Intrinsics.areEqual("include", name2) && (navDestinationC instanceof NavGraph)) {
                        TypedArray typedArrayObtainAttributes = resources2.obtainAttributes(attributeSet2, R.styleable.f49005i);
                        Intrinsics.checkNotNullExpressionValue(typedArrayObtainAttributes, "obtainAttributes(...)");
                        ((NavGraph) navDestinationC).H(b(typedArrayObtainAttributes.getResourceId(R.styleable.f49006j, 0)));
                        Unit unit = Unit.f139807a;
                        typedArrayObtainAttributes.recycle();
                    } else if (navDestinationC instanceof NavGraph) {
                        ((NavGraph) navDestinationC).H(a(resources2, xmlResourceParser2, attributeSet2, i4));
                    }
                    resources = resources2;
                    attributeSet = attributeSet2;
                    xmlResourceParser = xmlResourceParser2;
                    i3 = i4;
                }
            }
        }
        return navDestinationC;
    }

    private final void c(Resources resources, NavDestination navDestination, AttributeSet attributeSet, XmlResourceParser xmlResourceParser, int i3) throws XmlPullParserException, IOException {
        Pair[] pairArr;
        int depth;
        Context context = this.f48920a;
        int[] NavAction = androidx.navigation.common.R.styleable.f49010a;
        Intrinsics.checkNotNullExpressionValue(NavAction, "NavAction");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, NavAction, 0, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(androidx.navigation.common.R.styleable.f49011b, 0);
        NavAction navAction = new NavAction(typedArrayObtainStyledAttributes.getResourceId(androidx.navigation.common.R.styleable.f49012c, 0), null, null, 6, null);
        NavOptions.Builder builder = new NavOptions.Builder();
        builder.d(typedArrayObtainStyledAttributes.getBoolean(androidx.navigation.common.R.styleable.f49015f, false));
        builder.l(typedArrayObtainStyledAttributes.getBoolean(androidx.navigation.common.R.styleable.f49021l, false));
        builder.g(typedArrayObtainStyledAttributes.getResourceId(androidx.navigation.common.R.styleable.f49018i, -1), typedArrayObtainStyledAttributes.getBoolean(androidx.navigation.common.R.styleable.f49019j, false), typedArrayObtainStyledAttributes.getBoolean(androidx.navigation.common.R.styleable.f49020k, false));
        builder.b(typedArrayObtainStyledAttributes.getResourceId(androidx.navigation.common.R.styleable.f49013d, -1));
        builder.c(typedArrayObtainStyledAttributes.getResourceId(androidx.navigation.common.R.styleable.f49014e, -1));
        builder.e(typedArrayObtainStyledAttributes.getResourceId(androidx.navigation.common.R.styleable.f49016g, -1));
        builder.f(typedArrayObtainStyledAttributes.getResourceId(androidx.navigation.common.R.styleable.f49017h, -1));
        navAction.e(builder.a());
        Map mapEmptyMap = MapsKt.emptyMap();
        if (mapEmptyMap.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(mapEmptyMap.size());
            for (Map.Entry entry : mapEmptyMap.entrySet()) {
                arrayList.add(TuplesKt.a((String) entry.getKey(), entry.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleB = BundleKt.b((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        SavedStateWriter.a(bundleB);
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && Intrinsics.areEqual("argument", xmlResourceParser.getName())) {
                e(resources, bundleB, attributeSet, i3);
            }
        }
        if (!SavedStateReader.O(SavedStateReader.a(bundleB))) {
            navAction.d(bundleB);
        }
        navDestination.y(resourceId, navAction);
        typedArrayObtainStyledAttributes.recycle();
    }

    private final NavArgument d(TypedArray typedArray, Resources resources, int i3) throws XmlPullParserException {
        int iValueOf;
        NavArgument.Builder builder = new NavArgument.Builder();
        builder.c(typedArray.getBoolean(androidx.navigation.common.R.styleable.f49026q, false));
        ThreadLocal threadLocal = f48919d;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        TypedValue typedValue2 = typedValue;
        String string = typedArray.getString(androidx.navigation.common.R.styleable.f49025p);
        Object objL = null;
        NavType navTypeA = string != null ? NavType.f48956c.a(string, resources.getResourcePackageName(i3)) : null;
        int i4 = androidx.navigation.common.R.styleable.f49024o;
        if (typedArray.getValue(i4, typedValue2)) {
            NavType navType = NavType.f48958e;
            if (navTypeA == navType) {
                int i5 = typedValue2.resourceId;
                if (i5 != 0) {
                    iValueOf = Integer.valueOf(i5);
                } else {
                    if (typedValue2.type != 16 || typedValue2.data != 0) {
                        throw new XmlPullParserException("unsupported value '" + ((Object) typedValue2.string) + "' for " + navTypeA.b() + ". Must be a reference to a resource.");
                    }
                    iValueOf = 0;
                }
            } else {
                int i6 = typedValue2.resourceId;
                if (i6 != 0) {
                    if (navTypeA != null) {
                        throw new XmlPullParserException("unsupported value '" + ((Object) typedValue2.string) + "' for " + navTypeA.b() + ". You must use a \"" + navType.b() + "\" type to reference other resources.");
                    }
                    iValueOf = Integer.valueOf(i6);
                    navTypeA = navType;
                } else if (navTypeA == NavType.f48970q) {
                    objL = typedArray.getString(i4);
                } else {
                    int i7 = typedValue2.type;
                    if (i7 == 3) {
                        String string2 = typedValue2.string.toString();
                        if (navTypeA == null) {
                            navTypeA = NavType.f48956c.b(string2);
                        }
                        objL = navTypeA.l(string2);
                    } else if (i7 == 4) {
                        navTypeA = f48918c.a(typedValue2, navTypeA, NavType.f48964k, string, LegacyTokenHelper.TYPE_FLOAT);
                        objL = Float.valueOf(typedValue2.getFloat());
                    } else if (i7 == 5) {
                        navTypeA = f48918c.a(typedValue2, navTypeA, NavType.f48957d, string, ViewHierarchyConstants.DIMENSION_KEY);
                        objL = Integer.valueOf((int) typedValue2.getDimension(resources.getDisplayMetrics()));
                    } else if (i7 == 18) {
                        navTypeA = f48918c.a(typedValue2, navTypeA, NavType.f48967n, string, "boolean");
                        objL = Boolean.valueOf(typedValue2.data != 0);
                    } else {
                        if (i7 < 16 || i7 > 31) {
                            throw new XmlPullParserException("unsupported argument type " + typedValue2.type);
                        }
                        NavType navType2 = NavType.f48964k;
                        if (navTypeA == navType2) {
                            navTypeA = f48918c.a(typedValue2, navTypeA, navType2, string, LegacyTokenHelper.TYPE_FLOAT);
                            objL = Float.valueOf(typedValue2.data);
                        } else {
                            navTypeA = f48918c.a(typedValue2, navTypeA, NavType.f48957d, string, "integer");
                            objL = Integer.valueOf(typedValue2.data);
                        }
                    }
                }
            }
            objL = iValueOf;
        }
        if (objL != null) {
            builder.b(objL);
        }
        if (navTypeA != null) {
            builder.d(navTypeA);
        }
        return builder.a();
    }

    private final void e(Resources resources, Bundle bundle, AttributeSet attributeSet, int i3) throws XmlPullParserException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.f49022m);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainAttributes, "obtainAttributes(...)");
        String string = typedArrayObtainAttributes.getString(androidx.navigation.common.R.styleable.f49023n);
        if (string == null) {
            throw new XmlPullParserException("Arguments must have a name");
        }
        NavArgument navArgumentD = d(typedArrayObtainAttributes, resources, i3);
        if (navArgumentD.b()) {
            navArgumentD.e(string, bundle);
        }
        Unit unit = Unit.f139807a;
        typedArrayObtainAttributes.recycle();
    }

    private final void f(Resources resources, NavDestination navDestination, AttributeSet attributeSet, int i3) throws XmlPullParserException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.f49022m);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainAttributes, "obtainAttributes(...)");
        String string = typedArrayObtainAttributes.getString(androidx.navigation.common.R.styleable.f49023n);
        if (string == null) {
            throw new XmlPullParserException("Arguments must have a name");
        }
        navDestination.a(string, d(typedArrayObtainAttributes, resources, i3));
        Unit unit = Unit.f139807a;
        typedArrayObtainAttributes.recycle();
    }

    private final void g(Resources resources, NavDestination navDestination, AttributeSet attributeSet) throws XmlPullParserException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.f49027r);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainAttributes, "obtainAttributes(...)");
        String string = typedArrayObtainAttributes.getString(androidx.navigation.common.R.styleable.f49030u);
        String string2 = typedArrayObtainAttributes.getString(androidx.navigation.common.R.styleable.f49028s);
        String string3 = typedArrayObtainAttributes.getString(androidx.navigation.common.R.styleable.f49029t);
        if ((string == null || string.length() == 0) && ((string2 == null || string2.length() == 0) && (string3 == null || string3.length() == 0))) {
            throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
        }
        NavDeepLink.Builder builder = new NavDeepLink.Builder();
        if (string != null) {
            String packageName = this.f48920a.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            builder.d(StringsKt.O(string, "${applicationId}", packageName, false, 4, null));
        }
        if (string2 != null && string2.length() != 0) {
            String packageName2 = this.f48920a.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName2, "getPackageName(...)");
            builder.b(StringsKt.O(string2, "${applicationId}", packageName2, false, 4, null));
        }
        if (string3 != null) {
            String packageName3 = this.f48920a.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName3, "getPackageName(...)");
            builder.c(StringsKt.O(string3, "${applicationId}", packageName3, false, 4, null));
        }
        navDestination.b(builder.a());
        Unit unit = Unit.f139807a;
        typedArrayObtainAttributes.recycle();
    }

    public final NavGraph b(int i3) {
        int next;
        Resources resources = this.f48920a.getResources();
        XmlResourceParser xml = resources.getXml(i3);
        Intrinsics.checkNotNullExpressionValue(xml, "getXml(...)");
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            try {
                try {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } catch (Exception e3) {
                    throw new RuntimeException("Exception inflating " + resources.getResourceName(i3) + " line " + xml.getLineNumber(), e3);
                }
            } finally {
                xml.close();
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        Intrinsics.checkNotNull(resources);
        Intrinsics.checkNotNull(attributeSetAsAttributeSet);
        NavDestination navDestinationA = a(resources, xml, attributeSetAsAttributeSet, i3);
        if (navDestinationA instanceof NavGraph) {
            return (NavGraph) navDestinationA;
        }
        throw new IllegalArgumentException(("Root element <" + name + "> did not inflate into a NavGraph").toString());
    }
}
