package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import java.util.List;
import kotlin.Metadata;
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
final class PointerInputChangeEventProducer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LongSparseArray f26873a = new LongSparseArray(0, 1, null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class PointerInputData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f26874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f26875b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f26876c;

        public /* synthetic */ PointerInputData(long j3, long j4, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
            this(j3, j4, z2);
        }

        public final boolean a() {
            return this.f26876c;
        }

        public final long b() {
            return this.f26875b;
        }

        public final long c() {
            return this.f26874a;
        }

        private PointerInputData(long j3, long j4, boolean z2) {
            this.f26874a = j3;
            this.f26875b = j4;
            this.f26876c = z2;
        }
    }

    public final void a() {
        this.f26873a.b();
    }

    public final InternalPointerEvent b(PointerInputEvent pointerInputEvent, PositionCalculator positionCalculator) {
        long jC;
        boolean zA;
        long jX;
        LongSparseArray longSparseArray = new LongSparseArray(pointerInputEvent.b().size());
        List listB = pointerInputEvent.b();
        int size = listB.size();
        for (int i3 = 0; i3 < size; i3++) {
            PointerInputEventData pointerInputEventData = (PointerInputEventData) listB.get(i3);
            PointerInputData pointerInputData = (PointerInputData) this.f26873a.g(pointerInputEventData.d());
            if (pointerInputData == null) {
                zA = false;
                jC = pointerInputEventData.k();
                jX = pointerInputEventData.f();
            } else {
                jC = pointerInputData.c();
                zA = pointerInputData.a();
                jX = positionCalculator.x(pointerInputData.b());
            }
            longSparseArray.m(pointerInputEventData.d(), new PointerInputChange(pointerInputEventData.d(), pointerInputEventData.k(), pointerInputEventData.f(), pointerInputEventData.b(), pointerInputEventData.h(), jC, jX, zA, false, pointerInputEventData.j(), pointerInputEventData.c(), pointerInputEventData.i(), pointerInputEventData.e(), null));
            if (pointerInputEventData.b()) {
                this.f26873a.m(pointerInputEventData.d(), new PointerInputData(pointerInputEventData.k(), pointerInputEventData.g(), pointerInputEventData.b(), null));
            } else {
                this.f26873a.p(pointerInputEventData.d());
            }
        }
        return new InternalPointerEvent(longSparseArray, pointerInputEvent);
    }
}
