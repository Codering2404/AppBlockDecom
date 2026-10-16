package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.UByteArray;
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
public final class UByteArrayBuilder extends PrimitiveArrayBuilder<UByteArray> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f142901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f142902b;

    public /* synthetic */ UByteArrayBuilder(byte[] bArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public /* bridge */ /* synthetic */ Object a() {
        return UByteArray.a(f());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void b(int i3) {
        if (UByteArray.o(this.f142901a) < i3) {
            byte[] bArr = this.f142901a;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, RangesKt.f(i3, UByteArray.o(bArr) * 2));
            Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
            this.f142901a = UByteArray.d(bArrCopyOf);
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int d() {
        return this.f142902b;
    }

    public final void e(byte b3) {
        PrimitiveArrayBuilder.c(this, 0, 1, null);
        byte[] bArr = this.f142901a;
        int iD = d();
        this.f142902b = iD + 1;
        UByteArray.t(bArr, iD, b3);
    }

    public byte[] f() {
        byte[] bArrCopyOf = Arrays.copyOf(this.f142901a, d());
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return UByteArray.d(bArrCopyOf);
    }

    private UByteArrayBuilder(byte[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        this.f142901a = bufferWithData;
        this.f142902b = UByteArray.o(bufferWithData);
        b(10);
    }
}
