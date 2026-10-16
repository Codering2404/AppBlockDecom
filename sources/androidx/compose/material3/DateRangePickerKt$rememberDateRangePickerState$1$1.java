package androidx.compose.material3;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
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
final class DateRangePickerKt$rememberDateRangePickerState$1$1 extends Lambda implements Function0<DateRangePickerStateImpl> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Long f17424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Long f17425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Long f17426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ IntRange f17427d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f17428f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ SelectableDates f17429g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Locale f17430h;

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final DateRangePickerStateImpl invoke() {
        return new DateRangePickerStateImpl(this.f17424a, this.f17425b, this.f17426c, this.f17427d, this.f17428f, this.f17429g, this.f17430h, null);
    }
}
