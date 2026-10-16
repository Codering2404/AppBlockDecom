package androidx.glance.unit;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public abstract class Dimension {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Dp extends Dimension {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f39786a;

        public /* synthetic */ Dp(float f3, DefaultConstructorMarker defaultConstructorMarker) {
            this(f3);
        }

        public final float a() {
            return this.f39786a;
        }

        private Dp(float f3) {
            super(null);
            this.f39786a = f3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Expand extends Dimension {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Expand f39787a = new Expand();

        private Expand() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Fill extends Dimension {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Fill f39788a = new Fill();

        private Fill() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Resource extends Dimension {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f39789a;

        public final int a() {
            return this.f39789a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Wrap extends Dimension {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Wrap f39790a = new Wrap();

        private Wrap() {
            super(null);
        }
    }

    public /* synthetic */ Dimension(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private Dimension() {
    }
}
