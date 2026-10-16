package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.UIntArray;
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
public final class UIntArrayBuilder extends PrimitiveArrayBuilder<UIntArray> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f142906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f142907b;

    public /* synthetic */ UIntArrayBuilder(int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(iArr);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public /* bridge */ /* synthetic */ Object a() {
        return UIntArray.a(f());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void b(int i3) {
        if (UIntArray.o(this.f142906a) < i3) {
            int[] iArr = this.f142906a;
            int[] iArrCopyOf = Arrays.copyOf(iArr, RangesKt.f(i3, UIntArray.o(iArr) * 2));
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
            this.f142906a = UIntArray.d(iArrCopyOf);
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int d() {
        return this.f142907b;
    }

    public final void e(int i3) {
        PrimitiveArrayBuilder.c(this, 0, 1, null);
        int[] iArr = this.f142906a;
        int iD = d();
        this.f142907b = iD + 1;
        UIntArray.t(iArr, iD, i3);
    }

    public int[] f() {
        int[] iArrCopyOf = Arrays.copyOf(this.f142906a, d());
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        return UIntArray.d(iArrCopyOf);
    }

    private UIntArrayBuilder(int[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        this.f142906a = bufferWithData;
        this.f142907b = UIntArray.o(bufferWithData);
        b(10);
    }
}
