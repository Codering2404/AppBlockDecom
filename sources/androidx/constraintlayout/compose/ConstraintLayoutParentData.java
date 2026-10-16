package androidx.constraintlayout.compose;

import androidx.compose.ui.layout.LayoutIdParentData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
final class ConstraintLayoutParentData implements LayoutIdParentData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConstrainedLayoutReference f30493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f30494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f30495c;

    public ConstraintLayoutParentData(ConstrainedLayoutReference constrainedLayoutReference, Function1 function1) {
        this.f30493a = constrainedLayoutReference;
        this.f30494b = function1;
        this.f30495c = constrainedLayoutReference.a();
    }

    @Override // androidx.compose.ui.layout.LayoutIdParentData
    public Object Z0() {
        return this.f30495c;
    }

    public final Function1 a() {
        return this.f30494b;
    }

    public final ConstrainedLayoutReference b() {
        return this.f30493a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConstraintLayoutParentData)) {
            return false;
        }
        ConstraintLayoutParentData constraintLayoutParentData = (ConstraintLayoutParentData) obj;
        return Intrinsics.areEqual(this.f30493a.a(), constraintLayoutParentData.f30493a.a()) && this.f30494b == constraintLayoutParentData.f30494b;
    }

    public int hashCode() {
        return (this.f30493a.a().hashCode() * 31) + this.f30494b.hashCode();
    }
}
