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
public final class WindowWidthSizeClass {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f54169b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WindowWidthSizeClass f54170c = new WindowWidthSizeClass(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final WindowWidthSizeClass f54171d = new WindowWidthSizeClass(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final WindowWidthSizeClass f54172e = new WindowWidthSizeClass(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f54173a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WindowWidthSizeClass a(float f3) {
            if (f3 >= 0.0f) {
                return f3 < 600.0f ? WindowWidthSizeClass.f54170c : f3 < 840.0f ? WindowWidthSizeClass.f54171d : WindowWidthSizeClass.f54172e;
            }
            throw new IllegalArgumentException(("Width must be positive, received " + f3).toString());
        }

        private Companion() {
        }
    }

    private WindowWidthSizeClass(int i3) {
        this.f54173a = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && WindowWidthSizeClass.class == obj.getClass() && this.f54173a == ((WindowWidthSizeClass) obj).f54173a;
    }

    public int hashCode() {
        return this.f54173a;
    }

    public String toString() {
        return "WindowWidthSizeClass: " + (Intrinsics.areEqual(this, f54170c) ? "COMPACT" : Intrinsics.areEqual(this, f54171d) ? "MEDIUM" : Intrinsics.areEqual(this, f54172e) ? "EXPANDED" : "UNKNOWN");
    }
}
