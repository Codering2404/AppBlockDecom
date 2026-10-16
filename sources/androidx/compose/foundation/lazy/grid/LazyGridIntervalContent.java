package androidx.compose.foundation.lazy.grid;

import androidx.collection.IntList;
import androidx.collection.IntListKt;
import androidx.collection.MutableIntList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class LazyGridIntervalContent extends LazyLayoutIntervalContent<LazyGridInterval> implements LazyGridScope {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Companion f7741e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f7742f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Function2 f7743g = new Function2<LazyGridItemSpanScope, Integer, GridItemSpan>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridIntervalContent$Companion$DefaultSpan$1
        public final long c(LazyGridItemSpanScope lazyGridItemSpanScope, int i3) {
            return LazyGridSpanKt.a(1);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return GridItemSpan.a(c((LazyGridItemSpanScope) obj, ((Number) obj2).intValue()));
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LazyGridSpanLayoutProvider f7744a = new LazyGridSpanLayoutProvider(this);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableIntervalList f7745b = new MutableIntervalList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MutableIntList f7747d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public LazyGridIntervalContent(Function1 function1) {
        function1.invoke(this);
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridScope
    public void e(Object obj, Object obj2, final Function4 function4) {
        MutableIntList mutableIntList = this.f7747d;
        if (mutableIntList == null) {
            mutableIntList = new MutableIntList(0, 1, null);
            this.f7747d = mutableIntList;
        }
        final int size = j().getSize();
        mutableIntList.l(size);
        q(obj, new Function1<LazyGridItemSpanScope, GridItemSpan>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridIntervalContent$stickyHeader$1
            public final long c(LazyGridItemSpanScope lazyGridItemSpanScope) {
                return LazyGridSpanKt.a(lazyGridItemSpanScope.a());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                return GridItemSpan.a(c((LazyGridItemSpanScope) obj3));
            }
        }, obj2, ComposableLambdaKt.c(2045010142, true, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridIntervalContent$stickyHeader$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public final void c(LazyGridItemScope lazyGridItemScope, Composer composer, int i3) {
                if ((i3 & 6) == 0) {
                    i3 |= composer.Z(lazyGridItemScope) ? 4 : 2;
                }
                if (!composer.r((i3 & 19) != 18, i3 & 1)) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(2045010142, i3, -1, "androidx.compose.foundation.lazy.grid.LazyGridIntervalContent.stickyHeader.<anonymous> (LazyGridIntervalContent.kt:88)");
                }
                function4.invoke(lazyGridItemScope, Integer.valueOf(size), composer, Integer.valueOf(i3 & 14));
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4, Object obj5) {
                c((LazyGridItemScope) obj3, (Composer) obj4, ((Number) obj5).intValue());
                return Unit.f139807a;
            }
        }));
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridScope
    public void g(int i3, Function1 function1, Function2 function2, Function1 function12, Function4 function4) {
        j().b(i3, new LazyGridInterval(function1, function2 == null ? f7743g : function2, function12, function4));
        if (function2 != null) {
            this.f7746c = true;
        }
    }

    public final boolean m() {
        return this.f7746c;
    }

    public final IntList n() {
        MutableIntList mutableIntList = this.f7747d;
        return mutableIntList != null ? mutableIntList : IntListKt.a();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public MutableIntervalList j() {
        return this.f7745b;
    }

    public final LazyGridSpanLayoutProvider p() {
        return this.f7744a;
    }

    public void q(final Object obj, final Function1 function1, final Object obj2, final Function3 function3) {
        j().b(1, new LazyGridInterval(obj != null ? new Function1<Integer, Object>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridIntervalContent$item$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Object invoke(int i3) {
                return obj;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                return invoke(((Number) obj3).intValue());
            }
        } : null, function1 != null ? new Function2<LazyGridItemSpanScope, Integer, GridItemSpan>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridIntervalContent$item$2$1
            {
                super(2);
            }

            public final long c(LazyGridItemSpanScope lazyGridItemSpanScope, int i3) {
                return ((GridItemSpan) function1.invoke(lazyGridItemSpanScope)).g();
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4) {
                return GridItemSpan.a(c((LazyGridItemSpanScope) obj3, ((Number) obj4).intValue()));
            }
        } : f7743g, new Function1<Integer, Object>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridIntervalContent$item$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                return invoke(((Number) obj3).intValue());
            }

            public final Object invoke(int i3) {
                return obj2;
            }
        }, ComposableLambdaKt.c(-34608120, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridIntervalContent$item$4
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4, Object obj5, Object obj6) {
                invoke((LazyGridItemScope) obj3, ((Number) obj4).intValue(), (Composer) obj5, ((Number) obj6).intValue());
                return Unit.f139807a;
            }

            public final void invoke(LazyGridItemScope lazyGridItemScope, int i3, Composer composer, int i4) {
                if ((i4 & 6) == 0) {
                    i4 |= composer.Z(lazyGridItemScope) ? 4 : 2;
                }
                if (!composer.r((i4 & 131) != 130, i4 & 1)) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(-34608120, i4, -1, "androidx.compose.foundation.lazy.grid.LazyGridIntervalContent.item.<anonymous> (LazyGridIntervalContent.kt:55)");
                }
                function3.invoke(lazyGridItemScope, composer, Integer.valueOf(i4 & 14));
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        })));
        if (function1 != null) {
            this.f7746c = true;
        }
    }
}
