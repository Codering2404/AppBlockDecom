package androidx.glance;

import androidx.compose.runtime.AbstractApplier;
import java.util.List;
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
public final class Applier extends AbstractApplier<Emittable> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f37523d;

    public Applier(EmittableWithChildren emittableWithChildren) {
        super(emittableWithChildren);
        this.f37523d = emittableWithChildren.e();
    }

    private final List q() {
        Emittable emittable = (Emittable) b();
        if (emittable instanceof EmittableWithChildren) {
            return ((EmittableWithChildren) emittable).d();
        }
        throw new IllegalStateException("Current node cannot accept children");
    }

    @Override // androidx.compose.runtime.Applier
    public void a(int i3, int i4) {
        o(q(), i3, i4);
    }

    @Override // androidx.compose.runtime.Applier
    public void c(int i3, int i4, int i5) {
        m(q(), i3, i4, i5);
    }

    @Override // androidx.compose.runtime.AbstractApplier
    protected void n() {
        Object objL = l();
        Intrinsics.checkNotNull(objL, "null cannot be cast to non-null type androidx.glance.EmittableWithChildren");
        ((EmittableWithChildren) objL).d().clear();
    }

    @Override // androidx.compose.runtime.Applier
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void e(int i3, Emittable emittable) {
        Object objB = b();
        Intrinsics.checkNotNull(objB, "null cannot be cast to non-null type androidx.glance.EmittableWithChildren");
        if (((EmittableWithChildren) objB).e() > 0) {
            if (emittable instanceof EmittableWithChildren) {
                EmittableWithChildren emittableWithChildren = (EmittableWithChildren) emittable;
                emittableWithChildren.g(emittableWithChildren.f() ? this.f37523d : r0.e() - 1);
            }
            q().add(i3, emittable);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Too many embedded views for the current surface. The maximum depth is: ");
        Object objL = l();
        Intrinsics.checkNotNull(objL, "null cannot be cast to non-null type androidx.glance.EmittableWithChildren");
        sb.append(((EmittableWithChildren) objL).e());
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @Override // androidx.compose.runtime.Applier
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public void g(int i3, Emittable emittable) {
    }
}
