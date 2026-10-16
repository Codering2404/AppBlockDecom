package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.internal.SynchronizedObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

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
public abstract class NavigatorState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SynchronizedObject f48988a = new SynchronizedObject();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableStateFlow f48989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableStateFlow f48990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f48991d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final StateFlow f48992e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final StateFlow f48993f;

    public NavigatorState() {
        MutableStateFlow mutableStateFlowA = StateFlowKt.a(CollectionsKt.emptyList());
        this.f48989b = mutableStateFlowA;
        MutableStateFlow mutableStateFlowA2 = StateFlowKt.a(SetsKt.emptySet());
        this.f48990c = mutableStateFlowA2;
        this.f48992e = FlowKt.c(mutableStateFlowA);
        this.f48993f = FlowKt.c(mutableStateFlowA2);
    }

    public abstract NavBackStackEntry b(NavDestination navDestination, Bundle bundle);

    public final StateFlow c() {
        return this.f48992e;
    }

    public final StateFlow d() {
        return this.f48993f;
    }

    public final boolean e() {
        return this.f48991d;
    }

    public void f(NavBackStackEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        MutableStateFlow mutableStateFlow = this.f48990c;
        mutableStateFlow.setValue(SetsKt.minus((Set<? extends NavBackStackEntry>) mutableStateFlow.getValue(), entry));
    }

    public void g(NavBackStackEntry backStackEntry) {
        int iNextIndex;
        Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
        synchronized (this.f48988a) {
            try {
                List mutableList = CollectionsKt.toMutableList((Collection) c().getValue());
                ListIterator listIterator = mutableList.listIterator(mutableList.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        iNextIndex = -1;
                        break;
                    } else if (Intrinsics.areEqual(((NavBackStackEntry) listIterator.previous()).f(), backStackEntry.f())) {
                        iNextIndex = listIterator.nextIndex();
                        break;
                    }
                }
                mutableList.set(iNextIndex, backStackEntry);
                this.f48989b.setValue(mutableList);
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void h(NavBackStackEntry backStackEntry) {
        Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
        List list = (List) this.f48992e.getValue();
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) listIterator.previous();
            if (Intrinsics.areEqual(navBackStackEntry.f(), backStackEntry.f())) {
                MutableStateFlow mutableStateFlow = this.f48990c;
                mutableStateFlow.setValue(SetsKt.plus((Set<? extends NavBackStackEntry>) SetsKt.plus((Set<? extends NavBackStackEntry>) mutableStateFlow.getValue(), navBackStackEntry), backStackEntry));
                g(backStackEntry);
                return;
            }
        }
        throw new NoSuchElementException("List contains no element matching the predicate.");
    }

    public void i(NavBackStackEntry popUpTo, boolean z2) {
        Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
        synchronized (this.f48988a) {
            try {
                MutableStateFlow mutableStateFlow = this.f48989b;
                Iterable iterable = (Iterable) this.f48989b.getValue();
                ArrayList arrayList = new ArrayList();
                for (Object obj : iterable) {
                    if (Intrinsics.areEqual((NavBackStackEntry) obj, popUpTo)) {
                        break;
                    } else {
                        arrayList.add(obj);
                    }
                }
                mutableStateFlow.setValue(arrayList);
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void j(NavBackStackEntry popUpTo, boolean z2) {
        Object objPrevious;
        Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
        Iterable iterable = (Iterable) this.f48990c.getValue();
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((NavBackStackEntry) it.next()) == popUpTo) {
                    Iterable iterable2 = (Iterable) this.f48992e.getValue();
                    if ((iterable2 instanceof Collection) && ((Collection) iterable2).isEmpty()) {
                        return;
                    }
                    Iterator it2 = iterable2.iterator();
                    while (it2.hasNext()) {
                        if (((NavBackStackEntry) it2.next()) == popUpTo) {
                        }
                    }
                    return;
                }
            }
        }
        MutableStateFlow mutableStateFlow = this.f48990c;
        mutableStateFlow.setValue(SetsKt.plus((Set<? extends NavBackStackEntry>) mutableStateFlow.getValue(), popUpTo));
        List list = (List) this.f48992e.getValue();
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) objPrevious;
            if (!Intrinsics.areEqual(navBackStackEntry, popUpTo) && ((List) this.f48992e.getValue()).lastIndexOf(navBackStackEntry) < ((List) this.f48992e.getValue()).lastIndexOf(popUpTo)) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) objPrevious;
        if (navBackStackEntry2 != null) {
            MutableStateFlow mutableStateFlow2 = this.f48990c;
            mutableStateFlow2.setValue(SetsKt.plus((Set<? extends NavBackStackEntry>) mutableStateFlow2.getValue(), navBackStackEntry2));
        }
        i(popUpTo, z2);
    }

    public void k(NavBackStackEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        MutableStateFlow mutableStateFlow = this.f48990c;
        mutableStateFlow.setValue(SetsKt.plus((Set<? extends NavBackStackEntry>) mutableStateFlow.getValue(), entry));
    }

    public void l(NavBackStackEntry backStackEntry) {
        Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
        synchronized (this.f48988a) {
            this.f48989b.setValue(CollectionsKt.plus((Collection<? extends NavBackStackEntry>) this.f48989b.getValue(), backStackEntry));
            Unit unit = Unit.f139807a;
        }
    }

    public void m(NavBackStackEntry backStackEntry) {
        Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
        Iterable iterable = (Iterable) this.f48990c.getValue();
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((NavBackStackEntry) it.next()) == backStackEntry) {
                    Iterable iterable2 = (Iterable) this.f48992e.getValue();
                    if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
                        Iterator it2 = iterable2.iterator();
                        while (it2.hasNext()) {
                            if (((NavBackStackEntry) it2.next()) == backStackEntry) {
                                return;
                            }
                        }
                    }
                }
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) CollectionsKt.lastOrNull((List) this.f48992e.getValue());
        if (navBackStackEntry != null) {
            MutableStateFlow mutableStateFlow = this.f48990c;
            mutableStateFlow.setValue(SetsKt.plus((Set<? extends NavBackStackEntry>) mutableStateFlow.getValue(), navBackStackEntry));
        }
        MutableStateFlow mutableStateFlow2 = this.f48990c;
        mutableStateFlow2.setValue(SetsKt.plus((Set<? extends NavBackStackEntry>) mutableStateFlow2.getValue(), backStackEntry));
        l(backStackEntry);
    }

    public final void n(boolean z2) {
        this.f48991d = z2;
    }
}
