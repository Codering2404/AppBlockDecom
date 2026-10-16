package androidx.constraintlayout.compose;

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
public final class Easing implements NamedPropertyOrValue {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f30545b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Easing f30546c = new Easing("standard");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Easing f30547d = new Easing("accelerate");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Easing f30548e = new Easing("decelerate");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Easing f30549f = new Easing("linear");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Easing f30550g = new Easing("anticipate");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Easing f30551h = new Easing("overshoot");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f30552a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Easing(String str) {
        this.f30552a = str;
    }

    @Override // androidx.constraintlayout.compose.NamedPropertyOrValue
    public String getName() {
        return this.f30552a;
    }
}
