package androidx.room;

import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class TransactionExecutor implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f52385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayDeque f52386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Runnable f52387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f52388d;

    public TransactionExecutor(Executor executor) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.f52385a = executor;
        this.f52386b = new ArrayDeque();
        this.f52388d = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Runnable runnable, TransactionExecutor transactionExecutor) {
        try {
            runnable.run();
        } finally {
            transactionExecutor.c();
        }
    }

    public final void c() {
        synchronized (this.f52388d) {
            try {
                Object objPoll = this.f52386b.poll();
                Runnable runnable = (Runnable) objPoll;
                this.f52387c = runnable;
                if (objPoll != null) {
                    this.f52385a.execute(runnable);
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, MHoiDDglUlPJC.iqOS);
        synchronized (this.f52388d) {
            try {
                this.f52386b.offer(new Runnable() { // from class: androidx.room.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        TransactionExecutor.b(runnable, this);
                    }
                });
                if (this.f52387c == null) {
                    c();
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
