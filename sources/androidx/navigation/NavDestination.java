package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import androidx.navigation.NavDestination;
import androidx.navigation.internal.NavContext;
import androidx.navigation.internal.NavDestinationImpl;
import androidx.savedstate.SavedStateReader;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

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
public class NavDestination {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f48864g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Map f48865h = new LinkedHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f48866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final NavDestinationImpl f48867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private NavGraph f48868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CharSequence f48869d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SparseArrayCompat f48870f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata
    @kotlin.annotation.Target
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention
    public @interface ClassType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final NavDestination b(NavDestination it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.s();
        }

        public final String c(String str) {
            if (str == null) {
                return "";
            }
            return "android-app://androidx.navigation/" + str;
        }

        public final String d(NavContext context, int i3) {
            Intrinsics.checkNotNullParameter(context, "context");
            return i3 <= 16777215 ? String.valueOf(i3) : context.c(i3);
        }

        public final Sequence e(NavDestination navDestination) {
            Intrinsics.checkNotNullParameter(navDestination, "<this>");
            return SequencesKt.h(navDestination, new Function1() { // from class: androidx.navigation.x
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NavDestination.Companion.b((NavDestination) obj);
                }
            });
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DeepLinkMatch implements Comparable<DeepLinkMatch> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NavDestination f48871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Bundle f48872b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f48873c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f48874d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f48875f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f48876g;

        public DeepLinkMatch(NavDestination destination, Bundle bundle, boolean z2, int i3, boolean z3, int i4) {
            Intrinsics.checkNotNullParameter(destination, "destination");
            this.f48871a = destination;
            this.f48872b = bundle;
            this.f48873c = z2;
            this.f48874d = i3;
            this.f48875f = z3;
            this.f48876g = i4;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(DeepLinkMatch other) {
            Intrinsics.checkNotNullParameter(other, "other");
            boolean z2 = this.f48873c;
            if (z2 && !other.f48873c) {
                return 1;
            }
            if (!z2 && other.f48873c) {
                return -1;
            }
            int i3 = this.f48874d - other.f48874d;
            if (i3 > 0) {
                return 1;
            }
            if (i3 < 0) {
                return -1;
            }
            Bundle bundle = this.f48872b;
            if (bundle != null && other.f48872b == null) {
                return 1;
            }
            if (bundle == null && other.f48872b != null) {
                return -1;
            }
            if (bundle != null) {
                int iQ = SavedStateReader.Q(SavedStateReader.a(bundle));
                Bundle bundle2 = other.f48872b;
                Intrinsics.checkNotNull(bundle2);
                int iQ2 = iQ - SavedStateReader.Q(SavedStateReader.a(bundle2));
                if (iQ2 > 0) {
                    return 1;
                }
                if (iQ2 < 0) {
                    return -1;
                }
            }
            boolean z3 = this.f48875f;
            if (z3 && !other.f48875f) {
                return 1;
            }
            if (z3 || !other.f48875f) {
                return this.f48876g - other.f48876g;
            }
            return -1;
        }

        public final NavDestination b() {
            return this.f48871a;
        }

        public final Bundle c() {
            return this.f48872b;
        }

        public final boolean d(Bundle bundle) {
            Bundle bundle2;
            if (bundle == null || (bundle2 = this.f48872b) == null) {
                return false;
            }
            Set<String> setKeySet = bundle2.keySet();
            Intrinsics.checkNotNullExpressionValue(setKeySet, "keySet(...)");
            for (String str : setKeySet) {
                Bundle bundleA = SavedStateReader.a(bundle);
                Intrinsics.checkNotNull(str);
                if (!SavedStateReader.b(bundleA, str)) {
                    return false;
                }
                NavArgument navArgument = (NavArgument) this.f48871a.h().get(str);
                NavType navTypeA = navArgument != null ? navArgument.a() : null;
                Object objA = navTypeA != null ? navTypeA.a(this.f48872b, str) : null;
                Object objA2 = navTypeA != null ? navTypeA.a(bundle, str) : null;
                if (navTypeA != null && !navTypeA.j(objA, objA2)) {
                    return false;
                }
            }
            return true;
        }
    }

    public NavDestination(String navigatorName) {
        Intrinsics.checkNotNullParameter(navigatorName, "navigatorName");
        this.f48866a = navigatorName;
        this.f48867b = new NavDestinationImpl(this);
        this.f48870f = new SparseArrayCompat(0, 1, null);
    }

    private final void B(String str) {
        this.f48867b.v(str);
    }

    public static /* synthetic */ int[] f(NavDestination navDestination, NavDestination navDestination2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildDeepLinkIds");
        }
        if ((i3 & 1) != 0) {
            navDestination2 = null;
        }
        return navDestination.e(navDestination2);
    }

    private final List l() {
        return this.f48867b.l();
    }

    private final String p() {
        return this.f48867b.n();
    }

    public final void A(int i3) {
        this.f48867b.u(i3);
    }

    public final void C(CharSequence charSequence) {
        this.f48869d = charSequence;
    }

    public final void D(NavGraph navGraph) {
        this.f48868c = navGraph;
    }

    public final void E(String str) {
        this.f48867b.w(str);
    }

    public boolean G() {
        return true;
    }

    public final void a(String argumentName, NavArgument argument) {
        Intrinsics.checkNotNullParameter(argumentName, "argumentName");
        Intrinsics.checkNotNullParameter(argument, "argument");
        this.f48867b.g(argumentName, argument);
    }

    public final void b(NavDeepLink navDeepLink) {
        Intrinsics.checkNotNullParameter(navDeepLink, "navDeepLink");
        this.f48867b.i(navDeepLink);
    }

    public final Bundle d(Bundle bundle) {
        return this.f48867b.j(bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int[] e(androidx.navigation.NavDestination r6) {
        /*
            r5 = this;
            kotlin.collections.ArrayDeque r0 = new kotlin.collections.ArrayDeque
            r0.<init>()
            r1 = r5
        L6:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.navigation.NavGraph r2 = r1.f48868c
            if (r6 == 0) goto L10
            androidx.navigation.NavGraph r3 = r6.f48868c
            goto L11
        L10:
            r3 = 0
        L11:
            if (r3 == 0) goto L26
            androidx.navigation.NavGraph r3 = r6.f48868c
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            int r4 = r1.o()
            androidx.navigation.NavDestination r3 = r3.J(r4)
            if (r3 != r1) goto L26
            r0.addFirst(r1)
            goto L3e
        L26:
            if (r2 == 0) goto L32
            int r3 = r2.P()
            int r4 = r1.o()
            if (r3 == r4) goto L35
        L32:
            r0.addFirst(r1)
        L35:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r6)
            if (r1 == 0) goto L3c
            goto L3e
        L3c:
            if (r2 != 0) goto L70
        L3e:
            java.util.List r6 = kotlin.collections.CollectionsKt.toList(r0)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r6, r1)
            r0.<init>(r1)
            java.util.Iterator r6 = r6.iterator()
        L53:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L6b
            java.lang.Object r1 = r6.next()
            androidx.navigation.NavDestination r1 = (androidx.navigation.NavDestination) r1
            int r1 = r1.o()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L53
        L6b:
            int[] r6 = kotlin.collections.CollectionsKt.toIntArray(r0)
            return r6
        L70:
            r1 = r2
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavDestination.e(androidx.navigation.NavDestination):int[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ae A[EDGE_INSN: B:31:0x00ae->B:32:0x00af BREAK  A[LOOP:1: B:23:0x007b->B:47:?]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r9) {
        /*
            Method dump skipped, instruction units count: 207
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavDestination.equals(java.lang.Object):boolean");
    }

    public final String g(Context context, Bundle bundle) {
        Map mapEmptyMap;
        String strValueOf;
        Intrinsics.checkNotNullParameter(context, "context");
        CharSequence charSequence = this.f48869d;
        if (charSequence == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(charSequence);
        StringBuffer stringBuffer = new StringBuffer();
        if (bundle == null || (mapEmptyMap = SavedStateReader.R(SavedStateReader.a(bundle))) == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            if (strGroup == null || !mapEmptyMap.containsKey(strGroup)) {
                throw new IllegalArgumentException(("Could not find \"" + strGroup + "\" in " + bundle + " to fill label \"" + ((Object) charSequence) + '\"').toString());
            }
            matcher.appendReplacement(stringBuffer, "");
            NavArgument navArgument = (NavArgument) h().get(strGroup);
            NavType navTypeA = navArgument != null ? navArgument.a() : null;
            NavType navType = NavType.f48958e;
            if (Intrinsics.areEqual(navTypeA, navType)) {
                Intrinsics.checkNotNull(bundle);
                Object objA = navType.a(bundle, strGroup);
                Intrinsics.checkNotNull(objA, "null cannot be cast to non-null type kotlin.Int");
                strValueOf = context.getString(((Integer) objA).intValue());
            } else {
                Intrinsics.checkNotNull(navTypeA);
                Intrinsics.checkNotNull(bundle);
                strValueOf = String.valueOf(navTypeA.a(bundle, strGroup));
            }
            Intrinsics.checkNotNull(strValueOf);
            stringBuffer.append(strValueOf);
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public final Map h() {
        return MapsKt.toMap(this.f48867b.k());
    }

    public int hashCode() {
        int iO = o() * 31;
        String strT = t();
        int iHashCode = iO + (strT != null ? strT.hashCode() : 0);
        for (NavDeepLink navDeepLink : l()) {
            int i3 = iHashCode * 31;
            String strG = navDeepLink.G();
            int iHashCode2 = (i3 + (strG != null ? strG.hashCode() : 0)) * 31;
            String strP = navDeepLink.p();
            int iHashCode3 = (iHashCode2 + (strP != null ? strP.hashCode() : 0)) * 31;
            String strB = navDeepLink.B();
            iHashCode = iHashCode3 + (strB != null ? strB.hashCode() : 0);
        }
        Iterator itB = SparseArrayKt.b(this.f48870f);
        while (itB.hasNext()) {
            NavAction navAction = (NavAction) itB.next();
            int iB = ((iHashCode * 31) + navAction.b()) * 31;
            NavOptions navOptionsC = navAction.c();
            iHashCode = iB + (navOptionsC != null ? navOptionsC.hashCode() : 0);
            Bundle bundleA = navAction.a();
            if (bundleA != null) {
                iHashCode = (iHashCode * 31) + SavedStateReader.d(SavedStateReader.a(bundleA));
            }
        }
        for (String str : h().keySet()) {
            int iHashCode4 = ((iHashCode * 31) + str.hashCode()) * 31;
            Object obj = h().get(str);
            iHashCode = iHashCode4 + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public String n() {
        String strP = p();
        return strP == null ? String.valueOf(o()) : strP;
    }

    public final int o() {
        return this.f48867b.m();
    }

    public final String q() {
        return this.f48866a;
    }

    public final NavGraph s() {
        return this.f48868c;
    }

    public final String t() {
        return this.f48867b.o();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        if (p() == null) {
            sb.append("0x");
            sb.append(Integer.toHexString(o()));
        } else {
            sb.append(p());
        }
        sb.append(")");
        String strT = t();
        if (strT != null && !StringsKt.p0(strT)) {
            sb.append(" route=");
            sb.append(t());
        }
        if (this.f48869d != null) {
            sb.append(" label=");
            sb.append(this.f48869d);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final boolean u(String route, Bundle bundle) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.f48867b.r(route, bundle);
    }

    public DeepLinkMatch v(NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        return this.f48867b.s(navDeepLinkRequest);
    }

    public final DeepLinkMatch w(String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.f48867b.t(route);
    }

    public void x(Context context, AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attrs, androidx.navigation.common.R.styleable.f49033x);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainAttributes, "obtainAttributes(...)");
        E(typedArrayObtainAttributes.getString(androidx.navigation.common.R.styleable.A));
        int i3 = androidx.navigation.common.R.styleable.f49035z;
        if (typedArrayObtainAttributes.hasValue(i3)) {
            A(typedArrayObtainAttributes.getResourceId(i3, 0));
            B(f48864g.d(new NavContext(context), o()));
        }
        this.f48869d = typedArrayObtainAttributes.getText(androidx.navigation.common.R.styleable.f49034y);
        Unit unit = Unit.f139807a;
        typedArrayObtainAttributes.recycle();
    }

    public final void y(int i3, NavAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (G()) {
            if (i3 == 0) {
                throw new IllegalArgumentException("Cannot have an action with actionId 0");
            }
            this.f48870f.m(i3, action);
        } else {
            throw new UnsupportedOperationException("Cannot add action " + i3 + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavDestination(Navigator navigator) {
        this(NavigatorProvider.f48985b.a(navigator.getClass()));
        Intrinsics.checkNotNullParameter(navigator, "navigator");
    }
}
