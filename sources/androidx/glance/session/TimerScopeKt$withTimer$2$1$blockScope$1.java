package androidx.glance.session;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

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
public final class TimerScopeKt$withTimer$2$1$blockScope$1 implements TimerScope, CoroutineScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ CoroutineScope f39685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference f39686b = new AtomicReference(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TimeSource f39687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f39688d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function2 f39689f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ AtomicReference f39690g;

    TimerScopeKt$withTimer$2$1$blockScope$1(CoroutineScope coroutineScope, TimeSource timeSource, CoroutineScope coroutineScope2, Function2 function2, AtomicReference atomicReference) {
        this.f39687c = timeSource;
        this.f39688d = coroutineScope2;
        this.f39689f = function2;
        this.f39690g = atomicReference;
        this.f39685a = coroutineScope;
    }

    @Override // androidx.glance.session.TimerScope
    public long e0() {
        Long l3 = (Long) this.f39686b.get();
        if (l3 == null) {
            return Duration.f140631b.a();
        }
        long jLongValue = l3.longValue() - this.f39687c.a();
        Duration.Companion companion = Duration.f140631b;
        return DurationKt.t(jLongValue, DurationUnit.f140640d);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.f39685a.getCoroutineContext();
    }

    @Override // androidx.glance.session.TimerScope
    public void i(final long j3) {
        TimerScopeKt.b(this.f39686b, new Function1<Long, Long>() { // from class: androidx.glance.session.TimerScopeKt$withTimer$2$1$blockScope$1$addTime$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Long invoke(Long l3) {
                if (l3 == null) {
                    throw new IllegalStateException("Start the timer with startTimer before calling addTime");
                }
                if (Duration.E(j3)) {
                    return Long.valueOf(l3.longValue() + Duration.p(j3));
                }
                throw new IllegalArgumentException("Cannot call addTime with a negative duration");
            }
        });
    }

    @Override // androidx.glance.session.TimerScope
    public void r(long j3) {
        if (Duration.p(j3) <= 0) {
            CoroutineScopeKt.d(this.f39688d, new TimeoutCancellationException("Timed out immediately", this.f39689f.hashCode()));
            return;
        }
        if (Duration.h(e0(), j3) < 0) {
            return;
        }
        this.f39686b.set(Long.valueOf(this.f39687c.a() + Duration.p(j3)));
        AtomicReference atomicReference = this.f39690g;
        CoroutineScope coroutineScope = this.f39688d;
        Job job = (Job) atomicReference.getAndSet(BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new TimerScopeKt$withTimer$2$1$blockScope$1$startTimer$1(this, this.f39687c, coroutineScope, this.f39689f, null), 3, null));
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
    }
}
