package androidx.navigation;

import androidx.navigation.Navigator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public class NavigatorProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f48985b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map f48986c = new LinkedHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f48987a = new LinkedHashMap();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(Class navigatorClass) {
            Intrinsics.checkNotNullParameter(navigatorClass, "navigatorClass");
            String strValue = (String) NavigatorProvider.f48986c.get(navigatorClass);
            if (strValue == null) {
                Navigator.Name name = (Navigator.Name) navigatorClass.getAnnotation(Navigator.Name.class);
                strValue = name != null ? name.value() : null;
                if (!b(strValue)) {
                    throw new IllegalArgumentException(("No @Navigator.Name annotation found for " + navigatorClass.getSimpleName()).toString());
                }
                NavigatorProvider.f48986c.put(navigatorClass, strValue);
            }
            Intrinsics.checkNotNull(strValue);
            return strValue;
        }

        public final boolean b(String str) {
            return str != null && str.length() > 0;
        }

        private Companion() {
        }
    }

    public final Navigator b(Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        return c(f48985b.a(navigator.getClass()), navigator);
    }

    public Navigator c(String name, Navigator navigator) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        if (!f48985b.b(name)) {
            throw new IllegalArgumentException("navigator name cannot be an empty string");
        }
        Navigator navigator2 = (Navigator) this.f48987a.get(name);
        if (Intrinsics.areEqual(navigator2, navigator)) {
            return navigator;
        }
        boolean z2 = false;
        if (navigator2 != null && navigator2.e()) {
            z2 = true;
        }
        if (z2) {
            throw new IllegalStateException(("Navigator " + navigator + " is replacing an already attached " + navigator2).toString());
        }
        if (!navigator.e()) {
            return (Navigator) this.f48987a.put(name, navigator);
        }
        throw new IllegalStateException(("Navigator " + navigator + " is already attached to another NavController").toString());
    }

    public final Navigator d(Class navigatorClass) {
        Intrinsics.checkNotNullParameter(navigatorClass, "navigatorClass");
        return e(f48985b.a(navigatorClass));
    }

    public Navigator e(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (!f48985b.b(name)) {
            throw new IllegalArgumentException("navigator name cannot be an empty string");
        }
        Navigator navigator = (Navigator) this.f48987a.get(name);
        if (navigator != null) {
            return navigator;
        }
        throw new IllegalStateException("Could not find Navigator with name \"" + name + "\". You must call NavController.addNavigator() for each navigation type.");
    }

    public final Map f() {
        return MapsKt.toMap(this.f48987a);
    }
}
