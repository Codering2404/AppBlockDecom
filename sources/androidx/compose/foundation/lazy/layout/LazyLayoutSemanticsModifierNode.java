package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
final class LazyLayoutSemanticsModifierNode extends Modifier.Node implements SemanticsModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Function0 f8216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LazyLayoutSemanticState f8217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Orientation f8218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8219d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f8220f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ScrollAxisRange f8221g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Function1 f8222h = new Function1<Object, Integer>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$indexForKeyMapping$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(Object obj) {
            LazyLayoutItemProvider lazyLayoutItemProvider = (LazyLayoutItemProvider) this.f8225a.f8216a.invoke();
            int iA = lazyLayoutItemProvider.a();
            int i3 = 0;
            while (true) {
                if (i3 >= iA) {
                    i3 = -1;
                    break;
                }
                if (Intrinsics.areEqual(lazyLayoutItemProvider.d(i3), obj)) {
                    break;
                }
                i3++;
            }
            return Integer.valueOf(i3);
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Function1 f8223i;

    public LazyLayoutSemanticsModifierNode(Function0 function0, LazyLayoutSemanticState lazyLayoutSemanticState, Orientation orientation, boolean z2, boolean z3) {
        this.f8216a = function0;
        this.f8217b = lazyLayoutSemanticState;
        this.f8218c = orientation;
        this.f8219d = z2;
        this.f8220f = z3;
        r2();
    }

    private final CollectionInfo o2() {
        return this.f8217b.d();
    }

    private final boolean p2() {
        return this.f8218c == Orientation.f6031a;
    }

    private final void r2() {
        this.f8221g = new ScrollAxisRange(new Function0<Float>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(this.f8226a.f8217b.f());
            }
        }, new Function0<Float>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(this.f8227a.f8217b.b());
            }
        }, this.f8220f);
        this.f8223i = this.f8219d ? new Function1<Integer, Boolean>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$3

            /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$3$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$3$2", f = "LazyLayoutSemantics.kt", l = {213}, m = "invokeSuspend")
            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f8229a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ LazyLayoutSemanticsModifierNode f8230b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ int f8231c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(LazyLayoutSemanticsModifierNode lazyLayoutSemanticsModifierNode, int i3, Continuation continuation) {
                    super(2, continuation);
                    this.f8230b = lazyLayoutSemanticsModifierNode;
                    this.f8231c = i3;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new AnonymousClass2(this.f8230b, this.f8231c, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f8229a;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        LazyLayoutSemanticState lazyLayoutSemanticState = this.f8230b.f8217b;
                        int i4 = this.f8231c;
                        this.f8229a = 1;
                        if (lazyLayoutSemanticState.c(i4, this) == objF) {
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
                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            {
                super(1);
            }

            public final Boolean c(int i3) {
                LazyLayoutItemProvider lazyLayoutItemProvider = (LazyLayoutItemProvider) this.f8228a.f8216a.invoke();
                if (!(i3 >= 0 && i3 < lazyLayoutItemProvider.a())) {
                    InlineClassHelperKt.a("Can't scroll to index " + i3 + ", it is out of bounds [0, " + lazyLayoutItemProvider.a() + ')');
                }
                BuildersKt__Builders_commonKt.d(this.f8228a.getCoroutineScope(), null, null, new AnonymousClass2(this.f8228a, i3, null), 3, null);
                return Boolean.TRUE;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((Number) obj).intValue());
            }
        } : null;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void N(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.G0(semanticsPropertyReceiver, true);
        SemanticsPropertiesKt.v(semanticsPropertyReceiver, this.f8222h);
        if (p2()) {
            ScrollAxisRange scrollAxisRange = this.f8221g;
            if (scrollAxisRange == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollAxisRange");
                scrollAxisRange = null;
            }
            SemanticsPropertiesKt.I0(semanticsPropertyReceiver, scrollAxisRange);
        } else {
            ScrollAxisRange scrollAxisRange2 = this.f8221g;
            if (scrollAxisRange2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollAxisRange");
                scrollAxisRange2 = null;
            }
            SemanticsPropertiesKt.j0(semanticsPropertyReceiver, scrollAxisRange2);
        }
        Function1 function1 = this.f8223i;
        if (function1 != null) {
            SemanticsPropertiesKt.Y(semanticsPropertyReceiver, null, function1, 1, null);
        }
        SemanticsPropertiesKt.s(semanticsPropertyReceiver, null, new Function0<Float>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$applySemantics$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(this.f8224a.f8217b.e() - this.f8224a.f8217b.a());
            }
        }, 1, null);
        SemanticsPropertiesKt.a0(semanticsPropertyReceiver, o2());
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final void q2(Function0 function0, LazyLayoutSemanticState lazyLayoutSemanticState, Orientation orientation, boolean z2, boolean z3) {
        this.f8216a = function0;
        this.f8217b = lazyLayoutSemanticState;
        if (this.f8218c != orientation) {
            this.f8218c = orientation;
            SemanticsModifierNodeKt.b(this);
        }
        if (this.f8219d == z2 && this.f8220f == z3) {
            return;
        }
        this.f8219d = z2;
        this.f8220f = z3;
        r2();
        SemanticsModifierNodeKt.b(this);
    }
}
