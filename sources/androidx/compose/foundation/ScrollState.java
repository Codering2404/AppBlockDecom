package androidx.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ScrollState implements ScrollableState {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f5135i = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Saver f5136j = SaverKt.a(new Function2<SaverScope, ScrollState, Integer>() { // from class: androidx.compose.foundation.ScrollState$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(SaverScope saverScope, ScrollState scrollState) {
            return Integer.valueOf(scrollState.n());
        }
    }, new Function1<Integer, ScrollState>() { // from class: androidx.compose.foundation.ScrollState$Companion$Saver$2
        public final ScrollState c(int i3) {
            return new ScrollState(i3);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return c(((Number) obj).intValue());
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableIntState f5137a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f5141e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableIntState f5138b = SnapshotIntStateKt.a(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableInteractionSource f5139c = InteractionSourceKt.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MutableIntState f5140d = SnapshotIntStateKt.a(Api.BaseClientBuilder.API_PRIORITY_OTHER);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ScrollableState f5142f = ScrollableStateKt.a(new Function1<Float, Float>() { // from class: androidx.compose.foundation.ScrollState$scrollableState$1
        {
            super(1);
        }

        public final Float c(float f3) {
            float fN = this.f5149a.n() + f3 + this.f5149a.f5141e;
            float fO = RangesKt.o(fN, 0.0f, this.f5149a.m());
            boolean z2 = fN == fO;
            float fN2 = fO - this.f5149a.n();
            int iRound = Math.round(fN2);
            ScrollState scrollState = this.f5149a;
            scrollState.p(scrollState.n() + iRound);
            this.f5149a.f5141e = fN2 - iRound;
            if (!z2) {
                f3 = fN2;
            }
            return Float.valueOf(f3);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return c(((Number) obj).floatValue());
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final State f5143g = SnapshotStateKt.e(new Function0<Boolean>() { // from class: androidx.compose.foundation.ScrollState$canScrollForward$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(this.f5148a.n() < this.f5148a.m());
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final State f5144h = SnapshotStateKt.e(new Function0<Boolean>() { // from class: androidx.compose.foundation.ScrollState$canScrollBackward$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(this.f5147a.n() > 0);
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver a() {
            return ScrollState.f5136j;
        }

        private Companion() {
        }
    }

    public ScrollState(int i3) {
        this.f5137a = SnapshotIntStateKt.a(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(int i3) {
        this.f5137a.a(i3);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float b(float f3) {
        return this.f5142f.b(f3);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean c() {
        return this.f5142f.c();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean d() {
        return ((Boolean) this.f5144h.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public Object e(MutatePriority mutatePriority, Function2 function2, Continuation continuation) {
        Object objE = this.f5142f.e(mutatePriority, function2, continuation);
        return objE == IntrinsicsKt.f() ? objE : Unit.f139807a;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean f() {
        return ((Boolean) this.f5143g.getValue()).booleanValue();
    }

    public final Object k(int i3, AnimationSpec animationSpec, Continuation continuation) throws Throwable {
        Object objA = ScrollExtensionsKt.a(this, i3 - n(), animationSpec, continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    public final MutableInteractionSource l() {
        return this.f5139c;
    }

    public final int m() {
        return this.f5140d.g();
    }

    public final int n() {
        return this.f5137a.g();
    }

    public final void o(int i3) {
        this.f5140d.a(i3);
        Snapshot.Companion companion = Snapshot.f24914e;
        Snapshot snapshotD = companion.d();
        Function1 function1G = snapshotD != null ? snapshotD.g() : null;
        Snapshot snapshotE = companion.e(snapshotD);
        try {
            if (n() > i3) {
                p(i3);
            }
            Unit unit = Unit.f139807a;
            companion.m(snapshotD, snapshotE, function1G);
        } catch (Throwable th) {
            companion.m(snapshotD, snapshotE, function1G);
            throw th;
        }
    }

    public final void q(int i3) {
        this.f5138b.a(i3);
    }
}
