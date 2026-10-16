package androidx.constraintlayout.compose;

import java.util.Map;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class MotionSceneDslImpl implements MotionScene {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f30922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f30923b;

    @Override // androidx.constraintlayout.compose.MotionScene
    public ConstraintSet c(String str) {
        return (ConstraintSet) this.f30922a.get(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(MotionSceneDslImpl.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.constraintlayout.compose.MotionSceneDslImpl");
        MotionSceneDslImpl motionSceneDslImpl = (MotionSceneDslImpl) obj;
        return Intrinsics.areEqual(this.f30922a, motionSceneDslImpl.f30922a) && Intrinsics.areEqual(this.f30923b, motionSceneDslImpl.f30923b);
    }

    public int hashCode() {
        return (this.f30922a.hashCode() * 31) + this.f30923b.hashCode();
    }

    @Override // androidx.constraintlayout.compose.MotionScene
    public Transition k(String str) {
        return (Transition) this.f30923b.get(str);
    }

    @Override // androidx.constraintlayout.core.state.CoreMotionScene
    public String m(String str) {
        return "";
    }

    @Override // androidx.constraintlayout.core.state.CoreMotionScene
    public void r(String str) {
    }

    @Override // androidx.constraintlayout.core.state.CoreMotionScene
    public void o(String str, String str2) {
    }

    @Override // androidx.constraintlayout.core.state.CoreMotionScene
    public void q(String str, String str2) {
    }
}
