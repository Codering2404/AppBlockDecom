package androidx.compose.material3;

import androidx.compose.material3.internal.DateInputFormat;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

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
public final class DateInputValidator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IntRange f16837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SelectableDates f16838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DateInputFormat f16839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DatePickerFormatter f16840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f16841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f16842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f16843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f16844h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Long f16845i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Long f16846j;

    public DateInputValidator(IntRange intRange, SelectableDates selectableDates, DateInputFormat dateInputFormat, DatePickerFormatter datePickerFormatter, String str, String str2, String str3, String str4, Long l3, Long l4) {
        this.f16837a = intRange;
        this.f16838b = selectableDates;
        this.f16839c = dateInputFormat;
        this.f16840d = datePickerFormatter;
        this.f16841e = str;
        this.f16842f = str2;
        this.f16843g = str3;
        this.f16844h = str4;
        this.f16845i = l3;
        this.f16846j = l4;
    }

    public final void a(Long l3) {
        this.f16846j = l3;
    }

    public final void b(Long l3) {
        this.f16845i = l3;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String c(androidx.compose.material3.internal.CalendarDate r9, int r10, java.util.Locale r11) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateInputValidator.c(androidx.compose.material3.internal.CalendarDate, int, java.util.Locale):java.lang.String");
    }

    public /* synthetic */ DateInputValidator(IntRange intRange, SelectableDates selectableDates, DateInputFormat dateInputFormat, DatePickerFormatter datePickerFormatter, String str, String str2, String str3, String str4, Long l3, Long l4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(intRange, selectableDates, dateInputFormat, datePickerFormatter, str, str2, str3, str4, (i3 & Function.MAX_NARGS) != 0 ? null : l3, (i3 & 512) != 0 ? null : l4);
    }
}
