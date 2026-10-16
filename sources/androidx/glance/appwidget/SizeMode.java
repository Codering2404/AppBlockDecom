package androidx.glance.appwidget;

import java.util.Set;
import kotlin.Metadata;
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
public interface SizeMode {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Exact implements SizeMode {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Exact f38451a = new Exact();

        private Exact() {
        }

        public String toString() {
            return "SizeMode.Exact";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Responsive implements SizeMode {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set f38452a;

        public Responsive(Set set) {
            this.f38452a = set;
            if (set.isEmpty()) {
                throw new IllegalArgumentException("The set of sizes cannot be empty");
            }
        }

        public final Set a() {
            return this.f38452a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.areEqual(Responsive.class, obj != null ? obj.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.glance.appwidget.SizeMode.Responsive");
            return Intrinsics.areEqual(this.f38452a, ((Responsive) obj).f38452a);
        }

        public int hashCode() {
            return this.f38452a.hashCode();
        }

        public String toString() {
            return "SizeMode.Responsive(sizes=" + this.f38452a + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Single implements SizeMode {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Single f38453a = new Single();

        private Single() {
        }

        public String toString() {
            return "SizeMode.Single";
        }
    }
}
