package androidx.compose.material3.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class DateInputFormat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char f22000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f22001c;

    public DateInputFormat(String str, char c3) {
        this.f21999a = str;
        this.f22000b = c3;
        this.f22001c = StringsKt.O(str, String.valueOf(c3), "", false, 4, null);
    }

    public final char a() {
        return this.f22000b;
    }

    public final String b() {
        return this.f21999a;
    }

    public final String c() {
        return this.f22001c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DateInputFormat)) {
            return false;
        }
        DateInputFormat dateInputFormat = (DateInputFormat) obj;
        return Intrinsics.areEqual(this.f21999a, dateInputFormat.f21999a) && this.f22000b == dateInputFormat.f22000b;
    }

    public int hashCode() {
        return (this.f21999a.hashCode() * 31) + Character.hashCode(this.f22000b);
    }

    public String toString() {
        return "DateInputFormat(patternWithDelimiters=" + this.f21999a + ", delimiter=" + this.f22000b + ')';
    }
}
