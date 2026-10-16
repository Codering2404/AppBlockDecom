package androidx.compose.ui.input.pointer;

import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInteropFilter;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

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
public final class PointerInteropFilter$pointerInputFilter$1 extends PointerInputFilter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PointerInteropFilter.DispatchToViewState f26906b = PointerInteropFilter.DispatchToViewState.f26901a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PointerInteropFilter f26907c;

    PointerInteropFilter$pointerInputFilter$1(PointerInteropFilter pointerInteropFilter) {
        this.f26907c = pointerInteropFilter;
    }

    private final void h(PointerEvent pointerEvent) {
        List listC = pointerEvent.c();
        List list = listC;
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((PointerInputChange) listC.get(i3)).p()) {
                if (this.f26906b == PointerInteropFilter.DispatchToViewState.f26902b) {
                    LayoutCoordinates layoutCoordinatesB = b();
                    if (layoutCoordinatesB == null) {
                        throw new IllegalStateException("layoutCoordinates not set");
                    }
                    long jX0 = layoutCoordinatesB.x0(Offset.f25596b.c());
                    final PointerInteropFilter pointerInteropFilter = this.f26907c;
                    PointerInteropUtils_androidKt.b(pointerEvent, jX0, new Function1<MotionEvent, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$dispatchToView$2
                        {
                            super(1);
                        }

                        public final void c(MotionEvent motionEvent) {
                            pointerInteropFilter.b().invoke(motionEvent);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            c((MotionEvent) obj);
                            return Unit.f139807a;
                        }
                    });
                }
                this.f26906b = PointerInteropFilter.DispatchToViewState.f26903c;
                return;
            }
        }
        LayoutCoordinates layoutCoordinatesB2 = b();
        if (layoutCoordinatesB2 == null) {
            throw new IllegalStateException("layoutCoordinates not set");
        }
        long jX02 = layoutCoordinatesB2.x0(Offset.f25596b.c());
        final PointerInteropFilter pointerInteropFilter2 = this.f26907c;
        PointerInteropUtils_androidKt.c(pointerEvent, jX02, new Function1<MotionEvent, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$dispatchToView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() != 0) {
                    pointerInteropFilter2.b().invoke(motionEvent);
                } else {
                    this.f26909a.f26906b = ((Boolean) pointerInteropFilter2.b().invoke(motionEvent)).booleanValue() ? PointerInteropFilter.DispatchToViewState.f26902b : PointerInteropFilter.DispatchToViewState.f26903c;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((MotionEvent) obj);
                return Unit.f139807a;
            }
        });
        if (this.f26906b == PointerInteropFilter.DispatchToViewState.f26902b) {
            int size2 = list.size();
            for (int i4 = 0; i4 < size2; i4++) {
                ((PointerInputChange) listC.get(i4)).a();
            }
            InternalPointerEvent internalPointerEventE = pointerEvent.e();
            if (internalPointerEventE == null) {
                return;
            }
            internalPointerEventE.e(!this.f26907c.a());
        }
    }

    private final void i() {
        this.f26906b = PointerInteropFilter.DispatchToViewState.f26901a;
        this.f26907c.c(false);
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputFilter
    public boolean c() {
        return true;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputFilter
    public void d() {
        if (this.f26906b == PointerInteropFilter.DispatchToViewState.f26902b) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            final PointerInteropFilter pointerInteropFilter = this.f26907c;
            PointerInteropUtils_androidKt.a(jUptimeMillis, new Function1<MotionEvent, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$onCancel$1
                {
                    super(1);
                }

                public final void c(MotionEvent motionEvent) {
                    pointerInteropFilter.b().invoke(motionEvent);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c((MotionEvent) obj);
                    return Unit.f139807a;
                }
            });
            i();
        }
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputFilter
    public void e(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j3) {
        boolean z2;
        List listC = pointerEvent.c();
        if (this.f26907c.a()) {
            z2 = true;
            break;
        }
        int size = listC.size();
        for (int i3 = 0; i3 < size; i3++) {
            PointerInputChange pointerInputChange = (PointerInputChange) listC.get(i3);
            if (PointerEventKt.b(pointerInputChange) || PointerEventKt.d(pointerInputChange)) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        if (this.f26906b != PointerInteropFilter.DispatchToViewState.f26903c) {
            if (pointerEventPass == PointerEventPass.f26830a && z2) {
                h(pointerEvent);
            }
            if (pointerEventPass == PointerEventPass.f26832c && !z2) {
                h(pointerEvent);
            }
        }
        if (pointerEventPass == PointerEventPass.f26832c) {
            int size2 = listC.size();
            for (int i4 = 0; i4 < size2; i4++) {
                if (!PointerEventKt.d((PointerInputChange) listC.get(i4))) {
                    return;
                }
            }
            i();
        }
    }
}
