package androidx.work.impl.model;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class Preference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f54972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Long f54973b;

    public Preference(String key, Long l3) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.f54972a = key;
        this.f54973b = l3;
    }

    public final String a() {
        return this.f54972a;
    }

    public final Long b() {
        return this.f54973b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Preference)) {
            return false;
        }
        Preference preference = (Preference) obj;
        return Intrinsics.areEqual(this.f54972a, preference.f54972a) && Intrinsics.areEqual(this.f54973b, preference.f54973b);
    }

    public int hashCode() {
        int iHashCode = this.f54972a.hashCode() * 31;
        Long l3 = this.f54973b;
        return iHashCode + (l3 == null ? 0 : l3.hashCode());
    }

    public String toString() {
        return "Preference(key=" + this.f54972a + ", value=" + this.f54973b + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Preference(String key, boolean z2) {
        this(key, Long.valueOf(z2 ? 1L : 0L));
        Intrinsics.checkNotNullParameter(key, "key");
    }
}
