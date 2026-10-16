package com.superwall.supercel;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.superwall.supercel.ForeignBytes;
import com.superwall.supercel.RustBuffer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public interface UniffiLib extends Library {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Lazy<UniffiLib> INSTANCE$delegate = LazyKt.b(new Function0<UniffiLib>() { // from class: com.superwall.supercel.UniffiLib$Companion$INSTANCE$2
            @Override // kotlin.jvm.functions.Function0
            public final UniffiLib invoke() {
                Library libraryLoad = Native.load(CELKt.findLibraryName("cel"), (Class<Library>) IntegrityCheckingUniffiLib.class);
                Intrinsics.checkNotNullExpressionValue(libraryLoad, "load(...)");
                IntegrityCheckingUniffiLib integrityCheckingUniffiLib = (IntegrityCheckingUniffiLib) libraryLoad;
                CELKt.uniffiCheckContractApiVersion(integrityCheckingUniffiLib);
                CELKt.uniffiCheckApiChecksums(integrityCheckingUniffiLib);
                Library libraryLoad2 = Native.load(CELKt.findLibraryName("cel"), (Class<Library>) UniffiLib.class);
                Intrinsics.checkNotNullExpressionValue(libraryLoad2, "load(...)");
                UniffiLib uniffiLib = (UniffiLib) libraryLoad2;
                uniffiCallbackInterfaceHostContext.INSTANCE.register$supercel_release(uniffiLib);
                return uniffiLib;
            }
        });
        private static final Lazy<UniffiCleaner> CLEANER$delegate = LazyKt.b(new Function0<UniffiCleaner>() { // from class: com.superwall.supercel.UniffiLib$Companion$CLEANER$2
            @Override // kotlin.jvm.functions.Function0
            public final UniffiCleaner invoke() {
                return CELKt.create(UniffiCleaner.Companion);
            }
        });

        private Companion() {
        }

        public final UniffiCleaner getCLEANER$supercel_release() {
            return (UniffiCleaner) CLEANER$delegate.getValue();
        }

        public final UniffiLib getINSTANCE$supercel_release() {
            return (UniffiLib) INSTANCE$delegate.getValue();
        }
    }

    void ffi_cel_eval_rust_future_cancel_f32(long j3);

    void ffi_cel_eval_rust_future_cancel_f64(long j3);

    void ffi_cel_eval_rust_future_cancel_i16(long j3);

    void ffi_cel_eval_rust_future_cancel_i32(long j3);

    void ffi_cel_eval_rust_future_cancel_i64(long j3);

    void ffi_cel_eval_rust_future_cancel_i8(long j3);

    void ffi_cel_eval_rust_future_cancel_pointer(long j3);

    void ffi_cel_eval_rust_future_cancel_rust_buffer(long j3);

    void ffi_cel_eval_rust_future_cancel_u16(long j3);

    void ffi_cel_eval_rust_future_cancel_u32(long j3);

    void ffi_cel_eval_rust_future_cancel_u64(long j3);

    void ffi_cel_eval_rust_future_cancel_u8(long j3);

    void ffi_cel_eval_rust_future_cancel_void(long j3);

    float ffi_cel_eval_rust_future_complete_f32(long j3, UniffiRustCallStatus uniffiRustCallStatus);

    double ffi_cel_eval_rust_future_complete_f64(long j3, UniffiRustCallStatus uniffiRustCallStatus);

    short ffi_cel_eval_rust_future_complete_i16(long j3, UniffiRustCallStatus uniffiRustCallStatus);

    int ffi_cel_eval_rust_future_complete_i32(long j3, UniffiRustCallStatus uniffiRustCallStatus);

    long ffi_cel_eval_rust_future_complete_i64(long j3, UniffiRustCallStatus uniffiRustCallStatus);

    byte ffi_cel_eval_rust_future_complete_i8(long j3, UniffiRustCallStatus uniffiRustCallStatus);

    Pointer ffi_cel_eval_rust_future_complete_pointer(long j3, UniffiRustCallStatus uniffiRustCallStatus);

    RustBuffer.ByValue ffi_cel_eval_rust_future_complete_rust_buffer(long j3, UniffiRustCallStatus uniffiRustCallStatus);

    short ffi_cel_eval_rust_future_complete_u16(long j3, UniffiRustCallStatus uniffiRustCallStatus);

    int ffi_cel_eval_rust_future_complete_u32(long j3, UniffiRustCallStatus uniffiRustCallStatus);

    long ffi_cel_eval_rust_future_complete_u64(long j3, UniffiRustCallStatus uniffiRustCallStatus);

    byte ffi_cel_eval_rust_future_complete_u8(long j3, UniffiRustCallStatus uniffiRustCallStatus);

    void ffi_cel_eval_rust_future_complete_void(long j3, UniffiRustCallStatus uniffiRustCallStatus);

    void ffi_cel_eval_rust_future_free_f32(long j3);

    void ffi_cel_eval_rust_future_free_f64(long j3);

    void ffi_cel_eval_rust_future_free_i16(long j3);

    void ffi_cel_eval_rust_future_free_i32(long j3);

    void ffi_cel_eval_rust_future_free_i64(long j3);

    void ffi_cel_eval_rust_future_free_i8(long j3);

    void ffi_cel_eval_rust_future_free_pointer(long j3);

    void ffi_cel_eval_rust_future_free_rust_buffer(long j3);

    void ffi_cel_eval_rust_future_free_u16(long j3);

    void ffi_cel_eval_rust_future_free_u32(long j3);

    void ffi_cel_eval_rust_future_free_u64(long j3);

    void ffi_cel_eval_rust_future_free_u8(long j3);

    void ffi_cel_eval_rust_future_free_void(long j3);

    void ffi_cel_eval_rust_future_poll_f32(long j3, UniffiRustFutureContinuationCallback uniffiRustFutureContinuationCallback, long j4);

    void ffi_cel_eval_rust_future_poll_f64(long j3, UniffiRustFutureContinuationCallback uniffiRustFutureContinuationCallback, long j4);

    void ffi_cel_eval_rust_future_poll_i16(long j3, UniffiRustFutureContinuationCallback uniffiRustFutureContinuationCallback, long j4);

    void ffi_cel_eval_rust_future_poll_i32(long j3, UniffiRustFutureContinuationCallback uniffiRustFutureContinuationCallback, long j4);

    void ffi_cel_eval_rust_future_poll_i64(long j3, UniffiRustFutureContinuationCallback uniffiRustFutureContinuationCallback, long j4);

    void ffi_cel_eval_rust_future_poll_i8(long j3, UniffiRustFutureContinuationCallback uniffiRustFutureContinuationCallback, long j4);

    void ffi_cel_eval_rust_future_poll_pointer(long j3, UniffiRustFutureContinuationCallback uniffiRustFutureContinuationCallback, long j4);

    void ffi_cel_eval_rust_future_poll_rust_buffer(long j3, UniffiRustFutureContinuationCallback uniffiRustFutureContinuationCallback, long j4);

    void ffi_cel_eval_rust_future_poll_u16(long j3, UniffiRustFutureContinuationCallback uniffiRustFutureContinuationCallback, long j4);

    void ffi_cel_eval_rust_future_poll_u32(long j3, UniffiRustFutureContinuationCallback uniffiRustFutureContinuationCallback, long j4);

    void ffi_cel_eval_rust_future_poll_u64(long j3, UniffiRustFutureContinuationCallback uniffiRustFutureContinuationCallback, long j4);

    void ffi_cel_eval_rust_future_poll_u8(long j3, UniffiRustFutureContinuationCallback uniffiRustFutureContinuationCallback, long j4);

    void ffi_cel_eval_rust_future_poll_void(long j3, UniffiRustFutureContinuationCallback uniffiRustFutureContinuationCallback, long j4);

    RustBuffer.ByValue ffi_cel_eval_rustbuffer_alloc(long j3, UniffiRustCallStatus uniffiRustCallStatus);

    void ffi_cel_eval_rustbuffer_free(RustBuffer.ByValue byValue, UniffiRustCallStatus uniffiRustCallStatus);

    RustBuffer.ByValue ffi_cel_eval_rustbuffer_from_bytes(ForeignBytes.ByValue byValue, UniffiRustCallStatus uniffiRustCallStatus);

    RustBuffer.ByValue ffi_cel_eval_rustbuffer_reserve(RustBuffer.ByValue byValue, long j3, UniffiRustCallStatus uniffiRustCallStatus);

    Pointer uniffi_cel_eval_fn_clone_hostcontext(Pointer pointer, UniffiRustCallStatus uniffiRustCallStatus);

    Pointer uniffi_cel_eval_fn_clone_resultcallback(Pointer pointer, UniffiRustCallStatus uniffiRustCallStatus);

    void uniffi_cel_eval_fn_free_hostcontext(Pointer pointer, UniffiRustCallStatus uniffiRustCallStatus);

    void uniffi_cel_eval_fn_free_resultcallback(Pointer pointer, UniffiRustCallStatus uniffiRustCallStatus);

    RustBuffer.ByValue uniffi_cel_eval_fn_func_evaluate_ast(RustBuffer.ByValue byValue, UniffiRustCallStatus uniffiRustCallStatus);

    RustBuffer.ByValue uniffi_cel_eval_fn_func_evaluate_ast_with_context(RustBuffer.ByValue byValue, Pointer pointer, UniffiRustCallStatus uniffiRustCallStatus);

    RustBuffer.ByValue uniffi_cel_eval_fn_func_evaluate_with_context(RustBuffer.ByValue byValue, Pointer pointer, UniffiRustCallStatus uniffiRustCallStatus);

    RustBuffer.ByValue uniffi_cel_eval_fn_func_parse_to_ast(RustBuffer.ByValue byValue, UniffiRustCallStatus uniffiRustCallStatus);

    void uniffi_cel_eval_fn_init_callback_vtable_hostcontext(UniffiVTableCallbackInterfaceHostContext uniffiVTableCallbackInterfaceHostContext);

    void uniffi_cel_eval_fn_method_hostcontext_computed_property(Pointer pointer, RustBuffer.ByValue byValue, RustBuffer.ByValue byValue2, Pointer pointer2, UniffiRustCallStatus uniffiRustCallStatus);

    void uniffi_cel_eval_fn_method_hostcontext_device_property(Pointer pointer, RustBuffer.ByValue byValue, RustBuffer.ByValue byValue2, Pointer pointer2, UniffiRustCallStatus uniffiRustCallStatus);

    void uniffi_cel_eval_fn_method_resultcallback_on_result(Pointer pointer, RustBuffer.ByValue byValue, UniffiRustCallStatus uniffiRustCallStatus);
}
