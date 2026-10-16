package com.superwall.sdk.analytics;

import com.superwall.sdk.Superwall;
import com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.misc.IOScope;
import com.superwall.sdk.models.attribution.AttributionProvider;
import com.superwall.sdk.models.internal.VendorId;
import com.superwall.sdk.storage.IntegrationAttributes;
import com.superwall.sdk.storage.Storage;
import com.superwall.sdk.utilities.ErrorTrackingKt;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

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
public final class AttributionManager {
    private Map<AttributionProvider, String> _integrationAttributes;
    private final IOScope ioScope;
    private Job lastIntegrationJob;
    private final Function0<Unit> redeemAfterSetting;
    private final Storage storage;
    private final Function2<TrackableSuperwallEvent, Continuation<? super Unit>, Object> track;
    private final Function0<VendorId> vendorId;

    /* JADX INFO: renamed from: com.superwall.sdk.analytics.AttributionManager$setIntegrationAttributes$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.analytics.AttributionManager$setIntegrationAttributes$2", f = "AttributionManager.kt", l = {55}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<AttributionProvider, String> $attributes;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Map<AttributionProvider, String> map, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$attributes = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AttributionManager.this.new AnonymousClass2(this.$attributes, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Duration.Companion companion = Duration.f140631b;
                long jS = DurationKt.s(500, DurationUnit.f140640d);
                this.label = 1;
                if (DelayKt.c(jS, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            AttributionManager attributionManager = AttributionManager.this;
            try {
                attributionManager._integrationAttributes = this.$attributes;
                Map<String, String> fullAttributionIds$superwall_release = attributionManager.getFullAttributionIds$superwall_release();
                attributionManager.getStorage().write(IntegrationAttributes.INSTANCE, attributionManager._integrationAttributes);
                new Either.Success(BuildersKt__Builders_commonKt.d(attributionManager.getIoScope(), null, null, new AttributionManager$setIntegrationAttributes$2$1$1(attributionManager, fullAttributionIds$superwall_release, null), 3, null));
            } catch (Throwable th) {
                if (ErrorTrackingKt.shouldLog(th)) {
                    Superwall.Companion companion2 = Superwall.Companion;
                    if (companion2.getInitialized()) {
                        ErrorTrackingKt.trackError(companion2.getInstance(), th);
                    }
                }
                new Either.Failure(th);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AttributionManager(Storage storage, Function2<? super TrackableSuperwallEvent, ? super Continuation<? super Unit>, ? extends Object> track, IOScope ioScope, Function0<Unit> redeemAfterSetting, Function0<VendorId> vendorId) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(track, "track");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        Intrinsics.checkNotNullParameter(redeemAfterSetting, "redeemAfterSetting");
        Intrinsics.checkNotNullParameter(vendorId, "vendorId");
        this.storage = storage;
        this.track = track;
        this.ioScope = ioScope;
        this.redeemAfterSetting = redeemAfterSetting;
        this.vendorId = vendorId;
        this._integrationAttributes = MapsKt.emptyMap();
        Map<AttributionProvider, String> map = (Map) storage.read(IntegrationAttributes.INSTANCE);
        this._integrationAttributes = map == null ? MapsKt.emptyMap() : map;
    }

    public final Map<String, String> getFullAttributionIds$superwall_release() {
        Map<AttributionProvider, String> map = this._integrationAttributes;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<AttributionProvider, String> entry : map.entrySet()) {
            arrayList.add(TuplesKt.a(entry.getKey().getRawName(), entry.getValue()));
        }
        return MapsKt.toMap(arrayList);
    }

    public final Map<String, String> getIntegrationAttributes() {
        return getFullAttributionIds$superwall_release();
    }

    public final IOScope getIoScope() {
        return this.ioScope;
    }

    public final Job getLastIntegrationJob() {
        return this.lastIntegrationJob;
    }

    public final Function0<Unit> getRedeemAfterSetting() {
        return this.redeemAfterSetting;
    }

    public final Storage getStorage() {
        return this.storage;
    }

    public final Function2<TrackableSuperwallEvent, Continuation<? super Unit>, Object> getTrack() {
        return this.track;
    }

    public final Function0<VendorId> getVendorId() {
        return this.vendorId;
    }

    public final void setIntegrationAttributes(Map<AttributionProvider, String> attributes) {
        Unit unit;
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Job job = this.lastIntegrationJob;
        if (job != null) {
            try {
                Result.Companion companion = Result.f139772b;
                if (job != null) {
                    Job.DefaultImpls.b(job, null, 1, null);
                    unit = Unit.f139807a;
                } else {
                    unit = null;
                }
                Result.b(unit);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.f139772b;
                Result.b(ResultKt.a(th));
            }
        }
        this.lastIntegrationJob = BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new AnonymousClass2(attributes, null), 3, null);
    }

    public final void setLastIntegrationJob(Job job) {
        this.lastIntegrationJob = job;
    }

    public /* synthetic */ AttributionManager(Storage storage, Function2 function2, IOScope iOScope, Function0 function0, Function0 function02, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(storage, function2, (i3 & 4) != 0 ? new IOScope(null, 1, null) : iOScope, function0, function02);
    }
}
