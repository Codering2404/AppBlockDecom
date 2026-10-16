package androidx.work.impl.constraints;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public abstract class ConstraintsState {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ConstraintsMet extends ConstraintsState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ConstraintsMet f54853a = new ConstraintsMet();

        private ConstraintsMet() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ConstraintsNotMet extends ConstraintsState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f54854a;

        public ConstraintsNotMet(int i3) {
            super(null);
            this.f54854a = i3;
        }

        public final int a() {
            return this.f54854a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ConstraintsNotMet) && this.f54854a == ((ConstraintsNotMet) obj).f54854a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f54854a);
        }

        public String toString() {
            return "ConstraintsNotMet(reason=" + this.f54854a + ')';
        }
    }

    public /* synthetic */ ConstraintsState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ConstraintsState() {
    }
}
