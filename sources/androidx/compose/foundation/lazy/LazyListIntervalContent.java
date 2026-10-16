package androidx.compose.foundation.lazy;

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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

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
public final class LazyListIntervalContent extends LazyLayoutIntervalContent<LazyListInterval> implements LazyListScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableIntervalList f7434a = new MutableIntervalList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MutableIntList f7435b;

    public LazyListIntervalContent(Function1 function1) {
        function1.invoke(this);
    }

    @Override // androidx.compose.foundation.lazy.LazyListScope
    public void a(final Object obj, final Object obj2, final Function3 function3) {
        j().b(1, new LazyListInterval(obj != null ? new Function1<Integer, Object>() { // from class: androidx.compose.foundation.lazy.LazyListIntervalContent$item$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                return invoke(((Number) obj3).intValue());
            }

            public final Object invoke(int i3) {
                return obj;
            }
        } : null, new Function1<Integer, Object>() { // from class: androidx.compose.foundation.lazy.LazyListIntervalContent$item$2
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
        }, ComposableLambdaKt.c(-1010194746, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListIntervalContent$item$3
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4, Object obj5, Object obj6) {
                invoke((LazyItemScope) obj3, ((Number) obj4).intValue(), (Composer) obj5, ((Number) obj6).intValue());
                return Unit.f139807a;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i3, Composer composer, int i4) {
                if ((i4 & 6) == 0) {
                    i4 |= composer.Z(lazyItemScope) ? 4 : 2;
                }
                if (!composer.r((i4 & 131) != 130, i4 & 1)) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(-1010194746, i4, -1, "androidx.compose.foundation.lazy.LazyListIntervalContent.item.<anonymous> (LazyListIntervalContent.kt:59)");
                }
                function3.invoke(lazyItemScope, composer, Integer.valueOf(i4 & 14));
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        })));
    }

    @Override // androidx.compose.foundation.lazy.LazyListScope
    public void h(int i3, Function1 function1, Function1 function12, Function4 function4) {
        j().b(i3, new LazyListInterval(function1, function12, function4));
    }

    public final IntList m() {
        MutableIntList mutableIntList = this.f7435b;
        return mutableIntList != null ? mutableIntList : IntListKt.a();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public MutableIntervalList j() {
        return this.f7434a;
    }
}
