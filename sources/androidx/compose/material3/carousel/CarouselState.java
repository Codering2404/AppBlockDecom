package androidx.compose.material3.carousel;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class CarouselState implements ScrollableState {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f21701c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f21702d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Saver f21703e = ListSaverKt.a(new Function2<SaverScope, CarouselState, List<? extends Object>>() { // from class: androidx.compose.material3.carousel.CarouselState$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final List invoke(SaverScope saverScope, CarouselState carouselState) {
            return CollectionsKt.listOf(Integer.valueOf(carouselState.h().v()), Float.valueOf(carouselState.h().w()), Integer.valueOf(carouselState.h().H()));
        }
    }, new Function1<List, CarouselState>() { // from class: androidx.compose.material3.carousel.CarouselState$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final CarouselState invoke(final List list) {
            Object obj = list.get(0);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) obj).intValue();
            Object obj2 = list.get(1);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
            return new CarouselState(iIntValue, ((Float) obj2).floatValue(), new Function0<Integer>() { // from class: androidx.compose.material3.carousel.CarouselState$Companion$Saver$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Integer invoke() {
                    Object obj3 = list.get(2);
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
                    return (Integer) obj3;
                }
            });
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MutableState f21704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PagerState f21705b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public CarouselState(int i3, float f3, Function0 function0) {
        MutableState mutableStateE = SnapshotStateKt__SnapshotStateKt.e(function0, null, 2, null);
        this.f21704a = mutableStateE;
        this.f21705b = PagerStateKt.a(i3, f3, (Function0) mutableStateE.getValue());
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float b(float f3) {
        return this.f21705b.b(f3);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean c() {
        return this.f21705b.c();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public Object e(MutatePriority mutatePriority, Function2 function2, Continuation continuation) {
        Object objE = this.f21705b.e(mutatePriority, function2, continuation);
        return objE == IntrinsicsKt.f() ? objE : Unit.f139807a;
    }

    public final MutableState g() {
        return this.f21704a;
    }

    public final PagerState h() {
        return this.f21705b;
    }
}
