package androidx.glance.appwidget;

import androidx.glance.layout.Alignment;
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
public final class BoxChildSelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LayoutType f37806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f37807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f37808c;

    public /* synthetic */ BoxChildSelector(LayoutType layoutType, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutType, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BoxChildSelector)) {
            return false;
        }
        BoxChildSelector boxChildSelector = (BoxChildSelector) obj;
        return this.f37806a == boxChildSelector.f37806a && Alignment.Horizontal.g(this.f37807b, boxChildSelector.f37807b) && Alignment.Vertical.g(this.f37808c, boxChildSelector.f37808c);
    }

    public int hashCode() {
        return (((this.f37806a.hashCode() * 31) + Alignment.Horizontal.h(this.f37807b)) * 31) + Alignment.Vertical.h(this.f37808c);
    }

    public String toString() {
        return "BoxChildSelector(type=" + this.f37806a + ", horizontalAlignment=" + ((Object) Alignment.Horizontal.i(this.f37807b)) + ", verticalAlignment=" + ((Object) Alignment.Vertical.i(this.f37808c)) + ')';
    }

    private BoxChildSelector(LayoutType layoutType, int i3, int i4) {
        this.f37806a = layoutType;
        this.f37807b = i3;
        this.f37808c = i4;
    }
}
