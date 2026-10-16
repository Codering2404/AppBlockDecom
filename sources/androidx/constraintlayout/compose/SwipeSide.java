package androidx.constraintlayout.compose;

import com.facebook.appevents.internal.ViewHierarchyConstants;
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
public final class SwipeSide {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f30964b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SwipeSide f30965c = new SwipeSide(ViewHierarchyConstants.DIMENSION_TOP_KEY);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SwipeSide f30966d = new SwipeSide(ViewHierarchyConstants.DIMENSION_LEFT_KEY);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SwipeSide f30967e = new SwipeSide("right");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SwipeSide f30968f = new SwipeSide("bottom");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final SwipeSide f30969g = new SwipeSide("middle");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final SwipeSide f30970h = new SwipeSide("start");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final SwipeSide f30971i = new SwipeSide("end");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f30972a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public SwipeSide(String str) {
        this.f30972a = str;
    }
}
