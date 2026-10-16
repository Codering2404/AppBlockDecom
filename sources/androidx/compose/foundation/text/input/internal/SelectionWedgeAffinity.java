package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;

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
public final class SelectionWedgeAffinity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WedgeAffinity f10430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WedgeAffinity f10431b;

    public SelectionWedgeAffinity(WedgeAffinity wedgeAffinity, WedgeAffinity wedgeAffinity2) {
        this.f10430a = wedgeAffinity;
        this.f10431b = wedgeAffinity2;
    }

    public static /* synthetic */ SelectionWedgeAffinity b(SelectionWedgeAffinity selectionWedgeAffinity, WedgeAffinity wedgeAffinity, WedgeAffinity wedgeAffinity2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            wedgeAffinity = selectionWedgeAffinity.f10430a;
        }
        if ((i3 & 2) != 0) {
            wedgeAffinity2 = selectionWedgeAffinity.f10431b;
        }
        return selectionWedgeAffinity.a(wedgeAffinity, wedgeAffinity2);
    }

    public final SelectionWedgeAffinity a(WedgeAffinity wedgeAffinity, WedgeAffinity wedgeAffinity2) {
        return new SelectionWedgeAffinity(wedgeAffinity, wedgeAffinity2);
    }

    public final WedgeAffinity c() {
        return this.f10431b;
    }

    public final WedgeAffinity d() {
        return this.f10430a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectionWedgeAffinity)) {
            return false;
        }
        SelectionWedgeAffinity selectionWedgeAffinity = (SelectionWedgeAffinity) obj;
        return this.f10430a == selectionWedgeAffinity.f10430a && this.f10431b == selectionWedgeAffinity.f10431b;
    }

    public int hashCode() {
        return (this.f10430a.hashCode() * 31) + this.f10431b.hashCode();
    }

    public String toString() {
        return "SelectionWedgeAffinity(startAffinity=" + this.f10430a + ", endAffinity=" + this.f10431b + ')';
    }

    public SelectionWedgeAffinity(WedgeAffinity wedgeAffinity) {
        this(wedgeAffinity, wedgeAffinity);
    }
}
