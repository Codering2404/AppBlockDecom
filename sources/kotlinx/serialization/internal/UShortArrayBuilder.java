package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.UShortArray;
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
public final class UShortArrayBuilder extends PrimitiveArrayBuilder<UShortArray> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private short[] f142916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f142917b;

    public /* synthetic */ UShortArrayBuilder(short[] sArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(sArr);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public /* bridge */ /* synthetic */ Object a() {
        return UShortArray.a(f());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void b(int i3) {
        if (UShortArray.o(this.f142916a) < i3) {
            short[] sArr = this.f142916a;
            short[] sArrCopyOf = Arrays.copyOf(sArr, RangesKt.f(i3, UShortArray.o(sArr) * 2));
            Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
            this.f142916a = UShortArray.d(sArrCopyOf);
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int d() {
        return this.f142917b;
    }

    public final void e(short s2) {
        PrimitiveArrayBuilder.c(this, 0, 1, null);
        short[] sArr = this.f142916a;
        int iD = d();
        this.f142917b = iD + 1;
        UShortArray.t(sArr, iD, s2);
    }

    public short[] f() {
        short[] sArrCopyOf = Arrays.copyOf(this.f142916a, d());
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        return UShortArray.d(sArrCopyOf);
    }

    private UShortArrayBuilder(short[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        this.f142916a = bufferWithData;
        this.f142917b = UShortArray.o(bufferWithData);
        b(10);
    }
}
