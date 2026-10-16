package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
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
public final class NavDeepLink {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Companion f48815q = new Companion(null);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Regex f48816r = new Regex("^[a-zA-Z]+[+\\w\\-.]*:");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final Regex f48817s = new Regex("\\{(.+?)\\}");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final Regex f48818t = new Regex("http[s]?://");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final Regex f48819u = new Regex(".*");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final Regex f48820v = new Regex("([^/]*?|)");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final Regex f48821w = new Regex("^[^?#]+\\?([^#]*).*");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f48822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f48823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f48824c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f48826e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f48829h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f48830i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f48831j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f48832k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f48833l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f48834m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f48835n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f48836o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f48837p;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f48825d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f48827f = LazyKt.b(new Function0() { // from class: androidx.navigation.m
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NavDeepLink.W(this.f49409a);
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f48828g = LazyKt.b(new Function0() { // from class: androidx.navigation.n
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Boolean.valueOf(NavDeepLink.J(this.f49410a));
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Companion f48838d = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f48839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f48840b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f48841c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public final NavDeepLink a() {
            return new NavDeepLink(this.f48839a, this.f48840b, this.f48841c);
        }

        public final Builder b(String action) {
            Intrinsics.checkNotNullParameter(action, "action");
            if (action.length() <= 0) {
                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
            }
            this.f48840b = action;
            return this;
        }

        public final Builder c(String mimeType) {
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            this.f48841c = mimeType;
            return this;
        }

        public final Builder d(String uriPattern) {
            Intrinsics.checkNotNullParameter(uriPattern, "uriPattern");
            this.f48839a = uriPattern;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class MimeType implements Comparable<MimeType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f48842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f48843b;

        public MimeType(String mimeType) {
            List listEmptyList;
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            List listM = new Regex("/").m(mimeType, 0);
            if (listM.isEmpty()) {
                listEmptyList = CollectionsKt.emptyList();
            } else {
                ListIterator listIterator = listM.listIterator(listM.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        listEmptyList = CollectionsKt.take(listM, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                listEmptyList = CollectionsKt.emptyList();
            }
            this.f48842a = (String) listEmptyList.get(0);
            this.f48843b = (String) listEmptyList.get(1);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(MimeType other) {
            Intrinsics.checkNotNullParameter(other, "other");
            int i3 = Intrinsics.areEqual(this.f48842a, other.f48842a) ? 2 : 0;
            return Intrinsics.areEqual(this.f48843b, other.f48843b) ? i3 + 1 : i3;
        }

        public final String b() {
            return this.f48843b;
        }

        public final String c() {
            return this.f48842a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class ParamQuery {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f48844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f48845b = new ArrayList();

        public final void a(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.f48845b.add(name);
        }

        public final List b() {
            return this.f48845b;
        }

        public final String c() {
            return this.f48844a;
        }

        public final void d(String str) {
            this.f48844a = str;
        }
    }

    public NavDeepLink(String str, String str2, String str3) {
        this.f48822a = str;
        this.f48823b = str2;
        this.f48824c = str3;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139763c;
        this.f48829h = LazyKt.a(lazyThreadSafetyMode, new Function0() { // from class: androidx.navigation.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NavDeepLink.X(this.f49411a);
            }
        });
        this.f48831j = LazyKt.a(lazyThreadSafetyMode, new Function0() { // from class: androidx.navigation.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NavDeepLink.l(this.f49412a);
            }
        });
        this.f48832k = LazyKt.a(lazyThreadSafetyMode, new Function0() { // from class: androidx.navigation.q
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NavDeepLink.m(this.f49413a);
            }
        });
        this.f48833l = LazyKt.a(lazyThreadSafetyMode, new Function0() { // from class: androidx.navigation.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NavDeepLink.o(this.f49414a);
            }
        });
        this.f48834m = LazyKt.b(new Function0() { // from class: androidx.navigation.t
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NavDeepLink.n(this.f49488a);
            }
        });
        this.f48836o = LazyKt.b(new Function0() { // from class: androidx.navigation.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NavDeepLink.O(this.f49489a);
            }
        });
        U();
        T();
    }

    private final void A(String str, Bundle bundle, Map map) {
        MatchResult matchResultJ;
        String strB;
        Regex regexT = t();
        if (regexT == null || (matchResultJ = regexT.j(String.valueOf(str))) == null) {
            return;
        }
        List listR = r();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listR, 10));
        int i3 = 0;
        for (Object obj : listR) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str2 = (String) obj;
            MatchGroup matchGroup = matchResultJ.d().get(i4);
            String strA = (matchGroup == null || (strB = matchGroup.b()) == null) ? null : NavUriUtils.f48980a.a(strB);
            if (strA == null) {
                strA = "";
            }
            try {
                P(bundle, str2, strA, (NavArgument) map.get(str2));
                arrayList.add(Unit.f139807a);
                i3 = i4;
            } catch (IllegalArgumentException unused) {
                return;
            }
        }
    }

    private final Regex D() {
        return (Regex) this.f48836o.getValue();
    }

    private final Regex E() {
        return (Regex) this.f48827f.getValue();
    }

    private final Map F() {
        return (Map) this.f48829h.getValue();
    }

    private final boolean I() {
        return ((Boolean) this.f48828g.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean J(NavDeepLink navDeepLink) {
        String str = navDeepLink.f48822a;
        return str != null && f48821w.k(str);
    }

    private final boolean K(String str) {
        String str2 = this.f48823b;
        if (str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return Intrinsics.areEqual(str2, str);
    }

    private final boolean L(String str) {
        if (this.f48824c == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        Regex regexD = D();
        Intrinsics.checkNotNull(regexD);
        return regexD.k(str);
    }

    private final boolean M(Uri uri) {
        if (E() == null) {
            return true;
        }
        if (uri == null) {
            return false;
        }
        Regex regexE = E();
        Intrinsics.checkNotNull(regexE);
        return regexE.k(uri.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Regex O(NavDeepLink navDeepLink) {
        String str = navDeepLink.f48835n;
        if (str != null) {
            return new Regex(str);
        }
        return null;
    }

    private final void P(Bundle bundle, String str, String str2, NavArgument navArgument) {
        if (navArgument != null) {
            navArgument.a().d(bundle, str, str2);
        } else {
            SavedStateWriter.F(SavedStateWriter.a(bundle), str, str2);
        }
    }

    private final boolean Q(Bundle bundle, String str, String str2, NavArgument navArgument) {
        if (!SavedStateReader.b(SavedStateReader.a(bundle), str)) {
            return true;
        }
        if (navArgument == null) {
            return false;
        }
        NavType navTypeA = navArgument.a();
        navTypeA.e(bundle, str, str2, navTypeA.a(bundle, str));
        return false;
    }

    private final Pair R() {
        String str = this.f48822a;
        if (str == null) {
            return null;
        }
        NavUriUtils navUriUtils = NavUriUtils.f48980a;
        if (navUriUtils.d(str).getFragment() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String fragment = navUriUtils.d(this.f48822a).getFragment();
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkNotNull(fragment);
        j(fragment, arrayList, sb);
        return TuplesKt.a(arrayList, sb.toString());
    }

    private final boolean S(List list, ParamQuery paramQuery, Bundle bundle, Map map) {
        Pair[] pairArr;
        Object objValueOf;
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
        Iterator it = paramQuery.b().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            NavArgument navArgument = (NavArgument) map.get(str);
            NavType navTypeA = navArgument != null ? navArgument.a() : null;
            if ((navTypeA instanceof CollectionNavType) && !navArgument.b()) {
                CollectionNavType collectionNavType = (CollectionNavType) navTypeA;
                collectionNavType.h(bundleB, str, collectionNavType.k());
            }
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            String strC = paramQuery.c();
            MatchResult matchResultJ = strC != null ? new Regex(strC).j(str2) : null;
            if (matchResultJ == null) {
                return false;
            }
            List listB = paramQuery.b();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listB, 10));
            int i3 = 0;
            for (Object obj : listB) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str3 = (String) obj;
                MatchGroup matchGroup = matchResultJ.d().get(i4);
                String strB = matchGroup != null ? matchGroup.b() : null;
                if (strB == null) {
                    strB = "";
                }
                NavArgument navArgument2 = (NavArgument) map.get(str3);
                try {
                    if (SavedStateReader.b(SavedStateReader.a(bundleB), str3)) {
                        objValueOf = Boolean.valueOf(Q(bundleB, str3, strB, navArgument2));
                    } else {
                        P(bundleB, str3, strB, navArgument2);
                        objValueOf = Unit.f139807a;
                    }
                } catch (IllegalArgumentException unused) {
                    objValueOf = Unit.f139807a;
                }
                arrayList2.add(objValueOf);
                i3 = i4;
            }
        }
        SavedStateWriter.d(SavedStateWriter.a(bundle), bundleB);
        return true;
    }

    private final void T() {
        if (this.f48824c == null) {
            return;
        }
        if (!new Regex("^[\\s\\S]+/[\\s\\S]+$").k(this.f48824c)) {
            throw new IllegalArgumentException(("The given mimeType " + this.f48824c + " does not match to required \"type/subtype\" format").toString());
        }
        MimeType mimeType = new MimeType(this.f48824c);
        this.f48835n = StringsKt.O("^(" + mimeType.c() + "|[*]+)/(" + mimeType.b() + "|[*]+)$", "*|[*]", "[\\s\\S]", false, 4, null);
    }

    private final void U() {
        if (this.f48822a == null) {
            return;
        }
        StringBuilder sb = new StringBuilder("^");
        if (!f48816r.c(this.f48822a)) {
            sb.append(f48818t.i());
        }
        boolean z2 = false;
        MatchResult matchResultE = Regex.e(new Regex("(\\?|#|$)"), this.f48822a, 0, 2, null);
        if (matchResultE != null) {
            String strSubstring = this.f48822a.substring(0, matchResultE.c().g());
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            j(strSubstring, this.f48825d, sb);
            if (!f48819u.c(sb) && !f48820v.c(sb)) {
                z2 = true;
            }
            this.f48837p = z2;
            sb.append("($|(\\?(.)*)|(#(.)*))");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.f48826e = Y(string);
    }

    private final Map V() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (I()) {
            NavUriUtils navUriUtils = NavUriUtils.f48980a;
            String str = this.f48822a;
            Intrinsics.checkNotNull(str);
            Uri uriD = navUriUtils.d(str);
            for (String str2 : uriD.getQueryParameterNames()) {
                StringBuilder sb = new StringBuilder();
                List<String> queryParameters = uriD.getQueryParameters(str2);
                if (queryParameters.size() > 1) {
                    throw new IllegalArgumentException(("Query parameter " + str2 + " must only be present once in " + this.f48822a + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
                }
                String str3 = (String) CollectionsKt.firstOrNull((List) queryParameters);
                if (str3 == null) {
                    this.f48830i = true;
                    str3 = str2;
                }
                int iH = 0;
                ParamQuery paramQuery = new ParamQuery();
                for (MatchResult matchResultE = Regex.e(f48817s, str3, 0, 2, null); matchResultE != null; matchResultE = matchResultE.next()) {
                    MatchGroup matchGroup = matchResultE.d().get(1);
                    Intrinsics.checkNotNull(matchGroup);
                    paramQuery.a(matchGroup.b());
                    if (matchResultE.c().g() > iH) {
                        String strSubstring = str3.substring(iH, matchResultE.c().g());
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        sb.append(Regex.f140573b.c(strSubstring));
                    }
                    sb.append("([\\s\\S]+?)?");
                    iH = matchResultE.c().h() + 1;
                }
                if (iH < str3.length()) {
                    Regex.Companion companion = Regex.f140573b;
                    String strSubstring2 = str3.substring(iH);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                    sb.append(companion.c(strSubstring2));
                }
                sb.append("$");
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                paramQuery.d(Y(string));
                linkedHashMap.put(str2, paramQuery);
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Regex W(NavDeepLink navDeepLink) {
        String str = navDeepLink.f48826e;
        if (str != null) {
            return new Regex(str, RegexOption.f140589c);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map X(NavDeepLink navDeepLink) {
        return navDeepLink.V();
    }

    private final String Y(String str) {
        return (StringsKt.a0(str, "\\Q", false, 2, null) && StringsKt.a0(str, "\\E", false, 2, null)) ? StringsKt.O(str, ".*", "\\E.*\\Q", false, 4, null) : StringsKt.a0(str, "\\.\\*", false, 2, null) ? StringsKt.O(str, "\\.\\*", ".*", false, 4, null) : str;
    }

    private final void j(String str, List list, StringBuilder sb) {
        int iH = 0;
        for (MatchResult matchResultE = Regex.e(f48817s, str, 0, 2, null); matchResultE != null; matchResultE = matchResultE.next()) {
            MatchGroup matchGroup = matchResultE.d().get(1);
            Intrinsics.checkNotNull(matchGroup);
            list.add(matchGroup.b());
            if (matchResultE.c().g() > iH) {
                Regex.Companion companion = Regex.f140573b;
                String strSubstring = str.substring(iH, matchResultE.c().g());
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                sb.append(companion.c(strSubstring));
            }
            sb.append(f48820v.i());
            iH = matchResultE.c().h() + 1;
        }
        if (iH < str.length()) {
            Regex.Companion companion2 = Regex.f140573b;
            String strSubstring2 = str.substring(iH);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            sb.append(companion2.c(strSubstring2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair l(NavDeepLink navDeepLink) {
        return navDeepLink.R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List m(NavDeepLink navDeepLink) {
        List list;
        Pair pairS = navDeepLink.s();
        return (pairS == null || (list = (List) pairS.e()) == null) ? new ArrayList() : list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Regex n(NavDeepLink navDeepLink) {
        String strU = navDeepLink.u();
        if (strU != null) {
            return new Regex(strU, RegexOption.f140589c);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String o(NavDeepLink navDeepLink) {
        Pair pairS = navDeepLink.s();
        if (pairS != null) {
            return (String) pairS.f();
        }
        return null;
    }

    private final List r() {
        return (List) this.f48832k.getValue();
    }

    private final Pair s() {
        return (Pair) this.f48831j.getValue();
    }

    private final Regex t() {
        return (Regex) this.f48834m.getValue();
    }

    private final String u() {
        return (String) this.f48833l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean w(Bundle bundle, String argName) {
        Intrinsics.checkNotNullParameter(argName, "argName");
        return !SavedStateReader.b(SavedStateReader.a(bundle), argName);
    }

    private final boolean y(MatchResult matchResult, Bundle bundle, Map map) {
        String strB;
        List list = this.f48825d;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i3 = 0;
        for (Object obj : list) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            MatchGroup matchGroup = matchResult.d().get(i4);
            String strA = (matchGroup == null || (strB = matchGroup.b()) == null) ? null : NavUriUtils.f48980a.a(strB);
            if (strA == null) {
                strA = "";
            }
            try {
                P(bundle, str, strA, (NavArgument) map.get(str));
                arrayList.add(Unit.f139807a);
                i3 = i4;
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }
        return true;
    }

    private final boolean z(Uri uri, Bundle bundle, Map map) {
        String query;
        for (Map.Entry entry : F().entrySet()) {
            String str = (String) entry.getKey();
            ParamQuery paramQuery = (ParamQuery) entry.getValue();
            List<String> queryParameters = uri.getQueryParameters(str);
            if (this.f48830i && (query = uri.getQuery()) != null && !Intrinsics.areEqual(query, uri.toString())) {
                queryParameters = CollectionsKt.listOf(query);
            }
            if (!S(queryParameters, paramQuery, bundle, map)) {
                return false;
            }
        }
        return true;
    }

    public final String B() {
        return this.f48824c;
    }

    public final int C(String mimeType) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        if (this.f48824c == null) {
            return -1;
        }
        Regex regexD = D();
        Intrinsics.checkNotNull(regexD);
        if (regexD.k(mimeType)) {
            return new MimeType(this.f48824c).compareTo(new MimeType(mimeType));
        }
        return -1;
    }

    public final String G() {
        return this.f48822a;
    }

    public final boolean H() {
        return this.f48837p;
    }

    public final boolean N(NavDeepLinkRequest deepLinkRequest) {
        Intrinsics.checkNotNullParameter(deepLinkRequest, "deepLinkRequest");
        return M(deepLinkRequest.c()) && K(deepLinkRequest.a()) && L(deepLinkRequest.b());
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof NavDeepLink)) {
            NavDeepLink navDeepLink = (NavDeepLink) obj;
            if (Intrinsics.areEqual(this.f48822a, navDeepLink.f48822a) && Intrinsics.areEqual(this.f48823b, navDeepLink.f48823b) && Intrinsics.areEqual(this.f48824c, navDeepLink.f48824c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f48822a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f48823b;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f48824c;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final int k(Uri uri) {
        if (uri == null || this.f48822a == null) {
            return 0;
        }
        return CollectionsKt.intersect(uri.getPathSegments(), NavUriUtils.f48980a.d(this.f48822a).getPathSegments()).size();
    }

    public final String p() {
        return this.f48823b;
    }

    public final List q() {
        List list = this.f48825d;
        Collection collectionValues = F().values();
        ArrayList arrayList = new ArrayList();
        Iterator it = collectionValues.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((ParamQuery) it.next()).b());
        }
        return CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) list, (Iterable) arrayList), (Iterable) r());
    }

    public final Bundle v(Uri deepLink, Map arguments) {
        MatchResult matchResultJ;
        Pair[] pairArr;
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Regex regexE = E();
        if (regexE == null || (matchResultJ = regexE.j(deepLink.toString())) == null) {
            return null;
        }
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
        final Bundle bundleB = BundleKt.b((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        SavedStateWriter.a(bundleB);
        if (!y(matchResultJ, bundleB, arguments)) {
            return null;
        }
        if (I() && !z(deepLink, bundleB, arguments)) {
            return null;
        }
        A(deepLink.getFragment(), bundleB, arguments);
        if (NavArgumentKt.a(arguments, new Function1() { // from class: androidx.navigation.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(NavDeepLink.w(bundleB, (String) obj));
            }
        }).isEmpty()) {
            return bundleB;
        }
        return null;
    }

    public final Bundle x(Uri uri, Map arguments) {
        Pair[] pairArr;
        Regex regexE;
        MatchResult matchResultJ;
        Intrinsics.checkNotNullParameter(arguments, "arguments");
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
        if (uri != null && (regexE = E()) != null && (matchResultJ = regexE.j(uri.toString())) != null) {
            y(matchResultJ, bundleB, arguments);
            if (I()) {
                z(uri, bundleB, arguments);
            }
        }
        return bundleB;
    }
}
