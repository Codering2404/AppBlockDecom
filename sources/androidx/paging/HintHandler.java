package androidx.paging;

import androidx.paging.HintHandler;
import androidx.paging.ViewportHint;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

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
public final class HintHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final State f49807a = new State();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class HintFlow {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ViewportHint f49808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final MutableSharedFlow f49809b = SharedFlowKt.b(1, 0, BufferOverflow.f141063b, 2, null);

        public HintFlow() {
        }

        public final Flow a() {
            return this.f49809b;
        }

        public final ViewportHint b() {
            return this.f49808a;
        }

        public final void c(ViewportHint viewportHint) {
            this.f49808a = viewportHint;
            if (viewportHint != null) {
                this.f49809b.c(viewportHint);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class State {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HintFlow f49811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final HintFlow f49812b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ViewportHint.Access f49813c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ReentrantLock f49814d = new ReentrantLock();

        public State() {
            this.f49811a = HintHandler.this.new HintFlow();
            this.f49812b = HintHandler.this.new HintFlow();
        }

        public final Flow a() {
            return this.f49812b.a();
        }

        public final ViewportHint.Access b() {
            return this.f49813c;
        }

        public final Flow c() {
            return this.f49811a.a();
        }

        public final void d(ViewportHint.Access access, Function2 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            ReentrantLock reentrantLock = this.f49814d;
            try {
                reentrantLock.lock();
                if (access != null) {
                    this.f49813c = access;
                }
                block.invoke(this.f49811a, this.f49812b);
                Unit unit = Unit.f139807a;
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f49816a;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.PREPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadType.APPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f49816a = iArr;
        }
    }

    public final void a(final LoadType loadType, final ViewportHint viewportHint) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(viewportHint, "viewportHint");
        if (loadType == LoadType.PREPEND || loadType == LoadType.APPEND) {
            this.f49807a.d(null, new Function2<HintFlow, HintFlow, Unit>() { // from class: androidx.paging.HintHandler$forceSetHint$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public final void c(HintHandler.HintFlow prependHint, HintHandler.HintFlow appendHint) {
                    Intrinsics.checkNotNullParameter(prependHint, "prependHint");
                    Intrinsics.checkNotNullParameter(appendHint, "appendHint");
                    if (loadType == LoadType.PREPEND) {
                        prependHint.c(viewportHint);
                    } else {
                        appendHint.c(viewportHint);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((HintHandler.HintFlow) obj, (HintHandler.HintFlow) obj2);
                    return Unit.f139807a;
                }
            });
            return;
        }
        throw new IllegalArgumentException(("invalid load type for reset: " + loadType).toString());
    }

    public final ViewportHint.Access b() {
        return this.f49807a.b();
    }

    public final Flow c(LoadType loadType) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        int i3 = WhenMappings.f49816a[loadType.ordinal()];
        if (i3 == 1) {
            return this.f49807a.c();
        }
        if (i3 == 2) {
            return this.f49807a.a();
        }
        throw new IllegalArgumentException("invalid load type for hints");
    }

    public final void d(final ViewportHint viewportHint) {
        Intrinsics.checkNotNullParameter(viewportHint, "viewportHint");
        this.f49807a.d(viewportHint instanceof ViewportHint.Access ? (ViewportHint.Access) viewportHint : null, new Function2<HintFlow, HintFlow, Unit>() { // from class: androidx.paging.HintHandler$processHint$1
            {
                super(2);
            }

            public final void c(HintHandler.HintFlow prependHint, HintHandler.HintFlow appendHint) {
                Intrinsics.checkNotNullParameter(prependHint, "prependHint");
                Intrinsics.checkNotNullParameter(appendHint, "appendHint");
                if (HintHandlerKt.a(viewportHint, prependHint.b(), LoadType.PREPEND)) {
                    prependHint.c(viewportHint);
                }
                if (HintHandlerKt.a(viewportHint, appendHint.b(), LoadType.APPEND)) {
                    appendHint.c(viewportHint);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((HintHandler.HintFlow) obj, (HintHandler.HintFlow) obj2);
                return Unit.f139807a;
            }
        });
    }
}
