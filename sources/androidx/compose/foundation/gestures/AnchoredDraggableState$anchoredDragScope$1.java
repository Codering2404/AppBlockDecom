package androidx.compose.foundation.gestures;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class AnchoredDraggableState$anchoredDragScope$1 implements AnchoredDragScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f5528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f5529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f5530c = Float.NaN;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AnchoredDraggableState f5531d;

    AnchoredDraggableState$anchoredDragScope$1(AnchoredDraggableState anchoredDraggableState) {
        this.f5531d = anchoredDraggableState;
    }

    @Override // androidx.compose.foundation.gestures.AnchoredDragScope
    public void a(float f3, float f4) {
        float fR = this.f5531d.r();
        this.f5531d.F(f3);
        this.f5531d.E(f4);
        if (Float.isNaN(fR)) {
            return;
        }
        d(f3 >= fR);
    }

    public final void c(boolean z2) {
        if (this.f5531d.r() == this.f5531d.l().c(this.f5531d.n())) {
            Object objA = this.f5531d.l().a(this.f5531d.r() + (z2 ? 1.0f : -1.0f), z2);
            if (objA == null) {
                objA = this.f5531d.n();
            }
            if (z2) {
                this.f5528a = this.f5531d.n();
                this.f5529b = objA;
            } else {
                this.f5528a = objA;
                this.f5529b = this.f5531d.n();
            }
        } else {
            Object objA2 = this.f5531d.l().a(this.f5531d.r(), false);
            if (objA2 == null) {
                objA2 = this.f5531d.n();
            }
            Object objA3 = this.f5531d.l().a(this.f5531d.r(), true);
            if (objA3 == null) {
                objA3 = this.f5531d.n();
            }
            this.f5528a = objA2;
            this.f5529b = objA3;
        }
        DraggableAnchors draggableAnchorsL = this.f5531d.l();
        Object obj = this.f5528a;
        Intrinsics.checkNotNull(obj);
        float fC = draggableAnchorsL.c(obj);
        DraggableAnchors draggableAnchorsL2 = this.f5531d.l();
        Object obj2 = this.f5529b;
        Intrinsics.checkNotNull(obj2);
        this.f5530c = Math.abs(fC - draggableAnchorsL2.c(obj2));
    }

    public final void d(boolean z2) {
        c(z2);
        if (Math.abs(this.f5531d.r() - this.f5531d.l().c(this.f5531d.n())) >= this.f5530c / 2.0f) {
            Object objN = z2 ? this.f5529b : this.f5528a;
            if (objN == null) {
                objN = this.f5531d.n();
            }
            if (((Boolean) this.f5531d.m().invoke(objN)).booleanValue()) {
                this.f5531d.B(objN);
            }
        }
    }
}
