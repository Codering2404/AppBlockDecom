package com.superwall.sdk.storage;

import android.content.Context;
import androidx.glance.color.Tq.KqqtdetwHMIO;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.analytics.internal.TrackingKt;
import com.superwall.sdk.analytics.internal.TrackingResult;
import com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent;
import com.superwall.sdk.analytics.internal.trackable.Trackable;
import com.superwall.sdk.dependencies.DeviceHelperFactory;
import com.superwall.sdk.dependencies.HasExternalPurchaseControllerFactory;
import com.superwall.sdk.misc.ConstantsKt;
import com.superwall.sdk.misc.IOScope;
import com.superwall.sdk.models.triggers.Experiment;
import com.superwall.sdk.network.device.DeviceInfo;
import com.superwall.sdk.storage.core_data.CoreDataManager;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.Json;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public class LocalStorage implements Storage, CoroutineScope {
    private final String _apiKey;
    private Map<String, Experiment.Variant> _confirmedAssignments;
    private boolean _didTrackFirstSeen;
    private boolean _didTrackFirstSession;
    private String apiKey;
    private final Cache cache;
    private final CoreDataManager coreDataManager;
    private final CoroutineContext coroutineContext;
    private String debugKey;
    private final Factory factory;
    private final IOScope ioScope;
    private final Json json;
    private boolean neverCalledStaticConfig;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Factory extends DeviceHelperFactory, HasExternalPurchaseControllerFactory {
    }

    /* JADX INFO: renamed from: com.superwall.sdk.storage.LocalStorage$recordAppInstall$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.storage.LocalStorage$recordAppInstall$1", f = "LocalStorage.kt", l = {177}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DeviceInfo $deviceInfo;
        final /* synthetic */ boolean $hasExternalPurchaseController;
        final /* synthetic */ Function2<Trackable, Continuation<? super Result<TrackingResult>>, Object> $trackEvent;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(DeviceInfo deviceInfo, boolean z2, Function2<? super Trackable, ? super Continuation<? super Result<TrackingResult>>, ? extends Object> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$deviceInfo = deviceInfo;
            this.$hasExternalPurchaseController = z2;
            this.$trackEvent = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$deviceInfo, this.$hasExternalPurchaseController, this.$trackEvent, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                InternalSuperwallEvent.AppInstall appInstall = new InternalSuperwallEvent.AppInstall(this.$deviceInfo.getAppInstalledAtString(), this.$hasExternalPurchaseController, null, 4, null);
                Function2<Trackable, Continuation<? super Result<TrackingResult>>, Object> function2 = this.$trackEvent;
                this.label = 1;
                if (function2.invoke(appInstall, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.storage.LocalStorage$recordFirstSeenTracked$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.storage.LocalStorage$recordFirstSeenTracked$1", f = "LocalStorage.kt", l = {}, m = "invokeSuspend")
    static final class C29051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.superwall.sdk.storage.LocalStorage$recordFirstSeenTracked$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.storage.LocalStorage$recordFirstSeenTracked$1$1", f = "LocalStorage.kt", l = {144}, m = "invokeSuspend")
        static final class C02531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            C02531(Continuation<? super C02531> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02531(continuation);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.label;
                int i4 = 1;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    Superwall companion = Superwall.Companion.getInstance();
                    InternalSuperwallEvent.FirstSeen firstSeen = new InternalSuperwallEvent.FirstSeen(null, i4, 0 == true ? 1 : 0);
                    this.label = 1;
                    if (TrackingKt.track(companion, firstSeen, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    ((Result) obj).j();
                }
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02531) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        C29051(Continuation<? super C29051> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LocalStorage.this.new C29051(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            if (LocalStorage.this._didTrackFirstSeen) {
                return Unit.f139807a;
            }
            BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), null, null, new C02531(null), 3, null);
            LocalStorage.this.write(DidTrackFirstSeen.INSTANCE, Boxing.a(true));
            LocalStorage.this._didTrackFirstSeen = true;
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29051) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.storage.LocalStorage$recordFirstSessionTracked$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.storage.LocalStorage$recordFirstSessionTracked$1", f = "LocalStorage.kt", l = {}, m = "invokeSuspend")
    static final class C29061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C29061(Continuation<? super C29061> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LocalStorage.this.new C29061(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            if (LocalStorage.this._didTrackFirstSession) {
                return Unit.f139807a;
            }
            LocalStorage.this.write(DidTrackFirstSession.INSTANCE, Boxing.a(true));
            LocalStorage.this._didTrackFirstSession = true;
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29061) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.storage.LocalStorage$reset$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.storage.LocalStorage$reset$1", f = "LocalStorage.kt", l = {}, m = "invokeSuspend")
    static final class C29071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C29071(Continuation<? super C29071> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LocalStorage.this.new C29071(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            LocalStorage.this._confirmedAssignments = null;
            LocalStorage.this._didTrackFirstSeen = false;
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29071) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public LocalStorage(Context context, Json json, String _apiKey, Factory factory, IOScope ioScope, Cache cache, CoreDataManager coreDataManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(_apiKey, "_apiKey");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(coreDataManager, "coreDataManager");
        this.json = json;
        this._apiKey = _apiKey;
        this.factory = factory;
        this.ioScope = ioScope;
        this.cache = cache;
        this.coreDataManager = coreDataManager;
        this.apiKey = _apiKey;
        this.debugKey = "";
        this.coroutineContext = CoroutineDispatcher.q0(Dispatchers.b(), 1, null, 2, null);
        Object obj = cache.read(DidTrackFirstSeen.INSTANCE);
        Boolean bool = Boolean.TRUE;
        boolean zAreEqual = Intrinsics.areEqual(obj, bool);
        this._didTrackFirstSeen = zAreEqual;
        if (zAreEqual) {
            this._didTrackFirstSession = true;
        } else {
            this._didTrackFirstSession = Intrinsics.areEqual(cache.read(DidTrackFirstSession.INSTANCE), bool);
        }
    }

    private final Map<String, Experiment.Variant> getP_confirmedAssignments() {
        return (Map) BuildersKt.e(getCoroutineContext(), new LocalStorage$p_confirmedAssignments$1(this, null));
    }

    private final void setP_confirmedAssignments(Map<String, Experiment.Variant> map) {
        BuildersKt__Builders_commonKt.d(this, null, null, new LocalStorage$p_confirmedAssignments$2(this, map, null), 3, null);
    }

    private final void updateSdkVersion() {
        String sdkVersion = ConstantsKt.getSdkVersion();
        SdkVersion sdkVersion2 = SdkVersion.INSTANCE;
        String str = (String) read(sdkVersion2);
        if (!Intrinsics.areEqual(sdkVersion, str)) {
            write(sdkVersion2, sdkVersion);
        }
        if (str == null) {
            this.neverCalledStaticConfig = true;
        }
    }

    @Override // com.superwall.sdk.storage.Storage
    public void clean() {
        reset();
    }

    public void clearCachedSessionEvents() {
        this.cache.delete(Transactions.INSTANCE);
    }

    public final void configure(String apiKey) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        updateSdkVersion();
        this.apiKey = apiKey;
    }

    @Override // com.superwall.sdk.storage.Storage
    public <T> void delete(Storable<T> storable) {
        Intrinsics.checkNotNullParameter(storable, "storable");
        this.cache.delete(storable);
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public Map<String, Experiment.Variant> getConfirmedAssignments() {
        Map<String, Experiment.Variant> p_confirmedAssignments = getP_confirmedAssignments();
        if (p_confirmedAssignments != null) {
            return p_confirmedAssignments;
        }
        Map<String, Experiment.Variant> mapEmptyMap = (Map) read(ConfirmedAssignments.INSTANCE);
        if (mapEmptyMap == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        setP_confirmedAssignments(mapEmptyMap);
        return mapEmptyMap;
    }

    public final CoreDataManager getCoreDataManager() {
        return this.coreDataManager;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final String getDebugKey() {
        return this.debugKey;
    }

    public final boolean getDidTrackFirstSeen() {
        return ((Boolean) BuildersKt.e(getCoroutineContext(), new LocalStorage$didTrackFirstSeen$1(this, null))).booleanValue();
    }

    public final boolean getDidTrackFirstSession() {
        return ((Boolean) BuildersKt.e(getCoroutineContext(), new LocalStorage$didTrackFirstSession$1(this, null))).booleanValue();
    }

    public final boolean getNeverCalledStaticConfig() {
        return this.neverCalledStaticConfig;
    }

    public final void recordAppInstall(Function2<? super Trackable, ? super Continuation<? super Result<TrackingResult>>, ? extends Object> trackEvent) {
        Intrinsics.checkNotNullParameter(trackEvent, "trackEvent");
        DidTrackAppInstall didTrackAppInstall = DidTrackAppInstall.INSTANCE;
        Boolean bool = (Boolean) read(didTrackAppInstall);
        if (bool != null ? bool.booleanValue() : false) {
            return;
        }
        BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new AnonymousClass1(this.factory.makeDeviceInfo(), this.factory.makeHasExternalPurchaseController(), trackEvent, null), 3, null);
        write(didTrackAppInstall, Boolean.TRUE);
    }

    public final void recordFirstSeenTracked() {
        BuildersKt__Builders_commonKt.d(this, null, null, new C29051(null), 3, null);
    }

    public final void recordFirstSessionTracked() {
        BuildersKt__Builders_commonKt.d(this, null, null, new C29061(null), 3, null);
    }

    public final void reset() {
        this.coreDataManager.deleteAllEntities();
        this.cache.clean();
        BuildersKt__Builders_commonKt.d(this, null, null, new C29071(null), 3, null);
        recordFirstSeenTracked();
    }

    public void saveConfirmedAssignments(Map<String, Experiment.Variant> assignments) {
        Intrinsics.checkNotNullParameter(assignments, "assignments");
        write(ConfirmedAssignments.INSTANCE, assignments);
        setP_confirmedAssignments(assignments);
    }

    public final void setApiKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.apiKey = str;
    }

    public final void setDebugKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.debugKey = str;
    }

    public final void setDidTrackFirstSeen(boolean z2) {
        BuildersKt__Builders_commonKt.d(this, null, null, new LocalStorage$didTrackFirstSeen$2(this, z2, null), 3, null);
    }

    public final void setDidTrackFirstSession(boolean z2) {
        BuildersKt__Builders_commonKt.d(this, null, null, new LocalStorage$didTrackFirstSession$2(this, z2, null), 3, null);
    }

    public final void setNeverCalledStaticConfig(boolean z2) {
        this.neverCalledStaticConfig = z2;
    }

    public final void trackPaywallOpen() {
        TotalPaywallViews totalPaywallViews = TotalPaywallViews.INSTANCE;
        Integer num = (Integer) read(totalPaywallViews);
        write(totalPaywallViews, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
        write(LastPaywallView.INSTANCE, new Date());
    }

    @Override // com.superwall.sdk.storage.Storage
    public <T> void write(Storable<T> storable, T data) {
        Intrinsics.checkNotNullParameter(storable, "storable");
        Intrinsics.checkNotNullParameter(data, "data");
        this.cache.write(storable, data);
    }

    @Override // com.superwall.sdk.storage.Storage
    public <T> T read(Storable<T> storable) {
        Intrinsics.checkNotNullParameter(storable, KqqtdetwHMIO.hkU);
        return (T) this.cache.read(storable);
    }

    public /* synthetic */ LocalStorage(Context context, Json json, String str, Factory factory, IOScope iOScope, Cache cache, CoreDataManager coreDataManager, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        Json json2;
        Context context2;
        if ((i3 & 32) != 0) {
            json2 = json;
            context2 = context;
            cache = new Cache(context, null, json2, 2, null);
        } else {
            json2 = json;
            context2 = context;
        }
        this(context2, json2, str, factory, iOScope, cache, (i3 & 64) != 0 ? new CoreDataManager(context2) : coreDataManager);
    }
}
