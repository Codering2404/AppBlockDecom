package androidx.navigation;

import androidx.navigation.NavOptions;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

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
@NavOptionsDsl
public final class NavOptionsBuilder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f48947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f48948c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f48950e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f48951f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f48952g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private KClass f48953h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Object f48954i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NavOptions.Builder f48946a = new NavOptions.Builder();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f48949d = -1;

    private final void g(String str) {
        if (str != null) {
            if (StringsKt.p0(str)) {
                throw new IllegalArgumentException("Cannot pop up to an empty route");
            }
            this.f48950e = str;
            this.f48951f = false;
        }
    }

    public final void a(Function1 animBuilder) {
        Intrinsics.checkNotNullParameter(animBuilder, "animBuilder");
        AnimBuilder animBuilder2 = new AnimBuilder();
        animBuilder.invoke(animBuilder2);
        this.f48946a.b(animBuilder2.a()).c(animBuilder2.b()).e(animBuilder2.c()).f(animBuilder2.d());
    }

    public final NavOptions b() {
        NavOptions.Builder builder = this.f48946a;
        builder.d(this.f48947b);
        builder.l(this.f48948c);
        String str = this.f48950e;
        if (str != null) {
            builder.i(str, this.f48951f, this.f48952g);
        } else {
            KClass kClass = this.f48953h;
            if (kClass != null) {
                Intrinsics.checkNotNull(kClass);
                builder.j(kClass, this.f48951f, this.f48952g);
            } else {
                Object obj = this.f48954i;
                if (obj != null) {
                    Intrinsics.checkNotNull(obj);
                    builder.h(obj, this.f48951f, this.f48952g);
                } else {
                    builder.g(this.f48949d, this.f48951f, this.f48952g);
                }
            }
        }
        return builder.a();
    }

    public final void c(int i3, Function1 popUpToBuilder) {
        Intrinsics.checkNotNullParameter(popUpToBuilder, "popUpToBuilder");
        f(i3);
        g(null);
        PopUpToBuilder popUpToBuilder2 = new PopUpToBuilder();
        popUpToBuilder.invoke(popUpToBuilder2);
        this.f48951f = popUpToBuilder2.a();
        this.f48952g = popUpToBuilder2.b();
    }

    public final void d(String route, Function1 popUpToBuilder) {
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(popUpToBuilder, "popUpToBuilder");
        g(route);
        f(-1);
        PopUpToBuilder popUpToBuilder2 = new PopUpToBuilder();
        popUpToBuilder.invoke(popUpToBuilder2);
        this.f48951f = popUpToBuilder2.a();
        this.f48952g = popUpToBuilder2.b();
    }

    public final void e(boolean z2) {
        this.f48947b = z2;
    }

    public final void f(int i3) {
        this.f48949d = i3;
        this.f48951f = false;
    }

    public final void h(boolean z2) {
        this.f48948c = z2;
    }
}
