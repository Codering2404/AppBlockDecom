package androidx.compose.material3;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class BottomAppBarStateImpl implements BottomAppBarState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableFloatState f15942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableFloatState f15943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MutableFloatState f15944c;

    public BottomAppBarStateImpl(float f3, float f4, float f5) {
        this.f15942a = PrimitiveSnapshotStateKt.a(f3);
        this.f15943b = PrimitiveSnapshotStateKt.a(f5);
        this.f15944c = PrimitiveSnapshotStateKt.a(f4);
    }

    @Override // androidx.compose.material3.BottomAppBarState
    public float a() {
        if (e() == 0.0f) {
            return 0.0f;
        }
        return b() / e();
    }

    @Override // androidx.compose.material3.BottomAppBarState
    public float b() {
        return this.f15944c.c();
    }

    @Override // androidx.compose.material3.BottomAppBarState
    public float c() {
        return this.f15943b.c();
    }

    @Override // androidx.compose.material3.BottomAppBarState
    public void d(float f3) {
        this.f15943b.s(f3);
    }

    @Override // androidx.compose.material3.BottomAppBarState
    public float e() {
        return this.f15942a.c();
    }

    @Override // androidx.compose.material3.BottomAppBarState
    public void f(float f3) {
        this.f15944c.s(RangesKt.o(f3, e(), 0.0f));
    }

    @Override // androidx.compose.material3.BottomAppBarState
    public void g(float f3) {
        this.f15942a.s(f3);
    }
}
