package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.internal.NavContext;
import androidx.navigation.internal.NavGraphImpl;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.serialization.KSerializer;

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
public class NavGraph extends NavDestination implements Iterable<NavDestination>, KMappedMarker {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Companion f48886j = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final NavGraphImpl f48887i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final NavDestination c(NavDestination it) {
            Intrinsics.checkNotNullParameter(it, "it");
            if (!(it instanceof NavGraph)) {
                return null;
            }
            NavGraph navGraph = (NavGraph) it;
            return navGraph.J(navGraph.P());
        }

        public final Sequence b(NavGraph navGraph) {
            Intrinsics.checkNotNullParameter(navGraph, "<this>");
            return SequencesKt.h(navGraph, new Function1() { // from class: androidx.navigation.y
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NavGraph.Companion.c((NavDestination) obj);
                }
            });
        }

        public final NavDestination d(NavGraph navGraph) {
            Intrinsics.checkNotNullParameter(navGraph, "<this>");
            return (NavDestination) SequencesKt.L(b(navGraph));
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraph(Navigator navGraphNavigator) {
        super(navGraphNavigator);
        Intrinsics.checkNotNullParameter(navGraphNavigator, "navGraphNavigator");
        this.f48887i = new NavGraphImpl(this);
    }

    private final void Y(int i3) {
        this.f48887i.z(i3);
    }

    public final void H(NavDestination node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.f48887i.b(node);
    }

    public final void I(Collection nodes) {
        Intrinsics.checkNotNullParameter(nodes, "nodes");
        this.f48887i.c(nodes);
    }

    public final NavDestination J(int i3) {
        return this.f48887i.d(i3);
    }

    public final NavDestination K(String str) {
        return this.f48887i.e(str);
    }

    public final NavDestination L(String route, boolean z2) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.f48887i.f(route, z2);
    }

    public final NavDestination M(int i3, NavDestination navDestination, boolean z2, NavDestination navDestination2) {
        return this.f48887i.g(i3, navDestination, z2, navDestination2);
    }

    public final SparseArrayCompat N() {
        return this.f48887i.j();
    }

    public final String O() {
        return this.f48887i.k();
    }

    public final int P() {
        return this.f48887i.n();
    }

    public final String Q() {
        return this.f48887i.o();
    }

    public final NavDestination.DeepLinkMatch R(NavDeepLinkRequest navDeepLinkRequest, boolean z2, boolean z3, NavDestination lastVisited) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        Intrinsics.checkNotNullParameter(lastVisited, "lastVisited");
        return this.f48887i.r(super.v(navDeepLinkRequest), navDeepLinkRequest, z2, z3, lastVisited);
    }

    public final NavDestination.DeepLinkMatch S(String route, boolean z2, boolean z3, NavDestination lastVisited) {
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(lastVisited, "lastVisited");
        return this.f48887i.s(route, z2, z3, lastVisited);
    }

    public final void T(int i3) {
        this.f48887i.v(i3);
    }

    public final /* synthetic */ void U(Object startDestRoute) {
        Intrinsics.checkNotNullParameter(startDestRoute, "startDestRoute");
        this.f48887i.w(startDestRoute);
    }

    public final void W(String startDestRoute) {
        Intrinsics.checkNotNullParameter(startDestRoute, "startDestRoute");
        this.f48887i.x(startDestRoute);
    }

    public final void X(KSerializer serializer, Function1 parseRoute) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(parseRoute, "parseRoute");
        this.f48887i.y(serializer, parseRoute);
    }

    @Override // androidx.navigation.NavDestination
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof NavGraph) && super.equals(obj)) {
            NavGraph navGraph = (NavGraph) obj;
            if (N().q() == navGraph.N().q() && P() == navGraph.P()) {
                for (NavDestination navDestination : SequencesKt.e(SparseArrayKt.b(N()))) {
                    if (!Intrinsics.areEqual(navDestination, navGraph.N().g(navDestination.o()))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // androidx.navigation.NavDestination
    public int hashCode() {
        int iP = P();
        SparseArrayCompat sparseArrayCompatN = N();
        int iQ = sparseArrayCompatN.q();
        for (int i3 = 0; i3 < iQ; i3++) {
            iP = (((iP * 31) + sparseArrayCompatN.k(i3)) * 31) + ((NavDestination) sparseArrayCompatN.r(i3)).hashCode();
        }
        return iP;
    }

    @Override // java.lang.Iterable
    public final Iterator<NavDestination> iterator() {
        return this.f48887i.p();
    }

    @Override // androidx.navigation.NavDestination
    public String n() {
        return this.f48887i.i(super.n());
    }

    @Override // androidx.navigation.NavDestination
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        NavDestination navDestinationK = K(Q());
        if (navDestinationK == null) {
            navDestinationK = J(P());
        }
        sb.append(" startDestination=");
        if (navDestinationK != null) {
            sb.append("{");
            sb.append(navDestinationK.toString());
            sb.append("}");
        } else if (Q() != null) {
            sb.append(Q());
        } else if (this.f48887i.m() != null) {
            sb.append(this.f48887i.m());
        } else {
            sb.append("0x" + Integer.toHexString(this.f48887i.l()));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Override // androidx.navigation.NavDestination
    public NavDestination.DeepLinkMatch v(NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        return this.f48887i.q(super.v(navDeepLinkRequest), navDeepLinkRequest);
    }

    @Override // androidx.navigation.NavDestination
    public void x(Context context, AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        super.x(context, attrs);
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attrs, androidx.navigation.common.R.styleable.f49031v);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainAttributes, "obtainAttributes(...)");
        Y(typedArrayObtainAttributes.getResourceId(androidx.navigation.common.R.styleable.f49032w, 0));
        this.f48887i.t(NavDestination.f48864g.d(new NavContext(context), this.f48887i.l()));
        Unit unit = Unit.f139807a;
        typedArrayObtainAttributes.recycle();
    }
}
