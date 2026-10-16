package cz.mobilesoft.coreblock.view.compose;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ExpandableCheckboxItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f130472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f130473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f130474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function0 f130475d;

    public ExpandableCheckboxItem(String id, int i3, boolean z2, Function0 onClick) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.f130472a = id;
        this.f130473b = i3;
        this.f130474c = z2;
        this.f130475d = onClick;
    }

    public final Function0 a() {
        return this.f130475d;
    }

    public final int b() {
        return this.f130473b;
    }

    public final boolean c() {
        return this.f130474c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExpandableCheckboxItem)) {
            return false;
        }
        ExpandableCheckboxItem expandableCheckboxItem = (ExpandableCheckboxItem) obj;
        return Intrinsics.areEqual(this.f130472a, expandableCheckboxItem.f130472a) && this.f130473b == expandableCheckboxItem.f130473b && this.f130474c == expandableCheckboxItem.f130474c && Intrinsics.areEqual(this.f130475d, expandableCheckboxItem.f130475d);
    }

    public int hashCode() {
        return (((((this.f130472a.hashCode() * 31) + Integer.hashCode(this.f130473b)) * 31) + Boolean.hashCode(this.f130474c)) * 31) + this.f130475d.hashCode();
    }

    public String toString() {
        return "ExpandableCheckboxItem(id=" + this.f130472a + ", titleResId=" + this.f130473b + ", isChecked=" + this.f130474c + ", onClick=" + this.f130475d + ")";
    }
}
