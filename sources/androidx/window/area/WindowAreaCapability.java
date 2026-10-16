package androidx.window.area;

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
public final class WindowAreaCapability {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Operation f54034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Status f54035b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Operation {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f54036b = new Companion(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Operation f54037c = new Operation("TRANSFER");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Operation f54038d = new Operation("PRESENT");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f54039a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        private Operation(String str) {
            this.f54039a = str;
        }

        public String toString() {
            return this.f54039a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Status {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f54040b = new Companion(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Status f54041c = new Status("UNKNOWN");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Status f54042d = new Status("UNSUPPORTED");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Status f54043e = new Status("UNAVAILABLE");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Status f54044f = new Status("AVAILABLE");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final Status f54045g = new Status("ACTIVE");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f54046a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        private Status(String str) {
            this.f54046a = str;
        }

        public String toString() {
            return this.f54046a;
        }
    }

    public WindowAreaCapability(Operation operation, Status status) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(status, "status");
        this.f54034a = operation;
        this.f54035b = status;
    }

    public final Status a() {
        return this.f54035b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof WindowAreaCapability)) {
            return false;
        }
        WindowAreaCapability windowAreaCapability = (WindowAreaCapability) obj;
        return Intrinsics.areEqual(this.f54034a, windowAreaCapability.f54034a) && Intrinsics.areEqual(this.f54035b, windowAreaCapability.f54035b);
    }

    public int hashCode() {
        return (this.f54034a.hashCode() * 31) + this.f54035b.hashCode();
    }

    public String toString() {
        return "Operation: " + this.f54034a + ": Status: " + this.f54035b;
    }
}
