package androidx.glance.appwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class GlanceAppWidgetManager {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static DataStore f37972g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f37974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AppWidgetManager f37975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f37976c = LazyKt.b(new Function0<DataStore<Preferences>>() { // from class: androidx.glance.appwidget.GlanceAppWidgetManager$dataStore$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final DataStore invoke() {
            return this.f37984a.j();
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Companion f37969d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f37970e = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ReadOnlyProperty f37971f = PreferenceDataStoreDelegateKt.b("GlanceAppWidgetManager", null, null, null, 14, null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Preferences.Key f37973h = PreferencesKeys.h("list::Providers");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class AppWidgetManagerApi26Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AppWidgetManagerApi26Impl f37977a = new AppWidgetManagerApi26Impl();

        private AppWidgetManagerApi26Impl() {
        }

        public final boolean a(AppWidgetManager appWidgetManager) {
            return appWidgetManager.isRequestPinAppWidgetSupported();
        }

        public final boolean b(AppWidgetManager appWidgetManager, ComponentName componentName, Bundle bundle, PendingIntent pendingIntent) {
            return appWidgetManager.requestPinAppWidget(componentName, bundle, pendingIntent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ KProperty[] f37978a = {Reflection.j(new PropertyReference2Impl(Companion.class, "appManagerDataStore", "getAppManagerDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DataStore c(Context context) {
            return (DataStore) GlanceAppWidgetManager.f37971f.a(context, f37978a[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Preferences.Key d(String str) {
            return PreferencesKeys.g("provider:" + str);
        }

        private Companion() {
        }
    }

    public GlanceAppWidgetManager(Context context) {
        this.f37974a = context;
        this.f37975b = AppWidgetManager.getInstance(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final State g(Preferences preferences) {
        String packageName = this.f37974a.getPackageName();
        Set<String> set = (Set) preferences.c(f37973h);
        Map map = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (set == null) {
            return new State(map, objArr2 == true ? 1 : 0, 3, objArr == true ? 1 : 0);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : set) {
            ComponentName componentName = new ComponentName(packageName, str);
            String str2 = (String) preferences.c(f37969d.d(str));
            Pair pairA = str2 == null ? null : TuplesKt.a(componentName, str2);
            if (pairA != null) {
                arrayList.add(pairA);
            }
        }
        return new State(MapsKt.toMap(arrayList));
    }

    private final DataStore h() {
        return (DataStore) this.f37976c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DataStore j() {
        DataStore dataStoreC;
        Companion companion = f37969d;
        synchronized (companion) {
            dataStoreC = f37972g;
            if (dataStoreC == null) {
                dataStoreC = companion.c(this.f37974a);
                f37972g = dataStoreC;
            }
        }
        return dataStoreC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object k(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.glance.appwidget.GlanceAppWidgetManager$getState$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.glance.appwidget.GlanceAppWidgetManager$getState$1 r0 = (androidx.glance.appwidget.GlanceAppWidgetManager$getState$1) r0
            int r1 = r0.f37994d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f37994d = r1
            goto L18
        L13:
            androidx.glance.appwidget.GlanceAppWidgetManager$getState$1 r0 = new androidx.glance.appwidget.GlanceAppWidgetManager$getState$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f37992b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f37994d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.f37991a
            androidx.glance.appwidget.GlanceAppWidgetManager r0 = (androidx.glance.appwidget.GlanceAppWidgetManager) r0
            kotlin.ResultKt.b(r5)
            goto L4c
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.ResultKt.b(r5)
            androidx.datastore.core.DataStore r5 = r4.h()
            kotlinx.coroutines.flow.Flow r5 = r5.getData()
            r0.f37991a = r4
            r0.f37994d = r3
            java.lang.Object r5 = kotlinx.coroutines.flow.FlowKt.F(r5, r0)
            if (r5 != r1) goto L4b
            return r1
        L4b:
            r0 = r4
        L4c:
            androidx.datastore.preferences.core.Preferences r5 = (androidx.datastore.preferences.core.Preferences) r5
            if (r5 == 0) goto L58
            androidx.glance.appwidget.GlanceAppWidgetManager$State r5 = r0.g(r5)
            if (r5 != 0) goto L57
            goto L58
        L57:
            return r5
        L58:
            androidx.glance.appwidget.GlanceAppWidgetManager$State r5 = new androidx.glance.appwidget.GlanceAppWidgetManager$State
            r0 = 3
            r1 = 0
            r5.<init>(r1, r1, r0, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.GlanceAppWidgetManager.k(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object f(Continuation continuation) {
        String packageName = this.f37974a.getPackageName();
        List<AppWidgetProviderInfo> installedProviders = this.f37975b.getInstalledProviders();
        ArrayList arrayList = new ArrayList();
        for (Object obj : installedProviders) {
            if (Intrinsics.areEqual(((AppWidgetProviderInfo) obj).provider.getPackageName(), packageName)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            arrayList2.add(((AppWidgetProviderInfo) obj2).provider.getClassName());
        }
        Object objA = h().a(new GlanceAppWidgetManager$cleanReceivers$2(CollectionsKt.toSet(arrayList2), null), continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(java.lang.Class r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.glance.appwidget.GlanceAppWidgetManager$getGlanceIds$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.glance.appwidget.GlanceAppWidgetManager$getGlanceIds$1 r0 = (androidx.glance.appwidget.GlanceAppWidgetManager$getGlanceIds$1) r0
            int r1 = r0.f37990f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f37990f = r1
            goto L18
        L13:
            androidx.glance.appwidget.GlanceAppWidgetManager$getGlanceIds$1 r0 = new androidx.glance.appwidget.GlanceAppWidgetManager$getGlanceIds$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f37988c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f37990f
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r8 = r0.f37987b
            java.lang.Class r8 = (java.lang.Class) r8
            java.lang.Object r0 = r0.f37986a
            androidx.glance.appwidget.GlanceAppWidgetManager r0 = (androidx.glance.appwidget.GlanceAppWidgetManager) r0
            kotlin.ResultKt.b(r9)
            goto L4a
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            kotlin.ResultKt.b(r9)
            r0.f37986a = r7
            r0.f37987b = r8
            r0.f37990f = r3
            java.lang.Object r9 = r7.k(r0)
            if (r9 != r1) goto L49
            return r1
        L49:
            r0 = r7
        L4a:
            androidx.glance.appwidget.GlanceAppWidgetManager$State r9 = (androidx.glance.appwidget.GlanceAppWidgetManager.State) r9
            java.lang.String r8 = r8.getCanonicalName()
            if (r8 == 0) goto L9c
            java.util.Map r9 = r9.a()
            java.lang.Object r8 = r9.get(r8)
            java.util.List r8 = (java.util.List) r8
            if (r8 != 0) goto L63
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
            return r8
        L63:
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Iterator r8 = r8.iterator()
        L6e:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L9b
            java.lang.Object r1 = r8.next()
            android.content.ComponentName r1 = (android.content.ComponentName) r1
            android.appwidget.AppWidgetManager r2 = r0.f37975b
            int[] r1 = r2.getAppWidgetIds(r1)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r1.length
            r2.<init>(r3)
            int r3 = r1.length
            r4 = 0
        L88:
            if (r4 >= r3) goto L97
            r5 = r1[r4]
            androidx.glance.appwidget.AppWidgetId r6 = new androidx.glance.appwidget.AppWidgetId
            r6.<init>(r5)
            r2.add(r6)
            int r4 = r4 + 1
            goto L88
        L97:
            kotlin.collections.CollectionsKt.addAll(r9, r2)
            goto L6e
        L9b:
            return r9
        L9c:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "no canonical provider name"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.GlanceAppWidgetManager.i(java.lang.Class, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object l(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.glance.appwidget.GlanceAppWidgetManager$listKnownReceivers$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.glance.appwidget.GlanceAppWidgetManager$listKnownReceivers$1 r0 = (androidx.glance.appwidget.GlanceAppWidgetManager$listKnownReceivers$1) r0
            int r1 = r0.f37997c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f37997c = r1
            goto L18
        L13:
            androidx.glance.appwidget.GlanceAppWidgetManager$listKnownReceivers$1 r0 = new androidx.glance.appwidget.GlanceAppWidgetManager$listKnownReceivers$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f37995a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f37997c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)
            goto L45
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.b(r5)
            androidx.datastore.core.DataStore r5 = r4.h()
            kotlinx.coroutines.flow.Flow r5 = r5.getData()
            r0.f37997c = r3
            java.lang.Object r5 = kotlinx.coroutines.flow.FlowKt.F(r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            androidx.datastore.preferences.core.Preferences r5 = (androidx.datastore.preferences.core.Preferences) r5
            if (r5 == 0) goto L52
            androidx.datastore.preferences.core.Preferences$Key r0 = androidx.glance.appwidget.GlanceAppWidgetManager.f37973h
            java.lang.Object r5 = r5.c(r0)
            java.util.Set r5 = (java.util.Set) r5
            return r5
        L52:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.GlanceAppWidgetManager.l(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m(java.lang.Class r11, androidx.glance.appwidget.GlanceAppWidget r12, java.lang.Object r13, android.app.PendingIntent r14, kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.GlanceAppWidgetManager.m(java.lang.Class, androidx.glance.appwidget.GlanceAppWidget, java.lang.Object, android.app.PendingIntent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object n(GlanceAppWidgetReceiver glanceAppWidgetReceiver, GlanceAppWidget glanceAppWidget, Continuation continuation) {
        String canonicalName = glanceAppWidgetReceiver.getClass().getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("no receiver name");
        }
        String canonicalName2 = glanceAppWidget.getClass().getCanonicalName();
        if (canonicalName2 == null) {
            throw new IllegalArgumentException("no provider name");
        }
        Object objA = h().a(new GlanceAppWidgetManager$updateReceiver$2(canonicalName, canonicalName2, null), continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class State {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f37979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map f37980b;

        public State(Map map, Map map2) {
            this.f37979a = map;
            this.f37980b = map2;
        }

        public final Map a() {
            return this.f37980b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return Intrinsics.areEqual(this.f37979a, state.f37979a) && Intrinsics.areEqual(this.f37980b, state.f37980b);
        }

        public int hashCode() {
            return (this.f37979a.hashCode() * 31) + this.f37980b.hashCode();
        }

        public String toString() {
            return "State(receiverToProviderName=" + this.f37979a + ", providerNameToReceivers=" + this.f37980b + ')';
        }

        public /* synthetic */ State(Map map, Map map2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? MapsKt.emptyMap() : map, (i3 & 2) != 0 ? MapsKt.emptyMap() : map2);
        }

        public State(Map map) {
            this(map, GlanceAppWidgetManagerKt.b(map));
        }
    }
}
