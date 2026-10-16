package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
final class CompletedContinuation<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f140902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CancelHandler f140903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function3 f140904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f140905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Throwable f140906e;

    public CompletedContinuation(Object obj, CancelHandler cancelHandler, Function3 function3, Object obj2, Throwable th) {
        this.f140902a = obj;
        this.f140903b = cancelHandler;
        this.f140904c = function3;
        this.f140905d = obj2;
        this.f140906e = th;
    }

    public static /* synthetic */ CompletedContinuation b(CompletedContinuation completedContinuation, Object obj, CancelHandler cancelHandler, Function3 function3, Object obj2, Throwable th, int i3, Object obj3) {
        if ((i3 & 1) != 0) {
            obj = completedContinuation.f140902a;
        }
        if ((i3 & 2) != 0) {
            cancelHandler = completedContinuation.f140903b;
        }
        if ((i3 & 4) != 0) {
            function3 = completedContinuation.f140904c;
        }
        if ((i3 & 8) != 0) {
            obj2 = completedContinuation.f140905d;
        }
        if ((i3 & 16) != 0) {
            th = completedContinuation.f140906e;
        }
        Throwable th2 = th;
        Function3 function32 = function3;
        return completedContinuation.a(obj, cancelHandler, function32, obj2, th2);
    }

    public final CompletedContinuation a(Object obj, CancelHandler cancelHandler, Function3 function3, Object obj2, Throwable th) {
        return new CompletedContinuation(obj, cancelHandler, function3, obj2, th);
    }

    public final boolean c() {
        return this.f140906e != null;
    }

    public final void d(CancellableContinuationImpl cancellableContinuationImpl, Throwable th) {
        CancelHandler cancelHandler = this.f140903b;
        if (cancelHandler != null) {
            cancellableContinuationImpl.j(cancelHandler, th);
        }
        Function3 function3 = this.f140904c;
        if (function3 != null) {
            cancellableContinuationImpl.k(function3, th, this.f140902a);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompletedContinuation)) {
            return false;
        }
        CompletedContinuation completedContinuation = (CompletedContinuation) obj;
        return Intrinsics.areEqual(this.f140902a, completedContinuation.f140902a) && Intrinsics.areEqual(this.f140903b, completedContinuation.f140903b) && Intrinsics.areEqual(this.f140904c, completedContinuation.f140904c) && Intrinsics.areEqual(this.f140905d, completedContinuation.f140905d) && Intrinsics.areEqual(this.f140906e, completedContinuation.f140906e);
    }

    public int hashCode() {
        Object obj = this.f140902a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        CancelHandler cancelHandler = this.f140903b;
        int iHashCode2 = (iHashCode + (cancelHandler == null ? 0 : cancelHandler.hashCode())) * 31;
        Function3 function3 = this.f140904c;
        int iHashCode3 = (iHashCode2 + (function3 == null ? 0 : function3.hashCode())) * 31;
        Object obj2 = this.f140905d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f140906e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f140902a + ", cancelHandler=" + this.f140903b + ", onCancellation=" + this.f140904c + ", idempotentResume=" + this.f140905d + ", cancelCause=" + this.f140906e + ')';
    }

    public /* synthetic */ CompletedContinuation(Object obj, CancelHandler cancelHandler, Function3 function3, Object obj2, Throwable th, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i3 & 2) != 0 ? null : cancelHandler, (i3 & 4) != 0 ? null : function3, (i3 & 8) != 0 ? null : obj2, (i3 & 16) != 0 ? null : th);
    }
}
