package androidx.navigation;

import android.os.Bundle;
import androidx.savedstate.SavedStateReader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

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
public final class NavArgument {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NavType f48772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f48773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f48774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f48775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f48776e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private NavType f48777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f48778b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Object f48779c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f48780d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f48781e;

        public final NavArgument a() {
            NavType navTypeC = this.f48777a;
            if (navTypeC == null) {
                navTypeC = NavType.f48956c.c(this.f48779c);
                Intrinsics.checkNotNull(navTypeC, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any?>");
            }
            return new NavArgument(navTypeC, this.f48778b, this.f48779c, this.f48780d, this.f48781e);
        }

        public final Builder b(Object obj) {
            this.f48779c = obj;
            this.f48780d = true;
            return this;
        }

        public final Builder c(boolean z2) {
            this.f48778b = z2;
            return this;
        }

        public final Builder d(NavType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.f48777a = type;
            return this;
        }

        public final Builder e(boolean z2) {
            this.f48781e = z2;
            return this;
        }
    }

    public NavArgument(NavType type, boolean z2, Object obj, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (!type.c() && z2) {
            throw new IllegalArgumentException((type.b() + " does not allow nullable values").toString());
        }
        if (!z2 && z3 && obj == null) {
            throw new IllegalArgumentException(("Argument with type " + type.b() + " has null value but is not nullable.").toString());
        }
        this.f48772a = type;
        this.f48773b = z2;
        this.f48776e = obj;
        this.f48774c = z3 || z4;
        this.f48775d = z4;
    }

    public final NavType a() {
        return this.f48772a;
    }

    public final boolean b() {
        return this.f48774c;
    }

    public final boolean c() {
        return this.f48775d;
    }

    public final boolean d() {
        return this.f48773b;
    }

    public final void e(String name, Bundle bundle) {
        Object obj;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (!this.f48774c || (obj = this.f48776e) == null) {
            return;
        }
        this.f48772a.h(bundle, name, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && NavArgument.class == obj.getClass()) {
            NavArgument navArgument = (NavArgument) obj;
            if (this.f48773b != navArgument.f48773b || this.f48774c != navArgument.f48774c || !Intrinsics.areEqual(this.f48772a, navArgument.f48772a)) {
                return false;
            }
            Object obj2 = this.f48776e;
            if (obj2 != null) {
                return Intrinsics.areEqual(obj2, navArgument.f48776e);
            }
            if (navArgument.f48776e == null) {
                return true;
            }
        }
        return false;
    }

    public final boolean f(String name, Bundle bundle) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (!this.f48773b) {
            Bundle bundleA = SavedStateReader.a(bundle);
            if (SavedStateReader.b(bundleA, name) && SavedStateReader.P(bundleA, name)) {
                return false;
            }
        }
        try {
            this.f48772a.a(bundle, name);
            return true;
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    public int hashCode() {
        int iHashCode = ((((this.f48772a.hashCode() * 31) + (this.f48773b ? 1 : 0)) * 31) + (this.f48774c ? 1 : 0)) * 31;
        Object obj = this.f48776e;
        return iHashCode + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Reflection.b(NavArgument.class).m());
        sb.append(" Type: " + this.f48772a);
        sb.append(" Nullable: " + this.f48773b);
        if (this.f48774c) {
            sb.append(" DefaultValue: " + this.f48776e);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
