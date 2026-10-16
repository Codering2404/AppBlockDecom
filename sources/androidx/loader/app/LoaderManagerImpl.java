package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class LoaderManagerImpl extends LoaderManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static boolean f40259c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LifecycleOwner f40260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LoaderViewModel f40261b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final int f40262l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final Bundle f40263m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final Loader f40264n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private LifecycleOwner f40265o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private LoaderObserver f40266p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private Loader f40267q;

        LoaderInfo(int i3, Bundle bundle, Loader loader, Loader loader2) {
            this.f40262l = i3;
            this.f40263m = bundle;
            this.f40264n = loader;
            this.f40267q = loader2;
            loader.t(i3, this);
        }

        @Override // androidx.loader.content.Loader.OnLoadCompleteListener
        public void a(Loader loader, Object obj) {
            if (LoaderManagerImpl.f40259c) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                p(obj);
                return;
            }
            if (LoaderManagerImpl.f40259c) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            n(obj);
        }

        @Override // androidx.lifecycle.LiveData
        protected void l() {
            if (LoaderManagerImpl.f40259c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.f40264n.w();
        }

        @Override // androidx.lifecycle.LiveData
        protected void m() {
            if (LoaderManagerImpl.f40259c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f40264n.x();
        }

        @Override // androidx.lifecycle.LiveData
        public void o(Observer observer) {
            super.o(observer);
            this.f40265o = null;
            this.f40266p = null;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void p(Object obj) {
            super.p(obj);
            Loader loader = this.f40267q;
            if (loader != null) {
                loader.u();
                this.f40267q = null;
            }
        }

        Loader q(boolean z2) {
            if (LoaderManagerImpl.f40259c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f40264n.b();
            this.f40264n.a();
            LoaderObserver loaderObserver = this.f40266p;
            if (loaderObserver != null) {
                o(loaderObserver);
                if (z2) {
                    loaderObserver.d();
                }
            }
            this.f40264n.z(this);
            if ((loaderObserver == null || loaderObserver.c()) && !z2) {
                return this.f40264n;
            }
            this.f40264n.u();
            return this.f40267q;
        }

        public void r(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f40262l);
            printWriter.print(" mArgs=");
            printWriter.println(this.f40263m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f40264n);
            this.f40264n.g(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f40266p != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f40266p);
                this.f40266p.b(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(s().d(f()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(h());
        }

        Loader s() {
            return this.f40264n;
        }

        void t() {
            LifecycleOwner lifecycleOwner = this.f40265o;
            LoaderObserver loaderObserver = this.f40266p;
            if (lifecycleOwner == null || loaderObserver == null) {
                return;
            }
            super.o(loaderObserver);
            j(lifecycleOwner, loaderObserver);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f40262l);
            sb.append(" : ");
            DebugUtils.a(this.f40264n, sb);
            sb.append("}}");
            return sb.toString();
        }

        Loader u(LifecycleOwner lifecycleOwner, LoaderManager.LoaderCallbacks loaderCallbacks) {
            LoaderObserver loaderObserver = new LoaderObserver(this.f40264n, loaderCallbacks);
            j(lifecycleOwner, loaderObserver);
            LoaderObserver loaderObserver2 = this.f40266p;
            if (loaderObserver2 != null) {
                o(loaderObserver2);
            }
            this.f40265o = lifecycleOwner;
            this.f40266p = loaderObserver;
            return this.f40264n;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class LoaderObserver<D> implements Observer<D> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Loader f40268a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final LoaderManager.LoaderCallbacks f40269b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f40270c = false;

        LoaderObserver(Loader loader, LoaderManager.LoaderCallbacks loaderCallbacks) {
            this.f40268a = loader;
            this.f40269b = loaderCallbacks;
        }

        @Override // androidx.lifecycle.Observer
        public void a(Object obj) {
            if (LoaderManagerImpl.f40259c) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f40268a + ": " + this.f40268a.d(obj));
            }
            this.f40269b.a(this.f40268a, obj);
            this.f40270c = true;
        }

        public void b(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f40270c);
        }

        boolean c() {
            return this.f40270c;
        }

        void d() {
            if (this.f40270c) {
                if (LoaderManagerImpl.f40259c) {
                    Log.v("LoaderManager", "  Resetting: " + this.f40268a);
                }
                this.f40269b.c(this.f40268a);
            }
        }

        public String toString() {
            return this.f40269b.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class LoaderViewModel extends ViewModel {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final ViewModelProvider.Factory f40271c = new ViewModelProvider.Factory() { // from class: androidx.loader.app.LoaderManagerImpl.LoaderViewModel.1
            @Override // androidx.lifecycle.ViewModelProvider.Factory
            public ViewModel create(Class cls) {
                return new LoaderViewModel();
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SparseArrayCompat f40272a = new SparseArrayCompat();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f40273b = false;

        LoaderViewModel() {
        }

        static LoaderViewModel A0(ViewModelStore viewModelStore) {
            return (LoaderViewModel) new ViewModelProvider(viewModelStore, f40271c).a(LoaderViewModel.class);
        }

        LoaderInfo B0(int i3) {
            return (LoaderInfo) this.f40272a.g(i3);
        }

        boolean C0() {
            return this.f40273b;
        }

        void D0() {
            int iQ = this.f40272a.q();
            for (int i3 = 0; i3 < iQ; i3++) {
                ((LoaderInfo) this.f40272a.r(i3)).t();
            }
        }

        void E0(int i3, LoaderInfo loaderInfo) {
            this.f40272a.m(i3, loaderInfo);
        }

        void F0() {
            this.f40273b = true;
        }

        @Override // androidx.lifecycle.ViewModel
        protected void onCleared() {
            super.onCleared();
            int iQ = this.f40272a.q();
            for (int i3 = 0; i3 < iQ; i3++) {
                ((LoaderInfo) this.f40272a.r(i3)).q(true);
            }
            this.f40272a.b();
        }

        public void y0(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f40272a.q() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i3 = 0; i3 < this.f40272a.q(); i3++) {
                    LoaderInfo loaderInfo = (LoaderInfo) this.f40272a.r(i3);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f40272a.k(i3));
                    printWriter.print(": ");
                    printWriter.println(loaderInfo.toString());
                    loaderInfo.r(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void z0() {
            this.f40273b = false;
        }
    }

    LoaderManagerImpl(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        this.f40260a = lifecycleOwner;
        this.f40261b = LoaderViewModel.A0(viewModelStore);
    }

    private Loader e(int i3, Bundle bundle, LoaderManager.LoaderCallbacks loaderCallbacks, Loader loader) {
        try {
            this.f40261b.F0();
            Loader loaderB = loaderCallbacks.b(i3, bundle);
            if (loaderB == null) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
            }
            if (loaderB.getClass().isMemberClass() && !Modifier.isStatic(loaderB.getClass().getModifiers())) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + loaderB);
            }
            LoaderInfo loaderInfo = new LoaderInfo(i3, bundle, loaderB, loader);
            if (f40259c) {
                Log.v("LoaderManager", "  Created new loader " + loaderInfo);
            }
            this.f40261b.E0(i3, loaderInfo);
            this.f40261b.z0();
            return loaderInfo.u(this.f40260a, loaderCallbacks);
        } catch (Throwable th) {
            this.f40261b.z0();
            throw th;
        }
    }

    @Override // androidx.loader.app.LoaderManager
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f40261b.y0(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.loader.app.LoaderManager
    public Loader c(int i3, Bundle bundle, LoaderManager.LoaderCallbacks loaderCallbacks) {
        if (this.f40261b.C0()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        LoaderInfo loaderInfoB0 = this.f40261b.B0(i3);
        if (f40259c) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
        }
        if (loaderInfoB0 == null) {
            return e(i3, bundle, loaderCallbacks, null);
        }
        if (f40259c) {
            Log.v("LoaderManager", "  Re-using existing loader " + loaderInfoB0);
        }
        return loaderInfoB0.u(this.f40260a, loaderCallbacks);
    }

    @Override // androidx.loader.app.LoaderManager
    public void d() {
        this.f40261b.D0();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.a(this.f40260a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
