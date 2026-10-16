package androidx.glance.session;

import androidx.compose.runtime.BroadcastFrameClock;
import androidx.compose.runtime.MonotonicFrameClock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

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
public final class InteractiveFrameClock implements MonotonicFrameClock {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Companion f39552l = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f39553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f39554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f39555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f39556d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Function0 f39557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final BroadcastFrameClock f39558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f39559h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f39560i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f39561j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CancellableContinuation f39562k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public InteractiveFrameClock(CoroutineScope coroutineScope, int i3, int i4, long j3, Function0 function0) {
        this.f39553a = coroutineScope;
        this.f39554b = i3;
        this.f39555c = i4;
        this.f39556d = j3;
        this.f39557f = function0;
        this.f39558g = new BroadcastFrameClock(new Function0<Unit>() { // from class: androidx.glance.session.InteractiveFrameClock$frameClock$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m348invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m348invoke() {
                this.f39564a.p();
            }
        });
        this.f39559h = new Object();
        this.f39560i = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        long jLongValue = ((Number) this.f39557f.invoke()).longValue();
        Ref.LongRef longRef = new Ref.LongRef();
        Ref.LongRef longRef2 = new Ref.LongRef();
        synchronized (this.f39559h) {
            longRef.f140143a = jLongValue - this.f39561j;
            longRef2.f140143a = 1000000000 / ((long) this.f39560i);
            Unit unit = Unit.f139807a;
        }
        BuildersKt__Builders_commonKt.d(this.f39553a, null, null, new InteractiveFrameClock$onNewAwaiters$2(longRef, longRef2, this, jLongValue, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(long j3) {
        this.f39558g.p(j3);
        synchronized (this.f39559h) {
            this.f39561j = j3;
            Unit unit = Unit.f139807a;
        }
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public Object fold(Object obj, Function2 function2) {
        return MonotonicFrameClock.DefaultImpls.a(this, obj, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext.Element get(CoroutineContext.Key key) {
        return MonotonicFrameClock.DefaultImpls.b(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key key) {
        return MonotonicFrameClock.DefaultImpls.c(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return MonotonicFrameClock.DefaultImpls.d(this, coroutineContext);
    }

    public final Object r(Continuation continuation) {
        return TimeoutKt.e(this.f39556d, new InteractiveFrameClock$startInteractive$2(this, null), continuation);
    }

    public final void s() {
        synchronized (this.f39559h) {
            CancellableContinuation cancellableContinuation = this.f39562k;
            if (cancellableContinuation != null) {
                CancellableContinuation.DefaultImpls.a(cancellableContinuation, null, 1, null);
            }
        }
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    public Object z(Function1 function1, Continuation continuation) {
        return this.f39558g.z(function1, continuation);
    }

    public /* synthetic */ InteractiveFrameClock(CoroutineScope coroutineScope, int i3, int i4, long j3, Function0 function0, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, (i5 & 2) != 0 ? 5 : i3, (i5 & 4) != 0 ? 20 : i4, (i5 & 8) != 0 ? 5000L : j3, (i5 & 16) != 0 ? new Function0<Long>() { // from class: androidx.glance.session.InteractiveFrameClock.1
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                return Long.valueOf(System.nanoTime());
            }
        } : function0);
    }
}
