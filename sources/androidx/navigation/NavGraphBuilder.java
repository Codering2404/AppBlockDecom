package androidx.navigation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.SerializersKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@NavDestinationDsl
@Metadata
public class NavGraphBuilder extends NavDestinationBuilder<NavGraph> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final NavigatorProvider f48888i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f48889j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f48890k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private KClass f48891l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Object f48892m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final List f48893n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraphBuilder(NavigatorProvider provider, String startDestination, String str) {
        super(provider.d(NavGraphNavigator.class), str);
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(startDestination, "startDestination");
        this.f48893n = new ArrayList();
        this.f48888i = provider;
        this.f48890k = startDestination;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String h(NavDestination it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String strT = it.t();
        Intrinsics.checkNotNull(strT);
        return strT;
    }

    @Override // androidx.navigation.NavDestinationBuilder
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public NavGraph b() {
        NavGraph navGraph = (NavGraph) super.b();
        navGraph.I(this.f48893n);
        int i3 = this.f48889j;
        if (i3 == 0 && this.f48890k == null && this.f48891l == null && this.f48892m == null) {
            if (d() != null) {
                throw new IllegalStateException("You must set a start destination route");
            }
            throw new IllegalStateException("You must set a start destination id");
        }
        String str = this.f48890k;
        if (str != null) {
            Intrinsics.checkNotNull(str);
            navGraph.W(str);
            return navGraph;
        }
        KClass kClass = this.f48891l;
        if (kClass != null) {
            Intrinsics.checkNotNull(kClass);
            navGraph.X(SerializersKt.c(kClass), new Function1() { // from class: androidx.navigation.z
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NavGraphBuilder.h((NavDestination) obj);
                }
            });
            return navGraph;
        }
        Object obj = this.f48892m;
        if (obj == null) {
            navGraph.T(i3);
            return navGraph;
        }
        Intrinsics.checkNotNull(obj);
        navGraph.U(obj);
        return navGraph;
    }

    public final void i(NavDestinationBuilder navDestination) {
        Intrinsics.checkNotNullParameter(navDestination, "navDestination");
        this.f48893n.add(navDestination.b());
    }

    public final NavigatorProvider j() {
        return this.f48888i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraphBuilder(NavigatorProvider provider, Object startDestination, KClass kClass, Map typeMap) {
        super(provider.d(NavGraphNavigator.class), kClass, typeMap);
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(startDestination, "startDestination");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        this.f48893n = new ArrayList();
        this.f48888i = provider;
        this.f48892m = startDestination;
    }
}
