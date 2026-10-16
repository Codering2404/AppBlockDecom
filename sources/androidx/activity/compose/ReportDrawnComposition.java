package androidx.activity.compose;

import androidx.activity.FullyDrawnReporter;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class ReportDrawnComposition implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FullyDrawnReporter f489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SnapshotStateObserver f491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function1 f492d;

    public ReportDrawnComposition(FullyDrawnReporter fullyDrawnReporter, Function0 function0) {
        this.f489a = fullyDrawnReporter;
        this.f490b = function0;
        SnapshotStateObserver snapshotStateObserver = new SnapshotStateObserver(new Function1<Function0<? extends Unit>, Unit>() { // from class: androidx.activity.compose.ReportDrawnComposition$snapshotStateObserver$1
            public final void c(Function0 function02) {
                function02.invoke();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((Function0) obj);
                return Unit.f139807a;
            }
        });
        snapshotStateObserver.t();
        this.f491c = snapshotStateObserver;
        this.f492d = new ReportDrawnComposition$checkReporter$1(this);
        fullyDrawnReporter.b(this);
        if (fullyDrawnReporter.e()) {
            return;
        }
        fullyDrawnReporter.c();
        e(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(final Function0 function0) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        this.f491c.p(function0, this.f492d, new Function0<Unit>() { // from class: androidx.activity.compose.ReportDrawnComposition$observeReporter$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m8invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m8invoke() {
                booleanRef.f140137a = ((Boolean) function0.invoke()).booleanValue();
            }
        });
        if (booleanRef.f140137a) {
            h();
        }
    }

    public void d() {
        this.f491c.k();
        this.f491c.u();
    }

    public final void h() {
        this.f491c.l(this.f490b);
        if (!this.f489a.e()) {
            this.f489a.g();
        }
        d();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        d();
        return Unit.f139807a;
    }
}
