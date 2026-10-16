package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ULongArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.ExperimentalSerializationApi;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
@ExperimentalSerializationApi
public final class ULongArrayBuilder extends PrimitiveArrayBuilder<ULongArray> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long[] f142911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f142912b;

    public /* synthetic */ ULongArrayBuilder(long[] jArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(jArr);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public /* bridge */ /* synthetic */ Object a() {
        return ULongArray.a(f());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void b(int i3) {
        if (ULongArray.o(this.f142911a) < i3) {
            long[] jArr = this.f142911a;
            long[] jArrCopyOf = Arrays.copyOf(jArr, RangesKt.f(i3, ULongArray.o(jArr) * 2));
            Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
            this.f142911a = ULongArray.d(jArrCopyOf);
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int d() {
        return this.f142912b;
    }

    public final void e(long j3) {
        PrimitiveArrayBuilder.c(this, 0, 1, null);
        long[] jArr = this.f142911a;
        int iD = d();
        this.f142912b = iD + 1;
        ULongArray.t(jArr, iD, j3);
    }

    public long[] f() {
        long[] jArrCopyOf = Arrays.copyOf(this.f142911a, d());
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        return ULongArray.d(jArrCopyOf);
    }

    private ULongArrayBuilder(long[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        this.f142911a = bufferWithData;
        this.f142912b = ULongArray.o(bufferWithData);
        b(10);
    }
}
