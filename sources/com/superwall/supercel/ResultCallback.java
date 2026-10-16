package com.superwall.supercel;

import com.sun.jna.Pointer;
import com.superwall.supercel.UniffiCleaner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public class ResultCallback implements Disposable, AutoCloseable, ResultCallbackInterface {
    public static final Companion Companion = new Companion(null);
    private final AtomicLong callCounter;
    private final UniffiCleaner.Cleanable cleanable;
    private final Pointer pointer;
    private final AtomicBoolean wasDestroyed;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class UniffiCleanAction implements Runnable {
        private final Pointer pointer;

        public UniffiCleanAction(Pointer pointer) {
            this.pointer = pointer;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: E */
        @Override // java.lang.Runnable
        public void run() throws E, InternalException {
            Pointer pointer = this.pointer;
            if (pointer != null) {
                UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
                UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
                UniffiLib.Companion.getINSTANCE$supercel_release().uniffi_cel_eval_fn_free_resultcallback(pointer, uniffiRustCallStatus);
                Unit unit = Unit.f139807a;
                CELKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
            }
        }
    }

    public ResultCallback(Pointer pointer) {
        Intrinsics.checkNotNullParameter(pointer, "pointer");
        this.wasDestroyed = new AtomicBoolean(false);
        this.callCounter = new AtomicLong(1L);
        this.pointer = pointer;
        this.cleanable = UniffiLib.Companion.getCLEANER$supercel_release().register(this, new UniffiCleanAction(pointer));
    }

    public final <R> R callWithPointer$supercel_release(Function1<? super Pointer, ? extends R> block) {
        long j3;
        Intrinsics.checkNotNullParameter(block, "block");
        do {
            j3 = this.callCounter.get();
            if (j3 == 0) {
                throw new IllegalStateException(getClass().getSimpleName() + " object has already been destroyed");
            }
            if (j3 == Long.MAX_VALUE) {
                throw new IllegalStateException(getClass().getSimpleName() + " call counter would overflow");
            }
        } while (!this.callCounter.compareAndSet(j3, 1 + j3));
        try {
            return (R) block.invoke(uniffiClonePointer());
        } finally {
            InlineMarker.b(1);
            if (this.callCounter.decrementAndGet() == 0) {
                this.cleanable.clean();
            }
            InlineMarker.a(1);
        }
    }

    @Override // java.lang.AutoCloseable
    public synchronized void close() {
        destroy();
    }

    @Override // com.superwall.supercel.Disposable
    public void destroy() {
        if (this.wasDestroyed.compareAndSet(false, true) && this.callCounter.decrementAndGet() == 0) {
            this.cleanable.clean();
        }
    }

    protected final UniffiCleaner.Cleanable getCleanable() {
        return this.cleanable;
    }

    protected final Pointer getPointer() {
        return this.pointer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005c, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0067, code lost:
    
        if (r7.callCounter.decrementAndGet() == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0069, code lost:
    
        r7.cleanable.clean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0070, code lost:
    
        throw r8;
     */
    @Override // com.superwall.supercel.ResultCallbackInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onResult(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
        L5:
            java.util.concurrent.atomic.AtomicLong r0 = access$getCallCounter$p(r7)
            long r0 = r0.get()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L90
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 == 0) goto L71
            java.util.concurrent.atomic.AtomicLong r4 = access$getCallCounter$p(r7)
            r5 = 1
            long r5 = r5 + r0
            boolean r0 = r4.compareAndSet(r0, r5)
            if (r0 == 0) goto L5
            com.sun.jna.Pointer r0 = r7.uniffiClonePointer()     // Catch: java.lang.Throwable -> L5c
            com.superwall.supercel.UniffiNullRustCallStatusErrorHandler r1 = com.superwall.supercel.UniffiNullRustCallStatusErrorHandler.INSTANCE     // Catch: java.lang.Throwable -> L5c
            com.superwall.supercel.UniffiRustCallStatus r4 = new com.superwall.supercel.UniffiRustCallStatus     // Catch: java.lang.Throwable -> L5c
            r4.<init>()     // Catch: java.lang.Throwable -> L5c
            com.superwall.supercel.UniffiLib$Companion r5 = com.superwall.supercel.UniffiLib.Companion     // Catch: java.lang.Throwable -> L5c
            com.superwall.supercel.UniffiLib r5 = r5.getINSTANCE$supercel_release()     // Catch: java.lang.Throwable -> L5c
            com.superwall.supercel.FfiConverterString r6 = com.superwall.supercel.FfiConverterString.INSTANCE     // Catch: java.lang.Throwable -> L5c
            com.superwall.supercel.RustBuffer$ByValue r8 = r6.lower(r8)     // Catch: java.lang.Throwable -> L5c
            r5.uniffi_cel_eval_fn_method_resultcallback_on_result(r0, r8, r4)     // Catch: java.lang.Throwable -> L5c
            kotlin.Unit r8 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L5c
            com.superwall.supercel.CELKt.access$uniffiCheckCallStatus(r1, r4)     // Catch: java.lang.Throwable -> L5c
            java.util.concurrent.atomic.AtomicLong r8 = access$getCallCounter$p(r7)
            long r0 = r8.decrementAndGet()
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r8 != 0) goto L5b
            com.superwall.supercel.UniffiCleaner$Cleanable r8 = access$getCleanable(r7)
            r8.clean()
        L5b:
            return
        L5c:
            r8 = move-exception
            java.util.concurrent.atomic.AtomicLong r0 = access$getCallCounter$p(r7)
            long r0 = r0.decrementAndGet()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L70
            com.superwall.supercel.UniffiCleaner$Cleanable r0 = access$getCleanable(r7)
            r0.clean()
        L70:
            throw r8
        L71:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Class r1 = r7.getClass()
            java.lang.String r1 = r1.getSimpleName()
            r0.append(r1)
            java.lang.String r1 = " call counter would overflow"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L90:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Class r1 = r7.getClass()
            java.lang.String r1 = r1.getSimpleName()
            r0.append(r1)
            java.lang.String r1 = " object has already been destroyed"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.supercel.ResultCallback.onResult(java.lang.String):void");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E */
    public final Pointer uniffiClonePointer() throws E, InternalException {
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        UniffiLib iNSTANCE$supercel_release = UniffiLib.Companion.getINSTANCE$supercel_release();
        Pointer pointer = this.pointer;
        Intrinsics.checkNotNull(pointer);
        Pointer pointerUniffi_cel_eval_fn_clone_resultcallback = iNSTANCE$supercel_release.uniffi_cel_eval_fn_clone_resultcallback(pointer, uniffiRustCallStatus);
        CELKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return pointerUniffi_cel_eval_fn_clone_resultcallback;
    }

    public ResultCallback(NoPointer noPointer) {
        Intrinsics.checkNotNullParameter(noPointer, "noPointer");
        this.wasDestroyed = new AtomicBoolean(false);
        this.callCounter = new AtomicLong(1L);
        this.pointer = null;
        this.cleanable = UniffiLib.Companion.getCLEANER$supercel_release().register(this, new UniffiCleanAction(null));
    }
}
