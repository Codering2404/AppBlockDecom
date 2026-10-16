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
public final class SwipeTouchUp {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f30973b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SwipeTouchUp f30974c = new SwipeTouchUp("autocomplete");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SwipeTouchUp f30975d = new SwipeTouchUp("toStart");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SwipeTouchUp f30976e = new SwipeTouchUp("toEnd");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SwipeTouchUp f30977f = new SwipeTouchUp("stop");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final SwipeTouchUp f30978g = new SwipeTouchUp("decelerate");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final SwipeTouchUp f30979h = new SwipeTouchUp("neverCompleteStart");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final SwipeTouchUp f30980i = new SwipeTouchUp("neverCompleteEnd");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f30981a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public SwipeTouchUp(String str) {
        this.f30981a = str;
    }
}
