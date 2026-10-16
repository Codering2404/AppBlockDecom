package androidx.compose.material3;

import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
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
final class DateRangePickerStateImpl$Companion$Saver$2 extends Lambda implements Function1<List, DateRangePickerStateImpl> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SelectableDates f17436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Locale f17437b;

    @Override // kotlin.jvm.functions.Function1
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final DateRangePickerStateImpl invoke(List list) {
        Long l3 = (Long) list.get(0);
        Long l4 = (Long) list.get(1);
        Long l5 = (Long) list.get(2);
        Object obj = list.get(3);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) obj).intValue();
        Object obj2 = list.get(4);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
        IntRange intRange = new IntRange(iIntValue, ((Integer) obj2).intValue());
        Object obj3 = list.get(5);
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
        return new DateRangePickerStateImpl(l3, l4, l5, intRange, DisplayMode.d(((Integer) obj3).intValue()), this.f17436a, this.f17437b, null);
    }
}
