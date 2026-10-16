package cz.mobilesoft.coreblock.scene.strictmode3;

import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithIntervals;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.MutableStateFlow;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$updateIntervalTrigger$1", f = "StrictMode3ViewModel.kt", l = {392}, m = "invokeSuspend", v = 1)
final class StrictMode3ViewModel$updateIntervalTrigger$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f121430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f121431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f121432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f121433d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f121434f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f121435g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    long f121436h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    long f121437i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f121438j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ List f121439k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ StrictMode3ViewModel f121440l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictMode3ViewModel$updateIntervalTrigger$1(List list, StrictMode3ViewModel strictMode3ViewModel, Continuation continuation) {
        super(2, continuation);
        this.f121439k = list;
        this.f121440l = strictMode3ViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StrictMode3ViewModel$updateIntervalTrigger$1(this.f121439k, this.f121440l, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Long l3;
        int i3;
        Object objF = IntrinsicsKt.f();
        int i4 = this.f121438j;
        if (i4 == 0) {
            ResultKt.b(obj);
            Calendar calendarA = TimeHelperExt.A();
            long timeInMillis = calendarA.getTimeInMillis();
            int i5 = 0;
            calendarA.set(11, 0);
            calendarA.set(12, 0);
            calendarA.set(13, 0);
            calendarA.set(14, 0);
            long timeInMillis2 = calendarA.getTimeInMillis();
            long minutes = TimeUnit.MILLISECONDS.toMinutes(timeInMillis - timeInMillis2);
            List list = this.f121439k;
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CollectionsKt.addAll(arrayList, ((ProfileWithIntervals) it.next()).a());
            }
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            while (i5 < size) {
                Object obj2 = arrayList.get(i5);
                i5++;
                Interval interval = (Interval) obj2;
                Long lE = Boxing.e(interval.b());
                Long l4 = lE.longValue() > minutes ? lE : null;
                Long lE2 = Boxing.e(interval.a());
                if (lE2.longValue() <= minutes) {
                    lE2 = null;
                }
                CollectionsKt.addAll(arrayList2, CollectionsKt.listOfNotNull((Object[]) new Long[]{l4, lE2}));
            }
            Long l5 = (Long) CollectionsKt.minOrNull((Iterable) arrayList2);
            long millis = l5 != null ? TimeUnit.MINUTES.toMillis(l5.longValue()) + timeInMillis2 : Long.MAX_VALUE;
            Iterator it2 = this.f121439k.iterator();
            if (it2.hasNext()) {
                Long lE3 = Boxing.e(((ProfileWithIntervals) it2.next()).b().w());
                if (lE3.longValue() <= timeInMillis) {
                    lE3 = null;
                }
                Long lE4 = Boxing.e(lE3 != null ? lE3.longValue() : Long.MAX_VALUE);
                while (it2.hasNext()) {
                    Long lE5 = Boxing.e(((ProfileWithIntervals) it2.next()).b().w());
                    if (lE5.longValue() <= timeInMillis) {
                        lE5 = null;
                    }
                    Long lE6 = Boxing.e(lE5 != null ? lE5.longValue() : Long.MAX_VALUE);
                    if (lE4.compareTo(lE6) > 0) {
                        lE4 = lE6;
                    }
                }
                l3 = lE4;
            } else {
                l3 = null;
            }
            long jLongValue = l3 != null ? l3.longValue() : Long.MAX_VALUE;
            long jMin = Math.min(millis, jLongValue);
            long j3 = jMin - timeInMillis;
            if (j3 <= 0 || jMin == Long.MAX_VALUE) {
                return Unit.f139807a;
            }
            this.f121430a = SpillingKt.a(calendarA);
            this.f121431b = timeInMillis;
            this.f121432c = timeInMillis2;
            this.f121433d = minutes;
            this.f121434f = millis;
            this.f121435g = jLongValue;
            this.f121436h = jMin;
            this.f121437i = j3;
            i3 = 1;
            this.f121438j = 1;
            if (DelayKt.b(j3, this) == objF) {
                return objF;
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            i3 = 1;
        }
        MutableStateFlow mutableStateFlow = this.f121440l.J;
        mutableStateFlow.setValue(Boxing.d(((Number) mutableStateFlow.getValue()).intValue() + i3));
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StrictMode3ViewModel$updateIntervalTrigger$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
