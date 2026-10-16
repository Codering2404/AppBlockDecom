package androidx.glance.appwidget;

import androidx.glance.appwidget.unit.CheckableColorProvider;
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
public final class SwitchColorsImpl extends SwitchColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CheckableColorProvider f38456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CheckableColorProvider f38457b;

    public SwitchColorsImpl(CheckableColorProvider checkableColorProvider, CheckableColorProvider checkableColorProvider2) {
        super(null);
        this.f38456a = checkableColorProvider;
        this.f38457b = checkableColorProvider2;
    }

    @Override // androidx.glance.appwidget.SwitchColors
    public CheckableColorProvider a() {
        return this.f38456a;
    }

    @Override // androidx.glance.appwidget.SwitchColors
    public CheckableColorProvider b() {
        return this.f38457b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwitchColorsImpl)) {
            return false;
        }
        SwitchColorsImpl switchColorsImpl = (SwitchColorsImpl) obj;
        return Intrinsics.areEqual(this.f38456a, switchColorsImpl.f38456a) && Intrinsics.areEqual(this.f38457b, switchColorsImpl.f38457b);
    }

    public int hashCode() {
        return (this.f38456a.hashCode() * 31) + this.f38457b.hashCode();
    }

    public String toString() {
        return "SwitchColorsImpl(thumb=" + this.f38456a + ", track=" + this.f38457b + ')';
    }
}
