package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

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
final class SequenceBuilderIterator<T> extends SequenceScope<T> implements Iterator<T>, Continuation<Unit>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f140334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f140335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Iterator f140336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Continuation f140337d;

    private final Throwable d() {
        int i3 = this.f140334a;
        if (i3 == 4) {
            return new NoSuchElementException();
        }
        if (i3 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f140334a);
    }

    private final Object e() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // kotlin.sequences.SequenceScope
    public Object a(Object obj, Continuation continuation) {
        this.f140335b = obj;
        this.f140334a = 3;
        this.f140337d = continuation;
        Object objF = IntrinsicsKt.f();
        if (objF == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // kotlin.sequences.SequenceScope
    public Object b(Iterator it, Continuation continuation) {
        if (!it.hasNext()) {
            return Unit.f139807a;
        }
        this.f140336c = it;
        this.f140334a = 2;
        this.f140337d = continuation;
        Object objF = IntrinsicsKt.f();
        if (objF == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    public final void f(Continuation continuation) {
        this.f140337d = continuation;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.f139889a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i3 = this.f140334a;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2 || i3 == 3) {
                        return true;
                    }
                    if (i3 == 4) {
                        return false;
                    }
                    throw d();
                }
                Iterator it = this.f140336c;
                Intrinsics.checkNotNull(it);
                if (it.hasNext()) {
                    this.f140334a = 2;
                    return true;
                }
                this.f140336c = null;
            }
            this.f140334a = 5;
            Continuation continuation = this.f140337d;
            Intrinsics.checkNotNull(continuation);
            this.f140337d = null;
            continuation.resumeWith(Result.b(Unit.f139807a));
        }
    }

    @Override // java.util.Iterator
    public Object next() throws Throwable {
        int i3 = this.f140334a;
        if (i3 == 0 || i3 == 1) {
            return e();
        }
        if (i3 == 2) {
            this.f140334a = 1;
            Iterator it = this.f140336c;
            Intrinsics.checkNotNull(it);
            return it.next();
        }
        if (i3 != 3) {
            throw d();
        }
        this.f140334a = 0;
        Object obj = this.f140335b;
        this.f140335b = null;
        return obj;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) throws Throwable {
        ResultKt.b(obj);
        this.f140334a = 4;
    }
}
