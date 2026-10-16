package androidx.preference;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

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
public final class PreferenceGroupKt$iterator$1 implements Iterator<Preference>, KMutableIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f50926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PreferenceGroup f50927b;

    PreferenceGroupKt$iterator$1(PreferenceGroup preferenceGroup) {
        this.f50927b = preferenceGroup;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Preference next() {
        PreferenceGroup preferenceGroup = this.f50927b;
        int i3 = this.f50926a;
        this.f50926a = i3 + 1;
        Preference preferenceH0 = preferenceGroup.H0(i3);
        Intrinsics.checkNotNullExpressionValue(preferenceH0, "getPreference(index++)");
        return preferenceH0;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f50926a < this.f50927b.I0();
    }

    @Override // java.util.Iterator
    public void remove() {
        PreferenceGroup preferenceGroup = this.f50927b;
        int i3 = this.f50926a - 1;
        this.f50926a = i3;
        preferenceGroup.K0(preferenceGroup.H0(i3));
    }
}
