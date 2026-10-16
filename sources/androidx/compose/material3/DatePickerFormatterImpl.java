package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarModel_androidKt;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class DatePickerFormatterImpl implements DatePickerFormatter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f16919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f16920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f16921d = new LinkedHashMap();

    public DatePickerFormatterImpl(String str, String str2, String str3) {
        this.f16918a = str;
        this.f16919b = str2;
        this.f16920c = str3;
    }

    @Override // androidx.compose.material3.DatePickerFormatter
    public String b(Long l3, Locale locale) {
        if (l3 == null) {
            return null;
        }
        return CalendarModel_androidKt.b(l3.longValue(), this.f16918a, locale, this.f16921d);
    }

    @Override // androidx.compose.material3.DatePickerFormatter
    public String c(Long l3, Locale locale, boolean z2) {
        if (l3 == null) {
            return null;
        }
        return CalendarModel_androidKt.b(l3.longValue(), z2 ? this.f16920c : this.f16919b, locale, this.f16921d);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DatePickerFormatterImpl)) {
            return false;
        }
        DatePickerFormatterImpl datePickerFormatterImpl = (DatePickerFormatterImpl) obj;
        return Intrinsics.areEqual(this.f16918a, datePickerFormatterImpl.f16918a) && Intrinsics.areEqual(this.f16919b, datePickerFormatterImpl.f16919b) && Intrinsics.areEqual(this.f16920c, datePickerFormatterImpl.f16920c);
    }

    public int hashCode() {
        return (((this.f16918a.hashCode() * 31) + this.f16919b.hashCode()) * 31) + this.f16920c.hashCode();
    }
}
