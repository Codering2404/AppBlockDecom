package com.superwall.supercel;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Structure.FieldOrder({"capacity", "len", "data"})
public class RustBuffer extends Structure {
    public static final Companion Companion = new Companion(null);
    public long capacity;
    public Pointer data;
    public long len;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ByReference extends RustBuffer implements Structure.ByReference {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ByValue extends RustBuffer implements Structure.ByValue {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: alloc-VKZWuLQ$supercel_release$default, reason: not valid java name */
        public static /* synthetic */ ByValue m1352allocVKZWuLQ$supercel_release$default(Companion companion, long j3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                j3 = 0;
            }
            return companion.m1353allocVKZWuLQ$supercel_release(j3);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: E */
        /* JADX INFO: renamed from: alloc-VKZWuLQ$supercel_release, reason: not valid java name */
        public final ByValue m1353allocVKZWuLQ$supercel_release(long j3) throws E, InternalException {
            UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
            UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
            ByValue byValueFfi_cel_eval_rustbuffer_alloc = UniffiLib.Companion.getINSTANCE$supercel_release().ffi_cel_eval_rustbuffer_alloc(j3, uniffiRustCallStatus);
            CELKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
            if (byValueFfi_cel_eval_rustbuffer_alloc.data != null) {
                return byValueFfi_cel_eval_rustbuffer_alloc;
            }
            throw new RuntimeException("RustBuffer.alloc() returned null data pointer (size=" + ((Object) ULong.f(j3)) + ')');
        }

        /* JADX INFO: renamed from: create-twO9MuI$supercel_release, reason: not valid java name */
        public final ByValue m1354createtwO9MuI$supercel_release(long j3, long j4, Pointer pointer) {
            ByValue byValue = new ByValue();
            byValue.capacity = j3;
            byValue.len = j4;
            byValue.data = pointer;
            return byValue;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: E */
        public final void free$supercel_release(ByValue buf) throws E, InternalException {
            Intrinsics.checkNotNullParameter(buf, "buf");
            UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
            UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
            UniffiLib.Companion.getINSTANCE$supercel_release().ffi_cel_eval_rustbuffer_free(buf, uniffiRustCallStatus);
            Unit unit = Unit.f139807a;
            CELKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        }

        private Companion() {
        }
    }

    public final ByteBuffer asByteBuffer() {
        ByteBuffer byteBuffer;
        Pointer pointer = this.data;
        if (pointer == null || (byteBuffer = pointer.getByteBuffer(0L, this.len)) == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        return byteBuffer;
    }

    public final void setValue$supercel_release(RustBuffer other) {
        Intrinsics.checkNotNullParameter(other, "other");
        this.capacity = other.capacity;
        this.len = other.len;
        this.data = other.data;
    }
}
