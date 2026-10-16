package cz.mobilesoft.coreblock.util.livedata;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ProcessLifecycleOwner;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class FreshLiveData<T> extends MutableLiveData<T> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Map f128730l = new LinkedHashMap();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class FreshLiveDataObserver implements Observer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CopyOnWriteArraySet f128731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicBoolean f128732b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ FreshLiveData f128733c;

        public FreshLiveDataObserver(FreshLiveData freshLiveData, Observer observer) {
            Intrinsics.checkNotNullParameter(observer, "observer");
            this.f128733c = freshLiveData;
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            this.f128731a = copyOnWriteArraySet;
            this.f128732b = new AtomicBoolean(false);
            copyOnWriteArraySet.add(observer);
        }

        @Override // androidx.lifecycle.Observer
        public void a(Object obj) {
            if (this.f128732b.compareAndSet(true, false)) {
                synchronized (this.f128731a) {
                    try {
                        Iterator<T> it = this.f128731a.iterator();
                        while (it.hasNext()) {
                            ((Observer) it.next()).a(obj);
                        }
                        Unit unit = Unit.f139807a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public final boolean b(Observer observer) {
            Intrinsics.checkNotNullParameter(observer, "observer");
            return this.f128731a.add(observer);
        }

        public final boolean c(Observer observer) {
            Intrinsics.checkNotNullParameter(observer, "observer");
            return this.f128731a.remove(observer);
        }

        public final void d() {
            this.f128732b.set(true);
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void j(LifecycleOwner owner, Observer observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        FreshLiveDataObserver freshLiveDataObserver = (FreshLiveDataObserver) this.f128730l.get(owner);
        if (freshLiveDataObserver != null) {
            freshLiveDataObserver.b(observer);
            return;
        }
        Map map = this.f128730l;
        FreshLiveDataObserver freshLiveDataObserver2 = new FreshLiveDataObserver(this, observer);
        super.j(owner, freshLiveDataObserver2);
        map.put(owner, freshLiveDataObserver2);
    }

    @Override // androidx.lifecycle.LiveData
    public void k(Observer observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Map map = this.f128730l;
        ProcessLifecycleOwner.Companion companion = ProcessLifecycleOwner.f40032j;
        FreshLiveDataObserver freshLiveDataObserver = (FreshLiveDataObserver) map.get(companion.a());
        if (freshLiveDataObserver != null) {
            freshLiveDataObserver.b(observer);
            return;
        }
        Map map2 = this.f128730l;
        LifecycleOwner lifecycleOwnerA = companion.a();
        FreshLiveDataObserver freshLiveDataObserver2 = new FreshLiveDataObserver(this, observer);
        super.k(freshLiveDataObserver2);
        map2.put(lifecycleOwnerA, freshLiveDataObserver2);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void n(Object obj) {
        synchronized (this.f128730l) {
            try {
                Iterator it = this.f128730l.entrySet().iterator();
                while (it.hasNext()) {
                    ((FreshLiveDataObserver) ((Map.Entry) it.next()).getValue()).d();
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
        super.n(obj);
    }

    @Override // androidx.lifecycle.LiveData
    public void o(Observer observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Iterator it = this.f128730l.entrySet().iterator();
        while (it.hasNext()) {
            ((FreshLiveDataObserver) ((Map.Entry) it.next()).getValue()).c(observer);
        }
        super.o(observer);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void p(Object obj) {
        Iterator it = this.f128730l.entrySet().iterator();
        while (it.hasNext()) {
            ((FreshLiveDataObserver) ((Map.Entry) it.next()).getValue()).d();
        }
        super.p(obj);
    }
}
