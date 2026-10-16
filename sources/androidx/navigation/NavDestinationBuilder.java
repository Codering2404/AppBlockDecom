package androidx.navigation;

import androidx.navigation.NavDestination;
import androidx.navigation.serialization.RouteSerializerKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
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
public class NavDestinationBuilder<D extends NavDestination> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Navigator f48877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f48878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f48879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map f48880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CharSequence f48881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map f48882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List f48883g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map f48884h;

    public NavDestinationBuilder(Navigator navigator, int i3, String str) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        this.f48877a = navigator;
        this.f48878b = i3;
        this.f48879c = str;
        this.f48882f = new LinkedHashMap();
        this.f48883g = new ArrayList();
        this.f48884h = new LinkedHashMap();
    }

    public final void a(String name, NavArgument argument) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(argument, "argument");
        this.f48882f.put(name, argument);
    }

    public NavDestination b() {
        NavDestination navDestinationE = e();
        navDestinationE.C(this.f48881e);
        for (Map.Entry entry : this.f48882f.entrySet()) {
            navDestinationE.a((String) entry.getKey(), (NavArgument) entry.getValue());
        }
        Iterator it = this.f48883g.iterator();
        while (it.hasNext()) {
            navDestinationE.b((NavDeepLink) it.next());
        }
        for (Map.Entry entry2 : this.f48884h.entrySet()) {
            navDestinationE.y(((Number) entry2.getKey()).intValue(), (NavAction) entry2.getValue());
        }
        String str = this.f48879c;
        if (str != null) {
            navDestinationE.E(str);
        }
        int i3 = this.f48878b;
        if (i3 != -1) {
            navDestinationE.A(i3);
        }
        return navDestinationE;
    }

    public final void c(NavDeepLink navDeepLink) {
        Intrinsics.checkNotNullParameter(navDeepLink, "navDeepLink");
        this.f48883g.add(navDeepLink);
    }

    public final String d() {
        return this.f48879c;
    }

    protected NavDestination e() {
        return this.f48877a.c();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavDestinationBuilder(Navigator navigator, String str) {
        this(navigator, -1, str);
        Intrinsics.checkNotNullParameter(navigator, "navigator");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public NavDestinationBuilder(Navigator navigator, KClass kClass, Map typeMap) {
        KSerializer kSerializerC;
        KSerializer kSerializerC2;
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        int iJ = (kClass == null || (kSerializerC2 = SerializersKt.c(kClass)) == null) ? -1 : RouteSerializerKt.j(kSerializerC2);
        String strO = null;
        if (kClass != null && (kSerializerC = SerializersKt.c(kClass)) != null) {
            strO = RouteSerializerKt.o(kSerializerC, typeMap, null, 2, null);
        }
        this(navigator, iJ, strO);
        if (kClass != null) {
            for (NamedNavArgument namedNavArgument : RouteSerializerKt.k(SerializersKt.c(kClass), typeMap)) {
                this.f48882f.put(namedNavArgument.d(), namedNavArgument.c());
            }
        }
        this.f48880d = typeMap;
    }
}
