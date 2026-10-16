package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class RowColumnParentData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f7089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CrossAxisAlignment f7091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FlowLayoutData f7092d;

    public RowColumnParentData(float f3, boolean z2, CrossAxisAlignment crossAxisAlignment, FlowLayoutData flowLayoutData) {
        this.f7089a = f3;
        this.f7090b = z2;
        this.f7091c = crossAxisAlignment;
        this.f7092d = flowLayoutData;
    }

    public final CrossAxisAlignment a() {
        return this.f7091c;
    }

    public final boolean b() {
        return this.f7090b;
    }

    public final FlowLayoutData c() {
        return this.f7092d;
    }

    public final float d() {
        return this.f7089a;
    }

    public final void e(CrossAxisAlignment crossAxisAlignment) {
        this.f7091c = crossAxisAlignment;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RowColumnParentData)) {
            return false;
        }
        RowColumnParentData rowColumnParentData = (RowColumnParentData) obj;
        return Float.compare(this.f7089a, rowColumnParentData.f7089a) == 0 && this.f7090b == rowColumnParentData.f7090b && Intrinsics.areEqual(this.f7091c, rowColumnParentData.f7091c) && Intrinsics.areEqual(this.f7092d, rowColumnParentData.f7092d);
    }

    public final void f(boolean z2) {
        this.f7090b = z2;
    }

    public final void g(FlowLayoutData flowLayoutData) {
        this.f7092d = flowLayoutData;
    }

    public final void h(float f3) {
        this.f7089a = f3;
    }

    public int hashCode() {
        int iHashCode = ((Float.hashCode(this.f7089a) * 31) + Boolean.hashCode(this.f7090b)) * 31;
        CrossAxisAlignment crossAxisAlignment = this.f7091c;
        int iHashCode2 = (iHashCode + (crossAxisAlignment == null ? 0 : crossAxisAlignment.hashCode())) * 31;
        FlowLayoutData flowLayoutData = this.f7092d;
        return iHashCode2 + (flowLayoutData != null ? flowLayoutData.hashCode() : 0);
    }

    public String toString() {
        return "RowColumnParentData(weight=" + this.f7089a + ", fill=" + this.f7090b + ", crossAxisAlignment=" + this.f7091c + ", flowLayoutData=" + this.f7092d + ')';
    }

    public /* synthetic */ RowColumnParentData(float f3, boolean z2, CrossAxisAlignment crossAxisAlignment, FlowLayoutData flowLayoutData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0f : f3, (i3 & 2) != 0 ? true : z2, (i3 & 4) != 0 ? null : crossAxisAlignment, (i3 & 8) != 0 ? null : flowLayoutData);
    }
}
