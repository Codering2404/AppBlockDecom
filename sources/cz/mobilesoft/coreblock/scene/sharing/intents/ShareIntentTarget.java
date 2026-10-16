package cz.mobilesoft.coreblock.scene.sharing.intents;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class ShareIntentTarget {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ActivityExact extends ShareIntentTarget {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f119451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f119452b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActivityExact(String packageName, String activityName) {
            super(null);
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(activityName, "activityName");
            this.f119451a = packageName;
            this.f119452b = activityName;
        }

        public final String a() {
            return this.f119452b;
        }

        public final String b() {
            return this.f119451a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActivityExact)) {
                return false;
            }
            ActivityExact activityExact = (ActivityExact) obj;
            return Intrinsics.areEqual(this.f119451a, activityExact.f119451a) && Intrinsics.areEqual(this.f119452b, activityExact.f119452b);
        }

        public int hashCode() {
            return (this.f119451a.hashCode() * 31) + this.f119452b.hashCode();
        }

        public String toString() {
            return "ActivityExact(packageName=" + this.f119451a + ", activityName=" + this.f119452b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultSms extends ShareIntentTarget {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DefaultSms f119453a = new DefaultSms();

        private DefaultSms() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof DefaultSms);
        }

        public int hashCode() {
            return -590608080;
        }

        public String toString() {
            return "DefaultSms";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PackageFirst extends ShareIntentTarget {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f119454a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PackageFirst(String packageName) {
            super(null);
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            this.f119454a = packageName;
        }

        public final String a() {
            return this.f119454a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PackageFirst) && Intrinsics.areEqual(this.f119454a, ((PackageFirst) obj).f119454a);
        }

        public int hashCode() {
            return this.f119454a.hashCode();
        }

        public String toString() {
            return "PackageFirst(packageName=" + this.f119454a + ")";
        }
    }

    public /* synthetic */ ShareIntentTarget(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ShareIntentTarget() {
    }
}
