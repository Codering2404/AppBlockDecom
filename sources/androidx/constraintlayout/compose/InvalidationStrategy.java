package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
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
public final class InvalidationStrategy {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f30578e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f30579f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final InvalidationStrategy f30580g = new InvalidationStrategy(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function3 f30581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f30582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InvalidationStrategySpecification f30583c = new InvalidationStrategySpecification();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ShouldInvalidateCallback f30584d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final InvalidationStrategy a() {
            return InvalidationStrategy.f30580g;
        }

        private Companion() {
        }
    }

    public InvalidationStrategy(Function3 function3, Function0 function0) {
        this.f30581a = function3;
        this.f30582b = function0;
        this.f30584d = function3 == null ? null : new ShouldInvalidateCallback() { // from class: androidx.constraintlayout.compose.InvalidationStrategy$shouldInvalidate$1$1
            @Override // androidx.constraintlayout.compose.ShouldInvalidateCallback
            public final boolean a(long j3, long j4) {
                return ((Boolean) this.f30585a.c().invoke(this.f30585a.f30583c, Constraints.a(j3), Constraints.a(j4))).booleanValue();
            }
        };
    }

    public final Function3 c() {
        return this.f30581a;
    }

    public final Function0 d() {
        return this.f30582b;
    }

    public final ShouldInvalidateCallback e() {
        return this.f30584d;
    }
}
