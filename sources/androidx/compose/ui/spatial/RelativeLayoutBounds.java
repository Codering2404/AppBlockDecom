package androidx.compose.ui.spatial;

import androidx.compose.ui.node.DelegatableNode;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class RelativeLayoutBounds {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f28595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f28596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f28597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f28598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float[] f28599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final DelegatableNode f28600f;

    public /* synthetic */ RelativeLayoutBounds(long j3, long j4, long j5, long j6, float[] fArr, DelegatableNode delegatableNode, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, fArr, delegatableNode);
    }

    private RelativeLayoutBounds(long j3, long j4, long j5, long j6, float[] fArr, DelegatableNode delegatableNode) {
        this.f28595a = j3;
        this.f28596b = j4;
        this.f28597c = j5;
        this.f28598d = j6;
        this.f28599e = fArr;
        this.f28600f = delegatableNode;
    }
}
