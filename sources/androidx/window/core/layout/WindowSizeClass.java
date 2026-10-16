package androidx.window.core.layout;

import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class WindowSizeClass {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f54166c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WindowWidthSizeClass f54167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WindowHeightSizeClass f54168b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WindowSizeClass a(float f3, float f4) {
            return new WindowSizeClass(WindowWidthSizeClass.f54169b.a(f3), WindowHeightSizeClass.f54161b.a(f4), null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ WindowSizeClass(WindowWidthSizeClass windowWidthSizeClass, WindowHeightSizeClass windowHeightSizeClass, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowWidthSizeClass, windowHeightSizeClass);
    }

    public final WindowHeightSizeClass a() {
        return this.f54168b;
    }

    public final WindowWidthSizeClass b() {
        return this.f54167a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(WindowSizeClass.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.window.core.layout.WindowSizeClass");
        WindowSizeClass windowSizeClass = (WindowSizeClass) obj;
        return Intrinsics.areEqual(this.f54167a, windowSizeClass.f54167a) && Intrinsics.areEqual(this.f54168b, windowSizeClass.f54168b);
    }

    public int hashCode() {
        return (this.f54167a.hashCode() * 31) + this.f54168b.hashCode();
    }

    public String toString() {
        return "WindowSizeClass {windowWidthSizeClass=" + this.f54167a + ", windowHeightSizeClass=" + this.f54168b + " }";
    }

    private WindowSizeClass(WindowWidthSizeClass windowWidthSizeClass, WindowHeightSizeClass windowHeightSizeClass) {
        this.f54167a = windowWidthSizeClass;
        this.f54168b = windowHeightSizeClass;
    }
}
