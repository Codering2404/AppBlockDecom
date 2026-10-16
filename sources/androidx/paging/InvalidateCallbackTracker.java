package androidx.paging;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class InvalidateCallbackTracker<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f49820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f49821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ReentrantLock f49822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f49823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f49824e;

    public InvalidateCallbackTracker(Function1 callbackInvoker, Function0 function0) {
        Intrinsics.checkNotNullParameter(callbackInvoker, "callbackInvoker");
        this.f49820a = callbackInvoker;
        this.f49821b = function0;
        this.f49822c = new ReentrantLock();
        this.f49823d = new ArrayList();
    }

    public final boolean a() {
        return this.f49824e;
    }

    public final boolean b() {
        if (this.f49824e) {
            return false;
        }
        ReentrantLock reentrantLock = this.f49822c;
        try {
            reentrantLock.lock();
            if (this.f49824e) {
                return false;
            }
            this.f49824e = true;
            List list = CollectionsKt.toList(this.f49823d);
            this.f49823d.clear();
            reentrantLock.unlock();
            Function1 function1 = this.f49820a;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                function1.invoke(it.next());
            }
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void c(Object obj) {
        Function0 function0 = this.f49821b;
        boolean z2 = true;
        if (function0 != null && ((Boolean) function0.invoke()).booleanValue()) {
            b();
        }
        if (this.f49824e) {
            this.f49820a.invoke(obj);
            return;
        }
        ReentrantLock reentrantLock = this.f49822c;
        try {
            reentrantLock.lock();
            if (!this.f49824e) {
                this.f49823d.add(obj);
                z2 = false;
            }
            if (z2) {
                this.f49820a.invoke(obj);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void d(Object obj) {
        ReentrantLock reentrantLock = this.f49822c;
        try {
            reentrantLock.lock();
            this.f49823d.remove(obj);
        } finally {
            reentrantLock.unlock();
        }
    }

    public /* synthetic */ InvalidateCallbackTracker(Function1 function1, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i3 & 2) != 0 ? null : function0);
    }
}
