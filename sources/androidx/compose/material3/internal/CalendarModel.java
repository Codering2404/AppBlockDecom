package androidx.compose.material3.internal;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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
public abstract class CalendarModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Locale f21986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f21987b = new LinkedHashMap();

    public CalendarModel(Locale locale) {
        this.f21986a = locale;
    }

    public abstract String a(long j3, String str, Locale locale);

    public abstract CalendarDate b(long j3);

    public abstract DateInputFormat c(Locale locale);

    public abstract int d();

    public final Map e() {
        return this.f21987b;
    }

    public abstract CalendarMonth f(int i3, int i4);

    public abstract CalendarMonth g(long j3);

    public abstract CalendarMonth h(CalendarDate calendarDate);

    public abstract CalendarDate i();

    public abstract List j();

    public abstract CalendarDate k(String str, String str2);

    public abstract CalendarMonth l(CalendarMonth calendarMonth, int i3);
}
