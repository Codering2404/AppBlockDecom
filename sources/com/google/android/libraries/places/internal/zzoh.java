package com.google.android.libraries.places.internal;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.common.base.Preconditions;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzoh implements ViewModelProvider.Factory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zznx f78321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzom f78322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzpu f78323d;

    public zzoh(zznx zznxVar, zzom zzomVar, zzpu zzpuVar) {
        this.f78321b = zznxVar;
        this.f78322c = zzomVar;
        this.f78323d = zzpuVar;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final ViewModel create(Class cls) {
        Preconditions.e(cls == zzoi.class, "This factory can only be used to instantiate its enclosing class.");
        return new zzoi(this.f78321b, this.f78322c, this.f78323d, null);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final ViewModel create(Class cls, CreationExtras creationExtras) {
        return create(cls);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final ViewModel create(KClass kClass, CreationExtras creationExtras) {
        return create(JvmClassMappingKt.a(kClass));
    }
}
