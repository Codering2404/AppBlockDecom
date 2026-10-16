package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.TransportRuntimeComponent;
import com.google.android.datatransport.runtime.backends.CreationContextFactory_Factory;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry_Factory;
import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler_Factory;
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule_ConfigFactory;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_DbNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_PackageNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_SchemaVersionFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_StoreConfigFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import javax.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class DaggerTransportRuntimeComponent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Builder implements TransportRuntimeComponent.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f69333a;

        private Builder() {
        }

        @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent.Builder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Builder a(Context context) {
            this.f69333a = (Context) Preconditions.b(context);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent.Builder
        public TransportRuntimeComponent build() {
            Preconditions.a(this.f69333a, Context.class);
            return new TransportRuntimeComponentImpl(this.f69333a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class TransportRuntimeComponentImpl extends TransportRuntimeComponent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TransportRuntimeComponentImpl f69334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Provider f69335b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Provider f69336c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Provider f69337d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Provider f69338f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Provider f69339g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Provider f69340h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Provider f69341i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Provider f69342j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private Provider f69343k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private Provider f69344l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private Provider f69345m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private Provider f69346n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private Provider f69347o;

        private void c(Context context) {
            this.f69335b = DoubleCheck.a(ExecutionModule_ExecutorFactory.a());
            Factory factoryA = InstanceFactory.a(context);
            this.f69336c = factoryA;
            CreationContextFactory_Factory creationContextFactory_FactoryA = CreationContextFactory_Factory.a(factoryA, TimeModule_EventClockFactory.a(), TimeModule_UptimeClockFactory.a());
            this.f69337d = creationContextFactory_FactoryA;
            this.f69338f = DoubleCheck.a(MetadataBackendRegistry_Factory.a(this.f69336c, creationContextFactory_FactoryA));
            this.f69339g = SchemaManager_Factory.a(this.f69336c, EventStoreModule_DbNameFactory.a(), EventStoreModule_SchemaVersionFactory.a());
            this.f69340h = DoubleCheck.a(EventStoreModule_PackageNameFactory.a(this.f69336c));
            this.f69341i = DoubleCheck.a(SQLiteEventStore_Factory.a(TimeModule_EventClockFactory.a(), TimeModule_UptimeClockFactory.a(), EventStoreModule_StoreConfigFactory.a(), this.f69339g, this.f69340h));
            SchedulingConfigModule_ConfigFactory schedulingConfigModule_ConfigFactoryB = SchedulingConfigModule_ConfigFactory.b(TimeModule_EventClockFactory.a());
            this.f69342j = schedulingConfigModule_ConfigFactoryB;
            SchedulingModule_WorkSchedulerFactory schedulingModule_WorkSchedulerFactoryA = SchedulingModule_WorkSchedulerFactory.a(this.f69336c, this.f69341i, schedulingConfigModule_ConfigFactoryB, TimeModule_UptimeClockFactory.a());
            this.f69343k = schedulingModule_WorkSchedulerFactoryA;
            Provider provider = this.f69335b;
            Provider provider2 = this.f69338f;
            Provider provider3 = this.f69341i;
            this.f69344l = DefaultScheduler_Factory.a(provider, provider2, schedulingModule_WorkSchedulerFactoryA, provider3, provider3);
            Provider provider4 = this.f69336c;
            Provider provider5 = this.f69338f;
            Provider provider6 = this.f69341i;
            this.f69345m = Uploader_Factory.a(provider4, provider5, provider6, this.f69343k, this.f69335b, provider6, TimeModule_EventClockFactory.a(), TimeModule_UptimeClockFactory.a(), this.f69341i);
            Provider provider7 = this.f69335b;
            Provider provider8 = this.f69341i;
            this.f69346n = WorkInitializer_Factory.a(provider7, provider8, this.f69343k, provider8);
            this.f69347o = DoubleCheck.a(TransportRuntime_Factory.a(TimeModule_EventClockFactory.a(), TimeModule_UptimeClockFactory.a(), this.f69344l, this.f69345m, this.f69346n));
        }

        @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent
        EventStore a() {
            return (EventStore) this.f69341i.get();
        }

        @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent
        TransportRuntime b() {
            return (TransportRuntime) this.f69347o.get();
        }

        private TransportRuntimeComponentImpl(Context context) {
            this.f69334a = this;
            c(context);
        }
    }

    public static TransportRuntimeComponent.Builder a() {
        return new Builder();
    }
}
