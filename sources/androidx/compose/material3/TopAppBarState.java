package androidx.compose.material3;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class TopAppBarState {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f21553d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Saver f21554e = ListSaverKt.a(new Function2<SaverScope, TopAppBarState, List<? extends Float>>() { // from class: androidx.compose.material3.TopAppBarState$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final List invoke(SaverScope saverScope, TopAppBarState topAppBarState) {
            return CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(topAppBarState.e()), Float.valueOf(topAppBarState.d()), Float.valueOf(topAppBarState.c())});
        }
    }, new Function1<List<? extends Float>, TopAppBarState>() { // from class: androidx.compose.material3.TopAppBarState$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final TopAppBarState invoke(List list) {
            return new TopAppBarState(((Number) list.get(0)).floatValue(), ((Number) list.get(1)).floatValue(), ((Number) list.get(2)).floatValue());
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableFloatState f21555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableFloatState f21556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MutableFloatState f21557c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver a() {
            return TopAppBarState.f21554e;
        }

        private Companion() {
        }
    }

    public TopAppBarState(float f3, float f4, float f5) {
        this.f21555a = PrimitiveSnapshotStateKt.a(f3);
        this.f21556b = PrimitiveSnapshotStateKt.a(f5);
        this.f21557c = PrimitiveSnapshotStateKt.a(f4);
    }

    public final float b() {
        if (e() == 0.0f) {
            return 0.0f;
        }
        return d() / e();
    }

    public final float c() {
        return this.f21556b.c();
    }

    public final float d() {
        return this.f21557c.c();
    }

    public final float e() {
        return this.f21555a.c();
    }

    public final float f() {
        if (e() == 0.0f) {
            return 0.0f;
        }
        return 1 - (RangesKt.o(e() - c(), e(), 0.0f) / e());
    }

    public final void g(float f3) {
        this.f21556b.s(f3);
    }

    public final void h(float f3) {
        this.f21557c.s(RangesKt.o(f3, e(), 0.0f));
    }

    public final void i(float f3) {
        this.f21555a.s(f3);
    }
}
