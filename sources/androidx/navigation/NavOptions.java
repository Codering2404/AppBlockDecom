package androidx.navigation;

import androidx.navigation.serialization.RouteSerializerKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class NavOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f48922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f48923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f48924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f48925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f48926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f48927f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f48928g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f48929h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f48930i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f48931j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private KClass f48932k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Object f48933l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f48934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f48935b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f48937d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private KClass f48938e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Object f48939f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f48940g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f48941h;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f48936c = -1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f48942i = -1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f48943j = -1;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f48944k = -1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f48945l = -1;

        public static /* synthetic */ Builder k(Builder builder, int i3, boolean z2, boolean z3, int i4, Object obj) {
            if ((i4 & 4) != 0) {
                z3 = false;
            }
            return builder.g(i3, z2, z3);
        }

        public final NavOptions a() {
            String str = this.f48937d;
            if (str != null) {
                return new NavOptions(this.f48934a, this.f48935b, str, this.f48940g, this.f48941h, this.f48942i, this.f48943j, this.f48944k, this.f48945l);
            }
            KClass kClass = this.f48938e;
            if (kClass != null) {
                return new NavOptions(this.f48934a, this.f48935b, kClass, this.f48940g, this.f48941h, this.f48942i, this.f48943j, this.f48944k, this.f48945l);
            }
            Object obj = this.f48939f;
            if (obj == null) {
                return new NavOptions(this.f48934a, this.f48935b, this.f48936c, this.f48940g, this.f48941h, this.f48942i, this.f48943j, this.f48944k, this.f48945l);
            }
            boolean z2 = this.f48934a;
            boolean z3 = this.f48935b;
            Intrinsics.checkNotNull(obj);
            return new NavOptions(z2, z3, obj, this.f48940g, this.f48941h, this.f48942i, this.f48943j, this.f48944k, this.f48945l);
        }

        public final Builder b(int i3) {
            this.f48942i = i3;
            return this;
        }

        public final Builder c(int i3) {
            this.f48943j = i3;
            return this;
        }

        public final Builder d(boolean z2) {
            this.f48934a = z2;
            return this;
        }

        public final Builder e(int i3) {
            this.f48944k = i3;
            return this;
        }

        public final Builder f(int i3) {
            this.f48945l = i3;
            return this;
        }

        public final Builder g(int i3, boolean z2, boolean z3) {
            this.f48936c = i3;
            this.f48937d = null;
            this.f48940g = z2;
            this.f48941h = z3;
            return this;
        }

        public final Builder h(Object route, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(route, "route");
            this.f48939f = route;
            g(RouteSerializerKt.j(SerializersKt.c(Reflection.b(route.getClass()))), z2, z3);
            return this;
        }

        public final Builder i(String str, boolean z2, boolean z3) {
            this.f48937d = str;
            this.f48936c = -1;
            this.f48940g = z2;
            this.f48941h = z3;
            return this;
        }

        public final Builder j(KClass route, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(route, "route");
            this.f48938e = route;
            this.f48936c = -1;
            this.f48940g = z2;
            this.f48941h = z3;
            return this;
        }

        public final Builder l(boolean z2) {
            this.f48935b = z2;
            return this;
        }
    }

    public NavOptions(boolean z2, boolean z3, int i3, boolean z4, boolean z5, int i4, int i5, int i6, int i7) {
        this.f48922a = z2;
        this.f48923b = z3;
        this.f48924c = i3;
        this.f48925d = z4;
        this.f48926e = z5;
        this.f48927f = i4;
        this.f48928g = i5;
        this.f48929h = i6;
        this.f48930i = i7;
    }

    public final int a() {
        return this.f48927f;
    }

    public final int b() {
        return this.f48928g;
    }

    public final int c() {
        return this.f48929h;
    }

    public final int d() {
        return this.f48930i;
    }

    public final int e() {
        return this.f48924c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof NavOptions)) {
            NavOptions navOptions = (NavOptions) obj;
            if (this.f48922a == navOptions.f48922a && this.f48923b == navOptions.f48923b && this.f48924c == navOptions.f48924c && Intrinsics.areEqual(this.f48931j, navOptions.f48931j) && Intrinsics.areEqual(this.f48932k, navOptions.f48932k) && Intrinsics.areEqual(this.f48933l, navOptions.f48933l) && this.f48925d == navOptions.f48925d && this.f48926e == navOptions.f48926e && this.f48927f == navOptions.f48927f && this.f48928g == navOptions.f48928g && this.f48929h == navOptions.f48929h && this.f48930i == navOptions.f48930i) {
                return true;
            }
        }
        return false;
    }

    public final String f() {
        return this.f48931j;
    }

    public final KClass g() {
        return this.f48932k;
    }

    public final Object h() {
        return this.f48933l;
    }

    public int hashCode() {
        int i3 = (((((j() ? 1 : 0) * 31) + (l() ? 1 : 0)) * 31) + this.f48924c) * 31;
        String str = this.f48931j;
        int iHashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        KClass kClass = this.f48932k;
        int iHashCode2 = (iHashCode + (kClass != null ? kClass.hashCode() : 0)) * 31;
        Object obj = this.f48933l;
        return ((((((((((((iHashCode2 + (obj != null ? obj.hashCode() : 0)) * 31) + (i() ? 1 : 0)) * 31) + (k() ? 1 : 0)) * 31) + this.f48927f) * 31) + this.f48928g) * 31) + this.f48929h) * 31) + this.f48930i;
    }

    public final boolean i() {
        return this.f48925d;
    }

    public final boolean j() {
        return this.f48922a;
    }

    public final boolean k() {
        return this.f48926e;
    }

    public final boolean l() {
        return this.f48923b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NavOptions.class.getSimpleName());
        sb.append("(");
        if (this.f48922a) {
            sb.append("launchSingleTop ");
        }
        if (this.f48923b) {
            sb.append("restoreState ");
        }
        String str = this.f48931j;
        if ((str != null || this.f48924c != -1) && str != null) {
            sb.append("popUpTo(");
            String str2 = this.f48931j;
            if (str2 != null) {
                sb.append(str2);
            } else {
                KClass kClass = this.f48932k;
                if (kClass != null) {
                    sb.append(kClass);
                } else {
                    Object obj = this.f48933l;
                    if (obj != null) {
                        sb.append(obj);
                    } else {
                        sb.append("0x");
                        sb.append(Integer.toHexString(this.f48924c));
                    }
                }
            }
            if (this.f48925d) {
                sb.append(" inclusive");
            }
            if (this.f48926e) {
                sb.append(" saveState");
            }
            sb.append(")");
        }
        if (this.f48927f != -1 || this.f48928g != -1 || this.f48929h != -1 || this.f48930i != -1) {
            sb.append("anim(enterAnim=0x");
            sb.append(Integer.toHexString(this.f48927f));
            sb.append(" exitAnim=0x");
            sb.append(Integer.toHexString(this.f48928g));
            sb.append(" popEnterAnim=0x");
            sb.append(Integer.toHexString(this.f48929h));
            sb.append(" popExitAnim=0x");
            sb.append(Integer.toHexString(this.f48930i));
            sb.append(")");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public NavOptions(boolean z2, boolean z3, String str, boolean z4, boolean z5, int i3, int i4, int i5, int i6) {
        this(z2, z3, NavDestination.f48864g.c(str).hashCode(), z4, z5, i3, i4, i5, i6);
        this.f48931j = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavOptions(boolean z2, boolean z3, KClass kClass, boolean z4, boolean z5, int i3, int i4, int i5, int i6) {
        this(z2, z3, RouteSerializerKt.j(SerializersKt.c(kClass)), z4, z5, i3, i4, i5, i6);
        Intrinsics.checkNotNull(kClass);
        this.f48932k = kClass;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavOptions(boolean z2, boolean z3, Object popUpToRouteObject, boolean z4, boolean z5, int i3, int i4, int i5, int i6) {
        this(z2, z3, RouteSerializerKt.j(SerializersKt.c(Reflection.b(popUpToRouteObject.getClass()))), z4, z5, i3, i4, i5, i6);
        Intrinsics.checkNotNullParameter(popUpToRouteObject, "popUpToRouteObject");
        this.f48933l = popUpToRouteObject;
    }
}
