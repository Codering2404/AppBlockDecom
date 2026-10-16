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
public class HostContextImpl implements Disposable, AutoCloseable, HostContext {
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
                UniffiLib.Companion.getINSTANCE$supercel_release().uniffi_cel_eval_fn_free_hostcontext(pointer, uniffiRustCallStatus);
                Unit unit = Unit.f139807a;
                CELKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
            }
        }
    }

    public HostContextImpl(Pointer pointer) {
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

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0070, code lost:
    
        r0 = move-exception;
     */
    @Override // com.superwall.supercel.HostContext
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void computedProperty(java.lang.String r11, java.lang.String r12, com.superwall.supercel.ResultCallback r13) {
        /*
            r10 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "args"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "callback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
        Lf:
            java.util.concurrent.atomic.AtomicLong r0 = access$getCallCounter$p(r10)
            long r0 = r0.get()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto La5
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 == 0) goto L86
            java.util.concurrent.atomic.AtomicLong r4 = access$getCallCounter$p(r10)
            r5 = 1
            long r5 = r5 + r0
            boolean r0 = r4.compareAndSet(r0, r5)
            if (r0 == 0) goto Lf
            com.sun.jna.Pointer r5 = r10.uniffiClonePointer()     // Catch: java.lang.Throwable -> L70
            com.superwall.supercel.UniffiNullRustCallStatusErrorHandler r0 = com.superwall.supercel.UniffiNullRustCallStatusErrorHandler.INSTANCE     // Catch: java.lang.Throwable -> L70
            com.superwall.supercel.UniffiRustCallStatus r9 = new com.superwall.supercel.UniffiRustCallStatus     // Catch: java.lang.Throwable -> L70
            r9.<init>()     // Catch: java.lang.Throwable -> L70
            com.superwall.supercel.UniffiLib$Companion r1 = com.superwall.supercel.UniffiLib.Companion     // Catch: java.lang.Throwable -> L70
            com.superwall.supercel.UniffiLib r4 = r1.getINSTANCE$supercel_release()     // Catch: java.lang.Throwable -> L70
            com.superwall.supercel.FfiConverterString r1 = com.superwall.supercel.FfiConverterString.INSTANCE     // Catch: java.lang.Throwable -> L70
            com.superwall.supercel.RustBuffer$ByValue r6 = r1.lower(r11)     // Catch: java.lang.Throwable -> L70
            com.superwall.supercel.RustBuffer$ByValue r7 = r1.lower(r12)     // Catch: java.lang.Throwable -> L70
            com.superwall.supercel.FfiConverterTypeResultCallback r11 = com.superwall.supercel.FfiConverterTypeResultCallback.INSTANCE     // Catch: java.lang.Throwable -> L70
            com.sun.jna.Pointer r8 = r11.lower(r13)     // Catch: java.lang.Throwable -> L70
            r4.uniffi_cel_eval_fn_method_hostcontext_computed_property(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L70
            kotlin.Unit r11 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L70
            com.superwall.supercel.CELKt.access$uniffiCheckCallStatus(r0, r9)     // Catch: java.lang.Throwable -> L70
            java.util.concurrent.atomic.AtomicLong r11 = access$getCallCounter$p(r10)
            long r11 = r11.decrementAndGet()
            int r11 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r11 != 0) goto L6f
            com.superwall.supercel.UniffiCleaner$Cleanable r11 = access$getCleanable(r10)
            r11.clean()
        L6f:
            return
        L70:
            r0 = move-exception
            r11 = r0
            java.util.concurrent.atomic.AtomicLong r12 = access$getCallCounter$p(r10)
            long r12 = r12.decrementAndGet()
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L85
            com.superwall.supercel.UniffiCleaner$Cleanable r12 = access$getCleanable(r10)
            r12.clean()
        L85:
            throw r11
        L86:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.Class r13 = r10.getClass()
            java.lang.String r13 = r13.getSimpleName()
            r12.append(r13)
            java.lang.String r13 = " call counter would overflow"
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        La5:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.Class r13 = r10.getClass()
            java.lang.String r13 = r13.getSimpleName()
            r12.append(r13)
            java.lang.String r13 = " object has already been destroyed"
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.supercel.HostContextImpl.computedProperty(java.lang.String, java.lang.String, com.superwall.supercel.ResultCallback):void");
    }

    @Override // com.superwall.supercel.Disposable
    public void destroy() {
        if (this.wasDestroyed.compareAndSet(false, true) && this.callCounter.decrementAndGet() == 0) {
            this.cleanable.clean();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0070, code lost:
    
        r0 = move-exception;
     */
    @Override // com.superwall.supercel.HostContext
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void deviceProperty(java.lang.String r11, java.lang.String r12, com.superwall.supercel.ResultCallback r13) {
        /*
            r10 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "args"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "callback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
        Lf:
            java.util.concurrent.atomic.AtomicLong r0 = access$getCallCounter$p(r10)
            long r0 = r0.get()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto La5
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 == 0) goto L86
            java.util.concurrent.atomic.AtomicLong r4 = access$getCallCounter$p(r10)
            r5 = 1
            long r5 = r5 + r0
            boolean r0 = r4.compareAndSet(r0, r5)
            if (r0 == 0) goto Lf
            com.sun.jna.Pointer r5 = r10.uniffiClonePointer()     // Catch: java.lang.Throwable -> L70
            com.superwall.supercel.UniffiNullRustCallStatusErrorHandler r0 = com.superwall.supercel.UniffiNullRustCallStatusErrorHandler.INSTANCE     // Catch: java.lang.Throwable -> L70
            com.superwall.supercel.UniffiRustCallStatus r9 = new com.superwall.supercel.UniffiRustCallStatus     // Catch: java.lang.Throwable -> L70
            r9.<init>()     // Catch: java.lang.Throwable -> L70
            com.superwall.supercel.UniffiLib$Companion r1 = com.superwall.supercel.UniffiLib.Companion     // Catch: java.lang.Throwable -> L70
            com.superwall.supercel.UniffiLib r4 = r1.getINSTANCE$supercel_release()     // Catch: java.lang.Throwable -> L70
            com.superwall.supercel.FfiConverterString r1 = com.superwall.supercel.FfiConverterString.INSTANCE     // Catch: java.lang.Throwable -> L70
            com.superwall.supercel.RustBuffer$ByValue r6 = r1.lower(r11)     // Catch: java.lang.Throwable -> L70
            com.superwall.supercel.RustBuffer$ByValue r7 = r1.lower(r12)     // Catch: java.lang.Throwable -> L70
            com.superwall.supercel.FfiConverterTypeResultCallback r11 = com.superwall.supercel.FfiConverterTypeResultCallback.INSTANCE     // Catch: java.lang.Throwable -> L70
            com.sun.jna.Pointer r8 = r11.lower(r13)     // Catch: java.lang.Throwable -> L70
            r4.uniffi_cel_eval_fn_method_hostcontext_device_property(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L70
            kotlin.Unit r11 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L70
            com.superwall.supercel.CELKt.access$uniffiCheckCallStatus(r0, r9)     // Catch: java.lang.Throwable -> L70
            java.util.concurrent.atomic.AtomicLong r11 = access$getCallCounter$p(r10)
            long r11 = r11.decrementAndGet()
            int r11 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r11 != 0) goto L6f
            com.superwall.supercel.UniffiCleaner$Cleanable r11 = access$getCleanable(r10)
            r11.clean()
        L6f:
            return
        L70:
            r0 = move-exception
            r11 = r0
            java.util.concurrent.atomic.AtomicLong r12 = access$getCallCounter$p(r10)
            long r12 = r12.decrementAndGet()
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L85
            com.superwall.supercel.UniffiCleaner$Cleanable r12 = access$getCleanable(r10)
            r12.clean()
        L85:
            throw r11
        L86:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.Class r13 = r10.getClass()
            java.lang.String r13 = r13.getSimpleName()
            r12.append(r13)
            java.lang.String r13 = " call counter would overflow"
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        La5:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.Class r13 = r10.getClass()
            java.lang.String r13 = r13.getSimpleName()
            r12.append(r13)
            java.lang.String r13 = " object has already been destroyed"
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.supercel.HostContextImpl.deviceProperty(java.lang.String, java.lang.String, com.superwall.supercel.ResultCallback):void");
    }

    protected final UniffiCleaner.Cleanable getCleanable() {
        return this.cleanable;
    }

    protected final Pointer getPointer() {
        return this.pointer;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E */
    public final Pointer uniffiClonePointer() throws E, InternalException {
        UniffiNullRustCallStatusErrorHandler uniffiNullRustCallStatusErrorHandler = UniffiNullRustCallStatusErrorHandler.INSTANCE;
        UniffiRustCallStatus uniffiRustCallStatus = new UniffiRustCallStatus();
        UniffiLib iNSTANCE$supercel_release = UniffiLib.Companion.getINSTANCE$supercel_release();
        Pointer pointer = this.pointer;
        Intrinsics.checkNotNull(pointer);
        Pointer pointerUniffi_cel_eval_fn_clone_hostcontext = iNSTANCE$supercel_release.uniffi_cel_eval_fn_clone_hostcontext(pointer, uniffiRustCallStatus);
        CELKt.uniffiCheckCallStatus(uniffiNullRustCallStatusErrorHandler, uniffiRustCallStatus);
        return pointerUniffi_cel_eval_fn_clone_hostcontext;
    }

    public HostContextImpl(NoPointer noPointer) {
        Intrinsics.checkNotNullParameter(noPointer, "noPointer");
        this.wasDestroyed = new AtomicBoolean(false);
        this.callCounter = new AtomicLong(1L);
        this.pointer = null;
        this.cleanable = UniffiLib.Companion.getCLEANER$supercel_release().register(this, new UniffiCleanAction(null));
    }
}
