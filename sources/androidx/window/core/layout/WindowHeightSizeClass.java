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
public final class WindowHeightSizeClass {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f54161b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WindowHeightSizeClass f54162c = new WindowHeightSizeClass(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final WindowHeightSizeClass f54163d = new WindowHeightSizeClass(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final WindowHeightSizeClass f54164e = new WindowHeightSizeClass(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f54165a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WindowHeightSizeClass a(float f3) {
            if (f3 >= 0.0f) {
                return f3 < 480.0f ? WindowHeightSizeClass.f54162c : f3 < 900.0f ? WindowHeightSizeClass.f54163d : WindowHeightSizeClass.f54164e;
            }
            throw new IllegalArgumentException(("Height must be positive, received " + f3).toString());
        }

        private Companion() {
        }
    }

    private WindowHeightSizeClass(int i3) {
        this.f54165a = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && WindowHeightSizeClass.class == obj.getClass() && this.f54165a == ((WindowHeightSizeClass) obj).f54165a;
    }

    public int hashCode() {
        return this.f54165a;
    }

    public String toString() {
        return "WindowHeightSizeClass: " + (Intrinsics.areEqual(this, f54162c) ? "COMPACT" : Intrinsics.areEqual(this, f54163d) ? "MEDIUM" : Intrinsics.areEqual(this, f54164e) ? "EXPANDED" : "UNKNOWN");
    }
}
