package cz.mobilesoft.coreblock.view.compose.material3;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class RadioPickerItem<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f131182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f131183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f131184c;

    public RadioPickerItem(Object obj, String label, boolean z2) {
        Intrinsics.checkNotNullParameter(label, "label");
        this.f131182a = obj;
        this.f131183b = label;
        this.f131184c = z2;
    }

    public final boolean a() {
        return this.f131184c;
    }

    public final String b() {
        return this.f131183b;
    }

    public final Object c() {
        return this.f131182a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RadioPickerItem)) {
            return false;
        }
        RadioPickerItem radioPickerItem = (RadioPickerItem) obj;
        return Intrinsics.areEqual(this.f131182a, radioPickerItem.f131182a) && Intrinsics.areEqual(this.f131183b, radioPickerItem.f131183b) && this.f131184c == radioPickerItem.f131184c;
    }

    public int hashCode() {
        Object obj = this.f131182a;
        return ((((obj == null ? 0 : obj.hashCode()) * 31) + this.f131183b.hashCode()) * 31) + Boolean.hashCode(this.f131184c);
    }

    public String toString() {
        return "RadioPickerItem(value=" + this.f131182a + ", label=" + this.f131183b + ", enabled=" + this.f131184c + ")";
    }

    public /* synthetic */ RadioPickerItem(Object obj, String str, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, str, (i3 & 4) != 0 ? true : z2);
    }
}
