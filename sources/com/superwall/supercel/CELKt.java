package com.superwall.supercel;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.superwall.supercel.RustBuffer;
import com.superwall.supercel.UniffiCleaner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class CELKt {
    public static final int IDX_CALLBACK_FREE = 0;
    public static final int UNIFFI_CALLBACK_ERROR = 1;
    public static final int UNIFFI_CALLBACK_SUCCESS = 0;
    public static final int UNIFFI_CALLBACK_UNEXPECTED_ERROR = 2;
    public static final byte UNIFFI_CALL_ERROR = 1;
    public static final byte UNIFFI_CALL_SUCCESS = 0;
    public static final byte UNIFFI_CALL_UNEXPECTED_ERROR = 2;

    /* JADX INFO: Access modifiers changed from: private */
    public static final UniffiCleaner create(UniffiCleaner.Companion companion) {
        try {
            Class.forName("java.lang.ref.Cleaner");
            return new JavaLangRefCleaner();
        } catch (ClassNotFoundException unused) {
            return new UniffiJnaCleaner();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E */
    public static final String evaluateAst(String ast) throws E, InternalException {
        Intrinsics.checkNotNullParameter(ast, "ast");
        FfiConverterString ffiConverterString = FfiConverterString.INSTANCE;
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        RustBuffer.ByValue byValueUniffi_cel_eval_fn_func_evaluate_ast = UniffiLib.Companion.getINSTANCE$supercel_release().uniffi_cel_eval_fn_func_evaluate_ast(ffiConverterString.lower(ast), uniffiRustCallStatus);
        uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return ffiConverterString.lift(byValueUniffi_cel_eval_fn_func_evaluate_ast);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E */
    public static final String evaluateAstWithContext(String definition, HostContext context) throws E, InternalException {
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(context, "context");
        FfiConverterString ffiConverterString = FfiConverterString.INSTANCE;
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        RustBuffer.ByValue byValueUniffi_cel_eval_fn_func_evaluate_ast_with_context = UniffiLib.Companion.getINSTANCE$supercel_release().uniffi_cel_eval_fn_func_evaluate_ast_with_context(ffiConverterString.lower(definition), FfiConverterTypeHostContext.INSTANCE.lower(context), uniffiRustCallStatus);
        uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return ffiConverterString.lift(byValueUniffi_cel_eval_fn_func_evaluate_ast_with_context);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E */
    public static final String evaluateWithContext(String definition, HostContext context) throws E, InternalException {
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(context, "context");
        FfiConverterString ffiConverterString = FfiConverterString.INSTANCE;
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        RustBuffer.ByValue byValueUniffi_cel_eval_fn_func_evaluate_with_context = UniffiLib.Companion.getINSTANCE$supercel_release().uniffi_cel_eval_fn_func_evaluate_with_context(ffiConverterString.lower(definition), FfiConverterTypeHostContext.INSTANCE.lower(context), uniffiRustCallStatus);
        uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return ffiConverterString.lift(byValueUniffi_cel_eval_fn_func_evaluate_with_context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final synchronized String findLibraryName(String str) {
        String property = System.getProperty("uniffi.component." + str + ".libraryOverride");
        return property != null ? property : "uniffi_cel";
    }

    private static final /* synthetic */ <Lib extends Library> Lib loadIndirect(String str) {
        String strFindLibraryName = findLibraryName(str);
        Intrinsics.reifiedOperationMarker(4, "Lib");
        Lib lib = (Lib) Native.load(strFindLibraryName, Library.class);
        Intrinsics.checkNotNullExpressionValue(lib, "load(...)");
        return lib;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E */
    public static final String parseToAst(String expression) throws E, InternalException {
        Intrinsics.checkNotNullParameter(expression, "expression");
        FfiConverterString ffiConverterString = FfiConverterString.INSTANCE;
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        RustBuffer.ByValue byValueUniffi_cel_eval_fn_func_parse_to_ast = UniffiLib.Companion.getINSTANCE$supercel_release().uniffi_cel_eval_fn_func_parse_to_ast(ffiConverterString.lower(expression), uniffiRustCallStatus);
        uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return ffiConverterString.lift(byValueUniffi_cel_eval_fn_func_parse_to_ast);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uniffiCheckApiChecksums(IntegrityCheckingUniffiLib integrityCheckingUniffiLib) {
        if (integrityCheckingUniffiLib.uniffi_cel_eval_checksum_func_evaluate_ast() != -10787) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_cel_eval_checksum_func_evaluate_ast_with_context() != 28567) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_cel_eval_checksum_func_evaluate_with_context() != -28217) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_cel_eval_checksum_func_parse_to_ast() != -25071) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_cel_eval_checksum_method_hostcontext_computed_property() != 5366) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_cel_eval_checksum_method_hostcontext_device_property() != 7074) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
        if (integrityCheckingUniffiLib.uniffi_cel_eval_checksum_method_resultcallback_on_result() != 27954) {
            throw new RuntimeException("UniFFI API checksum mismatch: try cleaning and rebuilding your project");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: E extends java.lang.Exception */
    public static final <E extends Exception> void uniffiCheckCallStatus(UniffiRustCallStatusErrorHandler<E> uniffiRustCallStatusErrorHandler, UniffiRustCallStatus uniffiRustCallStatus) throws E, InternalException {
        if (uniffiRustCallStatus.isSuccess()) {
            return;
        }
        if (uniffiRustCallStatus.isError()) {
            throw uniffiRustCallStatusErrorHandler.lift(uniffiRustCallStatus.error_buf);
        }
        if (uniffiRustCallStatus.isPanic()) {
            if (uniffiRustCallStatus.error_buf.len <= 0) {
                throw new InternalException("Rust panic");
            }
            throw new InternalException(FfiConverterString.INSTANCE.lift(uniffiRustCallStatus.error_buf));
        }
        throw new InternalException("Unknown rust call status: " + uniffiRustCallStatus + ".code");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uniffiCheckContractApiVersion(IntegrityCheckingUniffiLib integrityCheckingUniffiLib) {
        if (29 != integrityCheckingUniffiLib.ffi_cel_eval_uniffi_contract_version()) {
            throw new RuntimeException("UniFFI contract version mismatch: try cleaning and rebuilding your project");
        }
    }

    public static final void uniffiEnsureInitialized() {
        UniffiLib.Companion.getINSTANCE$supercel_release();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E */
    private static final <U> U uniffiRustCall(Function1<? super UniffiRustCallStatus, ? extends U> function1) throws E, InternalException {
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        U u2 = (U) function1.invoke(uniffiRustCallStatus);
        uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return u2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E */
    private static final <U, E extends Exception> U uniffiRustCallWithError(UniffiRustCallStatusErrorHandler<E> uniffiRustCallStatusErrorHandler, Function1<? super UniffiRustCallStatus, ? extends U> function1) throws E, InternalException {
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        U u2 = (U) function1.invoke(uniffiRustCallStatus);
        uniffiCheckCallStatus(uniffiRustCallStatusErrorHandler, uniffiRustCallStatus);
        return u2;
    }

    public static final <T> void uniffiTraitInterfaceCall(UniffiRustCallStatus callStatus, Function0<? extends T> makeCall, Function1<? super T, Unit> writeReturn) {
        Intrinsics.checkNotNullParameter(callStatus, "callStatus");
        Intrinsics.checkNotNullParameter(makeCall, "makeCall");
        Intrinsics.checkNotNullParameter(writeReturn, "writeReturn");
        try {
            writeReturn.invoke(makeCall.invoke());
        } catch (Exception e3) {
            callStatus.code = (byte) 2;
            callStatus.error_buf = FfiConverterString.INSTANCE.lower(e3.toString());
        }
    }

    public static final /* synthetic */ <T, E extends Throwable> void uniffiTraitInterfaceCallWithError(UniffiRustCallStatus callStatus, Function0<? extends T> makeCall, Function1<? super T, Unit> writeReturn, Function1<? super E, RustBuffer.ByValue> lowerError) {
        Intrinsics.checkNotNullParameter(callStatus, "callStatus");
        Intrinsics.checkNotNullParameter(makeCall, "makeCall");
        Intrinsics.checkNotNullParameter(writeReturn, "writeReturn");
        Intrinsics.checkNotNullParameter(lowerError, "lowerError");
        try {
            writeReturn.invoke(makeCall.invoke());
        } catch (Exception e3) {
            Intrinsics.reifiedOperationMarker(3, "E");
            callStatus.code = (byte) 1;
            callStatus.error_buf = (RustBuffer.ByValue) lowerError.invoke(e3);
        }
    }

    public static final <T extends Disposable, R> R use(T t2, Function1<? super T, ? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return (R) block.invoke(t2);
        } finally {
            InlineMarker.b(1);
            if (t2 != null) {
                try {
                    t2.destroy();
                } catch (Throwable unused) {
                }
            }
            InlineMarker.a(1);
        }
    }
}
