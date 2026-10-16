package cz.mobilesoft.coreblock.enums;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class PermissionAccessibilityReason implements Serializable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FloatingWindows extends PermissionAccessibilityReason {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FloatingWindows f97006a = new FloatingWindows();

        private FloatingWindows() {
            super(null);
        }

        private final Object readResolve() {
            return f97006a;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof FloatingWindows);
        }

        public int hashCode() {
            return -604872629;
        }

        public String toString() {
            return "FloatingWindows";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InAppPurchases extends PermissionAccessibilityReason {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final InAppPurchases f97007a = new InAppPurchases();

        private InAppPurchases() {
            super(null);
        }

        private final Object readResolve() {
            return f97007a;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof InAppPurchases);
        }

        public int hashCode() {
            return -1097926200;
        }

        public String toString() {
            return "InAppPurchases";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SplitScreen extends PermissionAccessibilityReason {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SplitScreen f97008a = new SplitScreen();

        private SplitScreen() {
            super(null);
        }

        private final Object readResolve() {
            return f97008a;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof SplitScreen);
        }

        public int hashCode() {
            return -2034682924;
        }

        public String toString() {
            return "SplitScreen";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Statistics extends PermissionAccessibilityReason {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Statistics f97009a = new Statistics();

        private Statistics() {
            super(null);
        }

        private final Object readResolve() {
            return f97009a;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Statistics);
        }

        public int hashCode() {
            return -1332847691;
        }

        public String toString() {
            return "Statistics";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class StrictMode extends PermissionAccessibilityReason {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f97010a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f97011b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f97012c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f97013d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f97014f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f97015g;

        public StrictMode(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
            super(null);
            this.f97010a = z2;
            this.f97011b = z3;
            this.f97012c = z4;
            this.f97013d = z5;
            this.f97014f = z6;
            this.f97015g = z7;
        }

        public final boolean a() {
            return this.f97010a;
        }

        public final boolean b() {
            return this.f97014f;
        }

        public final boolean c() {
            return this.f97015g;
        }

        public final boolean d() {
            return this.f97012c;
        }

        public final boolean e() {
            return this.f97013d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StrictMode)) {
                return false;
            }
            StrictMode strictMode = (StrictMode) obj;
            return this.f97010a == strictMode.f97010a && this.f97011b == strictMode.f97011b && this.f97012c == strictMode.f97012c && this.f97013d == strictMode.f97013d && this.f97014f == strictMode.f97014f && this.f97015g == strictMode.f97015g;
        }

        public final boolean f() {
            return this.f97011b;
        }

        public int hashCode() {
            return (((((((((Boolean.hashCode(this.f97010a) * 31) + Boolean.hashCode(this.f97011b)) * 31) + Boolean.hashCode(this.f97012c)) * 31) + Boolean.hashCode(this.f97013d)) * 31) + Boolean.hashCode(this.f97014f)) * 31) + Boolean.hashCode(this.f97015g);
        }

        public String toString() {
            return "StrictMode(isBlockingFGSTaskManager=" + this.f97010a + ", isBlockingUserChange=" + this.f97011b + ", isBlockingSplitScreen=" + this.f97012c + ", isBlockingUninstall=" + this.f97013d + ", isBlockingRecentApps=" + this.f97014f + ", isBlockingSettings=" + this.f97015g + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UsageLimits extends PermissionAccessibilityReason {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final UsageLimits f97016a = new UsageLimits();

        private UsageLimits() {
            super(null);
        }

        private final Object readResolve() {
            return f97016a;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof UsageLimits);
        }

        public int hashCode() {
            return 965656775;
        }

        public String toString() {
            return "UsageLimits";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class WebBlocking extends PermissionAccessibilityReason {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final WebBlocking f97017a = new WebBlocking();

        private WebBlocking() {
            super(null);
        }

        private final Object readResolve() {
            return f97017a;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof WebBlocking);
        }

        public int hashCode() {
            return 1169993559;
        }

        public String toString() {
            return "WebBlocking";
        }
    }

    public /* synthetic */ PermissionAccessibilityReason(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PermissionAccessibilityReason() {
    }
}
