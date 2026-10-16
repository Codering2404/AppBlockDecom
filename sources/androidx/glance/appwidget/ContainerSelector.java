package androidx.glance.appwidget;

import androidx.glance.layout.Alignment;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ContainerSelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LayoutType f37872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f37873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Alignment.Horizontal f37874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Alignment.Vertical f37875d;

    public /* synthetic */ ContainerSelector(LayoutType layoutType, int i3, Alignment.Horizontal horizontal, Alignment.Vertical vertical, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutType, i3, horizontal, vertical);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContainerSelector)) {
            return false;
        }
        ContainerSelector containerSelector = (ContainerSelector) obj;
        return this.f37872a == containerSelector.f37872a && this.f37873b == containerSelector.f37873b && Intrinsics.areEqual(this.f37874c, containerSelector.f37874c) && Intrinsics.areEqual(this.f37875d, containerSelector.f37875d);
    }

    public int hashCode() {
        int iHashCode = ((this.f37872a.hashCode() * 31) + Integer.hashCode(this.f37873b)) * 31;
        Alignment.Horizontal horizontal = this.f37874c;
        int iH = (iHashCode + (horizontal == null ? 0 : Alignment.Horizontal.h(horizontal.j()))) * 31;
        Alignment.Vertical vertical = this.f37875d;
        return iH + (vertical != null ? Alignment.Vertical.h(vertical.j()) : 0);
    }

    public String toString() {
        return "ContainerSelector(type=" + this.f37872a + ", numChildren=" + this.f37873b + ", horizontalAlignment=" + this.f37874c + ", verticalAlignment=" + this.f37875d + ')';
    }

    private ContainerSelector(LayoutType layoutType, int i3, Alignment.Horizontal horizontal, Alignment.Vertical vertical) {
        this.f37872a = layoutType;
        this.f37873b = i3;
        this.f37874c = horizontal;
        this.f37875d = vertical;
    }

    public /* synthetic */ ContainerSelector(LayoutType layoutType, int i3, Alignment.Horizontal horizontal, Alignment.Vertical vertical, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutType, i3, (i4 & 4) != 0 ? null : horizontal, (i4 & 8) != 0 ? null : vertical, null);
    }
}
