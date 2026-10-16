package androidx.navigation.serialization;

import androidx.navigation.NamedNavArgumentKt;
import androidx.navigation.NavArgumentBuilder;
import androidx.navigation.NavType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.descriptors.ContextAwareKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind;

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
@Metadata
public final class RouteSerializerKt {
    private static final void f(KSerializer kSerializer, Function0 function0) {
        if (kSerializer instanceof PolymorphicSerializer) {
            function0.invoke();
        }
    }

    private static final NavType g(SerialDescriptor serialDescriptor, Map map) {
        Object next;
        Iterator it = map.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (NavTypeConverterKt.b(serialDescriptor, (KType) next)) {
                break;
            }
        }
        KType kType = (KType) next;
        NavType navTypeA = kType != null ? (NavType) map.get(kType) : null;
        if (navTypeA == null) {
            navTypeA = null;
        }
        if (navTypeA == null) {
            navTypeA = NavTypeConverterKt.a(serialDescriptor);
        }
        if (Intrinsics.areEqual(navTypeA, UNKNOWN.f49478t)) {
            return null;
        }
        Intrinsics.checkNotNull(navTypeA, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any?>");
        return navTypeA;
    }

    private static final void h(KSerializer kSerializer, Map map, Function3 function3) {
        int iE = kSerializer.getDescriptor().e();
        for (int i3 = 0; i3 < iE; i3++) {
            String strF = kSerializer.getDescriptor().f(i3);
            NavType navTypeG = g(kSerializer.getDescriptor().h(i3), map);
            if (navTypeG == null) {
                throw new IllegalArgumentException(u(strF, kSerializer.getDescriptor().h(i3).i(), kSerializer.getDescriptor().i(), map.toString()));
            }
            function3.invoke(Integer.valueOf(i3), strF, navTypeG);
        }
    }

    private static final void i(KSerializer kSerializer, Map map, Function3 function3) {
        int iE = kSerializer.getDescriptor().e();
        for (int i3 = 0; i3 < iE; i3++) {
            String strF = kSerializer.getDescriptor().f(i3);
            NavType navType = (NavType) map.get(strF);
            if (navType == null) {
                throw new IllegalStateException(("Cannot locate NavType for argument [" + strF + ']').toString());
            }
            function3.invoke(Integer.valueOf(i3), strF, navType);
        }
    }

    public static final int j(KSerializer kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "<this>");
        int iHashCode = kSerializer.getDescriptor().i().hashCode();
        int iE = kSerializer.getDescriptor().e();
        for (int i3 = 0; i3 < iE; i3++) {
            iHashCode = (iHashCode * 31) + kSerializer.getDescriptor().f(i3).hashCode();
        }
        return iHashCode;
    }

    public static final List k(final KSerializer kSerializer, final Map typeMap) {
        Intrinsics.checkNotNullParameter(kSerializer, "<this>");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        f(kSerializer, new Function0() { // from class: androidx.navigation.serialization.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RouteSerializerKt.l(kSerializer);
            }
        });
        int iE = kSerializer.getDescriptor().e();
        ArrayList arrayList = new ArrayList(iE);
        for (final int i3 = 0; i3 < iE; i3++) {
            final String strF = kSerializer.getDescriptor().f(i3);
            arrayList.add(NamedNavArgumentKt.a(strF, new Function1() { // from class: androidx.navigation.serialization.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RouteSerializerKt.m(kSerializer, i3, typeMap, strF, (NavArgumentBuilder) obj);
                }
            }));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(KSerializer kSerializer) {
        throw new IllegalArgumentException("Cannot generate NavArguments for polymorphic serializer " + kSerializer + ". Arguments can only be generated from concrete classes or objects.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(KSerializer kSerializer, int i3, Map map, String str, NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        SerialDescriptor serialDescriptorH = kSerializer.getDescriptor().h(i3);
        boolean zB = serialDescriptorH.b();
        NavType navTypeG = g(serialDescriptorH, map);
        if (navTypeG == null) {
            throw new IllegalArgumentException(u(str, serialDescriptorH.i(), kSerializer.getDescriptor().i(), map.toString()));
        }
        navArgument.d(navTypeG);
        navArgument.c(zB);
        if (kSerializer.getDescriptor().j(i3)) {
            navArgument.e(true);
        }
        return Unit.f139807a;
    }

    public static final String n(final KSerializer kSerializer, Map typeMap, String str) {
        Intrinsics.checkNotNullParameter(kSerializer, "<this>");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        f(kSerializer, new Function0() { // from class: androidx.navigation.serialization.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RouteSerializerKt.p(kSerializer);
            }
        });
        final RouteBuilder routeBuilder = str != null ? new RouteBuilder(str, kSerializer) : new RouteBuilder(kSerializer);
        h(kSerializer, typeMap, new Function3() { // from class: androidx.navigation.serialization.c
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return RouteSerializerKt.q(routeBuilder, ((Integer) obj).intValue(), (String) obj2, (NavType) obj3);
            }
        });
        return routeBuilder.e();
    }

    public static /* synthetic */ String o(KSerializer kSerializer, Map map, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i3 & 2) != 0) {
            str = null;
        }
        return n(kSerializer, map, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(KSerializer kSerializer) {
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot generate route pattern from polymorphic class ");
        KClass kClassA = ContextAwareKt.a(kSerializer.getDescriptor());
        sb.append(kClassA != null ? kClassA.m() : null);
        sb.append(". Routes can only be generated from concrete classes or objects.");
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(RouteBuilder routeBuilder, int i3, String argName, NavType navType) {
        Intrinsics.checkNotNullParameter(argName, "argName");
        Intrinsics.checkNotNullParameter(navType, "navType");
        routeBuilder.d(i3, argName, navType);
        return Unit.f139807a;
    }

    public static final String r(Object route, Map typeMap) {
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        KSerializer kSerializerC = SerializersKt.c(Reflection.b(route.getClass()));
        final Map mapK = new RouteEncoder(kSerializerC, typeMap).K(route);
        final RouteBuilder routeBuilder = new RouteBuilder(kSerializerC);
        i(kSerializerC, typeMap, new Function3() { // from class: androidx.navigation.serialization.a
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return RouteSerializerKt.s(mapK, routeBuilder, ((Integer) obj).intValue(), (String) obj2, (NavType) obj3);
            }
        });
        return routeBuilder.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Map map, RouteBuilder routeBuilder, int i3, String argName, NavType navType) {
        Intrinsics.checkNotNullParameter(argName, "argName");
        Intrinsics.checkNotNullParameter(navType, "navType");
        Object obj = map.get(argName);
        Intrinsics.checkNotNull(obj);
        routeBuilder.c(i3, argName, navType, (List) obj);
        return Unit.f139807a;
    }

    public static final boolean t(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        return Intrinsics.areEqual(serialDescriptor.d(), StructureKind.CLASS.f142753a) && serialDescriptor.isInline() && serialDescriptor.e() == 1;
    }

    private static final String u(String str, String str2, String str3, String str4) {
        return "Route " + str3 + " could not find any NavType for argument " + str + " of type " + str2 + " - typeMap received was " + str4;
    }
}
